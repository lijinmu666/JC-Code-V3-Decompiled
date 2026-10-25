package p131o;

import java.util.Arrays;
import java.util.Comparator;
import org.conscrypt.BuildConfig;
import p131o.C4955yX;

/* renamed from: o.M3 */
/* loaded from: classes.dex */
public class C2411M3 extends C4955yX {

    /* renamed from: Dt */
    public int f9541Dt;

    /* renamed from: ETF */
    public AZxh f9542ETF;

    /* renamed from: VA */
    public C2768RWyiuY f9543VA;

    /* renamed from: lgHUyS */
    public C3274Z6[] f9544lgHUyS;

    /* renamed from: qdMbNW */
    public C3274Z6[] f9545qdMbNW;

    /* renamed from: xJ */
    public int f9546xJ;

    /* renamed from: o.M3$AZxh */
    public class AZxh implements Comparable {

        /* renamed from: AZxh */
        public C2411M3 f9547AZxh;

        /* renamed from: mjFkc */
        public C3274Z6 f9548mjFkc;

        public AZxh(C2411M3 c2411m3) {
            this.f9547AZxh = c2411m3;
        }

        /* renamed from: Dt */
        public final boolean m9477Dt(C3274Z6 c3274z6) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = c3274z6.f11983qdMbNW[i];
                float f2 = this.f9548mjFkc.f11983qdMbNW[i];
                if (f2 == f) {
                    i--;
                } else if (f2 < f) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: ETF */
        public void m9478ETF() {
            Arrays.fill(this.f9548mjFkc.f11983qdMbNW, 0.0f);
        }

