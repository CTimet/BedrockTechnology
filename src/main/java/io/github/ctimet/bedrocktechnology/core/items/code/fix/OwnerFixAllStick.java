package io.github.ctimet.bedrocktechnology.core.items.code.fix;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.data.MysqlHandler;
import io.github.ctimet.bedrocktechnology.util.Log;
import io.github.ctimet.bedrocktechnology.util.PlayerChat;
import io.github.ctimet.bedrocktechnology.util.PluginTask;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
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

public class OwnerFixAllStick extends SlimefunItem {
    private static final HashMap<String, Long> LAST_USE = new HashMap<>();

    public OwnerFixAllStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) this::onClick);
    }

    private void onClick(PlayerRightClickEvent event) {
        event.cancel();

        Player player = event.getPlayer();
        String owner = OwnerRegisterStick.checkOwner(player, event.getItem());
        PlayerChat chat = new PlayerChat(player, false);

        if (LAST_USE.containsKey(owner)) {
            long interval = System.currentTimeMillis() - LAST_USE.get(owner);
            if (interval < 60 * 60 * 1000) {
                if (interval > 59 * 60 * 1000)
                    chat.sendWarn("使用太频繁了，请 " + new SimpleDateFormat("s秒").format((60*60*1000 - interval)) + " 后再来使用吧qwq.");
                else
                    chat.sendWarn("使用太频繁了，请 " + new SimpleDateFormat("m分s秒").format((60*60*1000 - interval)) + " 后再来使用吧qwq.");
                return;
            }
        }

        chat.sendInfo("开始查找ID=" + ChatColor.AQUA + owner + ChatColor.GREEN + "注册过的所有机器并予以修复...");
        if (PluginTask.getThreadPoolQueueSize() != 0) {
            chat.sendInfo("线程池正忙。当前有" + PluginTask.getThreadPoolQueueSize() + "个任务等待处理。您的修复任务已添加至线程池队列中，正在等待处理，您可以先去做些别的事情");
        }
        LAST_USE.put(owner, System.currentTimeMillis());


        PluginTask.runTaskInCachedThreadPool(() -> {
            long startTime = System.currentTimeMillis();
            ResultSet resultSet = null;
            try (Connection conn = MysqlHandler.getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM bekt_player_data WHERE uuid = ?;")) {

                statement.setInt(1, UUID.fromString(owner).hashCode());
                resultSet = statement.executeQuery();

                final LinkedList<Location> locations = new LinkedList<>();
                while (resultSet.next()) {
                    locations.add(new Location(Bukkit.getWorld(resultSet.getString("world")), resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("z")));
                }

                FixAllStick.fixAll(locations, chat, startTime);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void register(@Nonnull SlimefunAddon addon) {
        if (BektMain.getCfg().getBoolean("mysql.enabled"))
            super.register(addon);
        else
            Log.warn("检测到未启用数据库保存，物品\"拥有者-修复全部\"将不会被注册");
    }
}
