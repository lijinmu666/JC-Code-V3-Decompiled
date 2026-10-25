package org.bouncycastle.p194crypto.p221util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class PBKDF2Config extends PBKDFConfig {
    private static final Map PRFS_SALT;
    public static final AlgorithmIdentifier PRF_SHA1;
    public static final AlgorithmIdentifier PRF_SHA256;
    public static final AlgorithmIdentifier PRF_SHA3_256;
    public static final AlgorithmIdentifier PRF_SHA3_512;
    public static final AlgorithmIdentifier PRF_SHA512;
    private final int iterationCount;

    /* renamed from: prf */
    private final AlgorithmIdentifier f21132prf;
    private final int saltLength;

    /* renamed from: org.bouncycastle.crypto.util.PBKDF2Config$Builder */
    public static class C5422Builder {
        private int iterationCount = 1024;
        private int saltLength = -1;

        /* renamed from: prf */
        private AlgorithmIdentifier f21133prf = PBKDF2Config.PRF_SHA1;

        /* renamed from: build */
        public PBKDF2Config m15929build() {
            return new PBKDF2Config(this);
        }

        public C5422Builder withIterationCount(int i) {
            this.iterationCount = i;
            return this;
        }

        /* renamed from: withPRF */
        public C5422Builder m15930withPRF(AlgorithmIdentifier algorithmIdentifier) {
            this.f21133prf = algorithmIdentifier;
            return this;
        }

        public C5422Builder withSaltLength(int i) {
            this.saltLength = i;
            return this;
        }
    }

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA1;
        C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
        PRF_SHA1 = new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        PRF_SHA256 = new AlgorithmIdentifier(aSN1ObjectIdentifier2, c5103DERNull);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        PRF_SHA512 = new AlgorithmIdentifier(aSN1ObjectIdentifier3, c5103DERNull);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_hmacWithSHA3_256;
        PRF_SHA3_256 = new AlgorithmIdentifier(aSN1ObjectIdentifier4, c5103DERNull);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_hmacWithSHA3_512;
        PRF_SHA3_512 = new AlgorithmIdentifier(aSN1ObjectIdentifier5, c5103DERNull);
        HashMap map = new HashMap();
        PRFS_SALT = map;
        map.put(aSN1ObjectIdentifier, Integers.m18296valueOf(20));
        map.put(aSN1ObjectIdentifier2, Integers.m18296valueOf(32));
        map.put(aSN1ObjectIdentifier3, Integers.m18296valueOf(64));
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.m18296valueOf(28));
        map.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.m18296valueOf(48));
        map.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.m18296valueOf(28));
        map.put(aSN1ObjectIdentifier4, Integers.m18296valueOf(32));
        map.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.m18296valueOf(48));
        map.put(aSN1ObjectIdentifier5, Integers.m18296valueOf(64));
        map.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.m18296valueOf(32));
        map.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_256, Integers.m18296valueOf(32));
        map.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_512, Integers.m18296valueOf(64));
        map.put(GMObjectIdentifiers.hmac_sm3, Integers.m18296valueOf(32));
    }

    private PBKDF2Config(C5422Builder c5422Builder) {
        super(PKCSObjectIdentifiers.id_PBKDF2);
        this.iterationCount = c5422Builder.iterationCount;
        AlgorithmIdentifier algorithmIdentifier = c5422Builder.f21133prf;
        this.f21132prf = algorithmIdentifier;
        this.saltLength = c5422Builder.saltLength < 0 ? getSaltSize(algorithmIdentifier.getAlgorithm()) : c5422Builder.saltLength;
    }

    public static int getSaltSize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Map map = PRFS_SALT;
        if (map.containsKey(aSN1ObjectIdentifier)) {
            return ((Integer) map.get(aSN1ObjectIdentifier)).intValue();
        }
        throw new IllegalStateException("no salt size for algorithm: " + aSN1ObjectIdentifier);
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    /* renamed from: getPRF */
    public AlgorithmIdentifier m15928getPRF() {
        return this.f21132prf;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
