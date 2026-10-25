package p131o;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p131o.C2971Ucbh;

/* renamed from: o.MiMN */
/* loaded from: classes.dex */
public class C2454MiMN {

    /* renamed from: wA */
    public static final View.AccessibilityDelegate f9594wA = new View.AccessibilityDelegate();

    /* renamed from: AZxh */
    public final View.AccessibilityDelegate f9595AZxh;

    /* renamed from: mjFkc */
    public final View.AccessibilityDelegate f9596mjFkc;

    /* renamed from: o.MiMN$mjFkc */
    public static final class mjFkc extends View.AccessibilityDelegate {

        /* renamed from: mjFkc */
        public final C2454MiMN f9597mjFkc;

        public mjFkc(C2454MiMN c2454MiMN) {
            this.f9597mjFkc = c2454MiMN;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f9597mjFkc.mo1225mjFkc(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C3850huTpC c3850huTpCMo1220AZxh = this.f9597mjFkc.mo1220AZxh(view);
            if (c3850huTpCMo1220AZxh != null) {
                return (AccessibilityNodeProvider) c3850huTpCMo1220AZxh.m12238KLFTb();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9597mjFkc.mo619JHa(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C2971Ucbh c2971UcbhM10526XtE = C2971Ucbh.m10526XtE(accessibilityNodeInfo);
            c2971UcbhM10526XtE.m10581gtIJp(AbstractC2876T9.m10293vadzgd(view));
            c2971UcbhM10526XtE.m10599vjlshU(AbstractC2876T9.m10302zvd(view));
            c2971UcbhM10526XtE.m10556SOS(AbstractC2876T9.m10227ETF(view));
            c2971UcbhM10526XtE.m10580gYa(AbstractC2876T9.m10296wJVbdd(view));
            this.f9597mjFkc.mo620xJ(view, c2971UcbhM10526XtE);
            c2971UcbhM10526XtE.m10569ZfxDd(accessibilityNodeInfo.getText(), view);
            List listM9525wA = C2454MiMN.m9525wA(view);
            for (int i = 0; i < listM9525wA.size(); i++) {
                c2971UcbhM10526XtE.m10531AZxh((C2971Ucbh.mjFkc) listM9525wA.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f9597mjFkc.mo1224lgHUyS(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f9597mjFkc.mo1226qdMbNW(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f9597mjFkc.mo618Dt(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f9597mjFkc.mo1222VA(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f9597mjFkc.mo1221MiMN(view, accessibilityEvent);
        }
    }

    public C2454MiMN() {
        this(f9594wA);
    }

    /* renamed from: wA */
    public static List m9525wA(View view) {
        List list = (List) view.getTag(AbstractC4790w4.f17118CqaNbM);
        return list == null ? Collections.emptyList() : list;
    }

    /* renamed from: AZxh */
    public C3850huTpC mo1220AZxh(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f9596mjFkc.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C3850huTpC(accessibilityNodeProvider);
        }
        return null;
    }

    /* renamed from: Dt */
    public boolean mo618Dt(View view, int i, Bundle bundle) {
        List listM9525wA = m9525wA(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= listM9525wA.size()) {
                break;
            }
            C2971Ucbh.mjFkc mjfkc = (C2971Ucbh.mjFkc) listM9525wA.get(i2);
            if (mjfkc.m10624AZxh() == i) {
                zPerformAccessibilityAction = mjfkc.m10625ZfxDd(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f9596mjFkc.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != AbstractC4790w4.f17147mjFkc || bundle == null) ? zPerformAccessibilityAction : m9526ETF(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    /* renamed from: ETF */
    public final boolean m9526ETF(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(AbstractC4790w4.f17158xrEuO);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!m9527KLFTb(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    /* renamed from: JHa */
    public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
        this.f9596mjFkc.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: KLFTb */
    public final boolean m9527KLFTb(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrM10528rkYL = C2971Ucbh.m10528rkYL(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrM10528rkYL != null && i < clickableSpanArrM10528rkYL.length; i++) {
                if (clickableSpan.equals(clickableSpanArrM10528rkYL[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: MiMN */
    public void mo1221MiMN(View view, AccessibilityEvent accessibilityEvent) {
        this.f9596mjFkc.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* renamed from: VA */
    public void mo1222VA(View view, int i) {
        this.f9596mjFkc.sendAccessibilityEvent(view, i);
    }

    /* renamed from: ZfxDd */
    public View.AccessibilityDelegate m9528ZfxDd() {
        return this.f9595AZxh;
    }

    /* renamed from: lgHUyS */
    public void mo1224lgHUyS(View view, AccessibilityEvent accessibilityEvent) {
        this.f9596mjFkc.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: mjFkc */
    public boolean mo1225mjFkc(View view, AccessibilityEvent accessibilityEvent) {
        return this.f9596mjFkc.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: qdMbNW */
    public boolean mo1226qdMbNW(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f9596mjFkc.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: xJ */
    public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
        this.f9596mjFkc.onInitializeAccessibilityNodeInfo(view, c2971Ucbh.m10565XFUzSY());
    }

    public C2454MiMN(View.AccessibilityDelegate accessibilityDelegate) {
        this.f9596mjFkc = accessibilityDelegate;
        this.f9595AZxh = new mjFkc(this);
    }
}
