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
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECIESKeyEncapsulation implements KeyEncapsulation {
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;

    /* renamed from: kdf */
    private DerivationFunction f20372kdf;

    /* renamed from: key */
    private ECKeyParameters f20373key;

    /* renamed from: rnd */
    private SecureRandom f20374rnd;

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.f20372kdf = derivationFunction;
        this.f20374rnd = secureRandom;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    /* renamed from: decrypt */
    public CipherParameters m15556decrypt(byte[] bArr, int i) {
        return mo14971decrypt(bArr, 0, bArr.length, i);
    }

    /* renamed from: encrypt */
    public CipherParameters m15557encrypt(byte[] bArr, int i) {
        return mo14972encrypt(bArr, 0, i);
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: init */
    public void mo14973init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECKeyParameters)) {
            throw new IllegalArgumentException("EC key required");
        }
        ECKeyParameters eCKeyParameters = (ECKeyParameters) cipherParameters;
        this.f20373key = eCKeyParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECIESKem", ConstraintUtils.bitsOfSecurityFor(eCKeyParameters.getParameters().getCurve()), cipherParameters, CryptoServicePurpose.ANY));
    }

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom, boolean z, boolean z2, boolean z3) {
        this.f20372kdf = derivationFunction;
        this.f20374rnd = secureRandom;
        this.CofactorMode = z;
        if (z) {
            this.OldCofactorMode = false;
        } else {
            this.OldCofactorMode = z2;
        }
        this.SingleHashMode = z3;
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: decrypt */
    public CipherParameters mo14971decrypt(byte[] bArr, int i, int i2, int i3) {
        ECKeyParameters eCKeyParameters = this.f20373key;
        if (eCKeyParameters instanceof ECPrivateKeyParameters) {
            return new KeyParameter(new ECIESKEMExtractor((ECPrivateKeyParameters) eCKeyParameters, i3, this.f20372kdf, this.CofactorMode, this.OldCofactorMode, this.SingleHashMode).extractSecret(C6238Arrays.copyOfRange(bArr, i, i2 + i)));
        }
        throw new IllegalArgumentException("Private key required for encryption");
    }

    @Override // org.bouncycastle.p194crypto.KeyEncapsulation
    /* renamed from: encrypt */
    public CipherParameters mo14972encrypt(byte[] bArr, int i, int i2) {
        if (!(this.f20373key instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new ECIESKEMGenerator(i2, this.f20372kdf, this.f20374rnd, this.CofactorMode, this.OldCofactorMode, this.SingleHashMode).generateEncapsulated(this.f20373key);
        byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
        System.arraycopy(encapsulation, 0, bArr, i, encapsulation.length);
        return new KeyParameter(secretWithEncapsulationGenerateEncapsulated.getSecret());
    }
}
