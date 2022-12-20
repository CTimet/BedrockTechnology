package io.github.ctimet.bedrocktechnology.data;

import org.bukkit.Location;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public interface Data extends Serializable {
    void put(UUID uuid, Location location, String data);
    String get(Location location);
    void remove(Location location);
    HashMap<Integer, String> getHashMap();
    void setHashMap(HashMap<Integer, String> map);
    void readData();
    void stop();
}
