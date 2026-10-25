package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.C6242GF16;

/* loaded from: classes2.dex */
class MapGroup1 {

    /* renamed from: aAlpha */
    public final byte[][][] f23528aAlpha;

    /* renamed from: bAlpha */
    public final byte[][][] f23529bAlpha;

    /* renamed from: p11 */
    public final byte[][][][] f23530p11;

    /* renamed from: p12 */
    public final byte[][][][] f23531p12;

    /* renamed from: p21 */
    public final byte[][][][] f23532p21;

    /* renamed from: qAlpha1 */
    public final byte[][][] f23533qAlpha1;

    /* renamed from: qAlpha2 */
    public final byte[][][] f23534qAlpha2;

    public MapGroup1(SnovaParameters snovaParameters) {
        int iM17866getM = snovaParameters.m17866getM();
        int iM17870getV = snovaParameters.m17870getV();
        int iM17869getO = snovaParameters.m17869getO();
        int alpha = snovaParameters.getAlpha();
        int iM17865getLsq = snovaParameters.m17865getLsq();
        Class cls = Byte.TYPE;
        this.f23530p11 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17870getV, iM17870getV, iM17865getLsq);
        this.f23531p12 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17870getV, iM17869getO, iM17865getLsq);
        this.f23532p21 = (byte[][][][]) Array.newInstance((Class<?>) cls, iM17866getM, iM17869getO, iM17870getV, iM17865getLsq);
        this.f23528aAlpha = (byte[][][]) Array.newInstance((Class<?>) cls, iM17866getM, alpha, iM17865getLsq);
        this.f23529bAlpha = (byte[][][]) Array.newInstance((Class<?>) cls, iM17866getM, alpha, iM17865getLsq);
        this.f23533qAlpha1 = (byte[][][]) Array.newInstance((Class<?>) cls, iM17866getM, alpha, iM17865getLsq);
        this.f23534qAlpha2 = (byte[][][]) Array.newInstance((Class<?>) cls, iM17866getM, alpha, iM17865getLsq);
    }

    private static int decodeAlpha(byte[] bArr, int i, byte[][][] bArr2, int i2) {
        int iDecodeArray = 0;
        for (byte[][] bArr3 : bArr2) {
            iDecodeArray += decodeArray(bArr, i + iDecodeArray, bArr3, i2 - iDecodeArray);
        }
        return iDecodeArray;
    }

    public static int decodeArray(byte[] bArr, int i, byte[][] bArr2, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            int iMin = Math.min(bArr2[i4].length, i2 << 1);
            C6242GF16.m18285decode(bArr, i + i3, bArr2[i4], 0, iMin);
            int i5 = (iMin + 1) >> 1;
            i3 += i5;
            i2 -= i5;
        }
        return i3;
    }

    /* renamed from: decodeP */
    public static int m17850decodeP(byte[] bArr, int i, byte[][][][] bArr2, int i2) {
        int iDecodeAlpha = 0;
        for (byte[][][] bArr3 : bArr2) {
            iDecodeAlpha += decodeAlpha(bArr, i + iDecodeAlpha, bArr3, i2);
        }
        return iDecodeAlpha;
    }

    public static int fillAlpha(byte[] bArr, int i, byte[][][] bArr2, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            int i5 = 0;
            while (true) {
                byte[][] bArr3 = bArr2[i4];
                if (i5 < bArr3.length) {
                    int iMin = Math.min(bArr3[i5].length, i2 - i3);
                    System.arraycopy(bArr, i + i3, bArr2[i4][i5], 0, iMin);
                    i3 += iMin;
                    i5++;
                }
            }
        }
        return i3;
    }

    /* renamed from: fillP */
    public static int m17851fillP(byte[] bArr, int i, byte[][][][] bArr2, int i2) {
        int iFillAlpha = 0;
        for (byte[][][] bArr3 : bArr2) {
            iFillAlpha += fillAlpha(bArr, i + iFillAlpha, bArr3, i2 - iFillAlpha);
        }
        return iFillAlpha;
    }

    /* renamed from: decode */
    public void m17852decode(byte[] bArr, int i, boolean z) {
        int iM17850decodeP = m17850decodeP(bArr, 0, this.f23530p11, i);
        int iM17850decodeP2 = iM17850decodeP + m17850decodeP(bArr, iM17850decodeP, this.f23531p12, i - iM17850decodeP);
        int iM17850decodeP3 = iM17850decodeP2 + m17850decodeP(bArr, iM17850decodeP2, this.f23532p21, i - iM17850decodeP2);
        if (z) {
            int iDecodeAlpha = iM17850decodeP3 + decodeAlpha(bArr, iM17850decodeP3, this.f23528aAlpha, i - iM17850decodeP3);
            int iDecodeAlpha2 = iDecodeAlpha + decodeAlpha(bArr, iDecodeAlpha, this.f23529bAlpha, i - iDecodeAlpha);
            int iDecodeAlpha3 = iDecodeAlpha2 + decodeAlpha(bArr, iDecodeAlpha2, this.f23533qAlpha1, i - iDecodeAlpha2);
            decodeAlpha(bArr, iDecodeAlpha3, this.f23534qAlpha2, i - iDecodeAlpha3);
        }
    }

    /* renamed from: fill */
    public void m17853fill(byte[] bArr, boolean z) {
        int iM17851fillP = m17851fillP(bArr, 0, this.f23530p11, bArr.length);
        int iM17851fillP2 = iM17851fillP + m17851fillP(bArr, iM17851fillP, this.f23531p12, bArr.length - iM17851fillP);
        int iM17851fillP3 = iM17851fillP2 + m17851fillP(bArr, iM17851fillP2, this.f23532p21, bArr.length - iM17851fillP2);
        if (z) {
            int iFillAlpha = iM17851fillP3 + fillAlpha(bArr, iM17851fillP3, this.f23528aAlpha, bArr.length - iM17851fillP3);
            int iFillAlpha2 = iFillAlpha + fillAlpha(bArr, iFillAlpha, this.f23529bAlpha, bArr.length - iFillAlpha);
            int iFillAlpha3 = iFillAlpha2 + fillAlpha(bArr, iFillAlpha2, this.f23533qAlpha1, bArr.length - iFillAlpha2);
            fillAlpha(bArr, iFillAlpha3, this.f23534qAlpha2, bArr.length - iFillAlpha3);
        }
    }
}
