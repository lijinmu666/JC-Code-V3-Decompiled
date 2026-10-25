package androidx.recyclerview.p023widget;

import androidx.recyclerview.p023widget.RecyclerView;
import p131o.C1733C3;
import p131o.C3074W6;
import p131o.C4253o1;
import p131o.InterfaceC1601A3;

/* renamed from: androidx.recyclerview.widget.qGY */
/* loaded from: classes.dex */
public class C0177qGY {

    /* renamed from: mjFkc */
    public final C3074W6 f1867mjFkc = new C3074W6();

    /* renamed from: AZxh */
    public final C4253o1 f1866AZxh = new C4253o1();

    /* renamed from: androidx.recyclerview.widget.qGY$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        void mo1631AZxh(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2);

        /* renamed from: ZfxDd */
        void mo1632ZfxDd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2);

        /* renamed from: mjFkc */
        void mo1633mjFkc(RecyclerView.AbstractC0157mByQ abstractC0157mByQ);

        /* renamed from: wA */
        void mo1634wA(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh, RecyclerView.AbstractC0144MiMN.AZxh aZxh2);
    }

    /* renamed from: androidx.recyclerview.widget.qGY$mjFkc */
    public static class mjFkc {

        /* renamed from: ZfxDd */
        public static InterfaceC1601A3 f1868ZfxDd = new C1733C3(20);

        /* renamed from: AZxh */
        public RecyclerView.AbstractC0144MiMN.AZxh f1869AZxh;

        /* renamed from: mjFkc */
        public int f1870mjFkc;

        /* renamed from: wA */
        public RecyclerView.AbstractC0144MiMN.AZxh f1871wA;

        /* renamed from: AZxh */
        public static mjFkc m2040AZxh() {
            mjFkc mjfkc = (mjFkc) f1868ZfxDd.mo7550AZxh();
            return mjfkc == null ? new mjFkc() : mjfkc;
        }

        /* renamed from: mjFkc */
        public static void m2041mjFkc() {
            while (f1868ZfxDd.mo7550AZxh() != null) {
            }
        }

        /* renamed from: wA */
        public static void m2042wA(mjFkc mjfkc) {
            mjfkc.f1870mjFkc = 0;
            mjfkc.f1869AZxh = null;
            mjfkc.f1871wA = null;
            f1868ZfxDd.mo7551mjFkc(mjfkc);
        }
    }

    /* renamed from: AZxh */
    public void m2023AZxh(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        mjFkc mjfkcM2040AZxh = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        if (mjfkcM2040AZxh == null) {
            mjfkcM2040AZxh = mjFkc.m2040AZxh();
            this.f1867mjFkc.m10821put(abstractC0157mByQ, mjfkcM2040AZxh);
        }
        mjfkcM2040AZxh.f1870mjFkc |= 1;
    }

    /* renamed from: Dt */
    public void m2024Dt() {
        mjFkc.m2041mjFkc();
    }

    /* renamed from: ETF */
    public void m2025ETF(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        m2035qGY(abstractC0157mByQ);
    }

    /* renamed from: JHa */
    public void m2026JHa() {
        this.f1867mjFkc.m10815clear();
        this.f1866AZxh.m12924mjFkc();
    }

    /* renamed from: KLFTb */
    public void m2027KLFTb(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh) {
        mjFkc mjfkcM2040AZxh = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        if (mjfkcM2040AZxh == null) {
            mjfkcM2040AZxh = mjFkc.m2040AZxh();
            this.f1867mjFkc.m10821put(abstractC0157mByQ, mjfkcM2040AZxh);
        }
        mjfkcM2040AZxh.f1869AZxh = aZxh;
        mjfkcM2040AZxh.f1870mjFkc |= 4;
    }

    /* renamed from: MiMN */
    public RecyclerView.AbstractC0144MiMN.AZxh m2028MiMN(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        return m2029VA(abstractC0157mByQ, 8);
    }

    /* renamed from: VA */
    public final RecyclerView.AbstractC0144MiMN.AZxh m2029VA(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, int i) {
        mjFkc mjfkc;
        RecyclerView.AbstractC0144MiMN.AZxh aZxh;
        int iM10811JHa = this.f1867mjFkc.m10811JHa(abstractC0157mByQ);
        if (iM10811JHa >= 0 && (mjfkc = (mjFkc) this.f1867mjFkc.m10813MiMN(iM10811JHa)) != null) {
            int i2 = mjfkc.f1870mjFkc;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                mjfkc.f1870mjFkc = i3;
                if (i == 4) {
                    aZxh = mjfkc.f1869AZxh;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    aZxh = mjfkc.f1871wA;
                }
                if ((i3 & 12) == 0) {
                    this.f1867mjFkc.m10810ETF(iM10811JHa);
                    mjFkc.m2042wA(mjfkc);
                }
                return aZxh;
            }
        }
        return null;
    }

    /* renamed from: YoKzxo */
    public RecyclerView.AbstractC0144MiMN.AZxh m2030YoKzxo(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        return m2029VA(abstractC0157mByQ, 4);
    }

    /* renamed from: ZfxDd */
    public void m2031ZfxDd(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh) {
        mjFkc mjfkcM2040AZxh = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        if (mjfkcM2040AZxh == null) {
            mjfkcM2040AZxh = mjFkc.m2040AZxh();
            this.f1867mjFkc.m10821put(abstractC0157mByQ, mjfkcM2040AZxh);
        }
        mjfkcM2040AZxh.f1871wA = aZxh;
        mjfkcM2040AZxh.f1870mjFkc |= 8;
    }

    /* renamed from: fehf */
    public void m2032fehf(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        int iM12919MiMN = this.f1866AZxh.m12919MiMN() - 1;
        while (true) {
            if (iM12919MiMN < 0) {
                break;
            }
            if (abstractC0157mByQ == this.f1866AZxh.m12921YoKzxo(iM12919MiMN)) {
                this.f1866AZxh.m12920VA(iM12919MiMN);
                break;
            }
            iM12919MiMN--;
        }
        mjFkc mjfkc = (mjFkc) this.f1867mjFkc.m10823remove(abstractC0157mByQ);
        if (mjfkc != null) {
            mjFkc.m2042wA(mjfkc);
        }
    }

    /* renamed from: lgHUyS */
    public boolean m2033lgHUyS(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        mjFkc mjfkc = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        return (mjfkc == null || (mjfkc.f1870mjFkc & 1) == 0) ? false : true;
    }

    /* renamed from: mjFkc */
    public void m2034mjFkc(RecyclerView.AbstractC0157mByQ abstractC0157mByQ, RecyclerView.AbstractC0144MiMN.AZxh aZxh) {
        mjFkc mjfkcM2040AZxh = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        if (mjfkcM2040AZxh == null) {
            mjfkcM2040AZxh = mjFkc.m2040AZxh();
            this.f1867mjFkc.m10821put(abstractC0157mByQ, mjfkcM2040AZxh);
        }
        mjfkcM2040AZxh.f1870mjFkc |= 2;
        mjfkcM2040AZxh.f1869AZxh = aZxh;
    }

    /* renamed from: qGY */
    public void m2035qGY(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        mjFkc mjfkc = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        if (mjfkc == null) {
            return;
        }
        mjfkc.f1870mjFkc &= -2;
    }

    /* renamed from: qdMbNW */
    public boolean m2036qdMbNW(RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        mjFkc mjfkc = (mjFkc) this.f1867mjFkc.m10817get(abstractC0157mByQ);
        return (mjfkc == null || (mjfkc.f1870mjFkc & 4) == 0) ? false : true;
    }

    /* renamed from: rkYL */
    public void m2037rkYL(AZxh aZxh) {
        for (int iM10827size = this.f1867mjFkc.m10827size() - 1; iM10827size >= 0; iM10827size--) {
            RecyclerView.AbstractC0157mByQ abstractC0157mByQ = (RecyclerView.AbstractC0157mByQ) this.f1867mjFkc.m10822qdMbNW(iM10827size);
            mjFkc mjfkc = (mjFkc) this.f1867mjFkc.m10810ETF(iM10827size);
            int i = mjfkc.f1870mjFkc;
            if ((i & 3) == 3) {
                aZxh.mo1633mjFkc(abstractC0157mByQ);
            } else if ((i & 1) != 0) {
                RecyclerView.AbstractC0144MiMN.AZxh aZxh2 = mjfkc.f1869AZxh;
                if (aZxh2 == null) {
                    aZxh.mo1633mjFkc(abstractC0157mByQ);
                } else {
                    aZxh.mo1634wA(abstractC0157mByQ, aZxh2, mjfkc.f1871wA);
                }
            } else if ((i & 14) == 14) {
                aZxh.mo1631AZxh(abstractC0157mByQ, mjfkc.f1869AZxh, mjfkc.f1871wA);
            } else if ((i & 12) == 12) {
                aZxh.mo1632ZfxDd(abstractC0157mByQ, mjfkc.f1869AZxh, mjfkc.f1871wA);
            } else if ((i & 4) != 0) {
                aZxh.mo1634wA(abstractC0157mByQ, mjfkc.f1869AZxh, null);
            } else if ((i & 8) != 0) {
                aZxh.mo1631AZxh(abstractC0157mByQ, mjfkc.f1869AZxh, mjfkc.f1871wA);
            }
            mjFkc.m2042wA(mjfkc);
        }
    }

    /* renamed from: wA */
    public void m2038wA(long j, RecyclerView.AbstractC0157mByQ abstractC0157mByQ) {
        this.f1866AZxh.m12915Dt(j, abstractC0157mByQ);
    }

    /* renamed from: xJ */
    public RecyclerView.AbstractC0157mByQ m2039xJ(long j) {
        return (RecyclerView.AbstractC0157mByQ) this.f1866AZxh.m12918KLFTb(j);
    }
}
