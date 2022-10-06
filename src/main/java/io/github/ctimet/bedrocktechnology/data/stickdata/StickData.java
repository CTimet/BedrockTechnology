package io.github.ctimet.bedrocktechnology.data.stickdata;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.data.util.Data;
import io.github.ctimet.bedrocktechnology.data.util.FileData;
import io.github.ctimet.bedrocktechnology.data.util.SQLData;
import io.github.ctimet.bedrocktechnology.log.ExceptionHandler;
import io.github.ctimet.bedrocktechnology.log.Log;
import io.github.ctimet.bedrocktechnology.plugin.task.PluginTask;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import java.io.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class StickData {
    private static boolean EnabledMySQL;

    private static Data data;

    private static boolean readFinish = false;

    public static void init() {
        EnabledMySQL = BektMain.getCfg().getBoolean("mysql.enabled");
        if (EnabledMySQL) {
            if (MySQLHandler.init()) {
                PluginTask.runTaskInFixedThreadPool(() -> {
                    data = new SQLData();
                    MySQLHandler.readData(data);
                });
            } else {
                EnabledMySQL = false;
                data = FileDataSave.readData();
            }
            return;
        }
        data = FileDataSave.readData();
        FileDataSave.startTimer();
    }

    public static void stop() {
        if (EnabledMySQL) {
            MySQLHandler.close();
        } else {
            FileDataSave.saveData(data.getHashMap());
            FileDataSave.stopTimer();
        }
    }

    public static boolean contains(String location) {
        return data.getHashMap().containsKey(location);
    }

    public static void putData(String uuid, String location, String json) {
        data.put(uuid, location, json);
    }

    public static String getData(String location) {
        return data.get(location);
    }

    public static void removeData(String location) {
        data.remove(location);
    }

    public static void setFinish(boolean f) {
        readFinish = f;
    }

    public static boolean isNotReadFinish() {
        return !readFinish;
    }

    public static class FileDataSave {
        private static final File BLOCK_DAT = new File("plugins/BedrockTechnology/block.dat");
        private static final File TEMP_DAT = new File("plugins/BedrockTechnology/temp.dat");

        public static FileData readData() {
            FileData data = new FileData();
            if (TEMP_DAT.exists()) {
                data.setHashMap(readData0(TEMP_DAT));
                if (!TEMP_DAT.delete()) {
                    Log.warn("警告：temp.dat未能正常删除，请手动删除，否则可能发生数据丢失！！！");
                }
            } else if (isBlockDatExists()) {
                data.setHashMap(readData0(BLOCK_DAT));
            } else {
                data.setHashMap(new HashMap<>());
                StickData.setFinish(true);
                try {
                    BLOCK_DAT.createNewFile();
                } catch (IOException e) {
                    ExceptionHandler.writeException(e, "readData", "在尝试创建block.dat时发生异常", FileData.class);
                }
            }
            return data;
        }

        public static boolean isBlockDatExists() {
            return BLOCK_DAT.exists();
        }

        public static void saveData(HashMap<String, String> data) {
            if (isBlockDataOccupy()) {
                saveData0(data, TEMP_DAT);
            } else {
                saveData0(data, BLOCK_DAT);
            }
        }

        private static final Timer TIMER = new Timer();
        private static int TIMER_DELAY = BektMain.getCfg().getInt("timer.delay") * 60 * 1000;
        private static int TIMER_PERIOD = BektMain.getCfg().getInt("timer.period") * 60 * 1000;

        private static int WaitList = 0;

        public static void addWait() {
            WaitList ++;
        }

        public static void startTimer() {
            Config cfg = BektMain.getCfg();
            if (TIMER_DELAY < 0) {
                Log.warn("警告：config.yml中设置的delay小于0，BedrockTechnology已自动将delay设置为初始值10");
                TIMER_DELAY = 10 * 60 * 1000;
                cfg.setValue("timer.delay",10);
                cfg.save();
            }
            if (TIMER_PERIOD <= 0) {
                Log.warn("警告：config.yml中设置的period值过小，BedrockTechnology已自动将period设置为初始值10");
                TIMER_PERIOD = 10 * 60 * 1000;
                cfg.setValue("timer.period",10);
                cfg.save();
            }

            TIMER.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (isBlockDataOccupy() || WaitList == 0) {
                        //block.dat被占用或等待集为空时不保存数据
                        return;
                    }
                    saveData0(data.getHashMap(), BLOCK_DAT);
                    WaitList = 0;
                }
            }, TIMER_DELAY, TIMER_PERIOD);
        }

        public static void stopTimer() {
            TIMER.cancel();
        }

        @SuppressWarnings("unchecked")
        private static HashMap<String, String> readData0(File file) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                StickData.setFinish(true);
                return (HashMap<String, String>) in.readObject();
            } catch (StreamCorruptedException ignored) {
                return new HashMap<>();
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.writeException(e, "readData0", "在读取注册数据时抛出异常", FileData.class);
                return new HashMap<>();
            }
        }

        private static void saveData0(HashMap<String, String> data, File file) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
                out.writeObject(data);
            } catch (IOException e) {
                ExceptionHandler.writeException(e, "saveData0", "在保存注册数据时抛出异常", FileData.class);
            }
        }

        private static boolean isBlockDataOccupy() {
            return !FileDataSave.BLOCK_DAT.renameTo(FileDataSave.BLOCK_DAT);
        }
    }
}