        /* renamed from: KLFTb */
        public boolean m9479KLFTb(C3274Z6 c3274z6, float f) {
            boolean z = true;
            if (!this.f9548mjFkc.f11982mjFkc) {
                for (int i = 0; i < 9; i++) {
                    float f2 = c3274z6.f11983qdMbNW[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.f9548mjFkc.f11983qdMbNW[i] = f3;
                    } else {
                        this.f9548mjFkc.f11983qdMbNW[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f9548mjFkc.f11983qdMbNW;
                float f4 = fArr[i2] + (c3274z6.f11983qdMbNW[i2] * f);
                fArr[i2] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.f9548mjFkc.f11983qdMbNW[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                C2411M3.this.m9472Ne(this.f9548mjFkc);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f9548mjFkc.f11984wA - ((C3274Z6) obj).f11984wA;
        }

        /* renamed from: lgHUyS */
        public void m9480lgHUyS(C3274Z6 c3274z6) {
            this.f9548mjFkc = c3274z6;
        }

        /* renamed from: qdMbNW */
        public final boolean m9481qdMbNW() {
            for (int i = 8; i >= 0; i--) {
                float f = this.f9548mjFkc.f11983qdMbNW[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            String str = "[ ";
            if (this.f9548mjFkc != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.f9548mjFkc.f11983qdMbNW[i] + " ";
                }
            }
            return str + "] " + this.f9548mjFkc;
        }
    }

    /* renamed from: o.M3$mjFkc */
    public class mjFkc implements Comparator {
        public mjFkc() {
        }

        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(C3274Z6 c3274z6, C3274Z6 c3274z62) {
            return c3274z6.f11984wA - c3274z62.f11984wA;
        }
    }

    public C2411M3(C2768RWyiuY c2768RWyiuY) {
        super(c2768RWyiuY);
        this.f9546xJ = 128;
        this.f9544lgHUyS = new C3274Z6[128];
        this.f9545qdMbNW = new C3274Z6[128];
        this.f9541Dt = 0;
        this.f9542ETF = new AZxh(this);
        this.f9543VA = c2768RWyiuY;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // p131o.C4955yX, p131o.C3202Y0.mjFkc
    /* renamed from: AZxh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C3274Z6 mo9471AZxh(C3202Y0 c3202y0, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.f9541Dt; i2++) {
            C3274Z6 c3274z6 = this.f9544lgHUyS[i2];
            if (!zArr[c3274z6.f11984wA]) {
                this.f9542ETF.m9480lgHUyS(c3274z6);
                if (i == -1) {
                    if (this.f9542ETF.m9481qdMbNW()) {
                        i = i2;
                    }
                } else if (this.f9542ETF.m9477Dt(this.f9544lgHUyS[i])) {
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f9544lgHUyS[i];
    }

    /* renamed from: Ne */
    public final void m9472Ne(C3274Z6 c3274z6) {
        int i = 0;
        while (i < this.f9541Dt) {
            if (this.f9544lgHUyS[i] == c3274z6) {
                while (true) {
                    int i2 = this.f9541Dt;
                    if (i >= i2 - 1) {
                        this.f9541Dt = i2 - 1;
                        c3274z6.f11982mjFkc = false;
                        return;
                    } else {
                        C3274Z6[] c3274z6Arr = this.f9544lgHUyS;
                        int i3 = i + 1;
                        c3274z6Arr[i] = c3274z6Arr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    /* renamed from: OjSQV */
    public final void m9473OjSQV(C3274Z6 c3274z6) {
        int i;
        int i2 = this.f9541Dt + 1;
        C3274Z6[] c3274z6Arr = this.f9544lgHUyS;
        if (i2 > c3274z6Arr.length) {
            C3274Z6[] c3274z6Arr2 = (C3274Z6[]) Arrays.copyOf(c3274z6Arr, c3274z6Arr.length * 2);
            this.f9544lgHUyS = c3274z6Arr2;
            this.f9545qdMbNW = (C3274Z6[]) Arrays.copyOf(c3274z6Arr2, c3274z6Arr2.length * 2);
        }
        C3274Z6[] c3274z6Arr3 = this.f9544lgHUyS;
        int i3 = this.f9541Dt;
        c3274z6Arr3[i3] = c3274z6;
        int i4 = i3 + 1;
        this.f9541Dt = i4;
        if (i4 > 1 && c3274z6Arr3[i3].f11984wA > c3274z6.f11984wA) {
            int i5 = 0;
            while (true) {
                i = this.f9541Dt;
                if (i5 >= i) {
                    break;
                }
                this.f9545qdMbNW[i5] = this.f9544lgHUyS[i5];
                i5++;
            }
            Arrays.sort(this.f9545qdMbNW, 0, i, new mjFkc());
            for (int i6 = 0; i6 < this.f9541Dt; i6++) {
                this.f9544lgHUyS[i6] = this.f9545qdMbNW[i6];
            }
        }
        c3274z6.f11982mjFkc = true;
        c3274z6.m11178mjFkc(this);
    }

    @Override // p131o.C4955yX, p131o.C3202Y0.mjFkc
    /* renamed from: clear */
    public void mo9474clear() {
        this.f9541Dt = 0;
        this.f17528AZxh = 0.0f;
    }

    @Override // p131o.C4955yX
    /* renamed from: lB */
    public void mo9475lB(C4955yX c4955yX, boolean z) {
        C3274Z6 c3274z6 = c4955yX.f17532mjFkc;
        if (c3274z6 == null) {
            return;
        }
        C4955yX.mjFkc mjfkc = c4955yX.f17530KLFTb;
        int iMo11285ZfxDd = mjfkc.mo11285ZfxDd();
        for (int i = 0; i < iMo11285ZfxDd; i++) {
            C3274Z6 c3274z6Mo11288lgHUyS = mjfkc.mo11288lgHUyS(i);
            float fMo11289mjFkc = mjfkc.mo11289mjFkc(i);
            this.f9542ETF.m9480lgHUyS(c3274z6Mo11288lgHUyS);
            if (this.f9542ETF.m9479KLFTb(c3274z6, fMo11289mjFkc)) {
                m9473OjSQV(c3274z6Mo11288lgHUyS);
            }
            this.f17528AZxh += c4955yX.f17528AZxh * fMo11289mjFkc;
        }
        m9472Ne(c3274z6);
    }

    @Override // p131o.C4955yX, p131o.C3202Y0.mjFkc
    /* renamed from: mjFkc */
    public void mo9476mjFkc(C3274Z6 c3274z6) {
        this.f9542ETF.m9480lgHUyS(c3274z6);
        this.f9542ETF.m9478ETF();
        c3274z6.f11983qdMbNW[c3274z6.f11976KLFTb] = 1.0f;
        m9473OjSQV(c3274z6);
    }

    @Override // p131o.C4955yX
    public String toString() {
        String str = BuildConfig.f24315FLAVOR + " goal -> (" + this.f17528AZxh + ") : ";
        for (int i = 0; i < this.f9541Dt; i++) {
            this.f9542ETF.m9480lgHUyS(this.f9544lgHUyS[i]);
            str = str + this.f9542ETF + " ";
        }
        return str;
    }
}
