package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* loaded from: classes2.dex */
public class CrlSeries extends C5972UINT16 {
    public CrlSeries(int i) {
        super(i);
    }

    public static CrlSeries getInstance(Object obj) {
        if (obj instanceof CrlSeries) {
            return (CrlSeries) obj;
        }
        if (obj != null) {
            return new CrlSeries(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    public CrlSeries(BigInteger bigInteger) {
        super(bigInteger);
    }
}
