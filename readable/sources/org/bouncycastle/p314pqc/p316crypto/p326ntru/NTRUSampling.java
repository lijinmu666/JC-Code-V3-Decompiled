package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import java.util.Arrays;
import org.bouncycastle.p314pqc.p356math.p357ntru.HPSPolynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.HRSSPolynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPSParameterSet;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSSParameterSet;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class NTRUSampling {

    /* renamed from: params */
    private final NTRUParameterSet f23383params;

    public NTRUSampling(NTRUParameterSet nTRUParameterSet) {
        this.f23383params = nTRUParameterSet;
    }

    /* renamed from: mod3 */
    private static int m17763mod3(int i) {
        return i % 3;
    }

    public PolynomialPair sampleFg(byte[] bArr) {
        NTRUParameterSet nTRUParameterSet = this.f23383params;
        if (nTRUParameterSet instanceof NTRUHRSSParameterSet) {
            return new PolynomialPair(sampleIidPlus(C6238Arrays.copyOfRange(bArr, 0, nTRUParameterSet.sampleIidBytes())), sampleIidPlus(C6238Arrays.copyOfRange(bArr, this.f23383params.sampleIidBytes(), bArr.length)));
        }
        if (nTRUParameterSet instanceof NTRUHPSParameterSet) {
            return new PolynomialPair((HPSPolynomial) sampleIid(C6238Arrays.copyOfRange(bArr, 0, nTRUParameterSet.sampleIidBytes())), sampleFixedType(C6238Arrays.copyOfRange(bArr, this.f23383params.sampleIidBytes(), bArr.length)));
        }
        throw new IllegalArgumentException("Invalid polynomial type");
    }

    public HPSPolynomial sampleFixedType(byte[] bArr) {
        int i;
        int i2;
        int iM18201n = this.f23383params.m18201n();
        int iM18199weight = ((NTRUHPSParameterSet) this.f23383params).m18199weight();
        HPSPolynomial hPSPolynomial = new HPSPolynomial((NTRUHPSParameterSet) this.f23383params);
        int i3 = iM18201n - 1;
        int[] iArr = new int[i3];
        int i4 = 0;
        while (true) {
            i = i3 / 4;
            if (i4 >= i) {
                break;
            }
            int i5 = i4 * 4;
            int i6 = i4 * 15;
            iArr[i5] = ((bArr[i6] & C1126UByte.MAX_VALUE) << 2) + ((bArr[i6 + 1] & C1126UByte.MAX_VALUE) << 10) + ((bArr[i6 + 2] & C1126UByte.MAX_VALUE) << 18) + ((bArr[i6 + 3] & C1126UByte.MAX_VALUE) << 26);
            iArr[i5 + 1] = ((bArr[(i4 * 3) + 15] & 192) >> 4) + ((bArr[i6 + 4] & C1126UByte.MAX_VALUE) << 4) + ((bArr[i6 + 5] & C1126UByte.MAX_VALUE) << 12) + ((bArr[i6 + 6] & C1126UByte.MAX_VALUE) << 20) + ((bArr[i6 + 7] & C1126UByte.MAX_VALUE) << 28);
            int i7 = ((bArr[(i4 * 7) + 15] & 240) >> 2) + ((bArr[i6 + 8] & C1126UByte.MAX_VALUE) << 6) + ((bArr[i6 + 9] & C1126UByte.MAX_VALUE) << 14) + ((bArr[i6 + 10] & C1126UByte.MAX_VALUE) << 22);
            byte b = bArr[i6 + 11];
            iArr[i5 + 2] = i7 + ((b & C1126UByte.MAX_VALUE) << 30);
            iArr[i5 + 3] = (b & 252) + ((bArr[i6 + 12] & C1126UByte.MAX_VALUE) << 8) + ((bArr[i6 + 13] & C1126UByte.MAX_VALUE) << 16) + ((bArr[i6 + 14] & C1126UByte.MAX_VALUE) << 24);
            i4++;
        }
        int i8 = i * 4;
        if (i3 > i8) {
            int i9 = i * 15;
            iArr[i8] = ((bArr[i9] & C1126UByte.MAX_VALUE) << 2) + ((bArr[i9 + 1] & C1126UByte.MAX_VALUE) << 10) + ((bArr[i9 + 2] & C1126UByte.MAX_VALUE) << 18) + ((bArr[i9 + 3] & C1126UByte.MAX_VALUE) << 26);
            iArr[i8 + 1] = ((bArr[(i * 3) + 15] & 192) >> 4) + ((bArr[i9 + 4] & C1126UByte.MAX_VALUE) << 4) + ((bArr[i9 + 5] & C1126UByte.MAX_VALUE) << 12) + ((bArr[i9 + 6] & C1126UByte.MAX_VALUE) << 20) + ((bArr[i9 + 7] & C1126UByte.MAX_VALUE) << 28);
        }
        int i10 = 0;
        while (true) {
            i2 = iM18199weight / 2;
            if (i10 >= i2) {
                break;
            }
            iArr[i10] = iArr[i10] | 1;
            i10++;
        }
        while (i2 < iM18199weight) {
            iArr[i2] = iArr[i2] | 2;
            i2++;
        }
        Arrays.sort(iArr);
        for (int i11 = 0; i11 < i3; i11++) {
            hPSPolynomial.f24144coeffs[i11] = (short) (iArr[i11] & 3);
        }
        hPSPolynomial.f24144coeffs[i3] = 0;
        return hPSPolynomial;
    }

    public Polynomial sampleIid(byte[] bArr) {
        Polynomial polynomialCreatePolynomial = this.f23383params.createPolynomial();
        for (int i = 0; i < this.f23383params.m18201n() - 1; i++) {
            polynomialCreatePolynomial.f24144coeffs[i] = (short) m17763mod3(bArr[i] & C1126UByte.MAX_VALUE);
        }
        polynomialCreatePolynomial.f24144coeffs[this.f23383params.m18201n() - 1] = 0;
        return polynomialCreatePolynomial;
    }

    public HRSSPolynomial sampleIidPlus(byte[] bArr) {
        int i;
        int iM18201n = this.f23383params.m18201n();
        HRSSPolynomial hRSSPolynomial = (HRSSPolynomial) sampleIid(bArr);
        int i2 = 0;
        while (true) {
            i = iM18201n - 1;
            if (i2 >= i) {
                break;
            }
            short[] sArr = hRSSPolynomial.f24144coeffs;
            short s = sArr[i2];
            sArr[i2] = (short) (s | (-(s >>> 1)));
            i2++;
        }
        int i3 = 0;
        short s2 = 0;
        while (i3 < i) {
            short[] sArr2 = hRSSPolynomial.f24144coeffs;
            int i4 = i3 + 1;
            s2 = (short) (s2 + ((short) (sArr2[i4] * sArr2[i3])));
            i3 = i4;
        }
        short s3 = (short) ((-((s2 & 65535) >>> 15)) | 1);
        for (int i5 = 0; i5 < i; i5 += 2) {
            short[] sArr3 = hRSSPolynomial.f24144coeffs;
            sArr3[i5] = (short) (sArr3[i5] * s3);
        }
        for (int i6 = 0; i6 < i; i6++) {
            short[] sArr4 = hRSSPolynomial.f24144coeffs;
            short s4 = sArr4[i6];
            sArr4[i6] = (short) ((((s4 & 65535) >>> 15) ^ (s4 & 65535)) & 3);
        }
        return hRSSPolynomial;
    }

    public PolynomialPair sampleRm(byte[] bArr) {
        NTRUParameterSet nTRUParameterSet = this.f23383params;
        if (nTRUParameterSet instanceof NTRUHRSSParameterSet) {
            return new PolynomialPair((HRSSPolynomial) sampleIid(C6238Arrays.copyOfRange(bArr, 0, nTRUParameterSet.sampleIidBytes())), (HRSSPolynomial) sampleIid(C6238Arrays.copyOfRange(bArr, this.f23383params.sampleIidBytes(), bArr.length)));
        }
        if (nTRUParameterSet instanceof NTRUHPSParameterSet) {
            return new PolynomialPair((HPSPolynomial) sampleIid(C6238Arrays.copyOfRange(bArr, 0, nTRUParameterSet.sampleIidBytes())), sampleFixedType(C6238Arrays.copyOfRange(bArr, this.f23383params.sampleIidBytes(), bArr.length)));
        }
        throw new IllegalArgumentException("Invalid polynomial type");
    }
}
