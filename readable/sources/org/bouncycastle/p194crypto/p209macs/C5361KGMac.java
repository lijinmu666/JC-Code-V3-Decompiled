package org.bouncycastle.p194crypto.p209macs;

import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p210modes.KGCMBlockCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* renamed from: org.bouncycastle.crypto.macs.KGMac */
/* loaded from: classes2.dex */
public class C5361KGMac implements InterfaceC5278Mac {

    /* renamed from: cipher */
    private final KGCMBlockCipher f20460cipher;
    private final int macSizeBits;

    public C5361KGMac(KGCMBlockCipher kGCMBlockCipher) {
        this.f20460cipher = kGCMBlockCipher;
        this.macSizeBits = kGCMBlockCipher.getUnderlyingCipher().getBlockSize() * 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        try {
            return this.f20460cipher.mo15224doFinal(bArr, i);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20460cipher.getUnderlyingCipher().getAlgorithmName() + "-KGMAC";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.macSizeBits / 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) throws IOException {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("KGMAC requires ParametersWithIV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        this.f20460cipher.mo15226init(true, new AEADParameters((KeyParameter) parametersWithIV.getParameters(), this.macSizeBits, bArrM15801getIV));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() throws IOException {
        this.f20460cipher.mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) throws IOException {
        this.f20460cipher.processAADByte(b);
    }

    public C5361KGMac(KGCMBlockCipher kGCMBlockCipher, int i) {
        this.f20460cipher = kGCMBlockCipher;
        this.macSizeBits = i;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) throws IOException {
        this.f20460cipher.processAADBytes(bArr, i, i2);
    }
}
