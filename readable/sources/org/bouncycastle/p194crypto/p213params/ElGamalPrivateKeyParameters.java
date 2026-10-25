package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {

    /* renamed from: x */
    private BigInteger f20749x;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.f20749x = bigInteger;
    }

    @Override // org.bouncycastle.p194crypto.p213params.ElGamalKeyParameters
    /* renamed from: equals */
    public boolean mo15741equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).m15746getX().equals(this.f20749x)) {
            return super.mo15741equals(obj);
        }
        return false;
    }

    /* renamed from: getX */
    public BigInteger m15746getX() {
        return this.f20749x;
    }

    @Override // org.bouncycastle.p194crypto.p213params.ElGamalKeyParameters
    public int hashCode() {
        return m15746getX().hashCode();
    }
}
