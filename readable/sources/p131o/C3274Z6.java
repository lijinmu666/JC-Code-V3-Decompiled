package p131o;

import java.util.Arrays;
import java.util.HashSet;
import org.conscrypt.BuildConfig;

/* renamed from: o.Z6 */
/* loaded from: classes.dex */
public class C3274Z6 {

    /* renamed from: rkYL */
    public static int f11971rkYL = 1;

    /* renamed from: AZxh */
    public String f11972AZxh;

    /* renamed from: Dt */
    public mjFkc f11973Dt;

    /* renamed from: JHa */
    public float f11975JHa;

    /* renamed from: mjFkc */
    public boolean f11982mjFkc;

    /* renamed from: wA */
    public int f11984wA = -1;

    /* renamed from: ZfxDd */
    public int f11980ZfxDd = -1;

    /* renamed from: KLFTb */
    public int f11976KLFTb = 0;

    /* renamed from: xJ */
    public boolean f11985xJ = false;

    /* renamed from: lgHUyS */
    public float[] f11981lgHUyS = new float[9];

    /* renamed from: qdMbNW */
    public float[] f11983qdMbNW = new float[9];

    /* renamed from: ETF */
    public C4955yX[] f11974ETF = new C4955yX[16];

    /* renamed from: VA */
    public int f11978VA = 0;

    /* renamed from: MiMN */
    public int f11977MiMN = 0;

    /* renamed from: YoKzxo */
    public HashSet f11979YoKzxo = null;

    /* renamed from: o.Z6$mjFkc */
    public enum mjFkc {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C3274Z6(mjFkc mjfkc, String str) {
        this.f11973Dt = mjfkc;
    }

    /* renamed from: AZxh */
    public static void m11174AZxh() {
        f11971rkYL++;
    }

    /* renamed from: JHa */
    public void m11175JHa(mjFkc mjfkc, String str) {
        this.f11973Dt = mjfkc;
    }

    /* renamed from: KLFTb */
    public void m11176KLFTb(C3202Y0 c3202y0, float f) {
        this.f11975JHa = f;
        this.f11985xJ = true;
        int i = this.f11978VA;
        for (int i2 = 0; i2 < i; i2++) {
            this.f11974ETF[i2].m14013BAnRFn(c3202y0, this, false);
        }
        this.f11978VA = 0;
    }

    /* renamed from: ZfxDd */
    public void m11177ZfxDd() {
        this.f11972AZxh = null;
        this.f11973Dt = mjFkc.UNKNOWN;
        this.f11976KLFTb = 0;
        this.f11984wA = -1;
        this.f11980ZfxDd = -1;
        this.f11975JHa = 0.0f;
        this.f11985xJ = false;
        int i = this.f11978VA;
        for (int i2 = 0; i2 < i; i2++) {
            this.f11974ETF[i2] = null;
        }
        this.f11978VA = 0;
        this.f11977MiMN = 0;
        this.f11982mjFkc = false;
        Arrays.fill(this.f11983qdMbNW, 0.0f);
    }

    /* renamed from: mjFkc */
    public final void m11178mjFkc(C4955yX c4955yX) {
        int i = 0;
        while (true) {
            int i2 = this.f11978VA;
            if (i >= i2) {
                C4955yX[] c4955yXArr = this.f11974ETF;
                if (i2 >= c4955yXArr.length) {
                    this.f11974ETF = (C4955yX[]) Arrays.copyOf(c4955yXArr, c4955yXArr.length * 2);
                }
                C4955yX[] c4955yXArr2 = this.f11974ETF;
                int i3 = this.f11978VA;
                c4955yXArr2[i3] = c4955yX;
                this.f11978VA = i3 + 1;
                return;
            }
            if (this.f11974ETF[i] == c4955yX) {
                return;
            } else {
                i++;
            }
        }
    }

    public String toString() {
        if (this.f11972AZxh != null) {
            return BuildConfig.f24315FLAVOR + this.f11972AZxh;
        }
        return BuildConfig.f24315FLAVOR + this.f11984wA;
    }

    /* renamed from: wA */
    public final void m11179wA(C4955yX c4955yX) {
        int i = this.f11978VA;
        int i2 = 0;
        while (i2 < i) {
            if (this.f11974ETF[i2] == c4955yX) {
                while (i2 < i - 1) {
                    C4955yX[] c4955yXArr = this.f11974ETF;
                    int i3 = i2 + 1;
                    c4955yXArr[i2] = c4955yXArr[i3];
                    i2 = i3;
                }
                this.f11978VA--;
                return;
            }
            i2++;
        }
    }

    /* renamed from: xJ */
    public final void m11180xJ(C4955yX c4955yX) {
        int i = this.f11978VA;
        for (int i2 = 0; i2 < i; i2++) {
            this.f11974ETF[i2].mo9475lB(c4955yX, false);
        }
        this.f11978VA = 0;
    }
}
