package io.github.ctimet.bedrocktechnology;

import io.github.ctimet.bedrocktechnology.plugin.PluginManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BektMain extends JavaPlugin implements SlimefunAddon {
    private static BektMain instance;
    private static Config cfg;
    private static boolean autoRegister;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        cfg = new Config(this);
        autoRegister = cfg.getBoolean("auto-register");
        PluginManager.startBekt();
        if (cfg.getBoolean("check-update"))
            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "BedrockTechnology", "master", false).start();
    }

    @Override
    public void onDisable() {
        PluginManager.stopBekt();
    }

    @NotNull
    public static BektMain getInstance() {
        return instance;
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return instance;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/CTimet/BedrockTechnology/issues";
    }

    public static NamespacedKey createNamespacedKey(@NotNull String key) {
        return new NamespacedKey(instance, key);
    }

    public static Config getCfg() {
        return cfg;
    }

    public static boolean autoRegister() {
        return autoRegister;
    }
}
