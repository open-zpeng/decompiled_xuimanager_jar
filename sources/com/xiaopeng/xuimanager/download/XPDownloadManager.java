package com.xiaopeng.xuimanager.download;

import android.annotation.SystemApi;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.download.IDownloadListenerInterface;
import com.xiaopeng.xuimanager.download.IDownloadServiceInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
@SystemApi
/* loaded from: classes.dex */
public class XPDownloadManager implements XUIManagerBase {
    public static final int TYPE_CANCEL = 5;
    public static final int TYPE_COMPLETED = 3;
    public static final int TYPE_ERROR = 6;
    public static final int TYPE_IN_PROGRESS = 2;
    public static final int TYPE_PAUSE = 4;
    public static final int TYPE_START = 1;
    private IDownloadServiceInterface mXpDownloadService;
    private static final String TAG = XPDownloadManager.class.getSimpleName();
    private static String mServiceName = null;
    private IDownloadListenerInterface mIDownloadListenerToService = null;
    private ArraySet<DownloadListener> mDownloadListenerArraySet = new ArraySet<>();

    /* loaded from: classes.dex */
    public interface DownloadListener {
        void onDownloadCancel(long j, String str);

        void onDownloadCompleted(long j, String str, String str2);

        void onDownloadError(long j, String str, String str2);

        void onDownloadInProgress(long j, String str, long j2, float f, long j3);

        void onDownloadPause(long j, String str);

        void onDownloadStart(long j, String str);

        void onRegisterError(DownloadListener downloadListener, String str);

        void onRegisterSuccess(DownloadListener downloadListener);

        void onUnRegisterError(DownloadListener downloadListener, String str);

        void onUnRegisterSuccess(DownloadListener downloadListener);
    }

    public XPDownloadManager(IBinder service, Context context, Handler handler) {
        this.mXpDownloadService = null;
        this.mXpDownloadService = IDownloadServiceInterface.Stub.asInterface(service);
    }

