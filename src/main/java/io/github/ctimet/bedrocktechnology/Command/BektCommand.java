package io.github.ctimet.bedrocktechnology.Command;

import io.github.ctimet.bedrocktechnology.Command.MessagePage.SendMessageToPlayer;
import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static io.github.ctimet.bedrocktechnology.BektMain.VERSION;

public class BektCommand implements CommandExecutor
{
    public static final Config cfg = new Config(BektMain.main);

    /*Help的显示页*/
    private static final ArrayList<String[]> mes = new ArrayList<>();

    static {
        //之所以后面解释的部分没有对齐是因为对其后在游戏内就显示不齐了，这个标准以游戏内的标准为主
        /*第一页*/
        mes.add(
            new String[]{
                    "—————————————————————————————————HELP1————————————————————————————————————",
                    "/bt debug                                   §a-- 使用调试指令",
                    "    |    getValue                            §a-- 获取config.yml中的相关值",
                    "    |    |     xxx                           §a-- 获取值名为xxx的值",
                    "    |    setValue                            §a-- 设置config.yml中的值",
                    "    |    |     xxx <true/t||false/f||?>           §a-- 设置相关值",
                    "    help                                    §a-- 获取指令帮助",
                    "    version                                  §a--获取当前版本",
                    "—————————————————————————————————HELP1—————————————————————————————————————",
                    "排序先后顺序以A~Z的字母顺序为基准，可使用/bt help-2来阅读下一页"
            }
        );
        /*第二页*/
        mes.add(
                new String[]{
                        "—————————————————————————————————HELP2————————————————————————————————————",

                        "—————————————————————————————————HELP2—————————————————————————————————————",
                        "排序先后顺序以A~Z的字母顺序为基准，可使用/bt help-3来阅读下一页，/bt help-1来阅读上一页"
                }
        );
        mes.add(
                new String[]{
                        "—————————————————————————————————HELP3————————————————————————————————————",
                        "—————————————————————————————————HELP3—————————————————————————————————————",
                        "排序先后顺序以A~Z的字母顺序为基准，可使用/bt help-4来阅读下一页，/bt help-2来阅读上一页"
                }
        );
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        SendMessageToPlayer st = new SendMessageToPlayer(sender,args);
        if (args.length < 1)
        {
            st.sendWarning("未知命令，请检查是否有拼写错误");
            return false;
        }
        if (command.getLabel().equals("bedrocktechnology") || label.equals("bt"))
        {
            switch (args[0])
            {
                case "debug":
                    if (args[1].equals("setValue") && st.isNotNull(2))
                    {
                        if (args[2].equals("info-print") && st.isNotNull(3))
                        {
                            if (args[3].equals("true") || args[3].equals("t"))
                            {
                                cfg.setValue("options.info-print", true);
                                BektMain.sayInfo(
                                        "管理者 " +
                                                sender.getName() +
                                                " 修改了 config.yml 文件中 info-print 的值为 true"
                                );
                                BektMain.sayInfo(
                                        "The administrator " +
                                                sender.getName() +
                                                " set the info-print from config.yml as true"
                                );
                                cfg.save();
                                st.sendInfo("成功将 info-print 设置为" + cfg.getBoolean("options.info-print"));
                                return true;
                            }
                            else if (args[3].equals("false") || args[3].equals("f"))
                            {
                                cfg.setValue("options.info-print", false);
                                BektMain.sayInfo(
                                        "管理者 " +
                                                sender.getName() +
                                                " 修改了 config.yml 文件中 info-print 的值为 false"
                                );
                                BektMain.sayInfo(
                                        "The administrator " +
                                                sender.getName() +
                                                " set the info-print from config.yml as false"
                                );
                                cfg.save();
                                st.sendInfo("成功将 info-print 设置为" + cfg.getBoolean("options.info-print"));
                                return true;
                            } else {
                                st.sendWarning("未知命令，请检查是否有拼写错误");
                                return false;
                            }
                        }
                        else if (args[2].equals("warning-print"))
                        {
                            if (args[3].equals("true") || args[3].equals("t")) {
                                cfg.setValue("options.warning-print", true);
                                BektMain.sayInfo(
                                        "管理者 " +
                                                sender.getName() +
                                                " 修改了 config.yml 文件中 warning-print 的值为 true"
                                );
                                BektMain.sayInfo(
                                        "The administrator " +
                                                sender.getName() +
                                                " set the warning-print from config.yml as true"
                                );
                                cfg.save();
                                st.sendInfo("成功将 warning-print 设置为" + cfg.getBoolean("options.warning-print"));
                                return true;
                            } else if (args[3].equals("false") || args[3].equals("f")) {
                                cfg.setValue("options.warning-print", false);
                                BektMain.sayInfo(
                                        "管理者 " +
                                                sender.getName() +
                                                " 修改了 config.yml 文件中 warning-print 的值为 false"
                                );
                                BektMain.sayInfo(
                                        "The administrator " +
                                                sender.getName() +
                                                " set the warning-print from config.yml as false"
                                );
                                cfg.save();
                                st.sendInfo("成功将 warning-print 设置为" + cfg.getBoolean("options.warning-print"));
                                return true;
                            } else {
                                st.sendWarning("未知命令，请检查是否有拼写错误");
                                return false;
                            }
                        }
                        return false;
                    } else if (args[1].equals("getValue") && st.isNotNull(2))
                    {
                        if (args[2].equals("info-print") && st.isNotNull(3)) {
                            st.sendInfo(String.valueOf(cfg.getBoolean("options.info-print")));
                        } else if (args[2].equals("warning-print")) {
                            st.sendInfo(String.valueOf(cfg.getBoolean("options.warning-print")));
                        } else {
                            st.sendWarning("未知命令，请检查是否有拼写错误");
                            return false;
                        }
                        return true;
                    }
                    break;
                case "help":
                case "help-1":
                    st.showTheHelp(mes, 0);
                    return true;
                case "help-2":
                    st.showTheHelp(mes, 1);
                    return true;
                case "help-3":
                    st.showTheHelp(mes, 2);
                    return true;
                case "version":
                    st.sendInfo(VERSION);
                default:
                    st.sendWarning("未知命令，请检查是否有拼写错误");
                    return false;
            }
        }
        return false;
    }


}
