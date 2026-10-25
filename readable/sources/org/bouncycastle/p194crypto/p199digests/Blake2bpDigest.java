package org.bouncycastle.p194crypto.p199digests;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Blake2bpDigest implements ExtendedDigest {

    /* renamed from: depth */
    private int f19287depth;
    private int digestLength;

    /* renamed from: fanout */
    private int f19288fanout;
    private long innerHashLength;

    /* renamed from: root */
    private Blake2bDigest f19291root;
    private int bufferPos = 0;
    private int keyLength = 0;
    private int nodeOffset = 0;

    /* renamed from: S */
    private Blake2bDigest[] f19285S = new Blake2bDigest[4];

    /* renamed from: salt */
    private byte[] f19292salt = null;

    /* renamed from: key */
    private byte[] f19289key = null;
    private final int BLAKE2B_BLOCKBYTES = 128;
    private final int BLAKE2B_KEYBYTES = 64;
    private final int BLAKE2B_OUTBYTES = 64;
    private final int PARALLELISM_DEGREE = 4;
    private final byte[] singleByte = new byte[1];

    /* renamed from: param */
    private byte[] f19290param = new byte[64];

    /* renamed from: buffer */
    private byte[] f19286buffer = new byte[512];

    public Blake2bpDigest(byte[] bArr) {
        m15050init(bArr);
    }

    /* renamed from: init */
    private void m15050init(byte[] bArr) {
        int i;
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            this.keyLength = length;
            if (length > 64) {
                throw new IllegalArgumentException("Keys > 64 bytes are not supported");
            }
            this.f19289key = C6238Arrays.m18231clone(bArr);
        }
        this.bufferPos = 0;
        this.digestLength = 64;
        this.f19288fanout = 4;
        this.f19287depth = 2;
        this.innerHashLength = 64L;
        byte[] bArr2 = this.f19290param;
        bArr2[0] = (byte) 64;
        bArr2[1] = (byte) this.keyLength;
        bArr2[2] = (byte) 4;
        bArr2[3] = (byte) 2;
        bArr2[16] = 1;
        bArr2[17] = (byte) 64;
        this.f19291root = new Blake2bDigest((byte[]) null, this.f19290param);
        AbstractC6245Pack.intToLittleEndian(this.nodeOffset, this.f19290param, 8);
        this.f19290param[16] = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            AbstractC6245Pack.intToLittleEndian(i2, this.f19290param, 8);
            this.f19285S[i2] = new Blake2bDigest((byte[]) null, this.f19290param);
        }
        this.f19291root.setAsLastNode();
        this.f19285S[3].setAsLastNode();
        if (bArr == null || (i = this.keyLength) <= 0) {
            return;
        }
        byte[] bArr3 = new byte[128];
        System.arraycopy(bArr, 0, bArr3, 0, i);
        for (int i3 = 0; i3 < 4; i3++) {
            this.f19285S[i3].mo14970update(bArr3, 0, 128);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 64);
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = this.bufferPos;
            int i4 = i2 * 128;
            if (i3 > i4) {
                int i5 = i3 - i4;
                if (i5 > 128) {
                    i5 = 128;
                }
                this.f19285S[i2].mo14970update(this.f19286buffer, i4, i5);
            }
            this.f19285S[i2].mo14967doFinal(bArr2[i2], 0);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            this.f19291root.mo14970update(bArr2[i6], 0, 64);
        }
        int iMo14967doFinal = this.f19291root.mo14967doFinal(bArr, i);
        mo14968reset();
        return iMo14967doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "BLAKE2bp";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.bufferPos = 0;
        this.digestLength = 64;
        this.f19291root.mo14968reset();
        for (int i = 0; i < 4; i++) {
            this.f19285S[i].mo14968reset();
        }
        this.f19291root.setAsLastNode();
        this.f19285S[3].setAsLastNode();
        byte[] bArr = this.f19289key;
        if (bArr != null) {
            byte[] bArr2 = new byte[128];
            System.arraycopy(bArr, 0, bArr2, 0, this.keyLength);
            for (int i2 = 0; i2 < 4; i2++) {
                this.f19285S[i2].mo14970update(bArr2, 0, 128);
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
        int i4 = 1024 - i3;
        if (i3 != 0 && i2 >= i4) {
            System.arraycopy(bArr, i, this.f19286buffer, i3, i4);
            for (int i5 = 0; i5 < 4; i5++) {
                this.f19285S[i5].mo14970update(this.f19286buffer, i5 * 128, 128);
            }
            i += i4;
            i2 -= i4;
            i3 = 0;
        }
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = (i6 * 128) + i;
            for (int i8 = i2; i8 >= 512; i8 -= 512) {
                this.f19285S[i6].mo14970update(bArr, i7, 128);
                i7 += 512;
            }
        }
        int i9 = i2 % 512;
        int i10 = i + (i2 - i9);
        if (i9 > 0) {
            System.arraycopy(bArr, i10, this.f19286buffer, i3, i9);
        }
        this.bufferPos = i3 + i9;
    }
}
