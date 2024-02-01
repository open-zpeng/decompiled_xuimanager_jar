package com.xiaopeng.xuimanager.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtil {
    private static int defaultLevel = 1;
    private static int targetLevel = -1;
    public static final int xD = 1;
    public static final int xE = 4;
    public static final int xI = 2;
    public static final int xNon = 10;
    public static final int xV = 0;
    public static final int xW = 3;

    public static void log(int logLevel, String tag, String message, Throwable t) {
        int i = targetLevel;
        if (-1 != i && logLevel < i) {
            logLevel = targetLevel;
        }
        if (logLevel >= defaultLevel) {
            if (logLevel == 0) {
                Log.v(tag, message);
            } else if (logLevel == 1) {
                Log.d(tag, message);
            } else if (logLevel == 2) {
                Log.i(tag, message);
            } else if (logLevel == 3) {
                Log.w(tag, message);
            } else if (logLevel == 4) {
                if (t != null) {
                    Log.e(tag, message, t);
                } else {
                    Log.e(tag, message);
                }
            }
        }
    }

    public static void log(int logLevel, String tag, String message) {
        log(logLevel, tag, message, null);
    }

    public static void v(String tag, String message) {
        log(0, tag, message, null);
    }

    public static void d(String tag, String message) {
        log(1, tag, message, null);
    }

    public static void i(String tag, String message) {
        log(2, tag, message, null);
    }

    public static void w(String tag, String message) {
        log(3, tag, message, null);
    }

    public static void e(String tag, String message) {
        log(4, tag, message, null);
    }

    public static void e(String tag, String message, Throwable t) {
        log(4, tag, message, t);
    }

    public static void setModuleLogLevel(String tag, int level) {
    }

    public static void setDefaultLevel(int level) {
        if (level >= 0 && level <= 4) {
            defaultLevel = level;
        } else if (10 == level) {
            defaultLevel = level;
        }
    }

    public static int getDefaultLevel() {
        return defaultLevel;
    }

    public static void setOutputLevel(int level) {
        if (level >= 0 && level <= 4) {
            targetLevel = level;
        } else if (-1 == level) {
            targetLevel = -1;
        }
    }

    public static int getOutputLevel() {
        return targetLevel;
    }
}
