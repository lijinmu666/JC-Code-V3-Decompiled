package p131o;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.InterfaceC2087HGpJ;

/* renamed from: o.Ucbh */
/* loaded from: classes.dex */
public class C2971Ucbh {

    /* renamed from: mjFkc */
    public final AccessibilityNodeInfo f10854mjFkc;

    /* renamed from: AZxh */
    public int f10853AZxh = -1;

    /* renamed from: wA */
    public int f10855wA = -1;

    /* renamed from: o.Ucbh$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static CharSequence m10607AZxh(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        /* renamed from: mjFkc */
        public static Object m10608mjFkc(int i, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(i, f, f2, f3);
        }

        /* renamed from: wA */
        public static void m10609wA(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* renamed from: o.Ucbh$JHa */
    public static class JHa {

        /* renamed from: mjFkc */
        public final Object f10856mjFkc;

        public JHa(Object obj) {
            this.f10856mjFkc = obj;
        }

        /* renamed from: mjFkc */
        public static JHa m10610mjFkc(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new JHa(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    /* renamed from: o.Ucbh$KLFTb */
    public static class KLFTb {

        /* renamed from: mjFkc */
        public final Object f10857mjFkc;

        public KLFTb(Object obj) {
            this.f10857mjFkc = obj;
        }

        /* renamed from: mjFkc */
        public static KLFTb m10611mjFkc(int i, int i2, boolean z, int i3) {
            return new KLFTb(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    /* renamed from: o.Ucbh$ZfxDd */
    public static class ZfxDd {
        /* renamed from: AZxh */
        public static void m10612AZxh(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        /* renamed from: Dt */
        public static void m10613Dt(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j));
        }

        /* renamed from: ETF */
        public static void m10614ETF(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        /* renamed from: JHa */
        public static boolean m10615JHa(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        /* renamed from: KLFTb */
        public static boolean m10616KLFTb(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        /* renamed from: VA */
        public static void m10617VA(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }

        /* renamed from: ZfxDd */
        public static long m10618ZfxDd(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        /* renamed from: lgHUyS */
        public static void m10619lgHUyS(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        /* renamed from: mjFkc */
        public static AccessibilityNodeInfo.AccessibilityAction m10620mjFkc() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        /* renamed from: qdMbNW */
        public static void m10621qdMbNW(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        /* renamed from: wA */
        public static CharSequence m10622wA(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        /* renamed from: xJ */
        public static void m10623xJ(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }
    }

    /* renamed from: o.Ucbh$mjFkc */
    public static class mjFkc {

        /* renamed from: BAnRFn */
        public static final mjFkc f10858BAnRFn;

        /* renamed from: CqaNbM */
        public static final mjFkc f10859CqaNbM;

        /* renamed from: GMIER */
        public static final mjFkc f10862GMIER;

        /* renamed from: KLMXS */
        public static final mjFkc f10868KLMXS;

        /* renamed from: KRTLGT */
        public static final mjFkc f10869KRTLGT;

        /* renamed from: NPj */
        public static final mjFkc f10871NPj;

        /* renamed from: Ne */
        public static final mjFkc f10872Ne;

        /* renamed from: OjSQV */
        public static final mjFkc f10873OjSQV;

        /* renamed from: Vnb */
        public static final mjFkc f10877Vnb;

        /* renamed from: VocHEe */
        public static final mjFkc f10878VocHEe;

        /* renamed from: WrLQs */
        public static final mjFkc f10879WrLQs;

        /* renamed from: aqHPIZ */
        public static final mjFkc f10881aqHPIZ;

        /* renamed from: cMLeY */
        public static final mjFkc f10882cMLeY;

        /* renamed from: lB */
        public static final mjFkc f10887lB;

        /* renamed from: mByQ */
        public static final mjFkc f10889mByQ;

        /* renamed from: oCFDzJ */
        public static final mjFkc f10890oCFDzJ;

        /* renamed from: rWxwaT */
        public static final mjFkc f10893rWxwaT;

        /* renamed from: uHVRx */
        public static final mjFkc f10895uHVRx;

        /* renamed from: vadzgd */
        public static final mjFkc f10897vadzgd;

        /* renamed from: wJVbdd */
        public static final mjFkc f10898wJVbdd;

        /* renamed from: xrEuO */
        public static final mjFkc f10900xrEuO;

        /* renamed from: zvd */
        public static final mjFkc f10901zvd;

        /* renamed from: AZxh */
        public final int f10902AZxh;

        /* renamed from: ZfxDd */
        public final InterfaceC2087HGpJ f10903ZfxDd;

        /* renamed from: mjFkc */
        public final Object f10904mjFkc;

        /* renamed from: wA */
        public final Class f10905wA;

        /* renamed from: KLFTb */
        public static final mjFkc f10867KLFTb = new mjFkc(1, null);

        /* renamed from: JHa */
        public static final mjFkc f10866JHa = new mjFkc(2, null);

        /* renamed from: xJ */
        public static final mjFkc f10899xJ = new mjFkc(4, null);

        /* renamed from: lgHUyS */
        public static final mjFkc f10888lgHUyS = new mjFkc(8, null);

        /* renamed from: qdMbNW */
        public static final mjFkc f10892qdMbNW = new mjFkc(16, null);

        /* renamed from: Dt */
        public static final mjFkc f10860Dt = new mjFkc(32, null);

        /* renamed from: ETF */
        public static final mjFkc f10861ETF = new mjFkc(64, null);

        /* renamed from: VA */
        public static final mjFkc f10876VA = new mjFkc(128, null);

        /* renamed from: MiMN */
        public static final mjFkc f10870MiMN = new mjFkc(256, (CharSequence) null, InterfaceC2087HGpJ.AZxh.class);

        /* renamed from: YoKzxo */
        public static final mjFkc f10880YoKzxo = new mjFkc(512, (CharSequence) null, InterfaceC2087HGpJ.AZxh.class);

        /* renamed from: rkYL */
        public static final mjFkc f10894rkYL = new mjFkc(1024, (CharSequence) null, InterfaceC2087HGpJ.wA.class);

        /* renamed from: qGY */
        public static final mjFkc f10891qGY = new mjFkc(2048, (CharSequence) null, InterfaceC2087HGpJ.wA.class);

        /* renamed from: fehf */
        public static final mjFkc f10885fehf = new mjFkc(4096, null);

        /* renamed from: IEE */
        public static final mjFkc f10865IEE = new mjFkc(8192, null);

        /* renamed from: Pq */
        public static final mjFkc f10874Pq = new mjFkc(16384, null);

        /* renamed from: diqgf */
        public static final mjFkc f10883diqgf = new mjFkc(32768, null);

        /* renamed from: eyqo */
        public static final mjFkc f10884eyqo = new mjFkc(PKIFailureInfo.notAuthorized, null);

        /* renamed from: Ucbh */
        public static final mjFkc f10875Ucbh = new mjFkc(PKIFailureInfo.unsupportedVersion, (CharSequence) null, InterfaceC2087HGpJ.xJ.class);

        /* renamed from: huTpC */
        public static final mjFkc f10886huTpC = new mjFkc(PKIFailureInfo.transactionIdInUse, null);

        /* renamed from: Gd */
        public static final mjFkc f10863Gd = new mjFkc(PKIFailureInfo.signerNotTrusted, null);

        /* renamed from: HGpJ */
        public static final mjFkc f10864HGpJ = new mjFkc(1048576, null);

        /* renamed from: vI */
        public static final mjFkc f10896vI = new mjFkc(PKIFailureInfo.badSenderNonce, (CharSequence) null, InterfaceC2087HGpJ.lgHUyS.class);

        static {
            int i = Build.VERSION.SDK_INT;
            f10878VocHEe = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f10858BAnRFn = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, InterfaceC2087HGpJ.KLFTb.class);
            f10887lB = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f10898wJVbdd = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f10889mByQ = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f10873OjSQV = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f10872Ne = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            f10859CqaNbM = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            f10900xrEuO = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            f10868KLMXS = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            f10901zvd = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f10882cMLeY = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, InterfaceC2087HGpJ.JHa.class);
            f10893rWxwaT = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, InterfaceC2087HGpJ.ZfxDd.class);
            f10877Vnb = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            f10871NPj = new mjFkc(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
            f10897vadzgd = new mjFkc(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f10890oCFDzJ = new mjFkc(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f10881aqHPIZ = new mjFkc(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f10879WrLQs = new mjFkc(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f10869KRTLGT = new mjFkc(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f10862GMIER = new mjFkc(i >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f10895uHVRx = new mjFkc(i >= 34 ? ZfxDd.m10620mjFkc() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public mjFkc(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        /* renamed from: AZxh */
        public int m10624AZxh() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f10904mjFkc).getId();
        }

        /* renamed from: ZfxDd */
        public boolean m10625ZfxDd(View view, Bundle bundle) {
            if (this.f10903ZfxDd == null) {
                return false;
            }
            Class cls = this.f10905wA;
            if (cls != null) {
                try {
                    AbstractC4793w7.m13819mjFkc(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e) {
                    Class cls2 = this.f10905wA;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                }
            }
            return this.f10903ZfxDd.mo2482mjFkc(view, null);
        }

        /* renamed from: equals */
        public boolean m10626equals(Object obj) {
            if (obj == null || !(obj instanceof mjFkc)) {
                return false;
            }
            mjFkc mjfkc = (mjFkc) obj;
            Object obj2 = this.f10904mjFkc;
            return obj2 == null ? mjfkc.f10904mjFkc == null : obj2.equals(mjfkc.f10904mjFkc);
        }

        public int hashCode() {
            Object obj = this.f10904mjFkc;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        /* renamed from: mjFkc */
        public mjFkc m10627mjFkc(CharSequence charSequence, InterfaceC2087HGpJ interfaceC2087HGpJ) {
            return new mjFkc(null, this.f10902AZxh, charSequence, interfaceC2087HGpJ, this.f10905wA);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strM10529xJ = C2971Ucbh.m10529xJ(this.f10902AZxh);
            if (strM10529xJ.equals("ACTION_UNKNOWN") && m10628wA() != null) {
                strM10529xJ = m10628wA().toString();
            }
            sb.append(strM10529xJ);
            return sb.toString();
        }

        /* renamed from: wA */
        public CharSequence m10628wA() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f10904mjFkc).getLabel();
        }

        public mjFkc(int i, CharSequence charSequence, InterfaceC2087HGpJ interfaceC2087HGpJ) {
            this(null, i, charSequence, interfaceC2087HGpJ, null);
        }

        public mjFkc(Object obj) {
            this(obj, 0, null, null, null);
        }

        public mjFkc(int i, CharSequence charSequence, Class cls) {
            this(null, i, charSequence, null, cls);
        }

        public mjFkc(Object obj, int i, CharSequence charSequence, InterfaceC2087HGpJ interfaceC2087HGpJ, Class cls) {
            this.f10902AZxh = i;
            this.f10903ZfxDd = interfaceC2087HGpJ;
            if (obj == null) {
                this.f10904mjFkc = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.f10904mjFkc = obj;
            }
            this.f10905wA = cls;
        }
    }

    /* renamed from: o.Ucbh$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static C2971Ucbh m10629AZxh(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
            return C2971Ucbh.m10527jx(accessibilityNodeInfo.getChild(i, i2));
        }

        /* renamed from: Dt */
        public static void m10630Dt(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }

        /* renamed from: JHa */
        public static C2971Ucbh m10631JHa(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return C2971Ucbh.m10527jx(accessibilityNodeInfo.getParent(i));
        }

        /* renamed from: KLFTb */
        public static AccessibilityNodeInfo.ExtraRenderingInfo m10632KLFTb(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        /* renamed from: ZfxDd */
        public static String m10633ZfxDd(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        /* renamed from: lgHUyS */
        public static boolean m10634lgHUyS(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        /* renamed from: mjFkc */
        public static JHa m10635mjFkc(boolean z, int i, int i2, int i3, int i4, boolean z2, String str, String str2) {
            return new JHa(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i).setRowIndex(i2).setColumnSpan(i3).setRowSpan(i4).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        /* renamed from: qdMbNW */
        public static void m10636qdMbNW(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        /* renamed from: wA */
        public static String m10637wA(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        /* renamed from: xJ */
        public static String m10638xJ(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }
    }

    public C2971Ucbh(Object obj) {
        this.f10854mjFkc = (AccessibilityNodeInfo) obj;
    }

    /* renamed from: GMIER */
    public static C2971Ucbh m10523GMIER(C2971Ucbh c2971Ucbh) {
        return m10526XtE(AccessibilityNodeInfo.obtain(c2971Ucbh.f10854mjFkc));
    }

    /* renamed from: KRTLGT */
    public static C2971Ucbh m10524KRTLGT(View view) {
        return m10526XtE(AccessibilityNodeInfo.obtain(view));
    }

    /* renamed from: WrLQs */
    public static C2971Ucbh m10525WrLQs() {
        return m10526XtE(AccessibilityNodeInfo.obtain());
    }

    /* renamed from: XtE */
    public static C2971Ucbh m10526XtE(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C2971Ucbh(accessibilityNodeInfo);
    }

    /* renamed from: jx */
    public static C2971Ucbh m10527jx(Object obj) {
        if (obj != null) {
            return new C2971Ucbh(obj);
        }
        return null;
    }

    /* renamed from: rkYL */
    public static ClickableSpan[] m10528rkYL(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: xJ */
    public static String m10529xJ(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case PKIFailureInfo.notAuthorized /* 65536 */:
                return "ACTION_CUT";
            case PKIFailureInfo.unsupportedVersion /* 131072 */:
                return "ACTION_SET_SELECTION";
            case PKIFailureInfo.transactionIdInUse /* 262144 */:
                return "ACTION_EXPAND";
            case PKIFailureInfo.signerNotTrusted /* 524288 */:
                return "ACTION_COLLAPSE";
            case PKIFailureInfo.badSenderNonce /* 2097152 */:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    /* renamed from: ANMGZc */
    public void m10530ANMGZc(boolean z) {
        this.f10854mjFkc.setDismissable(z);
    }

    /* renamed from: AZxh */
    public void m10531AZxh(mjFkc mjfkc) {
        this.f10854mjFkc.addAction((AccessibilityNodeInfo.AccessibilityAction) mjfkc.f10904mjFkc);
    }

    /* renamed from: BAnRFn */
    public boolean m10532BAnRFn() {
        return Build.VERSION.SDK_INT >= 34 ? ZfxDd.m10615JHa(this.f10854mjFkc) : m10592qdMbNW(64);
    }

    /* renamed from: CqaNbM */
    public boolean m10533CqaNbM() {
        return this.f10854mjFkc.isFocusable();
    }

    /* renamed from: Dt */
    public void m10534Dt(Rect rect) {
        this.f10854mjFkc.getBoundsInParent(rect);
    }

    /* renamed from: ETF */
    public void m10535ETF(Rect rect) {
        this.f10854mjFkc.getBoundsInScreen(rect);
    }

    /* renamed from: Gd */
    public CharSequence m10536Gd() {
        return this.f10854mjFkc.getTooltipText();
    }

    /* renamed from: HGpJ */
    public String m10537HGpJ() {
        return Build.VERSION.SDK_INT >= 33 ? wA.m10638xJ(this.f10854mjFkc) : this.f10854mjFkc.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    /* renamed from: IEE */
    public CharSequence m10538IEE() {
        return this.f10854mjFkc.getError();
    }

    /* renamed from: IVlxe */
    public void m10539IVlxe(View view) {
        this.f10854mjFkc.setLabelFor(view);
    }

    /* renamed from: JBhc */
    public void m10540JBhc(Object obj) {
        this.f10854mjFkc.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((KLFTb) obj).f10857mjFkc);
    }

    /* renamed from: JHa */
    public List m10541JHa() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f10854mjFkc.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new mjFkc(actionList.get(i)));
        }
        return arrayList;
    }

    /* renamed from: JYgkl */
    public void m10542JYgkl(boolean z) {
        this.f10854mjFkc.setAccessibilityFocused(z);
    }

    /* renamed from: JYn */
    public void m10543JYn() {
    }

    /* renamed from: JrJO */
    public void m10544JrJO(Rect rect) {
        this.f10854mjFkc.setBoundsInParent(rect);
    }

    /* renamed from: KLFTb */
    public final List m10545KLFTb(String str) {
        ArrayList<Integer> integerArrayList = this.f10854mjFkc.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f10854mjFkc.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* renamed from: KLMXS */
    public boolean m10546KLMXS() {
        return m10592qdMbNW(67108864);
    }

    /* renamed from: LREOK */
    public void m10547LREOK(CharSequence charSequence) {
        this.f10854mjFkc.setText(charSequence);
    }

    /* renamed from: MiMN */
    public int m10548MiMN() {
        return this.f10854mjFkc.getChildCount();
    }

    /* renamed from: Moer */
    public void m10549Moer(int i) {
        this.f10854mjFkc.setMaxTextLength(i);
    }

    /* renamed from: NKyg */
    public void m10550NKyg(View view, int i) {
        this.f10853AZxh = i;
        this.f10854mjFkc.setParent(view, i);
    }

    /* renamed from: NPj */
    public boolean m10551NPj() {
        return this.f10854mjFkc.isSelected();
    }

    /* renamed from: Ne */
    public boolean m10552Ne() {
        return this.f10854mjFkc.isEnabled();
    }

    /* renamed from: OjSQV */
    public boolean m10553OjSQV() {
        return this.f10854mjFkc.isContextClickable();
    }

    /* renamed from: Pq */
    public Bundle m10554Pq() {
        return this.f10854mjFkc.getExtras();
    }

    /* renamed from: Qr */
    public void m10555Qr(View view) {
        this.f10853AZxh = -1;
        this.f10854mjFkc.setParent(view);
    }

    /* renamed from: SOS */
    public void m10556SOS(CharSequence charSequence) {
        this.f10854mjFkc.setPaneTitle(charSequence);
    }

    /* renamed from: SmIWf */
    public void m10557SmIWf(CharSequence charSequence) {
        this.f10854mjFkc.setPackageName(charSequence);
    }

    /* renamed from: SwgkN */
    public void m10558SwgkN(boolean z) {
        this.f10854mjFkc.setClickable(z);
    }

    /* renamed from: Ucbh */
    public CharSequence m10559Ucbh() {
        return Build.VERSION.SDK_INT >= 30 ? AZxh.m10607AZxh(this.f10854mjFkc) : this.f10854mjFkc.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    /* renamed from: VA */
    public void m10560VA(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            ZfxDd.m10612AZxh(this.f10854mjFkc, rect);
            return;
        }
        Rect rect2 = (Rect) this.f10854mjFkc.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    /* renamed from: Vdz */
    public void m10561Vdz(Object obj) {
        this.f10854mjFkc.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((JHa) obj).f10856mjFkc);
    }

    /* renamed from: Vnb */
    public boolean m10562Vnb() {
        return this.f10854mjFkc.isScrollable();
    }

    /* renamed from: VocHEe */
    public final boolean m10563VocHEe() {
        return !m10545KLFTb("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: WGXroI */
    public void m10564WGXroI(boolean z) {
        this.f10854mjFkc.setCheckable(z);
    }

    /* renamed from: XFUzSY */
    public AccessibilityNodeInfo m10565XFUzSY() {
        return this.f10854mjFkc;
    }

    /* renamed from: XV */
    public void m10566XV(boolean z) {
        this.f10854mjFkc.setChecked(z);
    }

    /* renamed from: XbiWeM */
    public void m10567XbiWeM(boolean z) {
        this.f10854mjFkc.setVisibleToUser(z);
    }

    /* renamed from: YoKzxo */
    public CharSequence m10568YoKzxo() {
        return this.f10854mjFkc.getClassName();
    }

    /* renamed from: ZfxDd */
    public void m10569ZfxDd(CharSequence charSequence, View view) {
    }

    /* renamed from: alEkx */
    public void m10570alEkx(boolean z) {
        this.f10854mjFkc.setEnabled(z);
    }

    /* renamed from: aqHPIZ */
    public boolean m10571aqHPIZ() {
        return this.f10854mjFkc.isVisibleToUser();
    }

    /* renamed from: bbzow */
    public void m10572bbzow(CharSequence charSequence) {
        this.f10854mjFkc.setClassName(charSequence);
    }

    /* renamed from: cMLeY */
    public boolean m10573cMLeY() {
        return this.f10854mjFkc.isLongClickable();
    }

    /* renamed from: diqgf */
    public int m10574diqgf() {
        return this.f10854mjFkc.getMaxTextLength();
    }

    /* renamed from: dm */
    public void m10575dm(CharSequence charSequence) {
        this.f10854mjFkc.setError(charSequence);
    }

    /* renamed from: equals */
    public boolean m10576equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C2971Ucbh)) {
            return false;
        }
        C2971Ucbh c2971Ucbh = (C2971Ucbh) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10854mjFkc;
        if (accessibilityNodeInfo == null) {
            if (c2971Ucbh.f10854mjFkc != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c2971Ucbh.f10854mjFkc)) {
            return false;
        }
        return this.f10855wA == c2971Ucbh.f10855wA && this.f10853AZxh == c2971Ucbh.f10853AZxh;
    }

    /* renamed from: eyqo */
    public CharSequence m10577eyqo() {
        return this.f10854mjFkc.getPackageName();
    }

    /* renamed from: fFz */
    public void m10578fFz(View view) {
        this.f10854mjFkc.setTraversalAfter(view);
    }

    /* renamed from: fehf */
    public CharSequence m10579fehf() {
        return this.f10854mjFkc.getContentDescription();
    }

    /* renamed from: gYa */
    public void m10580gYa(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            AZxh.m10609wA(this.f10854mjFkc, charSequence);
        } else {
            this.f10854mjFkc.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    /* renamed from: gtIJp */
    public void m10581gtIJp(boolean z) {
        this.f10854mjFkc.setScreenReaderFocusable(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10854mjFkc;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* renamed from: huTpC */
    public CharSequence m10582huTpC() {
        if (!m10563VocHEe()) {
            return this.f10854mjFkc.getText();
        }
        List listM10545KLFTb = m10545KLFTb("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listM10545KLFTb2 = m10545KLFTb("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listM10545KLFTb3 = m10545KLFTb("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listM10545KLFTb4 = m10545KLFTb("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f10854mjFkc.getText(), 0, this.f10854mjFkc.getText().length()));
        for (int i = 0; i < listM10545KLFTb.size(); i++) {
            spannableString.setSpan(new C3011VA(((Integer) listM10545KLFTb4.get(i)).intValue(), this, m10554Pq().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listM10545KLFTb.get(i)).intValue(), ((Integer) listM10545KLFTb2.get(i)).intValue(), ((Integer) listM10545KLFTb3.get(i)).intValue());
        }
        return spannableString;
    }

    /* renamed from: jm */
    public void m10583jm(CharSequence charSequence) {
        this.f10854mjFkc.setContentDescription(charSequence);
    }

    /* renamed from: kism */
    public void m10584kism(boolean z) {
        this.f10854mjFkc.setScrollable(z);
    }

    /* renamed from: lB */
    public boolean m10585lB() {
        return this.f10854mjFkc.isCheckable();
    }

    /* renamed from: lgHUyS */
    public int m10586lgHUyS() {
        return this.f10854mjFkc.getActions();
    }

    /* renamed from: mByQ */
    public boolean m10587mByQ() {
        return this.f10854mjFkc.isClickable();
    }

    /* renamed from: mjFkc */
    public void m10588mjFkc(int i) {
        this.f10854mjFkc.addAction(i);
    }

    /* renamed from: nxI */
    public void m10589nxI(Rect rect) {
        this.f10854mjFkc.setBoundsInScreen(rect);
    }

    /* renamed from: oCFDzJ */
    public boolean m10590oCFDzJ() {
        return Build.VERSION.SDK_INT >= 33 ? wA.m10634lgHUyS(this.f10854mjFkc) : m10592qdMbNW(8388608);
    }

    /* renamed from: qGY */
    public CharSequence m10591qGY() {
        return Build.VERSION.SDK_INT >= 34 ? ZfxDd.m10622wA(this.f10854mjFkc) : this.f10854mjFkc.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    /* renamed from: qdMbNW */
    public final boolean m10592qdMbNW(int i) {
        Bundle bundleM10554Pq = m10554Pq();
        return bundleM10554Pq != null && (bundleM10554Pq.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    /* renamed from: rWxwaT */
    public boolean m10593rWxwaT() {
        return this.f10854mjFkc.isPassword();
    }

    /* renamed from: tQ */
    public void m10594tQ(boolean z) {
        this.f10854mjFkc.setFocusable(z);
    }

    /* renamed from: tjSezt */
    public void m10595tjSezt(boolean z) {
        this.f10854mjFkc.setShowingHintText(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m10534Dt(rect);
        sb.append("; boundsInParent: " + rect);
        m10535ETF(rect);
        sb.append("; boundsInScreen: " + rect);
        m10560VA(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(m10577eyqo());
        sb.append("; className: ");
        sb.append(m10568YoKzxo());
        sb.append("; text: ");
        sb.append(m10582huTpC());
        sb.append("; error: ");
        sb.append(m10538IEE());
        sb.append("; maxTextLength: ");
        sb.append(m10574diqgf());
        sb.append("; stateDescription: ");
        sb.append(m10559Ucbh());
        sb.append("; contentDescription: ");
        sb.append(m10579fehf());
        sb.append("; tooltipText: ");
        sb.append(m10536Gd());
        sb.append("; viewIdResName: ");
        sb.append(m10597vI());
        sb.append("; uniqueId: ");
        sb.append(m10537HGpJ());
        sb.append("; checkable: ");
        sb.append(m10585lB());
        sb.append("; checked: ");
        sb.append(m10601wJVbdd());
        sb.append("; focusable: ");
        sb.append(m10533CqaNbM());
        sb.append("; focused: ");
        sb.append(m10603xrEuO());
        sb.append("; selected: ");
        sb.append(m10551NPj());
        sb.append("; clickable: ");
        sb.append(m10587mByQ());
        sb.append("; longClickable: ");
        sb.append(m10573cMLeY());
        sb.append("; contextClickable: ");
        sb.append(m10553OjSQV());
        sb.append("; enabled: ");
        sb.append(m10552Ne());
        sb.append("; password: ");
        sb.append(m10593rWxwaT());
        sb.append("; scrollable: " + m10562Vnb());
        sb.append("; containerTitle: ");
        sb.append(m10591qGY());
        sb.append("; granularScrollingSupported: ");
        sb.append(m10546KLMXS());
        sb.append("; importantForAccessibility: ");
        sb.append(m10606zvd());
        sb.append("; visible: ");
        sb.append(m10571aqHPIZ());
        sb.append("; isTextSelectable: ");
        sb.append(m10590oCFDzJ());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(m10532BAnRFn());
        sb.append("; [");
        List listM10541JHa = m10541JHa();
        for (int i = 0; i < listM10541JHa.size(); i++) {
            mjFkc mjfkc = (mjFkc) listM10541JHa.get(i);
            String strM10529xJ = m10529xJ(mjfkc.m10624AZxh());
            if (strM10529xJ.equals("ACTION_UNKNOWN") && mjfkc.m10628wA() != null) {
                strM10529xJ = mjfkc.m10628wA().toString();
            }
            sb.append(strM10529xJ);
            if (i != listM10541JHa.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: uHVRx */
    public boolean m10596uHVRx(int i, Bundle bundle) {
        return this.f10854mjFkc.performAction(i, bundle);
    }

    /* renamed from: vI */
    public String m10597vI() {
        return this.f10854mjFkc.getViewIdResourceName();
    }

    /* renamed from: vadzgd */
    public boolean m10598vadzgd() {
        return this.f10854mjFkc.isShowingHintText();
    }

    /* renamed from: vjlshU */
    public void m10599vjlshU(boolean z) {
        this.f10854mjFkc.setHeading(z);
    }

    /* renamed from: wA */
    public void m10600wA(View view, int i) {
        this.f10854mjFkc.addChild(view, i);
    }

    /* renamed from: wJVbdd */
    public boolean m10601wJVbdd() {
        return this.f10854mjFkc.isChecked();
    }

    /* renamed from: xROA */
    public void m10602xROA(CharSequence charSequence) {
        this.f10854mjFkc.setHintText(charSequence);
    }

    /* renamed from: xrEuO */
    public boolean m10603xrEuO() {
        return this.f10854mjFkc.isFocused();
    }

    /* renamed from: yX */
    public void m10604yX(View view, int i) {
        this.f10855wA = i;
        this.f10854mjFkc.setSource(view, i);
    }

    /* renamed from: yfx */
    public void m10605yfx(boolean z) {
        this.f10854mjFkc.setFocused(z);
    }

    /* renamed from: zvd */
    public boolean m10606zvd() {
        return this.f10854mjFkc.isImportantForAccessibility();
    }

    public C2971Ucbh(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f10854mjFkc = accessibilityNodeInfo;
    }
}
