package org.bouncycastle.p133asn1.p135bc;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;

/* loaded from: classes.dex */
public class LinkedCertificate extends ASN1Object {

    /* renamed from: cACerts */
    private GeneralNames f18043cACerts;
    private X500Name certIssuer;
    private final GeneralName certLocation;

    /* renamed from: digest */
    private final DigestInfo f18044digest;

    private LinkedCertificate(ASN1Sequence aSN1Sequence) {
        this.f18044digest = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.certLocation = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() > 2) {
            for (int i = 2; i != aSN1Sequence.mo14450size(); i++) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.certIssuer = X500Name.getInstance(aSN1TaggedObject, true);
                } else {
                    if (tagNo != 1) {
                        throw new IllegalArgumentException("unknown tag in tagged field");
                    }
                    this.f18043cACerts = GeneralNames.getInstance(aSN1TaggedObject, false);
                }
            }
        }
    }

    public static LinkedCertificate getInstance(Object obj) {
        if (obj instanceof LinkedCertificate) {
            return (LinkedCertificate) obj;
        }
        if (obj != null) {
            return new LinkedCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getCACerts() {
        return this.f18043cACerts;
    }

    public X500Name getCertIssuer() {
        return this.certIssuer;
    }

    public GeneralName getCertLocation() {
        return this.certLocation;
    }

    public DigestInfo getDigest() {
        return this.f18044digest;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18044digest);
        aSN1EncodableVector.m14420add(this.certLocation);
        X500Name x500Name = this.certIssuer;
        if (x500Name != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) x500Name));
        }
        GeneralNames generalNames = this.f18043cACerts;
        if (generalNames != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) generalNames));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public LinkedCertificate(DigestInfo digestInfo, GeneralName generalName) {
        this(digestInfo, generalName, null, null);
    }

    public LinkedCertificate(DigestInfo digestInfo, GeneralName generalName, X500Name x500Name, GeneralNames generalNames) {
        this.f18044digest = digestInfo;
        this.certLocation = generalName;
        this.certIssuer = x500Name;
        this.f18043cACerts = generalNames;
    }
}
