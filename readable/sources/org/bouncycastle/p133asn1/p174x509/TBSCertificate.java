package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class TBSCertificate extends ASN1Object {
    Extensions extensions;

    /* renamed from: issuer */
    X500Name f18687issuer;
    ASN1BitString issuerUniqueId;

    /* renamed from: seq */
    ASN1Sequence f18688seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;

    /* renamed from: subject */
    X500Name f18689subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    ASN1BitString subjectUniqueId;
    Validity validity;

    /* renamed from: version */
    ASN1Integer f18690version;

    public TBSCertificate(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, AlgorithmIdentifier algorithmIdentifier, X500Name x500Name, Validity validity, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1BitString aSN1BitString, ASN1BitString aSN1BitString2, Extensions extensions) {
        if (aSN1Integer2 == null) {
            throw new NullPointerException("'serialNumber' cannot be null");
        }
        if (algorithmIdentifier == null) {
            throw new NullPointerException("'signature' cannot be null");
        }
        if (x500Name == null) {
            throw new NullPointerException("'issuer' cannot be null");
        }
        if (validity == null) {
            throw new NullPointerException("'validity' cannot be null");
        }
        if (x500Name2 == null) {
            throw new NullPointerException("'subject' cannot be null");
        }
        if (subjectPublicKeyInfo == null) {
            throw new NullPointerException("'subjectPublicKeyInfo' cannot be null");
        }
        this.f18690version = aSN1Integer == null ? ASN1Integer.f17922ZERO : aSN1Integer;
        this.serialNumber = aSN1Integer2;
        this.signature = algorithmIdentifier;
        this.f18687issuer = x500Name;
        this.validity = validity;
        this.f18689subject = x500Name2;
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        this.issuerUniqueId = aSN1BitString;
        this.subjectUniqueId = aSN1BitString2;
        this.extensions = extensions;
        this.f18688seq = null;
    }

    public static TBSCertificate getInstance(Object obj) {
        if (obj instanceof TBSCertificate) {
            return (TBSCertificate) obj;
        }
        if (obj != null) {
            return new TBSCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5194Time getEndDate() {
        return this.validity.getNotAfter();
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.f18687issuer;
    }

    public ASN1BitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public C5194Time getStartDate() {
        return this.validity.getNotBefore();
    }

    public X500Name getSubject() {
        return this.f18689subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public ASN1BitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public Validity getValidity() {
        return this.validity;
    }

    public ASN1Integer getVersion() {
        return this.f18690version;
    }

    public int getVersionNumber() {
        return this.f18690version.intValueExact() + 1;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.f18688seq == null || (Properties.getPropertyValue("org.bouncycastle.x509.allow_non-der_tbscert") != null && !Properties.isOverrideSet("org.bouncycastle.x509.allow_non-der_tbscert"))) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
            if (!this.f18690version.hasValue(0)) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) this.f18690version));
            }
            aSN1EncodableVector.m14420add(this.serialNumber);
            aSN1EncodableVector.m14420add(this.signature);
            aSN1EncodableVector.m14420add(this.f18687issuer);
            aSN1EncodableVector.m14420add(this.validity);
            aSN1EncodableVector.m14420add(this.f18689subject);
            aSN1EncodableVector.m14420add(this.subjectPublicKeyInfo);
            ASN1BitString aSN1BitString = this.issuerUniqueId;
            if (aSN1BitString != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1BitString));
            }
            ASN1BitString aSN1BitString2 = this.subjectUniqueId;
            if (aSN1BitString2 != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) aSN1BitString2));
            }
            Extensions extensions = this.extensions;
            if (extensions != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(true, 3, (ASN1Encodable) extensions));
            }
            return new DERSequence(aSN1EncodableVector);
        }
        return this.f18688seq;
    }

    private TBSCertificate(ASN1Sequence aSN1Sequence) {
        int i;
        boolean z;
        boolean z2;
        this.f18688seq = aSN1Sequence;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.f18690version = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 0;
        } else {
            this.f18690version = ASN1Integer.f17922ZERO;
            i = -1;
        }
        if (this.f18690version.hasValue(0)) {
            z2 = false;
            z = true;
        } else if (this.f18690version.hasValue(1)) {
            z = false;
            z2 = true;
        } else {
            if (!this.f18690version.hasValue(2)) {
                throw new IllegalArgumentException("version number not recognised");
            }
            z = false;
            z2 = false;
        }
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 2));
        this.f18687issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(i + 3));
        this.validity = Validity.getInstance(aSN1Sequence.getObjectAt(i + 4));
        this.f18689subject = X500Name.getInstance(aSN1Sequence.getObjectAt(i + 5));
        int i2 = i + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i2));
        int iMo14450size = (aSN1Sequence.mo14450size() - i2) - 1;
        if (iMo14450size != 0 && z) {
            throw new IllegalArgumentException("version 1 certificate contains extra data");
        }
        while (iMo14450size > 0) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i2 + iMo14450size);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 1) {
                this.issuerUniqueId = ASN1BitString.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 2) {
                this.subjectUniqueId = ASN1BitString.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 3) {
                    throw new IllegalArgumentException("Unknown tag encountered in structure: " + aSN1TaggedObject.getTagNo());
                }
                if (z2) {
                    throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
                }
                this.extensions = Extensions.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
            }
            iMo14450size--;
        }
    }

    public static TBSCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
