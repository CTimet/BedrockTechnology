package io.github.ctimet.bedrocktechnology.core.cmd;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;

import static io.github.ctimet.bedrocktechnology.core.cmd.BCommand.*;

public final class BCommandHandler {
    private BCommandHandler(){
    }

    public static boolean guide(CommandSender user, String[] args) {
        Chat st = new Chat(user,args);
        Player player = (Player) user;

        if (st.isNotNull(1)) {
            //command example:/bekt guide open, the "open" is args[1]
            //so here is isNotNull(1)
            String arg = args[1];
            if (arg.equalsIgnoreCase("open")) {
                Inventory inv = Bukkit.createInventory(player,9,"§6查找配方");
                //0 1 2 3 4 5 6 7 8
                inv.setItem(3, new CustomItemStack(Material.GREEN_STAINED_GLASS, "§aSearch-查找配方"));
                inv.setItem(5,new CustomItemStack(Material.BLUE_STAINED_GLASS, "§bCount-统计配方"));
                player.openInventory(inv);
            } else if (arg.equalsIgnoreCase("search")) {
                Inventory inv = Bukkit.createInventory((InventoryHolder) user, 6 * 9, "Search-配方查询");

            } else if (arg.equalsIgnoreCase("count")) {

            } else {
                st.sendWarn("oh不，你输入了错误的参数");
            }
            return true;
        }
        return false;
    }

    public static void hs(Chat st, String command, int read) {
        if (!COMMAND_GROUP.contains(command)) {
            st.sendWarn("该命令组不存在，请检查命令组名称");
            return;
        }
        ArrayList<String> commands = COMMAND_MAP.get(command);
        if (commands.isEmpty()) {
            st.sendWarn("该命令集下没有子命令");
            return;
        }
        int hasPage = ((commands.size()%5)==0) ? (commands.size()/5) : ((commands.size()/5)+1);
        if (read == 0) {
            read = 1;
        } else if (read < 0 || read > hasPage) {
            st.sendWarn("啊哦。貌似没有这个页面呢");
            return;
        }
        st.sendMessageWithoutHead("===============" + command + "-help(" + read + "/" + hasPage + ")===============","§e§l");
        ArrayList<String> out = new ArrayList<>();
        StringBuilder help = new StringBuilder();
        int lines = 0;
        int times = 0;
        for (String com : commands) {
            help.append("§6/bekt ")
                    .append(command)
                    .append(" §l")
                    .append(com)
                    .append("§f: ")
                    .append(COMMAND_DESC.get(command + "^" + com))
                    .append("\n");
            lines += 1;
            times += 1;
            if (times == commands.size()) {
                help.append("§7没有更多帮助了");
                out.add(help.toString());
                help = new StringBuilder();
            } else if (lines == 5) {
                help.append("§7输入\"/bekt hs ").append(command).append(" ").append(read+1).append("\"以阅读下一篇帮助");
                out.add(help.toString());
                help = new StringBuilder();
            }
        }
        st.sendMessageWithoutHead(out.get(read-1),"");
    }
}
