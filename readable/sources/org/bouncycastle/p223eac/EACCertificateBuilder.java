package org.bouncycastle.p223eac;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p143eac.CVCertificate;
import org.bouncycastle.p133asn1.p143eac.CertificateBody;
import org.bouncycastle.p133asn1.p143eac.CertificateHolderAuthorization;
import org.bouncycastle.p133asn1.p143eac.CertificateHolderReference;
import org.bouncycastle.p133asn1.p143eac.CertificationAuthorityReference;
import org.bouncycastle.p133asn1.p143eac.PackedDate;
import org.bouncycastle.p133asn1.p143eac.PublicKeyDataObject;
import org.bouncycastle.p223eac.operator.EACSigner;

/* loaded from: classes2.dex */
public class EACCertificateBuilder {
    private static final byte[] ZeroArray = {0};
    private PackedDate certificateEffectiveDate;
    private PackedDate certificateExpirationDate;
    private CertificateHolderAuthorization certificateHolderAuthorization;
    private CertificateHolderReference certificateHolderReference;
    private CertificationAuthorityReference certificationAuthorityReference;
    private PublicKeyDataObject publicKey;

    public EACCertificateBuilder(CertificationAuthorityReference certificationAuthorityReference, PublicKeyDataObject publicKeyDataObject, CertificateHolderReference certificateHolderReference, CertificateHolderAuthorization certificateHolderAuthorization, PackedDate packedDate, PackedDate packedDate2) {
        this.certificationAuthorityReference = certificationAuthorityReference;
        this.publicKey = publicKeyDataObject;
        this.certificateHolderReference = certificateHolderReference;
        this.certificateHolderAuthorization = certificateHolderAuthorization;
        this.certificateEffectiveDate = packedDate;
        this.certificateExpirationDate = packedDate2;
    }

    private CertificateBody buildBody() {
        return new CertificateBody(new DERTaggedObject(false, 64, 41, (ASN1Encodable) new DEROctetString(ZeroArray)), this.certificationAuthorityReference, this.publicKey, this.certificateHolderReference, this.certificateHolderAuthorization, this.certificateEffectiveDate, this.certificateExpirationDate);
    }

    /* renamed from: build */
    public EACCertificateHolder m15947build(EACSigner eACSigner) throws EACException, IOException {
        try {
            CertificateBody certificateBodyBuildBody = buildBody();
            OutputStream outputStream = eACSigner.getOutputStream();
            outputStream.write(certificateBodyBuildBody.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return new EACCertificateHolder(new CVCertificate(certificateBodyBuildBody, eACSigner.getSignature()));
        } catch (Exception e) {
            throw new EACException("unable to process signature: " + e.getMessage(), e);
        }
    }
}
