package io.github.ctimet.bedrocktechnology.util;

import io.github.ctimet.bedrocktechnology.BektMain;
import org.bukkit.NamespacedKey;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Util {
    private Util(){
    }

    public static void isTrue(boolean b, String m) {
        if (b) {
            throw new IllegalArgumentException(m);
        }
    }

    public static boolean isNumber(String str) {
        return Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(str).matches();
    }

    public static <T> T[] sort(T[] array) {
        Arrays.sort(array);
        return array;
    }

    public static NamespacedKey createNamespacedKey(String key) {
        return new NamespacedKey(BektMain.getInstance(), key);
    }
}