    public synchronized long enqueue(String uri) throws XUIServiceNotConnectedException {
        try {
        } catch (RemoteException ex) {
            String str = TAG;
            Log.e(str, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        }
        return this.mXpDownloadService.enqueue(uri);
    }

    public synchronized long enqueueWtihTitleDescription(String uri, String title, String description, Map requestHeaders) throws XUIServiceNotConnectedException {
        try {
        } catch (RemoteException ex) {
            String str = TAG;
            Log.e(str, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        }
        return this.mXpDownloadService.enqueueWithHeader(uri, title, description, requestHeaders);
    }

    public synchronized ArrayList<Integer> getStatusListByPackageName(String packageName, String stateKey) throws XUIServiceNotConnectedException {
        ArrayList<Integer> intList;
        try {
            int[] ints = this.mXpDownloadService.getStatusListByPackageName(packageName, stateKey);
            intList = new ArrayList<>(ints.length);
            for (int i : ints) {
                intList.add(Integer.valueOf(i));
            }
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        }
        return intList;
    }

    public synchronized long enqueueWithHeader(String uri, Map requestHeaders) throws XUIServiceNotConnectedException {
        try {
        } catch (RemoteException ex) {
            String str = TAG;
            Log.e(str, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        }
        return this.mXpDownloadService.enqueueWithHeader(uri, null, null, requestHeaders);
    }

    public synchronized String getState(long id, String stateKey) throws XUIServiceNotConnectedException {
        try {
        } catch (RemoteException ex) {
            String str = TAG;
            Log.e(str, "Could not connect: " + ex.toString());
            throw new XUIServiceNotConnectedException(ex);
        }
        return this.mXpDownloadService.getState(id, stateKey);
    }

    public synchronized boolean registerListener(DownloadListener listener) throws XUIServiceNotConnectedException {
        if (this.mDownloadListenerArraySet.isEmpty()) {
            try {
                this.mIDownloadListenerToService = new DownloadListenerInterfaceToService(this);
                this.mXpDownloadService.registerListener(this.mIDownloadListenerToService);
            } catch (RemoteException ex) {
                String str = TAG;
                Log.e(str, "Could not connect: " + ex.toString());
                throw new XUIServiceNotConnectedException(ex);
            } catch (IllegalStateException ex2) {
                XUIManager.checkXUIServiceNotConnectedExceptionFromXUIService(ex2);
            }
        }
        return this.mDownloadListenerArraySet.add(listener);
    }

    public synchronized void unregisterListener(DownloadListener listener) throws XUIServiceNotConnectedException {
        this.mDownloadListenerArraySet.remove(listener);
        if (this.mDownloadListenerArraySet.isEmpty()) {
            try {
                this.mXpDownloadService.unRegisterListener(this.mIDownloadListenerToService);
                this.mIDownloadListenerToService = null;
            } catch (RemoteException e) {
                String str = TAG;
                Log.e(str, "Could not unregister: " + e.toString());
                throw new XUIServiceNotConnectedException(e);
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        Iterator<DownloadListener> it = this.mDownloadListenerArraySet.iterator();
        while (it.hasNext()) {
            DownloadListener l = it.next();
            try {
                unregisterListener(l);
            } catch (XUIServiceNotConnectedException e) {
            }
        }
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        this.mXpDownloadService = IDownloadServiceInterface.Stub.asInterface(service);
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
    public boolean dispatchDownloadCallbackToClientByType(int type, long taskId, String fileUri, long totalBytes, float percentage, long byteTillNow, String completedFileUri, String errorMessage) {
        if (!this.mDownloadListenerArraySet.isEmpty()) {
            try {
                Iterator<DownloadListener> it = this.mDownloadListenerArraySet.iterator();
                while (it.hasNext()) {
                    DownloadListener downloadListener = it.next();
                    switch (type) {
                        case 1:
                            String str = TAG;
                            Log.d(str, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadStart start");
                            downloadListener.onDownloadStart(taskId, fileUri);
                            String str2 = TAG;
                            Log.d(str2, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadStart end");
                            break;
                        case 2:
                            String str3 = TAG;
                            Log.d(str3, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadInProgress start");
                            downloadListener.onDownloadInProgress(taskId, fileUri, totalBytes, percentage, byteTillNow);
                            String str4 = TAG;
                            Log.d(str4, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadInProgress end");
                            break;
                        case 3:
                            try {
                                String str5 = TAG;
                                Log.d(str5, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCompleted start");
                                downloadListener.onDownloadCompleted(taskId, fileUri, completedFileUri);
                                String str6 = TAG;
                                Log.d(str6, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCompleted end");
                                break;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                return false;
                            }
                        case 4:
                            String str7 = TAG;
                            Log.d(str7, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCancel start");
                            downloadListener.onDownloadPause(taskId, fileUri);
                            String str8 = TAG;
                            Log.d(str8, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCancel end");
                            break;
                        case 5:
                            String str9 = TAG;
                            Log.d(str9, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCancel start");
                            downloadListener.onDownloadCancel(taskId, fileUri);
                            String str10 = TAG;
                            Log.d(str10, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadCancel end");
                            break;
                        case 6:
                            try {
                                String str11 = TAG;
                                Log.d(str11, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadError start");
                                downloadListener.onDownloadError(taskId, fileUri, errorMessage);
                                String str12 = TAG;
                                Log.d(str12, "dispatchDownloadCallbackToClientByType listener is " + downloadListener + " onDownloadError end");
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                return false;
                            }
                    }
                }
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            Log.d(TAG, "dispatchDownloadCallbackByType listeners is null");
            return true;
        }
    }

    /* loaded from: classes.dex */
    private static class DownloadListenerInterfaceToService extends IDownloadListenerInterface.Stub {
        private final WeakReference<XPDownloadManager> mManager;

        public DownloadListenerInterfaceToService(XPDownloadManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onRegisterSuccess(IDownloadListenerInterface listener) throws RemoteException {
            Log.d(XPDownloadManager.TAG, "mIDownloadListener onRegisterSuccess ");
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onRegisterError(IDownloadListenerInterface listener, String errorMessage) throws RemoteException {
            Log.d(XPDownloadManager.TAG, "mIDownloadListener onRegisterError ");
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onUnRegisterSuccess(IDownloadListenerInterface listener) throws RemoteException {
            Log.d(XPDownloadManager.TAG, "mIDownloadListener onUnRegisterSuccess ");
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onUnRegisterError(IDownloadListenerInterface listener, String errorMessage) throws RemoteException {
            Log.d(XPDownloadManager.TAG, "mIDownloadListener onUnRegisterError ");
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadStart(long taskId, String uri) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadStart task id  = " + taskId);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(1, taskId, uri, 0L, 0.0f, 0L, "", "");
            }
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadInProgress(long taskId, String url, long totalBytes, float percentage, long byteTillNow) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadInProgress task id  = " + taskId + "   percentage = " + percentage + "   byteTillNow = " + byteTillNow);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(2, taskId, url, totalBytes, percentage, byteTillNow, "", "");
            }
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadPause(long taskId, String uri) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadStart task id  = " + taskId);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(4, taskId, uri, 0L, 0.0f, 0L, "", "");
            }
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadCancel(long taskId, String uri) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadStart task id  = " + taskId);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(5, taskId, uri, 0L, 0.0f, 0L, "", "");
            }
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadError(long taskId, String downloadUrl, String errorMessage) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadError task id  = " + taskId + " errorMessage = " + errorMessage);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(6, taskId, downloadUrl, 0L, 0.0f, 0L, "", errorMessage);
            }
        }

        @Override // com.xiaopeng.xuimanager.download.IDownloadListenerInterface
        public void onDownloadCompleted(long taskId, String downloadUrl, String completedFileUri) throws RemoteException {
            String str = XPDownloadManager.TAG;
            Log.d(str, "mIDownloadListener onDownloadCompleted task id  = " + taskId + " fileUri = " + completedFileUri);
            XPDownloadManager manager = this.mManager.get();
            if (manager != null) {
                manager.dispatchDownloadCallbackToClientByType(3, taskId, downloadUrl, 0L, 0.0f, 0L, completedFileUri, "");
            }
        }
    }
}
