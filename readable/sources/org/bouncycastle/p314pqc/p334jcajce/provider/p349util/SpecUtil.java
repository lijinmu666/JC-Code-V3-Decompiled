package org.bouncycastle.p314pqc.p334jcajce.provider.p349util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.spec.AlgorithmParameterSpec;

@Deprecated
/* loaded from: classes2.dex */
public class SpecUtil {
    private static Class[] NO_PARAMS = new Class[0];

    /* renamed from: NO_ARGS */
    private static Object[] f23879NO_ARGS = new Object[0];

    public static String getNameFrom(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pqc.jcajce.provider.util.SpecUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return algorithmParameterSpec.getClass().getMethod("getName", SpecUtil.NO_PARAMS).invoke(algorithmParameterSpec, SpecUtil.f23879NO_ARGS);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }
}
