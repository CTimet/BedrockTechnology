package io.github.ctimet.bedrocktechnology.core.listener;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ListenerRegister {
    public static void registerEvent() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new MachineProtectListener(), BektMain.getInstance());
        manager.registerEvents(new CallBackListener(), BektMain.getInstance());


        if (BektMain.getCfg().getBoolean("options.auto-register")) {
            manager.registerEvents(new AutoRegisterListener(), BektMain.getInstance());
        }
    }
}
