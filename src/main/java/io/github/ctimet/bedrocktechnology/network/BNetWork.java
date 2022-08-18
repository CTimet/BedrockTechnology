package io.github.ctimet.bedrocktechnology.network;

import org.bukkit.Location;

import java.util.HashSet;

public class BNetWork {
    private static final HashSet<BIP> NetWork = new HashSet<>();
    private static final HashSet<Location> Bridge = new HashSet<>();
    public static void connectNetWork(BIP bip) {
        NetWork.add(bip);
    }
    public static void disconnectNetWork(BIP bip) {
        NetWork.remove(bip);
    }
    public static boolean isConnect(BIP bip) {
        return NetWork.contains(bip);
    }
    public static void addBridge(Location loc) {
        Bridge.add(loc);
    }
    public static void removeBridge(Location loc) {
        Bridge.remove(loc);
    }
    public static boolean isBridge(Location loc) {
        return Bridge.contains(loc);
    }
}
