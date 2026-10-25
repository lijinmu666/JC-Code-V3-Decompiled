package p131o;

/* renamed from: o.XW */
/* loaded from: classes.dex */
public abstract class AbstractC3168XW {
    /* renamed from: AZxh */
    public static int m10941AZxh(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m10942KLFTb(i, i2, "index"));
        }
        return i;
    }

    /* renamed from: KLFTb */
    public static String m10942KLFTb(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC3438bX.m11526mjFkc("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC3438bX.m11526mjFkc("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    /* renamed from: ZfxDd */
    public static void m10943ZfxDd(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    /* renamed from: mjFkc */
    public static int m10944mjFkc(int i, int i2, String str) {
        String strM11526mjFkc;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strM11526mjFkc = AbstractC3438bX.m11526mjFkc("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strM11526mjFkc = AbstractC3438bX.m11526mjFkc("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strM11526mjFkc);
    }

    /* renamed from: wA */
    public static void m10945wA(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? m10942KLFTb(i, i3, "start index") : (i2 < 0 || i2 > i3) ? m10942KLFTb(i2, i3, "end index") : AbstractC3438bX.m11526mjFkc("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
