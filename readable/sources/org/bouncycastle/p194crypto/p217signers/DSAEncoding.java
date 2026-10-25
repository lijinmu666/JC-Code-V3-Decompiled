package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public interface DSAEncoding {
    /* renamed from: decode */
    BigInteger[] mo15856decode(BigInteger bigInteger, byte[] bArr);

    /* renamed from: encode */
    byte[] mo15857encode(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3);
}
