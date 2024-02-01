package com.xiaopeng.xuimanager.message;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.message.IMessage;
import com.xiaopeng.xuimanager.message.IMessageListener;
import com.xiaopeng.xuimanager.message.MessageManager;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;

@SystemApi
/* loaded from: classes.dex */
public class MessageManager implements XUIManagerBase {
    private static final int MSG_onReceiveMessage = 1;
    private static final String TAG = MessageManager.class.getSimpleName();
    private Handler mHandler;
    private final ArrayMap<String, ArraySet<MessageListener>> mListenerMap;
    private IMessage mService;
    private final ArrayMap<String, MessageListenerToService> mServiceListenerMap;
    private String mServiceName;

    /* loaded from: classes.dex */
    public interface MessageListener {
        void onReceiveMessage(String str, String str2);
    }

    public static MessageManager getInstance() {
        return MessageManagerHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MessageManagerHolder {
        private static final MessageManager INSTANCE = new MessageManager();

        private MessageManagerHolder() {
        }
    }

    private MessageManager() {
        this.mListenerMap = new ArrayMap<>();
        this.mServiceListenerMap = new ArrayMap<>();
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        super.onXUIConnected(service);
        this.mService = IMessage.Stub.asInterface(service);
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void setServiceName(String name) {
        this.mServiceName = name;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public String getServiceName() {
        if (this.mServiceName == null) {
            this.mServiceName = getClass().getSimpleName();
        }
        return this.mServiceName;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void init(IBinder service, Context context, Handler handler) {
        this.mService = IMessage.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    public void registerMessage(String messageType, MessageListener listener) throws XUIServiceNotConnectedException {
        if (messageType == null) {
            throw new NullPointerException("messageType is null");
        }
        if (listener == null) {
            throw new NullPointerException("MessageListener listener is null");
        }
        synchronized (this.mListenerMap) {
            ArraySet<MessageListener> listeners = this.mListenerMap.get(messageType);
            if (listeners == null) {
                listeners = new ArraySet<>();
                this.mListenerMap.put(messageType, listeners);
            }
            if (listeners.isEmpty()) {
                try {
                    try {
                        MessageListenerToService messageListenerToService = new MessageListenerToService(this);
                        this.mService.registerMessage(messageType, messageListenerToService);
                        this.mServiceListenerMap.put(messageType, messageListenerToService);
                    } catch (RemoteException e) {
                        String str = TAG;
                        LogUtil.e(str, "IMessage.registerMessage fail, " + e.getMessage());
                        e.printStackTrace();
                        throw new XUIServiceNotConnectedException(e);
                    }
                } catch (IllegalStateException e2) {
                    XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
                }
            }
            listeners.add(listener);
        }
    }

    public void unregisterMessage(String messageType, MessageListener listener) throws XUIServiceNotConnectedException {
        if (messageType == null) {
            throw new NullPointerException("messageType is null");
        }
        if (listener == null) {
            throw new NullPointerException("MessageListener listener is null");
        }
        synchronized (this.mListenerMap) {
            ArraySet<MessageListener> listeners = this.mListenerMap.get(messageType);
            if (listeners != null) {
                listeners.remove(listener);
                if (listeners.isEmpty()) {
                    this.mListenerMap.remove(messageType);
                    MessageListenerToService messageListenerToService = this.mServiceListenerMap.remove(messageType);
                    if (messageListenerToService != null) {
                        try {
                            this.mService.unregisterMessage(messageType, messageListenerToService);
                        } catch (RemoteException e) {
                            String str = TAG;
                            LogUtil.e(str, "IMessage.unregisterMessage fail, " + e.getMessage());
                            e.printStackTrace();
                            throw new XUIServiceNotConnectedException(e);
                        } catch (IllegalStateException e2) {
                            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
                        }
                    }
                }
            }
        }
    }

    public void publishMessage(String messageType, String data) throws XUIServiceNotConnectedException {
        try {
            this.mService.publishMessage(messageType, data);
        } catch (RemoteException e) {
            String str = TAG;
            LogUtil.e(str, "IMessage.publishMessage fail, " + e.getMessage());
            e.printStackTrace();
            throw new XUIServiceNotConnectedException(e);
        } catch (IllegalStateException e2) {
            XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnReceiveMessage(String messageType, String data) {
        Message.obtain(this.mHandler, 1, new Pair(messageType, data)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessage(final String messageType, final String data) {
        synchronized (this.mListenerMap) {
            ArraySet<MessageListener> listeners = this.mListenerMap.get(messageType);
            if (listeners != null) {
                listeners.forEach(new Consumer() { // from class: com.xiaopeng.xuimanager.message.-$$Lambda$MessageManager$RmlQBwdBA6iBCEEo_nDYwnVwT2k
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        MessageManager.lambda$dispatchMessage$0(messageType, data, (MessageManager.MessageListener) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchMessage$0(String messageType, String data, MessageListener l) {
        try {
            l.onReceiveMessage(messageType, data);
        } catch (Exception e) {
            String str = TAG;
            LogUtil.e(str, "client error in onReceiveMessage callback, " + e.getMessage());
        }
    }

    /* loaded from: classes.dex */
    private static final class MessageListenerToService extends IMessageListener.Stub {
        private final WeakReference<MessageManager> ref;

        public MessageListenerToService(MessageManager messageManager) {
            this.ref = new WeakReference<>(messageManager);
        }

        @Override // com.xiaopeng.xuimanager.message.IMessageListener
        public void onReceiveMessage(String messageType, String data) throws RemoteException {
            MessageManager messageManager = this.ref.get();
            if (messageManager != null) {
                messageManager.handleOnReceiveMessage(messageType, data);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<MessageManager> mManager;

        EventCallbackHandler(MessageManager manager, Looper looper) {
            super(looper);
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            MessageManager manager = this.mManager.get();
            if (manager != null && msg.what == 1) {
                Pair<String, String> pair = (Pair) msg.obj;
                manager.dispatchMessage((String) pair.first, (String) pair.second);
            }
        }
    }
}
