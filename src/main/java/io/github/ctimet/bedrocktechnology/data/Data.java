package io.github.ctimet.bedrocktechnology.data;

import org.bukkit.Location;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public interface Data extends Serializable {
    void put(UUID uuid, Location location, String data);
    String get(Location location);
    void remove(Location location);
    HashMap<String, String> getHashMap();
    void setHashMap(HashMap<String, String> map);
    void readData();
    void stop();

    default String getStringLocation(@Nonnull Location loc) {
        return loc.getX() + "&" + loc.getY() + "&" + loc.getZ() + (loc.getWorld() == null ? "null" : loc.getWorld().getName());
    }
}
