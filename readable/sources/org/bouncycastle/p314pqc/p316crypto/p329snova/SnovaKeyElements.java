package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
class SnovaKeyElements {

    /* renamed from: T12 */
    public final byte[][][] f23550T12;

    /* renamed from: map1 */
    public final MapGroup1 f23551map1;

    /* renamed from: map2 */
    public final MapGroup2 f23552map2;

    public SnovaKeyElements(SnovaParameters snovaParameters) {
        int iM17869getO = snovaParameters.m17869getO();
        int iM17870getV = snovaParameters.m17870getV();
        int iM17865getLsq = snovaParameters.m17865getLsq();
        this.f23551map1 = new MapGroup1(snovaParameters);
        this.f23550T12 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, iM17870getV, iM17869getO, iM17865getLsq);
        this.f23552map2 = new MapGroup2(snovaParameters);
    }

    /* renamed from: copy3d */
    public static int m17860copy3d(byte[] bArr, int i, byte[][][] bArr2) {
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            int i3 = 0;
            while (true) {
                byte[][] bArr3 = bArr2[i2];
                if (i3 < bArr3.length) {
                    byte[] bArr4 = bArr3[i3];
                    System.arraycopy(bArr, i, bArr4, 0, bArr4.length);
                    i += bArr2[i2][i3].length;
                    i3++;
                }
            }
        }
        return i;
    }

    /* renamed from: copy4d */
    public static int m17862copy4d(byte[] bArr, int i, byte[][][][] bArr2) {
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            for (int i3 = 0; i3 < bArr2[i2].length; i3++) {
                int i4 = 0;
                while (true) {
                    byte[][] bArr3 = bArr2[i2][i3];
                    if (i4 < bArr3.length) {
                        byte[] bArr4 = bArr3[i4];
                        System.arraycopy(bArr, i, bArr4, 0, bArr4.length);
                        i += bArr2[i2][i3][i4].length;
                        i4++;
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: copy3d */
    public static int m17861copy3d(byte[][][] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = 0;
            while (true) {
                byte[][] bArr3 = bArr[i2];
                if (i3 < bArr3.length) {
                    byte[] bArr4 = bArr3[i3];
                    System.arraycopy(bArr4, 0, bArr2, i, bArr4.length);
                    i += bArr[i2][i3].length;
                    i3++;
                }
            }
        }
        return i;
    }

    /* renamed from: copy4d */
    public static int m17863copy4d(byte[][][][] bArr, byte[] bArr2, int i) {
        for (byte[][][] bArr3 : bArr) {
            i = m17861copy3d(bArr3, bArr2, i);
        }
        return i;
    }
}
