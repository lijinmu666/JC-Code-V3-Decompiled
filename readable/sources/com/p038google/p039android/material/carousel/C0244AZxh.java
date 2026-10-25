package com.p038google.p039android.material.carousel;

import com.p038google.p039android.material.carousel.C0249mjFkc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p131o.AbstractC2506NPj;
import p131o.InterfaceC4810wLtdyQ;

/* renamed from: com.google.android.material.carousel.AZxh */
/* loaded from: classes.dex */
public class C0244AZxh {

    /* renamed from: AZxh */
    public final List f2469AZxh;

    /* renamed from: JHa */
    public final float f2470JHa;

    /* renamed from: KLFTb */
    public final float[] f2471KLFTb;

    /* renamed from: ZfxDd */
    public final float[] f2472ZfxDd;

    /* renamed from: mjFkc */
    public final C0249mjFkc f2473mjFkc;

    /* renamed from: wA */
    public final List f2474wA;

    /* renamed from: xJ */
    public final float f2475xJ;

    public C0244AZxh(C0249mjFkc c0249mjFkc, List list, List list2) {
        this.f2473mjFkc = c0249mjFkc;
        this.f2469AZxh = Collections.unmodifiableList(list);
        this.f2474wA = Collections.unmodifiableList(list2);
        float f = ((C0249mjFkc) list.get(list.size() - 1)).m2688wA().f2506mjFkc - c0249mjFkc.m2688wA().f2506mjFkc;
        this.f2470JHa = f;
        float f2 = c0249mjFkc.m2686lgHUyS().f2506mjFkc - ((C0249mjFkc) list2.get(list2.size() - 1)).m2686lgHUyS().f2506mjFkc;
        this.f2475xJ = f2;
        this.f2472ZfxDd = m2627Dt(f, list, true);
        this.f2471KLFTb = m2627Dt(f2, list2, false);
    }

