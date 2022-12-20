package io.github.ctimet.bedrocktechnology.util;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * BedrockTechnology的任务类
 */
public class PluginTask {
    private static final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
    private static final ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public static void runTackInServerThread(Runnable task) {
        new BukkitRunnable() {
            @Override
            public void run() {
                task.run();
            }
        }.runTask(BektMain.getInstance());
    }
    /**
     * 使用runTaskInCachedThreadPool是代替此方法的更佳的解决方案，无论是在该方法频繁调用还是在非频繁调用中，
     * 使用runTaskInCachedThreadPool会更划算
     * @deprecated 建议使用runTaskInCachedThreadPool
     */
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
