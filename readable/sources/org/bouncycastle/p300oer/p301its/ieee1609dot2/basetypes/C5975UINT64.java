package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.UINT64 */
/* loaded from: classes2.dex */
public class C5975UINT64 extends UintBase {

    /* renamed from: MAX */
    private static final BigInteger f22778MAX = new BigInteger("18446744073709551615");

    public C5975UINT64(int i) {
        super(i);
    }

    public static C5975UINT64 getInstance(Object obj) {
        if (obj instanceof C5975UINT64) {
            return (C5975UINT64) obj;
        }
        if (obj != null) {
            return new C5975UINT64(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.UintBase
    public void assertLimit() {
        if (this.f22780value.signum() < 0) {
            throw new IllegalArgumentException("value must not be negative");
        }
        BigInteger bigInteger = this.f22780value;
        BigInteger bigInteger2 = f22778MAX;
        if (bigInteger.compareTo(bigInteger2) <= 0) {
            return;
        }
        throw new IllegalArgumentException("value must not exceed " + bigInteger2.toString(16));
    }

    public C5975UINT64(long j) {
        super(j);
    }

    public C5975UINT64(BigInteger bigInteger) {
        super(bigInteger);
    }

    public C5975UINT64(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }
}
