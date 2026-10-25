package p131o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p012widget.ActionMenuView;
import androidx.appcompat.p012widget.C0047mjFkc;

/* renamed from: o.AZxh */
/* loaded from: classes.dex */
public abstract class AbstractC1633AZxh extends ViewGroup {

    /* renamed from: AZxh */
    public final Context f7371AZxh;

    /* renamed from: JHa */
    public boolean f7372JHa;

    /* renamed from: KLFTb */
    public int f7373KLFTb;

    /* renamed from: ZfxDd */
    public C0047mjFkc f7374ZfxDd;

    /* renamed from: mjFkc */
    public final mjFkc f7375mjFkc;

    /* renamed from: wA */
    public ActionMenuView f7376wA;

    /* renamed from: xJ */
    public boolean f7377xJ;

    /* renamed from: o.AZxh$mjFkc */
    public class mjFkc {

        /* renamed from: mjFkc */
        public boolean f7379mjFkc = false;

        public mjFkc() {
        }
    }

    public AbstractC1633AZxh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7375mjFkc = new mjFkc();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC3862i4.f14116mjFkc, typedValue, true) || typedValue.resourceId == 0) {
            this.f7371AZxh = context;
        } else {
            this.f7371AZxh = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* renamed from: AZxh */
    public static int m7609AZxh(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f7373KLFTb;
    }

    /* renamed from: mjFkc */
    public int m7610mjFkc(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC3407b5.f12991mjFkc, AbstractC3862i4.f14120wA, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(AbstractC3407b5.f13004qdMbNW, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0047mjFkc c0047mjFkc = this.f7374ZfxDd;
        if (c0047mjFkc != null) {
            c0047mjFkc.m364lB(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f7377xJ = false;
        }
        if (!this.f7377xJ) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f7377xJ = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f7377xJ = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7372JHa = false;
        }
        if (!this.f7372JHa) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f7372JHa = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f7372JHa = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            super.setVisibility(i);
        }
    }

    /* renamed from: wA */
    public int m7611wA(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
