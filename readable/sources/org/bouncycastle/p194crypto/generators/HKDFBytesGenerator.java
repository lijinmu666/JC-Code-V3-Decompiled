package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public class HKDFBytesGenerator implements DerivationFunction {
    private byte[] currentT;
    private int generatedBytes;
    private C5360HMac hMacHash;

    /* renamed from: hashLen */
    private int f20249hashLen;

    /* renamed from: info */
    private byte[] f20250info;

    public HKDFBytesGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.hMacHash = new C5360HMac(interfaceC5277Digest);
        this.f20249hashLen = interfaceC5277Digest.getDigestSize();
    }

    private void expandNext() {
        int i = this.generatedBytes;
        int i2 = this.f20249hashLen;
        int i3 = (i / i2) + 1;
        if (i3 >= 256) {
            throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
        }
        if (i != 0) {
            this.hMacHash.mo14979update(this.currentT, 0, i2);
        }
        C5360HMac c5360HMac = this.hMacHash;
        byte[] bArr = this.f20250info;
        c5360HMac.mo14979update(bArr, 0, bArr.length);
        this.hMacHash.mo14978update((byte) i3);
        this.hMacHash.mo14975doFinal(this.currentT, 0);
    }

    public byte[] extractPRK(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            this.hMacHash.mo14976init(new KeyParameter(new byte[this.f20249hashLen]));
        } else {
            this.hMacHash.mo14976init(new KeyParameter(bArr));
        }
        this.hMacHash.mo14979update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.f20249hashLen];
        this.hMacHash.mo14975doFinal(bArr3, 0);
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        int i5 = this.f20249hashLen;
        if (i4 > i5 * 255) {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
        if (i3 % i5 == 0) {
            expandNext();
        }
        int i6 = this.generatedBytes;
        int i7 = this.f20249hashLen;
        int i8 = i6 % i7;
        int iMin = Math.min(i7 - (i6 % i7), i2);
        System.arraycopy(this.currentT, i8, bArr, i, iMin);
        this.generatedBytes += iMin;
        int i9 = i2 - iMin;
        while (true) {
            i += iMin;
            if (i9 <= 0) {
                return i2;
            }
            expandNext();
            iMin = Math.min(this.f20249hashLen, i9);
            System.arraycopy(this.currentT, 0, bArr, i, iMin);
            this.generatedBytes += iMin;
            i9 -= iMin;
        }
    }

    public InterfaceC5277Digest getDigest() {
        return this.hMacHash.getUnderlyingDigest();
    }

    @Override // org.bouncycastle.p194crypto.DerivationFunction
    /* renamed from: init */
    public void mo14966init(DerivationParameters derivationParameters) {
        C5360HMac c5360HMac;
        KeyParameter keyParameter;
        if (!(derivationParameters instanceof HKDFParameters)) {
            throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
        }
        HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
        if (hKDFParameters.skipExtract()) {
            c5360HMac = this.hMacHash;
            keyParameter = new KeyParameter(hKDFParameters.m15760getIKM());
        } else {
            c5360HMac = this.hMacHash;
            keyParameter = new KeyParameter(extractPRK(hKDFParameters.m15762getSalt(), hKDFParameters.m15760getIKM()));
        }
        c5360HMac.mo14976init(keyParameter);
        this.f20250info = hKDFParameters.m15761getInfo();
        this.generatedBytes = 0;
        this.currentT = new byte[this.f20249hashLen];
    }
}
