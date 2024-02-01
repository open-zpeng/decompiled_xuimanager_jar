package com.xiaopeng.xuimanager.operation;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaopeng.xuimanager.XUIManagerBase;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.operation.IOperation;
import com.xiaopeng.xuimanager.operation.IOperationEventListener;
import com.xiaopeng.xuimanager.operation.internal.OperationCmd;
import com.xiaopeng.xuimanager.operation.internal.OperationConstants;
import com.xiaopeng.xuimanager.operation.internal.OperationParams;
import com.xiaopeng.xuimanager.operation.utils.ResourceBuild;
import com.xiaopeng.xuimanager.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class OperationManager implements XUIManagerBase {
    private static final int MSG_WHAT_OPERATION_EVENT = 1;
    public static final String TAG = "OperationManager";
    private static String mServiceName = null;
    private Handler mHandler;
    private List<OperationEventListener> mOperationEventListeners;
    private IOperation mOperationService;
    private IOperationEventListener mServiceEventListener;
    private SparseArray<List<IOperationListener>> mTypeToCallbacksMap = new SparseArray<>();
    private boolean serverDisconnected = false;
    private IOperationListener mCompatibleListener = new IOperationListener() { // from class: com.xiaopeng.xuimanager.operation.OperationManager.1
        @Override // com.xiaopeng.xuimanager.operation.IOperationListener
        public void onOperationSourceAdd(int type, OperationResource resource) {
            if (OperationManager.this.mOperationEventListeners != null && !OperationManager.this.mOperationEventListeners.isEmpty()) {
                for (OperationEventListener listener : OperationManager.this.mOperationEventListeners) {
                    listener.onEvent(1, resource.getId(), resource.getResourceType(), ResourceBuild.getLegacyEventInfo(resource));
                }
            }
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationListener
        public void onOperationSourceExpire(int type, OperationResource resource) {
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationListener
        public void onOperationSourceDelete(int type, OperationResource resource) {
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationListener
        public void onRemoteSourceQuerySuccess(int type, List<OperationResource> resources) {
        }
    };

    /* loaded from: classes.dex */
    public interface OperationEventListener {
        void onErrorEvent(int i, int i2);

        void onEvent(int i, String str, int i2, String str2);
    }

    public OperationManager(IBinder service, Context context, Handler handler) {
        this.mOperationService = IOperation.Stub.asInterface(service);
        this.mHandler = new EventCallbackHandler(this, handler.getLooper());
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onServerDisconnected() {
        LogUtil.log(3, TAG, "onServerDisconnected");
        this.serverDisconnected = true;
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIDisconnected() {
        LogUtil.log(3, TAG, "onXUIDisconnected");
    }

    @Override // com.xiaopeng.xuimanager.XUIManagerBase
    public void onXUIConnected(IBinder service) {
        LogUtil.log(2, TAG, "onXUIConnected");
        if (!this.serverDisconnected) {
            return;
        }
        this.serverDisconnected = false;
        this.mOperationService = IOperation.Stub.asInterface(service);
        IOperationEventListener iOperationEventListener = this.mServiceEventListener;
        if (iOperationEventListener != null) {
            try {
                this.mOperationService.registerListener(iOperationEventListener);
            } catch (RemoteException e) {
                LogUtil.log(4, TAG, "registerListenerToService e=" + e);
            }
        }
        if (this.mTypeToCallbacksMap.size() > 0) {
            for (int i = 0; i < this.mTypeToCallbacksMap.size(); i++) {
                try {
                    this.mOperationService.operateResource(OperationCmd.ADD_MONITOR_RESOURCE, this.mTypeToCallbacksMap.keyAt(i), "");
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
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

    public synchronized void registerListener(OperationEventListener listener) {
        if (this.mOperationEventListeners == null) {
            this.mOperationEventListeners = new ArrayList();
        }
        if (!this.mOperationEventListeners.contains(listener)) {
            this.mOperationEventListeners.add(listener);
        }
        registerListener(OperationType.LLU, this.mCompatibleListener);
    }

    public synchronized void registerListener(int type, IOperationListener listener) {
        if (listener == null) {
            LogUtil.log(3, TAG, "registerListener callback is null");
            throw new IllegalArgumentException("input listener cannot be null");
        }
        if (this.mServiceEventListener == null) {
            this.mServiceEventListener = new ServiceEventListener(this);
            if (this.mOperationService != null) {
                try {
                    this.mOperationService.registerListener(this.mServiceEventListener);
                } catch (RemoteException e) {
                    LogUtil.log(4, TAG, "registerListener exception=" + e.getMessage());
                }
            }
        }
        List<IOperationListener> callbacks = this.mTypeToCallbacksMap.get(type);
        if (callbacks == null) {
            callbacks = new ArrayList();
            if (this.mOperationService != null) {
                try {
                    this.mOperationService.operateResource(OperationCmd.ADD_MONITOR_RESOURCE, type, "");
                } catch (RemoteException e2) {
                    LogUtil.log(4, TAG, "registerListener exception=" + e2.getMessage());
                }
            }
        }
        if (!callbacks.contains(listener)) {
            callbacks.add(listener);
            this.mTypeToCallbacksMap.put(type, callbacks);
        }
    }

    public synchronized void unregisterListener(OperationEventListener listener) {
        if (this.mOperationEventListeners != null && !this.mOperationEventListeners.isEmpty()) {
            this.mOperationEventListeners.remove(listener);
        }
        if (this.mOperationEventListeners.isEmpty()) {
            unRegisterListener(OperationType.LLU, this.mCompatibleListener);
        }
    }

    public synchronized void unRegisterListener(int type, IOperationListener listener) {
        if (listener == null) {
            LogUtil.log(3, TAG, "unRegisterListener callback is null");
            throw new IllegalArgumentException("input listener cannot be null");
        }
        List<IOperationListener> callbacks = this.mTypeToCallbacksMap.get(type);
        if (callbacks != null && !callbacks.isEmpty() && callbacks.contains(listener)) {
            callbacks.remove(listener);
        }
        if ((callbacks == null || callbacks.isEmpty()) && this.mOperationService != null) {
            try {
                this.mOperationService.operateResource(OperationCmd.REMOVE_MONITOR_RESOURCE, type, "");
            } catch (RemoteException e) {
                LogUtil.log(4, TAG, "registerListener exception=" + e.getMessage());
            }
        }
        if (this.mTypeToCallbacksMap.size() == 0 && this.mServiceEventListener != null) {
            if (this.mOperationService != null) {
                try {
                    this.mOperationService.unregisterListener(this.mServiceEventListener);
                } catch (RemoteException e2) {
                    LogUtil.log(4, TAG, "registerListener exception=" + e2.getMessage());
                }
            }
            this.mServiceEventListener = null;
        }
    }

    public void downloadResource(boolean useSystemTraffic, OperationResource resource) {
        downloadResource(useSystemTraffic, resource, null);
    }

    public void downloadResource(boolean useSystemTraffic, OperationResource resource, PendingIntent pendingIntent) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.downloadResource(resource.getResourceType(), ResourceBuild.toJsonWithDownloadParams(resource, useSystemTraffic).toString(), pendingIntent);
                LogUtil.log(1, TAG, "downloadResource");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelDownload(OperationResource resource) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.operateResource(OperationCmd.CANCEL_DOWNLOAD_RESOURCE, resource.getResourceType(), ResourceBuild.toJson(resource).toString());
                LogUtil.log(1, TAG, "cancelDownload");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseDownload(OperationResource resource) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.operateResource(OperationCmd.PAUSE_DOWNLOAD_RESOURCE, resource.getResourceType(), ResourceBuild.toJson(resource).toString());
                LogUtil.log(1, TAG, "pauseDownload");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void resumeDownload(OperationResource resource) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.operateResource(OperationCmd.RESUME_DOWNLOAD_RESOURCE, resource.getResourceType(), ResourceBuild.toJson(resource).toString());
                LogUtil.log(1, TAG, "resumeDownload");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void showDownloadResourceDetail(String downloadUri, Bundle bundle) {
        if (this.mOperationService != null && bundle != null) {
            try {
                OperationResource operationResource = new OperationResource();
                operationResource.setId(bundle.getString("id", ""));
                operationResource.setResourceType(Integer.valueOf(bundle.getString(OperationConstants.MetaData.KEY_TYPE, "-1")).intValue());
                operationResource.setResourceName(bundle.getString(OperationConstants.MetaData.KEY_NAME, ""));
                operationResource.setDownloadUrl(downloadUri);
                this.mOperationService.operateResource(OperationCmd.SHOW_DOWNLOAD_RESOURCE_DETAIL, operationResource.getResourceType(), ResourceBuild.toJson(operationResource).toString());
                LogUtil.log(1, TAG, "showDownloadResourceDetail");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAutoSync(int type) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.operateResource(OperationCmd.SET_AUTO_SYNC_RESOURCE, type, "");
                LogUtil.log(1, TAG, "setAutoSync: type=" + type);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getRemoteResourceList(int type) {
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                iOperation.getResource(type, OperationParams.PARAMS_GET_REMOTE);
                LogUtil.log(1, TAG, "getRemoteResourceList with type:" + type);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public List<OperationResource> getResourceList(int type) {
        String result = "";
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                result = iOperation.getResource(type, "");
                LogUtil.log(1, TAG, "getResourceList result:" + result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return ResourceBuild.fromJsonArray(result);
    }

    public OperationResource getSelectedResource(int type) {
        String result = "";
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                result = iOperation.getResource(type, OperationParams.PARAM_GET_SELECTED);
                LogUtil.log(1, TAG, "getSelectedResource result:" + result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        try {
            if (!TextUtils.isEmpty(result)) {
                return ResourceBuild.fromJson(new JSONObject(result));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<DownloadStatusInfo> getDownloadStatusList(int type) {
        String result = "";
        IOperation iOperation = this.mOperationService;
        if (iOperation != null) {
            try {
                result = iOperation.getInfo(OperationCmd.GET_DOWNLOAD_STATUS_LIST, type, "");
                LogUtil.log(1, TAG, "getDownloadStatusList result:" + result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(result)) {
            return null;
        }
        return ResourceBuild.toDownloadStatusList(result);
    }

    public int addNewResource(String id, int type, String rsc_name, String rsc_path) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "addNewResource");
        try {
            return this.mOperationService.addNewResource(id, type, rsc_name, rsc_path);
        } catch (RemoteException e) {
            LogUtil.log(4, TAG, "addNewResource failed:" + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getLocalResourceList(int type) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "getLocalResourceList");
        try {
            return this.mOperationService.getLocalResourceList(type);
        } catch (RemoteException e) {
            LogUtil.log(4, TAG, "getLocalResourceList failed:" + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public String getDownLoadResourceList(int type) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "getDownLoadResourceList");
        try {
            return this.mOperationService.getDownLoadResourceList(type);
        } catch (RemoteException e) {
            LogUtil.log(4, TAG, "getDownLoadResourceList failed:" + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public boolean checkResourceExist(int type, String rsc_name) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "checkResourceExist");
        try {
            return this.mOperationService.checkResourceExist(type, rsc_name);
        } catch (RemoteException e) {
            LogUtil.log(4, TAG, "checkResourceExist failed:" + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public int deleteResource(String id, int type, String rsc_name) throws XUIServiceNotConnectedException {
        LogUtil.log(1, TAG, "deleteResource");
        try {
            return this.mOperationService.deleteResource(id, type, rsc_name);
        } catch (RemoteException e) {
            LogUtil.log(4, TAG, "deleteResource failed:" + e.getMessage());
            throw new XUIServiceNotConnectedException(e);
        }
    }

    public void deleteResource(String id) {
        LogUtil.log(1, TAG, "deleteResource");
        try {
            this.mOperationService.operateResource(OperationCmd.DELETE_OPERATION_RESOURCE, -1, id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    private static final class EventCallbackHandler extends Handler {
        WeakReference<OperationManager> mOperationManagerWeakReference;

        EventCallbackHandler(OperationManager mgr, Looper looper) {
            super(looper);
            this.mOperationManagerWeakReference = new WeakReference<>(mgr);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            OperationManager manager;
            if (msg.what == 1 && (manager = this.mOperationManagerWeakReference.get()) != null) {
                manager.dispatchEvent(msg.arg1, msg.arg2, (String) msg.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOperationEvent(int code, String id, int type, String event) {
        Message.obtain(this.mHandler, 1, code, type, event).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOperationErrorEvent(int errorCode, int operation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEvent(int code, int type, String event) {
        LogUtil.log(2, TAG, "dispatchEvent code :" + code + " &event:" + event);
        List<IOperationListener> callbacks = this.mTypeToCallbacksMap.get(type);
        if (callbacks != null && !callbacks.isEmpty()) {
            switch (code) {
                case 1:
                    dispatchAddEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 2:
                case 3:
                    dispatchExpireEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 4:
                    dispatchSelectEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 5:
                    List<OperationResource> resources = ResourceBuild.fromJsonArray(event);
                    dispatchQuerySuccessEvent(callbacks, type, resources);
                    return;
                case 6:
                    dispatchDownloadFailedEvent(callbacks, ResourceBuild.toFailedInfo(event));
                    return;
                case 7:
                    dispatchDownloadStatusChangedEvent(callbacks, ResourceBuild.toDownloadStatusInfo(event));
                    return;
                case 8:
                    dispatchRequestShowDetailEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 9:
                    dispatchDeleteEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 10:
                    dispatchUnselectEvent(callbacks, getResourceFromEvent(event));
                    return;
                case 11:
                    dispatchSyncCompletedEvent(callbacks, type);
                    return;
                case 12:
                    dispatchSyncFailedEvent(callbacks, type);
                    return;
                case 13:
                    dispatchSyncAbortedEvent(callbacks, type);
                    return;
                default:
                    return;
            }
        }
    }

    private OperationResource getResourceFromEvent(String event) {
        if (!TextUtils.isEmpty(event)) {
            try {
                JSONObject sourceObject = new JSONObject(event);
                return ResourceBuild.fromJson(sourceObject);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private void dispatchAddEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationSourceAdd(resource.getResourceType(), resource);
        }
    }

    private void dispatchExpireEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationSourceExpire(resource.getResourceType(), resource);
        }
    }

    private void dispatchDeleteEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationSourceDelete(resource.getResourceType(), resource);
        }
    }

    private void dispatchSelectEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationSourceSelected(resource.getResourceType(), resource);
        }
    }

    private void dispatchUnselectEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationSourceUnselected(resource.getResourceType(), resource);
        }
    }

    private void dispatchQuerySuccessEvent(List<IOperationListener> callbacks, int type, List<OperationResource> resources) {
        for (IOperationListener listener : callbacks) {
            listener.onRemoteSourceQuerySuccess(type, resources);
        }
    }

    private void dispatchDownloadStatusChangedEvent(List<IOperationListener> callbacks, DownloadStatusInfo downloadStatusInfo) {
        for (IOperationListener listener : callbacks) {
            listener.onDownloadStatusChanged(downloadStatusInfo.getResourceType(), downloadStatusInfo);
        }
    }

    private void dispatchDownloadFailedEvent(List<IOperationListener> callbacks, FailedInfo failedInfo) {
        for (IOperationListener listener : callbacks) {
            listener.onResourceDownloadFailed(failedInfo.getResourceType(), failedInfo);
        }
    }

    private void dispatchRequestShowDetailEvent(List<IOperationListener> callbacks, OperationResource resource) {
        for (IOperationListener listener : callbacks) {
            listener.onRequestShowResourceDetail(resource.getResourceType(), resource);
        }
    }

    private void dispatchSyncCompletedEvent(List<IOperationListener> callbacks, int type) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationResourceSyncCompleted(type);
        }
    }

    private void dispatchSyncFailedEvent(List<IOperationListener> callbacks, int type) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationResourceSyncFailed(type);
        }
    }

    private void dispatchSyncAbortedEvent(List<IOperationListener> callbacks, int type) {
        for (IOperationListener listener : callbacks) {
            listener.onOperationResourceSyncAborted(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ServiceEventListener extends IOperationEventListener.Stub {
        private final WeakReference<OperationManager> mManager;

        public ServiceEventListener(OperationManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
        public void onError(int errorCode, int operation) throws RemoteException {
            OperationManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleOperationErrorEvent(errorCode, operation);
            }
        }

        @Override // com.xiaopeng.xuimanager.operation.IOperationEventListener
        public void onEvent(int code, String id, int type, String event) throws RemoteException {
            OperationManager manager = this.mManager.get();
            if (manager != null) {
                LogUtil.log(2, OperationManager.TAG, "onEvent code :" + code + " &type:" + type);
                manager.handleOperationEvent(code, id, type, event);
            }
        }
    }
}
