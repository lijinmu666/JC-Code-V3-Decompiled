package androidx.fragment.p022app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.p022app.AbstractC0086Dt;
import androidx.lifecycle.AbstractC0112wA;
import p131o.AbstractC2876T9;
import p131o.AbstractC4925y4;
import p131o.C1833DanUFX;
import p131o.C3435bVfe;
import p131o.C3793gy;

/* renamed from: androidx.fragment.app.xJ */
/* loaded from: classes.dex */
public class C0099xJ {

    /* renamed from: AZxh */
    public final C3435bVfe f1329AZxh;

    /* renamed from: mjFkc */
    public final C1833DanUFX f1332mjFkc;

    /* renamed from: wA */
    public final Fragment f1333wA;

    /* renamed from: ZfxDd */
    public boolean f1331ZfxDd = false;

    /* renamed from: KLFTb */
    public int f1330KLFTb = -1;

    /* renamed from: androidx.fragment.app.xJ$AZxh */
    public static /* synthetic */ class AZxh {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f1334mjFkc;

        static {
            int[] iArr = new int[AbstractC0112wA.AZxh.m1097values().length];
            f1334mjFkc = iArr;
            try {
                iArr[AbstractC0112wA.AZxh.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1334mjFkc[AbstractC0112wA.AZxh.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1334mjFkc[AbstractC0112wA.AZxh.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1334mjFkc[AbstractC0112wA.AZxh.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.xJ$mjFkc */
    public class mjFkc implements View.OnAttachStateChangeListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ View f1336mjFkc;

        public mjFkc(View view) {
            this.f1336mjFkc = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f1336mjFkc.removeOnAttachStateChangeListener(this);
            AbstractC2876T9.m10255Vdz(this.f1336mjFkc);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public C0099xJ(C1833DanUFX c1833DanUFX, C3435bVfe c3435bVfe, Fragment fragment) {
        this.f1332mjFkc = c1833DanUFX;
        this.f1329AZxh = c3435bVfe;
        this.f1333wA = fragment;
    }

    /* renamed from: AZxh */
    public void m1006AZxh() {
        int iM11517lgHUyS = this.f1329AZxh.m11517lgHUyS(this.f1333wA);
        Fragment fragment = this.f1333wA;
        fragment.f1151wJVbdd.addView(fragment.f1140mByQ, iM11517lgHUyS);
    }

    /* renamed from: Dt */
    public void m1007Dt() {
        Fragment fragment = this.f1333wA;
        if (fragment.f1126VA && fragment.f1120MiMN && !fragment.f1146rkYL) {
            if (AbstractC0093KLFTb.m857dm(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1333wA);
            }
            Fragment fragment2 = this.f1333wA;
            fragment2.mo778Moer(fragment2.m784Qr(fragment2.f1106AZxh), null, this.f1333wA.f1106AZxh);
            View view = this.f1333wA.f1140mByQ;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f1333wA;
                fragment3.f1140mByQ.setTag(AbstractC4925y4.f17475mjFkc, fragment3);
                Fragment fragment4 = this.f1333wA;
                if (fragment4.f1137huTpC) {
                    fragment4.f1140mByQ.setVisibility(8);
                }
                this.f1333wA.m813gYa();
                C1833DanUFX c1833DanUFX = this.f1332mjFkc;
                Fragment fragment5 = this.f1333wA;
                c1833DanUFX.m8025ETF(fragment5, fragment5.f1140mByQ, fragment5.f1106AZxh, false);
                this.f1333wA.f1141mjFkc = 2;
            }
        }
    }

    /* renamed from: ETF */
    public Fragment m1008ETF() {
        return this.f1333wA;
    }

    /* renamed from: IEE */
    public void m1009IEE() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f1333wA);
        }
        this.f1333wA.m835tjSezt();
        this.f1332mjFkc.m8032qdMbNW(this.f1333wA, false);
    }

    /* renamed from: JHa */
    public void m1010JHa() {
        String resourceName;
        if (this.f1333wA.f1126VA) {
            return;
        }
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        LayoutInflater layoutInflaterM784Qr = fragment.m784Qr(fragment.f1106AZxh);
        Fragment fragment2 = this.f1333wA;
        ViewGroup viewGroup = fragment2.f1151wJVbdd;
        if (viewGroup == null) {
            int i = fragment2.f1135eyqo;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f1333wA + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.f1136fehf.m934uHVRx().mo850mjFkc(this.f1333wA.f1135eyqo);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f1333wA;
                    if (!fragment3.f1130YoKzxo) {
                        try {
                            resourceName = fragment3.m782OjSQV().getResourceName(this.f1333wA.f1135eyqo);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f1333wA.f1135eyqo) + " (" + resourceName + ") for fragment " + this.f1333wA);
                    }
                }
            }
        }
        Fragment fragment4 = this.f1333wA;
        fragment4.f1151wJVbdd = viewGroup;
        fragment4.mo778Moer(layoutInflaterM784Qr, viewGroup, fragment4.f1106AZxh);
        View view = this.f1333wA.f1140mByQ;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f1333wA;
            fragment5.f1140mByQ.setTag(AbstractC4925y4.f17475mjFkc, fragment5);
            if (viewGroup != null) {
                m1006AZxh();
            }
            Fragment fragment6 = this.f1333wA;
            if (fragment6.f1137huTpC) {
                fragment6.f1140mByQ.setVisibility(8);
            }
            if (AbstractC2876T9.m10268cMLeY(this.f1333wA.f1140mByQ)) {
                AbstractC2876T9.m10255Vdz(this.f1333wA.f1140mByQ);
            } else {
                View view2 = this.f1333wA.f1140mByQ;
                view2.addOnAttachStateChangeListener(new mjFkc(view2));
            }
            this.f1333wA.m813gYa();
            C1833DanUFX c1833DanUFX = this.f1332mjFkc;
            Fragment fragment7 = this.f1333wA;
            c1833DanUFX.m8025ETF(fragment7, fragment7.f1140mByQ, fragment7.f1106AZxh, false);
            int visibility = this.f1333wA.f1140mByQ.getVisibility();
            float alpha = this.f1333wA.f1140mByQ.getAlpha();
            if (AbstractC0093KLFTb.f1194KLMXS) {
                this.f1333wA.m796XD(alpha);
                Fragment fragment8 = this.f1333wA;
                if (fragment8.f1151wJVbdd != null && visibility == 0) {
                    View viewFindFocus = fragment8.f1140mByQ.findFocus();
                    if (viewFindFocus != null) {
                        this.f1333wA.m791Vgyli(viewFindFocus);
                        if (AbstractC0093KLFTb.m857dm(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f1333wA);
                        }
                    }
                    this.f1333wA.f1140mByQ.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f1333wA;
                if (visibility == 0 && fragment9.f1151wJVbdd != null) {
                    z = true;
                }
                fragment9.f1118KLMXS = z;
            }
        }
        this.f1333wA.f1141mjFkc = 2;
    }

    /* renamed from: KLFTb */
    public void m1011KLFTb() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        if (fragment.f1127Vnb) {
            fragment.m797XFUzSY(fragment.f1106AZxh);
            this.f1333wA.f1141mjFkc = 1;
            return;
        }
        this.f1332mjFkc.m8034xJ(fragment, fragment.f1106AZxh, false);
        Fragment fragment2 = this.f1333wA;
        fragment2.m768IVlxe(fragment2.f1106AZxh);
        C1833DanUFX c1833DanUFX = this.f1332mjFkc;
        Fragment fragment3 = this.f1333wA;
        c1833DanUFX.m8033wA(fragment3, fragment3.f1106AZxh, false);
    }

