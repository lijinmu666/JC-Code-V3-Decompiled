package p131o;

import android.content.Context;
import android.content.res.Configuration;

/* renamed from: o.lB */
/* loaded from: classes.dex */
public class C4068lB {

    /* renamed from: mjFkc */
    public Context f14677mjFkc;

    public C4068lB(Context context) {
        this.f14677mjFkc = context;
    }

    /* renamed from: mjFkc */
    public static C4068lB m12686mjFkc(Context context) {
        return new C4068lB(context);
    }

    /* renamed from: AZxh */
    public int m12687AZxh() {
        return this.f14677mjFkc.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: ZfxDd */
    public boolean m12688ZfxDd() {
        return true;
    }

    /* renamed from: wA */
    public int m12689wA() {
        Configuration configuration = this.f14677mjFkc.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }
}
