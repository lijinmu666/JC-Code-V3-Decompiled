package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;

/* loaded from: classes2.dex */
public class NTRUPlusKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: sr */
    private final SecureRandom f23402sr;

    public NTRUPlusKEMGenerator(SecureRandom secureRandom) {
        this.f23402sr = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        NTRUPlusPublicKeyParameters nTRUPlusPublicKeyParameters = (NTRUPlusPublicKeyParameters) asymmetricKeyParameter;
        NTRUPlusParameters parameters = nTRUPlusPublicKeyParameters.getParameters();
        byte[] bArr = new byte[parameters.getCiphertextBytes()];
        byte[] bArr2 = new byte[32];
        NTRUPlusEngine nTRUPlusEngine = new NTRUPlusEngine(parameters);
        byte[] bArr3 = new byte[parameters.m17774getN() >> 3];
        this.f23402sr.nextBytes(bArr3);
        nTRUPlusEngine.crypto_kem_enc_derand(bArr, 0, bArr2, 0, nTRUPlusPublicKeyParameters.getEncoded(), 0, bArr3, 0);
        return new SecretWithEncapsulationImpl(bArr2, bArr);
    }
}
