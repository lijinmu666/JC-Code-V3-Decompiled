package p131o;

import android.util.Log;

/* renamed from: o.m1 */
/* loaded from: classes.dex */
public abstract class AbstractC4122m1 {
    /* renamed from: AZxh */
    public static void m12733AZxh(String str, String str2, Object... objArr) {
        Log.d(m12736ZfxDd(str), String.format(str2, objArr));
    }

    /* renamed from: JHa */
    public static void m12734JHa(String str, String str2, Object obj) {
        Log.w(m12736ZfxDd(str), String.format(str2, obj));
    }

    /* renamed from: KLFTb */
    public static void m12735KLFTb(String str, String str2) {
        Log.i(m12736ZfxDd(str), str2);
    }

    /* renamed from: ZfxDd */
    public static String m12736ZfxDd(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: mjFkc */
    public static void m12737mjFkc(String str, String str2, Object obj) {
        Log.d(m12736ZfxDd(str), String.format(str2, obj));
    }

    /* renamed from: wA */
    public static void m12738wA(String str, String str2, Throwable th) {
        Log.e(m12736ZfxDd(str), str2, th);
    }
}
