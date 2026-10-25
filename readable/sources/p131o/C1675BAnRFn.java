package p131o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.p012widget.ActionBarContainer;

/* renamed from: o.BAnRFn */
/* loaded from: classes.dex */
public class C1675BAnRFn extends Drawable {

    /* renamed from: mjFkc */
    public final ActionBarContainer f7459mjFkc;

    /* renamed from: o.BAnRFn$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static void m7686mjFkc(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C1675BAnRFn(ActionBarContainer actionBarContainer) {
        this.f7459mjFkc = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f7459mjFkc;
        if (actionBarContainer.f405lgHUyS) {
            Drawable drawable = actionBarContainer.f409xJ;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f403KLFTb;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f7459mjFkc;
        Drawable drawable3 = actionBarContainer2.f402JHa;
        if (drawable3 == null || !actionBarContainer2.f407qdMbNW) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f7459mjFkc;
        if (actionBarContainer.f405lgHUyS) {
            if (actionBarContainer.f409xJ != null) {
                mjFkc.m7686mjFkc(actionBarContainer.f403KLFTb, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f403KLFTb;
            if (drawable != null) {
                mjFkc.m7686mjFkc(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
