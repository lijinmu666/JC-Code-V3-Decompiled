package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;

/* loaded from: classes2.dex */
public class XDHBasicAgreement implements BasicAgreement {
    private RawAgreement agreement;
    private int fieldSize = 0;

    /* renamed from: key */
    private AsymmetricKeyParameter f19161key;

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        byte[] bArr = new byte[this.fieldSize];
        this.agreement.calculateAgreement(cipherParameters, bArr, 0);
        return new BigInteger(1, bArr);
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    public int getFieldSize() {
        return this.fieldSize;
    }

    @Override // org.bouncycastle.p194crypto.BasicAgreement
    /* renamed from: init */
    public void mo14945init(CipherParameters cipherParameters) {
        RawAgreement x448Agreement;
        if (cipherParameters instanceof X25519PrivateKeyParameters) {
            this.fieldSize = 32;
            x448Agreement = new X25519Agreement();
        } else {
            if (!(cipherParameters instanceof X448PrivateKeyParameters)) {
                throw new IllegalArgumentException("key is neither X25519 nor X448");
            }
            this.fieldSize = 56;
            x448Agreement = new X448Agreement();
        }
        this.agreement = x448Agreement;
        this.f19161key = (AsymmetricKeyParameter) cipherParameters;
        this.agreement.mo14986init(cipherParameters);
    }
}
