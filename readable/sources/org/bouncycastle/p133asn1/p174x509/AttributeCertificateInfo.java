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

/* loaded from: classes2.dex */
public class AttributeCertificateInfo extends ASN1Object {
    private AttCertValidityPeriod attrCertValidityPeriod;
    private ASN1Sequence attributes;
    private Extensions extensions;

    /* renamed from: holder */
    private C5190Holder f18625holder;

    /* renamed from: issuer */
    private AttCertIssuer f18626issuer;
    private ASN1BitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;

    /* renamed from: version */
    private ASN1Integer f18627version;

    private AttributeCertificateInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 6 || aSN1Sequence.mo14450size() > 9) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.f18627version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.f18627version = ASN1Integer.f17922ZERO;
        }
        this.f18625holder = C5190Holder.getInstance(aSN1Sequence.getObjectAt(i));
        this.f18626issuer = AttCertIssuer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 2));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 3));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(aSN1Sequence.getObjectAt(i + 4));
        this.attributes = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i + 5));
        for (int i2 = i + 6; i2 < aSN1Sequence.mo14450size(); i2++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i2);
            if (objectAt instanceof ASN1BitString) {
                this.issuerUniqueID = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(i2));
            } else if ((objectAt instanceof ASN1Sequence) || (objectAt instanceof Extensions)) {
                this.extensions = Extensions.getInstance(aSN1Sequence.getObjectAt(i2));
            }
        }
    }

    public static AttributeCertificateInfo getInstance(Object obj) {
        if (obj instanceof AttributeCertificateInfo) {
            return (AttributeCertificateInfo) obj;
        }
        if (obj != null) {
            return new AttributeCertificateInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.attrCertValidityPeriod;
    }

    public ASN1Sequence getAttributes() {
        return this.attributes;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public C5190Holder getHolder() {
        return this.f18625holder;
    }

    public AttCertIssuer getIssuer() {
        return this.f18626issuer;
    }

    public ASN1BitString getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public ASN1Integer getVersion() {
        return this.f18627version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        if (!this.f18627version.hasValue(0)) {
            aSN1EncodableVector.m14420add(this.f18627version);
        }
        aSN1EncodableVector.m14420add(this.f18625holder);
        aSN1EncodableVector.m14420add(this.f18626issuer);
        aSN1EncodableVector.m14420add(this.signature);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(this.attrCertValidityPeriod);
        aSN1EncodableVector.m14420add(this.attributes);
        ASN1BitString aSN1BitString = this.issuerUniqueID;
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(aSN1BitString);
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static AttributeCertificateInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
