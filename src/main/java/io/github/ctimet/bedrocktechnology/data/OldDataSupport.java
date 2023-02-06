package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.Config;
import io.github.ctimet.bedrocktechnology.util.Log;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

/**
 * 添加对旧数据的支持，遇到版本稍微往前一点的代码，我们直接上旧数据支持，将旧数据升级为效率更高的新数据格式
 */
public class OldDataSupport {
    public static void updateMysqlData() {
        Config cfg = BektMain.getCfg();
        if (37 > cfg.getInt("version.mysql")) {
            //当前版本号小于37
            //检查是否存在player_data表
            //该方法在prepareTable中执行，本身就是异步
            try (Connection conn = MysqlHandler.getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM information_schema.TABLES WHERE TABLE_NAME = 'player_data';");
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    //表存在，接着我们开始进行数据迁移
                    try (PreparedStatement old = conn.prepareStatement("SELECT * FROM player_data");
                         ResultSet oldData = old.executeQuery()) {
                        String[] locs;
                        double x, y, z;
                        String worldName;
                        while (oldData.next()) {
                            try (PreparedStatement newDataStatement = conn.prepareStatement("INSERT INTO bekt_player_data (uuid, location, world, x, y, z, data) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                                newDataStatement.setInt(1, UUID.fromString(oldData.getString("uuid")).hashCode());
                                locs = oldData.getString("location").split("&");
                                x = Double.parseDouble(locs[0]);
                                y = Double.parseDouble(locs[1]);
                                z = Double.parseDouble(locs[2]);
                                worldName = locs[3];
                                newDataStatement.setInt(2, new Location(Bukkit.getWorld(worldName), x, y, z).hashCode());
                                newDataStatement.setString(3, worldName);
                                newDataStatement.setDouble(4, x);
                                newDataStatement.setDouble(5, y);
                                newDataStatement.setDouble(6, z);
                                newDataStatement.setString(7, oldData.getString("json"));
                                newDataStatement.execute();
                            }
                        }
                    }
                    Log.info("Mysql数据迁移完毕！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Log.warn("由于某种不可抗力因素，Mysql数据迁移失败..");
            } finally {
                cfg.setValue("version.mysql", 37);
                cfg.save();
            }
        }

        if (20230206 > cfg.getInt("version.mysql")) {
            //当前版本号小于20230206，说明是使用的旧版本。旧版本的数据库存在问题，
            //首先读取全表
            try (Connection conn = MysqlHandler.getConnection();
                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM bekt_player_data");
                 ResultSet resultSet = statement.executeQuery()) {
                String world;
                double x, y, z;
                while (resultSet.next()) {
                    //往新表里面插入数据
                    try (PreparedStatement ps = conn.prepareStatement("INSERT INTO bekt_new_player_data (uuid, location, world, x, y, z, data) VALUES (?, ?, ?, ?, ?, ?, ?);")) {
                        ps.setInt(1, resultSet.getInt("uuid"));
                        world = resultSet.getString("world");
                        x = resultSet.getDouble("x");
                        y = resultSet.getDouble("y");
                        z = resultSet.getDouble("z");
                        ps.setString(2, x + "&" + y + "&" + z + "&" + world);
                        ps.setString(3, world);
                        ps.setDouble(4, x);
                        ps.setDouble(5, y);
                        ps.setDouble(6, z);
                        ps.setString(7, resultSet.getString("data"));
                        ps.execute();
                    }
                }
                Log.info("Mysql数据迁移完毕！");
            } catch (SQLException e) {
                e.printStackTrace();
                Log.warn("由于某种不可抗力因素，Mysql数据迁移失败..");
            } finally {
                cfg.setValue("version.mysql", 20230206);
                cfg.save();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean updateFileData(Data data) {
        Config cfg = BektMain.getCfg();
        File file = new File("plugins/BedrockTechnology/block.dat");
        if (37 > cfg.getInt("version.file")) {
            //旧版本，准备进行数据更新
            //这里的旧版本使用的拼接方式与新版一致
            HashMap<String, String> oldData = new HashMap<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                oldData = (HashMap<String, String>) in.readObject();
            } catch (EOFException e) {
                data.setHashMap(new HashMap<>());
                cfg.setValue("version.file", 37);
                cfg.save();
                return true;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                Log.warn("由于某种不可抗力因素，文件数据迁移失败..");
            }
            file.delete();
            try {
                file.createNewFile();//删除文件然后重新生成，为了清空文件内容
            } catch (IOException e) {
                e.printStackTrace();
            }
            //由于旧版本data拼接方式与新版本一致，所以我们直接写入oldData;
            data.setHashMap(oldData);
            cfg.setValue("version.file", 20230206);
            cfg.save();
            return true;
        } else if (20230206 > cfg.getInt("version.file")) {
            file.delete();
            try {
                file.createNewFile();//删除文件然后重新生成，为了清空文件内容
            } catch (IOException e) {
                e.printStackTrace();
            }
            //我们非常抱歉，但只能这样了
            data.setHashMap(new HashMap<>());
            cfg.setValue("version.file", 20230206);
            cfg.save();
            return true;
        } else return false;
    }

    public static void checkYaml() {
        Config cfg = BektMain.getCfg();
        if (38 <= cfg.getInt("version.yml")) {
            return;
        } else {
            cfg.setValue("version.yml", 38);
        }
        if (!cfg.contains("options.check-update")) {
            cfg.setValue("options.check-update", true);
        }
        if (!cfg.contains("options.auto-register")) {
            cfg.setValue("options.auto-register", false);
        }
        if (!cfg.contains("version.mysql")) {
            cfg.setValue("version.mysql", 20230206);
        }
        if (!cfg.contains("version.file")) {
            cfg.setValue("version.file", 20230206);
        }
        if (!cfg.contains("timer.delay")) {
            cfg.setValue("timer.delay", 10);
        }
        if (!cfg.contains("timer.period")) {
            cfg.setValue("timer.period", 10);
        }
        if (!cfg.contains("mysql.enabled")) {
            cfg.setValue("mysql.enabled", false);
        }
        if (!cfg.contains("mysql.host")) {
            cfg.setValue("mysql.host", "localhost");
        }
        if (!cfg.contains("mysql.port")) {
            cfg.setValue("mysql.port", 3306);
        }
        if (!cfg.contains("mysql.user")) {
            cfg.setValue("mysql.user", "root");
        }
        if (!cfg.contains("mysql.password")) {
            cfg.setValue("mysql.password", "");
        }
        if (!cfg.contains("mysql.database")) {
            cfg.setValue("mysql.database", "");
        }
        if (!cfg.contains("mysql.maxconns")) {
            cfg.setValue("mysql.maxconns", 16);
        }

        cfg.save();
    }
}
