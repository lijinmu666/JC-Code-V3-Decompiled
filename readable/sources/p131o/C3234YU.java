package p131o;

import android.content.Context;

/* renamed from: o.YU */
/* loaded from: classes.dex */
public final class C3234YU implements InterfaceC4352pU {

    /* renamed from: AZxh */
    public final InterfaceC3339a4 f11882AZxh;

    /* renamed from: mjFkc */
    public InterfaceC3339a4 f11883mjFkc;

    /* renamed from: wA */
    public final AbstractC1630AU f11884wA;

    public C3234YU(Context context, AbstractC1630AU abstractC1630AU) {
        this.f11884wA = abstractC1630AU;
        C4288oaI c4288oaI = C4288oaI.f15764xJ;
        C3543d9.m11710JHa(context);
        final InterfaceC3210Y8 interfaceC3210Y8M11715xJ = C3543d9.m11712wA().m11715xJ(c4288oaI);
        if (c4288oaI.mo12982mjFkc().contains(C3569dXmy.m11728AZxh("json"))) {
            this.f11883mjFkc = new C2541O0(new InterfaceC3339a4() { // from class: o.SU
                @Override // p131o.InterfaceC3339a4
                /* renamed from: get */
                public final Object mo8427get() {
                    return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("json"), new InterfaceC2416M8() { // from class: o.WU
                        @Override // p131o.InterfaceC2416M8
                        /* renamed from: apply */
                        public final Object mo8122apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f11882AZxh = new C2541O0(new InterfaceC3339a4() { // from class: o.UU
            @Override // p131o.InterfaceC3339a4
            /* renamed from: get */
            public final Object mo8427get() {
                return interfaceC3210Y8M11715xJ.mo11048mjFkc("FIREBASE_ML_SDK", byte[].class, C3569dXmy.m11728AZxh("proto"), new InterfaceC2416M8() { // from class: o.QU
                    @Override // p131o.InterfaceC2416M8
                    /* renamed from: apply */
                    public final Object mo8122apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }
}
