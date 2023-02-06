package io.github.ctimet.bedrocktechnology.data;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.Config;
import io.github.ctimet.bedrocktechnology.util.Log;
import io.github.ctimet.bedrocktechnology.util.PluginTask;
import org.bukkit.Location;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class MysqlHandler {
    private static final DruidDataSource source = new DruidDataSource();

    private static final  Config cfg = BektMain.getCfg();
    private static final  String user = cfg.getString("mysql.user");
    private static final  String password = cfg.getString("mysql.password");
    private static final  String host = cfg.getString("mysql.host");
    private static final  String port = cfg.getString("mysql.port");
    private static final  String database = cfg.getString("mysql.database");
    private static final  String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    public static boolean init() {
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //在设置连接池参数前，先尝试连接Mysql，如果连不上直接抛异常、否则连接池会连续抛多次异常
            tryConnect();

            source.setUsername(user);
            source.setPassword(password);
            source.setUrl(url);
            source.setMaxActive(16);
            source.setMinIdle(3);

            prepareTable();
            return true;
        } catch (Exception e) {
            Log.warn("数据库操作发生异常");
            e.printStackTrace();
            BektMain.getCfg().setValue("mysql.enabled", false);
            return false;
        }
    }

    private static void tryConnect() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.close();
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    public static Connection getCorrectConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //该方法的调用者异步
    public static void prepareTable() {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS bekt_new_player_data (uuid INTEGER, location CHAR(255) PRIMARY KEY, world TEXT, x DOUBLE, y DOUBLE, z DOUBLE, data TEXT);")) {
            statement.execute();
            OldDataSupport.updateMysqlData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void putData(UUID uuid, Location location, String data) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("INSERT INTO bekt_new_player_data (uuid, location, world, x, y, z, data) VALUES (?, ?, ?, ?, ?, ?, ?);")) {
                statement.setInt(1, uuid.hashCode());
                statement.setString(2, location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + (location.getWorld() == null ? "null" : location.getWorld().getName()));
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
        remove(location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + (location.getWorld() == null ? "null" : location.getWorld().getName()));
    }

    public static void remove(String loc) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("DELETE FROM bekt_new_player_data WHERE location = ?;")) {
                statement.setString(1, loc);
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeData(Data data) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            if (!MysqlHandler.init()) {
                StickData.setMessage("错误：此服务器启用了数据库保存，但是插件在尝试连接数据库时发生了错误，堆栈已打印到控制台，请通知服务器管理员处理。BedrockTechnology无法处理您的方块请求。");
                return;
            }
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM bekt_new_player_data");
                 ResultSet resultSet = statement.executeQuery()) {

                HashMap<String, String> map = new HashMap<>();
                while (resultSet.next()) {
                    map.put(resultSet.getString("location"), resultSet.getString("data"));
                }

                data.setHashMap(map);

                StickData.finishRead();
            } catch (SQLException e) {
                BektMain.getCfg().setValue("mysql.enabled", false);
                StickData.setMessage("在从数据库中拷贝缓存时发生异常，请联系服务器管理员。");
                e.printStackTrace();
            }
        });
    }

    public static void stop() {
        source.close();
    }
}
