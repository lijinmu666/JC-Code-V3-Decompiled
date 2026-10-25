package org.bouncycastle.p194crypto.agreement.p197kdf;

import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.KDFParameters;

/* loaded from: classes2.dex */
public class ConcatenationKDFGenerator implements DerivationFunction {

    /* renamed from: digest */
    private InterfaceC5277Digest f19209digest;

    /* renamed from: hLen */
    private int f19210hLen;
    private byte[] otherInfo;

    /* renamed from: shared */
    private byte[] f19211shared;

    public ConcatenationKDFGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19209digest = interfaceC5277Digest;
        this.f19210hLen = interfaceC5277Digest.getDigestSize();
    }

    /* renamed from: ItoOSP */
    private void m15027ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if (i2 <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (bArr.length - i2 < i) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.f19210hLen];
        byte[] bArr3 = new byte[4];
        this.f19209digest.mo14968reset();
        int i5 = 1;
        if (i2 > this.f19210hLen) {
            i3 = 0;
            while (true) {
                m15027ItoOSP(i5, bArr3);
                this.f19209digest.mo14970update(bArr3, 0, 4);
                InterfaceC5277Digest interfaceC5277Digest = this.f19209digest;
                byte[] bArr4 = this.f19211shared;
                interfaceC5277Digest.mo14970update(bArr4, 0, bArr4.length);
                InterfaceC5277Digest interfaceC5277Digest2 = this.f19209digest;
                byte[] bArr5 = this.otherInfo;
                interfaceC5277Digest2.mo14970update(bArr5, 0, bArr5.length);
                this.f19209digest.mo14967doFinal(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i + i3, this.f19210hLen);
                int i6 = this.f19210hLen;
                i3 += i6;
                i4 = i5 + 1;
                if (i5 >= i2 / i6) {
                    break;
                }
                i5 = i4;
            }
            i5 = i4;
        } else {
            i3 = 0;
        }
        if (i3 < i2) {
            m15027ItoOSP(i5, bArr3);
            this.f19209digest.mo14970update(bArr3, 0, 4);
            InterfaceC5277Digest interfaceC5277Digest3 = this.f19209digest;
            byte[] bArr6 = this.f19211shared;
            interfaceC5277Digest3.mo14970update(bArr6, 0, bArr6.length);
            InterfaceC5277Digest interfaceC5277Digest4 = this.f19209digest;
            byte[] bArr7 = this.otherInfo;
            interfaceC5277Digest4.mo14970update(bArr7, 0, bArr7.length);
            this.f19209digest.mo14967doFinal(bArr2, 0);
            System.arraycopy(bArr2, 0, bArr, i + i3, i2 - i3);
        }
        return i2;
    }

    public InterfaceC5277Digest getDigest() {
        return this.f19209digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFParameters)) {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
        KDFParameters kDFParameters = (KDFParameters) derivationParameters;
        this.f19211shared = kDFParameters.getSharedSecret();
        this.otherInfo = kDFParameters.m15771getIV();
    }
}
