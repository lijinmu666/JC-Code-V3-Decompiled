package p131o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

/* renamed from: o.k */
/* loaded from: classes.dex */
public class C3990k {

    /* renamed from: AZxh */
    public static C3990k f14410AZxh;

    /* renamed from: mjFkc */
    public final Context f14411mjFkc;

    public C3990k(Context context) {
        this.f14411mjFkc = context.getApplicationContext();
    }

    /* renamed from: AZxh */
    public static final AbstractBinderC1821DM m12456AZxh(PackageInfo packageInfo, AbstractBinderC1821DM... abstractBinderC1821DMArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            BinderC2302KN binderC2302KN = new BinderC2302KN(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < abstractBinderC1821DMArr.length; i++) {
                if (abstractBinderC1821DMArr[i].m7994equals(binderC2302KN)) {
                    return abstractBinderC1821DMArr[i];
                }
            }
        }
        return null;
    }

    /* renamed from: mjFkc */
    public static C3990k m12457mjFkc(Context context) {
        AbstractC2138I3.m8648xJ(context);
        synchronized (C3990k.class) {
            try {
                if (f14410AZxh == null) {
                    AbstractC4019kR.m12546mjFkc(context);
                    f14410AZxh = new C3990k(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f14410AZxh;
    }

    /* renamed from: wA */
    public static final boolean m12458wA(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? m12456AZxh(packageInfo2, AbstractC3690fQ.f13578mjFkc) : m12456AZxh(packageInfo2, AbstractC3690fQ.f13578mjFkc[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
