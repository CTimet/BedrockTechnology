package io.github.ctimet.bedrocktechnology.BektItems.Command;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class BektCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3)
            return false;
        if (command.getLabel().equals("bedrocktechnology") || label.equals("bt")){
            if (args[0].equals("debug")) {
                try {
                    if (args[1].equals("info-print")) {
                        if (args[2].equals("true") || args[2].equals("t")) {
                            BektMain.main.getConfig().set("info-print", true);
                            BektMain.main.getConfig().save("config.yml");
                        } else if (args[2].equals("false") || args[2].equals("f")) {
                            BektMain.main.getConfig().set("info-print", false);
                            BektMain.main.getConfig().save("config.yml");
                        } else return false;
                        return true;

                    } else if (args[1].equals("warning-print")) {
                        if (args[2].equals("true") || args[2].equals("t")) {
                            BektMain.main.getConfig().set("warning-print", true);
                            BektMain.main.getConfig().save("config.yml");
                        } else if (args[2].equals("false") || args[2].equals("f")) {
                            BektMain.main.getConfig().set("warning", false);
                            BektMain.main.getConfig().save("config.yml");
                        } else return false;
                        return true;
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }
            return false;
        }
        sender.sendMessage("§4[BedrockTechnology] >> 未知命令！");
        return false;
    }
}
