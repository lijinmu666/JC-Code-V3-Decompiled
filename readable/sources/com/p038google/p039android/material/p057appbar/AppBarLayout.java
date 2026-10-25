package com.p038google.p039android.material.p057appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import p131o.AbstractC2868T1;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC4586t;
import p131o.AbstractC4653u;
import p131o.AbstractC4793w7;
import p131o.AbstractC4796wA;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
public abstract class AppBarLayout extends LinearLayout {

    public static class BaseBehavior<T extends AppBarLayout> extends AbstractC4586t {

        /* renamed from: ETF */
        public int f2294ETF;

        /* renamed from: MiMN */
        public C0223mjFkc f2295MiMN;

        /* renamed from: VA */
        public int f2296VA;

        /* renamed from: YoKzxo */
        public WeakReference f2297YoKzxo;

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$mjFkc */
        public static class C0223mjFkc extends AbstractC4796wA {

            /* renamed from: CREATOR */
            public static final Parcelable.Creator<C0223mjFkc> f2298CREATOR = new mjFkc();

            /* renamed from: JHa */
            public float f2299JHa;

            /* renamed from: KLFTb */
            public int f2300KLFTb;

            /* renamed from: ZfxDd */
            public boolean f2301ZfxDd;

            /* renamed from: wA */
            public boolean f2302wA;

