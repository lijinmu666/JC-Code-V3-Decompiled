package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p210modes.GCMModeCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* renamed from: org.bouncycastle.crypto.macs.GMac */
/* loaded from: classes2.dex */
public class C5359GMac implements InterfaceC5278Mac {

    /* renamed from: cipher */
    private final GCMModeCipher f20444cipher;
    private final int macSizeBits;

    public C5359GMac(GCMModeCipher gCMModeCipher) {
        this.f20444cipher = gCMModeCipher;
        this.macSizeBits = 128;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        try {
            return this.f20444cipher.mo15224doFinal(bArr, i);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20444cipher.getUnderlyingCipher().getAlgorithmName() + "-GMAC";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.macSizeBits / 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("GMAC requires ParametersWithIV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        this.f20444cipher.mo15226init(true, new AEADParameters((KeyParameter) parametersWithIV.getParameters(), this.macSizeBits, bArrM15801getIV));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.f20444cipher.mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20444cipher.processAADByte(b);
    }

    public C5359GMac(GCMModeCipher gCMModeCipher, int i) {
        this.f20444cipher = gCMModeCipher;
        this.macSizeBits = i;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        this.f20444cipher.processAADBytes(bArr, i, i2);
    }
}