    /* renamed from: MiMN */
    public void m1012MiMN() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f1331ZfxDd) {
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + m1008ETF());
                return;
            }
            return;
        }
        try {
            this.f1331ZfxDd = true;
            while (true) {
                int iM1016ZfxDd = m1016ZfxDd();
                Fragment fragment = this.f1333wA;
                int i = fragment.f1141mjFkc;
                if (iM1016ZfxDd == i) {
                    if (AbstractC0093KLFTb.f1194KLMXS && fragment.f1154zvd) {
                        if (fragment.f1140mByQ != null && (viewGroup = fragment.f1151wJVbdd) != null) {
                            AbstractC0086Dt abstractC0086DtM721MiMN = AbstractC0086Dt.m721MiMN(viewGroup, fragment.m838vI());
                            if (this.f1333wA.f1137huTpC) {
                                abstractC0086DtM721MiMN.m736wA(this);
                            } else {
                                abstractC0086DtM721MiMN.m727KLFTb(this);
                            }
                        }
                        Fragment fragment2 = this.f1333wA;
                        AbstractC0093KLFTb abstractC0093KLFTb = fragment2.f1136fehf;
                        if (abstractC0093KLFTb != null) {
                            abstractC0093KLFTb.m861ANMGZc(fragment2);
                        }
                        Fragment fragment3 = this.f1333wA;
                        fragment3.f1154zvd = false;
                        fragment3.m787SwgkN(fragment3.f1137huTpC);
                    }
                    this.f1331ZfxDd = false;
                    return;
                }
                if (iM1016ZfxDd <= i) {
                    switch (i - 1) {
                        case -1:
                            m1021qdMbNW();
                            break;
                        case 0:
                            m1024xJ();
                            break;
                        case 1:
                            m1018lgHUyS();
                            this.f1333wA.f1141mjFkc = 1;
                            break;
                        case 2:
                            fragment.f1120MiMN = false;
                            fragment.f1141mjFkc = 2;
                            break;
                        case 3:
                            if (AbstractC0093KLFTb.m857dm(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1333wA);
                            }
                            Fragment fragment4 = this.f1333wA;
                            if (fragment4.f1140mByQ != null && fragment4.f1150wA == null) {
                                m1020qGY();
                            }
                            Fragment fragment5 = this.f1333wA;
                            if (fragment5.f1140mByQ != null && (viewGroup3 = fragment5.f1151wJVbdd) != null) {
                                AbstractC0086Dt.m721MiMN(viewGroup3, fragment5.m838vI()).m729ZfxDd(this);
                            }
                            this.f1333wA.f1141mjFkc = 3;
                            break;
                        case 4:
                            m1013Pq();
                            break;
                        case 5:
                            fragment.f1141mjFkc = 5;
                            break;
                        case 6:
                            m1015YoKzxo();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            m1023wA();
                            break;
                        case 1:
                            m1011KLFTb();
                            break;
                        case 2:
                            m1007Dt();
                            m1010JHa();
                            break;
                        case 3:
                            m1019mjFkc();
                            break;
                        case 4:
                            if (fragment.f1140mByQ != null && (viewGroup2 = fragment.f1151wJVbdd) != null) {
                                AbstractC0086Dt.m721MiMN(viewGroup2, fragment.m838vI()).m723AZxh(AbstractC0086Dt.KLFTb.wA.m753lgHUyS(this.f1333wA.f1140mByQ.getVisibility()), this);
                            }
                            this.f1333wA.f1141mjFkc = 4;
                            break;
                        case 5:
                            m1009IEE();
                            break;
                        case 6:
                            fragment.f1141mjFkc = 6;
                            break;
                        case 7:
                            m1022rkYL();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f1331ZfxDd = false;
            throw th;
        }
    }

    /* renamed from: Pq */
    public void m1013Pq() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f1333wA);
        }
        this.f1333wA.m846yX();
        this.f1332mjFkc.m8024Dt(this.f1333wA, false);
    }

    /* renamed from: VA */
    public final boolean m1014VA(View view) {
        if (view == this.f1333wA.f1140mByQ) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f1333wA.f1140mByQ) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: YoKzxo */
    public void m1015YoKzxo() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f1333wA);
        }
        this.f1333wA.m779NKyg();
        this.f1332mjFkc.m8027KLFTb(this.f1333wA, false);
    }

    /* renamed from: ZfxDd */
    public int m1016ZfxDd() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f1333wA;
        if (fragment2.f1136fehf == null) {
            return fragment2.f1141mjFkc;
        }
        int iMin = this.f1330KLFTb;
        int i = AZxh.f1334mjFkc[fragment2.f1121NPj.ordinal()];
        if (i != 1) {
            iMin = i != 2 ? i != 3 ? i != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment3 = this.f1333wA;
        if (fragment3.f1126VA) {
            if (fragment3.f1120MiMN) {
                iMin = Math.max(this.f1330KLFTb, 2);
                View view = this.f1333wA.f1140mByQ;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f1330KLFTb < 4 ? Math.min(iMin, fragment3.f1141mjFkc) : Math.min(iMin, 1);
            }
        }
        if (!this.f1333wA.f1109Dt) {
            iMin = Math.min(iMin, 1);
        }
        AbstractC0086Dt.KLFTb.AZxh aZxhM725ETF = (!AbstractC0093KLFTb.f1194KLMXS || (viewGroup = (fragment = this.f1333wA).f1151wJVbdd) == null) ? null : AbstractC0086Dt.m721MiMN(viewGroup, fragment.m838vI()).m725ETF(this);
        if (aZxhM725ETF == AbstractC0086Dt.KLFTb.AZxh.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aZxhM725ETF == AbstractC0086Dt.KLFTb.AZxh.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f1333wA;
            if (fragment4.f1110ETF) {
                iMin = fragment4.m827oCFDzJ() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f1333wA;
        if (fragment5.f1123OjSQV && fragment5.f1141mjFkc < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f1333wA);
        }
        return iMin;
    }

    /* renamed from: fehf */
    public void m1017fehf(int i) {
        this.f1330KLFTb = i;
    }

    /* renamed from: lgHUyS */
    public void m1018lgHUyS() {
        View view;
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        ViewGroup viewGroup = fragment.f1151wJVbdd;
        if (viewGroup != null && (view = fragment.f1140mByQ) != null) {
            viewGroup.removeView(view);
        }
        this.f1333wA.m786SmIWf();
        this.f1332mjFkc.m8028VA(this.f1333wA, false);
        Fragment fragment2 = this.f1333wA;
        fragment2.f1151wJVbdd = null;
        fragment2.f1140mByQ = null;
        fragment2.f1142oCFDzJ = null;
        fragment2.f1132aqHPIZ.mo1060lgHUyS(null);
        this.f1333wA.f1120MiMN = false;
    }

    /* renamed from: mjFkc */
    public void m1019mjFkc() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        fragment.m840vjlshU(fragment.f1106AZxh);
        C1833DanUFX c1833DanUFX = this.f1332mjFkc;
        Fragment fragment2 = this.f1333wA;
        c1833DanUFX.m8031mjFkc(fragment2, fragment2.f1106AZxh, false);
    }

    /* renamed from: qGY */
    public void m1020qGY() {
        if (this.f1333wA.f1140mByQ == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f1333wA.f1140mByQ.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f1333wA.f1150wA = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f1333wA.f1142oCFDzJ.m7693lgHUyS(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f1333wA.f1131ZfxDd = bundle;
    }

    /* renamed from: qdMbNW */
    public void m1021qdMbNW() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f1333wA);
        }
        this.f1333wA.m785SOS();
        this.f1332mjFkc.m8029ZfxDd(this.f1333wA, false);
        Fragment fragment = this.f1333wA;
        fragment.f1141mjFkc = -1;
        fragment.getClass();
        Fragment fragment2 = this.f1333wA;
        fragment2.f1124Pq = null;
        fragment2.f1136fehf = null;
        if ((!fragment2.f1110ETF || fragment2.m827oCFDzJ()) && !this.f1329AZxh.m11510MiMN().m11579Dt(this.f1333wA)) {
            return;
        }
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f1333wA);
        }
        this.f1333wA.m839vadzgd();
    }

    /* renamed from: rkYL */
    public void m1022rkYL() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f1333wA);
        }
        View viewM809eyqo = this.f1333wA.m809eyqo();
        if (viewM809eyqo != null && m1014VA(viewM809eyqo)) {
            boolean zRequestFocus = viewM809eyqo.requestFocus();
            if (AbstractC0093KLFTb.m857dm(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(viewM809eyqo);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f1333wA);
                sb.append(" resulting in focused view ");
                sb.append(this.f1333wA.f1140mByQ.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f1333wA.m791Vgyli(null);
        this.f1333wA.m820kism();
        this.f1332mjFkc.m8030lgHUyS(this.f1333wA, false);
        Fragment fragment = this.f1333wA;
        fragment.f1106AZxh = null;
        fragment.f1150wA = null;
        fragment.f1131ZfxDd = null;
    }

    /* renamed from: wA */
    public void m1023wA() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        Fragment fragment2 = fragment.f1152xJ;
        C0099xJ c0099xJM11506ETF = null;
        if (fragment2 != null) {
            C0099xJ c0099xJM11506ETF2 = this.f1329AZxh.m11506ETF(fragment2.f1117KLFTb);
            if (c0099xJM11506ETF2 == null) {
                throw new IllegalStateException("Fragment " + this.f1333wA + " declared target fragment " + this.f1333wA.f1152xJ + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f1333wA;
            fragment3.f1139lgHUyS = fragment3.f1152xJ.f1117KLFTb;
            fragment3.f1152xJ = null;
            c0099xJM11506ETF = c0099xJM11506ETF2;
        } else {
            String str = fragment.f1139lgHUyS;
            if (str != null && (c0099xJM11506ETF = this.f1329AZxh.m11506ETF(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f1333wA + " declared target fragment " + this.f1333wA.f1139lgHUyS + " that does not belong to this FragmentManager!");
            }
        }
        if (c0099xJM11506ETF != null && (AbstractC0093KLFTb.f1194KLMXS || c0099xJM11506ETF.m1008ETF().f1141mjFkc < 1)) {
            c0099xJM11506ETF.m1012MiMN();
        }
        Fragment fragment4 = this.f1333wA;
        fragment4.f1136fehf.m925nxI();
        fragment4.getClass();
        Fragment fragment5 = this.f1333wA;
        fragment5.f1124Pq = fragment5.f1136fehf.m900XV();
        this.f1332mjFkc.m8026JHa(this.f1333wA, false);
        this.f1333wA.m844xROA();
        this.f1332mjFkc.m8023AZxh(this.f1333wA, false);
    }

    /* renamed from: xJ */
    public void m1024xJ() {
        Fragment fragmentM11509KLFTb;
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f1333wA);
        }
        Fragment fragment = this.f1333wA;
        if ((fragment.f1110ETF && !fragment.m827oCFDzJ()) || this.f1329AZxh.m11510MiMN().m11579Dt(this.f1333wA)) {
            this.f1333wA.getClass();
            throw null;
        }
        String str = this.f1333wA.f1139lgHUyS;
        if (str != null && (fragmentM11509KLFTb = this.f1329AZxh.m11509KLFTb(str)) != null && fragmentM11509KLFTb.f1113HGpJ) {
            this.f1333wA.f1152xJ = fragmentM11509KLFTb;
        }
        this.f1333wA.f1141mjFkc = 0;
    }

    public C0099xJ(C1833DanUFX c1833DanUFX, C3435bVfe c3435bVfe, Fragment fragment, C3793gy c3793gy) {
        this.f1332mjFkc = c1833DanUFX;
        this.f1329AZxh = c3435bVfe;
        this.f1333wA = fragment;
        fragment.f1150wA = null;
        fragment.f1131ZfxDd = null;
        fragment.f1143qGY = 0;
        fragment.f1120MiMN = false;
        fragment.f1109Dt = false;
        Fragment fragment2 = fragment.f1152xJ;
        fragment.f1139lgHUyS = fragment2 != null ? fragment2.f1117KLFTb : null;
        fragment.f1152xJ = null;
        Bundle bundle = c3793gy.f13881MiMN;
        if (bundle != null) {
            fragment.f1106AZxh = bundle;
        } else {
            fragment.f1106AZxh = new Bundle();
        }
    }
}
