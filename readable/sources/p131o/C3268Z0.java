package p131o;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: o.Z0 */
/* loaded from: classes.dex */
public final class C3268Z0 extends AbstractMap implements Serializable {

    /* renamed from: lgHUyS */
    public static final Comparator f11928lgHUyS = new mjFkc();

    /* renamed from: AZxh */
    public KLFTb f11929AZxh;

    /* renamed from: JHa */
    public AZxh f11930JHa;

    /* renamed from: KLFTb */
    public final KLFTb f11931KLFTb;

    /* renamed from: ZfxDd */
    public int f11932ZfxDd;

    /* renamed from: mjFkc */
    public Comparator f11933mjFkc;

    /* renamed from: wA */
    public int f11934wA;

    /* renamed from: xJ */
    public wA f11935xJ;

    /* renamed from: o.Z0$AZxh */
    public class AZxh extends AbstractSet {

        /* renamed from: o.Z0$AZxh$mjFkc */
        public class mjFkc extends ZfxDd {
            public mjFkc() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return m11162AZxh();
            }
        }

        public AZxh() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C3268Z0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && C3268Z0.this.m11157wA((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new mjFkc();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            KLFTb kLFTbM11157wA;
            if (!(obj instanceof Map.Entry) || (kLFTbM11157wA = C3268Z0.this.m11157wA((Map.Entry) obj)) == null) {
                return false;
            }
            C3268Z0.this.m11151JHa(kLFTbM11157wA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C3268Z0.this.f11934wA;
        }
    }

    /* renamed from: o.Z0$ZfxDd */
    public abstract class ZfxDd implements Iterator {

        /* renamed from: AZxh */
        public KLFTb f11946AZxh = null;

        /* renamed from: mjFkc */
        public KLFTb f11948mjFkc;

        /* renamed from: wA */
        public int f11949wA;

        public ZfxDd() {
            this.f11948mjFkc = C3268Z0.this.f11931KLFTb.f11941ZfxDd;
            this.f11949wA = C3268Z0.this.f11932ZfxDd;
        }

        /* renamed from: AZxh */
        public final KLFTb m11162AZxh() {
            KLFTb kLFTb = this.f11948mjFkc;
            C3268Z0 c3268z0 = C3268Z0.this;
            if (kLFTb == c3268z0.f11931KLFTb) {
                throw new NoSuchElementException();
            }
            if (c3268z0.f11932ZfxDd != this.f11949wA) {
                throw new ConcurrentModificationException();
            }
            this.f11948mjFkc = kLFTb.f11941ZfxDd;
            this.f11946AZxh = kLFTb;
            return kLFTb;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f11948mjFkc != C3268Z0.this.f11931KLFTb;
        }

        @Override // java.util.Iterator
        public final void remove() {
            KLFTb kLFTb = this.f11946AZxh;
            if (kLFTb == null) {
                throw new IllegalStateException();
            }
            C3268Z0.this.m11151JHa(kLFTb, true);
            this.f11946AZxh = null;
            this.f11949wA = C3268Z0.this.f11932ZfxDd;
        }
    }

    /* renamed from: o.Z0$mjFkc */
    public class mjFkc implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* renamed from: o.Z0$wA */
    public final class wA extends AbstractSet {

        /* renamed from: o.Z0$wA$mjFkc */
        public class mjFkc extends ZfxDd {
            public mjFkc() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return m11162AZxh().f11939JHa;
            }
        }

        public wA() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C3268Z0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C3268Z0.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new mjFkc();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return C3268Z0.this.m11158xJ(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C3268Z0.this.f11934wA;
        }
    }

    public C3268Z0() {
        this(f11928lgHUyS);
    }

