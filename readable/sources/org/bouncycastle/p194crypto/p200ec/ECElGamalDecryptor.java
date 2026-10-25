package org.bouncycastle.p194crypto.p200ec;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;

/* loaded from: classes2.dex */
public class ECElGamalDecryptor implements ECDecryptor {

    /* renamed from: key */
    private ECPrivateKeyParameters f19624key;

    @Override // org.bouncycastle.p194crypto.p200ec.ECDecryptor
    /* renamed from: decrypt */
    public AbstractC5820ECPoint mo15215decrypt(C5332ECPair c5332ECPair) {
        ECPrivateKeyParameters eCPrivateKeyParameters = this.f19624key;
        if (eCPrivateKeyParameters == null) {
            throw new IllegalStateException("ECElGamalDecryptor not initialised");
        }
        AbstractC5817ECCurve curve = eCPrivateKeyParameters.getParameters().getCurve();
        return ECAlgorithms.cleanPoint(curve, c5332ECPair.m15223getY()).subtract(ECAlgorithms.cleanPoint(curve, c5332ECPair.m15222getX()).multiply(this.f19624key.m15727getD())).normalize();
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECDecryptor
    /* renamed from: init */
    public void mo15216init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPrivateKeyParameters)) {
            throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
        }
        this.f19624key = (ECPrivateKeyParameters) cipherParameters;
    }
}
