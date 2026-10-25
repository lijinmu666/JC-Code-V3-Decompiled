package org.bouncycastle.p314pqc.p316crypto.p333xwing;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.agreement.X25519Agreement;
import org.bouncycastle.p194crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p207kems.MLKEMGenerator;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class XWingKEMGenerator implements EncapsulatedSecretGenerator {
    private static final byte[] XWING_LABEL = C6250Strings.toByteArray("\\.//^\\");

    /* renamed from: random */
    private final SecureRandom f23676random;

    public XWingKEMGenerator(SecureRandom secureRandom) {
        this.f23676random = secureRandom;
    }

    public static byte[] computeSSX(X25519PublicKeyParameters x25519PublicKeyParameters, X25519PrivateKeyParameters x25519PrivateKeyParameters) {
        X25519Agreement x25519Agreement = new X25519Agreement();
        x25519Agreement.mo14986init(x25519PrivateKeyParameters);
        byte[] bArr = new byte[x25519Agreement.getAgreementSize()];
        x25519Agreement.calculateAgreement(x25519PublicKeyParameters, bArr, 0);
        return bArr;
    }

    public static byte[] computeSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.mo14970update(bArr2, 0, bArr2.length);
        sHA3Digest.mo14970update(bArr4, 0, bArr4.length);
        sHA3Digest.mo14970update(bArr3, 0, bArr3.length);
        sHA3Digest.mo14970update(bArr, 0, bArr.length);
        byte[] bArr5 = XWING_LABEL;
        sHA3Digest.mo14970update(bArr5, 0, bArr5.length);
        byte[] bArr6 = new byte[32];
        sHA3Digest.mo14967doFinal(bArr6, 0);
        return bArr6;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        XWingPublicKeyParameters xWingPublicKeyParameters = (XWingPublicKeyParameters) asymmetricKeyParameter;
        MLKEMPublicKeyParameters kyberPublicKey = xWingPublicKeyParameters.getKyberPublicKey();
        X25519PublicKeyParameters xDHPublicKey = xWingPublicKeyParameters.getXDHPublicKey();
        byte[] encoded = xDHPublicKey.getEncoded();
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new MLKEMGenerator(this.f23676random).generateEncapsulated(kyberPublicKey);
        byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
        X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
        x25519KeyPairGenerator.mo14944init(new X25519KeyGenerationParameters(this.f23676random));
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = x25519KeyPairGenerator.generateKeyPair();
        byte[] encoded2 = ((X25519PublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()).getEncoded();
        byte[] bArrComputeSSX = computeSSX(xDHPublicKey, (X25519PrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        byte[] bArrComputeSharedSecret = computeSharedSecret(encoded, secretWithEncapsulationGenerateEncapsulated.getSecret(), encoded2, bArrComputeSSX);
        C6238Arrays.m18227clear(bArrComputeSSX);
        return new SecretWithEncapsulationImpl(bArrComputeSharedSecret, C6238Arrays.concatenate(encapsulation, encoded2));
    }
}
