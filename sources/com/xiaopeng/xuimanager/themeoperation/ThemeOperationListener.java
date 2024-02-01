package com.xiaopeng.xuimanager.themeoperation;

import java.util.List;

/* loaded from: classes.dex */
public interface ThemeOperationListener {
    void onThemeStatus(String str, String str2, List<ThemeOperationData> list);

    default void onEffectStatus(String event, String extra, List<AbilityEffect> effectList) {
    }
}
