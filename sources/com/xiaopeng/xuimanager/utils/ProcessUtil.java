package com.xiaopeng.xuimanager.utils;

import android.os.Debug;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes.dex */
public class ProcessUtil {
    public static String getCurrentProcessName() {
        try {
            File file = new File("/proc/" + Process.myPid() + "/cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean dumpJavaTrace(int pid, String fileName, int timeOutSeconds) {
        boolean ret = Debug.dumpJavaBacktraceToFileTimeout(pid, fileName, timeOutSeconds);
        if (!ret && !(ret = Debug.dumpNativeBacktraceToFileTimeout(pid, fileName, timeOutSeconds))) {
            Log.w("ProcessUtil", "dump native trace fail");
        }
        return ret;
    }
}
