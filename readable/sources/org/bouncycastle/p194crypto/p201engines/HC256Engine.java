package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class HC256Engine implements StreamCipher {
    private boolean initialised;

    /* renamed from: iv */
    private byte[] f19911iv;

    /* renamed from: key */
    private byte[] f19912key;

    /* renamed from: p */
    private int[] f19913p = new int[1024];

    /* renamed from: q */
    private int[] f19914q = new int[1024];

    /* renamed from: cnt */
    private int f19909cnt = 0;

    /* renamed from: buf */
    private byte[] f19908buf = new byte[4];

    /* renamed from: idx */
    private int f19910idx = 0;

    /* renamed from: getByte */
    private byte m15341getByte() {
        if (this.f19910idx == 0) {
            int iM15343step = m15343step();
            byte[] bArr = this.f19908buf;
            bArr[0] = (byte) (iM15343step & 255);
            bArr[1] = (byte) ((iM15343step >> 8) & 255);
            bArr[2] = (byte) ((iM15343step >> 16) & 255);
            bArr[3] = (byte) ((iM15343step >> 24) & 255);
        }
        byte[] bArr2 = this.f19908buf;
        int i = this.f19910idx;
        byte b = bArr2[i];
        this.f19910idx = 3 & (i + 1);
        return b;
    }

    /* renamed from: init */
    private void m15342init() {
        byte[] bArr = this.f19912key;
        if (bArr.length != 32 && bArr.length != 16) {
            throw new IllegalArgumentException("The key must be 128/256 bits long");
        }
        if (this.f19911iv.length < 16) {
            throw new IllegalArgumentException("The IV must be at least 128 bits long");
        }
        if (bArr.length != 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            byte[] bArr3 = this.f19912key;
            System.arraycopy(bArr3, 0, bArr2, 16, bArr3.length);
            this.f19912key = bArr2;
        }
        byte[] bArr4 = this.f19911iv;
        if (bArr4.length < 32) {
            byte[] bArr5 = new byte[32];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            byte[] bArr6 = this.f19911iv;
            System.arraycopy(bArr6, 0, bArr5, bArr6.length, 32 - bArr6.length);
            this.f19911iv = bArr5;
        }
        this.f19910idx = 0;
        this.f19909cnt = 0;
        int[] iArr = new int[2560];
        for (int i = 0; i < 32; i++) {
            int i2 = i >> 2;
            iArr[i2] = iArr[i2] | ((this.f19912key[i] & C1126UByte.MAX_VALUE) << ((i & 3) * 8));
        }
        for (int i3 = 0; i3 < 32; i3++) {
            int i4 = (i3 >> 2) + 8;
            iArr[i4] = iArr[i4] | ((this.f19911iv[i3] & C1126UByte.MAX_VALUE) << ((i3 & 3) * 8));
        }
        for (int i5 = 16; i5 < 2560; i5++) {
            int i6 = iArr[i5 - 2];
            int i7 = iArr[i5 - 15];
            iArr[i5] = ((i6 >>> 10) ^ (rotateRight(i6, 17) ^ rotateRight(i6, 19))) + iArr[i5 - 7] + ((i7 >>> 3) ^ (rotateRight(i7, 7) ^ rotateRight(i7, 18))) + iArr[i5 - 16] + i5;
        }
        System.arraycopy(iArr, 512, this.f19913p, 0, 1024);
        System.arraycopy(iArr, 1536, this.f19914q, 0, 1024);
        for (int i8 = 0; i8 < 4096; i8++) {
            m15343step();
        }
        this.f19909cnt = 0;
    }

    private static int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: step */
    private int m15343step() {
        int i;
        int i2;
        int i3 = this.f19909cnt;
        int i4 = i3 & 1023;
        if (i3 < 1024) {
            int[] iArr = this.f19913p;
            int i5 = iArr[(i4 - 3) & 1023];
            int i6 = iArr[(i4 - 1023) & 1023];
            int i7 = iArr[i4];
            int iRotateRight = iArr[(i4 - 10) & 1023] + (rotateRight(i6, 23) ^ rotateRight(i5, 10));
            int[] iArr2 = this.f19914q;
            iArr[i4] = i7 + iRotateRight + iArr2[(i5 ^ i6) & 1023];
            int[] iArr3 = this.f19913p;
            int i8 = iArr3[(i4 - 12) & 1023];
            i = iArr2[i8 & 255] + iArr2[((i8 >> 8) & 255) + 256] + iArr2[((i8 >> 16) & 255) + 512] + iArr2[((i8 >> 24) & 255) + 768];
            i2 = iArr3[i4];
        } else {
            int[] iArr4 = this.f19914q;
            int i9 = iArr4[(i4 - 3) & 1023];
            int i10 = iArr4[(i4 - 1023) & 1023];
            int i11 = iArr4[i4];
            int iRotateRight2 = iArr4[(i4 - 10) & 1023] + (rotateRight(i10, 23) ^ rotateRight(i9, 10));
            int[] iArr5 = this.f19913p;
            iArr4[i4] = i11 + iRotateRight2 + iArr5[(i9 ^ i10) & 1023];
            int[] iArr6 = this.f19914q;
            int i12 = iArr6[(i4 - 12) & 1023];
            i = iArr5[i12 & 255] + iArr5[((i12 >> 8) & 255) + 256] + iArr5[((i12 >> 16) & 255) + 512] + iArr5[((i12 >> 24) & 255) + 768];
            i2 = iArr6[i4];
        }
        int i13 = i2 ^ i;
        this.f19909cnt = (this.f19909cnt + 1) & 2047;
        return i13;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-256";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ m15341getByte());
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        m15342init();
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        return (byte) (m15341getByte() ^ b);
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f19911iv = parametersWithIV.m15801getIV();
            parameters = parametersWithIV.getParameters();
        } else {
            this.f19911iv = new byte[0];
            parameters = cipherParameters;
        }
        if (!(parameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Invalid parameter passed to HC256 init - " + cipherParameters.getClass().getName());
        }
        this.f19912key = ((KeyParameter) parameters).m15773getKey();
        m15342init();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), this.f19912key.length * 8, cipherParameters, C5342Utils.getPurpose(z)));
        this.initialised = true;
    }
}
