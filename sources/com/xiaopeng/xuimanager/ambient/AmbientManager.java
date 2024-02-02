package com.xiaopeng.xuimanager.ambient;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.ambient.IAmbient;
import com.xiaopeng.xuimanager.ambient.IAmbientEventListener;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
@SystemApi
/* loaded from: classes.dex */
public class AmbientManager implements XUIManagerBase {
    public static final int MSG_BRIGHT = 6;
    public static final int MSG_COLORTYPE = 7;
    public static final int MSG_DOUBLECOLOR = 9;
    public static final int MSG_ENABLE = 1;
    public static final int MSG_ERR_EFFECT = 13;
    public static final int MSG_ERR_MODE = 14;
    public static final int MSG_MONOCOLOR = 8;
    public static final int MSG_PLAY = 2;
    public static final int MSG_REGIONBRIGHT = 12;
    public static final int MSG_REGIONCOLOR = 11;
    public static final int MSG_REQUEST = 0;
    public static final int MSG_SETMODE = 4;
    public static final int MSG_STOP = 3;
    public static final int MSG_SUBMODE = 5;
    public static final int MSG_THEMECOLOR = 10;
    public static final String TAG = "AmbientManager";
    private static final ArraySet<EventListener> mListeners = new ArraySet<>();
    private static String mServiceName = null;
    private final Handler mHandler;
    private AmbientLightListenerToService mListenerToService = null;
    private IAmbient mService;

    /* loaded from: classes.dex */
    public interface EventListener {
        default void onRequestAmbientLight(boolean apply) {
        }

        default void onChangeAmbientLightEnable(boolean enable) {
        }

        default void onPlayEffect(String partition, String effect) {
        }

        default void onStopEffect(String partition, String effect) {
        }

        default void onErrorPlay(String partition, String effect) {
        }

        default void onErrorStop(String partition, String effect) {
        }

        default void onAddMode(String partition, String mode) {
        }

        default void onSubMode(String partition, String mode) {
        }

        default void onChangeMode(String partition, String mode) {
        }

        default void onErrorSet(String partition, String mode) {
        }

        default void onErrorSub(String partition, String mode) {
        }

        default void onChangeBright(String partition, int bright) {
        }

        default void onChangeColorType(String partition, String type) {
        }

        default void onChangeMonoColor(String partition, Color color) {
        }

        default void onChangeDoubleColor(String partition, Pair<Color, Color> color) {
        }

        default void onChangeThemeColor(String partition, String theme) {
        }

        default void onChangeRegionColor(String partition, String region, Color color) {
        }

        default void onChangeRegionBright(String partition, String region, int bright) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AmbientMessage {
        private int data;
        private String sdata;
        private String sdata2;

        public AmbientMessage(String sdata, String sdata2, int data) {
            this.sdata = sdata;
            this.sdata2 = sdata2;
            this.data = data;
        }
    }

    protected static int parseColor(Color color) {
        if (color == null) {
            return -1;
        }
        return !color.hasRgb ? color.predef : 16777216 | (color.rgb.red << 16) | (color.rgb.green << 8) | color.rgb.blue;
    }

