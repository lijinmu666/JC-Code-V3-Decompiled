package p131o;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: o.h1 */
/* loaded from: classes.dex */
public final class C3797h1 implements InterfaceC3728g1 {

    /* renamed from: mjFkc */
    public final LocaleList f13916mjFkc;

    public C3797h1(Object obj) {
        this.f13916mjFkc = (LocaleList) obj;
    }

    /* renamed from: equals */
    public boolean m12162equals(Object obj) {
        return this.f13916mjFkc.equals(((InterfaceC3728g1) obj).mo11976mjFkc());
    }

    @Override // p131o.InterfaceC3728g1
    /* renamed from: get */
    public Locale mo11975get(int i) {
        return this.f13916mjFkc.get(i);
    }

    public int hashCode() {
        return this.f13916mjFkc.hashCode();
    }

    @Override // p131o.InterfaceC3728g1
    /* renamed from: mjFkc */
    public Object mo11976mjFkc() {
        return this.f13916mjFkc;
    }

    @Override // p131o.InterfaceC3728g1
    /* renamed from: size */
    public int mo11977size() {
        return this.f13916mjFkc.size();
    }

    public String toString() {
        return this.f13916mjFkc.toString();
    }
}
