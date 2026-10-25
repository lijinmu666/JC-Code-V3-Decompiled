package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;

/* loaded from: classes2.dex */
public class NTRUPlusKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private final NTRUPlusEngine f23401engine;
    private final NTRUPlusPrivateKeyParameters privateKey;

    public NTRUPlusKEMExtractor(NTRUPlusPrivateKeyParameters nTRUPlusPrivateKeyParameters) {
        if (nTRUPlusPrivateKeyParameters == null) {
            throw new NullPointerException("'privateKey' cannot be null");
        }
        this.privateKey = nTRUPlusPrivateKeyParameters;
        this.f23401engine = new NTRUPlusEngine(nTRUPlusPrivateKeyParameters.getParameters());
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        this.f23401engine.crypto_kem_dec(bArr2, 0, bArr, 0, this.privateKey.getEncoded(), 0);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.privateKey.getParameters().getCiphertextBytes();
    }
}
