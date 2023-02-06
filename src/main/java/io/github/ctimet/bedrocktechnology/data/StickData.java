package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class StickData {
    private static Data storage;
    private static String message = "数据未读取完成，请稍作等待";
    private static boolean readFinish = false;
    private static final HashSet<String> refusedBlockID = new HashSet<>();

    public static void init() {
        Config cfg = BektMain.getCfg();
        if (cfg.getBoolean("mysql.enabled")) {
            storage = new SqlStorage();
        } else {
            storage = new FileStorage();
        }
        storage.readData();
        FileStorage.readRefuseBlockID(refusedBlockID);
    }

    public static void stop() {
        storage.stop();
    }

    public static boolean isNotReadFinish() {
        return !readFinish;
    }

    public static synchronized boolean containsRefuseID(String id) {
        return refusedBlockID.contains(id);
    }

    public static void setMessage(String m) {
        message = m;
    }

    public static String getMessage() {
        return message;
    }

    public static void finishRead() {
        readFinish = true;
    }

    public static void startDataCorrect() throws SQLException {
        //此方法需要异步调用
        HashMap<String, String> map = new HashMap<>();
        try (Connection conn = MysqlHandler.getCorrectConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT (location, data) FROM bekt_new_player_data;");
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                map.put(set.getString("location"), set.getString("data"));
            }
            storage.getHashMap().forEach((k, v) -> map.remove(k));
            map.forEach((k, v) -> MysqlHandler.remove(k));
        }
    }

    public static synchronized void setReadFinish(boolean f) {
        readFinish = f;
    }

    public static synchronized void putData(UUID uuid, Location location) {
        storage.put(uuid, location, BlockStorage.getBlockInfoAsJson(location));
    }
    
    public static synchronized void removeData(Location location) {
        storage.remove(location);
    }

    public static synchronized String getData(Location location) {
        return storage.get(location);
    }
    
    public static synchronized boolean containsData(Location location) {
        return storage.getHashMap().containsKey(location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + (location.getWorld() == null ? "null" : location.getWorld().getName()));
    }
}
