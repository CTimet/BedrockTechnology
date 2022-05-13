package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.BektItems.BektItemGroup;
import io.github.ctimet.bedrocktechnology.core.Command.BektCommand;
import io.github.ctimet.bedrocktechnology.event.Event;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static io.github.ctimet.bedrocktechnology.event.Event.readData;
import static io.github.ctimet.bedrocktechnology.event.Event.saveData;

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

    Runnable read = () -> {
        readData();
        isReadFinish = true;
    };

    @Override
    public void onEnable(){
        main = this;
        saveDefaultConfig();
        saveResource("block.dat",false);
        saveResource("save.yml",false);
        BektItemGroup.registerSubCate();
        Thread thread = new Thread(read);
        thread.start();

        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }
        Bukkit.getPluginManager().registerEvents(new Event(),this);
    }

    @Override
    public void onDisable(){
        saveData();
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
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
