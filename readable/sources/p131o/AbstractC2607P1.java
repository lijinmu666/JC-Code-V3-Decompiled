package p131o;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: o.P1 */
/* loaded from: classes.dex */
public abstract class AbstractC2607P1 {
    /* renamed from: AZxh */
    public static AbstractC4638tnpR m9939AZxh() {
        return new C2072H5();
    }

    /* renamed from: JHa */
    public static void m9940JHa(View view, C2542O1 c2542o1) {
        if (c2542o1.m9819Vnb()) {
            c2542o1.m9808JrJO(AbstractC4557sa.m13504ZfxDd(view));
        }
    }

    /* renamed from: KLFTb */
    public static void m9941KLFTb(View view) {
        Drawable background = view.getBackground();
        if (background instanceof C2542O1) {
            m9940JHa(view, (C2542O1) background);
        }
    }

    /* renamed from: ZfxDd */
    public static void m9942ZfxDd(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof C2542O1) {
            ((C2542O1) background).m9801GMIER(f);
        }
    }

    /* renamed from: mjFkc */
    public static AbstractC4638tnpR m9943mjFkc(int i) {
        return i != 0 ? i != 1 ? m9939AZxh() : new C2990UqgK() : new C2072H5();
    }

    /* renamed from: wA */
    public static C4475rKxis m9944wA() {
        return new C4475rKxis();
    }
}
