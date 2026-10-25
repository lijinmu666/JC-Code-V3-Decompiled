package org.bouncycastle.p133asn1.p143eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1ParsingException;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CVCertificate extends ASN1Object {
    private static int bodyValid = 1;
    private static int signValid = 2;
    private CertificateBody certificateBody;
    private byte[] signature;

    /* renamed from: valid */
    private int f18326valid;

    public CVCertificate(ASN1InputStream aSN1InputStream) throws IOException {
        initFrom(aSN1InputStream);
    }

    public static CVCertificate getInstance(Object obj) {
        if (obj instanceof CVCertificate) {
            return (CVCertificate) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new CVCertificate(ASN1TaggedObject.getInstance(obj, 64));
        } catch (IOException e) {
            throw new ASN1ParsingException("unable to parse data: " + e.getMessage(), e);
        }
    }

    private void initFrom(ASN1InputStream aSN1InputStream) throws IOException {
        while (true) {
            ASN1Primitive object = aSN1InputStream.readObject();
            if (object == null) {
                return;
            }
            if (!(object instanceof ASN1TaggedObject)) {
                throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
            }
            setPrivateData((ASN1TaggedObject) object);
        }
    }

    private void setPrivateData(ASN1TaggedObject aSN1TaggedObject) throws IOException {
        int i;
        int i2;
        this.f18326valid = 0;
        if (!aSN1TaggedObject.mo14457hasTag(64, 33)) {
            throw new IOException("not a CARDHOLDER_CERTIFICATE :" + aSN1TaggedObject.getTagNo());
        }
        Enumeration objects = ASN1Sequence.getInstance(aSN1TaggedObject.getBaseUniversal(false, 16)).getObjects();
        while (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            if (!(objNextElement instanceof ASN1TaggedObject)) {
                throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
            }
            ASN1TaggedObject aSN1TaggedObject2 = ASN1TaggedObject.getInstance(objNextElement, 64);
            int tagNo = aSN1TaggedObject2.getTagNo();
            if (tagNo == 55) {
                this.signature = ASN1OctetString.getInstance(aSN1TaggedObject2.getBaseUniversal(false, 4)).getOctets();
                i = this.f18326valid;
                i2 = signValid;
            } else {
                if (tagNo != 78) {
                    throw new IOException("Invalid tag, not an Iso7816CertificateStructure :" + aSN1TaggedObject2.getTagNo());
                }
                this.certificateBody = CertificateBody.getInstance(aSN1TaggedObject2);
                i = this.f18326valid;
                i2 = bodyValid;
            }
            this.f18326valid = i | i2;
        }
        if (this.f18326valid == (signValid | bodyValid)) {
            return;
        }
        throw new IOException("invalid CARDHOLDER_CERTIFICATE :" + aSN1TaggedObject.getTagNo());
    }

    public CertificationAuthorityReference getAuthorityReference() {
        return this.certificateBody.getCertificationAuthorityReference();
    }

    /* renamed from: getBody */
    public CertificateBody m14589getBody() {
        return this.certificateBody;
    }

    public int getCertificateType() {
        return this.certificateBody.getCertificateType();
    }

    public PackedDate getEffectiveDate() {
        return this.certificateBody.getCertificateEffectiveDate();
    }

    public PackedDate getExpirationDate() {
        return this.certificateBody.getCertificateExpirationDate();
    }

    public ASN1ObjectIdentifier getHolderAuthorization() {
        return this.certificateBody.getCertificateHolderAuthorization().m14593getOid();
    }

    public C5126Flags getHolderAuthorizationRights() {
        return new C5126Flags(this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 31);
    }

    public int getHolderAuthorizationRole() {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 192;
    }

    public CertificateHolderReference getHolderReference() {
        return this.certificateBody.getCertificateHolderReference();
    }

    /* renamed from: getRole */
    public int m14590getRole() {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights();
    }

    public byte[] getSignature() {
        return C6238Arrays.m18231clone(this.signature);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return EACTagged.m14594create(33, new DERSequence(this.certificateBody, EACTagged.m14596create(55, this.signature)));
    }

    private CVCertificate(ASN1TaggedObject aSN1TaggedObject) throws IOException {
        setPrivateData(aSN1TaggedObject);
    }

    public CVCertificate(CertificateBody certificateBody, byte[] bArr) {
        this.certificateBody = certificateBody;
        this.signature = C6238Arrays.m18231clone(bArr);
        this.f18326valid = this.f18326valid | bodyValid | signValid;
    }
}
