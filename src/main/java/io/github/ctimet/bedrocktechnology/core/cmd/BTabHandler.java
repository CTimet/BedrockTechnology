package io.github.ctimet.bedrocktechnology.core.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static io.github.ctimet.bedrocktechnology.core.cmd.BCommand.*;

public class BTabHandler implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }
        if (args.length == 1) {
            ArrayList<String> keys = new ArrayList<>();
            for (String key : COMMAND_GROUP) {
                if (key.startsWith(args[0])) {
                    keys.add(key);
                }
            }
            return keys;
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
        if (args.length == 3) {
            List<String> gets = new LinkedList<>();

        }
        return null;
    }
}
