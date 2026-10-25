package p131o;

import android.content.Context;

/* renamed from: o.MQ */
/* loaded from: classes.dex */
public final class C2437MQ implements InterfaceC4085lQ {

    /* renamed from: AZxh */
    public final InterfaceC3339a4 f9578AZxh;

    /* renamed from: mjFkc */
    public InterfaceC3339a4 f9579mjFkc;

    /* renamed from: wA */
    public final AbstractC4348pQ f9580wA;

    public C2437MQ(Context context, AbstractC4348pQ abstractC4348pQ) {
        this.f9580wA = abstractC4348pQ;
        C4288oaI c4288oaI = C4288oaI.f15764xJ;
        C3543d9.m11710JHa(context);
        final InterfaceC3210Y8 interfaceC3210Y8M11715xJ = C3543d9.m11712wA().m11715xJ(c4288oaI);
        if (c4288oaI.mo12982mjFkc().contains(C3569dXmy.m11728AZxh("json"))) {
            this.f9579mjFkc = new C2541O0(new InterfaceC3339a4() { // from class: o.GQ
                @Override // p131o.InterfaceC3339a4
                /* renamed from: get */
                public final Object mo8427get() {
                    return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("json"), new InterfaceC2416M8() { // from class: o.KQ
                        @Override // p131o.InterfaceC2416M8
                        /* renamed from: apply */
                        public final Object mo8122apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f9578AZxh = new C2541O0(new InterfaceC3339a4() { // from class: o.IQ
            @Override // p131o.InterfaceC3339a4
            /* renamed from: get */
            public final Object mo8427get() {
                return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("proto"), new InterfaceC2416M8() { // from class: o.EQ
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
    public static AbstractC4697uhQ m9506AZxh(AbstractC4348pQ abstractC4348pQ, InterfaceC3949jQ interfaceC3949jQ) {
        return AbstractC4697uhQ.m13721KLFTb(interfaceC3949jQ.mo7833wA(abstractC4348pQ.mo12220mjFkc(), false));
    }

    @Override // p131o.InterfaceC4085lQ
    /* renamed from: mjFkc */
    public final void mo9507mjFkc(InterfaceC3949jQ interfaceC3949jQ) {
        if (this.f9580wA.mo12220mjFkc() != 0) {
            ((InterfaceC3009V8) this.f9578AZxh.mo8427get()).mo10679mjFkc(m9506AZxh(this.f9580wA, interfaceC3949jQ));
            return;
        }
        InterfaceC3339a4 interfaceC3339a4 = this.f9579mjFkc;
        if (interfaceC3339a4 != null) {
            ((InterfaceC3009V8) interfaceC3339a4.mo8427get()).mo10679mjFkc(m9506AZxh(this.f9580wA, interfaceC3949jQ));
        }
    }
}
