package io.github.ctimet.bedrocktechnology.BektItems.Command.MessagePage;

import org.bukkit.command.CommandSender;

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

    public void sendWarning(String mes)
    {
        this.sender.sendMessage("§4[BedrockTechnology] >> " + mes + "!");
    }

    public void sendInfo(String mes)
    {
        this.sender.sendMessage("§a[BedrockTechnology] >> " + "§e" + mes + ".");
    }

    public void sendMoreInfo(String[] mes, boolean isUseMoreHint)
    {
        if (isUseMoreHint) {
            for (String info : mes) {
                this.sender.sendMessage("§a[BedrockTechnology] >> " + "§e" + info + ".");
            }
        }else {
            this.sender.sendMessage("§a[BedrockTechnology] >> ");
            for (String info : mes) {
                this.sender.sendMessage("§e" + info);
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
