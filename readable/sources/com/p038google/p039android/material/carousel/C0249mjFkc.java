package com.p038google.p039android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p131o.AbstractC2506NPj;

/* renamed from: com.google.android.material.carousel.mjFkc */
/* loaded from: classes.dex */
public final class C0249mjFkc {

    /* renamed from: AZxh */
    public final List f2493AZxh;

    /* renamed from: ZfxDd */
    public final int f2494ZfxDd;

    /* renamed from: mjFkc */
    public final float f2495mjFkc;

    /* renamed from: wA */
    public final int f2496wA;

    /* renamed from: com.google.android.material.carousel.mjFkc$AZxh */
    public static final class AZxh {

        /* renamed from: ZfxDd */
        public wA f2500ZfxDd;

        /* renamed from: mjFkc */
        public final float f2501mjFkc;

        /* renamed from: wA */
        public wA f2502wA;

        /* renamed from: AZxh */
        public final List f2497AZxh = new ArrayList();

        /* renamed from: KLFTb */
        public int f2499KLFTb = -1;

        /* renamed from: JHa */
        public int f2498JHa = -1;

        /* renamed from: xJ */
        public float f2503xJ = 0.0f;

        public AZxh(float f) {
            this.f2501mjFkc = f;
        }

        /* renamed from: JHa */
        public static float m2690JHa(float f, float f2, int i, int i2) {
            return (f - (i * f2)) + (i2 * f2);
        }

        /* renamed from: AZxh */
        public AZxh m2691AZxh(float f, float f2, float f3, boolean z) {
            if (f3 <= 0.0f) {
                return this;
            }
            wA wAVar = new wA(Float.MIN_VALUE, f, f2, f3);
            if (z) {
                if (this.f2502wA == null) {
                    this.f2502wA = wAVar;
                    this.f2499KLFTb = this.f2497AZxh.size();
                }
                if (this.f2498JHa != -1 && this.f2497AZxh.size() - this.f2498JHa > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f3 != this.f2502wA.f2505ZfxDd) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f2500ZfxDd = wAVar;
                this.f2498JHa = this.f2497AZxh.size();
            } else {
                if (this.f2502wA == null && wAVar.f2505ZfxDd < this.f2503xJ) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f2500ZfxDd != null && wAVar.f2505ZfxDd > this.f2503xJ) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f2503xJ = wAVar.f2505ZfxDd;
            this.f2497AZxh.add(wAVar);
            return this;
        }

        /* renamed from: KLFTb */
        public C0249mjFkc m2692KLFTb() {
            if (this.f2502wA == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f2497AZxh.size(); i++) {
                wA wAVar = (wA) this.f2497AZxh.get(i);
                arrayList.add(new wA(m2690JHa(this.f2502wA.f2504AZxh, this.f2501mjFkc, this.f2499KLFTb, i), wAVar.f2504AZxh, wAVar.f2507wA, wAVar.f2505ZfxDd));
            }
            return new C0249mjFkc(this.f2501mjFkc, arrayList, this.f2499KLFTb, this.f2498JHa);
        }

        /* renamed from: ZfxDd */
        public AZxh m2693ZfxDd(float f, float f2, float f3, int i, boolean z) {
            if (i > 0 && f3 > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    m2691AZxh((i2 * f3) + f, f2, f3, z);
                }
            }
            return this;
        }

        /* renamed from: mjFkc */
        public AZxh m2694mjFkc(float f, float f2, float f3) {
            return m2691AZxh(f, f2, f3, false);
        }

