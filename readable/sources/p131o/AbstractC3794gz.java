package p131o;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: o.gz */
/* loaded from: classes.dex */
public abstract class AbstractC3794gz extends AbstractMap {

    /* renamed from: AZxh */
    public int f13889AZxh;

    /* renamed from: KLFTb */
    public volatile C3660ez f13891KLFTb;

    /* renamed from: ZfxDd */
    public boolean f13892ZfxDd;

    /* renamed from: mjFkc */
    public Object[] f13893mjFkc;

    /* renamed from: wA */
    public Map f13894wA = Collections.emptyMap();

    /* renamed from: JHa */
    public Map f13890JHa = Collections.emptyMap();

    public /* synthetic */ AbstractC3794gz(AbstractC3725fz abstractC3725fz) {
    }

    /* renamed from: Dt */
    public final boolean m12122Dt() {
        return this.f13892ZfxDd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        m12128rkYL();
        int iM12125VA = m12125VA(comparable);
        if (iM12125VA >= 0) {
            return ((C3400az) this.f13893mjFkc[iM12125VA]).setValue(obj);
        }
        m12128rkYL();
        if (this.f13893mjFkc == null) {
            this.f13893mjFkc = new Object[16];
        }
        int i = -(iM12125VA + 1);
        if (i >= 16) {
            return m12126YoKzxo().put(comparable, obj);
        }
        if (this.f13889AZxh == 16) {
            C3400az c3400az = (C3400az) this.f13893mjFkc[15];
            this.f13889AZxh = 15;
            m12126YoKzxo().put(c3400az.m11437KLFTb(), c3400az.getValue());
        }
        Object[] objArr = this.f13893mjFkc;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.f13893mjFkc[i] = new C3400az(this, comparable, obj);
        this.f13889AZxh++;
        return null;
    }

    /* renamed from: MiMN */
    public final Object m12124MiMN(int i) {
        m12128rkYL();
        Object value = ((C3400az) this.f13893mjFkc[i]).getValue();
        Object[] objArr = this.f13893mjFkc;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f13889AZxh - i) - 1);
        this.f13889AZxh--;
        if (!this.f13894wA.isEmpty()) {
            Iterator it = m12126YoKzxo().entrySet().iterator();
            Object[] objArr2 = this.f13893mjFkc;
            int i2 = this.f13889AZxh;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new C3400az(this, (Comparable) entry.getKey(), entry.getValue());
            this.f13889AZxh++;
            it.remove();
        }
        return value;
    }

    /* renamed from: VA */
    public final int m12125VA(Comparable comparable) {
        int i = this.f13889AZxh;
        int i2 = i - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((C3400az) this.f13893mjFkc[i2]).m11437KLFTb());
            if (iCompareTo > 0) {
                return -(i + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((C3400az) this.f13893mjFkc[i4]).m11437KLFTb());
            if (iCompareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    /* renamed from: YoKzxo */
    public final SortedMap m12126YoKzxo() {
        m12128rkYL();
        if (this.f13894wA.isEmpty() && !(this.f13894wA instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f13894wA = treeMap;
            this.f13890JHa = treeMap.descendingMap();
        }
        return (SortedMap) this.f13894wA;
    }

    /* renamed from: ZfxDd */
    public final Iterable m12127ZfxDd() {
        return this.f13894wA.isEmpty() ? Collections.emptySet() : this.f13894wA.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        m12128rkYL();
        if (this.f13889AZxh != 0) {
            this.f13893mjFkc = null;
            this.f13889AZxh = 0;
        }
        if (this.f13894wA.isEmpty()) {
            return;
        }
        this.f13894wA.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m12125VA(comparable) >= 0 || this.f13894wA.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f13891KLFTb == null) {
            this.f13891KLFTb = new C3660ez(this, null);
        }
        return this.f13891KLFTb;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC3794gz)) {
            return super.equals(obj);
        }
        AbstractC3794gz abstractC3794gz = (AbstractC3794gz) obj;
        int size = size();
        if (size != abstractC3794gz.size()) {
            return false;
        }
        int i = this.f13889AZxh;
        if (i != abstractC3794gz.f13889AZxh) {
            return entrySet().equals(abstractC3794gz.entrySet());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!m12130xJ(i2).equals(abstractC3794gz.m12130xJ(i2))) {
                return false;
            }
        }
        if (i != size) {
            return this.f13894wA.equals(abstractC3794gz.f13894wA);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM12125VA = m12125VA(comparable);
        return iM12125VA >= 0 ? ((C3400az) this.f13893mjFkc[iM12125VA]).getValue() : this.f13894wA.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.f13889AZxh;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.f13893mjFkc[i2].hashCode();
        }
        return this.f13894wA.size() > 0 ? iHashCode + this.f13894wA.hashCode() : iHashCode;
    }

    /* renamed from: mjFkc */
    public void mo11236mjFkc() {
        if (this.f13892ZfxDd) {
            return;
        }
        this.f13894wA = this.f13894wA.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f13894wA);
        this.f13890JHa = this.f13890JHa.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f13890JHa);
        this.f13892ZfxDd = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m12128rkYL();
        Comparable comparable = (Comparable) obj;
        int iM12125VA = m12125VA(comparable);
        if (iM12125VA >= 0) {
            return m12124MiMN(iM12125VA);
        }
        if (this.f13894wA.isEmpty()) {
            return null;
        }
        return this.f13894wA.remove(comparable);
    }

    /* renamed from: rkYL */
    public final void m12128rkYL() {
        if (this.f13892ZfxDd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f13889AZxh + this.f13894wA.size();
    }

    /* renamed from: wA */
    public final int m12129wA() {
        return this.f13889AZxh;
    }

    /* renamed from: xJ */
    public final Map.Entry m12130xJ(int i) {
        if (i < this.f13889AZxh) {
            return (C3400az) this.f13893mjFkc[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }
}
