package com.xiaopeng.xuimanager.operation;

import java.util.List;

/* loaded from: classes.dex */
public interface IOperationListener {
    void onOperationSourceAdd(int i, OperationResource operationResource);

    void onOperationSourceDelete(int i, OperationResource operationResource);

    void onOperationSourceExpire(int i, OperationResource operationResource);

    void onRemoteSourceQuerySuccess(int i, List<OperationResource> list);

    default void onResourceDownloadFailed(int type, FailedInfo failedInfo) {
    }

    default void onDownloadStatusChanged(int type, DownloadStatusInfo downloadStatusInfo) {
    }

    default void onRequestShowResourceDetail(int type, OperationResource operationResource) {
    }

    default void onOperationSourceSelected(int type, OperationResource resource) {
    }

    default void onOperationSourceUnselected(int type, OperationResource resource) {
    }

    default void onOperationResourceSyncCompleted(int resourceType) {
    }

    default void onOperationResourceSyncFailed(int resourceType) {
    }

    default void onOperationResourceSyncAborted(int resourceType) {
    }
}
