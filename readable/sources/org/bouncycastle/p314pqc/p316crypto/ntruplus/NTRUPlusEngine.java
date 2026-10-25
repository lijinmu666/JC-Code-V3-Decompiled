package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class NTRUPlusEngine {

    /* renamed from: OMEGA */
    private static final short f23388OMEGA = -886;

    /* renamed from: Q */
    private static final short f23389Q = 3457;

    /* renamed from: QINV */
    private static final short f23390QINV = 12929;
    private static final short QMinus1_Half = 1728;
    private static final short QPlus1_Half = 1729;

    /* renamed from: Q_HALF */
    private static final short f23391Q_HALF = 1728;

    /* renamed from: RINV */
    private static final short f23392RINV = -682;

    /* renamed from: RSQ */
    private static final short f23393RSQ = 867;

    /* renamed from: SSBytes */
    static final int f23394SSBytes = 32;

    /* renamed from: V */
    private static final short f23395V = 19412;
    private static final byte hash_f_domain = 0;
    private static final byte hash_g_domain = 1;
    private static final byte hash_h_domain = 2;
    private final int blockSize;
    private final int doubleBlockSize;

    /* renamed from: eighthN */
    private final int f23396eighthN;

    /* renamed from: halfN */
    private final int f23397halfN;

    /* renamed from: n */
    private final int f23398n;

    /* renamed from: params */
    private final NTRUPlusParameters f23399params;
    public short polyBytes;
    private final int quarterN;
    private final SHAKEDigest shakeDigest = new SHAKEDigest(256);
    private final int zetaOffset;

    /* renamed from: zetas */
    public short[] f23400zetas;

    public NTRUPlusEngine(NTRUPlusParameters nTRUPlusParameters) {
        this.f23399params = nTRUPlusParameters;
        int iM17774getN = nTRUPlusParameters.m17774getN();
        this.f23398n = iM17774getN;
        this.f23397halfN = iM17774getN >> 1;
        this.quarterN = iM17774getN >> 2;
        this.f23396eighthN = iM17774getN >> 3;
        int i = iM17774getN == 864 ? 3 : 4;
        this.blockSize = i;
        this.doubleBlockSize = i << 1;
        this.zetaOffset = nTRUPlusParameters.getZetasOffset();
        this.polyBytes = (short) nTRUPlusParameters.getPublicKeyBytes();
        this.f23400zetas = nTRUPlusParameters.getZetas();
    }

    private int baseinv3(short[] sArr, int i, short[] sArr2, int i2, short s) {
        short s2 = sArr2[i2];
        short s3 = sArr2[i2 + 1];
        short s4 = sArr2[i2 + 2];
        short sMontgomery_reduce = montgomery_reduce(s3 * s4);
        short sMontgomery_reduce2 = montgomery_reduce(s4 * s4);
        short sMontgomery_reduce3 = montgomery_reduce((s3 * s3) - (s2 * s4));
        short sMontgomery_reduce4 = montgomery_reduce((s2 * s2) - (sMontgomery_reduce * s));
        short sMontgomery_reduce5 = montgomery_reduce((sMontgomery_reduce2 * s) - (s2 * s3));
        short sMontgomery_reduce6 = montgomery_reduce((montgomery_reduce((s3 * sMontgomery_reduce3) + (s4 * sMontgomery_reduce5)) * s) + (s2 * sMontgomery_reduce4));
        if (sMontgomery_reduce6 == 0) {
            return 1;
        }
        short sMontgomery_reduce7 = montgomery_reduce(m17772fqinv(sMontgomery_reduce6) * f23392RINV);
        sArr[i] = montgomery_reduce(sMontgomery_reduce4 * sMontgomery_reduce7);
        sArr[i + 1] = montgomery_reduce(sMontgomery_reduce5 * sMontgomery_reduce7);
        sArr[i + 2] = montgomery_reduce(sMontgomery_reduce3 * sMontgomery_reduce7);
        return 0;
    }

    /* renamed from: basemul */
    private void m17768basemul(short[] sArr, int i, short[] sArr2, int i2, short[] sArr3, int i3, short s) {
        multiplyCore(sArr, i, sArr2, i2, sArr3, i3, s, this.blockSize);
        finalizeMultiplication(sArr, i, this.blockSize);
    }

    private void basemul_add(short[] sArr, int i, short[] sArr2, int i2, short[] sArr3, int i3, short[] sArr4, int i4, short s, int i5) {
        multiplyCore(sArr, i, sArr2, i2, sArr3, i3, s, i5);
        finalizeWithAddition(sArr, i, sArr4, i4, i5);
    }

    /* renamed from: cmov */
    public static void m17769cmov(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int i4 = (i3 - 1) & 255;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5];
            bArr[i5] = (byte) (i6 ^ ((bArr2[i5 + i] ^ i6) & i4));
        }
    }

    private short crepmod3(short s) {
        short s2 = (short) (((short) (s + ((short) (((s >> 15) & 3457) - 1729)))) + ((short) (((r0 >> 15) & 3457) - 1728)));
        return (short) (s2 - ((short) (((short) (((s2 * 10923) + 16384) >> 15)) * 3)));
    }

    private void finalizeMultiplication(short[] sArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            sArr[i] = montgomery_reduce(sArr[i] * f23393RSQ);
            i3++;
            i++;
        }
    }

    private void finalizeWithAddition(short[] sArr, int i, short[] sArr2, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i2 + 1;
            sArr[i] = montgomery_reduce((sArr2[i2] * PKIFailureInfo.notAuthorized) + (sArr[i] * f23393RSQ));
            i4++;
            i2 = i5;
            i++;
        }
    }

    private void multiplyCore(short[] sArr, int i, short[] sArr2, int i2, short[] sArr3, int i3, short s, int i4) {
        short s2 = sArr2[i2];
        short s3 = sArr2[i2 + 1];
        short s4 = sArr2[i2 + 2];
        short s5 = sArr3[i3];
        short s6 = sArr3[i3 + 1];
        short s7 = sArr3[i3 + 2];
        if (i4 == 4) {
            short s8 = sArr2[i2 + 3];
            short s9 = sArr3[i3 + 3];
            sArr[i] = montgomery_reduce((s3 * s9) + (s4 * s7) + (s8 * s6));
            sArr[i + 1] = montgomery_reduce((s4 * s9) + (s8 * s7));
            sArr[i + 2] = montgomery_reduce((montgomery_reduce(s8 * s9) * s) + (s2 * s7) + (s3 * s6) + (s4 * s5));
            sArr[i + 3] = montgomery_reduce((s9 * s2) + (s7 * s3) + (s4 * s6) + (s8 * s5));
        } else {
            sArr[i] = montgomery_reduce((s4 * s6) + (s3 * s7));
            sArr[i + 1] = montgomery_reduce(s4 * s7);
            sArr[i + 2] = montgomery_reduce((s4 * s5) + (s3 * s6) + (s7 * s2));
        }
        sArr[i] = montgomery_reduce((sArr[i] * s) + (s2 * s5));
        int i5 = i + 1;
        sArr[i5] = montgomery_reduce((sArr[i5] * s) + (s2 * s6) + (s3 * s5));
    }

    private int poly_baseinv(short[] sArr, short[] sArr2) {
        if (this.f23398n == 864) {
            int i = this.zetaOffset;
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f23398n / 6) {
                if (baseinv3(sArr, i3, sArr2, i3, this.f23400zetas[i]) == 1) {
                    C6238Arrays.m18260fill(sArr, (short) 0);
                    return 1;
                }
                int i4 = i3 + 3;
                if (baseinv3(sArr, i4, sArr2, i4, (short) (-this.f23400zetas[i])) == 1) {
                    C6238Arrays.m18260fill(sArr, (short) 0);
                    return 1;
                }
                i2++;
                i3 += 6;
                i++;
            }
        } else {
            int i5 = this.zetaOffset;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.f23396eighthN) {
                if (m17771baseinv(sArr, i7, sArr2, i7, this.f23400zetas[i5]) == 1) {
                    C6238Arrays.m18260fill(sArr, (short) 0);
                    return 1;
                }
                int i8 = i7 + 4;
                if (m17771baseinv(sArr, i8, sArr2, i8, (short) (-this.f23400zetas[i5])) == 1) {
                    C6238Arrays.m18260fill(sArr, (short) 0);
                    return 1;
                }
                i6++;
                i7 += 8;
                i5++;
            }
        }
        return 0;
    }

    private void poly_basemul(short[] sArr, short[] sArr2, short[] sArr3) {
        int i = 0;
        while (true) {
            int i2 = this.f23398n;
            int i3 = this.doubleBlockSize;
            if (i >= i2 / i3) {
                return;
            }
            m17768basemul(sArr, i3 * i, sArr2, i3 * i, sArr3, i3 * i, this.f23400zetas[this.zetaOffset + i]);
            int i4 = this.doubleBlockSize;
            int i5 = this.blockSize;
            m17768basemul(sArr, (i4 * i) + i5, sArr2, (i4 * i) + i5, sArr3, (i4 * i) + i5, (short) (-this.f23400zetas[this.zetaOffset + i]));
            i++;
        }
    }

    private void poly_basemul_add(short[] sArr, short[] sArr2, short[] sArr3, short[] sArr4) {
        int i = this.zetaOffset;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f23398n / this.doubleBlockSize) {
            basemul_add(sArr, i3, sArr2, i3, sArr3, i3, sArr4, i3, this.f23400zetas[i], this.blockSize);
            int i4 = this.blockSize;
            int i5 = i3 + i4;
            basemul_add(sArr, i5, sArr2, i5, sArr3, i5, sArr4, i5, (short) (-this.f23400zetas[i]), i4);
            i3 = i5 + this.blockSize;
            i2++;
            i++;
        }
    }

    private void poly_cbd1(short[] sArr, byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = this.f23396eighthN;
            if (i2 >= i4) {
                return;
            }
            int i5 = i + i2;
            int i6 = bArr[i5] & C1126UByte.MAX_VALUE;
            int i7 = bArr[i5 + i4] & C1126UByte.MAX_VALUE;
            for (int i8 = 0; i8 < 8; i8++) {
                sArr[i3 + i8] = (short) ((i6 & 1) - (i7 & 1));
                i6 >>= 1;
                i7 >>= 1;
            }
            i2++;
            i3 += 8;
        }
    }

    private void poly_crepmod3(short[] sArr, short[] sArr2) {
        for (int i = 0; i < this.f23398n; i++) {
            sArr[i] = crepmod3(sArr2[i]);
        }
    }

    private void poly_frombytes(short[] sArr, byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f23397halfN) {
            int i4 = i3 + 1;
            int i5 = bArr[i] & C1126UByte.MAX_VALUE;
            byte b = bArr[i + 1];
            sArr[i3] = (short) ((i5 | ((b & C1126UByte.MAX_VALUE) << 8)) & 4095);
            i3 += 2;
            sArr[i4] = (short) ((((b & C1126UByte.MAX_VALUE) >> 4) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 4)) & 4095);
            i2++;
            i += 3;
        }
    }

    private void poly_invntt(short[] sArr) {
        short s;
        short s2;
        int i;
        if (this.f23398n == 768) {
            s = -811;
            s2 = -1622;
            i = 191;
        } else {
            s = -1693;
            s2 = 71;
            i = 287;
        }
        int baseStep = this.f23399params.getBaseStep();
        for (int minStep = this.f23399params.getMinStep(); minStep <= baseStep; minStep <<= 1) {
            int i2 = 0;
            while (i2 < this.f23398n) {
                int i3 = i - 1;
                short s3 = this.f23400zetas[i];
                int i4 = i2 + minStep;
                int i5 = i2;
                int i6 = i4;
                while (i5 < i4) {
                    short s4 = sArr[i6];
                    sArr[i6] = m17773fqmul(s3, (short) (s4 - sArr[i5]));
                    sArr[i5] = barrett_reduce((short) (sArr[i5] + s4));
                    i5++;
                    i6++;
                }
                i2 += minStep << 1;
                i = i3;
            }
        }
        for (int i7 = baseStep << 1; i7 <= this.f23398n / 6; i7 *= 3) {
            int i8 = i7 << 1;
            for (int i9 = 0; i9 < this.f23398n; i9 += i7 * 3) {
                short[] sArr2 = this.f23400zetas;
                int i10 = i - 1;
                short s5 = sArr2[i];
                i -= 2;
                short s6 = sArr2[i10];
                int i11 = i9 + i7;
                int i12 = i9 + i8;
                int i13 = i9;
                int i14 = i11;
                while (i13 < i11) {
                    short sM17773fqmul = m17773fqmul(f23388OMEGA, (short) (sArr[i14] - sArr[i13]));
                    short sM17773fqmul2 = m17773fqmul(s6, (short) ((sArr[i12] - sArr[i13]) + sM17773fqmul));
                    short sM17773fqmul3 = m17773fqmul(s5, (short) ((sArr[i12] - sArr[i14]) - sM17773fqmul));
                    sArr[i13] = barrett_reduce((short) (sArr[i13] + sArr[i14] + sArr[i12]));
                    sArr[i14] = sM17773fqmul2;
                    sArr[i12] = sM17773fqmul3;
                    i13++;
                    i14++;
                    i12++;
                }
            }
        }
        int i15 = 0;
        while (true) {
            int i16 = this.f23397halfN;
            if (i15 >= i16) {
                return;
            }
            short s7 = sArr[i15];
            short s8 = (short) (sArr[i15 + i16] + s7);
            short sM17773fqmul4 = m17773fqmul((short) -1665, (short) (s7 - sArr[i16 + i15]));
            sArr[i15] = m17773fqmul(s, (short) (s8 - sM17773fqmul4));
            sArr[this.f23397halfN + i15] = m17773fqmul(s2, sM17773fqmul4);
            i15++;
        }
    }

    private void poly_ntt(short[] sArr) {
        short s = this.f23400zetas[1];
        int i = this.f23397halfN;
        int i2 = 0;
        while (i2 < this.f23397halfN) {
            short sM17773fqmul = m17773fqmul(s, sArr[i]);
            sArr[i] = (short) ((sArr[i2] + sArr[i]) - sM17773fqmul);
            sArr[i2] = (short) (sArr[i2] + sM17773fqmul);
            i2++;
            i++;
        }
        int baseStep = this.f23399params.getBaseStep();
        int minStep = this.f23399params.getMinStep();
        int i3 = 2;
        for (int i4 = this.f23398n / 6; i4 >= (baseStep << 1); i4 /= 3) {
            int i5 = i4 << 1;
            int i6 = i5 + i4;
            for (int i7 = 0; i7 < this.f23398n; i7 += i6) {
                short[] sArr2 = this.f23400zetas;
                int i8 = i3 + 1;
                short s2 = sArr2[i3];
                i3 += 2;
                short s3 = sArr2[i8];
                int i9 = i7 + i4;
                int i10 = i7 + i5;
                int i11 = i7;
                int i12 = i9;
                while (i11 < i9) {
                    short sM17773fqmul2 = m17773fqmul(s2, sArr[i12]);
                    short sM17773fqmul3 = m17773fqmul(s3, sArr[i10]);
                    int i13 = baseStep;
                    short sM17773fqmul4 = m17773fqmul(f23388OMEGA, (short) (sM17773fqmul2 - sM17773fqmul3));
                    sArr[i10] = (short) ((sArr[i11] - sM17773fqmul2) - sM17773fqmul4);
                    sArr[i12] = (short) ((sArr[i11] - sM17773fqmul3) + sM17773fqmul4);
                    sArr[i11] = (short) (sArr[i11] + sM17773fqmul2 + sM17773fqmul3);
                    i11++;
                    i12++;
                    i10++;
                    baseStep = i13;
                    i3 = i3;
                }
            }
        }
        while (baseStep >= minStep) {
            int i14 = 0;
            while (i14 < this.f23398n) {
                int i15 = i3 + 1;
                short s4 = this.f23400zetas[i3];
                int i16 = i14 + baseStep;
                int i17 = i14;
                int i18 = i16;
                while (i17 < i16) {
                    short sM17773fqmul5 = m17773fqmul(s4, sArr[i18]);
                    sArr[i18] = barrett_reduce((short) (sArr[i17] - sM17773fqmul5));
                    sArr[i17] = barrett_reduce((short) (sArr[i17] + sM17773fqmul5));
                    i17++;
                    i18++;
                }
                i14 += baseStep << 1;
                i3 = i15;
            }
            baseStep >>= 1;
        }
    }

    private int poly_sotp_decode(byte[] bArr, short[] sArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.f23396eighthN;
            if (i >= i3) {
                break;
            }
            int i4 = bArr2[i] & C1126UByte.MAX_VALUE;
            int i5 = bArr2[i3 + i] & C1126UByte.MAX_VALUE;
            byte b = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                int i7 = (i5 & 1) + sArr[(i * 8) + i6];
                i2 |= i7;
                b = (byte) (b ^ ((byte) (((i7 ^ i4) & 1) << i6)));
                i4 >>= 1;
                i5 >>= 1;
            }
            bArr[i] = b;
            i++;
        }
        int i8 = (-(i2 >> 1)) >> 31;
        byte b2 = (byte) (i8 - 1);
        for (int i9 = 0; i9 < this.f23396eighthN; i9++) {
            bArr[i9] = (byte) (bArr[i9] & b2);
        }
        return i8;
    }

    private void poly_sotp_encode(short[] sArr, byte[] bArr, byte[] bArr2) {
        C6240Bytes.m18281xorTo(this.f23396eighthN, bArr, bArr2);
        poly_cbd1(sArr, bArr2, 0);
    }

    private void poly_sub(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < this.f23398n; i++) {
            sArr[i] = (short) (sArr2[i] - sArr3[i]);
        }
    }

    private void shake256(byte[] bArr, int i, int i2, byte b, byte[] bArr2, int i3, int i4) {
        this.shakeDigest.mo14969update(b);
        this.shakeDigest.mo14970update(bArr2, i3, i4);
        this.shakeDigest.mo14998doFinal(bArr, i, i2);
    }

    /* renamed from: verify */
    private int m17770verify(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 |= (bArr[i3] ^ bArr2[i3]) & 255;
        }
        return i2 != 0 ? 1 : 0;
    }

    public short barrett_reduce(short s) {
        return (short) (s - ((((s * f23395V) + AdbProtocol.INITIAL_DELAYED_ACK_BYTES) >> 26) * 3457));
    }

    /* renamed from: baseinv */
    public int m17771baseinv(short[] sArr, int i, short[] sArr2, int i2, short s) {
        short s2 = sArr2[i2];
        short s3 = sArr2[i2 + 1];
        short s4 = sArr2[i2 + 2];
        short s5 = sArr2[i2 + 3];
        short sMontgomery_reduce = montgomery_reduce((s4 * s4) - ((s3 * 2) * s5));
        short sMontgomery_reduce2 = montgomery_reduce(s5 * s5);
        short sMontgomery_reduce3 = montgomery_reduce((s2 * s2) + (sMontgomery_reduce * s));
        short sMontgomery_reduce4 = montgomery_reduce(((s3 * s3) + (sMontgomery_reduce2 * s)) - ((s2 * 2) * s4));
        short sMontgomery_reduce5 = montgomery_reduce(s * sMontgomery_reduce4);
        short sMontgomery_reduce6 = montgomery_reduce((sMontgomery_reduce3 * sMontgomery_reduce3) - (sMontgomery_reduce4 * sMontgomery_reduce5));
        if (sMontgomery_reduce6 == 0) {
            return 1;
        }
        short sMontgomery_reduce7 = montgomery_reduce((s2 * sMontgomery_reduce3) + (s4 * sMontgomery_reduce5));
        short sMontgomery_reduce8 = montgomery_reduce((sMontgomery_reduce5 * s5) + (s3 * sMontgomery_reduce3));
        short sMontgomery_reduce9 = montgomery_reduce((s4 * sMontgomery_reduce3) + (s2 * sMontgomery_reduce4));
        short sMontgomery_reduce10 = montgomery_reduce((s3 * sMontgomery_reduce4) + (s5 * sMontgomery_reduce3));
        short sMontgomery_reduce11 = montgomery_reduce(m17772fqinv(sMontgomery_reduce6) * f23392RINV);
        sArr[i] = montgomery_reduce(sMontgomery_reduce7 * sMontgomery_reduce11);
        sArr[i + 1] = (short) (-montgomery_reduce(sMontgomery_reduce8 * sMontgomery_reduce11));
        sArr[i + 2] = montgomery_reduce(sMontgomery_reduce9 * sMontgomery_reduce11);
        sArr[i + 3] = (short) (-montgomery_reduce(sMontgomery_reduce10 * sMontgomery_reduce11));
        return 0;
    }

    public void crypto_kem_dec(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4 = this.f23396eighthN + 32;
        byte[] bArr4 = new byte[i4];
        int i5 = this.polyBytes;
        byte[] bArr5 = new byte[i5];
        byte[] bArr6 = new byte[i5];
        int i6 = i5 + 32;
        byte[] bArr7 = new byte[i6];
        int i7 = this.f23398n;
        short[] sArr = new short[i7];
        short[] sArr2 = new short[i7];
        short[] sArr3 = new short[i7];
        short[] sArr4 = new short[i7];
        short[] sArr5 = new short[i7];
        short[] sArr6 = new short[i7];
        short[] sArr7 = new short[i7];
        poly_frombytes(sArr, bArr2, i2);
        poly_frombytes(sArr2, bArr3, i3);
        poly_frombytes(sArr3, bArr3, this.polyBytes + i3);
        poly_basemul(sArr6, sArr, sArr2);
        poly_invntt(sArr6);
        poly_crepmod3(sArr6, sArr6);
        System.arraycopy(sArr6, 0, sArr7, 0, this.f23398n);
        poly_ntt(sArr7);
        poly_sub(sArr, sArr, sArr7);
        poly_basemul(sArr5, sArr, sArr3);
        poly_tobytes(bArr5, 0, sArr5);
        shake256(bArr6, 0, this.quarterN, (byte) 1, bArr5, 0, this.polyBytes);
        int iPoly_sotp_decode = poly_sotp_decode(bArr4, sArr6, bArr6);
        System.arraycopy(bArr3, (this.polyBytes * 2) + i3, bArr4, this.f23396eighthN, 32);
        shake256(bArr7, 0, i6, (byte) 2, bArr4, 0, i4);
        poly_cbd1(sArr4, bArr7, 32);
        poly_ntt(sArr4);
        poly_tobytes(bArr6, 0, sArr4);
        m17769cmov(bArr, bArr7, i, 32, m17770verify(bArr5, bArr6, this.polyBytes) | iPoly_sotp_decode);
    }

    public void crypto_kem_enc_derand(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, byte[] bArr4, int i4) {
        int i5 = this.f23396eighthN;
        int i6 = i5 + 32;
        byte[] bArr5 = new byte[i6];
        int i7 = this.quarterN + 32;
        byte[] bArr6 = new byte[i7];
        byte[] bArr7 = new byte[this.polyBytes];
        int i8 = this.f23398n;
        short[] sArr = new short[i8];
        short[] sArr2 = new short[i8];
        short[] sArr3 = new short[i8];
        short[] sArr4 = new short[i8];
        System.arraycopy(bArr4, i4, bArr5, 0, i5);
        shake256(bArr5, this.f23396eighthN, 32, (byte) 0, bArr3, i3, this.polyBytes);
        shake256(bArr6, 0, i7, (byte) 2, bArr5, 0, i6);
        poly_cbd1(sArr3, bArr6, 32);
        poly_ntt(sArr3);
        poly_tobytes(bArr7, 0, sArr3);
        shake256(bArr7, 0, this.quarterN, (byte) 1, bArr7, 0, this.polyBytes);
        poly_sotp_encode(sArr4, bArr5, bArr7);
        poly_ntt(sArr4);
        poly_frombytes(sArr2, bArr3, i3);
        poly_basemul_add(sArr, sArr2, sArr3, sArr4);
        poly_tobytes(bArr, i, sArr);
        System.arraycopy(bArr6, 0, bArr2, i2, 32);
    }

    public void crypto_kem_keypair_derand(byte[] bArr, byte[] bArr2, short[] sArr, short[] sArr2, short[] sArr3, short[] sArr4) {
        int i = this.f23398n;
        short[] sArr5 = new short[i];
        short[] sArr6 = new short[i];
        poly_basemul(sArr5, sArr3, sArr2);
        poly_basemul(sArr6, sArr, sArr4);
        poly_tobytes(bArr, 0, sArr5);
        poly_tobytes(bArr2, 0, sArr);
        poly_tobytes(bArr2, this.polyBytes, sArr6);
        short s = this.polyBytes;
        shake256(bArr2, s << 1, 32, (byte) 0, bArr, 0, s);
    }

    /* renamed from: fqinv */
    public short m17772fqinv(short s) {
        short sM17773fqmul = m17773fqmul(s, s);
        short sM17773fqmul2 = m17773fqmul(sM17773fqmul, sM17773fqmul);
        short sM17773fqmul3 = m17773fqmul(sM17773fqmul2, sM17773fqmul2);
        short sM17773fqmul4 = m17773fqmul(sM17773fqmul3, sM17773fqmul3);
        short sM17773fqmul5 = m17773fqmul(sM17773fqmul, sM17773fqmul3);
        short sM17773fqmul6 = m17773fqmul(sM17773fqmul5, sM17773fqmul4);
        short sM17773fqmul7 = m17773fqmul(m17773fqmul(sM17773fqmul6, sM17773fqmul6), s);
        short sM17773fqmul8 = m17773fqmul(sM17773fqmul5, sM17773fqmul7);
        short sM17773fqmul9 = m17773fqmul(sM17773fqmul7, sM17773fqmul7);
        short sM17773fqmul10 = m17773fqmul(sM17773fqmul9, sM17773fqmul9);
        short sM17773fqmul11 = m17773fqmul(sM17773fqmul10, sM17773fqmul10);
        short sM17773fqmul12 = m17773fqmul(sM17773fqmul11, sM17773fqmul11);
        short sM17773fqmul13 = m17773fqmul(sM17773fqmul12, sM17773fqmul12);
        return m17773fqmul(m17773fqmul(sM17773fqmul13, sM17773fqmul13), sM17773fqmul8);
    }

    /* renamed from: fqmul */
    public short m17773fqmul(short s, short s2) {
        return montgomery_reduce(s * s2);
    }

    public int genf_derand(short[] sArr, short[] sArr2, byte[] bArr) {
        int i = this.quarterN;
        byte[] bArr2 = new byte[i];
        shake256(bArr2, 0, i, bArr, 32);
        poly_cbd1(sArr, bArr2, 0);
        poly_triple(sArr, sArr);
        sArr[0] = (short) (sArr[0] + 1);
        poly_ntt(sArr);
        return poly_baseinv(sArr2, sArr);
    }

    public int geng_derand(short[] sArr, short[] sArr2, byte[] bArr) {
        int i = this.quarterN;
        byte[] bArr2 = new byte[i];
        shake256(bArr2, 0, i, bArr, 32);
        poly_cbd1(sArr, bArr2, 0);
        poly_triple(sArr, sArr);
        poly_ntt(sArr);
        return poly_baseinv(sArr2, sArr);
    }

    public short montgomery_reduce(int i) {
        return (short) ((i - (((short) (i * 12929)) * f23389Q)) >> 16);
    }

    public void poly_tobytes(byte[] bArr, int i, short[] sArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f23397halfN; i3++) {
            int i4 = i2 + 1;
            short s = sArr[i2];
            int i5 = s + ((s >> 15) & 3457);
            i2 += 2;
            short s2 = sArr[i4];
            int i6 = s2 + ((s2 >> 15) & 3457);
            bArr[i] = (byte) i5;
            int i7 = i + 2;
            bArr[i + 1] = (byte) ((i5 >> 8) | (i6 << 4));
            i += 3;
            bArr[i7] = (byte) (i6 >> 4);
        }
    }

    public void poly_triple(short[] sArr, short[] sArr2) {
        for (int i = 0; i < this.f23398n; i++) {
            sArr[i] = (short) (sArr2[i] * 3);
        }
    }

    public void shake256(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.shakeDigest.mo14970update(bArr2, 0, i3);
        this.shakeDigest.mo14998doFinal(bArr, i, i2);
    }
}
