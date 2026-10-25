package p131o;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* renamed from: o.Hx */
/* loaded from: classes.dex */
public final class C2131Hx implements InterfaceC4919xz {

    /* renamed from: mjFkc */
    public final AbstractC2063Gx f8662mjFkc;

    public C2131Hx(AbstractC2063Gx abstractC2063Gx) {
        Charset charset = AbstractC4183my.f15287mjFkc;
        this.f8662mjFkc = abstractC2063Gx;
        abstractC2063Gx.f8464mjFkc = this;
    }

    /* renamed from: rWxwaT */
    public static C2131Hx m8592rWxwaT(AbstractC2063Gx abstractC2063Gx) {
        C2131Hx c2131Hx = abstractC2063Gx.f8464mjFkc;
        return c2131Hx != null ? c2131Hx : new C2131Hx(abstractC2063Gx);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: AZxh */
    public final void mo8593AZxh(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2795Rx)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8088rkYL(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.f8662mjFkc.mo8090wJVbdd(i3);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8086qGY(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        C2795Rx c2795Rx = (C2795Rx) list;
        if (!z) {
            while (i2 < c2795Rx.size()) {
                this.f8662mjFkc.mo8088rkYL(i, Float.floatToRawIntBits(c2795Rx.m10112ZfxDd(i2)));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c2795Rx.size(); i6++) {
            c2795Rx.m10112ZfxDd(i6);
            i5 += 4;
        }
        this.f8662mjFkc.mo8090wJVbdd(i5);
        while (i2 < c2795Rx.size()) {
            this.f8662mjFkc.mo8086qGY(Float.floatToRawIntBits(c2795Rx.m10112ZfxDd(i2)));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: BAnRFn */
    public final void mo8594BAnRFn(int i, boolean z) {
        this.f8662mjFkc.mo8069ETF(i, z);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: CqaNbM */
    public final void mo8595CqaNbM(int i, AbstractC4981yx abstractC4981yx) {
        this.f8662mjFkc.mo8073MiMN(i, abstractC4981yx);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: Dt */
    public final void mo8596Dt(int i, String str) {
        this.f8662mjFkc.mo8089vI(i, str);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: ETF */
    public final void mo8597ETF(int i, Object obj, InterfaceC2998Uy interfaceC2998Uy) {
        this.f8662mjFkc.mo8076Ucbh(i, (InterfaceC2341Ky) obj, interfaceC2998Uy);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: Gd */
    public final void mo8598Gd(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8075Pq(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8468KLFTb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Integer) list.get(i3)).intValue());
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8080diqgf(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                this.f8662mjFkc.mo8075Pq(i, c3658ey.m11870ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8468KLFTb2 = 0;
        for (int i4 = 0; i4 < c3658ey.size(); i4++) {
            iM8468KLFTb2 += AbstractC2063Gx.m8468KLFTb(c3658ey.m11870ZfxDd(i4));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb2);
        while (i2 < c3658ey.size()) {
            this.f8662mjFkc.mo8080diqgf(c3658ey.m11870ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: HGpJ */
    public final void mo8599HGpJ(int i, Object obj) {
        boolean z = obj instanceof AbstractC4981yx;
        AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
        if (z) {
            abstractC2063Gx.mo8071HGpJ(i, (AbstractC4981yx) obj);
        } else {
            abstractC2063Gx.mo8070Gd(i, (InterfaceC2341Ky) obj);
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: IEE */
    public final void mo8600IEE(int i, int i2) {
        AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
        abstractC2063Gx.mo8084lB(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: JHa */
    public final void mo8601JHa(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C4982yy)) {
            if (!z) {
                while (i2 < list.size()) {
                    AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    abstractC2063Gx.mo8085mByQ(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8468KLFTb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb);
            while (i2 < list.size()) {
                AbstractC2063Gx abstractC2063Gx2 = this.f8662mjFkc;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                abstractC2063Gx2.mo8074OjSQV((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        C4982yy c4982yy = (C4982yy) list;
        if (!z) {
            while (i2 < c4982yy.size()) {
                AbstractC2063Gx abstractC2063Gx3 = this.f8662mjFkc;
                long jM14059ZfxDd = c4982yy.m14059ZfxDd(i2);
                abstractC2063Gx3.mo8085mByQ(i, (jM14059ZfxDd >> 63) ^ (jM14059ZfxDd + jM14059ZfxDd));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8468KLFTb2 = 0;
        for (int i4 = 0; i4 < c4982yy.size(); i4++) {
            long jM14059ZfxDd2 = c4982yy.m14059ZfxDd(i4);
            iM8468KLFTb2 += AbstractC2063Gx.m8468KLFTb((jM14059ZfxDd2 >> 63) ^ (jM14059ZfxDd2 + jM14059ZfxDd2));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb2);
        while (i2 < c4982yy.size()) {
            AbstractC2063Gx abstractC2063Gx4 = this.f8662mjFkc;
            long jM14059ZfxDd3 = c4982yy.m14059ZfxDd(i2);
            abstractC2063Gx4.mo8074OjSQV((jM14059ZfxDd3 >> 63) ^ (jM14059ZfxDd3 + jM14059ZfxDd3));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: KLFTb */
    public final void mo8602KLFTb(int i, C1796Cy c1796Cy, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            this.f8662mjFkc.mo8090wJVbdd(C1858Dy.m8095AZxh(c1796Cy, entry.getKey(), entry.getValue()));
            C1858Dy.m8096KLFTb(this.f8662mjFkc, c1796Cy, entry.getKey(), entry.getValue());
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: KLMXS */
    public final void mo8603KLMXS(int i, long j) {
        this.f8662mjFkc.mo8085mByQ(i, j);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: MiMN */
    public final void mo8604MiMN(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8075Pq(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8468KLFTb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Integer) list.get(i3)).intValue());
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8080diqgf(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                this.f8662mjFkc.mo8075Pq(i, c3658ey.m11870ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8468KLFTb2 = 0;
        for (int i4 = 0; i4 < c3658ey.size(); i4++) {
            iM8468KLFTb2 += AbstractC2063Gx.m8468KLFTb(c3658ey.m11870ZfxDd(i4));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb2);
        while (i2 < c3658ey.size()) {
            this.f8662mjFkc.mo8080diqgf(c3658ey.m11870ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: Ne */
    public final void mo8605Ne(int i, Object obj, InterfaceC2998Uy interfaceC2998Uy) {
        AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
        abstractC2063Gx.mo8066BAnRFn(i, 3);
        interfaceC2998Uy.mo9771qdMbNW((InterfaceC2341Ky) obj, abstractC2063Gx.f8464mjFkc);
        abstractC2063Gx.mo8066BAnRFn(i, 4);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: OjSQV */
    public final void mo8606OjSQV(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C4982yy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8085mByQ(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8468KLFTb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Long) list.get(i3)).longValue());
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8074OjSQV(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C4982yy c4982yy = (C4982yy) list;
        if (!z) {
            while (i2 < c4982yy.size()) {
                this.f8662mjFkc.mo8085mByQ(i, c4982yy.m14059ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8468KLFTb2 = 0;
        for (int i4 = 0; i4 < c4982yy.size(); i4++) {
            iM8468KLFTb2 += AbstractC2063Gx.m8468KLFTb(c4982yy.m14059ZfxDd(i4));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb2);
        while (i2 < c4982yy.size()) {
            this.f8662mjFkc.mo8074OjSQV(c4982yy.m14059ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: Pq */
    public final void mo8607Pq(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C4982yy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8085mByQ(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8468KLFTb = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM8468KLFTb += AbstractC2063Gx.m8468KLFTb(((Long) list.get(i3)).longValue());
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8074OjSQV(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C4982yy c4982yy = (C4982yy) list;
        if (!z) {
            while (i2 < c4982yy.size()) {
                this.f8662mjFkc.mo8085mByQ(i, c4982yy.m14059ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8468KLFTb2 = 0;
        for (int i4 = 0; i4 < c4982yy.size(); i4++) {
            iM8468KLFTb2 += AbstractC2063Gx.m8468KLFTb(c4982yy.m14059ZfxDd(i4));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8468KLFTb2);
        while (i2 < c4982yy.size()) {
            this.f8662mjFkc.mo8074OjSQV(c4982yy.m14059ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: Ucbh */
    public final void mo8608Ucbh(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f8662mjFkc.mo8073MiMN(i, (AbstractC4981yx) list.get(i2));
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: VA */
    public final void mo8609VA(int i, int i2) {
        this.f8662mjFkc.mo8075Pq(i, i2);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: VocHEe */
    public final void mo8610VocHEe(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C4982yy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8082fehf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.f8662mjFkc.mo8090wJVbdd(i3);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8072IEE(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C4982yy c4982yy = (C4982yy) list;
        if (!z) {
            while (i2 < c4982yy.size()) {
                this.f8662mjFkc.mo8082fehf(i, c4982yy.m14059ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c4982yy.size(); i6++) {
            c4982yy.m14059ZfxDd(i6);
            i5 += 8;
        }
        this.f8662mjFkc.mo8090wJVbdd(i5);
        while (i2 < c4982yy.size()) {
            this.f8662mjFkc.mo8072IEE(c4982yy.m14059ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: YoKzxo */
    public final void mo8611YoKzxo(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    abstractC2063Gx.mo8084lB(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8470ZfxDd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8470ZfxDd);
            while (i2 < list.size()) {
                AbstractC2063Gx abstractC2063Gx2 = this.f8662mjFkc;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                abstractC2063Gx2.mo8090wJVbdd((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                AbstractC2063Gx abstractC2063Gx3 = this.f8662mjFkc;
                int iM11870ZfxDd = c3658ey.m11870ZfxDd(i2);
                abstractC2063Gx3.mo8084lB(i, (iM11870ZfxDd >> 31) ^ (iM11870ZfxDd + iM11870ZfxDd));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8470ZfxDd2 = 0;
        for (int i4 = 0; i4 < c3658ey.size(); i4++) {
            int iM11870ZfxDd2 = c3658ey.m11870ZfxDd(i4);
            iM8470ZfxDd2 += AbstractC2063Gx.m8470ZfxDd((iM11870ZfxDd2 >> 31) ^ (iM11870ZfxDd2 + iM11870ZfxDd2));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8470ZfxDd2);
        while (i2 < c3658ey.size()) {
            AbstractC2063Gx abstractC2063Gx4 = this.f8662mjFkc;
            int iM11870ZfxDd3 = c3658ey.m11870ZfxDd(i2);
            abstractC2063Gx4.mo8090wJVbdd((iM11870ZfxDd3 >> 31) ^ (iM11870ZfxDd3 + iM11870ZfxDd3));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: ZfxDd */
    public final void mo8612ZfxDd(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8069ETF(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.f8662mjFkc.mo8090wJVbdd(i3);
        while (i2 < list.size()) {
            this.f8662mjFkc.mo8068Dt(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: cMLeY */
    public final void mo8613cMLeY(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8084lB(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int iM8470ZfxDd = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM8470ZfxDd += AbstractC2063Gx.m8470ZfxDd(((Integer) list.get(i3)).intValue());
            }
            this.f8662mjFkc.mo8090wJVbdd(iM8470ZfxDd);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8090wJVbdd(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                this.f8662mjFkc.mo8084lB(i, c3658ey.m11870ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int iM8470ZfxDd2 = 0;
        for (int i4 = 0; i4 < c3658ey.size(); i4++) {
            iM8470ZfxDd2 += AbstractC2063Gx.m8470ZfxDd(c3658ey.m11870ZfxDd(i4));
        }
        this.f8662mjFkc.mo8090wJVbdd(iM8470ZfxDd2);
        while (i2 < c3658ey.size()) {
            this.f8662mjFkc.mo8090wJVbdd(c3658ey.m11870ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: diqgf */
    public final void mo8614diqgf(int i, double d) {
        this.f8662mjFkc.mo8082fehf(i, Double.doubleToRawLongBits(d));
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: eyqo */
    public final void mo8615eyqo(int i, long j) {
        this.f8662mjFkc.mo8085mByQ(i, j);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: fehf */
    public final void mo8616fehf(int i) {
        this.f8662mjFkc.mo8066BAnRFn(i, 4);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: huTpC */
    public final void mo8617huTpC(int i, float f) {
        this.f8662mjFkc.mo8088rkYL(i, Float.floatToRawIntBits(f));
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: lB */
    public final void mo8618lB(int i, int i2) {
        this.f8662mjFkc.mo8088rkYL(i, i2);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: lgHUyS */
    public final void mo8619lgHUyS(int i, long j) {
        this.f8662mjFkc.mo8082fehf(i, j);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: mByQ */
    public final void mo8620mByQ(int i, long j) {
        AbstractC2063Gx abstractC2063Gx = this.f8662mjFkc;
        abstractC2063Gx.mo8085mByQ(i, (j >> 63) ^ (j + j));
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: mjFkc */
    public final void mo8621mjFkc(int i, int i2) {
        this.f8662mjFkc.mo8088rkYL(i, i2);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: qGY */
    public final void mo8622qGY(int i, int i2) {
        this.f8662mjFkc.mo8075Pq(i, i2);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: qdMbNW */
    public final void mo8623qdMbNW(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f8662mjFkc.mo8089vI(i, (String) list.get(i2));
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: rkYL */
    public final void mo8624rkYL(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8082fehf(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.f8662mjFkc.mo8090wJVbdd(i3);
        while (i2 < list.size()) {
            this.f8662mjFkc.mo8072IEE(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: vI */
    public final void mo8625vI(int i) {
        this.f8662mjFkc.mo8066BAnRFn(i, 3);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: wA */
    public final void mo8626wA(int i, int i2) {
        this.f8662mjFkc.mo8084lB(i, i2);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: wJVbdd */
    public final void mo8627wJVbdd(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C4982yy)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8082fehf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.f8662mjFkc.mo8090wJVbdd(i3);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8072IEE(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C4982yy c4982yy = (C4982yy) list;
        if (!z) {
            while (i2 < c4982yy.size()) {
                this.f8662mjFkc.mo8082fehf(i, c4982yy.m14059ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c4982yy.size(); i6++) {
            c4982yy.m14059ZfxDd(i6);
            i5 += 8;
        }
        this.f8662mjFkc.mo8090wJVbdd(i5);
        while (i2 < c4982yy.size()) {
            this.f8662mjFkc.mo8072IEE(c4982yy.m14059ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: xJ */
    public final void mo8628xJ(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8088rkYL(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.f8662mjFkc.mo8090wJVbdd(i3);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8086qGY(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                this.f8662mjFkc.mo8088rkYL(i, c3658ey.m11870ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c3658ey.size(); i6++) {
            c3658ey.m11870ZfxDd(i6);
            i5 += 4;
        }
        this.f8662mjFkc.mo8090wJVbdd(i5);
        while (i2 < c3658ey.size()) {
            this.f8662mjFkc.mo8086qGY(c3658ey.m11870ZfxDd(i2));
            i2++;
        }
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: xrEuO */
    public final void mo8629xrEuO(int i, long j) {
        this.f8662mjFkc.mo8082fehf(i, j);
    }

    @Override // p131o.InterfaceC4919xz
    /* renamed from: zvd */
    public final void mo8630zvd(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C3658ey)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f8662mjFkc.mo8088rkYL(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f8662mjFkc.mo8066BAnRFn(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.f8662mjFkc.mo8090wJVbdd(i3);
            while (i2 < list.size()) {
                this.f8662mjFkc.mo8086qGY(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C3658ey c3658ey = (C3658ey) list;
        if (!z) {
            while (i2 < c3658ey.size()) {
                this.f8662mjFkc.mo8088rkYL(i, c3658ey.m11870ZfxDd(i2));
                i2++;
            }
            return;
        }
        this.f8662mjFkc.mo8066BAnRFn(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c3658ey.size(); i6++) {
            c3658ey.m11870ZfxDd(i6);
            i5 += 4;
        }
        this.f8662mjFkc.mo8090wJVbdd(i5);
        while (i2 < c3658ey.size()) {
            this.f8662mjFkc.mo8086qGY(c3658ey.m11870ZfxDd(i2));
            i2++;
        }
    }
}
