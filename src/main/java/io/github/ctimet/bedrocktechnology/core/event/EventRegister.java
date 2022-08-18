package io.github.ctimet.bedrocktechnology.core.event;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.Bukkit;

public class EventRegister {
    public static void registerEvent() {
        Bukkit.getPluginManager().registerEvents(new MachineProtectEvent(), BektMain.getInstance());
        Bukkit.getPluginManager().registerEvents(new CheckBanItemEvent(), BektMain.getInstance());
        Bukkit.getPluginManager().registerEvents(new InventoryProtectEvent(), BektMain.getInstance());
    }
}
