package p131o;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: o.BWWRl */
/* loaded from: classes.dex */
public abstract class AbstractC1701BWWRl {

    /* renamed from: o.BWWRl$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        int mo7715AZxh(Object obj);

        /* renamed from: mjFkc */
        Object mo7716mjFkc(Object obj, int i);
    }

    /* renamed from: o.BWWRl$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo7717mjFkc(Object obj, Rect rect);
    }

    /* renamed from: o.BWWRl$wA */
    public static class wA implements Comparator {

        /* renamed from: ZfxDd */
        public final mjFkc f7483ZfxDd;

        /* renamed from: wA */
        public final boolean f7485wA;

        /* renamed from: mjFkc */
        public final Rect f7484mjFkc = new Rect();

        /* renamed from: AZxh */
        public final Rect f7482AZxh = new Rect();

        public wA(boolean z, mjFkc mjfkc) {
            this.f7485wA = z;
            this.f7483ZfxDd = mjfkc;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Rect rect = this.f7484mjFkc;
            Rect rect2 = this.f7482AZxh;
            this.f7483ZfxDd.mo7717mjFkc(obj, rect);
            this.f7483ZfxDd.mo7717mjFkc(obj2, rect2);
            int i = rect.top;
            int i2 = rect2.top;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = rect.left;
            int i4 = rect2.left;
            if (i3 < i4) {
                return this.f7485wA ? 1 : -1;
            }
            if (i3 > i4) {
                return this.f7485wA ? -1 : 1;
            }
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                return this.f7485wA ? 1 : -1;
            }
            if (i7 > i8) {
                return this.f7485wA ? -1 : 1;
            }
            return 0;
        }
    }

    /* renamed from: AZxh */
    public static boolean m7700AZxh(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* renamed from: Dt */
    public static boolean m7701Dt(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        }
        if (i == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i == 66) {
            return rect.right <= rect2.left;
        }
        if (i == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: ETF */
    public static int m7702ETF(int i, Rect rect, Rect rect2) {
        return Math.max(0, m7706VA(i, rect, rect2));
    }

    /* renamed from: JHa */
    public static Object m7703JHa(Object obj, ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        int iIndexOf = (obj == null ? size : arrayList.indexOf(obj)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* renamed from: KLFTb */
    public static Object m7704KLFTb(Object obj, ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        int iLastIndexOf = (obj == null ? -1 : arrayList.lastIndexOf(obj)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* renamed from: MiMN */
    public static int m7705MiMN(int i, Rect rect, Rect rect2) {
        return Math.max(1, m7707YoKzxo(i, rect, rect2));
    }

    /* renamed from: VA */
    public static int m7706VA(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    /* renamed from: YoKzxo */
    public static int m7707YoKzxo(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.bottom;
            i3 = rect.bottom;
        }
        return i2 - i3;
    }

    /* renamed from: ZfxDd */
    public static Object m7708ZfxDd(Object obj, AZxh aZxh, mjFkc mjfkc, Object obj2, int i, boolean z, boolean z2) {
        int iMo7715AZxh = aZxh.mo7715AZxh(obj);
        ArrayList arrayList = new ArrayList(iMo7715AZxh);
        for (int i2 = 0; i2 < iMo7715AZxh; i2++) {
            arrayList.add(aZxh.mo7716mjFkc(obj, i2));
        }
        Collections.sort(arrayList, new wA(z, mjfkc));
        if (i == 1) {
            return m7703JHa(obj2, arrayList, z2);
        }
        if (i == 2) {
            return m7704KLFTb(obj2, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    /* renamed from: lgHUyS */
    public static boolean m7709lgHUyS(int i, Rect rect, Rect rect2, Rect rect3) {
        if (!m7711qdMbNW(rect, rect2, i)) {
            return false;
        }
        if (m7711qdMbNW(rect, rect3, i) && !m7710mjFkc(i, rect, rect2, rect3)) {
            return !m7710mjFkc(i, rect, rect3, rect2) && m7714xJ(m7702ETF(i, rect, rect2), m7712rkYL(i, rect, rect2)) < m7714xJ(m7702ETF(i, rect, rect3), m7712rkYL(i, rect, rect3));
        }
        return true;
    }

    /* renamed from: mjFkc */
    public static boolean m7710mjFkc(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean zM7700AZxh = m7700AZxh(i, rect, rect2);
        if (m7700AZxh(i, rect, rect3) || !zM7700AZxh) {
            return false;
        }
        return !m7701Dt(i, rect, rect3) || i == 17 || i == 66 || m7702ETF(i, rect, rect2) < m7705MiMN(i, rect, rect3);
    }

    /* renamed from: qdMbNW */
    public static boolean m7711qdMbNW(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }

    /* renamed from: rkYL */
    public static int m7712rkYL(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    /* renamed from: wA */
    public static Object m7713wA(Object obj, AZxh aZxh, mjFkc mjfkc, Object obj2, Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int iMo7715AZxh = aZxh.mo7715AZxh(obj);
        Rect rect3 = new Rect();
        Object obj3 = null;
        for (int i2 = 0; i2 < iMo7715AZxh; i2++) {
            Object objMo7716mjFkc = aZxh.mo7716mjFkc(obj, i2);
            if (objMo7716mjFkc != obj2) {
                mjfkc.mo7717mjFkc(objMo7716mjFkc, rect3);
                if (m7709lgHUyS(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    obj3 = objMo7716mjFkc;
                }
            }
        }
        return obj3;
    }

    /* renamed from: xJ */
    public static int m7714xJ(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }
}
