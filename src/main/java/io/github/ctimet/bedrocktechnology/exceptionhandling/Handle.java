package io.github.ctimet.bedrocktechnology.exceptionhandling;

import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 这是Bekt的异常处理类，该类不允许任何类继承
 */
public final class Handle {
    //不可以实例化这个类
    private Handle(){
    }

    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    public static void writeException(Throwable e, String eName, String eMethod, String eMes, Class<?> c) {
        e.printStackTrace();
        //基本信息
        String time = getTimeString();
        String fileName = eName + "_" + time + ".err";

        File file = new File("");
        File make = new File(file.getAbsolutePath() + File.separator + "BedrockTechnologyErr" + File.separator + "err" + File.separator + fileName);
        BektMain.sayWarning("数据保存时发生IO异常！已将异常保存至服务器根目录下的 BedrockTechnologyErr/err/" + fileName + " 文件中！");
        //System.out.println(file.getAbsolutePath());
        File fileParent = make.getParentFile();
        try {
            if (!fileParent.exists())
                fileParent.mkdirs();
            if (!make.exists())
                make.createNewFile();
            PrintStream print = new PrintStream(make);

            //插件信息
            String sf_version = Slimefun.getVersion();
            String bekt_version = BektMain.main.getPluginVersion();

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
            BektMain.sayWarning("漂亮，又炸了一个。这次是文件找不到了");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            BektMain.sayWarning("太漂亮了，又炸了一个异常，这次是IO又发生错误了");
        }
    }
}
