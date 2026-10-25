package org.conscrypt;

/* loaded from: classes2.dex */
class NativeCryptoJni {
    private NativeCryptoJni() {
    }

    /* renamed from: init */
    public static void m18450init() {
        if ("com.google.android.gms.org.conscrypt".equals(NativeCrypto.class.getPackage().getName())) {
            System.loadLibrary("conscrypt_gmscore_jni");
        } else {
            System.loadLibrary("conscrypt_jni");
        }
    }
}
