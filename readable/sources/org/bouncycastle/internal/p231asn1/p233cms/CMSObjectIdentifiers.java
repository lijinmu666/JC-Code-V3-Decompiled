package org.bouncycastle.internal.p231asn1.p233cms;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;

/* loaded from: classes2.dex */
public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256;

    /* renamed from: id_alg */
    public static final ASN1ObjectIdentifier f21239id_alg;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;

    /* renamed from: id_ri */
    public static final ASN1ObjectIdentifier f21240id_ri;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response;
    public static final ASN1ObjectIdentifier id_ri_scvp;

    /* renamed from: data */
    public static final ASN1ObjectIdentifier f21238data = PKCSObjectIdentifiers.f18493data;
    public static final ASN1ObjectIdentifier signedData = PKCSObjectIdentifiers.signedData;
    public static final ASN1ObjectIdentifier envelopedData = PKCSObjectIdentifiers.envelopedData;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier digestedData = PKCSObjectIdentifiers.digestedData;
    public static final ASN1ObjectIdentifier encryptedData = PKCSObjectIdentifiers.encryptedData;
    public static final ASN1ObjectIdentifier authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    public static final ASN1ObjectIdentifier compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    public static final ASN1ObjectIdentifier authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    public static final ASN1ObjectIdentifier timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
        f21240id_ri = aSN1ObjectIdentifier;
        id_ri_ocsp_response = aSN1ObjectIdentifier.m14432branch("2");
        id_ri_scvp = aSN1ObjectIdentifier.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.6");
        f21239id_alg = aSN1ObjectIdentifier2;
        id_RSASSA_PSS_SHAKE128 = aSN1ObjectIdentifier2.m14432branch("30");
        id_RSASSA_PSS_SHAKE256 = aSN1ObjectIdentifier2.m14432branch("31");
        id_ecdsa_with_shake128 = aSN1ObjectIdentifier2.m14432branch("32");
        id_ecdsa_with_shake256 = aSN1ObjectIdentifier2.m14432branch("33");
    }
}
