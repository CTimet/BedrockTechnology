package io.github.ctimet.bedrocktechnology.util;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private final File file = new File(BektMain.getInstance().getDataFolder(), "config.yml");
    private final FileConfiguration cfg;

    public Config() {
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public String getString(String path) {
        return cfg.getString(path);
    }

    public int getInt(String path) {
        return cfg.getInt(path);
    }

    public boolean getBoolean(String path) {
        return cfg.getBoolean(path);
    }

    public void setValue(String path, Object value) {
        cfg.set(path, value);
    }

    public boolean contains(String path) {
        return cfg.contains(path);
    }

    public void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
