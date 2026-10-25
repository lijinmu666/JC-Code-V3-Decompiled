package p131o;

/* renamed from: o.PH */
/* loaded from: classes.dex */
public abstract class AbstractC2623PH {
    /* renamed from: AZxh */
    public static int m9954AZxh(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m9955ZfxDd(i, i2, "index"));
        }
        return i;
    }

    /* renamed from: ZfxDd */
    public static String m9955ZfxDd(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC3221YI.m11090mjFkc("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC3221YI.m11090mjFkc("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    /* renamed from: mjFkc */
    public static int m9956mjFkc(int i, int i2, String str) {
        String strM11090mjFkc;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strM11090mjFkc = AbstractC3221YI.m11090mjFkc("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strM11090mjFkc = AbstractC3221YI.m11090mjFkc("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strM11090mjFkc);
    }

    /* renamed from: wA */
    public static void m9957wA(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? m9955ZfxDd(i, i3, "start index") : (i2 < 0 || i2 > i3) ? m9955ZfxDd(i2, i3, "end index") : AbstractC3221YI.m11090mjFkc("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