    /* renamed from: AZxh */
    public static int m2626AZxh(C0249mjFkc c0249mjFkc, float f) {
        for (int iM2689xJ = c0249mjFkc.m2689xJ(); iM2689xJ < c0249mjFkc.m2684KLFTb().size(); iM2689xJ++) {
            if (f == ((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(iM2689xJ)).f2507wA) {
                return iM2689xJ;
            }
        }
        return c0249mjFkc.m2684KLFTb().size() - 1;
    }

    /* renamed from: Dt */
    public static float[] m2627Dt(float f, List list, boolean z) {
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            C0249mjFkc c0249mjFkc = (C0249mjFkc) list.get(i2);
            C0249mjFkc c0249mjFkc2 = (C0249mjFkc) list.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i2] + ((z ? c0249mjFkc2.m2688wA().f2506mjFkc - c0249mjFkc.m2688wA().f2506mjFkc : c0249mjFkc.m2686lgHUyS().f2506mjFkc - c0249mjFkc2.m2686lgHUyS().f2506mjFkc) / f);
            i++;
        }
        return fArr;
    }

    /* renamed from: ETF */
    public static List m2628ETF(C0249mjFkc c0249mjFkc) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0249mjFkc);
        int iM2634mjFkc = m2634mjFkc(c0249mjFkc);
        if (!m2630MiMN(c0249mjFkc) && iM2634mjFkc != -1) {
            int iM2682AZxh = (c0249mjFkc.m2682AZxh() - 1) - iM2634mjFkc;
            float f = c0249mjFkc.m2688wA().f2504AZxh - (c0249mjFkc.m2688wA().f2505ZfxDd / 2.0f);
            for (int i = 0; i <= iM2682AZxh; i++) {
                C0249mjFkc c0249mjFkc2 = (C0249mjFkc) arrayList.get(arrayList.size() - 1);
                int size = c0249mjFkc.m2684KLFTb().size() - 1;
                int i2 = (iM2634mjFkc + i) - 1;
                if (i2 >= 0) {
                    size = m2626AZxh(c0249mjFkc2, ((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(i2)).f2507wA) - 1;
                }
                arrayList.add(m2635qGY(c0249mjFkc2, iM2634mjFkc, size, f, (c0249mjFkc.m2682AZxh() - i) - 1, (c0249mjFkc.m2689xJ() - i) - 1));
            }
        }
        return arrayList;
    }

    /* renamed from: KLFTb */
    public static C0244AZxh m2629KLFTb(InterfaceC4810wLtdyQ interfaceC4810wLtdyQ, C0249mjFkc c0249mjFkc) {
        return new C0244AZxh(c0249mjFkc, m2628ETF(c0249mjFkc), m2631VA(interfaceC4810wLtdyQ, c0249mjFkc));
    }

    /* renamed from: MiMN */
    public static boolean m2630MiMN(C0249mjFkc c0249mjFkc) {
        return c0249mjFkc.m2687mjFkc().f2504AZxh - (c0249mjFkc.m2687mjFkc().f2505ZfxDd / 2.0f) <= 0.0f || c0249mjFkc.m2687mjFkc() == c0249mjFkc.m2688wA();
    }

    /* renamed from: VA */
    public static List m2631VA(InterfaceC4810wLtdyQ interfaceC4810wLtdyQ, C0249mjFkc c0249mjFkc) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0249mjFkc);
        int iM2637wA = m2637wA(interfaceC4810wLtdyQ, c0249mjFkc);
        if (!m2632YoKzxo(interfaceC4810wLtdyQ, c0249mjFkc) && iM2637wA != -1) {
            int iM2689xJ = iM2637wA - c0249mjFkc.m2689xJ();
            float f = c0249mjFkc.m2688wA().f2504AZxh - (c0249mjFkc.m2688wA().f2505ZfxDd / 2.0f);
            for (int i = 0; i < iM2689xJ; i++) {
                C0249mjFkc c0249mjFkc2 = (C0249mjFkc) arrayList.get(arrayList.size() - 1);
                int i2 = (iM2637wA - i) + 1;
                arrayList.add(m2635qGY(c0249mjFkc2, iM2637wA, i2 < c0249mjFkc.m2684KLFTb().size() ? m2633ZfxDd(c0249mjFkc2, ((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(i2)).f2507wA) + 1 : 0, f, c0249mjFkc.m2682AZxh() + i + 1, c0249mjFkc.m2689xJ() + i + 1));
            }
        }
        return arrayList;
    }

    /* renamed from: YoKzxo */
    public static boolean m2632YoKzxo(InterfaceC4810wLtdyQ interfaceC4810wLtdyQ, C0249mjFkc c0249mjFkc) {
        return c0249mjFkc.m2683JHa().f2504AZxh + (c0249mjFkc.m2683JHa().f2505ZfxDd / 2.0f) >= ((float) interfaceC4810wLtdyQ.mo2670mjFkc()) || c0249mjFkc.m2683JHa() == c0249mjFkc.m2686lgHUyS();
    }

    /* renamed from: ZfxDd */
    public static int m2633ZfxDd(C0249mjFkc c0249mjFkc, float f) {
        for (int iM2682AZxh = c0249mjFkc.m2682AZxh() - 1; iM2682AZxh >= 0; iM2682AZxh--) {
            if (f == ((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(iM2682AZxh)).f2507wA) {
                return iM2682AZxh;
            }
        }
        return 0;
    }

    /* renamed from: mjFkc */
    public static int m2634mjFkc(C0249mjFkc c0249mjFkc) {
        for (int i = 0; i < c0249mjFkc.m2684KLFTb().size(); i++) {
            if (((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(i)).f2504AZxh >= 0.0f) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: qGY */
    public static C0249mjFkc m2635qGY(C0249mjFkc c0249mjFkc, int i, int i2, float f, int i3, int i4) {
        ArrayList arrayList = new ArrayList(c0249mjFkc.m2684KLFTb());
        arrayList.add(i2, (C0249mjFkc.wA) arrayList.remove(i));
        C0249mjFkc.AZxh aZxh = new C0249mjFkc.AZxh(c0249mjFkc.m2685ZfxDd());
        int i5 = 0;
        while (i5 < arrayList.size()) {
            C0249mjFkc.wA wAVar = (C0249mjFkc.wA) arrayList.get(i5);
            float f2 = wAVar.f2505ZfxDd;
            aZxh.m2691AZxh((f2 / 2.0f) + f, wAVar.f2507wA, f2, i5 >= i3 && i5 <= i4);
            f += wAVar.f2505ZfxDd;
            i5++;
        }
        return aZxh.m2692KLFTb();
    }

    /* renamed from: rkYL */
    public static C0249mjFkc m2636rkYL(List list, float f, float[] fArr) {
        int size = list.size();
        float f2 = fArr[0];
        int i = 1;
        while (i < size) {
            float f3 = fArr[i];
            if (f <= f3) {
                return C0249mjFkc.m2681qdMbNW((C0249mjFkc) list.get(i - 1), (C0249mjFkc) list.get(i), AbstractC2506NPj.m9655AZxh(0.0f, 1.0f, f2, f3, f));
            }
            i++;
            f2 = f3;
        }
        return (C0249mjFkc) list.get(0);
    }

    /* renamed from: wA */
    public static int m2637wA(InterfaceC4810wLtdyQ interfaceC4810wLtdyQ, C0249mjFkc c0249mjFkc) {
        for (int size = c0249mjFkc.m2684KLFTb().size() - 1; size >= 0; size--) {
            if (((C0249mjFkc.wA) c0249mjFkc.m2684KLFTb().get(size)).f2504AZxh <= interfaceC4810wLtdyQ.mo2670mjFkc()) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: JHa */
    public C0249mjFkc m2638JHa() {
        return this.f2473mjFkc;
    }

    /* renamed from: lgHUyS */
    public C0249mjFkc m2639lgHUyS() {
        return (C0249mjFkc) this.f2474wA.get(r1.size() - 1);
    }

    /* renamed from: qdMbNW */
    public C0249mjFkc m2640qdMbNW(float f, float f2, float f3) {
        float f4 = this.f2470JHa + f2;
        float f5 = f3 - this.f2475xJ;
        if (f < f4) {
            return m2636rkYL(this.f2469AZxh, AbstractC2506NPj.m9655AZxh(1.0f, 0.0f, f2, f4, f), this.f2472ZfxDd);
        }
        if (f <= f5) {
            return this.f2473mjFkc;
        }
        return m2636rkYL(this.f2474wA, AbstractC2506NPj.m9655AZxh(0.0f, 1.0f, f5, f3, f), this.f2471KLFTb);
    }

    /* renamed from: xJ */
    public C0249mjFkc m2641xJ() {
        return (C0249mjFkc) this.f2469AZxh.get(r1.size() - 1);
    }
}
