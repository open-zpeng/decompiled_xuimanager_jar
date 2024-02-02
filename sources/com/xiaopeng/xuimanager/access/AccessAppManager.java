package com.xiaopeng.xuimanager.access;

import android.app.ActivityThread;
import android.os.Parcelable;
import com.xiaopeng.app.xpAppInfo;
import com.xiaopeng.xuimanager.pipebus.ParcelableContainer;
import com.xiaopeng.xuimanager.pipebus.client.PipeBusClient;
import com.xiaopeng.xuimanager.pipebus.client.PipeBusClientManager;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AccessAppManager {
    public static final String APP_PAGE_HEADER = "XPENG.ACCESS@";
    public static final String MODULE_NAME = "AccessManager";
    private static final String busServiceName = "xuiAccess";
    private static final String TAG = AccessAppManager.class.getSimpleName();
    private static PipeBusClient pipeBusClient = null;

    /* loaded from: classes.dex */
    private static class AccessAppManagerHolder {
        private static final AccessAppManager INSTANCE = new AccessAppManager();

        private AccessAppManagerHolder() {
        }
    }

    private AccessAppManager() {
        pipeBusClient = PipeBusClientManager.createBusClient(busServiceName, ActivityThread.currentApplication().getApplicationContext());
        pipeBusClient.addLogTagSuffix("access");
    }

    public static AccessAppManager getInstance() {
        return AccessAppManagerHolder.INSTANCE;
    }

    public List<xpAppInfo> getAppList() {
        List<xpAppInfo> infoList = null;
        ParcelableContainer dataOut = new ParcelableContainer();
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_GET_APP_LIST, null, dataOut);
        if (ret == 0) {
            Parcelable[] data = dataOut.getParcelableArray();
            if (data == null || data.length == 0) {
                LogUtil.w(TAG, "getAppList,no valid data");
            } else {
                infoList = new ArrayList<>(16);
                for (Parcelable p : data) {
                    infoList.add((xpAppInfo) p);
                }
            }
        } else {
            LogUtil.w(TAG, "getAppList,ret=" + ret);
        }
        return infoList;
    }

    public int startApp(xpAppInfo appInfo) {
        ParcelableContainer dataIn = new ParcelableContainer();
        dataIn.setParcelableArray(new xpAppInfo[]{appInfo});
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, "startApp", dataIn, null);
        return ret;
    }

    public List<xpAppInfo> getRunningApps() {
        List<xpAppInfo> infoList = null;
        ParcelableContainer dataOut = new ParcelableContainer();
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_GET_RUNNING_APPS, null, dataOut);
        if (ret == 0) {
            Parcelable[] data = dataOut.getParcelableArray();
            if (data == null || data.length == 0) {
                LogUtil.w(TAG, "getRunningApps,no data");
            } else {
                infoList = new ArrayList<>(8);
                for (Parcelable p : data) {
                    infoList.add((xpAppInfo) p);
                }
            }
        } else {
            LogUtil.w(TAG, "getRunningApps,ret=" + ret);
        }
        return infoList;
    }

    public int closeAllApp() {
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_CLOSE_ALL_APP, null, null);
        return ret;
    }

    public xpAppInfo getForegroundRunningWebApp() {
        ParcelableContainer dataOut = new ParcelableContainer();
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_GET_FOREGROUND_WEB_APP, null, dataOut);
        if (ret == 0) {
            xpAppInfo[] parcelableArray = dataOut.getParcelableArray();
            if (parcelableArray == null || parcelableArray.length == 0) {
                LogUtil.w(TAG, "getForegroundRunningWebApp,no data");
                return null;
            }
            xpAppInfo info = parcelableArray[0];
            return info;
        }
        String str = TAG;
        LogUtil.w(str, "getForegroundRunningWebApp,ret=" + ret);
        return null;
    }

    public int closeForegroundRunningWebApp() {
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_STOP_FOREGROUND_WEB_APP, null, null);
        return ret;
    }

    public int goToWebAppHome() {
        int ret = pipeBusClient.ioControlWithParcelable(MODULE_NAME, AccessConst.CMD_GOTO_WEBAPP_HOME, null, null);
        return ret;
    }
}
