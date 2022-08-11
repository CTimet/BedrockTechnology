package io.github.ctimet.bedrocktechnology.core.cmd;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.log.Log;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import static io.github.ctimet.bedrocktechnology.core.cmd.BCommandHandler.*;

public class BCommand implements CommandExecutor
{
    //一级子命令
    public static LinkedList<String> COMMAND_GROUP = new LinkedList<>();
    //一级命令与对应描述
    public static HashMap<String, String> COMMAND_GROUP_DESC = new HashMap<>();
    //二级子命令
    public static HashMap<String, ArrayList<String>> COMMAND_MAP = new HashMap<>();
    //二级子命令描述
    public static HashMap<String,String> COMMAND_DESC = new HashMap<>();

    public static final ArrayList<String> LIST = new ArrayList<>();

    public static void registerCommand() {
        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BCommand());
            command.setTabCompleter(new BTabHandler());
        }
        register();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label,@NotNull String[] args) {
        if (args.length < 1) {
            return false;
        }
        Chat st = new Chat(sender,args);
        switch (args[0]) {
            case "help" -> {
                if (st.isNotNull(1)) {
                    help(st, Integer.parseInt(args[1]));
                } else {
                    help(st, 1);
                }
            }
            case "reload" -> {
                st.sendInfo("准备重载数据，期间不可进行 注册/修复 操作");
                StickData.reloadData();
                st.sendInfo("重载完成");
            }
            case "hs" -> {
                if (st.isNotNull(1)) {
                    if (st.isNotNull(2))
                        hs(st,args[1],Integer.parseInt(args[2]));
                    else
                        hs(st,args[1],0);
                } else {
                    st.sendWarn("额，你好像还没输入命令集名称呢");
                }
            }
            case "guide" -> {
                if (sender instanceof Player) {
                    return guide(sender,args);
                } else {
                    st.sendWarn("?");
                }
            }
        }
        return true;
    }

    private static void registerCommandGroup(String command, String desc) {
        COMMAND_GROUP.add(command);
        COMMAND_GROUP_DESC.put(command, desc);
        COMMAND_MAP.put(command,new ArrayList<>());
        if (!command.equals("hs"))
            registerSubCommand("hs",command,"得到关于" + command + "的子命令帮助");
    }

    private static void registerSubCommand(String group, String command, String describe) {
        if (COMMAND_GROUP.contains(group)) {
            ArrayList<String> sc = COMMAND_MAP.get(group);
            sc.add(command);
            COMMAND_DESC.put(group + "^" + command,describe);
            //往hc这个组里面添加command子命令用于命令补全
            COMMAND_MAP.put(group,sc);
            return;
        }
        Log.warn("该命令组不存在，请检查命令名称，命令组：" + group + "；尝试注册的子命令：" + command);
    }

    public static void help(Chat st, int page) {
        if (page > LIST.size() || page < 0) {
            st.sendWarn("啊哦，貌似没有这个页面呢");
            return;
        }
        if (LIST.size() == 0)
            st.sendWarn("啊哦，出问题了，LIST的大小为0呢");
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
        //先初始化HS
        COMMAND_MAP.put("hs",new ArrayList<>());

        registerCommandGroup("hs","显示二级命令帮助");
        registerCommandGroup("help","显示一级命令帮助");
        registerCommandGroup("guide","关于配方查询界面的指令");
        registerCommandGroup("reload","重载BedrockTechnology数据");

        registerSubCommand("guide","open", "打开一个配方查询界面");
        registerSubCommand("guide","search","查询相关配方");
        registerSubCommand("guide","count","统计某机器配方所需材料");

        int end = ((COMMAND_GROUP.size()%5)==0) ? (COMMAND_GROUP.size()/5) : ((COMMAND_GROUP.size()/5)+1);
        for (int index = 1;
             index <= end;
             index ++) {
            registerSubCommand("help",String.valueOf(index),"获取第" + index + "页帮助");
        }

        //先排序，再刷新
        sort();
        refreshHelp();
    }

    private static void sort() {
        Collections.sort(COMMAND_GROUP);
        COMMAND_MAP.forEach((k,v) -> Collections.sort(v));
    }
}
