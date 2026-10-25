package org.bouncycastle.p191cms.p192bc;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.p305bc.BcDigestProvider;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p199digests.SHA224Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.DESEngine;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.RC2Engine;
import org.bouncycastle.p194crypto.p201engines.RFC3211WrapEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.AlgorithmIdentifierFactory;
import org.bouncycastle.p194crypto.p221util.CipherFactory;
import org.bouncycastle.p194crypto.p221util.CipherKeyGeneratorFactory;

/* loaded from: classes2.dex */
class EnvelopedDataHelper {
    protected static final Map BASE_CIPHER_NAMES;
    protected static final Map MAC_ALG_NAMES;
    private static final Set authEnvelopedAlgorithms;

    /* renamed from: prfs */
    private static final Map f19057prfs;

    static {
        HashMap map = new HashMap();
        BASE_CIPHER_NAMES = map;
        HashMap map2 = new HashMap();
        MAC_ALG_NAMES = map2;
        HashSet hashSet = new HashSet();
        authEnvelopedAlgorithms = hashSet;
        f19057prfs = createTable();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSAlgorithm.DES_EDE3_CBC;
        map.put(aSN1ObjectIdentifier, "DESEDE");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAlgorithm.AES128_CBC;
        map.put(aSN1ObjectIdentifier2, "AES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAlgorithm.AES192_CBC;
        map.put(aSN1ObjectIdentifier3, "AES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CMSAlgorithm.AES256_CBC;
        map.put(aSN1ObjectIdentifier4, "AES");
        map2.put(aSN1ObjectIdentifier, "DESEDEMac");
        map2.put(aSN1ObjectIdentifier2, "AESMac");
        map2.put(aSN1ObjectIdentifier3, "AESMac");
        map2.put(aSN1ObjectIdentifier4, "AESMac");
        map2.put(CMSAlgorithm.f18929RC2_CBC, "RC2Mac");
        hashSet.add(CMSAlgorithm.AES128_GCM);
        hashSet.add(CMSAlgorithm.AES192_GCM);
        hashSet.add(CMSAlgorithm.AES256_GCM);
        hashSet.add(CMSAlgorithm.AES128_CCM);
        hashSet.add(CMSAlgorithm.AES192_CCM);
        hashSet.add(CMSAlgorithm.AES256_CCM);
        hashSet.add(CMSAlgorithm.ChaCha20Poly1305);
    }

    public static Object createContentCipher(boolean z, CipherParameters cipherParameters, AlgorithmIdentifier algorithmIdentifier) throws CMSException {
        try {
            return CipherFactory.createContentCipher(z, cipherParameters, algorithmIdentifier);
        } catch (IllegalArgumentException e) {
            throw new CMSException(e.getMessage(), e);
        }
    }

    public static InterfaceC5283Wrapper createRFC3211Wrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        if (NISTObjectIdentifiers.id_aes128_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes192_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes256_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new RFC3211WrapEngine(AESEngine.newInstance());
        }
        if (PKCSObjectIdentifiers.des_EDE3_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new RFC3211WrapEngine(new DESedeEngine());
        }
        if (OIWObjectIdentifiers.f18454desCBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new RFC3211WrapEngine(new DESEngine());
        }
        if (PKCSObjectIdentifiers.f18490RC2_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new RFC3211WrapEngine(new RC2Engine());
        }
        throw new CMSException("cannot recognise wrapper: " + aSN1ObjectIdentifier);
    }

    private static Map createTable() {
        HashMap map = new HashMap();
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA1, new BcDigestProvider() { // from class: org.bouncycastle.cms.bc.EnvelopedDataHelper.1
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA1Digest();
            }
        });
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA224, new BcDigestProvider() { // from class: org.bouncycastle.cms.bc.EnvelopedDataHelper.2
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA224Digest();
            }
        });
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA256, new BcDigestProvider() { // from class: org.bouncycastle.cms.bc.EnvelopedDataHelper.3
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return SHA256Digest.newInstance();
            }
        });
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA384, new BcDigestProvider() { // from class: org.bouncycastle.cms.bc.EnvelopedDataHelper.4
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA384Digest();
            }
        });
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA512, new BcDigestProvider() { // from class: org.bouncycastle.cms.bc.EnvelopedDataHelper.5
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA512Digest();
            }
        });
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: getPRF */
    public static ExtendedDigest m14915getPRF(AlgorithmIdentifier algorithmIdentifier) {
        return ((BcDigestProvider) f19057prfs.get(algorithmIdentifier.getAlgorithm())).mo14916get(null);
    }

    public CipherKeyGenerator createKeyGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) throws CMSException {
        try {
            return CipherKeyGeneratorFactory.createKeyGenerator(aSN1ObjectIdentifier, secureRandom);
        } catch (IllegalArgumentException e) {
            throw new CMSException(e.getMessage(), e);
        }
    }

    public AlgorithmIdentifier generateEncryptionAlgID(ASN1ObjectIdentifier aSN1ObjectIdentifier, KeyParameter keyParameter, SecureRandom secureRandom) throws CMSException {
        try {
            return AlgorithmIdentifierFactory.generateEncryptionAlgID(aSN1ObjectIdentifier, keyParameter.m15773getKey().length * 8, secureRandom);
        } catch (IllegalArgumentException e) {
            throw new CMSException(e.getMessage(), e);
        }
    }

    public boolean isAuthEnveloped(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return authEnvelopedAlgorithms.contains(aSN1ObjectIdentifier);
    }
}
