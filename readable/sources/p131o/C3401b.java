package p131o;

import android.util.Log;

/* renamed from: o.b */
/* loaded from: classes.dex */
public final class C3401b {

    /* renamed from: AZxh */
    public final String f12842AZxh;

    /* renamed from: mjFkc */
    public final String f12843mjFkc;

    public C3401b(String str, String str2) {
        AbstractC2138I3.m8644lgHUyS(str, "log tag cannot be null");
        AbstractC2138I3.m8647wA(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f12843mjFkc = str;
        this.f12842AZxh = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    /* renamed from: AZxh */
    public void m11438AZxh(String str, String str2) {
        if (m11442mjFkc(3)) {
            Log.d(str, m11444xJ(str2));
        }
    }

    /* renamed from: JHa */
    public void m11439JHa(String str, String str2) {
        if (m11442mjFkc(5)) {
            Log.w(str, m11444xJ(str2));
        }
    }

    /* renamed from: KLFTb */
    public void m11440KLFTb(String str, String str2) {
        if (m11442mjFkc(2)) {
            Log.v(str, m11444xJ(str2));
        }
    }

    /* renamed from: ZfxDd */
    public void m11441ZfxDd(String str, String str2, Throwable th) {
        if (m11442mjFkc(6)) {
            Log.e(str, m11444xJ(str2), th);
        }
    }

    /* renamed from: mjFkc */
    public boolean m11442mjFkc(int i) {
        return Log.isLoggable(this.f12843mjFkc, i);
    }

    /* renamed from: wA */
    public void m11443wA(String str, String str2) {
        if (m11442mjFkc(6)) {
            Log.e(str, m11444xJ(str2));
        }
    }

    /* renamed from: xJ */
    public final String m11444xJ(String str) {
        String str2 = this.f12842AZxh;
        return str2 == null ? str : str2.concat(str);
    }
}
