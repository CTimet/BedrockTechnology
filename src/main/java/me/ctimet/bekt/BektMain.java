package me.ctimet.bekt;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.ctimet.bekt.BektItems.BektItemGroup;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    public final NamespacedKey keyId = new NamespacedKey(this,"BEKT");

    @Override
    public void onEnable(){
        main = this;
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
}
