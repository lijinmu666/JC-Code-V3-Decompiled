package p131o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.p038google.p039android.p042gms.p046common.GooglePlayServicesIncorrectManifestValueException;
import com.p038google.p039android.p042gms.p046common.GooglePlayServicesMissingManifestValueException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: o.j */
/* loaded from: classes.dex */
public abstract class AbstractC3919j {

    /* renamed from: mjFkc */
    public static final int f14233mjFkc = 12451000;

    /* renamed from: AZxh */
    public static final AtomicBoolean f14232AZxh = new AtomicBoolean();

    /* renamed from: wA */
    public static final AtomicBoolean f14234wA = new AtomicBoolean();

    /* renamed from: AZxh */
    public static String m12324AZxh(int i) {
        return C3613eEOGOh.m11821xJ(i);
    }

    /* renamed from: JHa */
    public static boolean m12325JHa(Context context) {
        if (!AbstractC4856x3.m13890AZxh()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        AbstractC2138I3.m8648xJ(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    /* renamed from: KLFTb */
    public static boolean m12326KLFTb(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return m12328lgHUyS(context, "com.google.android.gms");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* renamed from: ZfxDd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m12327ZfxDd(Context context, int i) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            context.getResources().getString(AbstractC2412M4.f9551mjFkc);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f14234wA.get()) {
            int iM11308mjFkc = AbstractC3348aC.m11308mjFkc(context);
            if (iM11308mjFkc == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (iM11308mjFkc != f14233mjFkc) {
                throw new GooglePlayServicesIncorrectManifestValueException(iM11308mjFkc);
            }
        }
        boolean z = (AbstractC3943jKf.m12433wA(context) || AbstractC3943jKf.m12430KLFTb(context)) ? false : true;
        AbstractC2138I3.m8645mjFkc(i >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C3990k.m12457mjFkc(context);
            if (!C3990k.m12458wA(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else if (z) {
                AbstractC2138I3.m8648xJ(packageInfo);
                if (!C3990k.m12458wA(packageInfo, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else {
                    if (!z || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        if (AbstractC4531sB.m13493mjFkc(packageInfo2.versionCode) >= AbstractC4531sB.m13493mjFkc(i)) {
                            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                            if (applicationInfo == null) {
                                try {
                                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                } catch (PackageManager.NameNotFoundException e) {
                                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                                    return 1;
                                }
                            }
                            return !applicationInfo.enabled ? 3 : 0;
                        }
                        Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + packageInfo2.versionCode);
                        return 2;
                    }
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            }
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    /* renamed from: lgHUyS */
    public static boolean m12328lgHUyS(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        if (AbstractC4856x3.m13893ZfxDd()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !m12325JHa(context);
    }

    /* renamed from: mjFkc */
    public static int m12329mjFkc(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    /* renamed from: wA */
    public static Resources m12330wA(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: xJ */
    public static boolean m12331xJ(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }
}
