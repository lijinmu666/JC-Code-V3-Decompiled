package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.OtherRevocationInfoFormat;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AttributeCertificate;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
class CMSSignedHelper {
    static final CMSSignedHelper INSTANCE = new CMSSignedHelper();
    private static final Map encryptionAlgs = new HashMap();

    static {
        addEntries(NISTObjectIdentifiers.dsa_with_sha224, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha256, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha384, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha512, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_224, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_256, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_384, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_512, "DSA");
        addEntries(OIWObjectIdentifiers.dsaWithSHA1, "DSA");
        addEntries(OIWObjectIdentifiers.md4WithRSA, "RSA");
        addEntries(OIWObjectIdentifiers.md4WithRSAEncryption, "RSA");
        addEntries(OIWObjectIdentifiers.md5WithRSA, "RSA");
        addEntries(OIWObjectIdentifiers.sha1WithRSA, "RSA");
        addEntries(PKCSObjectIdentifiers.md2WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.md4WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.md5WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha1WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha224WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha256WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha384WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha512WithRSAEncryption, "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224, "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256, "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384, "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512, "RSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA1, "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA224, "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA256, "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA384, "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA512, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_224, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_256, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_384, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_512, "ECDSA");
        addEntries(X9ObjectIdentifiers.id_dsa_with_sha1, "DSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1, "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256, "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1, "RSAandMGF1");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256, "RSAandMGF1");
        addEntries(X9ObjectIdentifiers.f18789id_dsa, "DSA");
        addEntries(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        addEntries(TeleTrusTObjectIdentifiers.teleTrusTRSAsignatureAlgorithm, "RSA");
        addEntries(X509ObjectIdentifiers.id_ea_rsa, "RSA");
        addEntries(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSAandMGF1");
        addEntries(CryptoProObjectIdentifiers.gostR3410_94, "GOST3410");
        addEntries(CryptoProObjectIdentifiers.gostR3410_2001, "ECGOST3410");
        addEntries(new ASN1ObjectIdentifier("1.3.6.1.4.1.5849.1.6.2"), "ECGOST3410");
        addEntries(new ASN1ObjectIdentifier("1.3.6.1.4.1.5849.1.1.5"), "GOST3410");
        addEntries(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256, "ECGOST3410-2012-256");
        addEntries(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512, "ECGOST3410-2012-512");
        addEntries(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "ECGOST3410");
        addEntries(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3410");
        addEntries(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "ECGOST3410-2012-256");
        addEntries(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "ECGOST3410-2012-512");
    }

    private static void addEntries(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        encryptionAlgs.put(aSN1ObjectIdentifier.m14433getId(), str);
    }

    public AlgorithmIdentifier fixDigestAlgID(AlgorithmIdentifier algorithmIdentifier, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        return (parameters == null || C5103DERNull.INSTANCE.m14445equals(parameters)) ? digestAlgorithmIdentifierFinder.mo17381find(algorithmIdentifier.getAlgorithm()) : algorithmIdentifier;
    }

    public InterfaceC6249Store getAttributeCertificates(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        if (abstractC5093ASN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(abstractC5093ASN1Set.m14454size());
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                if (aSN1TaggedObject.getTagNo() == 1 || aSN1TaggedObject.getTagNo() == 2) {
                    arrayList.add(new X509AttributeCertificateHolder(AttributeCertificate.getInstance(aSN1TaggedObject.getBaseUniversal(false, 16))));
                }
            }
        }
        return new CollectionStore(arrayList);
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store m14876getCRLs(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        if (abstractC5093ASN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(abstractC5093ASN1Set.m14454size());
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Sequence) {
                arrayList.add(new X509CRLHolder(CertificateList.getInstance(aSN1Primitive)));
            }
        }
        return new CollectionStore(arrayList);
    }

    public InterfaceC6249Store getCertificates(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        if (abstractC5093ASN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(abstractC5093ASN1Set.m14454size());
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Sequence) {
                arrayList.add(new X509CertificateHolder(Certificate.getInstance(aSN1Primitive)));
            }
        }
        return new CollectionStore(arrayList);
    }

    public String getEncryptionAlgName(String str) {
        String str2 = (String) encryptionAlgs.get(str);
        return str2 != null ? str2 : str;
    }

    public InterfaceC6249Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        if (abstractC5093ASN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(abstractC5093ASN1Set.m14454size());
        Enumeration objects = abstractC5093ASN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Primitive);
                if (aSN1TaggedObject.hasContextTag(1)) {
                    OtherRevocationInfoFormat otherRevocationInfoFormat = OtherRevocationInfoFormat.getInstance(aSN1TaggedObject, false);
                    if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) otherRevocationInfoFormat.getInfoFormat())) {
                        arrayList.add(otherRevocationInfoFormat.m14549getInfo());
                    }
                }
            }
        }
        return new CollectionStore(arrayList);
    }

    public void setSigningEncryptionAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        addEntries(aSN1ObjectIdentifier, str);
    }
}
