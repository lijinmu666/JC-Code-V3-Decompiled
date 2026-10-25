package p131o;

import java.util.ArrayList;
import p131o.C3776gjvQ;
import p131o.C4446qtZIjO;

/* renamed from: o.dkKKW */
/* loaded from: classes.dex */
public class C3582dkKKW {

    /* renamed from: wA */
    public C4052kw f13380wA;

    /* renamed from: mjFkc */
    public final ArrayList f13379mjFkc = new ArrayList();

    /* renamed from: AZxh */
    public mjFkc f13378AZxh = new mjFkc();

    /* renamed from: o.dkKKW$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        void mo407AZxh(C3776gjvQ c3776gjvQ, mjFkc mjfkc);

        /* renamed from: mjFkc */
        void mo408mjFkc();
    }

    /* renamed from: o.dkKKW$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public C3776gjvQ.AZxh f13381AZxh;

        /* renamed from: Dt */
        public boolean f13382Dt;

        /* renamed from: JHa */
        public int f13383JHa;

        /* renamed from: KLFTb */
        public int f13384KLFTb;

        /* renamed from: ZfxDd */
        public int f13385ZfxDd;

        /* renamed from: lgHUyS */
        public boolean f13386lgHUyS;

        /* renamed from: mjFkc */
        public C3776gjvQ.AZxh f13387mjFkc;

        /* renamed from: qdMbNW */
        public boolean f13388qdMbNW;

        /* renamed from: wA */
        public int f13389wA;

        /* renamed from: xJ */
        public int f13390xJ;
    }

    public C3582dkKKW(C4052kw c4052kw) {
        this.f13380wA = c4052kw;
    }

    /* renamed from: AZxh */
    public final void m11739AZxh(C4052kw c4052kw) {
        int size = c4052kw.f8762tjSezt.size();
        AZxh aZxhM12625eQ = c4052kw.m12625eQ();
        for (int i = 0; i < size; i++) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) c4052kw.f8762tjSezt.get(i);
            if (!(c3776gjvQ instanceof C4186n) && (!c3776gjvQ.f13778KLFTb.f8999KLFTb.f16348Dt || !c3776gjvQ.f13774JHa.f8999KLFTb.f16348Dt)) {
                C3776gjvQ.AZxh aZxhM12046Pq = c3776gjvQ.m12046Pq(0);
                C3776gjvQ.AZxh aZxhM12046Pq2 = c3776gjvQ.m12046Pq(1);
                C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxhM12046Pq != aZxh || c3776gjvQ.f13793VA == 1 || aZxhM12046Pq2 != aZxh || c3776gjvQ.f13781MiMN == 1) {
                    m11742mjFkc(aZxhM12625eQ, c3776gjvQ, false);
                }
            }
        }
        aZxhM12625eQ.mo408mjFkc();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* renamed from: KLFTb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m11740KLFTb(C4052kw c4052kw) {
        this.f13379mjFkc.clear();
        int size = c4052kw.f8762tjSezt.size();
        for (int i = 0; i < size; i++) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) c4052kw.f8762tjSezt.get(i);
            C3776gjvQ.AZxh aZxhM12030HGpJ = c3776gjvQ.m12030HGpJ();
            C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
            if (aZxhM12030HGpJ != aZxh) {
                C3776gjvQ.AZxh aZxhM12030HGpJ2 = c3776gjvQ.m12030HGpJ();
                C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.MATCH_PARENT;
                if (aZxhM12030HGpJ2 == aZxh2 || c3776gjvQ.m12088rWxwaT() == aZxh || c3776gjvQ.m12088rWxwaT() == aZxh2) {
                    this.f13379mjFkc.add(c3776gjvQ);
                }
            }
        }
        c4052kw.m12620XgAT();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* renamed from: ZfxDd */
    public long m11741ZfxDd(C4052kw c4052kw, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        boolean zM12630rdJr;
        int i10;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        AZxh aZxh;
        boolean z4;
        int i14;
        int i15;
        boolean z5;
        ?? r2;
        AZxh aZxhM12625eQ = c4052kw.m12625eQ();
        int size = c4052kw.f8762tjSezt.size();
        int iM12096vadzgd = c4052kw.m12096vadzgd();
        int iM12051Ucbh = c4052kw.m12051Ucbh();
        boolean zM12277AZxh = AbstractC3861i3.m12277AZxh(i, 128);
        boolean z6 = true;
        boolean z7 = zM12277AZxh || AbstractC3861i3.m12277AZxh(i, 64);
        if (z7) {
            for (int i16 = 0; i16 < size; i16++) {
                C3776gjvQ c3776gjvQ = (C3776gjvQ) c4052kw.f8762tjSezt.get(i16);
                C3776gjvQ.AZxh aZxhM12030HGpJ = c3776gjvQ.m12030HGpJ();
                C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                boolean z8 = (aZxhM12030HGpJ == aZxh2) && (c3776gjvQ.m12088rWxwaT() == aZxh2) && c3776gjvQ.m12068diqgf() > 0.0f;
                if ((c3776gjvQ.m12094uHVRx() && z8) || ((c3776gjvQ.m12034JYgkl() && z8) || (c3776gjvQ instanceof AbstractC1832Da) || c3776gjvQ.m12094uHVRx() || c3776gjvQ.m12034JYgkl())) {
                    z7 = false;
                    break;
                }
            }
        }
        if (z7) {
            int i17 = C3202Y0.f11766fehf;
        }
        int i18 = 2;
        if (z7 && ((i4 == 1073741824 && i6 == 1073741824) || zM12277AZxh)) {
            int iMin = Math.min(c4052kw.m12080lB(), i5);
            int iMin2 = Math.min(c4052kw.m12024BAnRFn(), i7);
            if (i4 == 1073741824 && c4052kw.m12096vadzgd() != iMin) {
                c4052kw.m12078jx(iMin);
                c4052kw.m12620XgAT();
            }
            if (i6 == 1073741824 && c4052kw.m12051Ucbh() != iMin2) {
                c4052kw.m12023ANMGZc(iMin2);
                c4052kw.m12620XgAT();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                zM12630rdJr = c4052kw.m12618SKTn(zM12277AZxh);
                i10 = 2;
                z = false;
            } else {
                zM12630rdJr = c4052kw.m12630rdJr(zM12277AZxh);
                z = false;
                if (i4 == 1073741824) {
                    zM12630rdJr &= c4052kw.m12619XDdeP(zM12277AZxh, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    zM12630rdJr &= c4052kw.m12619XDdeP(zM12277AZxh, 1);
                    i10++;
                }
            }
            if (zM12630rdJr) {
                c4052kw.mo12082lti(i4 == 1073741824 ? true : z, i6 == 1073741824 ? true : z);
            }
        } else {
            z = false;
            zM12630rdJr = false;
            i10 = 0;
        }
        if (zM12630rdJr && i10 == 2) {
            return 0L;
        }
        if (size > 0) {
            m11739AZxh(c4052kw);
        }
        int iM12610FbxKQm = c4052kw.m12610FbxKQm();
        int size2 = this.f13379mjFkc.size();
        if (size > 0) {
            m11743wA(c4052kw, "First pass", iM12096vadzgd, iM12051Ucbh);
        }
        if (size2 > 0) {
            C3776gjvQ.AZxh aZxhM12030HGpJ2 = c4052kw.m12030HGpJ();
            C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.WRAP_CONTENT;
            boolean z9 = aZxhM12030HGpJ2 == aZxh3 ? true : z;
            boolean z10 = c4052kw.m12088rWxwaT() == aZxh3 ? true : z;
            int iMax = Math.max(c4052kw.m12096vadzgd(), this.f13380wA.m12083mByQ());
            int iMax2 = Math.max(c4052kw.m12051Ucbh(), this.f13380wA.m12098wJVbdd());
            boolean z11 = z;
            boolean zM8002FbxKQm = z11;
            ?? r14 = z11;
            while (r14 < size2) {
                C3776gjvQ c3776gjvQ2 = (C3776gjvQ) this.f13379mjFkc.get(r14);
                if (c3776gjvQ2 instanceof AbstractC1832Da) {
                    int iM12096vadzgd2 = c3776gjvQ2.m12096vadzgd();
                    i15 = iM12610FbxKQm;
                    int iM12051Ucbh2 = c3776gjvQ2.m12051Ucbh();
                    boolean zM11742mjFkc = zM8002FbxKQm | m11742mjFkc(aZxhM12625eQ, c3776gjvQ2, z6);
                    int iM12096vadzgd3 = c3776gjvQ2.m12096vadzgd();
                    int iM12051Ucbh3 = c3776gjvQ2.m12051Ucbh();
                    if (iM12096vadzgd3 != iM12096vadzgd2) {
                        c3776gjvQ2.m12078jx(iM12096vadzgd3);
                        if (z9 && c3776gjvQ2.m12100xrEuO() > iMax) {
                            iMax = Math.max(iMax, c3776gjvQ2.m12100xrEuO() + c3776gjvQ2.mo12040MiMN(C4446qtZIjO.AZxh.RIGHT).m13321wA());
                        }
                        z5 = true;
                    } else {
                        z5 = zM11742mjFkc;
                    }
                    if (iM12051Ucbh3 != iM12051Ucbh2) {
                        c3776gjvQ2.m12023ANMGZc(iM12051Ucbh3);
                        if (z10 && c3776gjvQ2.m12086qGY() > iMax2) {
                            iMax2 = Math.max(iMax2, c3776gjvQ2.m12086qGY() + c3776gjvQ2.mo12040MiMN(C4446qtZIjO.AZxh.BOTTOM).m13321wA());
                        }
                        z5 = true;
                    }
                    zM8002FbxKQm = z5 | ((AbstractC1832Da) c3776gjvQ2).m8002FbxKQm();
                    r2 = 1;
                } else {
                    i15 = iM12610FbxKQm;
                    r2 = z6;
                }
                int i19 = r14 + r2;
                z6 = r2;
                i18 = 2;
                iM12610FbxKQm = i15;
                r14 = i19;
            }
            int i20 = iM12610FbxKQm;
            int i21 = 0;
            for (int i22 = i18; i21 < i22; i22 = 2) {
                int i23 = 0;
                while (i23 < size2) {
                    C3776gjvQ c3776gjvQ3 = (C3776gjvQ) this.f13379mjFkc.get(i23);
                    if (((c3776gjvQ3 instanceof InterfaceC4718v) && !(c3776gjvQ3 instanceof AbstractC1832Da)) || (c3776gjvQ3 instanceof C4186n) || c3776gjvQ3.m12043NPj() == 8 || ((c3776gjvQ3.f13778KLFTb.f8999KLFTb.f16348Dt && c3776gjvQ3.f13774JHa.f8999KLFTb.f16348Dt) || (c3776gjvQ3 instanceof AbstractC1832Da))) {
                        i12 = size2;
                        aZxh = aZxhM12625eQ;
                        i13 = i21;
                    } else {
                        int iM12096vadzgd4 = c3776gjvQ3.m12096vadzgd();
                        int iM12051Ucbh4 = c3776gjvQ3.m12051Ucbh();
                        i12 = size2;
                        int iM12062YoKzxo = c3776gjvQ3.m12062YoKzxo();
                        i13 = i21;
                        boolean zM11742mjFkc2 = zM8002FbxKQm | m11742mjFkc(aZxhM12625eQ, c3776gjvQ3, true);
                        int iM12096vadzgd5 = c3776gjvQ3.m12096vadzgd();
                        aZxh = aZxhM12625eQ;
                        int iM12051Ucbh5 = c3776gjvQ3.m12051Ucbh();
                        if (iM12096vadzgd5 != iM12096vadzgd4) {
                            c3776gjvQ3.m12078jx(iM12096vadzgd5);
                            if (z9 && c3776gjvQ3.m12100xrEuO() > iMax) {
                                iMax = Math.max(iMax, c3776gjvQ3.m12100xrEuO() + c3776gjvQ3.mo12040MiMN(C4446qtZIjO.AZxh.RIGHT).m13321wA());
                            }
                            z4 = true;
                        } else {
                            z4 = zM11742mjFkc2;
                        }
                        if (iM12051Ucbh5 != iM12051Ucbh4) {
                            c3776gjvQ3.m12023ANMGZc(iM12051Ucbh5);
                            if (z10 && c3776gjvQ3.m12086qGY() > iMax2) {
                                iMax2 = Math.max(iMax2, c3776gjvQ3.m12086qGY() + c3776gjvQ3.mo12040MiMN(C4446qtZIjO.AZxh.BOTTOM).m13321wA());
                            }
                            z4 = true;
                        }
                        if (!c3776gjvQ3.m12057WrLQs() || iM12062YoKzxo == c3776gjvQ3.m12062YoKzxo()) {
                            zM8002FbxKQm = z4;
                        } else {
                            i14 = 1;
                            zM8002FbxKQm = true;
                            i23 += i14;
                            size2 = i12;
                            aZxhM12625eQ = aZxh;
                            i21 = i13;
                        }
                    }
                    i14 = 1;
                    i23 += i14;
                    size2 = i12;
                    aZxhM12625eQ = aZxh;
                    i21 = i13;
                }
                int i24 = size2;
                AZxh aZxh4 = aZxhM12625eQ;
                int i25 = i21;
                if (zM8002FbxKQm) {
                    m11743wA(c4052kw, "intermediate pass", iM12096vadzgd, iM12051Ucbh);
                    zM8002FbxKQm = false;
                }
                i21 = i25 + 1;
                size2 = i24;
                aZxhM12625eQ = aZxh4;
            }
            if (zM8002FbxKQm) {
                m11743wA(c4052kw, "2nd pass", iM12096vadzgd, iM12051Ucbh);
                if (c4052kw.m12096vadzgd() < iMax) {
                    c4052kw.m12078jx(iMax);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (c4052kw.m12051Ucbh() < iMax2) {
                    c4052kw.m12023ANMGZc(iMax2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    m11743wA(c4052kw, "3rd pass", iM12096vadzgd, iM12051Ucbh);
                }
            }
            i11 = i20;
        } else {
            i11 = iM12610FbxKQm;
        }
        c4052kw.m12624dkKKW(i11);
        return 0L;
    }

    /* renamed from: mjFkc */
    public final boolean m11742mjFkc(AZxh aZxh, C3776gjvQ c3776gjvQ, boolean z) {
        this.f13378AZxh.f13387mjFkc = c3776gjvQ.m12030HGpJ();
        this.f13378AZxh.f13381AZxh = c3776gjvQ.m12088rWxwaT();
        this.f13378AZxh.f13389wA = c3776gjvQ.m12096vadzgd();
        this.f13378AZxh.f13385ZfxDd = c3776gjvQ.m12051Ucbh();
        mjFkc mjfkc = this.f13378AZxh;
        mjfkc.f13388qdMbNW = false;
        mjfkc.f13382Dt = z;
        C3776gjvQ.AZxh aZxh2 = mjfkc.f13387mjFkc;
        C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
        boolean z2 = aZxh2 == aZxh3;
        boolean z3 = mjfkc.f13381AZxh == aZxh3;
        boolean z4 = z2 && c3776gjvQ.f13818oCFDzJ > 0.0f;
        boolean z5 = z3 && c3776gjvQ.f13818oCFDzJ > 0.0f;
        if (z4 && c3776gjvQ.f13800YoKzxo[0] == 4) {
            mjfkc.f13387mjFkc = C3776gjvQ.AZxh.FIXED;
        }
        if (z5 && c3776gjvQ.f13800YoKzxo[1] == 4) {
            mjfkc.f13381AZxh = C3776gjvQ.AZxh.FIXED;
        }
        aZxh.mo407AZxh(c3776gjvQ, mjfkc);
        c3776gjvQ.m12078jx(this.f13378AZxh.f13384KLFTb);
        c3776gjvQ.m12023ANMGZc(this.f13378AZxh.f13383JHa);
        c3776gjvQ.m12077jm(this.f13378AZxh.f13386lgHUyS);
        c3776gjvQ.m12059XV(this.f13378AZxh.f13390xJ);
        mjFkc mjfkc2 = this.f13378AZxh;
        mjfkc2.f13382Dt = false;
        return mjfkc2.f13388qdMbNW;
    }

    /* renamed from: wA */
    public final void m11743wA(C4052kw c4052kw, String str, int i, int i2) {
        int iM12083mByQ = c4052kw.m12083mByQ();
        int iM12098wJVbdd = c4052kw.m12098wJVbdd();
        c4052kw.m12075gtIJp(0);
        c4052kw.m12042NKyg(0);
        c4052kw.m12078jx(i);
        c4052kw.m12023ANMGZc(i2);
        c4052kw.m12075gtIJp(iM12083mByQ);
        c4052kw.m12042NKyg(iM12098wJVbdd);
        this.f13380wA.mo8794sRqPfw();
    }
}
