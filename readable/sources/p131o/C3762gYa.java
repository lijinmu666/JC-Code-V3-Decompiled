package p131o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: o.gYa */
/* loaded from: classes.dex */
public final class C3762gYa implements Collection, Set {

    /* renamed from: Dt */
    public static int f13720Dt;

    /* renamed from: lgHUyS */
    public static int f13723lgHUyS;

    /* renamed from: qdMbNW */
    public static Object[] f13724qdMbNW;

    /* renamed from: xJ */
    public static Object[] f13725xJ;

    /* renamed from: AZxh */
    public Object[] f13726AZxh;

    /* renamed from: ZfxDd */
    public AbstractC4986z1 f13727ZfxDd;

    /* renamed from: mjFkc */
    public int[] f13728mjFkc;

    /* renamed from: wA */
    public int f13729wA;

    /* renamed from: KLFTb */
    public static final int[] f13722KLFTb = new int[0];

    /* renamed from: JHa */
    public static final Object[] f13721JHa = new Object[0];

    /* renamed from: o.gYa$mjFkc */
    public class mjFkc extends AbstractC4986z1 {
        public mjFkc() {
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: AZxh */
        public Object mo12004AZxh(int i, int i2) {
            return C3762gYa.this.f13726AZxh[i];
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: JHa */
        public int mo12005JHa(Object obj) {
            return C3762gYa.this.m11999indexOf(obj);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: KLFTb */
        public int mo12006KLFTb(Object obj) {
            return C3762gYa.this.m11999indexOf(obj);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: ZfxDd */
        public int mo12007ZfxDd() {
            return C3762gYa.this.f13729wA;
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: lgHUyS */
        public void mo12008lgHUyS(int i) {
            C3762gYa.this.m11996Dt(i);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: mjFkc */
        public void mo12009mjFkc() {
            C3762gYa.this.clear();
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: qdMbNW */
        public Object mo12010qdMbNW(int i, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: wA */
        public Map mo12011wA() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: xJ */
        public void mo12012xJ(Object obj, Object obj2) {
            C3762gYa.this.add(obj);
        }
    }

    public C3762gYa() {
        this(0);
    }

    /* renamed from: JHa */
    public static void m11995JHa(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C3762gYa.class) {
                try {
                    if (f13720Dt < 10) {
                        objArr[0] = f13724qdMbNW;
                        objArr[1] = iArr;
                        for (int i2 = i - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f13724qdMbNW = objArr;
                        f13720Dt++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C3762gYa.class) {
                try {
                    if (f13723lgHUyS < 10) {
                        objArr[0] = f13725xJ;
                        objArr[1] = iArr;
                        for (int i3 = i - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f13725xJ = objArr;
                        f13723lgHUyS++;
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: Dt */
    public Object m11996Dt(int i) {
        Object[] objArr = this.f13726AZxh;
        Object obj = objArr[i];
        int i2 = this.f13729wA;
        if (i2 <= 1) {
            m11995JHa(this.f13728mjFkc, objArr, i2);
            this.f13728mjFkc = f13722KLFTb;
            this.f13726AZxh = f13721JHa;
            this.f13729wA = 0;
        } else {
            int[] iArr = this.f13728mjFkc;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.f13729wA = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.f13726AZxh;
                    System.arraycopy(objArr2, i4, objArr2, i, this.f13729wA - i);
                }
                this.f13726AZxh[this.f13729wA] = null;
            } else {
                m12001mjFkc(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.f13729wA--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f13728mjFkc, 0, i);
                    System.arraycopy(objArr, 0, this.f13726AZxh, 0, i);
                }
                int i5 = this.f13729wA;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.f13728mjFkc, i, i5 - i);
                    System.arraycopy(objArr, i6, this.f13726AZxh, i, this.f13729wA - i);
                }
            }
        }
        return obj;
    }

    /* renamed from: ETF */
    public Object m11997ETF(int i) {
        return this.f13726AZxh[i];
    }

    /* renamed from: ZfxDd */
    public void m11998ZfxDd(int i) {
        int[] iArr = this.f13728mjFkc;
        if (iArr.length < i) {
            Object[] objArr = this.f13726AZxh;
            m12001mjFkc(i);
            int i2 = this.f13729wA;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f13728mjFkc, 0, i2);
                System.arraycopy(objArr, 0, this.f13726AZxh, 0, this.f13729wA);
            }
            m11995JHa(iArr, objArr, this.f13729wA);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i;
        int iM12000lgHUyS;
        if (obj == null) {
            iM12000lgHUyS = m12002qdMbNW();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iM12000lgHUyS = m12000lgHUyS(obj, iHashCode);
        }
        if (iM12000lgHUyS >= 0) {
            return false;
        }
        int i2 = ~iM12000lgHUyS;
        int i3 = this.f13729wA;
        int[] iArr = this.f13728mjFkc;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f13726AZxh;
            m12001mjFkc(i4);
            int[] iArr2 = this.f13728mjFkc;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f13726AZxh, 0, objArr.length);
            }
            m11995JHa(iArr, objArr, this.f13729wA);
        }
        int i5 = this.f13729wA;
        if (i2 < i5) {
            int[] iArr3 = this.f13728mjFkc;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f13726AZxh;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f13729wA - i2);
        }
        this.f13728mjFkc[i2] = i;
        this.f13726AZxh[i2] = obj;
        this.f13729wA++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        m11998ZfxDd(this.f13729wA + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f13729wA;
        if (i != 0) {
            m11995JHa(this.f13728mjFkc, this.f13726AZxh, i);
            this.f13728mjFkc = f13722KLFTb;
            this.f13726AZxh = f13721JHa;
            this.f13729wA = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return m11999indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f13729wA; i++) {
                try {
                    if (!set.contains(m11997ETF(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f13728mjFkc;
        int i = this.f13729wA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    /* renamed from: indexOf */
    public int m11999indexOf(Object obj) {
        return obj == null ? m12002qdMbNW() : m12000lgHUyS(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f13729wA <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return m12003xJ().m14079MiMN().iterator();
    }

    /* renamed from: lgHUyS */
    public final int m12000lgHUyS(Object obj, int i) {
        int i2 = this.f13729wA;
        if (i2 == 0) {
            return -1;
        }
        int iM9534mjFkc = AbstractC2458MlqoT.m9534mjFkc(this.f13728mjFkc, i2, i);
        if (iM9534mjFkc < 0 || obj.equals(this.f13726AZxh[iM9534mjFkc])) {
            return iM9534mjFkc;
        }
        int i3 = iM9534mjFkc + 1;
        while (i3 < i2 && this.f13728mjFkc[i3] == i) {
            if (obj.equals(this.f13726AZxh[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM9534mjFkc - 1; i4 >= 0 && this.f13728mjFkc[i4] == i; i4--) {
            if (obj.equals(this.f13726AZxh[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    /* renamed from: mjFkc */
    public final void m12001mjFkc(int i) {
        if (i == 8) {
            synchronized (C3762gYa.class) {
                try {
                    Object[] objArr = f13724qdMbNW;
                    if (objArr != null) {
                        this.f13726AZxh = objArr;
                        f13724qdMbNW = (Object[]) objArr[0];
                        this.f13728mjFkc = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f13720Dt--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (C3762gYa.class) {
                try {
                    Object[] objArr2 = f13725xJ;
                    if (objArr2 != null) {
                        this.f13726AZxh = objArr2;
                        f13725xJ = (Object[]) objArr2[0];
                        this.f13728mjFkc = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f13723lgHUyS--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f13728mjFkc = new int[i];
        this.f13726AZxh = new Object[i];
    }

    /* renamed from: qdMbNW */
    public final int m12002qdMbNW() {
        int i = this.f13729wA;
        if (i == 0) {
            return -1;
        }
        int iM9534mjFkc = AbstractC2458MlqoT.m9534mjFkc(this.f13728mjFkc, i, 0);
        if (iM9534mjFkc < 0 || this.f13726AZxh[iM9534mjFkc] == null) {
            return iM9534mjFkc;
        }
        int i2 = iM9534mjFkc + 1;
        while (i2 < i && this.f13728mjFkc[i2] == 0) {
            if (this.f13726AZxh[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM9534mjFkc - 1; i3 >= 0 && this.f13728mjFkc[i3] == 0; i3--) {
            if (this.f13726AZxh[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iM11999indexOf = m11999indexOf(obj);
        if (iM11999indexOf < 0) {
            return false;
        }
        m11996Dt(iM11999indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i = this.f13729wA - 1; i >= 0; i--) {
            if (!collection.contains(this.f13726AZxh[i])) {
                m11996Dt(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f13729wA;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.f13729wA;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f13726AZxh, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13729wA * 14);
        sb.append('{');
        for (int i = 0; i < this.f13729wA; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objM11997ETF = m11997ETF(i);
            if (objM11997ETF != this) {
                sb.append(objM11997ETF);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: xJ */
    public final AbstractC4986z1 m12003xJ() {
        if (this.f13727ZfxDd == null) {
            this.f13727ZfxDd = new mjFkc();
        }
        return this.f13727ZfxDd;
    }

    public C3762gYa(int i) {
        if (i == 0) {
            this.f13728mjFkc = f13722KLFTb;
            this.f13726AZxh = f13721JHa;
        } else {
            m12001mjFkc(i);
        }
        this.f13729wA = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f13729wA) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f13729wA);
        }
        System.arraycopy(this.f13726AZxh, 0, objArr, 0, this.f13729wA);
        int length = objArr.length;
        int i = this.f13729wA;
        if (length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
