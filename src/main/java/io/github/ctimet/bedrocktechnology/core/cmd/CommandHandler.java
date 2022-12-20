package io.github.ctimet.bedrocktechnology.core.cmd;

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

import javax.annotation.ParametersAreNonnullByDefault;

public class CommandHandler implements CommandExecutor {
    public static void init() {
        PluginCommand cmd = Bukkit.getPluginCommand("bedrocktechnology");
        if (cmd != null) {
            cmd.setExecutor(new CommandHandler());
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§b基岩科技命令系统还在重构呢，想看wiki的话可以戳下面的链接 ↓↓↓");
        BaseComponent component = new TextComponent("https://www.yuque.com/ctimet/bedrocktechnologywiki");
        component.setClickEvent(new ClickEvent(
                ClickEvent.Action.OPEN_URL,
                "https://www.yuque.com/ctimet/bedrocktechnologywiki"
        ));
        component.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new Text("左键打开 BedrockTechnology Wiki")
        ));
        sender.spigot().sendMessage(component);
        return true;
    }
}
