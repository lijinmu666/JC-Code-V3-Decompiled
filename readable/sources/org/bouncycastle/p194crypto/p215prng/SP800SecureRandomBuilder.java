package org.bouncycastle.p194crypto.p215prng;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p215prng.p216drbg.CTRSP800DRBG;
import org.bouncycastle.p194crypto.p215prng.p216drbg.HMacSP800DRBG;
import org.bouncycastle.p194crypto.p215prng.p216drbg.HashSP800DRBG;
import org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SP800SecureRandomBuilder {
    private int entropyBitsRequired;
    private final EntropySourceProvider entropySourceProvider;
    private byte[] personalizationString;

    /* renamed from: random */
    private final SecureRandom f20881random;
    private int securityStrength;

    public static class CTRDRBGProvider implements DRBGProvider {
        private final BlockCipher blockCipher;
        private final int keySizeInBits;

        /* renamed from: nonce */
        private final byte[] f20882nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public CTRDRBGProvider(BlockCipher blockCipher, int i, byte[] bArr, byte[] bArr2, int i2) {
            this.blockCipher = blockCipher;
            this.keySizeInBits = i;
            this.f20882nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i2;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        /* renamed from: get */
        public SP80090DRBG mo15837get(EntropySource entropySource) {
            return new CTRSP800DRBG(this.blockCipher, this.keySizeInBits, this.securityStrength, entropySource, this.personalizationString, this.f20882nonce);
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        public String getAlgorithm() {
            if (this.blockCipher instanceof DESedeEngine) {
                return "CTR-DRBG-3KEY-TDES";
            }
            return "CTR-DRBG-" + this.blockCipher.getAlgorithmName() + this.keySizeInBits;
        }
    }

    public static class HMacDRBGProvider implements DRBGProvider {

        /* renamed from: hMac */
        private final InterfaceC5278Mac f20883hMac;

        /* renamed from: nonce */
        private final byte[] f20884nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HMacDRBGProvider(InterfaceC5278Mac interfaceC5278Mac, byte[] bArr, byte[] bArr2, int i) {
            this.f20883hMac = interfaceC5278Mac;
            this.f20884nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        /* renamed from: get */
        public SP80090DRBG mo15837get(EntropySource entropySource) {
            return new HMacSP800DRBG(this.f20883hMac, this.securityStrength, entropySource, this.personalizationString, this.f20884nonce);
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        public String getAlgorithm() {
            StringBuilder sb;
            String algorithmName;
            if (this.f20883hMac instanceof C5360HMac) {
                sb = new StringBuilder();
                sb.append("HMAC-DRBG-");
                algorithmName = SP800SecureRandomBuilder.getSimplifiedName(((C5360HMac) this.f20883hMac).getUnderlyingDigest());
            } else {
                sb = new StringBuilder();
                sb.append("HMAC-DRBG-");
                algorithmName = this.f20883hMac.getAlgorithmName();
            }
            sb.append(algorithmName);
            return sb.toString();
        }
    }

    public static class HashDRBGProvider implements DRBGProvider {

        /* renamed from: digest */
        private final InterfaceC5277Digest f20885digest;

        /* renamed from: nonce */
        private final byte[] f20886nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HashDRBGProvider(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, byte[] bArr2, int i) {
            this.f20885digest = interfaceC5277Digest;
            this.f20886nonce = bArr;
            this.personalizationString = bArr2;
            this.securityStrength = i;
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        /* renamed from: get */
        public SP80090DRBG mo15837get(EntropySource entropySource) {
            return new HashSP800DRBG(this.f20885digest, this.securityStrength, entropySource, this.personalizationString, this.f20886nonce);
        }

        @Override // org.bouncycastle.p194crypto.p215prng.DRBGProvider
        public String getAlgorithm() {
            return "HASH-DRBG-" + SP800SecureRandomBuilder.getSimplifiedName(this.f20885digest);
        }
    }

    public SP800SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSimplifiedName(InterfaceC5277Digest interfaceC5277Digest) {
        String algorithmName = interfaceC5277Digest.getAlgorithmName();
        int iIndexOf = algorithmName.indexOf(45);
        if (iIndexOf <= 0 || algorithmName.startsWith("SHA3")) {
            return algorithmName;
        }
        return algorithmName.substring(0, iIndexOf) + algorithmName.substring(iIndexOf + 1);
    }

    public SP800SecureRandom buildCTR(BlockCipher blockCipher, int i, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.f20881random, this.entropySourceProvider.mo15836get(this.entropyBitsRequired), new CTRDRBGProvider(blockCipher, i, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandom buildHMAC(InterfaceC5278Mac interfaceC5278Mac, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.f20881random, this.entropySourceProvider.mo15836get(this.entropyBitsRequired), new HMacDRBGProvider(interfaceC5278Mac, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandom buildHash(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.f20881random, this.entropySourceProvider.mo15836get(this.entropyBitsRequired), new HashDRBGProvider(interfaceC5277Digest, bArr, this.personalizationString, this.securityStrength), z);
    }

    public SP800SecureRandomBuilder setEntropyBitsRequired(int i) {
        this.entropyBitsRequired = i;
        return this;
    }

    public SP800SecureRandomBuilder setPersonalizationString(byte[] bArr) {
        this.personalizationString = C6238Arrays.m18231clone(bArr);
        return this;
    }

    public SP800SecureRandomBuilder setSecurityStrength(int i) {
        this.securityStrength = i;
        return this;
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.f20881random = secureRandom;
        this.entropySourceProvider = new BasicEntropySourceProvider(secureRandom, z);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider entropySourceProvider) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.f20881random = null;
        this.entropySourceProvider = entropySourceProvider;
    }
}
