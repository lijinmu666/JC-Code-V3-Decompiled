package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.MGFParameters;

/* loaded from: classes2.dex */
public class MGF1BytesGenerator implements DerivationFunction {

    /* renamed from: digest */
    private InterfaceC5277Digest f20265digest;

    /* renamed from: hLen */
    private int f20266hLen;

    /* renamed from: seed */
    private byte[] f20267seed;

    public MGF1BytesGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20265digest = interfaceC5277Digest;
        this.f20266hLen = interfaceC5277Digest.getDigestSize();
    }

    /* renamed from: ItoOSP */
    private void m15494ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr.length - i2 < i) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.f20266hLen];
        byte[] bArr3 = new byte[4];
        this.f20265digest.mo14968reset();
        if (i2 > this.f20266hLen) {
            i3 = 0;
            do {
                m15494ItoOSP(i3, bArr3);
                InterfaceC5277Digest interfaceC5277Digest = this.f20265digest;
                byte[] bArr4 = this.f20267seed;
                interfaceC5277Digest.mo14970update(bArr4, 0, bArr4.length);
                this.f20265digest.mo14970update(bArr3, 0, 4);
                this.f20265digest.mo14967doFinal(bArr2, 0);
                int i4 = this.f20266hLen;
                System.arraycopy(bArr2, 0, bArr, (i3 * i4) + i, i4);
                i3++;
            } while (i3 < i2 / this.f20266hLen);
        } else {
            i3 = 0;
        }
        if (this.f20266hLen * i3 < i2) {
            m15494ItoOSP(i3, bArr3);
            InterfaceC5277Digest interfaceC5277Digest2 = this.f20265digest;
            byte[] bArr5 = this.f20267seed;
            interfaceC5277Digest2.mo14970update(bArr5, 0, bArr5.length);
            this.f20265digest.mo14970update(bArr3, 0, 4);
            this.f20265digest.mo14967doFinal(bArr2, 0);
            int i5 = this.f20266hLen;
            System.arraycopy(bArr2, 0, bArr, i + (i3 * i5), i2 - (i3 * i5));
        }
        return i2;
    }

    public InterfaceC5277Digest getDigest() {
        return this.f20265digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof MGFParameters)) {
            throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
        }
        this.f20267seed = ((MGFParameters) derivationParameters).m15775getSeed();
    }
}
