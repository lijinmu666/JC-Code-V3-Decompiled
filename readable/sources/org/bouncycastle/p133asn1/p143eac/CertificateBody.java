package org.bouncycastle.p133asn1.p143eac;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CertificateBody extends ASN1Object {

    /* renamed from: CAR */
    private static final int f18327CAR = 2;

    /* renamed from: CEfD */
    private static final int f18328CEfD = 32;

    /* renamed from: CExD */
    private static final int f18329CExD = 64;

    /* renamed from: CHA */
    private static final int f18330CHA = 16;

    /* renamed from: CHR */
    private static final int f18331CHR = 8;

    /* renamed from: CPI */
    private static final int f18332CPI = 1;

    /* renamed from: PK */
    private static final int f18333PK = 4;
    public static final int profileType = 127;
    private static final int profileType_m = 127;
    private static final int profileType_r = 0;
    public static final int requestType = 13;
    private static final int requestType_m = 13;
    private static final int requestType_r = 2;
    private ASN1TaggedObject certificateEffectiveDate;
    private ASN1TaggedObject certificateExpirationDate;
    private CertificateHolderAuthorization certificateHolderAuthorization;
    private ASN1TaggedObject certificateHolderReference;
    private ASN1TaggedObject certificateProfileIdentifier;
    private int certificateType = 0;
    private ASN1TaggedObject certificationAuthorityReference;
    private PublicKeyDataObject publicKey;

    /* renamed from: seq */
    ASN1InputStream f18334seq;

    private CertificateBody(ASN1TaggedObject aSN1TaggedObject) throws IOException {
        setIso7816CertificateBody(aSN1TaggedObject);
    }

    public static CertificateBody getInstance(Object obj) {
        if (obj instanceof CertificateBody) {
            return (CertificateBody) obj;
        }
        if (obj != null) {
            return new CertificateBody(ASN1TaggedObject.getInstance(obj, 64));
        }
        return null;
    }

    private ASN1Primitive profileToASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.m14420add(this.certificateProfileIdentifier);
        aSN1EncodableVector.m14420add(this.certificationAuthorityReference);
        aSN1EncodableVector.m14420add(EACTagged.m14595create(73, this.publicKey));
        aSN1EncodableVector.m14420add(this.certificateHolderReference);
        aSN1EncodableVector.m14420add(this.certificateHolderAuthorization);
        aSN1EncodableVector.m14420add(this.certificateEffectiveDate);
        aSN1EncodableVector.m14420add(this.certificateExpirationDate);
        return EACTagged.m14594create(78, new DERSequence(aSN1EncodableVector));
    }

    private ASN1Primitive requestToASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.certificateProfileIdentifier);
        ASN1TaggedObject aSN1TaggedObject = this.certificationAuthorityReference;
        if (aSN1TaggedObject != null) {
            aSN1EncodableVector.m14420add(aSN1TaggedObject);
        }
        aSN1EncodableVector.m14420add(EACTagged.m14595create(73, this.publicKey));
        aSN1EncodableVector.m14420add(this.certificateHolderReference);
        return EACTagged.m14594create(78, new DERSequence(aSN1EncodableVector));
    }

    private void setCertificateEffectiveDate(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.mo14457hasTag(64, 37)) {
            this.certificateEffectiveDate = aSN1TaggedObject;
            this.certificateType |= 32;
        } else {
            throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :" + aSN1TaggedObject.getTagNo());
        }
    }

    private void setCertificateExpirationDate(ASN1TaggedObject aSN1TaggedObject) {
        if (!aSN1TaggedObject.mo14457hasTag(64, 36)) {
            throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
        }
        this.certificateExpirationDate = aSN1TaggedObject;
        this.certificateType |= 64;
    }

    private void setCertificateHolderAuthorization(CertificateHolderAuthorization certificateHolderAuthorization) {
        this.certificateHolderAuthorization = certificateHolderAuthorization;
        this.certificateType |= 16;
    }

    private void setCertificateHolderReference(ASN1TaggedObject aSN1TaggedObject) {
        if (!aSN1TaggedObject.mo14457hasTag(64, 32)) {
            throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
        }
        this.certificateHolderReference = aSN1TaggedObject;
        this.certificateType |= 8;
    }

    private void setCertificateProfileIdentifier(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.mo14457hasTag(64, 41)) {
            this.certificateProfileIdentifier = aSN1TaggedObject;
            this.certificateType |= 1;
        } else {
            throw new IllegalArgumentException("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :" + aSN1TaggedObject.getTagNo());
        }
    }

    private void setCertificationAuthorityReference(ASN1TaggedObject aSN1TaggedObject) {
        if (!aSN1TaggedObject.mo14457hasTag(64, 2)) {
            throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
        }
        this.certificationAuthorityReference = aSN1TaggedObject;
        this.certificateType |= 2;
    }

    private void setIso7816CertificateBody(ASN1TaggedObject aSN1TaggedObject) throws IOException {
        if (!aSN1TaggedObject.mo14457hasTag(64, 78)) {
            throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1TaggedObject.getBaseUniversal(false, 16));
        int iMo14450size = aSN1Sequence.mo14450size();
        for (int i = 0; i < iMo14450size; i++) {
            ASN1TaggedObject aSN1TaggedObject2 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i), 64);
            int tagNo = aSN1TaggedObject2.getTagNo();
            if (tagNo == 2) {
                setCertificationAuthorityReference(aSN1TaggedObject2);
            } else if (tagNo == 32) {
                setCertificateHolderReference(aSN1TaggedObject2);
            } else if (tagNo == 41) {
                setCertificateProfileIdentifier(aSN1TaggedObject2);
            } else if (tagNo == 73) {
                setPublicKey(PublicKeyDataObject.getInstance(aSN1TaggedObject2.getBaseUniversal(false, 16)));
            } else if (tagNo == 76) {
                setCertificateHolderAuthorization(new CertificateHolderAuthorization(aSN1TaggedObject2));
            } else if (tagNo == 36) {
                setCertificateExpirationDate(aSN1TaggedObject2);
            } else {
                if (tagNo != 37) {
                    this.certificateType = 0;
                    throw new IOException("Not a valid iso7816 ASN1TaggedObject tag " + aSN1TaggedObject2.getTagNo());
                }
                setCertificateEffectiveDate(aSN1TaggedObject2);
            }
        }
    }

    private void setPublicKey(PublicKeyDataObject publicKeyDataObject) {
        this.publicKey = PublicKeyDataObject.getInstance(publicKeyDataObject);
        this.certificateType |= 4;
    }

    public PackedDate getCertificateEffectiveDate() {
        if ((this.certificateType & 32) == 32) {
            return new PackedDate(ASN1OctetString.getInstance(this.certificateEffectiveDate.getBaseUniversal(false, 4)).getOctets());
        }
        return null;
    }

    public PackedDate getCertificateExpirationDate() throws IOException {
        if ((this.certificateType & 64) == 64) {
            return new PackedDate(ASN1OctetString.getInstance(this.certificateExpirationDate.getBaseUniversal(false, 4)).getOctets());
        }
        throw new IOException("certificate Expiration Date not set");
    }

    public CertificateHolderAuthorization getCertificateHolderAuthorization() throws IOException {
        if ((this.certificateType & 16) == 16) {
            return this.certificateHolderAuthorization;
        }
        throw new IOException("Certificate Holder Authorisation not set");
    }

    public CertificateHolderReference getCertificateHolderReference() {
        return new CertificateHolderReference(ASN1OctetString.getInstance(this.certificateHolderReference.getBaseUniversal(false, 4)).getOctets());
    }

    public ASN1TaggedObject getCertificateProfileIdentifier() {
        return this.certificateProfileIdentifier;
    }

    public int getCertificateType() {
        return this.certificateType;
    }

    public CertificationAuthorityReference getCertificationAuthorityReference() throws IOException {
        if ((this.certificateType & 2) == 2) {
            return new CertificationAuthorityReference(ASN1OctetString.getInstance(this.certificationAuthorityReference.getBaseUniversal(false, 4)).getOctets());
        }
        throw new IOException("Certification authority reference not set");
    }

    public PublicKeyDataObject getPublicKey() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            int i = this.certificateType;
            if (i == 127) {
                return profileToASN1Object();
            }
            if ((i & (-3)) == 13) {
                return requestToASN1Object();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public CertificateBody(ASN1TaggedObject aSN1TaggedObject, CertificationAuthorityReference certificationAuthorityReference, PublicKeyDataObject publicKeyDataObject, CertificateHolderReference certificateHolderReference, CertificateHolderAuthorization certificateHolderAuthorization, PackedDate packedDate, PackedDate packedDate2) {
        setCertificateProfileIdentifier(aSN1TaggedObject);
        setCertificationAuthorityReference(EACTagged.m14596create(2, certificationAuthorityReference.getEncoded()));
        setPublicKey(publicKeyDataObject);
        setCertificateHolderReference(EACTagged.m14596create(32, certificateHolderReference.getEncoded()));
        setCertificateHolderAuthorization(certificateHolderAuthorization);
        setCertificateEffectiveDate(EACTagged.m14596create(37, packedDate.getEncoding()));
        setCertificateExpirationDate(EACTagged.m14596create(36, packedDate2.getEncoding()));
    }
}
