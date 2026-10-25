package p131o;

/* renamed from: o.LREOK */
/* loaded from: classes.dex */
public abstract class AbstractC2371LREOK {
    /* renamed from: AZxh */
    public static boolean m9364AZxh(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!AbstractC2931U2.m10465mjFkc(objArr[i], obj)) {
                i++;
            } else if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: mjFkc */
    public static boolean m9365mjFkc(int[] iArr, int i) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
