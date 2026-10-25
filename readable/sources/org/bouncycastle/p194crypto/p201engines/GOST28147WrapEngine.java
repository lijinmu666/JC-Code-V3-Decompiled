package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.p209macs.GOST28147Mac;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithUKM;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GOST28147WrapEngine implements InterfaceC5283Wrapper {

    /* renamed from: cipher */
    private GOST28147Engine f19876cipher = new GOST28147Engine();

    /* renamed from: mac */
    private GOST28147Mac f19877mac = new GOST28147Mac();

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    public String getAlgorithmName() {
        return "GOST28147Wrap";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: init */
    public void mo14995init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.f19876cipher.mo14946init(z, parametersWithUKM.getParameters());
        this.f19877mac.mo14976init(new ParametersWithIV(parametersWithUKM.getParameters(), parametersWithUKM.m15804getUKM()));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: unwrap */
    public byte[] mo14996unwrap(byte[] bArr, int i, int i2) {
        int macSize = i2 - this.f19877mac.getMacSize();
        byte[] bArr2 = new byte[macSize];
        this.f19876cipher.processBlock(bArr, i, bArr2, 0);
        this.f19876cipher.processBlock(bArr, i + 8, bArr2, 8);
        this.f19876cipher.processBlock(bArr, i + 16, bArr2, 16);
        this.f19876cipher.processBlock(bArr, i + 24, bArr2, 24);
        byte[] bArr3 = new byte[this.f19877mac.getMacSize()];
        this.f19877mac.mo14979update(bArr2, 0, macSize);
        this.f19877mac.mo14975doFinal(bArr3, 0);
        byte[] bArr4 = new byte[this.f19877mac.getMacSize()];
        System.arraycopy(bArr, (i + i2) - 4, bArr4, 0, this.f19877mac.getMacSize());
        if (C6238Arrays.constantTimeAreEqual(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: wrap */
    public byte[] mo14997wrap(byte[] bArr, int i, int i2) {
        this.f19877mac.mo14979update(bArr, i, i2);
        byte[] bArr2 = new byte[this.f19877mac.getMacSize() + i2];
        this.f19876cipher.processBlock(bArr, i, bArr2, 0);
        this.f19876cipher.processBlock(bArr, i + 8, bArr2, 8);
        this.f19876cipher.processBlock(bArr, i + 16, bArr2, 16);
        this.f19876cipher.processBlock(bArr, i + 24, bArr2, 24);
        this.f19877mac.mo14975doFinal(bArr2, i2);
        return bArr2;
    }
}
