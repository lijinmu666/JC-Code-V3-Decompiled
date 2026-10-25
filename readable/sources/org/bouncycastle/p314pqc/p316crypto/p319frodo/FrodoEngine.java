package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class FrodoEngine {

    /* renamed from: len_chi */
    private static final int f23144len_chi = 16;
    private static final int len_chi_bytes = 2;
    private static final int len_seedA = 128;
    private static final int len_seedA_bytes = 16;

    /* renamed from: len_z */
    private static final int f23145len_z = 128;
    private static final int len_z_bytes = 16;

    /* renamed from: mbar */
    private static final int f23146mbar = 8;

    /* renamed from: nbar */
    static final int f23147nbar = 8;

    /* renamed from: B */
    private final int f23148B;

    /* renamed from: D */
    private final int f23149D;

    /* renamed from: T_chi */
    private final short[] f23150T_chi;

    /* renamed from: digest */
    private final InterfaceC5284Xof f23151digest;

    /* renamed from: gen */
    private final FrodoMatrixGenerator f23152gen;
    private final int len_ct_bytes;

    /* renamed from: len_k */
    private final int f23153len_k;
    private final int len_k_bytes;

    /* renamed from: len_mu */
    private final int f23154len_mu;
    private final int len_mu_bytes;
    private final int len_pk_bytes;

    /* renamed from: len_pkh */
    private final int f23155len_pkh;
    private final int len_pkh_bytes;

    /* renamed from: len_s */
    private final int f23156len_s;
    private final int len_s_bytes;
    private final int len_seedSE;
    private final int len_seedSE_bytes;
    private final int len_sk_bytes;

    /* renamed from: len_ss */
    private final int f23157len_ss;
    private final int len_ss_bytes;

    /* renamed from: n */
    private final int f23158n;

    /* renamed from: q */
    private final int f23159q;

    public FrodoEngine(int i, int i2, int i3, short[] sArr, InterfaceC5284Xof interfaceC5284Xof, FrodoMatrixGenerator frodoMatrixGenerator) {
        this.f23158n = i;
        this.f23149D = i2;
        this.f23159q = 1 << i2;
        this.f23148B = i3;
        int i4 = i3 * 64;
        this.f23154len_mu = i4;
        this.len_seedSE = i4;
        this.f23156len_s = i4;
        this.f23153len_k = i4;
        this.f23155len_pkh = i4;
        this.f23157len_ss = i4;
        this.len_mu_bytes = i4 / 8;
        this.len_seedSE_bytes = i4 / 8;
        int i5 = i4 / 8;
        this.len_s_bytes = i5;
        this.len_k_bytes = i4 / 8;
        int i6 = i4 / 8;
        this.len_pkh_bytes = i6;
        this.len_ss_bytes = i4 / 8;
        int i7 = ((i2 * i) * 8) / 8;
        this.len_ct_bytes = ((i2 * 64) / 8) + i7;
        int i8 = i7 + 16;
        this.len_pk_bytes = i8;
        this.len_sk_bytes = i5 + i8 + (i * 16) + i6;
        this.f23150T_chi = sArr;
        this.f23151digest = interfaceC5284Xof;
        this.f23152gen = frodoMatrixGenerator;
    }

    private static int ctverify(short[] sArr, short[] sArr2, short[] sArr3, short[] sArr4) {
        int i = 0;
        for (int i2 = 0; i2 < sArr.length; i2++) {
            i |= sArr[i2] ^ sArr3[i2];
        }
        for (int i3 = 0; i3 < sArr2.length; i3++) {
            i |= sArr2[i3] ^ sArr4[i3];
        }
        return AbstractC5869Nat.m16907czero(i);
    }

    /* renamed from: decode */
    private byte[] m17560decode(short[] sArr) {
        int i = this.f23148B;
        short s = (short) ((1 << i) - 1);
        short s2 = (short) ((1 << this.f23149D) - 1);
        byte[] bArr = new byte[i * 8];
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            long j = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = sArr[i2] & s2;
                int i6 = this.f23149D;
                j |= (((short) ((i5 + (1 << ((i6 - r14) - 1))) >> (i6 - r14))) & s) << (this.f23148B * i4);
                i2++;
            }
            int i7 = 0;
            while (true) {
                int i8 = this.f23148B;
                if (i7 < i8) {
                    bArr[(i8 * i3) + i7] = (byte) ((j >> (i7 * 8)) & 255);
                    i7++;
                }
            }
        }
        return bArr;
    }

    /* renamed from: encode */
    private short[] m17561encode(byte[] bArr) {
        int i;
        short[] sArr = new short[64];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 8; i4++) {
            for (int i5 = 0; i5 < 8; i5++) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    i = this.f23148B;
                    if (i6 < i) {
                        i7 += ((bArr[i2] >>> i3) & 1) << i6;
                        int i8 = i3 + 1;
                        i2 += i8 >>> 3;
                        i3 = i8 & 7;
                        i6++;
                    }
                }
                sArr[(i4 * 8) + i5] = (short) (i7 * (this.f23159q / (1 << i)));
            }
        }
        return sArr;
    }

    private short[] matrix_add(short[] sArr, short[] sArr2, int i, int i2) {
        int i3 = this.f23159q - 1;
        short[] sArr3 = new short[i * i2];
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = (i4 * i2) + i5;
                sArr3[i6] = (short) ((sArr[i6] + sArr2[i6]) & i3);
            }
        }
        return sArr3;
    }

    private short[] matrix_mul(short[] sArr, int i, int i2, short[] sArr2, int i3) {
        int i4 = this.f23159q - 1;
        short[] sArr3 = new short[i * i3];
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = 0;
                for (int i8 = 0; i8 < i2; i8++) {
                    i7 += sArr[(i5 * i2) + i8] * sArr2[(i8 * i3) + i6];
                }
                sArr3[(i5 * i3) + i6] = (short) (i7 & i4);
            }
        }
        return sArr3;
    }

    private short[] matrix_sub(short[] sArr, short[] sArr2, int i, int i2) {
        int i3 = this.f23159q - 1;
        short[] sArr3 = new short[i * i2];
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = (i4 * i2) + i5;
                sArr3[i6] = (short) ((sArr[i6] - sArr2[i6]) & i3);
            }
        }
        return sArr3;
    }

    private short[] matrix_transpose(short[] sArr, int i, int i2) {
        short[] sArr2 = new short[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                sArr2[(i3 * i) + i4] = sArr[(i4 * i2) + i3];
            }
        }
        return sArr2;
    }

    /* renamed from: pack */
    private byte[] m17562pack(short[] sArr) {
        int length = sArr.length;
        int i = (this.f23149D * length) / 8;
        byte[] bArr = new byte[i];
        short s = 0;
        short s2 = 0;
        byte b = 0;
        short s3 = 0;
        while (s < i && (s2 < length || (s2 == length && b > 0))) {
            byte b2 = 0;
            while (b2 < 8) {
                int i2 = 8 - b2;
                int iMin = Math.min(i2, (int) b);
                int i3 = b - iMin;
                bArr[s] = (byte) (bArr[s] + (((byte) (((short) ((1 << iMin) - 1)) & (s3 >> i3))) << (i2 - iMin)));
                b2 = (byte) (b2 + iMin);
                b = (byte) i3;
                if (b == 0) {
                    if (s2 >= length) {
                        break;
                    }
                    short s4 = sArr[s2];
                    s2 = (short) (s2 + 1);
                    s3 = s4;
                    b = (byte) this.f23149D;
                }
            }
            if (b2 == 8) {
                s = (short) (s + 1);
            }
        }
        return bArr;
    }

    private short[] sample_matrix(short[] sArr, int i, int i2, int i3) {
        short[] sArr2 = new short[i2 * i3];
        AbstractC6062Noise.m17570sample(this.f23150T_chi, sArr, i, sArr2);
        return sArr2;
    }

    /* renamed from: unpack */
    private short[] m17563unpack(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        short[] sArr = new short[i3];
        short s = 0;
        short s2 = 0;
        byte b = 0;
        byte b2 = 0;
        while (s < i3 && (s2 < bArr.length || (s2 == bArr.length && b > 0))) {
            byte b3 = 0;
            while (true) {
                int i4 = this.f23149D;
                if (b3 >= i4) {
                    break;
                }
                int iMin = Math.min(i4 - b3, (int) b);
                short s3 = (short) (((1 << iMin) - 1) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                sArr[s] = (short) (((sArr[s] & 65535) + ((((byte) ((((b2 & C1126UByte.MAX_VALUE) >>> ((b & C1126UByte.MAX_VALUE) - iMin)) & (s3 & 65535)) & 255)) & C1126UByte.MAX_VALUE) << ((this.f23149D - (b3 & C1126UByte.MAX_VALUE)) - iMin))) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                b3 = (byte) (b3 + iMin);
                byte b4 = (byte) (b - iMin);
                byte b5 = (byte) ((~(s3 << b4)) & b2);
                if (b4 != 0) {
                    b2 = b5;
                    b = b4;
                } else {
                    if (s2 >= bArr.length) {
                        b2 = b5;
                        b = b4;
                        break;
                    }
                    byte b6 = bArr[s2];
                    s2 = (short) (s2 + 1);
                    b = 8;
                    b2 = b6;
                }
            }
            if (b3 == this.f23149D) {
                s = (short) (s + 1);
            }
        }
        return sArr;
    }

    public int getCipherTextSize() {
        return this.len_ct_bytes;
    }

    public int getPrivateKeySize() {
        return this.len_sk_bytes;
    }

    public int getPublicKeySize() {
        return this.len_pk_bytes;
    }

    public int getSessionKeySize() {
        return this.len_ss_bytes;
    }

    /* renamed from: kem_dec */
    public void m17564kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = ((this.f23158n * 8) * this.f23149D) / 8;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr2, 0, i);
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr2, i, ((this.f23149D * 64) / 8) + i);
        int i2 = this.len_s_bytes + 16;
        int i3 = (((this.f23149D * this.f23158n) * 8) / 8) + i2;
        byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr3, i2, i3);
        int i4 = ((this.f23158n * 128) / 8) + i3;
        byte[] bArrCopyOfRange4 = C6238Arrays.copyOfRange(bArr3, i3, i4);
        short[] sArr = new short[this.f23158n * 8];
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.f23158n;
                if (i6 < i7) {
                    sArr[(i5 * i7) + i6] = AbstractC6245Pack.littleEndianToShort(bArrCopyOfRange4, (i7 * i5 * 2) + (i6 * 2));
                    i6++;
                }
            }
        }
        short[] sArrMatrix_transpose = matrix_transpose(sArr, 8, this.f23158n);
        byte[] bArrCopyOfRange5 = C6238Arrays.copyOfRange(bArr3, i4, this.len_pkh_bytes + i4);
        short[] sArrM17563unpack = m17563unpack(bArrCopyOfRange, 8, this.f23158n);
        short[] sArrM17563unpack2 = m17563unpack(bArrCopyOfRange2, 8, 8);
        byte[] bArrM17560decode = m17560decode(matrix_sub(sArrM17563unpack2, matrix_mul(sArrM17563unpack, 8, this.f23158n, sArrMatrix_transpose, 8), 8, 8));
        byte[] bArr4 = new byte[this.len_seedSE_bytes + this.len_k_bytes];
        this.f23151digest.mo14970update(bArrCopyOfRange5, 0, this.len_pkh_bytes);
        this.f23151digest.mo14970update(bArrM17560decode, 0, this.len_mu_bytes);
        this.f23151digest.mo14998doFinal(bArr4, 0, this.len_seedSE_bytes + this.len_k_bytes);
        int i8 = this.len_seedSE_bytes;
        byte[] bArrCopyOfRange6 = C6238Arrays.copyOfRange(bArr4, i8, this.len_k_bytes + i8);
        int i9 = ((this.f23158n * 16) + 64) * 2;
        byte[] bArr5 = new byte[i9];
        this.f23151digest.mo14969update((byte) -106);
        this.f23151digest.mo14970update(bArr4, 0, this.len_seedSE_bytes);
        this.f23151digest.mo14998doFinal(bArr5, 0, i9);
        short[] sArrLittleEndianToShort = AbstractC6245Pack.littleEndianToShort(bArr5, 0, i9 / 2);
        short[] sArrSample_matrix = sample_matrix(sArrLittleEndianToShort, 0, 8, this.f23158n);
        int i10 = this.f23158n;
        short[] sArrSample_matrix2 = sample_matrix(sArrLittleEndianToShort, i10 * 8, 8, i10);
        short[] sArrGenMatrix = this.f23152gen.genMatrix(bArr3, this.len_s_bytes, 16);
        int i11 = this.f23158n;
        C6240Bytes.m18273cmov(bArrCopyOfRange6.length, ~ctverify(sArrM17563unpack, sArrM17563unpack2, matrix_add(matrix_mul(sArrSample_matrix, 8, i11, sArrGenMatrix, i11), sArrSample_matrix2, 8, this.f23158n), matrix_add(matrix_add(matrix_mul(sArrSample_matrix, 8, this.f23158n, m17563unpack(bArrCopyOfRange3, this.f23158n, 8), 8), sample_matrix(sArrLittleEndianToShort, this.f23158n * 16, 8, 8), 8, 8), m17561encode(bArrM17560decode), 8, 8)), bArr3, bArrCopyOfRange6);
        this.f23151digest.mo14970update(bArrCopyOfRange, 0, bArrCopyOfRange.length);
        this.f23151digest.mo14970update(bArrCopyOfRange2, 0, bArrCopyOfRange2.length);
        this.f23151digest.mo14970update(bArrCopyOfRange6, 0, bArrCopyOfRange6.length);
        this.f23151digest.mo14998doFinal(bArr, 0, this.len_ss_bytes);
    }

    /* renamed from: kem_enc */
    public void m17565kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr3, 16, this.len_pk_bytes);
        byte[] bArr4 = new byte[this.len_mu_bytes];
        secureRandom.nextBytes(bArr4);
        byte[] bArr5 = new byte[this.len_pkh_bytes];
        this.f23151digest.mo14970update(bArr3, 0, this.len_pk_bytes);
        this.f23151digest.mo14998doFinal(bArr5, 0, this.len_pkh_bytes);
        byte[] bArr6 = new byte[this.len_seedSE + this.f23153len_k];
        this.f23151digest.mo14970update(bArr5, 0, this.len_pkh_bytes);
        this.f23151digest.mo14970update(bArr4, 0, this.len_mu_bytes);
        this.f23151digest.mo14998doFinal(bArr6, 0, this.len_seedSE_bytes + this.len_k_bytes);
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr6, 0, this.len_seedSE_bytes);
        int i = this.len_seedSE_bytes;
        byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr6, i, this.len_k_bytes + i);
        int i2 = ((this.f23158n * 16) + 64) * 2;
        byte[] bArr7 = new byte[i2];
        this.f23151digest.mo14969update((byte) -106);
        this.f23151digest.mo14970update(bArrCopyOfRange2, 0, bArrCopyOfRange2.length);
        this.f23151digest.mo14998doFinal(bArr7, 0, i2);
        short[] sArrLittleEndianToShort = AbstractC6245Pack.littleEndianToShort(bArr7, 0, i2 / 2);
        short[] sArrSample_matrix = sample_matrix(sArrLittleEndianToShort, 0, 8, this.f23158n);
        int i3 = this.f23158n;
        short[] sArrSample_matrix2 = sample_matrix(sArrLittleEndianToShort, i3 * 8, 8, i3);
        short[] sArrGenMatrix = this.f23152gen.genMatrix(bArr3, 0, 16);
        int i4 = this.f23158n;
        byte[] bArrM17562pack = m17562pack(matrix_add(matrix_mul(sArrSample_matrix, 8, i4, sArrGenMatrix, i4), sArrSample_matrix2, 8, this.f23158n));
        byte[] bArrM17562pack2 = m17562pack(matrix_add(matrix_add(matrix_mul(sArrSample_matrix, 8, this.f23158n, m17563unpack(bArrCopyOfRange, this.f23158n, 8), 8), sample_matrix(sArrLittleEndianToShort, this.f23158n * 16, 8, 8), 8, 8), m17561encode(bArr4), 8, 8));
        System.arraycopy(bArrM17562pack, 0, bArr, 0, bArrM17562pack.length);
        System.arraycopy(bArrM17562pack2, 0, bArr, bArrM17562pack.length, this.len_ct_bytes - bArrM17562pack.length);
        this.f23151digest.mo14970update(bArr, 0, this.len_ct_bytes);
        this.f23151digest.mo14970update(bArrCopyOfRange3, 0, this.len_k_bytes);
        this.f23151digest.mo14998doFinal(bArr2, 0, this.len_s_bytes);
    }

    public void kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        byte[] bArr3 = new byte[this.len_s_bytes + this.len_seedSE_bytes + 16];
        secureRandom.nextBytes(bArr3);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr3, 0, this.len_s_bytes);
        int i = this.len_s_bytes;
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr3, i, this.len_seedSE_bytes + i);
        int i2 = this.len_s_bytes;
        int i3 = this.len_seedSE_bytes;
        byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr3, i2 + i3, i2 + i3 + 16);
        byte[] bArr4 = new byte[16];
        this.f23151digest.mo14970update(bArrCopyOfRange3, 0, bArrCopyOfRange3.length);
        this.f23151digest.mo14998doFinal(bArr4, 0, 16);
        short[] sArrGenMatrix = this.f23152gen.genMatrix(bArr4, 0, 16);
        int i4 = this.f23158n * 32;
        byte[] bArr5 = new byte[i4];
        this.f23151digest.mo14969update((byte) 95);
        this.f23151digest.mo14970update(bArrCopyOfRange2, 0, bArrCopyOfRange2.length);
        this.f23151digest.mo14998doFinal(bArr5, 0, i4);
        short[] sArrLittleEndianToShort = AbstractC6245Pack.littleEndianToShort(bArr5, 0, i4 / 2);
        short[] sArrSample_matrix = sample_matrix(sArrLittleEndianToShort, 0, 8, this.f23158n);
        short[] sArrMatrix_transpose = matrix_transpose(sArrSample_matrix, 8, this.f23158n);
        int i5 = this.f23158n;
        short[] sArrSample_matrix2 = sample_matrix(sArrLittleEndianToShort, i5 * 8, i5, 8);
        int i6 = this.f23158n;
        byte[] bArrM17562pack = m17562pack(matrix_add(matrix_mul(sArrGenMatrix, i6, i6, sArrMatrix_transpose, 8), sArrSample_matrix2, this.f23158n, 8));
        System.arraycopy(bArr4, 0, bArr, 0, 16);
        System.arraycopy(bArrM17562pack, 0, bArr, 16, this.len_pk_bytes - 16);
        int i7 = this.len_pkh_bytes;
        byte[] bArr6 = new byte[i7];
        this.f23151digest.mo14970update(bArr, 0, bArr.length);
        this.f23151digest.mo14998doFinal(bArr6, 0, i7);
        System.arraycopy(bArrCopyOfRange, 0, bArr2, 0, this.len_s_bytes);
        System.arraycopy(bArr, 0, bArr2, this.len_s_bytes, this.len_pk_bytes);
        AbstractC6245Pack.shortToLittleEndian(sArrSample_matrix, bArr2, this.len_s_bytes + this.len_pk_bytes);
        int i8 = this.len_sk_bytes;
        int i9 = this.len_pkh_bytes;
        System.arraycopy(bArr6, 0, bArr2, i8 - i9, i9);
    }
}
