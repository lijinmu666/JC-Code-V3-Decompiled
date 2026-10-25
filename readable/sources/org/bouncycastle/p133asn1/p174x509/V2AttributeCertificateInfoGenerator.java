package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class V2AttributeCertificateInfoGenerator {

    /* renamed from: endDate */
    private ASN1GeneralizedTime f18702endDate;
    private Extensions extensions;

    /* renamed from: holder */
    private C5190Holder f18703holder;

    /* renamed from: issuer */
    private AttCertIssuer f18704issuer;
    private DERBitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private ASN1GeneralizedTime startDate;

    /* renamed from: version */
    private ASN1Integer f18705version = ASN1Integer.f17918ONE;
    private ASN1EncodableVector attributes = new ASN1EncodableVector();

    public void addAttribute(String str, ASN1Encodable aSN1Encodable) {
        this.attributes.m14420add(new Attribute(new ASN1ObjectIdentifier(str), new C5104DERSet(aSN1Encodable)));
    }

    public AttributeCertificateInfo generateAttributeCertificateInfo() {
        if (this.serialNumber == null || this.signature == null || this.f18704issuer == null || this.startDate == null || this.f18702endDate == null || this.f18703holder == null || this.attributes == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 AttributeCertificateInfo generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        aSN1EncodableVector.m14420add(this.f18705version);
        aSN1EncodableVector.m14420add(this.f18703holder);
        aSN1EncodableVector.m14420add(this.f18704issuer);
        aSN1EncodableVector.m14420add(this.signature);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(new AttCertValidityPeriod(this.startDate, this.f18702endDate));
        aSN1EncodableVector.m14420add(new DERSequence(this.attributes));
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            aSN1EncodableVector.m14420add(dERBitString);
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return AttributeCertificateInfo.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setEndDate(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.f18702endDate = aSN1GeneralizedTime;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public void setHolder(C5190Holder c5190Holder) {
        this.f18703holder = c5190Holder;
    }

    public void setIssuer(AttCertIssuer attCertIssuer) {
        this.f18704issuer = attCertIssuer;
    }

    public void setIssuerUniqueID(DERBitString dERBitString) {
        this.issuerUniqueID = dERBitString;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.serialNumber = aSN1Integer;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setStartDate(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.startDate = aSN1GeneralizedTime;
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.m14420add(attribute);
    }

    public void setExtensions(X509Extensions x509Extensions) {
        this.extensions = Extensions.getInstance(x509Extensions.toASN1Primitive());
    }
}
