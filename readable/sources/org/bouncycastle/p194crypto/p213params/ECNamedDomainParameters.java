package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p176x9.ECNamedCurveTable;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECConstants;

/* loaded from: classes2.dex */
public class ECNamedDomainParameters extends ECDomainParameters {

    /* renamed from: name */
    private ASN1ObjectIdentifier f20739name;

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParameters x9ECParameters) {
        super(x9ECParameters);
        this.f20739name = aSN1ObjectIdentifier;
    }

    /* renamed from: lookup */
    public static ECNamedDomainParameters m15725lookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = CustomNamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID == null) {
            byOID = ECNamedCurveTable.getByOID(aSN1ObjectIdentifier);
        }
        return new ECNamedDomainParameters(aSN1ObjectIdentifier, byOID);
    }

    /* renamed from: getName */
    public ASN1ObjectIdentifier m15726getName() {
        return this.f20739name;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECDomainParameters eCDomainParameters) {
        super(eCDomainParameters.getCurve(), eCDomainParameters.m15720getG(), eCDomainParameters.m15723getN(), eCDomainParameters.m15721getH(), eCDomainParameters.m15724getSeed());
        this.f20739name = aSN1ObjectIdentifier;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger) {
        this(aSN1ObjectIdentifier, abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, ECConstants.f22091ONE, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(aSN1ObjectIdentifier, abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, bigInteger2, null);
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5817ECCurve abstractC5817ECCurve, AbstractC5820ECPoint abstractC5820ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(abstractC5817ECCurve, abstractC5820ECPoint, bigInteger, bigInteger2, bArr);
        this.f20739name = aSN1ObjectIdentifier;
    }
}
