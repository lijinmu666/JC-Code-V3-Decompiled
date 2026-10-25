package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p201engines.PhotonBeetleEngine;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;

/* loaded from: classes2.dex */
public class PhotonBeetleDigest extends BufferBaseDigest {

    /* renamed from: D */
    private static final int f19480D = 8;
    private static final int SQUEEZE_RATE_INBYTES = 16;
    private int blockCount;

    /* renamed from: state */
    private final byte[] f19481state;

    /* renamed from: org.bouncycastle.crypto.digests.PhotonBeetleDigest$Friend */
    public static class C5293Friend {
        private static final C5293Friend INSTANCE = new C5293Friend();

        private C5293Friend() {
        }
    }

    public PhotonBeetleDigest() {
        super(BufferBaseDigest.ProcessingBufferType.Buffered, 4);
        this.DigestSize = 32;
        this.f19481state = new byte[32];
        this.algorithmName = "Photon-Beetle Hash";
        this.blockCount = 0;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    /* renamed from: finish */
    public void mo15038finish(byte[] bArr, int i) {
        int i2 = this.m_bufPos;
        if (i2 == 0 && this.blockCount == 0) {
            byte[] bArr2 = this.f19481state;
            int i3 = this.DigestSize - 1;
            bArr2[i3] = (byte) (bArr2[i3] ^ 32);
        } else {
            int i4 = this.blockCount;
            if (i4 < 4) {
                System.arraycopy(this.f19336m_buf, 0, this.f19481state, i4 << 2, i2);
                byte[] bArr3 = this.f19481state;
                int i5 = (this.blockCount << 2) + this.m_bufPos;
                bArr3[i5] = (byte) (bArr3[i5] ^ 1);
                int i6 = this.DigestSize - 1;
                bArr3[i6] = (byte) (bArr3[i6] ^ 32);
            } else if (i4 == 4 && i2 == 0) {
                byte[] bArr4 = this.f19481state;
                int i7 = this.DigestSize - 1;
                bArr4[i7] = (byte) (bArr4[i7] ^ 64);
            } else {
                PhotonBeetleEngine.photonPermutation(C5293Friend.INSTANCE, this.f19481state);
                C6240Bytes.m18281xorTo(this.m_bufPos, this.f19336m_buf, this.f19481state);
                int i8 = this.m_bufPos;
                int i9 = this.BlockSize;
                if (i8 < i9) {
                    byte[] bArr5 = this.f19481state;
                    bArr5[i8] = (byte) (bArr5[i8] ^ 1);
                }
                byte[] bArr6 = this.f19481state;
                int i10 = this.DigestSize - 1;
                bArr6[i10] = (byte) (((i8 % i9 != 0 ? 2 : 1) << 5) ^ bArr6[i10]);
            }
        }
        PhotonBeetleEngine.photonPermutation(C5293Friend.INSTANCE, this.f19481state);
        System.arraycopy(this.f19481state, 0, bArr, i, 16);
        PhotonBeetleEngine.photonPermutation(C5293Friend.INSTANCE, this.f19481state);
        System.arraycopy(this.f19481state, 0, bArr, i + 16, 16);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.ExtendedDigest
    public /* bridge */ /* synthetic */ int getByteLength() {
        return super.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ int getDigestSize() {
        return super.getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i) {
        int i2 = this.blockCount;
        if (i2 < 4) {
            System.arraycopy(bArr, i, this.f19481state, i2 << 2, this.BlockSize);
        } else {
            PhotonBeetleEngine.photonPermutation(C5293Friend.INSTANCE, this.f19481state);
            C6240Bytes.m18279xorTo(this.BlockSize, bArr, i, this.f19481state);
        }
        this.blockCount++;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        C6238Arrays.m18249fill(this.f19481state, (byte) 0);
        this.blockCount = 0;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }
}
