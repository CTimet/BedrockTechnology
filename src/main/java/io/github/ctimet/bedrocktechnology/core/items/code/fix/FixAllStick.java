package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.data.MysqlHandler;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.util.Log;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.PlayerChat;
import io.github.ctimet.bedrocktechnology.util.PluginTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
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
        this.addItemHandler((ItemUseHandler) e -> {
            try {
                onClick(e);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void onClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        PlayerChat chat = new PlayerChat(player, false);

        if (StickData.isNotReadFinish()) {
            chat.sendWarn(StickData.getMessage());
            return;
        }

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
            chat.sendInfo("线程池正忙。当前有" + PluginTask.getThreadPoolQueueSize() + "个任务等待处理。您的修复任务已添加至线程池队列中，正在等待处理，您可以先去做些别的事情");
        }

        LAST_USE.put(player.getUniqueId(), System.currentTimeMillis());
        PluginTask.runTaskInFixedThreadPool(() -> {
            long startTime = System.currentTimeMillis();
            try (Connection conn = MysqlHandler.getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT world, x, y, z FROM bekt_player_data WHERE uuid = ?;")) {

                statement.setInt(1, player.getUniqueId().hashCode());

                try (ResultSet resultSet = statement.executeQuery()) {
                    final LinkedList<Location> locations = new LinkedList<>();
                    while (resultSet.next()) {
                        locations.add(new Location(Bukkit.getWorld(resultSet.getString("world")), resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("z")));
                    }

                    fixAll(locations, chat, startTime);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void fixAll(LinkedList<Location> locations, PlayerChat chat, long startTime) {
        PluginTask.runTaskInFixedThreadPool(() -> {
            //再推一个任务进池子，将Connection，Statement这些释放出来
            int fixedBlockSize = 0;

            for (Location location : locations) {
                if (FixStick.fixBlock(location)) {
                    fixedBlockSize ++;
                }
            }

            chat.sendInfo("修复完成。以下为修复报告: ");
            chat.sendInfo("------------------------------");
            chat.sendInfo("搜索到注册方块数：§b" + locations.size());
            chat.sendInfo("已被修复的方块数：§4" + fixedBlockSize);
            chat.sendInfo("本次修复耗时：§d" + (System.currentTimeMillis() - startTime) + " ms");
            chat.sendInfo("------------------------------");
        });
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        //使用该物品需要连接数据库从而查询所有方块数据。未启用数据库将不会注册该物品
        if (BektMain.getCfg().getBoolean("mysql.enabled"))
            super.register(addon);
        else
            Log.warn("检测到未启用数据库保存，物品\"修复全部棒\"将不会被注册");
    }
}
