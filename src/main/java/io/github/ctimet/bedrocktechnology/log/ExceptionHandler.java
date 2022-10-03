package io.github.ctimet.bedrocktechnology.log;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExceptionHandler {
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S");
        return df.format(new Date());
    }

    public static void writeException(Throwable e, String eMethod, String eMes, Class<?> c) {
        e.printStackTrace();
        //基本信息
        String time = getTimeString();
        String fileName = time + ".err";

        File file = new File("");
        File make = new File(file.getAbsolutePath() + File.separator + "BedrockTechnologyErr" + File.separator + "err" + File.separator + fileName);
        Log.warn("BedrockTechnology发生异常！已将异常保存至服务器根目录下的 BedrockTechnologyErr/err/" + fileName + " 文件中！");
        File fileParent = make.getParentFile();
        try {
            if (!fileParent.exists())
                fileParent.mkdirs();
            if (!make.exists())
                make.createNewFile();
            PrintStream print = new PrintStream(make);

            //输出插件信息
            print.println("当前使用的Slimefun版本: " + Slimefun.getVersion());
            print.println("当前使用的BedrockTechnology版本: " + BektMain.getInstance().getPluginVersion());
            print.println("出现问题的类: " + c.getName());
            print.println("出现问题的方法: " + eMethod);
            print.println("问题描述: " + eMes);
            print.println("以下为异常堆栈: ");
            //输出堆栈信息
            e.printStackTrace(print);
            //关闭流
            print.close();
        } catch (Exception exception) {
            Log.warn("漂亮，在ExceptionHandler#writeException中炸了一个异常。摆烂了我直接printStackTrace，请交由服务器技术人员处理");
            exception.printStackTrace();
        }
    }
}
