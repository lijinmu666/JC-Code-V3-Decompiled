package org.bouncycastle.p281jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p232bsi.BSIObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p234eac.EACObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p238isara.IsaraObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p164ocsp.BasicOCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.C5131CertID;
import org.bouncycastle.p133asn1.p164ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.p133asn1.p164ocsp.OCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.ResponderID;
import org.bouncycastle.p133asn1.p164ocsp.ResponseBytes;
import org.bouncycastle.p133asn1.p164ocsp.ResponseData;
import org.bouncycastle.p133asn1.p164ocsp.RevokedInfo;
import org.bouncycastle.p133asn1.p164ocsp.SingleResponse;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSASSAPSSparams;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;
import org.bouncycastle.p133asn1.p172x500.p173style.BCStrictStyle;
import org.bouncycastle.p133asn1.p174x509.AccessDescription;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AuthorityInformationAccess;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.KeyPurposeId;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p249jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.MessageDigestUtils;
import org.bouncycastle.p281jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
class ProvOcspRevocationChecker implements PKIXCertRevocationChecker {
    private static final int DEFAULT_OCSP_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_OCSP_TIMEOUT = 15000;

    /* renamed from: oids */
    private static final Map f22032oids;

    /* renamed from: helper */
    private final JcaJceHelper f22033helper;
    private boolean isEnabledOCSP;

    /* renamed from: ocspURL */
    private String f22034ocspURL;
    private PKIXCertRevocationCheckerParameters parameters;

    /* renamed from: parent */
    private final ProvRevocationChecker f22035parent;

    static {
        HashMap map = new HashMap();
        f22032oids = map;
        map.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        map.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        map.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        map.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        map.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        map.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        map.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        map.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHECGOST3410-2012-256");
        map.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHECGOST3410-2012-512");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        map.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        map.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        map.put(IsaraObjectIdentifiers.id_alg_xmss, "XMSS");
        map.put(IsaraObjectIdentifiers.id_alg_xmssmt, "XMSSMT");
        map.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        map.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        map.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        map.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        map.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        map.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        map.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
    }

    public ProvOcspRevocationChecker(ProvRevocationChecker provRevocationChecker, JcaJceHelper jcaJceHelper) {
        this.f22035parent = provRevocationChecker;
        this.f22033helper = jcaJceHelper;
    }

    private static byte[] calcKeyHash(MessageDigest messageDigest, PublicKey publicKey) {
        return messageDigest.digest(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getPublicKeyData().getBytes());
    }

    private C5131CertID createCertID(C5131CertID c5131CertID, Certificate certificate, ASN1Integer aSN1Integer) {
        return createCertID(c5131CertID.getHashAlgorithm(), certificate, aSN1Integer);
    }

    private Certificate extractCert() throws CertPathValidatorException {
        try {
            return Certificate.getInstance(this.parameters.getSigningCert().getEncoded());
        } catch (Exception e) {
            throw new CertPathValidatorException("cannot process signing cert: " + e.getMessage(), e, this.parameters.getCertPath(), this.parameters.getIndex());
        }
    }

