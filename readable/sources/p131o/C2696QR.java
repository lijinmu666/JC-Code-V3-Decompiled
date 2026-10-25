package p131o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* renamed from: o.QR */
/* loaded from: classes.dex */
public final class C2696QR {

    /* renamed from: JHa */
    public static final Uri f10179JHa = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: AZxh */
    public final String f10180AZxh;

    /* renamed from: KLFTb */
    public final boolean f10181KLFTb;

    /* renamed from: ZfxDd */
    public final int f10182ZfxDd;

    /* renamed from: mjFkc */
    public final String f10183mjFkc;

    /* renamed from: wA */
    public final ComponentName f10184wA;

    public C2696QR(String str, String str2, int i, boolean z) {
        AbstractC2138I3.m8642KLFTb(str);
        this.f10183mjFkc = str;
        AbstractC2138I3.m8642KLFTb(str2);
        this.f10180AZxh = str2;
        this.f10184wA = null;
        this.f10182ZfxDd = 4225;
        this.f10181KLFTb = z;
    }

    /* renamed from: AZxh */
    public final Intent m10006AZxh(Context context) {
        Bundle bundleCall;
        if (this.f10183mjFkc == null) {
            return new Intent().setComponent(this.f10184wA);
        }
        if (this.f10181KLFTb) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f10183mjFkc);
            try {
                bundleCall = context.getContentResolver().call(f10179JHa, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f10183mjFkc)));
            }
        }
        return intent == null ? new Intent(this.f10183mjFkc).setPackage(this.f10180AZxh) : intent;
    }

    /* renamed from: equals */
    public final boolean m10007equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2696QR)) {
            return false;
        }
        C2696QR c2696qr = (C2696QR) obj;
        return AbstractC2931U2.m10465mjFkc(this.f10183mjFkc, c2696qr.f10183mjFkc) && AbstractC2931U2.m10465mjFkc(this.f10180AZxh, c2696qr.f10180AZxh) && AbstractC2931U2.m10465mjFkc(this.f10184wA, c2696qr.f10184wA) && this.f10181KLFTb == c2696qr.f10181KLFTb;
    }

    public final int hashCode() {
        return AbstractC2931U2.m10464AZxh(this.f10183mjFkc, this.f10180AZxh, this.f10184wA, 4225, Boolean.valueOf(this.f10181KLFTb));
    }

    /* renamed from: mjFkc */
    public final ComponentName m10008mjFkc() {
        return this.f10184wA;
    }

    public final String toString() {
        String str = this.f10183mjFkc;
        if (str != null) {
            return str;
        }
        AbstractC2138I3.m8648xJ(this.f10184wA);
        return this.f10184wA.flattenToString();
    }

    /* renamed from: wA */
    public final String m10009wA() {
        return this.f10180AZxh;
    }
}
