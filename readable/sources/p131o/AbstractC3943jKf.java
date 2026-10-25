package p131o;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: o.jKf */
/* loaded from: classes.dex */
public abstract class AbstractC3943jKf {

    /* renamed from: AZxh */
    public static Boolean f14302AZxh;

    /* renamed from: ZfxDd */
    public static Boolean f14303ZfxDd;

    /* renamed from: mjFkc */
    public static Boolean f14304mjFkc;

    /* renamed from: wA */
    public static Boolean f14305wA;

    /* renamed from: AZxh */
    public static boolean m12428AZxh(Context context) {
        return m12429JHa(context.getPackageManager());
    }

    /* renamed from: JHa */
    public static boolean m12429JHa(PackageManager packageManager) {
        if (f14304mjFkc == null) {
            boolean z = false;
            if (AbstractC4856x3.m13897wA() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            f14304mjFkc = Boolean.valueOf(z);
        }
        return f14304mjFkc.booleanValue();
    }

    /* renamed from: KLFTb */
    public static boolean m12430KLFTb(Context context) {
        if (f14305wA == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f14305wA = Boolean.valueOf(z);
        }
        return f14305wA.booleanValue();
    }

    /* renamed from: ZfxDd */
    public static boolean m12431ZfxDd(Context context) {
        if (f14302AZxh == null) {
            boolean z = false;
            if (AbstractC4856x3.m13893ZfxDd() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            f14302AZxh = Boolean.valueOf(z);
        }
        return f14302AZxh.booleanValue();
    }

    /* renamed from: mjFkc */
    public static boolean m12432mjFkc(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f14303ZfxDd == null) {
            boolean z = false;
            if (AbstractC4856x3.m13891JHa() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            f14303ZfxDd = Boolean.valueOf(z);
        }
        return f14303ZfxDd.booleanValue();
    }

    /* renamed from: wA */
    public static boolean m12433wA(Context context) {
        if (m12428AZxh(context) && !AbstractC4856x3.m13892KLFTb()) {
            return true;
        }
        if (m12431ZfxDd(context)) {
            return !AbstractC4856x3.m13891JHa() || AbstractC4856x3.m13894lgHUyS();
        }
        return false;
    }
}
