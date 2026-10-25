package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.MacDerivationFunction;
import org.bouncycastle.p194crypto.p213params.KDFFeedbackParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h */
    private final int f20260h;

    /* renamed from: ios */
    private byte[] f20261ios;

    /* renamed from: iv */
    private byte[] f20262iv;

    /* renamed from: k */
    private byte[] f20263k;
    private int maxSizeExcl;

    /* renamed from: prf */
    private final InterfaceC5278Mac f20264prf;
    private boolean useCounter;

    public KDFFeedbackBytesGenerator(InterfaceC5278Mac interfaceC5278Mac) {
        this.f20264prf = interfaceC5278Mac;
        int macSize = interfaceC5278Mac.getMacSize();
        this.f20260h = macSize;
        this.f20263k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            InterfaceC5278Mac interfaceC5278Mac = this.f20264prf;
            byte[] bArr = this.f20262iv;
            interfaceC5278Mac.mo14979update(bArr, 0, bArr.length);
        } else {
            InterfaceC5278Mac interfaceC5278Mac2 = this.f20264prf;
            byte[] bArr2 = this.f20263k;
            interfaceC5278Mac2.mo14979update(bArr2, 0, bArr2.length);
        }
        if (this.useCounter) {
            int i = (this.generatedBytes / this.f20260h) + 1;
            byte[] bArr3 = this.f20261ios;
            int length = bArr3.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr3[0] = (byte) (i >>> 24);
                    }
                    bArr3[bArr3.length - 3] = (byte) (i >>> 16);
                }
                bArr3[bArr3.length - 2] = (byte) (i >>> 8);
            }
            bArr3[bArr3.length - 1] = (byte) i;
            this.f20264prf.mo14979update(bArr3, 0, bArr3.length);
        }
        InterfaceC5278Mac interfaceC5278Mac3 = this.f20264prf;
        byte[] bArr4 = this.fixedInputData;
        interfaceC5278Mac3.mo14979update(bArr4, 0, bArr4.length);
        this.f20264prf.mo14975doFinal(this.f20263k, 0);
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        if (i4 < 0 || i4 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i3 % this.f20260h == 0) {
            generateNext();
        }
        int i5 = this.generatedBytes;
        int i6 = this.f20260h;
        int i7 = i5 % i6;
        int iMin = Math.min(i6 - (i5 % i6), i2);
        System.arraycopy(this.f20263k, i7, bArr, i, iMin);
        this.generatedBytes += iMin;
        int i8 = i2 - iMin;
        while (true) {
            i += iMin;
            if (i8 <= 0) {
                return i2;
            }
            generateNext();
            iMin = Math.min(this.f20260h, i8);
            System.arraycopy(this.f20263k, 0, bArr, i, iMin);
            this.generatedBytes += iMin;
            i8 -= iMin;
        }
    }

    @Override // org.bouncycastle.p194crypto.MacDerivationFunction
    /* renamed from: getMac */
    public InterfaceC5278Mac mo14980getMac() {
        return this.f20264prf;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFFeedbackParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
        this.f20264prf.mo14976init(new KeyParameter(kDFFeedbackParameters.m15769getKI()));
        this.fixedInputData = kDFFeedbackParameters.getFixedInputData();
        int iM15770getR = kDFFeedbackParameters.m15770getR();
        this.f20261ios = new byte[iM15770getR / 8];
        int i = Integer.MAX_VALUE;
        if (kDFFeedbackParameters.useCounter() && iM15770getR < Integers.numberOfLeadingZeros(this.f20260h)) {
            i = this.f20260h << iM15770getR;
        }
        this.maxSizeExcl = i;
        this.f20262iv = kDFFeedbackParameters.m15768getIV();
        this.useCounter = kDFFeedbackParameters.useCounter();
        this.generatedBytes = 0;
    }
}
