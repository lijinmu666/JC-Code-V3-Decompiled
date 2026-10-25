package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;

/* loaded from: classes2.dex */
public class FrodoKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: sr */
    private final SecureRandom f23162sr;

    public FrodoKEMGenerator(SecureRandom secureRandom) {
        this.f23162sr = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        FrodoPublicKeyParameters frodoPublicKeyParameters = (FrodoPublicKeyParameters) asymmetricKeyParameter;
        FrodoEngine engine = frodoPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[engine.getCipherTextSize()];
        byte[] bArr2 = new byte[engine.getSessionKeySize()];
        engine.m17565kem_enc(bArr, bArr2, frodoPublicKeyParameters.getPublicKey(), this.f23162sr);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
