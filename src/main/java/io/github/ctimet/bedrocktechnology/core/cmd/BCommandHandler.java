package io.github.ctimet.bedrocktechnology.core.cmd;

import io.github.ctimet.bedrocktechnology.core.chat.Chat;

import java.util.ArrayList;

import static io.github.ctimet.bedrocktechnology.core.cmd.BCommand.*;

public final class BCommandHandler {
    private BCommandHandler(){
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
