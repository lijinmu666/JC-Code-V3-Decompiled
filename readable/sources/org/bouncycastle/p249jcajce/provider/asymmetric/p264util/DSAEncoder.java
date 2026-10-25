package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public interface DSAEncoder {
    /* renamed from: decode */
    BigInteger[] m16140decode(byte[] bArr);

    /* renamed from: encode */
    byte[] m16141encode(BigInteger bigInteger, BigInteger bigInteger2);
}
