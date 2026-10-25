package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.p007view.OnReceiveContentListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import p131o.C2454MiMN;
import p131o.C2514Na;
import p131o.C2971Ucbh;
import p131o.C3372ab;

/* renamed from: o.T9 */
/* loaded from: classes.dex */
public abstract class AbstractC2876T9 {

    /* renamed from: mjFkc */
    public static final int[] f10649mjFkc = {AbstractC4790w4.f17116AZxh, AbstractC4790w4.f17155wA, AbstractC4790w4.f17136YoKzxo, AbstractC4790w4.f17122HGpJ, AbstractC4790w4.f17117BAnRFn, AbstractC4790w4.f17144lB, AbstractC4790w4.f17156wJVbdd, AbstractC4790w4.f17146mByQ, AbstractC4790w4.f17130OjSQV, AbstractC4790w4.f17129Ne, AbstractC4790w4.f17137ZfxDd, AbstractC4790w4.f17125KLFTb, AbstractC4790w4.f17124JHa, AbstractC4790w4.f17157xJ, AbstractC4790w4.f17145lgHUyS, AbstractC4790w4.f17150qdMbNW, AbstractC4790w4.f17119Dt, AbstractC4790w4.f17120ETF, AbstractC4790w4.f17133VA, AbstractC4790w4.f17127MiMN, AbstractC4790w4.f17152rkYL, AbstractC4790w4.f17149qGY, AbstractC4790w4.f17142fehf, AbstractC4790w4.f17123IEE, AbstractC4790w4.f17131Pq, AbstractC4790w4.f17140diqgf, AbstractC4790w4.f17141eyqo, AbstractC4790w4.f17132Ucbh, AbstractC4790w4.f17143huTpC, AbstractC4790w4.f17121Gd, AbstractC4790w4.f17153vI, AbstractC4790w4.f17135VocHEe};

    /* renamed from: AZxh */
    public static final InterfaceC3537d3 f10648AZxh = new InterfaceC3537d3() { // from class: o.S9
        @Override // p131o.InterfaceC3537d3
        /* renamed from: mjFkc */
        public final C1901EcuP mo10138mjFkc(C1901EcuP c1901EcuP) {
            return AbstractC2876T9.m10284oCFDzJ(c1901EcuP);
        }
    };

    /* renamed from: wA */
    public static final KLFTb f10650wA = new KLFTb();

