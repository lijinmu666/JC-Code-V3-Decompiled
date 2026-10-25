package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* loaded from: classes2.dex */
public class KnownLongitude extends Longitude {
    public KnownLongitude(long j) {
        super(j);
    }

    public static KnownLongitude getInstance(Object obj) {
        if (obj instanceof KnownLongitude) {
            return (KnownLongitude) obj;
        }
        if (obj != null) {
            return new KnownLongitude(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public KnownLongitude(BigInteger bigInteger) {
        super(bigInteger);
    }

    private KnownLongitude(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
