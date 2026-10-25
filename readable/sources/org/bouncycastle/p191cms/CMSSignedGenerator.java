package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.OtherRevocationInfoFormat;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class CMSSignedGenerator {

    /* renamed from: DATA */
    public static final String f19002DATA = CMSObjectIdentifiers.f18179data.m14433getId();
    public static final String DIGEST_GOST3411;
    public static final String DIGEST_MD5;
    public static final String DIGEST_RIPEMD128;
    public static final String DIGEST_RIPEMD160;
    public static final String DIGEST_RIPEMD256;
    public static final String DIGEST_SHA1;
    public static final String DIGEST_SHA224;
    public static final String DIGEST_SHA256;
    public static final String DIGEST_SHA384;
    public static final String DIGEST_SHA512;
    private static final Map EC_ALGORITHMS;
    public static final String ENCRYPTION_DSA;
    public static final String ENCRYPTION_ECDSA;
    private static final String ENCRYPTION_ECDSA_WITH_SHA1;
    private static final String ENCRYPTION_ECDSA_WITH_SHA224;
    private static final String ENCRYPTION_ECDSA_WITH_SHA256;
    private static final String ENCRYPTION_ECDSA_WITH_SHA384;
    private static final String ENCRYPTION_ECDSA_WITH_SHA512;
    public static final String ENCRYPTION_ECGOST3410;
    public static final String ENCRYPTION_ECGOST3410_2012_256;
    public static final String ENCRYPTION_ECGOST3410_2012_512;
    public static final String ENCRYPTION_GOST3410;
    public static final String ENCRYPTION_RSA;
    public static final String ENCRYPTION_RSA_PSS;
    private static final Set NO_PARAMS;
    protected List _signers;

    /* renamed from: certs */
    protected List f19003certs;

    /* renamed from: crls */
    protected List f19004crls;
    protected DigestAlgorithmIdentifierFinder digestAlgIdFinder;

    /* renamed from: digests */
    protected Map f19005digests;
    protected Set<AlgorithmIdentifier> extraDigestAlgorithms;
    protected List signerGens;

    static {
        String strM14433getId = OIWObjectIdentifiers.f18459idSHA1.m14433getId();
        DIGEST_SHA1 = strM14433getId;
        String strM14433getId2 = NISTObjectIdentifiers.id_sha224.m14433getId();
        DIGEST_SHA224 = strM14433getId2;
        String strM14433getId3 = NISTObjectIdentifiers.id_sha256.m14433getId();
        DIGEST_SHA256 = strM14433getId3;
        String strM14433getId4 = NISTObjectIdentifiers.id_sha384.m14433getId();
        DIGEST_SHA384 = strM14433getId4;
        String strM14433getId5 = NISTObjectIdentifiers.id_sha512.m14433getId();
        DIGEST_SHA512 = strM14433getId5;
        DIGEST_MD5 = PKCSObjectIdentifiers.f18503md5.m14433getId();
        DIGEST_GOST3411 = CryptoProObjectIdentifiers.gostR3411.m14433getId();
        DIGEST_RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.m14433getId();
        DIGEST_RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.m14433getId();
        DIGEST_RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.m14433getId();
        ENCRYPTION_RSA = PKCSObjectIdentifiers.rsaEncryption.m14433getId();
        String strM14433getId6 = X9ObjectIdentifiers.id_dsa_with_sha1.m14433getId();
        ENCRYPTION_DSA = strM14433getId6;
        String strM14433getId7 = X9ObjectIdentifiers.ecdsa_with_SHA1.m14433getId();
        ENCRYPTION_ECDSA = strM14433getId7;
        ENCRYPTION_RSA_PSS = PKCSObjectIdentifiers.id_RSASSA_PSS.m14433getId();
        ENCRYPTION_GOST3410 = CryptoProObjectIdentifiers.gostR3410_94.m14433getId();
        ENCRYPTION_ECGOST3410 = CryptoProObjectIdentifiers.gostR3410_2001.m14433getId();
        ENCRYPTION_ECGOST3410_2012_256 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256.m14433getId();
        ENCRYPTION_ECGOST3410_2012_512 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512.m14433getId();
        ENCRYPTION_ECDSA_WITH_SHA1 = strM14433getId7;
        String strM14433getId8 = X9ObjectIdentifiers.ecdsa_with_SHA224.m14433getId();
        ENCRYPTION_ECDSA_WITH_SHA224 = strM14433getId8;
        String strM14433getId9 = X9ObjectIdentifiers.ecdsa_with_SHA256.m14433getId();
        ENCRYPTION_ECDSA_WITH_SHA256 = strM14433getId9;
        String strM14433getId10 = X9ObjectIdentifiers.ecdsa_with_SHA384.m14433getId();
        ENCRYPTION_ECDSA_WITH_SHA384 = strM14433getId10;
        String strM14433getId11 = X9ObjectIdentifiers.ecdsa_with_SHA512.m14433getId();
        ENCRYPTION_ECDSA_WITH_SHA512 = strM14433getId11;
        HashSet hashSet = new HashSet();
        NO_PARAMS = hashSet;
        HashMap map = new HashMap();
        EC_ALGORITHMS = map;
        hashSet.add(strM14433getId6);
        hashSet.add(strM14433getId7);
        hashSet.add(strM14433getId8);
        hashSet.add(strM14433getId9);
        hashSet.add(strM14433getId10);
        hashSet.add(strM14433getId11);
        map.put(strM14433getId, strM14433getId7);
        map.put(strM14433getId2, strM14433getId8);
        map.put(strM14433getId3, strM14433getId9);
        map.put(strM14433getId4, strM14433getId10);
        map.put(strM14433getId5, strM14433getId11);
    }

    public CMSSignedGenerator() {
        this(new DefaultDigestAlgorithmIdentifierFinder());
    }

    public void addAttributeCertificate(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        this.f19003certs.add(new DERTaggedObject(false, 2, (ASN1Encodable) x509AttributeCertificateHolder.toASN1Structure()));
    }

    public void addAttributeCertificates(InterfaceC6249Store interfaceC6249Store) {
        this.f19003certs.addAll(CMSUtils.getAttributeCertificatesFromStore(interfaceC6249Store));
    }

    /* renamed from: addCRL */
    public void m14874addCRL(X509CRLHolder x509CRLHolder) {
        this.f19004crls.add(x509CRLHolder.toASN1Structure());
    }

    /* renamed from: addCRLs */
    public void m14875addCRLs(InterfaceC6249Store interfaceC6249Store) {
        this.f19004crls.addAll(CMSUtils.getCRLsFromStore(interfaceC6249Store));
    }

    public void addCertificate(X509CertificateHolder x509CertificateHolder) {
        this.f19003certs.add(x509CertificateHolder.toASN1Structure());
    }

    public void addCertificates(InterfaceC6249Store interfaceC6249Store) {
        this.f19003certs.addAll(CMSUtils.getCertificatesFromStore(interfaceC6249Store));
    }

    public void addDigestAlgorithms(Set<AlgorithmIdentifier> set) {
        this.extraDigestAlgorithms.addAll(set);
    }

    public void addOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        OtherRevocationInfoFormat otherRevocationInfoFormat = new OtherRevocationInfoFormat(aSN1ObjectIdentifier, aSN1Encodable);
        CMSUtils.validateInfoFormat(otherRevocationInfoFormat);
        this.f19004crls.add(new DERTaggedObject(false, 1, (ASN1Encodable) otherRevocationInfoFormat));
    }

    public void addSignerInfoGenerator(SignerInfoGenerator signerInfoGenerator) {
        this.signerGens.add(signerInfoGenerator);
    }

    public void addSigners(SignerInformationStore signerInformationStore) {
        Iterator<SignerInformation> it = signerInformationStore.getSigners().iterator();
        while (it.hasNext()) {
            this._signers.add(it.next());
        }
    }

    public Map getBaseParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        HashMap map = new HashMap();
        map.put(CMSAttributeTableGenerator.CONTENT_TYPE, aSN1ObjectIdentifier);
        map.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        map.put(CMSAttributeTableGenerator.f18937DIGEST, C6238Arrays.m18231clone(bArr));
        return map;
    }

    public Map getGeneratedDigests() {
        return new HashMap(this.f19005digests);
    }

    public CMSSignedGenerator(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.f19003certs = new ArrayList();
        this.f19004crls = new ArrayList();
        this._signers = new ArrayList();
        this.signerGens = new ArrayList();
        this.f19005digests = new HashMap();
        this.extraDigestAlgorithms = new LinkedHashSet();
        this.digestAlgIdFinder = digestAlgorithmIdentifierFinder;
    }

    public void addOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC6249Store interfaceC6249Store) {
        this.f19004crls.addAll(CMSUtils.getOthersFromStore(aSN1ObjectIdentifier, interfaceC6249Store));
    }
}
