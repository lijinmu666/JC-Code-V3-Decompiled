package p131o;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: o.W6 */
/* loaded from: classes.dex */
public class C3074W6 {

    /* renamed from: JHa */
    public static Object[] f11413JHa;

    /* renamed from: KLFTb */
    public static int f11414KLFTb;

    /* renamed from: ZfxDd */
    public static Object[] f11415ZfxDd;

    /* renamed from: xJ */
    public static int f11416xJ;

    /* renamed from: AZxh */
    public Object[] f11417AZxh;

    /* renamed from: mjFkc */
    public int[] f11418mjFkc;

    /* renamed from: wA */
    public int f11419wA;

    public C3074W6() {
        this.f11418mjFkc = AbstractC2458MlqoT.f9605mjFkc;
        this.f11417AZxh = AbstractC2458MlqoT.f9606wA;
        this.f11419wA = 0;
    }

    /* renamed from: AZxh */
    public static int m10807AZxh(int[] iArr, int i, int i2) {
        try {
            return AbstractC2458MlqoT.m9534mjFkc(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: ZfxDd */
    public static void m10808ZfxDd(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C3074W6.class) {
                try {
                    if (f11416xJ < 10) {
                        objArr[0] = f11413JHa;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f11413JHa = objArr;
                        f11416xJ++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C3074W6.class) {
                try {
                    if (f11414KLFTb < 10) {
                        objArr[0] = f11415ZfxDd;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f11415ZfxDd = objArr;
                        f11414KLFTb++;
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: Dt */
    public void m10809Dt(C3074W6 c3074w6) {
        int i = c3074w6.f11419wA;
        m10828wA(this.f11419wA + i);
        if (this.f11419wA != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                m10821put(c3074w6.m10822qdMbNW(i2), c3074w6.m10813MiMN(i2));
            }
        } else if (i > 0) {
            System.arraycopy(c3074w6.f11418mjFkc, 0, this.f11418mjFkc, 0, i);
            System.arraycopy(c3074w6.f11417AZxh, 0, this.f11417AZxh, 0, i << 1);
            this.f11419wA = i;
        }
    }

    /* renamed from: ETF */
    public Object m10810ETF(int i) {
        Object[] objArr = this.f11417AZxh;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.f11419wA;
        int i4 = 0;
        if (i3 <= 1) {
            m10808ZfxDd(this.f11418mjFkc, objArr, i3);
            this.f11418mjFkc = AbstractC2458MlqoT.f9605mjFkc;
            this.f11417AZxh = AbstractC2458MlqoT.f9606wA;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f11418mjFkc;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f11417AZxh;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f11417AZxh;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                m10820mjFkc(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.f11419wA) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f11418mjFkc, 0, i);
                    System.arraycopy(objArr, 0, this.f11417AZxh, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.f11418mjFkc, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f11417AZxh, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.f11419wA) {
            throw new ConcurrentModificationException();
        }
        this.f11419wA = i4;
        return obj;
    }

    /* renamed from: JHa */
    public int m10811JHa(Object obj) {
        return obj == null ? m10829xJ() : m10812KLFTb(obj, obj.hashCode());
    }

    /* renamed from: KLFTb */
    public int m10812KLFTb(Object obj, int i) {
        int i2 = this.f11419wA;
        if (i2 == 0) {
            return -1;
        }
        int iM10807AZxh = m10807AZxh(this.f11418mjFkc, i2, i);
        if (iM10807AZxh < 0 || obj.equals(this.f11417AZxh[iM10807AZxh << 1])) {
            return iM10807AZxh;
        }
        int i3 = iM10807AZxh + 1;
        while (i3 < i2 && this.f11418mjFkc[i3] == i) {
            if (obj.equals(this.f11417AZxh[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM10807AZxh - 1; i4 >= 0 && this.f11418mjFkc[i4] == i; i4--) {
            if (obj.equals(this.f11417AZxh[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    /* renamed from: MiMN */
    public Object m10813MiMN(int i) {
        return this.f11417AZxh[(i << 1) + 1];
    }

    /* renamed from: VA */
    public Object m10814VA(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f11417AZxh;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    /* renamed from: clear */
    public void m10815clear() {
        int i = this.f11419wA;
        if (i > 0) {
            int[] iArr = this.f11418mjFkc;
            Object[] objArr = this.f11417AZxh;
            this.f11418mjFkc = AbstractC2458MlqoT.f9605mjFkc;
            this.f11417AZxh = AbstractC2458MlqoT.f9606wA;
            this.f11419wA = 0;
            m10808ZfxDd(iArr, objArr, i);
        }
        if (this.f11419wA > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m10811JHa(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m10819lgHUyS(obj) >= 0;
    }

    /* renamed from: equals */
    public boolean m10816equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3074W6) {
            C3074W6 c3074w6 = (C3074W6) obj;
            if (m10827size() != c3074w6.m10827size()) {
                return false;
            }
            for (int i = 0; i < this.f11419wA; i++) {
                try {
                    Object objM10822qdMbNW = m10822qdMbNW(i);
                    Object objM10813MiMN = m10813MiMN(i);
                    Object objM10817get = c3074w6.m10817get(objM10822qdMbNW);
                    if (objM10813MiMN == null) {
                        if (objM10817get != null || !c3074w6.containsKey(objM10822qdMbNW)) {
                            return false;
                        }
                    } else if (!objM10813MiMN.equals(objM10817get)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (m10827size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f11419wA; i2++) {
                try {
                    Object objM10822qdMbNW2 = m10822qdMbNW(i2);
                    Object objM10813MiMN2 = m10813MiMN(i2);
                    Object obj2 = map.get(objM10822qdMbNW2);
                    if (objM10813MiMN2 == null) {
                        if (obj2 != null || !map.containsKey(objM10822qdMbNW2)) {
                            return false;
                        }
                    } else if (!objM10813MiMN2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: get */
    public Object m10817get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iM10811JHa = m10811JHa(obj);
        return iM10811JHa >= 0 ? this.f11417AZxh[(iM10811JHa << 1) + 1] : obj2;
    }

    public int hashCode() {
        int[] iArr = this.f11418mjFkc;
        Object[] objArr = this.f11417AZxh;
        int i = this.f11419wA;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    /* renamed from: isEmpty */
    public boolean m10818isEmpty() {
        return this.f11419wA <= 0;
    }

    /* renamed from: lgHUyS */
    public int m10819lgHUyS(Object obj) {
        int i = this.f11419wA * 2;
        Object[] objArr = this.f11417AZxh;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* renamed from: mjFkc */
    public final void m10820mjFkc(int i) {
        if (i == 8) {
            synchronized (C3074W6.class) {
                try {
                    Object[] objArr = f11413JHa;
                    if (objArr != null) {
                        this.f11417AZxh = objArr;
                        f11413JHa = (Object[]) objArr[0];
                        this.f11418mjFkc = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f11416xJ--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (C3074W6.class) {
                try {
                    Object[] objArr2 = f11415ZfxDd;
                    if (objArr2 != null) {
                        this.f11417AZxh = objArr2;
                        f11415ZfxDd = (Object[]) objArr2[0];
                        this.f11418mjFkc = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f11414KLFTb--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f11418mjFkc = new int[i];
        this.f11417AZxh = new Object[i << 1];
    }

    /* renamed from: put */
    public Object m10821put(Object obj, Object obj2) {
        int i;
        int iM10812KLFTb;
        int i2 = this.f11419wA;
        if (obj == null) {
            iM10812KLFTb = m10829xJ();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iM10812KLFTb = m10812KLFTb(obj, iHashCode);
        }
        if (iM10812KLFTb >= 0) {
            int i3 = (iM10812KLFTb << 1) + 1;
            Object[] objArr = this.f11417AZxh;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~iM10812KLFTb;
        int[] iArr = this.f11418mjFkc;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.f11417AZxh;
            m10820mjFkc(i5);
            if (i2 != this.f11419wA) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f11418mjFkc;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f11417AZxh, 0, objArr2.length);
            }
            m10808ZfxDd(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f11418mjFkc;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f11417AZxh;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f11419wA - i4) << 1);
        }
        int i7 = this.f11419wA;
        if (i2 == i7) {
            int[] iArr4 = this.f11418mjFkc;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f11417AZxh;
                int i8 = i4 << 1;
                objArr4[i8] = obj;
                objArr4[i8 + 1] = obj2;
                this.f11419wA = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object objM10817get = m10817get(obj);
        return objM10817get == null ? m10821put(obj, obj2) : objM10817get;
    }

    /* renamed from: qdMbNW */
    public Object m10822qdMbNW(int i) {
        return this.f11417AZxh[i << 1];
    }

    /* renamed from: remove */
    public Object m10823remove(Object obj) {
        int iM10811JHa = m10811JHa(obj);
        if (iM10811JHa >= 0) {
            return m10810ETF(iM10811JHa);
        }
        return null;
    }

    /* renamed from: replace */
    public Object m10825replace(Object obj, Object obj2) {
        int iM10811JHa = m10811JHa(obj);
        if (iM10811JHa >= 0) {
            return m10814VA(iM10811JHa, obj2);
        }
        return null;
    }

    /* renamed from: size */
    public int m10827size() {
        return this.f11419wA;
    }

    public String toString() {
        if (m10818isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f11419wA * 28);
        sb.append('{');
        for (int i = 0; i < this.f11419wA; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objM10822qdMbNW = m10822qdMbNW(i);
            if (objM10822qdMbNW != this) {
                sb.append(objM10822qdMbNW);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objM10813MiMN = m10813MiMN(i);
            if (objM10813MiMN != this) {
                sb.append(objM10813MiMN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: wA */
    public void m10828wA(int i) {
        int i2 = this.f11419wA;
        int[] iArr = this.f11418mjFkc;
        if (iArr.length < i) {
            Object[] objArr = this.f11417AZxh;
            m10820mjFkc(i);
            if (this.f11419wA > 0) {
                System.arraycopy(iArr, 0, this.f11418mjFkc, 0, i2);
                System.arraycopy(objArr, 0, this.f11417AZxh, 0, i2 << 1);
            }
            m10808ZfxDd(iArr, objArr, i2);
        }
        if (this.f11419wA != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: xJ */
    public int m10829xJ() {
        int i = this.f11419wA;
        if (i == 0) {
            return -1;
        }
        int iM10807AZxh = m10807AZxh(this.f11418mjFkc, i, 0);
        if (iM10807AZxh < 0 || this.f11417AZxh[iM10807AZxh << 1] == null) {
            return iM10807AZxh;
        }
        int i2 = iM10807AZxh + 1;
        while (i2 < i && this.f11418mjFkc[i2] == 0) {
            if (this.f11417AZxh[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM10807AZxh - 1; i3 >= 0 && this.f11418mjFkc[i3] == 0; i3--) {
            if (this.f11417AZxh[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    /* renamed from: remove */
    public boolean m10824remove(Object obj, Object obj2) {
        int iM10811JHa = m10811JHa(obj);
        if (iM10811JHa < 0) {
            return false;
        }
        Object objM10813MiMN = m10813MiMN(iM10811JHa);
        if (obj2 != objM10813MiMN && (obj2 == null || !obj2.equals(objM10813MiMN))) {
            return false;
        }
        m10810ETF(iM10811JHa);
        return true;
    }

    /* renamed from: replace */
    public boolean m10826replace(Object obj, Object obj2, Object obj3) {
        int iM10811JHa = m10811JHa(obj);
        if (iM10811JHa < 0) {
            return false;
        }
        Object objM10813MiMN = m10813MiMN(iM10811JHa);
        if (objM10813MiMN != obj2 && (obj2 == null || !obj2.equals(objM10813MiMN))) {
            return false;
        }
        m10814VA(iM10811JHa, obj3);
        return true;
    }

    public C3074W6(int i) {
        if (i == 0) {
            this.f11418mjFkc = AbstractC2458MlqoT.f9605mjFkc;
            this.f11417AZxh = AbstractC2458MlqoT.f9606wA;
        } else {
            m10820mjFkc(i);
        }
        this.f11419wA = 0;
    }

    public C3074W6(C3074W6 c3074w6) {
        this();
        if (c3074w6 != null) {
            m10809Dt(c3074w6);
        }
    }
}
