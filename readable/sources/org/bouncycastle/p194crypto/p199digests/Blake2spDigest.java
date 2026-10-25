package org.bouncycastle.p194crypto.p199digests;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Blake2spDigest implements ExtendedDigest {

    /* renamed from: depth */
    private int f19306depth;
    private int digestLength;

    /* renamed from: fanout */
    private int f19307fanout;
    private long innerHashLength;

    /* renamed from: root */
    private Blake2sDigest f19310root;
    private int bufferPos = 0;
    private int keyLength = 0;
    private int nodeOffset = 0;

    /* renamed from: S */
    private Blake2sDigest[] f19304S = new Blake2sDigest[8];

    /* renamed from: salt */
    private byte[] f19311salt = null;

    /* renamed from: key */
    private byte[] f19308key = null;
    private final int BLAKE2S_BLOCKBYTES = 64;
    private final int BLAKE2S_KEYBYTES = 32;
    private final int BLAKE2S_OUTBYTES = 32;
    private final int PARALLELISM_DEGREE = 8;
    private final byte[] singleByte = new byte[1];

    /* renamed from: param */
    private byte[] f19309param = new byte[32];

    /* renamed from: buffer */
    private byte[] f19305buffer = new byte[512];

    public Blake2spDigest(byte[] bArr) {
        m15053init(bArr);
    }

    /* renamed from: init */
    private void m15053init(byte[] bArr) {
        int i;
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            this.keyLength = length;
            if (length > 32) {
                throw new IllegalArgumentException("Keys > 32 bytes are not supported");
            }
            this.f19308key = C6238Arrays.m18231clone(bArr);
        }
        this.bufferPos = 0;
        this.digestLength = 32;
        this.f19307fanout = 8;
        this.f19306depth = 2;
        this.innerHashLength = 32L;
        byte[] bArr2 = this.f19309param;
        bArr2[0] = (byte) 32;
        bArr2[1] = (byte) this.keyLength;
        bArr2[2] = (byte) 8;
        bArr2[3] = (byte) 2;
        AbstractC6245Pack.intToLittleEndian(0, bArr2, 8);
        byte[] bArr3 = this.f19309param;
        bArr3[14] = 1;
        bArr3[15] = (byte) this.innerHashLength;
        this.f19310root = new Blake2sDigest((byte[]) null, this.f19309param);
        AbstractC6245Pack.intToLittleEndian(this.nodeOffset, this.f19309param, 8);
        this.f19309param[14] = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            AbstractC6245Pack.intToLittleEndian(i2, this.f19309param, 8);
            this.f19304S[i2] = new Blake2sDigest((byte[]) null, this.f19309param);
        }
        this.f19310root.setAsLastNode();
        this.f19304S[7].setAsLastNode();
        if (bArr == null || (i = this.keyLength) <= 0) {
            return;
        }
        byte[] bArr4 = new byte[64];
        System.arraycopy(bArr, 0, bArr4, 0, i);
        for (int i3 = 0; i3 < 8; i3++) {
            this.f19304S[i3].mo14970update(bArr4, 0, 64);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 8, 32);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = this.bufferPos;
            int i4 = i2 * 64;
            if (i3 > i4) {
                int i5 = i3 - i4;
                if (i5 > 64) {
                    i5 = 64;
                }
                this.f19304S[i2].mo14970update(this.f19305buffer, i4, i5);
            }
            this.f19304S[i2].mo14967doFinal(bArr2[i2], 0);
        }
        for (int i6 = 0; i6 < 8; i6++) {
            this.f19310root.mo14970update(bArr2[i6], 0, 32);
        }
        int iMo14967doFinal = this.f19310root.mo14967doFinal(bArr, i);
        mo14968reset();
        return iMo14967doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "BLAKE2sp";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.bufferPos = 0;
        this.digestLength = 32;
        this.f19310root.mo14968reset();
        for (int i = 0; i < 8; i++) {
            this.f19304S[i].mo14968reset();
        }
        this.f19310root.setAsLastNode();
        this.f19304S[7].setAsLastNode();
        byte[] bArr = this.f19308key;
        if (bArr != null) {
            byte[] bArr2 = new byte[64];
            System.arraycopy(bArr, 0, bArr2, 0, this.keyLength);
            for (int i2 = 0; i2 < 8; i2++) {
                this.f19304S[i2].mo14970update(bArr2, 0, 64);
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        mo14970update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3 = this.bufferPos;
        int i4 = 512 - i3;
        if (i3 != 0 && i2 >= i4) {
            System.arraycopy(bArr, i, this.f19305buffer, i3, i4);
            for (int i5 = 0; i5 < 8; i5++) {
                this.f19304S[i5].mo14970update(this.f19305buffer, i5 * 64, 64);
            }
            i += i4;
            i2 -= i4;
            i3 = 0;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = (i6 * 64) + i;
            for (int i8 = i2; i8 >= 512; i8 -= 512) {
                this.f19304S[i6].mo14970update(bArr, i7, 64);
                i7 += 512;
            }
        }
        int i9 = i2 % 512;
        int i10 = i + (i2 - i9);
        if (i9 > 0) {
            System.arraycopy(bArr, i10, this.f19305buffer, i3, i9);
        }
        this.bufferPos = i3 + i9;
    }
}
