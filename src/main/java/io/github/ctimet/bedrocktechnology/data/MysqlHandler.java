package io.github.ctimet.bedrocktechnology.data;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.Config;
import io.github.ctimet.bedrocktechnology.util.PluginTask;
import org.bukkit.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class MysqlHandler {
    private static final DruidDataSource source = new DruidDataSource();

    public static void init() {
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            Config cfg = BektMain.getCfg();
            String user = cfg.getString("mysql.user");
            String password = cfg.getString("mysql.password");
            String host = cfg.getString("mysql.host");
            String port = cfg.getString("mysql.port");
            String database = cfg.getString("mysql.database");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            source.setUsername(user);
            source.setPassword(password);
            source.setUrl(url);
            source.setMaxActive(16);
            source.setMinIdle(3);

            prepareTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    //该方法的调用者异步
    public static void prepareTable() {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS bekt_player_data (uuid INTEGER, location INTEGER PRIMARY KEY, world TEXT, x DOUBLE, y DOUBLE, z DOUBLE, data TEXT);")) {
            statement.execute();
            OldDataSupport.updateMysqlData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putData(UUID uuid, Location location, String data) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("INSERT INTO bekt_player_data (uuid, location, world, x, y, z, data) VALUES (?, ?, ?, ?, ?, ?, ?);")) {
                statement.setInt(1, uuid.hashCode());
                statement.setInt(2, location.hashCode());
                statement.setString(3, location.getWorld() == null ? "null" : location.getWorld().getName());
                statement.setDouble(4, location.getX());
                statement.setDouble(5, location.getY());
                statement.setDouble(6, location.getZ());
                statement.setString(7, data);
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void removeData(Location location) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("DELETE FROM bekt_player_data WHERE location = ?;")) {
                statement.setInt(1, location.hashCode());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeData(Data data) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            MysqlHandler.init();
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM bekt_player_data");
                 ResultSet resultSet = statement.executeQuery()) {

                HashMap<Integer, String> map = new HashMap<>();
                while (resultSet.next()) {
                    map.put(resultSet.getInt("location"), resultSet.getString("data"));
                }

                data.setHashMap(map);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void stop() {
        source.close();
    }
}
