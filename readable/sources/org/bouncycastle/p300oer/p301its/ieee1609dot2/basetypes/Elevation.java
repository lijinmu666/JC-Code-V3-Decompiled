package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* loaded from: classes2.dex */
public class Elevation extends C5972UINT16 {
    public Elevation(int i) {
        super(i);
    }

    public static Elevation getInstance(Object obj) {
        if (obj instanceof Elevation) {
            return (Elevation) obj;
        }
        if (obj != null) {
            return new Elevation(C5972UINT16.getInstance(obj));
        }
        return null;
    }

    public Elevation(long j) {
        super(j);
    }

    public Elevation(BigInteger bigInteger) {
        super(bigInteger);
    }

    public Elevation(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }

    public Elevation(C5972UINT16 c5972uint16) {
        super(c5972uint16.getValue());
    }
}
