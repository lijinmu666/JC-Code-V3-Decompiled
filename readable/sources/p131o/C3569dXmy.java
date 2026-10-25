package p131o;

/* renamed from: o.dXmy */
/* loaded from: classes.dex */
public final class C3569dXmy {

    /* renamed from: mjFkc */
    public final String f13368mjFkc;

    public C3569dXmy(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f13368mjFkc = str;
    }

    /* renamed from: AZxh */
    public static C3569dXmy m11728AZxh(String str) {
        return new C3569dXmy(str);
    }

    /* renamed from: equals */
    public boolean m11729equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3569dXmy) {
            return this.f13368mjFkc.equals(((C3569dXmy) obj).f13368mjFkc);
        }
        return false;
    }

    public int hashCode() {
        return this.f13368mjFkc.hashCode() ^ 1000003;
    }

    /* renamed from: mjFkc */
    public String m11730mjFkc() {
        return this.f13368mjFkc;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f13368mjFkc + "\"}";
    }
}
