package com.p038google.p039android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.AbstractC2478N1;
import p131o.AbstractC2481N4;
import p131o.AbstractC2737R4;
import p131o.AbstractC2868T1;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4191n4;
import p131o.AbstractC4557sa;
import p131o.AbstractC4793w7;
import p131o.AbstractC4796wA;
import p131o.C2141I6;
import p131o.C2542O1;
import p131o.C2798S;
import p131o.C2866T;
import p131o.C2971Ucbh;
import p131o.C3211Y9;
import p131o.C3372ab;
import p131o.InterfaceC2087HGpJ;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: ANMGZc */
    public static final int f2350ANMGZc = AbstractC2737R4.f10375wA;

    /* renamed from: AZxh */
    public boolean f2351AZxh;

    /* renamed from: BAnRFn */
    public final C0236xJ f2352BAnRFn;

    /* renamed from: CqaNbM */
    public int f2353CqaNbM;

    /* renamed from: Dt */
    public C2542O1 f2354Dt;

    /* renamed from: ETF */
    public ColorStateList f2355ETF;

    /* renamed from: GMIER */
    public int f2356GMIER;

    /* renamed from: Gd */
    public int f2357Gd;

    /* renamed from: HGpJ */
    public boolean f2358HGpJ;

    /* renamed from: IEE */
    public boolean f2359IEE;

    /* renamed from: JBhc */
    public Map f2360JBhc;

    /* renamed from: JHa */
    public int f2361JHa;

    /* renamed from: JYgkl */
    public WeakReference f2362JYgkl;

    /* renamed from: JYn */
    public WeakReference f2363JYn;

    /* renamed from: JrJO */
    public WeakReference f2364JrJO;

    /* renamed from: KLFTb */
    public int f2365KLFTb;

    /* renamed from: KLMXS */
    public boolean f2366KLMXS;

    /* renamed from: KRTLGT */
    public int f2367KRTLGT;

    /* renamed from: MiMN */
    public int f2368MiMN;

    /* renamed from: NPj */
    public C3211Y9 f2369NPj;

    /* renamed from: Ne */
    public float f2370Ne;

    /* renamed from: OjSQV */
    public int f2371OjSQV;

    /* renamed from: Pq */
    public boolean f2372Pq;

    /* renamed from: SwgkN */
    public boolean f2373SwgkN;

    /* renamed from: Ucbh */
    public boolean f2374Ucbh;

    /* renamed from: VA */
    public int f2375VA;

    /* renamed from: Vdz */
    public final SparseIntArray f2376Vdz;

    /* renamed from: Vnb */
    public int f2377Vnb;

    /* renamed from: VocHEe */
    public boolean f2378VocHEe;

    /* renamed from: WGXroI */
    public VelocityTracker f2379WGXroI;

    /* renamed from: WrLQs */
    public float f2380WrLQs;

    /* renamed from: XV */
    public int f2381XV;

    /* renamed from: YoKzxo */
    public int f2382YoKzxo;

    /* renamed from: ZfxDd */
    public float f2383ZfxDd;

    /* renamed from: aqHPIZ */
    public boolean f2384aqHPIZ;

    /* renamed from: bbzow */
    public int f2385bbzow;

    /* renamed from: cMLeY */
    public boolean f2386cMLeY;

    /* renamed from: diqgf */
    public boolean f2387diqgf;

    /* renamed from: eyqo */
    public boolean f2388eyqo;

    /* renamed from: fehf */
    public boolean f2389fehf;

    /* renamed from: huTpC */
    public int f2390huTpC;

    /* renamed from: jm */
    public final C3211Y9.wA f2391jm;

    /* renamed from: lB */
    public ValueAnimator f2392lB;

    /* renamed from: lgHUyS */
    public int f2393lgHUyS;

    /* renamed from: mByQ */
    public int f2394mByQ;

    /* renamed from: mjFkc */
    public int f2395mjFkc;

    /* renamed from: nxI */
    public final ArrayList f2396nxI;

    /* renamed from: oCFDzJ */
    public int f2397oCFDzJ;

    /* renamed from: qGY */
    public boolean f2398qGY;

    /* renamed from: qdMbNW */
    public int f2399qdMbNW;

    /* renamed from: rWxwaT */
    public int f2400rWxwaT;

    /* renamed from: rkYL */
    public boolean f2401rkYL;

    /* renamed from: uHVRx */
    public int f2402uHVRx;

    /* renamed from: vI */
    public C2141I6 f2403vI;

    /* renamed from: vadzgd */
    public boolean f2404vadzgd;

    /* renamed from: wA */
    public boolean f2405wA;

    /* renamed from: wJVbdd */
    public int f2406wJVbdd;

    /* renamed from: xJ */
    public boolean f2407xJ;

    /* renamed from: xrEuO */
    public float f2408xrEuO;

    /* renamed from: zvd */
    public boolean f2409zvd;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$AZxh */
    public class C0230AZxh implements ValueAnimator.AnimatorUpdateListener {
        public C0230AZxh() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f2354Dt != null) {
                BottomSheetBehavior.this.f2354Dt.m9807JYn(fFloatValue);
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$KLFTb */
    public class C0232KLFTb implements InterfaceC2087HGpJ {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f2418mjFkc;

        public C0232KLFTb(int i) {
            this.f2418mjFkc = i;
        }

        @Override // p131o.InterfaceC2087HGpJ
        /* renamed from: mjFkc */
        public boolean mo2482mjFkc(View view, InterfaceC2087HGpJ.mjFkc mjfkc) {
            BottomSheetBehavior.this.m2564sRqPfw(this.f2418mjFkc);
            return true;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$ZfxDd */
    public class C0233ZfxDd extends C3211Y9.wA {

        /* renamed from: mjFkc */
        public long f2420mjFkc;

        public C0233ZfxDd() {
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: AZxh */
        public int mo2483AZxh(View view, int i, int i2) {
            return AbstractC2868T1.m10211AZxh(i, BottomSheetBehavior.this.m2566tQ(), mo2576KLFTb(view));
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: Dt */
        public void mo2484Dt(int i) {
            if (i == 1 && BottomSheetBehavior.this.f2386cMLeY) {
                BottomSheetBehavior.this.m2539XD(1);
            }
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: ETF */
        public void mo2485ETF(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.m2520ANMGZc(i2);
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: KLFTb */
        public int mo2576KLFTb(View view) {
            return BottomSheetBehavior.this.m2547bbzow() ? BottomSheetBehavior.this.f2402uHVRx : BottomSheetBehavior.this.f2353CqaNbM;
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: MiMN */
        public boolean mo2486MiMN(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.f2400rWxwaT;
            if (i2 == 1 || bottomSheetBehavior.f2373SwgkN) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.f2381XV == i) {
                WeakReference weakReference = bottomSheetBehavior.f2364JrJO;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f2420mjFkc = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.f2363JYn;
            return weakReference2 != null && weakReference2.get() == view;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // p131o.C3211Y9.wA
        /* renamed from: VA */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo2487VA(View view, float f, float f2) {
            int i = 6;
            if (f2 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f2366KLMXS && bottomSheetBehavior.m2556hvGY(view, f2)) {
                    if ((Math.abs(f) < Math.abs(f2) && f2 > BottomSheetBehavior.this.f2365KLFTb) || m2577YoKzxo(view)) {
                        i = 5;
                    } else if (BottomSheetBehavior.this.f2351AZxh || Math.abs(view.getTop() - BottomSheetBehavior.this.m2566tQ()) < Math.abs(view.getTop() - BottomSheetBehavior.this.f2371OjSQV)) {
                    }
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.f2351AZxh) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i2 = bottomSheetBehavior2.f2371OjSQV;
                        if (top < i2) {
                            if (top >= Math.abs(top - bottomSheetBehavior2.f2353CqaNbM)) {
                                if (BottomSheetBehavior.this.m2531Rc()) {
                                }
                            }
                        } else if (Math.abs(top - i2) >= Math.abs(top - BottomSheetBehavior.this.f2353CqaNbM) || BottomSheetBehavior.this.m2531Rc()) {
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.f2394mByQ) < Math.abs(top - BottomSheetBehavior.this.f2353CqaNbM)) {
                    }
                } else if (!BottomSheetBehavior.this.f2351AZxh) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.f2371OjSQV) >= Math.abs(top2 - BottomSheetBehavior.this.f2353CqaNbM) || BottomSheetBehavior.this.m2531Rc()) {
                    }
                }
            } else if (BottomSheetBehavior.this.f2351AZxh) {
                i = 3;
            } else {
                int top3 = view.getTop();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f2420mjFkc;
                if (BottomSheetBehavior.this.m2531Rc()) {
                    if (!BottomSheetBehavior.this.m2521Dp(jCurrentTimeMillis, (top3 * 100.0f) / r10.f2402uHVRx)) {
                        i = 4;
                    }
                } else if (top3 <= BottomSheetBehavior.this.f2371OjSQV) {
                }
                i = 3;
            }
            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
            bottomSheetBehavior3.m2563rdJr(view, i, bottomSheetBehavior3.m2532SKTn());
        }

        /* renamed from: YoKzxo */
        public final boolean m2577YoKzxo(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.f2402uHVRx + bottomSheetBehavior.m2566tQ()) / 2;
        }

        @Override // p131o.C3211Y9.wA
        /* renamed from: mjFkc */
        public int mo2490mjFkc(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$mjFkc */
    public class RunnableC0234mjFkc implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ int f2421AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ View f2422mjFkc;

        public RunnableC0234mjFkc(View view, int i) {
            this.f2422mjFkc = view;
            this.f2421AZxh = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.m2563rdJr(this.f2422mjFkc, this.f2421AZxh, false);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$wA */
    public class C0235wA implements AbstractC4557sa.ZfxDd {

        /* renamed from: mjFkc */
        public final /* synthetic */ boolean f2425mjFkc;

        public C0235wA(boolean z) {
            this.f2425mjFkc = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // p131o.AbstractC4557sa.ZfxDd
        /* renamed from: mjFkc */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C3372ab mo2578mjFkc(View view, C3372ab c3372ab, AbstractC4557sa.KLFTb kLFTb) {
            boolean z;
            C2798S c2798sM11336JHa = c3372ab.m11336JHa(C3372ab.VA.m11388ZfxDd());
            C2798S c2798sM11336JHa2 = c3372ab.m11336JHa(C3372ab.VA.m11390wA());
            BottomSheetBehavior.this.f2357Gd = c2798sM11336JHa.f10506AZxh;
            boolean zM13503KLFTb = AbstractC4557sa.m13503KLFTb(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f2398qGY) {
                BottomSheetBehavior.this.f2390huTpC = c3372ab.m11343lgHUyS();
                paddingBottom = kLFTb.f16524ZfxDd + BottomSheetBehavior.this.f2390huTpC;
            }
            if (BottomSheetBehavior.this.f2389fehf) {
                paddingLeft = (zM13503KLFTb ? kLFTb.f16526wA : kLFTb.f16525mjFkc) + c2798sM11336JHa.f10508mjFkc;
            }
            if (BottomSheetBehavior.this.f2359IEE) {
                paddingRight = (zM13503KLFTb ? kLFTb.f16525mjFkc : kLFTb.f16526wA) + c2798sM11336JHa.f10509wA;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z2 = true;
            if (BottomSheetBehavior.this.f2387diqgf) {
                int i = marginLayoutParams.leftMargin;
                int i2 = c2798sM11336JHa.f10508mjFkc;
                if (i != i2) {
                    marginLayoutParams.leftMargin = i2;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (BottomSheetBehavior.this.f2388eyqo) {
                int i3 = marginLayoutParams.rightMargin;
                int i4 = c2798sM11336JHa.f10509wA;
                if (i3 != i4) {
                    marginLayoutParams.rightMargin = i4;
                    z = true;
                }
            }
            if (BottomSheetBehavior.this.f2374Ucbh) {
                int i5 = marginLayoutParams.topMargin;
                int i6 = c2798sM11336JHa.f10506AZxh;
                if (i5 != i6) {
                    marginLayoutParams.topMargin = i6;
                } else {
                    z2 = z;
                }
            }
            if (z2) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f2425mjFkc) {
                BottomSheetBehavior.this.f2382YoKzxo = c2798sM11336JHa2.f10507ZfxDd;
            }
            if (BottomSheetBehavior.this.f2398qGY || this.f2425mjFkc) {
                BottomSheetBehavior.this.m2544XgAT(false);
            }
            return c3372ab;
        }
    }

    public BottomSheetBehavior() {
        this.f2395mjFkc = 0;
        this.f2351AZxh = true;
        this.f2405wA = false;
        this.f2375VA = -1;
        this.f2368MiMN = -1;
        this.f2352BAnRFn = new C0236xJ(this, null);
        this.f2370Ne = 0.5f;
        this.f2408xrEuO = -1.0f;
        this.f2386cMLeY = true;
        this.f2400rWxwaT = 4;
        this.f2377Vnb = 4;
        this.f2380WrLQs = 0.1f;
        this.f2396nxI = new ArrayList();
        this.f2376Vdz = new SparseIntArray();
        this.f2391jm = new C0233ZfxDd();
    }

    /* renamed from: ANMGZc */
    public void m2520ANMGZc(int i) {
        if (((View) this.f2363JYn.get()) == null || this.f2396nxI.isEmpty()) {
            return;
        }
        m2542XV(i);
        if (this.f2396nxI.size() <= 0) {
            return;
        }
        AbstractC4793w7.m13819mjFkc(this.f2396nxI.get(0));
        throw null;
    }

    /* renamed from: Dp */
    public boolean m2521Dp(long j, float f) {
        return false;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: Dt */
    public void mo487Dt() {
        super.mo487Dt();
        this.f2363JYn = null;
        this.f2369NPj = null;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: ETF */
    public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C3211Y9 c3211y9;
        if (!view.isShown() || !this.f2386cMLeY) {
            this.f2404vadzgd = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m2554gtIJp();
        }
        if (this.f2379WGXroI == null) {
            this.f2379WGXroI = VelocityTracker.obtain();
        }
        this.f2379WGXroI.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.f2385bbzow = (int) motionEvent.getY();
            if (this.f2400rWxwaT != 2) {
                WeakReference weakReference = this.f2364JrJO;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.m482vI(view2, x, this.f2385bbzow)) {
                    this.f2381XV = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2373SwgkN = true;
                }
            }
            this.f2404vadzgd = this.f2381XV == -1 && !coordinatorLayout.m482vI(view, x, this.f2385bbzow);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2373SwgkN = false;
            this.f2381XV = -1;
            if (this.f2404vadzgd) {
                this.f2404vadzgd = false;
                return false;
            }
        }
        if (!this.f2404vadzgd && (c3211y9 = this.f2369NPj) != null && c3211y9.m11061Ne(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f2364JrJO;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f2404vadzgd || this.f2400rWxwaT == 1 || coordinatorLayout.m482vI(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f2369NPj == null || Math.abs(((float) this.f2385bbzow) - motionEvent.getY()) <= ((float) this.f2369NPj.m11069eyqo())) ? false : true;
    }

    /* renamed from: FbxKQm */
    public final void m2522FbxKQm(int i, boolean z) {
        boolean zM2570xROA;
        ValueAnimator valueAnimator;
        if (i == 2 || this.f2378VocHEe == (zM2570xROA = m2570xROA()) || this.f2354Dt == null) {
            return;
        }
        this.f2378VocHEe = zM2570xROA;
        if (!z || (valueAnimator = this.f2392lB) == null) {
            ValueAnimator valueAnimator2 = this.f2392lB;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f2392lB.cancel();
            }
            this.f2354Dt.m9807JYn(this.f2378VocHEe ? 0.0f : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.f2392lB.reverse();
            return;
        }
        float f = zM2570xROA ? 0.0f : 1.0f;
        this.f2392lB.setFloatValues(1.0f - f, f);
        this.f2392lB.start();
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: Gd */
    public void mo489Gd(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        C0231JHa c0231JHa = (C0231JHa) parcelable;
        super.mo489Gd(coordinatorLayout, view, c0231JHa.m13824mjFkc());
        m2560kism(c0231JHa);
        int i = c0231JHa.f2415wA;
        if (i == 1 || i == 2) {
            this.f2400rWxwaT = 4;
            this.f2377Vnb = 4;
        } else {
            this.f2400rWxwaT = i;
            this.f2377Vnb = i;
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: HGpJ */
    public Parcelable mo490HGpJ(CoordinatorLayout coordinatorLayout, View view) {
        return new C0231JHa(super.mo490HGpJ(coordinatorLayout, view), this);
    }

    /* renamed from: IVlxe */
    public boolean m2523IVlxe() {
        return this.f2401rkYL;
    }

    /* renamed from: JBhc */
    public final InterfaceC2087HGpJ m2524JBhc(int i) {
        return new C0232KLFTb(i);
    }

    /* renamed from: JYgkl */
    public final int m2525JYgkl(View view, int i, int i2) {
        return AbstractC2876T9.m10295wA(view, view.getResources().getString(i), m2524JBhc(i2));
    }

    /* renamed from: JrJO */
    public final void m2526JrJO() {
        int iM2538WGXroI = m2538WGXroI();
        if (this.f2351AZxh) {
            this.f2353CqaNbM = Math.max(this.f2402uHVRx - iM2538WGXroI, this.f2394mByQ);
        } else {
            this.f2353CqaNbM = this.f2402uHVRx - iM2538WGXroI;
        }
    }

    /* renamed from: LREOK */
    public void m2527LREOK(boolean z) {
        if (this.f2351AZxh == z) {
            return;
        }
        this.f2351AZxh = z;
        if (this.f2363JYn != null) {
            m2526JrJO();
        }
        m2539XD((this.f2351AZxh && this.f2400rWxwaT == 6) ? 3 : this.f2400rWxwaT);
        m2522FbxKQm(this.f2400rWxwaT, true);
        m2540XDdeP();
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: MiMN */
    public boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(m2548dm(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.f2375VA, marginLayoutParams.width), m2548dm(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.f2368MiMN, marginLayoutParams.height));
        return true;
    }

    /* renamed from: Moer */
    public boolean m2528Moer() {
        return this.f2366KLMXS;
    }

    /* renamed from: NKyg */
    public final void m2529NKyg(View view, C2971Ucbh.mjFkc mjfkc, int i) {
        AbstractC2876T9.m10233JBhc(view, mjfkc, null, m2524JBhc(i));
    }

    /* renamed from: Qr */
    public boolean m2530Qr() {
        return true;
    }

    /* renamed from: Rc */
    public boolean m2531Rc() {
        return false;
    }

    /* renamed from: SKTn */
    public boolean m2532SKTn() {
        return true;
    }

    /* renamed from: SOS */
    public final boolean m2533SOS(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && AbstractC2876T9.m10268cMLeY(view);
    }

    /* renamed from: SmIWf */
    public boolean m2534SmIWf() {
        return true;
    }

    /* renamed from: SwgkN */
    public final void m2535SwgkN(View view, int i) {
        if (view == null) {
            return;
        }
        AbstractC2876T9.m10267bbzow(view, PKIFailureInfo.signerNotTrusted);
        AbstractC2876T9.m10267bbzow(view, PKIFailureInfo.transactionIdInUse);
        AbstractC2876T9.m10267bbzow(view, 1048576);
        int i2 = this.f2376Vdz.get(i, -1);
        if (i2 != -1) {
            AbstractC2876T9.m10267bbzow(view, i2);
            this.f2376Vdz.delete(i);
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (AbstractC2876T9.m10269diqgf(coordinatorLayout) && !AbstractC2876T9.m10269diqgf(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f2363JYn == null) {
            this.f2393lgHUyS = coordinatorLayout.getResources().getDimensionPixelSize(AbstractC4191n4.f15338mjFkc);
            m2555gtr(view);
            AbstractC2876T9.m10272fFz(view, new C2866T(view));
            this.f2363JYn = new WeakReference(view);
            C2542O1 c2542o1 = this.f2354Dt;
            if (c2542o1 != null) {
                AbstractC2876T9.m10294vjlshU(view, c2542o1);
                C2542O1 c2542o12 = this.f2354Dt;
                float fM10231IEE = this.f2408xrEuO;
                if (fM10231IEE == -1.0f) {
                    fM10231IEE = AbstractC2876T9.m10231IEE(view);
                }
                c2542o12.m9801GMIER(fM10231IEE);
            } else {
                ColorStateList colorStateList = this.f2355ETF;
                if (colorStateList != null) {
                    AbstractC2876T9.m10298xROA(view, colorStateList);
                }
            }
            m2540XDdeP();
            if (AbstractC2876T9.m10271eyqo(view) == 0) {
                AbstractC2876T9.m10244NKyg(view, 1);
            }
        }
        if (this.f2369NPj == null) {
            this.f2369NPj = C3211Y9.m11049MiMN(coordinatorLayout, this.f2391jm);
        }
        int top = view.getTop();
        coordinatorLayout.m462Ne(view, i);
        this.f2356GMIER = coordinatorLayout.getWidth();
        this.f2402uHVRx = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f2367KRTLGT = height;
        int i2 = this.f2402uHVRx;
        int i3 = i2 - height;
        int i4 = this.f2357Gd;
        if (i3 < i4) {
            if (this.f2372Pq) {
                this.f2367KRTLGT = i2;
            } else {
                this.f2367KRTLGT = i2 - i4;
            }
        }
        this.f2394mByQ = Math.max(0, i2 - this.f2367KRTLGT);
        m2562nxI();
        m2526JrJO();
        int i5 = this.f2400rWxwaT;
        if (i5 == 3) {
            AbstractC2876T9.m10240KRTLGT(view, m2566tQ());
        } else if (i5 == 6) {
            AbstractC2876T9.m10240KRTLGT(view, this.f2371OjSQV);
        } else if (this.f2366KLMXS && i5 == 5) {
            AbstractC2876T9.m10240KRTLGT(view, this.f2402uHVRx);
        } else if (i5 == 4) {
            AbstractC2876T9.m10240KRTLGT(view, this.f2353CqaNbM);
        } else if (i5 == 1 || i5 == 2) {
            AbstractC2876T9.m10240KRTLGT(view, top - view.getTop());
        }
        m2522FbxKQm(this.f2400rWxwaT, false);
        this.f2364JrJO = new WeakReference(m2546alEkx(view));
        if (this.f2396nxI.size() <= 0) {
            return true;
        }
        AbstractC4793w7.m13819mjFkc(this.f2396nxI.get(0));
        throw null;
    }

    /* renamed from: Vdz */
    public final void m2536Vdz(Context context) {
        if (this.f2403vI == null) {
            return;
        }
        C2542O1 c2542o1 = new C2542O1(this.f2403vI);
        this.f2354Dt = c2542o1;
        c2542o1.m9827cMLeY(context);
        ColorStateList colorStateList = this.f2355ETF;
        if (colorStateList != null) {
            this.f2354Dt.m9841uHVRx(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f2354Dt.setTint(typedValue.data);
    }

    /* renamed from: Vgyli */
    public void m2537Vgyli(int i) {
        this.f2395mjFkc = i;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VocHEe */
    public boolean mo498VocHEe(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.f2397oCFDzJ = 0;
        this.f2384aqHPIZ = false;
        return (i & 2) != 0;
    }

    /* renamed from: WGXroI */
    public final int m2538WGXroI() {
        int iMin;
        int i;
        int i2;
        if (this.f2407xJ) {
            iMin = Math.min(Math.max(this.f2393lgHUyS, this.f2402uHVRx - ((this.f2356GMIER * 9) / 16)), this.f2367KRTLGT);
            i = this.f2390huTpC;
        } else {
            if (!this.f2401rkYL && !this.f2398qGY && (i2 = this.f2382YoKzxo) > 0) {
                return Math.max(this.f2361JHa, i2 + this.f2399qdMbNW);
            }
            iMin = this.f2361JHa;
            i = this.f2390huTpC;
        }
        return iMin + i;
    }

    /* renamed from: XD */
    public void m2539XD(int i) {
        if (this.f2400rWxwaT == i) {
            return;
        }
        this.f2400rWxwaT = i;
        if (i == 4 || i == 3 || i == 6 || (this.f2366KLMXS && i == 5)) {
            this.f2377Vnb = i;
        }
        WeakReference weakReference = this.f2363JYn;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            m2558jtz(true);
        } else if (i == 6 || i == 5 || i == 4) {
            m2558jtz(false);
        }
        m2522FbxKQm(i, true);
        if (this.f2396nxI.size() <= 0) {
            m2540XDdeP();
        } else {
            AbstractC4793w7.m13819mjFkc(this.f2396nxI.get(0));
            throw null;
        }
    }

    /* renamed from: XDdeP */
    public final void m2540XDdeP() {
        WeakReference weakReference = this.f2363JYn;
        if (weakReference != null) {
            m2549eQ((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.f2362JYgkl;
        if (weakReference2 != null) {
            m2549eQ((View) weakReference2.get(), 1);
        }
    }

    /* renamed from: XFUzSY */
    public void m2541XFUzSY(boolean z) {
        if (this.f2366KLMXS != z) {
            this.f2366KLMXS = z;
            if (!z && this.f2400rWxwaT == 5) {
                m2564sRqPfw(4);
            }
            m2540XDdeP();
        }
    }

    /* renamed from: XV */
    public final float m2542XV(int i) {
        float f;
        float fM2566tQ;
        int i2 = this.f2353CqaNbM;
        if (i > i2 || i2 == m2566tQ()) {
            int i3 = this.f2353CqaNbM;
            f = i3 - i;
            fM2566tQ = this.f2402uHVRx - i3;
        } else {
            int i4 = this.f2353CqaNbM;
            f = i4 - i;
            fM2566tQ = i4 - m2566tQ();
        }
        return f / fM2566tQ;
    }

    /* renamed from: XbiWeM */
    public void m2543XbiWeM(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f2370Ne = f;
        if (this.f2363JYn != null) {
            m2562nxI();
        }
    }

    /* renamed from: XgAT */
    public final void m2544XgAT(boolean z) {
        View view;
        if (this.f2363JYn != null) {
            m2526JrJO();
            if (this.f2400rWxwaT != 4 || (view = (View) this.f2363JYn.get()) == null) {
                return;
            }
            if (z) {
                m2564sRqPfw(4);
            } else {
                view.requestLayout();
            }
        }
    }

    /* renamed from: XtE */
    public void m2545XtE(int i) {
        this.f2368MiMN = i;
    }

    /* renamed from: alEkx */
    public View m2546alEkx(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (AbstractC2876T9.m10256Vnb(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewM2546alEkx = m2546alEkx(viewGroup.getChildAt(i));
                if (viewM2546alEkx != null) {
                    return viewM2546alEkx;
                }
            }
        }
        return null;
    }

    /* renamed from: bbzow */
    public final boolean m2547bbzow() {
        return m2528Moer() && m2534SmIWf();
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: diqgf */
    public void mo501diqgf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    /* renamed from: dm */
    public final int m2548dm(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    /* renamed from: eQ */
    public final void m2549eQ(View view, int i) {
        if (view == null) {
            return;
        }
        m2535SwgkN(view, i);
        if (!this.f2351AZxh && this.f2400rWxwaT != 6) {
            this.f2376Vdz.put(i, m2525JYgkl(view, AbstractC2481N4.f9649mjFkc, 6));
        }
        if (this.f2366KLMXS && m2534SmIWf() && this.f2400rWxwaT != 5) {
            m2529NKyg(view, C2971Ucbh.mjFkc.f10864HGpJ, 5);
        }
        int i2 = this.f2400rWxwaT;
        if (i2 == 3) {
            m2529NKyg(view, C2971Ucbh.mjFkc.f10863Gd, this.f2351AZxh ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            m2529NKyg(view, C2971Ucbh.mjFkc.f10886huTpC, this.f2351AZxh ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            m2529NKyg(view, C2971Ucbh.mjFkc.f10863Gd, 4);
            m2529NKyg(view, C2971Ucbh.mjFkc.f10886huTpC, 3);
        }
    }

    /* renamed from: fFz */
    public void m2550fFz(boolean z) {
        this.f2401rkYL = z;
    }

    /* renamed from: fLidf */
    public final boolean m2551fLidf() {
        return this.f2369NPj != null && (this.f2386cMLeY || this.f2400rWxwaT == 1);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: fehf */
    public void mo503fehf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.f2364JrJO;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!m2530Qr() || view2 == view3) {
            int top = view.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < m2566tQ()) {
                    int iM2566tQ = top - m2566tQ();
                    iArr[1] = iM2566tQ;
                    AbstractC2876T9.m10240KRTLGT(view, -iM2566tQ);
                    m2539XD(3);
                } else {
                    if (!this.f2386cMLeY) {
                        return;
                    }
                    iArr[1] = i2;
                    AbstractC2876T9.m10240KRTLGT(view, -i2);
                    m2539XD(1);
                }
            } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
                if (i4 > this.f2353CqaNbM && !m2547bbzow()) {
                    int i5 = top - this.f2353CqaNbM;
                    iArr[1] = i5;
                    AbstractC2876T9.m10240KRTLGT(view, -i5);
                    m2539XD(4);
                } else {
                    if (!this.f2386cMLeY) {
                        return;
                    }
                    iArr[1] = i2;
                    AbstractC2876T9.m10240KRTLGT(view, -i2);
                    m2539XD(1);
                }
            }
            m2520ANMGZc(view.getTop());
            this.f2397oCFDzJ = i2;
            this.f2384aqHPIZ = true;
        }
    }

    /* renamed from: gYa */
    public void m2552gYa(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f2406wJVbdd = i;
        m2522FbxKQm(this.f2400rWxwaT, true);
    }

    /* renamed from: giT */
    public void m2553giT(boolean z) {
        this.f2409zvd = z;
    }

    /* renamed from: gtIJp */
    public final void m2554gtIJp() {
        this.f2381XV = -1;
        VelocityTracker velocityTracker = this.f2379WGXroI;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2379WGXroI = null;
        }
    }

    /* renamed from: gtr */
    public final void m2555gtr(View view) {
        boolean z = (m2523IVlxe() || this.f2407xJ) ? false : true;
        if (this.f2398qGY || this.f2389fehf || this.f2359IEE || this.f2387diqgf || this.f2388eyqo || this.f2374Ucbh || z) {
            AbstractC4557sa.m13506mjFkc(view, new C0235wA(z));
        }
    }

    /* renamed from: hvGY */
    public boolean m2556hvGY(View view, float f) {
        if (this.f2409zvd) {
            return true;
        }
        if (m2534SmIWf() && view.getTop() >= this.f2353CqaNbM) {
            return Math.abs((((float) view.getTop()) + (f * this.f2380WrLQs)) - ((float) this.f2353CqaNbM)) / ((float) m2538WGXroI()) > 0.5f;
        }
        return false;
    }

    /* renamed from: jm */
    public final void m2557jm() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2392lB = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f2392lB.addUpdateListener(new C0230AZxh());
    }

    /* renamed from: jtz */
    public final void m2558jtz(boolean z) {
        Map map;
        WeakReference weakReference = this.f2363JYn;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.f2360JBhc != null) {
                    return;
                } else {
                    this.f2360JBhc = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f2363JYn.get()) {
                    if (z) {
                        this.f2360JBhc.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f2405wA) {
                            AbstractC2876T9.m10244NKyg(childAt, 4);
                        }
                    } else if (this.f2405wA && (map = this.f2360JBhc) != null && map.containsKey(childAt)) {
                        AbstractC2876T9.m10244NKyg(childAt, ((Integer) this.f2360JBhc.get(childAt)).intValue());
                    }
                }
            }
            if (!z) {
                this.f2360JBhc = null;
            } else if (this.f2405wA) {
                ((View) this.f2363JYn.get()).sendAccessibilityEvent(8);
            }
        }
    }

    /* renamed from: jx */
    public void m2559jx(int i) {
        this.f2375VA = i;
    }

    /* renamed from: kism */
    public final void m2560kism(C0231JHa c0231JHa) {
        int i = this.f2395mjFkc;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f2361JHa = c0231JHa.f2414ZfxDd;
        }
        if (i == -1 || (i & 2) == 2) {
            this.f2351AZxh = c0231JHa.f2413KLFTb;
        }
        if (i == -1 || (i & 4) == 4) {
            this.f2366KLMXS = c0231JHa.f2412JHa;
        }
        if (i == -1 || (i & 8) == 8) {
            this.f2409zvd = c0231JHa.f2416xJ;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: lB */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo505lB(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        WeakReference weakReference;
        int i2 = 3;
        if (view.getTop() == m2566tQ()) {
            m2539XD(3);
            return;
        }
        if (!m2530Qr() || ((weakReference = this.f2364JrJO) != null && view2 == weakReference.get() && this.f2384aqHPIZ)) {
            if (this.f2397oCFDzJ > 0) {
                if (!this.f2351AZxh && view.getTop() > this.f2371OjSQV) {
                    i2 = 6;
                }
            } else if (this.f2366KLMXS && m2556hvGY(view, m2569vjlshU())) {
                i2 = 5;
            } else if (this.f2397oCFDzJ == 0) {
                int top = view.getTop();
                if (!this.f2351AZxh) {
                    int i3 = this.f2371OjSQV;
                    if (top < i3) {
                        if (top >= Math.abs(top - this.f2353CqaNbM)) {
                            if (m2531Rc()) {
                            }
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.f2353CqaNbM)) {
                    }
                } else if (Math.abs(top - this.f2394mByQ) >= Math.abs(top - this.f2353CqaNbM)) {
                    i2 = 4;
                }
            } else {
                if (!this.f2351AZxh) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.f2371OjSQV) < Math.abs(top2 - this.f2353CqaNbM)) {
                    }
                }
                i2 = 4;
            }
            m2563rdJr(view, i2, false);
            this.f2384aqHPIZ = false;
        }
    }

    /* renamed from: lti */
    public void m2561lti(int i) {
        this.f2365KLFTb = i;
    }

    /* renamed from: nxI */
    public final void m2562nxI() {
        this.f2371OjSQV = (int) (this.f2402uHVRx * (1.0f - this.f2370Ne));
    }

    /* renamed from: rdJr */
    public final void m2563rdJr(View view, int i, boolean z) {
        int iM2572yfx = m2572yfx(i);
        C3211Y9 c3211y9 = this.f2369NPj;
        if (c3211y9 == null || (!z ? c3211y9.m11053CqaNbM(view, view.getLeft(), iM2572yfx) : c3211y9.m11062OjSQV(view.getLeft(), iM2572yfx))) {
            m2539XD(i);
            return;
        }
        m2539XD(2);
        m2522FbxKQm(i, true);
        this.f2352BAnRFn.m2581wA(i);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: rkYL */
    public boolean mo510rkYL(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
        WeakReference weakReference;
        if (m2530Qr() && (weakReference = this.f2364JrJO) != null && view2 == weakReference.get()) {
            return this.f2400rWxwaT != 3 || super.mo510rkYL(coordinatorLayout, view, view2, f, f2);
        }
        return false;
    }

    /* renamed from: sRqPfw */
    public void m2564sRqPfw(int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.f2366KLMXS && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.f2351AZxh && m2572yfx(i) <= this.f2394mByQ) ? 3 : i;
        WeakReference weakReference = this.f2363JYn;
        if (weakReference == null || weakReference.get() == null) {
            m2539XD(i);
        } else {
            View view = (View) this.f2363JYn.get();
            m2567tjSezt(view, new RunnableC0234mjFkc(view, i2));
        }
    }

    /* renamed from: tISON */
    public final void m2565tISON(int i, boolean z) {
        if (i == -1) {
            if (this.f2407xJ) {
                return;
            } else {
                this.f2407xJ = true;
            }
        } else {
            if (!this.f2407xJ && this.f2361JHa == i) {
                return;
            }
            this.f2407xJ = false;
            this.f2361JHa = Math.max(0, i);
        }
        m2544XgAT(z);
    }

    /* renamed from: tQ */
    public int m2566tQ() {
        if (this.f2351AZxh) {
            return this.f2394mByQ;
        }
        return Math.max(this.f2406wJVbdd, this.f2372Pq ? 0 : this.f2357Gd);
    }

    /* renamed from: tjSezt */
    public final void m2567tjSezt(View view, Runnable runnable) {
        if (m2533SOS(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: uH */
    public void m2568uH(int i) {
        m2565tISON(i, false);
    }

    /* renamed from: vjlshU */
    public final float m2569vjlshU() {
        VelocityTracker velocityTracker = this.f2379WGXroI;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, this.f2383ZfxDd);
        return this.f2379WGXroI.getYVelocity(this.f2381XV);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: wJVbdd */
    public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2400rWxwaT == 1 && actionMasked == 0) {
            return true;
        }
        if (m2551fLidf()) {
            this.f2369NPj.m11079vI(motionEvent);
        }
        if (actionMasked == 0) {
            m2554gtIJp();
        }
        if (this.f2379WGXroI == null) {
            this.f2379WGXroI = VelocityTracker.obtain();
        }
        this.f2379WGXroI.addMovement(motionEvent);
        if (m2551fLidf() && actionMasked == 2 && !this.f2404vadzgd && Math.abs(this.f2385bbzow - motionEvent.getY()) > this.f2369NPj.m11069eyqo()) {
            this.f2369NPj.m11051AZxh(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2404vadzgd;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: xJ */
    public void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
        super.mo514xJ(c0060KLFTb);
        this.f2363JYn = null;
        this.f2369NPj = null;
    }

    /* renamed from: xROA */
    public final boolean m2570xROA() {
        return this.f2400rWxwaT == 3 && (this.f2358HGpJ || m2566tQ() == 0);
    }

    /* renamed from: yX */
    public void m2571yX(boolean z) {
        this.f2386cMLeY = z;
    }

    /* renamed from: yfx */
    public final int m2572yfx(int i) {
        if (i == 3) {
            return m2566tQ();
        }
        if (i == 4) {
            return this.f2353CqaNbM;
        }
        if (i == 5) {
            return this.f2402uHVRx;
        }
        if (i == 6) {
            return this.f2371OjSQV;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i);
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$xJ */
    public class C0236xJ {

        /* renamed from: AZxh */
        public boolean f2426AZxh;

        /* renamed from: mjFkc */
        public int f2428mjFkc;

        /* renamed from: wA */
        public final Runnable f2429wA;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$xJ$mjFkc */
        public class mjFkc implements Runnable {
            public mjFkc() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0236xJ.this.f2426AZxh = false;
                C3211Y9 c3211y9 = BottomSheetBehavior.this.f2369NPj;
                if (c3211y9 != null && c3211y9.m11055ETF(true)) {
                    C0236xJ c0236xJ = C0236xJ.this;
                    c0236xJ.m2581wA(c0236xJ.f2428mjFkc);
                    return;
                }
                C0236xJ c0236xJ2 = C0236xJ.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f2400rWxwaT == 2) {
                    bottomSheetBehavior.m2539XD(c0236xJ2.f2428mjFkc);
                }
            }
        }

        public C0236xJ() {
            this.f2429wA = new mjFkc();
        }

        /* renamed from: wA */
        public void m2581wA(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.f2363JYn;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f2428mjFkc = i;
            if (this.f2426AZxh) {
                return;
            }
            AbstractC2876T9.m10258WGXroI((View) BottomSheetBehavior.this.f2363JYn.get(), this.f2429wA);
            this.f2426AZxh = true;
        }

        public /* synthetic */ C0236xJ(BottomSheetBehavior bottomSheetBehavior, RunnableC0234mjFkc runnableC0234mjFkc) {
            this();
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$JHa */
    public static class C0231JHa extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0231JHa> f2411CREATOR = new mjFkc();

        /* renamed from: JHa */
        public boolean f2412JHa;

        /* renamed from: KLFTb */
        public boolean f2413KLFTb;

        /* renamed from: ZfxDd */
        public int f2414ZfxDd;

        /* renamed from: wA */
        public final int f2415wA;

        /* renamed from: xJ */
        public boolean f2416xJ;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$JHa$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0231JHa createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0231JHa(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0231JHa createFromParcel(Parcel parcel) {
                return new C0231JHa(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0231JHa[] newArray(int i) {
                return new C0231JHa[i];
            }
        }

        public C0231JHa(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2415wA = parcel.readInt();
            this.f2414ZfxDd = parcel.readInt();
            this.f2413KLFTb = parcel.readInt() == 1;
            this.f2412JHa = parcel.readInt() == 1;
            this.f2416xJ = parcel.readInt() == 1;
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2415wA);
            parcel.writeInt(this.f2414ZfxDd);
            parcel.writeInt(this.f2413KLFTb ? 1 : 0);
            parcel.writeInt(this.f2412JHa ? 1 : 0);
            parcel.writeInt(this.f2416xJ ? 1 : 0);
        }

        public C0231JHa(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f2415wA = bottomSheetBehavior.f2400rWxwaT;
            this.f2414ZfxDd = bottomSheetBehavior.f2361JHa;
            this.f2413KLFTb = bottomSheetBehavior.f2351AZxh;
            this.f2412JHa = bottomSheetBehavior.f2366KLMXS;
            this.f2416xJ = bottomSheetBehavior.f2409zvd;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.f2395mjFkc = 0;
        this.f2351AZxh = true;
        this.f2405wA = false;
        this.f2375VA = -1;
        this.f2368MiMN = -1;
        this.f2352BAnRFn = new C0236xJ(this, null);
        this.f2370Ne = 0.5f;
        this.f2408xrEuO = -1.0f;
        this.f2386cMLeY = true;
        this.f2400rWxwaT = 4;
        this.f2377Vnb = 4;
        this.f2380WrLQs = 0.1f;
        this.f2396nxI = new ArrayList();
        this.f2376Vdz = new SparseIntArray();
        this.f2391jm = new C0233ZfxDd();
        this.f2399qdMbNW = context.getResources().getDimensionPixelSize(AbstractC4191n4.f15342rWxwaT);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12371Gd);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12324BAnRFn)) {
            this.f2355ETF = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12324BAnRFn);
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12409KRTLGT)) {
            this.f2403vI = C2141I6.m8658KLFTb(context, attributeSet, AbstractC3800h4.f13947mjFkc, f2350ANMGZc).m8698MiMN();
        }
        m2536Vdz(context);
        m2557jm();
        this.f2408xrEuO = typedArrayObtainStyledAttributes.getDimension(AbstractC3340a5.f12492VocHEe, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12376HGpJ)) {
            m2559jx(typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12376HGpJ, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3340a5.f12672vI)) {
            m2545XtE(typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12672vI, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(AbstractC3340a5.f12338CqaNbM);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            m2568uH(i);
        } else {
            m2568uH(typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12338CqaNbM, -1));
        }
        m2541XFUzSY(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12435Ne, false));
        m2550fFz(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12542cMLeY, false));
        m2527LREOK(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12603mByQ, true));
        m2553giT(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12707zvd, false));
        m2571yX(typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12598lB, true));
        m2537Vgyli(typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12696xrEuO, 0));
        m2543XbiWeM(typedArrayObtainStyledAttributes.getFloat(AbstractC3340a5.f12438OjSQV, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(AbstractC3340a5.f12681wJVbdd);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            m2552gYa(typedValuePeekValue2.data);
        } else {
            m2552gYa(typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3340a5.f12681wJVbdd, 0));
        }
        m2561lti(typedArrayObtainStyledAttributes.getInt(AbstractC3340a5.f12408KLMXS, 500));
        this.f2398qGY = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12676vadzgd, false);
        this.f2389fehf = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12617oCFDzJ, false);
        this.f2359IEE = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12530aqHPIZ, false);
        this.f2372Pq = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12498WrLQs, true);
        this.f2387diqgf = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12642rWxwaT, false);
        this.f2388eyqo = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12491Vnb, false);
        this.f2374Ucbh = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12432NPj, false);
        this.f2358HGpJ = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12369GMIER, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f2383ZfxDd = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
