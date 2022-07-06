package io.github.ctimet.bedrocktechnology.core.command;

import io.github.ctimet.bedrocktechnology.data.DataSave;
import io.github.ctimet.bedrocktechnology.initial.BektMain;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

public class BektCommand implements CommandExecutor
{
    public static final Config cfg = new Config(BektMain.main);

    /**
     * 注册命令系统，该方法必须放在onEnable中
     */
    public static void registerCommand() {
        PluginCommand command = Bukkit.getPluginCommand("bedrocktechnology");
        if (command != null) {
            command.setExecutor(new BektCommand());
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull Command command,@NotNull String label,@NotNull String[] args) {

        return true;
    }
}
