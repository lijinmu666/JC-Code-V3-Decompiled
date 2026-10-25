package androidx.fragment.p022app;

import android.animation.Animator;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.C0103JHa;
import androidx.lifecycle.InterfaceC0104KLFTb;
import androidx.lifecycle.LiveData;
import androidx.savedstate.C0184mjFkc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import p131o.AbstractActivityC2784RnaHj;
import p131o.AbstractC2414M6;
import p131o.AbstractC3535d1;
import p131o.AbstractC3963jeHSg;
import p131o.AbstractC4356pa;
import p131o.AbstractC4421qa;
import p131o.AbstractC4489ra;
import p131o.AbstractC4793w7;
import p131o.C1600A2;
import p131o.C1680BEUaYa;
import p131o.C2781RleMQT;
import p131o.C3829ha;
import p131o.C3893ia;
import p131o.C4127m6;
import p131o.C4527s7;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC3958ja;
import p131o.InterfaceC4193n6;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC3068W0, InterfaceC3958ja, InterfaceC4193n6 {

    /* renamed from: JYgkl */
    public static final Object f1105JYgkl = new Object();

    /* renamed from: AZxh */
    public Bundle f1106AZxh;

    /* renamed from: CqaNbM */
    public C0091wA f1108CqaNbM;

    /* renamed from: Dt */
    public boolean f1109Dt;

    /* renamed from: ETF */
    public boolean f1110ETF;

    /* renamed from: GMIER */
    public int f1111GMIER;

    /* renamed from: Gd */
    public boolean f1112Gd;

    /* renamed from: HGpJ */
    public boolean f1113HGpJ;

    /* renamed from: JHa */
    public Bundle f1115JHa;

    /* renamed from: KLMXS */
    public boolean f1118KLMXS;

    /* renamed from: KRTLGT */
    public C4127m6 f1119KRTLGT;

    /* renamed from: MiMN */
    public boolean f1120MiMN;

    /* renamed from: OjSQV */
    public boolean f1123OjSQV;

    /* renamed from: Pq */
    public Fragment f1124Pq;

    /* renamed from: Ucbh */
    public String f1125Ucbh;

    /* renamed from: VA */
    public boolean f1126VA;

    /* renamed from: Vnb */
    public boolean f1127Vnb;

    /* renamed from: VocHEe */
    public boolean f1128VocHEe;

    /* renamed from: WrLQs */
    public C3829ha.mjFkc f1129WrLQs;

    /* renamed from: YoKzxo */
    public boolean f1130YoKzxo;

    /* renamed from: ZfxDd */
    public Bundle f1131ZfxDd;

    /* renamed from: cMLeY */
    public float f1133cMLeY;

    /* renamed from: diqgf */
    public int f1134diqgf;

    /* renamed from: eyqo */
    public int f1135eyqo;

    /* renamed from: fehf */
    public AbstractC0093KLFTb f1136fehf;

    /* renamed from: huTpC */
    public boolean f1137huTpC;

    /* renamed from: lB */
    public boolean f1138lB;

    /* renamed from: mByQ */
    public View f1140mByQ;

    /* renamed from: oCFDzJ */
    public C1680BEUaYa f1142oCFDzJ;

    /* renamed from: qGY */
    public int f1143qGY;

    /* renamed from: rWxwaT */
    public LayoutInflater f1145rWxwaT;

    /* renamed from: rkYL */
    public boolean f1146rkYL;

    /* renamed from: vI */
    public boolean f1148vI;

    /* renamed from: vadzgd */
    public C0103JHa f1149vadzgd;

    /* renamed from: wA */
    public SparseArray f1150wA;

    /* renamed from: wJVbdd */
    public ViewGroup f1151wJVbdd;

    /* renamed from: xJ */
    public Fragment f1152xJ;

    /* renamed from: zvd */
    public boolean f1154zvd;

    /* renamed from: mjFkc */
    public int f1141mjFkc = -1;

    /* renamed from: KLFTb */
    public String f1117KLFTb = UUID.randomUUID().toString();

    /* renamed from: lgHUyS */
    public String f1139lgHUyS = null;

    /* renamed from: qdMbNW */
    public Boolean f1144qdMbNW = null;

    /* renamed from: IEE */
    public AbstractC0093KLFTb f1114IEE = new C2781RleMQT();

    /* renamed from: BAnRFn */
    public boolean f1107BAnRFn = true;

    /* renamed from: Ne */
    public boolean f1122Ne = true;

    /* renamed from: xrEuO */
    public Runnable f1153xrEuO = new RunnableC0090mjFkc();

    /* renamed from: NPj */
    public AbstractC0112wA.AZxh f1121NPj = AbstractC0112wA.AZxh.RESUMED;

    /* renamed from: aqHPIZ */
    public C1600A2 f1132aqHPIZ = new C1600A2();

    /* renamed from: uHVRx */
    public final AtomicInteger f1147uHVRx = new AtomicInteger();

    /* renamed from: JYn */
    public final ArrayList f1116JYn = new ArrayList();

    /* renamed from: androidx.fragment.app.Fragment$AZxh */
    public class C0088AZxh extends AbstractC3963jeHSg {
        public C0088AZxh() {
        }

        @Override // p131o.AbstractC3963jeHSg
        /* renamed from: AZxh */
        public boolean mo849AZxh() {
            return Fragment.this.f1140mByQ != null;
        }

        @Override // p131o.AbstractC3963jeHSg
        /* renamed from: mjFkc */
        public View mo850mjFkc(int i) {
            View view = Fragment.this.f1140mByQ;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$ZfxDd */
    public interface InterfaceC0089ZfxDd {
        /* renamed from: mjFkc */
        void mo851mjFkc();
    }

    /* renamed from: androidx.fragment.app.Fragment$mjFkc */
    public class RunnableC0090mjFkc implements Runnable {
        public RunnableC0090mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m811fLidf();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$wA */
    public static class C0091wA {

        /* renamed from: AZxh */
        public int f1158AZxh;

        /* renamed from: Dt */
        public Object f1159Dt;

        /* renamed from: ETF */
        public Object f1160ETF;

        /* renamed from: IEE */
        public View f1161IEE;

        /* renamed from: JHa */
        public int f1162JHa;

        /* renamed from: KLFTb */
        public int f1163KLFTb;

        /* renamed from: MiMN */
        public Object f1164MiMN;

        /* renamed from: Pq */
        public boolean f1165Pq;

        /* renamed from: VA */
        public Object f1166VA;

        /* renamed from: YoKzxo */
        public Object f1167YoKzxo;

        /* renamed from: ZfxDd */
        public int f1168ZfxDd;

        /* renamed from: diqgf */
        public InterfaceC0089ZfxDd f1169diqgf;

        /* renamed from: fehf */
        public float f1170fehf;

        /* renamed from: lgHUyS */
        public ArrayList f1171lgHUyS;

        /* renamed from: mjFkc */
        public boolean f1172mjFkc;

        /* renamed from: qGY */
        public Boolean f1173qGY;

        /* renamed from: qdMbNW */
        public Object f1174qdMbNW = null;

        /* renamed from: rkYL */
        public Boolean f1175rkYL;

        /* renamed from: wA */
        public int f1176wA;

        /* renamed from: xJ */
        public ArrayList f1177xJ;

        public C0091wA() {
            Object obj = Fragment.f1105JYgkl;
            this.f1159Dt = obj;
            this.f1160ETF = null;
            this.f1166VA = obj;
            this.f1164MiMN = null;
            this.f1167YoKzxo = obj;
            this.f1170fehf = 1.0f;
            this.f1161IEE = null;
        }
    }

    public Fragment() {
        m780NPj();
    }

    /* renamed from: ANMGZc */
    public void mo758ANMGZc() {
        this.f1138lB = true;
    }

    /* renamed from: BAnRFn */
    public int m759BAnRFn() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 0;
        }
        return c0091wA.f1168ZfxDd;
    }

    /* renamed from: CqaNbM */
    public Object m760CqaNbM() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        return c0091wA.f1164MiMN;
    }

    /* renamed from: Dp */
    public void m761Dp(Intent intent, int i, Bundle bundle) {
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* renamed from: Dt */
    public boolean m762Dt() {
        Boolean bool;
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null || (bool = c0091wA.f1173qGY) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: ETF */
    public boolean m763ETF() {
        Boolean bool;
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null || (bool = c0091wA.f1175rkYL) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: GMIER */
    public final boolean m764GMIER() {
        AbstractC0093KLFTb abstractC0093KLFTb = this.f1136fehf;
        if (abstractC0093KLFTb == null) {
            return false;
        }
        return abstractC0093KLFTb.m941xROA();
    }

    /* renamed from: Gd */
    public int m765Gd() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 0;
        }
        return c0091wA.f1162JHa;
    }

    /* renamed from: HGpJ */
    public final Fragment m766HGpJ() {
        return this.f1124Pq;
    }

    /* renamed from: IEE */
    public int m767IEE() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 0;
        }
        return c0091wA.f1176wA;
    }

    /* renamed from: IVlxe */
    public void m768IVlxe(Bundle bundle) {
        this.f1114IEE.m881NKyg();
        this.f1141mjFkc = 1;
        this.f1138lB = false;
        this.f1149vadzgd.mo1044mjFkc(new InterfaceC0104KLFTb() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.InterfaceC0104KLFTb
            /* renamed from: VA */
            public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
                View view;
                if (mjfkc != AbstractC0112wA.mjFkc.ON_STOP || (view = Fragment.this.f1140mByQ) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.f1119KRTLGT.m12746ZfxDd(bundle);
        mo772JYn(bundle);
        this.f1127Vnb = true;
        if (this.f1138lB) {
            this.f1149vadzgd.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_CREATE);
            return;
        }
        throw new C4527s7("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* renamed from: JBhc */
    public void m769JBhc(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f1138lB = true;
    }

    @Override // p131o.InterfaceC3068W0
    /* renamed from: JHa */
    public AbstractC0112wA mo770JHa() {
        return this.f1149vadzgd;
    }

    /* renamed from: JYgkl */
    public Animation m771JYgkl(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: JYn */
    public void mo772JYn(Bundle bundle) {
        this.f1138lB = true;
        m797XFUzSY(bundle);
        if (this.f1114IEE.m937vjlshU(1)) {
            return;
        }
        this.f1114IEE.m890Ucbh();
    }

    /* renamed from: JrJO */
    public Animator m773JrJO(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: KLMXS */
    public ArrayList m774KLMXS() {
        ArrayList arrayList;
        C0091wA c0091wA = this.f1108CqaNbM;
        return (c0091wA == null || (arrayList = c0091wA.f1177xJ) == null) ? new ArrayList() : arrayList;
    }

    /* renamed from: KRTLGT */
    public final boolean m775KRTLGT() {
        Fragment fragmentM766HGpJ = m766HGpJ();
        return fragmentM766HGpJ != null && (fragmentM766HGpJ.m795WrLQs() || fragmentM766HGpJ.m775KRTLGT());
    }

    /* renamed from: LREOK */
    public final AbstractActivityC2784RnaHj m776LREOK() {
        m829qdMbNW();
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    /* renamed from: MiMN */
    public final AbstractC0093KLFTb m777MiMN() {
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    /* renamed from: Moer */
    public void mo778Moer(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1114IEE.m881NKyg();
        this.f1146rkYL = true;
        this.f1142oCFDzJ = new C1680BEUaYa(this, mo841wA());
        View viewMo826nxI = mo826nxI(layoutInflater, viewGroup, bundle);
        this.f1140mByQ = viewMo826nxI;
        if (viewMo826nxI == null) {
            if (this.f1142oCFDzJ.m7691KLFTb()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f1142oCFDzJ = null;
        } else {
            this.f1142oCFDzJ.m7692ZfxDd();
            AbstractC4356pa.m13133mjFkc(this.f1140mByQ, this.f1142oCFDzJ);
            AbstractC4489ra.m13378mjFkc(this.f1140mByQ, this.f1142oCFDzJ);
            AbstractC4421qa.m13267mjFkc(this.f1140mByQ, this.f1142oCFDzJ);
            this.f1132aqHPIZ.mo1060lgHUyS(this.f1142oCFDzJ);
        }
    }

    /* renamed from: NKyg */
    public void m779NKyg() {
        this.f1114IEE.m935vI();
        if (this.f1140mByQ != null) {
            this.f1142oCFDzJ.m7690AZxh(AbstractC0112wA.mjFkc.ON_PAUSE);
        }
        this.f1149vadzgd.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_PAUSE);
        this.f1141mjFkc = 6;
        this.f1138lB = false;
        m790Vdz();
        if (this.f1138lB) {
            return;
        }
        throw new C4527s7("Fragment " + this + " did not call through to super.onPause()");
    }

    /* renamed from: NPj */
    public final void m780NPj() {
        this.f1149vadzgd = new C0103JHa(this);
        this.f1119KRTLGT = C4127m6.m12743mjFkc(this);
        this.f1129WrLQs = null;
    }

    /* renamed from: Ne */
    public Object m781Ne() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        Object obj = c0091wA.f1159Dt;
        return obj == f1105JYgkl ? m828qGY() : obj;
    }

    /* renamed from: OjSQV */
    public final Resources m782OjSQV() {
        return m810fFz().getResources();
    }

    /* renamed from: Pq */
    public Object m783Pq() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        return c0091wA.f1160ETF;
    }

    /* renamed from: Qr */
    public LayoutInflater m784Qr(Bundle bundle) {
        LayoutInflater layoutInflaterMo804bbzow = mo804bbzow(bundle);
        this.f1145rWxwaT = layoutInflaterMo804bbzow;
        return layoutInflaterMo804bbzow;
    }

    /* renamed from: SOS */
    public void m785SOS() {
        this.f1141mjFkc = -1;
        this.f1138lB = false;
        mo798XV();
        this.f1145rWxwaT = null;
        if (this.f1138lB) {
            if (this.f1114IEE.m905alEkx()) {
                return;
            }
            this.f1114IEE.m917huTpC();
            this.f1114IEE = new C2781RleMQT();
            return;
        }
        throw new C4527s7("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* renamed from: SmIWf */
    public void m786SmIWf() {
        this.f1114IEE.m867Gd();
        if (this.f1140mByQ != null && this.f1142oCFDzJ.mo770JHa().mo1035AZxh().m1098lgHUyS(AbstractC0112wA.AZxh.CREATED)) {
            this.f1142oCFDzJ.m7690AZxh(AbstractC0112wA.mjFkc.ON_DESTROY);
        }
        this.f1141mjFkc = 1;
        this.f1138lB = false;
        mo794WGXroI();
        if (this.f1138lB) {
            AbstractC3535d1.m11639mjFkc(this).mo11640AZxh();
            this.f1146rkYL = false;
        } else {
            throw new C4527s7("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* renamed from: SwgkN */
    public void m787SwgkN(boolean z) {
    }

    /* renamed from: Ucbh */
    public LayoutInflater m788Ucbh(Bundle bundle) {
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* renamed from: VA */
    public final Bundle m789VA() {
        return this.f1115JHa;
    }

    /* renamed from: Vdz */
    public void m790Vdz() {
        this.f1138lB = true;
    }

    /* renamed from: Vgyli */
    public void m791Vgyli(View view) {
        m822lgHUyS().f1161IEE = view;
    }

    /* renamed from: Vnb */
    public LiveData m792Vnb() {
        return this.f1132aqHPIZ;
    }

    /* renamed from: VocHEe */
    public boolean m793VocHEe() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return false;
        }
        return c0091wA.f1172mjFkc;
    }

    /* renamed from: WGXroI */
    public void mo794WGXroI() {
        this.f1138lB = true;
    }

    /* renamed from: WrLQs */
    public final boolean m795WrLQs() {
        return this.f1110ETF;
    }

    /* renamed from: XD */
    public void m796XD(float f) {
        m822lgHUyS().f1170fehf = f;
    }

    /* renamed from: XFUzSY */
    public void m797XFUzSY(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f1114IEE.m919jx(parcelable);
        this.f1114IEE.m890Ucbh();
    }

    /* renamed from: XV */
    public void mo798XV() {
        this.f1138lB = true;
    }

    /* renamed from: XbiWeM */
    public final View m799XbiWeM() {
        View viewM830rWxwaT = m830rWxwaT();
        if (viewM830rWxwaT != null) {
            return viewM830rWxwaT;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* renamed from: XtE */
    public final void m800XtE() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f1140mByQ != null) {
            m819jx(this.f1106AZxh);
        }
        this.f1106AZxh = null;
    }

    /* renamed from: YoKzxo */
    public Context m801YoKzxo() {
        return null;
    }

    /* renamed from: alEkx */
    public void mo802alEkx() {
        this.f1138lB = true;
    }

    /* renamed from: aqHPIZ */
    public boolean m803aqHPIZ() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return false;
        }
        return c0091wA.f1165Pq;
    }

    /* renamed from: bbzow */
    public LayoutInflater mo804bbzow(Bundle bundle) {
        return m788Ucbh(bundle);
    }

    /* renamed from: cMLeY */
    public final String m805cMLeY(int i) {
        return m782OjSQV().getString(i);
    }

    /* renamed from: diqgf */
    public AbstractC2414M6 m806diqgf() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        c0091wA.getClass();
        return null;
    }

    /* renamed from: dm */
    public void mo807dm() {
        this.f1138lB = true;
    }

    /* renamed from: equals */
    public final boolean m808equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: eyqo */
    public View m809eyqo() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        return c0091wA.f1161IEE;
    }

    /* renamed from: fFz */
    public final Context m810fFz() {
        Context contextM801YoKzxo = m801YoKzxo();
        if (contextM801YoKzxo != null) {
            return contextM801YoKzxo;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* renamed from: fLidf */
    public void m811fLidf() {
        if (this.f1108CqaNbM == null || !m822lgHUyS().f1165Pq) {
            return;
        }
        m822lgHUyS().f1165Pq = false;
    }

    /* renamed from: fehf */
    public AbstractC2414M6 m812fehf() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        c0091wA.getClass();
        return null;
    }

    /* renamed from: gYa */
    public void m813gYa() {
        m834tQ(this.f1140mByQ, this.f1106AZxh);
        this.f1114IEE.m884OjSQV();
    }

    /* renamed from: giT */
    public void m814giT(InterfaceC0089ZfxDd interfaceC0089ZfxDd) {
        m822lgHUyS();
        C0091wA c0091wA = this.f1108CqaNbM;
        InterfaceC0089ZfxDd interfaceC0089ZfxDd2 = c0091wA.f1169diqgf;
        if (interfaceC0089ZfxDd == interfaceC0089ZfxDd2) {
            return;
        }
        if (interfaceC0089ZfxDd != null && interfaceC0089ZfxDd2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (c0091wA.f1165Pq) {
            c0091wA.f1169diqgf = interfaceC0089ZfxDd;
        }
        if (interfaceC0089ZfxDd != null) {
            interfaceC0089ZfxDd.mo851mjFkc();
        }
    }

    /* renamed from: gtIJp */
    public void m815gtIJp() {
        boolean zM944yfx = this.f1136fehf.m944yfx(this);
        Boolean bool = this.f1144qdMbNW;
        if (bool == null || bool.booleanValue() != zM944yfx) {
            this.f1144qdMbNW = Boolean.valueOf(zM944yfx);
            m818jm(zM944yfx);
            this.f1114IEE.m895VocHEe();
        }
    }

    /* renamed from: gtr */
    public void m816gtr(ArrayList arrayList, ArrayList arrayList2) {
        m822lgHUyS();
        C0091wA c0091wA = this.f1108CqaNbM;
        c0091wA.f1177xJ = arrayList;
        c0091wA.f1171lgHUyS = arrayList2;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* renamed from: huTpC */
    public final int m817huTpC() {
        AbstractC0112wA.AZxh aZxh = this.f1121NPj;
        return (aZxh == AbstractC0112wA.AZxh.INITIALIZED || this.f1124Pq == null) ? aZxh.ordinal() : Math.min(aZxh.ordinal(), this.f1124Pq.m817huTpC());
    }

    /* renamed from: jm */
    public void m818jm(boolean z) {
    }

    /* renamed from: jx */
    public final void m819jx(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f1150wA;
        if (sparseArray != null) {
            this.f1140mByQ.restoreHierarchyState(sparseArray);
            this.f1150wA = null;
        }
        if (this.f1140mByQ != null) {
            this.f1142oCFDzJ.m7694xJ(this.f1131ZfxDd);
            this.f1131ZfxDd = null;
        }
        this.f1138lB = false;
        mo847yfx(bundle);
        if (this.f1138lB) {
            if (this.f1140mByQ != null) {
                this.f1142oCFDzJ.m7690AZxh(AbstractC0112wA.mjFkc.ON_CREATE);
            }
        } else {
            throw new C4527s7("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* renamed from: kism */
    public void m820kism() {
        this.f1114IEE.m881NKyg();
        this.f1114IEE.m945zvd(true);
        this.f1141mjFkc = 7;
        this.f1138lB = false;
        mo758ANMGZc();
        if (!this.f1138lB) {
            throw new C4527s7("Fragment " + this + " did not call through to super.onResume()");
        }
        C0103JHa c0103JHa = this.f1149vadzgd;
        AbstractC0112wA.mjFkc mjfkc = AbstractC0112wA.mjFkc.ON_RESUME;
        c0103JHa.m1043lgHUyS(mjfkc);
        if (this.f1140mByQ != null) {
            this.f1142oCFDzJ.m7690AZxh(mjfkc);
        }
        this.f1114IEE.m862BAnRFn();
    }

    /* renamed from: lB */
    public int m821lB() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 0;
        }
        return c0091wA.f1163KLFTb;
    }

    /* renamed from: lgHUyS */
    public final C0091wA m822lgHUyS() {
        if (this.f1108CqaNbM == null) {
            this.f1108CqaNbM = new C0091wA();
        }
        return this.f1108CqaNbM;
    }

    /* renamed from: lti */
    public void m823lti(int i) {
        if (this.f1108CqaNbM == null && i == 0) {
            return;
        }
        m822lgHUyS();
        this.f1108CqaNbM.f1162JHa = i;
    }

    /* renamed from: mByQ */
    public Object m824mByQ() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        Object obj = c0091wA.f1166VA;
        return obj == f1105JYgkl ? m783Pq() : obj;
    }

    @Override // p131o.InterfaceC4193n6
    /* renamed from: mjFkc */
    public final C0184mjFkc mo825mjFkc() {
        return this.f1119KRTLGT.m12744AZxh();
    }

    /* renamed from: nxI */
    public View mo826nxI(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.f1111GMIER;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    /* renamed from: oCFDzJ */
    public final boolean m827oCFDzJ() {
        return this.f1143qGY > 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f1138lB = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m776LREOK();
        throw null;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f1138lB = true;
    }

    /* renamed from: qGY */
    public Object m828qGY() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        return c0091wA.f1174qdMbNW;
    }

    /* renamed from: qdMbNW */
    public final AbstractActivityC2784RnaHj m829qdMbNW() {
        return null;
    }

    /* renamed from: rWxwaT */
    public View m830rWxwaT() {
        return this.f1140mByQ;
    }

    /* renamed from: rkYL */
    public int m831rkYL() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 0;
        }
        return c0091wA.f1158AZxh;
    }

    /* renamed from: sRqPfw */
    public void m832sRqPfw(boolean z) {
        if (this.f1108CqaNbM == null) {
            return;
        }
        m822lgHUyS().f1172mjFkc = z;
    }

    public void startActivityForResult(Intent intent, int i) {
        m761Dp(intent, i, null);
    }

    /* renamed from: tISON */
    public void m833tISON(Bundle bundle) {
        if (this.f1136fehf != null && m764GMIER()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f1115JHa = bundle;
    }

    /* renamed from: tQ */
    public void m834tQ(View view, Bundle bundle) {
    }

    /* renamed from: tjSezt */
    public void m835tjSezt() {
        this.f1114IEE.m881NKyg();
        this.f1114IEE.m945zvd(true);
        this.f1141mjFkc = 5;
        this.f1138lB = false;
        mo802alEkx();
        if (!this.f1138lB) {
            throw new C4527s7("Fragment " + this + " did not call through to super.onStart()");
        }
        C0103JHa c0103JHa = this.f1149vadzgd;
        AbstractC0112wA.mjFkc mjfkc = AbstractC0112wA.mjFkc.ON_START;
        c0103JHa.m1043lgHUyS(mjfkc);
        if (this.f1140mByQ != null) {
            this.f1142oCFDzJ.m7690AZxh(mjfkc);
        }
        this.f1114IEE.m921lB();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1117KLFTb);
        if (this.f1134diqgf != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1134diqgf));
        }
        if (this.f1125Ucbh != null) {
            sb.append(" tag=");
            sb.append(this.f1125Ucbh);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: uH */
    public void m836uH(int i, int i2, int i3, int i4) {
        if (this.f1108CqaNbM == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        m822lgHUyS().f1158AZxh = i;
        m822lgHUyS().f1176wA = i2;
        m822lgHUyS().f1168ZfxDd = i3;
        m822lgHUyS().f1163KLFTb = i4;
    }

    /* renamed from: uHVRx */
    public void m837uHVRx(Bundle bundle) {
        this.f1138lB = true;
    }

    /* renamed from: vI */
    public final AbstractC0093KLFTb m838vI() {
        AbstractC0093KLFTb abstractC0093KLFTb = this.f1136fehf;
        if (abstractC0093KLFTb != null) {
            return abstractC0093KLFTb;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* renamed from: vadzgd */
    public void m839vadzgd() {
        m780NPj();
        this.f1117KLFTb = UUID.randomUUID().toString();
        this.f1109Dt = false;
        this.f1110ETF = false;
        this.f1126VA = false;
        this.f1120MiMN = false;
        this.f1130YoKzxo = false;
        this.f1143qGY = 0;
        this.f1136fehf = null;
        this.f1114IEE = new C2781RleMQT();
        this.f1134diqgf = 0;
        this.f1135eyqo = 0;
        this.f1125Ucbh = null;
        this.f1137huTpC = false;
        this.f1112Gd = false;
    }

    /* renamed from: vjlshU */
    public void m840vjlshU(Bundle bundle) {
        this.f1114IEE.m881NKyg();
        this.f1141mjFkc = 3;
        this.f1138lB = false;
        m837uHVRx(bundle);
        if (this.f1138lB) {
            m800XtE();
            this.f1114IEE.m910eyqo();
        } else {
            throw new C4527s7("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    @Override // p131o.InterfaceC3958ja
    /* renamed from: wA */
    public C3893ia mo841wA() {
        if (this.f1136fehf == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m817huTpC() != AbstractC0112wA.AZxh.INITIALIZED.ordinal()) {
            return this.f1136fehf.m892Vdz(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    /* renamed from: wJVbdd */
    public float m842wJVbdd() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return 1.0f;
        }
        return c0091wA.f1170fehf;
    }

    /* renamed from: xJ */
    public AbstractC3963jeHSg mo843xJ() {
        return new C0088AZxh();
    }

    /* renamed from: xROA */
    public void m844xROA() {
        Iterator it = this.f1116JYn.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
        this.f1116JYn.clear();
        this.f1114IEE.m922lgHUyS(null, mo843xJ(), this);
        this.f1141mjFkc = 0;
        this.f1138lB = false;
        throw null;
    }

    /* renamed from: xrEuO */
    public Object m845xrEuO() {
        C0091wA c0091wA = this.f1108CqaNbM;
        if (c0091wA == null) {
            return null;
        }
        Object obj = c0091wA.f1167YoKzxo;
        return obj == f1105JYgkl ? m760CqaNbM() : obj;
    }

    /* renamed from: yX */
    public void m846yX() {
        this.f1114IEE.m924mByQ();
        if (this.f1140mByQ != null) {
            this.f1142oCFDzJ.m7690AZxh(AbstractC0112wA.mjFkc.ON_STOP);
        }
        this.f1149vadzgd.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_STOP);
        this.f1141mjFkc = 4;
        this.f1138lB = false;
        mo807dm();
        if (this.f1138lB) {
            return;
        }
        throw new C4527s7("Fragment " + this + " did not call through to super.onStop()");
    }

    /* renamed from: yfx */
    public void mo847yfx(Bundle bundle) {
        this.f1138lB = true;
    }

    /* renamed from: zvd */
    public ArrayList m848zvd() {
        ArrayList arrayList;
        C0091wA c0091wA = this.f1108CqaNbM;
        return (c0091wA == null || (arrayList = c0091wA.f1171lgHUyS) == null) ? new ArrayList() : arrayList;
    }
}
