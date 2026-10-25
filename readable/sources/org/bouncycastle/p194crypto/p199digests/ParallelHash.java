package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class ParallelHash implements InterfaceC5284Xof, InterfaceC5277Digest {
    private static final byte[] N_PARALLEL_HASH = C6250Strings.toByteArray("ParallelHash");

    /* renamed from: B */
    private final int f19474B;
    private final int bitLength;

    /* renamed from: bufOff */
    private int f19475bufOff;

    /* renamed from: buffer */
    private final byte[] f19476buffer;
    private final CSHAKEDigest compressor;
    private final byte[] compressorBuffer;

    /* renamed from: cshake */
    private final CSHAKEDigest f19477cshake;
    private boolean firstOutput;

    /* renamed from: nCount */
    private int f19478nCount;
    private final int outputLength;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19479purpose;

    public ParallelHash(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, i * 2, CryptoServicePurpose.ANY);
    }

    private void compress() {
        compress(this.f19476buffer, 0, this.f19475bufOff);
        this.f19475bufOff = 0;
    }

    /* renamed from: wrapUp */
    private void m15111wrapUp(int i) {
        if (this.f19475bufOff != 0) {
            compress();
        }
        byte[] bArrRightEncode = XofUtils.rightEncode(this.f19478nCount);
        byte[] bArrRightEncode2 = XofUtils.rightEncode(i * 8);
        this.f19477cshake.mo14970update(bArrRightEncode, 0, bArrRightEncode.length);
        this.f19477cshake.mo14970update(bArrRightEncode2, 0, bArrRightEncode2.length);
        this.firstOutput = false;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        if (this.firstOutput) {
            m15111wrapUp(this.outputLength);
        }
        int iMo14998doFinal = this.f19477cshake.mo14998doFinal(bArr, i, getDigestSize());
        mo14968reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            m15111wrapUp(0);
        }
        return this.f19477cshake.doOutput(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "ParallelHash" + this.f19477cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.f19477cshake.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19477cshake.mo14968reset();
        C6238Arrays.m18227clear(this.f19476buffer);
        byte[] bArrLeftEncode = XofUtils.leftEncode(this.f19474B);
        this.f19477cshake.mo14970update(bArrLeftEncode, 0, bArrLeftEncode.length);
        this.f19478nCount = 0;
        this.f19475bufOff = 0;
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.f19476buffer;
        int i = this.f19475bufOff;
        int i2 = i + 1;
        this.f19475bufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            compress();
        }
    }

    public ParallelHash(int i, byte[] bArr, int i2, int i3) {
        this(i, bArr, i2, i3, CryptoServicePurpose.ANY);
    }

    private void compress(byte[] bArr, int i, int i2) {
        this.compressor.mo14970update(bArr, i, i2);
        CSHAKEDigest cSHAKEDigest = this.compressor;
        byte[] bArr2 = this.compressorBuffer;
        cSHAKEDigest.mo14998doFinal(bArr2, 0, bArr2.length);
        CSHAKEDigest cSHAKEDigest2 = this.f19477cshake;
        byte[] bArr3 = this.compressorBuffer;
        cSHAKEDigest2.mo14970update(bArr3, 0, bArr3.length);
        this.f19478nCount++;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            m15111wrapUp(this.outputLength);
        }
        int iMo14998doFinal = this.f19477cshake.mo14998doFinal(bArr, i, i2);
        mo14968reset();
        return iMo14998doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i2);
        if (this.f19475bufOff != 0) {
            while (i3 < iMax) {
                int i4 = this.f19475bufOff;
                byte[] bArr2 = this.f19476buffer;
                if (i4 == bArr2.length) {
                    break;
                }
                this.f19475bufOff = i4 + 1;
                bArr2[i4] = bArr[i3 + i];
                i3++;
            }
            if (this.f19475bufOff == this.f19476buffer.length) {
                compress();
            }
        }
        if (i3 < iMax) {
            while (true) {
                int i5 = iMax - i3;
                int i6 = this.f19474B;
                if (i5 < i6) {
                    break;
                }
                compress(bArr, i + i3, i6);
                i3 += this.f19474B;
            }
        }
        while (i3 < iMax) {
            mo14969update(bArr[i3 + i]);
            i3++;
        }
    }

    public ParallelHash(int i, byte[] bArr, int i2, int i3, CryptoServicePurpose cryptoServicePurpose) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("block size should be greater than 0");
        }
        this.f19477cshake = new CSHAKEDigest(i, N_PARALLEL_HASH, bArr);
        this.compressor = new CSHAKEDigest(i, new byte[0], new byte[0]);
        this.bitLength = i;
        this.f19474B = i2;
        this.outputLength = (i3 + 7) / 8;
        this.f19476buffer = new byte[i2];
        this.compressorBuffer = new byte[(i * 2) / 8];
        this.f19479purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, i, cryptoServicePurpose));
        mo14968reset();
    }

    public ParallelHash(ParallelHash parallelHash) {
        this.f19477cshake = new CSHAKEDigest(parallelHash.f19477cshake);
        this.compressor = new CSHAKEDigest(parallelHash.compressor);
        int i = parallelHash.bitLength;
        this.bitLength = i;
        this.f19474B = parallelHash.f19474B;
        this.outputLength = parallelHash.outputLength;
        this.f19476buffer = C6238Arrays.m18231clone(parallelHash.f19476buffer);
        this.compressorBuffer = C6238Arrays.m18231clone(parallelHash.compressorBuffer);
        CryptoServicePurpose cryptoServicePurpose = parallelHash.f19479purpose;
        this.f19479purpose = cryptoServicePurpose;
        this.firstOutput = parallelHash.firstOutput;
        this.f19478nCount = parallelHash.f19478nCount;
        this.f19475bufOff = parallelHash.f19475bufOff;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, i, cryptoServicePurpose));
    }
}
