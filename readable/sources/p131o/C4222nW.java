package p131o;

import android.content.Context;

/* renamed from: o.nW */
/* loaded from: classes.dex */
public final class C4222nW implements InterfaceC2574OV {

    /* renamed from: AZxh */
    public final InterfaceC3339a4 f15424AZxh;

    /* renamed from: mjFkc */
    public InterfaceC3339a4 f15425mjFkc;

    /* renamed from: wA */
    public final AbstractC2700QV f15426wA;

    public C4222nW(Context context, AbstractC2700QV abstractC2700QV) {
        this.f15426wA = abstractC2700QV;
        C4288oaI c4288oaI = C4288oaI.f15764xJ;
        C3543d9.m11710JHa(context);
        final InterfaceC3210Y8 interfaceC3210Y8M11715xJ = C3543d9.m11712wA().m11715xJ(c4288oaI);
        if (c4288oaI.mo12982mjFkc().contains(C3569dXmy.m11728AZxh("json"))) {
            this.f15425mjFkc = new C2541O0(new InterfaceC3339a4() { // from class: o.kW
                @Override // p131o.InterfaceC3339a4
                /* renamed from: get */
                public final Object mo8427get() {
                    return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("json"), new InterfaceC2416M8() { // from class: o.mW
                        @Override // p131o.InterfaceC2416M8
                        /* renamed from: apply */
                        public final Object mo8122apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f15424AZxh = new C2541O0(new InterfaceC3339a4() { // from class: o.lW
            @Override // p131o.InterfaceC3339a4
            /* renamed from: get */
            public final Object mo8427get() {
                return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("proto"), new InterfaceC2416M8() { // from class: o.jW
                    @Override // p131o.InterfaceC2416M8
                    /* renamed from: apply */
                    public final Object mo8122apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    /* renamed from: AZxh */
    public static AbstractC4697uhQ m12893AZxh(AbstractC2700QV abstractC2700QV, InterfaceC2443MV interfaceC2443MV) {
        int iMo9368mjFkc = abstractC2700QV.mo9368mjFkc();
        return interfaceC2443MV.mo9517zza() != 0 ? AbstractC4697uhQ.m13722ZfxDd(interfaceC2443MV.mo9515mjFkc(iMo9368mjFkc, false)) : AbstractC4697uhQ.m13721KLFTb(interfaceC2443MV.mo9515mjFkc(iMo9368mjFkc, false));
    }

    @Override // p131o.InterfaceC2574OV
    /* renamed from: mjFkc */
    public final void mo9900mjFkc(InterfaceC2443MV interfaceC2443MV) {
        if (this.f15426wA.mo9368mjFkc() != 0) {
            ((InterfaceC3009V8) this.f15424AZxh.mo8427get()).mo10679mjFkc(m12893AZxh(this.f15426wA, interfaceC2443MV));
            return;
        }
        InterfaceC3339a4 interfaceC3339a4 = this.f15425mjFkc;
        if (interfaceC3339a4 != null) {
            ((InterfaceC3009V8) interfaceC3339a4.mo8427get()).mo10679mjFkc(m12893AZxh(this.f15426wA, interfaceC2443MV));
        }
    }
}
