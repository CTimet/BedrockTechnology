package io.github.ctimet.bekt;

import io.github.ctimet.bekt.BektItems.BektItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    public static File file;

    @Override
    public void onEnable(){
        main = this;
        saveDefaultConfig();
        BektItemGroup.registerSubCate();
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
}
