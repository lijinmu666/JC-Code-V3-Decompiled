package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.DEROtherInfo;
import org.bouncycastle.p314pqc.p316crypto.KEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMGenerator;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKEMGenerator;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPrivateKeyParameters;

/* loaded from: classes2.dex */
public class PQCOtherInfoGenerator {
    protected final DEROtherInfo.C5403Builder otherInfoBuilder;

    /* renamed from: random */
    protected final SecureRandom f23586random;

    /* renamed from: used */
    protected boolean f23587used = false;

    /* renamed from: org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator$PartyU */
    public static class C6104PartyU extends PQCOtherInfoGenerator {

        /* renamed from: aKp */
        private AsymmetricCipherKeyPair f23588aKp;

        /* renamed from: encSE */
        private EncapsulatedSecretExtractor f23589encSE;

        public C6104PartyU(KEMParameters kEMParameters, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            EncapsulatedSecretExtractor nTRUKEMExtractor;
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            if (kEMParameters instanceof MLKEMParameters) {
                MLKEMKeyPairGenerator mLKEMKeyPairGenerator = new MLKEMKeyPairGenerator();
                mLKEMKeyPairGenerator.mo14944init(new MLKEMKeyGenerationParameters(secureRandom, (MLKEMParameters) kEMParameters));
                AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = mLKEMKeyPairGenerator.generateKeyPair();
                this.f23588aKp = asymmetricCipherKeyPairGenerateKeyPair;
                nTRUKEMExtractor = new MLKEMExtractor((MLKEMPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
            } else {
                if (!(kEMParameters instanceof NTRUParameters)) {
                    throw new IllegalArgumentException("unknown KEMParameters");
                }
                NTRUKeyPairGenerator nTRUKeyPairGenerator = new NTRUKeyPairGenerator();
                nTRUKeyPairGenerator.mo14944init(new NTRUKeyGenerationParameters(secureRandom, (NTRUParameters) kEMParameters));
                AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair2 = nTRUKeyPairGenerator.generateKeyPair();
                this.f23588aKp = asymmetricCipherKeyPairGenerateKeyPair2;
                nTRUKEMExtractor = new NTRUKEMExtractor((NTRUPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair2.getPrivate());
            }
            this.f23589encSE = nTRUKEMExtractor;
        }

        public DEROtherInfo generate(byte[] bArr) {
            this.otherInfoBuilder.withSuppPrivInfo(this.f23589encSE.extractSecret(bArr));
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartA() {
            return PQCOtherInfoGenerator.getEncoded(this.f23588aKp.getPublic());
        }

        public PQCOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    /* renamed from: org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator$PartyV */
    public static class C6105PartyV extends PQCOtherInfoGenerator {

        /* renamed from: encSG */
        private EncapsulatedSecretGenerator f23590encSG;

        public C6105PartyV(KEMParameters kEMParameters, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            EncapsulatedSecretGenerator nTRUKEMGenerator;
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            if (kEMParameters instanceof MLKEMParameters) {
                nTRUKEMGenerator = new MLKEMGenerator(secureRandom);
            } else {
                if (!(kEMParameters instanceof NTRUParameters)) {
                    throw new IllegalArgumentException("unknown KEMParameters");
                }
                nTRUKEMGenerator = new NTRUKEMGenerator(secureRandom);
            }
            this.f23590encSG = nTRUKEMGenerator;
        }

        public DEROtherInfo generate() {
            if (this.f23587used) {
                throw new IllegalStateException("builder already used");
            }
            this.f23587used = true;
            return this.otherInfoBuilder.m15924build();
        }

        public byte[] getSuppPrivInfoPartB(byte[] bArr) {
            this.f23587used = false;
            try {
                SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = this.f23590encSG.generateEncapsulated(PQCOtherInfoGenerator.getPublicKey(bArr));
                this.otherInfoBuilder.withSuppPrivInfo(secretWithEncapsulationGenerateEncapsulated.getSecret());
                return secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
            } catch (IOException unused) {
                throw new IllegalArgumentException("cannot decode public key");
            }
        }

        public PQCOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    public PQCOtherInfoGenerator(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.otherInfoBuilder = new DEROtherInfo.C5403Builder(algorithmIdentifier, bArr, bArr2);
        this.f23586random = secureRandom;
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
