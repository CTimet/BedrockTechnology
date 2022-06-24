package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.Command.BektCommand;
import io.github.ctimet.bedrocktechnology.event.FixEvent;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import static io.github.ctimet.bedrocktechnology.event.FixEvent.*;

/**
 * Main Class
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    public static boolean isReadFinish = false;
    public static boolean isStopSave = false;
    public static long prevSave = 0L;

    @Override
    public void onEnable(){
        main = this;
        //test
        saveDefaultConfig();
        saveResource("block.dat",false);
        BektItemGroup.registerSubCate();

        new BukkitRunnable() {
            @Override
            public void run() {
                readData();
                isReadFinish = true;
                int time = new Config(main).getInt("save.time");
                while (true){
                    if (isStopSave) return;
                    prevSave = System.currentTimeMillis();
                    saveData();
                    main.getLogger().info("已保存玩家数据，下一次保存在" + time + "分钟之后.");
                    try {
                        Thread.sleep((long) time * 60 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.runTaskAsynchronously(this);

        Bukkit.getPluginManager().registerEvents(new FixEvent(),this);

        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }
    }

    @Override
    public void onDisable(){
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
