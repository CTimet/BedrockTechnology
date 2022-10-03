package io.github.ctimet.bedrocktechnology.plugin.task;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * BedrockTechnology的异步任务类
 */
public class PluginTask {
    private static final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
    private static final ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
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
    public static void runTaskInFixedThreadPool(Runnable task) {
        fixedThreadPool.submit(task);
    }
    public static void runTaskInCachedThreadPool(Runnable task) {
        cachedThreadPool.submit(task);
    }
    public static int getThreadPoolQueueSize() {
        return fixedThreadPool.getQueue().size();
    }
}
