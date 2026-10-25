package androidx.recyclerview.p023widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.rkYL */
/* loaded from: classes.dex */
public class C0179rkYL {

    /* renamed from: AZxh */
    public mjFkc f1875AZxh = new mjFkc();

    /* renamed from: mjFkc */
    public final AZxh f1876mjFkc;

    /* renamed from: androidx.recyclerview.widget.rkYL$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        int mo1818AZxh();

        /* renamed from: KLFTb */
        int mo1819KLFTb(View view);

        /* renamed from: ZfxDd */
        int mo1820ZfxDd();

        /* renamed from: mjFkc */
        View mo1821mjFkc(int i);

        /* renamed from: wA */
        int mo1822wA(View view);
    }

    /* renamed from: androidx.recyclerview.widget.rkYL$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public int f1877AZxh;

        /* renamed from: KLFTb */
        public int f1878KLFTb;

        /* renamed from: ZfxDd */
        public int f1879ZfxDd;

        /* renamed from: mjFkc */
        public int f1880mjFkc = 0;

        /* renamed from: wA */
        public int f1881wA;

        /* renamed from: AZxh */
        public boolean m2064AZxh() {
            int i = this.f1880mjFkc;
            if ((i & 7) != 0 && (i & m2068wA(this.f1879ZfxDd, this.f1877AZxh)) == 0) {
                return false;
            }
            int i2 = this.f1880mjFkc;
            if ((i2 & 112) != 0 && (i2 & (m2068wA(this.f1879ZfxDd, this.f1881wA) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1880mjFkc;
            if ((i3 & 1792) != 0 && (i3 & (m2068wA(this.f1878KLFTb, this.f1877AZxh) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1880mjFkc;
            return (i4 & 28672) == 0 || ((m2068wA(this.f1878KLFTb, this.f1881wA) << 12) & i4) != 0;
        }

        /* renamed from: KLFTb */
        public void m2065KLFTb(int i, int i2, int i3, int i4) {
            this.f1877AZxh = i;
            this.f1881wA = i2;
            this.f1879ZfxDd = i3;
            this.f1878KLFTb = i4;
        }

        /* renamed from: ZfxDd */
        public void m2066ZfxDd() {
            this.f1880mjFkc = 0;
        }

        /* renamed from: mjFkc */
        public void m2067mjFkc(int i) {
            this.f1880mjFkc = i | this.f1880mjFkc;
        }

        /* renamed from: wA */
        public int m2068wA(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    public C0179rkYL(AZxh aZxh) {
        this.f1876mjFkc = aZxh;
    }

    /* renamed from: AZxh */
    public boolean m2062AZxh(View view, int i) {
        this.f1875AZxh.m2065KLFTb(this.f1876mjFkc.mo1820ZfxDd(), this.f1876mjFkc.mo1818AZxh(), this.f1876mjFkc.mo1822wA(view), this.f1876mjFkc.mo1819KLFTb(view));
        if (i == 0) {
            return false;
        }
        this.f1875AZxh.m2066ZfxDd();
        this.f1875AZxh.m2067mjFkc(i);
        return this.f1875AZxh.m2064AZxh();
    }

    /* renamed from: mjFkc */
    public View m2063mjFkc(int i, int i2, int i3, int i4) {
        int iMo1820ZfxDd = this.f1876mjFkc.mo1820ZfxDd();
        int iMo1818AZxh = this.f1876mjFkc.mo1818AZxh();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewMo1821mjFkc = this.f1876mjFkc.mo1821mjFkc(i);
            this.f1875AZxh.m2065KLFTb(iMo1820ZfxDd, iMo1818AZxh, this.f1876mjFkc.mo1822wA(viewMo1821mjFkc), this.f1876mjFkc.mo1819KLFTb(viewMo1821mjFkc));
            if (i3 != 0) {
                this.f1875AZxh.m2066ZfxDd();
                this.f1875AZxh.m2067mjFkc(i3);
                if (this.f1875AZxh.m2064AZxh()) {
                    return viewMo1821mjFkc;
                }
            }
            if (i4 != 0) {
                this.f1875AZxh.m2066ZfxDd();
                this.f1875AZxh.m2067mjFkc(i4);
                if (this.f1875AZxh.m2064AZxh()) {
                    view = viewMo1821mjFkc;
                }
            }
            i += i5;
        }
        return view;
    }
}
