package p131o;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* renamed from: o.ND */
/* loaded from: classes.dex */
public abstract class AbstractC2492ND implements Map, Serializable {

    /* renamed from: AZxh */
    public transient AbstractC2619PD f9716AZxh;

    /* renamed from: mjFkc */
    public transient AbstractC2619PD f9717mjFkc;

    /* renamed from: wA */
    public transient AbstractC4998zD f9718wA;

    /* renamed from: wA */
    public static AbstractC2492ND m9649wA(Object obj, Object obj2) {
        AbstractC1744CC.m7823AZxh("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return C2682QE.m10002xJ(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    @Override // java.util.Map
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public final AbstractC4998zD values() {
        AbstractC4998zD abstractC4998zD = this.f9718wA;
        if (abstractC4998zD != null) {
            return abstractC4998zD;
        }
        AbstractC4998zD abstractC4998zDMo9654mjFkc = mo9654mjFkc();
        this.f9718wA = abstractC4998zDMo9654mjFkc;
        return abstractC4998zDMo9654mjFkc;
    }

    @Override // java.util.Map
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public final AbstractC2619PD entrySet() {
        AbstractC2619PD abstractC2619PD = this.f9717mjFkc;
        if (abstractC2619PD != null) {
            return abstractC2619PD;
        }
        AbstractC2619PD abstractC2619PDMo9653ZfxDd = mo9653ZfxDd();
        this.f9717mjFkc = abstractC2619PDMo9653ZfxDd;
        return abstractC2619PDMo9653ZfxDd;
    }

    /* renamed from: KLFTb */
    public abstract AbstractC2619PD mo9652KLFTb();

    /* renamed from: ZfxDd */
    public abstract AbstractC2619PD mo9653ZfxDd();

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
        return AbstractC2944UE.m10480mjFkc(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        AbstractC2619PD abstractC2619PD = this.f9716AZxh;
        if (abstractC2619PD != null) {
            return abstractC2619PD;
        }
        AbstractC2619PD abstractC2619PDMo9652KLFTb = mo9652KLFTb();
        this.f9716AZxh = abstractC2619PDMo9652KLFTb;
        return abstractC2619PDMo9652KLFTb;
    }

    /* renamed from: mjFkc */
    public abstract AbstractC4998zD mo9654mjFkc();

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
        AbstractC1744CC.m7824mjFkc(size, "size");
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