            /* renamed from: xJ */
            public boolean f2303xJ;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$mjFkc$mjFkc */
            public class mjFkc implements Parcelable.ClassLoaderCreator {
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
                public C0223mjFkc createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new C0223mjFkc(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
                public C0223mjFkc createFromParcel(Parcel parcel) {
                    return new C0223mjFkc(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: wA, reason: merged with bridge method [inline-methods] */
                public C0223mjFkc[] newArray(int i) {
                    return new C0223mjFkc[i];
                }
            }

            public C0223mjFkc(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2302wA = parcel.readByte() != 0;
                this.f2301ZfxDd = parcel.readByte() != 0;
                this.f2300KLFTb = parcel.readInt();
                this.f2299JHa = parcel.readFloat();
                this.f2303xJ = parcel.readByte() != 0;
            }

            @Override // p131o.AbstractC4796wA, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.f2302wA ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f2301ZfxDd ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f2300KLFTb);
                parcel.writeFloat(this.f2299JHa);
                parcel.writeByte(this.f2303xJ ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        /* renamed from: ANMGZc */
        public final void m2423ANMGZc(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            AbstractC2876T9.m10267bbzow(coordinatorLayout, C2971Ucbh.mjFkc.f10885fehf.m10624AZxh());
            AbstractC2876T9.m10267bbzow(coordinatorLayout, C2971Ucbh.mjFkc.f10865IEE.m10624AZxh());
            throw null;
        }

        /* renamed from: GMIER */
        public void m2424GMIER(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m2440jm(coordinatorLayout, appBarLayout);
            throw null;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: Gd */
        public /* bridge */ /* synthetic */ void mo489Gd(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AbstractC4793w7.m13819mjFkc(view);
            mo2441nxI(coordinatorLayout, null, parcelable);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: HGpJ */
        public /* bridge */ /* synthetic */ Parcelable mo490HGpJ(CoordinatorLayout coordinatorLayout, View view) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2434WGXroI(coordinatorLayout, null);
        }

        /* renamed from: JBhc */
        public C0223mjFkc m2425JBhc(Parcelable parcelable, AppBarLayout appBarLayout) {
            mo2449mByQ();
            throw null;
        }

        /* renamed from: JYgkl */
        public void mo2426JYgkl(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            if (i2 != 0 && i2 >= 0) {
                throw null;
            }
            throw null;
        }

        /* renamed from: JYn */
        public boolean mo2427JYn(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            throw null;
        }

        /* renamed from: JrJO */
        public void mo2428JrJO(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                throw null;
            }
            if (i4 == 0) {
                m2423ANMGZc(coordinatorLayout, appBarLayout);
            }
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: KLMXS */
        public /* bridge */ /* synthetic */ int mo2429KLMXS(View view) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2435WrLQs(null);
        }

        /* renamed from: KRTLGT */
        public int m2430KRTLGT(AppBarLayout appBarLayout) {
            throw null;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: MiMN */
        public /* bridge */ /* synthetic */ boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2427JYn(coordinatorLayout, null, i, i2, i3, i4);
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: Ne */
        public /* bridge */ /* synthetic */ boolean mo2431Ne(View view) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2437aqHPIZ(null);
        }

        /* renamed from: SwgkN */
        public void m2432SwgkN(C0223mjFkc c0223mjFkc, boolean z) {
            if (this.f2295MiMN == null || z) {
                this.f2295MiMN = c0223mjFkc;
            }
        }

        @Override // p131o.AbstractC4025ka, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VA */
        public /* bridge */ /* synthetic */ boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2443uHVRx(coordinatorLayout, null, i);
        }

        /* renamed from: Vdz */
        public int m2433Vdz(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int iMo2439cMLeY = mo2439cMLeY();
            if (i2 == 0 || iMo2439cMLeY < i2 || iMo2439cMLeY > i3) {
                this.f2294ETF = 0;
            } else if (iMo2439cMLeY != AbstractC2868T1.m10211AZxh(i, i2, i3)) {
                throw null;
            }
            m2423ANMGZc(coordinatorLayout, appBarLayout);
            return 0;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VocHEe */
        public /* bridge */ /* synthetic */ boolean mo498VocHEe(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2436XV(coordinatorLayout, null, view2, view3, i, i2);
        }

        /* renamed from: WGXroI */
        public Parcelable mo2434WGXroI(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableMo490HGpJ = super.mo490HGpJ(coordinatorLayout, appBarLayout);
            C0223mjFkc c0223mjFkcM2425JBhc = m2425JBhc(parcelableMo490HGpJ, appBarLayout);
            return c0223mjFkcM2425JBhc == null ? parcelableMo490HGpJ : c0223mjFkcM2425JBhc;
        }

        /* renamed from: WrLQs */
        public int m2435WrLQs(AppBarLayout appBarLayout) {
            throw null;
        }

        /* renamed from: XV */
        public boolean mo2436XV(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            if ((i & 2) != 0) {
                throw null;
            }
            this.f2297YoKzxo = null;
            this.f2296VA = i2;
            return false;
        }

        /* renamed from: aqHPIZ */
        public boolean m2437aqHPIZ(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.f2297YoKzxo;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* renamed from: bbzow */
        public void mo2438bbzow(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (this.f2296VA == 0 || i == 1) {
                m2440jm(coordinatorLayout, appBarLayout);
                throw null;
            }
            this.f2297YoKzxo = new WeakReference(view);
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: cMLeY */
        public int mo2439cMLeY() {
            return mo2449mByQ() + this.f2294ETF;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: diqgf */
        public /* bridge */ /* synthetic */ void mo501diqgf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            AbstractC4793w7.m13819mjFkc(view);
            mo2428JrJO(coordinatorLayout, null, view2, i, i2, i3, i4, i5, iArr);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: fehf */
        public /* bridge */ /* synthetic */ void mo503fehf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            AbstractC4793w7.m13819mjFkc(view);
            mo2426JYgkl(coordinatorLayout, null, view2, i, i2, iArr, i3);
        }

        /* renamed from: jm */
        public final void m2440jm(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            throw null;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: lB */
        public /* bridge */ /* synthetic */ void mo505lB(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AbstractC4793w7.m13819mjFkc(view);
            mo2438bbzow(coordinatorLayout, null, view2, i);
        }

        /* renamed from: nxI */
        public void mo2441nxI(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C0223mjFkc) {
                m2432SwgkN((C0223mjFkc) parcelable, true);
                super.mo489Gd(coordinatorLayout, appBarLayout, this.f2295MiMN.m13824mjFkc());
            } else {
                super.mo489Gd(coordinatorLayout, appBarLayout, parcelable);
                this.f2295MiMN = null;
            }
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: rWxwaT */
        public /* bridge */ /* synthetic */ void mo2442rWxwaT(CoordinatorLayout coordinatorLayout, View view) {
            AbstractC4793w7.m13819mjFkc(view);
            m2424GMIER(coordinatorLayout, null);
        }

        /* renamed from: uHVRx */
        public boolean mo2443uHVRx(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            super.mo497VA(coordinatorLayout, appBarLayout, i);
            throw null;
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: vadzgd */
        public /* bridge */ /* synthetic */ int mo2444vadzgd(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2433Vdz(coordinatorLayout, null, i, i2, i3);
        }

        @Override // p131o.AbstractC4586t
        /* renamed from: zvd */
        public /* bridge */ /* synthetic */ int mo2445zvd(View view) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2430KRTLGT(null);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // p131o.AbstractC4586t, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: ETF */
        public /* bridge */ /* synthetic */ boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.mo488ETF(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: JYgkl */
        public /* bridge */ /* synthetic */ void mo2426JYgkl(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.mo2426JYgkl(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: JYn */
        public /* bridge */ /* synthetic */ boolean mo2427JYn(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.mo2427JYn(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: JrJO */
        public /* bridge */ /* synthetic */ void mo2428JrJO(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.mo2428JrJO(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: WGXroI */
        public /* bridge */ /* synthetic */ Parcelable mo2434WGXroI(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.mo2434WGXroI(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: XV */
        public /* bridge */ /* synthetic */ boolean mo2436XV(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.mo2436XV(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: bbzow */
        public /* bridge */ /* synthetic */ void mo2438bbzow(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.mo2438bbzow(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // p131o.AbstractC4025ka
        /* renamed from: mByQ */
        public /* bridge */ /* synthetic */ int mo2449mByQ() {
            return super.mo2449mByQ();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: nxI */
        public /* bridge */ /* synthetic */ void mo2441nxI(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.mo2441nxI(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: uHVRx */
        public /* bridge */ /* synthetic */ boolean mo2443uHVRx(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.mo2443uHVRx(coordinatorLayout, appBarLayout, i);
        }

        @Override // p131o.AbstractC4586t, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: wJVbdd */
        public /* bridge */ /* synthetic */ boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.mo513wJVbdd(coordinatorLayout, view, motionEvent);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends AbstractC4653u {
        public ScrollingViewBehavior() {
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: KLFTb */
        public boolean mo493KLFTb(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        @Override // p131o.AbstractC4653u
        /* renamed from: KLMXS */
        public int mo2450KLMXS(View view) {
            return super.mo2450KLMXS(view);
        }

        @Override // p131o.AbstractC4653u, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: MiMN */
        public /* bridge */ /* synthetic */ boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo494MiMN(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* renamed from: NPj */
        public AppBarLayout m2451NPj(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
            }
            return null;
        }

        @Override // p131o.AbstractC4653u
        /* renamed from: Ne */
        public /* bridge */ /* synthetic */ View mo2452Ne(List list) {
            m2451NPj(list);
            return null;
        }

        @Override // p131o.AbstractC4025ka, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VA */
        public /* bridge */ /* synthetic */ boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo497VA(coordinatorLayout, view, i);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: huTpC */
        public boolean mo504huTpC(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            m2451NPj(coordinatorLayout.m474fehf(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: lgHUyS */
        public boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m2454vadzgd(view, view2);
            m2453oCFDzJ(view, view2);
            return false;
        }

        /* renamed from: oCFDzJ */
        public final void m2453oCFDzJ(View view, View view2) {
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: qdMbNW */
        public void mo509qdMbNW(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        /* renamed from: vadzgd */
        public final void m2454vadzgd(View view, View view2) {
            CoordinatorLayout.AbstractC0058AZxh abstractC0058AZxhM520KLFTb = ((CoordinatorLayout.C0060KLFTb) view2.getLayoutParams()).m520KLFTb();
            if (abstractC0058AZxhM520KLFTb instanceof BaseBehavior) {
                AbstractC2876T9.m10240KRTLGT(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) abstractC0058AZxhM520KLFTb).f2294ETF) + m13663zvd()) - m13661CqaNbM(view2));
            }
        }

        @Override // p131o.AbstractC4653u
        /* renamed from: xrEuO */
        public float mo2455xrEuO(View view) {
            return 0.0f;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12452RURGdp);
            m13662rWxwaT(typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12495VzXmn, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
