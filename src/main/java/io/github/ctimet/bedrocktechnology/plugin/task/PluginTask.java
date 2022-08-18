package io.github.ctimet.bedrocktechnology.plugin.task;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * BedrockTechnology的异步任务类
 */
public class PluginTask {
    public static void runTack(Runnable task) {
        new BukkitRunnable() {
            @Override
            public void run() {
                task.run();
            }
        }.runTask(BektMain.getInstance());
    }
    public static void runTaskAsynchronously(Runnable task) {
        new BukkitRunnable() {
            @Override
            public void run() {
                task.run();
            }
        }.runTaskAsynchronously(BektMain.getInstance());
    }
}
