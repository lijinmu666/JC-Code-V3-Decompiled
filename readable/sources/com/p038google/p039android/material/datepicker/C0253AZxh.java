package com.p038google.p039android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.p023widget.C0123Dt;
import androidx.recyclerview.p023widget.GridLayoutManager;
import androidx.recyclerview.p023widget.LinearLayoutManager;
import androidx.recyclerview.p023widget.RecyclerView;
import com.p038google.p039android.material.p058button.MaterialButton;
import java.util.Calendar;
import p131o.AbstractC1803D4;
import p131o.AbstractC1870E9;
import p131o.AbstractC1934F4;
import p131o.AbstractC2007G4;
import p131o.AbstractC2481N4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3138X6;
import p131o.AbstractC3601e3;
import p131o.AbstractC4191n4;
import p131o.AbstractC4567sjsh;
import p131o.AbstractC4789w3;
import p131o.AbstractC4793w7;
import p131o.C1834Db;
import p131o.C2409M1;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;
import p131o.C3167XVrPFt;
import p131o.C4656u2;
import p131o.C4715uxlM;
import p131o.InterfaceC2981UlIi;

/* renamed from: com.google.android.material.datepicker.AZxh */
/* loaded from: classes.dex */
public final class C0253AZxh<S> extends AbstractC4789w3 {

    /* renamed from: ANMGZc */
    public View f2613ANMGZc;

    /* renamed from: JBhc */
    public RecyclerView f2614JBhc;

    /* renamed from: SwgkN */
    public C4715uxlM f2615SwgkN;

    /* renamed from: Vdz */
    public RecyclerView f2616Vdz;

    /* renamed from: WGXroI */
    public C0256mjFkc f2617WGXroI;

    /* renamed from: XV */
    public C4656u2 f2618XV;

    /* renamed from: alEkx */
    public View f2619alEkx;

    /* renamed from: bbzow */
    public VA f2620bbzow;

    /* renamed from: dm */
    public View f2621dm;

    /* renamed from: jm */
    public View f2622jm;

    /* renamed from: nxI */
    public int f2623nxI;

    /* renamed from: tQ */
    public static final Object f2609tQ = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: yfx */
    public static final Object f2612yfx = "NAVIGATION_PREV_TAG";

    /* renamed from: vjlshU */
    public static final Object f2610vjlshU = "NAVIGATION_NEXT_TAG";

    /* renamed from: xROA */
    public static final Object f2611xROA = "SELECTOR_TOGGLE_TAG";

    /* renamed from: com.google.android.material.datepicker.AZxh$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ int f2625mjFkc;

        public AZxh(int i) {
            this.f2625mjFkc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0253AZxh.this.f2616Vdz.m1467VfB(this.f2625mjFkc);
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$Dt */
    public class Dt implements View.OnClickListener {
        public Dt() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0253AZxh.this.m2894IvRQOa();
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$ETF */
    public class ETF implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ C0255ZfxDd f2628mjFkc;

