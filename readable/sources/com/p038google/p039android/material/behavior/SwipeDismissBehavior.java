package com.p038google.p039android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import p131o.AbstractC2876T9;
import p131o.C2971Ucbh;
import p131o.C3211Y9;
import p131o.InterfaceC2087HGpJ;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: AZxh */
    public InterfaceC0228wA f2324AZxh;

    /* renamed from: JHa */
    public boolean f2327JHa;

    /* renamed from: ZfxDd */
    public boolean f2329ZfxDd;

    /* renamed from: mjFkc */
    public C3211Y9 f2331mjFkc;

    /* renamed from: wA */
    public boolean f2333wA;

    /* renamed from: KLFTb */
    public float f2328KLFTb = 0.0f;

    /* renamed from: xJ */
    public int f2334xJ = 2;

    /* renamed from: lgHUyS */
    public float f2330lgHUyS = 0.5f;

    /* renamed from: qdMbNW */
    public float f2332qdMbNW = 0.0f;

    /* renamed from: Dt */
    public float f2325Dt = 0.5f;

    /* renamed from: ETF */
    public final C3211Y9.wA f2326ETF = new C0227mjFkc();

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$AZxh */
    public class C0225AZxh implements InterfaceC2087HGpJ {
        public C0225AZxh() {
        }

        @Override // p131o.InterfaceC2087HGpJ
        /* renamed from: mjFkc */
        public boolean mo2482mjFkc(View view, InterfaceC2087HGpJ.mjFkc mjfkc) {
            if (!SwipeDismissBehavior.this.mo2476OjSQV(view)) {
                return false;
            }
            boolean z = AbstractC2876T9.m10276huTpC(view) == 1;
            int i = SwipeDismissBehavior.this.f2334xJ;
            AbstractC2876T9.m10259WrLQs(view, (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            InterfaceC0228wA interfaceC0228wA = SwipeDismissBehavior.this.f2324AZxh;
            if (interfaceC0228wA != null) {
                interfaceC0228wA.mo2493mjFkc(view);
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$ZfxDd */
    public class RunnableC0226ZfxDd implements Runnable {

        /* renamed from: AZxh */
        public final boolean f2336AZxh;

        /* renamed from: mjFkc */
        public final View f2337mjFkc;

        public RunnableC0226ZfxDd(View view, boolean z) {
            this.f2337mjFkc = view;
            this.f2336AZxh = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC0228wA interfaceC0228wA;
            C3211Y9 c3211y9 = SwipeDismissBehavior.this.f2331mjFkc;
            if (c3211y9 != null && c3211y9.m11055ETF(true)) {
                AbstractC2876T9.m10258WGXroI(this.f2337mjFkc, this);
            } else {
                if (!this.f2336AZxh || (interfaceC0228wA = SwipeDismissBehavior.this.f2324AZxh) == null) {
                    return;
                }
                interfaceC0228wA.mo2493mjFkc(this.f2337mjFkc);
            }
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$mjFkc */
    public class C0227mjFkc extends C3211Y9.wA {

        /* renamed from: AZxh */
        public int f2339AZxh = -1;

        /* renamed from: mjFkc */
        public int f2340mjFkc;

        public C0227mjFkc() {
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: AZxh */
        public int mo2483AZxh(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: Dt */
        public void mo2484Dt(int i) {
            InterfaceC0228wA interfaceC0228wA = SwipeDismissBehavior.this.f2324AZxh;
            if (interfaceC0228wA != null) {
                interfaceC0228wA.mo2492AZxh(i);
            }
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: ETF */
        public void mo2485ETF(View view, int i, int i2, int i3, int i4) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f2332qdMbNW;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f2325Dt;
            float fAbs = Math.abs(i - this.f2340mjFkc);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m2473Ne(0.0f, 1.0f - SwipeDismissBehavior.m2472KLMXS(width, width2, fAbs), 1.0f));
            }
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: MiMN */
        public boolean mo2486MiMN(View view, int i) {
            int i2 = this.f2339AZxh;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.mo2476OjSQV(view);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // p131o.C3211Y9.wA
        /* renamed from: VA */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo2487VA(View view, float f, float f2) {
            int i;
            boolean z;
            InterfaceC0228wA interfaceC0228wA;
            this.f2339AZxh = -1;
            int width = view.getWidth();
            if (!m2488YoKzxo(view, f)) {
                i = this.f2340mjFkc;
                z = false;
            } else if (f >= 0.0f) {
                int left = view.getLeft();
                int i2 = this.f2340mjFkc;
                i = left < i2 ? this.f2340mjFkc - width : i2 + width;
                z = true;
            }
            if (SwipeDismissBehavior.this.f2331mjFkc.m11062OjSQV(i, view.getTop())) {
                AbstractC2876T9.m10258WGXroI(view, new RunnableC0226ZfxDd(view, z));
            } else {
                if (!z || (interfaceC0228wA = SwipeDismissBehavior.this.f2324AZxh) == null) {
                    return;
                }
                interfaceC0228wA.mo2493mjFkc(view);
            }
        }

        /* renamed from: YoKzxo */
        public final boolean m2488YoKzxo(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.f2340mjFkc) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2330lgHUyS);
            }
            boolean z = AbstractC2876T9.m10276huTpC(view) == 1;
            int i = SwipeDismissBehavior.this.f2334xJ;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: ZfxDd */
        public int mo2489ZfxDd(View view) {
            return view.getWidth();
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: mjFkc */
        public int mo2490mjFkc(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = AbstractC2876T9.m10276huTpC(view) == 1;
            int i3 = SwipeDismissBehavior.this.f2334xJ;
            if (i3 == 0) {
                if (z) {
                    width = this.f2340mjFkc - view.getWidth();
                    width2 = this.f2340mjFkc;
                } else {
                    width = this.f2340mjFkc;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.f2340mjFkc - view.getWidth();
                width2 = this.f2340mjFkc + view.getWidth();
            } else if (z) {
                width = this.f2340mjFkc;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f2340mjFkc - view.getWidth();
                width2 = this.f2340mjFkc;
            }
            return SwipeDismissBehavior.m2471CqaNbM(width, i, width2);
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: qdMbNW */
        public void mo2491qdMbNW(View view, int i) {
            this.f2339AZxh = i;
            this.f2340mjFkc = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f2329ZfxDd = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f2329ZfxDd = false;
            }
        }
    }

    /* renamed from: com.google.android.material.behavior.SwipeDismissBehavior$wA */
    public interface InterfaceC0228wA {
        /* renamed from: AZxh */
        void mo2492AZxh(int i);

        /* renamed from: mjFkc */
        void mo2493mjFkc(View view);
    }

    /* renamed from: CqaNbM */
    public static int m2471CqaNbM(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* renamed from: KLMXS */
    public static float m2472KLMXS(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* renamed from: Ne */
    public static float m2473Ne(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: ETF */
    public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zM482vI = this.f2333wA;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zM482vI = coordinatorLayout.m482vI(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2333wA = zM482vI;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2333wA = false;
        }
        if (!zM482vI) {
            return false;
        }
        m2480xrEuO(coordinatorLayout);
        return !this.f2329ZfxDd && this.f2331mjFkc.m11061Ne(motionEvent);
    }

    /* renamed from: NPj */
    public final void m2475NPj(View view) {
        AbstractC2876T9.m10267bbzow(view, 1048576);
        if (mo2476OjSQV(view)) {
            AbstractC2876T9.m10233JBhc(view, C2971Ucbh.mjFkc.f10864HGpJ, null, new C0225AZxh());
        }
    }

    /* renamed from: OjSQV */
    public boolean mo2476OjSQV(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zMo497VA = super.mo497VA(coordinatorLayout, view, i);
        if (AbstractC2876T9.m10271eyqo(view) == 0) {
            AbstractC2876T9.m10244NKyg(view, 1);
            m2475NPj(view);
        }
        return zMo497VA;
    }

    /* renamed from: Vnb */
    public void m2477Vnb(int i) {
        this.f2334xJ = i;
    }

    /* renamed from: cMLeY */
    public void m2478cMLeY(InterfaceC0228wA interfaceC0228wA) {
        this.f2324AZxh = interfaceC0228wA;
    }

    /* renamed from: rWxwaT */
    public void m2479rWxwaT(float f) {
        this.f2332qdMbNW = m2473Ne(0.0f, f, 1.0f);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: wJVbdd */
    public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f2331mjFkc == null) {
            return false;
        }
        if (this.f2329ZfxDd && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f2331mjFkc.m11079vI(motionEvent);
        return true;
    }

    /* renamed from: xrEuO */
    public final void m2480xrEuO(ViewGroup viewGroup) {
        if (this.f2331mjFkc == null) {
            this.f2331mjFkc = this.f2327JHa ? C3211Y9.m11050VA(viewGroup, this.f2328KLFTb, this.f2326ETF) : C3211Y9.m11049MiMN(viewGroup, this.f2326ETF);
        }
    }

    /* renamed from: zvd */
    public void m2481zvd(float f) {
        this.f2325Dt = m2473Ne(0.0f, f, 1.0f);
    }
}
