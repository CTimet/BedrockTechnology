package io.github.ctimet.bedrocktechnology;

import io.github.ctimet.bedrocktechnology.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.BektItems.Command.BektCommand;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class
 * @author CTimet
 * @author CLIEDS
 * @version beta1.0.0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;

    @Override
    public void onEnable(){
        main = this;
        saveDefaultConfig();
        BektItemGroup.registerSubCate();

        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }

        getLogger().info("物品与命令注册完成！一切正常！");
    }

    @Override
    public void onDisable(){

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
        if (main.getConfig().getBoolean("info-print"))
            main.getLogger().info(information);
    }

    public static void sayWarning(String warning){
        if (main.getConfig().getBoolean("warning-print"))
            main.getLogger().warning(warning);
    }
}
