package p131o;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: o.Ey */
/* loaded from: classes.dex */
public final class C1927Ey extends LinkedHashMap {

    /* renamed from: AZxh */
    public static final C1927Ey f8117AZxh;

    /* renamed from: mjFkc */
    public boolean f8118mjFkc;

    static {
        C1927Ey c1927Ey = new C1927Ey();
        f8117AZxh = c1927Ey;
        c1927Ey.f8118mjFkc = false;
    }

    public C1927Ey() {
        this.f8118mjFkc = true;
    }

    /* renamed from: lgHUyS */
    public static int m8235lgHUyS(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        Charset charset = AbstractC4183my.f15287mjFkc;
        int length = bArr.length;
        int iM12815AZxh = AbstractC4183my.m12815AZxh(length, bArr, 0, length);
        if (iM12815AZxh == 0) {
            return 1;
        }
        return iM12815AZxh;
    }

    /* renamed from: mjFkc */
    public static C1927Ey m8236mjFkc() {
        return f8117AZxh;
    }

    /* renamed from: AZxh */
    public final C1927Ey m8237AZxh() {
        return isEmpty() ? new C1927Ey() : new C1927Ey(this);
    }

    /* renamed from: JHa */
    public final boolean m8238JHa() {
        return this.f8118mjFkc;
    }

    /* renamed from: KLFTb */
    public final void m8239KLFTb(C1927Ey c1927Ey) {
        m8240qdMbNW();
        if (c1927Ey.isEmpty()) {
            return;
        }
        putAll(c1927Ey);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m8240qdMbNW();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iM8235lgHUyS = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iM8235lgHUyS += m8235lgHUyS(entry.getValue()) ^ m8235lgHUyS(entry.getKey());
        }
        return iM8235lgHUyS;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        m8240qdMbNW();
        Charset charset = AbstractC4183my.f15287mjFkc;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        m8240qdMbNW();
        for (Object obj : map.keySet()) {
            Charset charset = AbstractC4183my.f15287mjFkc;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    /* renamed from: qdMbNW */
    public final void m8240qdMbNW() {
        if (!this.f8118mjFkc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m8240qdMbNW();
        return super.remove(obj);
    }

    /* renamed from: wA */
    public final void m8241wA() {
        this.f8118mjFkc = false;
    }

    public C1927Ey(Map map) {
        super(map);
        this.f8118mjFkc = true;
    }
}
