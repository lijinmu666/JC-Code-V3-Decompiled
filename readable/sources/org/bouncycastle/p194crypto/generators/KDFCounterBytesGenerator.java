package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.MacDerivationFunction;
import org.bouncycastle.p194crypto.p213params.KDFCounterParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h */
    private final int f20251h;

    /* renamed from: ios */
    private byte[] f20252ios;

    /* renamed from: k */
    private byte[] f20253k;
    private int maxSizeExcl;

    /* renamed from: prf */
    private final InterfaceC5278Mac f20254prf;

    public KDFCounterBytesGenerator(InterfaceC5278Mac interfaceC5278Mac) {
        this.f20254prf = interfaceC5278Mac;
        int macSize = interfaceC5278Mac.getMacSize();
        this.f20251h = macSize;
        this.f20253k = new byte[macSize];
    }

    private void generateNext() {
        int i = (this.generatedBytes / this.f20251h) + 1;
        byte[] bArr = this.f20252ios;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                    bArr[0] = (byte) (i >>> 24);
                }
                bArr[bArr.length - 3] = (byte) (i >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i;
        InterfaceC5278Mac interfaceC5278Mac = this.f20254prf;
        byte[] bArr2 = this.fixedInputDataCtrPrefix;
        interfaceC5278Mac.mo14979update(bArr2, 0, bArr2.length);
        InterfaceC5278Mac interfaceC5278Mac2 = this.f20254prf;
        byte[] bArr3 = this.f20252ios;
        interfaceC5278Mac2.mo14979update(bArr3, 0, bArr3.length);
        InterfaceC5278Mac interfaceC5278Mac3 = this.f20254prf;
        byte[] bArr4 = this.fixedInputData_afterCtr;
        interfaceC5278Mac3.mo14979update(bArr4, 0, bArr4.length);
        this.f20254prf.mo14975doFinal(this.f20253k, 0);
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        if (i4 < 0 || i4 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i3 % this.f20251h == 0) {
            generateNext();
        }
        int i5 = this.generatedBytes;
        int i6 = this.f20251h;
        int i7 = i5 % i6;
        int iMin = Math.min(i6 - (i5 % i6), i2);
        System.arraycopy(this.f20253k, i7, bArr, i, iMin);
        this.generatedBytes += iMin;
        int i8 = i2 - iMin;
        while (true) {
            i += iMin;
            if (i8 <= 0) {
                return i2;
            }
            generateNext();
            iMin = Math.min(this.f20251h, i8);
            System.arraycopy(this.f20253k, 0, bArr, i, iMin);
            this.generatedBytes += iMin;
            i8 -= iMin;
        }
    }

    @Override // org.bouncycastle.p194crypto.MacDerivationFunction
    /* renamed from: getMac */
    public InterfaceC5278Mac mo14980getMac() {
        return this.f20254prf;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFCounterParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
        this.f20254prf.mo14976init(new KeyParameter(kDFCounterParameters.m15764getKI()));
        this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
        this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
        int iM15765getR = kDFCounterParameters.m15765getR();
        this.f20252ios = new byte[iM15765getR / 8];
        this.maxSizeExcl = iM15765getR >= Integers.numberOfLeadingZeros(this.f20251h) ? Integer.MAX_VALUE : this.f20251h << iM15765getR;
        this.generatedBytes = 0;
    }
}
