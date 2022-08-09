package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.core.items.BItems;
import io.github.ctimet.bedrocktechnology.log.ExceptionHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class BannedData {
    private static final HashSet<String> banned = new HashSet<>();
    public static void readDataAndRegisterItems() {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    Scanner in = new Scanner(new FileInputStream("plugins/BedrockTechnology/banned.txt"), StandardCharsets.UTF_8);
                    while (in.hasNextLine()) {
                        banned.add(in.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    ExceptionHandler.writeException(e, "readData", "在读取banned.txt时抛出异常", BannedData.class);
                }
                BItems.registerItems();
            }
        }.runTaskAsynchronously(BektMain.getInstance());
    }
    public static boolean isNoBanned() {
        return banned.size() == 0;
    }
    public static boolean isBanned(SlimefunItem key) {
        return banned.contains(key.getId());
    }
}
