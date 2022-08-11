package io.github.ctimet.bedrocktechnology.plugin;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.cmd.BCommand;
import io.github.ctimet.bedrocktechnology.core.event.MachineProtectEvent;
import io.github.ctimet.bedrocktechnology.data.BannedData;
import io.github.ctimet.bedrocktechnology.data.PluginData;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.log.Color;
import io.github.ctimet.bedrocktechnology.log.Log;
import org.bukkit.Bukkit;

public class PluginManager {
    public static void startBekt() {
        Log.info(Color.LIGHT_BLUE + "BedrockTechnology_Wiki地址：https://www.yuque.com/ctimet/bedrocktechnologywiki");
        Log.info(Color.LIGHT_BLUE + "BedrockTechnology_Github库地址：https://github.com/CTimet/BedrockTechnology");
        Log.info(Color.PINK + "当前使用的版本：" + BektMain.getInstance().getPluginVersion());

        PluginData.check();
        BektMain.getInstance().saveDefaultConfig();
        BannedData.readDataAndRegisterItems();
        BCommand.registerCommand();
        StickData.readData();
        StickData.startTimer();

        Bukkit.getPluginManager().registerEvents(new MachineProtectEvent(), BektMain.getInstance());
    }

    public static void stopBekt() {
        StickData.stopTimer();
        StickData.saveData();
    }
}
