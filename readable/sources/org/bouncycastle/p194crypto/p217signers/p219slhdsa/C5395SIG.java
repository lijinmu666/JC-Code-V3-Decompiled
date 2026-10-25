package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

/* renamed from: org.bouncycastle.crypto.signers.slhdsa.SIG */
/* loaded from: classes2.dex */
class C5395SIG {

    /* renamed from: r */
    private final byte[] f21072r;
    private final SIG_FORS[] sig_fors;

    /* renamed from: sig_ht */
    private final SIG_XMSS[] f21073sig_ht;

    public C5395SIG(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        byte[] bArr2 = new byte[i];
        this.f21072r = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i);
        this.sig_fors = new SIG_FORS[i2];
        int i7 = i;
        for (int i8 = 0; i8 != i2; i8++) {
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, i7, bArr3, 0, i);
            i7 += i;
            byte[][] bArr4 = new byte[i3][];
            for (int i9 = 0; i9 != i3; i9++) {
                byte[] bArr5 = new byte[i];
                bArr4[i9] = bArr5;
                System.arraycopy(bArr, i7, bArr5, 0, i);
                i7 += i;
            }
            this.sig_fors[i8] = new SIG_FORS(bArr3, bArr4);
        }
        this.f21073sig_ht = new SIG_XMSS[i4];
        for (int i10 = 0; i10 != i4; i10++) {
            int i11 = i6 * i;
            byte[] bArr6 = new byte[i11];
            System.arraycopy(bArr, i7, bArr6, 0, i11);
            i7 += i11;
            byte[][] bArr7 = new byte[i5][];
            for (int i12 = 0; i12 != i5; i12++) {
                byte[] bArr8 = new byte[i];
                bArr7[i12] = bArr8;
                System.arraycopy(bArr, i7, bArr8, 0, i);
                i7 += i;
            }
            this.f21073sig_ht[i10] = new SIG_XMSS(bArr6, bArr7);
        }
        if (i7 != bArr.length) {
            throw new IllegalArgumentException("signature wrong length");
        }
    }

    /* renamed from: getR */
    public byte[] m15885getR() {
        return this.f21072r;
    }

    public SIG_FORS[] getSIG_FORS() {
        return this.sig_fors;
    }

    public SIG_XMSS[] getSIG_HT() {
        return this.f21073sig_ht;
    }
}
