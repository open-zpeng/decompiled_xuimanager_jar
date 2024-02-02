package android.net.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class WifiApManager {
    private static final String TAG = "WifiApManager";
    private Map<WifiClientsCallback, SoftApCallbackAdaptor> mCallBacks = new HashMap();
    private Context mContext;
    private WifiManager mWifiManager;

    /* loaded from: classes.dex */
    public interface WifiClientsCallback {
        void onClientsUpdated(List<WifiClient> list);
    }

    /* loaded from: classes.dex */
    private static class SoftApCallbackAdaptor implements WifiManager.SoftApCallback {
        private WifiClientsCallback mCallback;

        SoftApCallbackAdaptor(WifiClientsCallback callback) {
            this.mCallback = callback;
        }

        public void onStateChanged(int state, int failureReason) {
            Log.v(WifiApManager.TAG, "SoftApCallbackAdaptor: onStateChanged: state=" + state + ", failureReason=" + failureReason);
        }

        public void onNumClientsChanged(int numClients) {
            Log.v(WifiApManager.TAG, "SoftApCallbackAdaptor: onNumClientsChanged: numClients=" + numClients);
        }

        public void onClientsUpdated(List<WifiClient> clients) {
            Log.d(WifiApManager.TAG, "SoftApCallbackAdaptor: onClientsUpdated: Clients=" + clients);
            if (this.mCallback != null) {
                this.mCallback.onClientsUpdated(clients);
            }
        }
    }

    public WifiApManager(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mContext = context;
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public synchronized void registerWifiClientsCallback(WifiClientsCallback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        Log.v(TAG, "registerWifiClientsCallback: callback=" + callback + ", handler=" + handler);
        if (this.mCallBacks.containsKey(callback)) {
            Log.d(TAG, callback + " already registed");
            return;
        }
        if (this.mWifiManager != null) {
            SoftApCallbackAdaptor adaptor = new SoftApCallbackAdaptor(callback);
            this.mWifiManager.registerSoftApCallback(adaptor, handler);
            this.mCallBacks.put(callback, adaptor);
        }
    }

    public synchronized void unregisterWifiClientsCallback(WifiClientsCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        Log.v(TAG, "unregisterWifiClientsCallback: callback=" + callback);
        SoftApCallbackAdaptor adaptor = this.mCallBacks.remove(callback);
        if (adaptor != null && this.mWifiManager != null) {
            this.mWifiManager.unregisterSoftApCallback(adaptor);
        }
    }
}
