package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.log.ExceptionHandler;
import io.github.ctimet.bedrocktechnology.log.Log;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.io.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 管理注册修复系统的数据
 * @author CTimet
 * @version last edit at 2022/08/09
 */
public class StickData {
    private static final Timer TIMER = new Timer();
    private static final Config CONFIG = BektMain.getCfg();

    private static final File TEMP_DAT = new File("plugins/BedrockTechnology/temp.dat");
    private static final File BLOCK_DAT = PluginData.getBlockDat();

    private static HashMap<String, PlayerBlock> RegisterBlockData;
    private static boolean ReadFinish = false;
    private static boolean ThrowException = false;
    private static int WaitListSize = 0;

    /**
     * 读取注册的方块数据
     * 首先，该方法将检查temp.dat文件是否存在，若存在，则从temp.dat中读取数据
     * 若不存在，则从block.dat中读取数据
     */
    public static void readData() {
        //判断是否存在临时文件，存在则读取，并在读取完后销毁
        if (TEMP_DAT.exists()) {
            Log.info("监测到temp.dat文件，将抛弃block.dat文件中的数据");
            readRegisterBlockData(TEMP_DAT);
            Log.info("已经读取temp.dat中的数据，尝试销毁temp.dat..." + TEMP_DAT.delete());
        } else {
            readRegisterBlockData(BLOCK_DAT);
        }
    }

    /**
     * 这个方法将用于注册数据，这个方法只可用于onDisable中
     */
    public static void saveData() {
        if (RegisterBlockData.isEmpty()) return;
        if (isOccupy(BLOCK_DAT)) {
            //如果BlockDat正在被计时器占用，此时会将数据保存至temp.dat文件中防止因为计时器意外终止或两个输出流同时输出导致的数据丢失
            saveRegisterBlockData(TEMP_DAT);
            return;
        }
        saveRegisterBlockData(BLOCK_DAT);
    }

    /**
     * <p>这个方法仅在op使用</p>
     * <p>/bedrocktechnology(bekt) reload</p>
     * <p>时调用</p>
     */
    public static void reloadData() {
        if (ReadFinish) ReadFinish = false;
        readData();
    }

    /**
     * 这个方法将启动BedrockTechnology的自动保存计时器
     */
    public static void startTimer() {
        int delay = CONFIG.getInt("timer.delay") * 60 * 1000;
        int period = CONFIG.getInt("timer.period") * 60 * 1000;
        if (delay < 0) {
            Log.warn("警告：config.yml中设置的delay小于0，BedrockTechnology已自动将delay设置为初始值10");
            delay = 10 * 60 * 1000;
            CONFIG.setValue("timer.delay",10);
            CONFIG.save();
        }
        if (period <= 0) {
            Log.warn("警告：config.yml中设置的period值过小，BedrockTechnology已自动将period设置为初始值10");
            period = 10 * 60 * 1000;
            CONFIG.setValue("timer.period",10);
            CONFIG.save();
        }
        TIMER.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isOccupy(BLOCK_DAT) || WaitListSize == 0) {
                    //等待集为空或者文件被占用时不保存数据
                    return;
                }
                saveRegisterBlockData(BLOCK_DAT);
            }
        }, delay,period);
    }

    /**
     * 关闭计时器，使其优雅地终止
     */
    public static void stopTimer() {
        TIMER.cancel();
    }

    /**
     * 判断这个文件是否被占用，通过判断是否可以重命名
     * @param file 被判断的文件
     * @return 这个文件是否被占用
     */
    public static boolean isOccupy(File file) {
        return !file.renameTo(file);
    }

    /**
     * 向等待集中"增加数据"
     */
    private static void addWait() {
        WaitListSize ++;
    }

    /**
     * 返回RegisterBlockData中是否有这个key
     * @param key key
     * @return true if RegisterBlockData contains key else false
     */
    public static boolean contains(String key) {
        return RegisterBlockData.containsKey(key);
    }

    /**
     * 删除并返回被删除的值
     * 该方法调用时会增加等待集数据，调用此方法后不应再调用addWait方法
     * @param key key
     */
    public static void remove(String key) {
        addWait();
        RegisterBlockData.remove(key);
    }

    /**
     * 得到方块数据
     * @param key 通过坐标计算得来的key
     * @return 方块的BlockData
     */
    @Nullable
    public static PlayerBlock getBlockData(String key) {
        return RegisterBlockData.getOrDefault(key, null);
    }

    /**
     * 向RegisterBlockData中放置方块数据
     * @param key 通过坐标计算得来的关键字
     * @param value 方块的BlockData
     */
    public static void putBlockData(String key, PlayerBlock value) {
        RegisterBlockData.put(key,value);
        addWait();
    }

    /**
     * 这个方法将返回是否未读取完成
     * @return 是否仍然未读取完成
     */
    public static boolean isNotReadFinish() {
        return !ReadFinish;
    }

    /**
     * return now read situation
     * @return read situation, a String
     */
    public static String getReadSituation() {
        return ThrowException ? "读取发生异常，请向管理汇报" : (ReadFinish ? "读取完成" : "读取尚未完成，请稍加等待");
    }

    /**
     * read the register data
     * @param file file for save register data
     */
    private static void readRegisterBlockData(File file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            RegisterBlockData = (HashMap<String, PlayerBlock>) in.readObject();
            ReadFinish = true;
        } catch (EOFException e) {
            //出现 EOF 往往都是文件第一次创建时导致的，此时我们只需把RegisterBlockData初始化即可，无需打印堆栈
            RegisterBlockData = new HashMap<>();
            ReadFinish = true;
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.writeException(e, "readRegisterBlockData", "在读取注册数据时抛出异常", StickData.class);
            ThrowException = true;
        }
    }

    /**
     * save register data to the file
     * @param file the file for save the data
     */
    private static void saveRegisterBlockData(File file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(RegisterBlockData);
            WaitListSize = 0;//数据已保存，清空等待集
        } catch (IOException e) {
            ExceptionHandler.writeException(e, "saveRegisterBlockData", "在保存注册数据时抛出异常", StickData.class);
        }
    }

    /**
     * return true if this inventory has any empty slot
     * @param inv Inventory for check
     * @return true if this inventory has any empty slot , false otherwise
     */
    public static boolean isInventoryFull(Inventory inv) {
        if (inv.isEmpty()) return false;
        for (ItemStack i : inv) {
            if (i == null) return false;
        }
        return true;
    }
}
