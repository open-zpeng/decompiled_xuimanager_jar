package com.xiaopeng.xuimanager.seatmassager;

import android.annotation.SystemApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.seatmassager.ISeatMassager;
import com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SystemApi
/* loaded from: classes.dex */
public class SeatMassagerManager implements XUIManagerBase {
    public static final int EFFECT = 2;
    public static final int ERROR = 8;
    public static final int INTENSITY = 3;
    public static final int LOAD = 7;
    private static final int MSG_MASSAGER = 0;
    private static final int MSG_VIBRATE = 1;
    public static final int RHYTHM_INTENSITY = 5;
    public static final int RHYTHM_PATTERN = 6;
    public static final int RHYTHM_STATUS = 4;
    public static final int START = 0;
    public static final int STOP = 1;
    public static final String TAG = "SeatMassagerManager";
    private static String mServiceName = null;
    private final Handler mHandler;
    private ISeatMassager mService;
    private final ArraySet<EventListener> mListeners = new ArraySet<>();
    private SeatMassagerListenerToService mListenerToService = null;

    /* loaded from: classes.dex */
    public interface EventListener {
        default void onStartMassager(int id, String effect, int intensity) {
        }

        default void onStopMassager(int id, String effect, int intensity) {
        }

        default void onErrorMassager(int id, String effect, int opCode, int errCode) {
        }

        default void onChangeEffectMassager(int id, String effect) {
        }

        default void onChangeIntensityMassager(int id, int intensity) {
        }

        default void onLoadVibrate(String effect, boolean result) {
        }

        default void onStartVibrate(Set<Integer> ids, String effect, int position) {
        }

        default void onStopVibrate(Set<Integer> ids, String effect, int position) {
        }

        default void onChangeIntensityVibrate(Set<Integer> ids, int intensity) {
        }

        default void onErrorVibrate(Set<Integer> ids, String effect, int opCode, int errCode) {
        }

        default void onChangeIntensityRhythm(Set<Integer> ids, int intensity) {
        }

        default void onChangeStatusRhythm(Set<Integer> ids, boolean enable) {
        }

