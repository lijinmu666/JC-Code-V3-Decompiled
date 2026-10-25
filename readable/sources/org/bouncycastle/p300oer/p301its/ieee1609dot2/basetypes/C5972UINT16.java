package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.UINT16 */
/* loaded from: classes2.dex */
public class C5972UINT16 extends UintBase {

    /* renamed from: MAX */
    private static final BigInteger f22775MAX = BigInteger.valueOf(65535);

    public C5972UINT16(int i) {
        super(i);
    }

    public static C5972UINT16 getInstance(Object obj) {
        if (obj instanceof C5972UINT16) {
            return (C5972UINT16) obj;
        }
        if (obj != null) {
            return new C5972UINT16(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    /* renamed from: valueOf */
    public static C5972UINT16 m17346valueOf(int i) {
        return new C5972UINT16(i);
    }

    @Override // org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.UintBase
    public void assertLimit() {
        if (this.f22780value.signum() < 0) {
            throw new IllegalArgumentException("value must not be negative");
        }
        BigInteger bigInteger = this.f22780value;
        BigInteger bigInteger2 = f22775MAX;
        if (bigInteger.compareTo(bigInteger2) <= 0) {
            return;
        }
        throw new IllegalArgumentException("value must not exceed " + bigInteger2.toString(16));
    }

    public C5972UINT16(long j) {
        super(j);
    }

    public C5972UINT16(BigInteger bigInteger) {
        super(bigInteger);
    }

    public C5972UINT16(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }
}
