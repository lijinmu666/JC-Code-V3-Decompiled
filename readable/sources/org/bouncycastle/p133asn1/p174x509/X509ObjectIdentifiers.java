package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier attributeType;
    public static final ASN1ObjectIdentifier commonName;
    public static final ASN1ObjectIdentifier countryName;
    public static final ASN1ObjectIdentifier crlAccessMethod;
    public static final ASN1ObjectIdentifier id_PasswordBasedMac;

    /* renamed from: id_SHA1 */
    public static final ASN1ObjectIdentifier f18741id_SHA1;

    /* renamed from: id_ad */
    public static final ASN1ObjectIdentifier f18742id_ad;
    public static final ASN1ObjectIdentifier id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_ad_ocsp;
    public static final ASN1ObjectIdentifier id_alg_noSignature;
    public static final ASN1ObjectIdentifier id_alg_unsigned;
    public static final ASN1ObjectIdentifier id_at_name;
    public static final ASN1ObjectIdentifier id_at_organizationIdentifier;
    public static final ASN1ObjectIdentifier id_at_telephoneNumber;

    /* renamed from: id_ce */
    public static final ASN1ObjectIdentifier f18743id_ce;
    public static final ASN1ObjectIdentifier id_ea_rsa;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;

    /* renamed from: id_pda */
    public static final ASN1ObjectIdentifier f18744id_pda;

    /* renamed from: id_pe */
    public static final ASN1ObjectIdentifier f18745id_pe;

    /* renamed from: id_pkix */
    public static final ASN1ObjectIdentifier f18746id_pkix;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake128;
    public static final ASN1ObjectIdentifier id_rsassa_pss_shake256;
    public static final ASN1ObjectIdentifier localityName;
    public static final ASN1ObjectIdentifier ocspAccessMethod;
    public static final ASN1ObjectIdentifier organization;
    public static final ASN1ObjectIdentifier organizationalUnitName;
    public static final ASN1ObjectIdentifier pkix_algorithms;
    public static final ASN1ObjectIdentifier ripemd160;
    public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption;
    public static final ASN1ObjectIdentifier stateOrProvinceName;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern = new ASN1ObjectIdentifier("2.5.4").m14434intern();
        attributeType = aSN1ObjectIdentifierM14434intern;
        commonName = aSN1ObjectIdentifierM14434intern.m14432branch("3").m14434intern();
        countryName = aSN1ObjectIdentifierM14434intern.m14432branch("6").m14434intern();
        localityName = aSN1ObjectIdentifierM14434intern.m14432branch("7").m14434intern();
        stateOrProvinceName = aSN1ObjectIdentifierM14434intern.m14432branch("8").m14434intern();
        organization = aSN1ObjectIdentifierM14434intern.m14432branch("10").m14434intern();
        organizationalUnitName = aSN1ObjectIdentifierM14434intern.m14432branch("11").m14434intern();
        id_at_telephoneNumber = aSN1ObjectIdentifierM14434intern.m14432branch("20").m14434intern();
        id_at_name = aSN1ObjectIdentifierM14434intern.m14432branch("41").m14434intern();
        id_at_organizationIdentifier = aSN1ObjectIdentifierM14434intern.m14432branch("97").m14434intern();
        f18741id_SHA1 = new ASN1ObjectIdentifier("1.3.14.3.2.26").m14434intern();
        ripemd160 = new ASN1ObjectIdentifier("1.3.36.3.2.1").m14434intern();
        ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2").m14434intern();
        id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1").m14434intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        f18746id_pkix = aSN1ObjectIdentifier;
        f18745id_pe = aSN1ObjectIdentifier.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("6");
        pkix_algorithms = aSN1ObjectIdentifierM14432branch;
        id_rsassa_pss_shake128 = aSN1ObjectIdentifierM14432branch.m14432branch("30");
        id_rsassa_pss_shake256 = aSN1ObjectIdentifierM14432branch.m14432branch("31");
        id_ecdsa_with_shake128 = aSN1ObjectIdentifierM14432branch.m14432branch("32");
        id_ecdsa_with_shake256 = aSN1ObjectIdentifierM14432branch.m14432branch("33");
        id_alg_noSignature = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_alg_unsigned = aSN1ObjectIdentifierM14432branch.m14432branch("36");
        f18744id_pda = aSN1ObjectIdentifier.m14432branch("9");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifier.m14432branch("48");
        f18742id_ad = aSN1ObjectIdentifierM14432branch2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern2 = aSN1ObjectIdentifierM14432branch2.m14432branch("2").m14434intern();
        id_ad_caIssuers = aSN1ObjectIdentifierM14434intern2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14434intern3 = aSN1ObjectIdentifierM14432branch2.m14432branch("1").m14434intern();
        id_ad_ocsp = aSN1ObjectIdentifierM14434intern3;
        ocspAccessMethod = aSN1ObjectIdentifierM14434intern3;
        crlAccessMethod = aSN1ObjectIdentifierM14434intern2;
        f18743id_ce = new ASN1ObjectIdentifier("2.5.29");
        id_PasswordBasedMac = MiscObjectIdentifiers.f21266entrust.m14432branch("66.13");
    }
}
