package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x */
    private BigInteger f20702x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f20702x = bigInteger;
    }

    @Override // org.bouncycastle.p194crypto.p213params.DHKeyParameters
    /* renamed from: equals */
    public boolean mo15689equals(Object obj) {
        return (obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).m15697getX().equals(this.f20702x) && super.mo15689equals(obj);
    }

    /* renamed from: getX */
    public BigInteger m15697getX() {
        return this.f20702x;
    }

    @Override // org.bouncycastle.p194crypto.p213params.DHKeyParameters
    public int hashCode() {
        return super.hashCode() ^ this.f20702x.hashCode();
    }
}
