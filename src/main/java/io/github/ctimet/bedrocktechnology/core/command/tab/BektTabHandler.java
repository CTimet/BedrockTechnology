package io.github.ctimet.bedrocktechnology.core.command.tab;

import io.github.ctimet.bedrocktechnology.core.command.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static io.github.ctimet.bedrocktechnology.core.command.com.BektCommand.*;

public class BektTabHandler implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }
        if (args.length == 1) {
            return Arrays.asList(COMMAND_GROUP.toArray(new String[0]));
        }
        if (args.length == 2) {
            String arg0 = args[0];
            if (!COMMAND_GROUP.contains(arg0)) return null;
            String arg = args[1];
            ArrayList<String> keys = COMMAND_MAP.get(arg0);
            if (arg.equals("")) return keys;
            List<String> gets = new LinkedList<>();
            for (String key : keys) {
                if (key.startsWith(arg)) {
                    gets.add(key);
                }
            }
            return gets;
        }
        return null;
    }
}
