package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.BektMain;
import io.github.ctimet.bedrocktechnology.log.Log;

import java.io.File;
import java.io.IOException;

public class PluginData {
    private static final File BLOCK_DAT = new File("plugins/BedrockTechnology/block.dat");
    private static final File BANNED_TXT = new File("plugins/BedrockTechnology/banned.txt");

    public static void check() {
        try {
            if (!BLOCK_DAT.exists()) {
                Log.info("创建block.dat..." + BLOCK_DAT.createNewFile());
            }
            if (!BANNED_TXT.exists()) {
                Log.info("创建banned.txt..." + BANNED_TXT.createNewFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getBlockDat() {
        return BLOCK_DAT;
    }

    public static File getBannedTxt() {
        return BANNED_TXT;
    }
}
