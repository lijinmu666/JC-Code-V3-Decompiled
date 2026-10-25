package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p281jce.p282spec.IESParameterSpec;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.IESUtil */
/* loaded from: classes2.dex */
public class C5619IESUtil {
    public static IESParameterSpec guessParameterSpec(BufferedBlockCipher bufferedBlockCipher, byte[] bArr) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec(null, null, 128);
        }
        BlockCipher underlyingCipher = bufferedBlockCipher.getUnderlyingCipher();
        return (underlyingCipher.getAlgorithmName().equals("DES") || underlyingCipher.getAlgorithmName().equals("RC2") || underlyingCipher.getAlgorithmName().equals("RC5-32") || underlyingCipher.getAlgorithmName().equals("RC5-64")) ? new IESParameterSpec(null, null, 64, 64, bArr) : underlyingCipher.getAlgorithmName().equals("SKIPJACK") ? new IESParameterSpec(null, null, 80, 80, bArr) : underlyingCipher.getAlgorithmName().equals("GOST28147") ? new IESParameterSpec(null, null, 256, 256, bArr) : new IESParameterSpec(null, null, 128, 128, bArr);
    }
}
