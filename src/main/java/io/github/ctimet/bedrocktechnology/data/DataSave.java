package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.event.FixEvent;
import io.github.ctimet.bedrocktechnology.handle.ExceptionHandle;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static io.github.ctimet.bedrocktechnology.initial.BektMain.*;

/**
 * 这个类主要用于BEKT的数据读取与保存
 * 标记为final是不想让任何类继承它，因为继承它实在没啥用，直接调这里面的方法就好了。没必要继承
 * @author CTimet
 */
public final class DataSave {
    private static int WAIT_FOR_WRITE = 0;
    public static final String DefaultPath = "plugins" + "/" + main.getName() + "/" + "block.dat";
    public static final String SnapPath = "plugins" + "/" + main.getName() + "/" + "snap.dat";
    public static final Timer TIMER = new Timer();
    public static boolean isTimerRun = false;

    //阻止任何人实例化这个类，因为所有东西都是静态的
    private DataSave(){
    }

    public static void registerSave() {
        new BukkitRunnable() {
            @Override
            public void run() {
                File file = new File(new File("").getAbsolutePath() + "\\plugins\\" + main.getName() + "\\snap.dat");
                if (file.exists()) {
                    //文件存在，说明上一次关闭服务器的数据丢这里了，我们以这个数据为主，把他读出来
                    DataSave.readData(SnapPath);
                    file.delete();//把临时文件删掉
                } else {
                    DataSave.readData(DefaultPath);
                }
                main.getLogger().info("机器保护 >> 数据读取完成！可以使用修复注册棒了！");
                isReadFinish = true;
            }
        }.runTaskAsynchronously(main);

        TIMER.schedule(new TimerTask() {
            @Override
            public void run() {
                isTimerRun = true;
                DataSave.refreshData();
                isTimerRun = false;
            }
        }, (long) 10 * 60 * 1000, (long) time * 60 * 1000);
    }

    public static void closeTimer() {
        TIMER.cancel();
    }

    public static void readData(String dataPath) {
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataPath));

            FixEvent.MAP = (HashMap<String, PlayerBlock>) in.readObject();

            in.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            ExceptionHandle.writeException(e,"IOException_ClassNotFoundException", "readData", "在尝试读取block.dat时出错", DataSave.class);
        }
    }

    /**
     * 特别说明：不要直接调用此方法保存数据，事实上，应该调用refreshData()或者refreshDataInEnd()来保存数据！否则，容易导致数据丢失
     */
    public static void saveData(String dataPath) {
        if (!isReadFinish) {
            main.getLogger().info("机器保护 >> 检测到数据未读取完成，已终止本次保存。");
        }
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataPath));

            out.writeObject(FixEvent.MAP);

            out.close();
        }
        catch (IOException e)
        {
            ExceptionHandle.writeException(e,"IOException", "saveData", "在尝试保存数据时出错", DataSave.class);
        }
    }

    public static void addWait() {
        WAIT_FOR_WRITE += 1;
    }

    public static void refreshData() {
        if (WAIT_FOR_WRITE == 0)
            return;
        BektMain.sayInfo("正在保存数据，本次存在 " + WAIT_FOR_WRITE + " 个数据变动，下次保存在 " + BektMain.time + " 分钟之后");
        refresh(DefaultPath);
        BektMain.sayInfo("保存成功");
    }

    public static void refreshDataInEnd() {
        if (WAIT_FOR_WRITE == 0)
            return;
        BektMain.sayInfo("正在保存数据，本次存在 " + WAIT_FOR_WRITE + " 个数据变动");
        if (isTimerRun) {
            File file = new File(new File("").getAbsolutePath() + "\\plugins\\" + main.getName() + "\\snap.dat");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    ExceptionHandle.writeException(e, "IOException", "refreshDataInEnd", "尝试创建snap.dat时发生IO错误", DataSave.class);
                }
            }
            refresh(SnapPath);
        }
    }

    //这个方法不允许其他类调用
    private static void refresh(String dataPath) {
        saveData(dataPath);
        WAIT_FOR_WRITE = 0;
    }
}
