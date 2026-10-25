package org.bouncycastle.p133asn1.p164ocsp;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes2.dex */
public interface OCSPObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_pkix_ocsp;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_archive_cutoff;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_basic;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_crl;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_extended_revoke;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_nocheck;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_nonce;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_pref_sig_algs;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_response;
    public static final ASN1ObjectIdentifier id_pkix_ocsp_service_locator;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.id_ad_ocsp;
        id_pkix_ocsp = aSN1ObjectIdentifier;
        id_pkix_ocsp_basic = aSN1ObjectIdentifier.m14432branch("1");
        id_pkix_ocsp_nonce = aSN1ObjectIdentifier.m14432branch("2");
        id_pkix_ocsp_crl = aSN1ObjectIdentifier.m14432branch("3");
        id_pkix_ocsp_response = aSN1ObjectIdentifier.m14432branch("4");
        id_pkix_ocsp_nocheck = aSN1ObjectIdentifier.m14432branch("5");
        id_pkix_ocsp_archive_cutoff = aSN1ObjectIdentifier.m14432branch("6");
        id_pkix_ocsp_service_locator = aSN1ObjectIdentifier.m14432branch("7");
        id_pkix_ocsp_pref_sig_algs = aSN1ObjectIdentifier.m14432branch("8");
        id_pkix_ocsp_extended_revoke = aSN1ObjectIdentifier.m14432branch("9");
    }
}
