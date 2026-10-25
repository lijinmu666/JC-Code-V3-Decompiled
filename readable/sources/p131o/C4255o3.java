package p131o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* renamed from: o.o3 */
/* loaded from: classes.dex */
public class C4255o3 {

    /* renamed from: mjFkc */
    public final Context f15496mjFkc;

    public C4255o3(Context context) {
        this.f15496mjFkc = context;
    }

    /* renamed from: AZxh */
    public CharSequence m12929AZxh(String str) {
        Context context = this.f15496mjFkc;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    /* renamed from: mjFkc */
    public ApplicationInfo m12930mjFkc(String str, int i) {
        return this.f15496mjFkc.getPackageManager().getApplicationInfo(str, i);
    }

    /* renamed from: wA */
    public PackageInfo m12931wA(String str, int i) {
        return this.f15496mjFkc.getPackageManager().getPackageInfo(str, i);
    }
}
