package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ECCSIPrivateKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: pub */
    private final ECCSIPublicKeyParameters f20730pub;

    /* renamed from: ssk */
    private final BigInteger f20731ssk;

    public ECCSIPrivateKeyParameters(BigInteger bigInteger, ECCSIPublicKeyParameters eCCSIPublicKeyParameters) {
        super(true);
        this.f20731ssk = bigInteger;
        this.f20730pub = eCCSIPublicKeyParameters;
    }

    public ECCSIPublicKeyParameters getPublicKeyParameters() {
        return this.f20730pub;
    }

    /* renamed from: getSSK */
    public BigInteger m15717getSSK() {
        return this.f20731ssk;
    }
}