        public ETF(C0255ZfxDd c0255ZfxDd) {
            this.f2628mjFkc = c0255ZfxDd;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iM1364zPp = C0253AZxh.this.m2897Jk().m1364zPp() + 1;
            if (iM1364zPp < C0253AZxh.this.f2616Vdz.getAdapter().mo1665ZfxDd()) {
                C0253AZxh.this.m2901dkKKW(this.f2628mjFkc.m2914Ucbh(iM1364zPp));
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$JHa */
    public class JHa extends C2454MiMN {
        public JHa() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10584kism(false);
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$KLFTb */
    public class KLFTb implements MiMN {
        public KLFTb() {
        }

        @Override // com.p038google.p039android.material.datepicker.C0253AZxh.MiMN
        /* renamed from: mjFkc */
        public void mo2906mjFkc(long j) {
            C0253AZxh.this.f2617WGXroI.m2922mjFkc();
            throw null;
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$MiMN */
    public interface MiMN {
        /* renamed from: mjFkc */
        void mo2906mjFkc(long j);
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$VA */
    public enum VA {
        DAY,
        YEAR
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$ZfxDd */
    public class ZfxDd extends AbstractC3138X6 {

        /* renamed from: xrEuO */
        public final /* synthetic */ int f2635xrEuO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZfxDd(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.f2635xrEuO = i2;
        }

        @Override // androidx.recyclerview.p023widget.LinearLayoutManager
        /* renamed from: JOe */
        public void mo1317JOe(RecyclerView.C0148VocHEe c0148VocHEe, int[] iArr) {
            if (this.f2635xrEuO == 0) {
                iArr[0] = C0253AZxh.this.f2616Vdz.getWidth();
                iArr[1] = C0253AZxh.this.f2616Vdz.getWidth();
            } else {
                iArr[0] = C0253AZxh.this.f2616Vdz.getHeight();
                iArr[1] = C0253AZxh.this.f2616Vdz.getHeight();
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$lgHUyS */
    public class lgHUyS extends C2454MiMN {
        public lgHUyS() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10602xROA(C0253AZxh.this.f2621dm.getVisibility() == 0 ? C0253AZxh.this.m805cMLeY(AbstractC2481N4.f9638IEE) : C0253AZxh.this.m805cMLeY(AbstractC2481N4.f9650qGY));
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$mjFkc */
    public class mjFkc implements View.OnClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ C0255ZfxDd f2638mjFkc;

        public mjFkc(C0255ZfxDd c0255ZfxDd) {
            this.f2638mjFkc = c0255ZfxDd;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iM1340aDq = C0253AZxh.this.m2897Jk().m1340aDq() - 1;
            if (iM1340aDq >= 0) {
                C0253AZxh.this.m2901dkKKW(this.f2638mjFkc.m2914Ucbh(iM1340aDq));
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$qdMbNW */
    public class qdMbNW extends RecyclerView.AbstractC0151diqgf {

        /* renamed from: AZxh */
        public final /* synthetic */ MaterialButton f2639AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ C0255ZfxDd f2640mjFkc;

        public qdMbNW(C0255ZfxDd c0255ZfxDd, MaterialButton materialButton) {
            this.f2640mjFkc = c0255ZfxDd;
            this.f2639AZxh = materialButton;
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0151diqgf
        /* renamed from: AZxh */
        public void mo1635AZxh(RecyclerView recyclerView, int i, int i2) {
            int iM1364zPp = i < 0 ? C0253AZxh.this.m2897Jk().m1364zPp() : C0253AZxh.this.m2897Jk().m1340aDq();
            C0253AZxh.this.f2618XV = this.f2640mjFkc.m2914Ucbh(iM1364zPp);
            this.f2639AZxh.setText(this.f2640mjFkc.m2915huTpC(iM1364zPp));
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0151diqgf
        /* renamed from: mjFkc */
        public void mo1636mjFkc(RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.f2639AZxh.getText());
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$wA */
    public class wA extends C2454MiMN {
        public wA() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10540JBhc(null);
        }
    }

    /* renamed from: com.google.android.material.datepicker.AZxh$xJ */
    public class xJ extends RecyclerView.AbstractC0161rkYL {

        /* renamed from: mjFkc */
        public final Calendar f2644mjFkc = AbstractC1870E9.m8116lgHUyS();

        /* renamed from: AZxh */
        public final Calendar f2643AZxh = AbstractC1870E9.m8116lgHUyS();

        public xJ() {
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0161rkYL
        /* renamed from: xJ */
        public void mo1829xJ(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe) {
            if ((recyclerView.getAdapter() instanceof C1834Db) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                C0253AZxh.m2889XDdeP(C0253AZxh.this);
                throw null;
            }
        }
    }

    /* renamed from: KRckQg */
    public static C0253AZxh m2887KRckQg(InterfaceC2981UlIi interfaceC2981UlIi, int i, C0256mjFkc c0256mjFkc, AbstractC4567sjsh abstractC4567sjsh) {
        C0253AZxh c0253AZxh = new C0253AZxh();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", interfaceC2981UlIi);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0256mjFkc);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", abstractC4567sjsh);
        bundle.putParcelable("CURRENT_MONTH_KEY", c0256mjFkc.m2918JHa());
        c0253AZxh.m833tISON(bundle);
        return c0253AZxh;
    }

    /* renamed from: XDdeP */
    public static /* synthetic */ InterfaceC2981UlIi m2889XDdeP(C0253AZxh c0253AZxh) {
        c0253AZxh.getClass();
        return null;
    }

    /* renamed from: Xxz */
    public static int m2890Xxz(Context context) {
        return context.getResources().getDimensionPixelSize(AbstractC4191n4.f15335lB);
    }

    /* renamed from: Zdbk */
    public static int m2891Zdbk(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(AbstractC4191n4.f15316KLMXS) + resources.getDimensionPixelOffset(AbstractC4191n4.f15350zvd) + resources.getDimensionPixelOffset(AbstractC4191n4.f15349xrEuO);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(AbstractC4191n4.f15337mByQ);
        int i = C0257wA.f2664KLFTb;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(AbstractC4191n4.f15335lB) * i) + ((i - 1) * resources.getDimensionPixelOffset(AbstractC4191n4.f15308CqaNbM)) + resources.getDimensionPixelOffset(AbstractC4191n4.f15325VocHEe);
    }

    /* renamed from: IvRQOa */
    public void m2894IvRQOa() {
        VA va = this.f2620bbzow;
        VA va2 = VA.YEAR;
        if (va == va2) {
            m2898NV(VA.DAY);
        } else if (va == VA.DAY) {
            m2898NV(va2);
        }
    }

    /* renamed from: IyS */
    public C0256mjFkc m2895IyS() {
        return this.f2617WGXroI;
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: JYn */
    public void mo772JYn(Bundle bundle) {
        super.mo772JYn(bundle);
        if (bundle == null) {
            bundle = m789VA();
        }
        this.f2623nxI = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC4793w7.m13819mjFkc(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f2617WGXroI = (C0256mjFkc) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        AbstractC4793w7.m13819mjFkc(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f2618XV = (C4656u2) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* renamed from: Jidt */
    public final void m2896Jidt() {
        AbstractC2876T9.m10265alEkx(this.f2616Vdz, new JHa());
    }

    /* renamed from: Jk */
    public LinearLayoutManager m2897Jk() {
        return (LinearLayoutManager) this.f2616Vdz.getLayoutManager();
    }

    /* renamed from: NV */
    public void m2898NV(VA va) {
        this.f2620bbzow = va;
        if (va == VA.YEAR) {
            this.f2614JBhc.getLayoutManager().mo1331Tw(((C1834Db) this.f2614JBhc.getAdapter()).m8037eyqo(this.f2618XV.f16769wA));
            this.f2619alEkx.setVisibility(0);
            this.f2621dm.setVisibility(8);
            this.f2622jm.setVisibility(8);
            this.f2613ANMGZc.setVisibility(8);
            return;
        }
        if (va == VA.DAY) {
            this.f2619alEkx.setVisibility(8);
            this.f2621dm.setVisibility(0);
            this.f2622jm.setVisibility(0);
            this.f2613ANMGZc.setVisibility(0);
            m2901dkKKW(this.f2618XV);
        }
    }

    /* renamed from: XgAT */
    public final RecyclerView.AbstractC0161rkYL m2899XgAT() {
        return new xJ();
    }

    /* renamed from: dGDT */
    public InterfaceC2981UlIi m2900dGDT() {
        return null;
    }

    /* renamed from: dkKKW */
    public void m2901dkKKW(C4656u2 c4656u2) {
        C0255ZfxDd c0255ZfxDd = (C0255ZfxDd) this.f2616Vdz.getAdapter();
        int iM2912Gd = c0255ZfxDd.m2912Gd(c4656u2);
        int iM2912Gd2 = iM2912Gd - c0255ZfxDd.m2912Gd(this.f2618XV);
        boolean z = Math.abs(iM2912Gd2) > 3;
        boolean z2 = iM2912Gd2 > 0;
        this.f2618XV = c4656u2;
        if (z && z2) {
            this.f2616Vdz.m1516oaI(iM2912Gd - 3);
            m2904mPWV(iM2912Gd);
        } else if (!z) {
            m2904mPWV(iM2912Gd);
        } else {
            this.f2616Vdz.m1516oaI(iM2912Gd + 3);
            m2904mPWV(iM2912Gd);
        }
    }

    @Override // p131o.AbstractC4789w3
    /* renamed from: hvGY */
    public boolean mo2902hvGY(AbstractC3601e3 abstractC3601e3) {
        return super.mo2902hvGY(abstractC3601e3);
    }

    /* renamed from: jtz */
    public final void m2903jtz(View view, C0255ZfxDd c0255ZfxDd) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(AbstractC1803D4.f7817qGY);
        materialButton.setTag(f2611xROA);
        AbstractC2876T9.m10265alEkx(materialButton, new lgHUyS());
        View viewFindViewById = view.findViewById(AbstractC1803D4.f7794IEE);
        this.f2622jm = viewFindViewById;
        viewFindViewById.setTag(f2612yfx);
        View viewFindViewById2 = view.findViewById(AbstractC1803D4.f7811fehf);
        this.f2613ANMGZc = viewFindViewById2;
        viewFindViewById2.setTag(f2610vjlshU);
        this.f2619alEkx = view.findViewById(AbstractC1803D4.f7793HGpJ);
        this.f2621dm = view.findViewById(AbstractC1803D4.f7809diqgf);
        m2898NV(VA.DAY);
        materialButton.setText(this.f2618XV.m13676rkYL());
        this.f2616Vdz.m1465VA(new qdMbNW(c0255ZfxDd, materialButton));
        materialButton.setOnClickListener(new Dt());
        this.f2613ANMGZc.setOnClickListener(new ETF(c0255ZfxDd));
        this.f2622jm.setOnClickListener(new mjFkc(c0255ZfxDd));
    }

    /* renamed from: mPWV */
    public final void m2904mPWV(int i) {
        this.f2616Vdz.post(new AZxh(i));
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: nxI */
    public View mo826nxI(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(m801YoKzxo(), this.f2623nxI);
        this.f2615SwgkN = new C4715uxlM(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        C4656u2 c4656u2M2924xJ = this.f2617WGXroI.m2924xJ();
        if (C2409M1.m9416ybBTr(contextThemeWrapper)) {
            i = AbstractC2007G4.f8324qGY;
            i2 = 1;
        } else {
            i = AbstractC2007G4.f8317YoKzxo;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        viewInflate.setMinimumHeight(m2891Zdbk(m810fFz()));
        GridView gridView = (GridView) viewInflate.findViewById(AbstractC1803D4.f7810eyqo);
        AbstractC2876T9.m10265alEkx(gridView, new wA());
        int iM2923wA = this.f2617WGXroI.m2923wA();
        gridView.setAdapter((ListAdapter) (iM2923wA > 0 ? new C3167XVrPFt(iM2923wA) : new C3167XVrPFt()));
        gridView.setNumColumns(c4656u2M2924xJ.f16767ZfxDd);
        gridView.setEnabled(false);
        this.f2616Vdz = (RecyclerView) viewInflate.findViewById(AbstractC1803D4.f7792Gd);
        this.f2616Vdz.setLayoutManager(new ZfxDd(m801YoKzxo(), i2, false, i2));
        this.f2616Vdz.setTag(f2609tQ);
        C0255ZfxDd c0255ZfxDd = new C0255ZfxDd(contextThemeWrapper, null, this.f2617WGXroI, null, new KLFTb());
        this.f2616Vdz.setAdapter(c0255ZfxDd);
        int integer = contextThemeWrapper.getResources().getInteger(AbstractC1934F4.f8121mjFkc);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(AbstractC1803D4.f7793HGpJ);
        this.f2614JBhc = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f2614JBhc.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f2614JBhc.setAdapter(new C1834Db(this));
            this.f2614JBhc.m1518qdMbNW(m2899XgAT());
        }
        if (viewInflate.findViewById(AbstractC1803D4.f7817qGY) != null) {
            m2903jtz(viewInflate, c0255ZfxDd);
        }
        if (!C2409M1.m9416ybBTr(contextThemeWrapper)) {
            new C0123Dt().m1968AZxh(this.f2616Vdz);
        }
        this.f2616Vdz.m1516oaI(c0255ZfxDd.m2912Gd(this.f2618XV));
        m2896Jidt();
        return viewInflate;
    }

    /* renamed from: tAfC */
    public C4715uxlM m2905tAfC() {
        return this.f2615SwgkN;
    }
}
