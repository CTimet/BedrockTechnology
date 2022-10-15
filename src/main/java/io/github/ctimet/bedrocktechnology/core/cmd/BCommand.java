package io.github.ctimet.bedrocktechnology.core.cmd;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.ctimet.bedrocktechnology.data.stickdata.StickData;
import io.github.ctimet.bedrocktechnology.log.Log;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static io.github.ctimet.bedrocktechnology.core.cmd.BCommandHandler.hs;

//缝缝补补还能用
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
            case "wiki" -> {
                BaseComponent url = new TextComponent("点我前往BedrockTechnology的Wiki");
                url.setHoverEvent(new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        new Text("https://www.yuque.com/ctimet/bedrocktechnologywiki")
                ));
                url.setClickEvent(new ClickEvent(
                        ClickEvent.Action.OPEN_URL,
                        "https://www.yuque.com/ctimet/bedrocktechnologywiki"
                ));
                url.setColor(ChatColor.GRAY);
                url.setUnderlined(true);
                sender.spigot().sendMessage(url);
            }
            case "refuse" -> {
                if (st.isNotNull(1)) {
                    if (st.isNotNull(2)) {
                        if (SlimefunItem.getById(args[2]) == null) {
                            st.sendWarn("啊，插件没找到这个ID对应的物品。请检查您输入的ID是否正确");
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("add")) {
                            StickData.addRefuseBlockID(args[2]);
                        } else if (args[1].equalsIgnoreCase("remove")) {
                            StickData.removeRefuseBlockID(args[2]);
                        } else if (args[1].equalsIgnoreCase("clear")) {
                            StickData.clearRefuseBlockID();
                        } else {
                            st.sendWarn("唔...子命令不正确。真搞不懂你要干啥。/bekt hs refuse看看这个指令怎么用吧");
                            return true;
                        }
                        st.sendInfo("操作执行完毕");
                    } else {
                        st.sendWarn("唔...你好像还没指定拒绝注册/修复的方块ID呢");
                    }
                } else {
                    st.sendWarn("唔...你好像还没指定要干啥呢");
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
        registerCommandGroup("wiki","获取BedrockTechnology的Wiki链接");
        registerCommandGroup("refuse", "拒绝某种方块被注册/修复");

        registerSubCommand("refuse", "add", "添加被拒绝注册/修复方块的ID(对应sf物品的id)");
        registerSubCommand("refuse", "remove", "删除被拒绝注册/修复方块的ID(对应sf物品的id)");
        registerSubCommand("refuse", "clear", "删除所有被拒绝注册/修复方块的ID");

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
