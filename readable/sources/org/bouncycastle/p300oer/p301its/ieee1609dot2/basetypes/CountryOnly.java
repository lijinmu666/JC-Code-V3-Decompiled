package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;

/* loaded from: classes2.dex */
public class CountryOnly extends C5972UINT16 implements RegionInterface {
    public CountryOnly(int i) {
        super(i);
    }

    public static CountryOnly getInstance(Object obj) {
        if (obj instanceof CountryOnly) {
            return (CountryOnly) obj;
        }
        if (obj != null) {
            return new CountryOnly(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    public CountryOnly(BigInteger bigInteger) {
        super(bigInteger);
    }
}
