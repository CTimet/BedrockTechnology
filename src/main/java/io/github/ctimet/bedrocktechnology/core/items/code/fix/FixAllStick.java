package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.chat.PlayerChat;
import io.github.ctimet.bedrocktechnology.data.stickdata.StickData;
import io.github.ctimet.bedrocktechnology.data.stickdata.MySQLHandler;
import io.github.ctimet.bedrocktechnology.log.Log;
import io.github.ctimet.bedrocktechnology.plugin.task.PluginTask;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class FixAllStick extends SlimefunItem {
    private static final HashMap<UUID, Long> LAST_USE = new HashMap<>();

    public FixAllStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) FixAllStick::onClick);
    }

    private static void onClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        PlayerChat chat = new PlayerChat(player, false);

        if (LAST_USE.containsKey(player.getUniqueId())) {
            long interval = System.currentTimeMillis() - LAST_USE.get(player.getUniqueId());
            if (interval < 60 * 60 * 1000) {
                if (interval > 59 * 60 * 1000)
                    chat.sendWarn("使用太频繁了，请 " + new SimpleDateFormat("s秒").format((60*60*1000 - interval)) + " 后再来使用吧qwq.");
                else
                    chat.sendWarn("使用太频繁了，请 " + new SimpleDateFormat("m分s秒").format((60*60*1000 - interval)) + " 后再来使用吧qwq.");
                return;
            }
        }

        chat.sendInfo("开始查找玩家 " + ChatColor.AQUA + player.getName() + ChatColor.GREEN + " 注册过的所有机器并予以修复...");
        if (PluginTask.getThreadPoolQueueSize() != 0) {
            chat.sendInfo("线程池正忙。当前有" + PluginTask.getThreadPoolQueueSize() + "个任务等待处理。您可以先去处理别的事情");
        }

        LAST_USE.put(player.getUniqueId(), System.currentTimeMillis());
        PluginTask.runTaskInFixedThreadPool(() -> {
            try {
                Connection conn = MySQLHandler.getConnection();
                PreparedStatement statement = conn.prepareStatement("SELECT location FROM player_data WHERE uuid = ?;");
                statement.setString(1, player.getUniqueId().toString());
                ResultSet set = statement.executeQuery();

                final LinkedList<String> locs = new LinkedList<>();
                while (set.next()) {
                    locs.add(set.getString("location"));
                }

                set.close();
                statement.close();
                conn.close();

                PluginTask.runTaskInFixedThreadPool(() -> {
                    int RegisterBlockSize = locs.size();
                    int FixedBlockSize = 0;
                    String xyz;
                    String json;
                    String[] loc;
                    Location location;
                    while (!locs.isEmpty()) {
                        xyz = locs.removeFirst();
                        json = StickData.getData(xyz);
                        //有可能对应删除坐标的sql未执行。所以此处要进行判空操作
                        if (json != null) {
                            loc = xyz.split("&");
                            location = new Location(Bukkit.getWorld(loc[3]),Double.parseDouble(loc[0]),Double.parseDouble(loc[1]),Double.parseDouble(loc[2]));
                            if (BlockStorage.check(location) == null) {
                                BlockStorage.setBlockInfo(location, json, true);
                                chat.sendInfo("修复机器 x=" + location.getX() + "; y=" + location.getY() + "; z=" + location.getZ());
                                StickData.removeData(xyz);
                                FixedBlockSize ++;
                            }
                        } else {
                            RegisterBlockSize --;
                        }
                    }
                    chat.sendInfo("修复完成。以下为修复报告: ");
                    chat.sendInfo("------------------------------");
                    chat.sendInfo("搜索到注册方块数：§b" + RegisterBlockSize);
                    chat.sendInfo("已被修复的方块数：§4" + FixedBlockSize);
                    chat.sendInfo("剩余的注册方块数：§e" + (RegisterBlockSize - FixedBlockSize));
                    chat.sendInfo("------------------------------");
                    chat.sendWarn("注：修复后方块注册数据将被删除。请自行注册。");
                });
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void register(@NotNull SlimefunAddon addon) {
        //使用该物品需要连接数据库从而查询所有方块数据。未启用数据库将不会注册该物品
        if (BektMain.getCfg().getBoolean("mysql.enabled"))
            super.register(addon);
        else
            Log.warn("检测到未启用数据库保存，物品\"超级修复-修复全部\"将不会被注册");
    }
}
