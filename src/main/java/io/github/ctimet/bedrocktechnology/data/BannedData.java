package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.core.items.BItems;
import io.github.ctimet.bedrocktechnology.log.ExceptionHandler;
import io.github.ctimet.bedrocktechnology.plugin.task.PluginTask;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class BannedData {
    private static final HashSet<String> banned = new HashSet<>();
    public static void readDataAndRegisterItems() {
        PluginTask.runTaskAsynchronously(() -> {
            try {
                Scanner in = new Scanner(new FileInputStream(PluginData.getBannedTxt()), StandardCharsets.UTF_8);
                while (in.hasNextLine()) {
                    banned.add(in.nextLine());
                }
            } catch (FileNotFoundException e) {
                ExceptionHandler.writeException(e, "readData", "在读取banned.txt时抛出异常", BannedData.class);
            }
            BItems.registerItems();
        });
    }
    public static boolean isNoBanned() {
        return banned.size() == 0;
    }
    public static boolean isBanned(SlimefunItem key) {
        return banned.contains(key.getId());
    }
}
