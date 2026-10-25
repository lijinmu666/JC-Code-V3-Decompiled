package p131o;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import java.util.List;

/* renamed from: o.u */
/* loaded from: classes.dex */
public abstract class AbstractC4653u extends AbstractC4025ka {

    /* renamed from: JHa */
    public int f16758JHa;

    /* renamed from: KLFTb */
    public final Rect f16759KLFTb;

    /* renamed from: ZfxDd */
    public final Rect f16760ZfxDd;

    /* renamed from: xJ */
    public int f16761xJ;

    public AbstractC4653u() {
        this.f16760ZfxDd = new Rect();
        this.f16759KLFTb = new Rect();
        this.f16758JHa = 0;
    }

    /* renamed from: cMLeY */
    public static int m13660cMLeY(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* renamed from: CqaNbM */
    public final int m13661CqaNbM(View view) {
        if (this.f16761xJ == 0) {
            return 0;
        }
        float fMo2455xrEuO = mo2455xrEuO(view);
        int i = this.f16761xJ;
        return AbstractC2868T1.m10211AZxh((int) (fMo2455xrEuO * i), 0, i);
    }

    /* renamed from: KLMXS */
    public int mo2450KLMXS(View view) {
        return view.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: MiMN */
    public boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewMo2452Ne;
        C3372ab lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewMo2452Ne = mo2452Ne(coordinatorLayout.m474fehf(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (AbstractC2876T9.m10269diqgf(viewMo2452Ne) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m11334ETF() + lastWindowInsets.m11343lgHUyS();
        }
        int iMo2450KLMXS = size + mo2450KLMXS(viewMo2452Ne);
        int measuredHeight = viewMo2452Ne.getMeasuredHeight();
        if (mo2964Vnb()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iMo2450KLMXS -= measuredHeight;
        }
        coordinatorLayout.m451CqaNbM(view, i, i2, View.MeasureSpec.makeMeasureSpec(iMo2450KLMXS, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* renamed from: Ne */
    public abstract View mo2452Ne(List list);

    @Override // p131o.AbstractC4025ka
    /* renamed from: OjSQV */
    public void mo12548OjSQV(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewMo2452Ne = mo2452Ne(coordinatorLayout.m474fehf(view));
        if (viewMo2452Ne == null) {
            super.mo12548OjSQV(coordinatorLayout, view, i);
            this.f16758JHa = 0;
            return;
        }
        CoordinatorLayout.C0060KLFTb c0060KLFTb = (CoordinatorLayout.C0060KLFTb) view.getLayoutParams();
        Rect rect = this.f16760ZfxDd;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).leftMargin, viewMo2452Ne.getBottom() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).rightMargin, ((coordinatorLayout.getHeight() + viewMo2452Ne.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).bottomMargin);
        C3372ab lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && AbstractC2876T9.m10269diqgf(coordinatorLayout) && !AbstractC2876T9.m10269diqgf(view)) {
            rect.left += lastWindowInsets.m11346qdMbNW();
            rect.right -= lastWindowInsets.m11333Dt();
        }
        Rect rect2 = this.f16759KLFTb;
        AbstractC4056l.m12648mjFkc(m13660cMLeY(c0060KLFTb.f933wA), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int iM13661CqaNbM = m13661CqaNbM(viewMo2452Ne);
        view.layout(rect2.left, rect2.top - iM13661CqaNbM, rect2.right, rect2.bottom - iM13661CqaNbM);
        this.f16758JHa = rect2.top - viewMo2452Ne.getBottom();
    }

    /* renamed from: Vnb */
    public boolean mo2964Vnb() {
        return false;
    }

    /* renamed from: rWxwaT */
    public final void m13662rWxwaT(int i) {
        this.f16761xJ = i;
    }

    /* renamed from: xrEuO */
    public abstract float mo2455xrEuO(View view);

    /* renamed from: zvd */
    public final int m13663zvd() {
        return this.f16758JHa;
    }

    public AbstractC4653u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16760ZfxDd = new Rect();
        this.f16759KLFTb = new Rect();
        this.f16758JHa = 0;
    }
}
