package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class HashAlgorithm extends ASN1Enumerated {

    /* renamed from: sha256 */
    public static final HashAlgorithm f22730sha256 = new HashAlgorithm(BigInteger.ZERO);

    /* renamed from: sha384 */
    public static final HashAlgorithm f22731sha384 = new HashAlgorithm(BigIntegers.f24189ONE);

    public HashAlgorithm(BigInteger bigInteger) {
        super(bigInteger);
        assertValues();
    }

    public static HashAlgorithm getInstance(Object obj) {
        if (obj instanceof HashAlgorithm) {
            return (HashAlgorithm) obj;
        }
        if (obj != null) {
            return new HashAlgorithm(ASN1Enumerated.getInstance(obj));
        }
        return null;
    }

    public void assertValues() {
        int iIntValueExact = BigIntegers.intValueExact(getValue());
        if (iIntValueExact == 0 || iIntValueExact == 1) {
            return;
        }
        throw new IllegalArgumentException("invalid enumeration value " + getValue());
    }

    private HashAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this(aSN1Enumerated.getValue());
    }
}
