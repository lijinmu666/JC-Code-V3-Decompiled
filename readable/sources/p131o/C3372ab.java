package p131o;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: o.ab */
/* loaded from: classes.dex */
public class C3372ab {

    /* renamed from: AZxh */
    public static final C3372ab f12772AZxh;

    /* renamed from: mjFkc */
    public final ETF f12773mjFkc;

    /* renamed from: o.ab$Dt */
    public static class Dt extends qdMbNW {

        /* renamed from: fehf */
        public static final C3372ab f12775fehf = C3372ab.m11330Pq(WindowInsets.CONSUMED);

        public Dt(C3372ab c3372ab, WindowInsets windowInsets) {
            super(c3372ab, windowInsets);
        }

        @Override // p131o.C3372ab.JHa, p131o.C3372ab.ETF
        /* renamed from: ZfxDd */
        public final void mo11354ZfxDd(View view) {
        }

        @Override // p131o.C3372ab.JHa, p131o.C3372ab.ETF
        /* renamed from: xJ */
        public C2798S mo11355xJ(int i) {
            return C2798S.m10119ZfxDd(this.f12786wA.getInsets(MiMN.m11386mjFkc(i)));
        }

        public Dt(C3372ab c3372ab, Dt dt) {
            super(c3372ab, dt);
        }
    }

    /* renamed from: o.ab$ETF */
    public static class ETF {

        /* renamed from: AZxh */
        public static final C3372ab f12776AZxh = new AZxh().m11352mjFkc().m11344mjFkc().m11332AZxh().m11348wA();

        /* renamed from: mjFkc */
        public final C3372ab f12777mjFkc;

        public ETF(C3372ab c3372ab) {
            this.f12777mjFkc = c3372ab;
        }

        /* renamed from: AZxh */
        public C3372ab mo11356AZxh() {
            return this.f12777mjFkc;
        }

        /* renamed from: Dt */
        public C2798S mo11357Dt() {
            return mo11358ETF();
        }

        /* renamed from: ETF */
        public C2798S mo11358ETF() {
            return C2798S.f10505KLFTb;
        }

        /* renamed from: IEE */
        public void mo11359IEE(C3372ab c3372ab) {
        }

        /* renamed from: JHa */
        public C1760CRhd mo11360JHa() {
            return null;
        }

        /* renamed from: KLFTb */
        public void mo11361KLFTb(C3372ab c3372ab) {
        }

        /* renamed from: MiMN */
        public C3372ab mo11362MiMN(int i, int i2, int i3, int i4) {
            return f12776AZxh;
        }

        /* renamed from: VA */
        public C2798S mo11363VA() {
            return mo11358ETF();
        }

        /* renamed from: YoKzxo */
        public boolean mo11364YoKzxo() {
            return false;
        }

        /* renamed from: ZfxDd */
        public void mo11354ZfxDd(View view) {
        }

