package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.ExchangePair;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NHSecretKeyProcessor {

    /* renamed from: xof */
    private final InterfaceC5284Xof f23366xof;

    public static class PartyUBuilder {

        /* renamed from: aKp */
        private final AsymmetricCipherKeyPair f23367aKp;
        private final NHAgreement agreement;
        private byte[] sharedInfo;

        /* renamed from: used */
        private boolean f23368used;

        public PartyUBuilder(SecureRandom secureRandom) {
            NHAgreement nHAgreement = new NHAgreement();
            this.agreement = nHAgreement;
            this.sharedInfo = null;
            this.f23368used = false;
            NHKeyPairGenerator nHKeyPairGenerator = new NHKeyPairGenerator();
            nHKeyPairGenerator.mo14944init(new KeyGenerationParameters(secureRandom, 2048));
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = nHKeyPairGenerator.generateKeyPair();
            this.f23367aKp = asymmetricCipherKeyPairGenerateKeyPair;
            nHAgreement.m17737init(asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        }

        /* renamed from: build */
        public NHSecretKeyProcessor m17739build(byte[] bArr) {
            if (this.f23368used) {
                throw new IllegalStateException("builder already used");
            }
            this.f23368used = true;
            return new NHSecretKeyProcessor(this.agreement.calculateAgreement(new NHPublicKeyParameters(bArr)), this.sharedInfo);
        }

        public byte[] getPartA() {
            return ((NHPublicKeyParameters) this.f23367aKp.getPublic()).getPubData();
        }

        public PartyUBuilder withSharedInfo(byte[] bArr) {
            this.sharedInfo = C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    public static class PartyVBuilder {

        /* renamed from: random */
        protected final SecureRandom f23369random;
        private byte[] sharedInfo = null;
        private byte[] sharedSecret = null;

        /* renamed from: used */
        private boolean f23370used = false;

        public PartyVBuilder(SecureRandom secureRandom) {
            this.f23369random = secureRandom;
        }

        /* renamed from: build */
        public NHSecretKeyProcessor m17740build() {
            if (this.f23370used) {
                throw new IllegalStateException("builder already used");
            }
            this.f23370used = true;
            return new NHSecretKeyProcessor(this.sharedSecret, this.sharedInfo);
        }

        public byte[] getPartB(byte[] bArr) {
            ExchangePair exchangePairGenerateExchange = new NHExchangePairGenerator(this.f23369random).generateExchange(new NHPublicKeyParameters(bArr));
            this.sharedSecret = exchangePairGenerateExchange.getSharedValue();
            return ((NHPublicKeyParameters) exchangePairGenerateExchange.getPublicKey()).getPubData();
        }

        public PartyVBuilder withSharedInfo(byte[] bArr) {
            this.sharedInfo = C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    private NHSecretKeyProcessor(byte[] bArr, byte[] bArr2) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        this.f23366xof = sHAKEDigest;
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        if (bArr2 != null) {
            sHAKEDigest.mo14970update(bArr2, 0, bArr2.length);
        }
        C6238Arrays.m18249fill(bArr, (byte) 0);
    }

    /* renamed from: xor */
    private static void m17738xor(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public byte[] processKey(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f23366xof.mo14998doFinal(bArr2, 0, length);
        m17738xor(bArr, bArr2);
        C6238Arrays.m18249fill(bArr2, (byte) 0);
        return bArr;
    }
}
