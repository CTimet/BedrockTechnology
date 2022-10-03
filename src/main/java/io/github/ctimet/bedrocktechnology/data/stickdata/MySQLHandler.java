package io.github.ctimet.bedrocktechnology.data.stickdata;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.data.util.Data;
import io.github.ctimet.bedrocktechnology.log.ExceptionHandler;
import io.github.ctimet.bedrocktechnology.plugin.task.PluginTask;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import java.sql.*;
import java.util.HashMap;

public class MySQLHandler {
    private static final Config cfg = BektMain.getCfg();

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = cfg.getString("mysql.database");
    private static final String USER = cfg.getString("mysql.user");
    private static final String PASSWORD = cfg.getString("mysql.password");
    private static final String HOST = cfg.getString("mysql.host");
    private static final String PORT = cfg.getString("mysql.port");
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final DruidDataSource dds = new DruidDataSource();

    public static boolean init() {
        try {
            dds.setDriverClassName(JDBC_DRIVER);
            dds.setUrl(URL);
            dds.setUsername(USER);
            dds.setPassword(PASSWORD);
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void initTable() throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS player_data (uuid VARCHAR(255) NOT NULL, location VARCHAR(255) PRIMARY KEY NOT NULL, json VARCHAR(255) NOT NULL);");
        statement.execute();
        statement.close();
        connection.close();
    }

    public static void close() {
        dds.close();
    }

    public static Connection getConnection() throws SQLException {
        return dds.getConnection();
    }

    public static void readData(Data data) {
        try (Connection connection = getConnection();
             Statement stat = connection.createStatement();
             ResultSet set = stat.executeQuery("SELECT * FROM player_data")) {

            final HashMap<String, String> MAP = new HashMap<>();
            while (set.next()) {
                MAP.put(set.getString("location"), set.getString("json"));
            }

            data.setHashMap(MAP);

            StickData.setFinish(true);
        } catch (Exception throwable) {
            ExceptionHandler.writeException(throwable, "readData", "在从表中读取数据时发生异常", MySQLHandler.class);
            StickData.setFinish(false);
        }
    }

    public static void addPutDataSql(String uuid, String location, String json) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("INSERT INTO player_data (uuid, location, json) VALUES (?, ?, ?);")) {
                statement.setString(1, uuid);
                statement.setString(2, location);
                statement.setString(3, json);
                statement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void addRemoveDataSql(String location) {
        PluginTask.runTaskInCachedThreadPool(() -> {
            try (Connection conn = getConnection();
                 PreparedStatement statement = conn.prepareStatement("DELETE FROM player_data WHERE location = ?;")) {
                statement.setString(1, location);
                statement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
