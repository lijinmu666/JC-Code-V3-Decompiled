package org.bouncycastle.p281jce.provider;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p232bsi.BSIObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p234eac.EACObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p238isara.IsaraObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p249jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
class ProvRevocationChecker extends PKIXRevocationChecker implements PKIXCertRevocationChecker {
    private static final int DEFAULT_OCSP_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_OCSP_TIMEOUT = 15000;

    /* renamed from: oids */
    private static final Map f22036oids;
    private final ProvCrlRevocationChecker crlChecker;

    /* renamed from: helper */
    private final JcaJceHelper f22037helper;
    private final ProvOcspRevocationChecker ocspChecker;
    private PKIXCertRevocationCheckerParameters parameters;

    static {
        HashMap map = new HashMap();
        f22036oids = map;
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

    public ProvRevocationChecker(JcaJceHelper jcaJceHelper) {
        this.f22037helper = jcaJceHelper;
        this.crlChecker = new ProvCrlRevocationChecker(jcaJceHelper);
        this.ocspChecker = new ProvOcspRevocationChecker(this, jcaJceHelper);
    }

    private boolean hasOption(PKIXRevocationChecker.Option option) {
        return getOptions().contains(option);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate certificate, Collection<String> collection) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertPathValidatorException, CRLException, NoSuchProviderException {
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (!hasOption(PKIXRevocationChecker.Option.ONLY_END_ENTITY) || x509Certificate.getBasicConstraints() == -1) {
            if (hasOption(PKIXRevocationChecker.Option.PREFER_CRLS)) {
                try {
                    this.crlChecker.mo16075check(certificate);
                    return;
                } catch (RecoverableCertPathValidatorException e) {
                    if (hasOption(PKIXRevocationChecker.Option.NO_FALLBACK)) {
                        throw e;
                    }
                    this.ocspChecker.mo16075check(certificate);
                    return;
                }
            }
            try {
                this.ocspChecker.mo16075check(certificate);
            } catch (RecoverableCertPathValidatorException e2) {
                if (hasOption(PKIXRevocationChecker.Option.NO_FALLBACK)) {
                    throw e2;
                }
                this.crlChecker.mo16075check(certificate);
            }
        }
    }

    @Override // java.security.cert.PKIXRevocationChecker
    public List<CertPathValidatorException> getSoftFailExceptions() {
        return this.ocspChecker.getSoftFailExceptions();
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean z) throws CertPathValidatorException {
        this.parameters = null;
        this.crlChecker.m16261init(z);
        this.ocspChecker.m16262init(z);
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) {
        this.parameters = pKIXCertRevocationCheckerParameters;
        this.crlChecker.initialize(pKIXCertRevocationCheckerParameters);
        this.ocspChecker.initialize(pKIXCertRevocationCheckerParameters);
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void setParameter(String str, Object obj) {
    }
}