        /* renamed from: wA */
        public AZxh m2695wA(float f, float f2, float f3, int i) {
            return m2693ZfxDd(f, f2, f3, i, false);
        }
    }

    /* renamed from: com.google.android.material.carousel.mjFkc$wA */
    public static final class wA {

        /* renamed from: AZxh */
        public final float f2504AZxh;

        /* renamed from: ZfxDd */
        public final float f2505ZfxDd;

        /* renamed from: mjFkc */
        public final float f2506mjFkc;

        /* renamed from: wA */
        public final float f2507wA;

        public wA(float f, float f2, float f3, float f4) {
            this.f2506mjFkc = f;
            this.f2504AZxh = f2;
            this.f2507wA = f3;
            this.f2505ZfxDd = f4;
        }

        /* renamed from: mjFkc */
        public static wA m2696mjFkc(wA wAVar, wA wAVar2, float f) {
            return new wA(AbstractC2506NPj.m9656mjFkc(wAVar.f2506mjFkc, wAVar2.f2506mjFkc, f), AbstractC2506NPj.m9656mjFkc(wAVar.f2504AZxh, wAVar2.f2504AZxh, f), AbstractC2506NPj.m9656mjFkc(wAVar.f2507wA, wAVar2.f2507wA, f), AbstractC2506NPj.m9656mjFkc(wAVar.f2505ZfxDd, wAVar2.f2505ZfxDd, f));
        }
    }

    /* renamed from: Dt */
    public static C0249mjFkc m2680Dt(C0249mjFkc c0249mjFkc) {
        AZxh aZxh = new AZxh(c0249mjFkc.m2685ZfxDd());
        float f = c0249mjFkc.m2688wA().f2504AZxh - (c0249mjFkc.m2688wA().f2505ZfxDd / 2.0f);
        int size = c0249mjFkc.m2684KLFTb().size() - 1;
        while (size >= 0) {
            wA wAVar = (wA) c0249mjFkc.m2684KLFTb().get(size);
            aZxh.m2691AZxh((wAVar.f2505ZfxDd / 2.0f) + f, wAVar.f2507wA, wAVar.f2505ZfxDd, size >= c0249mjFkc.m2682AZxh() && size <= c0249mjFkc.m2689xJ());
            f += wAVar.f2505ZfxDd;
            size--;
        }
        return aZxh.m2692KLFTb();
    }

    /* renamed from: qdMbNW */
    public static C0249mjFkc m2681qdMbNW(C0249mjFkc c0249mjFkc, C0249mjFkc c0249mjFkc2, float f) {
        if (c0249mjFkc.m2685ZfxDd() != c0249mjFkc2.m2685ZfxDd()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List listM2684KLFTb = c0249mjFkc.m2684KLFTb();
        List listM2684KLFTb2 = c0249mjFkc2.m2684KLFTb();
        if (listM2684KLFTb.size() != listM2684KLFTb2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0249mjFkc.m2684KLFTb().size(); i++) {
            arrayList.add(wA.m2696mjFkc((wA) listM2684KLFTb.get(i), (wA) listM2684KLFTb2.get(i), f));
        }
        return new C0249mjFkc(c0249mjFkc.m2685ZfxDd(), arrayList, AbstractC2506NPj.m9657wA(c0249mjFkc.m2682AZxh(), c0249mjFkc2.m2682AZxh(), f), AbstractC2506NPj.m9657wA(c0249mjFkc.m2689xJ(), c0249mjFkc2.m2689xJ(), f));
    }

    /* renamed from: AZxh */
    public int m2682AZxh() {
        return this.f2496wA;
    }

    /* renamed from: JHa */
    public wA m2683JHa() {
        return (wA) this.f2493AZxh.get(this.f2494ZfxDd);
    }

    /* renamed from: KLFTb */
    public List m2684KLFTb() {
        return this.f2493AZxh;
    }

    /* renamed from: ZfxDd */
    public float m2685ZfxDd() {
        return this.f2495mjFkc;
    }

    /* renamed from: lgHUyS */
    public wA m2686lgHUyS() {
        return (wA) this.f2493AZxh.get(r1.size() - 1);
    }

    /* renamed from: mjFkc */
    public wA m2687mjFkc() {
        return (wA) this.f2493AZxh.get(this.f2496wA);
    }

    /* renamed from: wA */
    public wA m2688wA() {
        return (wA) this.f2493AZxh.get(0);
    }

    /* renamed from: xJ */
    public int m2689xJ() {
        return this.f2494ZfxDd;
    }

    public C0249mjFkc(float f, List list, int i, int i2) {
        this.f2495mjFkc = f;
        this.f2493AZxh = Collections.unmodifiableList(list);
        this.f2496wA = i;
        this.f2494ZfxDd = i2;
    }
}
