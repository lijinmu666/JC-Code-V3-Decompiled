package p131o;

import java.util.Map;

/* renamed from: o.az */
/* loaded from: classes.dex */
public final class C3400az implements Map.Entry, Comparable {

    /* renamed from: AZxh */
    public Object f12839AZxh;

    /* renamed from: mjFkc */
    public final Comparable f12840mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ AbstractC3794gz f12841wA;

    public C3400az(AbstractC3794gz abstractC3794gz, Comparable comparable, Object obj) {
        this.f12841wA = abstractC3794gz;
        this.f12840mjFkc = comparable;
        this.f12839AZxh = obj;
    }

    /* renamed from: lgHUyS */
    public static final boolean m11436lgHUyS(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: KLFTb */
    public final Comparable m11437KLFTb() {
        return this.f12840mjFkc;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f12840mjFkc.compareTo(((C3400az) obj).f12840mjFkc);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m11436lgHUyS(this.f12840mjFkc, entry.getKey()) && m11436lgHUyS(this.f12839AZxh, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f12840mjFkc;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f12839AZxh;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f12840mjFkc;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f12839AZxh;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f12841wA.m12128rkYL();
        Object obj2 = this.f12839AZxh;
        this.f12839AZxh = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f12840mjFkc) + "=" + String.valueOf(this.f12839AZxh);
    }
}
