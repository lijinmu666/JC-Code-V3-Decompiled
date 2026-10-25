package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p221util.DEROtherInfo;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p316crypto.ExchangePair;

/* loaded from: classes2.dex */
public class NHOtherInfoGenerator {
    protected final DEROtherInfo.C5403Builder otherInfoBuilder;

    /* renamed from: random */
    protected final SecureRandom f23361random;

    /* renamed from: used */
    protected boolean f23362used = false;

    /* renamed from: org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator$PartyU */
    public static class C6081PartyU extends NHOtherInfoGenerator {

        /* renamed from: aKp */
        private AsymmetricCipherKeyPair f23363aKp;
        private NHAgreement agreement;

        public C6081PartyU(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            this.agreement = new NHAgreement();
            NHKeyPairGenerator nHKeyPairGenerator = new NHKeyPairGenerator();
            nHKeyPairGenerator.mo14944init(new KeyGenerationParameters(secureRandom, 2048));
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = nHKeyPairGenerator.generateKeyPair();
            this.f23363aKp = asymmetricCipherKeyPairGenerateKeyPair;
            this.agreement.m17737init(asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        }

        public DEROtherInfo generate(byte[] bArr) {
            if (this.f23362used) {
                throw new IllegalStateException("builder already used");
            }
            this.f23362used = true;
            this.otherInfoBuilder.withSuppPrivInfo(this.agreement.calculateAgreement(NHOtherInfoGenerator.getPublicKey(bArr)));
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartA() {
            return NHOtherInfoGenerator.getEncoded((NHPublicKeyParameters) this.f23363aKp.getPublic());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    /* renamed from: org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator$PartyV */
    public static class C6082PartyV extends NHOtherInfoGenerator {
        public C6082PartyV(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
        }

        public DEROtherInfo generate() {
            if (this.f23362used) {
                throw new IllegalStateException("builder already used");
            }
            this.f23362used = true;
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartB(byte[] bArr) {
            ExchangePair exchangePairGenerateExchange = new NHExchangePairGenerator(this.f23361random).generateExchange(NHOtherInfoGenerator.getPublicKey(bArr));
            this.otherInfoBuilder.withSuppPrivInfo(exchangePairGenerateExchange.getSharedValue());
            return NHOtherInfoGenerator.getEncoded((NHPublicKeyParameters) exchangePairGenerateExchange.getPublicKey());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    public NHOtherInfoGenerator(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.otherInfoBuilder = new DEROtherInfo.C5403Builder(algorithmIdentifier, bArr, bArr2);
        this.f23361random = secureRandom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] getEncoded(NHPublicKeyParameters nHPublicKeyParameters) {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23021newHope), nHPublicKeyParameters.getPubData()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NHPublicKeyParameters getPublicKey(byte[] bArr) {
        return new NHPublicKeyParameters(SubjectPublicKeyInfo.getInstance(bArr).getPublicKeyData().getOctets());
    }
}
