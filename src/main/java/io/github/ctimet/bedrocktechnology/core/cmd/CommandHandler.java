package io.github.ctimet.bedrocktechnology.core.cmd;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.data.StickData;
import io.github.ctimet.bedrocktechnology.util.PluginTask;
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
import java.sql.SQLException;

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
        if (args.length == 1 && sender.isOp()) {
            switch (args[0]) {
                case "-cf" -> {
                    if (!BektMain.getCfg().getBoolean("mysql.enabled")) {
                        sender.sendMessage("§4无法启用数据强制矫正，因为未链接到服务器。");
                        return true;
                    }
                    sender.sendMessage("§4启动数据强制矫正，矫正期间严禁关闭服务器/数据库，否则后果自负。矫正时不可注册/修复方块。");
                    sender.sendMessage("§b数据矫正可能会花费较长时间，请耐心等待。§4不要重复执行/bekt -cf命令，否则后果自负！§b数据矫正完成后我们会通知您。");
                    StickData.setMessage("§4服务器管理员 " + sender.getName() + " 启用了BedrockTechnology数据强制矫正，无法注册/修复方块。");
                    StickData.setReadFinish(false);
                    PluginTask.runTaskInCachedThreadPool(() -> {
                        try {
                            StickData.startDataCorrect();
                            sender.sendMessage("§b数据矫正完成。");
                        } catch (SQLException e) {
                            sender.sendMessage("§b数据矫正失败。");
                        } finally {
                            StickData.finishRead();
                        }
                    });
                }
                case "-sft" -> {
                    sender.sendMessage("§4方块修复系统已经不对外开放，此时无法进行方块注册/修复操作。");
                    StickData.setReadFinish(false);
                    StickData.setMessage("§4服务器管理员 " + sender.getName() + " 关闭了方块修复系统。无法进行方块注册/修复操作。");
                }
                case "-sff" -> {
                    sender.sendMessage("§b方块修复系统已经对外开放，可以进行方块注册/修复操作。");
                    StickData.finishRead();
                }
            }
            return true;
        }
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
