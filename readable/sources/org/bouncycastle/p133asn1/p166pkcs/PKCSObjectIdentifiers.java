package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface PKCSObjectIdentifiers {

    /* renamed from: RC2_CBC */
    public static final ASN1ObjectIdentifier f18490RC2_CBC;
    public static final ASN1ObjectIdentifier bagtypes;
    public static final ASN1ObjectIdentifier canNotDecryptAny;

    /* renamed from: certBag */
    public static final ASN1ObjectIdentifier f18491certBag;
    public static final ASN1ObjectIdentifier certTypes;

    /* renamed from: crlBag */
    public static final ASN1ObjectIdentifier f18492crlBag;
    public static final ASN1ObjectIdentifier crlTypes;

    /* renamed from: data */
    public static final ASN1ObjectIdentifier f18493data;
    public static final ASN1ObjectIdentifier des_EDE3_CBC;
    public static final ASN1ObjectIdentifier dhKeyAgreement;
    public static final ASN1ObjectIdentifier digestAlgorithm;
    public static final ASN1ObjectIdentifier digestedData;
    public static final ASN1ObjectIdentifier encryptedData;
    public static final ASN1ObjectIdentifier encryptionAlgorithm;
    public static final ASN1ObjectIdentifier envelopedData;
    public static final ASN1ObjectIdentifier id_PBES2;
    public static final ASN1ObjectIdentifier id_PBKDF2;
    public static final ASN1ObjectIdentifier id_PBMAC1;
    public static final ASN1ObjectIdentifier id_RSAES_OAEP;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS;

    /* renamed from: id_aa */
    public static final ASN1ObjectIdentifier f18494id_aa;
    public static final ASN1ObjectIdentifier id_aa_asymmDecryptKeyID;
    public static final ASN1ObjectIdentifier id_aa_cmsAlgorithmProtect;

    @Deprecated
    public static final ASN1ObjectIdentifier id_aa_commitmentType;
    public static final ASN1ObjectIdentifier id_aa_communityIdentifiers;
    public static final ASN1ObjectIdentifier id_aa_contentHint;
    public static final ASN1ObjectIdentifier id_aa_contentIdentifier;
    public static final ASN1ObjectIdentifier id_aa_contentReference;
    public static final ASN1ObjectIdentifier id_aa_decryptKeyID;
    public static final ASN1ObjectIdentifier id_aa_encrypKeyPref;
    public static final ASN1ObjectIdentifier id_aa_ets_archiveTimestamp;
    public static final ASN1ObjectIdentifier id_aa_ets_certCRLTimestamp;
    public static final ASN1ObjectIdentifier id_aa_ets_certValues;
    public static final ASN1ObjectIdentifier id_aa_ets_certificateRefs;
    public static final ASN1ObjectIdentifier id_aa_ets_commitmentType;
    public static final ASN1ObjectIdentifier id_aa_ets_contentTimestamp;
    public static final ASN1ObjectIdentifier id_aa_ets_escTimeStamp;
    public static final ASN1ObjectIdentifier id_aa_ets_otherSigCert;
    public static final ASN1ObjectIdentifier id_aa_ets_revocationRefs;
    public static final ASN1ObjectIdentifier id_aa_ets_revocationValues;
    public static final ASN1ObjectIdentifier id_aa_ets_sigPolicyId;
    public static final ASN1ObjectIdentifier id_aa_ets_signerAttr;
    public static final ASN1ObjectIdentifier id_aa_ets_signerLocation;
    public static final ASN1ObjectIdentifier id_aa_implCompressAlgs;
    public static final ASN1ObjectIdentifier id_aa_implCryptoAlgs;
    public static final ASN1ObjectIdentifier id_aa_msgSigDigest;

    @Deprecated
    public static final ASN1ObjectIdentifier id_aa_otherSigCert;
    public static final ASN1ObjectIdentifier id_aa_receiptRequest;

    @Deprecated
    public static final ASN1ObjectIdentifier id_aa_sigPolicyId;
    public static final ASN1ObjectIdentifier id_aa_signatureTimeStampToken;

    @Deprecated
    public static final ASN1ObjectIdentifier id_aa_signerLocation;
    public static final ASN1ObjectIdentifier id_aa_signingCertificate;
    public static final ASN1ObjectIdentifier id_aa_signingCertificateV2;

    /* renamed from: id_alg */
    @Deprecated
    public static final ASN1ObjectIdentifier f18495id_alg;
    public static final ASN1ObjectIdentifier id_alg_AEADChaCha20Poly1305;
    public static final ASN1ObjectIdentifier id_alg_CMS3DESwrap;
    public static final ASN1ObjectIdentifier id_alg_CMSRC2wrap;
    public static final ASN1ObjectIdentifier id_alg_ESDH;
    public static final ASN1ObjectIdentifier id_alg_PWRI_KEK;
    public static final ASN1ObjectIdentifier id_alg_SSDH;
    public static final ASN1ObjectIdentifier id_alg_hkdf_with_sha256;
    public static final ASN1ObjectIdentifier id_alg_hkdf_with_sha384;
    public static final ASN1ObjectIdentifier id_alg_hkdf_with_sha512;
    public static final ASN1ObjectIdentifier id_alg_hss_lms_hashsig;
    public static final ASN1ObjectIdentifier id_alg_zlibCompress;

    /* renamed from: id_ct */
    public static final ASN1ObjectIdentifier f18496id_ct;
    public static final ASN1ObjectIdentifier id_ct_TSTInfo;
    public static final ASN1ObjectIdentifier id_ct_authData;
    public static final ASN1ObjectIdentifier id_ct_authEnvelopedData;
    public static final ASN1ObjectIdentifier id_ct_compressedData;
    public static final ASN1ObjectIdentifier id_ct_timestampedData;

    /* renamed from: id_cti */
    public static final ASN1ObjectIdentifier f18497id_cti;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfApproval;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfCreation;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfDelivery;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfOrigin;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfReceipt;
    public static final ASN1ObjectIdentifier id_cti_ets_proofOfSender;
    public static final ASN1ObjectIdentifier id_hmacWithSHA1;
    public static final ASN1ObjectIdentifier id_hmacWithSHA224;
    public static final ASN1ObjectIdentifier id_hmacWithSHA256;
    public static final ASN1ObjectIdentifier id_hmacWithSHA384;
    public static final ASN1ObjectIdentifier id_hmacWithSHA512;
    public static final ASN1ObjectIdentifier id_hmacWithSHA512_224;
    public static final ASN1ObjectIdentifier id_hmacWithSHA512_256;

    /* renamed from: id_mgf1 */
    public static final ASN1ObjectIdentifier f18498id_mgf1;
    public static final ASN1ObjectIdentifier id_mod_CMS_AEADChaCha20Poly1305;
    public static final ASN1ObjectIdentifier id_mod_cms_seed;
    public static final ASN1ObjectIdentifier id_mod_mts_hashsig_2013;
    public static final ASN1ObjectIdentifier id_pSpecified;
    public static final ASN1ObjectIdentifier id_rsa_KEM;
    public static final ASN1ObjectIdentifier id_smime;

    /* renamed from: id_spq */
    @Deprecated
    public static final String f18499id_spq = "1.2.840.113549.1.9.16.5";
    public static final ASN1ObjectIdentifier id_spq_ets_unotice;
    public static final ASN1ObjectIdentifier id_spq_ets_uri;
    public static final ASN1ObjectIdentifier id_spq_oid;

    /* renamed from: keyBag */
    public static final ASN1ObjectIdentifier f18500keyBag;

    /* renamed from: md2 */
    public static final ASN1ObjectIdentifier f18501md2;
    public static final ASN1ObjectIdentifier md2WithRSAEncryption;

    /* renamed from: md4 */
    public static final ASN1ObjectIdentifier f18502md4;
    public static final ASN1ObjectIdentifier md4WithRSAEncryption;

    /* renamed from: md5 */
    public static final ASN1ObjectIdentifier f18503md5;
    public static final ASN1ObjectIdentifier md5WithRSAEncryption;
    public static final ASN1ObjectIdentifier pbeWithMD2AndDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithMD2AndRC2_CBC;
    public static final ASN1ObjectIdentifier pbeWithMD5AndDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithMD5AndRC2_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHA1AndDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHA1AndRC2_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd128BitRC2_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd128BitRC4;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd2_KeyTripleDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd3_KeyTripleDES_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd40BitRC2_CBC;
    public static final ASN1ObjectIdentifier pbeWithSHAAnd40BitRC4;

    @Deprecated
    public static final ASN1ObjectIdentifier pbewithSHAAnd40BitRC2_CBC;
    public static final ASN1ObjectIdentifier pkcs8ShroudedKeyBag;

    /* renamed from: pkcs_1 */
    public static final ASN1ObjectIdentifier f18504pkcs_1;

    /* renamed from: pkcs_12 */
    public static final ASN1ObjectIdentifier f18505pkcs_12;
    public static final ASN1ObjectIdentifier pkcs_12PbeIds;

    /* renamed from: pkcs_3 */
    public static final ASN1ObjectIdentifier f18506pkcs_3;

    /* renamed from: pkcs_5 */
    public static final ASN1ObjectIdentifier f18507pkcs_5;

    /* renamed from: pkcs_7 */
    public static final ASN1ObjectIdentifier f18508pkcs_7;

    /* renamed from: pkcs_9 */
    public static final ASN1ObjectIdentifier f18509pkcs_9;
    public static final ASN1ObjectIdentifier pkcs_9_at_binarySigningTime;
    public static final ASN1ObjectIdentifier pkcs_9_at_challengePassword;
    public static final ASN1ObjectIdentifier pkcs_9_at_contentType;
    public static final ASN1ObjectIdentifier pkcs_9_at_counterSignature;
    public static final ASN1ObjectIdentifier pkcs_9_at_emailAddress;
    public static final ASN1ObjectIdentifier pkcs_9_at_extendedCertificateAttributes;
    public static final ASN1ObjectIdentifier pkcs_9_at_extensionRequest;
    public static final ASN1ObjectIdentifier pkcs_9_at_friendlyName;
    public static final ASN1ObjectIdentifier pkcs_9_at_localKeyId;
    public static final ASN1ObjectIdentifier pkcs_9_at_messageDigest;
    public static final ASN1ObjectIdentifier pkcs_9_at_signingDescription;
    public static final ASN1ObjectIdentifier pkcs_9_at_signingTime;
    public static final ASN1ObjectIdentifier pkcs_9_at_smimeCapabilities;
    public static final ASN1ObjectIdentifier pkcs_9_at_unstructuredAddress;
    public static final ASN1ObjectIdentifier pkcs_9_at_unstructuredName;
    public static final ASN1ObjectIdentifier preferSignedData;

    /* renamed from: rc4 */
    public static final ASN1ObjectIdentifier f18510rc4;
    public static final ASN1ObjectIdentifier rsaEncryption;
    public static final ASN1ObjectIdentifier sMIMECapabilitiesVersions;
    public static final ASN1ObjectIdentifier safeContentsBag;
    public static final ASN1ObjectIdentifier sdsiCertificate;
    public static final ASN1ObjectIdentifier secretBag;
    public static final ASN1ObjectIdentifier sha1WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha224WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha256WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha384WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha512WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha512_224WithRSAEncryption;
    public static final ASN1ObjectIdentifier sha512_256WithRSAEncryption;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier signedData;
    public static final ASN1ObjectIdentifier smime_alg;
    public static final ASN1ObjectIdentifier srsaOAEPEncryptionSET;
    public static final ASN1ObjectIdentifier x509Certificate;

    /* renamed from: x509Crl */
    public static final ASN1ObjectIdentifier f18511x509Crl;

    @Deprecated
    public static final ASN1ObjectIdentifier x509certType;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.113549.1.1");
        f18504pkcs_1 = aSN1ObjectIdentifier;
        rsaEncryption = aSN1ObjectIdentifier.m14432branch("1");
        md2WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("2");
        md4WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("3");
        md5WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("4");
        sha1WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("5");
        srsaOAEPEncryptionSET = aSN1ObjectIdentifier.m14432branch("6");
        id_RSAES_OAEP = aSN1ObjectIdentifier.m14432branch("7");
        f18498id_mgf1 = aSN1ObjectIdentifier.m14432branch("8");
        id_pSpecified = aSN1ObjectIdentifier.m14432branch("9");
        id_RSASSA_PSS = aSN1ObjectIdentifier.m14432branch("10");
        sha256WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("11");
        sha384WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("12");
        sha512WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("13");
        sha224WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("14");
        sha512_224WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("15");
        sha512_256WithRSAEncryption = aSN1ObjectIdentifier.m14432branch("16");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.2.840.113549.1.3");
        f18506pkcs_3 = aSN1ObjectIdentifier2;
        dhKeyAgreement = aSN1ObjectIdentifier2.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.113549.1.5");
        f18507pkcs_5 = aSN1ObjectIdentifier3;
        pbeWithMD2AndDES_CBC = aSN1ObjectIdentifier3.m14432branch("1");
        pbeWithMD2AndRC2_CBC = aSN1ObjectIdentifier3.m14432branch("4");
        pbeWithMD5AndDES_CBC = aSN1ObjectIdentifier3.m14432branch("3");
        pbeWithMD5AndRC2_CBC = aSN1ObjectIdentifier3.m14432branch("6");
        pbeWithSHA1AndDES_CBC = aSN1ObjectIdentifier3.m14432branch("10");
        pbeWithSHA1AndRC2_CBC = aSN1ObjectIdentifier3.m14432branch("11");
        id_PBKDF2 = aSN1ObjectIdentifier3.m14432branch("12");
        id_PBES2 = aSN1ObjectIdentifier3.m14432branch("13");
        id_PBMAC1 = aSN1ObjectIdentifier3.m14432branch("14");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.2.840.113549.3");
        encryptionAlgorithm = aSN1ObjectIdentifier4;
        des_EDE3_CBC = aSN1ObjectIdentifier4.m14432branch("7");
        f18490RC2_CBC = aSN1ObjectIdentifier4.m14432branch("2");
        f18510rc4 = aSN1ObjectIdentifier4.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.2.840.113549.2");
        digestAlgorithm = aSN1ObjectIdentifier5;
        f18501md2 = aSN1ObjectIdentifier5.m14432branch("2");
        f18502md4 = aSN1ObjectIdentifier5.m14432branch("4");
        f18503md5 = aSN1ObjectIdentifier5.m14432branch("5");
        id_hmacWithSHA1 = aSN1ObjectIdentifier5.m14432branch("7").m14434intern();
        id_hmacWithSHA224 = aSN1ObjectIdentifier5.m14432branch("8").m14434intern();
        id_hmacWithSHA256 = aSN1ObjectIdentifier5.m14432branch("9").m14434intern();
        id_hmacWithSHA384 = aSN1ObjectIdentifier5.m14432branch("10").m14434intern();
        id_hmacWithSHA512 = aSN1ObjectIdentifier5.m14432branch("11").m14434intern();
        id_hmacWithSHA512_224 = aSN1ObjectIdentifier5.m14432branch("12").m14434intern();
        id_hmacWithSHA512_256 = aSN1ObjectIdentifier5.m14432branch("13").m14434intern();
        f18508pkcs_7 = new ASN1ObjectIdentifier("1.2.840.113549.1.7").m14434intern();
        f18493data = new ASN1ObjectIdentifier("1.2.840.113549.1.7.1").m14434intern();
        signedData = new ASN1ObjectIdentifier("1.2.840.113549.1.7.2").m14434intern();
        envelopedData = new ASN1ObjectIdentifier("1.2.840.113549.1.7.3").m14434intern();
        signedAndEnvelopedData = new ASN1ObjectIdentifier("1.2.840.113549.1.7.4").m14434intern();
        digestedData = new ASN1ObjectIdentifier("1.2.840.113549.1.7.5").m14434intern();
        encryptedData = new ASN1ObjectIdentifier("1.2.840.113549.1.7.6").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("1.2.840.113549.1.9");
        f18509pkcs_9 = aSN1ObjectIdentifier6;
        pkcs_9_at_emailAddress = aSN1ObjectIdentifier6.m14432branch("1").m14434intern();
        pkcs_9_at_unstructuredName = aSN1ObjectIdentifier6.m14432branch("2").m14434intern();
        pkcs_9_at_contentType = aSN1ObjectIdentifier6.m14432branch("3").m14434intern();
        pkcs_9_at_messageDigest = aSN1ObjectIdentifier6.m14432branch("4").m14434intern();
        pkcs_9_at_signingTime = aSN1ObjectIdentifier6.m14432branch("5").m14434intern();
        pkcs_9_at_counterSignature = aSN1ObjectIdentifier6.m14432branch("6").m14434intern();
        pkcs_9_at_challengePassword = aSN1ObjectIdentifier6.m14432branch("7").m14434intern();
        pkcs_9_at_unstructuredAddress = aSN1ObjectIdentifier6.m14432branch("8").m14434intern();
        pkcs_9_at_extendedCertificateAttributes = aSN1ObjectIdentifier6.m14432branch("9").m14434intern();
        pkcs_9_at_signingDescription = aSN1ObjectIdentifier6.m14432branch("13").m14434intern();
        pkcs_9_at_extensionRequest = aSN1ObjectIdentifier6.m14432branch("14").m14434intern();
        pkcs_9_at_smimeCapabilities = aSN1ObjectIdentifier6.m14432branch("15").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern = aSN1ObjectIdentifier6.m14432branch("16").m14434intern();
        id_smime = aSN1ObjectIdentifierM14434intern;
        pkcs_9_at_friendlyName = aSN1ObjectIdentifier6.m14432branch("20").m14434intern();
        pkcs_9_at_localKeyId = aSN1ObjectIdentifier6.m14432branch("21").m14434intern();
        x509certType = aSN1ObjectIdentifier6.m14432branch("22.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier6.m14432branch("22");
        certTypes = aSN1ObjectIdentifierM14432branch;
        x509Certificate = aSN1ObjectIdentifierM14432branch.m14432branch("1").m14434intern();
        sdsiCertificate = aSN1ObjectIdentifierM14432branch.m14432branch("2").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifier6.m14432branch("23");
        crlTypes = aSN1ObjectIdentifierM14432branch2;
        f18511x509Crl = aSN1ObjectIdentifierM14432branch2.m14432branch("1").m14434intern();
        id_aa_cmsAlgorithmProtect = aSN1ObjectIdentifier6.m14432branch("52").m14434intern();
        preferSignedData = aSN1ObjectIdentifier6.m14432branch("15.1");
        canNotDecryptAny = aSN1ObjectIdentifier6.m14432branch("15.2");
        sMIMECapabilitiesVersions = aSN1ObjectIdentifier6.m14432branch("15.3");
        id_mod_cms_seed = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.24");
        id_mod_mts_hashsig_2013 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.64");
        id_mod_CMS_AEADChaCha20Poly1305 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.66");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14434intern.m14432branch("1");
        f18496id_ct = aSN1ObjectIdentifierM14432branch3;
        id_ct_authData = aSN1ObjectIdentifierM14432branch3.m14432branch("2");
        id_ct_TSTInfo = aSN1ObjectIdentifierM14432branch3.m14432branch("4");
        id_ct_compressedData = aSN1ObjectIdentifierM14432branch3.m14432branch("9");
        id_ct_authEnvelopedData = aSN1ObjectIdentifierM14432branch3.m14432branch("23");
        id_ct_timestampedData = aSN1ObjectIdentifierM14432branch3.m14432branch("31");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch4 = aSN1ObjectIdentifierM14434intern.m14432branch("3");
        smime_alg = aSN1ObjectIdentifierM14432branch4;
        f18495id_alg = aSN1ObjectIdentifierM14434intern.m14432branch("3");
        id_alg_ESDH = aSN1ObjectIdentifierM14432branch4.m14432branch("5");
        id_alg_CMS3DESwrap = aSN1ObjectIdentifierM14432branch4.m14432branch("6");
        id_alg_CMSRC2wrap = aSN1ObjectIdentifierM14432branch4.m14432branch("7");
        id_alg_zlibCompress = aSN1ObjectIdentifierM14432branch4.m14432branch("8");
        id_alg_PWRI_KEK = aSN1ObjectIdentifierM14432branch4.m14432branch("9");
        id_alg_SSDH = aSN1ObjectIdentifierM14432branch4.m14432branch("10");
        id_rsa_KEM = aSN1ObjectIdentifierM14432branch4.m14432branch("14");
        id_alg_hss_lms_hashsig = aSN1ObjectIdentifierM14432branch4.m14432branch("17");
        id_alg_AEADChaCha20Poly1305 = aSN1ObjectIdentifierM14432branch4.m14432branch("18");
        id_alg_hkdf_with_sha256 = aSN1ObjectIdentifierM14432branch4.m14432branch("28");
        id_alg_hkdf_with_sha384 = aSN1ObjectIdentifierM14432branch4.m14432branch("29");
        id_alg_hkdf_with_sha512 = aSN1ObjectIdentifierM14432branch4.m14432branch("30");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch5 = aSN1ObjectIdentifierM14434intern.m14432branch("6");
        f18497id_cti = aSN1ObjectIdentifierM14432branch5;
        id_cti_ets_proofOfOrigin = aSN1ObjectIdentifierM14432branch5.m14432branch("1");
        id_cti_ets_proofOfReceipt = aSN1ObjectIdentifierM14432branch5.m14432branch("2");
        id_cti_ets_proofOfDelivery = aSN1ObjectIdentifierM14432branch5.m14432branch("3");
        id_cti_ets_proofOfSender = aSN1ObjectIdentifierM14432branch5.m14432branch("4");
        id_cti_ets_proofOfApproval = aSN1ObjectIdentifierM14432branch5.m14432branch("5");
        id_cti_ets_proofOfCreation = aSN1ObjectIdentifierM14432branch5.m14432branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch6 = aSN1ObjectIdentifierM14434intern.m14432branch("2");
        f18494id_aa = aSN1ObjectIdentifierM14432branch6;
        pkcs_9_at_binarySigningTime = aSN1ObjectIdentifierM14432branch6.m14432branch("46").m14434intern();
        id_aa_receiptRequest = aSN1ObjectIdentifierM14432branch6.m14432branch("1");
        id_aa_contentHint = aSN1ObjectIdentifierM14432branch6.m14432branch("4");
        id_aa_msgSigDigest = aSN1ObjectIdentifierM14432branch6.m14432branch("5");
        id_aa_contentReference = aSN1ObjectIdentifierM14432branch6.m14432branch("10");
        id_aa_encrypKeyPref = aSN1ObjectIdentifierM14432branch6.m14432branch("11");
        id_aa_signingCertificate = aSN1ObjectIdentifierM14432branch6.m14432branch("12");
        id_aa_signingCertificateV2 = aSN1ObjectIdentifierM14432branch6.m14432branch("47");
        id_aa_contentIdentifier = aSN1ObjectIdentifierM14432branch6.m14432branch("7");
        id_aa_signatureTimeStampToken = aSN1ObjectIdentifierM14432branch6.m14432branch("14");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch7 = aSN1ObjectIdentifierM14432branch6.m14432branch("15");
        id_aa_ets_sigPolicyId = aSN1ObjectIdentifierM14432branch7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch8 = aSN1ObjectIdentifierM14432branch6.m14432branch("16");
        id_aa_ets_commitmentType = aSN1ObjectIdentifierM14432branch8;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch9 = aSN1ObjectIdentifierM14432branch6.m14432branch("17");
        id_aa_ets_signerLocation = aSN1ObjectIdentifierM14432branch9;
        id_aa_ets_signerAttr = aSN1ObjectIdentifierM14432branch6.m14432branch("18");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch10 = aSN1ObjectIdentifierM14432branch6.m14432branch("19");
        id_aa_ets_otherSigCert = aSN1ObjectIdentifierM14432branch10;
        id_aa_ets_contentTimestamp = aSN1ObjectIdentifierM14432branch6.m14432branch("20");
        id_aa_ets_certificateRefs = aSN1ObjectIdentifierM14432branch6.m14432branch("21");
        id_aa_ets_revocationRefs = aSN1ObjectIdentifierM14432branch6.m14432branch("22");
        id_aa_ets_certValues = aSN1ObjectIdentifierM14432branch6.m14432branch("23");
        id_aa_ets_revocationValues = aSN1ObjectIdentifierM14432branch6.m14432branch("24");
        id_aa_ets_escTimeStamp = aSN1ObjectIdentifierM14432branch6.m14432branch("25");
        id_aa_ets_certCRLTimestamp = aSN1ObjectIdentifierM14432branch6.m14432branch("26");
        id_aa_ets_archiveTimestamp = aSN1ObjectIdentifierM14432branch6.m14432branch("27");
        id_aa_decryptKeyID = aSN1ObjectIdentifierM14432branch6.m14432branch("37");
        id_aa_implCryptoAlgs = aSN1ObjectIdentifierM14432branch6.m14432branch("38");
        id_aa_asymmDecryptKeyID = aSN1ObjectIdentifierM14432branch6.m14432branch("54");
        id_aa_implCompressAlgs = aSN1ObjectIdentifierM14432branch6.m14432branch("43");
        id_aa_communityIdentifiers = aSN1ObjectIdentifierM14432branch6.m14432branch("40");
        id_aa_sigPolicyId = aSN1ObjectIdentifierM14432branch7;
        id_aa_commitmentType = aSN1ObjectIdentifierM14432branch8;
        id_aa_signerLocation = aSN1ObjectIdentifierM14432branch9;
        id_aa_otherSigCert = aSN1ObjectIdentifierM14432branch10;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch11 = aSN1ObjectIdentifierM14434intern.m14432branch("5");
        id_spq_oid = aSN1ObjectIdentifierM14432branch11;
        id_spq_ets_uri = aSN1ObjectIdentifierM14432branch11.m14432branch("1");
        id_spq_ets_unotice = aSN1ObjectIdentifierM14432branch11.m14432branch("2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("1.2.840.113549.1.12");
        f18505pkcs_12 = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch12 = aSN1ObjectIdentifier7.m14432branch("10.1");
        bagtypes = aSN1ObjectIdentifierM14432branch12;
        f18500keyBag = aSN1ObjectIdentifierM14432branch12.m14432branch("1");
        pkcs8ShroudedKeyBag = aSN1ObjectIdentifierM14432branch12.m14432branch("2");
        f18491certBag = aSN1ObjectIdentifierM14432branch12.m14432branch("3");
        f18492crlBag = aSN1ObjectIdentifierM14432branch12.m14432branch("4");
        secretBag = aSN1ObjectIdentifierM14432branch12.m14432branch("5");
        safeContentsBag = aSN1ObjectIdentifierM14432branch12.m14432branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch13 = aSN1ObjectIdentifier7.m14432branch("1");
        pkcs_12PbeIds = aSN1ObjectIdentifierM14432branch13;
        pbeWithSHAAnd128BitRC4 = aSN1ObjectIdentifierM14432branch13.m14432branch("1");
        pbeWithSHAAnd40BitRC4 = aSN1ObjectIdentifierM14432branch13.m14432branch("2");
        pbeWithSHAAnd3_KeyTripleDES_CBC = aSN1ObjectIdentifierM14432branch13.m14432branch("3");
        pbeWithSHAAnd2_KeyTripleDES_CBC = aSN1ObjectIdentifierM14432branch13.m14432branch("4");
        pbeWithSHAAnd128BitRC2_CBC = aSN1ObjectIdentifierM14432branch13.m14432branch("5");
        pbeWithSHAAnd40BitRC2_CBC = aSN1ObjectIdentifierM14432branch13.m14432branch("6");
        pbewithSHAAnd40BitRC2_CBC = aSN1ObjectIdentifierM14432branch13.m14432branch("6");
    }
}
