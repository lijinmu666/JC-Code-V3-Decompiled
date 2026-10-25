package p131o;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

/* renamed from: o.sa */
/* loaded from: classes.dex */
public abstract class AbstractC4557sa {

    /* renamed from: o.sa$AZxh */
    public class AZxh implements InterfaceC3134X2 {

        /* renamed from: AZxh */
        public final /* synthetic */ KLFTb f16521AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ ZfxDd f16522mjFkc;

        public AZxh(ZfxDd zfxDd, KLFTb kLFTb) {
            this.f16522mjFkc = zfxDd;
            this.f16521AZxh = kLFTb;
        }

        @Override // p131o.InterfaceC3134X2
        /* renamed from: mjFkc */
        public C3372ab mo535mjFkc(View view, C3372ab c3372ab) {
            return this.f16522mjFkc.mo2578mjFkc(view, c3372ab, new KLFTb(this.f16521AZxh));
        }
    }

    /* renamed from: o.sa$ZfxDd */
    public interface ZfxDd {
        /* renamed from: mjFkc */
        C3372ab mo2578mjFkc(View view, C3372ab c3372ab, KLFTb kLFTb);
    }

    /* renamed from: o.sa$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f16527mjFkc;

        public mjFkc(View view) {
            this.f16527mjFkc = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f16527mjFkc.getContext().getSystemService("input_method")).showSoftInput(this.f16527mjFkc, 1);
        }
    }

    /* renamed from: o.sa$wA */
    public class wA implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            AbstractC2876T9.m10255Vdz(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: AZxh */
    public static float m13501AZxh(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: JHa */
    public static PorterDuff.Mode m13502JHa(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: KLFTb */
    public static boolean m13503KLFTb(View view) {
        return AbstractC2876T9.m10276huTpC(view) == 1;
    }

    /* renamed from: ZfxDd */
    public static float m13504ZfxDd(View view) {
        float fM10231IEE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fM10231IEE += AbstractC2876T9.m10231IEE((View) parent);
        }
        return fM10231IEE;
    }

    /* renamed from: lgHUyS */
    public static void m13505lgHUyS(View view) {
        view.requestFocus();
        view.post(new mjFkc(view));
    }

    /* renamed from: mjFkc */
    public static void m13506mjFkc(View view, ZfxDd zfxDd) {
        AbstractC2876T9.m10300yX(view, new AZxh(zfxDd, new KLFTb(AbstractC2876T9.m10224BAnRFn(view), view.getPaddingTop(), AbstractC2876T9.m10257VocHEe(view), view.getPaddingBottom())));
        m13508xJ(view);
    }

    /* renamed from: wA */
    public static Integer m13507wA(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    /* renamed from: xJ */
    public static void m13508xJ(View view) {
        if (AbstractC2876T9.m10268cMLeY(view)) {
            AbstractC2876T9.m10255Vdz(view);
        } else {
            view.addOnAttachStateChangeListener(new wA());
        }
    }

    /* renamed from: o.sa$KLFTb */
    public static class KLFTb {

        /* renamed from: AZxh */
        public int f16523AZxh;

        /* renamed from: ZfxDd */
        public int f16524ZfxDd;

        /* renamed from: mjFkc */
        public int f16525mjFkc;

        /* renamed from: wA */
        public int f16526wA;

        public KLFTb(int i, int i2, int i3, int i4) {
            this.f16525mjFkc = i;
            this.f16523AZxh = i2;
            this.f16526wA = i3;
            this.f16524ZfxDd = i4;
        }

        public KLFTb(KLFTb kLFTb) {
            this.f16525mjFkc = kLFTb.f16525mjFkc;
            this.f16523AZxh = kLFTb.f16523AZxh;
            this.f16526wA = kLFTb.f16526wA;
            this.f16524ZfxDd = kLFTb.f16524ZfxDd;
        }
    }
}
