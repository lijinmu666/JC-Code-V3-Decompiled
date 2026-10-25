package p131o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.rdtF */
/* loaded from: classes.dex */
public class C4494rdtF implements InterfaceC2695QQi {

    /* renamed from: JHa */
    public int f16350JHa;

    /* renamed from: ZfxDd */
    public AbstractC2246Ja f16353ZfxDd;

    /* renamed from: xJ */
    public int f16358xJ;

    /* renamed from: mjFkc */
    public InterfaceC2695QQi f16355mjFkc = null;

    /* renamed from: AZxh */
    public boolean f16347AZxh = false;

    /* renamed from: wA */
    public boolean f16357wA = false;

    /* renamed from: KLFTb */
    public mjFkc f16351KLFTb = mjFkc.UNKNOWN;

    /* renamed from: lgHUyS */
    public int f16354lgHUyS = 1;

    /* renamed from: qdMbNW */
    public C1691BOPu f16356qdMbNW = null;

    /* renamed from: Dt */
    public boolean f16348Dt = false;

    /* renamed from: ETF */
    public List f16349ETF = new ArrayList();

    /* renamed from: VA */
    public List f16352VA = new ArrayList();

    /* renamed from: o.rdtF$mjFkc */
    public enum mjFkc {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public C4494rdtF(AbstractC2246Ja abstractC2246Ja) {
        this.f16353ZfxDd = abstractC2246Ja;
    }

    /* renamed from: AZxh */
    public void m13386AZxh(InterfaceC2695QQi interfaceC2695QQi) {
        this.f16349ETF.add(interfaceC2695QQi);
        if (this.f16348Dt) {
            interfaceC2695QQi.mo7521mjFkc(interfaceC2695QQi);
        }
    }

    /* renamed from: ZfxDd */
    public void mo7695ZfxDd(int i) {
        if (this.f16348Dt) {
            return;
        }
        this.f16348Dt = true;
        this.f16358xJ = i;
        for (InterfaceC2695QQi interfaceC2695QQi : this.f16349ETF) {
            interfaceC2695QQi.mo7521mjFkc(interfaceC2695QQi);
        }
    }

    @Override // p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        Iterator it = this.f16352VA.iterator();
        while (it.hasNext()) {
            if (!((C4494rdtF) it.next()).f16348Dt) {
                return;
            }
        }
        this.f16357wA = true;
        InterfaceC2695QQi interfaceC2695QQi2 = this.f16355mjFkc;
        if (interfaceC2695QQi2 != null) {
            interfaceC2695QQi2.mo7521mjFkc(this);
        }
        if (this.f16347AZxh) {
            this.f16353ZfxDd.mo7521mjFkc(this);
            return;
        }
        C4494rdtF c4494rdtF = null;
        int i = 0;
        for (C4494rdtF c4494rdtF2 : this.f16352VA) {
            if (!(c4494rdtF2 instanceof C1691BOPu)) {
                i++;
                c4494rdtF = c4494rdtF2;
            }
        }
        if (c4494rdtF != null && i == 1 && c4494rdtF.f16348Dt) {
            C1691BOPu c1691BOPu = this.f16356qdMbNW;
            if (c1691BOPu != null) {
                if (!c1691BOPu.f16348Dt) {
                    return;
                } else {
                    this.f16350JHa = this.f16354lgHUyS * c1691BOPu.f16358xJ;
                }
            }
            mo7695ZfxDd(c4494rdtF.f16358xJ + this.f16350JHa);
        }
        InterfaceC2695QQi interfaceC2695QQi3 = this.f16355mjFkc;
        if (interfaceC2695QQi3 != null) {
            interfaceC2695QQi3.mo7521mjFkc(this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f16353ZfxDd.f8996AZxh.m12031IEE());
        sb.append(":");
        sb.append(this.f16351KLFTb);
        sb.append("(");
        sb.append(this.f16348Dt ? Integer.valueOf(this.f16358xJ) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f16352VA.size());
        sb.append(":d=");
        sb.append(this.f16349ETF.size());
        sb.append(">");
        return sb.toString();
    }

    /* renamed from: wA */
    public void m13387wA() {
        this.f16352VA.clear();
        this.f16349ETF.clear();
        this.f16348Dt = false;
        this.f16358xJ = 0;
        this.f16357wA = false;
        this.f16347AZxh = false;
    }
}
