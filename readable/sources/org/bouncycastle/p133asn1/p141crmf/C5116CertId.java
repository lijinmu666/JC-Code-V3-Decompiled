package org.bouncycastle.p133asn1.p141crmf;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* renamed from: org.bouncycastle.asn1.crmf.CertId */
/* loaded from: classes2.dex */
public class C5116CertId extends ASN1Object {

    /* renamed from: issuer */
    private GeneralName f18246issuer;
    private ASN1Integer serialNumber;

    private C5116CertId(ASN1Sequence aSN1Sequence) {
        this.f18246issuer = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static C5116CertId getInstance(Object obj) {
        if (obj instanceof C5116CertId) {
            return (C5116CertId) obj;
        }
        if (obj != null) {
            return new C5116CertId(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getIssuer() {
        return this.f18246issuer;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18246issuer, this.serialNumber);
    }

    public C5116CertId(GeneralName generalName, BigInteger bigInteger) {
        this(generalName, new ASN1Integer(bigInteger));
    }

    public static C5116CertId getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public C5116CertId(GeneralName generalName, ASN1Integer aSN1Integer) {
        this.f18246issuer = generalName;
        this.serialNumber = aSN1Integer;
    }
}
