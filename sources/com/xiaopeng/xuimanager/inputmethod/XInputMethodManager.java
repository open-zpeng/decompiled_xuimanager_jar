package com.xiaopeng.xuimanager.inputmethod;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public class XInputMethodManager {
    public static boolean getInputShown(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService("input_method");
        return imm.getInputShown();
    }

    public static void forceHideSoftInputMethod(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService("input_method");
        imm.forceHideSoftInputMethod();
    }
}
