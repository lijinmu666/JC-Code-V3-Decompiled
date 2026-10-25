package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c */
    private BigInteger f20691c;

    /* renamed from: d */
    private BigInteger f20692d;

    /* renamed from: h */
    private BigInteger f20693h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f20691c = bigInteger;
        this.f20692d = bigInteger2;
        this.f20693h = bigInteger3;
    }

    @Override // org.bouncycastle.p194crypto.p213params.CramerShoupKeyParameters
    /* renamed from: equals */
    public boolean mo15673equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.m15686getC().equals(this.f20691c) && cramerShoupPublicKeyParameters.m15687getD().equals(this.f20692d) && cramerShoupPublicKeyParameters.m15688getH().equals(this.f20693h) && super.mo15673equals(obj);
    }

    /* renamed from: getC */
    public BigInteger m15686getC() {
        return this.f20691c;
    }

    /* renamed from: getD */
    public BigInteger m15687getD() {
        return this.f20692d;
    }

    /* renamed from: getH */
    public BigInteger m15688getH() {
        return this.f20693h;
    }

    @Override // org.bouncycastle.p194crypto.p213params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((this.f20691c.hashCode() ^ this.f20692d.hashCode()) ^ this.f20693h.hashCode());
    }
}
