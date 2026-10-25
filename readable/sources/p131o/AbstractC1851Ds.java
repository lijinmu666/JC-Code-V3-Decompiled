package p131o;

/* renamed from: o.Ds */
/* loaded from: classes.dex */
public abstract class AbstractC1851Ds {
    /* renamed from: AZxh */
    public static int m8059AZxh(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m8060KLFTb(i, i2, "index"));
        }
        return i;
    }

    /* renamed from: KLFTb */
    public static String m8060KLFTb(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC2335Ks.m9283mjFkc("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC2335Ks.m9283mjFkc("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    /* renamed from: ZfxDd */
    public static void m8061ZfxDd(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? m8060KLFTb(i, i3, "start index") : (i2 < 0 || i2 > i3) ? m8060KLFTb(i2, i3, "end index") : AbstractC2335Ks.m9283mjFkc("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    /* renamed from: mjFkc */
    public static int m8062mjFkc(int i, int i2, String str) {
        String strM9283mjFkc;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strM9283mjFkc = AbstractC2335Ks.m9283mjFkc("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strM9283mjFkc = AbstractC2335Ks.m9283mjFkc("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strM9283mjFkc);
    }

    /* renamed from: wA */
    public static void m8063wA(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
