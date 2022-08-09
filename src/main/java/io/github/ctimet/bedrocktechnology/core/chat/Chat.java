package io.github.ctimet.bedrocktechnology.core.chat;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
    public void sendPrompt(String mes)
    {
        this.sender.sendMessage("§e[BedrockTechnology] >> " + mes + "。");
    }

    public void sendWarn(String mes)
    {
        this.sender.sendMessage("§4[BedrockTechnology] >> " + mes + "！");
    }

    public void sendMesWithHead(String mes, String head, String color) {
        this.sender.sendMessage("§" + color + "[BedrockTechnology-" + head + "]" + " >> " + mes);
    }

    public void sendInfo(String mes)
    {
        this.sender.sendMessage("§a[BedrockTechnology] >> " + mes + "。");
    }

    public void sendMessageWithoutHead(String mes,String color)
    {
        this.sender.sendMessage(color + mes);
    }

    public boolean isNotNull(int index) {
        return this.args != null && this.args.length > index;
    }
}