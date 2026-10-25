package p131o;

/* renamed from: o.MlqoT */
/* loaded from: classes.dex */
public abstract class AbstractC2458MlqoT {

    /* renamed from: mjFkc */
    public static final int[] f9605mjFkc = new int[0];

    /* renamed from: AZxh */
    public static final long[] f9604AZxh = new long[0];

    /* renamed from: wA */
    public static final Object[] f9606wA = new Object[0];

    /* renamed from: AZxh */
    public static int m9530AZxh(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    /* renamed from: JHa */
    public static int m9531JHa(int i) {
        return m9533ZfxDd(i * 8) / 8;
    }

    /* renamed from: KLFTb */
    public static int m9532KLFTb(int i) {
        return m9533ZfxDd(i * 4) / 4;
    }

    /* renamed from: ZfxDd */
    public static int m9533ZfxDd(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    /* renamed from: mjFkc */
    public static int m9534mjFkc(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    /* renamed from: wA */
    public static boolean m9535wA(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