        default void onChangePatternRhythm(int pattern) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MassagerMessage {
        public int data;
        public String effect;
        public int id;
        public int type;

        public MassagerMessage(int id, int type, String effect, int data) {
            this.id = id;
            this.type = type;
            this.effect = effect;
            this.data = data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class VibrateMessage {
        public int data;
        public String effect;
        public Set<Integer> ids;
        public int type;

        public VibrateMessage(Set<Integer> ids, int type, String effect, int data) {
            this.ids = ids;
            this.type = type;
            this.effect = effect;
            this.data = data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMassagerToClient(MassagerMessage message) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                if (message.type == 0) {
                    l.onStartMassager(message.id, message.effect, message.data);
                } else if (message.type == 1) {
                    l.onStopMassager(message.id, message.effect, message.data);
                } else if (message.type == 8) {
                    l.onErrorMassager(message.id, message.effect, message.data >> 4, -(message.data & 15));
                } else if (message.type == 2) {
                    l.onChangeEffectMassager(message.id, message.effect);
                } else if (message.type == 3) {
                    l.onChangeIntensityMassager(message.id, message.data);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchVibrateToClient(VibrateMessage message) {
        Collection<EventListener> listeners;
        synchronized (this) {
            listeners = this.mListeners;
        }
        if (!listeners.isEmpty()) {
            for (EventListener l : listeners) {
                if (message.type == 0) {
                    l.onStartVibrate(message.ids, message.effect, message.data);
                } else if (message.type == 1) {
                    l.onStopVibrate(message.ids, message.effect, message.data);
                } else if (message.type == 7) {
                    l.onLoadVibrate(message.effect, message.data != 0);
                } else if (message.type == 8) {
                    l.onErrorVibrate(message.ids, message.effect, message.data >> 4, -(message.data & 15));
                } else if (message.type == 3) {
                    l.onChangeIntensityVibrate(message.ids, message.data);
                } else if (message.type == 4) {
                    l.onChangeStatusRhythm(message.ids, message.data != 0);
                } else if (message.type == 5) {
                    l.onChangeIntensityRhythm(message.ids, message.data);
                } else if (message.type == 6) {
                    l.onChangePatternRhythm(message.data);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMassagerEvent(int id, int type, String effect, int data) {
        Message message = this.mHandler.obtainMessage();
        message.what = 0;
        message.obj = new MassagerMessage(id, type, effect, data);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVibrateEvent(Set<Integer> ids, int type, String effect, int data) {
        Message message = this.mHandler.obtainMessage();
        message.what = 1;
        message.obj = new VibrateMessage(ids, type, effect, data);
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SeatMassagerListenerToService extends ISeatMassagerEventListener.Stub {
        private final WeakReference<SeatMassagerManager> mManager;

        public SeatMassagerListenerToService(SeatMassagerManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
        public void onMassagerEvent(int id, int type, String effect, int data) {
            SeatMassagerManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleMassagerEvent(id, type, effect, data);
            }
        }

        @Override // com.xiaopeng.xuimanager.seatmassager.ISeatMassagerEventListener
        public void onVibrateEvent(List<String> ids, int type, String effect, int data) {
            SeatMassagerManager manager = this.mManager.get();
            if (manager != null) {
                Set<Integer> intIds = (Set) ids.stream().map(new Function() { // from class: com.xiaopeng.xuimanager.seatmassager.-$$Lambda$JWLUSa4hQWAZf1TfuyVGazguidI
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Integer.valueOf(Integer.parseInt((String) obj));
                    }
                }).collect(Collectors.toSet());
                manager.handleVibrateEvent(intIds, type, effect, data);
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<EventListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            EventListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mService = ISeatMassager.Stub.asInterface(service);
        if (!this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new SeatMassagerListenerToService(this);
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
        if (this.mListeners.isEmpty()) {
            try {
                this.mListenerToService = new SeatMassagerListenerToService(this);
                this.mService.registerListener(this.mListenerToService);
            } catch (RemoteException e) {
                Log.e(TAG, "Could not connect: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            } catch (IllegalStateException e2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
            }
        }
        this.mListeners.add(listener);
    }

    public synchronized void unregisterListener(EventListener listener) throws XUIServiceNotConnectedException {
        Log.d(TAG, "unregisterListener");
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

    public void loadMassagerEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.loadMassagerEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loadMassagerEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showMassagerEffect() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showMassagerEffect());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showMassagerEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startMassager(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.startMassager(Collections.singletonList(new Seat(id, getMassagerIntensity(id))), getMassagerEffect(id));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startMassager(int id, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.startMassager(Collections.singletonList(new Seat(id, getMassagerIntensity(id))), effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startMassager(Seat seat, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.startMassager(Collections.singletonList(seat), effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int startMassager(Set<Seat> seats, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.startMassager(new ArrayList(seats), effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not startMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setMassagerEffect(int id, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setMassagerEffect(Collections.singletonList(String.valueOf(id)), effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMassagerEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setMassagerEffect(Set<Integer> ids, String effect) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.setMassagerEffect(strIds, effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMassagerEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getMassagerEffect(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMassagerEffect(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMassagerEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setMassagerIntensity(int id, int intensity) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setMassagerIntensity(Collections.singletonList(String.valueOf(id)), intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMassagerIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setMassagerIntensity(Set<Integer> ids, int intensity) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.setMassagerIntensity(strIds, intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setMassagerIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getMassagerIntensity(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMassagerIntensity(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMassagerIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getMassagerStatus(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getMassagerStatus(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getMassagerStatus: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopMassager(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.stopMassager(Collections.singletonList(String.valueOf(id)));
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int stopMassager(Set<Integer> ids) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.stopMassager(strIds);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopMassager: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void loadVibrateEffect() throws XUIServiceNotConnectedException {
        try {
            this.mService.loadVibrateEffect();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loadVibrateEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int loadVibrateEffect(AssetFileDescriptor fd, String effect) throws XUIServiceNotConnectedException {
        try {
            return this.mService.loadVibrate(fd, effect);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not loadVibrate: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public Set<String> showVibrateEffect() throws XUIServiceNotConnectedException {
        try {
            return new HashSet(this.mService.showVibrateEffect());
        } catch (RemoteException e) {
            Log.e(TAG, "Could not showVibrateEffect: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setRhythmEnable(int id, boolean enable) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setRhythmEnable(Collections.singletonList(String.valueOf(id)), enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setRhythmEnable(Set<Integer> ids, boolean enable) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.setRhythmEnable(strIds, enable);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getRhythmEnable(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRhythmEnable(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRhythmEnable: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int doVibrate(int id, String effect, int loop, int position) throws XUIServiceNotConnectedException {
        try {
            return this.mService.doVibrate(Collections.singletonList(new Seat(id, getVibrateIntensity(id))), effect, loop, position);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not doVibrate: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int doVibrate(Seat seat, String effect, int loop, int position) throws XUIServiceNotConnectedException {
        try {
            return this.mService.doVibrate(Collections.singletonList(seat), effect, loop, position);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not doVibrate: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int doVibrate(Set<Seat> seats, String effect, int loop, int position) throws XUIServiceNotConnectedException {
        try {
            return this.mService.doVibrate(new ArrayList(seats), effect, loop, position);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not doVibrate: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int doVibrate(int id, int duration, int position) throws XUIServiceNotConnectedException {
        if (duration != 0) {
            return doVibrate(id, "background", duration, position);
        }
        return -1;
    }

    public int doVibrate(Seat seat, int duration, int position) throws XUIServiceNotConnectedException {
        if (duration != 0) {
            return doVibrate(seat, "background", duration, position);
        }
        return -1;
    }

    public int doVibrate(Set<Seat> seats, int duration, int position) throws XUIServiceNotConnectedException {
        if (duration != 0) {
            return doVibrate(seats, "background", duration, position);
        }
        return -1;
    }

    public int stopVibrate() throws XUIServiceNotConnectedException {
        try {
            return this.mService.stopVibrate();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not stopVibrate: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setVibrateIntensity(int id, int intensity) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setVibrateIntensity(Collections.singletonList(String.valueOf(id)), intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setVibrateIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setVibrateIntensity(Set<Integer> ids, int intensity) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.setVibrateIntensity(strIds, intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setVibrateIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getVibrateIntensity(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getVibrateIntensity(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getVibrateIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setRhythmIntensity(int id, int intensity) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setRhythmIntensity(Collections.singletonList(String.valueOf(id)), intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setRhythmIntensity(Set<Integer> ids, int intensity) throws XUIServiceNotConnectedException {
        try {
            List<String> strIds = (List) ids.stream().map($$Lambda$znfQj8LqOvyui6ncUHU4komPIHY.INSTANCE).collect(Collectors.toList());
            return this.mService.setRhythmIntensity(strIds, intensity);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getRhythmIntensity(int id) throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRhythmIntensity(id);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRhythmIntensity: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int setRhythmPattern(int pattern) throws XUIServiceNotConnectedException {
        try {
            return this.mService.setRhythmPattern(pattern);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not setRhythmPattern: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int getRhythmPattern() throws XUIServiceNotConnectedException {
        try {
            return this.mService.getRhythmPattern();
        } catch (RemoteException e) {
            Log.e(TAG, "Could not getRhythmPattern: " + e.toString());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<SeatMassagerManager> mManager;

        EventCallbackHandler(SeatMassagerManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SeatMassagerManager manager = this.mManager.get();
            if (manager == null) {
                return;
            }
            int i = msg.what;
            if (i == 0) {
                manager.dispatchMassagerToClient((MassagerMessage) msg.obj);
            } else if (i == 1) {
                manager.dispatchVibrateToClient((VibrateMessage) msg.obj);
            } else {
                Log.e(SeatMassagerManager.TAG, "Event type not handled?" + msg);
            }
        }
    }

    public SeatMassagerManager(IBinder service, Context context, Handler handler) {
        this.mService = ISeatMassager.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }
}
