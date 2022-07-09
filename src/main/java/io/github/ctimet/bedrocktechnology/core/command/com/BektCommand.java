package io.github.ctimet.bedrocktechnology.core.command.com;

import io.github.ctimet.bedrocktechnology.core.command.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.core.command.tab.BektTabHandler;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BektCommand implements CommandExecutor
{
    public static final Config cfg = new Config(BektMain.main);

    //一级子命令
    public static LinkedList<String> COMMAND_GROUP = new LinkedList<>();
    //一级命令与对应描述
    public static HashMap<String, String> COMMAND_GROUP_DESC = new HashMap<>();
    //二级子命令
    public static HashMap<String, ArrayList<String>> COMMAND_MAP = new HashMap<>();
    //二级子命令描述
    public static HashMap<String,LinkedList<String>> COMMAND_DESC = new HashMap<>();

    public static final ArrayList<String> LIST = new ArrayList<>();

    /**
     * 注册命令系统，该方法必须放在onEnable中
     */
    public static void registerCommand() {
        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
            command.setTabCompleter(new BektTabHandler());
        }
        register();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label,@NotNull String[] args) {
        if (args.length < 1) {
            return false;
        }
        switch (args[0]) {
            case "help" -> {
                SendMessageToPlayer st = new SendMessageToPlayer(sender,args);
                if (st.isNotNull(1)) {
                    help(st, Integer.parseInt(args[1]));
                } else {
                    help(st, 0);
                }
            }
            case "guide" -> {
                if (sender instanceof Player) {
                    return CommandHandle.openGuide(sender,args);
                } else {
                    new SendMessageToPlayer(sender,null).sendWarning("?");
                }
            }
        }
        return true;
    }

    public static void registerCommandGroup(String command, String desc) {
        COMMAND_GROUP.add(command);
        COMMAND_GROUP_DESC.put(command, desc);
        COMMAND_MAP.put(command,new ArrayList<>());
    }

    public static void registerSubCommand(String group, String command, String describe) {
        if (COMMAND_GROUP.contains(group)) {
            ArrayList<String> sc = COMMAND_MAP.get(group);
            sc.add(command);
            LinkedList<String> desc = new LinkedList<>();
            desc.add(describe);
            COMMAND_DESC.put(group + "^" + command,desc);
            COMMAND_MAP.put(group,sc);
            return;
        }
        BektMain.sayWarning("该命令组不存在，请检查命令名称，命令组：" + group + "；尝试注册的子命令：" + command);
    }

    public static void help(SendMessageToPlayer st, int page) {
        if (page > LIST.size() || page < 0) {
            st.sendWarning("啊哦，貌似没有这个页面呢");
            return;
        }
        if (LIST.size() == 0)
            st.sendWarning("啊哦，出问题了，LIST的大小为0呢");
        if (page > 0)
            st.sendMessageWithoutHead(LIST.get((page-1)),"§e");
        else
            st.sendMessageWithoutHead(LIST.get(0),"§e");
    }

    public static void refreshHelp() {
        StringBuilder help = new StringBuilder();
        int pages = 0;
        int lines = 0;
        help.append("[BedrockTechnology-help] >>> \n");
        for (String command : COMMAND_GROUP) {
            if (lines == 0)
                help.append("当前页面  ").append(pages + 1).append("/").append(COMMAND_GROUP.size()/5).append("\n \n");
            help.append("/bekt ").append(command).append("\n");
            help.append("     --").append(COMMAND_GROUP_DESC.get(command)).append("\n \n");
            lines += 1;
            if (lines == 5) {
                help.append("\n").append("输入 \"/bekt hs 命令集名称\" 以查看该命令集帮助\n");
                if (pages == COMMAND_GROUP.size()) {
                    help.append("你已经阅读到最底层啦，已经没有什么好看的啦");
                }
                LIST.add(help.toString());
                pages += 1;
                lines = 0;
                help = new StringBuilder();
            }
        }
        if (LIST.size() == 0) {
            //初始化两个变量
            help = new StringBuilder();
            help.append("[BedrockTechnology-help] >>> \n");
            help.append("当前页面  ").append("1/1\n \n");
            for (String command : COMMAND_GROUP) {
                help.append("/bekt ").append(command).append("\n");
                help.append("     --").append(COMMAND_GROUP_DESC.get(command)).append("\n");
            }
            help.append("\n \n").append("输入 \"/bekt hs 命令集名称\" 以查看该命令集帮助\n");
            help.append("你已经阅读到最底层啦，已经没有什么好看的啦");
            LIST.add(help.toString());
        }
    }

    public static void register() {
        registerCommandGroup("help","显示帮助");
        registerCommandGroup("hs","显示命令集帮助");
        registerCommandGroup("guide","关于配方查询界面的指令");
        registerCommandGroup("help1","显示帮助");
        registerCommandGroup("hs1","显示命令集帮助");
        registerCommandGroup("guide1","关于配方查询界面的指令");

        registerSubCommand("guide","open", "打开一个配方查询界面");
        registerSubCommand("guide","search","查询相关配方");
        registerSubCommand("guide","count","统计某机器配方所需材料");

        refreshHelp();
    }
}