    private static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String digestName = MessageDigestUtils.getDigestName(aSN1ObjectIdentifier);
        int iIndexOf = digestName.indexOf(45);
        if (iIndexOf <= 0 || digestName.startsWith("SHA3")) {
            return digestName;
        }
        return digestName.substring(0, iIndexOf) + digestName.substring(iIndexOf + 1);
    }

    public static URI getOcspResponderURI(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityInfoAccess.m14433getId());
        if (extensionValue == null) {
            return null;
        }
        AccessDescription[] accessDescriptions = AuthorityInformationAccess.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getAccessDescriptions();
        for (int i = 0; i != accessDescriptions.length; i++) {
            AccessDescription accessDescription = accessDescriptions[i];
            if (AccessDescription.id_ad_ocsp.m14446equals((ASN1Primitive) accessDescription.getAccessMethod())) {
                GeneralName accessLocation = accessDescription.getAccessLocation();
                if (accessLocation.getTagNo() == 6) {
                    try {
                        return new URI(((ASN1String) accessLocation.m14690getName()).getString());
                    } catch (URISyntaxException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || C5103DERNull.INSTANCE.m14445equals(parameters) || !algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            Map map = f22032oids;
            boolean zContainsKey = map.containsKey(algorithmIdentifier.getAlgorithm());
            ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
            return zContainsKey ? (String) map.get(algorithm) : algorithm.m14433getId();
        }
        return getDigestName(RSASSAPSSparams.getInstance(parameters).getHashAlgorithm().getAlgorithm()) + "WITHRSAANDMGF1";
    }

    private static X509Certificate getSignerCert(BasicOCSPResponse basicOCSPResponse, X509Certificate x509Certificate, X509Certificate x509Certificate2, JcaJceHelper jcaJceHelper) {
        ResponderID responderID = basicOCSPResponse.getTbsResponseData().getResponderID();
        byte[] keyHash = responderID.getKeyHash();
        if (keyHash != null) {
            MessageDigest messageDigestCreateMessageDigest = jcaJceHelper.createMessageDigest("SHA1");
            if (x509Certificate2 != null && C6238Arrays.areEqual(keyHash, calcKeyHash(messageDigestCreateMessageDigest, x509Certificate2.getPublicKey()))) {
                return x509Certificate2;
            }
            if (x509Certificate == null || !C6238Arrays.areEqual(keyHash, calcKeyHash(messageDigestCreateMessageDigest, x509Certificate.getPublicKey()))) {
                return null;
            }
            return x509Certificate;
        }
        X500NameStyle x500NameStyle = BCStrictStyle.INSTANCE;
        X500Name x500Name = X500Name.getInstance(x500NameStyle, responderID.m14623getName());
        if (x509Certificate2 != null && x500Name.mo14431equals(X500Name.getInstance(x500NameStyle, x509Certificate2.getSubjectX500Principal().getEncoded()))) {
            return x509Certificate2;
        }
        if (x509Certificate == null || !x500Name.mo14431equals(X500Name.getInstance(x500NameStyle, x509Certificate.getSubjectX500Principal().getEncoded()))) {
            return null;
        }
        return x509Certificate;
    }

    private static boolean isEqualAlgId(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (algorithmIdentifier == algorithmIdentifier2 || algorithmIdentifier.mo14431equals(algorithmIdentifier2)) {
            return true;
        }
        if (!algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm())) {
            return false;
        }
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        ASN1Encodable parameters2 = algorithmIdentifier2.getParameters();
        if (parameters == parameters2) {
            return true;
        }
        if (parameters == null) {
            return C5103DERNull.INSTANCE.m14445equals(parameters2);
        }
        if (C5103DERNull.INSTANCE.m14445equals(parameters) && parameters2 == null) {
            return true;
        }
        return parameters.equals(parameters2);
    }

    private static boolean responderMatches(ResponderID responderID, X509Certificate x509Certificate, JcaJceHelper jcaJceHelper) {
        byte[] keyHash = responderID.getKeyHash();
        if (keyHash != null) {
            return C6238Arrays.areEqual(keyHash, calcKeyHash(jcaJceHelper.createMessageDigest("SHA1"), x509Certificate.getPublicKey()));
        }
        X500NameStyle x500NameStyle = BCStrictStyle.INSTANCE;
        return X500Name.getInstance(x500NameStyle, responderID.m14623getName()).mo14431equals(X500Name.getInstance(x500NameStyle, x509Certificate.getSubjectX500Principal().getEncoded()));
    }

    public static boolean validatedOcspResponse(BasicOCSPResponse basicOCSPResponse, PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, byte[] bArr, X509Certificate x509Certificate, JcaJceHelper jcaJceHelper) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, CertPathValidatorException, CertificateException, NoSuchProviderException {
        try {
            ASN1Sequence certs = basicOCSPResponse.getCerts();
            Signature signatureCreateSignature = jcaJceHelper.createSignature(getSignatureName(basicOCSPResponse.getSignatureAlgorithm()));
            X509Certificate signerCert = getSignerCert(basicOCSPResponse, pKIXCertRevocationCheckerParameters.getSigningCert(), x509Certificate, jcaJceHelper);
            if (signerCert == null && certs == null) {
                throw new CertPathValidatorException("OCSP responder certificate not found");
            }
            if (signerCert != null) {
                signatureCreateSignature.initVerify(signerCert.getPublicKey());
            } else {
                X509Certificate x509Certificate2 = (X509Certificate) jcaJceHelper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(certs.getObjectAt(0).toASN1Primitive().getEncoded()));
                x509Certificate2.verify(pKIXCertRevocationCheckerParameters.getSigningCert().getPublicKey());
                x509Certificate2.checkValidity(pKIXCertRevocationCheckerParameters.getValidDate());
                if (!responderMatches(basicOCSPResponse.getTbsResponseData().getResponderID(), x509Certificate2, jcaJceHelper)) {
                    throw new CertPathValidatorException("responder certificate does not match responderID", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                }
                List<String> extendedKeyUsage = x509Certificate2.getExtendedKeyUsage();
                if (extendedKeyUsage == null || !extendedKeyUsage.contains(KeyPurposeId.id_kp_OCSPSigning.m14695getId())) {
                    throw new CertPathValidatorException("responder certificate not valid for signing OCSP responses", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                }
                signatureCreateSignature.initVerify(x509Certificate2);
            }
            signatureCreateSignature.update(basicOCSPResponse.getTbsResponseData().getEncoded(ASN1Encoding.f17902DER));
            if (!signatureCreateSignature.verify(basicOCSPResponse.getSignature().getOctets())) {
                return false;
            }
            if (bArr != null && !C6238Arrays.areEqual(bArr, basicOCSPResponse.getTbsResponseData().getResponseExtensions().getExtension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce).getExtnValue().getOctets())) {
                throw new CertPathValidatorException("nonce mismatch in OCSP response", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
            }
            return true;
        } catch (IOException e) {
            throw new CertPathValidatorException("OCSP response failure: " + e.getMessage(), e, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        } catch (CertPathValidatorException e2) {
            throw e2;
        } catch (GeneralSecurityException e3) {
            throw new CertPathValidatorException("OCSP response failure: " + e3.getMessage(), e3, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        }
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    /* renamed from: check */
    public void mo16075check(java.security.cert.Certificate certificate) {
        byte[] bArr;
        boolean z;
        X509Certificate x509Certificate = (X509Certificate) certificate;
        Map<X509Certificate, byte[]> ocspResponses = this.f22035parent.getOcspResponses();
        URI ocspResponder = this.f22035parent.getOcspResponder();
        if (ocspResponder == null) {
            if (this.f22034ocspURL != null) {
                try {
                    ocspResponder = new URI(this.f22034ocspURL);
                } catch (URISyntaxException e) {
                    throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, this.parameters.getCertPath(), this.parameters.getIndex());
                }
            } else {
                ocspResponder = getOcspResponderURI(x509Certificate);
            }
        }
        URI uri = ocspResponder;
        if (ocspResponses.get(x509Certificate) != null || uri == null) {
            List<java.security.cert.Extension> ocspExtensions = this.f22035parent.getOcspExtensions();
            bArr = null;
            for (int i = 0; i != ocspExtensions.size(); i++) {
                java.security.cert.Extension extension = ocspExtensions.get(i);
                byte[] value = extension.getValue();
                if (OCSPObjectIdentifiers.id_pkix_ocsp_nonce.m14433getId().equals(extension.getId())) {
                    bArr = value;
                }
            }
            z = false;
        } else {
            if (this.f22034ocspURL == null && this.f22035parent.getOcspResponder() == null && !this.isEnabledOCSP) {
                throw new RecoverableCertPathValidatorException("OCSP disabled by \"ocsp.enable\" setting", null, this.parameters.getCertPath(), this.parameters.getIndex());
            }
            try {
                ocspResponses.put(x509Certificate, OcspCache.getOcspResponse(createCertID(new AlgorithmIdentifier(OIWObjectIdentifiers.f21282idSHA1), extractCert(), new ASN1Integer(x509Certificate.getSerialNumber())), this.parameters, uri, this.f22035parent.getOcspResponderCert(), this.f22035parent.getOcspExtensions(), this.f22033helper).getEncoded());
                z = true;
                bArr = null;
            } catch (IOException e2) {
                throw new CertPathValidatorException("unable to encode OCSP response", e2, this.parameters.getCertPath(), this.parameters.getIndex());
            }
        }
        if (ocspResponses.isEmpty()) {
            throw new RecoverableCertPathValidatorException("no OCSP response found for any certificate", null, this.parameters.getCertPath(), this.parameters.getIndex());
        }
        OCSPResponse oCSPResponse = OCSPResponse.getInstance(ocspResponses.get(x509Certificate));
        ASN1Integer aSN1Integer = new ASN1Integer(x509Certificate.getSerialNumber());
        if (oCSPResponse == null) {
            throw new RecoverableCertPathValidatorException("no OCSP response found for certificate", null, this.parameters.getCertPath(), this.parameters.getIndex());
        }
        if (oCSPResponse.getResponseStatus().getIntValue() != 0) {
            throw new CertPathValidatorException("OCSP response failed: " + oCSPResponse.getResponseStatus().getValue(), null, this.parameters.getCertPath(), this.parameters.getIndex());
        }
        ResponseBytes responseBytes = ResponseBytes.getInstance(oCSPResponse.getResponseBytes());
        if (responseBytes.getResponseType().m14446equals((ASN1Primitive) OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
            try {
                BasicOCSPResponse basicOCSPResponse = BasicOCSPResponse.getInstance(responseBytes.getResponse().getOctets());
                if (!z && !validatedOcspResponse(basicOCSPResponse, this.parameters, bArr, this.f22035parent.getOcspResponderCert(), this.f22033helper)) {
                    return;
                }
                ASN1Sequence responses = ResponseData.getInstance(basicOCSPResponse.getTbsResponseData()).getResponses();
                C5131CertID c5131CertIDCreateCertID = null;
                for (int i2 = 0; i2 != responses.mo14450size(); i2++) {
                    SingleResponse singleResponse = SingleResponse.getInstance(responses.getObjectAt(i2));
                    if (aSN1Integer.m14446equals((ASN1Primitive) singleResponse.getCertID().getSerialNumber())) {
                        ASN1GeneralizedTime nextUpdate = singleResponse.getNextUpdate();
                        if (nextUpdate != null && this.parameters.getValidDate().after(nextUpdate.m14427getDate())) {
                            throw new ExtCertPathValidatorException("OCSP response expired");
                        }
                        if (c5131CertIDCreateCertID == null || !isEqualAlgId(c5131CertIDCreateCertID.getHashAlgorithm(), singleResponse.getCertID().getHashAlgorithm())) {
                            c5131CertIDCreateCertID = createCertID(singleResponse.getCertID(), extractCert(), aSN1Integer);
                        }
                        if (c5131CertIDCreateCertID.mo14431equals(singleResponse.getCertID())) {
                            if (singleResponse.getCertStatus().getTagNo() == 0) {
                                return;
                            }
                            if (singleResponse.getCertStatus().getTagNo() != 1) {
                                throw new CertPathValidatorException("certificate revoked, details unknown", null, this.parameters.getCertPath(), this.parameters.getIndex());
                            }
                            RevokedInfo revokedInfo = RevokedInfo.getInstance(singleResponse.getCertStatus().getStatus());
                            throw new CertPathValidatorException("certificate revoked, reason=(" + revokedInfo.getRevocationReason() + "), date=" + revokedInfo.getRevocationTime().m14427getDate(), null, this.parameters.getCertPath(), this.parameters.getIndex());
                        }
                    }
                }
            } catch (CertPathValidatorException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new CertPathValidatorException("unable to process OCSP response", e4, this.parameters.getCertPath(), this.parameters.getIndex());
            }
        }
    }

    public List<CertPathValidatorException> getSoftFailExceptions() {
        return null;
    }

    public Set<String> getSupportedExtensions() {
        return null;
    }

    /* renamed from: init */
    public void m16262init(boolean z) {
        if (z) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.parameters = null;
        this.isEnabledOCSP = Properties.isOverrideSet("ocsp.enable");
        this.f22034ocspURL = Properties.getPropertyValue("ocsp.responderURL");
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) {
        this.parameters = pKIXCertRevocationCheckerParameters;
        this.isEnabledOCSP = Properties.isOverrideSet("ocsp.enable");
        this.f22034ocspURL = Properties.getPropertyValue("ocsp.responderURL");
    }

    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void setParameter(String str, Object obj) {
    }

    private C5131CertID createCertID(AlgorithmIdentifier algorithmIdentifier, Certificate certificate, ASN1Integer aSN1Integer) throws CertPathValidatorException {
        try {
            MessageDigest messageDigestCreateMessageDigest = this.f22033helper.createMessageDigest(MessageDigestUtils.getDigestName(algorithmIdentifier.getAlgorithm()));
            return new C5131CertID(algorithmIdentifier, new DEROctetString(messageDigestCreateMessageDigest.digest(certificate.getSubject().getEncoded(ASN1Encoding.f17902DER))), new DEROctetString(messageDigestCreateMessageDigest.digest(certificate.getSubjectPublicKeyInfo().getPublicKeyData().getBytes())), aSN1Integer);
        } catch (Exception e) {
            throw new CertPathValidatorException("problem creating ID: " + e, e);
        }
    }
}
