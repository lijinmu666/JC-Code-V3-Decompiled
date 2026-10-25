package p131o;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;

/* renamed from: o.f */
/* loaded from: classes.dex */
public class C3661f {

    /* renamed from: mjFkc */
    public static final int f13514mjFkc = AbstractC3919j.f14233mjFkc;

    /* renamed from: AZxh */
    public static final C3661f f13513AZxh = new C3661f();

    /* renamed from: JHa */
    public static C3661f m11873JHa() {
        return f13513AZxh;
    }

    /* renamed from: AZxh */
    public Intent mo11772AZxh(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && AbstractC3943jKf.m12433wA(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f13514mjFkc);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(C1703Bb.m7729mjFkc(context).m12931wA(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(PKIFailureInfo.signerNotTrusted);
        return intent3;
    }

    /* renamed from: Dt */
    public boolean mo11773Dt(int i) {
        return AbstractC3919j.m12331xJ(i);
    }

    /* renamed from: KLFTb */
    public String mo11776KLFTb(int i) {
        return AbstractC3919j.m12324AZxh(i);
    }

    /* renamed from: ZfxDd */
    public PendingIntent m11874ZfxDd(Context context, int i, int i2, String str) {
        Intent intentMo11772AZxh = mo11772AZxh(context, i, str);
        if (intentMo11772AZxh == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentMo11772AZxh, AbstractC1613AF.f7335mjFkc | 134217728);
    }

    /* renamed from: lgHUyS */
    public int mo11785lgHUyS(Context context, int i) throws PackageManager.NameNotFoundException {
        int iM12327ZfxDd = AbstractC3919j.m12327ZfxDd(context, i);
        if (AbstractC3919j.m12326KLFTb(context, iM12327ZfxDd)) {
            return 18;
        }
        return iM12327ZfxDd;
    }

    /* renamed from: mjFkc */
    public int m11875mjFkc(Context context) {
        return AbstractC3919j.m12329mjFkc(context);
    }

    /* renamed from: qdMbNW */
    public boolean m11876qdMbNW(Context context, String str) {
        return AbstractC3919j.m12328lgHUyS(context, str);
    }

    /* renamed from: wA */
    public PendingIntent mo11788wA(Context context, int i, int i2) {
        return m11874ZfxDd(context, i, i2, null);
    }

    /* renamed from: xJ */
    public int mo11789xJ(Context context) {
        return mo11785lgHUyS(context, f13514mjFkc);
    }
}
