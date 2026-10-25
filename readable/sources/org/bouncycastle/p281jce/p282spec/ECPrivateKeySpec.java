package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ECPrivateKeySpec extends ECKeySpec {

    /* renamed from: d */
    private BigInteger f22063d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f22063d = bigInteger;
    }

    /* renamed from: getD */
    public BigInteger m16273getD() {
        return this.f22063d;
    }
}
