package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.Command.BektCommand;
import io.github.ctimet.bedrocktechnology.event.FixAndResEvent;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Main Class
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    //插件版本号
    public static final String VERSION = "v1.0-beta-220402";

    public static int ERROR = 0;

    @Override
    public void onEnable(){
        main = this;
        Bukkit.getPluginManager().registerEvents(new FixAndResEvent(), this);
        saveDefaultConfig();
        saveResource("protected.dat",false);

        BektItemGroup.registerSubCate();

        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }

        try {
            FixAndResEvent.readTheDat();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            ERROR += 1;
        }

        if (ERROR == 0)
            getLogger().info("物品与命令注册完成！一切正常！");
        else
            getLogger().warning("发生" + ERROR + "个报错！");
    }

    @Override
    public void onDisable(){
        FixAndResEvent.writeTheDat();
        getLogger().info("成功将被保护的方块写入dat数据文件！");
    }

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
