package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface DVCSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_aa_dvcs_dvc;
    public static final ASN1ObjectIdentifier id_ad_dvcs;
    public static final ASN1ObjectIdentifier id_ct_DVCSRequestData;
    public static final ASN1ObjectIdentifier id_ct_DVCSResponseData;
    public static final ASN1ObjectIdentifier id_kp_dvcs;

    /* renamed from: id_pkix */
    public static final ASN1ObjectIdentifier f18306id_pkix;
    public static final ASN1ObjectIdentifier id_smime;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        f18306id_pkix = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.16");
        id_smime = aSN1ObjectIdentifier2;
        id_ad_dvcs = aSN1ObjectIdentifier.m14432branch("48.4");
        id_kp_dvcs = aSN1ObjectIdentifier.m14432branch("3.10");
        id_ct_DVCSRequestData = aSN1ObjectIdentifier2.m14432branch("1.7");
        id_ct_DVCSResponseData = aSN1ObjectIdentifier2.m14432branch("1.8");
        id_aa_dvcs_dvc = aSN1ObjectIdentifier2.m14432branch("2.29");
    }
}
