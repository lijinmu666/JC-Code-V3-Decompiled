package androidx.coordinatorlayout.p016widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p131o.AbstractC2672Q4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3003V2;
import p131o.AbstractC3072W4;
import p131o.AbstractC3602e4;
import p131o.AbstractC3634ea;
import p131o.AbstractC4056l;
import p131o.AbstractC4294ofHOBL;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4796wA;
import p131o.C1864E3;
import p131o.C2005G2;
import p131o.C3372ab;
import p131o.C4874xIpq;
import p131o.InterfaceC1601A3;
import p131o.InterfaceC1863E2;
import p131o.InterfaceC1932F2;
import p131o.InterfaceC3134X2;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC1863E2, InterfaceC1932F2 {

    /* renamed from: Gd */
    public static final Comparator f891Gd;

    /* renamed from: HGpJ */
    public static final InterfaceC1601A3 f892HGpJ;

    /* renamed from: Ucbh */
    public static final Class[] f893Ucbh;

    /* renamed from: eyqo */
    public static final String f894eyqo;

    /* renamed from: huTpC */
    public static final ThreadLocal f895huTpC;

    /* renamed from: AZxh */
    public final C4874xIpq f896AZxh;

    /* renamed from: Dt */
    public int[] f897Dt;

    /* renamed from: ETF */
    public View f898ETF;

    /* renamed from: IEE */
    public ViewGroup.OnHierarchyChangeListener f899IEE;

    /* renamed from: JHa */
    public final int[] f900JHa;

    /* renamed from: KLFTb */
    public Paint f901KLFTb;

    /* renamed from: MiMN */
    public ViewTreeObserverOnPreDrawListenerC0059JHa f902MiMN;

    /* renamed from: Pq */
    public InterfaceC3134X2 f903Pq;

    /* renamed from: VA */
    public View f904VA;

    /* renamed from: YoKzxo */
    public boolean f905YoKzxo;

    /* renamed from: ZfxDd */
    public final List f906ZfxDd;

    /* renamed from: diqgf */
    public final C2005G2 f907diqgf;

    /* renamed from: fehf */
    public Drawable f908fehf;

    /* renamed from: lgHUyS */
    public boolean f909lgHUyS;

    /* renamed from: mjFkc */
    public final List f910mjFkc;

    /* renamed from: qGY */
    public boolean f911qGY;

    /* renamed from: qdMbNW */
    public boolean f912qdMbNW;

    /* renamed from: rkYL */
    public C3372ab f913rkYL;

    /* renamed from: wA */
    public final List f914wA;

    /* renamed from: xJ */
    public final int[] f915xJ;

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$AZxh */
    public static abstract class AbstractC0058AZxh {
        public AbstractC0058AZxh() {
        }

        /* renamed from: AZxh */
        public boolean mo485AZxh(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        /* renamed from: BAnRFn */
        public void m486BAnRFn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        /* renamed from: Dt */
        public void mo487Dt() {
        }

        /* renamed from: ETF */
        public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: Gd */
        public void mo489Gd(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        /* renamed from: HGpJ */
        public Parcelable mo490HGpJ(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* renamed from: IEE */
        public void m491IEE(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4) {
        }

        /* renamed from: JHa */
        public C3372ab m492JHa(CoordinatorLayout coordinatorLayout, View view, C3372ab c3372ab) {
            return c3372ab;
        }

        /* renamed from: KLFTb */
        public boolean mo493KLFTb(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        /* renamed from: MiMN */
        public boolean mo494MiMN(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: Pq */
        public void m495Pq(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                m491IEE(coordinatorLayout, view, view2, i, i2, i3, i4);
            }
        }

        /* renamed from: Ucbh */
        public void m496Ucbh(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                m502eyqo(coordinatorLayout, view, view2, view3, i);
            }
        }

        /* renamed from: VA */
        public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        /* renamed from: VocHEe */
        public boolean mo498VocHEe(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                return m511vI(coordinatorLayout, view, view2, view3, i);
            }
            return false;
        }

        /* renamed from: YoKzxo */
        public boolean m499YoKzxo(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2, boolean z) {
            return false;
        }

        /* renamed from: ZfxDd */
        public float m500ZfxDd(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        /* renamed from: diqgf */
        public void mo501diqgf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            m495Pq(coordinatorLayout, view, view2, i, i2, i3, i4, i5);
        }

        /* renamed from: eyqo */
        public void m502eyqo(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        }

        /* renamed from: fehf */
        public void mo503fehf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                m508qGY(coordinatorLayout, view, view2, i, i2, iArr);
            }
        }

        /* renamed from: huTpC */
        public boolean mo504huTpC(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: lB */
        public void mo505lB(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            if (i == 0) {
                m486BAnRFn(coordinatorLayout, view, view2);
            }
        }

        /* renamed from: lgHUyS */
        public boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        /* renamed from: mjFkc */
        public boolean m507mjFkc(CoordinatorLayout coordinatorLayout, View view) {
            return m500ZfxDd(coordinatorLayout, view) > 0.0f;
        }

        /* renamed from: qGY */
        public void m508qGY(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        }

        /* renamed from: qdMbNW */
        public void mo509qdMbNW(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        /* renamed from: rkYL */
        public boolean mo510rkYL(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
            return false;
        }

        /* renamed from: vI */
        public boolean m511vI(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
            return false;
        }

        /* renamed from: wA */
        public int m512wA(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        /* renamed from: wJVbdd */
        public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: xJ */
        public void mo514xJ(C0060KLFTb c0060KLFTb) {
        }

        public AbstractC0058AZxh(Context context, AttributeSet attributeSet) {
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$JHa */
    public class ViewTreeObserverOnPreDrawListenerC0059JHa implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC0059JHa() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.m463OjSQV(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$ZfxDd */
    public class ViewGroupOnHierarchyChangeListenerC0061ZfxDd implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroupOnHierarchyChangeListenerC0061ZfxDd() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f899IEE;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.m463OjSQV(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f899IEE;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$lgHUyS */
    public static class C0062lgHUyS implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fM10246Ne = AbstractC2876T9.m10246Ne(view);
            float fM10246Ne2 = AbstractC2876T9.m10246Ne(view2);
            if (fM10246Ne > fM10246Ne2) {
                return -1;
            }
            return fM10246Ne < fM10246Ne2 ? 1 : 0;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$mjFkc */
    public class C0063mjFkc implements InterfaceC3134X2 {
        public C0063mjFkc() {
        }

        @Override // p131o.InterfaceC3134X2
        /* renamed from: mjFkc */
        public C3372ab mo535mjFkc(View view, C3372ab c3372ab) {
            return CoordinatorLayout.this.m454GMIER(c3372ab);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$wA */
    public @interface InterfaceC0064wA {
        /* renamed from: value */
        Class m536value();
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f894eyqo = r0 != null ? r0.getName() : null;
        f891Gd = new C0062lgHUyS();
        f893Ucbh = new Class[]{Context.class, AttributeSet.class};
        f895huTpC = new ThreadLocal();
        f892HGpJ = new C1864E3(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3602e4.f13433mjFkc);
    }

    /* renamed from: aqHPIZ */
    public static int m443aqHPIZ(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* renamed from: oCFDzJ */
    public static int m444oCFDzJ(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    /* renamed from: qdMbNW */
    private static int m445qdMbNW(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* renamed from: rWxwaT */
    public static void m446rWxwaT(Rect rect) {
        rect.setEmpty();
        f892HGpJ.mo7551mjFkc(rect);
    }

    /* renamed from: vadzgd */
    public static int m447vadzgd(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    /* renamed from: xJ */
    public static Rect m448xJ() {
        Rect rect = (Rect) f892HGpJ.mo7550AZxh();
        return rect == null ? new Rect() : rect;
    }

    /* renamed from: xrEuO */
    public static AbstractC0058AZxh m449xrEuO(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f894eyqo;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f895huTpC;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f893Ucbh);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (AbstractC0058AZxh) constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: AZxh */
    public void mo189AZxh(View view, int i) {
        this.f907diqgf.m8394ZfxDd(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
            if (c0060KLFTb.m530qdMbNW(i)) {
                AbstractC0058AZxh abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb();
                if (abstractC0058AZxhM520KLFTb != null) {
                    abstractC0058AZxhM520KLFTb.mo505lB(this, childAt, view, i);
                }
                c0060KLFTb.m517ETF(i);
                c0060KLFTb.m516Dt();
            }
        }
        this.f904VA = null;
    }

    /* renamed from: BAnRFn */
    public final void m450BAnRFn(View view, View view2, int i) {
        Rect rectM448xJ = m448xJ();
        Rect rectM448xJ2 = m448xJ();
        try {
            m457IEE(view2, rectM448xJ);
            m464Pq(view, i, rectM448xJ, rectM448xJ2);
            view.layout(rectM448xJ2.left, rectM448xJ2.top, rectM448xJ2.right, rectM448xJ2.bottom);
        } finally {
            m446rWxwaT(rectM448xJ);
            m446rWxwaT(rectM448xJ2);
        }
    }

    /* renamed from: CqaNbM */
    public void m451CqaNbM(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* renamed from: Dt */
    public final void m452Dt(C0060KLFTb c0060KLFTb, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    /* renamed from: ETF */
    public final C3372ab m453ETF(C3372ab c3372ab) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        if (c3372ab.m11339YoKzxo()) {
            return c3372ab;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (AbstractC2876T9.m10269diqgf(childAt) && (abstractC0058AZxhM520KLFTb = ((C0060KLFTb) childAt.getLayoutParams()).m520KLFTb()) != null) {
                c3372ab = abstractC0058AZxhM520KLFTb.m492JHa(this, childAt, c3372ab);
                if (c3372ab.m11339YoKzxo()) {
                    break;
                }
            }
        }
        return c3372ab;
    }

    /* renamed from: GMIER */
    public final C3372ab m454GMIER(C3372ab c3372ab) {
        if (AbstractC3003V2.m10659mjFkc(this.f913rkYL, c3372ab)) {
            return c3372ab;
        }
        this.f913rkYL = c3372ab;
        boolean z = false;
        boolean z2 = c3372ab != null && c3372ab.m11334ETF() > 0;
        this.f911qGY = z2;
        if (!z2 && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        C3372ab c3372abM453ETF = m453ETF(c3372ab);
        requestLayout();
        return c3372abM453ETF;
    }

    /* renamed from: Gd */
    public final void m455Gd(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator comparator = f891Gd;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    /* renamed from: HGpJ */
    public final boolean m456HGpJ(View view) {
        return this.f896AZxh.m13929qdMbNW(view);
    }

    /* renamed from: IEE */
    public void m457IEE(View view, Rect rect) {
        AbstractC3634ea.m11849mjFkc(this, view, rect);
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: JHa */
    public boolean mo193JHa(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
                AbstractC0058AZxh abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb();
                if (abstractC0058AZxhM520KLFTb != null) {
                    boolean zMo498VocHEe = abstractC0058AZxhM520KLFTb.mo498VocHEe(this, childAt, view, view2, i, i2);
                    z |= zMo498VocHEe;
                    c0060KLFTb.m526fehf(i2, zMo498VocHEe);
                } else {
                    c0060KLFTb.m526fehf(i2, false);
                }
            }
        }
        return z;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: KLFTb */
    public void mo194KLFTb(View view, int i, int i2, int i3, int i4, int i5) {
        mo198ZfxDd(view, i, i2, i3, i4, 0, this.f915xJ);
    }

    /* renamed from: KLMXS */
    public final boolean m458KLMXS(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f914wA;
        m455Gd(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zMo488ETF = false;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) list.get(i2);
            C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb();
            if (!(zMo488ETF || z) || actionMasked == 0) {
                if (!zMo488ETF && abstractC0058AZxhM520KLFTb != null) {
                    if (i == 0) {
                        zMo488ETF = abstractC0058AZxhM520KLFTb.mo488ETF(this, view, motionEvent);
                    } else if (i == 1) {
                        zMo488ETF = abstractC0058AZxhM520KLFTb.mo513wJVbdd(this, view, motionEvent);
                    }
                    if (zMo488ETF) {
                        this.f898ETF = view;
                    }
                }
                boolean zM532wA = c0060KLFTb.m532wA();
                boolean zM527lgHUyS = c0060KLFTb.m527lgHUyS(this, view);
                z = zM527lgHUyS && !zM532wA;
                if (zM527lgHUyS && !z) {
                    break;
                }
            } else if (abstractC0058AZxhM520KLFTb != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    abstractC0058AZxhM520KLFTb.mo488ETF(this, view, motionEventObtain);
                } else if (i == 1) {
                    abstractC0058AZxhM520KLFTb.mo513wJVbdd(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zMo488ETF;
    }

    /* renamed from: KRTLGT */
    public final void m459KRTLGT(View view, int i) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        int i2 = c0060KLFTb.f918Dt;
        if (i2 != i) {
            AbstractC2876T9.m10240KRTLGT(view, i - i2);
            c0060KLFTb.f918Dt = i;
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: MiMN, reason: merged with bridge method [inline-methods] */
    public C0060KLFTb generateDefaultLayoutParams() {
        return new C0060KLFTb(-2, -2);
    }

    /* renamed from: NPj */
    public final void m461NPj(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = ((C0060KLFTb) childAt.getLayoutParams()).m520KLFTb();
            if (abstractC0058AZxhM520KLFTb != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    abstractC0058AZxhM520KLFTb.mo488ETF(this, childAt, motionEventObtain);
                } else {
                    abstractC0058AZxhM520KLFTb.mo513wJVbdd(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0060KLFTb) getChildAt(i2).getLayoutParams()).m523VA();
        }
        this.f898ETF = null;
        this.f909lgHUyS = false;
    }

    /* renamed from: Ne */
    public void m462Ne(View view, int i) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        if (c0060KLFTb.m528mjFkc()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = c0060KLFTb.f919ETF;
        if (view2 != null) {
            m450BAnRFn(view, view2, i);
            return;
        }
        int i2 = c0060KLFTb.f922KLFTb;
        if (i2 >= 0) {
            m476lB(view, i2, i);
        } else {
            m468VocHEe(view, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /* renamed from: OjSQV */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m463OjSQV(int i) {
        int i2;
        boolean zMo506lgHUyS;
        int iM10276huTpC = AbstractC2876T9.m10276huTpC(this);
        int size = this.f910mjFkc.size();
        Rect rectM448xJ = m448xJ();
        Rect rectM448xJ2 = m448xJ();
        Rect rectM448xJ3 = m448xJ();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f910mjFkc.get(i3);
            C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (c0060KLFTb.f924VA == ((View) this.f910mjFkc.get(i4))) {
                        m478mByQ(view, iM10276huTpC);
                    }
                }
                m479qGY(view, true, rectM448xJ2);
                if (c0060KLFTb.f934xJ != 0 && !rectM448xJ2.isEmpty()) {
                    int iM12647AZxh = AbstractC4056l.m12647AZxh(c0060KLFTb.f934xJ, iM10276huTpC);
                    int i5 = iM12647AZxh & 112;
                    if (i5 == 48) {
                        rectM448xJ.top = Math.max(rectM448xJ.top, rectM448xJ2.bottom);
                    } else if (i5 == 80) {
                        rectM448xJ.bottom = Math.max(rectM448xJ.bottom, getHeight() - rectM448xJ2.top);
                    }
                    int i6 = iM12647AZxh & 7;
                    if (i6 == 3) {
                        rectM448xJ.left = Math.max(rectM448xJ.left, rectM448xJ2.right);
                    } else if (i6 == 5) {
                        rectM448xJ.right = Math.max(rectM448xJ.right, getWidth() - rectM448xJ2.left);
                    }
                }
                if (c0060KLFTb.f928lgHUyS != 0 && view.getVisibility() == 0) {
                    m483wJVbdd(view, rectM448xJ, iM10276huTpC);
                }
                if (i != 2) {
                    m465Ucbh(view, rectM448xJ3);
                    if (!rectM448xJ3.equals(rectM448xJ2)) {
                        m471cMLeY(view, rectM448xJ2);
                        for (i2 = i3 + 1; i2 < size; i2++) {
                            View view2 = (View) this.f910mjFkc.get(i2);
                            C0060KLFTb c0060KLFTb2 = (C0060KLFTb) view2.getLayoutParams();
                            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = c0060KLFTb2.m520KLFTb();
                            if (abstractC0058AZxhM520KLFTb != null && abstractC0058AZxhM520KLFTb.mo493KLFTb(this, view2, view)) {
                                if (i == 0 && c0060KLFTb2.m519JHa()) {
                                    c0060KLFTb2.m516Dt();
                                } else {
                                    if (i != 2) {
                                        zMo506lgHUyS = abstractC0058AZxhM520KLFTb.mo506lgHUyS(this, view2, view);
                                    } else {
                                        abstractC0058AZxhM520KLFTb.mo509qdMbNW(this, view2, view);
                                        zMo506lgHUyS = true;
                                    }
                                    if (i == 1) {
                                        c0060KLFTb2.m531rkYL(zMo506lgHUyS);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i2 < size) {
                    }
                }
            }
        }
        m446rWxwaT(rectM448xJ);
        m446rWxwaT(rectM448xJ2);
        m446rWxwaT(rectM448xJ3);
    }

    /* renamed from: Pq */
    public void m464Pq(View view, int i, Rect rect, Rect rect2) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m472diqgf(view, i, rect, rect2, c0060KLFTb, measuredWidth, measuredHeight);
        m452Dt(c0060KLFTb, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: Ucbh */
    public void m465Ucbh(View view, Rect rect) {
        rect.set(((C0060KLFTb) view.getLayoutParams()).m533xJ());
    }

    /* renamed from: VA */
    public void m466VA() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (m456HGpJ(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.f905YoKzxo) {
            if (z) {
                m477lgHUyS();
            } else {
                m467Vnb();
            }
        }
    }

    /* renamed from: Vnb */
    public void m467Vnb() {
        if (this.f912qdMbNW && this.f902MiMN != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f902MiMN);
        }
        this.f905YoKzxo = false;
    }

    /* renamed from: VocHEe */
    public final void m468VocHEe(View view, int i) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        Rect rectM448xJ = m448xJ();
        rectM448xJ.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).bottomMargin);
        if (this.f913rkYL != null && AbstractC2876T9.m10269diqgf(this) && !AbstractC2876T9.m10269diqgf(view)) {
            rectM448xJ.left += this.f913rkYL.m11346qdMbNW();
            rectM448xJ.top += this.f913rkYL.m11334ETF();
            rectM448xJ.right -= this.f913rkYL.m11333Dt();
            rectM448xJ.bottom -= this.f913rkYL.m11343lgHUyS();
        }
        Rect rectM448xJ2 = m448xJ();
        AbstractC4056l.m12648mjFkc(m444oCFDzJ(c0060KLFTb.f933wA), view.getMeasuredWidth(), view.getMeasuredHeight(), rectM448xJ, rectM448xJ2, i);
        view.layout(rectM448xJ2.left, rectM448xJ2.top, rectM448xJ2.right, rectM448xJ2.bottom);
        m446rWxwaT(rectM448xJ);
        m446rWxwaT(rectM448xJ2);
    }

    /* renamed from: WrLQs */
    public final void m469WrLQs(View view, int i) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        int i2 = c0060KLFTb.f931qdMbNW;
        if (i2 != i) {
            AbstractC2876T9.m10259WrLQs(view, i - i2);
            c0060KLFTb.f931qdMbNW = i;
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: YoKzxo, reason: merged with bridge method [inline-methods] */
    public C0060KLFTb generateLayoutParams(AttributeSet attributeSet) {
        return new C0060KLFTb(getContext(), attributeSet);
    }

    @Override // p131o.InterfaceC1932F2
    /* renamed from: ZfxDd */
    public void mo198ZfxDd(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        boolean z;
        int iMin;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
                if (c0060KLFTb.m530qdMbNW(i5) && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                    int[] iArr2 = this.f900JHa;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0058AZxhM520KLFTb.mo501diqgf(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.f900JHa;
                    iMax = i3 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i4 > 0) {
                        z = true;
                        iMin = Math.max(i6, this.f900JHa[1]);
                    } else {
                        z = true;
                        iMin = Math.min(i6, this.f900JHa[1]);
                    }
                    i6 = iMin;
                    z2 = z;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i6;
        if (z2) {
            m463OjSQV(1);
        }
    }

    /* renamed from: cMLeY */
    public void m471cMLeY(View view, Rect rect) {
        ((C0060KLFTb) view.getLayoutParams()).m529qGY(rect);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0060KLFTb) && super.checkLayoutParams(layoutParams);
    }

    /* renamed from: diqgf */
    public final void m472diqgf(View view, int i, Rect rect, Rect rect2, C0060KLFTb c0060KLFTb, int i2, int i3) {
        int iM12647AZxh = AbstractC4056l.m12647AZxh(m447vadzgd(c0060KLFTb.f933wA), i);
        int iM12647AZxh2 = AbstractC4056l.m12647AZxh(m444oCFDzJ(c0060KLFTb.f926ZfxDd), i);
        int i4 = iM12647AZxh & 7;
        int i5 = iM12647AZxh & 112;
        int i6 = iM12647AZxh2 & 7;
        int i7 = iM12647AZxh2 & 112;
        int iWidth = i6 != 1 ? i6 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i7 != 16 ? i7 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        AbstractC0058AZxh abstractC0058AZxh = c0060KLFTb.f929mjFkc;
        if (abstractC0058AZxh != null) {
            float fM500ZfxDd = abstractC0058AZxh.m500ZfxDd(this, view);
            if (fM500ZfxDd > 0.0f) {
                if (this.f901KLFTb == null) {
                    this.f901KLFTb = new Paint();
                }
                this.f901KLFTb.setColor(c0060KLFTb.f929mjFkc.m512wA(this, view));
                this.f901KLFTb.setAlpha(m445qdMbNW(Math.round(fM500ZfxDd * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f901KLFTb);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f908fehf;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    /* renamed from: eyqo */
    public final int m473eyqo(int i) {
        int[] iArr = this.f897Dt;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    /* renamed from: fehf */
    public List m474fehf(View view) {
        List listM13931xJ = this.f896AZxh.m13931xJ(view);
        this.f906ZfxDd.clear();
        if (listM13931xJ != null) {
            this.f906ZfxDd.addAll(listM13931xJ);
        }
        return this.f906ZfxDd;
    }

    public final List<View> getDependencySortedChildren() {
        m484zvd();
        return Collections.unmodifiableList(this.f910mjFkc);
    }

    public final C3372ab getLastWindowInsets() {
        return this.f913rkYL;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f907diqgf.m8395mjFkc();
    }

    public Drawable getStatusBarBackground() {
        return this.f908fehf;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* renamed from: huTpC */
    public C0060KLFTb m475huTpC(View view) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        if (!c0060KLFTb.f917AZxh) {
            InterfaceC0064wA interfaceC0064wA = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                interfaceC0064wA = (InterfaceC0064wA) superclass.getAnnotation(InterfaceC0064wA.class);
                if (interfaceC0064wA != null) {
                    break;
                }
            }
            if (interfaceC0064wA != null) {
                try {
                    c0060KLFTb.m524YoKzxo((AbstractC0058AZxh) interfaceC0064wA.m536value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0064wA.m536value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0060KLFTb.f917AZxh = true;
        }
        return c0060KLFTb;
    }

    /* renamed from: lB */
    public final void m476lB(View view, int i, int i2) {
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        int iM12647AZxh = AbstractC4056l.m12647AZxh(m443aqHPIZ(c0060KLFTb.f933wA), i2);
        int i3 = iM12647AZxh & 7;
        int i4 = iM12647AZxh & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int iM473eyqo = m473eyqo(i) - measuredWidth;
        if (i3 == 1) {
            iM473eyqo += measuredWidth / 2;
        } else if (i3 == 5) {
            iM473eyqo += measuredWidth;
        }
        int i5 = i4 != 16 ? i4 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).leftMargin, Math.min(iM473eyqo, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0060KLFTb).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    /* renamed from: lgHUyS */
    public void m477lgHUyS() {
        if (this.f912qdMbNW) {
            if (this.f902MiMN == null) {
                this.f902MiMN = new ViewTreeObserverOnPreDrawListenerC0059JHa();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f902MiMN);
        }
        this.f905YoKzxo = true;
    }

    /* renamed from: mByQ */
    public void m478mByQ(View view, int i) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
        if (c0060KLFTb.f919ETF != null) {
            Rect rectM448xJ = m448xJ();
            Rect rectM448xJ2 = m448xJ();
            Rect rectM448xJ3 = m448xJ();
            m457IEE(c0060KLFTb.f919ETF, rectM448xJ);
            m479qGY(view, false, rectM448xJ2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m472diqgf(view, i, rectM448xJ, rectM448xJ3, c0060KLFTb, measuredWidth, measuredHeight);
            boolean z = (rectM448xJ3.left == rectM448xJ2.left && rectM448xJ3.top == rectM448xJ2.top) ? false : true;
            m452Dt(c0060KLFTb, rectM448xJ3, measuredWidth, measuredHeight);
            int i2 = rectM448xJ3.left - rectM448xJ2.left;
            int i3 = rectM448xJ3.top - rectM448xJ2.top;
            if (i2 != 0) {
                AbstractC2876T9.m10259WrLQs(view, i2);
            }
            if (i3 != 0) {
                AbstractC2876T9.m10240KRTLGT(view, i3);
            }
            if (z && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                abstractC0058AZxhM520KLFTb.mo506lgHUyS(this, view, c0060KLFTb.f919ETF);
            }
            m446rWxwaT(rectM448xJ);
            m446rWxwaT(rectM448xJ2);
            m446rWxwaT(rectM448xJ3);
        }
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: mjFkc */
    public void mo201mjFkc(View view, View view2, int i, int i2) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        this.f907diqgf.m8396wA(view, view2, i, i2);
        this.f904VA = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
            if (c0060KLFTb.m530qdMbNW(i2) && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                abstractC0058AZxhM520KLFTb.m496Ucbh(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m461NPj(false);
        if (this.f905YoKzxo) {
            if (this.f902MiMN == null) {
                this.f902MiMN = new ViewTreeObserverOnPreDrawListenerC0059JHa();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f902MiMN);
        }
        if (this.f913rkYL == null && AbstractC2876T9.m10269diqgf(this)) {
            AbstractC2876T9.m10255Vdz(this);
        }
        this.f912qdMbNW = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m461NPj(false);
        if (this.f905YoKzxo && this.f902MiMN != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f902MiMN);
        }
        View view = this.f904VA;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f912qdMbNW = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f911qGY || this.f908fehf == null) {
            return;
        }
        C3372ab c3372ab = this.f913rkYL;
        int iM11334ETF = c3372ab != null ? c3372ab.m11334ETF() : 0;
        if (iM11334ETF > 0) {
            this.f908fehf.setBounds(0, 0, getWidth(), iM11334ETF);
            this.f908fehf.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m461NPj(true);
        }
        boolean zM458KLMXS = m458KLMXS(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m461NPj(true);
        }
        return zM458KLMXS;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        int iM10276huTpC = AbstractC2876T9.m10276huTpC(this);
        int size = this.f910mjFkc.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f910mjFkc.get(i5);
            if (view.getVisibility() != 8 && ((abstractC0058AZxhM520KLFTb = ((C0060KLFTb) view.getLayoutParams()).m520KLFTb()) == null || !abstractC0058AZxhM520KLFTb.mo497VA(this, view, iM10276huTpC))) {
                m462Ne(view, iM10276huTpC);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        C0060KLFTb c0060KLFTb;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        m484zvd();
        m466VA();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iM10276huTpC = AbstractC2876T9.m10276huTpC(this);
        boolean z = iM10276huTpC == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i10 = paddingLeft + paddingRight;
        int i11 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.f913rkYL != null && AbstractC2876T9.m10269diqgf(this);
        int size3 = this.f910mjFkc.size();
        int i12 = suggestedMinimumWidth;
        int i13 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i14 = 0;
        while (i14 < size3) {
            View view = (View) this.f910mjFkc.get(i14);
            if (view.getVisibility() == 8) {
                i8 = i14;
                i5 = size3;
                i6 = paddingLeft;
            } else {
                C0060KLFTb c0060KLFTb2 = (C0060KLFTb) view.getLayoutParams();
                int i15 = c0060KLFTb2.f922KLFTb;
                if (i15 < 0 || mode == 0) {
                    i3 = iCombineMeasuredStates;
                } else {
                    int iM473eyqo = m473eyqo(i15);
                    int iM12647AZxh = AbstractC4056l.m12647AZxh(m443aqHPIZ(c0060KLFTb2.f933wA), iM10276huTpC) & 7;
                    i3 = iCombineMeasuredStates;
                    if ((iM12647AZxh == 3 && !z) || (iM12647AZxh == 5 && z)) {
                        iMax = Math.max(0, (size - paddingRight) - iM473eyqo);
                    } else if ((iM12647AZxh == 5 && !z) || (iM12647AZxh == 3 && z)) {
                        iMax = Math.max(0, iM473eyqo - paddingLeft);
                    }
                    if (z2 || AbstractC2876T9.m10269diqgf(view)) {
                        iMakeMeasureSpec = i;
                        iMakeMeasureSpec2 = i2;
                    } else {
                        int iM11346qdMbNW = this.f913rkYL.m11346qdMbNW() + this.f913rkYL.m11333Dt();
                        int iM11334ETF = this.f913rkYL.m11334ETF() + this.f913rkYL.m11343lgHUyS();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iM11346qdMbNW, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iM11334ETF, mode2);
                    }
                    abstractC0058AZxhM520KLFTb = c0060KLFTb2.m520KLFTb();
                    if (abstractC0058AZxhM520KLFTb == null) {
                        c0060KLFTb = c0060KLFTb2;
                        i7 = i3;
                        i8 = i14;
                        i4 = i13;
                        i6 = paddingLeft;
                        i9 = i12;
                        i5 = size3;
                        if (!abstractC0058AZxhM520KLFTb.mo494MiMN(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        C0060KLFTb c0060KLFTb3 = c0060KLFTb;
                        int iMax2 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0060KLFTb3).leftMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb3).rightMargin);
                        int iMax3 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0060KLFTb3).topMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                        i12 = iMax2;
                        i13 = iMax3;
                    } else {
                        c0060KLFTb = c0060KLFTb2;
                        i4 = i13;
                        i5 = size3;
                        i6 = paddingLeft;
                        i7 = i3;
                        i8 = i14;
                        i9 = i12;
                    }
                    m451CqaNbM(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    C0060KLFTb c0060KLFTb32 = c0060KLFTb;
                    int iMax22 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0060KLFTb32).leftMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb32).rightMargin);
                    int iMax32 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0060KLFTb32).topMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb32).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                    i12 = iMax22;
                    i13 = iMax32;
                }
                iMax = 0;
                if (z2) {
                    iMakeMeasureSpec = i;
                    iMakeMeasureSpec2 = i2;
                    abstractC0058AZxhM520KLFTb = c0060KLFTb2.m520KLFTb();
                    if (abstractC0058AZxhM520KLFTb == null) {
                    }
                    m451CqaNbM(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    C0060KLFTb c0060KLFTb322 = c0060KLFTb;
                    int iMax222 = Math.max(i9, i10 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0060KLFTb322).leftMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb322).rightMargin);
                    int iMax322 = Math.max(i4, i11 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0060KLFTb322).topMargin + ((ViewGroup.MarginLayoutParams) c0060KLFTb322).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i7, view.getMeasuredState());
                    i12 = iMax222;
                    i13 = iMax322;
                }
            }
            i14 = i8 + 1;
            paddingLeft = i6;
            size3 = i5;
        }
        int i16 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i12, i, (-16777216) & i16), View.resolveSizeAndState(i13, i2, i16 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        int childCount = getChildCount();
        boolean zM499YoKzxo = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
                if (c0060KLFTb.m530qdMbNW(0) && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                    zM499YoKzxo |= abstractC0058AZxhM520KLFTb.m499YoKzxo(this, childAt, view, f, f2, z);
                }
            }
        }
        if (zM499YoKzxo) {
            m463OjSQV(1);
        }
        return zM499YoKzxo;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        int childCount = getChildCount();
        boolean zMo510rkYL = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
                if (c0060KLFTb.m530qdMbNW(0) && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                    zMo510rkYL |= abstractC0058AZxhM520KLFTb.mo510rkYL(this, childAt, view, f, f2);
                }
            }
        }
        return zMo510rkYL;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo208wA(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo194KLFTb(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo201mjFkc(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0065xJ)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0065xJ c0065xJ = (C0065xJ) parcelable;
        super.onRestoreInstanceState(c0065xJ.m13824mjFkc());
        SparseArray sparseArray = c0065xJ.f938wA;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = m475huTpC(childAt).m520KLFTb();
            if (id != -1 && abstractC0058AZxhM520KLFTb != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                abstractC0058AZxhM520KLFTb.mo489Gd(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableMo490HGpJ;
        C0065xJ c0065xJ = new C0065xJ(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = ((C0060KLFTb) childAt.getLayoutParams()).m520KLFTb();
            if (id != -1 && abstractC0058AZxhM520KLFTb != null && (parcelableMo490HGpJ = abstractC0058AZxhM520KLFTb.mo490HGpJ(this, childAt)) != null) {
                sparseArray.append(id, parcelableMo490HGpJ);
            }
        }
        c0065xJ.f938wA = sparseArray;
        return c0065xJ;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo193JHa(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        mo189AZxh(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zM458KLMXS;
        boolean zMo513wJVbdd;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f898ETF == null) {
            zM458KLMXS = m458KLMXS(motionEvent, 1);
            if (!zM458KLMXS) {
                zMo513wJVbdd = false;
            }
            motionEventObtain = null;
            if (this.f898ETF != null) {
                zMo513wJVbdd |= super.onTouchEvent(motionEvent);
            } else if (zM458KLMXS) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                m461NPj(false);
            }
            return zMo513wJVbdd;
        }
        zM458KLMXS = false;
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb = ((C0060KLFTb) this.f898ETF.getLayoutParams()).m520KLFTb();
        if (abstractC0058AZxhM520KLFTb != null) {
            zMo513wJVbdd = abstractC0058AZxhM520KLFTb.mo513wJVbdd(this, this.f898ETF, motionEvent);
        }
        motionEventObtain = null;
        if (this.f898ETF != null) {
        }
        if (motionEventObtain != null) {
        }
        if (actionMasked != 1) {
            m461NPj(false);
        }
        return zMo513wJVbdd;
    }

    /* renamed from: qGY */
    public void m479qGY(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m457IEE(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb = ((C0060KLFTb) view.getLayoutParams()).m520KLFTb();
        if (abstractC0058AZxhM520KLFTb == null || !abstractC0058AZxhM520KLFTb.mo504huTpC(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f909lgHUyS) {
            return;
        }
        m461NPj(false);
        this.f909lgHUyS = true;
    }

    @Override // android.view.ViewGroup
    /* renamed from: rkYL, reason: merged with bridge method [inline-methods] */
    public C0060KLFTb generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0060KLFTb ? new C0060KLFTb((C0060KLFTb) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0060KLFTb((ViewGroup.MarginLayoutParams) layoutParams) : new C0060KLFTb(layoutParams);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m481uHVRx();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f899IEE = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f908fehf;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f908fehf = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f908fehf.setState(getDrawableState());
                }
                AbstractC4332pCk.m13083xJ(this.f908fehf, AbstractC2876T9.m10276huTpC(this));
                this.f908fehf.setVisible(getVisibility() == 0, false);
                this.f908fehf.setCallback(this);
            }
            AbstractC2876T9.m10283nxI(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? AbstractC4294ofHOBL.m12997wA(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f908fehf;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.f908fehf.setVisible(z, false);
    }

    /* renamed from: uHVRx */
    public final void m481uHVRx() {
        if (!AbstractC2876T9.m10269diqgf(this)) {
            AbstractC2876T9.m10300yX(this, null);
            return;
        }
        if (this.f903Pq == null) {
            this.f903Pq = new C0063mjFkc();
        }
        AbstractC2876T9.m10300yX(this, this.f903Pq);
        setSystemUiVisibility(1280);
    }

    /* renamed from: vI */
    public boolean m482vI(View view, int i, int i2) {
        Rect rectM448xJ = m448xJ();
        m457IEE(view, rectM448xJ);
        try {
            return rectM448xJ.contains(i, i2);
        } finally {
            m446rWxwaT(rectM448xJ);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f908fehf;
    }

    @Override // p131o.InterfaceC1863E2
    /* renamed from: wA */
    public void mo208wA(View view, int i, int i2, int[] iArr, int i3) {
        AbstractC0058AZxh abstractC0058AZxhM520KLFTb;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0060KLFTb c0060KLFTb = (C0060KLFTb) childAt.getLayoutParams();
                if (c0060KLFTb.m530qdMbNW(i3) && (abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb()) != null) {
                    int[] iArr2 = this.f900JHa;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0058AZxhM520KLFTb.mo503fehf(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.f900JHa;
                    iMax = i > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f900JHa;
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            m463OjSQV(1);
        }
    }

    /* renamed from: wJVbdd */
    public final void m483wJVbdd(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (AbstractC2876T9.m10287rWxwaT(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0060KLFTb c0060KLFTb = (C0060KLFTb) view.getLayoutParams();
            AbstractC0058AZxh abstractC0058AZxhM520KLFTb = c0060KLFTb.m520KLFTb();
            Rect rectM448xJ = m448xJ();
            Rect rectM448xJ2 = m448xJ();
            rectM448xJ2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (abstractC0058AZxhM520KLFTb == null || !abstractC0058AZxhM520KLFTb.mo485AZxh(this, view, rectM448xJ)) {
                rectM448xJ.set(rectM448xJ2);
            } else if (!rectM448xJ2.contains(rectM448xJ)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectM448xJ.toShortString() + " | Bounds:" + rectM448xJ2.toShortString());
            }
            m446rWxwaT(rectM448xJ2);
            if (rectM448xJ.isEmpty()) {
                m446rWxwaT(rectM448xJ);
                return;
            }
            int iM12647AZxh = AbstractC4056l.m12647AZxh(c0060KLFTb.f928lgHUyS, i);
            boolean z3 = true;
            if ((iM12647AZxh & 48) != 48 || (i6 = (rectM448xJ.top - ((ViewGroup.MarginLayoutParams) c0060KLFTb).topMargin) - c0060KLFTb.f918Dt) >= (i7 = rect.top)) {
                z = false;
            } else {
                m459KRTLGT(view, i7 - i6);
                z = true;
            }
            if ((iM12647AZxh & 80) == 80 && (height = ((getHeight() - rectM448xJ.bottom) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).bottomMargin) + c0060KLFTb.f918Dt) < (i5 = rect.bottom)) {
                m459KRTLGT(view, height - i5);
                z = true;
            }
            if (!z) {
                m459KRTLGT(view, 0);
            }
            if ((iM12647AZxh & 3) != 3 || (i3 = (rectM448xJ.left - ((ViewGroup.MarginLayoutParams) c0060KLFTb).leftMargin) - c0060KLFTb.f931qdMbNW) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                m469WrLQs(view, i4 - i3);
                z2 = true;
            }
            if ((iM12647AZxh & 5) != 5 || (width = ((getWidth() - rectM448xJ.right) - ((ViewGroup.MarginLayoutParams) c0060KLFTb).rightMargin) + c0060KLFTb.f931qdMbNW) >= (i2 = rect.right)) {
                z3 = z2;
            } else {
                m469WrLQs(view, width - i2);
            }
            if (!z3) {
                m469WrLQs(view, 0);
            }
            m446rWxwaT(rectM448xJ);
        }
    }

    /* renamed from: zvd */
    public final void m484zvd() {
        this.f910mjFkc.clear();
        this.f896AZxh.m13930wA();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0060KLFTb c0060KLFTbM475huTpC = m475huTpC(childAt);
            c0060KLFTbM475huTpC.m525ZfxDd(this, childAt);
            this.f896AZxh.m13922AZxh(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (c0060KLFTbM475huTpC.m515AZxh(this, childAt, childAt2)) {
                        if (!this.f896AZxh.m13926ZfxDd(childAt2)) {
                            this.f896AZxh.m13922AZxh(childAt2);
                        }
                        this.f896AZxh.m13928mjFkc(childAt2, childAt);
                    }
                }
            }
        }
        this.f910mjFkc.addAll(this.f896AZxh.m13927lgHUyS());
        Collections.reverse(this.f910mjFkc);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f910mjFkc = new ArrayList();
        this.f896AZxh = new C4874xIpq();
        this.f914wA = new ArrayList();
        this.f906ZfxDd = new ArrayList();
        this.f900JHa = new int[2];
        this.f915xJ = new int[2];
        this.f907diqgf = new C2005G2(this);
        TypedArray typedArrayObtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, AbstractC3072W4.f11396AZxh, 0, AbstractC2672Q4.f10148mjFkc) : context.obtainStyledAttributes(attributeSet, AbstractC3072W4.f11396AZxh, i, 0);
        if (i == 0) {
            saveAttributeDataForStyleable(context, AbstractC3072W4.f11396AZxh, attributeSet, typedArrayObtainStyledAttributes, 0, AbstractC2672Q4.f10148mjFkc);
        } else {
            saveAttributeDataForStyleable(context, AbstractC3072W4.f11396AZxh, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC3072W4.f11410wA, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f897Dt = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f897Dt.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f897Dt[i2] = (int) (r12[i2] * f);
            }
        }
        this.f908fehf = typedArrayObtainStyledAttributes.getDrawable(AbstractC3072W4.f11404ZfxDd);
        typedArrayObtainStyledAttributes.recycle();
        m481uHVRx();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0061ZfxDd());
        if (AbstractC2876T9.m10271eyqo(this) == 0) {
            AbstractC2876T9.m10244NKyg(this, 1);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$xJ */
    public static class C0065xJ extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0065xJ> f937CREATOR = new mjFkc();

        /* renamed from: wA */
        public SparseArray f938wA;

        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$xJ$mjFkc */
        public static class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0065xJ createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0065xJ(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0065xJ createFromParcel(Parcel parcel) {
                return new C0065xJ(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0065xJ[] newArray(int i) {
                return new C0065xJ[i];
            }
        }

        public C0065xJ(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f938wA = new SparseArray(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f938wA.append(iArr[i2], parcelableArray[i2]);
            }
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray sparseArray = this.f938wA;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f938wA.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f938wA.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public C0065xJ(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$KLFTb */
    public static class C0060KLFTb extends ViewGroup.MarginLayoutParams {

        /* renamed from: AZxh */
        public boolean f917AZxh;

        /* renamed from: Dt */
        public int f918Dt;

        /* renamed from: ETF */
        public View f919ETF;

        /* renamed from: IEE */
        public Object f920IEE;

        /* renamed from: JHa */
        public int f921JHa;

        /* renamed from: KLFTb */
        public int f922KLFTb;

        /* renamed from: MiMN */
        public boolean f923MiMN;

        /* renamed from: VA */
        public View f924VA;

        /* renamed from: YoKzxo */
        public boolean f925YoKzxo;

        /* renamed from: ZfxDd */
        public int f926ZfxDd;

        /* renamed from: fehf */
        public final Rect f927fehf;

        /* renamed from: lgHUyS */
        public int f928lgHUyS;

        /* renamed from: mjFkc */
        public AbstractC0058AZxh f929mjFkc;

        /* renamed from: qGY */
        public boolean f930qGY;

        /* renamed from: qdMbNW */
        public int f931qdMbNW;

        /* renamed from: rkYL */
        public boolean f932rkYL;

        /* renamed from: wA */
        public int f933wA;

        /* renamed from: xJ */
        public int f934xJ;

        public C0060KLFTb(int i, int i2) {
            super(i, i2);
            this.f917AZxh = false;
            this.f933wA = 0;
            this.f926ZfxDd = 0;
            this.f922KLFTb = -1;
            this.f921JHa = -1;
            this.f934xJ = 0;
            this.f928lgHUyS = 0;
            this.f927fehf = new Rect();
        }

        /* renamed from: AZxh */
        public boolean m515AZxh(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC0058AZxh abstractC0058AZxh;
            return view2 == this.f924VA || m518IEE(view2, AbstractC2876T9.m10276huTpC(coordinatorLayout)) || ((abstractC0058AZxh = this.f929mjFkc) != null && abstractC0058AZxh.mo493KLFTb(coordinatorLayout, view, view2));
        }

        /* renamed from: Dt */
        public void m516Dt() {
            this.f930qGY = false;
        }

        /* renamed from: ETF */
        public void m517ETF(int i) {
            m526fehf(i, false);
        }

        /* renamed from: IEE */
        public final boolean m518IEE(View view, int i) {
            int iM12647AZxh = AbstractC4056l.m12647AZxh(((C0060KLFTb) view.getLayoutParams()).f934xJ, i);
            return iM12647AZxh != 0 && (AbstractC4056l.m12647AZxh(this.f928lgHUyS, i) & iM12647AZxh) == iM12647AZxh;
        }

        /* renamed from: JHa */
        public boolean m519JHa() {
            return this.f930qGY;
        }

        /* renamed from: KLFTb */
        public AbstractC0058AZxh m520KLFTb() {
            return this.f929mjFkc;
        }

        /* renamed from: MiMN */
        public final void m521MiMN(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f921JHa);
            this.f919ETF = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f924VA = null;
                    this.f919ETF = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f921JHa) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f924VA = null;
                this.f919ETF = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f924VA = null;
                    this.f919ETF = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f924VA = viewFindViewById;
        }

        /* renamed from: Pq */
        public final boolean m522Pq(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f919ETF.getId() != this.f921JHa) {
                return false;
            }
            View view2 = this.f919ETF;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f924VA = null;
                    this.f919ETF = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f924VA = view2;
            return true;
        }

        /* renamed from: VA */
        public void m523VA() {
            this.f923MiMN = false;
        }

        /* renamed from: YoKzxo */
        public void m524YoKzxo(AbstractC0058AZxh abstractC0058AZxh) {
            AbstractC0058AZxh abstractC0058AZxh2 = this.f929mjFkc;
            if (abstractC0058AZxh2 != abstractC0058AZxh) {
                if (abstractC0058AZxh2 != null) {
                    abstractC0058AZxh2.mo487Dt();
                }
                this.f929mjFkc = abstractC0058AZxh;
                this.f920IEE = null;
                this.f917AZxh = true;
                if (abstractC0058AZxh != null) {
                    abstractC0058AZxh.mo514xJ(this);
                }
            }
        }

        /* renamed from: ZfxDd */
        public View m525ZfxDd(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f921JHa == -1) {
                this.f924VA = null;
                this.f919ETF = null;
                return null;
            }
            if (this.f919ETF == null || !m522Pq(view, coordinatorLayout)) {
                m521MiMN(view, coordinatorLayout);
            }
            return this.f919ETF;
        }

        /* renamed from: fehf */
        public void m526fehf(int i, boolean z) {
            if (i == 0) {
                this.f925YoKzxo = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.f932rkYL = z;
            }
        }

        /* renamed from: lgHUyS */
        public boolean m527lgHUyS(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f923MiMN;
            if (z) {
                return true;
            }
            AbstractC0058AZxh abstractC0058AZxh = this.f929mjFkc;
            boolean zM507mjFkc = (abstractC0058AZxh != null ? abstractC0058AZxh.m507mjFkc(coordinatorLayout, view) : false) | z;
            this.f923MiMN = zM507mjFkc;
            return zM507mjFkc;
        }

        /* renamed from: mjFkc */
        public boolean m528mjFkc() {
            return this.f919ETF == null && this.f921JHa != -1;
        }

        /* renamed from: qGY */
        public void m529qGY(Rect rect) {
            this.f927fehf.set(rect);
        }

        /* renamed from: qdMbNW */
        public boolean m530qdMbNW(int i) {
            if (i == 0) {
                return this.f925YoKzxo;
            }
            if (i != 1) {
                return false;
            }
            return this.f932rkYL;
        }

        /* renamed from: rkYL */
        public void m531rkYL(boolean z) {
            this.f930qGY = z;
        }

        /* renamed from: wA */
        public boolean m532wA() {
            if (this.f929mjFkc == null) {
                this.f923MiMN = false;
            }
            return this.f923MiMN;
        }

        /* renamed from: xJ */
        public Rect m533xJ() {
            return this.f927fehf;
        }

        public C0060KLFTb(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f917AZxh = false;
            this.f933wA = 0;
            this.f926ZfxDd = 0;
            this.f922KLFTb = -1;
            this.f921JHa = -1;
            this.f934xJ = 0;
            this.f928lgHUyS = 0;
            this.f927fehf = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3072W4.f11400KLFTb);
            this.f933wA = typedArrayObtainStyledAttributes.getInteger(AbstractC3072W4.f11399JHa, 0);
            this.f921JHa = typedArrayObtainStyledAttributes.getResourceId(AbstractC3072W4.f11411xJ, -1);
            this.f926ZfxDd = typedArrayObtainStyledAttributes.getInteger(AbstractC3072W4.f11405lgHUyS, 0);
            this.f922KLFTb = typedArrayObtainStyledAttributes.getInteger(AbstractC3072W4.f11402VA, -1);
            this.f934xJ = typedArrayObtainStyledAttributes.getInt(AbstractC3072W4.f11398ETF, 0);
            this.f928lgHUyS = typedArrayObtainStyledAttributes.getInt(AbstractC3072W4.f11397Dt, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(AbstractC3072W4.f11408qdMbNW);
            this.f917AZxh = zHasValue;
            if (zHasValue) {
                this.f929mjFkc = CoordinatorLayout.m449xrEuO(context, attributeSet, typedArrayObtainStyledAttributes.getString(AbstractC3072W4.f11408qdMbNW));
            }
            typedArrayObtainStyledAttributes.recycle();
            AbstractC0058AZxh abstractC0058AZxh = this.f929mjFkc;
            if (abstractC0058AZxh != null) {
                abstractC0058AZxh.mo514xJ(this);
            }
        }

        public C0060KLFTb(C0060KLFTb c0060KLFTb) {
            super((ViewGroup.MarginLayoutParams) c0060KLFTb);
            this.f917AZxh = false;
            this.f933wA = 0;
            this.f926ZfxDd = 0;
            this.f922KLFTb = -1;
            this.f921JHa = -1;
            this.f934xJ = 0;
            this.f928lgHUyS = 0;
            this.f927fehf = new Rect();
        }

        public C0060KLFTb(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f917AZxh = false;
            this.f933wA = 0;
            this.f926ZfxDd = 0;
            this.f922KLFTb = -1;
            this.f921JHa = -1;
            this.f934xJ = 0;
            this.f928lgHUyS = 0;
            this.f927fehf = new Rect();
        }

        public C0060KLFTb(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f917AZxh = false;
            this.f933wA = 0;
            this.f926ZfxDd = 0;
            this.f922KLFTb = -1;
            this.f921JHa = -1;
            this.f934xJ = 0;
            this.f928lgHUyS = 0;
            this.f927fehf = new Rect();
        }
    }
}
