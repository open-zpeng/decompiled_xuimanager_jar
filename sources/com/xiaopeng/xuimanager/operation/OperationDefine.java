package com.xiaopeng.xuimanager.operation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class OperationDefine {
    public static final int SOURCE_STATUS_FORBIDDEN = 1;
    public static final int SOURCE_STATUS_NORMAL = 0;
    public static final int SOURCE_STATUS_REMOVE = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SourceStatus {
    }
}
