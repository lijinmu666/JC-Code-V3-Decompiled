package p131o;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.AbstractC1701BWWRl;

/* renamed from: o.EqDGZ */
/* loaded from: classes.dex */
public abstract class AbstractC1919EqDGZ extends C2454MiMN {

    /* renamed from: Dt */
    public wA f8063Dt;

    /* renamed from: lgHUyS */
    public final AccessibilityManager f8070lgHUyS;

    /* renamed from: qdMbNW */
    public final View f8071qdMbNW;

    /* renamed from: YoKzxo */
    public static final Rect f8060YoKzxo = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: rkYL */
    public static final AbstractC1701BWWRl.mjFkc f8062rkYL = new mjFkc();

    /* renamed from: qGY */
    public static final AbstractC1701BWWRl.AZxh f8061qGY = new AZxh();

    /* renamed from: ZfxDd */
    public final Rect f8069ZfxDd = new Rect();

    /* renamed from: KLFTb */
    public final Rect f8066KLFTb = new Rect();

    /* renamed from: JHa */
    public final Rect f8065JHa = new Rect();

    /* renamed from: xJ */
    public final int[] f8072xJ = new int[2];

    /* renamed from: ETF */
    public int f8064ETF = Integer.MIN_VALUE;

    /* renamed from: VA */
    public int f8068VA = Integer.MIN_VALUE;

    /* renamed from: MiMN */
    public int f8067MiMN = Integer.MIN_VALUE;

    /* renamed from: o.EqDGZ$AZxh */
    public class AZxh implements AbstractC1701BWWRl.AZxh {
        @Override // p131o.AbstractC1701BWWRl.AZxh
        /* renamed from: ZfxDd, reason: merged with bridge method [inline-methods] */
        public int mo7715AZxh(C3605e7 c3605e7) {
            return c3605e7.m11810VA();
        }

        @Override // p131o.AbstractC1701BWWRl.AZxh
        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public C2971Ucbh mo7716mjFkc(C3605e7 c3605e7, int i) {
            return (C2971Ucbh) c3605e7.m11809MiMN(i);
        }
    }

    /* renamed from: o.EqDGZ$mjFkc */
    public class mjFkc implements AbstractC1701BWWRl.mjFkc {
        @Override // p131o.AbstractC1701BWWRl.mjFkc
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo7717mjFkc(C2971Ucbh c2971Ucbh, Rect rect) {
            c2971Ucbh.m10534Dt(rect);
        }
    }

    /* renamed from: o.EqDGZ$wA */
    public class wA extends C3850huTpC {
        public wA() {
        }

        @Override // p131o.C3850huTpC
        /* renamed from: AZxh */
        public C2971Ucbh mo8221AZxh(int i) {
            return C2971Ucbh.m10523GMIER(AbstractC1919EqDGZ.this.m8191CqaNbM(i));
        }

        @Override // p131o.C3850huTpC
        /* renamed from: JHa */
        public boolean mo8222JHa(int i, int i2, Bundle bundle) {
            return AbstractC1919EqDGZ.this.m8215vadzgd(i, i2, bundle);
        }

        @Override // p131o.C3850huTpC
        /* renamed from: ZfxDd */
        public C2971Ucbh mo8223ZfxDd(int i) {
            int i2 = i == 2 ? AbstractC1919EqDGZ.this.f8064ETF : AbstractC1919EqDGZ.this.f8068VA;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return mo8221AZxh(i2);
        }
    }

    public AbstractC1919EqDGZ(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f8071qdMbNW = view;
        this.f8070lgHUyS = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (AbstractC2876T9.m10271eyqo(view) == 0) {
            AbstractC2876T9.m10244NKyg(view, 1);
        }
    }

