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

import java.util.*;

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
        if (page > 0) {
            st.sendMessageWithoutHead("===============基岩科技帮助(" + page + "/" + LIST.size() + ")===============","§e§l");
            st.sendMessageWithoutHead("输入 \"/bekt hs 命令集名称\" 以查看相关命令集帮助","§7");
            st.sendMessageWithoutHead(LIST.get((page-1)),"");
            //st.sendMessageWithoutHead("===============基岩科技帮助===============","§a");
        } else {
            st.sendMessageWithoutHead("===============基岩科技帮助(1/" + LIST.size() + ")===============","§e§l");
            st.sendMessageWithoutHead("输入 \"/bekt hs 命令集名称\" 以查看相关命令集帮助","§7");
            st.sendMessageWithoutHead(LIST.get((0)),"");
            //st.sendMessageWithoutHead("===============基岩科技帮助===============","§a");
        }
    }

    public static void refreshHelp() {
        StringBuilder help = new StringBuilder();
        int pages = 1;
        int lines = 0;
        int times = 0;
        int hasPages = ((COMMAND_GROUP.size()%5) == 0) ? (COMMAND_GROUP.size()/5) : ((COMMAND_GROUP.size()/5)+1);
        for (String command : COMMAND_GROUP) {
            help.append("§6/bekt ")
                    .append("§l")
                    .append(command)
                    .append("§f")
                    //.append(" ".repeat(Math.max(0, (6 - command.length()))))
                    .append(": ")
                    .append(COMMAND_GROUP_DESC.get(command))
                    .append("\n");
            lines += 1;
            times += 1;

            if (lines == 5 || times == COMMAND_GROUP.size()) {
                if (pages != hasPages) {
                    help.append("§7输入 \"/bekt help [n]\" 以阅读第n页帮助");
                } else {
                    help.append("§7没有更多帮助了");
                }
                LIST.add(help.toString());
                pages += 1;
                lines = 0;
                help = new StringBuilder();
            }
        }
    }

    public static void register() {
        registerCommandGroup("hs","显示命令集帮助");
        registerCommandGroup("help","显示命令帮助");
        registerCommandGroup("guide","关于配方查询界面的指令");

        registerSubCommand("guide","open", "打开一个配方查询界面");
        registerSubCommand("guide","search","查询相关配方");
        registerSubCommand("guide","count","统计某机器配方所需材料");

        int end = ((COMMAND_GROUP.size()%5)==0) ? (COMMAND_GROUP.size()/5) : ((COMMAND_GROUP.size()/5)+1);
        for (int index = 1;
                 index <= end;
                 index ++) {
            registerSubCommand("help",String.valueOf(index),"第" + index + "页帮助");
        }

        //先排序，再刷新
        Collections.sort(COMMAND_GROUP);
        refreshHelp();
    }
}
