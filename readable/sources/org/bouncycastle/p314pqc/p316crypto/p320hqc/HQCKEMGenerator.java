package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HQCKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f23195random;

    public HQCKEMGenerator(SecureRandom secureRandom) {
        this.f23195random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        HQCPublicKeyParameters hQCPublicKeyParameters = (HQCPublicKeyParameters) asymmetricKeyParameter;
        HQCEngine engine = hQCPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[hQCPublicKeyParameters.getParameters().getSHA512_BYTES()];
        byte[] bArr2 = new byte[hQCPublicKeyParameters.getParameters().getN_BYTES()];
        byte[] bArr3 = new byte[hQCPublicKeyParameters.getParameters().getN1N2_BYTES()];
        byte[] bArr4 = new byte[hQCPublicKeyParameters.getParameters().getSALT_SIZE_BYTES()];
        engine.m17591encaps(bArr2, bArr3, bArr, hQCPublicKeyParameters.getPublicKey(), bArr4, this.f23195random);
        return new SecretWithEncapsulationImpl(C6238Arrays.copyOfRange(bArr, 0, 32), C6238Arrays.concatenate(bArr2, bArr3, bArr4));
    }
}
