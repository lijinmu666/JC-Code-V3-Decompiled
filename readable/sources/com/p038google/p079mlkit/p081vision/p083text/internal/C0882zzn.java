package com.p038google.p079mlkit.p081vision.p083text.internal;

import com.p038google.p079mlkit.p081vision.p082common.internal.MobileVisionBase;
import java.util.concurrent.Executor;
import p131o.AbstractC1670B7;
import p131o.AbstractC3477c8;
import p131o.AbstractC4188n1;
import p131o.C2605P;
import p131o.C2987UokA;
import p131o.C3697fW;
import p131o.C3866i8;
import p131o.C3892iW;
import p131o.C4153mU;
import p131o.C4215nS;
import p131o.C4887xU;
import p131o.EnumC4020kS;
import p131o.EnumC4151mS;
import p131o.InterfaceC3606e8;
import p131o.InterfaceC3735g8;

/* renamed from: com.google.mlkit.vision.text.internal.zzn */
/* loaded from: classes.dex */
public final class C0882zzn extends MobileVisionBase implements InterfaceC3606e8 {

    /* renamed from: xJ */
    public final InterfaceC3735g8 f4034xJ;

    public C0882zzn(C3866i8 c3866i8, Executor executor, C3697fW c3697fW, InterfaceC3735g8 interfaceC3735g8) {
        super(c3866i8, executor);
        this.f4034xJ = interfaceC3735g8;
        C4215nS c4215nS = new C4215nS();
        c4215nS.m12876KLFTb(interfaceC3735g8.mo11887JHa() ? EnumC4020kS.TYPE_THICK : EnumC4020kS.TYPE_THIN);
        C4153mU c4153mU = new C4153mU();
        C4887xU c4887xU = new C4887xU();
        c4887xU.m13944mjFkc(AbstractC4188n1.m12838mjFkc(interfaceC3735g8.mo11891lgHUyS()));
        c4153mU.m12769KLFTb(c4887xU.m13945wA());
        c4215nS.m12878lgHUyS(c4153mU.m12768JHa());
        c3697fW.m11954ZfxDd(C3892iW.m12298JHa(c4215nS, 1), EnumC4151mS.ON_DEVICE_TEXT_CREATE);
    }

    @Override // p131o.InterfaceC3923j3
    /* renamed from: ZfxDd */
    public final C2987UokA[] mo4301ZfxDd() {
        return AbstractC3477c8.m11606mjFkc(this.f4034xJ);
    }

    @Override // p131o.InterfaceC3606e8
    /* renamed from: qGY */
    public final AbstractC1670B7 mo4302qGY(C2605P c2605p) {
        return super.m4299Pq(c2605p);
    }
}
