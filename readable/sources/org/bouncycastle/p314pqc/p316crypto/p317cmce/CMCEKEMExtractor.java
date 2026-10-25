package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;

/* loaded from: classes2.dex */
public class CMCEKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private CMCEEngine f23068engine;

    /* renamed from: key */
    private CMCEKeyParameters f23069key;

    public CMCEKEMExtractor(CMCEPrivateKeyParameters cMCEPrivateKeyParameters) {
        this.f23069key = cMCEPrivateKeyParameters;
        initCipher(cMCEPrivateKeyParameters.getParameters());
    }

    private void initCipher(CMCEParameters cMCEParameters) {
        this.f23068engine = cMCEParameters.getEngine();
        CMCEPrivateKeyParameters cMCEPrivateKeyParameters = (CMCEPrivateKeyParameters) this.f23069key;
        if (cMCEPrivateKeyParameters.getPrivateKey().length < this.f23068engine.getPrivateKeySize()) {
            this.f23069key = new CMCEPrivateKeyParameters(cMCEPrivateKeyParameters.getParameters(), this.f23068engine.decompress_private_key(cMCEPrivateKeyParameters.getPrivateKey()));
        }
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        return extractSecret(bArr, this.f23068engine.getDefaultSessionKeySize());
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23068engine.getCipherTextSize();
    }

    public byte[] extractSecret(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i / 8];
        this.f23068engine.m17493kem_dec(bArr2, bArr, ((CMCEPrivateKeyParameters) this.f23069key).getPrivateKey());
        return bArr2;
    }
}
