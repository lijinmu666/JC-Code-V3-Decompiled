package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;

/* loaded from: classes2.dex */
public class CMCEKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: sr */
    private final SecureRandom f23070sr;

    public CMCEKEMGenerator(SecureRandom secureRandom) {
        this.f23070sr = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        return generateEncapsulated(asymmetricKeyParameter, ((CMCEPublicKeyParameters) asymmetricKeyParameter).getParameters().getEngine().getDefaultSessionKeySize());
    }

    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter, int i) {
        CMCEPublicKeyParameters cMCEPublicKeyParameters = (CMCEPublicKeyParameters) asymmetricKeyParameter;
        CMCEEngine engine = cMCEPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[engine.getCipherTextSize()];
        byte[] bArr2 = new byte[i / 8];
        engine.m17494kem_enc(bArr, bArr2, cMCEPublicKeyParameters.getPublicKey(), this.f23070sr);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
