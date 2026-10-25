package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.UINT8 */
/* loaded from: classes2.dex */
public class C5976UINT8 extends UintBase {

    /* renamed from: MAX */
    private static final BigInteger f22779MAX = BigInteger.valueOf(255);

    public C5976UINT8(int i) {
        super(i);
    }

    public static C5976UINT8 getInstance(Object obj) {
        if (obj instanceof C5976UINT8) {
            return (C5976UINT8) obj;
        }
        if (obj != null) {
            return new C5976UINT8(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.UintBase
    public void assertLimit() {
        if (this.f22780value.signum() < 0) {
            throw new IllegalArgumentException("value must not be negative");
        }
        BigInteger bigInteger = this.f22780value;
        BigInteger bigInteger2 = f22779MAX;
        if (bigInteger.compareTo(bigInteger2) <= 0) {
            return;
        }
        throw new IllegalArgumentException("value 0x" + this.f22780value.toString(16) + "  must not exceed 0x" + bigInteger2.toString(16));
    }

    public C5976UINT8(long j) {
        super(j);
    }

    public C5976UINT8(BigInteger bigInteger) {
        super(bigInteger);
    }

    public C5976UINT8(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }
}
