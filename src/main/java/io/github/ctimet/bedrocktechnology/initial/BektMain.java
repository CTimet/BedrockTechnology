package io.github.ctimet.bedrocktechnology.initial;

import io.github.ctimet.bedrocktechnology.core.command.com.BektCommand;
import io.github.ctimet.bedrocktechnology.core.items.BektItemGroup;
import io.github.ctimet.bedrocktechnology.data.DataSave;
import io.github.ctimet.bedrocktechnology.event.BektEvent;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * Main Class
 * 这里是BedrockTechnology的主类，同时存放了许多插件需要用到的方法
 * @author CTimet
 * @author CLIEDS
 * @version 22-07-06-f0
 */
public class BektMain extends JavaPlugin implements SlimefunAddon
{
    public static BektMain main;
    public static boolean isReadFinish = false;
    public static int time;

    @Override
    public void onEnable(){
        main = this;
        //判断time值是否过小
        int judge = new Config(this).getInt("save.time");
        if (judge < 3) {
            sayWarning("警告，config中设置的值过小，该值不能小于3，已自动调整至10，请您手动调整save.time的值");
            time = 10;
        } else {
            time = judge;
        }
        //保存一些基本文件
        saveDefaultConfig();
        saveResource("block.dat",false);
        //注册子组
        BektItemGroup.registerGroup();
        //注册物品
        BektItems.registerItems();
        //注册数据系统,启动相关线程
        DataSave.registerSave();
        //注册事件
        BektEvent.registerEvents();
        //注册命令系统
        BektCommand.registerCommand();
    }

    @Override
    public void onDisable(){
        sayInfo("正在进行数据保存，受限于您的数据量大小，这可能会耗费一点时间，请您稍安勿躁，很快就好");
        DataSave.refreshDataInEnd();
        sayInfo("关闭计时线程");
        DataSave.closeTimer();
        sayInfo("关闭BedrockTechnology完成");
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    public static NamespacedKey createKey(String key){
        return new NamespacedKey(main,key);
    }

    public static void sayInfo(String information){
        main.getLogger().info(information);
    }

    public static void sayWarning(String warning){
        main.getLogger().warning(warning);
    }
}
