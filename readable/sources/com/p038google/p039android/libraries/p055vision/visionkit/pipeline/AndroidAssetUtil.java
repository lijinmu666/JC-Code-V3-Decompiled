package com.p038google.p039android.libraries.p055vision.visionkit.pipeline;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class AndroidAssetUtil {
    /* renamed from: mjFkc */
    public static synchronized boolean m2406mjFkc(Context context) {
        return nativeInitializeAssetManager(context, context.getCacheDir().getAbsolutePath());
    }

    private static native boolean nativeInitializeAssetManager(Context context, String str);
}
