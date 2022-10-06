package io.github.ctimet.bedrocktechnology.core.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 可以构造此类的实例以便于发送带颜色的消息。该类已经废弃
 * @deprecated 请使用 {@link io.github.ctimet.bedrocktechnology.core.chat.PlayerChat}
 */
public class Chat {
    private final CommandSender sender;
    private final String[] args;
    public Chat(@NotNull Player player) {
        sender = player;
        this.args = null;
    }
    public Chat(@NotNull CommandSender sender, String[] args) {
        this.sender = sender;
        this.args = args;
    }
    public Chat(@NotNull CommandSender sender) {
        this.sender = sender;
        this.args = null;
    }

    public void sendWarn(String mes) {
        this.sender.sendMessage(ChatColor.GOLD + "[BedrockTechnology] >> " + mes);
    }

    public void sendErr(String mes) {
        this.sender.sendMessage(ChatColor.RED + "[BedrockTechnology] >> " + mes);
    }

    public void sendMesWithHead(String mes, String head, String color) {
        this.sender.sendMessage(color + "[BedrockTechnology-" + head + "]" + " >> \n" + mes);
    }

    public void sendInfo(String mes) {
        this.sender.sendMessage(Color.GREEN + "[BedrockTechnology] >> " + mes + "。");
    }

    public void sendInfoWithoutHead(String mes) {
        this.sender.sendMessage(Color.GREEN + mes);
    }

    public void sendMessageWithoutHead(String mes,String color) {
        this.sender.sendMessage(color + mes);
    }

    public boolean isNotNull(int index) {
        return this.args != null && this.args.length > index;
    }
}