    /* renamed from: AZxh */
    public KLFTb m11149AZxh(Object obj, boolean z) {
        int iCompareTo;
        KLFTb kLFTb;
        Comparator comparator = this.f11933mjFkc;
        KLFTb kLFTb2 = this.f11929AZxh;
        if (kLFTb2 != null) {
            Comparable comparable = comparator == f11928lgHUyS ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(kLFTb2.f11939JHa) : comparator.compare(obj, kLFTb2.f11939JHa);
                if (iCompareTo == 0) {
                    return kLFTb2;
                }
                KLFTb kLFTb3 = iCompareTo < 0 ? kLFTb2.f11938AZxh : kLFTb2.f11944wA;
                if (kLFTb3 == null) {
                    break;
                }
                kLFTb2 = kLFTb3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        KLFTb kLFTb4 = this.f11931KLFTb;
        if (kLFTb2 != null) {
            kLFTb = new KLFTb(kLFTb2, obj, kLFTb4, kLFTb4.f11940KLFTb);
            if (iCompareTo < 0) {
                kLFTb2.f11938AZxh = kLFTb;
            } else {
                kLFTb2.f11944wA = kLFTb;
            }
            m11152KLFTb(kLFTb2, true);
        } else {
            if (comparator == f11928lgHUyS && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            kLFTb = new KLFTb(kLFTb2, obj, kLFTb4, kLFTb4.f11940KLFTb);
            this.f11929AZxh = kLFTb;
        }
        this.f11934wA++;
        this.f11932ZfxDd++;
        return kLFTb;
    }

    /* renamed from: Dt */
    public final void m11150Dt(KLFTb kLFTb) {
        KLFTb kLFTb2 = kLFTb.f11938AZxh;
        KLFTb kLFTb3 = kLFTb.f11944wA;
        KLFTb kLFTb4 = kLFTb2.f11938AZxh;
        KLFTb kLFTb5 = kLFTb2.f11944wA;
        kLFTb.f11938AZxh = kLFTb5;
        if (kLFTb5 != null) {
            kLFTb5.f11943mjFkc = kLFTb;
        }
        m11154lgHUyS(kLFTb, kLFTb2);
        kLFTb2.f11944wA = kLFTb;
        kLFTb.f11943mjFkc = kLFTb2;
        int iMax = Math.max(kLFTb3 != null ? kLFTb3.f11942lgHUyS : 0, kLFTb5 != null ? kLFTb5.f11942lgHUyS : 0) + 1;
        kLFTb.f11942lgHUyS = iMax;
        kLFTb2.f11942lgHUyS = Math.max(iMax, kLFTb4 != null ? kLFTb4.f11942lgHUyS : 0) + 1;
    }

    /* renamed from: JHa */
    public void m11151JHa(KLFTb kLFTb, boolean z) {
        int i;
        if (z) {
            KLFTb kLFTb2 = kLFTb.f11940KLFTb;
            kLFTb2.f11941ZfxDd = kLFTb.f11941ZfxDd;
            kLFTb.f11941ZfxDd.f11940KLFTb = kLFTb2;
        }
        KLFTb kLFTb3 = kLFTb.f11938AZxh;
        KLFTb kLFTb4 = kLFTb.f11944wA;
        KLFTb kLFTb5 = kLFTb.f11943mjFkc;
        int i2 = 0;
        if (kLFTb3 == null || kLFTb4 == null) {
            if (kLFTb3 != null) {
                m11154lgHUyS(kLFTb, kLFTb3);
                kLFTb.f11938AZxh = null;
            } else if (kLFTb4 != null) {
                m11154lgHUyS(kLFTb, kLFTb4);
                kLFTb.f11944wA = null;
            } else {
                m11154lgHUyS(kLFTb, null);
            }
            m11152KLFTb(kLFTb5, false);
            this.f11934wA--;
            this.f11932ZfxDd++;
            return;
        }
        KLFTb kLFTbM11160AZxh = kLFTb3.f11942lgHUyS > kLFTb4.f11942lgHUyS ? kLFTb3.m11160AZxh() : kLFTb4.m11161mjFkc();
        m11151JHa(kLFTbM11160AZxh, false);
        KLFTb kLFTb6 = kLFTb.f11938AZxh;
        if (kLFTb6 != null) {
            i = kLFTb6.f11942lgHUyS;
            kLFTbM11160AZxh.f11938AZxh = kLFTb6;
            kLFTb6.f11943mjFkc = kLFTbM11160AZxh;
            kLFTb.f11938AZxh = null;
        } else {
            i = 0;
        }
        KLFTb kLFTb7 = kLFTb.f11944wA;
        if (kLFTb7 != null) {
            i2 = kLFTb7.f11942lgHUyS;
            kLFTbM11160AZxh.f11944wA = kLFTb7;
            kLFTb7.f11943mjFkc = kLFTbM11160AZxh;
            kLFTb.f11944wA = null;
        }
        kLFTbM11160AZxh.f11942lgHUyS = Math.max(i, i2) + 1;
        m11154lgHUyS(kLFTb, kLFTbM11160AZxh);
    }

    /* renamed from: KLFTb */
    public final void m11152KLFTb(KLFTb kLFTb, boolean z) {
        while (kLFTb != null) {
            KLFTb kLFTb2 = kLFTb.f11938AZxh;
            KLFTb kLFTb3 = kLFTb.f11944wA;
            int i = kLFTb2 != null ? kLFTb2.f11942lgHUyS : 0;
            int i2 = kLFTb3 != null ? kLFTb3.f11942lgHUyS : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                KLFTb kLFTb4 = kLFTb3.f11938AZxh;
                KLFTb kLFTb5 = kLFTb3.f11944wA;
                int i4 = (kLFTb4 != null ? kLFTb4.f11942lgHUyS : 0) - (kLFTb5 != null ? kLFTb5.f11942lgHUyS : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m11156qdMbNW(kLFTb);
                } else {
                    m11150Dt(kLFTb3);
                    m11156qdMbNW(kLFTb);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                KLFTb kLFTb6 = kLFTb2.f11938AZxh;
                KLFTb kLFTb7 = kLFTb2.f11944wA;
                int i5 = (kLFTb6 != null ? kLFTb6.f11942lgHUyS : 0) - (kLFTb7 != null ? kLFTb7.f11942lgHUyS : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m11150Dt(kLFTb);
                } else {
                    m11156qdMbNW(kLFTb2);
                    m11150Dt(kLFTb);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                kLFTb.f11942lgHUyS = i + 1;
                if (z) {
                    return;
                }
            } else {
                kLFTb.f11942lgHUyS = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            kLFTb = kLFTb.f11943mjFkc;
        }
    }

    /* renamed from: ZfxDd */
    public KLFTb m11153ZfxDd(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return m11149AZxh(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f11929AZxh = null;
        this.f11934wA = 0;
        this.f11932ZfxDd++;
        KLFTb kLFTb = this.f11931KLFTb;
        kLFTb.f11940KLFTb = kLFTb;
        kLFTb.f11941ZfxDd = kLFTb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m11153ZfxDd(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        AZxh aZxh = this.f11930JHa;
        if (aZxh != null) {
            return aZxh;
        }
        AZxh aZxh2 = new AZxh();
        this.f11930JHa = aZxh2;
        return aZxh2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        KLFTb kLFTbM11153ZfxDd = m11153ZfxDd(obj);
        if (kLFTbM11153ZfxDd != null) {
            return kLFTbM11153ZfxDd.f11945xJ;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        wA wAVar = this.f11935xJ;
        if (wAVar != null) {
            return wAVar;
        }
        wA wAVar2 = new wA();
        this.f11935xJ = wAVar2;
        return wAVar2;
    }

    /* renamed from: lgHUyS */
    public final void m11154lgHUyS(KLFTb kLFTb, KLFTb kLFTb2) {
        KLFTb kLFTb3 = kLFTb.f11943mjFkc;
        kLFTb.f11943mjFkc = null;
        if (kLFTb2 != null) {
            kLFTb2.f11943mjFkc = kLFTb3;
        }
        if (kLFTb3 == null) {
            this.f11929AZxh = kLFTb2;
        } else if (kLFTb3.f11938AZxh == kLFTb) {
            kLFTb3.f11938AZxh = kLFTb2;
        } else {
            kLFTb3.f11944wA = kLFTb2;
        }
    }

    /* renamed from: mjFkc */
    public final boolean m11155mjFkc(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        KLFTb kLFTbM11149AZxh = m11149AZxh(obj, true);
        Object obj3 = kLFTbM11149AZxh.f11945xJ;
        kLFTbM11149AZxh.f11945xJ = obj2;
        return obj3;
    }

    /* renamed from: qdMbNW */
    public final void m11156qdMbNW(KLFTb kLFTb) {
        KLFTb kLFTb2 = kLFTb.f11938AZxh;
        KLFTb kLFTb3 = kLFTb.f11944wA;
        KLFTb kLFTb4 = kLFTb3.f11938AZxh;
        KLFTb kLFTb5 = kLFTb3.f11944wA;
        kLFTb.f11944wA = kLFTb4;
        if (kLFTb4 != null) {
            kLFTb4.f11943mjFkc = kLFTb;
        }
        m11154lgHUyS(kLFTb, kLFTb3);
        kLFTb3.f11938AZxh = kLFTb;
        kLFTb.f11943mjFkc = kLFTb3;
        int iMax = Math.max(kLFTb2 != null ? kLFTb2.f11942lgHUyS : 0, kLFTb4 != null ? kLFTb4.f11942lgHUyS : 0) + 1;
        kLFTb.f11942lgHUyS = iMax;
        kLFTb3.f11942lgHUyS = Math.max(iMax, kLFTb5 != null ? kLFTb5.f11942lgHUyS : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        KLFTb kLFTbM11158xJ = m11158xJ(obj);
        if (kLFTbM11158xJ != null) {
            return kLFTbM11158xJ.f11945xJ;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f11934wA;
    }

    /* renamed from: wA */
    public KLFTb m11157wA(Map.Entry entry) {
        KLFTb kLFTbM11153ZfxDd = m11153ZfxDd(entry.getKey());
        if (kLFTbM11153ZfxDd == null || !m11155mjFkc(kLFTbM11153ZfxDd.f11945xJ, entry.getValue())) {
            return null;
        }
        return kLFTbM11153ZfxDd;
    }

    /* renamed from: xJ */
    public KLFTb m11158xJ(Object obj) {
        KLFTb kLFTbM11153ZfxDd = m11153ZfxDd(obj);
        if (kLFTbM11153ZfxDd != null) {
            m11151JHa(kLFTbM11153ZfxDd, true);
        }
        return kLFTbM11153ZfxDd;
    }

    public C3268Z0(Comparator comparator) {
        this.f11934wA = 0;
        this.f11932ZfxDd = 0;
        this.f11931KLFTb = new KLFTb();
        this.f11933mjFkc = comparator == null ? f11928lgHUyS : comparator;
    }

    /* renamed from: o.Z0$KLFTb */
    public static final class KLFTb implements Map.Entry {

        /* renamed from: AZxh */
        public KLFTb f11938AZxh;

        /* renamed from: JHa */
        public final Object f11939JHa;

        /* renamed from: KLFTb */
        public KLFTb f11940KLFTb;

        /* renamed from: ZfxDd */
        public KLFTb f11941ZfxDd;

        /* renamed from: lgHUyS */
        public int f11942lgHUyS;

        /* renamed from: mjFkc */
        public KLFTb f11943mjFkc;

        /* renamed from: wA */
        public KLFTb f11944wA;

        /* renamed from: xJ */
        public Object f11945xJ;

        public KLFTb() {
            this.f11939JHa = null;
            this.f11940KLFTb = this;
            this.f11941ZfxDd = this;
        }

        /* renamed from: AZxh */
        public KLFTb m11160AZxh() {
            KLFTb kLFTb = this.f11944wA;
            while (true) {
                KLFTb kLFTb2 = kLFTb;
                KLFTb kLFTb3 = this;
                this = kLFTb2;
                if (this == null) {
                    return kLFTb3;
                }
                kLFTb = this.f11944wA;
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f11939JHa;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f11945xJ;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f11939JHa;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f11945xJ;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f11939JHa;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f11945xJ;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        /* renamed from: mjFkc */
        public KLFTb m11161mjFkc() {
            KLFTb kLFTb = this.f11938AZxh;
            while (true) {
                KLFTb kLFTb2 = kLFTb;
                KLFTb kLFTb3 = this;
                this = kLFTb2;
                if (this == null) {
                    return kLFTb3;
                }
                kLFTb = this.f11938AZxh;
            }
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f11945xJ;
            this.f11945xJ = obj;
            return obj2;
        }

        public String toString() {
            return this.f11939JHa + "=" + this.f11945xJ;
        }

        public KLFTb(KLFTb kLFTb, Object obj, KLFTb kLFTb2, KLFTb kLFTb3) {
            this.f11943mjFkc = kLFTb;
            this.f11939JHa = obj;
            this.f11942lgHUyS = 1;
            this.f11941ZfxDd = kLFTb2;
            this.f11940KLFTb = kLFTb3;
            kLFTb3.f11941ZfxDd = this;
            kLFTb2.f11940KLFTb = this;
        }
    }
}