    protected static Color makeColor(int data) {
        return ((data >>> 24) & 1) == 0 ? new Color(data) : new Color((data >> 16) & 255, (data >> 8) & 255, data & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAmbientLightEvent(int msg, String sdata, String sdata2, int data) {
        Message message = this.mHandler.obtainMessage();
        message.what = msg;
        message.obj = new AmbientMessage(sdata, sdata2, data);
        this.mHandler.sendMessage(message);
    }

    /* loaded from: classes.dex */
    private static class AmbientLightListenerToService extends IAmbientEventListener.Stub {
        private final WeakReference<AmbientManager> mManager;

        public AmbientLightListenerToService(AmbientManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.ambient.IAmbientEventListener
        public void onAmbientLightEvent(int type, String sdata, String sdata2, int data) {
            AmbientManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleAmbientLightEvent(type, sdata, sdata2, data);
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Log.i(TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        Log.i(TAG, "onXUIConnected");
        this.mService = IAmbient.Stub.asInterface(service);
        if (!mListeners.isEmpty()) {
            try {
                if (this.mListenerToService == null) {
                    this.mListenerToService = new AmbientLightListenerToService(this);
                }
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect to XUI: " + ex.toString());
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        mServiceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        if (mServiceName == null) {
            mServiceName = getClass().getSimpleName();
        }
        return mServiceName;
    }

    public synchronized void registerListener(EventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "registerListener");
        if (mListeners.isEmpty()) {
            try {
                this.mListenerToService = new AmbientLightListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException e) {
                Log.e(TAG, "Could not connect: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            } catch (IllegalStateException e2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
            }
        }
        mListeners.add(listener);
    }

    public synchronized void unregisterListener(EventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
        mListeners.remove(listener);
        if (mListeners.isEmpty()) {
            try {
                this.mService.unregisterListener(this.mListenerToService);
                this.mListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public int requestAmbientLightPermission(boolean apply) throws XUIServiceNotConnectedException {
        try {
            return this.mService.requestAmbientLightPermission(apply);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not requestAmbientLightPermission: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightEnable(boolean enable) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean getAmbientLightEnable() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightEnable();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightEffectPartitions() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightEffectPartitions());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightEffectPartitions: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightEffects() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightEffects());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightEffects: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int playAmbientLightEffect(String partition, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.playAmbientLightEffect(partition, effect, false);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not playAmbientLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int playAmbientLightEffect(String partition, AmbientEffect effect) throws XUIServiceNotConnectedException {
        if (effect == null) {
            return -1;
        }
        try {
            return this.mService.playAmbientLightEffect(partition, effect.toJson(), true);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not playAmbientLightEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopAmbientLightEffect() throws XUIServiceNotConnectedException {
        try {
            return this.mService.stopAmbientLightEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightModePartitions() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightModePartitions());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightModePartitions: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightModes() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightModes());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightModes: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightMode(String partition, String mode) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightMode(partition, mode);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int subAmbientLightMode(String partition, String mode) throws XUIServiceNotConnectedException {
        try {
            return this.mService.subAmbientLightMode(partition, mode);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not subAmbientLightMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getAmbientLightMode(String partition) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightMode(partition);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightMode: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Map<String, String> getAmbientLightPartitionModes() throws XUIServiceNotConnectedException {
        try {
            String mapString = this.mService.getAmbientLightPartitionModes();
            return mapString == null ? new ArrayMap() : (Map) Arrays.stream(mapString.split(",")).map(new Function() { // from class: com.xiaopeng.xuimanager.ambient.-$$Lambda$AmbientManager$zedhs6MCQubQHdFIA5jZgdT75GE
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String[] split;
                    split = ((String) obj).split("=");
                    return split;
                }
            }).collect(Collectors.toMap(new Function() { // from class: com.xiaopeng.xuimanager.ambient.-$$Lambda$AmbientManager$-PWnqQTpKiYQ5ViMeJmbEouJH_4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AmbientManager.lambda$getAmbientLightPartitionModes$1((String[]) obj);
                }
            }, new Function() { // from class: com.xiaopeng.xuimanager.ambient.-$$Lambda$AmbientManager$TkwJe-05xrzjBrrpjF5c08xhlsc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AmbientManager.lambda$getAmbientLightPartitionModes$2((String[]) obj);
                }
            }));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightPartitionModes: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$getAmbientLightPartitionModes$1(String[] s) {
        return s[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$getAmbientLightPartitionModes$2(String[] s) {
        return s[1];
    }

    public int setAmbientLightBright(String partition, int bright) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightBright(partition, bright);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightBright(String partition) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightBright(partition);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightColorTypes() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightColorTypes());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightColorTypes: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightColorType(String partition, String colorType) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightColorType(partition, colorType);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightColorType: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getAmbientLightColorType(String partition) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightColorType(partition);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightColorType: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightMonoColor(String partition, Color color) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightMonoColor(partition, parseColor(color));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightMonoColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Color getAmbientLightMonoColor(String partition) throws XUIServiceNotConnectedException {
        try {
            return makeColor(this.mService.getAmbientLightMonoColor(partition));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightMonoColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightDoubleColor(String partition, Pair<Color, Color> color) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightDoubleColor(partition, parseColor((Color) color.first), parseColor((Color) color.second));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightDoubleColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Pair<Color, Color> getAmbientLightDoubleColor(String partition) throws XUIServiceNotConnectedException {
        try {
            List<Integer> res = (List) this.mService.getAmbientLightDoubleColor(partition).stream().map(new Function() { // from class: com.xiaopeng.xuimanager.ambient.-$$Lambda$AmbientManager$JWLUSa4hQWAZf1TfuyVGazguidI
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int parseInt;
                    parseInt = Integer.parseInt((String) obj);
                    return Integer.valueOf(parseInt);
                }
            }).collect(Collectors.toList());
            return new Pair<>(makeColor(res.get(0).intValue()), makeColor(res.get(1).intValue()));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightDoubleColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightThemesColor() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightThemesColor());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightThemesColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightThemeColor(String partition, String themeColor) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightThemeColor(partition, themeColor);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightThemeColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getAmbientLightThemeColor(String partition) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightThemeColor(partition);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightThemeColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showAmbientLightRegions() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showAmbientLightRegions());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showAmbientLightRegions: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightRegionColor(String partition, String region, Color color) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightRegionColor(partition, region, parseColor(color));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightRegionColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Color getAmbientLightRegionColor(String partition, String region) throws XUIServiceNotConnectedException {
        try {
            return makeColor(this.mService.getAmbientLightRegionColor(partition, region));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightRegionColor: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setAmbientLightRegionBright(String partition, String region, int bright) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setAmbientLightRegionBright(partition, region, bright);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setAmbientLightRegionBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getAmbientLightRegionBright(String partition, String region) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getAmbientLightRegionBright(partition, region);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getAmbientLightRegionBright: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<AmbientManager> mManager;

        EventCallbackHandler(AmbientManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Collection<EventListener> listeners;
            AmbientMessage message = (AmbientMessage) msg.obj;
            synchronized (this) {
                listeners = AmbientManager.mListeners;
            }
            if (!listeners.isEmpty()) {
                for (EventListener l : listeners) {
                    switch (msg.what) {
                        case 0:
                            l.onRequestAmbientLight(message.data == 1);
                            break;
                        case 1:
                            l.onChangeAmbientLightEnable(message.data == 1);
                            break;
                        case 2:
                            l.onPlayEffect(message.sdata, message.sdata2);
                            break;
                        case 3:
                            l.onStopEffect(message.sdata, message.sdata2);
                            break;
                        case 4:
                            if (message.data == 0) {
                                l.onChangeMode(message.sdata, message.sdata2);
                                break;
                            } else {
                                l.onAddMode(message.sdata, message.sdata2);
                                break;
                            }
                        case 5:
                            l.onSubMode(message.sdata, message.sdata2);
                            break;
                        case 6:
                            l.onChangeBright(message.sdata, message.data);
                            break;
                        case 7:
                            l.onChangeColorType(message.sdata, message.sdata2);
                            break;
                        case 8:
                            l.onChangeMonoColor(message.sdata, AmbientManager.makeColor(message.data));
                            break;
                        case 9:
                            l.onChangeDoubleColor(message.sdata, new Pair<>(AmbientManager.makeColor(Integer.valueOf(message.sdata2).intValue()), AmbientManager.makeColor(message.data)));
                            break;
                        case 10:
                            l.onChangeThemeColor(message.sdata, message.sdata2);
                            break;
                        case 11:
                            l.onChangeRegionColor(message.sdata, message.sdata2, AmbientManager.makeColor(message.data));
                            break;
                        case 12:
                            l.onChangeRegionBright(message.sdata, message.sdata2, message.data);
                            break;
                        case 13:
                            if (message.data == 2) {
                                l.onErrorPlay(message.sdata, message.sdata2);
                                break;
                            } else if (message.data == 3) {
                                l.onErrorStop(message.sdata, message.sdata2);
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (message.data == 4) {
                                l.onErrorSet(message.sdata, message.sdata2);
                                break;
                            } else if (message.data == 5) {
                                l.onErrorSub(message.sdata, message.sdata2);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
    }

    public AmbientManager(IBinder service, Context context, Handler handler) {
        this.mService = IAmbient.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }
}
