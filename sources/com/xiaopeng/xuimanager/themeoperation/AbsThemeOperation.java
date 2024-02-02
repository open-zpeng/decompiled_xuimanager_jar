package com.xiaopeng.xuimanager.themeoperation;
/* loaded from: classes.dex */
public interface AbsThemeOperation {
    boolean deleteTheme(ThemeOperationData themeOperationData);

    ThemeOperationData getCurrentTheme();

    ThemeOperationData[] getThemes();

    void registerListener(ThemeOperationListener themeOperationListener);

    boolean resetTheme(ThemeOperationData themeOperationData);

    boolean selectEffect(AbilityEffect abilityEffect);

    boolean selectTheme(ThemeOperationData themeOperationData);

    void unRegisterListener(ThemeOperationListener themeOperationListener);

    boolean updateTheme(ThemeOperationData themeOperationData);
}
