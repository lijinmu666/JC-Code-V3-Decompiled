package org.bouncycastle.p133asn1.p137cmc;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* renamed from: org.bouncycastle.asn1.cmc.GetCert */
/* loaded from: classes.dex */
public class C5109GetCert extends ASN1Object {
    private final GeneralName issuerName;
    private final BigInteger serialNumber;

    private C5109GetCert(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.issuerName = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
    }

    public static C5109GetCert getInstance(Object obj) {
        if (obj instanceof C5109GetCert) {
            return (C5109GetCert) obj;
        }
        if (obj != null) {
            return new C5109GetCert(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getIssuerName() {
        return this.issuerName;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.issuerName, new ASN1Integer(this.serialNumber));
    }

    public C5109GetCert(GeneralName generalName, BigInteger bigInteger) {
        this.issuerName = generalName;
        this.serialNumber = bigInteger;
    }
}
