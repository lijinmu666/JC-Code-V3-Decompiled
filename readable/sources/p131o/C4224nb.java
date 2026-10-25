package p131o;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* renamed from: o.nb */
/* loaded from: classes.dex */
public final class C4224nb {

    /* renamed from: mjFkc */
    public final KLFTb f15427mjFkc;

    /* renamed from: o.nb$AZxh */
    public static class AZxh extends mjFkc {
        public AZxh(Window window, C3208Y6 c3208y6) {
            super(window, c3208y6);
        }

        @Override // p131o.C4224nb.KLFTb
        /* renamed from: AZxh */
        public void mo12896AZxh(boolean z) {
            if (!z) {
                m12901KLFTb(8192);
                return;
            }
            m12900JHa(67108864);
            m12902ZfxDd(Integer.MIN_VALUE);
            m12903wA(8192);
        }
    }

    /* renamed from: o.nb$KLFTb */
    public static class KLFTb {
        /* renamed from: AZxh */
        public abstract void mo12896AZxh(boolean z);

        /* renamed from: mjFkc */
        public abstract void mo12897mjFkc(boolean z);
    }

    /* renamed from: o.nb$mjFkc */
    public static class mjFkc extends KLFTb {

        /* renamed from: AZxh */
        public final C3208Y6 f15433AZxh;

        /* renamed from: mjFkc */
        public final Window f15434mjFkc;

        public mjFkc(Window window, C3208Y6 c3208y6) {
            this.f15434mjFkc = window;
            this.f15433AZxh = c3208y6;
        }

        /* renamed from: JHa */
        public void m12900JHa(int i) {
            this.f15434mjFkc.clearFlags(i);
        }

        /* renamed from: KLFTb */
        public void m12901KLFTb(int i) {
            View decorView = this.f15434mjFkc.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        /* renamed from: ZfxDd */
        public void m12902ZfxDd(int i) {
            this.f15434mjFkc.addFlags(i);
        }

        /* renamed from: wA */
        public void m12903wA(int i) {
            View decorView = this.f15434mjFkc.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }
    }

    /* renamed from: o.nb$wA */
    public static class wA extends AZxh {
        public wA(Window window, C3208Y6 c3208y6) {
            super(window, c3208y6);
        }

        @Override // p131o.C4224nb.KLFTb
        /* renamed from: mjFkc */
        public void mo12897mjFkc(boolean z) {
            if (!z) {
                m12901KLFTb(16);
                return;
            }
            m12900JHa(134217728);
            m12902ZfxDd(Integer.MIN_VALUE);
            m12903wA(16);
        }
    }

    public C4224nb(Window window, View view) {
        C3208Y6 c3208y6 = new C3208Y6(view);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f15427mjFkc = new ZfxDd(window, this, c3208y6);
        } else {
            this.f15427mjFkc = new wA(window, c3208y6);
        }
    }

    /* renamed from: AZxh */
    public void m12894AZxh(boolean z) {
        this.f15427mjFkc.mo12896AZxh(z);
    }

    /* renamed from: mjFkc */
    public void m12895mjFkc(boolean z) {
        this.f15427mjFkc.mo12897mjFkc(z);
    }

    /* renamed from: o.nb$ZfxDd */
    public static class ZfxDd extends KLFTb {

        /* renamed from: AZxh */
        public final WindowInsetsController f15428AZxh;

        /* renamed from: KLFTb */
        public Window f15429KLFTb;

        /* renamed from: ZfxDd */
        public final C3074W6 f15430ZfxDd;

        /* renamed from: mjFkc */
        public final C4224nb f15431mjFkc;

        /* renamed from: wA */
        public final C3208Y6 f15432wA;

        public ZfxDd(Window window, C4224nb c4224nb, C3208Y6 c3208y6) {
            this(window.getInsetsController(), c4224nb, c3208y6);
            this.f15429KLFTb = window;
        }

        @Override // p131o.C4224nb.KLFTb
        /* renamed from: AZxh */
        public void mo12896AZxh(boolean z) {
            if (z) {
                if (this.f15429KLFTb != null) {
                    m12899wA(8192);
                }
                this.f15428AZxh.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f15429KLFTb != null) {
                    m12898ZfxDd(8192);
                }
                this.f15428AZxh.setSystemBarsAppearance(0, 8);
            }
        }

        /* renamed from: ZfxDd */
        public void m12898ZfxDd(int i) {
            View decorView = this.f15429KLFTb.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        @Override // p131o.C4224nb.KLFTb
        /* renamed from: mjFkc */
        public void mo12897mjFkc(boolean z) {
            if (z) {
                if (this.f15429KLFTb != null) {
                    m12899wA(16);
                }
                this.f15428AZxh.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f15429KLFTb != null) {
                    m12898ZfxDd(16);
                }
                this.f15428AZxh.setSystemBarsAppearance(0, 16);
            }
        }

        /* renamed from: wA */
        public void m12899wA(int i) {
            View decorView = this.f15429KLFTb.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public ZfxDd(WindowInsetsController windowInsetsController, C4224nb c4224nb, C3208Y6 c3208y6) {
            this.f15430ZfxDd = new C3074W6();
            this.f15428AZxh = windowInsetsController;
            this.f15431mjFkc = c4224nb;
            this.f15432wA = c3208y6;
        }
    }
}
