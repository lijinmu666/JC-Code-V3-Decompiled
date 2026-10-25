package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* renamed from: y */
    private BigInteger f20750y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f20750y = bigInteger;
    }

    @Override // org.bouncycastle.p194crypto.p213params.ElGamalKeyParameters
    /* renamed from: equals */
    public boolean mo15741equals(Object obj) {
        return (obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).m15747getY().equals(this.f20750y) && super.mo15741equals(obj);
    }

    /* renamed from: getY */
    public BigInteger m15747getY() {
        return this.f20750y;
    }

    @Override // org.bouncycastle.p194crypto.p213params.ElGamalKeyParameters
    public int hashCode() {
        return super.hashCode() ^ this.f20750y.hashCode();
    }
}
