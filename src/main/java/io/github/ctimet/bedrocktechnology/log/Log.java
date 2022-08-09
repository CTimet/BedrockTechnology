package io.github.ctimet.bedrocktechnology.log;

import io.github.ctimet.bedrocktechnology.BektMain;

import java.util.logging.Logger;

public class Log {
    private static final Logger log = BektMain.getInstance().getLogger();
    public static void info(String mes) {
        log.info(mes);
    }
    public static void warn(String mes) {
        log.warning(mes);
    }
}
