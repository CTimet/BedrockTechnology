package io.github.ctimet.bedrocktechnology.data;

import io.github.ctimet.bedrocktechnology.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class RefuseBlockStorage {
    public static void readRefuseBlockID(HashSet<String> set) {
        File file = new File("plugins/BedrockTechnology/refuse.txt");
        if (file.exists()) {
            try (Scanner in = new Scanner(new FileInputStream(file))) {
                while (in.hasNextLine()) {
                    set.add(in.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Log.info("创建refuse.txt " + file.createNewFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
