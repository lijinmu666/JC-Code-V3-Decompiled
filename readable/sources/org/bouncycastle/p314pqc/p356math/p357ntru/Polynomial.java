package org.bouncycastle.p314pqc.p356math.p357ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public abstract class Polynomial {

    /* renamed from: coeffs */
    public short[] f24144coeffs;

    /* renamed from: params */
    protected NTRUParameterSet f24145params;

    public Polynomial(NTRUParameterSet nTRUParameterSet) {
        this.f24144coeffs = new short[nTRUParameterSet.m18201n()];
        this.f24145params = nTRUParameterSet;
    }

    public static short bothNegativeMask(short s, short s2) {
        return (short) ((s & s2) >>> 15);
    }

    /* renamed from: mod3 */
    public static byte m18185mod3(byte b) {
        return (byte) ((b & C1126UByte.MAX_VALUE) % 3);
    }

    /* renamed from: modQ */
    public static int m18187modQ(int i, int i2) {
        return i % i2;
    }

    private void r2InvToRqInv(Polynomial polynomial, Polynomial polynomial2, Polynomial polynomial3, Polynomial polynomial4, Polynomial polynomial5) {
        int length = this.f24144coeffs.length;
        for (int i = 0; i < length; i++) {
            polynomial3.f24144coeffs[i] = (short) (-polynomial2.f24144coeffs[i]);
        }
        for (int i2 = 0; i2 < length; i2++) {
            this.f24144coeffs[i2] = polynomial.f24144coeffs[i2];
        }
        polynomial4.m18192rqMul(this, polynomial3);
        short[] sArr = polynomial4.f24144coeffs;
        sArr[0] = (short) (sArr[0] + 2);
        polynomial5.m18192rqMul(polynomial4, this);
        polynomial4.m18192rqMul(polynomial5, polynomial3);
        short[] sArr2 = polynomial4.f24144coeffs;
        sArr2[0] = (short) (sArr2[0] + 2);
        m18192rqMul(polynomial4, polynomial5);
        polynomial4.m18192rqMul(this, polynomial3);
        short[] sArr3 = polynomial4.f24144coeffs;
        sArr3[0] = (short) (sArr3[0] + 2);
        polynomial5.m18192rqMul(polynomial4, this);
        polynomial4.m18192rqMul(polynomial5, polynomial3);
        short[] sArr4 = polynomial4.f24144coeffs;
        sArr4[0] = (short) (sArr4[0] + 2);
        m18192rqMul(polynomial4, polynomial5);
    }

    /* renamed from: lift */
    public abstract void mo18184lift(Polynomial polynomial);

    public void mod3PhiN() {
        int iM18201n = this.f24145params.m18201n();
        for (int i = 0; i < iM18201n; i++) {
            short[] sArr = this.f24144coeffs;
            sArr[i] = m18186mod3((short) (sArr[i] + (sArr[iM18201n - 1] * 2)));
        }
    }

    public void modQPhiN() {
        int iM18201n = this.f24145params.m18201n();
        for (int i = 0; i < iM18201n; i++) {
            short[] sArr = this.f24144coeffs;
            sArr[i] = (short) (sArr[i] - sArr[iM18201n - 1]);
        }
    }

    /* renamed from: r2Inv */
    public void m18188r2Inv(Polynomial polynomial) {
        m18189r2Inv(polynomial, this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial());
    }

    /* renamed from: rqInv */
    public void m18190rqInv(Polynomial polynomial) {
        m18191rqInv(polynomial, this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial());
    }

    /* renamed from: rqMul */
    public void m18192rqMul(Polynomial polynomial, Polynomial polynomial2) {
        int i;
        int length = this.f24144coeffs.length;
        int i2 = 0;
        while (i2 < length) {
            this.f24144coeffs[i2] = 0;
            for (int i3 = 1; i3 < length - i2; i3++) {
                short[] sArr = this.f24144coeffs;
                sArr[i2] = (short) (sArr[i2] + (polynomial.f24144coeffs[i2 + i3] * polynomial2.f24144coeffs[length - i3]));
            }
            int i4 = 0;
            while (true) {
                i = i2 + 1;
                if (i4 < i) {
                    short[] sArr2 = this.f24144coeffs;
                    sArr2[i2] = (short) (sArr2[i2] + (polynomial.f24144coeffs[i2 - i4] * polynomial2.f24144coeffs[i4]));
                    i4++;
                }
            }
            i2 = i;
        }
    }

    public void rqSumZeroFromBytes(byte[] bArr) {
        int length = this.f24144coeffs.length;
        sqFromBytes(bArr);
        int i = length - 1;
        this.f24144coeffs[i] = 0;
        for (int i2 = 0; i2 < this.f24145params.packDegree(); i2++) {
            short[] sArr = this.f24144coeffs;
            sArr[i] = (short) (sArr[i] - sArr[i2]);
        }
    }

    public byte[] rqSumZeroToBytes(int i) {
        return sqToBytes(i);
    }

    /* renamed from: rqToS3 */
    public void m18193rqToS3(Polynomial polynomial) {
        int length = this.f24144coeffs.length;
        for (int i = 0; i < length; i++) {
            this.f24144coeffs[i] = (short) m18187modQ(polynomial.f24144coeffs[i] & 65535, this.f24145params.m18202q());
            short sM18200logQ = (short) (this.f24144coeffs[i] >>> (this.f24145params.m18200logQ() - 1));
            short[] sArr = this.f24144coeffs;
            sArr[i] = (short) (sArr[i] + (sM18200logQ << (1 - (this.f24145params.m18200logQ() & 1))));
        }
        mod3PhiN();
    }

    public void s3FromBytes(byte[] bArr) {
        int length = this.f24144coeffs.length;
        for (int i = 0; i < this.f24145params.packDegree() / 5; i++) {
            byte b = bArr[i];
            short[] sArr = this.f24144coeffs;
            int i2 = i * 5;
            sArr[i2] = b;
            int i3 = b & C1126UByte.MAX_VALUE;
            sArr[i2 + 1] = (short) ((i3 * 171) >>> 9);
            sArr[i2 + 2] = (short) ((i3 * 57) >>> 9);
            sArr[i2 + 3] = (short) ((i3 * 19) >>> 9);
            sArr[i2 + 4] = (short) ((i3 * 203) >>> 14);
        }
        if (this.f24145params.packDegree() > (this.f24145params.packDegree() / 5) * 5) {
            int iPackDegree = this.f24145params.packDegree() / 5;
            byte b2 = bArr[iPackDegree];
            int i4 = 0;
            while (true) {
                int i5 = (iPackDegree * 5) + i4;
                if (i5 >= this.f24145params.packDegree()) {
                    break;
                }
                this.f24144coeffs[i5] = b2;
                b2 = (byte) (((b2 & C1126UByte.MAX_VALUE) * 171) >> 9);
                i4++;
            }
        }
        this.f24144coeffs[length - 1] = 0;
        mod3PhiN();
    }

    /* renamed from: s3Inv */
    public void m18194s3Inv(Polynomial polynomial) {
        m18195s3Inv(polynomial, this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial(), this.f24145params.createPolynomial());
    }

    /* renamed from: s3Mul */
    public void m18196s3Mul(Polynomial polynomial, Polynomial polynomial2) {
        m18192rqMul(polynomial, polynomial2);
        mod3PhiN();
    }

    public void s3ToBytes(byte[] bArr, int i) {
        int iPackDegree = this.f24145params.packDegree();
        int i2 = iPackDegree - 5;
        int i3 = 0;
        while (i3 <= i2) {
            short[] sArr = this.f24144coeffs;
            int i4 = sArr[i3] & 255;
            int i5 = (sArr[i3 + 1] & 255) * 3;
            int i6 = (sArr[i3 + 2] & 255) * 9;
            bArr[i] = (byte) (i4 + i5 + i6 + ((sArr[i3 + 3] & 255) * 27) + ((sArr[i3 + 4] & 255) * 81));
            i3 += 5;
            i++;
        }
        if (i3 >= iPackDegree) {
            return;
        }
        int i7 = iPackDegree - 1;
        int i8 = this.f24144coeffs[i7] & 255;
        while (true) {
            i7--;
            if (i7 < i3) {
                bArr[i] = (byte) i8;
                return;
            }
            i8 = (i8 * 3) + (this.f24144coeffs[i7] & 255);
        }
    }

    public abstract void sqFromBytes(byte[] bArr);

    /* renamed from: sqMul */
    public void m18197sqMul(Polynomial polynomial, Polynomial polynomial2) {
        m18192rqMul(polynomial, polynomial2);
        modQPhiN();
    }

    public abstract byte[] sqToBytes(int i);

    public void trinaryZqToZ3() {
        int length = this.f24144coeffs.length;
        for (int i = 0; i < length; i++) {
            short[] sArr = this.f24144coeffs;
            sArr[i] = (short) m18187modQ(sArr[i] & 65535, this.f24145params.m18202q());
            short[] sArr2 = this.f24144coeffs;
            short s = sArr2[i];
            sArr2[i] = (short) ((s ^ (s >>> (this.f24145params.m18200logQ() - 1))) & 3);
        }
    }

    /* renamed from: z3ToZq */
    public void m18198z3ToZq() {
        int length = this.f24144coeffs.length;
        for (int i = 0; i < length; i++) {
            short[] sArr = this.f24144coeffs;
            short s = sArr[i];
            sArr[i] = (short) (s | ((-(s >>> 1)) & (this.f24145params.m18202q() - 1)));
        }
    }

    /* renamed from: mod3 */
    public static short m18186mod3(short s) {
        return (short) ((s & 65535) % 3);
    }

    /* renamed from: r2Inv */
    public void m18189r2Inv(Polynomial polynomial, Polynomial polynomial2, Polynomial polynomial3, Polynomial polynomial4, Polynomial polynomial5) {
        int i;
        int length = this.f24144coeffs.length;
        short s = 0;
        polynomial5.f24144coeffs[0] = 1;
        for (int i2 = 0; i2 < length; i2++) {
            polynomial2.f24144coeffs[i2] = 1;
        }
        int i3 = 0;
        while (true) {
            i = length - 1;
            if (i3 >= i) {
                break;
            }
            short[] sArr = polynomial.f24144coeffs;
            polynomial3.f24144coeffs[(length - 2) - i3] = (short) ((sArr[i] ^ sArr[i3]) & 1);
            i3++;
        }
        polynomial3.f24144coeffs[i] = 0;
        int i4 = 0;
        short s2 = 1;
        for (short s3 = 1; i4 < (i * 2) - s3; s3 = 1) {
            for (int i5 = i; i5 > 0; i5--) {
                short[] sArr2 = polynomial4.f24144coeffs;
                sArr2[i5] = sArr2[i5 - 1];
            }
            polynomial4.f24144coeffs[s] = s;
            short s4 = polynomial3.f24144coeffs[s];
            short s5 = (short) (polynomial2.f24144coeffs[s] & s4);
            int i6 = -s2;
            short sBothNegativeMask = bothNegativeMask((short) i6, (short) (-s4));
            s2 = (short) (((short) (s2 ^ ((i6 ^ s2) & sBothNegativeMask))) + s3);
            for (int i7 = s; i7 < length; i7++) {
                short[] sArr3 = polynomial2.f24144coeffs;
                short s6 = sArr3[i7];
                short[] sArr4 = polynomial3.f24144coeffs;
                short s7 = (short) (sBothNegativeMask & (s6 ^ sArr4[i7]));
                sArr3[i7] = (short) (s6 ^ s7);
                sArr4[i7] = (short) (s7 ^ sArr4[i7]);
                short[] sArr5 = polynomial4.f24144coeffs;
                short s8 = sArr5[i7];
                short[] sArr6 = polynomial5.f24144coeffs;
                short s9 = (short) ((sArr6[i7] ^ s8) & sBothNegativeMask);
                sArr5[i7] = (short) (s8 ^ s9);
                sArr6[i7] = (short) (sArr6[i7] ^ s9);
            }
            for (int i8 = 0; i8 < length; i8++) {
                short[] sArr7 = polynomial3.f24144coeffs;
                sArr7[i8] = (short) (sArr7[i8] ^ (polynomial2.f24144coeffs[i8] & s5));
            }
            for (int i9 = 0; i9 < length; i9++) {
                short[] sArr8 = polynomial5.f24144coeffs;
                sArr8[i9] = (short) (sArr8[i9] ^ (polynomial4.f24144coeffs[i9] & s5));
            }
            int i10 = 0;
            while (i10 < i) {
                short[] sArr9 = polynomial3.f24144coeffs;
                int i11 = i10 + 1;
                sArr9[i10] = sArr9[i11];
                i10 = i11;
            }
            polynomial3.f24144coeffs[i] = 0;
            i4++;
            s = 0;
        }
        for (int i12 = 0; i12 < i; i12++) {
            this.f24144coeffs[i12] = polynomial4.f24144coeffs[(length - 2) - i12];
        }
        this.f24144coeffs[i] = 0;
    }

    /* renamed from: rqInv */
    public void m18191rqInv(Polynomial polynomial, Polynomial polynomial2, Polynomial polynomial3, Polynomial polynomial4, Polynomial polynomial5) {
        polynomial2.m18188r2Inv(polynomial);
        r2InvToRqInv(polynomial2, polynomial, polynomial3, polynomial4, polynomial5);
    }

    /* renamed from: s3Inv */
    public void m18195s3Inv(Polynomial polynomial, Polynomial polynomial2, Polynomial polynomial3, Polynomial polynomial4, Polynomial polynomial5) {
        int i;
        int length = this.f24144coeffs.length;
        short s = 0;
        polynomial5.f24144coeffs[0] = 1;
        for (int i2 = 0; i2 < length; i2++) {
            polynomial2.f24144coeffs[i2] = 1;
        }
        int i3 = 0;
        while (true) {
            i = length - 1;
            if (i3 >= i) {
                break;
            }
            short[] sArr = polynomial.f24144coeffs;
            polynomial3.f24144coeffs[(length - 2) - i3] = m18186mod3((short) ((sArr[i3] & 3) + ((sArr[i] & 3) * 2)));
            i3++;
        }
        polynomial3.f24144coeffs[i] = 0;
        int i4 = 0;
        short s2 = 1;
        for (short s3 = 1; i4 < (i * 2) - s3; s3 = 1) {
            for (int i5 = i; i5 > 0; i5--) {
                short[] sArr2 = polynomial4.f24144coeffs;
                sArr2[i5] = sArr2[i5 - 1];
            }
            polynomial4.f24144coeffs[s] = s;
            short sM18185mod3 = m18185mod3((byte) (polynomial3.f24144coeffs[s] * 2 * polynomial2.f24144coeffs[s]));
            int i6 = -s2;
            short sBothNegativeMask = bothNegativeMask((short) i6, (short) (-polynomial3.f24144coeffs[s]));
            s2 = (short) (((short) (s2 ^ ((i6 ^ s2) & sBothNegativeMask))) + s3);
            for (int i7 = s; i7 < length; i7++) {
                short[] sArr3 = polynomial2.f24144coeffs;
                short s4 = sArr3[i7];
                short[] sArr4 = polynomial3.f24144coeffs;
                short s5 = (short) (sBothNegativeMask & (s4 ^ sArr4[i7]));
                sArr3[i7] = (short) (s4 ^ s5);
                sArr4[i7] = (short) (s5 ^ sArr4[i7]);
                short[] sArr5 = polynomial4.f24144coeffs;
                short s6 = sArr5[i7];
                short[] sArr6 = polynomial5.f24144coeffs;
                short s7 = (short) ((sArr6[i7] ^ s6) & sBothNegativeMask);
                sArr5[i7] = (short) (s6 ^ s7);
                sArr6[i7] = (short) (sArr6[i7] ^ s7);
            }
            for (int i8 = 0; i8 < length; i8++) {
                polynomial3.f24144coeffs[i8] = m18185mod3((byte) (r8[i8] + (polynomial2.f24144coeffs[i8] * sM18185mod3)));
            }
            for (int i9 = 0; i9 < length; i9++) {
                polynomial5.f24144coeffs[i9] = m18185mod3((byte) (r8[i9] + (polynomial4.f24144coeffs[i9] * sM18185mod3)));
            }
            int i10 = 0;
            while (i10 < i) {
                short[] sArr7 = polynomial3.f24144coeffs;
                int i11 = i10 + 1;
                sArr7[i10] = sArr7[i11];
                i10 = i11;
            }
            polynomial3.f24144coeffs[i] = 0;
            i4++;
            s = 0;
        }
        short s8 = polynomial2.f24144coeffs[s];
        for (int i12 = 0; i12 < i; i12++) {
            this.f24144coeffs[i12] = m18185mod3((byte) (polynomial4.f24144coeffs[(length - 2) - i12] * s8));
        }
        this.f24144coeffs[i] = 0;
    }

    public byte[] s3ToBytes(int i) {
        byte[] bArr = new byte[i];
        s3ToBytes(bArr, 0);
        return bArr;
    }
}
