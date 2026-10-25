package org.bouncycastle.p314pqc.p352legacy.p353bike;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BIKEKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: sr */
    private final SecureRandom f23939sr;

    public BIKEKEMGenerator(SecureRandom secureRandom) {
        this.f23939sr = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        BIKEPublicKeyParameters bIKEPublicKeyParameters = (BIKEPublicKeyParameters) asymmetricKeyParameter;
        BIKEEngine engine = bIKEPublicKeyParameters.getParameters().getEngine();
        byte[] bArr = new byte[bIKEPublicKeyParameters.getParameters().getLByte()];
        byte[] bArr2 = new byte[bIKEPublicKeyParameters.getParameters().getRByte()];
        byte[] bArr3 = new byte[bIKEPublicKeyParameters.getParameters().getLByte()];
        engine.m18062encaps(bArr2, bArr3, bArr, bIKEPublicKeyParameters.publicKey, this.f23939sr);
        return new SecretWithEncapsulationImpl(C6238Arrays.copyOfRange(bArr, 0, bIKEPublicKeyParameters.getParameters().getSessionKeySize() / 8), C6238Arrays.concatenate(bArr2, bArr3));
    }
}
