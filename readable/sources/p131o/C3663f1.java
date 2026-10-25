package p131o;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: o.f1 */
/* loaded from: classes.dex */
public final class C3663f1 {

    /* renamed from: AZxh */
    public static final C3663f1 f13516AZxh = m11878mjFkc(new Locale[0]);

    /* renamed from: mjFkc */
    public final InterfaceC3728g1 f13517mjFkc;

    /* renamed from: o.f1$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static LocaleList m11883AZxh() {
            return LocaleList.getAdjustedDefault();
        }

        /* renamed from: mjFkc */
        public static LocaleList m11884mjFkc(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        /* renamed from: wA */
        public static LocaleList m11885wA() {
            return LocaleList.getDefault();
        }
    }

    public C3663f1(InterfaceC3728g1 interfaceC3728g1) {
        this.f13517mjFkc = interfaceC3728g1;
    }

    /* renamed from: KLFTb */
    public static C3663f1 m11877KLFTb(LocaleList localeList) {
        return new C3663f1(new C3797h1(localeList));
    }

    /* renamed from: mjFkc */
    public static C3663f1 m11878mjFkc(Locale... localeArr) {
        return m11877KLFTb(mjFkc.m11884mjFkc(localeArr));
    }

    /* renamed from: AZxh */
    public Locale m11879AZxh(int i) {
        return this.f13517mjFkc.mo11975get(i);
    }

    /* renamed from: ZfxDd */
    public Object m11880ZfxDd() {
        return this.f13517mjFkc.mo11976mjFkc();
    }

    /* renamed from: equals */
    public boolean m11881equals(Object obj) {
        return (obj instanceof C3663f1) && this.f13517mjFkc.equals(((C3663f1) obj).f13517mjFkc);
    }

    public int hashCode() {
        return this.f13517mjFkc.hashCode();
    }

    public String toString() {
        return this.f13517mjFkc.toString();
    }

    /* renamed from: wA */
    public int m11882wA() {
        return this.f13517mjFkc.mo11977size();
    }
}
