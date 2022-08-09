package io.github.ctimet.bedrocktechnology.log;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class ExceptionHandler {
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    public static void writeException(Throwable e, String eMethod, String eMes, Class<?> c) {
        e.printStackTrace();
        //基本信息
        String time = getTimeString();
        String fileName = time + ".err";

        File file = new File("");
        File make = new File(file.getAbsolutePath() + File.separator + "BedrockTechnologyErr" + File.separator + "err" + File.separator + fileName);
        Log.warn("数据保存时发生异常！已将异常保存至服务器根目录下的 BedrockTechnologyErr/err/" + fileName + " 文件中！");
        File fileParent = make.getParentFile();
        try {
            if (!fileParent.exists())
                fileParent.mkdirs();
            if (!make.exists())
                make.createNewFile();
            PrintStream print = new PrintStream(make);

            //插件信息
            String sf_version = Slimefun.getVersion();
            String bekt_version = BektMain.getInstance().getPluginVersion();

            //输出插件信息
            print.println("当前使用的Slimefun版本: " + sf_version);
            print.println("当前使用的BedrockTechnology版本: " + bekt_version);
            print.println("出现问题的类: " + c.getName());
            print.println("出现问题的方法: " + eMethod);
            print.println("问题描述: " + eMes);
            print.println("以下为异常堆栈: ");
            //输出堆栈信息
            e.printStackTrace(print);
            //关闭流
            print.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            Log.warn("漂亮，又炸了一个。这次是文件找不到了");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            Log.warn("太漂亮了，又炸了一个异常，这次是IO发生错误了");
        }
    }
}
