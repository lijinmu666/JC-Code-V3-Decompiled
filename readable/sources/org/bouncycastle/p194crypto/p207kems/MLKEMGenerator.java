package org.bouncycastle.p194crypto.p207kems;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p207kems.p208mlkem.MLKEMEngine;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;

/* loaded from: classes2.dex */
public class MLKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f20376random;

    public MLKEMGenerator(SecureRandom secureRandom) {
        this.f20376random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        byte[] bArr = new byte[32];
        this.f20376random.nextBytes(bArr);
        return internalGenerateEncapsulated((MLKEMPublicKeyParameters) asymmetricKeyParameter, bArr);
    }

    public SecretWithEncapsulation internalGenerateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        return internalGenerateEncapsulated((MLKEMPublicKeyParameters) asymmetricKeyParameter, bArr);
    }

    public static SecretWithEncapsulation internalGenerateEncapsulated(MLKEMPublicKeyParameters mLKEMPublicKeyParameters, byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("'randBytes' has invalid length");
        }
        byte[][] bArrKemEncrypt = MLKEMEngine.getInstance(mLKEMPublicKeyParameters.getParameters()).kemEncrypt(mLKEMPublicKeyParameters, bArr);
        return new SecretWithEncapsulationImpl(bArrKemEncrypt[0], bArrKemEncrypt[1]);
    }
}
