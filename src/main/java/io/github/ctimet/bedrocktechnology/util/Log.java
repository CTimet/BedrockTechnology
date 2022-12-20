package io.github.ctimet.bedrocktechnology.util;

import io.github.ctimet.bedrocktechnology.BektMain;

import java.util.logging.Logger;

public class Log {
    private static final Logger logger = BektMain.getInstance().getLogger();
    public static void info(Object info) {
        logger.info(info.toString());
    }
    public static void warn(String warn) {
        logger.warning(warn);
    }
}
