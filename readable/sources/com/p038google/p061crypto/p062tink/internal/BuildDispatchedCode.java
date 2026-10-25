package com.p038google.p061crypto.p062tink.internal;

import android.os.Build;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class BuildDispatchedCode {
    private BuildDispatchedCode() {
    }

    @Nullable
    public static Integer getApiLevel() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
