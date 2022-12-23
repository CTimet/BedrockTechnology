package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.util.Config;
import io.github.ctimet.bedrocktechnology.util.Log;
import org.bukkit.Location;

import java.io.*;
import java.util.*;

public class FileStorage implements Data{
    private HashMap<Integer, String> map;

    private int waitList = 0;

    @Override
    public void put(UUID uuid, Location location, String data) {
        map.put(location.hashCode(), data);
        waitList ++;
    }

    @Override
    public String get(Location location) {
        return map.get(location.hashCode());
    }

    @Override
    public void remove(Location location) {
        map.remove(location.hashCode());
        waitList ++;
    }

    @Override
    public HashMap<Integer, String> getHashMap() {
        return map;
    }

    @Override
    public void setHashMap(HashMap<Integer, String> map) {
        this.map = map;
    }


    private final Timer autoSave = new Timer();

    @Override
    @SuppressWarnings("unchecked")
    public void readData() {
        StickData.setMessage("正在从文件中读取数据，请稍作等待");
        if (OldDataSupport.updateFileData(this)) {
            StickData.finishRead();
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("plugins/BedrockTechnology/block.dat"))) {
            this.setHashMap((HashMap<Integer, String>) in.readObject());
            StickData.finishRead();
        } catch (StreamCorruptedException | EOFException e) {
            this.setHashMap(new HashMap<>());
            StickData.finishRead();
        } catch (IOException | ClassNotFoundException e) {
            StickData.setMessage("读取数据失败，BedrockTechnology无法获取到保存的数据，请汇报服务器管理员");
            this.setHashMap(new HashMap<>());
            e.printStackTrace();
        }

        Config cfg = BektMain.getCfg();

        int delay = cfg.getInt("timer.delay");
        int period = cfg.getInt("timer.period");

        if (delay < 0) {
            Log.warn("timer.delay小于0！已自动纠正为初始值10");
            delay = 10;
            cfg.setValue("timer.delay", 10);
        }

        if (period < 3) {
            Log.warn("timer.period小于3！已自动纠正为初始值10");
            period = 10;
            cfg.setValue("timer.period", 10);
            cfg.save();
        }

        final int nextPeriod = period;
        autoSave.schedule(new TimerTask() {
            @Override
            public void run() {
                if (waitList != 0) {
                    Log.info("执行数据自动保存，下一次自动保存将于" + nextPeriod + "分钟后尝试开始");
                    saveData();
                    waitList = 0;
                }
            }
        }, (delay * 60 * 1000L), (period  * 60 * 1000L));
    }

    @Override
    public void stop() {
        saveData();
    }

    public synchronized void saveData() {
        //直接加锁，完事
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("plugins/BedrockTechnology/block.dat"))) {
            out.writeObject(this.map);
        } catch (IOException e) {
            Log.warn("保存数据失败");
            e.printStackTrace();
        }
    }

    public static void readRefuseBlockID(HashSet<String> set) {
        File file = new File("plugins/BedrockTechnology/refuse.txt");
        try (Scanner in = new Scanner(new FileInputStream(file))) {
            while (in.hasNextLine()) {
                set.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
