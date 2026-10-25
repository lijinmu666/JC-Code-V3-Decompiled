package p131o;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* renamed from: o.FT */
/* loaded from: classes.dex */
public abstract class AbstractC1963FT implements Map, Serializable {

    /* renamed from: AZxh */
    public transient AbstractC4485rU f8199AZxh;

    /* renamed from: mjFkc */
    public transient AbstractC4485rU f8200mjFkc;

    /* renamed from: wA */
    public transient AbstractC2566OO f8201wA;

    /* renamed from: wA */
    public static AbstractC1963FT m8294wA(Object obj, Object obj2) {
        AbstractC4343pL.m13124mjFkc("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return C3568dX.m11727xJ(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, null);
    }

    @Override // java.util.Map
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public final AbstractC2566OO values() {
        AbstractC2566OO abstractC2566OO = this.f8201wA;
        if (abstractC2566OO != null) {
            return abstractC2566OO;
        }
        AbstractC2566OO abstractC2566OOMo8299mjFkc = mo8299mjFkc();
        this.f8201wA = abstractC2566OOMo8299mjFkc;
        return abstractC2566OOMo8299mjFkc;
    }

    @Override // java.util.Map
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public final AbstractC4485rU entrySet() {
        AbstractC4485rU abstractC4485rU = this.f8200mjFkc;
        if (abstractC4485rU != null) {
            return abstractC4485rU;
        }
        AbstractC4485rU abstractC4485rUMo8298ZfxDd = mo8298ZfxDd();
        this.f8200mjFkc = abstractC4485rUMo8298ZfxDd;
        return abstractC4485rUMo8298ZfxDd;
    }

    /* renamed from: KLFTb */
    public abstract AbstractC4485rU mo8297KLFTb();

    /* renamed from: ZfxDd */
    public abstract AbstractC4485rU mo8298ZfxDd();

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
        return AbstractC1676BB.m7687mjFkc(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        AbstractC4485rU abstractC4485rU = this.f8199AZxh;
        if (abstractC4485rU != null) {
            return abstractC4485rU;
        }
        AbstractC4485rU abstractC4485rUMo8297KLFTb = mo8297KLFTb();
        this.f8199AZxh = abstractC4485rUMo8297KLFTb;
        return abstractC4485rUMo8297KLFTb;
    }

    /* renamed from: mjFkc */
    public abstract AbstractC2566OO mo8299mjFkc();

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
