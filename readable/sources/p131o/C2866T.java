package p131o;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import p131o.C2514Na;
import p131o.C3372ab;

/* renamed from: o.T */
/* loaded from: classes.dex */
public class C2866T extends C2514Na.AZxh {

    /* renamed from: JHa */
    public final int[] f10633JHa;

    /* renamed from: KLFTb */
    public int f10634KLFTb;

    /* renamed from: ZfxDd */
    public int f10635ZfxDd;

    /* renamed from: wA */
    public final View f10636wA;

    public C2866T(View view) {
        super(0);
        this.f10633JHa = new int[2];
        this.f10636wA = view;
    }

    @Override // p131o.C2514Na.AZxh
    /* renamed from: AZxh */
    public void mo9697AZxh(C2514Na c2514Na) {
        this.f10636wA.setTranslationY(0.0f);
    }

    @Override // p131o.C2514Na.AZxh
    /* renamed from: KLFTb */
    public C2514Na.mjFkc mo9698KLFTb(C2514Na c2514Na, C2514Na.mjFkc mjfkc) {
        this.f10636wA.getLocationOnScreen(this.f10633JHa);
        int i = this.f10635ZfxDd - this.f10633JHa[1];
        this.f10634KLFTb = i;
        this.f10636wA.setTranslationY(i);
        return mjfkc;
    }

    @Override // p131o.C2514Na.AZxh
    /* renamed from: ZfxDd */
    public C3372ab mo9699ZfxDd(C3372ab c3372ab, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((C2514Na) it.next()).m9696wA() & C3372ab.VA.m11389mjFkc()) != 0) {
                this.f10636wA.setTranslationY(AbstractC2506NPj.m9657wA(this.f10634KLFTb, 0, r0.m9693AZxh()));
                break;
            }
        }
        return c3372ab;
    }

    @Override // p131o.C2514Na.AZxh
    /* renamed from: wA */
    public void mo9701wA(C2514Na c2514Na) {
        this.f10636wA.getLocationOnScreen(this.f10633JHa);
        this.f10635ZfxDd = this.f10633JHa[1];
    }
}