        /* renamed from: equals */
        public boolean mo11365equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ETF)) {
                return false;
            }
            ETF etf = (ETF) obj;
            return mo11371rkYL() == etf.mo11371rkYL() && mo11364YoKzxo() == etf.mo11364YoKzxo() && AbstractC3003V2.m10659mjFkc(mo11358ETF(), etf.mo11358ETF()) && AbstractC3003V2.m10659mjFkc(mo11370qdMbNW(), etf.mo11370qdMbNW()) && AbstractC3003V2.m10659mjFkc(mo11360JHa(), etf.mo11360JHa());
        }

        /* renamed from: fehf */
        public void mo11366fehf(C2798S c2798s) {
        }

        public int hashCode() {
            return AbstractC3003V2.m10657AZxh(Boolean.valueOf(mo11371rkYL()), Boolean.valueOf(mo11364YoKzxo()), mo11358ETF(), mo11370qdMbNW(), mo11360JHa());
        }

        /* renamed from: lgHUyS */
        public C2798S mo11367lgHUyS() {
            return mo11358ETF();
        }

        /* renamed from: mjFkc */
        public C3372ab mo11368mjFkc() {
            return this.f12777mjFkc;
        }

        /* renamed from: qGY */
        public void mo11369qGY(C2798S[] c2798sArr) {
        }

        /* renamed from: qdMbNW */
        public C2798S mo11370qdMbNW() {
            return C2798S.f10505KLFTb;
        }

        /* renamed from: rkYL */
        public boolean mo11371rkYL() {
            return false;
        }

        /* renamed from: wA */
        public C3372ab mo11372wA() {
            return this.f12777mjFkc;
        }

        /* renamed from: xJ */
        public C2798S mo11355xJ(int i) {
            return C2798S.f10505KLFTb;
        }
    }

    /* renamed from: o.ab$KLFTb */
    public static class KLFTb {

        /* renamed from: AZxh */
        public C2798S[] f12788AZxh;

        /* renamed from: mjFkc */
        public final C3372ab f12789mjFkc;

        public KLFTb() {
            this(new C3372ab((C3372ab) null));
        }

        /* renamed from: AZxh */
        public abstract C3372ab mo11378AZxh();

        /* renamed from: JHa */
        public abstract void mo11379JHa(C2798S c2798s);

        /* renamed from: KLFTb */
        public abstract void mo11380KLFTb(C2798S c2798s);

        /* renamed from: ZfxDd */
        public abstract void mo11381ZfxDd(C2798S c2798s);

        /* renamed from: lgHUyS */
        public abstract void mo11382lgHUyS(C2798S c2798s);

        /* renamed from: mjFkc */
        public final void m11383mjFkc() {
            C2798S[] c2798sArr = this.f12788AZxh;
            if (c2798sArr != null) {
                C2798S c2798sM11336JHa = c2798sArr[VA.m11387AZxh(1)];
                C2798S c2798sM11336JHa2 = this.f12788AZxh[VA.m11387AZxh(2)];
                if (c2798sM11336JHa2 == null) {
                    c2798sM11336JHa2 = this.f12789mjFkc.m11336JHa(2);
                }
                if (c2798sM11336JHa == null) {
                    c2798sM11336JHa = this.f12789mjFkc.m11336JHa(1);
                }
                mo11385xJ(C2798S.m10120mjFkc(c2798sM11336JHa, c2798sM11336JHa2));
                C2798S c2798s = this.f12788AZxh[VA.m11387AZxh(16)];
                if (c2798s != null) {
                    mo11379JHa(c2798s);
                }
                C2798S c2798s2 = this.f12788AZxh[VA.m11387AZxh(32)];
                if (c2798s2 != null) {
                    mo11381ZfxDd(c2798s2);
                }
                C2798S c2798s3 = this.f12788AZxh[VA.m11387AZxh(64)];
                if (c2798s3 != null) {
                    mo11382lgHUyS(c2798s3);
                }
            }
        }

        /* renamed from: wA */
        public void mo11384wA(int i, C2798S c2798s) {
            if (this.f12788AZxh == null) {
                this.f12788AZxh = new C2798S[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.f12788AZxh[VA.m11387AZxh(i2)] = c2798s;
                }
            }
        }

        /* renamed from: xJ */
        public abstract void mo11385xJ(C2798S c2798s);

        public KLFTb(C3372ab c3372ab) {
            this.f12789mjFkc = c3372ab;
        }
    }

    /* renamed from: o.ab$MiMN */
    public static final class MiMN {
        /* renamed from: mjFkc */
        public static int m11386mjFkc(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    /* renamed from: o.ab$VA */
    public static final class VA {
        /* renamed from: AZxh */
        public static int m11387AZxh(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        /* renamed from: ZfxDd */
        public static int m11388ZfxDd() {
            return 7;
        }

        /* renamed from: mjFkc */
        public static int m11389mjFkc() {
            return 8;
        }

        /* renamed from: wA */
        public static int m11390wA() {
            return 32;
        }
    }

    /* renamed from: o.ab$ZfxDd */
    public static class ZfxDd extends wA {
        public ZfxDd() {
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: wA */
        public void mo11384wA(int i, C2798S c2798s) {
            this.f12797wA.setInsets(MiMN.m11386mjFkc(i), c2798s.m10122KLFTb());
        }

        public ZfxDd(C3372ab c3372ab) {
            super(c3372ab);
        }
    }

    /* renamed from: o.ab$lgHUyS */
    public static class lgHUyS extends xJ {
        public lgHUyS(C3372ab c3372ab, WindowInsets windowInsets) {
            super(c3372ab, windowInsets);
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: JHa */
        public C1760CRhd mo11360JHa() {
            return C1760CRhd.m7834KLFTb(this.f12786wA.getDisplayCutout());
        }

        @Override // p131o.C3372ab.JHa, p131o.C3372ab.ETF
        /* renamed from: equals */
        public boolean mo11365equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof lgHUyS)) {
                return false;
            }
            lgHUyS lghuys = (lgHUyS) obj;
            return Objects.equals(this.f12786wA, lghuys.f12786wA) && Objects.equals(this.f12787xJ, lghuys.f12787xJ);
        }

        @Override // p131o.C3372ab.ETF
        public int hashCode() {
            return this.f12786wA.hashCode();
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: mjFkc */
        public C3372ab mo11368mjFkc() {
            return C3372ab.m11330Pq(this.f12786wA.consumeDisplayCutout());
        }

        public lgHUyS(C3372ab c3372ab, lgHUyS lghuys) {
            super(c3372ab, lghuys);
        }
    }

    /* renamed from: o.ab$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public static Field f12790AZxh;

        /* renamed from: ZfxDd */
        public static boolean f12791ZfxDd;

        /* renamed from: mjFkc */
        public static Field f12792mjFkc;

        /* renamed from: wA */
        public static Field f12793wA;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f12792mjFkc = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f12790AZxh = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f12793wA = declaredField3;
                declaredField3.setAccessible(true);
                f12791ZfxDd = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        /* renamed from: mjFkc */
        public static C3372ab m11391mjFkc(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f12791ZfxDd && view.isAttachedToWindow()) {
                try {
                    Object obj = f12792mjFkc.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f12790AZxh.get(obj);
                        Rect rect2 = (Rect) f12793wA.get(obj);
                        if (rect != null && rect2 != null) {
                            C3372ab c3372abM11352mjFkc = new AZxh().m11353wA(C2798S.m10121wA(rect)).m11351ZfxDd(C2798S.m10121wA(rect2)).m11352mjFkc();
                            c3372abM11352mjFkc.m11342fehf(c3372abM11352mjFkc);
                            c3372abM11352mjFkc.m11340ZfxDd(view.getRootView());
                            return c3372abM11352mjFkc;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f12772AZxh = Dt.f12775fehf;
        } else {
            f12772AZxh = ETF.f12776AZxh;
        }
    }

    public C3372ab(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f12773mjFkc = new Dt(this, windowInsets);
        } else {
            this.f12773mjFkc = new qdMbNW(this, windowInsets);
        }
    }

    /* renamed from: MiMN */
    public static C2798S m11329MiMN(C2798S c2798s, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, c2798s.f10508mjFkc - i);
        int iMax2 = Math.max(0, c2798s.f10506AZxh - i2);
        int iMax3 = Math.max(0, c2798s.f10509wA - i3);
        int iMax4 = Math.max(0, c2798s.f10507ZfxDd - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? c2798s : C2798S.m10118AZxh(iMax, iMax2, iMax3, iMax4);
    }

    /* renamed from: Pq */
    public static C3372ab m11330Pq(WindowInsets windowInsets) {
        return m11331diqgf(windowInsets, null);
    }

    /* renamed from: diqgf */
    public static C3372ab m11331diqgf(WindowInsets windowInsets, View view) {
        C3372ab c3372ab = new C3372ab((WindowInsets) AbstractC2280K3.m9126xJ(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c3372ab.m11342fehf(AbstractC2876T9.m10279lB(view));
            c3372ab.m11340ZfxDd(view.getRootView());
        }
        return c3372ab;
    }

    /* renamed from: AZxh */
    public C3372ab m11332AZxh() {
        return this.f12773mjFkc.mo11356AZxh();
    }

    /* renamed from: Dt */
    public int m11333Dt() {
        return this.f12773mjFkc.mo11358ETF().f10509wA;
    }

    /* renamed from: ETF */
    public int m11334ETF() {
        return this.f12773mjFkc.mo11358ETF().f10506AZxh;
    }

    /* renamed from: IEE */
    public WindowInsets m11335IEE() {
        ETF etf = this.f12773mjFkc;
        if (etf instanceof JHa) {
            return ((JHa) etf).f12786wA;
        }
        return null;
    }

    /* renamed from: JHa */
    public C2798S m11336JHa(int i) {
        return this.f12773mjFkc.mo11355xJ(i);
    }

    /* renamed from: KLFTb */
    public C1760CRhd m11337KLFTb() {
        return this.f12773mjFkc.mo11360JHa();
    }

    /* renamed from: VA */
    public C3372ab m11338VA(int i, int i2, int i3, int i4) {
        return this.f12773mjFkc.mo11362MiMN(i, i2, i3, i4);
    }

    /* renamed from: YoKzxo */
    public boolean m11339YoKzxo() {
        return this.f12773mjFkc.mo11364YoKzxo();
    }

    /* renamed from: ZfxDd */
    public void m11340ZfxDd(View view) {
        this.f12773mjFkc.mo11354ZfxDd(view);
    }

    /* renamed from: equals */
    public boolean m11341equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3372ab) {
            return AbstractC3003V2.m10659mjFkc(this.f12773mjFkc, ((C3372ab) obj).f12773mjFkc);
        }
        return false;
    }

    /* renamed from: fehf */
    public void m11342fehf(C3372ab c3372ab) {
        this.f12773mjFkc.mo11359IEE(c3372ab);
    }

    public int hashCode() {
        ETF etf = this.f12773mjFkc;
        if (etf == null) {
            return 0;
        }
        return etf.hashCode();
    }

    /* renamed from: lgHUyS */
    public int m11343lgHUyS() {
        return this.f12773mjFkc.mo11358ETF().f10507ZfxDd;
    }

    /* renamed from: mjFkc */
    public C3372ab m11344mjFkc() {
        return this.f12773mjFkc.mo11368mjFkc();
    }

    /* renamed from: qGY */
    public void m11345qGY(C2798S c2798s) {
        this.f12773mjFkc.mo11366fehf(c2798s);
    }

    /* renamed from: qdMbNW */
    public int m11346qdMbNW() {
        return this.f12773mjFkc.mo11358ETF().f10508mjFkc;
    }

    /* renamed from: rkYL */
    public void m11347rkYL(C2798S[] c2798sArr) {
        this.f12773mjFkc.mo11369qGY(c2798sArr);
    }

    /* renamed from: wA */
    public C3372ab m11348wA() {
        return this.f12773mjFkc.mo11372wA();
    }

    /* renamed from: xJ */
    public C2798S m11349xJ() {
        return this.f12773mjFkc.mo11370qdMbNW();
    }

    /* renamed from: o.ab$wA */
    public static class wA extends KLFTb {

        /* renamed from: wA */
        public final WindowInsets.Builder f12797wA;

        public wA() {
            this.f12797wA = new WindowInsets.Builder();
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: AZxh */
        public C3372ab mo11378AZxh() {
            m11383mjFkc();
            C3372ab c3372abM11330Pq = C3372ab.m11330Pq(this.f12797wA.build());
            c3372abM11330Pq.m11347rkYL(this.f12788AZxh);
            return c3372abM11330Pq;
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: JHa */
        public void mo11379JHa(C2798S c2798s) {
            this.f12797wA.setSystemGestureInsets(c2798s.m10122KLFTb());
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: KLFTb */
        public void mo11380KLFTb(C2798S c2798s) {
            this.f12797wA.setStableInsets(c2798s.m10122KLFTb());
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: ZfxDd */
        public void mo11381ZfxDd(C2798S c2798s) {
            this.f12797wA.setMandatorySystemGestureInsets(c2798s.m10122KLFTb());
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: lgHUyS */
        public void mo11382lgHUyS(C2798S c2798s) {
            this.f12797wA.setTappableElementInsets(c2798s.m10122KLFTb());
        }

        @Override // p131o.C3372ab.KLFTb
        /* renamed from: xJ */
        public void mo11385xJ(C2798S c2798s) {
            this.f12797wA.setSystemWindowInsets(c2798s.m10122KLFTb());
        }

        public wA(C3372ab c3372ab) {
            WindowInsets.Builder builder;
            super(c3372ab);
            WindowInsets windowInsetsM11335IEE = c3372ab.m11335IEE();
            if (windowInsetsM11335IEE != null) {
                builder = new WindowInsets.Builder(windowInsetsM11335IEE);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f12797wA = builder;
        }
    }

    /* renamed from: o.ab$xJ */
    public static class xJ extends JHa {

        /* renamed from: MiMN */
        public C2798S f12798MiMN;

        public xJ(C3372ab c3372ab, WindowInsets windowInsets) {
            super(c3372ab, windowInsets);
            this.f12798MiMN = null;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: AZxh */
        public C3372ab mo11356AZxh() {
            return C3372ab.m11330Pq(this.f12786wA.consumeStableInsets());
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: YoKzxo */
        public boolean mo11364YoKzxo() {
            return this.f12786wA.isConsumed();
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: qdMbNW */
        public final C2798S mo11370qdMbNW() {
            if (this.f12798MiMN == null) {
                this.f12798MiMN = C2798S.m10118AZxh(this.f12786wA.getStableInsetLeft(), this.f12786wA.getStableInsetTop(), this.f12786wA.getStableInsetRight(), this.f12786wA.getStableInsetBottom());
            }
            return this.f12798MiMN;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: wA */
        public C3372ab mo11372wA() {
            return C3372ab.m11330Pq(this.f12786wA.consumeSystemWindowInsets());
        }

        public xJ(C3372ab c3372ab, xJ xJVar) {
            super(c3372ab, xJVar);
            this.f12798MiMN = null;
            this.f12798MiMN = xJVar.f12798MiMN;
        }
    }

    /* renamed from: o.ab$JHa */
    public static class JHa extends ETF {

        /* renamed from: Dt */
        public static Class f12778Dt;

        /* renamed from: ETF */
        public static Field f12779ETF;

        /* renamed from: VA */
        public static Field f12780VA;

        /* renamed from: lgHUyS */
        public static boolean f12781lgHUyS;

        /* renamed from: qdMbNW */
        public static Method f12782qdMbNW;

        /* renamed from: JHa */
        public C3372ab f12783JHa;

        /* renamed from: KLFTb */
        public C2798S f12784KLFTb;

        /* renamed from: ZfxDd */
        public C2798S[] f12785ZfxDd;

        /* renamed from: wA */
        public final WindowInsets f12786wA;

        /* renamed from: xJ */
        public C2798S f12787xJ;

        public JHa(C3372ab c3372ab, WindowInsets windowInsets) {
            super(c3372ab);
            this.f12784KLFTb = null;
            this.f12786wA = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: Pq */
        private C2798S m11373Pq(int i, boolean z) {
            C2798S c2798sM10120mjFkc = C2798S.f10505KLFTb;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    c2798sM10120mjFkc = C2798S.m10120mjFkc(c2798sM10120mjFkc, m11377diqgf(i2, z));
                }
            }
            return c2798sM10120mjFkc;
        }

        /* renamed from: Ucbh */
        private C2798S m11374Ucbh(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f12781lgHUyS) {
                m11376huTpC();
            }
            Method method = f12782qdMbNW;
            if (method != null && f12778Dt != null && f12779ETF != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f12779ETF.get(f12780VA.get(objInvoke));
                    if (rect != null) {
                        return C2798S.m10121wA(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        /* renamed from: eyqo */
        private C2798S m11375eyqo() {
            C3372ab c3372ab = this.f12783JHa;
            return c3372ab != null ? c3372ab.m11349xJ() : C2798S.f10505KLFTb;
        }

        @SuppressLint({"PrivateApi"})
        /* renamed from: huTpC */
        private static void m11376huTpC() throws ClassNotFoundException, SecurityException {
            try {
                f12782qdMbNW = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f12778Dt = cls;
                f12779ETF = cls.getDeclaredField("mVisibleInsets");
                f12780VA = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f12779ETF.setAccessible(true);
                f12780VA.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            f12781lgHUyS = true;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: ETF */
        public final C2798S mo11358ETF() {
            if (this.f12784KLFTb == null) {
                this.f12784KLFTb = C2798S.m10118AZxh(this.f12786wA.getSystemWindowInsetLeft(), this.f12786wA.getSystemWindowInsetTop(), this.f12786wA.getSystemWindowInsetRight(), this.f12786wA.getSystemWindowInsetBottom());
            }
            return this.f12784KLFTb;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: IEE */
        public void mo11359IEE(C3372ab c3372ab) {
            this.f12783JHa = c3372ab;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: KLFTb */
        public void mo11361KLFTb(C3372ab c3372ab) {
            c3372ab.m11342fehf(this.f12783JHa);
            c3372ab.m11345qGY(this.f12787xJ);
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: MiMN */
        public C3372ab mo11362MiMN(int i, int i2, int i3, int i4) {
            AZxh aZxh = new AZxh(C3372ab.m11330Pq(this.f12786wA));
            aZxh.m11351ZfxDd(C3372ab.m11329MiMN(mo11358ETF(), i, i2, i3, i4));
            aZxh.m11353wA(C3372ab.m11329MiMN(mo11370qdMbNW(), i, i2, i3, i4));
            return aZxh.m11352mjFkc();
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: ZfxDd */
        public void mo11354ZfxDd(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            C2798S c2798sM11374Ucbh = m11374Ucbh(view);
            if (c2798sM11374Ucbh == null) {
                c2798sM11374Ucbh = C2798S.f10505KLFTb;
            }
            mo11366fehf(c2798sM11374Ucbh);
        }

        /* renamed from: diqgf */
        public C2798S m11377diqgf(int i, boolean z) {
            C2798S c2798sM11349xJ;
            int i2;
            if (i == 1) {
                return z ? C2798S.m10118AZxh(0, Math.max(m11375eyqo().f10506AZxh, mo11358ETF().f10506AZxh), 0, 0) : C2798S.m10118AZxh(0, mo11358ETF().f10506AZxh, 0, 0);
            }
            if (i == 2) {
                if (z) {
                    C2798S c2798sM11375eyqo = m11375eyqo();
                    C2798S c2798sMo11370qdMbNW = mo11370qdMbNW();
                    return C2798S.m10118AZxh(Math.max(c2798sM11375eyqo.f10508mjFkc, c2798sMo11370qdMbNW.f10508mjFkc), 0, Math.max(c2798sM11375eyqo.f10509wA, c2798sMo11370qdMbNW.f10509wA), Math.max(c2798sM11375eyqo.f10507ZfxDd, c2798sMo11370qdMbNW.f10507ZfxDd));
                }
                C2798S c2798sMo11358ETF = mo11358ETF();
                C3372ab c3372ab = this.f12783JHa;
                c2798sM11349xJ = c3372ab != null ? c3372ab.m11349xJ() : null;
                int iMin = c2798sMo11358ETF.f10507ZfxDd;
                if (c2798sM11349xJ != null) {
                    iMin = Math.min(iMin, c2798sM11349xJ.f10507ZfxDd);
                }
                return C2798S.m10118AZxh(c2798sMo11358ETF.f10508mjFkc, 0, c2798sMo11358ETF.f10509wA, iMin);
            }
            if (i != 8) {
                if (i == 16) {
                    return mo11357Dt();
                }
                if (i == 32) {
                    return mo11367lgHUyS();
                }
                if (i == 64) {
                    return mo11363VA();
                }
                if (i != 128) {
                    return C2798S.f10505KLFTb;
                }
                C3372ab c3372ab2 = this.f12783JHa;
                C1760CRhd c1760CRhdM11337KLFTb = c3372ab2 != null ? c3372ab2.m11337KLFTb() : mo11360JHa();
                return c1760CRhdM11337KLFTb != null ? C2798S.m10118AZxh(c1760CRhdM11337KLFTb.m7835AZxh(), c1760CRhdM11337KLFTb.m7836ZfxDd(), c1760CRhdM11337KLFTb.m7839wA(), c1760CRhdM11337KLFTb.m7838mjFkc()) : C2798S.f10505KLFTb;
            }
            C2798S[] c2798sArr = this.f12785ZfxDd;
            c2798sM11349xJ = c2798sArr != null ? c2798sArr[VA.m11387AZxh(8)] : null;
            if (c2798sM11349xJ != null) {
                return c2798sM11349xJ;
            }
            C2798S c2798sMo11358ETF2 = mo11358ETF();
            C2798S c2798sM11375eyqo2 = m11375eyqo();
            int i3 = c2798sMo11358ETF2.f10507ZfxDd;
            if (i3 > c2798sM11375eyqo2.f10507ZfxDd) {
                return C2798S.m10118AZxh(0, 0, 0, i3);
            }
            C2798S c2798s = this.f12787xJ;
            return (c2798s == null || c2798s.m10123equals(C2798S.f10505KLFTb) || (i2 = this.f12787xJ.f10507ZfxDd) <= c2798sM11375eyqo2.f10507ZfxDd) ? C2798S.f10505KLFTb : C2798S.m10118AZxh(0, 0, 0, i2);
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: equals */
        public boolean mo11365equals(Object obj) {
            if (super.mo11365equals(obj)) {
                return Objects.equals(this.f12787xJ, ((JHa) obj).f12787xJ);
            }
            return false;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: fehf */
        public void mo11366fehf(C2798S c2798s) {
            this.f12787xJ = c2798s;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: qGY */
        public void mo11369qGY(C2798S[] c2798sArr) {
            this.f12785ZfxDd = c2798sArr;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: rkYL */
        public boolean mo11371rkYL() {
            return this.f12786wA.isRound();
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: xJ */
        public C2798S mo11355xJ(int i) {
            return m11373Pq(i, false);
        }

        public JHa(C3372ab c3372ab, JHa jHa) {
            this(c3372ab, new WindowInsets(jHa.f12786wA));
        }
    }

    /* renamed from: o.ab$AZxh */
    public static final class AZxh {

        /* renamed from: mjFkc */
        public final KLFTb f12774mjFkc;

        public AZxh() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f12774mjFkc = new ZfxDd();
            } else {
                this.f12774mjFkc = new wA();
            }
        }

        /* renamed from: AZxh */
        public AZxh m11350AZxh(int i, C2798S c2798s) {
            this.f12774mjFkc.mo11384wA(i, c2798s);
            return this;
        }

        /* renamed from: ZfxDd */
        public AZxh m11351ZfxDd(C2798S c2798s) {
            this.f12774mjFkc.mo11385xJ(c2798s);
            return this;
        }

        /* renamed from: mjFkc */
        public C3372ab m11352mjFkc() {
            return this.f12774mjFkc.mo11378AZxh();
        }

        /* renamed from: wA */
        public AZxh m11353wA(C2798S c2798s) {
            this.f12774mjFkc.mo11380KLFTb(c2798s);
            return this;
        }

        public AZxh(C3372ab c3372ab) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f12774mjFkc = new ZfxDd(c3372ab);
            } else {
                this.f12774mjFkc = new wA(c3372ab);
            }
        }
    }

    /* renamed from: o.ab$qdMbNW */
    public static class qdMbNW extends lgHUyS {

        /* renamed from: YoKzxo */
        public C2798S f12794YoKzxo;

        /* renamed from: qGY */
        public C2798S f12795qGY;

        /* renamed from: rkYL */
        public C2798S f12796rkYL;

        public qdMbNW(C3372ab c3372ab, WindowInsets windowInsets) {
            super(c3372ab, windowInsets);
            this.f12794YoKzxo = null;
            this.f12796rkYL = null;
            this.f12795qGY = null;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: Dt */
        public C2798S mo11357Dt() {
            if (this.f12794YoKzxo == null) {
                this.f12794YoKzxo = C2798S.m10119ZfxDd(this.f12786wA.getSystemGestureInsets());
            }
            return this.f12794YoKzxo;
        }

        @Override // p131o.C3372ab.JHa, p131o.C3372ab.ETF
        /* renamed from: MiMN */
        public C3372ab mo11362MiMN(int i, int i2, int i3, int i4) {
            return C3372ab.m11330Pq(this.f12786wA.inset(i, i2, i3, i4));
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: VA */
        public C2798S mo11363VA() {
            if (this.f12795qGY == null) {
                this.f12795qGY = C2798S.m10119ZfxDd(this.f12786wA.getTappableElementInsets());
            }
            return this.f12795qGY;
        }

        @Override // p131o.C3372ab.ETF
        /* renamed from: lgHUyS */
        public C2798S mo11367lgHUyS() {
            if (this.f12796rkYL == null) {
                this.f12796rkYL = C2798S.m10119ZfxDd(this.f12786wA.getMandatorySystemGestureInsets());
            }
            return this.f12796rkYL;
        }

        public qdMbNW(C3372ab c3372ab, qdMbNW qdmbnw) {
            super(c3372ab, qdmbnw);
            this.f12794YoKzxo = null;
            this.f12796rkYL = null;
            this.f12795qGY = null;
        }
    }

    public C3372ab(C3372ab c3372ab) {
        if (c3372ab != null) {
            ETF etf = c3372ab.f12773mjFkc;
            if (Build.VERSION.SDK_INT >= 30 && (etf instanceof Dt)) {
                this.f12773mjFkc = new Dt(this, (Dt) etf);
            } else if (etf instanceof qdMbNW) {
                this.f12773mjFkc = new qdMbNW(this, (qdMbNW) etf);
            } else if (etf instanceof lgHUyS) {
                this.f12773mjFkc = new lgHUyS(this, (lgHUyS) etf);
            } else if (etf instanceof xJ) {
                this.f12773mjFkc = new xJ(this, (xJ) etf);
            } else if (etf instanceof JHa) {
                this.f12773mjFkc = new JHa(this, (JHa) etf);
            } else {
                this.f12773mjFkc = new ETF(this);
            }
            etf.mo11361KLFTb(this);
            return;
        }
        this.f12773mjFkc = new ETF(this);
    }
}
