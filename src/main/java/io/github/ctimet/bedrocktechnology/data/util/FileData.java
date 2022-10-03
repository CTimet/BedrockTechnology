package io.github.ctimet.bedrocktechnology.data.util;

import io.github.ctimet.bedrocktechnology.data.stickdata.StickData;

import java.util.HashMap;

public class FileData implements Data {
    @java.io.Serial
    private static final long serialVersionUID = 20221003L;

    private HashMap<String, String> data;
    @Override
    public void put(String uuid, String location, String json) {
        data.put(location, json);
        StickData.FileDataSave.addWait();
    }

    @Override
    public String get(String location) {
        return data.get(location);
    }

    @Override
    public void remove(String location) {
        data.remove(location);
        StickData.FileDataSave.addWait();
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