    /* renamed from: o.T9$AZxh */
    public class AZxh extends JHa {
        public AZxh(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
        public boolean mo10308xJ(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
        public CharSequence mo10307wA(View view) {
            return ETF.m10325AZxh(view);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
        public void mo10304ZfxDd(View view, CharSequence charSequence) {
            ETF.m10330lgHUyS(view, charSequence);
        }
    }

    /* renamed from: o.T9$Dt */
    public static class Dt {
        /* renamed from: AZxh */
        public static AutofillId m10309AZxh(View view) {
            return view.getAutofillId();
        }

        /* renamed from: Dt */
        public static boolean m10310Dt(View view) {
            return view.restoreDefaultFocus();
        }

        /* renamed from: ETF */
        public static void m10311ETF(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        /* renamed from: JHa */
        public static boolean m10312JHa(View view) {
            return view.isFocusedByDefault();
        }

        /* renamed from: KLFTb */
        public static boolean m10313KLFTb(View view) {
            return view.hasExplicitFocusable();
        }

        /* renamed from: MiMN */
        public static void m10314MiMN(View view, int i) {
            view.setImportantForAutofill(i);
        }

        /* renamed from: VA */
        public static void m10315VA(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        /* renamed from: YoKzxo */
        public static void m10316YoKzxo(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        /* renamed from: ZfxDd */
        public static int m10317ZfxDd(View view) {
            return view.getNextClusterForwardId();
        }

        /* renamed from: lgHUyS */
        public static boolean m10318lgHUyS(View view) {
            return view.isKeyboardNavigationCluster();
        }

        /* renamed from: mjFkc */
        public static void m10319mjFkc(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        /* renamed from: qGY */
        public static void m10320qGY(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }

        /* renamed from: qdMbNW */
        public static View m10321qdMbNW(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        /* renamed from: rkYL */
        public static void m10322rkYL(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        /* renamed from: wA */
        public static int m10323wA(View view) {
            return view.getImportantForAutofill();
        }

        /* renamed from: xJ */
        public static boolean m10324xJ(View view) {
            return view.isImportantForAutofill();
        }
    }

    /* renamed from: o.T9$ETF */
    public static class ETF {
        /* renamed from: AZxh */
        public static CharSequence m10325AZxh(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* renamed from: Dt */
        public static void m10326Dt(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }

        /* renamed from: JHa */
        public static <T> T m10327JHa(View view, int i) {
            return (T) view.requireViewById(i);
        }

        /* renamed from: KLFTb */
        public static void m10328KLFTb(View view, qGY qgy) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C3074W6 c3074w6 = (C3074W6) view.getTag(AbstractC4790w4.f17148oCFDzJ);
            if (c3074w6 == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c3074w6.m10817get(qgy)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: ZfxDd */
        public static boolean m10329ZfxDd(View view) {
            return view.isScreenReaderFocusable();
        }

        /* renamed from: lgHUyS */
        public static void m10330lgHUyS(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* renamed from: mjFkc */
        public static void m10331mjFkc(View view, final qGY qgy) {
            C3074W6 c3074w6 = (C3074W6) view.getTag(AbstractC4790w4.f17148oCFDzJ);
            if (c3074w6 == null) {
                c3074w6 = new C3074W6();
                view.setTag(AbstractC4790w4.f17148oCFDzJ, c3074w6);
            }
            Objects.requireNonNull(qgy);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(qgy) { // from class: o.U9
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            c3074w6.m10821put(qgy, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: qdMbNW */
        public static void m10332qdMbNW(View view, AbstractC3177XgAT abstractC3177XgAT) {
            view.setAutofillId(null);
        }

        /* renamed from: wA */
        public static boolean m10333wA(View view) {
            return view.isAccessibilityHeading();
        }

        /* renamed from: xJ */
        public static void m10334xJ(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }
    }

    /* renamed from: o.T9$JHa */
    public static abstract class JHa {

        /* renamed from: AZxh */
        public final Class f10651AZxh;

        /* renamed from: ZfxDd */
        public final int f10652ZfxDd;

        /* renamed from: mjFkc */
        public final int f10653mjFkc;

        /* renamed from: wA */
        public final int f10654wA;

        public JHa(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }

        /* renamed from: AZxh */
        public final boolean m10335AZxh() {
            return Build.VERSION.SDK_INT >= this.f10654wA;
        }

        /* renamed from: JHa */
        public void m10336JHa(View view, Object obj) {
            if (m10335AZxh()) {
                mo10304ZfxDd(view, obj);
            } else if (mo10308xJ(m10337KLFTb(view), obj)) {
                AbstractC2876T9.m10297xJ(view);
                view.setTag(this.f10653mjFkc, obj);
                AbstractC2876T9.m10266aqHPIZ(view, this.f10652ZfxDd);
            }
        }

        /* renamed from: KLFTb */
        public Object m10337KLFTb(View view) {
            if (m10335AZxh()) {
                return mo10307wA(view);
            }
            Object tag = view.getTag(this.f10653mjFkc);
            if (this.f10651AZxh.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* renamed from: ZfxDd */
        public abstract void mo10304ZfxDd(View view, Object obj);

        /* renamed from: mjFkc */
        public boolean m10338mjFkc(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        /* renamed from: wA */
        public abstract Object mo10307wA(View view);

        /* renamed from: xJ */
        public abstract boolean mo10308xJ(Object obj, Object obj2);

        public JHa(int i, Class cls, int i2, int i3) {
            this.f10653mjFkc = i;
            this.f10651AZxh = cls;
            this.f10652ZfxDd = i2;
            this.f10654wA = i3;
        }
    }

    /* renamed from: o.T9$KLFTb */
    public static class KLFTb implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: mjFkc */
        public final WeakHashMap f10655mjFkc = new WeakHashMap();

        /* renamed from: AZxh */
        public final void m10339AZxh(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        /* renamed from: ZfxDd */
        public final void m10340ZfxDd(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        /* renamed from: mjFkc */
        public void m10341mjFkc(View view) {
            this.f10655mjFkc.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                m10339AZxh(view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m10339AZxh(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        /* renamed from: wA */
        public void m10342wA(View view) {
            this.f10655mjFkc.remove(view);
            view.removeOnAttachStateChangeListener(this);
            m10340ZfxDd(view);
        }
    }

    /* renamed from: o.T9$MiMN */
    public static class MiMN {
        /* renamed from: AZxh */
        public static CharSequence m10343AZxh(View view) {
            return view.getStateDescription();
        }

        /* renamed from: KLFTb */
        public static void m10344KLFTb(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        /* renamed from: ZfxDd */
        public static void m10345ZfxDd(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        /* renamed from: mjFkc */
        public static int m10346mjFkc(View view) {
            return view.getImportantForContentCapture();
        }

        /* renamed from: wA */
        public static boolean m10347wA(View view) {
            return view.isImportantForContentCapture();
        }
    }

    /* renamed from: o.T9$VA */
    public static class VA {
        /* renamed from: AZxh */
        public static ContentCaptureSession m10348AZxh(View view) {
            return view.getContentCaptureSession();
        }

        /* renamed from: JHa */
        public static void m10349JHa(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }

        /* renamed from: KLFTb */
        public static void m10350KLFTb(View view, AbstractC4556sZ abstractC4556sZ) {
            view.setContentCaptureSession(null);
        }

        /* renamed from: ZfxDd */
        public static void m10351ZfxDd(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        /* renamed from: mjFkc */
        public static View.AccessibilityDelegate m10352mjFkc(View view) {
            return view.getAccessibilityDelegate();
        }

        /* renamed from: wA */
        public static List<Rect> m10353wA(View view) {
            return view.getSystemGestureExclusionRects();
        }
    }

    /* renamed from: o.T9$YoKzxo */
    public static final class YoKzxo {
        /* renamed from: AZxh */
        public static C1901EcuP m10354AZxh(View view, C1901EcuP c1901EcuP) {
            ContentInfo contentInfoM8152JHa = c1901EcuP.m8152JHa();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM8152JHa);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoM8152JHa ? c1901EcuP : C1901EcuP.m8150xJ(contentInfoPerformReceiveContent);
        }

        /* renamed from: mjFkc */
        public static String[] m10355mjFkc(View view) {
            return view.getReceiveContentMimeTypes();
        }

        /* renamed from: wA */
        public static void m10356wA(View view, String[] strArr, InterfaceC3472c3 interfaceC3472c3) {
            if (interfaceC3472c3 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new rkYL(interfaceC3472c3));
            }
        }
    }

    /* renamed from: o.T9$ZfxDd */
    public class ZfxDd extends JHa {
        public ZfxDd(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
        public boolean mo10308xJ(Boolean bool, Boolean bool2) {
            return !m10338mjFkc(bool, bool2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
        public Boolean mo10307wA(View view) {
            return Boolean.valueOf(ETF.m10333wA(view));
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
        public void mo10304ZfxDd(View view, Boolean bool) {
            ETF.m10334xJ(view, bool.booleanValue());
        }
    }

    /* renamed from: o.T9$lgHUyS */
    public static class lgHUyS {

        /* renamed from: o.T9$lgHUyS$mjFkc */
        public class mjFkc implements View.OnApplyWindowInsetsListener {

            /* renamed from: AZxh */
            public final /* synthetic */ View f10656AZxh;

            /* renamed from: mjFkc */
            public C3372ab f10657mjFkc = null;

            /* renamed from: wA */
            public final /* synthetic */ InterfaceC3134X2 f10658wA;

            public mjFkc(View view, InterfaceC3134X2 interfaceC3134X2) {
                this.f10656AZxh = view;
                this.f10658wA = interfaceC3134X2;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C3372ab c3372abM11331diqgf = C3372ab.m11331diqgf(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    lgHUyS.m10379mjFkc(windowInsets, this.f10656AZxh);
                    if (c3372abM11331diqgf.m11341equals(this.f10657mjFkc)) {
                        return this.f10658wA.mo535mjFkc(view, c3372abM11331diqgf).m11335IEE();
                    }
                }
                this.f10657mjFkc = c3372abM11331diqgf;
                C3372ab c3372abMo535mjFkc = this.f10658wA.mo535mjFkc(view, c3372abM11331diqgf);
                if (i >= 30) {
                    return c3372abMo535mjFkc.m11335IEE();
                }
                AbstractC2876T9.m10255Vdz(view);
                return c3372abMo535mjFkc.m11335IEE();
            }
        }

        /* renamed from: AZxh */
        public static C3372ab m10360AZxh(View view, C3372ab c3372ab, Rect rect) {
            WindowInsets windowInsetsM11335IEE = c3372ab.m11335IEE();
            if (windowInsetsM11335IEE != null) {
                return C3372ab.m11331diqgf(view.computeSystemWindowInsets(windowInsetsM11335IEE, rect), view);
            }
            rect.setEmpty();
            return c3372ab;
        }

        /* renamed from: Dt */
        public static C3372ab m10361Dt(View view) {
            return C3372ab.mjFkc.m11391mjFkc(view);
        }

        /* renamed from: ETF */
        public static String m10362ETF(View view) {
            return view.getTransitionName();
        }

        /* renamed from: Gd */
        public static void m10363Gd(View view, float f) {
            view.setZ(f);
        }

        /* renamed from: HGpJ */
        public static boolean m10364HGpJ(View view, int i) {
            return view.startNestedScroll(i);
        }

        /* renamed from: IEE */
        public static void m10365IEE(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        /* renamed from: JHa */
        public static boolean m10366JHa(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        /* renamed from: KLFTb */
        public static boolean m10367KLFTb(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        /* renamed from: MiMN */
        public static float m10368MiMN(View view) {
            return view.getZ();
        }

        /* renamed from: Pq */
        public static void m10369Pq(View view, float f) {
            view.setElevation(f);
        }

        /* renamed from: Ucbh */
        public static void m10370Ucbh(View view, String str) {
            view.setTransitionName(str);
        }

        /* renamed from: VA */
        public static float m10371VA(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: YoKzxo */
        public static boolean m10372YoKzxo(View view) {
            return view.hasNestedScrollingParent();
        }

        /* renamed from: ZfxDd */
        public static boolean m10373ZfxDd(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        /* renamed from: diqgf */
        public static void m10374diqgf(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        /* renamed from: eyqo */
        public static void m10375eyqo(View view, InterfaceC3134X2 interfaceC3134X2) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(AbstractC4790w4.f17139cMLeY, interfaceC3134X2);
            }
            if (interfaceC3134X2 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(AbstractC4790w4.f17138aqHPIZ));
            } else {
                view.setOnApplyWindowInsetsListener(new mjFkc(view, interfaceC3134X2));
            }
        }

        /* renamed from: fehf */
        public static void m10376fehf(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        /* renamed from: huTpC */
        public static void m10377huTpC(View view, float f) {
            view.setTranslationZ(f);
        }

        /* renamed from: lgHUyS */
        public static PorterDuff.Mode m10378lgHUyS(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: mjFkc */
        public static void m10379mjFkc(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(AbstractC4790w4.f17138aqHPIZ);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        /* renamed from: qGY */
        public static boolean m10380qGY(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: qdMbNW */
        public static float m10381qdMbNW(View view) {
            return view.getElevation();
        }

        /* renamed from: rkYL */
        public static boolean m10382rkYL(View view) {
            return view.isImportantForAccessibility();
        }

        /* renamed from: vI */
        public static void m10383vI(View view) {
            view.stopNestedScroll();
        }

        /* renamed from: wA */
        public static boolean m10384wA(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        /* renamed from: xJ */
        public static ColorStateList m10385xJ(View view) {
            return view.getBackgroundTintList();
        }
    }

    /* renamed from: o.T9$mjFkc */
    public class mjFkc extends JHa {
        public mjFkc(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
        public boolean mo10308xJ(Boolean bool, Boolean bool2) {
            return !m10338mjFkc(bool, bool2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
        public Boolean mo10307wA(View view) {
            return Boolean.valueOf(ETF.m10329ZfxDd(view));
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
        public void mo10304ZfxDd(View view, Boolean bool) {
            ETF.m10326Dt(view, bool.booleanValue());
        }
    }

    /* renamed from: o.T9$qGY */
    public interface qGY {
    }

    /* renamed from: o.T9$qdMbNW */
    public static class qdMbNW {
        /* renamed from: AZxh */
        public static int m10389AZxh(View view) {
            return view.getScrollIndicators();
        }

        /* renamed from: ZfxDd */
        public static void m10390ZfxDd(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        /* renamed from: mjFkc */
        public static C3372ab m10391mjFkc(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C3372ab c3372abM11330Pq = C3372ab.m11330Pq(rootWindowInsets);
            c3372abM11330Pq.m11342fehf(c3372abM11330Pq);
            c3372abM11330Pq.m11340ZfxDd(view.getRootView());
            return c3372abM11330Pq;
        }

        /* renamed from: wA */
        public static void m10392wA(View view, int i) {
            view.setScrollIndicators(i);
        }
    }

    /* renamed from: o.T9$rkYL */
    public static final class rkYL implements OnReceiveContentListener {

        /* renamed from: mjFkc */
        public final InterfaceC3472c3 f10659mjFkc;

        public rkYL(InterfaceC3472c3 interfaceC3472c3) {
            this.f10659mjFkc = interfaceC3472c3;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C1901EcuP c1901EcuPM8150xJ = C1901EcuP.m8150xJ(contentInfo);
            C1901EcuP c1901EcuPMo11599mjFkc = this.f10659mjFkc.mo11599mjFkc(view, c1901EcuPM8150xJ);
            if (c1901EcuPMo11599mjFkc == null) {
                return null;
            }
            return c1901EcuPMo11599mjFkc == c1901EcuPM8150xJ ? contentInfo : c1901EcuPMo11599mjFkc.m8152JHa();
        }
    }

    /* renamed from: o.T9$wA */
    public class wA extends JHa {
        public wA(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
        public boolean mo10308xJ(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
        public CharSequence mo10307wA(View view) {
            return MiMN.m10343AZxh(view);
        }

        @Override // p131o.AbstractC2876T9.JHa
        /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
        public void mo10304ZfxDd(View view, CharSequence charSequence) {
            MiMN.m10344KLFTb(view, charSequence);
        }
    }

    /* renamed from: o.T9$xJ */
    public static class xJ {
        /* renamed from: AZxh */
        public static WindowInsets m10396AZxh(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        /* renamed from: mjFkc */
        public static WindowInsets m10397mjFkc(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        /* renamed from: wA */
        public static void m10398wA(View view) {
            view.requestApplyInsets();
        }
    }

    /* renamed from: ANMGZc */
    public static JHa m10222ANMGZc() {
        return new mjFkc(AbstractC4790w4.f17128NPj, Boolean.class, 28);
    }

    /* renamed from: AZxh */
    public static JHa m10223AZxh() {
        return new ZfxDd(AbstractC4790w4.f17126KLMXS, Boolean.class, 28);
    }

    /* renamed from: BAnRFn */
    public static int m10224BAnRFn(View view) {
        return view.getPaddingStart();
    }

    /* renamed from: CqaNbM */
    public static boolean m10225CqaNbM(View view) {
        return view.hasOnClickListeners();
    }

    /* renamed from: Dt */
    public static View.AccessibilityDelegate m10226Dt(View view) {
        return VA.m10352mjFkc(view);
    }

    /* renamed from: ETF */
    public static CharSequence m10227ETF(View view) {
        return (CharSequence) m10236JYn().m10337KLFTb(view);
    }

    /* renamed from: GMIER */
    public static C3372ab m10228GMIER(View view, C3372ab c3372ab) {
        WindowInsets windowInsetsM11335IEE = c3372ab.m11335IEE();
        if (windowInsetsM11335IEE != null) {
            WindowInsets windowInsetsM10396AZxh = xJ.m10396AZxh(view, windowInsetsM11335IEE);
            if (!windowInsetsM10396AZxh.equals(windowInsetsM11335IEE)) {
                return C3372ab.m11331diqgf(windowInsetsM10396AZxh, view);
            }
        }
        return c3372ab;
    }

    /* renamed from: Gd */
    public static int m10229Gd(View view) {
        return view.getMinimumHeight();
    }

    /* renamed from: HGpJ */
    public static int m10230HGpJ(View view) {
        return view.getMinimumWidth();
    }

    /* renamed from: IEE */
    public static float m10231IEE(View view) {
        return lgHUyS.m10381qdMbNW(view);
    }

    /* renamed from: IVlxe */
    public static void m10232IVlxe(View view, PorterDuff.Mode mode) {
        lgHUyS.m10365IEE(view, mode);
    }

    /* renamed from: JBhc */
    public static void m10233JBhc(View view, C2971Ucbh.mjFkc mjfkc, CharSequence charSequence, InterfaceC2087HGpJ interfaceC2087HGpJ) {
        if (interfaceC2087HGpJ == null && charSequence == null) {
            m10267bbzow(view, mjfkc.m10624AZxh());
        } else {
            m10264ZfxDd(view, mjfkc.m10627mjFkc(charSequence, interfaceC2087HGpJ));
        }
    }

    /* renamed from: JHa */
    public static C3372ab m10234JHa(View view, C3372ab c3372ab) {
        WindowInsets windowInsetsM11335IEE = c3372ab.m11335IEE();
        if (windowInsetsM11335IEE != null) {
            WindowInsets windowInsetsM10397mjFkc = xJ.m10397mjFkc(view, windowInsetsM11335IEE);
            if (!windowInsetsM10397mjFkc.equals(windowInsetsM11335IEE)) {
                return C3372ab.m11331diqgf(windowInsetsM10397mjFkc, view);
            }
        }
        return c3372ab;
    }

    /* renamed from: JYgkl */
    public static boolean m10235JYgkl(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    /* renamed from: JYn */
    public static JHa m10236JYn() {
        return new AZxh(AbstractC4790w4.f17159zvd, CharSequence.class, 8, 28);
    }

    /* renamed from: JrJO */
    public static C1901EcuP m10237JrJO(View view, C1901EcuP c1901EcuP) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c1901EcuP + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return YoKzxo.m10354AZxh(view, c1901EcuP);
        }
        InterfaceC3472c3 interfaceC3472c3 = (InterfaceC3472c3) view.getTag(AbstractC4790w4.f17151rWxwaT);
        if (interfaceC3472c3 == null) {
            return m10248Pq(view).mo10138mjFkc(c1901EcuP);
        }
        C1901EcuP c1901EcuPMo11599mjFkc = interfaceC3472c3.mo11599mjFkc(view, c1901EcuP);
        if (c1901EcuPMo11599mjFkc == null) {
            return null;
        }
        return m10248Pq(view).mo10138mjFkc(c1901EcuPMo11599mjFkc);
    }

    /* renamed from: KLFTb */
    public static C3372ab m10238KLFTb(View view, C3372ab c3372ab, Rect rect) {
        return lgHUyS.m10360AZxh(view, c3372ab, rect);
    }

    /* renamed from: KLMXS */
    public static boolean m10239KLMXS(View view) {
        return view.hasTransientState();
    }

    /* renamed from: KRTLGT */
    public static void m10240KRTLGT(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    /* renamed from: LREOK */
    public static void m10241LREOK(View view, String str) {
        lgHUyS.m10370Ucbh(view, str);
    }

    /* renamed from: MiMN */
    public static int m10242MiMN(View view, CharSequence charSequence) {
        List listM10254VA = m10254VA(view);
        for (int i = 0; i < listM10254VA.size(); i++) {
            if (TextUtils.equals(charSequence, ((C2971Ucbh.mjFkc) listM10254VA.get(i)).m10628wA())) {
                return ((C2971Ucbh.mjFkc) listM10254VA.get(i)).m10624AZxh();
            }
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[] iArr = f10649mjFkc;
            if (i3 >= iArr.length || i2 != -1) {
                break;
            }
            int i4 = iArr[i3];
            boolean z = true;
            for (int i5 = 0; i5 < listM10254VA.size(); i5++) {
                z &= ((C2971Ucbh.mjFkc) listM10254VA.get(i5)).m10624AZxh() != i4;
            }
            if (z) {
                i2 = i4;
            }
            i3++;
        }
        return i2;
    }

    /* renamed from: Moer */
    public static void m10243Moer(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    /* renamed from: NKyg */
    public static void m10244NKyg(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    /* renamed from: NPj */
    public static boolean m10245NPj(View view) {
        return view.isPaddingRelative();
    }

    /* renamed from: Ne */
    public static float m10246Ne(View view) {
        return lgHUyS.m10368MiMN(view);
    }

    /* renamed from: OjSQV */
    public static int m10247OjSQV(View view) {
        return view.getWindowSystemUiVisibility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Pq */
    public static InterfaceC3537d3 m10248Pq(View view) {
        return view instanceof InterfaceC3537d3 ? (InterfaceC3537d3) view : f10648AZxh;
    }

    /* renamed from: Qr */
    public static void m10249Qr(View view, boolean z) {
        view.setHasTransientState(z);
    }

    /* renamed from: SOS */
    public static void m10250SOS(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: SmIWf */
    public static void m10251SmIWf(View view, float f) {
        lgHUyS.m10369Pq(view, f);
    }

    /* renamed from: SwgkN */
    public static void m10252SwgkN(int i, View view) {
        List listM10254VA = m10254VA(view);
        for (int i2 = 0; i2 < listM10254VA.size(); i2++) {
            if (((C2971Ucbh.mjFkc) listM10254VA.get(i2)).m10624AZxh() == i) {
                listM10254VA.remove(i2);
                return;
            }
        }
    }

    /* renamed from: Ucbh */
    public static int m10253Ucbh(View view) {
        return Dt.m10323wA(view);
    }

    /* renamed from: VA */
    public static List m10254VA(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(AbstractC4790w4.f17118CqaNbM);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(AbstractC4790w4.f17118CqaNbM, arrayList2);
        return arrayList2;
    }

    /* renamed from: Vdz */
    public static void m10255Vdz(View view) {
        xJ.m10398wA(view);
    }

    /* renamed from: Vnb */
    public static boolean m10256Vnb(View view) {
        return lgHUyS.m10380qGY(view);
    }

    /* renamed from: VocHEe */
    public static int m10257VocHEe(View view) {
        return view.getPaddingEnd();
    }

    /* renamed from: WGXroI */
    public static void m10258WGXroI(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* renamed from: WrLQs */
    public static void m10259WrLQs(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    /* renamed from: XFUzSY */
    public static void m10260XFUzSY(View view) {
        lgHUyS.m10383vI(view);
    }

    /* renamed from: XV */
    public static void m10261XV(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    /* renamed from: XbiWeM */
    public static JHa m10262XbiWeM() {
        return new wA(AbstractC4790w4.f17154vadzgd, CharSequence.class, 64, 30);
    }

    /* renamed from: YoKzxo */
    public static ColorStateList m10263YoKzxo(View view) {
        return lgHUyS.m10385xJ(view);
    }

    /* renamed from: ZfxDd */
    public static void m10264ZfxDd(View view, C2971Ucbh.mjFkc mjfkc) {
        m10297xJ(view);
        m10252SwgkN(mjfkc.m10624AZxh(), view);
        m10254VA(view).add(mjfkc);
        m10266aqHPIZ(view, 0);
    }

    /* renamed from: alEkx */
    public static void m10265alEkx(View view, C2454MiMN c2454MiMN) {
        if (c2454MiMN == null && (m10226Dt(view) instanceof C2454MiMN.mjFkc)) {
            c2454MiMN = new C2454MiMN();
        }
        m10275gtIJp(view);
        view.setAccessibilityDelegate(c2454MiMN == null ? null : c2454MiMN.m9528ZfxDd());
    }

    /* renamed from: aqHPIZ */
    public static void m10266aqHPIZ(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m10227ETF(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(m10227ETF(view));
                    m10275gtIJp(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m10227ETF(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    /* renamed from: bbzow */
    public static void m10267bbzow(View view, int i) {
        m10252SwgkN(i, view);
        m10266aqHPIZ(view, 0);
    }

    /* renamed from: cMLeY */
    public static boolean m10268cMLeY(View view) {
        return view.isAttachedToWindow();
    }

    /* renamed from: diqgf */
    public static boolean m10269diqgf(View view) {
        return view.getFitsSystemWindows();
    }

    /* renamed from: dm */
    public static void m10270dm(View view, boolean z) {
        m10223AZxh().m10336JHa(view, Boolean.valueOf(z));
    }

    /* renamed from: eyqo */
    public static int m10271eyqo(View view) {
        return view.getImportantForAccessibility();
    }

    /* renamed from: fFz */
    public static void m10272fFz(View view, C2514Na.AZxh aZxh) {
        C2514Na.m9692ZfxDd(view, aZxh);
    }

    /* renamed from: fehf */
    public static Display m10273fehf(View view) {
        return view.getDisplay();
    }

    /* renamed from: gYa */
    public static void m10274gYa(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    /* renamed from: gtIJp */
    public static void m10275gtIJp(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    /* renamed from: huTpC */
    public static int m10276huTpC(View view) {
        return view.getLayoutDirection();
    }

    /* renamed from: jm */
    public static void m10277jm(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        VA.m10351ZfxDd(view, context, iArr, attributeSet, typedArray, i, i2);
    }

    /* renamed from: kism */
    public static void m10278kism(View view, int i) {
        Dt.m10314MiMN(view, i);
    }

    /* renamed from: lB */
    public static C3372ab m10279lB(View view) {
        return qdMbNW.m10391mjFkc(view);
    }

    /* renamed from: lgHUyS */
    public static int m10280lgHUyS() {
        return View.generateViewId();
    }

    /* renamed from: mByQ */
    public static String m10281mByQ(View view) {
        return lgHUyS.m10362ETF(view);
    }

    /* renamed from: nxI */
    public static void m10283nxI(View view) {
        view.postInvalidateOnAnimation();
    }

    /* renamed from: oCFDzJ */
    public static /* synthetic */ C1901EcuP m10284oCFDzJ(C1901EcuP c1901EcuP) {
        return c1901EcuP;
    }

    /* renamed from: qGY */
    public static Rect m10285qGY(View view) {
        return view.getClipBounds();
    }

    /* renamed from: qdMbNW */
    public static C2454MiMN m10286qdMbNW(View view) {
        View.AccessibilityDelegate accessibilityDelegateM10226Dt = m10226Dt(view);
        if (accessibilityDelegateM10226Dt == null) {
            return null;
        }
        return accessibilityDelegateM10226Dt instanceof C2454MiMN.mjFkc ? ((C2454MiMN.mjFkc) accessibilityDelegateM10226Dt).f9597mjFkc : new C2454MiMN(accessibilityDelegateM10226Dt);
    }

    /* renamed from: rWxwaT */
    public static boolean m10287rWxwaT(View view) {
        return view.isLaidOut();
    }

    /* renamed from: rkYL */
    public static PorterDuff.Mode m10288rkYL(View view) {
        return lgHUyS.m10378lgHUyS(view);
    }

    /* renamed from: tQ */
    public static void m10289tQ(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    /* renamed from: tjSezt */
    public static void m10290tjSezt(View view, int i) {
        view.setLabelFor(i);
    }

    /* renamed from: uHVRx */
    public static void m10291uHVRx(View view, C2971Ucbh c2971Ucbh) {
        view.onInitializeAccessibilityNodeInfo(c2971Ucbh.m10565XFUzSY());
    }

    /* renamed from: vI */
    public static String[] m10292vI(View view) {
        return Build.VERSION.SDK_INT >= 31 ? YoKzxo.m10355mjFkc(view) : (String[]) view.getTag(AbstractC4790w4.f17134Vnb);
    }

    /* renamed from: vadzgd */
    public static boolean m10293vadzgd(View view) {
        Boolean bool = (Boolean) m10222ANMGZc().m10337KLFTb(view);
        return bool != null && bool.booleanValue();
    }

    /* renamed from: vjlshU */
    public static void m10294vjlshU(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* renamed from: wA */
    public static int m10295wA(View view, CharSequence charSequence, InterfaceC2087HGpJ interfaceC2087HGpJ) {
        int iM10242MiMN = m10242MiMN(view, charSequence);
        if (iM10242MiMN != -1) {
            m10264ZfxDd(view, new C2971Ucbh.mjFkc(iM10242MiMN, charSequence, interfaceC2087HGpJ));
        }
        return iM10242MiMN;
    }

    /* renamed from: wJVbdd */
    public static CharSequence m10296wJVbdd(View view) {
        return (CharSequence) m10262XbiWeM().m10337KLFTb(view);
    }

    /* renamed from: xJ */
    public static void m10297xJ(View view) {
        C2454MiMN c2454MiMNM10286qdMbNW = m10286qdMbNW(view);
        if (c2454MiMNM10286qdMbNW == null) {
            c2454MiMNM10286qdMbNW = new C2454MiMN();
        }
        m10265alEkx(view, c2454MiMNM10286qdMbNW);
    }

    /* renamed from: xROA */
    public static void m10298xROA(View view, ColorStateList colorStateList) {
        lgHUyS.m10376fehf(view, colorStateList);
    }

    /* renamed from: xrEuO */
    public static boolean m10299xrEuO(View view) {
        return view.hasOverlappingRendering();
    }

    /* renamed from: yX */
    public static void m10300yX(View view, InterfaceC3134X2 interfaceC3134X2) {
        lgHUyS.m10375eyqo(view, interfaceC3134X2);
    }

    /* renamed from: yfx */
    public static void m10301yfx(View view, CharSequence charSequence) {
        m10236JYn().m10336JHa(view, charSequence);
        if (charSequence != null) {
            f10650wA.m10341mjFkc(view);
        } else {
            f10650wA.m10342wA(view);
        }
    }

    /* renamed from: zvd */
    public static boolean m10302zvd(View view) {
        Boolean bool = (Boolean) m10223AZxh().m10337KLFTb(view);
        return bool != null && bool.booleanValue();
    }
}
