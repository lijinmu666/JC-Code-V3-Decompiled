package org.bouncycastle.p246its.p248jcajce;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes2.dex */
class ClassUtil {
    public static AlgorithmParameterSpec getGCMSpec(byte[] bArr, int i) {
        return new GCMParameterSpec(i, bArr);
    }
}
