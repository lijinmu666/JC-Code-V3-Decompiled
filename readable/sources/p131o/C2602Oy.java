package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.Oy */
/* loaded from: classes.dex */
public final class C2602Oy implements InterfaceC2998Uy {

    /* renamed from: AZxh */
    public final AbstractC3989jz f10018AZxh;

    /* renamed from: ZfxDd */
    public final AbstractC2403Lx f10019ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC2341Ky f10020mjFkc;

    /* renamed from: wA */
    public final boolean f10021wA;

    public C2602Oy(AbstractC3989jz abstractC3989jz, AbstractC2403Lx abstractC2403Lx, InterfaceC2341Ky interfaceC2341Ky) {
        this.f10018AZxh = abstractC3989jz;
        this.f10021wA = interfaceC2341Ky instanceof AbstractC3330Zx;
        this.f10019ZfxDd = abstractC2403Lx;
        this.f10020mjFkc = interfaceC2341Ky;
    }

    /* renamed from: Dt */
    public static C2602Oy m9924Dt(AbstractC3989jz abstractC3989jz, AbstractC2403Lx abstractC2403Lx, InterfaceC2341Ky interfaceC2341Ky) {
        return new C2602Oy(abstractC3989jz, abstractC2403Lx, interfaceC2341Ky);
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: AZxh */
    public final Object mo9751AZxh() {
        InterfaceC2341Ky interfaceC2341Ky = this.f10020mjFkc;
        return interfaceC2341Ky instanceof AbstractC3595dy ? ((AbstractC3595dy) interfaceC2341Ky).m11761HGpJ() : interfaceC2341Ky.mo9295KLFTb().mo9071xJ();
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: JHa */
    public final int mo9754JHa(Object obj) {
        int iHashCode = ((AbstractC3595dy) obj).f13418zbc.hashCode();
        return this.f10021wA ? (iHashCode * 53) + ((AbstractC3330Zx) obj).f12261zbb.f10131mjFkc.hashCode() : iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5 A[EDGE_INSN: B:57:0x00b5->B:33:0x00b5 BREAK  A[LOOP:1: B:18:0x0062->B:60:0x0062], SYNTHETIC] */
    @Override // p131o.InterfaceC2998Uy
    /* renamed from: KLFTb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo9755KLFTb(Object obj, byte[] bArr, int i, int i2, C4117lx c4117lx) throws C4315oy {
        AbstractC3595dy abstractC3595dy = (AbstractC3595dy) obj;
        C4055kz c4055kzM12633JHa = abstractC3595dy.f13418zbc;
        if (c4055kzM12633JHa == C4055kz.m12635wA()) {
            c4055kzM12633JHa = C4055kz.m12633JHa();
            abstractC3595dy.f13418zbc = c4055kzM12633JHa;
        }
        C2664Px c2664PxM11232OjSQV = ((AbstractC3330Zx) obj).m11232OjSQV();
        C3531cy c3531cyM9292wA = null;
        while (i < i2) {
            int iM12798ETF = AbstractC4182mx.m12798ETF(bArr, i, c4117lx);
            int i3 = c4117lx.f14842mjFkc;
            if (i3 == 11) {
                int i4 = 0;
                AbstractC4981yx abstractC4981yx = null;
                while (iM12798ETF < i2) {
                    iM12798ETF = AbstractC4182mx.m12798ETF(bArr, iM12798ETF, c4117lx);
                    int i5 = c4117lx.f14842mjFkc;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (c3531cyM9292wA != null) {
                                iM12798ETF = AbstractC4182mx.m12801KLFTb(C2796Ry.m10116mjFkc().m10117AZxh(c3531cyM9292wA.f13273mjFkc.getClass()), bArr, iM12798ETF, i2, c4117lx);
                                c2664PxM11232OjSQV.m9978Dt(c3531cyM9292wA.f13272AZxh, c4117lx.f14843wA);
                            } else if (i7 == 2) {
                                iM12798ETF = AbstractC4182mx.m12809mjFkc(bArr, iM12798ETF, c4117lx);
                                abstractC4981yx = (AbstractC4981yx) c4117lx.f14843wA;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iM12798ETF = AbstractC4182mx.m12807fehf(i5, bArr, iM12798ETF, i2, c4117lx);
                        }
                    } else if (i7 == 0) {
                        iM12798ETF = AbstractC4182mx.m12798ETF(bArr, iM12798ETF, c4117lx);
                        i4 = c4117lx.f14842mjFkc;
                        c3531cyM9292wA = c4117lx.f14841ZfxDd.m9292wA(this.f10020mjFkc, i4);
                    } else if (i5 != 12) {
                    }
                }
                if (abstractC4981yx != null) {
                    c4055kzM12633JHa.m12637Dt((i4 << 3) | 2, abstractC4981yx);
                }
                i = iM12798ETF;
            } else if ((i3 & 7) == 2) {
                C3531cy c3531cyM9292wA2 = c4117lx.f14841ZfxDd.m9292wA(this.f10020mjFkc, i3 >>> 3);
                if (c3531cyM9292wA2 != null) {
                    i = AbstractC4182mx.m12801KLFTb(C2796Ry.m10116mjFkc().m10117AZxh(c3531cyM9292wA2.f13273mjFkc.getClass()), bArr, iM12798ETF, i2, c4117lx);
                    c2664PxM11232OjSQV.m9978Dt(c3531cyM9292wA2.f13272AZxh, c4117lx.f14843wA);
                } else {
                    i = AbstractC4182mx.m12797Dt(i3, bArr, iM12798ETF, i2, c4055kzM12633JHa, c4117lx);
                }
                c3531cyM9292wA = c3531cyM9292wA2;
            } else {
                i = AbstractC4182mx.m12807fehf(i3, bArr, iM12798ETF, i2, c4117lx);
            }
        }
        if (i != i2) {
            throw new C4315oy("Failed to parse the message.");
        }
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: ZfxDd */
    public final boolean mo9765ZfxDd(Object obj) {
        return ((AbstractC3330Zx) obj).f12261zbb.m9980MiMN();
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: lgHUyS */
    public final void mo9768lgHUyS(Object obj) {
        this.f10018AZxh.mo12454AZxh(obj);
        this.f10019ZfxDd.mo9398mjFkc(obj);
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: mjFkc */
    public final int mo9769mjFkc(Object obj) {
        int iM12636AZxh = ((AbstractC3595dy) obj).f13418zbc.m12636AZxh();
        return this.f10021wA ? iM12636AZxh + ((AbstractC3330Zx) obj).f12261zbb.m9988wA() : iM12636AZxh;
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: qdMbNW */
    public final void mo9771qdMbNW(Object obj, InterfaceC4919xz interfaceC4919xz) {
        Iterator itM9989xJ = ((AbstractC3330Zx) obj).f12261zbb.m9989xJ();
        while (itM9989xJ.hasNext()) {
            Map.Entry entry = (Map.Entry) itM9989xJ.next();
            InterfaceC2601Ox interfaceC2601Ox = (InterfaceC2601Ox) entry.getKey();
            if (interfaceC2601Ox.mo9918AZxh() != EnumC4851wz.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            interfaceC2601Ox.mo9920ZfxDd();
            interfaceC2601Ox.mo9922wA();
            if (entry instanceof AbstractC4451qy) {
                interfaceC2601Ox.mo9921mjFkc();
                ((AbstractC4451qy) entry).m13330mjFkc();
                throw null;
            }
            interfaceC2601Ox.mo9921mjFkc();
            interfaceC4919xz.mo8599HGpJ(32149011, entry.getValue());
        }
        ((AbstractC3595dy) obj).f13418zbc.m12638ETF(interfaceC4919xz);
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: wA */
    public final boolean mo9775wA(Object obj, Object obj2) {
        if (!((AbstractC3595dy) obj).f13418zbc.equals(((AbstractC3595dy) obj2).f13418zbc)) {
            return false;
        }
        if (this.f10021wA) {
            return ((AbstractC3330Zx) obj).f12261zbb.m9984equals(((AbstractC3330Zx) obj2).f12261zbb);
        }
        return true;
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: xJ */
    public final void mo9776xJ(Object obj, Object obj2) {
        AbstractC3129Wy.m10870eyqo(this.f10018AZxh, obj, obj2);
        if (this.f10021wA) {
            AbstractC3129Wy.m10869diqgf(this.f10019ZfxDd, obj, obj2);
        }
    }
}
