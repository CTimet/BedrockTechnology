package io.github.ctimet.bedrocktechnology.plugin.task;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * BedrockTechnology的异步任务类，该类的存在仅仅是为了让Bukkit的异步调用看起来更舒服
 * (没错我想用lambda写)
 */
public class PluginTask {
    public static void runTack(Task task) {
        new BukkitRunnable() {
            @Override
            public void run() {
                task.run();
            }
        }.runTask(BektMain.getInstance());
    }
    public static void runTaskAsynchronously(Task task) {
        new BukkitRunnable() {
            @Override
            public void run() {
                task.run();
            }
        }.runTaskAsynchronously(BektMain.getInstance());
    }
}
