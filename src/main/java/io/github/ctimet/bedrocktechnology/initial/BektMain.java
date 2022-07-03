package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.command.BektCommand;
import io.github.ctimet.bedrocktechnology.core.items.BektItemGroup;
import io.github.ctimet.bedrocktechnology.event.FixEvent;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

import static io.github.ctimet.bedrocktechnology.event.FixEvent.readData;
import static io.github.ctimet.bedrocktechnology.event.FixEvent.saveData;

/**
 * Main Class
 * 这里是BedrockTechnology的主类，同时存放了许多插件需要用到的方法
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    public static boolean isReadFinish = false;
    public static long prevSave = 0L;
    public static final Timer TIMER = new Timer();

    @Override
    public void onEnable(){
        main = this;
        //test
        saveDefaultConfig();
        saveResource("block.dat",false);
        BektItemGroup.registerSubCate();

        int time = new Config(main).getInt("save.time");
        new BukkitRunnable() {
            @Override
            public void run() {
                readData();
                main.getLogger().info("机器保护 >> 数据读取完成！可以使用修复注册棒了！");
                isReadFinish = true;
            }
        }.runTaskAsynchronously(this);
        TIMER.schedule(new TimerTask() {
            @Override
            public void run() {
                saveData();
                main.getLogger().info("机器保护 >> 已保存玩家数据，下一次保存在" + time + "分钟之后.");
                prevSave = System.currentTimeMillis();
            }
        }, (10 * 60 * 1000), ((long) time * 60 * 1000));

        Bukkit.getPluginManager().registerEvents(new FixEvent(),this);

        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }
    }

    @Override
    public void onDisable(){
        TIMER.cancel();
        saveData();
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static NamespacedKey createKey(String key){
        return new NamespacedKey(main,key);
    }

    public static void sayInfo(String information){
        if (main.getConfig().getBoolean("options.info-print"))
            main.getLogger().info(information);
    }

    public static void sayWarning(String warning){
        if (main.getConfig().getBoolean("options.warning-print"))
            main.getLogger().warning(warning);
    }
}
