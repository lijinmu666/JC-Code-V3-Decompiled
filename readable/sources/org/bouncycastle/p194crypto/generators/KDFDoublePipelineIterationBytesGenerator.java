package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.MacDerivationFunction;
import org.bouncycastle.p194crypto.p213params.KDFDoublePipelineIterationParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {

    /* renamed from: a */
    private byte[] f20255a;
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h */
    private final int f20256h;

    /* renamed from: ios */
    private byte[] f20257ios;

    /* renamed from: k */
    private byte[] f20258k;
    private int maxSizeExcl;

    /* renamed from: prf */
    private final InterfaceC5278Mac f20259prf;
    private boolean useCounter;

    public KDFDoublePipelineIterationBytesGenerator(InterfaceC5278Mac interfaceC5278Mac) {
        this.f20259prf = interfaceC5278Mac;
        int macSize = interfaceC5278Mac.getMacSize();
        this.f20256h = macSize;
        this.f20255a = new byte[macSize];
        this.f20258k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            InterfaceC5278Mac interfaceC5278Mac = this.f20259prf;
            byte[] bArr = this.fixedInputData;
            interfaceC5278Mac.mo14979update(bArr, 0, bArr.length);
            this.f20259prf.mo14975doFinal(this.f20255a, 0);
        } else {
            InterfaceC5278Mac interfaceC5278Mac2 = this.f20259prf;
            byte[] bArr2 = this.f20255a;
            interfaceC5278Mac2.mo14979update(bArr2, 0, bArr2.length);
            this.f20259prf.mo14975doFinal(this.f20255a, 0);
        }
        InterfaceC5278Mac interfaceC5278Mac3 = this.f20259prf;
        byte[] bArr3 = this.f20255a;
        interfaceC5278Mac3.mo14979update(bArr3, 0, bArr3.length);
        if (this.useCounter) {
            int i = (this.generatedBytes / this.f20256h) + 1;
            byte[] bArr4 = this.f20257ios;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr4[0] = (byte) (i >>> 24);
                    }
                    bArr4[bArr4.length - 3] = (byte) (i >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i;
            this.f20259prf.mo14979update(bArr4, 0, bArr4.length);
        }
        InterfaceC5278Mac interfaceC5278Mac4 = this.f20259prf;
        byte[] bArr5 = this.fixedInputData;
        interfaceC5278Mac4.mo14979update(bArr5, 0, bArr5.length);
        this.f20259prf.mo14975doFinal(this.f20258k, 0);
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        if (i4 < 0 || i4 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i3 % this.f20256h == 0) {
            generateNext();
        }
        int i5 = this.generatedBytes;
        int i6 = this.f20256h;
        int i7 = i5 % i6;
        int iMin = Math.min(i6 - (i5 % i6), i2);
        System.arraycopy(this.f20258k, i7, bArr, i, iMin);
        this.generatedBytes += iMin;
        int i8 = i2 - iMin;
        while (true) {
            i += iMin;
            if (i8 <= 0) {
                return i2;
            }
            generateNext();
            iMin = Math.min(this.f20256h, i8);
            System.arraycopy(this.f20258k, 0, bArr, i, iMin);
            this.generatedBytes += iMin;
            i8 -= iMin;
        }
    }

    @Override // org.bouncycastle.p194crypto.MacDerivationFunction
    /* renamed from: getMac */
    public InterfaceC5278Mac mo14980getMac() {
        return this.f20259prf;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFDoublePipelineIterationParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
        this.f20259prf.mo14976init(new KeyParameter(kDFDoublePipelineIterationParameters.m15766getKI()));
        this.fixedInputData = kDFDoublePipelineIterationParameters.getFixedInputData();
        int iM15767getR = kDFDoublePipelineIterationParameters.m15767getR();
        this.f20257ios = new byte[iM15767getR / 8];
        int i = Integer.MAX_VALUE;
        if (kDFDoublePipelineIterationParameters.useCounter() && iM15767getR < Integers.numberOfLeadingZeros(this.f20256h)) {
            i = this.f20256h << iM15767getR;
        }
        this.maxSizeExcl = i;
        this.useCounter = kDFDoublePipelineIterationParameters.useCounter();
        this.generatedBytes = 0;
    }
}