    /* renamed from: OjSQV */
    public static int m8189OjSQV(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    /* renamed from: wJVbdd */
    public static Rect m8190wJVbdd(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    @Override // p131o.C2454MiMN
    /* renamed from: AZxh */
    public C3850huTpC mo1220AZxh(View view) {
        if (this.f8063Dt == null) {
            this.f8063Dt = new wA();
        }
        return this.f8063Dt;
    }

    /* renamed from: BAnRFn */
    public abstract int mo2740BAnRFn(float f, float f2);

    /* renamed from: CqaNbM */
    public C2971Ucbh m8191CqaNbM(int i) {
        return i == -1 ? m8206eyqo() : m8205diqgf(i);
    }

    /* renamed from: GMIER */
    public final boolean m8192GMIER(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f8070lgHUyS.isEnabled() || (parent = this.f8071qdMbNW.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f8071qdMbNW, m8207fehf(i, i2));
    }

    /* renamed from: Gd */
    public final int m8193Gd() {
        return this.f8064ETF;
    }

    /* renamed from: HGpJ */
    public final C3605e7 m8194HGpJ() {
        ArrayList arrayList = new ArrayList();
        mo2744lB(arrayList);
        C3605e7 c3605e7 = new C3605e7();
        for (int i = 0; i < arrayList.size(); i++) {
            c3605e7.m11806ETF(((Integer) arrayList.get(i)).intValue(), m8205diqgf(((Integer) arrayList.get(i)).intValue()));
        }
        return c3605e7;
    }

    /* renamed from: IEE */
    public final AccessibilityEvent m8195IEE(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        C2971Ucbh c2971UcbhM8191CqaNbM = m8191CqaNbM(i);
        accessibilityEventObtain.getText().add(c2971UcbhM8191CqaNbM.m10582huTpC());
        accessibilityEventObtain.setContentDescription(c2971UcbhM8191CqaNbM.m10579fehf());
        accessibilityEventObtain.setScrollable(c2971UcbhM8191CqaNbM.m10562Vnb());
        accessibilityEventObtain.setPassword(c2971UcbhM8191CqaNbM.m10593rWxwaT());
        accessibilityEventObtain.setEnabled(c2971UcbhM8191CqaNbM.m10552Ne());
        accessibilityEventObtain.setChecked(c2971UcbhM8191CqaNbM.m10601wJVbdd());
        m8204cMLeY(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(c2971UcbhM8191CqaNbM.m10568YoKzxo());
        AbstractC2042Gd.m8448wA(accessibilityEventObtain, this.f8071qdMbNW, i);
        accessibilityEventObtain.setPackageName(this.f8071qdMbNW.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    @Override // p131o.C2454MiMN
    /* renamed from: JHa */
    public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
        super.mo619JHa(view, accessibilityEvent);
        m8217zvd(accessibilityEvent);
    }

    /* renamed from: KLMXS */
    public abstract boolean mo2741KLMXS(int i, int i2, Bundle bundle);

    /* renamed from: KRTLGT */
    public final boolean m8196KRTLGT(int i) {
        int i2;
        if ((!this.f8071qdMbNW.isFocused() && !this.f8071qdMbNW.requestFocus()) || (i2 = this.f8068VA) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            m8212rkYL(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.f8068VA = i;
        mo2742NPj(i, true);
        m8192GMIER(i, 8);
        return true;
    }

    /* renamed from: NPj */
    public abstract void mo2742NPj(int i, boolean z);

    /* renamed from: Ne */
    public final boolean m8197Ne(int i, Rect rect) {
        C2971Ucbh c2971Ucbh;
        C3605e7 c3605e7M8194HGpJ = m8194HGpJ();
        int i2 = this.f8068VA;
        C2971Ucbh c2971Ucbh2 = i2 == Integer.MIN_VALUE ? null : (C2971Ucbh) c3605e7M8194HGpJ.m11807JHa(i2);
        if (i == 1 || i == 2) {
            c2971Ucbh = (C2971Ucbh) AbstractC1701BWWRl.m7708ZfxDd(c3605e7M8194HGpJ, f8061qGY, f8062rkYL, c2971Ucbh2, i, AbstractC2876T9.m10276huTpC(this.f8071qdMbNW) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.f8068VA;
            if (i3 != Integer.MIN_VALUE) {
                m8214vI(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                m8190wJVbdd(this.f8071qdMbNW, i, rect2);
            }
            c2971Ucbh = (C2971Ucbh) AbstractC1701BWWRl.m7713wA(c3605e7M8194HGpJ, f8061qGY, f8062rkYL, c2971Ucbh2, rect2, i);
        }
        return m8196KRTLGT(c2971Ucbh != null ? c3605e7M8194HGpJ.m11805Dt(c3605e7M8194HGpJ.m11814qdMbNW(c2971Ucbh)) : Integer.MIN_VALUE);
    }

    /* renamed from: Pq */
    public final AccessibilityEvent m8198Pq(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.f8071qdMbNW.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    /* renamed from: Ucbh */
    public final boolean m8199Ucbh(MotionEvent motionEvent) {
        if (!this.f8070lgHUyS.isEnabled() || !this.f8070lgHUyS.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iMo2740BAnRFn = mo2740BAnRFn(motionEvent.getX(), motionEvent.getY());
            m8213uHVRx(iMo2740BAnRFn);
            return iMo2740BAnRFn != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f8067MiMN == Integer.MIN_VALUE) {
            return false;
        }
        m8213uHVRx(Integer.MIN_VALUE);
        return true;
    }

    /* renamed from: Vnb */
    public abstract void mo2743Vnb(int i, C2971Ucbh c2971Ucbh);

    /* renamed from: VocHEe */
    public final int m8200VocHEe() {
        return this.f8068VA;
    }

    /* renamed from: WrLQs */
    public final boolean m8201WrLQs(int i) {
        int i2;
        if (!this.f8070lgHUyS.isEnabled() || !this.f8070lgHUyS.isTouchExplorationEnabled() || (i2 = this.f8064ETF) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            m8202YoKzxo(i2);
        }
        this.f8064ETF = i;
        this.f8071qdMbNW.invalidate();
        m8192GMIER(i, 32768);
        return true;
    }

    /* renamed from: YoKzxo */
    public final boolean m8202YoKzxo(int i) {
        if (this.f8064ETF != i) {
            return false;
        }
        this.f8064ETF = Integer.MIN_VALUE;
        this.f8071qdMbNW.invalidate();
        m8192GMIER(i, PKIFailureInfo.notAuthorized);
        return true;
    }

    /* renamed from: aqHPIZ */
    public final boolean m8203aqHPIZ(int i, Bundle bundle) {
        return AbstractC2876T9.m10235JYgkl(this.f8071qdMbNW, i, bundle);
    }

    /* renamed from: cMLeY */
    public void m8204cMLeY(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* renamed from: diqgf */
    public final C2971Ucbh m8205diqgf(int i) {
        C2971Ucbh c2971UcbhM10525WrLQs = C2971Ucbh.m10525WrLQs();
        c2971UcbhM10525WrLQs.m10570alEkx(true);
        c2971UcbhM10525WrLQs.m10594tQ(true);
        c2971UcbhM10525WrLQs.m10572bbzow("android.view.View");
        Rect rect = f8060YoKzxo;
        c2971UcbhM10525WrLQs.m10544JrJO(rect);
        c2971UcbhM10525WrLQs.m10589nxI(rect);
        c2971UcbhM10525WrLQs.m10555Qr(this.f8071qdMbNW);
        mo2743Vnb(i, c2971UcbhM10525WrLQs);
        if (c2971UcbhM10525WrLQs.m10582huTpC() == null && c2971UcbhM10525WrLQs.m10579fehf() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        c2971UcbhM10525WrLQs.m10534Dt(this.f8066KLFTb);
        if (this.f8066KLFTb.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iM10586lgHUyS = c2971UcbhM10525WrLQs.m10586lgHUyS();
        if ((iM10586lgHUyS & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iM10586lgHUyS & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        c2971UcbhM10525WrLQs.m10557SmIWf(this.f8071qdMbNW.getContext().getPackageName());
        c2971UcbhM10525WrLQs.m10604yX(this.f8071qdMbNW, i);
        if (this.f8064ETF == i) {
            c2971UcbhM10525WrLQs.m10542JYgkl(true);
            c2971UcbhM10525WrLQs.m10588mjFkc(128);
        } else {
            c2971UcbhM10525WrLQs.m10542JYgkl(false);
            c2971UcbhM10525WrLQs.m10588mjFkc(64);
        }
        boolean z = this.f8068VA == i;
        if (z) {
            c2971UcbhM10525WrLQs.m10588mjFkc(2);
        } else if (c2971UcbhM10525WrLQs.m10533CqaNbM()) {
            c2971UcbhM10525WrLQs.m10588mjFkc(1);
        }
        c2971UcbhM10525WrLQs.m10605yfx(z);
        this.f8071qdMbNW.getLocationOnScreen(this.f8072xJ);
        c2971UcbhM10525WrLQs.m10535ETF(this.f8069ZfxDd);
        if (this.f8069ZfxDd.equals(rect)) {
            c2971UcbhM10525WrLQs.m10534Dt(this.f8069ZfxDd);
            if (c2971UcbhM10525WrLQs.f10853AZxh != -1) {
                C2971Ucbh c2971UcbhM10525WrLQs2 = C2971Ucbh.m10525WrLQs();
                for (int i2 = c2971UcbhM10525WrLQs.f10853AZxh; i2 != -1; i2 = c2971UcbhM10525WrLQs2.f10853AZxh) {
                    c2971UcbhM10525WrLQs2.m10550NKyg(this.f8071qdMbNW, -1);
                    c2971UcbhM10525WrLQs2.m10544JrJO(f8060YoKzxo);
                    mo2743Vnb(i2, c2971UcbhM10525WrLQs2);
                    c2971UcbhM10525WrLQs2.m10534Dt(this.f8066KLFTb);
                    Rect rect2 = this.f8069ZfxDd;
                    Rect rect3 = this.f8066KLFTb;
                    rect2.offset(rect3.left, rect3.top);
                }
                c2971UcbhM10525WrLQs2.m10543JYn();
            }
            this.f8069ZfxDd.offset(this.f8072xJ[0] - this.f8071qdMbNW.getScrollX(), this.f8072xJ[1] - this.f8071qdMbNW.getScrollY());
        }
        if (this.f8071qdMbNW.getLocalVisibleRect(this.f8065JHa)) {
            this.f8065JHa.offset(this.f8072xJ[0] - this.f8071qdMbNW.getScrollX(), this.f8072xJ[1] - this.f8071qdMbNW.getScrollY());
            if (this.f8069ZfxDd.intersect(this.f8065JHa)) {
                c2971UcbhM10525WrLQs.m10589nxI(this.f8069ZfxDd);
                if (m8209mByQ(this.f8069ZfxDd)) {
                    c2971UcbhM10525WrLQs.m10567XbiWeM(true);
                }
            }
        }
        return c2971UcbhM10525WrLQs;
    }

    /* renamed from: eyqo */
    public final C2971Ucbh m8206eyqo() {
        C2971Ucbh c2971UcbhM10524KRTLGT = C2971Ucbh.m10524KRTLGT(this.f8071qdMbNW);
        AbstractC2876T9.m10291uHVRx(this.f8071qdMbNW, c2971UcbhM10524KRTLGT);
        ArrayList arrayList = new ArrayList();
        mo2744lB(arrayList);
        if (c2971UcbhM10524KRTLGT.m10548MiMN() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c2971UcbhM10524KRTLGT.m10600wA(this.f8071qdMbNW, ((Integer) arrayList.get(i)).intValue());
        }
        return c2971UcbhM10524KRTLGT;
    }

    /* renamed from: fehf */
    public final AccessibilityEvent m8207fehf(int i, int i2) {
        return i != -1 ? m8195IEE(i, i2) : m8198Pq(i2);
    }

    /* renamed from: huTpC */
    public final boolean m8208huTpC(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return m8197Ne(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return m8197Ne(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iM8189OjSQV = m8189OjSQV(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && m8197Ne(iM8189OjSQV, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m8211qGY();
        return true;
    }

    /* renamed from: lB */
    public abstract void mo2744lB(List list);

    /* renamed from: mByQ */
    public final boolean m8209mByQ(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f8071qdMbNW.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f8071qdMbNW.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    /* renamed from: oCFDzJ */
    public final boolean m8210oCFDzJ(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? mo2741KLMXS(i, i2, bundle) : m8202YoKzxo(i) : m8201WrLQs(i) : m8212rkYL(i) : m8196KRTLGT(i);
    }

    /* renamed from: qGY */
    public final boolean m8211qGY() {
        int i = this.f8068VA;
        return i != Integer.MIN_VALUE && mo2741KLMXS(i, 16, null);
    }

    /* renamed from: rWxwaT */
    public abstract void mo2745rWxwaT(C2971Ucbh c2971Ucbh);

    /* renamed from: rkYL */
    public final boolean m8212rkYL(int i) {
        if (this.f8068VA != i) {
            return false;
        }
        this.f8068VA = Integer.MIN_VALUE;
        mo2742NPj(i, false);
        m8192GMIER(i, 8);
        return true;
    }

    /* renamed from: uHVRx */
    public final void m8213uHVRx(int i) {
        int i2 = this.f8067MiMN;
        if (i2 == i) {
            return;
        }
        this.f8067MiMN = i;
        m8192GMIER(i, 128);
        m8192GMIER(i2, 256);
    }

    /* renamed from: vI */
    public final void m8214vI(int i, Rect rect) {
        m8191CqaNbM(i).m10534Dt(rect);
    }

    /* renamed from: vadzgd */
    public boolean m8215vadzgd(int i, int i2, Bundle bundle) {
        return i != -1 ? m8210oCFDzJ(i, i2, bundle) : m8203aqHPIZ(i2, bundle);
    }

    @Override // p131o.C2454MiMN
    /* renamed from: xJ */
    public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
        super.mo620xJ(view, c2971Ucbh);
        mo2745rWxwaT(c2971Ucbh);
    }

    /* renamed from: xrEuO */
    public final void m8216xrEuO(boolean z, int i, Rect rect) {
        int i2 = this.f8068VA;
        if (i2 != Integer.MIN_VALUE) {
            m8212rkYL(i2);
        }
        if (z) {
            m8197Ne(i, rect);
        }
    }

    /* renamed from: zvd */
    public void m8217zvd(AccessibilityEvent accessibilityEvent) {
    }
}
