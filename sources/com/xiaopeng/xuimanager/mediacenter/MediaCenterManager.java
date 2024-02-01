package com.xiaopeng.xuimanager.mediacenter;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener;
import com.xiaopeng.xuimanager.mediacenter.IBTStatusListener;
import com.xiaopeng.xuimanager.mediacenter.ILyricUpdateListener;
import com.xiaopeng.xuimanager.mediacenter.IMediaCenter;
import com.xiaopeng.xuimanager.mediacenter.IMediaCenterEventListener;
import com.xiaopeng.xuimanager.mediacenter.IModeChangedListener;
import com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener;
import com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener;
import com.xiaopeng.xuimanager.mediacenter.IVisualizerViewEnableListener;
import com.xiaopeng.xuimanager.mediacenter.bluetooth.AvrcpEventListener;
import com.xiaopeng.xuimanager.mediacenter.bluetooth.AvrcpMeteData;
import com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener;
import com.xiaopeng.xuimanager.mediacenter.internal.MediaCenterCmd;
import com.xiaopeng.xuimanager.mediacenter.lyric.ILyricInfoListener;
import com.xiaopeng.xuimanager.mediacenter.lyric.LyricInfo;
import com.xiaopeng.xuimanager.mediacenter.lyric.LyricInfoListener;
import com.xiaopeng.xuimanager.mediacenter.utils.ParamsBuild;
import com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener;
import com.xiaopeng.xuimanager.mediacenter.visualizer.SDVisualizerListener;
import com.xiaopeng.xuimanager.mediacenter.visualizer.TypeVisualizerCaptureObjectListener;
import com.xiaopeng.xuimanager.mediacenter.visualizer.TypeVisualizerData;
import com.xiaopeng.xuimanager.mediacenter.visualizer.VisualCaptureObjectListener;
import com.xiaopeng.xuimanager.mediacenter.visualizer.VisualizerData;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
@SystemApi
/* loaded from: classes.dex */
public class MediaCenterManager implements XUIManagerBase {
    public static final String ACTION_MEDIA_PLAYBACK_CONTROL = "com.xiaopeng.xuiservice.playbackControl";
    public static final int ENTER_PARAMS_BUTTON = 2;
    public static final int ENTER_PARAMS_CURRENT = 0;
    public static final int ENTER_PARAMS_FORCE_XP = 1;
    public static final String EXTRA_PLAYBACK_CMD = "playbackCmd";
    public static final String EXTRA_PLAYBACK_PARAM = "playbackParam";
    public static final int ID_SHARED_PRIMARY = 0;
    public static final int ID_SHARED_SECONDARY = 1;
    public static final int MODE_CAR_SHOW = 1;
    public static final int MODE_NORMAL = 0;
    private static final int MSG_MEDIACENTER_ERROR_EVENT = 0;
    private static final int MSG_PLAYBACK_CONTROL_EVENT = 1;
    private static final int MSG_SET_FAVORITE_EVENT = 3;
    private static final int MSG_SWITCH_SOURCE_EVENT = 2;
    public static final String PACKAGE_BLUETOOTH = "com.android.bluetooth";
    public static final String PACKAGE_XP_MUSIC = "com.xiaopeng.musicradio";
    public static final int PLAYBACK_CMD_ENTER = 11;
    public static final int PLAYBACK_CMD_EXIT = 12;
    public static final int PLAYBACK_CMD_FAVORITE = 8;
    public static final int PLAYBACK_CMD_FORWARD = 14;
    public static final int PLAYBACK_CMD_NEXT = 6;
    public static final int PLAYBACK_CMD_NO_FAVORITE = 16;
    public static final int PLAYBACK_CMD_PAUSE = 2;
    public static final int PLAYBACK_CMD_PREV = 7;
    public static final int PLAYBACK_CMD_RESUME = 3;
    public static final int PLAYBACK_CMD_REWIND = 13;
    public static final int PLAYBACK_CMD_SEEKTO = 4;
    public static final int PLAYBACK_CMD_SET_LYRIC = 10;
    public static final int PLAYBACK_CMD_SET_MODE = 9;
    public static final int PLAYBACK_CMD_SET_TIME = 15;
    public static final int PLAYBACK_CMD_SPEED = 5;
    public static final int PLAYBACK_CMD_START = 0;
    public static final int PLAYBACK_CMD_STOP = 1;
    public static final int PLAYBACK_LYRIC_OFF = 1;
    public static final int PLAYBACK_LYRIC_ON = 0;
    public static final int PLAYBACK_MODE_CYCLE = 1;
    public static final int PLAYBACK_MODE_RANDOM = 3;
    public static final int PLAYBACK_MODE_SEQUENCE = 0;
    public static final int PLAYBACK_MODE_SINGLE_CYCLE = 2;
    public static final int PLAYBACK_STATE_NEW_MEDIASTREAM = 10;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_STARTED = 0;
    public static final int PLAYBACK_STATE_STOPED = 1;
    public static final int SOURCE_TYPE_FM = 1;
    public static final int SOURCE_TYPE_MUSIC = 0;
    public static final int STATE_BT_AVAILABLE = 2;
    public static final int STATE_BT_MEDIA_CONNECTED = 5;
    public static final int STATE_BT_MEDIA_CONNECTING = 4;
    public static final int STATE_BT_MEDIA_DISCONNECTING = 3;
    public static final int STATE_BT_SOURCE_SELECTED = 6;
    public static final int STATE_BT_UNAVAILABLE = 1;
    public static final String TAG = "MediaCenterManager";
    public static final int VISUALIZER_TYPE_AMBIENT_LIGHT = 1;
    public static final int VISUALIZER_TYPE_NONE = 0;
    public static final int VISUALIZER_TYPE_XP_MUSIC = 16;
    private static String mServiceName = null;
    private final Handler mHandler;
    private SDVisualizerListenerToService mSDVisualizerListenerToService;
    private IMediaCenter mService;
    private TypeVisualizerCaptureObjectListener mTypeVisualizerCaptureObjectListener;
    private VisualCaptureObjectListener mVisualCaptureObjectListener;
    private boolean serverDisconnected = false;
    private HashMap<Integer, List<SDVisualizerListener>> mDisplayVisualizers = new HashMap<>();
    private HashMap<String, List<SDVisualizerListener>> mPackageVisualizers = new HashMap<>();
    private final ArraySet<MediaCenterEventListener> mListeners = new ArraySet<>();
    private MediaCenterEventListenerToService mListenerToService = null;
    private final Map<String, VendorControlListener> mVendorControlListeners = new HashMap();
    private PlaybackControlListener mControlListenerToService = null;
    private final ArraySet<VisualCaptureListener> mVisualCaptureListeners = new ArraySet<>();
    private AudioCaptureListener mAudioCaptureListenerToService = null;
    private final ArraySet<PlaybackListener> mPlaybackListeners = new ArraySet<>();
    private PlaybackInfoListener mPlaybackInfoListenerToService = null;
    private final List<VisualizerViewEnableListener> mVisualizerViewEnableListeners = new ArrayList();
    private VisualizerViewEnableServiceListener mVisualizerViewEnableListenerToService = null;
    private List<AvrcpEventListener> mAvrcpEventListenerList = new ArrayList();
    private AvrcpEventListenerToService mAvrcpEventListenerToService = null;
    private SparseArray<List<SDPlaybackListener>> mSDPlaybackListenersMap = new SparseArray<>();
    private List<LyricInfoListener> mLyricInfoListenerList = new ArrayList();
    private LyricInfoListenerToService mLyricInfoListenerToService = null;
    private VisualCaptureListener mNapaListener = new VisualCaptureListener() { // from class: com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.1
        @Override // com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.VisualCaptureListener
        public void OnFftDataCapture(byte[] fft, int samplingRate) {
            if (MediaCenterManager.this.mVisualCaptureObjectListener != null) {
                MediaCenterManager.this.mVisualCaptureObjectListener.OnFftDataCapture(new VisualizerData(fft, samplingRate));
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.VisualCaptureListener
        public void OnRatioData(float ratio, float minRatio) {
        }
    };
    private SDVisualizerListener mSDNapaListener = new SDVisualizerListener() { // from class: com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.2
        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.SDVisualizerListener
        public void onFftDataCapture(int displayId, String pkgName, byte[] fft, int samplingRate) {
            if (MediaCenterManager.this.mTypeVisualizerCaptureObjectListener != null) {
                int typeFlags = 0;
                if (displayId == 0) {
                    typeFlags = 0 | 1;
                }
                if (!TextUtils.isEmpty(pkgName) && (MediaCenterManager.PACKAGE_XP_MUSIC.equals(pkgName) || MediaCenterManager.PACKAGE_BLUETOOTH.equals(pkgName))) {
                    typeFlags |= 16;
                }
                if (typeFlags != 0) {
                    MediaCenterManager.this.mTypeVisualizerCaptureObjectListener.OnFftDataCapture(new TypeVisualizerData(typeFlags, fft, samplingRate));
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.SDVisualizerListener
        public void onRatioData(int displayId, String pkgName, float ratio, float minRatio) {
        }
    };
    private SDVisualizerListener mCompatibleVisualizerListener = new SDVisualizerListener() { // from class: com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.3
        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.SDVisualizerListener
        public void onFftDataCapture(int displayId, String pkgName, byte[] fft, int samplingRate) {
            if (displayId == 0) {
                MediaCenterManager.this.OnFftDataCapture(fft, samplingRate);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.SDVisualizerListener
        public void onRatioData(int displayId, String pkgName, float ratio, float minRatio) {
            if (displayId == 0) {
                MediaCenterManager.this.OnRatioData(ratio, minRatio);
            }
        }
    };
    private List<LyricUpdateListener> mLyricUpdateListeners = new CopyOnWriteArrayList();
    private LyricUpdateServiceListener mLyricUpdateServiceListener = null;
    private final List<ModeChangedListener> mModeChangedListeners = new CopyOnWriteArrayList();
    private ModeChangedServiceListener mModeChangedListenerToService = null;
    private List<BTStatusListener> mBTStatusListeners = new ArrayList();
    private BTStatusListenerToService mBTStatusListenerToService = new BTStatusListenerToService(this);
    private SDPlaybackListener mCompatibleListener = new SDPlaybackListener() { // from class: com.xiaopeng.xuimanager.mediacenter.MediaCenterManager.4
        @Override // com.xiaopeng.xuimanager.mediacenter.SDPlaybackListener
        public void OnPlaybackChanged(int displayId, int playbackStatus) {
            if (displayId == 0) {
                synchronized (MediaCenterManager.this.mPlaybackListeners) {
                    Iterator it = MediaCenterManager.this.mPlaybackListeners.iterator();
                    while (it.hasNext()) {
                        PlaybackListener listener = (PlaybackListener) it.next();
                        listener.OnPlaybackChanged(playbackStatus);
                    }
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.SDPlaybackListener
        public void OnUpdatePosition(int displayId, long position, long duration) {
            if (displayId == 0) {
                synchronized (MediaCenterManager.this.mPlaybackListeners) {
                    Iterator it = MediaCenterManager.this.mPlaybackListeners.iterator();
                    while (it.hasNext()) {
                        PlaybackListener listener = (PlaybackListener) it.next();
                        listener.OnUpdatePosition(position, duration);
                    }
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.SDPlaybackListener
        public void OnMediaInfoNotify(int displayId, MediaInfo info) {
            Log.d(MediaCenterManager.TAG, "mCompatibleListener OnMediaInfoNotify");
            if (displayId == 0) {
                synchronized (MediaCenterManager.this.mPlaybackListeners) {
                    Iterator it = MediaCenterManager.this.mPlaybackListeners.iterator();
                    while (it.hasNext()) {
                        PlaybackListener listener = (PlaybackListener) it.next();
                        listener.OnMediaInfoNotify(info);
                    }
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface BTStatusListener {
        void onBtStatusChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface LyricUpdateListener {
        void onLyricUpdated(String str);
    }

    /* loaded from: classes.dex */
    public interface MediaCenterEventListener {
        void onErrorEvent(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface ModeChangedListener {
        void OnModeChanged(int i);
    }

    /* loaded from: classes.dex */
    public interface PlaybackListener {
        void OnMediaInfoNotify(MediaInfo mediaInfo);

        void OnPlaybackChanged(int i);

        void OnUpdatePosition(long j, long j2);
    }

    /* loaded from: classes.dex */
    public interface VendorControlListener {
        int OnPlaybackControl(int i, int i2);

        int OnSetFavorite(boolean z, String str);

        int OnSwitchSource(int i);
    }

    /* loaded from: classes.dex */
    public interface VisualizerViewEnableListener {
        void OnVisualizerViewEnable(boolean z);
    }

    /* loaded from: classes.dex */
    public interface VisualCaptureListener {
        void OnFftDataCapture(byte[] bArr, int i);

        default void OnRatioData(float ratio, float minRatio) {
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<MediaCenterManager> mMgr;

        EventCallbackHandler(MediaCenterManager mgr, Looper looper) {
            super(looper);
            this.mMgr = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            MediaCenterManager mgr = this.mMgr.get();
            switch (msg.what) {
                case 0:
                    if (mgr != null) {
                        mgr.dispatchErrorEventToClient(((Integer) msg.obj).intValue(), msg.arg1);
                        return;
                    }
                    return;
                case 1:
                    if (mgr != null) {
                        mgr.dispatchControlEventToVendor(msg.arg1, msg.arg2, (String) msg.obj);
                        return;
                    }
                    return;
                case 2:
                    if (mgr != null) {
                        mgr.dispatchSwitchSourceEventToVendor(msg.arg1, (String) msg.obj);
                        return;
                    }
                    return;
                case 3:
                    if (mgr != null) {
                        mgr.dispatchSetFavoriteEventToVendor((FavoriteEvent) msg.obj);
                        return;
                    }
                    return;
                default:
                    Log.d(MediaCenterManager.TAG, "Event type not handled?" + msg);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MediaCenterEventListenerToService extends IMediaCenterEventListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public MediaCenterEventListenerToService(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IMediaCenterEventListener
        public void onError(int errorCode, int operation) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleErrorEvent(errorCode, operation);
            }
        }
    }

    /* loaded from: classes.dex */
    private class PlaybackControlListener extends IPlaybackControlListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;
        private final String mPkgName;

        public PlaybackControlListener(String pkgName, MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
            this.mPkgName = pkgName;
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnPlaybackControl(int cmd, int param) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.handlePlaybackControlEvent(cmd, param, this.mPkgName);
                return 0;
            }
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnSwitchSource(int source) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleSwitchSourceEvent(source, this.mPkgName);
                return 0;
            }
            return 0;
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackControlListener
        public int OnSetFavorite(boolean favorite, String id) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleSetFavoriteEvent(favorite, id, this.mPkgName);
                return 0;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private static class AudioCaptureListener extends IAudioCaptureListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public AudioCaptureListener(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener
        public void OnFftDataCapture(byte[] fft, int samplingRate) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnFftDataCapture(fft, samplingRate);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IAudioCaptureListener
        public void OnRatioData(float ratio, float minRatio) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnRatioData(ratio, minRatio);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SDVisualizerListenerToService extends ISDVisualizerDataListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public SDVisualizerListenerToService(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener
        public void OnFftDataCapture(int displayId, String pkgName, byte[] fft, int samplingRate) throws RemoteException {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnFftDataCapture(displayId, pkgName, fft, samplingRate);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.visualizer.ISDVisualizerDataListener
        public void OnRatioData(int displayId, String pkgName, float ratio, float minRatio) throws RemoteException {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnRatioData(displayId, pkgName, ratio, minRatio);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PlaybackInfoListener extends IPlaybackInfoListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public PlaybackInfoListener(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener.Stub, android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            try {
                return super.onTransact(code, data, reply, flags);
            } catch (RuntimeException exception) {
                Log.e(MediaCenterManager.TAG, "Unexpected exception:" + exception.toString());
                throw exception;
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnPlaybackChanged(int displayId, int status) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnPlaybackChanged(displayId, status);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnUpdatePosition(int displayId, long position, long duration) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnUpdatePosition(displayId, position, duration);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IPlaybackInfoListener
        public void OnMediaInfoNotify(int displayId, MediaInfo info) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnMediaInfoNotify(displayId, info);
            }
        }
    }

    public MediaCenterManager(IBinder service, Context context, Handler handler) {
        this.mService = IMediaCenter.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public void registerListener(MediaCenterEventListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                try {
                    this.mListenerToService = new MediaCenterEventListenerToService(this);
                    this.mService.registerListener(this.mListenerToService);
                } catch (RemoteException ex) {
                    Log.e(TAG, "Could not connect: " + ex.toString());
                    throw new XUIServiceNotConnectedException(ex);
                } catch (IllegalStateException ex2) {
                    XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
                }
            }
            this.mListeners.add(listener);
        }
    }

    public void unregisterListener(MediaCenterEventListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unregisterListener");
        synchronized (this.mListeners) {
            this.mListeners.remove(listener);
            if (this.mListeners.isEmpty()) {
                try {
                    this.mService.unregisterListener(this.mListenerToService);
                    this.mListenerToService = null;
                } catch (RemoteException e) {
                    Log.e(TAG, "Could not unregister: " + e.toString());
                    throw new XUIServiceNotConnectedException(e);
                }
            }
        }
    }

    public synchronized void vendorRegister(Context context) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorRegister");
        try {
            this.mService.vendorRegister();
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public synchronized void vendorUnRegister(Context context) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorUnRegister");
        try {
            this.mService.vendorUnRegister();
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void vendorUpdatePlaybackStatus(int status) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorUpdatePlaybackStatus status:" + status);
        try {
            this.mService.vendorUpdatePlaybackStatus(status);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void vendorUpdatePosition(long position, long duration) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorUpdatePosition position:" + position);
        try {
            this.mService.vendorUpdatePosition(position, duration);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void vendorMediaInfoNotify(MediaInfo info) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorMediaInfoNotify:" + info.toString());
        try {
            this.mService.vendorMediaInfoNotify(info);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void vendorSetControlListener(Context context, VendorControlListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mVendorControlListeners) {
            String pkgName = context.getPackageName();
            if (this.mVendorControlListeners.containsKey(pkgName)) {
                this.mVendorControlListeners.remove(pkgName);
            }
            try {
                this.mService.vendorSetControlListener(pkgName, new PlaybackControlListener(pkgName, this));
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
            this.mVendorControlListeners.put(pkgName, listener);
        }
    }

    public void vendorStartAudioSession(int audioSession, int usage, String pkgName) throws XUIServiceNotConnectedException {
        try {
            this.mService.vendorStartAudioSession(audioSession, usage, pkgName);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
        }
    }

    public void vendorStopAudioSession(int audioSession, String pkgName) throws XUIServiceNotConnectedException {
        try {
            this.mService.vendorStopAudioSession(audioSession, pkgName);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
        }
    }

    public void vendorUnSetControlListener(Context contex, VendorControlListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "vendorUnSetControlListener:");
        synchronized (this.mVendorControlListeners) {
            String pkgName = contex.getPackageName();
            try {
                this.mService.vendorUnSetControlListener(pkgName, null);
                this.mVendorControlListeners.remove(pkgName);
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public synchronized void venderInvoke(Parcel request, Parcel reply) {
    }

    public int getCurrentPlayStatus() throws XUIServiceNotConnectedException {
        return getCurrentPlayStatus(0);
    }

    public int getCurrentPlayStatus(int displayId) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getCurrentPlayStatus(displayId);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            return 1;
        }
    }

    public MediaInfo getCurrentMediaInfo(int displayId) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getCurrentMediaInfo(displayId);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            return null;
        }
    }

    public LyricInfo getCurrentLyricInfo(int displayId) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getCurrentLyricInfo(displayId);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            return null;
        }
    }

    public MediaInfo getCurrentMediaInfo() throws XUIServiceNotConnectedException {
        return getCurrentMediaInfo(0);
    }

    public long[] getCurrentPosition() throws XUIServiceNotConnectedException {
        return getCurrentPosition(0);
    }

    public long[] getCurrentPosition(int displayId) throws XUIServiceNotConnectedException {
        long[] position = {0, 0};
        try {
            return this.mService.getCurrentPosition(displayId);
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            return position;
        }
    }

    public void registerVisualizerListener(VisualCaptureListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mVisualCaptureListeners) {
            if (!this.mVisualCaptureListeners.contains(listener)) {
                this.mVisualCaptureListeners.add(listener);
            }
        }
        registerVisualizerListener(0, this.mCompatibleVisualizerListener);
    }

    public void registerVisualizerListener(int displayId, SDVisualizerListener listener) {
        if (this.mSDVisualizerListenerToService == null) {
            this.mSDVisualizerListenerToService = new SDVisualizerListenerToService(this);
        }
        synchronized (this.mDisplayVisualizers) {
            if (this.mDisplayVisualizers.containsKey(Integer.valueOf(displayId))) {
                List<SDVisualizerListener> listeners = this.mDisplayVisualizers.get(Integer.valueOf(displayId));
                if (!listeners.contains(listener)) {
                    listeners.add(listener);
                }
            } else {
                List<SDVisualizerListener> listenerList = new ArrayList<>();
                listenerList.add(listener);
                this.mDisplayVisualizers.put(Integer.valueOf(displayId), listenerList);
                registerSDVisualizerToService(displayId);
            }
        }
    }

    public void unregisterVisualizerListener(int displayId, SDVisualizerListener listener) {
        synchronized (this.mDisplayVisualizers) {
            if (this.mDisplayVisualizers.containsKey(Integer.valueOf(displayId))) {
                List<SDVisualizerListener> listeners = this.mDisplayVisualizers.get(Integer.valueOf(displayId));
                if (listeners.contains(listener)) {
                    listeners.remove(listener);
                }
                if (listeners.isEmpty()) {
                    this.mDisplayVisualizers.remove(Integer.valueOf(displayId));
                    unregisterSDVisualizerToService(displayId);
                }
            }
        }
    }

    public void registerVisualizerListener(String pkgName, SDVisualizerListener listener) {
        if (this.mSDVisualizerListenerToService == null) {
            this.mSDVisualizerListenerToService = new SDVisualizerListenerToService(this);
        }
        synchronized (this.mPackageVisualizers) {
            if (this.mPackageVisualizers.containsKey(pkgName)) {
                List<SDVisualizerListener> listeners = this.mPackageVisualizers.get(pkgName);
                if (!listeners.contains(listener)) {
                    listeners.add(listener);
                }
            } else {
                List<SDVisualizerListener> listenerList = new ArrayList<>();
                listenerList.add(listener);
                this.mPackageVisualizers.put(pkgName, listenerList);
                registerSDVisualizerToService(pkgName);
            }
        }
    }

    public void unregisterVisualizerListener(String pkgName, SDVisualizerListener listener) {
        synchronized (this.mPackageVisualizers) {
            if (this.mPackageVisualizers.containsKey(pkgName)) {
                List<SDVisualizerListener> listeners = this.mPackageVisualizers.get(pkgName);
                if (listeners.contains(listener)) {
                    listeners.remove(listener);
                }
                if (listeners.isEmpty()) {
                    this.mPackageVisualizers.remove(pkgName);
                    unregisterSDVisualizerToService(pkgName);
                }
            }
        }
    }

    private void registerSDVisualizerToService(int displayId) {
        try {
            this.mService.registerVisualizerListenerWithDisplayId(displayId, this.mSDVisualizerListenerToService);
        } catch (RemoteException ex) {
            Log.e(TAG, "registerVisualizerListenerWithDisplayId error : " + ex.getMessage());
        }
    }

    private void unregisterSDVisualizerToService(int displayId) {
        try {
            this.mService.unRegisterVisualizerListenerWithDisplayId(displayId, this.mSDVisualizerListenerToService);
        } catch (RemoteException ex) {
            Log.e(TAG, "unRegisterVisualizerListenerWithDisplayId error : " + ex.getMessage());
        }
    }

    private void registerSDVisualizerToService(String pkgName) {
        try {
            this.mService.registerVisualizerListenerWithPackage(pkgName, this.mSDVisualizerListenerToService);
        } catch (RemoteException ex) {
            Log.e(TAG, "registerVisualizerListenerWithPackage error : " + ex.getMessage());
        }
    }

    private void unregisterSDVisualizerToService(String pkgName) {
        try {
            this.mService.unRegisterVisualizerListenerWithPackage(pkgName, this.mSDVisualizerListenerToService);
        } catch (RemoteException ex) {
            Log.e(TAG, "unregisterSDVisualizerToService error : " + ex.getMessage());
        }
    }

    public void setVisualCaptureObjectListener(VisualCaptureObjectListener listener) {
    }

    public void setVisualCaptureObjectListener(int typeFlag, TypeVisualizerCaptureObjectListener listener) {
        this.mTypeVisualizerCaptureObjectListener = listener;
        if (this.mTypeVisualizerCaptureObjectListener != null) {
            if ((typeFlag & 1) == 1) {
                registerVisualizerListener(0, this.mSDNapaListener);
            }
            if ((typeFlag & 16) == 16) {
                registerVisualizerListener(PACKAGE_XP_MUSIC, this.mSDNapaListener);
                registerVisualizerListener(PACKAGE_BLUETOOTH, this.mSDNapaListener);
                return;
            }
            return;
        }
        if ((typeFlag & 1) == 1) {
            unregisterVisualizerListener(0, this.mSDNapaListener);
        }
        if ((typeFlag & 16) == 16) {
            unregisterVisualizerListener(PACKAGE_XP_MUSIC, this.mSDNapaListener);
            unregisterVisualizerListener(PACKAGE_BLUETOOTH, this.mSDNapaListener);
        }
    }

    public void unRegisterVisualizerListener(VisualCaptureListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unRegisterVisualizerListener");
        synchronized (this.mVisualCaptureListeners) {
            if (this.mVisualCaptureListeners.contains(listener)) {
                this.mVisualCaptureListeners.remove(listener);
            }
        }
        if (this.mVisualCaptureListeners.isEmpty()) {
            unregisterVisualizerListener(0, this.mCompatibleVisualizerListener);
        }
    }

    public void registerPlaybackListener(PlaybackListener listener) throws XUIServiceNotConnectedException {
        if (this.mPlaybackListeners.isEmpty()) {
            registerPlaybackListener(0, this.mCompatibleListener);
        }
        synchronized (this.mPlaybackListeners) {
            if (!this.mPlaybackListeners.contains(listener)) {
                this.mPlaybackListeners.add(listener);
            }
        }
    }

    public void registerPlaybackListener(int displayId, SDPlaybackListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mSDPlaybackListenersMap) {
            if (listener == null) {
                LogUtil.log(3, TAG, "registerPlaybackListener listener is null");
                throw new IllegalArgumentException("input listener cannot be null");
            }
            if (this.mPlaybackInfoListenerToService == null) {
                this.mPlaybackInfoListenerToService = new PlaybackInfoListener(this);
                if (this.mPlaybackInfoListenerToService != null) {
                    try {
                        this.mService.registerPlaybackInfoListener(this.mPlaybackInfoListenerToService);
                    } catch (RemoteException e) {
                        LogUtil.log(4, TAG, "registerPlaybackListener exception=" + e.getMessage());
                    }
                }
            }
            List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
            if (callbacks == null) {
                callbacks = new ArrayList();
                if (this.mService != null) {
                    try {
                        this.mService.executeCmd(MediaCenterCmd.ADD_MONITOR_DISPLAY, ParamsBuild.getDisplayIdParams(displayId));
                    } catch (RemoteException e2) {
                        LogUtil.log(4, TAG, "registerPlaybackListener exception=" + e2.getMessage());
                    }
                }
            }
            if (!callbacks.contains(listener)) {
                callbacks.add(listener);
                this.mSDPlaybackListenersMap.put(displayId, callbacks);
            }
        }
    }

    public void unRegisterPlaybackListener(PlaybackListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mPlaybackListeners) {
            if (this.mPlaybackListeners.isEmpty()) {
                this.mPlaybackListeners.remove(listener);
            }
        }
        if (this.mPlaybackListeners.isEmpty()) {
            unRegisterPlaybackListener(0, this.mCompatibleListener);
        }
    }

    public void unRegisterPlaybackListener(int displayId, SDPlaybackListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unRegisterPlaybackListener");
        synchronized (this.mSDPlaybackListenersMap) {
            if (listener == null) {
                LogUtil.log(3, TAG, "unRegisterPlaybackListener callback is null");
                throw new IllegalArgumentException("input listener cannot be null");
            }
            List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
            if (callbacks != null && !callbacks.isEmpty() && callbacks.contains(listener)) {
                callbacks.remove(listener);
            }
            if ((callbacks == null || callbacks.isEmpty()) && this.mService != null) {
                try {
                    this.mService.executeCmd(MediaCenterCmd.REMOVE_MONITOR_DISPLAY, ParamsBuild.getDisplayIdParams(displayId));
                } catch (RemoteException e) {
                    LogUtil.log(4, TAG, "unRegisterPlaybackListener exception=" + e.getMessage());
                }
            }
            if (this.mSDPlaybackListenersMap.size() == 0 && this.mPlaybackInfoListenerToService != null) {
                if (this.mService != null) {
                    try {
                        this.mService.unRegisterPlaybackInfoListener(this.mPlaybackInfoListenerToService);
                    } catch (RemoteException e2) {
                        LogUtil.log(4, TAG, "registerListener exception=" + e2.getMessage());
                    }
                }
                this.mPlaybackInfoListenerToService = null;
            }
        }
    }

    public int playbackControl(int playbackCmd, int param) throws XUIServiceNotConnectedException {
        return playbackControl(0, playbackCmd, param);
    }

    public int playbackControl(int displayId, int playbackCmd, int param) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "playbackControl");
        try {
            return this.mService.playbackControl(displayId, playbackCmd, param);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int switchSource(int source) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "switchSource");
        try {
            return this.mService.switchSource(source);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void setSDPosition(int displayId, String packageName) {
        LogUtil.log(1, TAG, "setSDPosition displayId:" + displayId + " &packageName:" + packageName);
        try {
            this.mService.setSDPosition(displayId, packageName);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchErrorEventToClient(int errorCode, int operation) {
        synchronized (this.mListeners) {
            Iterator<MediaCenterEventListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                MediaCenterEventListener l = it.next();
                l.onErrorEvent(errorCode, operation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorEvent(int errorCode, int operation) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = Integer.valueOf(errorCode);
        message.arg1 = operation;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchControlEventToVendor(int cmd, int parm, String pkgName) {
        synchronized (this.mVendorControlListeners) {
            VendorControlListener l = this.mVendorControlListeners.get(pkgName);
            if (l != null) {
                l.OnPlaybackControl(cmd, parm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlaybackControlEvent(int cmd, int parm, String pkgName) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.arg1 = cmd;
        message.arg2 = parm;
        message.obj = pkgName;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSwitchSourceEventToVendor(int source, String pkgName) {
        synchronized (this.mVendorControlListeners) {
            VendorControlListener l = this.mVendorControlListeners.get(pkgName);
            if (l != null) {
                l.OnSwitchSource(source);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSetFavoriteEventToVendor(FavoriteEvent favoriteEvent) {
        synchronized (this.mVendorControlListeners) {
            VendorControlListener l = this.mVendorControlListeners.get(favoriteEvent.mPkgName);
            if (l != null) {
                l.OnSetFavorite(favoriteEvent.mFavorite, favoriteEvent.mId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSwitchSourceEvent(int source, String pkgName) {
        Message message = this.mHandler.obtainMessage();
        message.what = 2;
        message.arg1 = source;
        message.obj = pkgName;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetFavoriteEvent(boolean favorite, String id, String pkgName) {
        Message message = this.mHandler.obtainMessage();
        message.what = 3;
        message.obj = new FavoriteEvent(favorite, id, pkgName);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnFftDataCapture(byte[] fft, int samplingRate) {
        synchronized (this.mVisualCaptureListeners) {
            Iterator<VisualCaptureListener> it = this.mVisualCaptureListeners.iterator();
            while (it.hasNext()) {
                VisualCaptureListener l = it.next();
                l.OnFftDataCapture(fft, samplingRate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnRatioData(float ratio, float minRatio) {
        Collection<VisualCaptureListener> listeners;
        synchronized (this) {
            listeners = this.mVisualCaptureListeners;
        }
        if (!listeners.isEmpty()) {
            for (VisualCaptureListener l : listeners) {
                l.OnRatioData(ratio, minRatio);
            }
            return;
        }
        Log.d(TAG, "Listener died, not dispatching fft data.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnFftDataCapture(int displayId, String pkgName, byte[] fft, int samplingRate) {
        List<SDVisualizerListener> listeners = this.mDisplayVisualizers.get(Integer.valueOf(displayId));
        if (listeners != null && !listeners.isEmpty()) {
            for (SDVisualizerListener listener : listeners) {
                listener.onFftDataCapture(displayId, pkgName, fft, samplingRate);
            }
        }
        List<SDVisualizerListener> pkgListeners = this.mPackageVisualizers.get(pkgName);
        if (pkgListeners != null && !pkgListeners.isEmpty()) {
            for (SDVisualizerListener listener2 : pkgListeners) {
                listener2.onFftDataCapture(displayId, pkgName, fft, samplingRate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnRatioData(int displayId, String pkgName, float ratio, float minRatio) {
        List<SDVisualizerListener> listeners = this.mDisplayVisualizers.get(Integer.valueOf(displayId));
        if (listeners != null && !listeners.isEmpty()) {
            for (SDVisualizerListener listener : listeners) {
                listener.onRatioData(displayId, pkgName, ratio, minRatio);
            }
        }
        List<SDVisualizerListener> pkgListeners = this.mPackageVisualizers.get(pkgName);
        if (pkgListeners != null && !pkgListeners.isEmpty()) {
            for (SDVisualizerListener listener2 : pkgListeners) {
                listener2.onRatioData(displayId, pkgName, ratio, minRatio);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnPlaybackChanged(int displayId, int status) {
        synchronized (this.mSDPlaybackListenersMap) {
            List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
            if (callbacks != null && !callbacks.isEmpty()) {
                for (SDPlaybackListener listener : callbacks) {
                    listener.OnPlaybackChanged(displayId, status);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnUpdatePosition(int displayId, long position, long duration) {
        synchronized (this.mSDPlaybackListenersMap) {
            List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
            if (callbacks != null && !callbacks.isEmpty()) {
                for (SDPlaybackListener listener : callbacks) {
                    listener.OnUpdatePosition(displayId, position, duration);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnMediaInfoNotify(int displayId, MediaInfo info) {
        synchronized (this.mSDPlaybackListenersMap) {
            List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
            if (callbacks != null && !callbacks.isEmpty()) {
                for (SDPlaybackListener listener : callbacks) {
                    listener.OnMediaInfoNotify(displayId, info);
                }
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        Log.e(TAG, "onServerDisconnected!");
        this.serverDisconnected = true;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<MediaCenterEventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            MediaCenterEventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        LogUtil.log(1, TAG, "onXUIConnected");
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mService = IMediaCenter.Stub.asInterface(service);
        try {
            if (this.mPlaybackInfoListenerToService != null) {
                this.mService.registerPlaybackInfoListener(this.mPlaybackInfoListenerToService);
                if (this.mSDPlaybackListenersMap != null && this.mSDPlaybackListenersMap.size() > 0) {
                    for (int displayId = 0; displayId <= 1; displayId++) {
                        List<SDPlaybackListener> callbacks = this.mSDPlaybackListenersMap.get(displayId);
                        if (callbacks != null && !callbacks.isEmpty()) {
                            this.mService.executeCmd(MediaCenterCmd.ADD_MONITOR_DISPLAY, ParamsBuild.getDisplayIdParams(displayId));
                        }
                    }
                }
            }
            if (this.mBTStatusListenerToService != null) {
                this.mService.registerBtStatusListener(this.mBTStatusListenerToService);
            }
            if (this.mAudioCaptureListenerToService != null) {
                this.mService.registerVisualizerListener(this.mAudioCaptureListenerToService);
            }
            if (this.mVisualizerViewEnableListenerToService != null) {
                this.mService.registerVisualizerViewEnableListener(this.mVisualizerViewEnableListenerToService);
            }
            if (this.mAvrcpEventListenerToService != null) {
                this.mService.registerAvrcpEventListener(this.mAvrcpEventListenerToService);
            }
            if (this.mSDVisualizerListenerToService != null) {
                if (!this.mPackageVisualizers.isEmpty()) {
                    for (String pkgName : this.mPackageVisualizers.keySet()) {
                        registerSDVisualizerToService(pkgName);
                    }
                }
                if (!this.mDisplayVisualizers.isEmpty()) {
                    for (Integer num : this.mDisplayVisualizers.keySet()) {
                        int displayId2 = num.intValue();
                        registerSDVisualizerToService(displayId2);
                    }
                }
            }
        } catch (RemoteException e) {
            Log.e(TAG, "registerListenerToService e=" + e);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void OnVisualizerViewEnable(boolean enable) {
        if (!this.mVisualizerViewEnableListeners.isEmpty()) {
            for (VisualizerViewEnableListener l : this.mVisualizerViewEnableListeners) {
                l.OnVisualizerViewEnable(enable);
            }
            return;
        }
        Log.d(TAG, "mVisualizerViewEnableListeners is empty");
    }

    public void setVisualizerViewEnable(boolean enable) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "setVisualizerViewEnable");
        try {
            this.mService.setVisualizerViewEnable(enable);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void registerVisualizerViewEnableListener(VisualizerViewEnableListener listener) throws XUIServiceNotConnectedException {
        if (this.mVisualizerViewEnableListeners.isEmpty()) {
            try {
                this.mVisualizerViewEnableListenerToService = new VisualizerViewEnableServiceListener(this);
                this.mService.registerVisualizerViewEnableListener(this.mVisualizerViewEnableListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        if (!this.mVisualizerViewEnableListeners.contains(listener)) {
            this.mVisualizerViewEnableListeners.add(listener);
        }
    }

    public void unRegisterVisualizerViewEnableListener(VisualizerViewEnableListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unRegisterVisualizerViewEnableListener");
        if (this.mVisualizerViewEnableListeners.contains(listener)) {
            this.mVisualizerViewEnableListeners.remove(listener);
        }
        if (this.mVisualizerViewEnableListeners.isEmpty()) {
            try {
                this.mService.unRegisterVisualizerViewEnableListener(this.mVisualizerViewEnableListenerToService);
                this.mVisualizerViewEnableListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class VisualizerViewEnableServiceListener extends IVisualizerViewEnableListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public VisualizerViewEnableServiceListener(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IVisualizerViewEnableListener
        public void onVisualizerViewEnable(boolean enable) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.OnVisualizerViewEnable(enable);
            }
        }
    }

    public void notifyLyricUpdate(String lyric) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "notifyLyricUpdate");
        try {
            this.mService.notifyLyricUpdate(lyric);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void vendorNotifyLyricUpdated(LyricInfo info) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "notifyLyricInfoUpdated");
        try {
            this.mService.notifyLyricInfoUpdated(info);
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void registerLyricUpdateListener(LyricUpdateListener listener) throws XUIServiceNotConnectedException {
        if (this.mLyricUpdateListeners.isEmpty()) {
            try {
                this.mLyricUpdateServiceListener = new LyricUpdateServiceListener(this);
                this.mService.registerLyricUpdateListener(this.mLyricUpdateServiceListener);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        if (!this.mLyricUpdateListeners.contains(listener)) {
            this.mLyricUpdateListeners.add(listener);
        }
    }

    public void registerLyricInfoListener(LyricInfoListener listener) throws XUIServiceNotConnectedException {
        synchronized (this.mLyricInfoListenerList) {
            if (this.mLyricInfoListenerList.isEmpty()) {
                try {
                    this.mLyricInfoListenerToService = new LyricInfoListenerToService(this);
                    this.mService.registerLyricInfoListener(this.mLyricInfoListenerToService);
                } catch (RemoteException ex) {
                    Log.e(TAG, "Could not connect: " + ex.toString());
                    throw new XUIServiceNotConnectedException(ex);
                } catch (IllegalStateException ex2) {
                    XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
                }
            }
            if (!this.mLyricInfoListenerList.contains(listener)) {
                this.mLyricInfoListenerList.add(listener);
            }
        }
    }

    public void unRegisterLyricUpdateListener(LyricUpdateListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unRegisterLyricUpdateListener");
        if (this.mLyricUpdateListeners.contains(listener)) {
            this.mLyricUpdateListeners.remove(listener);
        }
        if (this.mLyricUpdateListeners.isEmpty()) {
            try {
                this.mService.unRegisterLyricUpdateListener(this.mLyricUpdateServiceListener);
                this.mLyricUpdateServiceListener = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public void unregisterLyricInfoListener(LyricInfoListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unregisterLyricInfoListener");
        synchronized (this.mLyricInfoListenerList) {
            if (this.mLyricInfoListenerList.contains(listener)) {
                this.mLyricInfoListenerList.remove(listener);
            }
        }
        if (this.mLyricInfoListenerList.isEmpty()) {
            try {
                this.mService.unregisterLyricInfoListener(this.mLyricInfoListenerToService);
                this.mLyricInfoListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onServiceLyricUpdated(String lyric) {
        if (!this.mLyricUpdateListeners.isEmpty()) {
            for (LyricUpdateListener l : this.mLyricUpdateListeners) {
                l.onLyricUpdated(lyric);
            }
            return;
        }
        Log.d(TAG, "mLyricUpdateListeners is empty");
    }

    /* loaded from: classes.dex */
    private static class LyricUpdateServiceListener extends ILyricUpdateListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public LyricUpdateServiceListener(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.ILyricUpdateListener
        public void onLyricUpdated(String lyric) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onServiceLyricUpdated(lyric);
            }
        }
    }

    public void registerModeChangedListener(ModeChangedListener listener) throws XUIServiceNotConnectedException {
        if (this.mModeChangedListeners.isEmpty()) {
            try {
                this.mModeChangedListenerToService = new ModeChangedServiceListener(this);
                this.mService.registerModeChangedListener(this.mModeChangedListenerToService);
            } catch (RemoteException ex) {
                Log.e(TAG, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        if (!this.mModeChangedListeners.contains(listener)) {
            this.mModeChangedListeners.add(listener);
        }
    }

    public void unRegisterModeChangedListener(ModeChangedListener listener) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "unRegisterModeChangedListener");
        if (this.mModeChangedListeners.contains(listener)) {
            this.mModeChangedListeners.remove(listener);
        }
        if (this.mModeChangedListeners.isEmpty()) {
            try {
                this.mService.unRegisterModeChangedListener(this.mModeChangedListenerToService);
                this.mModeChangedListenerToService = null;
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public int getCurrentMode() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getCurrentMode();
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        } catch (IllegalStateException ex2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private static class ModeChangedServiceListener extends IModeChangedListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public ModeChangedServiceListener(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IModeChangedListener
        public void onModeChanged(int currentMode) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.notifyClientModeChanged(currentMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClientModeChanged(int currentMode) {
        if (!this.mModeChangedListeners.isEmpty()) {
            for (ModeChangedListener l : this.mModeChangedListeners) {
                l.OnModeChanged(currentMode);
            }
            return;
        }
        Log.d(TAG, "mModeChangedListeners is empty");
    }

    /* loaded from: classes.dex */
    private static class BTStatusListenerToService extends IBTStatusListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public BTStatusListenerToService(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.IBTStatusListener
        public void onBtStatusChanged(int status) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.notifyBtStatusChanged(status);
            }
        }
    }

    public synchronized void registerBtStatusListener(BTStatusListener listener) throws XUIServiceNotConnectedException {
        if (this.mBTStatusListeners.isEmpty()) {
            try {
                try {
                    Log.d(TAG, "registerBtStatusListener");
                    this.mService.registerBtStatusListener(this.mBTStatusListenerToService);
                } catch (RemoteException ex) {
                    Log.e(TAG, "Could not connect: " + ex.toString());
                    throw new XUIServiceNotConnectedException(ex);
                }
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        if (!this.mBTStatusListeners.contains(listener)) {
            Log.d(TAG, "registerBtStatusListener add listener:" + listener);
            this.mBTStatusListeners.add(listener);
        }
    }

    public synchronized void unRegisterBtStatusListener(BTStatusListener listener) throws XUIServiceNotConnectedException {
        if (this.mBTStatusListeners.contains(listener)) {
            Log.d(TAG, "unRegisterBtStatusListener remove listener:" + listener);
            this.mBTStatusListeners.remove(listener);
        }
        if (this.mBTStatusListeners.isEmpty()) {
            try {
                Log.d(TAG, "unRegisterBtStatusListener");
                this.mService.unRegisterBtStatusListener(this.mBTStatusListenerToService);
            } catch (RemoteException e) {
                Log.e(TAG, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    public synchronized void playBtMedia() throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                this.mService.playBtMedia();
            } catch (RemoteException e) {
                Log.e(TAG, "playBtMedia error");
            }
        }
    }

    public synchronized void pauseBtMedia() throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                this.mService.pauseBtMedia();
            } catch (RemoteException e) {
                Log.e(TAG, "pauseBtMedia error");
            }
        }
    }

    public synchronized boolean isBtDeviceAvailable() throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                int status = this.mService.getBtStatus();
                return status >= 2;
            } catch (RemoteException e) {
                Log.e(TAG, "isBtDeviceAvailable error");
            }
        }
        return false;
    }

    public synchronized boolean isBtSourceSelected() throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                int status = this.mService.getBtStatus();
                return status == 6;
            } catch (RemoteException e) {
                Log.e(TAG, "isBtSourceSelected error");
            }
        }
        return false;
    }

    public synchronized int getBtStatus() throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                return this.mService.getBtStatus();
            } catch (RemoteException e) {
                Log.e(TAG, "getBtStatus error");
            }
        }
        return 1;
    }

    public synchronized void setBtVolume(float volume) throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                this.mService.setBtVolume(volume);
            } catch (RemoteException e) {
                Log.e(TAG, "setBtVolume error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBtStatusChanged(int status) {
        Log.d(TAG, "notifyBtStatusChanged status:" + status + "&listener size:" + this.mBTStatusListeners.size());
        if (this.mBTStatusListeners.size() > 0) {
            for (BTStatusListener btStatusListener : this.mBTStatusListeners) {
                btStatusListener.onBtStatusChanged(status);
            }
        }
    }

    public synchronized void setFavorite(boolean favorite, String id) throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                this.mService.setFavorite(favorite, id);
            } catch (RemoteException e) {
                Log.e(TAG, "setFavorite error");
            }
        }
    }

    public synchronized void setFavorite(String songId, boolean favorite, int displayId) throws XUIServiceNotConnectedException {
        if (this.mService != null) {
            try {
                Bundle extras = new Bundle();
                extras.putString("songId", songId);
                extras.putBoolean("favorite", favorite);
                extras.putInt("displayId", displayId);
                this.mService.favorSong(extras);
            } catch (RemoteException e) {
                Log.e(TAG, "favorSong error");
            }
        }
    }

    public void requestMediaButton(boolean request, Bundle extras) {
        if (this.mService != null) {
            try {
                this.mService.requestMediaButton(request, extras);
            } catch (RemoteException e) {
                Log.e(TAG, "requestMediaButton exception");
            }
        }
    }

    public void avrcpPlay() {
        if (this.mService != null) {
            try {
                this.mService.avrcpPlay();
            } catch (RemoteException e) {
                Log.e(TAG, "avrcpPlay error");
            }
        }
    }

    public void avrcpPause() {
        if (this.mService != null) {
            try {
                this.mService.avrcpPause();
            } catch (RemoteException e) {
                Log.e(TAG, "avrcpPause error");
            }
        }
    }

    public void avrcpNext() {
        if (this.mService != null) {
            try {
                this.mService.avrcpNext();
            } catch (RemoteException e) {
                Log.e(TAG, "avrcpNext error:" + e.getMessage());
            }
        }
    }

    public void avrcpPrevious() {
        if (this.mService != null) {
            try {
                this.mService.avrcpPrevious();
            } catch (RemoteException e) {
                Log.e(TAG, "avrcpPrevious error:" + e.getMessage());
            }
        }
    }

    public AvrcpMeteData getAvrcpMeteData() {
        if (this.mService != null) {
            try {
                return this.mService.getAvrcpMeteData();
            } catch (RemoteException e) {
                Log.e(TAG, "getAvrcpMeteData error: " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public int getAvrcpPlayStatus() {
        try {
            return this.mService.getAvrcpPlayStatus();
        } catch (RemoteException e) {
            Log.e(TAG, "getAvrcpPlayStatus error:" + e.getMessage());
            return 1;
        }
    }

    public long[] getAvrcpPosition() {
        long[] position = {0, 0};
        try {
            return this.mService.getAvrcpPosition();
        } catch (RemoteException e) {
            Log.e(TAG, "getAvrcpPosition error:" + e.getMessage());
            return position;
        }
    }

    public void registerAvrcpEventListener(AvrcpEventListener listener) {
        synchronized (this.mAvrcpEventListenerList) {
            if (this.mAvrcpEventListenerList.isEmpty() && this.mAvrcpEventListenerToService == null) {
                this.mAvrcpEventListenerToService = new AvrcpEventListenerToService(this);
                if (this.mService != null) {
                    try {
                        this.mService.registerAvrcpEventListener(this.mAvrcpEventListenerToService);
                    } catch (RemoteException e) {
                        Log.e(TAG, "registerAvrcpEventListener error:" + e.getMessage());
                    }
                }
            }
            if (!this.mAvrcpEventListenerList.contains(listener)) {
                this.mAvrcpEventListenerList.add(listener);
            }
        }
    }

    public void unRegisterAvrcpEventListener(AvrcpEventListener listener) {
        synchronized (this.mAvrcpEventListenerList) {
            this.mAvrcpEventListenerList.remove(listener);
            if (this.mAvrcpEventListenerList.isEmpty() && this.mService != null) {
                try {
                    this.mService.unRegisterAvrcpEventListener(this.mAvrcpEventListenerToService);
                } catch (RemoteException e) {
                    Log.e(TAG, "unRegisterAvrcpEventListener error:" + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAvrcpConnectedChanged(int prevState, int newState) {
        synchronized (this.mAvrcpEventListenerList) {
            for (AvrcpEventListener listener : this.mAvrcpEventListenerList) {
                listener.onConnectedChanged(prevState, newState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAvrcpPlaybackChanged(int playStatus) {
        synchronized (this.mAvrcpEventListenerList) {
            for (AvrcpEventListener listener : this.mAvrcpEventListenerList) {
                listener.onPlaybackChanged(playStatus);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAvrcpPositionChanged(long position, long duration) {
        synchronized (this.mAvrcpEventListenerList) {
            for (AvrcpEventListener listener : this.mAvrcpEventListenerList) {
                listener.onPositionChanged(position, duration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAvrcpMeteDataChanged(AvrcpMeteData meteData) {
        synchronized (this.mAvrcpEventListenerList) {
            for (AvrcpEventListener listener : this.mAvrcpEventListenerList) {
                listener.onMeteDataChanged(meteData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLyricInfoUpdated(int displayId, LyricInfo lyricInfo) {
        synchronized (this.mLyricInfoListenerList) {
            for (LyricInfoListener listener : this.mLyricInfoListenerList) {
                listener.onLyricInfoUpdated(displayId, lyricInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    private class AvrcpEventListenerToService extends IAvrcpEventListener.Stub {
        private final String TAG = MediaCenterManager.TAG + AvrcpEventListenerToService.class.getSimpleName();
        private final WeakReference<MediaCenterManager> mManager;

        public AvrcpEventListenerToService(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onConnectedChanged(int prevState, int newState) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onAvrcpConnectedChanged(prevState, newState);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onPlaybackChanged(int playStatus) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onAvrcpPlaybackChanged(playStatus);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onPositionChanged(long position, long duration) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onAvrcpPositionChanged(position, duration);
            }
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.bluetooth.IAvrcpEventListener
        public void onMeteDataChanged(AvrcpMeteData meteData) {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onAvrcpMeteDataChanged(meteData);
            }
        }
    }

    /* loaded from: classes.dex */
    private class LyricInfoListenerToService extends ILyricInfoListener.Stub {
        private final WeakReference<MediaCenterManager> mManager;

        public LyricInfoListenerToService(MediaCenterManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.mediacenter.lyric.ILyricInfoListener
        public void onLyricInfoUpdated(int displayId, LyricInfo lyricInfo) throws RemoteException {
            MediaCenterManager manager = this.mManager.get();
            if (manager != null) {
                manager.onLyricInfoUpdated(displayId, lyricInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public class FavoriteEvent {
        public boolean mFavorite;
        public String mId;
        public String mPkgName;

        public FavoriteEvent(boolean favorite, String id, String pkgName) {
            this.mFavorite = favorite;
            this.mId = id;
            this.mPkgName = pkgName;
        }
    }
}
