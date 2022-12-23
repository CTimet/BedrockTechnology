package io.github.ctimet.bedrocktechnology;

import io.github.ctimet.bedrocktechnology.core.cmd.CommandHandler;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import io.github.ctimet.bedrocktechnology.core.items.group.BItemGroup;
import io.github.ctimet.bedrocktechnology.core.listener.ListenerRegister;
import io.github.ctimet.bedrocktechnology.data.OldDataSupport;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.util.Config;
import io.github.ctimet.bedrocktechnology.util.Log;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;

public class BektMain extends JavaPlugin implements SlimefunAddon {
    private static BektMain instance;
    private static Config cfg;

    @Override
    public void onEnable() {
        instance = this;

        //需要先 create config.yml,再new Config
        createFile("config.yml");
        createFile("block.dat");
        createFile("refuse.txt");
        //这里要先new Config，再checkYaml，因为如果先checkYaml，那么在getCfg时就会炸空指针
        cfg = new Config();
        OldDataSupport.checkYaml();

        Log.info(ChatColor.AQUA + "BedrockTechnology_Wiki地址：https://www.yuque.com/ctimet/bedrocktechnologywiki");
        Log.info(ChatColor.AQUA + "BedrockTechnology_Github库地址：https://github.com/CTimet/BedrockTechnology");
        Log.info(ChatColor.AQUA + "当前使用的版本：" + BektMain.getInstance().getPluginVersion());

        CommandHandler.init();
        BItemGroup.init();
        BItems.init();
        StickData.init();
        ListenerRegister.init();
        if (getCfg().getBoolean("options.check-update"))
            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "BedrockTechnology", "master", false).start();
    }

    @Override
    public void onDisable() {
        StickData.stop();
    }

    public void createFile(@Nonnull String resourcePath) {
        File outFile = new File(this.getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(this.getDataFolder(), resourcePath.substring(0, Math.max(lastIndex, 0)));

        if (!outDir.exists()) {
            Log.info("mkdir " + outDir.mkdirs());
        }

        try {
            if (!outFile.exists()) {
                Log.info("create new file  " + outFile.createNewFile());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Nonnull
    public static BektMain getInstance() {
        return instance;
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return instance;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/CTimet/BedrockTechnology/issues";
    }

    public static Config getCfg() {
        return cfg;
    }
}
