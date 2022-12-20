package io.github.ctimet.bedrocktechnology.util;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 可以用于发送一些简单的带颜色的消息
 */
public class PlayerChat {
    private final CommandSender sender;
    private String head = "";
    public PlayerChat(CommandSender sender, boolean useHead) {
        this.sender = sender;
        if (useHead) head = "[BedrockTechnology] >> \n";
    }

    public PlayerChat(Player sender, boolean useHead) {
        this.sender = sender;
        if (useHead) head = "[BedrockTechnology] >> \n";
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void sendInfo(String info) {
        sender.sendMessage(ChatColor.GREEN + head + info);
    }
    public void sendWarn(String warn) {
        sender.sendMessage(ChatColor.YELLOW + head + warn);
    }
    public void sendErr(String err) {
        sender.sendMessage(ChatColor.RED + head + err);
    }
    public void sendMessage(String mes, ChatColor color) {
        sender.sendMessage(color + head + mes);
    }
    public void sendMessage(String mes) {
        sender.sendMessage(mes);
    }
    public void sendMessage(BaseComponent... components) {
        sender.spigot().sendMessage(components);
    }

    public CommandSender getSender() {
        return this.sender;
    }
}
