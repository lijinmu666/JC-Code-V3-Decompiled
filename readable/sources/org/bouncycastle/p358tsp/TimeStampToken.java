package org.bouncycastle.p358tsp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p146ess.ESSCertID;
import org.bouncycastle.p133asn1.p146ess.ESSCertIDv2;
import org.bouncycastle.p133asn1.p146ess.SigningCertificate;
import org.bouncycastle.p133asn1.p146ess.SigningCertificateV2;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p169tsp.C5186TSTInfo;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSSignedData;
import org.bouncycastle.p191cms.CMSTypedData;
import org.bouncycastle.p191cms.SignerId;
import org.bouncycastle.p191cms.SignerInformation;
import org.bouncycastle.p191cms.SignerInformationVerifier;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class TimeStampToken {

    /* renamed from: certID */
    ESSCertIDv2 f24160certID;

    /* renamed from: tsToken */
    CMSSignedData f24161tsToken;
    SignerInformation tsaSignerInfo;

    /* renamed from: tstInfo */
    TimeStampTokenInfo f24162tstInfo;

    public TimeStampToken(ContentInfo contentInfo) {
        this(getSignedData(contentInfo));
    }

    private static CMSSignedData getSignedData(ContentInfo contentInfo) throws TSPException {
        try {
            return new CMSSignedData(contentInfo);
        } catch (CMSException e) {
            throw new TSPException("TSP parsing error: " + e.getMessage(), e.getCause());
        }
    }

    public InterfaceC6249Store<X509AttributeCertificateHolder> getAttributeCertificates() {
        return this.f24161tsToken.getAttributeCertificates();
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store<X509CRLHolder> m18206getCRLs() {
        return this.f24161tsToken.m14867getCRLs();
    }

    public InterfaceC6249Store<X509CertificateHolder> getCertificates() {
        return this.f24161tsToken.getCertificates();
    }

    public byte[] getEncoded() {
        return this.f24161tsToken.getEncoded(ASN1Encoding.f17903DL);
    }

    /* renamed from: getSID */
    public SignerId m18207getSID() {
        return this.tsaSignerInfo.m14901getSID();
    }

    public AttributeTable getSignedAttributes() {
        return this.tsaSignerInfo.getSignedAttributes();
    }

    public TimeStampTokenInfo getTimeStampInfo() {
        return this.f24162tstInfo;
    }

    public AttributeTable getUnsignedAttributes() {
        return this.tsaSignerInfo.getUnsignedAttributes();
    }

    public boolean isSignatureValid(SignerInformationVerifier signerInformationVerifier) throws TSPException {
        try {
            return this.tsaSignerInfo.m14902verify(signerInformationVerifier);
        } catch (CMSException e) {
            if (e.getUnderlyingException() != null) {
                throw new TSPException(e.getMessage(), e.getUnderlyingException());
            }
            throw new TSPException("CMS exception: " + e, e);
        }
    }

    public CMSSignedData toCMSSignedData() {
        return this.f24161tsToken;
    }

    public void validate(SignerInformationVerifier signerInformationVerifier) {
        if (!signerInformationVerifier.hasAssociatedCertificate()) {
            throw new IllegalArgumentException("verifier provider needs an associated certificate");
        }
        try {
            X509CertificateHolder associatedCertificate = signerInformationVerifier.getAssociatedCertificate();
            DigestCalculator digestCalculator = signerInformationVerifier.getDigestCalculator(this.f24160certID.getHashAlgorithm());
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(associatedCertificate.getEncoded());
            outputStream.close();
            if (!C6238Arrays.constantTimeAreEqual(this.f24160certID.getCertHashObject().getOctets(), digestCalculator.getDigest())) {
                throw new TSPValidationException("certificate hash does not match certID hash.");
            }
            IssuerSerial issuerSerial = this.f24160certID.getIssuerSerial();
            if (issuerSerial != null) {
                Certificate aSN1Structure = associatedCertificate.toASN1Structure();
                if (!issuerSerial.getSerial().m14446equals((ASN1Primitive) aSN1Structure.getSerialNumber())) {
                    throw new TSPValidationException("certificate serial number does not match certID for signature.");
                }
                GeneralName[] names = issuerSerial.getIssuer().getNames();
                for (int i = 0; i != names.length; i++) {
                    if (names[i].getTagNo() != 4 || !X500Name.getInstance(names[i].m14690getName()).mo14431equals(aSN1Structure.getIssuer())) {
                    }
                }
                throw new TSPValidationException("certificate name does not match certID for signature. ");
            }
            C6230TSPUtil.validateCertificate(associatedCertificate);
            if (!associatedCertificate.isValidOn(this.f24162tstInfo.getGenTime())) {
                throw new TSPValidationException("certificate not valid when time stamp created.");
            }
            if (!this.tsaSignerInfo.m14902verify(signerInformationVerifier)) {
                throw new TSPValidationException("signature not created by certificate.");
            }
        } catch (IOException e) {
            throw new TSPException("problem processing certificate: " + e, e);
        } catch (CMSException e2) {
            if (e2.getUnderlyingException() != null) {
                throw new TSPException(e2.getMessage(), e2.getUnderlyingException());
            }
            throw new TSPException("CMS exception: " + e2, e2);
        } catch (OperatorCreationException e3) {
            throw new TSPException("unable to create digest: " + e3.getMessage(), e3);
        }
    }

    public TimeStampToken(CMSSignedData cMSSignedData) throws TSPException {
        ESSCertIDv2 eSSCertIDv2;
        this.f24161tsToken = cMSSignedData;
        if (!cMSSignedData.getSignedContentTypeOID().equals(PKCSObjectIdentifiers.id_ct_TSTInfo.m14433getId())) {
            throw new TSPValidationException("ContentInfo object not for a time stamp.");
        }
        Collection<SignerInformation> signers = this.f24161tsToken.getSignerInfos().getSigners();
        if (signers.size() != 1) {
            throw new IllegalArgumentException("Time-stamp token signed by " + signers.size() + " signers, but it must contain just the TSA signature.");
        }
        this.tsaSignerInfo = signers.iterator().next();
        try {
            CMSTypedData signedContent = this.f24161tsToken.getSignedContent();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            signedContent.mo14759write(byteArrayOutputStream);
            this.f24162tstInfo = new TimeStampTokenInfo(C5186TSTInfo.getInstance(byteArrayOutputStream.toByteArray()));
            Attribute attributeM14530get = this.tsaSignerInfo.getSignedAttributes().m14530get(PKCSObjectIdentifiers.id_aa_signingCertificate);
            if (attributeM14530get != null) {
                eSSCertIDv2 = ESSCertIDv2.m14606from(ESSCertID.getInstance(SigningCertificate.getInstance(attributeM14530get.getAttrValues().getObjectAt(0)).getCerts()[0]));
            } else {
                Attribute attributeM14530get2 = this.tsaSignerInfo.getSignedAttributes().m14530get(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
                if (attributeM14530get2 == null) {
                    throw new TSPValidationException("no signing certificate attribute found, time stamp invalid.");
                }
                eSSCertIDv2 = ESSCertIDv2.getInstance(SigningCertificateV2.getInstance(attributeM14530get2.getAttrValues().getObjectAt(0)).getCerts()[0]);
            }
            this.f24160certID = eSSCertIDv2;
        } catch (CMSException e) {
            throw new TSPException(e.getMessage(), e.getUnderlyingException());
        }
    }

    public byte[] getEncoded(String str) {
        return this.f24161tsToken.getEncoded(str);
    }
}
