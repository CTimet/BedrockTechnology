package io.github.ctimet.bedrocktechnology.event;

import io.github.ctimet.bedrocktechnology.initial.BektMain;
import org.bukkit.Bukkit;

public class BektEvent {
    public static void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new FixEvent(), BektMain.main);
    }
}
