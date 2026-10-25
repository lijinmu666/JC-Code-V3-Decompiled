package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: G */
    private AbstractC5820ECPoint f22058G;

    /* renamed from: curve */
    private AbstractC5817ECCurve f22059curve;

    /* renamed from: h */
    private BigInteger f22060h;

    /* renamed from: n */
    private BigInteger f22061n;

    /* renamed from: seed */
    private byte[] f22062seed;

    public ECParameterSpec(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        this.f22059curve = abstractC5817ECCurve;
        this.f22058G = abstractC5820ECPoint.normalize();
        this.f22061n = bigInteger;
        this.f22060h = BigInteger.valueOf(1L);
        this.f22062seed = null;
    }

    /* renamed from: equals */
    public boolean m16268equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        return getCurve().m16297equals(eCParameterSpec.getCurve()) && m16269getG().m16333equals(eCParameterSpec.m16269getG());
    }

    public AbstractC5817ECCurve getCurve() {
        return this.f22059curve;
    }

    /* renamed from: getG */
    public AbstractC5820ECPoint m16269getG() {
        return this.f22058G;
    }

    /* renamed from: getH */
    public BigInteger m16270getH() {
        return this.f22060h;
    }

    /* renamed from: getN */
    public BigInteger m16271getN() {
        return this.f22061n;
    }

    /* renamed from: getSeed */
    public byte[] m16272getSeed() {
        return this.f22062seed;
    }

    public int hashCode() {
        return m16269getG().hashCode() ^ getCurve().hashCode();
    }

    public ECParameterSpec(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f22059curve = abstractC5817ECCurve;
        this.f22058G = abstractC5820ECPoint.normalize();
        this.f22061n = bigInteger;
        this.f22060h = bigInteger2;
        this.f22062seed = null;
    }

    public ECParameterSpec(AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f22059curve = abstractC5817ECCurve;
        this.f22058G = abstractC5820ECPoint.normalize();
        this.f22061n = bigInteger;
        this.f22060h = bigInteger2;
        this.f22062seed = bArr;
    }
}
