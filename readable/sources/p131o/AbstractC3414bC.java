package p131o;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* renamed from: o.bC */
/* loaded from: classes.dex */
public abstract class AbstractC3414bC implements Map, Serializable {

    /* renamed from: AZxh */
    public transient AbstractC3674fC f13074AZxh;

    /* renamed from: mjFkc */
    public transient AbstractC3674fC f13075mjFkc;

    /* renamed from: wA */
    public transient AbstractC2014GB f13076wA;

    /* renamed from: wA */
    public static AbstractC3414bC m11474wA(Object obj, Object obj2) {
        AbstractC2638PW.m9959mjFkc("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return C1811DC.m7983xJ(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    @Override // java.util.Map
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public final AbstractC2014GB values() {
        AbstractC2014GB abstractC2014GB = this.f13076wA;
        if (abstractC2014GB != null) {
            return abstractC2014GB;
        }
        AbstractC2014GB abstractC2014GBMo7986mjFkc = mo7986mjFkc();
        this.f13076wA = abstractC2014GBMo7986mjFkc;
        return abstractC2014GBMo7986mjFkc;
    }

    @Override // java.util.Map
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public final AbstractC3674fC entrySet() {
        AbstractC3674fC abstractC3674fC = this.f13075mjFkc;
        if (abstractC3674fC != null) {
            return abstractC3674fC;
        }
        AbstractC3674fC abstractC3674fCMo7985ZfxDd = mo7985ZfxDd();
        this.f13075mjFkc = abstractC3674fCMo7985ZfxDd;
        return abstractC3674fCMo7985ZfxDd;
    }

    /* renamed from: KLFTb */
    public abstract AbstractC3674fC mo7984KLFTb();

    /* renamed from: ZfxDd */
    public abstract AbstractC3674fC mo7985ZfxDd();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return AbstractC2015GC.m8415mjFkc(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        AbstractC3674fC abstractC3674fC = this.f13074AZxh;
        if (abstractC3674fC != null) {
            return abstractC3674fC;
        }
        AbstractC3674fC abstractC3674fCMo7984KLFTb = mo7984KLFTb();
        this.f13074AZxh = abstractC3674fCMo7984KLFTb;
        return abstractC3674fCMo7984KLFTb;
    }

    /* renamed from: mjFkc */
    public abstract AbstractC2014GB mo7986mjFkc();

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
