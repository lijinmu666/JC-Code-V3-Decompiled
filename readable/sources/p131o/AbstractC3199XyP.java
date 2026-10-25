package p131o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;
import org.conscrypt.BuildConfig;

/* renamed from: o.XyP */
/* loaded from: classes.dex */
public abstract class AbstractC3199XyP {

    /* renamed from: mjFkc */
    public static final C3401b f11756mjFkc = new C3401b("CommonUtils", BuildConfig.f24315FLAVOR);

    /* renamed from: AZxh */
    public static String m11003AZxh(Locale locale) {
        if (AbstractC4856x3.m13893ZfxDd()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb.append("-");
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }

    /* renamed from: mjFkc */
    public static String m11004mjFkc(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            f11756mjFkc.m11443wA("CommonUtils", "Exception thrown when trying to get app version ".concat(e.toString()));
            return BuildConfig.f24315FLAVOR;
        }
    }
}
