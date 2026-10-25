package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class CramerShoupParameters implements CipherParameters {

    /* renamed from: H */
    private InterfaceC5277Digest f20681H;

    /* renamed from: g1 */
    private BigInteger f20682g1;

    /* renamed from: g2 */
    private BigInteger f20683g2;

    /* renamed from: p */
    private BigInteger f20684p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, InterfaceC5277Digest interfaceC5277Digest) {
        this.f20684p = bigInteger;
        this.f20682g1 = bigInteger2;
        this.f20683g2 = bigInteger3;
        InterfaceC5277Digest interfaceC5277Digest2 = (InterfaceC5277Digest) ((Memoable) interfaceC5277Digest).mo14823copy();
        this.f20681H = interfaceC5277Digest2;
        interfaceC5277Digest2.mo14968reset();
    }

    /* renamed from: equals */
    public boolean m15674equals(Object obj) {
        if (!(obj instanceof CramerShoupParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        return cramerShoupParameters.m15678getP().equals(this.f20684p) && cramerShoupParameters.m15675getG1().equals(this.f20682g1) && cramerShoupParameters.m15676getG2().equals(this.f20683g2);
    }

    /* renamed from: getG1 */
    public BigInteger m15675getG1() {
        return this.f20682g1;
    }

    /* renamed from: getG2 */
    public BigInteger m15676getG2() {
        return this.f20683g2;
    }

    /* renamed from: getH */
    public InterfaceC5277Digest m15677getH() {
        return (InterfaceC5277Digest) ((Memoable) this.f20681H).mo14823copy();
    }

    /* renamed from: getP */
    public BigInteger m15678getP() {
        return this.f20684p;
    }

    public int hashCode() {
        return m15676getG2().hashCode() ^ (m15678getP().hashCode() ^ m15675getG1().hashCode());
    }
}
