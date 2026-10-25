package p131o;

import java.util.List;

/* renamed from: o.Wy */
/* loaded from: classes.dex */
public abstract class AbstractC3129Wy {

    /* renamed from: mjFkc */
    public static final AbstractC3989jz f11513mjFkc;

    static {
        C2796Ry c2796Ry = C2796Ry.f10501wA;
        f11513mjFkc = new C4119lz();
    }

    /* renamed from: AZxh */
    public static void m10853AZxh(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8601JHa(i, list, z);
    }

    /* renamed from: BAnRFn */
    public static void m10854BAnRFn(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8604MiMN(i, list, z);
    }

    /* renamed from: Dt */
    public static int m10855Dt(List list) {
        return list.size() * 8;
    }

    /* renamed from: ETF */
    public static int m10856ETF(List list) {
        int iM8468KLFTb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3658ey) {
            C3658ey c3658ey = (C3658ey) list;
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(c3658ey.m11870ZfxDd(i));
                i++;
            }
        } else {
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM8468KLFTb;
    }

    /* renamed from: Gd */
    public static void m10857Gd(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8598Gd(i, list, z);
    }

    /* renamed from: HGpJ */
    public static void m10858HGpJ(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8628xJ(i, list, z);
    }

    /* renamed from: IEE */
    public static AbstractC3989jz m10859IEE() {
        return f11513mjFkc;
    }

    /* renamed from: JHa */
    public static int m10860JHa(List list) {
        int iM8468KLFTb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3658ey) {
            C3658ey c3658ey = (C3658ey) list;
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(c3658ey.m11870ZfxDd(i));
                i++;
            }
        } else {
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM8468KLFTb;
    }

    /* renamed from: KLFTb */
    public static boolean m10861KLFTb(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: MiMN */
    public static int m10862MiMN(int i, Object obj, InterfaceC2998Uy interfaceC2998Uy) {
        return AbstractC2063Gx.m8470ZfxDd(i << 3) + AbstractC2063Gx.m8467AZxh((InterfaceC2341Ky) obj, interfaceC2998Uy);
    }

    /* renamed from: Pq */
    public static Object m10863Pq(Object obj, int i, int i2, Object obj2, AbstractC3989jz abstractC3989jz) {
        if (obj2 == null) {
            obj2 = abstractC3989jz.mo12455mjFkc(obj);
        }
        ((C4055kz) obj2).m12637Dt(i << 3, Long.valueOf(i2));
        return obj2;
    }

    /* renamed from: Ucbh */
    public static void m10864Ucbh(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8612ZfxDd(i, list, z);
    }

    /* renamed from: VA */
    public static int m10865VA(List list) {
        int iM8468KLFTb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4982yy) {
            C4982yy c4982yy = (C4982yy) list;
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(c4982yy.m14059ZfxDd(i));
                i++;
            }
        } else {
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iM8468KLFTb;
    }

    /* renamed from: VocHEe */
    public static void m10866VocHEe(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8593AZxh(i, list, z);
    }

    /* renamed from: YoKzxo */
    public static int m10867YoKzxo(List list) {
        int iM8470ZfxDd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3658ey) {
            C3658ey c3658ey = (C3658ey) list;
            iM8470ZfxDd = 0;
            while (i < size) {
                int iM11870ZfxDd = c3658ey.m11870ZfxDd(i);
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd((iM11870ZfxDd >> 31) ^ (iM11870ZfxDd + iM11870ZfxDd));
                i++;
            }
        } else {
            iM8470ZfxDd = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iM8470ZfxDd;
    }

    /* renamed from: ZfxDd */
    public static void m10868ZfxDd(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8607Pq(i, list, z);
    }

    /* renamed from: diqgf */
    public static void m10869diqgf(AbstractC2403Lx abstractC2403Lx, Object obj, Object obj2) {
        C2664Px c2664Px = ((AbstractC3330Zx) obj2).f12261zbb;
        if (c2664Px.f10131mjFkc.isEmpty()) {
            return;
        }
        ((AbstractC3330Zx) obj).m11232OjSQV().m9986qdMbNW(c2664Px);
    }

    /* renamed from: eyqo */
    public static void m10870eyqo(AbstractC3989jz abstractC3989jz, Object obj, Object obj2) {
        AbstractC3595dy abstractC3595dy = (AbstractC3595dy) obj;
        C4055kz c4055kzM12634KLFTb = abstractC3595dy.f13418zbc;
        C4055kz c4055kz = ((AbstractC3595dy) obj2).f13418zbc;
        if (!C4055kz.m12635wA().m12642equals(c4055kz)) {
            if (C4055kz.m12635wA().m12642equals(c4055kzM12634KLFTb)) {
                c4055kzM12634KLFTb = C4055kz.m12634KLFTb(c4055kzM12634KLFTb, c4055kz);
            } else {
                c4055kzM12634KLFTb.m12641ZfxDd(c4055kz);
            }
        }
        abstractC3595dy.f13418zbc = c4055kzM12634KLFTb;
    }

    /* renamed from: fehf */
    public static int m10871fehf(List list) {
        int iM8468KLFTb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4982yy) {
            C4982yy c4982yy = (C4982yy) list;
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(c4982yy.m14059ZfxDd(i));
                i++;
            }
        } else {
            iM8468KLFTb = 0;
            while (i < size) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iM8468KLFTb;
    }

    /* renamed from: huTpC */
    public static void m10872huTpC(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8624rkYL(i, list, z);
    }

    /* renamed from: lB */
    public static void m10873lB(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8606OjSQV(i, list, z);
    }

    /* renamed from: lgHUyS */
    public static int m10874lgHUyS(List list) {
        return list.size() * 4;
    }

    /* renamed from: mByQ */
    public static void m10875mByQ(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8627wJVbdd(i, list, z);
    }

    /* renamed from: mjFkc */
    public static void m10876mjFkc(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8611YoKzxo(i, list, z);
    }

    /* renamed from: qGY */
    public static int m10877qGY(List list) {
        int iM8470ZfxDd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3658ey) {
            C3658ey c3658ey = (C3658ey) list;
            iM8470ZfxDd = 0;
            while (i < size) {
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd(c3658ey.m11870ZfxDd(i));
                i++;
            }
        } else {
            iM8470ZfxDd = 0;
            while (i < size) {
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM8470ZfxDd;
    }

    /* renamed from: qdMbNW */
    public static int m10878qdMbNW(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC2063Gx.m8470ZfxDd(i << 3) + 8);
    }

    /* renamed from: rkYL */
    public static int m10879rkYL(List list) {
        int iM8468KLFTb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4982yy) {
            C4982yy c4982yy = (C4982yy) list;
            iM8468KLFTb = 0;
            while (i < size) {
                long jM14059ZfxDd = c4982yy.m14059ZfxDd(i);
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb((jM14059ZfxDd >> 63) ^ (jM14059ZfxDd + jM14059ZfxDd));
                i++;
            }
        } else {
            iM8468KLFTb = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iM8468KLFTb;
    }

    /* renamed from: vI */
    public static void m10880vI(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8610VocHEe(i, list, z);
    }

    /* renamed from: wA */
    public static void m10881wA(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8613cMLeY(i, list, z);
    }

    /* renamed from: wJVbdd */
    public static void m10882wJVbdd(int i, List list, InterfaceC4919xz interfaceC4919xz, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4919xz.mo8630zvd(i, list, z);
    }

    /* renamed from: xJ */
    public static int m10883xJ(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (AbstractC2063Gx.m8470ZfxDd(i << 3) + 4);
    }
}
