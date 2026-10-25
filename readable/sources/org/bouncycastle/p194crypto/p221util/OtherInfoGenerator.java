package org.bouncycastle.p194crypto.p221util;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.KEMParameters;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.generators.MLKEMKeyPairGenerator;
import org.bouncycastle.p194crypto.p207kems.MLKEMExtractor;
import org.bouncycastle.p194crypto.p207kems.MLKEMGenerator;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLKEMKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p221util.DEROtherInfo;

/* loaded from: classes2.dex */
public class OtherInfoGenerator {
    protected final DEROtherInfo.C5403Builder otherInfoBuilder;

    /* renamed from: random */
    protected final SecureRandom f21127random;

    /* renamed from: used */
    protected boolean f21128used = false;

    /* renamed from: org.bouncycastle.crypto.util.OtherInfoGenerator$PartyU */
    public static class C5419PartyU extends OtherInfoGenerator {

        /* renamed from: aKp */
        private AsymmetricCipherKeyPair f21129aKp;

        /* renamed from: encSE */
        private EncapsulatedSecretExtractor f21130encSE;

        public C5419PartyU(KEMParameters kEMParameters, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            if (!(kEMParameters instanceof MLKEMParameters)) {
                throw new IllegalArgumentException("unknown KEMParameters");
            }
            MLKEMKeyPairGenerator mLKEMKeyPairGenerator = new MLKEMKeyPairGenerator();
            mLKEMKeyPairGenerator.mo14944init(new MLKEMKeyGenerationParameters(secureRandom, (MLKEMParameters) kEMParameters));
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = mLKEMKeyPairGenerator.generateKeyPair();
            this.f21129aKp = asymmetricCipherKeyPairGenerateKeyPair;
            this.f21130encSE = new MLKEMExtractor((MLKEMPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        }

        public DEROtherInfo generate(byte[] bArr) {
            this.otherInfoBuilder.withSuppPrivInfo(this.f21130encSE.extractSecret(bArr));
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartA() {
            return OtherInfoGenerator.getEncoded(this.f21129aKp.getPublic());
        }

        public OtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    /* renamed from: org.bouncycastle.crypto.util.OtherInfoGenerator$PartyV */
    public static class C5420PartyV extends OtherInfoGenerator {

        /* renamed from: encSG */
        private EncapsulatedSecretGenerator f21131encSG;

        public C5420PartyV(KEMParameters kEMParameters, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            if (!(kEMParameters instanceof MLKEMParameters)) {
                throw new IllegalArgumentException("unknown KEMParameters");
            }
            this.f21131encSG = new MLKEMGenerator(secureRandom);
        }

        public DEROtherInfo generate() {
            if (this.f21128used) {
                throw new IllegalStateException("builder already used");
            }
            this.f21128used = true;
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartB(byte[] bArr) {
            this.f21128used = false;
            try {
                SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = this.f21131encSG.generateEncapsulated(OtherInfoGenerator.getPublicKey(bArr));
                this.otherInfoBuilder.withSuppPrivInfo(secretWithEncapsulationGenerateEncapsulated.getSecret());
                return secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
            } catch (IOException unused) {
                throw new IllegalArgumentException("cannot decode public key");
            }
        }

        public OtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    public OtherInfoGenerator(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.otherInfoBuilder = new DEROtherInfo.C5403Builder(algorithmIdentifier, bArr, bArr2);
        this.f21127random = secureRandom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AsymmetricKeyParameter getPublicKey(byte[] bArr) {
        return PublicKeyFactory.createKey(bArr);
    }
}
