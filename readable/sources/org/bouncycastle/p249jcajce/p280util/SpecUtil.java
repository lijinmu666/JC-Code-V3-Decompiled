package org.bouncycastle.p249jcajce.p280util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes2.dex */
public class SpecUtil {
    private static Class[] NO_PARAMS = new Class[0];

    /* renamed from: NO_ARGS */
    private static Object[] f21955NO_ARGS = new Object[0];

    public static byte[] getContextFrom(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (byte[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.jcajce.util.SpecUtil.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return algorithmParameterSpec.getClass().getMethod("getContext", SpecUtil.NO_PARAMS).invoke(algorithmParameterSpec, SpecUtil.f21955NO_ARGS);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    public static String getNameFrom(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.jcajce.util.SpecUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return algorithmParameterSpec.getClass().getMethod("getName", SpecUtil.NO_PARAMS).invoke(algorithmParameterSpec, SpecUtil.f21955NO_ARGS);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }
}
