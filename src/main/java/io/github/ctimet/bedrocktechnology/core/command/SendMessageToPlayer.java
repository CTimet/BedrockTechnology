package io.github.ctimet.bedrocktechnology.core.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SendMessageToPlayer
{
    public final CommandSender sender;
    public final String[] args;

    public SendMessageToPlayer(CommandSender commandSender, String[] args)
    {
        this.args = args;
        this.sender = commandSender;
    }

    public SendMessageToPlayer(Player player)
    {
        this.args = new String[]{};
        sender = player;
    }

    public void sendPrompt(String mes)
    {
        this.sender.sendMessage("§e[BedrockTechnology] >> " + mes + "。");
    }

    public void sendWarning(String mes)
    {
        this.sender.sendMessage("§4[BedrockTechnology] >> " + mes + "！");
    }

    public void sendInfo(String mes)
    {
        this.sender.sendMessage("§a[BedrockTechnology] >> " + mes + "。");
    }

    public void sendMessageWithoutHead(String mes,String color)
    {
        this.sender.sendMessage(color + mes);
    }

    public void sendMoreInfo(String[] mes, boolean isUseMoreHint)
    {
        if (isUseMoreHint) {
            for (String info : mes) {
                this.sender.sendMessage("§a[BedrockTechnology] >> " + info + "。");
            }
        }else {
            this.sender.sendMessage("§a[BedrockTechnology] >> ");
            for (String info : mes) {
                this.sender.sendMessage("§a" + info);
            }
        }
    }
    public void showTheHelp(List<String[]> mes,int index){
        sendMoreInfo(mes.get(index),false);
    }

    public boolean isNotNull(int num)
    {
        return this.args.length > num;
    }
}
