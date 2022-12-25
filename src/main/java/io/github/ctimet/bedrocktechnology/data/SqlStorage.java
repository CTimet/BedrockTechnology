package io.github.ctimet.bedrocktechnology.data;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.UUID;

public class SqlStorage implements Data {
    private HashMap<Integer, String> map;

    @Override
    public void put(UUID uuid, Location location, String data) {
        map.put(location.hashCode(), data);

        MysqlHandler.putData(uuid, location, data);
    }

    @Override
    public String get(Location location) {
        return map.get(location.hashCode());
    }

    @Override
    public void remove(Location location) {
        map.remove(location.hashCode());

        MysqlHandler.removeData(location);
    }

    @Override
    public HashMap<Integer, String> getHashMap() {
        return map;
    }

    @Override
    public void setHashMap(HashMap<Integer, String> map) {
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
