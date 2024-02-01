package com.xiaopeng.xuimanager.mediacenter.bluetooth;

/* loaded from: classes.dex */
public interface AvrcpEventListener {
    void onConnectedChanged(int i, int i2);

    void onMeteDataChanged(AvrcpMeteData avrcpMeteData);

    void onPlaybackChanged(int i);

    void onPositionChanged(long j, long j2);
}
