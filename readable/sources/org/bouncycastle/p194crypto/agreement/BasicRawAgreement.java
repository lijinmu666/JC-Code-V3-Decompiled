package org.bouncycastle.p194crypto.agreement;

import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public final class BasicRawAgreement implements RawAgreement {
    public final BasicAgreement basicAgreement;

    public BasicRawAgreement(BasicAgreement basicAgreement) {
        if (basicAgreement == null) {
            throw new NullPointerException("'basicAgreement' cannot be null");
        }
        this.basicAgreement = basicAgreement;
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        BigIntegers.asUnsignedByteArray(this.basicAgreement.calculateAgreement(cipherParameters), bArr, i, getAgreementSize());
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public int getAgreementSize() {
        return this.basicAgreement.getFieldSize();
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    /* renamed from: init */
    public void mo14986init(CipherParameters cipherParameters) {
        this.basicAgreement.mo14945init(cipherParameters);
    }
}
