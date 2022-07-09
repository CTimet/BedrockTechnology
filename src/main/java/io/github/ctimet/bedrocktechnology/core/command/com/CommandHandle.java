package io.github.ctimet.bedrocktechnology.core.command.com;

import io.github.ctimet.bedrocktechnology.core.command.SendMessageToPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandHandle {
    private CommandHandle(){
    }

    public static boolean openGuide(CommandSender user, String[] args) {
        SendMessageToPlayer st = new SendMessageToPlayer(user,args);
        Player player = (Player) user;

        if (st.isNotNull(2)) {
            //command example:/bekt guide open, the "open" is args[2]
            //so here is isNotNull(2)
            String arg = args[2];
            if (arg.equalsIgnoreCase("open")) {

                return true;
            } else if (arg.equalsIgnoreCase("search")) {

                return true;
            } else if (arg.equalsIgnoreCase("count")) {

                return true;
            } else {
                st.sendWarning("oh不，你输入了错误的参数");
                return false;
            }
        }

        return false;
    }
}
