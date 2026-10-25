package p131o;

import p131o.C3363aQ;

/* renamed from: o.yJ */
/* loaded from: classes.dex */
public final class C4940yJ implements InterfaceC2735R2 {

    /* renamed from: AZxh */
    public static final C3363aQ f17501AZxh;

    /* renamed from: ZfxDd */
    public static final C3363aQ f17502ZfxDd;

    /* renamed from: mjFkc */
    public static final C4940yJ f17503mjFkc = new C4940yJ();

    /* renamed from: wA */
    public static final C3363aQ f17504wA;

    static {
        C3363aQ.AZxh aZxhM11311mjFkc = C3363aQ.m11311mjFkc("logEventKey");
        C4006kF c4006kF = new C4006kF();
        c4006kF.m12545mjFkc(1);
        f17501AZxh = aZxhM11311mjFkc.m11315AZxh(c4006kF.m12544AZxh()).m11316mjFkc();
        C3363aQ.AZxh aZxhM11311mjFkc2 = C3363aQ.m11311mjFkc("eventCount");
        C4006kF c4006kF2 = new C4006kF();
        c4006kF2.m12545mjFkc(2);
        f17504wA = aZxhM11311mjFkc2.m11315AZxh(c4006kF2.m12544AZxh()).m11316mjFkc();
        C3363aQ.AZxh aZxhM11311mjFkc3 = C3363aQ.m11311mjFkc("inferenceDurationStats");
        C4006kF c4006kF3 = new C4006kF();
        c4006kF3.m12545mjFkc(3);
        f17502ZfxDd = aZxhM11311mjFkc3.m11315AZxh(c4006kF3.m12544AZxh()).m11316mjFkc();
    }

    @Override // p131o.InterfaceC4156mYYU
    /* renamed from: mjFkc */
    public final /* bridge */ /* synthetic */ void mo7597mjFkc(Object obj, Object obj2) {
        C1749CH c1749ch = (C1749CH) obj;
        InterfaceC2801S2 interfaceC2801S2 = (InterfaceC2801S2) obj2;
        interfaceC2801S2.mo10131wA(f17501AZxh, c1749ch.m7826mjFkc());
        interfaceC2801S2.mo10131wA(f17504wA, c1749ch.m7827wA());
        interfaceC2801S2.mo10131wA(f17502ZfxDd, c1749ch.m7825AZxh());
    }
}
