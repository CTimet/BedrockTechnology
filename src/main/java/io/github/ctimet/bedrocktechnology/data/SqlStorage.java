package io.github.ctimet.bedrocktechnology.data;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.UUID;

public class SqlStorage implements Data {
    private HashMap<String, String> map;

    @Override
    public void put(UUID uuid, Location location, String data) {
        map.put(getStringLocation(location), data);

        MysqlHandler.putData(uuid, location, data);
    }

    @Override
    public String get(Location location) {
        return map.get(getStringLocation(location));
    }

    @Override
    public void remove(Location location) {
        map.remove(getStringLocation(location));

        MysqlHandler.removeData(location);
    }

    @Override
    public HashMap<String, String> getHashMap() {
        return map;
    }

    @Override
    public void setHashMap(HashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void readData() {
        StickData.setMessage("正在从数据库中拷贝数据至缓存，请稍作等待。");
        MysqlHandler.writeData(this);
    }

    @Override
    public void stop() {
        MysqlHandler.stop();
    }
}
