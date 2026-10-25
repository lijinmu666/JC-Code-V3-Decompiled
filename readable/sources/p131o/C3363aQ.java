package p131o;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: o.aQ */
/* loaded from: classes.dex */
public final class C3363aQ {

    /* renamed from: AZxh */
    public final Map f12753AZxh;

    /* renamed from: mjFkc */
    public final String f12754mjFkc;

    /* renamed from: o.aQ$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public Map f12755AZxh = null;

        /* renamed from: mjFkc */
        public final String f12756mjFkc;

        public AZxh(String str) {
            this.f12756mjFkc = str;
        }

        /* renamed from: AZxh */
        public AZxh m11315AZxh(Annotation annotation) {
            if (this.f12755AZxh == null) {
                this.f12755AZxh = new HashMap();
            }
            this.f12755AZxh.put(annotation.annotationType(), annotation);
            return this;
        }

        /* renamed from: mjFkc */
        public C3363aQ m11316mjFkc() {
            return new C3363aQ(this.f12756mjFkc, this.f12755AZxh == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f12755AZxh)));
        }
    }

    /* renamed from: ZfxDd */
    public static C3363aQ m11310ZfxDd(String str) {
        return new C3363aQ(str, Collections.emptyMap());
    }

    /* renamed from: mjFkc */
    public static AZxh m11311mjFkc(String str) {
        return new AZxh(str);
    }

    /* renamed from: AZxh */
    public String m11312AZxh() {
        return this.f12754mjFkc;
    }

    /* renamed from: equals */
    public boolean m11313equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3363aQ)) {
            return false;
        }
        C3363aQ c3363aQ = (C3363aQ) obj;
        return this.f12754mjFkc.equals(c3363aQ.f12754mjFkc) && this.f12753AZxh.equals(c3363aQ.f12753AZxh);
    }

    public int hashCode() {
        return (this.f12754mjFkc.hashCode() * 31) + this.f12753AZxh.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f12754mjFkc + ", properties=" + this.f12753AZxh.values() + "}";
    }

    /* renamed from: wA */
    public Annotation m11314wA(Class cls) {
        return (Annotation) this.f12753AZxh.get(cls);
    }

    public C3363aQ(String str, Map map) {
        this.f12754mjFkc = str;
        this.f12753AZxh = map;
    }
}
