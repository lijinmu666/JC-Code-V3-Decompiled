package org.bouncycastle.p194crypto.p207kems;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.KeyEncapsulation;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class RSAKeyEncapsulation implements KeyEncapsulation {

    /* renamed from: kdf */
    private DerivationFunction f20385kdf;

    /* renamed from: key */
    private RSAKeyParameters f20386key;

    /* renamed from: rnd */
    private SecureRandom f20387rnd;

    public RSAKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.f20385kdf = derivationFunction;
        this.f20387rnd = secureRandom;
    }

    /* renamed from: decrypt */
    public CipherParameters m15558decrypt(byte[] bArr, int i) {
        return mo14971decrypt(bArr, 0, bArr.length, i);
    }

    /* renamed from: encrypt */
    public CipherParameters m15559encrypt(byte[] bArr, int i) {
        return mo14972encrypt(bArr, 0, i);
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: init */
    public void mo14973init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof RSAKeyParameters)) {
            throw new IllegalArgumentException("RSA key required");
        }
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f20386key = rSAKeyParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSAKem", ConstraintUtils.bitsOfSecurityFor(rSAKeyParameters.getModulus()), cipherParameters, this.f20386key.isPrivate() ? CryptoServicePurpose.DECRYPTION : CryptoServicePurpose.ENCRYPTION));
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: decrypt */
    public CipherParameters mo14971decrypt(byte[] bArr, int i, int i2, int i3) {
        if (this.f20386key.isPrivate()) {
            return new KeyParameter(new RSAKEMExtractor(this.f20386key, i3, this.f20385kdf).extractSecret(C6238Arrays.copyOfRange(bArr, i, i2 + i)));
        }
        throw new IllegalArgumentException("Private key required for decryption");
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: encrypt */
    public CipherParameters mo14972encrypt(byte[] bArr, int i, int i2) {
        if (this.f20386key.isPrivate()) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new RSAKEMGenerator(i2, this.f20385kdf, this.f20387rnd).generateEncapsulated(this.f20386key);
        byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
        System.arraycopy(encapsulation, 0, bArr, i, encapsulation.length);
        return new KeyParameter(secretWithEncapsulationGenerateEncapsulated.getSecret());
    }
}
