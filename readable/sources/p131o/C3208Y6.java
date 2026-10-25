package p131o;

import android.os.Build;
import android.view.View;

/* renamed from: o.Y6 */
/* loaded from: classes.dex */
public final class C3208Y6 {

    /* renamed from: mjFkc */
    public final wA f11803mjFkc;

    /* renamed from: o.Y6$AZxh */
    public static class AZxh extends mjFkc {

        /* renamed from: AZxh */
        public View f11804AZxh;

        public AZxh(View view) {
            super(view);
            this.f11804AZxh = view;
        }
    }

    /* renamed from: o.Y6$mjFkc */
    public static class mjFkc extends wA {

        /* renamed from: mjFkc */
        public final View f11805mjFkc;

        public mjFkc(View view) {
            this.f11805mjFkc = view;
        }
    }

    /* renamed from: o.Y6$wA */
    public static class wA {
    }

    public C3208Y6(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f11803mjFkc = new AZxh(view);
        } else {
            this.f11803mjFkc = new mjFkc(view);
        }
    }
}
