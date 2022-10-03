package io.github.ctimet.bedrocktechnology;

import io.github.ctimet.bedrocktechnology.core.chat.Color;
import io.github.ctimet.bedrocktechnology.core.cmd.BCommand;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.listener.ListenerRegister;
import io.github.ctimet.bedrocktechnology.data.stickdata.StickData;
import io.github.ctimet.bedrocktechnology.log.Log;
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
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        cfg = new Config(this);

        Log.info(Color.LIGHT_BLUE + "BedrockTechnology_Wiki地址：https://www.yuque.com/ctimet/bedrocktechnologywiki");
        Log.info(Color.LIGHT_BLUE + "BedrockTechnology_Github库地址：https://github.com/CTimet/BedrockTechnology");
        Log.info(Color.PINK + "当前使用的版本：" + BektMain.getInstance().getPluginVersion());

        BItemGroup.registerGroup();
        BektMain.getInstance().saveDefaultConfig();
        BItems.registerItems();
        BCommand.registerCommand();
        StickData.init();
        ListenerRegister.registerEvent();

        if (cfg.getBoolean("options.check-update"))
            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "BedrockTechnology", "master", false).start();
    }

    @Override
    public void onDisable() {
        StickData.stop();
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
}
