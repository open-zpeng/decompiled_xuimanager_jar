package com.xiaopeng.xuimanager.mediacenter;
/* loaded from: classes.dex */
public interface SDPlaybackListener {
    void OnMediaInfoNotify(int i, MediaInfo mediaInfo);

    void OnPlaybackChanged(int i, int i2);

    void OnUpdatePosition(int i, long j, long j2);
}
