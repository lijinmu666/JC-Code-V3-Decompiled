package p131o;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* renamed from: o.sc */
/* loaded from: classes.dex */
public abstract class AbstractC4559sc {

    /* renamed from: AZxh */
    public static Locale f16528AZxh;

    /* renamed from: mjFkc */
    public static final C3074W6 f16529mjFkc = new C3074W6();

    /* renamed from: AZxh */
    public static String m13510AZxh(Context context, int i) {
        Resources resources = context.getResources();
        return i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(AbstractC2348L4.f9384mjFkc) : resources.getString(AbstractC2348L4.f9375Dt) : resources.getString(AbstractC2348L4.f9382ZfxDd);
    }

    /* renamed from: JHa */
    public static String m13511JHa(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(AbstractC2348L4.f9377JHa);
            case 2:
                return resources.getString(AbstractC2348L4.f9380VA);
            case 3:
                return resources.getString(AbstractC2348L4.f9387wA);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m13514lgHUyS(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m13514lgHUyS(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return m13514lgHUyS(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m13514lgHUyS(context, "common_google_play_services_restricted_profile_title");
        }
    }

    /* renamed from: KLFTb */
    public static String m13512KLFTb(Context context, int i) {
        String strM13514lgHUyS = i == 6 ? m13514lgHUyS(context, "common_google_play_services_resolution_required_title") : m13511JHa(context, i);
        return strM13514lgHUyS == null ? context.getResources().getString(AbstractC2348L4.f9383lgHUyS) : strM13514lgHUyS;
    }

    /* renamed from: ZfxDd */
    public static String m13513ZfxDd(Context context, int i) {
        return (i == 6 || i == 19) ? m13517xJ(context, "common_google_play_services_resolution_required_text", m13515mjFkc(context)) : m13516wA(context, i);
    }

    /* renamed from: lgHUyS */
    public static String m13514lgHUyS(Context context, String str) {
        C3074W6 c3074w6 = f16529mjFkc;
        synchronized (c3074w6) {
            try {
                Locale localeM11879AZxh = AbstractC1921Es.m8224mjFkc(context.getResources().getConfiguration()).m11879AZxh(0);
                if (!localeM11879AZxh.equals(f16528AZxh)) {
                    c3074w6.m10815clear();
                    f16528AZxh = localeM11879AZxh;
                }
                String str2 = (String) c3074w6.m10817get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesM12261wA = AbstractC3857i.m12261wA(context);
                if (resourcesM12261wA == null) {
                    return null;
                }
                int identifier = resourcesM12261wA.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = resourcesM12261wA.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    c3074w6.m10821put(str, string);
                    return string;
                }
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static String m13515mjFkc(Context context) {
        String packageName = context.getPackageName();
        try {
            return C1703Bb.m7729mjFkc(context).m12929AZxh(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    /* renamed from: wA */
    public static String m13516wA(Context context, int i) {
        Resources resources = context.getResources();
        String strM13515mjFkc = m13515mjFkc(context);
        if (i == 1) {
            return resources.getString(AbstractC2348L4.f9378KLFTb, strM13515mjFkc);
        }
        if (i == 2) {
            return AbstractC3943jKf.m12433wA(context) ? resources.getString(AbstractC2348L4.f9381YoKzxo) : resources.getString(AbstractC2348L4.f9376ETF, strM13515mjFkc);
        }
        if (i == 3) {
            return resources.getString(AbstractC2348L4.f9374AZxh, strM13515mjFkc);
        }
        if (i == 5) {
            return m13517xJ(context, "common_google_play_services_invalid_account_text", strM13515mjFkc);
        }
        if (i == 7) {
            return m13517xJ(context, "common_google_play_services_network_error_text", strM13515mjFkc);
        }
        if (i == 9) {
            return resources.getString(AbstractC2348L4.f9385qdMbNW, strM13515mjFkc);
        }
        if (i == 20) {
            return m13517xJ(context, "common_google_play_services_restricted_profile_text", strM13515mjFkc);
        }
        switch (i) {
            case 16:
                return m13517xJ(context, "common_google_play_services_api_unavailable_text", strM13515mjFkc);
            case 17:
                return m13517xJ(context, "common_google_play_services_sign_in_failed_text", strM13515mjFkc);
            case 18:
                return resources.getString(AbstractC2348L4.f9379MiMN, strM13515mjFkc);
            default:
                return resources.getString(AbstractC2412M4.f9551mjFkc, strM13515mjFkc);
        }
    }

    /* renamed from: xJ */
    public static String m13517xJ(Context context, String str, String str2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        String strM13514lgHUyS = m13514lgHUyS(context, str);
        if (strM13514lgHUyS == null) {
            strM13514lgHUyS = resources.getString(AbstractC2412M4.f9551mjFkc);
        }
        return String.format(resources.getConfiguration().locale, strM13514lgHUyS, str2);
    }
}
