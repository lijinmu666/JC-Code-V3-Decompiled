package org.bouncycastle.p194crypto.p201engines;

/* loaded from: classes2.dex */
public final class CAST6Engine extends CAST5Engine {
    protected static final int BLOCK_SIZE = 16;

    /* renamed from: ROUNDS */
    protected static final int f19769ROUNDS = 12;

    /* renamed from: _Kr */
    protected int[] f19771_Kr = new int[48];

    /* renamed from: _Km */
    protected int[] f19770_Km = new int[48];

    /* renamed from: _Tr */
    protected int[] f19773_Tr = new int[192];

    /* renamed from: _Tm */
    protected int[] f19772_Tm = new int[192];
    private int[] _workingKey = new int[8];

    public final void CAST_Decipher(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6 = 0;
        while (true) {
            if (i6 >= 6) {
                break;
            }
            int i7 = (11 - i6) * 4;
            i3 ^= m15271F1(i4, this.f19770_Km[i7], this.f19771_Kr[i7]);
            int i8 = i7 + 1;
            i2 ^= m15272F2(i3, this.f19770_Km[i8], this.f19771_Kr[i8]);
            int i9 = i7 + 2;
            i ^= m15273F3(i2, this.f19770_Km[i9], this.f19771_Kr[i9]);
            int i10 = i7 + 3;
            i4 ^= m15271F1(i, this.f19770_Km[i10], this.f19771_Kr[i10]);
            i6++;
        }
        for (i5 = 6; i5 < 12; i5++) {
            int i11 = (11 - i5) * 4;
            int i12 = i11 + 3;
            i4 ^= m15271F1(i, this.f19770_Km[i12], this.f19771_Kr[i12]);
            int i13 = i11 + 2;
            i ^= m15273F3(i2, this.f19770_Km[i13], this.f19771_Kr[i13]);
            int i14 = i11 + 1;
            i2 ^= m15272F2(i3, this.f19770_Km[i14], this.f19771_Kr[i14]);
            i3 ^= m15271F1(i4, this.f19770_Km[i11], this.f19771_Kr[i11]);
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    public final void CAST_Encipher(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6 = 0;
        while (true) {
            if (i6 >= 6) {
                break;
            }
            int i7 = i6 * 4;
            i3 ^= m15271F1(i4, this.f19770_Km[i7], this.f19771_Kr[i7]);
            int i8 = i7 + 1;
            i2 ^= m15272F2(i3, this.f19770_Km[i8], this.f19771_Kr[i8]);
            int i9 = i7 + 2;
            i ^= m15273F3(i2, this.f19770_Km[i9], this.f19771_Kr[i9]);
            int i10 = i7 + 3;
            i4 ^= m15271F1(i, this.f19770_Km[i10], this.f19771_Kr[i10]);
            i6++;
        }
        for (i5 = 6; i5 < 12; i5++) {
            int i11 = i5 * 4;
            int i12 = i11 + 3;
            i4 ^= m15271F1(i, this.f19770_Km[i12], this.f19771_Kr[i12]);
            int i13 = i11 + 2;
            i ^= m15273F3(i2, this.f19770_Km[i13], this.f19771_Kr[i13]);
            int i14 = i11 + 1;
            i2 ^= m15272F2(i3, this.f19770_Km[i14], this.f19771_Kr[i14]);
            i3 ^= m15271F1(i4, this.f19770_Km[i11], this.f19771_Kr[i11]);
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine
    public int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        CAST_Decipher(BytesTo32bits(bArr, i), BytesTo32bits(bArr, i + 4), BytesTo32bits(bArr, i + 8), BytesTo32bits(bArr, i + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i2);
        Bits32ToBytes(iArr[1], bArr2, i2 + 4);
        Bits32ToBytes(iArr[2], bArr2, i2 + 8);
        Bits32ToBytes(iArr[3], bArr2, i2 + 12);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine
    public int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        CAST_Encipher(BytesTo32bits(bArr, i), BytesTo32bits(bArr, i + 4), BytesTo32bits(bArr, i + 8), BytesTo32bits(bArr, i + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i2);
        Bits32ToBytes(iArr[1], bArr2, i2 + 4);
        Bits32ToBytes(iArr[2], bArr2, i2 + 8);
        Bits32ToBytes(iArr[3], bArr2, i2 + 12);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine, org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "CAST6";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine, org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine, org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }

    @Override // org.bouncycastle.p194crypto.p201engines.CAST5Engine
    /* renamed from: setKey */
    public void mo15274setKey(byte[] bArr) {
        int i = 1518500249;
        int i2 = 19;
        for (int i3 = 0; i3 < 24; i3++) {
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = (i3 * 8) + i4;
                this.f19772_Tm[i5] = i;
                i += 1859775393;
                this.f19773_Tr[i5] = i2;
                i2 = (i2 + 17) & 31;
            }
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i6 = 0; i6 < 8; i6++) {
            this._workingKey[i6] = BytesTo32bits(bArr2, i6 * 4);
        }
        for (int i7 = 0; i7 < 12; i7++) {
            int i8 = i7 * 16;
            int[] iArr = this._workingKey;
            iArr[6] = iArr[6] ^ m15271F1(iArr[7], this.f19772_Tm[i8], this.f19773_Tr[i8]);
            int[] iArr2 = this._workingKey;
            int i9 = i8 + 1;
            iArr2[5] = iArr2[5] ^ m15272F2(iArr2[6], this.f19772_Tm[i9], this.f19773_Tr[i9]);
            int[] iArr3 = this._workingKey;
            int i10 = i8 + 2;
            iArr3[4] = iArr3[4] ^ m15273F3(iArr3[5], this.f19772_Tm[i10], this.f19773_Tr[i10]);
            int[] iArr4 = this._workingKey;
            int i11 = i8 + 3;
            iArr4[3] = m15271F1(iArr4[4], this.f19772_Tm[i11], this.f19773_Tr[i11]) ^ iArr4[3];
            int[] iArr5 = this._workingKey;
            int i12 = i8 + 4;
            iArr5[2] = m15272F2(iArr5[3], this.f19772_Tm[i12], this.f19773_Tr[i12]) ^ iArr5[2];
            int[] iArr6 = this._workingKey;
            int i13 = i8 + 5;
            iArr6[1] = m15273F3(iArr6[2], this.f19772_Tm[i13], this.f19773_Tr[i13]) ^ iArr6[1];
            int[] iArr7 = this._workingKey;
            int i14 = i8 + 6;
            iArr7[0] = iArr7[0] ^ m15271F1(iArr7[1], this.f19772_Tm[i14], this.f19773_Tr[i14]);
            int[] iArr8 = this._workingKey;
            int i15 = i8 + 7;
            iArr8[7] = m15272F2(iArr8[0], this.f19772_Tm[i15], this.f19773_Tr[i15]) ^ iArr8[7];
            int i16 = ((i7 * 2) + 1) * 8;
            int[] iArr9 = this._workingKey;
            iArr9[6] = iArr9[6] ^ m15271F1(iArr9[7], this.f19772_Tm[i16], this.f19773_Tr[i16]);
            int[] iArr10 = this._workingKey;
            int i17 = i16 + 1;
            iArr10[5] = iArr10[5] ^ m15272F2(iArr10[6], this.f19772_Tm[i17], this.f19773_Tr[i17]);
            int[] iArr11 = this._workingKey;
            int i18 = i16 + 2;
            iArr11[4] = iArr11[4] ^ m15273F3(iArr11[5], this.f19772_Tm[i18], this.f19773_Tr[i18]);
            int[] iArr12 = this._workingKey;
            int i19 = i16 + 3;
            iArr12[3] = m15271F1(iArr12[4], this.f19772_Tm[i19], this.f19773_Tr[i19]) ^ iArr12[3];
            int[] iArr13 = this._workingKey;
            int i20 = i16 + 4;
            iArr13[2] = m15272F2(iArr13[3], this.f19772_Tm[i20], this.f19773_Tr[i20]) ^ iArr13[2];
            int[] iArr14 = this._workingKey;
            int i21 = i16 + 5;
            iArr14[1] = m15273F3(iArr14[2], this.f19772_Tm[i21], this.f19773_Tr[i21]) ^ iArr14[1];
            int[] iArr15 = this._workingKey;
            int i22 = i16 + 6;
            iArr15[0] = iArr15[0] ^ m15271F1(iArr15[1], this.f19772_Tm[i22], this.f19773_Tr[i22]);
            int[] iArr16 = this._workingKey;
            int i23 = i16 + 7;
            iArr16[7] = m15272F2(iArr16[0], this.f19772_Tm[i23], this.f19773_Tr[i23]) ^ iArr16[7];
            int[] iArr17 = this.f19771_Kr;
            int i24 = i7 * 4;
            int[] iArr18 = this._workingKey;
            iArr17[i24] = iArr18[0] & 31;
            int i25 = i24 + 1;
            iArr17[i25] = iArr18[2] & 31;
            int i26 = i24 + 2;
            iArr17[i26] = iArr18[4] & 31;
            int i27 = i24 + 3;
            iArr17[i27] = iArr18[6] & 31;
            int[] iArr19 = this.f19770_Km;
            iArr19[i24] = iArr18[7];
            iArr19[i25] = iArr18[5];
            iArr19[i26] = iArr18[3];
            iArr19[i27] = iArr18[1];
        }
    }
}
