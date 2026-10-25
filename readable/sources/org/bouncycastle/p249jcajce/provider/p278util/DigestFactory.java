package org.bouncycastle.p249jcajce.provider.p278util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class DigestFactory {

    /* renamed from: md5 */
    private static Set f21904md5 = new HashSet();

    /* renamed from: sha1 */
    private static Set f21906sha1 = new HashSet();

    /* renamed from: sha224 */
    private static Set f21907sha224 = new HashSet();

    /* renamed from: sha256 */
    private static Set f21908sha256 = new HashSet();

    /* renamed from: sha384 */
    private static Set f21909sha384 = new HashSet();

    /* renamed from: sha512 */
    private static Set f21910sha512 = new HashSet();
    private static Set sha512_224 = new HashSet();
    private static Set sha512_256 = new HashSet();
    private static Set sha3_224 = new HashSet();
    private static Set sha3_256 = new HashSet();
    private static Set sha3_384 = new HashSet();
    private static Set sha3_512 = new HashSet();
    private static Set shake128 = new HashSet();
    private static Set shake256 = new HashSet();

    /* renamed from: oids */
    private static Map f21905oids = new HashMap();

    static {
        f21904md5.add("MD5");
        Set set = f21904md5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.f18503md5;
        set.add(aSN1ObjectIdentifier.m14433getId());
        f21906sha1.add("SHA1");
        f21906sha1.add("SHA-1");
        Set set2 = f21906sha1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.f21282idSHA1;
        set2.add(aSN1ObjectIdentifier2.m14433getId());
        f21907sha224.add("SHA224");
        f21907sha224.add("SHA-224");
        Set set3 = f21907sha224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        set3.add(aSN1ObjectIdentifier3.m14433getId());
        f21908sha256.add("SHA256");
        f21908sha256.add(XMSSKeyParameters.f23621SHA_256);
        Set set4 = f21908sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        set4.add(aSN1ObjectIdentifier4.m14433getId());
        f21909sha384.add("SHA384");
        f21909sha384.add("SHA-384");
        Set set5 = f21909sha384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        set5.add(aSN1ObjectIdentifier5.m14433getId());
        f21910sha512.add("SHA512");
        f21910sha512.add(XMSSKeyParameters.f23622SHA_512);
        Set set6 = f21910sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        set6.add(aSN1ObjectIdentifier6.m14433getId());
        sha512_224.add("SHA512(224)");
        sha512_224.add("SHA-512(224)");
        Set set7 = sha512_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha512_224;
        set7.add(aSN1ObjectIdentifier7.m14433getId());
        sha512_256.add("SHA512(256)");
        sha512_256.add("SHA-512(256)");
        Set set8 = sha512_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha512_256;
        set8.add(aSN1ObjectIdentifier8.m14433getId());
        sha3_224.add("SHA3-224");
        Set set9 = sha3_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_sha3_224;
        set9.add(aSN1ObjectIdentifier9.m14433getId());
        sha3_256.add("SHA3-256");
        Set set10 = sha3_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_sha3_256;
        set10.add(aSN1ObjectIdentifier10.m14433getId());
        sha3_384.add("SHA3-384");
        Set set11 = sha3_384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_sha3_384;
        set11.add(aSN1ObjectIdentifier11.m14433getId());
        sha3_512.add("SHA3-512");
        Set set12 = sha3_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_sha3_512;
        set12.add(aSN1ObjectIdentifier12.m14433getId());
        shake128.add("SHAKE128");
        Set set13 = shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_shake128;
        set13.add(aSN1ObjectIdentifier13.m14433getId());
        shake256.add("SHAKE256");
        Set set14 = shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.id_shake256;
        set14.add(aSN1ObjectIdentifier14.m14433getId());
        f21905oids.put("MD5", aSN1ObjectIdentifier);
        f21905oids.put(aSN1ObjectIdentifier.m14433getId(), aSN1ObjectIdentifier);
        f21905oids.put("SHA1", aSN1ObjectIdentifier2);
        f21905oids.put("SHA-1", aSN1ObjectIdentifier2);
        f21905oids.put(aSN1ObjectIdentifier2.m14433getId(), aSN1ObjectIdentifier2);
        f21905oids.put("SHA224", aSN1ObjectIdentifier3);
        f21905oids.put("SHA-224", aSN1ObjectIdentifier3);
        f21905oids.put(aSN1ObjectIdentifier3.m14433getId(), aSN1ObjectIdentifier3);
        f21905oids.put("SHA256", aSN1ObjectIdentifier4);
        f21905oids.put(XMSSKeyParameters.f23621SHA_256, aSN1ObjectIdentifier4);
        f21905oids.put(aSN1ObjectIdentifier4.m14433getId(), aSN1ObjectIdentifier4);
        f21905oids.put("SHA384", aSN1ObjectIdentifier5);
        f21905oids.put("SHA-384", aSN1ObjectIdentifier5);
        f21905oids.put(aSN1ObjectIdentifier5.m14433getId(), aSN1ObjectIdentifier5);
        f21905oids.put("SHA512", aSN1ObjectIdentifier6);
        f21905oids.put(XMSSKeyParameters.f23622SHA_512, aSN1ObjectIdentifier6);
        f21905oids.put(aSN1ObjectIdentifier6.m14433getId(), aSN1ObjectIdentifier6);
        f21905oids.put("SHA512(224)", aSN1ObjectIdentifier7);
        f21905oids.put("SHA-512(224)", aSN1ObjectIdentifier7);
        f21905oids.put(aSN1ObjectIdentifier7.m14433getId(), aSN1ObjectIdentifier7);
        f21905oids.put("SHA512(256)", aSN1ObjectIdentifier8);
        f21905oids.put("SHA-512(256)", aSN1ObjectIdentifier8);
        f21905oids.put(aSN1ObjectIdentifier8.m14433getId(), aSN1ObjectIdentifier8);
        f21905oids.put("SHA3-224", aSN1ObjectIdentifier9);
        f21905oids.put(aSN1ObjectIdentifier9.m14433getId(), aSN1ObjectIdentifier9);
        f21905oids.put("SHA3-256", aSN1ObjectIdentifier10);
        f21905oids.put(aSN1ObjectIdentifier10.m14433getId(), aSN1ObjectIdentifier10);
        f21905oids.put("SHA3-384", aSN1ObjectIdentifier11);
        f21905oids.put(aSN1ObjectIdentifier11.m14433getId(), aSN1ObjectIdentifier11);
        f21905oids.put("SHA3-512", aSN1ObjectIdentifier12);
        f21905oids.put(aSN1ObjectIdentifier12.m14433getId(), aSN1ObjectIdentifier12);
        f21905oids.put("SHAKE128", aSN1ObjectIdentifier13);
        f21905oids.put(aSN1ObjectIdentifier13.m14433getId(), aSN1ObjectIdentifier13);
        f21905oids.put("SHAKE256", aSN1ObjectIdentifier14);
        f21905oids.put(aSN1ObjectIdentifier14.m14433getId(), aSN1ObjectIdentifier14);
    }

    public static InterfaceC5277Digest getDigest(String str) {
        String upperCase = C6250Strings.toUpperCase(str);
        if (f21906sha1.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA1();
        }
        if (f21904md5.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createMD5();
        }
        if (f21907sha224.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA224();
        }
        if (f21908sha256.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA256();
        }
        if (f21909sha384.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA384();
        }
        if (f21910sha512.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA512();
        }
        if (sha512_224.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA512_224();
        }
        if (sha512_256.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA512_256();
        }
        if (sha3_224.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA3_224();
        }
        if (sha3_256.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA3_256();
        }
        if (sha3_384.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA3_384();
        }
        if (sha3_512.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHA3_512();
        }
        if (shake128.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHAKE128();
        }
        if (shake256.contains(upperCase)) {
            return org.bouncycastle.p194crypto.p221util.DigestFactory.createSHAKE256();
        }
        return null;
    }

    /* renamed from: getOID */
    public static ASN1ObjectIdentifier m16181getOID(String str) {
        return (ASN1ObjectIdentifier) f21905oids.get(str);
    }

    public static boolean isSameDigest(String str, String str2) {
        return (f21906sha1.contains(str) && f21906sha1.contains(str2)) || (f21907sha224.contains(str) && f21907sha224.contains(str2)) || ((f21908sha256.contains(str) && f21908sha256.contains(str2)) || ((f21909sha384.contains(str) && f21909sha384.contains(str2)) || ((f21910sha512.contains(str) && f21910sha512.contains(str2)) || ((sha512_224.contains(str) && sha512_224.contains(str2)) || ((sha512_256.contains(str) && sha512_256.contains(str2)) || ((sha3_224.contains(str) && sha3_224.contains(str2)) || ((sha3_256.contains(str) && sha3_256.contains(str2)) || ((sha3_384.contains(str) && sha3_384.contains(str2)) || ((sha3_512.contains(str) && sha3_512.contains(str2)) || (f21904md5.contains(str) && f21904md5.contains(str2)))))))))));
    }
}
