package io.github.ctimet.bedrocktechnology.data.util;

import java.io.Serializable;
import java.util.HashMap;

public interface Data extends Serializable {
    void put(String uuid, String location, String json);
    String get(String location);
    void remove(String location);
    HashMap<String, String> getHashMap();
    void setHashMap(HashMap<String, String> data);
}
