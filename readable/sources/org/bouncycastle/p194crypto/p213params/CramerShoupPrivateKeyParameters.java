package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk */
    private CramerShoupPublicKeyParameters f20685pk;

    /* renamed from: x1 */
    private BigInteger f20686x1;

    /* renamed from: x2 */
    private BigInteger f20687x2;

    /* renamed from: y1 */
    private BigInteger f20688y1;

    /* renamed from: y2 */
    private BigInteger f20689y2;

    /* renamed from: z */
    private BigInteger f20690z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f20686x1 = bigInteger;
        this.f20687x2 = bigInteger2;
        this.f20688y1 = bigInteger3;
        this.f20689y2 = bigInteger4;
        this.f20690z = bigInteger5;
    }

    @Override // org.bouncycastle.p194crypto.p213params.CramerShoupKeyParameters
    /* renamed from: equals */
    public boolean mo15673equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.m15680getX1().equals(this.f20686x1) && cramerShoupPrivateKeyParameters.m15681getX2().equals(this.f20687x2) && cramerShoupPrivateKeyParameters.m15682getY1().equals(this.f20688y1) && cramerShoupPrivateKeyParameters.m15683getY2().equals(this.f20689y2) && cramerShoupPrivateKeyParameters.m15684getZ().equals(this.f20690z) && super.mo15673equals(obj);
    }

    /* renamed from: getPk */
    public CramerShoupPublicKeyParameters m15679getPk() {
        return this.f20685pk;
    }

    /* renamed from: getX1 */
    public BigInteger m15680getX1() {
        return this.f20686x1;
    }

    /* renamed from: getX2 */
    public BigInteger m15681getX2() {
        return this.f20687x2;
    }

    /* renamed from: getY1 */
    public BigInteger m15682getY1() {
        return this.f20688y1;
    }

    /* renamed from: getY2 */
    public BigInteger m15683getY2() {
        return this.f20689y2;
    }

    /* renamed from: getZ */
    public BigInteger m15684getZ() {
        return this.f20690z;
    }

    @Override // org.bouncycastle.p194crypto.p213params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((((this.f20686x1.hashCode() ^ this.f20687x2.hashCode()) ^ this.f20688y1.hashCode()) ^ this.f20689y2.hashCode()) ^ this.f20690z.hashCode());
    }

    /* renamed from: setPk */
    public void m15685setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f20685pk = cramerShoupPublicKeyParameters;
    }
}
