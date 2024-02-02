package com.xiaopeng.xuimanager.systemui;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public class SysLogUtils {
    public static final int LOG_D_LEVEL = 3;
    public static final int LOG_E_LEVEL = 6;
    public static final int LOG_I_LEVEL = 4;
    public static final int LOG_V_LEVEL = 2;
    public static final int LOG_W_LEVEL = 5;
    private static String TAG = "SSUI-";
    private static Logger sLogger = new DefaultLogger();
    private static boolean sLogEnable = true;
    private static boolean sWithStackTrace = false;
    private static int LOG_LEVEL = 4;

    /* loaded from: classes.dex */
    public interface Logger {
        void logByLevel(int i, String str, String str2, String str3);
    }

    public static boolean isLogEnable() {
        return sLogEnable;
    }

    public static void setLogEnable(boolean enable) {
        sLogEnable = enable;
    }

    public static void setLogLevel(int logLevel) {
        LOG_LEVEL = logLevel;
    }

    public static int getLogLevel() {
        return LOG_LEVEL;
    }

    public static void setLogger(Logger logger) {
        if (logger != null) {
            sLogger = logger;
        }
    }

    public static void setWithStackTraceFlag(boolean withStackTrace) {
        sWithStackTrace = withStackTrace;
    }

    public static boolean isLogLevelEnabled(int logLevel) {
        return LOG_LEVEL <= logLevel && isLogEnable();
    }

    public static void d(Object tag, String message) {
        if (isLogLevelEnabled(3)) {
            doLog(3, tag, message, null, sWithStackTrace);
        }
    }

    public static void i(Object tag, String message) {
        if (isLogLevelEnabled(4)) {
            doLog(4, tag, message, null, sWithStackTrace);
        }
    }

    public static void w(Object tag, String message) {
        if (isLogLevelEnabled(5)) {
            doLog(5, tag, message, null, sWithStackTrace);
        }
    }

    public static void e(Object tag, String message) {
        if (isLogLevelEnabled(6)) {
            doLog(6, tag, message, null, sWithStackTrace);
        }
    }

    public static void log(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        if (isLogLevelEnabled(logLevel)) {
            doLog(logLevel, tag, message, t, needStackTrace);
        }
    }

    private static void doLog(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        String tagName;
        String fileName = null;
        int lineNumber = 0;
        if (needStackTrace) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement element = null;
            if (stackTraceElements.length > 4) {
                element = stackTraceElements[4];
            }
            if (element != null) {
                fileName = element.getFileName();
                lineNumber = element.getLineNumber();
            }
        }
        String msg = message;
        if (needStackTrace || t != null) {
            msg = msgForTextLog(fileName, lineNumber, message, t, needStackTrace);
        }
        String tagName2 = objClassName(tag);
        if (tagName2 == null) {
            if (TextUtils.isEmpty(fileName)) {
                tagName = TAG;
            } else {
                tagName = fileName;
            }
        } else {
            tagName = TAG + tagName2;
        }
        logByLevel(logLevel, tagName, msg);
    }

    private static void logByLevel(int logLevel, String tag, String msg) {
        sLogger.logByLevel(logLevel, msg, tag, null);
    }

    private static String msgForTextLog(String filename, int line, String msg, Throwable t, boolean needStackTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        if (needStackTrace) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (TAG != null) {
                sb.append("(C:");
                sb.append(TAG);
                sb.append(")");
            }
            sb.append("at (");
            sb.append(filename == null ? "" : filename);
            sb.append(":");
            sb.append(line);
            sb.append(")");
        }
        if (t != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(t));
        }
        return sb.toString();
    }

    private static String objClassName(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return (obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName();
    }

    /* loaded from: classes.dex */
    static class DefaultLogger implements Logger {
        DefaultLogger() {
        }

        @Override // com.xiaopeng.xuimanager.systemui.SysLogUtils.Logger
        public void logByLevel(int type, String msg, String TAG, String fileName) {
            switch (type) {
                case 2:
                    Log.v(TAG, msg);
                    return;
                case 3:
                    Log.d(TAG, msg);
                    return;
                case 4:
                    Log.i(TAG, msg);
                    return;
                case 5:
                    Log.w(TAG, msg);
                    return;
                case 6:
                    Log.e(TAG, msg);
                    return;
                default:
                    return;
            }
        }
    }
}
