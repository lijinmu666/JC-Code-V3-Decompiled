package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.DigestDerivationFunction;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.ISO18033KDFParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;

    /* renamed from: digest */
    private InterfaceC5277Digest f20205digest;

    /* renamed from: iv */
    private byte[] f20206iv;

    /* renamed from: shared */
    private byte[] f20207shared;

    public BaseKDFBytesGenerator(int i, InterfaceC5277Digest interfaceC5277Digest) {
        this.counterStart = i;
        this.f20205digest = interfaceC5277Digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 < i) {
            throw new OutputLengthException("output buffer too small");
        }
        this.f20205digest.mo14968reset();
        int digestSize = this.f20205digest.getDigestSize();
        if (i2 > digestSize * BodyPartID.bodyIdMax) {
            throw new IllegalArgumentException("Output length too large");
        }
        int i3 = this.counterStart;
        byte[] bArr2 = new byte[4];
        int i4 = i2;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            AbstractC6245Pack.intToBigEndian(i3, bArr2);
            InterfaceC5277Digest interfaceC5277Digest = this.f20205digest;
            byte[] bArr3 = this.f20207shared;
            interfaceC5277Digest.mo14970update(bArr3, 0, bArr3.length);
            this.f20205digest.mo14970update(bArr2, 0, 4);
            byte[] bArr4 = this.f20206iv;
            if (bArr4 != null) {
                this.f20205digest.mo14970update(bArr4, 0, bArr4.length);
            }
            if (i4 < digestSize) {
                byte[] bArr5 = new byte[digestSize];
                this.f20205digest.mo14967doFinal(bArr5, 0);
                System.arraycopy(bArr5, 0, bArr, i, i4);
                break;
            }
            this.f20205digest.mo14967doFinal(bArr, i);
            i += digestSize;
            i4 -= digestSize;
            i3++;
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.DigestDerivationFunction
    public InterfaceC5277Digest getDigest() {
        return this.f20205digest;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f20207shared = kDFParameters.getSharedSecret();
            this.f20206iv = kDFParameters.m15771getIV();
        } else {
            if (!(derivationParameters instanceof ISO18033KDFParameters)) {
                throw new IllegalArgumentException("KDF parameters required for generator");
            }
            this.f20207shared = ((ISO18033KDFParameters) derivationParameters).m15763getSeed();
            this.f20206iv = null;
        }
    }
}
