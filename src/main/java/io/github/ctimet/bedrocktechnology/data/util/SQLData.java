package io.github.ctimet.bedrocktechnology.data.util;

import io.github.ctimet.bedrocktechnology.data.stickdata.MySQLHandler;

import java.util.HashMap;

public class SQLData implements Data{
    private HashMap<String, String> data;
    @Override
    public void put(String uuid, String location, String json) {
        data.put(location, json);
        MySQLHandler.addPutDataSql(uuid, location, json);
    }

    @Override
    public String get(String location) {
        return data.get(location);
    }

    @Override
    public void remove(String location) {
        data.remove(location);
        MySQLHandler.addRemoveDataSql(location);
    }

    @Override
    public HashMap<String, String> getHashMap() {
        return data;
    }

    @Override
    public void setHashMap(HashMap<String, String> data) {
        this.data = data;
    }
}
