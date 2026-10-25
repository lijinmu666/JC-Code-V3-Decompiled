package p131o;

import java.lang.reflect.Array;

/* renamed from: o.m */
/* loaded from: classes.dex */
public abstract class AbstractC4120m {
    /* renamed from: AZxh */
    public static Object[] m12717AZxh(Object[] objArr, int i, Object obj) {
        if (i + 1 > objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), m12719wA(i));
            System.arraycopy(objArr, 0, objArr2, 0, i);
            objArr = objArr2;
        }
        objArr[i] = obj;
        return objArr;
    }

    /* renamed from: mjFkc */
    public static int[] m12718mjFkc(int[] iArr, int i, int i2) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[m12719wA(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    /* renamed from: wA */
    public static int m12719wA(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }
}
