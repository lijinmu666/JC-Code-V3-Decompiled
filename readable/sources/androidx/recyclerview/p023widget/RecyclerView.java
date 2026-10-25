package androidx.recyclerview.p023widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.p023widget.C0122AZxh;
import androidx.recyclerview.p023widget.C0124ETF;
import androidx.recyclerview.p023widget.C0176mjFkc;
import androidx.recyclerview.p023widget.C0177qGY;
import androidx.recyclerview.p023widget.C0179rkYL;
import androidx.recyclerview.p023widget.RunnableC0129KLFTb;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p131o.AbstractC2280K3;
import p131o.AbstractC2352L8;
import p131o.AbstractC2876T9;
import p131o.AbstractC2967UXIO;
import p131o.AbstractC3141X9;
import p131o.AbstractC3253YoKzxo;
import p131o.AbstractC3272Z4;
import p131o.AbstractC3731g4;
import p131o.AbstractC4125m4;
import p131o.AbstractC4721v2;
import p131o.AbstractC4793w7;
import p131o.AbstractC4796wA;
import p131o.AbstractC4924y3;
import p131o.C1801D2;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: LREOK */
    public static boolean f1536LREOK;

    /* renamed from: gYa */
    public static boolean f1542gYa;

    /* renamed from: giT */
    public static final Interpolator f1543giT;

    /* renamed from: lti */
    public static final Class[] f1545lti;

    /* renamed from: sRqPfw */
    public static final C0136BAnRFn f1546sRqPfw;

    /* renamed from: ANMGZc */
    public List f1549ANMGZc;

    /* renamed from: AZxh */
    public final C0139Gd f1550AZxh;

    /* renamed from: BAnRFn */
    public boolean f1551BAnRFn;

    /* renamed from: CqaNbM */
    public int f1552CqaNbM;

    /* renamed from: Dt */
    public final Rect f1553Dt;

    /* renamed from: ETF */
    public final Rect f1554ETF;

    /* renamed from: GMIER */
    public int f1555GMIER;

    /* renamed from: Gd */
    public boolean f1556Gd;

    /* renamed from: HGpJ */
    public boolean f1557HGpJ;

    /* renamed from: IEE */
    public InterfaceC0145Pq f1558IEE;

    /* renamed from: IVlxe */
    public C1801D2 f1559IVlxe;

    /* renamed from: JBhc */
    public RunnableC0129KLFTb.AZxh f1560JBhc;

    /* renamed from: JHa */
    public C0122AZxh f1561JHa;

    /* renamed from: JYgkl */
    public final int f1562JYgkl;

    /* renamed from: JYn */
    public AbstractC0141IEE f1563JYn;

    /* renamed from: JrJO */
    public final int f1564JrJO;

    /* renamed from: KLFTb */
    public C0176mjFkc f1565KLFTb;

    /* renamed from: KLMXS */
    public EdgeEffect f1566KLMXS;

    /* renamed from: KRTLGT */
    public int f1567KRTLGT;

    /* renamed from: MiMN */
    public AbstractC0156lgHUyS f1568MiMN;

    /* renamed from: Moer */
    public final int[] f1569Moer;

    /* renamed from: NKyg */
    public Runnable f1570NKyg;

    /* renamed from: NPj */
    public int f1571NPj;

    /* renamed from: Ne */
    public int f1572Ne;

    /* renamed from: OjSQV */
    public boolean f1573OjSQV;

    /* renamed from: Pq */
    public boolean f1574Pq;

    /* renamed from: Qr */
    public final List f1575Qr;

    /* renamed from: SOS */
    public final int[] f1576SOS;

    /* renamed from: SmIWf */
    public final int[] f1577SmIWf;

    /* renamed from: SwgkN */
    public RunnableC0129KLFTb f1578SwgkN;

    /* renamed from: Ucbh */
    public boolean f1579Ucbh;

    /* renamed from: VA */
    public final RectF f1580VA;

    /* renamed from: Vdz */
    public final C0148VocHEe f1581Vdz;

    /* renamed from: Vnb */
    public AbstractC0144MiMN f1582Vnb;

    /* renamed from: VocHEe */
    public int f1583VocHEe;

    /* renamed from: WGXroI */
    public float f1584WGXroI;

    /* renamed from: WrLQs */
    public int f1585WrLQs;

    /* renamed from: XV */
    public boolean f1586XV;

    /* renamed from: YoKzxo */
    public AbstractC0159qGY f1587YoKzxo;

    /* renamed from: ZfxDd */
    public C0140HGpJ f1588ZfxDd;

    /* renamed from: alEkx */
    public boolean f1589alEkx;

    /* renamed from: aqHPIZ */
    public int f1590aqHPIZ;

    /* renamed from: bbzow */
    public final RunnableC0164wJVbdd f1591bbzow;

    /* renamed from: cMLeY */
    public EdgeEffect f1592cMLeY;

    /* renamed from: diqgf */
    public boolean f1593diqgf;

    /* renamed from: dm */
    public boolean f1594dm;

    /* renamed from: eyqo */
    public boolean f1595eyqo;

    /* renamed from: fehf */
    public final ArrayList f1596fehf;

    /* renamed from: gtIJp */
    public boolean f1597gtIJp;

    /* renamed from: huTpC */
    public int f1598huTpC;

    /* renamed from: jm */
    public AbstractC0151diqgf f1599jm;

    /* renamed from: kism */
    public int f1600kism;

    /* renamed from: lB */
    public final AccessibilityManager f1601lB;

    /* renamed from: lgHUyS */
    public boolean f1602lgHUyS;

    /* renamed from: mByQ */
    public boolean f1603mByQ;

    /* renamed from: mjFkc */
    public final float f1604mjFkc;

    /* renamed from: nxI */
    public float f1605nxI;

    /* renamed from: oCFDzJ */
    public VelocityTracker f1606oCFDzJ;

    /* renamed from: qGY */
    public final ArrayList f1607qGY;

    /* renamed from: qdMbNW */
    public final Runnable f1608qdMbNW;

    /* renamed from: rWxwaT */
    public EdgeEffect f1609rWxwaT;

    /* renamed from: rkYL */
    public final List f1610rkYL;

    /* renamed from: tQ */
    public AbstractC0144MiMN.mjFkc f1611tQ;

    /* renamed from: tjSezt */
    public int f1612tjSezt;

    /* renamed from: uHVRx */
    public int f1613uHVRx;

    /* renamed from: vI */
    public boolean f1614vI;

    /* renamed from: vadzgd */
    public int f1615vadzgd;

    /* renamed from: vjlshU */
    public C0124ETF f1616vjlshU;

    /* renamed from: wA */
    public final C0146Ucbh f1617wA;

    /* renamed from: wJVbdd */
    public List f1618wJVbdd;

    /* renamed from: xJ */
    public final C0177qGY f1619xJ;

    /* renamed from: xROA */
    public final int[] f1620xROA;

    /* renamed from: xrEuO */
    public C0147VA f1621xrEuO;

    /* renamed from: yX */
    public final C0177qGY.AZxh f1622yX;

    /* renamed from: yfx */
    public boolean f1623yfx;

    /* renamed from: zvd */
    public EdgeEffect f1624zvd;

    /* renamed from: fFz */
    public static final int[] f1541fFz = {R.attr.nestedScrollingEnabled};

    /* renamed from: XbiWeM */
    public static final float f1539XbiWeM = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: XFUzSY */
    public static final boolean f1538XFUzSY = false;

    /* renamed from: XtE */
    public static final boolean f1540XtE = true;

    /* renamed from: jx */
    public static final boolean f1544jx = true;

    /* renamed from: uH */
    public static final boolean f1548uH = true;

    /* renamed from: tISON */
    public static final boolean f1547tISON = false;

    /* renamed from: Vgyli */
    public static final boolean f1537Vgyli = false;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$AZxh */
    public class RunnableC0135AZxh implements Runnable {
        public RunnableC0135AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0144MiMN abstractC0144MiMN = RecyclerView.this.f1582Vnb;
            if (abstractC0144MiMN != null) {
                abstractC0144MiMN.mo1567eyqo();
            }
            RecyclerView.this.f1623yfx = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$BAnRFn */
    public static class C0136BAnRFn extends C0147VA {
        @Override // androidx.recyclerview.p023widget.RecyclerView.C0147VA
        /* renamed from: mjFkc */
        public EdgeEffect mo1542mjFkc(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$Dt */
    public static abstract class AbstractC0137Dt {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$ETF */
    public interface InterfaceC0138ETF {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$Gd */
    public class C0139Gd extends AbstractC0137Dt {
        public C0139Gd() {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$IEE */
    public static abstract class AbstractC0141IEE {
        /* renamed from: mjFkc */
        public abstract boolean mo1547mjFkc(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$JHa */
    public class C0142JHa implements C0176mjFkc.mjFkc {
        public C0142JHa() {
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: AZxh */
        public void mo1548AZxh(C0176mjFkc.AZxh aZxh) {
            m1554qdMbNW(aZxh);
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: JHa */
        public void mo1549JHa(int i, int i2) {
            RecyclerView.this.m1508lti(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1589alEkx = true;
            recyclerView.f1581Vdz.f1657ZfxDd += i2;
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: KLFTb */
        public void mo1550KLFTb(int i, int i2) {
            RecyclerView.this.m1525tISON(i, i2);
            RecyclerView.this.f1589alEkx = true;
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: ZfxDd */
        public void mo1551ZfxDd(int i, int i2) {
            RecyclerView.this.m1508lti(i, i2, false);
            RecyclerView.this.f1589alEkx = true;
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: lgHUyS */
        public void mo1552lgHUyS(int i, int i2, Object obj) {
            RecyclerView.this.m1535xCVa(i, i2, obj);
            RecyclerView.this.f1594dm = true;
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: mjFkc */
        public void mo1553mjFkc(int i, int i2) {
            RecyclerView.this.m1468Vgyli(i, i2);
            RecyclerView.this.f1589alEkx = true;
        }

        /* renamed from: qdMbNW */
        public void m1554qdMbNW(C0176mjFkc.AZxh aZxh) {
            int i = aZxh.f1864mjFkc;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f1587YoKzxo.mo1252eQ(recyclerView, aZxh.f1862AZxh, aZxh.f1863ZfxDd);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f1587YoKzxo.mo1244XgAT(recyclerView2, aZxh.f1862AZxh, aZxh.f1863ZfxDd);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f1587YoKzxo.mo1268tAfC(recyclerView3, aZxh.f1862AZxh, aZxh.f1863ZfxDd, aZxh.f1865wA);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f1587YoKzxo.mo1260jtz(recyclerView4, aZxh.f1862AZxh, aZxh.f1863ZfxDd, 1);
            }
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: wA */
        public AbstractC0157mByQ mo1555wA(int i) {
            AbstractC0157mByQ abstractC0157mByQM1463SwgkN = RecyclerView.this.m1463SwgkN(i, true);
            if (abstractC0157mByQM1463SwgkN == null) {
                return null;
            }
            if (!RecyclerView.this.f1561JHa.m1174YoKzxo(abstractC0157mByQM1463SwgkN.f1700mjFkc)) {
                return abstractC0157mByQM1463SwgkN;
            }
            if (RecyclerView.f1536LREOK) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
            return null;
        }

        @Override // androidx.recyclerview.p023widget.C0176mjFkc.mjFkc
        /* renamed from: xJ */
        public void mo1556xJ(C0176mjFkc.AZxh aZxh) {
            m1554qdMbNW(aZxh);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$KLFTb */
    public class C0143KLFTb implements C0122AZxh.AZxh {
        public C0143KLFTb() {
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: AZxh */
        public void mo1185AZxh(View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm != null) {
                abstractC0157mByQM1414dm.m1678BAnRFn(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: Dt */
        public void mo1186Dt(View view, int i, ViewGroup.LayoutParams layoutParams) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm != null) {
                if (!abstractC0157mByQM1414dm.m1682Gd() && !abstractC0157mByQM1414dm.m1687KLMXS()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + abstractC0157mByQM1414dm + RecyclerView.this.m1444KRTLGT());
                }
                if (RecyclerView.f1536LREOK) {
                    Log.d("RecyclerView", "reAttach " + abstractC0157mByQM1414dm);
                }
                abstractC0157mByQM1414dm.m1685JHa();
            } else if (RecyclerView.f1542gYa) {
                throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i + RecyclerView.this.m1444KRTLGT());
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: ETF */
        public int mo1187ETF(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: JHa */
        public void mo1188JHa(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.m1506lB(view);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: KLFTb */
        public void mo1189KLFTb(View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm != null) {
                abstractC0157mByQM1414dm.m1702lB(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: ZfxDd */
        public void mo1190ZfxDd(int i) {
            View viewMo1192mjFkc = mo1192mjFkc(i);
            if (viewMo1192mjFkc != null) {
                AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(viewMo1192mjFkc);
                if (abstractC0157mByQM1414dm != null) {
                    if (abstractC0157mByQM1414dm.m1682Gd() && !abstractC0157mByQM1414dm.m1687KLMXS()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + abstractC0157mByQM1414dm + RecyclerView.this.m1444KRTLGT());
                    }
                    if (RecyclerView.f1536LREOK) {
                        Log.d("RecyclerView", "tmpDetach " + abstractC0157mByQM1414dm);
                    }
                    abstractC0157mByQM1414dm.m1677AZxh(256);
                }
            } else if (RecyclerView.f1542gYa) {
                throw new IllegalArgumentException("No view at offset " + i + RecyclerView.this.m1444KRTLGT());
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: lgHUyS */
        public void mo1191lgHUyS(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.m1534wJVbdd(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: mjFkc */
        public View mo1192mjFkc(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: qdMbNW */
        public void mo1193qdMbNW() {
            int iMo1195xJ = mo1195xJ();
            for (int i = 0; i < iMo1195xJ; i++) {
                View viewMo1192mjFkc = mo1192mjFkc(i);
                RecyclerView.this.m1534wJVbdd(viewMo1192mjFkc);
                viewMo1192mjFkc.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: wA */
        public AbstractC0157mByQ mo1194wA(View view) {
            return RecyclerView.m1414dm(view);
        }

        @Override // androidx.recyclerview.p023widget.C0122AZxh.AZxh
        /* renamed from: xJ */
        public int mo1195xJ() {
            return RecyclerView.this.getChildCount();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$MiMN */
    public static abstract class AbstractC0144MiMN {

        /* renamed from: mjFkc */
        public mjFkc f1635mjFkc = null;

        /* renamed from: AZxh */
        public ArrayList f1631AZxh = new ArrayList();

        /* renamed from: wA */
        public long f1636wA = 120;

        /* renamed from: ZfxDd */
        public long f1634ZfxDd = 120;

        /* renamed from: KLFTb */
        public long f1633KLFTb = 250;

        /* renamed from: JHa */
        public long f1632JHa = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$MiMN$AZxh */
        public static class AZxh {

            /* renamed from: AZxh */
            public int f1637AZxh;

            /* renamed from: ZfxDd */
            public int f1638ZfxDd;

            /* renamed from: mjFkc */
            public int f1639mjFkc;

            /* renamed from: wA */
            public int f1640wA;

            /* renamed from: AZxh */
            public AZxh m1574AZxh(AbstractC0157mByQ abstractC0157mByQ, int i) {
                View view = abstractC0157mByQ.f1700mjFkc;
                this.f1639mjFkc = view.getLeft();
                this.f1637AZxh = view.getTop();
                this.f1640wA = view.getRight();
                this.f1638ZfxDd = view.getBottom();
                return this;
            }

            /* renamed from: mjFkc */
            public AZxh m1575mjFkc(AbstractC0157mByQ abstractC0157mByQ) {
                return m1574AZxh(abstractC0157mByQ, 0);
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$MiMN$mjFkc */
        public interface mjFkc {
            /* renamed from: mjFkc */
            void mo1576mjFkc(AbstractC0157mByQ abstractC0157mByQ);
        }

        /* renamed from: KLFTb */
        public static int m1557KLFTb(AbstractC0157mByQ abstractC0157mByQ) {
            int i = abstractC0157mByQ.f1688Dt;
            int i2 = i & 14;
            if (abstractC0157mByQ.m1698diqgf()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i2;
            }
            int iM1695YoKzxo = abstractC0157mByQ.m1695YoKzxo();
            int iM1680Dt = abstractC0157mByQ.m1680Dt();
            return (iM1695YoKzxo == -1 || iM1680Dt == -1 || iM1695YoKzxo == iM1680Dt) ? i2 : i2 | 2048;
        }

        /* renamed from: AZxh */
        public abstract boolean mo1381AZxh(AbstractC0157mByQ abstractC0157mByQ, AbstractC0157mByQ abstractC0157mByQ2, AZxh aZxh, AZxh aZxh2);

        /* renamed from: Dt */
        public abstract void mo1558Dt(AbstractC0157mByQ abstractC0157mByQ);

        /* renamed from: ETF */
        public abstract void mo1559ETF();

        /* renamed from: IEE */
        public void m1560IEE(AbstractC0157mByQ abstractC0157mByQ) {
        }

        /* renamed from: JHa */
        public abstract boolean mo1386JHa(AbstractC0157mByQ abstractC0157mByQ);

        /* renamed from: MiMN */
        public long m1561MiMN() {
            return this.f1632JHa;
        }

        /* renamed from: Pq */
        public AZxh m1562Pq(C0148VocHEe c0148VocHEe, AbstractC0157mByQ abstractC0157mByQ) {
            return m1568fehf().m1575mjFkc(abstractC0157mByQ);
        }

        /* renamed from: Ucbh */
        public void m1563Ucbh(mjFkc mjfkc) {
            this.f1635mjFkc = mjfkc;
        }

        /* renamed from: VA */
        public long m1564VA() {
            return this.f1636wA;
        }

        /* renamed from: YoKzxo */
        public long m1565YoKzxo() {
            return this.f1633KLFTb;
        }

        /* renamed from: ZfxDd */
        public abstract boolean mo1393ZfxDd(AbstractC0157mByQ abstractC0157mByQ, AZxh aZxh, AZxh aZxh2);

        /* renamed from: diqgf */
        public AZxh m1566diqgf(C0148VocHEe c0148VocHEe, AbstractC0157mByQ abstractC0157mByQ, int i, List list) {
            return m1568fehf().m1575mjFkc(abstractC0157mByQ);
        }

        /* renamed from: eyqo */
        public abstract void mo1567eyqo();

        /* renamed from: fehf */
        public AZxh m1568fehf() {
            return new AZxh();
        }

        /* renamed from: lgHUyS */
        public final void m1569lgHUyS(AbstractC0157mByQ abstractC0157mByQ) {
            m1560IEE(abstractC0157mByQ);
            mjFkc mjfkc = this.f1635mjFkc;
            if (mjfkc != null) {
                mjfkc.mo1576mjFkc(abstractC0157mByQ);
            }
        }

        /* renamed from: mjFkc */
        public abstract boolean mo1398mjFkc(AbstractC0157mByQ abstractC0157mByQ, AZxh aZxh, AZxh aZxh2);

        /* renamed from: qGY */
        public abstract boolean mo1570qGY();

        /* renamed from: qdMbNW */
        public final void m1571qdMbNW() {
            if (this.f1631AZxh.size() <= 0) {
                this.f1631AZxh.clear();
            } else {
                AbstractC4793w7.m13819mjFkc(this.f1631AZxh.get(0));
                throw null;
            }
        }

        /* renamed from: rkYL */
        public long m1572rkYL() {
            return this.f1634ZfxDd;
        }

        /* renamed from: wA */
        public abstract boolean mo1402wA(AbstractC0157mByQ abstractC0157mByQ, AZxh aZxh, AZxh aZxh2);

        /* renamed from: xJ */
        public boolean mo1573xJ(AbstractC0157mByQ abstractC0157mByQ, List list) {
            return mo1386JHa(abstractC0157mByQ);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$Pq */
    public interface InterfaceC0145Pq {
        /* renamed from: AZxh */
        void mo1577AZxh(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: mjFkc */
        boolean mo1578mjFkc(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: wA */
        void mo1579wA(boolean z);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$Ucbh */
    public final class C0146Ucbh {

        /* renamed from: AZxh */
        public ArrayList f1641AZxh;

        /* renamed from: JHa */
        public int f1642JHa;

        /* renamed from: KLFTb */
        public int f1643KLFTb;

        /* renamed from: ZfxDd */
        public final List f1644ZfxDd;

        /* renamed from: mjFkc */
        public final ArrayList f1646mjFkc;

        /* renamed from: wA */
        public final ArrayList f1647wA;

        /* renamed from: xJ */
        public C0152eyqo f1648xJ;

        public C0146Ucbh() {
            ArrayList arrayList = new ArrayList();
            this.f1646mjFkc = arrayList;
            this.f1641AZxh = null;
            this.f1647wA = new ArrayList();
            this.f1644ZfxDd = Collections.unmodifiableList(arrayList);
            this.f1643KLFTb = 2;
            this.f1642JHa = 2;
        }

        /* renamed from: AZxh */
        public final void m1580AZxh(AbstractC0157mByQ abstractC0157mByQ) {
            if (RecyclerView.this.m1538yX()) {
                View view = abstractC0157mByQ.f1700mjFkc;
                if (AbstractC2876T9.m10271eyqo(view) == 0) {
                    AbstractC2876T9.m10244NKyg(view, 1);
                }
                C0124ETF c0124etf = RecyclerView.this.f1616vjlshU;
                if (c0124etf == null) {
                    return;
                }
                C2454MiMN c2454MiMNM1218YoKzxo = c0124etf.m1218YoKzxo();
                if (c2454MiMNM1218YoKzxo instanceof C0124ETF.mjFkc) {
                    ((C0124ETF.mjFkc) c2454MiMNM1218YoKzxo).m1227rkYL(view);
                }
                AbstractC2876T9.m10265alEkx(view, c2454MiMNM1218YoKzxo);
            }
        }

        /* renamed from: BAnRFn */
        public final void m1581BAnRFn(AbstractC0156lgHUyS abstractC0156lgHUyS) {
            m1608lB(abstractC0156lgHUyS, false);
        }

        /* renamed from: CqaNbM */
        public void m1582CqaNbM(AbstractC0157mByQ abstractC0157mByQ) {
            boolean z;
            boolean z2 = true;
            if (abstractC0157mByQ.m1701huTpC() || abstractC0157mByQ.f1700mjFkc.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(abstractC0157mByQ.m1701huTpC());
                sb.append(" isAttached:");
                sb.append(abstractC0157mByQ.f1700mjFkc.getParent() != null);
                sb.append(RecyclerView.this.m1444KRTLGT());
                throw new IllegalArgumentException(sb.toString());
            }
            if (abstractC0157mByQ.m1682Gd()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + abstractC0157mByQ + RecyclerView.this.m1444KRTLGT());
            }
            if (abstractC0157mByQ.m1687KLMXS()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.m1444KRTLGT());
            }
            boolean zM1703lgHUyS = abstractC0157mByQ.m1703lgHUyS();
            AbstractC0156lgHUyS abstractC0156lgHUyS = RecyclerView.this.f1568MiMN;
            boolean z3 = abstractC0156lgHUyS != null && zM1703lgHUyS && abstractC0156lgHUyS.m1664YoKzxo(abstractC0157mByQ);
            if (RecyclerView.f1542gYa && this.f1647wA.contains(abstractC0157mByQ)) {
                throw new IllegalArgumentException("cached view received recycle internal? " + abstractC0157mByQ + RecyclerView.this.m1444KRTLGT());
            }
            if (z3 || abstractC0157mByQ.m1699eyqo()) {
                if (this.f1642JHa <= 0 || abstractC0157mByQ.m1706qGY(526)) {
                    z = false;
                } else {
                    int size = this.f1647wA.size();
                    if (size >= this.f1642JHa && size > 0) {
                        m1594OjSQV(0);
                        size--;
                    }
                    if (RecyclerView.f1548uH && size > 0 && !RecyclerView.this.f1560JBhc.m1299ZfxDd(abstractC0157mByQ.f1704wA)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.f1560JBhc.m1299ZfxDd(((AbstractC0157mByQ) this.f1647wA.get(i)).f1704wA)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.f1647wA.add(size, abstractC0157mByQ);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    m1611mjFkc(abstractC0157mByQ, true);
                }
                z = z;
            } else {
                if (RecyclerView.f1536LREOK) {
                    Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.m1444KRTLGT());
                }
                z2 = false;
            }
            RecyclerView.this.f1619xJ.m2032fehf(abstractC0157mByQ);
            if (z || z2 || !zM1703lgHUyS) {
                return;
            }
            AbstractC4924y3.m13991mjFkc(abstractC0157mByQ.f1700mjFkc);
            abstractC0157mByQ.f1694Pq = null;
            abstractC0157mByQ.f1690IEE = null;
        }

        /* renamed from: Dt */
        public int m1583Dt() {
            return this.f1646mjFkc.size();
        }

        /* renamed from: ETF */
        public List m1584ETF() {
            return this.f1644ZfxDd;
        }

        /* renamed from: Gd */
        public void m1585Gd(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1647wA.size() - 1; size >= 0; size--) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(size);
                if (abstractC0157mByQ != null) {
                    int i4 = abstractC0157mByQ.f1704wA;
                    if (i4 >= i3) {
                        if (RecyclerView.f1536LREOK) {
                            Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + abstractC0157mByQ + " now at position " + (abstractC0157mByQ.f1704wA - i2));
                        }
                        abstractC0157mByQ.m1694VocHEe(-i2, z);
                    } else if (i4 >= i) {
                        abstractC0157mByQ.m1677AZxh(8);
                        m1594OjSQV(size);
                    }
                }
            }
        }

        /* renamed from: HGpJ */
        public void m1586HGpJ(AbstractC0156lgHUyS abstractC0156lgHUyS, AbstractC0156lgHUyS abstractC0156lgHUyS2, boolean z) {
            m1619wA();
            m1608lB(abstractC0156lgHUyS, true);
            m1614qdMbNW().m1638Dt(abstractC0156lgHUyS, abstractC0156lgHUyS2, z);
            m1605eyqo();
        }

        /* renamed from: IEE */
        public final void m1587IEE(AbstractC0157mByQ abstractC0157mByQ) {
            View view = abstractC0157mByQ.f1700mjFkc;
            if (view instanceof ViewGroup) {
                m1606fehf((ViewGroup) view, false);
            }
        }

        /* renamed from: JHa */
        public int m1588JHa(int i) {
            if (i >= 0 && i < RecyclerView.this.f1581Vdz.m1624AZxh()) {
                return !RecyclerView.this.f1581Vdz.m1626KLFTb() ? i : RecyclerView.this.f1565KLFTb.m2006MiMN(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f1581Vdz.m1624AZxh() + RecyclerView.this.m1444KRTLGT());
        }

        /* renamed from: KLFTb */
        public void m1589KLFTb() {
            this.f1646mjFkc.clear();
            ArrayList arrayList = this.f1641AZxh;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* renamed from: KLMXS */
        public void m1590KLMXS(C0152eyqo c0152eyqo) {
            m1581BAnRFn(RecyclerView.this.f1568MiMN);
            C0152eyqo c0152eyqo2 = this.f1648xJ;
            if (c0152eyqo2 != null) {
                c0152eyqo2.m1645ZfxDd();
            }
            this.f1648xJ = c0152eyqo;
            if (c0152eyqo != null && RecyclerView.this.getAdapter() != null) {
                this.f1648xJ.m1647mjFkc();
            }
            m1605eyqo();
        }

        /* renamed from: MiMN */
        public AbstractC0157mByQ m1591MiMN(int i, boolean z) {
            View viewM1170KLFTb;
            int size = this.f1646mjFkc.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1646mjFkc.get(i2);
                if (!abstractC0157mByQ.m1697cMLeY() && abstractC0157mByQ.m1688MiMN() == i && !abstractC0157mByQ.m1698diqgf() && (RecyclerView.this.f1581Vdz.f1659lgHUyS || !abstractC0157mByQ.m1692Ucbh())) {
                    abstractC0157mByQ.m1677AZxh(32);
                    return abstractC0157mByQ;
                }
            }
            if (!z && (viewM1170KLFTb = RecyclerView.this.f1561JHa.m1170KLFTb(i)) != null) {
                AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(viewM1170KLFTb);
                RecyclerView.this.f1561JHa.m1172Pq(viewM1170KLFTb);
                int iM1171MiMN = RecyclerView.this.f1561JHa.m1171MiMN(viewM1170KLFTb);
                if (iM1171MiMN != -1) {
                    RecyclerView.this.f1561JHa.m1175ZfxDd(iM1171MiMN);
                    m1622xrEuO(viewM1170KLFTb);
                    abstractC0157mByQM1414dm.m1677AZxh(8224);
                    return abstractC0157mByQM1414dm;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + abstractC0157mByQM1414dm + RecyclerView.this.m1444KRTLGT());
            }
            int size2 = this.f1647wA.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractC0157mByQ abstractC0157mByQ2 = (AbstractC0157mByQ) this.f1647wA.get(i3);
                if (!abstractC0157mByQ2.m1698diqgf() && abstractC0157mByQ2.m1688MiMN() == i && !abstractC0157mByQ2.m1684IEE()) {
                    if (!z) {
                        this.f1647wA.remove(i3);
                    }
                    if (RecyclerView.f1536LREOK) {
                        Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + abstractC0157mByQ2);
                    }
                    return abstractC0157mByQ2;
                }
            }
            return null;
        }

        /* renamed from: NPj */
        public void m1592NPj(AbstractC0157mByQ abstractC0157mByQ) {
            if (abstractC0157mByQ.f1703rkYL) {
                this.f1641AZxh.remove(abstractC0157mByQ);
            } else {
                this.f1646mjFkc.remove(abstractC0157mByQ);
            }
            abstractC0157mByQ.f1696YoKzxo = null;
            abstractC0157mByQ.f1703rkYL = false;
            abstractC0157mByQ.m1686KLFTb();
        }

        /* renamed from: Ne */
        public void m1593Ne(View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm.m1682Gd()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (abstractC0157mByQM1414dm.m1701huTpC()) {
                abstractC0157mByQM1414dm.m1714zvd();
            } else if (abstractC0157mByQM1414dm.m1697cMLeY()) {
                abstractC0157mByQM1414dm.m1686KLFTb();
            }
            m1582CqaNbM(abstractC0157mByQM1414dm);
            if (RecyclerView.this.f1582Vnb == null || abstractC0157mByQM1414dm.m1699eyqo()) {
                return;
            }
            RecyclerView.this.f1582Vnb.mo1558Dt(abstractC0157mByQM1414dm);
        }

        /* renamed from: OjSQV */
        public void m1594OjSQV(int i) {
            if (RecyclerView.f1536LREOK) {
                Log.d("RecyclerView", "Recycling cached view at index " + i);
            }
            AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(i);
            if (RecyclerView.f1536LREOK) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + abstractC0157mByQ);
            }
            m1611mjFkc(abstractC0157mByQ, true);
            this.f1647wA.remove(i);
        }

        /* renamed from: Pq */
        public void m1595Pq() {
            int size = this.f1647wA.size();
            for (int i = 0; i < size; i++) {
                C0153fehf c0153fehf = (C0153fehf) ((AbstractC0157mByQ) this.f1647wA.get(i)).f1700mjFkc.getLayoutParams();
                if (c0153fehf != null) {
                    c0153fehf.f1678wA = true;
                }
            }
        }

        /* renamed from: Ucbh */
        public void m1596Ucbh(int i, int i2) {
            int size = this.f1647wA.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(i3);
                if (abstractC0157mByQ != null && abstractC0157mByQ.f1704wA >= i) {
                    if (RecyclerView.f1536LREOK) {
                        Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i3 + " holder " + abstractC0157mByQ + " now at position " + (abstractC0157mByQ.f1704wA + i2));
                    }
                    abstractC0157mByQ.m1694VocHEe(i2, false);
                }
            }
        }

        /* renamed from: VA */
        public AbstractC0157mByQ m1597VA(long j, int i, boolean z) {
            for (int size = this.f1646mjFkc.size() - 1; size >= 0; size--) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1646mjFkc.get(size);
                if (abstractC0157mByQ.m1681ETF() == j && !abstractC0157mByQ.m1697cMLeY()) {
                    if (i == abstractC0157mByQ.m1693VA()) {
                        abstractC0157mByQ.m1677AZxh(32);
                        if (abstractC0157mByQ.m1692Ucbh() && !RecyclerView.this.f1581Vdz.m1626KLFTb()) {
                            abstractC0157mByQ.m1690OjSQV(2, 14);
                        }
                        return abstractC0157mByQ;
                    }
                    if (!z) {
                        this.f1646mjFkc.remove(size);
                        RecyclerView.this.removeDetachedView(abstractC0157mByQ.f1700mjFkc, false);
                        m1620wJVbdd(abstractC0157mByQ.f1700mjFkc);
                    }
                }
            }
            int size2 = this.f1647wA.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                AbstractC0157mByQ abstractC0157mByQ2 = (AbstractC0157mByQ) this.f1647wA.get(size2);
                if (abstractC0157mByQ2.m1681ETF() == j && !abstractC0157mByQ2.m1684IEE()) {
                    if (i == abstractC0157mByQ2.m1693VA()) {
                        if (!z) {
                            this.f1647wA.remove(size2);
                        }
                        return abstractC0157mByQ2;
                    }
                    if (!z) {
                        m1594OjSQV(size2);
                        return null;
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0226 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0229  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x01fc  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x020a  */
        /* renamed from: Vnb */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AbstractC0157mByQ m1598Vnb(int i, boolean z, long j) {
            AbstractC0157mByQ abstractC0157mByQM1673wA;
            boolean z2;
            AbstractC0157mByQ abstractC0157mByQ;
            boolean z3;
            boolean zM1615rWxwaT;
            ViewGroup.LayoutParams layoutParams;
            C0153fehf c0153fehf;
            RecyclerView recyclerViewM1415nxI;
            if (i < 0 || i >= RecyclerView.this.f1581Vdz.m1624AZxh()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.f1581Vdz.m1624AZxh() + RecyclerView.this.m1444KRTLGT());
            }
            if (RecyclerView.this.f1581Vdz.m1626KLFTb()) {
                abstractC0157mByQM1673wA = m1609lgHUyS(i);
                if (abstractC0157mByQM1673wA != null) {
                    z2 = true;
                }
                if (abstractC0157mByQM1673wA == null && (abstractC0157mByQM1673wA = m1591MiMN(i, z)) != null) {
                    if (m1612oCFDzJ(abstractC0157mByQM1673wA)) {
                        if (!z) {
                            abstractC0157mByQM1673wA.m1677AZxh(4);
                            if (abstractC0157mByQM1673wA.m1701huTpC()) {
                                RecyclerView.this.removeDetachedView(abstractC0157mByQM1673wA.f1700mjFkc, false);
                                abstractC0157mByQM1673wA.m1714zvd();
                            } else if (abstractC0157mByQM1673wA.m1697cMLeY()) {
                                abstractC0157mByQM1673wA.m1686KLFTb();
                            }
                            m1582CqaNbM(abstractC0157mByQM1673wA);
                        }
                        abstractC0157mByQM1673wA = null;
                    } else {
                        z2 = true;
                    }
                }
                if (abstractC0157mByQM1673wA == null) {
                    int iM2006MiMN = RecyclerView.this.f1565KLFTb.m2006MiMN(i);
                    if (iM2006MiMN < 0 || iM2006MiMN >= RecyclerView.this.f1568MiMN.mo1665ZfxDd()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iM2006MiMN + ").state:" + RecyclerView.this.f1581Vdz.m1624AZxh() + RecyclerView.this.m1444KRTLGT());
                    }
                    int iM1659JHa = RecyclerView.this.f1568MiMN.m1659JHa(iM2006MiMN);
                    if (RecyclerView.this.f1568MiMN.m1668lgHUyS() && (abstractC0157mByQM1673wA = m1597VA(RecyclerView.this.f1568MiMN.mo1660KLFTb(iM2006MiMN), iM1659JHa, z)) != null) {
                        abstractC0157mByQM1673wA.f1704wA = iM2006MiMN;
                        z2 = true;
                    }
                    if (abstractC0157mByQM1673wA == null) {
                        if (RecyclerView.f1536LREOK) {
                            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                        }
                        abstractC0157mByQM1673wA = m1614qdMbNW().m1646lgHUyS(iM1659JHa);
                        if (abstractC0157mByQM1673wA != null) {
                            abstractC0157mByQM1673wA.m1711wJVbdd();
                            if (RecyclerView.f1538XFUzSY) {
                                m1587IEE(abstractC0157mByQM1673wA);
                            }
                        }
                    }
                    if (abstractC0157mByQM1673wA == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j != LongCompanionObject.MAX_VALUE && !this.f1648xJ.m1644YoKzxo(iM1659JHa, nanoTime, j)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        abstractC0157mByQM1673wA = recyclerView.f1568MiMN.m1673wA(recyclerView, iM1659JHa);
                        if (RecyclerView.f1548uH && (recyclerViewM1415nxI = RecyclerView.m1415nxI(abstractC0157mByQM1673wA.f1700mjFkc)) != null) {
                            abstractC0157mByQM1673wA.f1687AZxh = new WeakReference(recyclerViewM1415nxI);
                        }
                        this.f1648xJ.m1650xJ(iM1659JHa, RecyclerView.this.getNanoTime() - nanoTime);
                        if (RecyclerView.f1536LREOK) {
                            Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                        }
                    }
                }
                abstractC0157mByQ = abstractC0157mByQM1673wA;
                z3 = z2;
                if (z3 && !RecyclerView.this.f1581Vdz.m1626KLFTb() && abstractC0157mByQ.m1706qGY(8192)) {
                    abstractC0157mByQ.m1690OjSQV(0, 8192);
                    if (RecyclerView.this.f1581Vdz.f1651ETF) {
                        int iM1557KLFTb = AbstractC0144MiMN.m1557KLFTb(abstractC0157mByQ) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.m1502jtz(abstractC0157mByQ, recyclerView2.f1582Vnb.m1566diqgf(recyclerView2.f1581Vdz, abstractC0157mByQ, iM1557KLFTb, abstractC0157mByQ.m1708rkYL()));
                    }
                }
                if (RecyclerView.this.f1581Vdz.m1626KLFTb() || !abstractC0157mByQ.m1691Pq()) {
                    if (abstractC0157mByQ.m1691Pq() || abstractC0157mByQ.m1709vI() || abstractC0157mByQ.m1698diqgf()) {
                        if (!RecyclerView.f1542gYa && abstractC0157mByQ.m1692Ucbh()) {
                            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + abstractC0157mByQ + RecyclerView.this.m1444KRTLGT());
                        }
                        zM1615rWxwaT = m1615rWxwaT(abstractC0157mByQ, RecyclerView.this.f1565KLFTb.m2006MiMN(i), i, j);
                    }
                    layoutParams = abstractC0157mByQ.f1700mjFkc.getLayoutParams();
                    if (layoutParams == null) {
                        c0153fehf = (C0153fehf) RecyclerView.this.generateDefaultLayoutParams();
                        abstractC0157mByQ.f1700mjFkc.setLayoutParams(c0153fehf);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        c0153fehf = (C0153fehf) layoutParams;
                    } else {
                        c0153fehf = (C0153fehf) RecyclerView.this.generateLayoutParams(layoutParams);
                        abstractC0157mByQ.f1700mjFkc.setLayoutParams(c0153fehf);
                    }
                    c0153fehf.f1677mjFkc = abstractC0157mByQ;
                    c0153fehf.f1676ZfxDd = z3 && zM1615rWxwaT;
                    return abstractC0157mByQ;
                }
                abstractC0157mByQ.f1705xJ = i;
                zM1615rWxwaT = false;
                layoutParams = abstractC0157mByQ.f1700mjFkc.getLayoutParams();
                if (layoutParams == null) {
                }
                c0153fehf.f1677mjFkc = abstractC0157mByQ;
                c0153fehf.f1676ZfxDd = z3 && zM1615rWxwaT;
                return abstractC0157mByQ;
            }
            abstractC0157mByQM1673wA = null;
            z2 = false;
            if (abstractC0157mByQM1673wA == null) {
                if (m1612oCFDzJ(abstractC0157mByQM1673wA)) {
                }
            }
            if (abstractC0157mByQM1673wA == null) {
            }
            abstractC0157mByQ = abstractC0157mByQM1673wA;
            z3 = z2;
            if (z3) {
                abstractC0157mByQ.m1690OjSQV(0, 8192);
                if (RecyclerView.this.f1581Vdz.f1651ETF) {
                }
            }
            if (RecyclerView.this.f1581Vdz.m1626KLFTb()) {
                if (abstractC0157mByQ.m1691Pq()) {
                }
                if (!RecyclerView.f1542gYa) {
                }
                zM1615rWxwaT = m1615rWxwaT(abstractC0157mByQ, RecyclerView.this.f1565KLFTb.m2006MiMN(i), i, j);
            }
            layoutParams = abstractC0157mByQ.f1700mjFkc.getLayoutParams();
            if (layoutParams == null) {
            }
            c0153fehf.f1677mjFkc = abstractC0157mByQ;
            c0153fehf.f1676ZfxDd = z3 && zM1615rWxwaT;
            return abstractC0157mByQ;
        }

        /* renamed from: VocHEe */
        public void m1599VocHEe() {
            for (int i = 0; i < this.f1647wA.size(); i++) {
                AbstractC4924y3.m13991mjFkc(((AbstractC0157mByQ) this.f1647wA.get(i)).f1700mjFkc);
            }
            m1581BAnRFn(RecyclerView.this.f1568MiMN);
        }

        /* renamed from: YoKzxo */
        public View m1600YoKzxo(int i) {
            return ((AbstractC0157mByQ) this.f1646mjFkc.get(i)).f1700mjFkc;
        }

        /* renamed from: ZfxDd */
        public void m1601ZfxDd() {
            int size = this.f1647wA.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC0157mByQ) this.f1647wA.get(i)).m1710wA();
            }
            int size2 = this.f1646mjFkc.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((AbstractC0157mByQ) this.f1646mjFkc.get(i2)).m1710wA();
            }
            ArrayList arrayList = this.f1641AZxh;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((AbstractC0157mByQ) this.f1641AZxh.get(i3)).m1710wA();
                }
            }
        }

        /* renamed from: aqHPIZ */
        public void m1602aqHPIZ(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f1647wA.size() - 1; size >= 0; size--) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(size);
                if (abstractC0157mByQ != null && (i3 = abstractC0157mByQ.f1704wA) >= i && i3 < i4) {
                    abstractC0157mByQ.m1677AZxh(2);
                    m1594OjSQV(size);
                }
            }
        }

        /* renamed from: cMLeY */
        public void m1603cMLeY(int i) {
            this.f1643KLFTb = i;
            m1618vadzgd();
        }

        /* renamed from: diqgf */
        public void m1604diqgf() {
            int size = this.f1647wA.size();
            for (int i = 0; i < size; i++) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(i);
                if (abstractC0157mByQ != null) {
                    abstractC0157mByQ.m1677AZxh(6);
                    abstractC0157mByQ.m1705mjFkc(null);
                }
            }
            AbstractC0156lgHUyS abstractC0156lgHUyS = RecyclerView.this.f1568MiMN;
            if (abstractC0156lgHUyS == null || !abstractC0156lgHUyS.m1668lgHUyS()) {
                m1610mByQ();
            }
        }

        /* renamed from: eyqo */
        public final void m1605eyqo() {
            if (this.f1648xJ != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f1568MiMN == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.f1648xJ.m1637AZxh(RecyclerView.this.f1568MiMN);
            }
        }

        /* renamed from: fehf */
        public final void m1606fehf(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m1606fehf((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* renamed from: huTpC */
        public void m1607huTpC(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f1647wA.size();
            for (int i7 = 0; i7 < size; i7++) {
                AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1647wA.get(i7);
                if (abstractC0157mByQ != null && (i6 = abstractC0157mByQ.f1704wA) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        abstractC0157mByQ.m1694VocHEe(i2 - i, false);
                    } else {
                        abstractC0157mByQ.m1694VocHEe(i3, false);
                    }
                    if (RecyclerView.f1536LREOK) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i7 + " holder " + abstractC0157mByQ);
                    }
                }
            }
        }

        /* renamed from: lB */
        public final void m1608lB(AbstractC0156lgHUyS abstractC0156lgHUyS, boolean z) {
            C0152eyqo c0152eyqo = this.f1648xJ;
            if (c0152eyqo != null) {
                c0152eyqo.m1641KLFTb(abstractC0156lgHUyS, z);
            }
        }

        /* renamed from: lgHUyS */
        public AbstractC0157mByQ m1609lgHUyS(int i) {
            int size;
            int iM2006MiMN;
            ArrayList arrayList = this.f1641AZxh;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1641AZxh.get(i2);
                    if (!abstractC0157mByQ.m1697cMLeY() && abstractC0157mByQ.m1688MiMN() == i) {
                        abstractC0157mByQ.m1677AZxh(32);
                        return abstractC0157mByQ;
                    }
                }
                if (RecyclerView.this.f1568MiMN.m1668lgHUyS() && (iM2006MiMN = RecyclerView.this.f1565KLFTb.m2006MiMN(i)) > 0 && iM2006MiMN < RecyclerView.this.f1568MiMN.mo1665ZfxDd()) {
                    long jMo1660KLFTb = RecyclerView.this.f1568MiMN.mo1660KLFTb(iM2006MiMN);
                    for (int i3 = 0; i3 < size; i3++) {
                        AbstractC0157mByQ abstractC0157mByQ2 = (AbstractC0157mByQ) this.f1641AZxh.get(i3);
                        if (!abstractC0157mByQ2.m1697cMLeY() && abstractC0157mByQ2.m1681ETF() == jMo1660KLFTb) {
                            abstractC0157mByQ2.m1677AZxh(32);
                            return abstractC0157mByQ2;
                        }
                    }
                }
            }
            return null;
        }

        /* renamed from: mByQ */
        public void m1610mByQ() {
            for (int size = this.f1647wA.size() - 1; size >= 0; size--) {
                m1594OjSQV(size);
            }
            this.f1647wA.clear();
            if (RecyclerView.f1548uH) {
                RecyclerView.this.f1560JBhc.m1297AZxh();
            }
        }

        /* renamed from: mjFkc */
        public void m1611mjFkc(AbstractC0157mByQ abstractC0157mByQ, boolean z) {
            RecyclerView.m1410Pq(abstractC0157mByQ);
            View view = abstractC0157mByQ.f1700mjFkc;
            C0124ETF c0124etf = RecyclerView.this.f1616vjlshU;
            if (c0124etf != null) {
                C2454MiMN c2454MiMNM1218YoKzxo = c0124etf.m1218YoKzxo();
                AbstractC2876T9.m10265alEkx(view, c2454MiMNM1218YoKzxo instanceof C0124ETF.mjFkc ? ((C0124ETF.mjFkc) c2454MiMNM1218YoKzxo).m1223YoKzxo(view) : null);
            }
            if (z) {
                m1621xJ(abstractC0157mByQ);
            }
            abstractC0157mByQ.f1694Pq = null;
            abstractC0157mByQ.f1690IEE = null;
            m1614qdMbNW().m1639ETF(abstractC0157mByQ);
        }

        /* renamed from: oCFDzJ */
        public boolean m1612oCFDzJ(AbstractC0157mByQ abstractC0157mByQ) {
            if (abstractC0157mByQ.m1692Ucbh()) {
                if (!RecyclerView.f1542gYa || RecyclerView.this.f1581Vdz.m1626KLFTb()) {
                    return RecyclerView.this.f1581Vdz.m1626KLFTb();
                }
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.m1444KRTLGT());
            }
            int i = abstractC0157mByQ.f1704wA;
            if (i >= 0 && i < RecyclerView.this.f1568MiMN.mo1665ZfxDd()) {
                if (RecyclerView.this.f1581Vdz.m1626KLFTb() || RecyclerView.this.f1568MiMN.m1659JHa(abstractC0157mByQ.f1704wA) == abstractC0157mByQ.m1693VA()) {
                    return !RecyclerView.this.f1568MiMN.m1668lgHUyS() || abstractC0157mByQ.m1681ETF() == RecyclerView.this.f1568MiMN.mo1660KLFTb(abstractC0157mByQ.f1704wA);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + abstractC0157mByQ + RecyclerView.this.m1444KRTLGT());
        }

        /* renamed from: qGY */
        public View m1613qGY(int i, boolean z) {
            return m1598Vnb(i, z, LongCompanionObject.MAX_VALUE).f1700mjFkc;
        }

        /* renamed from: qdMbNW */
        public C0152eyqo m1614qdMbNW() {
            if (this.f1648xJ == null) {
                this.f1648xJ = new C0152eyqo();
                m1605eyqo();
            }
            return this.f1648xJ;
        }

        /* renamed from: rWxwaT */
        public final boolean m1615rWxwaT(AbstractC0157mByQ abstractC0157mByQ, int i, int i2, long j) {
            abstractC0157mByQ.f1694Pq = null;
            abstractC0157mByQ.f1690IEE = RecyclerView.this;
            int iM1693VA = abstractC0157mByQ.m1693VA();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z = false;
            if (j != LongCompanionObject.MAX_VALUE && !this.f1648xJ.m1642MiMN(iM1693VA, nanoTime, j)) {
                return false;
            }
            if (abstractC0157mByQ.m1682Gd()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(abstractC0157mByQ.f1700mjFkc, recyclerView.getChildCount(), abstractC0157mByQ.f1700mjFkc.getLayoutParams());
                z = true;
            }
            RecyclerView.this.f1568MiMN.m1669mjFkc(abstractC0157mByQ, i);
            if (z) {
                RecyclerView.this.detachViewFromParent(abstractC0157mByQ.f1700mjFkc);
            }
            this.f1648xJ.m1640JHa(abstractC0157mByQ.m1693VA(), RecyclerView.this.getNanoTime() - nanoTime);
            m1580AZxh(abstractC0157mByQ);
            if (RecyclerView.this.f1581Vdz.m1626KLFTb()) {
                abstractC0157mByQ.f1705xJ = i2;
            }
            return true;
        }

        /* renamed from: rkYL */
        public View m1616rkYL(int i) {
            return m1613qGY(i, false);
        }

        /* renamed from: vI */
        public void m1617vI() {
            m1605eyqo();
        }

        /* renamed from: vadzgd */
        public void m1618vadzgd() {
            AbstractC0159qGY abstractC0159qGY = RecyclerView.this.f1587YoKzxo;
            this.f1642JHa = this.f1643KLFTb + (abstractC0159qGY != null ? abstractC0159qGY.f1713MiMN : 0);
            for (int size = this.f1647wA.size() - 1; size >= 0 && this.f1647wA.size() > this.f1642JHa; size--) {
                m1594OjSQV(size);
            }
        }

        /* renamed from: wA */
        public void m1619wA() {
            this.f1646mjFkc.clear();
            m1610mByQ();
        }

        /* renamed from: wJVbdd */
        public void m1620wJVbdd(View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            abstractC0157mByQM1414dm.f1696YoKzxo = null;
            abstractC0157mByQM1414dm.f1703rkYL = false;
            abstractC0157mByQM1414dm.m1686KLFTb();
            m1582CqaNbM(abstractC0157mByQM1414dm);
        }

        /* renamed from: xJ */
        public void m1621xJ(AbstractC0157mByQ abstractC0157mByQ) {
            RecyclerView.this.getClass();
            if (RecyclerView.this.f1610rkYL.size() > 0) {
                AbstractC4793w7.m13819mjFkc(RecyclerView.this.f1610rkYL.get(0));
                throw null;
            }
            AbstractC0156lgHUyS abstractC0156lgHUyS = RecyclerView.this.f1568MiMN;
            if (abstractC0156lgHUyS != null) {
                abstractC0156lgHUyS.m1667fehf(abstractC0157mByQ);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1581Vdz != null) {
                recyclerView.f1619xJ.m2032fehf(abstractC0157mByQ);
            }
            if (RecyclerView.f1536LREOK) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + abstractC0157mByQ);
            }
        }

        /* renamed from: xrEuO */
        public void m1622xrEuO(View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (!abstractC0157mByQM1414dm.m1706qGY(12) && abstractC0157mByQM1414dm.m1683HGpJ() && !RecyclerView.this.m1494fehf(abstractC0157mByQM1414dm)) {
                if (this.f1641AZxh == null) {
                    this.f1641AZxh = new ArrayList();
                }
                abstractC0157mByQM1414dm.m1679CqaNbM(this, true);
                this.f1641AZxh.add(abstractC0157mByQM1414dm);
                return;
            }
            if (!abstractC0157mByQM1414dm.m1698diqgf() || abstractC0157mByQM1414dm.m1692Ucbh() || RecyclerView.this.f1568MiMN.m1668lgHUyS()) {
                abstractC0157mByQM1414dm.m1679CqaNbM(this, false);
                this.f1646mjFkc.add(abstractC0157mByQM1414dm);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.m1444KRTLGT());
            }
        }

        /* renamed from: zvd */
        public void m1623zvd(AbstractC0155lB abstractC0155lB) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$VA */
    public static class C0147VA {
        /* renamed from: mjFkc */
        public abstract EdgeEffect mo1542mjFkc(RecyclerView recyclerView, int i);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$VocHEe */
    public static class C0148VocHEe {

        /* renamed from: AZxh */
        public SparseArray f1649AZxh;

        /* renamed from: MiMN */
        public int f1654MiMN;

        /* renamed from: YoKzxo */
        public long f1656YoKzxo;

        /* renamed from: fehf */
        public int f1658fehf;

        /* renamed from: qGY */
        public int f1661qGY;

        /* renamed from: rkYL */
        public int f1663rkYL;

        /* renamed from: mjFkc */
        public int f1660mjFkc = -1;

        /* renamed from: wA */
        public int f1664wA = 0;

        /* renamed from: ZfxDd */
        public int f1657ZfxDd = 0;

        /* renamed from: KLFTb */
        public int f1653KLFTb = 1;

        /* renamed from: JHa */
        public int f1652JHa = 0;

        /* renamed from: xJ */
        public boolean f1665xJ = false;

        /* renamed from: lgHUyS */
        public boolean f1659lgHUyS = false;

        /* renamed from: qdMbNW */
        public boolean f1662qdMbNW = false;

        /* renamed from: Dt */
        public boolean f1650Dt = false;

        /* renamed from: ETF */
        public boolean f1651ETF = false;

        /* renamed from: VA */
        public boolean f1655VA = false;

        /* renamed from: AZxh */
        public int m1624AZxh() {
            return this.f1659lgHUyS ? this.f1664wA - this.f1657ZfxDd : this.f1652JHa;
        }

        /* renamed from: JHa */
        public void m1625JHa(AbstractC0156lgHUyS abstractC0156lgHUyS) {
            this.f1653KLFTb = 1;
            this.f1652JHa = abstractC0156lgHUyS.mo1665ZfxDd();
            this.f1659lgHUyS = false;
            this.f1662qdMbNW = false;
            this.f1650Dt = false;
        }

        /* renamed from: KLFTb */
        public boolean m1626KLFTb() {
            return this.f1659lgHUyS;
        }

        /* renamed from: ZfxDd */
        public boolean m1627ZfxDd() {
            return this.f1660mjFkc != -1;
        }

        /* renamed from: mjFkc */
        public void m1628mjFkc(int i) {
            if ((this.f1653KLFTb & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1653KLFTb));
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1660mjFkc + ", mData=" + this.f1649AZxh + ", mItemCount=" + this.f1652JHa + ", mIsMeasuring=" + this.f1650Dt + ", mPreviousLayoutItemCount=" + this.f1664wA + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1657ZfxDd + ", mStructureChanged=" + this.f1665xJ + ", mInPreLayout=" + this.f1659lgHUyS + ", mRunSimpleAnimations=" + this.f1651ETF + ", mRunPredictiveAnimations=" + this.f1655VA + '}';
        }

        /* renamed from: wA */
        public int m1629wA() {
            return this.f1660mjFkc;
        }

        /* renamed from: xJ */
        public boolean m1630xJ() {
            return this.f1655VA;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$YoKzxo */
    public class C0149YoKzxo implements AbstractC0144MiMN.mjFkc {
        public C0149YoKzxo() {
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0144MiMN.mjFkc
        /* renamed from: mjFkc */
        public void mo1576mjFkc(AbstractC0157mByQ abstractC0157mByQ) {
            abstractC0157mByQ.m1689Ne(true);
            if (abstractC0157mByQ.f1699lgHUyS != null && abstractC0157mByQ.f1702qdMbNW == null) {
                abstractC0157mByQ.f1699lgHUyS = null;
            }
            abstractC0157mByQ.f1702qdMbNW = null;
            if (abstractC0157mByQ.m1713xrEuO() || RecyclerView.this.m1483Zdbk(abstractC0157mByQ.f1700mjFkc) || !abstractC0157mByQ.m1682Gd()) {
                return;
            }
            RecyclerView.this.removeDetachedView(abstractC0157mByQ.f1700mjFkc, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$ZfxDd */
    public class C0150ZfxDd implements C0177qGY.AZxh {
        public C0150ZfxDd() {
        }

        @Override // androidx.recyclerview.p023widget.C0177qGY.AZxh
        /* renamed from: AZxh */
        public void mo1631AZxh(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2) {
            RecyclerView.this.m1449MiMN(abstractC0157mByQ, aZxh, aZxh2);
        }

        @Override // androidx.recyclerview.p023widget.C0177qGY.AZxh
        /* renamed from: ZfxDd */
        public void mo1632ZfxDd(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2) {
            abstractC0157mByQ.m1689Ne(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1603mByQ) {
                if (recyclerView.f1582Vnb.mo1381AZxh(abstractC0157mByQ, abstractC0157mByQ, aZxh, aZxh2)) {
                    RecyclerView.this.m1460SKTn();
                }
            } else if (recyclerView.f1582Vnb.mo1393ZfxDd(abstractC0157mByQ, aZxh, aZxh2)) {
                RecyclerView.this.m1460SKTn();
            }
        }

        @Override // androidx.recyclerview.p023widget.C0177qGY.AZxh
        /* renamed from: mjFkc */
        public void mo1633mjFkc(AbstractC0157mByQ abstractC0157mByQ) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1587YoKzxo.m1752RWyiuY(abstractC0157mByQ.f1700mjFkc, recyclerView.f1617wA);
        }

        @Override // androidx.recyclerview.p023widget.C0177qGY.AZxh
        /* renamed from: wA */
        public void mo1634wA(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2) {
            RecyclerView.this.f1617wA.m1592NPj(abstractC0157mByQ);
            RecyclerView.this.m1521rkYL(abstractC0157mByQ, aZxh, aZxh2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$diqgf */
    public static abstract class AbstractC0151diqgf {
        /* renamed from: AZxh */
        public abstract void mo1635AZxh(RecyclerView recyclerView, int i, int i2);

        /* renamed from: mjFkc */
        public void mo1636mjFkc(RecyclerView recyclerView, int i) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$eyqo */
    public static class C0152eyqo {

        /* renamed from: mjFkc */
        public SparseArray f1669mjFkc = new SparseArray();

        /* renamed from: AZxh */
        public int f1668AZxh = 0;

        /* renamed from: wA */
        public Set f1670wA = Collections.newSetFromMap(new IdentityHashMap());

        /* renamed from: androidx.recyclerview.widget.RecyclerView$eyqo$mjFkc */
        public static class mjFkc {

            /* renamed from: mjFkc */
            public final ArrayList f1673mjFkc = new ArrayList();

            /* renamed from: AZxh */
            public int f1671AZxh = 5;

            /* renamed from: wA */
            public long f1674wA = 0;

            /* renamed from: ZfxDd */
            public long f1672ZfxDd = 0;
        }

        /* renamed from: AZxh */
        public void m1637AZxh(AbstractC0156lgHUyS abstractC0156lgHUyS) {
            this.f1670wA.add(abstractC0156lgHUyS);
        }

        /* renamed from: Dt */
        public void m1638Dt(AbstractC0156lgHUyS abstractC0156lgHUyS, AbstractC0156lgHUyS abstractC0156lgHUyS2, boolean z) {
            if (abstractC0156lgHUyS != null) {
                m1645ZfxDd();
            }
            if (!z && this.f1668AZxh == 0) {
                m1649wA();
            }
            if (abstractC0156lgHUyS2 != null) {
                m1647mjFkc();
            }
        }

        /* renamed from: ETF */
        public void m1639ETF(AbstractC0157mByQ abstractC0157mByQ) {
            int iM1693VA = abstractC0157mByQ.m1693VA();
            ArrayList arrayList = m1648qdMbNW(iM1693VA).f1673mjFkc;
            if (((mjFkc) this.f1669mjFkc.get(iM1693VA)).f1671AZxh <= arrayList.size()) {
                AbstractC4924y3.m13991mjFkc(abstractC0157mByQ.f1700mjFkc);
            } else {
                if (RecyclerView.f1542gYa && arrayList.contains(abstractC0157mByQ)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                abstractC0157mByQ.m1711wJVbdd();
                arrayList.add(abstractC0157mByQ);
            }
        }

        /* renamed from: JHa */
        public void m1640JHa(int i, long j) {
            mjFkc mjfkcM1648qdMbNW = m1648qdMbNW(i);
            mjfkcM1648qdMbNW.f1672ZfxDd = m1643VA(mjfkcM1648qdMbNW.f1672ZfxDd, j);
        }

        /* renamed from: KLFTb */
        public void m1641KLFTb(AbstractC0156lgHUyS abstractC0156lgHUyS, boolean z) {
            this.f1670wA.remove(abstractC0156lgHUyS);
            if (this.f1670wA.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < this.f1669mjFkc.size(); i++) {
                SparseArray sparseArray = this.f1669mjFkc;
                ArrayList arrayList = ((mjFkc) sparseArray.get(sparseArray.keyAt(i))).f1673mjFkc;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    AbstractC4924y3.m13991mjFkc(((AbstractC0157mByQ) arrayList.get(i2)).f1700mjFkc);
                }
            }
        }

        /* renamed from: MiMN */
        public boolean m1642MiMN(int i, long j, long j2) {
            long j3 = m1648qdMbNW(i).f1672ZfxDd;
            return j3 == 0 || j + j3 < j2;
        }

        /* renamed from: VA */
        public long m1643VA(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* renamed from: YoKzxo */
        public boolean m1644YoKzxo(int i, long j, long j2) {
            long j3 = m1648qdMbNW(i).f1674wA;
            return j3 == 0 || j + j3 < j2;
        }

        /* renamed from: ZfxDd */
        public void m1645ZfxDd() {
            this.f1668AZxh--;
        }

        /* renamed from: lgHUyS */
        public AbstractC0157mByQ m1646lgHUyS(int i) {
            mjFkc mjfkc = (mjFkc) this.f1669mjFkc.get(i);
            if (mjfkc == null || mjfkc.f1673mjFkc.isEmpty()) {
                return null;
            }
            ArrayList arrayList = mjfkc.f1673mjFkc;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((AbstractC0157mByQ) arrayList.get(size)).m1684IEE()) {
                    return (AbstractC0157mByQ) arrayList.remove(size);
                }
            }
            return null;
        }

        /* renamed from: mjFkc */
        public void m1647mjFkc() {
            this.f1668AZxh++;
        }

        /* renamed from: qdMbNW */
        public final mjFkc m1648qdMbNW(int i) {
            mjFkc mjfkc = (mjFkc) this.f1669mjFkc.get(i);
            if (mjfkc != null) {
                return mjfkc;
            }
            mjFkc mjfkc2 = new mjFkc();
            this.f1669mjFkc.put(i, mjfkc2);
            return mjfkc2;
        }

        /* renamed from: wA */
        public void m1649wA() {
            for (int i = 0; i < this.f1669mjFkc.size(); i++) {
                mjFkc mjfkc = (mjFkc) this.f1669mjFkc.valueAt(i);
                Iterator it = mjfkc.f1673mjFkc.iterator();
                while (it.hasNext()) {
                    AbstractC4924y3.m13991mjFkc(((AbstractC0157mByQ) it.next()).f1700mjFkc);
                }
                mjfkc.f1673mjFkc.clear();
            }
        }

        /* renamed from: xJ */
        public void m1650xJ(int i, long j) {
            mjFkc mjfkcM1648qdMbNW = m1648qdMbNW(i);
            mjfkcM1648qdMbNW.f1674wA = m1643VA(mjfkcM1648qdMbNW.f1674wA, j);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$huTpC */
    public interface InterfaceC0154huTpC {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$lB */
    public static abstract class AbstractC0155lB {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$lgHUyS */
    public static abstract class AbstractC0156lgHUyS {

        /* renamed from: mjFkc */
        public final C0160qdMbNW f1680mjFkc = new C0160qdMbNW();

        /* renamed from: AZxh */
        public boolean f1679AZxh = false;

        /* renamed from: wA */
        public mjFkc f1681wA = mjFkc.ALLOW;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$lgHUyS$mjFkc */
        public enum mjFkc {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* renamed from: AZxh */
        public boolean m1655AZxh() {
            int i = C0165xJ.f1753mjFkc[this.f1681wA.ordinal()];
            if (i != 1) {
                return i != 2 || mo1665ZfxDd() > 0;
            }
            return false;
        }

        /* renamed from: Dt */
        public abstract void mo1656Dt(AbstractC0157mByQ abstractC0157mByQ, int i);

        /* renamed from: ETF */
        public void m1657ETF(AbstractC0157mByQ abstractC0157mByQ, int i, List list) {
            mo1656Dt(abstractC0157mByQ, i);
        }

        /* renamed from: IEE */
        public void m1658IEE(AbstractC0137Dt abstractC0137Dt) {
            this.f1680mjFkc.registerObserver(abstractC0137Dt);
        }

        /* renamed from: JHa */
        public int m1659JHa(int i) {
            return 0;
        }

        /* renamed from: KLFTb */
        public long mo1660KLFTb(int i) {
            return -1L;
        }

        /* renamed from: MiMN */
        public void m1661MiMN(RecyclerView recyclerView) {
        }

        /* renamed from: Pq */
        public void m1662Pq(boolean z) {
            if (m1674xJ()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1679AZxh = z;
        }

        /* renamed from: VA */
        public abstract AbstractC0157mByQ mo1663VA(ViewGroup viewGroup, int i);

        /* renamed from: YoKzxo */
        public boolean m1664YoKzxo(AbstractC0157mByQ abstractC0157mByQ) {
            return false;
        }

        /* renamed from: ZfxDd */
        public abstract int mo1665ZfxDd();

        /* renamed from: diqgf */
        public void m1666diqgf(AbstractC0137Dt abstractC0137Dt) {
            this.f1680mjFkc.unregisterObserver(abstractC0137Dt);
        }

        /* renamed from: fehf */
        public void m1667fehf(AbstractC0157mByQ abstractC0157mByQ) {
        }

        /* renamed from: lgHUyS */
        public final boolean m1668lgHUyS() {
            return this.f1679AZxh;
        }

        /* renamed from: mjFkc */
        public final void m1669mjFkc(AbstractC0157mByQ abstractC0157mByQ, int i) {
            boolean z = abstractC0157mByQ.f1694Pq == null;
            if (z) {
                abstractC0157mByQ.f1704wA = i;
                if (m1668lgHUyS()) {
                    abstractC0157mByQ.f1692KLFTb = mo1660KLFTb(i);
                }
                abstractC0157mByQ.m1690OjSQV(1, 519);
                AbstractC2352L8.m9358mjFkc("RV OnBindView");
            }
            abstractC0157mByQ.f1694Pq = this;
            if (RecyclerView.f1542gYa) {
                if (abstractC0157mByQ.f1700mjFkc.getParent() == null && AbstractC2876T9.m10268cMLeY(abstractC0157mByQ.f1700mjFkc) != abstractC0157mByQ.m1682Gd()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + abstractC0157mByQ.m1682Gd() + ", attached to window: " + AbstractC2876T9.m10268cMLeY(abstractC0157mByQ.f1700mjFkc) + ", holder: " + abstractC0157mByQ);
                }
                if (abstractC0157mByQ.f1700mjFkc.getParent() == null && AbstractC2876T9.m10268cMLeY(abstractC0157mByQ.f1700mjFkc)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + abstractC0157mByQ);
                }
            }
            m1657ETF(abstractC0157mByQ, i, abstractC0157mByQ.m1708rkYL());
            if (z) {
                abstractC0157mByQ.m1696ZfxDd();
                ViewGroup.LayoutParams layoutParams = abstractC0157mByQ.f1700mjFkc.getLayoutParams();
                if (layoutParams instanceof C0153fehf) {
                    ((C0153fehf) layoutParams).f1678wA = true;
                }
                AbstractC2352L8.m9357AZxh();
            }
        }

        /* renamed from: qGY */
        public void m1670qGY(AbstractC0157mByQ abstractC0157mByQ) {
        }

        /* renamed from: qdMbNW */
        public void m1671qdMbNW(RecyclerView recyclerView) {
        }

        /* renamed from: rkYL */
        public void m1672rkYL(AbstractC0157mByQ abstractC0157mByQ) {
        }

        /* renamed from: wA */
        public final AbstractC0157mByQ m1673wA(ViewGroup viewGroup, int i) {
            try {
                AbstractC2352L8.m9358mjFkc("RV CreateView");
                AbstractC0157mByQ abstractC0157mByQMo1663VA = mo1663VA(viewGroup, i);
                if (abstractC0157mByQMo1663VA.f1700mjFkc.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                abstractC0157mByQMo1663VA.f1691JHa = i;
                return abstractC0157mByQMo1663VA;
            } finally {
                AbstractC2352L8.m9357AZxh();
            }
        }

        /* renamed from: xJ */
        public final boolean m1674xJ() {
            return this.f1680mjFkc.m1823mjFkc();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$mByQ */
    public static abstract class AbstractC0157mByQ {

        /* renamed from: diqgf */
        public static final List f1686diqgf = Collections.emptyList();

        /* renamed from: AZxh */
        public WeakReference f1687AZxh;

        /* renamed from: Dt */
        public int f1688Dt;

        /* renamed from: IEE */
        public RecyclerView f1690IEE;

        /* renamed from: Pq */
        public AbstractC0156lgHUyS f1694Pq;

        /* renamed from: mjFkc */
        public final View f1700mjFkc;

        /* renamed from: wA */
        public int f1704wA = -1;

        /* renamed from: ZfxDd */
        public int f1697ZfxDd = -1;

        /* renamed from: KLFTb */
        public long f1692KLFTb = -1;

        /* renamed from: JHa */
        public int f1691JHa = -1;

        /* renamed from: xJ */
        public int f1705xJ = -1;

        /* renamed from: lgHUyS */
        public AbstractC0157mByQ f1699lgHUyS = null;

        /* renamed from: qdMbNW */
        public AbstractC0157mByQ f1702qdMbNW = null;

        /* renamed from: ETF */
        public List f1689ETF = null;

        /* renamed from: VA */
        public List f1695VA = null;

        /* renamed from: MiMN */
        public int f1693MiMN = 0;

        /* renamed from: YoKzxo */
        public C0146Ucbh f1696YoKzxo = null;

        /* renamed from: rkYL */
        public boolean f1703rkYL = false;

        /* renamed from: qGY */
        public int f1701qGY = 0;

        /* renamed from: fehf */
        public int f1698fehf = -1;

        public AbstractC0157mByQ(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1700mjFkc = view;
        }

        /* renamed from: AZxh */
        public void m1677AZxh(int i) {
            this.f1688Dt = i | this.f1688Dt;
        }

        /* renamed from: BAnRFn */
        public void m1678BAnRFn(RecyclerView recyclerView) {
            int i = this.f1698fehf;
            if (i != -1) {
                this.f1701qGY = i;
            } else {
                this.f1701qGY = AbstractC2876T9.m10271eyqo(this.f1700mjFkc);
            }
            recyclerView.m1471Vu(this, 4);
        }

        /* renamed from: CqaNbM */
        public void m1679CqaNbM(C0146Ucbh c0146Ucbh, boolean z) {
            this.f1696YoKzxo = c0146Ucbh;
            this.f1703rkYL = z;
        }

        /* renamed from: Dt */
        public final int m1680Dt() {
            RecyclerView recyclerView = this.f1690IEE;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.m1466Vdz(this);
        }

        /* renamed from: ETF */
        public final long m1681ETF() {
            return this.f1692KLFTb;
        }

        /* renamed from: Gd */
        public boolean m1682Gd() {
            return (this.f1688Dt & 256) != 0;
        }

        /* renamed from: HGpJ */
        public boolean m1683HGpJ() {
            return (this.f1688Dt & 2) != 0;
        }

        /* renamed from: IEE */
        public boolean m1684IEE() {
            return (this.f1700mjFkc.getParent() == null || this.f1700mjFkc.getParent() == this.f1690IEE) ? false : true;
        }

        /* renamed from: JHa */
        public void m1685JHa() {
            this.f1688Dt &= -257;
        }

        /* renamed from: KLFTb */
        public void m1686KLFTb() {
            this.f1688Dt &= -33;
        }

        /* renamed from: KLMXS */
        public boolean m1687KLMXS() {
            return (this.f1688Dt & 128) != 0;
        }

        /* renamed from: MiMN */
        public final int m1688MiMN() {
            int i = this.f1705xJ;
            return i == -1 ? this.f1704wA : i;
        }

        /* renamed from: Ne */
        public final void m1689Ne(boolean z) {
            int i = this.f1693MiMN;
            int i2 = z ? i - 1 : i + 1;
            this.f1693MiMN = i2;
            if (i2 < 0) {
                this.f1693MiMN = 0;
                if (RecyclerView.f1542gYa) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.f1688Dt |= 16;
            } else if (z && i2 == 0) {
                this.f1688Dt &= -17;
            }
            if (RecyclerView.f1536LREOK) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
            }
        }

        /* renamed from: OjSQV */
        public void m1690OjSQV(int i, int i2) {
            this.f1688Dt = (i & i2) | (this.f1688Dt & (~i2));
        }

        /* renamed from: Pq */
        public boolean m1691Pq() {
            return (this.f1688Dt & 1) != 0;
        }

        /* renamed from: Ucbh */
        public boolean m1692Ucbh() {
            return (this.f1688Dt & 8) != 0;
        }

        /* renamed from: VA */
        public final int m1693VA() {
            return this.f1691JHa;
        }

        /* renamed from: VocHEe */
        public void m1694VocHEe(int i, boolean z) {
            if (this.f1697ZfxDd == -1) {
                this.f1697ZfxDd = this.f1704wA;
            }
            if (this.f1705xJ == -1) {
                this.f1705xJ = this.f1704wA;
            }
            if (z) {
                this.f1705xJ += i;
            }
            this.f1704wA += i;
            if (this.f1700mjFkc.getLayoutParams() != null) {
                ((C0153fehf) this.f1700mjFkc.getLayoutParams()).f1678wA = true;
            }
        }

        /* renamed from: YoKzxo */
        public final int m1695YoKzxo() {
            return this.f1697ZfxDd;
        }

        /* renamed from: ZfxDd */
        public void m1696ZfxDd() {
            List list = this.f1689ETF;
            if (list != null) {
                list.clear();
            }
            this.f1688Dt &= -1025;
        }

        /* renamed from: cMLeY */
        public boolean m1697cMLeY() {
            return (this.f1688Dt & 32) != 0;
        }

        /* renamed from: diqgf */
        public boolean m1698diqgf() {
            return (this.f1688Dt & 4) != 0;
        }

        /* renamed from: eyqo */
        public final boolean m1699eyqo() {
            return (this.f1688Dt & 16) == 0 && !AbstractC2876T9.m10239KLMXS(this.f1700mjFkc);
        }

        /* renamed from: fehf */
        public boolean m1700fehf() {
            return (this.f1688Dt & 512) != 0 || m1698diqgf();
        }

        /* renamed from: huTpC */
        public boolean m1701huTpC() {
            return this.f1696YoKzxo != null;
        }

        /* renamed from: lB */
        public void m1702lB(RecyclerView recyclerView) {
            recyclerView.m1471Vu(this, this.f1701qGY);
            this.f1701qGY = 0;
        }

        /* renamed from: lgHUyS */
        public boolean m1703lgHUyS() {
            return (this.f1688Dt & 16) == 0 && AbstractC2876T9.m10239KLMXS(this.f1700mjFkc);
        }

        /* renamed from: mByQ */
        public void m1704mByQ() {
            if (this.f1697ZfxDd == -1) {
                this.f1697ZfxDd = this.f1704wA;
            }
        }

        /* renamed from: mjFkc */
        public void m1705mjFkc(Object obj) {
            if (obj == null) {
                m1677AZxh(1024);
            } else if ((1024 & this.f1688Dt) == 0) {
                m1712xJ();
                this.f1689ETF.add(obj);
            }
        }

        /* renamed from: qGY */
        public boolean m1706qGY(int i) {
            return (this.f1688Dt & i) != 0;
        }

        /* renamed from: qdMbNW */
        public void m1707qdMbNW(int i, int i2, boolean z) {
            m1677AZxh(8);
            m1694VocHEe(i2, z);
            this.f1704wA = i;
        }

        /* renamed from: rkYL */
        public List m1708rkYL() {
            if ((this.f1688Dt & 1024) != 0) {
                return f1686diqgf;
            }
            List list = this.f1689ETF;
            return (list == null || list.size() == 0) ? f1686diqgf : this.f1695VA;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1704wA + " id=" + this.f1692KLFTb + ", oldPos=" + this.f1697ZfxDd + ", pLpos:" + this.f1705xJ);
            if (m1701huTpC()) {
                sb.append(" scrap ");
                sb.append(this.f1703rkYL ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m1698diqgf()) {
                sb.append(" invalid");
            }
            if (!m1691Pq()) {
                sb.append(" unbound");
            }
            if (m1709vI()) {
                sb.append(" update");
            }
            if (m1692Ucbh()) {
                sb.append(" removed");
            }
            if (m1687KLMXS()) {
                sb.append(" ignored");
            }
            if (m1682Gd()) {
                sb.append(" tmpDetached");
            }
            if (!m1699eyqo()) {
                sb.append(" not recyclable(" + this.f1693MiMN + ")");
            }
            if (m1700fehf()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1700mjFkc.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* renamed from: vI */
        public boolean m1709vI() {
            return (this.f1688Dt & 2) != 0;
        }

        /* renamed from: wA */
        public void m1710wA() {
            this.f1697ZfxDd = -1;
            this.f1705xJ = -1;
        }

        /* renamed from: wJVbdd */
        public void m1711wJVbdd() {
            if (RecyclerView.f1542gYa && m1682Gd()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.f1688Dt = 0;
            this.f1704wA = -1;
            this.f1697ZfxDd = -1;
            this.f1692KLFTb = -1L;
            this.f1705xJ = -1;
            this.f1693MiMN = 0;
            this.f1699lgHUyS = null;
            this.f1702qdMbNW = null;
            m1696ZfxDd();
            this.f1701qGY = 0;
            this.f1698fehf = -1;
            RecyclerView.m1410Pq(this);
        }

        /* renamed from: xJ */
        public final void m1712xJ() {
            if (this.f1689ETF == null) {
                ArrayList arrayList = new ArrayList();
                this.f1689ETF = arrayList;
                this.f1695VA = Collections.unmodifiableList(arrayList);
            }
        }

        /* renamed from: xrEuO */
        public boolean m1713xrEuO() {
            return (this.f1688Dt & 16) != 0;
        }

        /* renamed from: zvd */
        public void m1714zvd() {
            this.f1696YoKzxo.m1592NPj(this);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$mjFkc */
    public class RunnableC0158mjFkc implements Runnable {
        public RunnableC0158mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f1579Ucbh || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f1574Pq) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f1557HGpJ) {
                recyclerView2.f1556Gd = true;
            } else {
                recyclerView2.m1432HGpJ();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$qGY */
    public static abstract class AbstractC0159qGY {

        /* renamed from: AZxh */
        public RecyclerView f1707AZxh;

        /* renamed from: Dt */
        public boolean f1708Dt;

        /* renamed from: ETF */
        public boolean f1709ETF;

        /* renamed from: IEE */
        public int f1710IEE;

        /* renamed from: JHa */
        public C0179rkYL f1711JHa;

        /* renamed from: KLFTb */
        public C0179rkYL f1712KLFTb;

        /* renamed from: MiMN */
        public int f1713MiMN;

        /* renamed from: VA */
        public boolean f1714VA;

        /* renamed from: YoKzxo */
        public boolean f1715YoKzxo;

        /* renamed from: ZfxDd */
        public final C0179rkYL.AZxh f1716ZfxDd;

        /* renamed from: fehf */
        public int f1717fehf;

        /* renamed from: lgHUyS */
        public boolean f1718lgHUyS;

        /* renamed from: mjFkc */
        public C0122AZxh f1719mjFkc;

        /* renamed from: qGY */
        public int f1720qGY;

        /* renamed from: qdMbNW */
        public boolean f1721qdMbNW;

        /* renamed from: rkYL */
        public int f1722rkYL;

        /* renamed from: wA */
        public final C0179rkYL.AZxh f1723wA;

        /* renamed from: xJ */
        public AbstractC0162vI f1724xJ;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$qGY$AZxh */
        public class AZxh implements C0179rkYL.AZxh {
            public AZxh() {
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: AZxh */
            public int mo1818AZxh() {
                return AbstractC0159qGY.this.m1737JYgkl() - AbstractC0159qGY.this.m1735JBhc();
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: KLFTb */
            public int mo1819KLFTb(View view) {
                return AbstractC0159qGY.this.m1808vadzgd(view) + ((ViewGroup.MarginLayoutParams) ((C0153fehf) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: ZfxDd */
            public int mo1820ZfxDd() {
                return AbstractC0159qGY.this.m1777dm();
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: mjFkc */
            public View mo1821mjFkc(int i) {
                return AbstractC0159qGY.this.m1743KLMXS(i);
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: wA */
            public int mo1822wA(View view) {
                return AbstractC0159qGY.this.m1803uHVRx(view) - ((ViewGroup.MarginLayoutParams) ((C0153fehf) view.getLayoutParams())).topMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$qGY$ZfxDd */
        public static class ZfxDd {

            /* renamed from: AZxh */
            public int f1726AZxh;

            /* renamed from: ZfxDd */
            public boolean f1727ZfxDd;

            /* renamed from: mjFkc */
            public int f1728mjFkc;

            /* renamed from: wA */
            public boolean f1729wA;
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$qGY$mjFkc */
        public class mjFkc implements C0179rkYL.AZxh {
            public mjFkc() {
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: AZxh */
            public int mo1818AZxh() {
                return AbstractC0159qGY.this.m1755SOS() - AbstractC0159qGY.this.m1719ANMGZc();
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: KLFTb */
            public int mo1819KLFTb(View view) {
                return AbstractC0159qGY.this.m1728GMIER(view) + ((ViewGroup.MarginLayoutParams) ((C0153fehf) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: ZfxDd */
            public int mo1820ZfxDd() {
                return AbstractC0159qGY.this.m1783jm();
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: mjFkc */
            public View mo1821mjFkc(int i) {
                return AbstractC0159qGY.this.m1743KLMXS(i);
            }

            @Override // androidx.recyclerview.p023widget.C0179rkYL.AZxh
            /* renamed from: wA */
            public int mo1822wA(View view) {
                return AbstractC0159qGY.this.m1774aqHPIZ(view) - ((ViewGroup.MarginLayoutParams) ((C0153fehf) view.getLayoutParams())).leftMargin;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$qGY$wA */
        public interface wA {
            /* renamed from: mjFkc */
            void mo1300mjFkc(int i, int i2);
        }

        public AbstractC0159qGY() {
            mjFkc mjfkc = new mjFkc();
            this.f1723wA = mjfkc;
            AZxh aZxh = new AZxh();
            this.f1716ZfxDd = aZxh;
            this.f1712KLFTb = new C0179rkYL(mjfkc);
            this.f1711JHa = new C0179rkYL(aZxh);
            this.f1718lgHUyS = false;
            this.f1721qdMbNW = false;
            this.f1708Dt = false;
            this.f1709ETF = true;
            this.f1714VA = true;
        }

        /* renamed from: LREOK */
        public static boolean m1715LREOK(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* renamed from: cMLeY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int m1716cMLeY(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                        i2 = 0;
                        i4 = 0;
                    } else {
                        i4 = iMax;
                    }
                }
                i2 = 1073741824;
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i4 = iMax;
                        i2 = Integer.MIN_VALUE;
                    } else {
                        i4 = iMax;
                        i2 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        /* renamed from: rkYL */
        public static int m1717rkYL(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        /* renamed from: yfx */
        public static ZfxDd m1718yfx(Context context, AttributeSet attributeSet, int i, int i2) {
            ZfxDd zfxDd = new ZfxDd();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3272Z4.f11966mjFkc, i, i2);
            zfxDd.f1728mjFkc = typedArrayObtainStyledAttributes.getInt(AbstractC3272Z4.f11957AZxh, 1);
            zfxDd.f1726AZxh = typedArrayObtainStyledAttributes.getInt(AbstractC3272Z4.f11963VA, 1);
            zfxDd.f1729wA = typedArrayObtainStyledAttributes.getBoolean(AbstractC3272Z4.f11959ETF, false);
            zfxDd.f1727ZfxDd = typedArrayObtainStyledAttributes.getBoolean(AbstractC3272Z4.f11962MiMN, false);
            typedArrayObtainStyledAttributes.recycle();
            return zfxDd;
        }

        /* renamed from: ANMGZc */
        public int m1719ANMGZc() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* renamed from: APn */
        public boolean m1720APn(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, int i, Bundle bundle) {
            int iM1777dm;
            int iM1783jm;
            int i2;
            int i3;
            if (this.f1707AZxh == null) {
                return false;
            }
            int iM1737JYgkl = m1737JYgkl();
            int iM1755SOS = m1755SOS();
            Rect rect = new Rect();
            if (this.f1707AZxh.getMatrix().isIdentity() && this.f1707AZxh.getGlobalVisibleRect(rect)) {
                iM1737JYgkl = rect.height();
                iM1755SOS = rect.width();
            }
            if (i == 4096) {
                iM1777dm = this.f1707AZxh.canScrollVertically(1) ? (iM1737JYgkl - m1777dm()) - m1735JBhc() : 0;
                if (this.f1707AZxh.canScrollHorizontally(1)) {
                    iM1783jm = (iM1755SOS - m1783jm()) - m1719ANMGZc();
                    i2 = iM1777dm;
                    i3 = iM1783jm;
                }
                i2 = iM1777dm;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                iM1777dm = this.f1707AZxh.canScrollVertically(-1) ? -((iM1737JYgkl - m1777dm()) - m1735JBhc()) : 0;
                if (this.f1707AZxh.canScrollHorizontally(-1)) {
                    iM1783jm = -((iM1755SOS - m1783jm()) - m1719ANMGZc());
                    i2 = iM1777dm;
                    i3 = iM1783jm;
                }
                i2 = iM1777dm;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.f1707AZxh.m1512mzUGzO(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        /* renamed from: BAnRFn */
        public void m1721BAnRFn(RecyclerView recyclerView, C0146Ucbh c0146Ucbh) {
            this.f1721qdMbNW = false;
            mo1337XD(recyclerView, c0146Ucbh);
        }

        /* renamed from: BxruE */
        public abstract int mo1230BxruE(int i, C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe);

        /* renamed from: CTcA */
        public void m1722CTcA(int i) {
            if (m1743KLMXS(i) != null) {
                this.f1719mjFkc.m1177fehf(i);
            }
        }

        /* renamed from: CqaNbM */
        public int m1723CqaNbM() {
            return -1;
        }

        /* renamed from: Dp */
        public void mo1308Dp(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1707AZxh;
            m1779fLidf(recyclerView.f1617wA, recyclerView.f1581Vdz, accessibilityEvent);
        }

        /* renamed from: Dt */
        public void m1724Dt(View view, int i, C0153fehf c0153fehf) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm.m1692Ucbh()) {
                this.f1707AZxh.f1619xJ.m2023AZxh(abstractC0157mByQM1414dm);
            } else {
                this.f1707AZxh.f1619xJ.m2035qGY(abstractC0157mByQM1414dm);
            }
            this.f1719mjFkc.m1183wA(view, i, c0153fehf, abstractC0157mByQM1414dm.m1692Ucbh());
        }

        /* renamed from: ERt */
        public boolean mo1231ERt() {
            return false;
        }

        /* renamed from: ETF */
        public void m1725ETF(View view, Rect rect) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.m1536xROA(view));
            }
        }

        /* renamed from: FOJ */
        public void m1726FOJ() {
            AbstractC0162vI abstractC0162vI = this.f1724xJ;
            if (abstractC0162vI != null) {
                abstractC0162vI.m1833IEE();
            }
        }

        /* renamed from: FbxKQm */
        public void mo1233FbxKQm(RecyclerView recyclerView) {
        }

        /* renamed from: Fztqa */
        public boolean mo1727Fztqa(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrM1795rWxwaT = m1795rWxwaT(view, rect);
            int i = iArrM1795rWxwaT[0];
            int i2 = iArrM1795rWxwaT[1];
            if ((z2 && !m1800tjSezt(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.m1423CTcA(i, i2);
            }
            return true;
        }

        /* renamed from: GMIER */
        public int m1728GMIER(View view) {
            return view.getRight() + m1809vjlshU(view);
        }

        /* renamed from: Gd */
        public void m1729Gd(C0146Ucbh c0146Ucbh) {
            for (int iM1817zvd = m1817zvd() - 1; iM1817zvd >= 0; iM1817zvd--) {
                m1731Htq(c0146Ucbh, iM1817zvd, m1743KLMXS(iM1817zvd));
            }
        }

        /* renamed from: HGpJ */
        public void m1730HGpJ(int i) {
            m1806vI(i, m1743KLMXS(i));
        }

        /* renamed from: Htq */
        public final void m1731Htq(C0146Ucbh c0146Ucbh, int i, View view) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm.m1687KLMXS()) {
                if (RecyclerView.f1536LREOK) {
                    Log.d("RecyclerView", "ignoring view " + abstractC0157mByQM1414dm);
                    return;
                }
                return;
            }
            if (abstractC0157mByQM1414dm.m1698diqgf() && !abstractC0157mByQM1414dm.m1692Ucbh() && !this.f1707AZxh.f1568MiMN.m1668lgHUyS()) {
                m1722CTcA(i);
                c0146Ucbh.m1582CqaNbM(abstractC0157mByQM1414dm);
            } else {
                m1730HGpJ(i);
                c0146Ucbh.m1622xrEuO(view);
                this.f1707AZxh.f1619xJ.m2025ETF(abstractC0157mByQM1414dm);
            }
        }

        /* renamed from: IEE */
        public abstract int mo1315IEE(C0148VocHEe c0148VocHEe);

        /* renamed from: IVlxe */
        public int m1732IVlxe(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return 0;
        }

        /* renamed from: IvRQOa */
        public boolean m1733IvRQOa(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f1707AZxh;
            return m1720APn(recyclerView.f1617wA, recyclerView.f1581Vdz, i, bundle);
        }

        /* renamed from: IyS */
        public void m1734IyS(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: JBhc */
        public int m1735JBhc() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        /* renamed from: JHa */
        public void m1736JHa(View view, int i) {
            m1812xJ(view, i, false);
        }

        /* renamed from: JYgkl */
        public int m1737JYgkl() {
            return this.f1710IEE;
        }

        /* renamed from: JYn */
        public View m1738JYn() {
            View focusedChild;
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1719mjFkc.m1174YoKzxo(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* renamed from: Jidt */
        public void m1739Jidt(AbstractC0162vI abstractC0162vI) {
            if (this.f1724xJ == abstractC0162vI) {
                this.f1724xJ = null;
            }
        }

        /* renamed from: Jk */
        public boolean m1740Jk(RecyclerView recyclerView, View view, View view2) {
            return m1778fFz() || recyclerView.m1495gYa();
        }

        /* renamed from: JrJO */
        public int m1741JrJO() {
            return this.f1720qGY;
        }

        /* renamed from: KLFTb */
        public void m1742KLFTb(View view) {
            m1736JHa(view, -1);
        }

        /* renamed from: KLMXS */
        public View m1743KLMXS(int i) {
            C0122AZxh c0122AZxh = this.f1719mjFkc;
            if (c0122AZxh != null) {
                return c0122AZxh.m1169JHa(i);
            }
            return null;
        }

        /* renamed from: KRTLGT */
        public int m1744KRTLGT(View view) {
            Rect rect = ((C0153fehf) view.getLayoutParams()).f1675AZxh;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* renamed from: KRckQg */
        public boolean m1745KRckQg(RecyclerView recyclerView, C0148VocHEe c0148VocHEe, View view, View view2) {
            return m1740Jk(recyclerView, view, view2);
        }

        /* renamed from: LeWm */
        public boolean m1746LeWm(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return mo1727Fztqa(recyclerView, view, rect, z, false);
        }

        /* renamed from: LsBneK */
        public void m1747LsBneK(RecyclerView recyclerView) {
            m1789nUaNy(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* renamed from: MiMN */
        public boolean mo1322MiMN() {
            return false;
        }

        /* renamed from: Moer */
        public int m1748Moer(View view) {
            return ((C0153fehf) view.getLayoutParams()).f1675AZxh.top;
        }

        /* renamed from: NKyg */
        public boolean m1749NKyg() {
            int iM1817zvd = m1817zvd();
            for (int i = 0; i < iM1817zvd; i++) {
                ViewGroup.LayoutParams layoutParams = m1743KLMXS(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: NPj */
        public int mo1237NPj(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return -1;
        }

        /* renamed from: NV */
        public void mo1750NV(int i) {
        }

        /* renamed from: Ne */
        public C0153fehf mo1238Ne(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof C0153fehf ? new C0153fehf((C0153fehf) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0153fehf((ViewGroup.MarginLayoutParams) layoutParams) : new C0153fehf(layoutParams);
        }

        /* renamed from: OjSQV */
        public C0153fehf mo1239OjSQV(Context context, AttributeSet attributeSet) {
            return new C0153fehf(context, attributeSet);
        }

        /* renamed from: Pq */
        public abstract int mo1240Pq(C0148VocHEe c0148VocHEe);

        /* renamed from: Qr */
        public int m1751Qr() {
            return this.f1722rkYL;
        }

        /* renamed from: QyqF */
        public int mo1241QyqF(int i, C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return 0;
        }

        /* renamed from: RWyiuY */
        public void m1752RWyiuY(View view, C0146Ucbh c0146Ucbh) {
            m1792oVXlhB(view);
            c0146Ucbh.m1593Ne(view);
        }

        /* renamed from: Rc */
        public void m1753Rc(C2971Ucbh c2971Ucbh) {
            RecyclerView recyclerView = this.f1707AZxh;
            mo1257hvGY(recyclerView.f1617wA, recyclerView.f1581Vdz, c2971Ucbh);
        }

        /* renamed from: SKTn */
        public void m1754SKTn(View view, C2971Ucbh c2971Ucbh) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (abstractC0157mByQM1414dm == null || abstractC0157mByQM1414dm.m1692Ucbh() || this.f1719mjFkc.m1174YoKzxo(abstractC0157mByQM1414dm.f1700mjFkc)) {
                return;
            }
            RecyclerView recyclerView = this.f1707AZxh;
            mo1266rdJr(recyclerView.f1617wA, recyclerView.f1581Vdz, view, c2971Ucbh);
        }

        /* renamed from: SOS */
        public int m1755SOS() {
            return this.f1717fehf;
        }

        /* renamed from: SmIWf */
        public void m1756SmIWf(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C0153fehf) view.getLayoutParams()).f1675AZxh;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1707AZxh != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f1707AZxh.f1580VA;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* renamed from: SwgkN */
        public int m1757SwgkN() {
            return AbstractC2876T9.m10230HGpJ(this.f1707AZxh);
        }

        /* renamed from: Tw */
        public abstract void mo1331Tw(int i);

        /* renamed from: Ucbh */
        public int mo1243Ucbh(C0148VocHEe c0148VocHEe) {
            return 0;
        }

        /* renamed from: VA */
        public abstract boolean mo1335VA();

        /* renamed from: Vdz */
        public int m1758Vdz() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return AbstractC2876T9.m10257VocHEe(recyclerView);
            }
            return 0;
        }

        /* renamed from: VfB */
        public void m1759VfB() {
            this.f1718lgHUyS = true;
        }

        /* renamed from: Vgyli */
        public void mo1760Vgyli(AbstractC0156lgHUyS abstractC0156lgHUyS, AbstractC0156lgHUyS abstractC0156lgHUyS2) {
        }

        /* renamed from: Vnb */
        public boolean m1761Vnb() {
            RecyclerView recyclerView = this.f1707AZxh;
            return recyclerView != null && recyclerView.f1602lgHUyS;
        }

        /* renamed from: VocHEe */
        public void m1762VocHEe(RecyclerView recyclerView) {
            this.f1721qdMbNW = true;
            m1781giT(recyclerView);
        }

        /* renamed from: Vu */
        public void m1763Vu(int i, C0146Ucbh c0146Ucbh) {
            View viewM1743KLMXS = m1743KLMXS(i);
            m1722CTcA(i);
            c0146Ucbh.m1593Ne(viewM1743KLMXS);
        }

        /* renamed from: WGXroI */
        public int m1764WGXroI() {
            return AbstractC2876T9.m10276huTpC(this.f1707AZxh);
        }

        /* renamed from: WrLQs */
        public int m1765WrLQs(View view) {
            Rect rect = ((C0153fehf) view.getLayoutParams()).f1675AZxh;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* renamed from: XD */
        public void mo1337XD(RecyclerView recyclerView, C0146Ucbh c0146Ucbh) {
            m1796sRqPfw(recyclerView);
        }

        /* renamed from: XDdeP */
        public View m1766XDdeP(View view, int i) {
            return null;
        }

        /* renamed from: XFUzSY */
        public void m1767XFUzSY(View view, int i, int i2, int i3, int i4) {
            C0153fehf c0153fehf = (C0153fehf) view.getLayoutParams();
            Rect rect = c0153fehf.f1675AZxh;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin);
        }

        /* renamed from: XV */
        public int m1768XV(View view) {
            return ((C0153fehf) view.getLayoutParams()).f1675AZxh.left;
        }

        /* renamed from: XbiWeM */
        public boolean m1769XbiWeM(View view, boolean z, boolean z2) {
            boolean z3 = this.f1712KLFTb.m2062AZxh(view, 24579) && this.f1711JHa.m2062AZxh(view, 24579);
            return z ? z3 : !z3;
        }

        /* renamed from: XgAT */
        public void mo1244XgAT(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: XtE */
        public void mo1770XtE(View view, int i, int i2) {
            C0153fehf c0153fehf = (C0153fehf) view.getLayoutParams();
            Rect rectM1536xROA = this.f1707AZxh.m1536xROA(view);
            int i3 = i + rectM1536xROA.left + rectM1536xROA.right;
            int i4 = i2 + rectM1536xROA.top + rectM1536xROA.bottom;
            int iM1716cMLeY = m1716cMLeY(m1755SOS(), m1751Qr(), m1783jm() + m1719ANMGZc() + ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin + i3, ((ViewGroup.MarginLayoutParams) c0153fehf).width, mo1335VA());
            int iM1716cMLeY2 = m1716cMLeY(m1737JYgkl(), m1741JrJO(), m1777dm() + m1735JBhc() + ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) c0153fehf).height, mo1322MiMN());
            if (m1814yP(view, iM1716cMLeY, iM1716cMLeY2, c0153fehf)) {
                view.measure(iM1716cMLeY, iM1716cMLeY2);
            }
        }

        /* renamed from: Xxz */
        public void mo1245Xxz(C0148VocHEe c0148VocHEe) {
        }

        /* renamed from: YoKzxo */
        public boolean mo1246YoKzxo(C0153fehf c0153fehf) {
            return c0153fehf != null;
        }

        /* renamed from: Zdbk */
        public void m1771Zdbk(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, int i, int i2) {
            this.f1707AZxh.m1470VocHEe(i, i2);
        }

        /* renamed from: ZfxDd */
        public void m1772ZfxDd(View view, int i) {
            m1812xJ(view, i, true);
        }

        /* renamed from: alEkx */
        public int m1773alEkx() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return AbstractC2876T9.m10224BAnRFn(recyclerView);
            }
            return 0;
        }

        /* renamed from: aqHPIZ */
        public int m1774aqHPIZ(View view) {
            return view.getLeft() - m1768XV(view);
        }

        /* renamed from: bbzow */
        public int m1775bbzow() {
            return AbstractC2876T9.m10229Gd(this.f1707AZxh);
        }

        /* renamed from: bc */
        public void m1776bc(int i, int i2) {
            int iM1817zvd = m1817zvd();
            if (iM1817zvd == 0) {
                this.f1707AZxh.m1470VocHEe(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iM1817zvd; i7++) {
                View viewM1743KLMXS = m1743KLMXS(i7);
                Rect rect = this.f1707AZxh.f1553Dt;
                mo1791oCFDzJ(viewM1743KLMXS, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.f1707AZxh.f1553Dt.set(i6, i4, i3, i5);
            mo1271xCVa(this.f1707AZxh.f1553Dt, i, i2);
        }

        /* renamed from: dGDT */
        public abstract void mo1248dGDT(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe);

        /* renamed from: diqgf */
        public abstract int mo1249diqgf(C0148VocHEe c0148VocHEe);

        /* renamed from: dkKKW */
        public Parcelable mo1343dkKKW() {
            return null;
        }

        /* renamed from: dm */
        public int m1777dm() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* renamed from: eQ */
        public void mo1252eQ(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: eyqo */
        public int mo1344eyqo(C0148VocHEe c0148VocHEe) {
            return 0;
        }

        /* renamed from: fFz */
        public boolean m1778fFz() {
            AbstractC0162vI abstractC0162vI = this.f1724xJ;
            return abstractC0162vI != null && abstractC0162vI.m1841lgHUyS();
        }

        /* renamed from: fLidf */
        public void m1779fLidf(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1707AZxh.canScrollVertically(-1) && !this.f1707AZxh.canScrollHorizontally(-1) && !this.f1707AZxh.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1707AZxh.f1568MiMN;
            if (abstractC0156lgHUyS != null) {
                accessibilityEvent.setItemCount(abstractC0156lgHUyS.mo1665ZfxDd());
            }
        }

        /* renamed from: fehf */
        public void mo1345fehf(int i, wA wAVar) {
        }

        /* renamed from: gYa */
        public boolean m1780gYa(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return false;
        }

        /* renamed from: giT */
        public void m1781giT(RecyclerView recyclerView) {
        }

        /* renamed from: gtIJp */
        public boolean m1782gtIJp() {
            return this.f1721qdMbNW;
        }

        /* renamed from: gtr */
        public View mo1255gtr(View view, int i, C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return null;
        }

        /* renamed from: huTpC */
        public int mo1256huTpC(C0148VocHEe c0148VocHEe) {
            return 0;
        }

        /* renamed from: hvGY */
        public void mo1257hvGY(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, C2971Ucbh c2971Ucbh) {
            if (this.f1707AZxh.canScrollVertically(-1) || this.f1707AZxh.canScrollHorizontally(-1)) {
                c2971Ucbh.m10588mjFkc(8192);
                c2971Ucbh.m10584kism(true);
            }
            if (this.f1707AZxh.canScrollVertically(1) || this.f1707AZxh.canScrollHorizontally(1)) {
                c2971Ucbh.m10588mjFkc(4096);
                c2971Ucbh.m10584kism(true);
            }
            c2971Ucbh.m10540JBhc(C2971Ucbh.KLFTb.m10611mjFkc(mo1272xROA(c0146Ucbh, c0148VocHEe), mo1237NPj(c0146Ucbh, c0148VocHEe), m1780gYa(c0146Ucbh, c0148VocHEe), m1732IVlxe(c0146Ucbh, c0148VocHEe)));
        }

        /* renamed from: jm */
        public int m1783jm() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        /* renamed from: jtz */
        public void mo1260jtz(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: jx */
        public void m1784jx(int i, int i2) {
            View viewM1743KLMXS = m1743KLMXS(i);
            if (viewM1743KLMXS != null) {
                m1730HGpJ(i);
                m1794qdMbNW(viewM1743KLMXS, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f1707AZxh.toString());
            }
        }

        /* renamed from: kism */
        public boolean mo1350kism() {
            return this.f1708Dt;
        }

        /* renamed from: knzZ */
        public boolean m1785knzZ(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f1707AZxh;
            return m1816ybBTr(recyclerView.f1617wA, recyclerView.f1581Vdz, view, i, bundle);
        }

        /* renamed from: lB */
        public View m1786lB(View view) {
            View viewM1528uHVRx;
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView == null || (viewM1528uHVRx = recyclerView.m1528uHVRx(view)) == null || this.f1719mjFkc.m1174YoKzxo(viewM1528uHVRx)) {
                return null;
            }
            return viewM1528uHVRx;
        }

        /* renamed from: lgHUyS */
        public void mo1351lgHUyS(String str) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                recyclerView.m1517qGY(str);
            }
        }

        /* renamed from: lti */
        public boolean m1787lti(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: mByQ */
        public abstract C0153fehf mo1263mByQ();

        /* renamed from: mPWV */
        public void mo1352mPWV(Parcelable parcelable) {
        }

        /* renamed from: mzUGzO */
        public void m1788mzUGzO() {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        /* renamed from: nUaNy */
        public void m1789nUaNy(int i, int i2) {
            this.f1717fehf = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.f1722rkYL = mode;
            if (mode == 0 && !RecyclerView.f1540XtE) {
                this.f1717fehf = 0;
            }
            this.f1710IEE = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f1720qGY = mode2;
            if (mode2 != 0 || RecyclerView.f1540XtE) {
                return;
            }
            this.f1710IEE = 0;
        }

        /* renamed from: nxI */
        public int m1790nxI() {
            RecyclerView recyclerView = this.f1707AZxh;
            AbstractC0156lgHUyS adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.mo1665ZfxDd();
            }
            return 0;
        }

        /* renamed from: oCFDzJ */
        public void mo1791oCFDzJ(View view, Rect rect) {
            RecyclerView.m1416tQ(view, rect);
        }

        /* renamed from: oVXlhB */
        public void m1792oVXlhB(View view) {
            this.f1719mjFkc.m1180qGY(view);
        }

        /* renamed from: oaI */
        public void m1793oaI(C0146Ucbh c0146Ucbh) {
            int iM1583Dt = c0146Ucbh.m1583Dt();
            for (int i = iM1583Dt - 1; i >= 0; i--) {
                View viewM1600YoKzxo = c0146Ucbh.m1600YoKzxo(i);
                AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(viewM1600YoKzxo);
                if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                    abstractC0157mByQM1414dm.m1689Ne(false);
                    if (abstractC0157mByQM1414dm.m1682Gd()) {
                        this.f1707AZxh.removeDetachedView(viewM1600YoKzxo, false);
                    }
                    AbstractC0144MiMN abstractC0144MiMN = this.f1707AZxh.f1582Vnb;
                    if (abstractC0144MiMN != null) {
                        abstractC0144MiMN.mo1558Dt(abstractC0157mByQM1414dm);
                    }
                    abstractC0157mByQM1414dm.m1689Ne(true);
                    c0146Ucbh.m1620wJVbdd(viewM1600YoKzxo);
                }
            }
            c0146Ucbh.m1589KLFTb();
            if (iM1583Dt > 0) {
                this.f1707AZxh.invalidate();
            }
        }

        /* renamed from: qGY */
        public void mo1356qGY(int i, int i2, C0148VocHEe c0148VocHEe, wA wAVar) {
        }

        /* renamed from: qGgY */
        public abstract void mo1357qGgY(RecyclerView recyclerView, C0148VocHEe c0148VocHEe, int i);

        /* renamed from: qdMbNW */
        public void m1794qdMbNW(View view, int i) {
            m1724Dt(view, i, (C0153fehf) view.getLayoutParams());
        }

        /* renamed from: rWxwaT */
        public final int[] m1795rWxwaT(View view, Rect rect) {
            int iM1783jm = m1783jm();
            int iM1777dm = m1777dm();
            int iM1755SOS = m1755SOS() - m1719ANMGZc();
            int iM1737JYgkl = m1737JYgkl() - m1735JBhc();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iM1783jm;
            int iMin = Math.min(0, i);
            int i2 = top - iM1777dm;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iM1755SOS;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iM1737JYgkl);
            if (m1764WGXroI() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        /* renamed from: rdJr */
        public void mo1266rdJr(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, View view, C2971Ucbh c2971Ucbh) {
        }

        /* renamed from: sRqPfw */
        public void m1796sRqPfw(RecyclerView recyclerView) {
        }

        /* renamed from: sqndV */
        public void m1797sqndV(C0146Ucbh c0146Ucbh) {
            for (int iM1817zvd = m1817zvd() - 1; iM1817zvd >= 0; iM1817zvd--) {
                if (!RecyclerView.m1414dm(m1743KLMXS(iM1817zvd)).m1687KLMXS()) {
                    m1763Vu(iM1817zvd, c0146Ucbh);
                }
            }
        }

        /* renamed from: tAfC */
        public void mo1268tAfC(RecyclerView recyclerView, int i, int i2, Object obj) {
            m1734IyS(recyclerView, i, i2);
        }

        /* renamed from: tISON */
        public void mo1798tISON(int i) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                recyclerView.m1527uH(i);
            }
        }

        /* renamed from: tQ */
        public int m1799tQ(View view) {
            return ((C0153fehf) view.getLayoutParams()).m1653mjFkc();
        }

        /* renamed from: tjSezt */
        public final boolean m1800tjSezt(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iM1783jm = m1783jm();
            int iM1777dm = m1777dm();
            int iM1755SOS = m1755SOS() - m1719ANMGZc();
            int iM1737JYgkl = m1737JYgkl() - m1735JBhc();
            Rect rect = this.f1707AZxh.f1553Dt;
            mo1791oCFDzJ(focusedChild, rect);
            return rect.left - i < iM1755SOS && rect.right - i > iM1783jm && rect.top - i2 < iM1737JYgkl && rect.bottom - i2 > iM1777dm;
        }

        /* renamed from: tpGcn */
        public boolean m1801tpGcn(View view, int i, int i2, C0153fehf c0153fehf) {
            return (this.f1709ETF && m1715LREOK(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) c0153fehf).width) && m1715LREOK(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) c0153fehf).height)) ? false : true;
        }

        /* renamed from: uH */
        public void mo1802uH(int i) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                recyclerView.m1503jx(i);
            }
        }

        /* renamed from: uHVRx */
        public int m1803uHVRx(View view) {
            return view.getTop() - m1748Moer(view);
        }

        /* renamed from: ub */
        public void m1804ub(int i, int i2) {
            this.f1707AZxh.setMeasuredDimension(i, i2);
        }

        /* renamed from: ui */
        public boolean mo1360ui() {
            return false;
        }

        /* renamed from: uxlM */
        public boolean m1805uxlM(Runnable runnable) {
            RecyclerView recyclerView = this.f1707AZxh;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* renamed from: vI */
        public final void m1806vI(int i, View view) {
            this.f1719mjFkc.m1175ZfxDd(i);
        }

        /* renamed from: vUsV */
        public void m1807vUsV(AbstractC0162vI abstractC0162vI) {
            AbstractC0162vI abstractC0162vI2 = this.f1724xJ;
            if (abstractC0162vI2 != null && abstractC0162vI != abstractC0162vI2 && abstractC0162vI2.m1841lgHUyS()) {
                this.f1724xJ.m1833IEE();
            }
            this.f1724xJ = abstractC0162vI;
            abstractC0162vI.m1840fehf(this.f1707AZxh, this);
        }

        /* renamed from: vadzgd */
        public int m1808vadzgd(View view) {
            return view.getBottom() + m1813xrEuO(view);
        }

        /* renamed from: vjlshU */
        public int m1809vjlshU(View view) {
            return ((C0153fehf) view.getLayoutParams()).f1675AZxh.right;
        }

        /* renamed from: wA */
        public void m1810wA(View view) {
            m1772ZfxDd(view, -1);
        }

        /* renamed from: wJVbdd */
        public View mo1362wJVbdd(int i) {
            int iM1817zvd = m1817zvd();
            for (int i2 = 0; i2 < iM1817zvd; i2++) {
                View viewM1743KLMXS = m1743KLMXS(i2);
                AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(viewM1743KLMXS);
                if (abstractC0157mByQM1414dm != null && abstractC0157mByQM1414dm.m1688MiMN() == i && !abstractC0157mByQM1414dm.m1687KLMXS() && (this.f1707AZxh.f1581Vdz.m1626KLFTb() || !abstractC0157mByQM1414dm.m1692Ucbh())) {
                    return viewM1743KLMXS;
                }
            }
            return null;
        }

        /* renamed from: wLtdyQ */
        public void m1811wLtdyQ(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1707AZxh = null;
                this.f1719mjFkc = null;
                this.f1717fehf = 0;
                this.f1710IEE = 0;
            } else {
                this.f1707AZxh = recyclerView;
                this.f1719mjFkc = recyclerView.f1561JHa;
                this.f1717fehf = recyclerView.getWidth();
                this.f1710IEE = recyclerView.getHeight();
            }
            this.f1722rkYL = 1073741824;
            this.f1720qGY = 1073741824;
        }

        /* renamed from: xCVa */
        public void mo1271xCVa(Rect rect, int i, int i2) {
            m1804ub(m1717rkYL(i, rect.width() + m1783jm() + m1719ANMGZc(), m1757SwgkN()), m1717rkYL(i2, rect.height() + m1777dm() + m1735JBhc(), m1775bbzow()));
        }

        /* renamed from: xJ */
        public final void m1812xJ(View view, int i, boolean z) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = RecyclerView.m1414dm(view);
            if (z || abstractC0157mByQM1414dm.m1692Ucbh()) {
                this.f1707AZxh.f1619xJ.m2023AZxh(abstractC0157mByQM1414dm);
            } else {
                this.f1707AZxh.f1619xJ.m2035qGY(abstractC0157mByQM1414dm);
            }
            C0153fehf c0153fehf = (C0153fehf) view.getLayoutParams();
            if (abstractC0157mByQM1414dm.m1697cMLeY() || abstractC0157mByQM1414dm.m1701huTpC()) {
                if (abstractC0157mByQM1414dm.m1701huTpC()) {
                    abstractC0157mByQM1414dm.m1714zvd();
                } else {
                    abstractC0157mByQM1414dm.m1686KLFTb();
                }
                this.f1719mjFkc.m1183wA(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1707AZxh) {
                int iM1171MiMN = this.f1719mjFkc.m1171MiMN(view);
                if (i == -1) {
                    i = this.f1719mjFkc.m1184xJ();
                }
                if (iM1171MiMN == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1707AZxh.indexOfChild(view) + this.f1707AZxh.m1444KRTLGT());
                }
                if (iM1171MiMN != i) {
                    this.f1707AZxh.f1587YoKzxo.m1784jx(iM1171MiMN, i);
                }
            } else {
                this.f1719mjFkc.m1179mjFkc(view, i, false);
                c0153fehf.f1678wA = true;
                AbstractC0162vI abstractC0162vI = this.f1724xJ;
                if (abstractC0162vI != null && abstractC0162vI.m1841lgHUyS()) {
                    this.f1724xJ.m1832ETF(view);
                }
            }
            if (c0153fehf.f1676ZfxDd) {
                if (RecyclerView.f1536LREOK) {
                    Log.d("RecyclerView", "consuming pending invalidate on child " + c0153fehf.f1677mjFkc);
                }
                abstractC0157mByQM1414dm.f1700mjFkc.invalidate();
                c0153fehf.f1676ZfxDd = false;
            }
        }

        /* renamed from: xROA */
        public int mo1272xROA(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe) {
            return -1;
        }

        /* renamed from: xrEuO */
        public int m1813xrEuO(View view) {
            return ((C0153fehf) view.getLayoutParams()).f1675AZxh.bottom;
        }

        /* renamed from: yP */
        public boolean m1814yP(View view, int i, int i2, C0153fehf c0153fehf) {
            return (!view.isLayoutRequested() && this.f1709ETF && m1715LREOK(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) c0153fehf).width) && m1715LREOK(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) c0153fehf).height)) ? false : true;
        }

        /* renamed from: yX */
        public final boolean m1815yX() {
            return this.f1714VA;
        }

        /* renamed from: ybBTr */
        public boolean m1816ybBTr(C0146Ucbh c0146Ucbh, C0148VocHEe c0148VocHEe, View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: zvd */
        public int m1817zvd() {
            C0122AZxh c0122AZxh = this.f1719mjFkc;
            if (c0122AZxh != null) {
                return c0122AZxh.m1184xJ();
            }
            return 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$qdMbNW */
    public static class C0160qdMbNW extends Observable {
        /* renamed from: mjFkc */
        public boolean m1823mjFkc() {
            return !((Observable) this).mObservers.isEmpty();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$rkYL */
    public static abstract class AbstractC0161rkYL {
        /* renamed from: JHa */
        public void m1824JHa(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: KLFTb */
        public void m1825KLFTb(Rect rect, View view, RecyclerView recyclerView, C0148VocHEe c0148VocHEe) {
            m1826ZfxDd(rect, ((C0153fehf) view.getLayoutParams()).m1653mjFkc(), recyclerView);
        }

        /* renamed from: ZfxDd */
        public void m1826ZfxDd(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* renamed from: lgHUyS */
        public void m1827lgHUyS(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: qdMbNW */
        public void mo1828qdMbNW(Canvas canvas, RecyclerView recyclerView, C0148VocHEe c0148VocHEe) {
            m1827lgHUyS(canvas, recyclerView);
        }

        /* renamed from: xJ */
        public void mo1829xJ(Canvas canvas, RecyclerView recyclerView, C0148VocHEe c0148VocHEe) {
            m1824JHa(canvas, recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$vI */
    public static abstract class AbstractC0162vI {

        /* renamed from: AZxh */
        public RecyclerView f1731AZxh;

        /* renamed from: JHa */
        public View f1732JHa;

        /* renamed from: KLFTb */
        public boolean f1733KLFTb;

        /* renamed from: ZfxDd */
        public boolean f1734ZfxDd;

        /* renamed from: lgHUyS */
        public boolean f1735lgHUyS;

        /* renamed from: wA */
        public AbstractC0159qGY f1737wA;

        /* renamed from: mjFkc */
        public int f1736mjFkc = -1;

        /* renamed from: xJ */
        public final mjFkc f1738xJ = new mjFkc(0, 0);

        /* renamed from: androidx.recyclerview.widget.RecyclerView$vI$AZxh */
        public interface AZxh {
            /* renamed from: AZxh */
            PointF mo1304AZxh(int i);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$vI$mjFkc */
        public static class mjFkc {

            /* renamed from: AZxh */
            public int f1739AZxh;

            /* renamed from: JHa */
            public boolean f1740JHa;

            /* renamed from: KLFTb */
            public Interpolator f1741KLFTb;

            /* renamed from: ZfxDd */
            public int f1742ZfxDd;

            /* renamed from: mjFkc */
            public int f1743mjFkc;

            /* renamed from: wA */
            public int f1744wA;

            /* renamed from: xJ */
            public int f1745xJ;

            public mjFkc(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            /* renamed from: AZxh */
            public void m1847AZxh(int i) {
                this.f1742ZfxDd = i;
            }

            /* renamed from: KLFTb */
            public final void m1848KLFTb() {
                if (this.f1741KLFTb != null && this.f1744wA < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1744wA < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: ZfxDd */
            public void m1849ZfxDd(int i, int i2, int i3, Interpolator interpolator) {
                this.f1743mjFkc = i;
                this.f1739AZxh = i2;
                this.f1744wA = i3;
                this.f1741KLFTb = interpolator;
                this.f1740JHa = true;
            }

            /* renamed from: mjFkc */
            public boolean m1850mjFkc() {
                return this.f1742ZfxDd >= 0;
            }

            /* renamed from: wA */
            public void m1851wA(RecyclerView recyclerView) {
                int i = this.f1742ZfxDd;
                if (i >= 0) {
                    this.f1742ZfxDd = -1;
                    recyclerView.m1492fFz(i);
                    this.f1740JHa = false;
                } else {
                    if (!this.f1740JHa) {
                        this.f1745xJ = 0;
                        return;
                    }
                    m1848KLFTb();
                    recyclerView.f1591bbzow.m1854KLFTb(this.f1743mjFkc, this.f1739AZxh, this.f1744wA, this.f1741KLFTb);
                    int i2 = this.f1745xJ + 1;
                    this.f1745xJ = i2;
                    if (i2 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1740JHa = false;
                }
            }

            public mjFkc(int i, int i2, int i3, Interpolator interpolator) {
                this.f1742ZfxDd = -1;
                this.f1740JHa = false;
                this.f1745xJ = 0;
                this.f1743mjFkc = i;
                this.f1739AZxh = i2;
                this.f1744wA = i3;
                this.f1741KLFTb = interpolator;
            }
        }

        /* renamed from: AZxh */
        public View m1830AZxh(int i) {
            return this.f1731AZxh.f1587YoKzxo.mo1362wJVbdd(i);
        }

        /* renamed from: Dt */
        public void m1831Dt(int i, int i2) {
            PointF pointFMo1842mjFkc;
            RecyclerView recyclerView = this.f1731AZxh;
            if (this.f1736mjFkc == -1 || recyclerView == null) {
                m1833IEE();
            }
            if (this.f1734ZfxDd && this.f1732JHa == null && this.f1737wA != null && (pointFMo1842mjFkc = mo1842mjFkc(this.f1736mjFkc)) != null) {
                float f = pointFMo1842mjFkc.x;
                if (f != 0.0f || pointFMo1842mjFkc.y != 0.0f) {
                    recyclerView.m1523sqndV((int) Math.signum(f), (int) Math.signum(pointFMo1842mjFkc.y), null);
                }
            }
            this.f1734ZfxDd = false;
            View view = this.f1732JHa;
            if (view != null) {
                if (m1839ZfxDd(view) == this.f1736mjFkc) {
                    mo1217rkYL(this.f1732JHa, recyclerView.f1581Vdz, this.f1738xJ);
                    this.f1738xJ.m1851wA(recyclerView);
                    m1833IEE();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1732JHa = null;
                }
            }
            if (this.f1733KLFTb) {
                mo1837VA(i, i2, recyclerView.f1581Vdz, this.f1738xJ);
                boolean zM1850mjFkc = this.f1738xJ.m1850mjFkc();
                this.f1738xJ.m1851wA(recyclerView);
                if (zM1850mjFkc && this.f1733KLFTb) {
                    this.f1734ZfxDd = true;
                    recyclerView.f1591bbzow.m1855ZfxDd();
                }
            }
        }

        /* renamed from: ETF */
        public void m1832ETF(View view) {
            if (m1839ZfxDd(view) == m1834JHa()) {
                this.f1732JHa = view;
                if (RecyclerView.f1536LREOK) {
                    Log.d("RecyclerView", "smooth scroll target view has been attached");
                }
            }
        }

        /* renamed from: IEE */
        public final void m1833IEE() {
            if (this.f1733KLFTb) {
                this.f1733KLFTb = false;
                mo1838YoKzxo();
                this.f1731AZxh.f1581Vdz.f1660mjFkc = -1;
                this.f1732JHa = null;
                this.f1736mjFkc = -1;
                this.f1734ZfxDd = false;
                this.f1737wA.m1739Jidt(this);
                this.f1737wA = null;
                this.f1731AZxh = null;
            }
        }

        /* renamed from: JHa */
        public int m1834JHa() {
            return this.f1736mjFkc;
        }

        /* renamed from: KLFTb */
        public AbstractC0159qGY m1835KLFTb() {
            return this.f1737wA;
        }

        /* renamed from: MiMN */
        public abstract void mo1836MiMN();

        /* renamed from: VA */
        public abstract void mo1837VA(int i, int i2, C0148VocHEe c0148VocHEe, mjFkc mjfkc);

        /* renamed from: YoKzxo */
        public abstract void mo1838YoKzxo();

        /* renamed from: ZfxDd */
        public int m1839ZfxDd(View view) {
            return this.f1731AZxh.m1419ANMGZc(view);
        }

        /* renamed from: fehf */
        public void m1840fehf(RecyclerView recyclerView, AbstractC0159qGY abstractC0159qGY) {
            recyclerView.f1591bbzow.m1853JHa();
            if (this.f1735lgHUyS) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1731AZxh = recyclerView;
            this.f1737wA = abstractC0159qGY;
            int i = this.f1736mjFkc;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f1581Vdz.f1660mjFkc = i;
            this.f1733KLFTb = true;
            this.f1734ZfxDd = true;
            this.f1732JHa = m1830AZxh(m1834JHa());
            mo1836MiMN();
            this.f1731AZxh.f1591bbzow.m1855ZfxDd();
            this.f1735lgHUyS = true;
        }

        /* renamed from: lgHUyS */
        public boolean m1841lgHUyS() {
            return this.f1733KLFTb;
        }

        /* renamed from: mjFkc */
        public PointF mo1842mjFkc(int i) {
            Object objM1835KLFTb = m1835KLFTb();
            if (objM1835KLFTb instanceof AZxh) {
                return ((AZxh) objM1835KLFTb).mo1304AZxh(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + AZxh.class.getCanonicalName());
            return null;
        }

        /* renamed from: qGY */
        public void m1843qGY(int i) {
            this.f1736mjFkc = i;
        }

        /* renamed from: qdMbNW */
        public void m1844qdMbNW(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        /* renamed from: rkYL */
        public abstract void mo1217rkYL(View view, C0148VocHEe c0148VocHEe, mjFkc mjfkc);

        /* renamed from: wA */
        public int m1845wA() {
            return this.f1731AZxh.f1587YoKzxo.m1817zvd();
        }

        /* renamed from: xJ */
        public boolean m1846xJ() {
            return this.f1734ZfxDd;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$wA */
    public class InterpolatorC0163wA implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$wJVbdd */
    public class RunnableC0164wJVbdd implements Runnable {

        /* renamed from: AZxh */
        public int f1746AZxh;

        /* renamed from: JHa */
        public boolean f1747JHa;

        /* renamed from: KLFTb */
        public boolean f1748KLFTb;

        /* renamed from: ZfxDd */
        public Interpolator f1749ZfxDd;

        /* renamed from: mjFkc */
        public int f1750mjFkc;

        /* renamed from: wA */
        public OverScroller f1751wA;

        public RunnableC0164wJVbdd() {
            Interpolator interpolator = RecyclerView.f1543giT;
            this.f1749ZfxDd = interpolator;
            this.f1748KLFTb = false;
            this.f1747JHa = false;
            this.f1751wA = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* renamed from: AZxh */
        public void m1852AZxh(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f1746AZxh = 0;
            this.f1750mjFkc = 0;
            Interpolator interpolator = this.f1749ZfxDd;
            Interpolator interpolator2 = RecyclerView.f1543giT;
            if (interpolator != interpolator2) {
                this.f1749ZfxDd = interpolator2;
                this.f1751wA = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1751wA.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m1855ZfxDd();
        }

        /* renamed from: JHa */
        public void m1853JHa() {
            RecyclerView.this.removeCallbacks(this);
            this.f1751wA.abortAnimation();
        }

        /* renamed from: KLFTb */
        public void m1854KLFTb(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = m1856mjFkc(i, i2);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.f1543giT;
            }
            if (this.f1749ZfxDd != interpolator) {
                this.f1749ZfxDd = interpolator;
                this.f1751wA = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1746AZxh = 0;
            this.f1750mjFkc = 0;
            RecyclerView.this.setScrollState(2);
            this.f1751wA.startScroll(0, 0, i, i2, i4);
            m1855ZfxDd();
        }

        /* renamed from: ZfxDd */
        public void m1855ZfxDd() {
            if (this.f1748KLFTb) {
                this.f1747JHa = true;
            } else {
                m1857wA();
            }
        }

        /* renamed from: mjFkc */
        public final int m1856mjFkc(int i, int i2) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1587YoKzxo == null) {
                m1853JHa();
                return;
            }
            this.f1747JHa = false;
            this.f1748KLFTb = true;
            recyclerView.m1432HGpJ();
            OverScroller overScroller = this.f1751wA;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f1750mjFkc;
                int i4 = currY - this.f1746AZxh;
                this.f1750mjFkc = currX;
                this.f1746AZxh = currY;
                int iM1464Ucbh = RecyclerView.this.m1464Ucbh(i3);
                int iM1431Gd = RecyclerView.this.m1431Gd(i4);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f1576SOS;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.m1443KLMXS(iM1464Ucbh, iM1431Gd, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f1576SOS;
                    iM1464Ucbh -= iArr2[0];
                    iM1431Gd -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.m1491eyqo(iM1464Ucbh, iM1431Gd);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f1568MiMN != null) {
                    int[] iArr3 = recyclerView3.f1576SOS;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.m1523sqndV(iM1464Ucbh, iM1431Gd, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f1576SOS;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    iM1464Ucbh -= i2;
                    iM1431Gd -= i;
                    AbstractC0162vI abstractC0162vI = recyclerView4.f1587YoKzxo.f1724xJ;
                    if (abstractC0162vI != null && !abstractC0162vI.m1846xJ() && abstractC0162vI.m1841lgHUyS()) {
                        int iM1624AZxh = RecyclerView.this.f1581Vdz.m1624AZxh();
                        if (iM1624AZxh == 0) {
                            abstractC0162vI.m1833IEE();
                        } else if (abstractC0162vI.m1834JHa() >= iM1624AZxh) {
                            abstractC0162vI.m1843qGY(iM1624AZxh - 1);
                            abstractC0162vI.m1831Dt(i2, i);
                        } else {
                            abstractC0162vI.m1831Dt(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.f1607qGY.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f1576SOS;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.m1541zvd(i2, i, iM1464Ucbh, iM1431Gd, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f1576SOS;
                int i5 = iM1464Ucbh - iArr6[0];
                int i6 = iM1431Gd - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.m1519rWxwaT(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                AbstractC0162vI abstractC0162vI2 = RecyclerView.this.f1587YoKzxo.f1724xJ;
                if ((abstractC0162vI2 == null || !abstractC0162vI2.m1846xJ()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.m1511mjFkc(i7, currVelocity);
                    }
                    if (RecyclerView.f1548uH) {
                        RecyclerView.this.f1560JBhc.m1297AZxh();
                    }
                } else {
                    m1855ZfxDd();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    RunnableC0129KLFTb runnableC0129KLFTb = recyclerView7.f1578SwgkN;
                    if (runnableC0129KLFTb != null) {
                        runnableC0129KLFTb.m1290JHa(recyclerView7, i2, i);
                    }
                }
            }
            AbstractC0162vI abstractC0162vI3 = RecyclerView.this.f1587YoKzxo.f1724xJ;
            if (abstractC0162vI3 != null && abstractC0162vI3.m1846xJ()) {
                abstractC0162vI3.m1831Dt(0, 0);
            }
            this.f1748KLFTb = false;
            if (this.f1747JHa) {
                m1857wA();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.m1448LsBneK(1);
            }
        }

        /* renamed from: wA */
        public final void m1857wA() {
            RecyclerView.this.removeCallbacks(this);
            AbstractC2876T9.m10258WGXroI(RecyclerView.this, this);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$xJ */
    public static /* synthetic */ class C0165xJ {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f1753mjFkc;

        static {
            int[] iArr = new int[AbstractC0156lgHUyS.mjFkc.m1676values().length];
            f1753mjFkc = iArr;
            try {
                iArr[AbstractC0156lgHUyS.mjFkc.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1753mjFkc[AbstractC0156lgHUyS.mjFkc.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Class cls = Integer.TYPE;
        f1545lti = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f1543giT = new InterpolatorC0163wA();
        f1546sRqPfw = new C0136BAnRFn();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3731g4.f13678mjFkc);
    }

    /* renamed from: IVlxe */
    private float m1407IVlxe(int i) {
        double dLog = Math.log((Math.abs(i) * 0.35f) / (this.f1604mjFkc * 0.015f));
        float f = f1539XbiWeM;
        return (float) (this.f1604mjFkc * 0.015f * Math.exp((f / (f - 1.0d)) * dLog));
    }

    /* renamed from: Pq */
    public static void m1410Pq(AbstractC0157mByQ abstractC0157mByQ) {
        WeakReference weakReference = abstractC0157mByQ.f1687AZxh;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == abstractC0157mByQ.f1700mjFkc) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            abstractC0157mByQ.f1687AZxh = null;
        }
    }

    /* renamed from: Tw */
    private boolean m1411Tw(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.f1566KLMXS;
        if (edgeEffect == null || AbstractC2967UXIO.m10508AZxh(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z = false;
        } else {
            AbstractC2967UXIO.m10509ZfxDd(this.f1566KLMXS, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z = true;
        }
        EdgeEffect edgeEffect2 = this.f1592cMLeY;
        if (edgeEffect2 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            AbstractC2967UXIO.m10509ZfxDd(this.f1592cMLeY, 0.0f, motionEvent.getY() / getHeight());
            z = true;
        }
        EdgeEffect edgeEffect3 = this.f1624zvd;
        if (edgeEffect3 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            AbstractC2967UXIO.m10509ZfxDd(this.f1624zvd, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        }
        EdgeEffect edgeEffect4 = this.f1609rWxwaT;
        if (edgeEffect4 == null || AbstractC2967UXIO.m10508AZxh(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z;
        }
        AbstractC2967UXIO.m10509ZfxDd(this.f1609rWxwaT, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    /* renamed from: dGDT */
    private int m1413dGDT(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.f1624zvd;
        float f2 = 0.0f;
        if (edgeEffect == null || AbstractC2967UXIO.m10508AZxh(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1609rWxwaT;
            if (edgeEffect2 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.f1609rWxwaT.onRelease();
                } else {
                    float fM10509ZfxDd = AbstractC2967UXIO.m10509ZfxDd(this.f1609rWxwaT, height, 1.0f - width);
                    if (AbstractC2967UXIO.m10508AZxh(this.f1609rWxwaT) == 0.0f) {
                        this.f1609rWxwaT.onRelease();
                    }
                    f2 = fM10509ZfxDd;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f1624zvd.onRelease();
            } else {
                float f3 = -AbstractC2967UXIO.m10509ZfxDd(this.f1624zvd, -height, width);
                if (AbstractC2967UXIO.m10508AZxh(this.f1624zvd) == 0.0f) {
                    this.f1624zvd.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    /* renamed from: dm */
    public static AbstractC0157mByQ m1414dm(View view) {
        if (view == null) {
            return null;
        }
        return ((C0153fehf) view.getLayoutParams()).f1677mjFkc;
    }

    private C1801D2 getScrollingChildHelper() {
        if (this.f1559IVlxe == null) {
            this.f1559IVlxe = new C1801D2(this);
        }
        return this.f1559IVlxe;
    }

    /* renamed from: nxI */
    public static RecyclerView m1415nxI(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewM1415nxI = m1415nxI(viewGroup.getChildAt(i));
            if (recyclerViewM1415nxI != null) {
                return recyclerViewM1415nxI;
            }
        }
        return null;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        f1542gYa = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        f1536LREOK = z;
    }

    /* renamed from: tQ */
    public static void m1416tQ(View view, Rect rect) {
        C0153fehf c0153fehf = (C0153fehf) view.getLayoutParams();
        Rect rect2 = c0153fehf.f1675AZxh;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin);
    }

    /* renamed from: ANMGZc */
    public int m1419ANMGZc(View view) {
        AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(view);
        if (abstractC0157mByQM1414dm != null) {
            return abstractC0157mByQM1414dm.m1688MiMN();
        }
        return -1;
    }

    /* renamed from: APn */
    public final void m1420APn() {
        View focusedChild = (this.f1586XV && hasFocus() && this.f1568MiMN != null) ? getFocusedChild() : null;
        AbstractC0157mByQ abstractC0157mByQM1439JYn = focusedChild != null ? m1439JYn(focusedChild) : null;
        if (abstractC0157mByQM1439JYn == null) {
            m1440Jidt();
            return;
        }
        this.f1581Vdz.f1656YoKzxo = this.f1568MiMN.m1668lgHUyS() ? abstractC0157mByQM1439JYn.m1681ETF() : -1L;
        this.f1581Vdz.f1654MiMN = this.f1603mByQ ? -1 : abstractC0157mByQM1439JYn.m1692Ucbh() ? abstractC0157mByQM1439JYn.f1697ZfxDd : abstractC0157mByQM1439JYn.m1680Dt();
        this.f1581Vdz.f1663rkYL = m1540yfx(abstractC0157mByQM1439JYn.f1700mjFkc);
    }

    /* renamed from: BAnRFn */
    public final boolean m1421BAnRFn(int i, int i2) {
        m1442JrJO(this.f1620xROA);
        int[] iArr = this.f1620xROA;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* renamed from: BxruE */
    public boolean m1422BxruE(int i, int i2) {
        return getScrollingChildHelper().m7965qGY(i, i2);
    }

    /* renamed from: CTcA */
    public void m1423CTcA(int i, int i2) {
        m1447LeWm(i, i2, null);
    }

    /* renamed from: CqaNbM */
    public final void m1424CqaNbM() {
        m1433Htq();
        m1474XD();
        this.f1581Vdz.m1628mjFkc(6);
        this.f1565KLFTb.m2001Dt();
        this.f1581Vdz.f1652JHa = this.f1568MiMN.mo1665ZfxDd();
        this.f1581Vdz.f1657ZfxDd = 0;
        if (this.f1588ZfxDd != null && this.f1568MiMN.m1655AZxh()) {
            Parcelable parcelable = this.f1588ZfxDd.f1628wA;
            if (parcelable != null) {
                this.f1587YoKzxo.mo1352mPWV(parcelable);
            }
            this.f1588ZfxDd = null;
        }
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        c0148VocHEe.f1659lgHUyS = false;
        this.f1587YoKzxo.mo1248dGDT(this.f1617wA, c0148VocHEe);
        C0148VocHEe c0148VocHEe2 = this.f1581Vdz;
        c0148VocHEe2.f1665xJ = false;
        c0148VocHEe2.f1651ETF = c0148VocHEe2.f1651ETF && this.f1582Vnb != null;
        c0148VocHEe2.f1653KLFTb = 4;
        m1498gtr();
        m1457QyqF(false);
    }

    /* renamed from: Dp */
    public void m1425Dp(boolean z) {
        int i = this.f1572Ne - 1;
        this.f1572Ne = i;
        if (i < 1) {
            if (f1542gYa && i < 0) {
                throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + m1444KRTLGT());
            }
            this.f1572Ne = 0;
            if (z) {
                m1509mByQ();
                m1469Vnb();
            }
        }
    }

    /* renamed from: Dt */
    public void m1426Dt(AbstractC0161rkYL abstractC0161rkYL, int i) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.mo1351lgHUyS("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f1607qGY.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f1607qGY.add(abstractC0161rkYL);
        } else {
            this.f1607qGY.add(i, abstractC0161rkYL);
        }
        m1478XbiWeM();
        requestLayout();
    }

    /* renamed from: ETF */
    public void m1427ETF(InterfaceC0145Pq interfaceC0145Pq) {
        this.f1596fehf.add(interfaceC0145Pq);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* renamed from: FbxKQm */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1428FbxKQm(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < 0.0f) {
            m1514oCFDzJ();
            AbstractC2967UXIO.m10509ZfxDd(this.f1566KLMXS, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        } else {
            if (f2 <= 0.0f) {
                z = false;
                if (f4 >= 0.0f) {
                    m1473WrLQs();
                    AbstractC2967UXIO.m10509ZfxDd(this.f1624zvd, (-f4) / getHeight(), f / getWidth());
                } else if (f4 > 0.0f) {
                    m1532vadzgd();
                    AbstractC2967UXIO.m10509ZfxDd(this.f1609rWxwaT, f4 / getHeight(), 1.0f - (f / getWidth()));
                } else {
                    z2 = z;
                }
                if (z2 && f2 == 0.0f && f4 == 0.0f) {
                    return;
                }
                AbstractC2876T9.m10283nxI(this);
            }
            m1485aqHPIZ();
            AbstractC2967UXIO.m10509ZfxDd(this.f1592cMLeY, f2 / getWidth(), f3 / getHeight());
        }
        z = true;
        if (f4 >= 0.0f) {
        }
        if (z2) {
        }
        AbstractC2876T9.m10283nxI(this);
    }

    /* renamed from: Fztqa */
    public void m1429Fztqa(int i, int i2, Interpolator interpolator, int i3) {
        m1512mzUGzO(i, i2, interpolator, i3, false);
    }

    /* renamed from: GMIER */
    public final void m1430GMIER(C0148VocHEe c0148VocHEe) {
        if (getScrollState() != 2) {
            c0148VocHEe.f1661qGY = 0;
            c0148VocHEe.f1658fehf = 0;
        } else {
            OverScroller overScroller = this.f1591bbzow.f1751wA;
            c0148VocHEe.f1661qGY = overScroller.getFinalX() - overScroller.getCurrX();
            c0148VocHEe.f1658fehf = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    /* renamed from: Gd */
    public int m1431Gd(int i) {
        return m1499huTpC(i, this.f1624zvd, this.f1609rWxwaT, getHeight());
    }

    /* renamed from: HGpJ */
    public void m1432HGpJ() {
        if (!this.f1579Ucbh || this.f1603mByQ) {
            AbstractC2352L8.m9358mjFkc("RV FullInvalidate");
            m1455OjSQV();
            AbstractC2352L8.m9357AZxh();
            return;
        }
        if (this.f1565KLFTb.m2016qGY()) {
            if (!this.f1565KLFTb.m2018rkYL(4) || this.f1565KLFTb.m2018rkYL(11)) {
                if (this.f1565KLFTb.m2016qGY()) {
                    AbstractC2352L8.m9358mjFkc("RV FullInvalidate");
                    m1455OjSQV();
                    AbstractC2352L8.m9357AZxh();
                    return;
                }
                return;
            }
            AbstractC2352L8.m9358mjFkc("RV PartialInvalidate");
            m1433Htq();
            m1474XD();
            this.f1565KLFTb.m2007Pq();
            if (!this.f1556Gd) {
                if (m1461SOS()) {
                    m1455OjSQV();
                } else {
                    this.f1565KLFTb.m2017qdMbNW();
                }
            }
            m1457QyqF(true);
            m1498gtr();
            AbstractC2352L8.m9357AZxh();
        }
    }

    /* renamed from: Htq */
    public void m1433Htq() {
        int i = this.f1598huTpC + 1;
        this.f1598huTpC = i;
        if (i != 1 || this.f1557HGpJ) {
            return;
        }
        this.f1556Gd = false;
    }

    /* renamed from: IEE */
    public final void m1434IEE() {
        m1435IvRQOa();
        setScrollState(0);
    }

    /* renamed from: IvRQOa */
    public final void m1435IvRQOa() {
        VelocityTracker velocityTracker = this.f1606oCFDzJ;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        m1448LsBneK(0);
        m1436IyS();
    }

    /* renamed from: IyS */
    public final void m1436IyS() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1566KLMXS;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f1566KLMXS.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f1624zvd;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f1624zvd.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1592cMLeY;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f1592cMLeY.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1609rWxwaT;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f1609rWxwaT.isFinished();
        }
        if (zIsFinished) {
            AbstractC2876T9.m10283nxI(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* renamed from: JBhc */
    public boolean m1437JBhc(int i, int i2) {
        int iMax;
        int i3;
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f1557HGpJ) {
            return false;
        }
        int iMo1335VA = abstractC0159qGY.mo1335VA();
        boolean zMo1322MiMN = this.f1587YoKzxo.mo1322MiMN();
        if (iMo1335VA == 0 || Math.abs(i) < this.f1562JYgkl) {
            i = 0;
        }
        if (!zMo1322MiMN || Math.abs(i2) < this.f1562JYgkl) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        if (i == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.f1566KLMXS;
            if (edgeEffect == null || AbstractC2967UXIO.m10508AZxh(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.f1592cMLeY;
                if (edgeEffect2 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect2) != 0.0f) {
                    if (m1530uxlM(this.f1592cMLeY, i, getWidth())) {
                        this.f1592cMLeY.onAbsorb(i);
                        i = 0;
                    }
                    iMax = i;
                    i = 0;
                }
                iMax = 0;
            } else {
                int i4 = -i;
                if (m1530uxlM(this.f1566KLMXS, i4, getWidth())) {
                    this.f1566KLMXS.onAbsorb(i4);
                    i = 0;
                }
                iMax = i;
                i = 0;
            }
        }
        if (i2 == 0) {
            i3 = i2;
            i2 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.f1624zvd;
            if (edgeEffect3 == null || AbstractC2967UXIO.m10508AZxh(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.f1609rWxwaT;
                if (edgeEffect4 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect4) != 0.0f) {
                    if (m1530uxlM(this.f1609rWxwaT, i2, getHeight())) {
                        this.f1609rWxwaT.onAbsorb(i2);
                        i2 = 0;
                    }
                    i3 = 0;
                }
                i3 = i2;
                i2 = 0;
            } else {
                int i5 = -i2;
                if (m1530uxlM(this.f1624zvd, i5, getHeight())) {
                    this.f1624zvd.onAbsorb(i5);
                    i2 = 0;
                }
                i3 = 0;
            }
        }
        if (iMax != 0 || i2 != 0) {
            int i6 = this.f1564JrJO;
            iMax = Math.max(-i6, Math.min(iMax, i6));
            int i7 = this.f1564JrJO;
            i2 = Math.max(-i7, Math.min(i2, i7));
            this.f1591bbzow.m1852AZxh(iMax, i2);
        }
        if (i == 0 && i3 == 0) {
            return (iMax == 0 && i2 == 0) ? false : true;
        }
        float f = i;
        float f2 = i3;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = iMo1335VA != 0 || zMo1322MiMN;
            dispatchNestedFling(f, f2, z);
            AbstractC0141IEE abstractC0141IEE = this.f1563JYn;
            if (abstractC0141IEE != null && abstractC0141IEE.mo1547mjFkc(i, i3)) {
                return true;
            }
            if (z) {
                if (zMo1322MiMN) {
                    iMo1335VA = (iMo1335VA == true ? 1 : 0) | 2;
                }
                m1422BxruE(iMo1335VA, 1);
                int i8 = this.f1564JrJO;
                int iMax2 = Math.max(-i8, Math.min(i, i8));
                int i9 = this.f1564JrJO;
                this.f1591bbzow.m1852AZxh(iMax2, Math.max(-i9, Math.min(i3, i9)));
                return true;
            }
        }
        return false;
    }

    /* renamed from: JYgkl */
    public final boolean m1438JYgkl(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f1596fehf.size();
        for (int i = 0; i < size; i++) {
            InterfaceC0145Pq interfaceC0145Pq = (InterfaceC0145Pq) this.f1596fehf.get(i);
            if (interfaceC0145Pq.mo1578mjFkc(this, motionEvent) && action != 3) {
                this.f1558IEE = interfaceC0145Pq;
                return true;
            }
        }
        return false;
    }

    /* renamed from: JYn */
    public AbstractC0157mByQ m1439JYn(View view) {
        View viewM1528uHVRx = m1528uHVRx(view);
        if (viewM1528uHVRx == null) {
            return null;
        }
        return m1484alEkx(viewM1528uHVRx);
    }

    /* renamed from: Jidt */
    public final void m1440Jidt() {
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        c0148VocHEe.f1656YoKzxo = -1L;
        c0148VocHEe.f1654MiMN = -1;
        c0148VocHEe.f1663rkYL = -1;
    }

    /* renamed from: Jk */
    public void m1441Jk(AbstractC0161rkYL abstractC0161rkYL) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.mo1351lgHUyS("Cannot remove item decoration during a scroll  or layout");
        }
        this.f1607qGY.remove(abstractC0161rkYL);
        if (this.f1607qGY.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m1478XbiWeM();
        requestLayout();
    }

    /* renamed from: JrJO */
    public final void m1442JrJO(int[] iArr) {
        int iM1184xJ = this.f1561JHa.m1184xJ();
        if (iM1184xJ == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iM1184xJ; i3++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1169JHa(i3));
            if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                int iM1688MiMN = abstractC0157mByQM1414dm.m1688MiMN();
                if (iM1688MiMN < i) {
                    i = iM1688MiMN;
                }
                if (iM1688MiMN > i2) {
                    i2 = iM1688MiMN;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* renamed from: KLMXS */
    public boolean m1443KLMXS(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m7961ZfxDd(i, i2, iArr, iArr2, i3);
    }

    /* renamed from: KRTLGT */
    public String m1444KRTLGT() {
        return " " + super.toString() + ", adapter:" + this.f1568MiMN + ", layout:" + this.f1587YoKzxo + ", context:" + getContext();
    }

    /* renamed from: KRckQg */
    public void m1445KRckQg(InterfaceC0145Pq interfaceC0145Pq) {
        this.f1596fehf.remove(interfaceC0145Pq);
        if (this.f1558IEE == interfaceC0145Pq) {
            this.f1558IEE = null;
        }
    }

    /* renamed from: LREOK */
    public final boolean m1446LREOK(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || view2 == view || m1528uHVRx(view2) == null) {
            return false;
        }
        if (view == null || m1528uHVRx(view) == null) {
            return true;
        }
        this.f1553Dt.set(0, 0, view.getWidth(), view.getHeight());
        this.f1554ETF.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f1553Dt);
        offsetDescendantRectToMyCoords(view2, this.f1554ETF);
        char c = 65535;
        int i3 = this.f1587YoKzxo.m1764WGXroI() == 1 ? -1 : 1;
        Rect rect = this.f1553Dt;
        int i4 = rect.left;
        Rect rect2 = this.f1554ETF;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            c = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                c = 0;
            }
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 < 0);
        }
        if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 > 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + m1444KRTLGT());
    }

    /* renamed from: LeWm */
    public void m1447LeWm(int i, int i2, Interpolator interpolator) {
        m1429Fztqa(i, i2, interpolator, Integer.MIN_VALUE);
    }

    /* renamed from: LsBneK */
    public void m1448LsBneK(int i) {
        getScrollingChildHelper().m7955IEE(i);
    }

    /* renamed from: MiMN */
    public void m1449MiMN(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2) {
        abstractC0157mByQ.m1689Ne(false);
        if (this.f1582Vnb.mo1398mjFkc(abstractC0157mByQ, aZxh, aZxh2)) {
            m1460SKTn();
        }
    }

    /* renamed from: Moer */
    public final void m1450Moer(long j, AbstractC0157mByQ abstractC0157mByQ, AbstractC0157mByQ abstractC0157mByQ2) {
        int iM1184xJ = this.f1561JHa.m1184xJ();
        for (int i = 0; i < iM1184xJ; i++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1169JHa(i));
            if (abstractC0157mByQM1414dm != abstractC0157mByQ && m1501jm(abstractC0157mByQM1414dm) == j) {
                AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1568MiMN;
                if (abstractC0156lgHUyS == null || !abstractC0156lgHUyS.m1668lgHUyS()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + abstractC0157mByQM1414dm + " \n View Holder 2:" + abstractC0157mByQ + m1444KRTLGT());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + abstractC0157mByQM1414dm + " \n View Holder 2:" + abstractC0157mByQ + m1444KRTLGT());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0157mByQ2 + " cannot be found but it is necessary for " + abstractC0157mByQ + m1444KRTLGT());
    }

    /* renamed from: NKyg */
    public final void m1451NKyg() {
        if (AbstractC2876T9.m10253Ucbh(this) == 0) {
            AbstractC2876T9.m10278kism(this, 8);
        }
    }

    /* renamed from: NPj */
    public final boolean m1452NPj(MotionEvent motionEvent) {
        InterfaceC0145Pq interfaceC0145Pq = this.f1558IEE;
        if (interfaceC0145Pq == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return m1438JYgkl(motionEvent);
        }
        interfaceC0145Pq.mo1577AZxh(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f1558IEE = null;
        }
        return true;
    }

    /* renamed from: NV */
    public final void m1453NV(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1553Dt.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0153fehf) {
            C0153fehf c0153fehf = (C0153fehf) layoutParams;
            if (!c0153fehf.f1678wA) {
                Rect rect = c0153fehf.f1675AZxh;
                Rect rect2 = this.f1553Dt;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1553Dt);
            offsetRectIntoDescendantCoords(view, this.f1553Dt);
        }
        this.f1587YoKzxo.mo1727Fztqa(this, view, this.f1553Dt, !this.f1579Ucbh, view2 == null);
    }

    /* renamed from: Ne */
    public final void m1454Ne() {
        this.f1581Vdz.m1628mjFkc(1);
        m1430GMIER(this.f1581Vdz);
        this.f1581Vdz.f1650Dt = false;
        m1433Htq();
        this.f1619xJ.m2026JHa();
        m1474XD();
        m1475XDdeP();
        m1420APn();
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        c0148VocHEe.f1662qdMbNW = c0148VocHEe.f1651ETF && this.f1594dm;
        this.f1594dm = false;
        this.f1589alEkx = false;
        c0148VocHEe.f1659lgHUyS = c0148VocHEe.f1655VA;
        c0148VocHEe.f1652JHa = this.f1568MiMN.mo1665ZfxDd();
        m1442JrJO(this.f1620xROA);
        if (this.f1581Vdz.f1651ETF) {
            int iM1184xJ = this.f1561JHa.m1184xJ();
            for (int i = 0; i < iM1184xJ; i++) {
                AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1169JHa(i));
                if (!abstractC0157mByQM1414dm.m1687KLMXS() && (!abstractC0157mByQM1414dm.m1698diqgf() || this.f1568MiMN.m1668lgHUyS())) {
                    this.f1619xJ.m2027KLFTb(abstractC0157mByQM1414dm, this.f1582Vnb.m1566diqgf(this.f1581Vdz, abstractC0157mByQM1414dm, AbstractC0144MiMN.m1557KLFTb(abstractC0157mByQM1414dm), abstractC0157mByQM1414dm.m1708rkYL()));
                    if (this.f1581Vdz.f1662qdMbNW && abstractC0157mByQM1414dm.m1683HGpJ() && !abstractC0157mByQM1414dm.m1692Ucbh() && !abstractC0157mByQM1414dm.m1687KLMXS() && !abstractC0157mByQM1414dm.m1698diqgf()) {
                        this.f1619xJ.m2038wA(m1501jm(abstractC0157mByQM1414dm), abstractC0157mByQM1414dm);
                    }
                }
            }
        }
        if (this.f1581Vdz.f1655VA) {
            m1505knzZ();
            C0148VocHEe c0148VocHEe2 = this.f1581Vdz;
            boolean z = c0148VocHEe2.f1665xJ;
            c0148VocHEe2.f1665xJ = false;
            this.f1587YoKzxo.mo1248dGDT(this.f1617wA, c0148VocHEe2);
            this.f1581Vdz.f1665xJ = z;
            for (int i2 = 0; i2 < this.f1561JHa.m1184xJ(); i2++) {
                AbstractC0157mByQ abstractC0157mByQM1414dm2 = m1414dm(this.f1561JHa.m1169JHa(i2));
                if (!abstractC0157mByQM1414dm2.m1687KLMXS() && !this.f1619xJ.m2036qdMbNW(abstractC0157mByQM1414dm2)) {
                    int iM1557KLFTb = AbstractC0144MiMN.m1557KLFTb(abstractC0157mByQM1414dm2);
                    boolean zM1706qGY = abstractC0157mByQM1414dm2.m1706qGY(8192);
                    if (!zM1706qGY) {
                        iM1557KLFTb |= 4096;
                    }
                    AbstractC0144MiMN.AZxh aZxhM1566diqgf = this.f1582Vnb.m1566diqgf(this.f1581Vdz, abstractC0157mByQM1414dm2, iM1557KLFTb, abstractC0157mByQM1414dm2.m1708rkYL());
                    if (zM1706qGY) {
                        m1502jtz(abstractC0157mByQM1414dm2, aZxhM1566diqgf);
                    } else {
                        this.f1619xJ.m2034mjFkc(abstractC0157mByQM1414dm2, aZxhM1566diqgf);
                    }
                }
            }
            m1488diqgf();
        } else {
            m1488diqgf();
        }
        m1498gtr();
        m1457QyqF(false);
        this.f1581Vdz.f1653KLFTb = 2;
    }

    /* renamed from: OjSQV */
    public void m1455OjSQV() {
        if (this.f1568MiMN == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1587YoKzxo == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.f1581Vdz.f1650Dt = false;
        boolean z = this.f1597gtIJp && !(this.f1600kism == getWidth() && this.f1612tjSezt == getHeight());
        this.f1600kism = 0;
        this.f1612tjSezt = 0;
        this.f1597gtIJp = false;
        if (this.f1581Vdz.f1653KLFTb == 1) {
            m1454Ne();
            this.f1587YoKzxo.m1747LsBneK(this);
            m1424CqaNbM();
        } else if (this.f1565KLFTb.m2014fehf() || z || this.f1587YoKzxo.m1755SOS() != getWidth() || this.f1587YoKzxo.m1737JYgkl() != getHeight()) {
            this.f1587YoKzxo.m1747LsBneK(this);
            m1424CqaNbM();
        } else {
            this.f1587YoKzxo.m1747LsBneK(this);
        }
        m1537xrEuO();
    }

    /* renamed from: Qr */
    public void m1456Qr() {
        this.f1565KLFTb = new C0176mjFkc(new C0142JHa());
    }

    /* renamed from: QyqF */
    public void m1457QyqF(boolean z) {
        if (this.f1598huTpC < 1) {
            if (f1542gYa) {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + m1444KRTLGT());
            }
            this.f1598huTpC = 1;
        }
        if (!z && !this.f1557HGpJ) {
            this.f1556Gd = false;
        }
        if (this.f1598huTpC == 1) {
            if (z && this.f1556Gd && !this.f1557HGpJ && this.f1587YoKzxo != null && this.f1568MiMN != null) {
                m1455OjSQV();
            }
            if (!this.f1557HGpJ) {
                this.f1556Gd = false;
            }
        }
        this.f1598huTpC--;
    }

    /* renamed from: RWyiuY */
    public final void m1458RWyiuY(AbstractC0156lgHUyS abstractC0156lgHUyS, boolean z, boolean z2) {
        AbstractC0156lgHUyS abstractC0156lgHUyS2 = this.f1568MiMN;
        if (abstractC0156lgHUyS2 != null) {
            abstractC0156lgHUyS2.m1666diqgf(this.f1550AZxh);
            this.f1568MiMN.m1661MiMN(this);
        }
        if (!z || z2) {
            m1481Xxz();
        }
        this.f1565KLFTb.m2013eyqo();
        AbstractC0156lgHUyS abstractC0156lgHUyS3 = this.f1568MiMN;
        this.f1568MiMN = abstractC0156lgHUyS;
        if (abstractC0156lgHUyS != null) {
            abstractC0156lgHUyS.m1658IEE(this.f1550AZxh);
            abstractC0156lgHUyS.m1671qdMbNW(this);
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.mo1760Vgyli(abstractC0156lgHUyS3, this.f1568MiMN);
        }
        this.f1617wA.m1586HGpJ(abstractC0156lgHUyS3, this.f1568MiMN, z);
        this.f1581Vdz.f1665xJ = true;
    }

    /* renamed from: Rc */
    public void m1459Rc(int i, int i2) {
    }

    /* renamed from: SKTn */
    public void m1460SKTn() {
        if (this.f1623yfx || !this.f1574Pq) {
            return;
        }
        AbstractC2876T9.m10258WGXroI(this, this.f1570NKyg);
        this.f1623yfx = true;
    }

    /* renamed from: SOS */
    public final boolean m1461SOS() {
        int iM1184xJ = this.f1561JHa.m1184xJ();
        for (int i = 0; i < iM1184xJ; i++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1169JHa(i));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1687KLMXS() && abstractC0157mByQM1414dm.m1683HGpJ()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: SmIWf */
    public boolean m1462SmIWf() {
        return !this.f1579Ucbh || this.f1603mByQ || this.f1565KLFTb.m2016qGY();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* renamed from: SwgkN */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC0157mByQ m1463SwgkN(int i, boolean z) {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        AbstractC0157mByQ abstractC0157mByQ = null;
        for (int i2 = 0; i2 < iM1166Dt; i2++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i2));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1692Ucbh()) {
                if (z) {
                    if (abstractC0157mByQM1414dm.f1704wA != i) {
                        continue;
                    } else {
                        if (!this.f1561JHa.m1174YoKzxo(abstractC0157mByQM1414dm.f1700mjFkc)) {
                            return abstractC0157mByQM1414dm;
                        }
                        abstractC0157mByQ = abstractC0157mByQM1414dm;
                    }
                } else if (abstractC0157mByQM1414dm.m1688MiMN() != i) {
                    continue;
                }
            }
        }
        return abstractC0157mByQ;
    }

    /* renamed from: Ucbh */
    public int m1464Ucbh(int i) {
        return m1499huTpC(i, this.f1566KLMXS, this.f1592cMLeY, getWidth());
    }

    /* renamed from: VA */
    public void m1465VA(AbstractC0151diqgf abstractC0151diqgf) {
        if (this.f1549ANMGZc == null) {
            this.f1549ANMGZc = new ArrayList();
        }
        this.f1549ANMGZc.add(abstractC0151diqgf);
    }

    /* renamed from: Vdz */
    public int m1466Vdz(AbstractC0157mByQ abstractC0157mByQ) {
        if (abstractC0157mByQ.m1706qGY(524) || !abstractC0157mByQ.m1691Pq()) {
            return -1;
        }
        return this.f1565KLFTb.m2005KLFTb(abstractC0157mByQ.f1704wA);
    }

    /* renamed from: VfB */
    public void m1467VfB(int i) {
        if (this.f1557HGpJ) {
            return;
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0159qGY.mo1357qGgY(this, this.f1581Vdz, i);
        }
    }

    /* renamed from: Vgyli */
    public void m1468Vgyli(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iM1166Dt = this.f1561JHa.m1166Dt();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < iM1166Dt; i7++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i7));
            if (abstractC0157mByQM1414dm != null && (i6 = abstractC0157mByQM1414dm.f1704wA) >= i4 && i6 <= i3) {
                if (f1536LREOK) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i7 + " holder " + abstractC0157mByQM1414dm);
                }
                if (abstractC0157mByQM1414dm.f1704wA == i) {
                    abstractC0157mByQM1414dm.m1694VocHEe(i2 - i, false);
                } else {
                    abstractC0157mByQM1414dm.m1694VocHEe(i5, false);
                }
                this.f1581Vdz.f1665xJ = true;
            }
        }
        this.f1617wA.m1607huTpC(i, i2);
        requestLayout();
    }

    /* renamed from: Vnb */
    public void m1469Vnb() {
        int i;
        for (int size = this.f1575Qr.size() - 1; size >= 0; size--) {
            AbstractC0157mByQ abstractC0157mByQ = (AbstractC0157mByQ) this.f1575Qr.get(size);
            if (abstractC0157mByQ.f1700mjFkc.getParent() == this && !abstractC0157mByQ.m1687KLMXS() && (i = abstractC0157mByQ.f1698fehf) != -1) {
                AbstractC2876T9.m10244NKyg(abstractC0157mByQ.f1700mjFkc, i);
                abstractC0157mByQ.f1698fehf = -1;
            }
        }
        this.f1575Qr.clear();
    }

    /* renamed from: VocHEe */
    public void m1470VocHEe(int i, int i2) {
        setMeasuredDimension(AbstractC0159qGY.m1717rkYL(i, getPaddingLeft() + getPaddingRight(), AbstractC2876T9.m10230HGpJ(this)), AbstractC0159qGY.m1717rkYL(i2, getPaddingTop() + getPaddingBottom(), AbstractC2876T9.m10229Gd(this)));
    }

    /* renamed from: Vu */
    public boolean m1471Vu(AbstractC0157mByQ abstractC0157mByQ, int i) {
        if (!m1495gYa()) {
            AbstractC2876T9.m10244NKyg(abstractC0157mByQ.f1700mjFkc, i);
            return true;
        }
        abstractC0157mByQ.f1698fehf = i;
        this.f1575Qr.add(abstractC0157mByQ);
        return false;
    }

    /* renamed from: WGXroI */
    public final View m1472WGXroI() {
        AbstractC0157mByQ abstractC0157mByQM1477XV;
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        int i = c0148VocHEe.f1654MiMN;
        if (i == -1) {
            i = 0;
        }
        int iM1624AZxh = c0148VocHEe.m1624AZxh();
        for (int i2 = i; i2 < iM1624AZxh; i2++) {
            AbstractC0157mByQ abstractC0157mByQM1477XV2 = m1477XV(i2);
            if (abstractC0157mByQM1477XV2 == null) {
                break;
            }
            if (abstractC0157mByQM1477XV2.f1700mjFkc.hasFocusable()) {
                return abstractC0157mByQM1477XV2.f1700mjFkc;
            }
        }
        int iMin = Math.min(iM1624AZxh, i);
        do {
            iMin--;
            if (iMin < 0 || (abstractC0157mByQM1477XV = m1477XV(iMin)) == null) {
                return null;
            }
        } while (!abstractC0157mByQM1477XV.f1700mjFkc.hasFocusable());
        return abstractC0157mByQM1477XV.f1700mjFkc;
    }

    /* renamed from: WrLQs */
    public void m1473WrLQs() {
        if (this.f1624zvd != null) {
            return;
        }
        EdgeEffect edgeEffectMo1542mjFkc = this.f1621xrEuO.mo1542mjFkc(this, 1);
        this.f1624zvd = edgeEffectMo1542mjFkc;
        if (this.f1602lgHUyS) {
            edgeEffectMo1542mjFkc.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectMo1542mjFkc.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: XD */
    public void m1474XD() {
        this.f1572Ne++;
    }

    /* renamed from: XDdeP */
    public final void m1475XDdeP() {
        boolean z;
        if (this.f1603mByQ) {
            this.f1565KLFTb.m2013eyqo();
            if (this.f1573OjSQV) {
                this.f1587YoKzxo.mo1233FbxKQm(this);
            }
        }
        if (m1520rdJr()) {
            this.f1565KLFTb.m2007Pq();
        } else {
            this.f1565KLFTb.m2001Dt();
        }
        boolean z2 = this.f1589alEkx || this.f1594dm;
        this.f1581Vdz.f1651ETF = this.f1579Ucbh && this.f1582Vnb != null && ((z = this.f1603mByQ) || z2 || this.f1587YoKzxo.f1718lgHUyS) && (!z || this.f1568MiMN.m1668lgHUyS());
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        c0148VocHEe.f1655VA = c0148VocHEe.f1651ETF && z2 && !this.f1603mByQ && m1520rdJr();
    }

    /* renamed from: XFUzSY */
    public void m1476XFUzSY() {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i = 0; i < iM1166Dt; i++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1687KLMXS()) {
                abstractC0157mByQM1414dm.m1677AZxh(6);
            }
        }
        m1478XbiWeM();
        this.f1617wA.m1604diqgf();
    }

    /* renamed from: XV */
    public AbstractC0157mByQ m1477XV(int i) {
        AbstractC0157mByQ abstractC0157mByQ = null;
        if (this.f1603mByQ) {
            return null;
        }
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i2 = 0; i2 < iM1166Dt; i2++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i2));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1692Ucbh() && m1466Vdz(abstractC0157mByQM1414dm) == i) {
                if (!this.f1561JHa.m1174YoKzxo(abstractC0157mByQM1414dm.f1700mjFkc)) {
                    return abstractC0157mByQM1414dm;
                }
                abstractC0157mByQ = abstractC0157mByQM1414dm;
            }
        }
        return abstractC0157mByQ;
    }

    /* renamed from: XbiWeM */
    public void m1478XbiWeM() {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i = 0; i < iM1166Dt; i++) {
            ((C0153fehf) this.f1561JHa.m1181qdMbNW(i).getLayoutParams()).f1678wA = true;
        }
        this.f1617wA.m1595Pq();
    }

    /* renamed from: XgAT */
    public final void m1479XgAT() {
        View viewFindViewById;
        if (!this.f1586XV || this.f1568MiMN == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f1537Vgyli || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f1561JHa.m1174YoKzxo(focusedChild)) {
                    return;
                }
            } else if (this.f1561JHa.m1184xJ() == 0) {
                requestFocus();
                return;
            }
        }
        View viewM1472WGXroI = null;
        AbstractC0157mByQ abstractC0157mByQM1486bbzow = (this.f1581Vdz.f1656YoKzxo == -1 || !this.f1568MiMN.m1668lgHUyS()) ? null : m1486bbzow(this.f1581Vdz.f1656YoKzxo);
        if (abstractC0157mByQM1486bbzow != null && !this.f1561JHa.m1174YoKzxo(abstractC0157mByQM1486bbzow.f1700mjFkc) && abstractC0157mByQM1486bbzow.f1700mjFkc.hasFocusable()) {
            viewM1472WGXroI = abstractC0157mByQM1486bbzow.f1700mjFkc;
        } else if (this.f1561JHa.m1184xJ() > 0) {
            viewM1472WGXroI = m1472WGXroI();
        }
        if (viewM1472WGXroI != null) {
            int i = this.f1581Vdz.f1663rkYL;
            if (i != -1 && (viewFindViewById = viewM1472WGXroI.findViewById(i)) != null && viewFindViewById.isFocusable()) {
                viewM1472WGXroI = viewFindViewById;
            }
            viewM1472WGXroI.requestFocus();
        }
    }

    /* renamed from: XtE */
    public final void m1480XtE(int i, int i2, MotionEvent motionEvent, int i3) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1557HGpJ) {
            return;
        }
        int[] iArr = this.f1576SOS;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zMo1335VA = abstractC0159qGY.mo1335VA();
        boolean zMo1322MiMN = this.f1587YoKzxo.mo1322MiMN();
        int i4 = zMo1322MiMN ? (zMo1335VA ? 1 : 0) | 2 : zMo1335VA ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iM1524tAfC = i - m1524tAfC(i, height);
        int iM1413dGDT = i2 - m1413dGDT(i2, width);
        m1422BxruE(i4, i3);
        if (m1443KLMXS(zMo1335VA ? iM1524tAfC : 0, zMo1322MiMN ? iM1413dGDT : 0, this.f1576SOS, this.f1569Moer, i3)) {
            int[] iArr2 = this.f1576SOS;
            iM1524tAfC -= iArr2[0];
            iM1413dGDT -= iArr2[1];
        }
        m1539ybBTr(zMo1335VA ? iM1524tAfC : 0, zMo1322MiMN ? iM1413dGDT : 0, motionEvent, i3);
        RunnableC0129KLFTb runnableC0129KLFTb = this.f1578SwgkN;
        if (runnableC0129KLFTb != null && (iM1524tAfC != 0 || iM1413dGDT != 0)) {
            runnableC0129KLFTb.m1290JHa(this, iM1524tAfC, iM1413dGDT);
        }
        m1448LsBneK(i3);
    }

    /* renamed from: Xxz */
    public void m1481Xxz() {
        AbstractC0144MiMN abstractC0144MiMN = this.f1582Vnb;
        if (abstractC0144MiMN != null) {
            abstractC0144MiMN.mo1559ETF();
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.m1797sqndV(this.f1617wA);
            this.f1587YoKzxo.m1793oaI(this.f1617wA);
        }
        this.f1617wA.m1619wA();
    }

    /* renamed from: YoKzxo */
    public final void m1482YoKzxo(AbstractC0157mByQ abstractC0157mByQ, AbstractC0157mByQ abstractC0157mByQ2, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2, boolean z, boolean z2) {
        abstractC0157mByQ.m1689Ne(false);
        if (z) {
            m1507lgHUyS(abstractC0157mByQ);
        }
        if (abstractC0157mByQ != abstractC0157mByQ2) {
            if (z2) {
                m1507lgHUyS(abstractC0157mByQ2);
            }
            abstractC0157mByQ.f1699lgHUyS = abstractC0157mByQ2;
            m1507lgHUyS(abstractC0157mByQ);
            this.f1617wA.m1592NPj(abstractC0157mByQ);
            abstractC0157mByQ2.m1689Ne(false);
            abstractC0157mByQ2.f1702qdMbNW = abstractC0157mByQ;
        }
        if (this.f1582Vnb.mo1381AZxh(abstractC0157mByQ, abstractC0157mByQ2, aZxh, aZxh2)) {
            m1460SKTn();
        }
    }

    /* renamed from: Zdbk */
    public boolean m1483Zdbk(View view) {
        m1433Htq();
        boolean zM1168IEE = this.f1561JHa.m1168IEE(view);
        if (zM1168IEE) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(view);
            this.f1617wA.m1592NPj(abstractC0157mByQM1414dm);
            this.f1617wA.m1582CqaNbM(abstractC0157mByQM1414dm);
            if (f1536LREOK) {
                Log.d("RecyclerView", "after removing animated view: " + view + ", " + this);
            }
        }
        m1457QyqF(!zM1168IEE);
        return zM1168IEE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null || !abstractC0159qGY.m1787lti(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* renamed from: alEkx */
    public AbstractC0157mByQ m1484alEkx(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return m1414dm(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* renamed from: aqHPIZ */
    public void m1485aqHPIZ() {
        if (this.f1592cMLeY != null) {
            return;
        }
        EdgeEffect edgeEffectMo1542mjFkc = this.f1621xrEuO.mo1542mjFkc(this, 2);
        this.f1592cMLeY = edgeEffectMo1542mjFkc;
        if (this.f1602lgHUyS) {
            edgeEffectMo1542mjFkc.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectMo1542mjFkc.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: bbzow */
    public AbstractC0157mByQ m1486bbzow(long j) {
        AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1568MiMN;
        AbstractC0157mByQ abstractC0157mByQ = null;
        if (abstractC0156lgHUyS != null && abstractC0156lgHUyS.m1668lgHUyS()) {
            int iM1166Dt = this.f1561JHa.m1166Dt();
            for (int i = 0; i < iM1166Dt; i++) {
                AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i));
                if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1692Ucbh() && abstractC0157mByQM1414dm.m1681ETF() == j) {
                    if (!this.f1561JHa.m1174YoKzxo(abstractC0157mByQM1414dm.f1700mjFkc)) {
                        return abstractC0157mByQM1414dm;
                    }
                    abstractC0157mByQ = abstractC0157mByQM1414dm;
                }
            }
        }
        return abstractC0157mByQ;
    }

    /* renamed from: cMLeY */
    public void m1487cMLeY(int i) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.mo1750NV(i);
        }
        m1500hvGY(i);
        AbstractC0151diqgf abstractC0151diqgf = this.f1599jm;
        if (abstractC0151diqgf != null) {
            abstractC0151diqgf.mo1636mjFkc(this, i);
        }
        List list = this.f1549ANMGZc;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((AbstractC0151diqgf) this.f1549ANMGZc.get(size)).mo1636mjFkc(this, i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0153fehf) && this.f1587YoKzxo.mo1246YoKzxo((C0153fehf) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1335VA()) {
            return this.f1587YoKzxo.mo1315IEE(this.f1581Vdz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1335VA()) {
            return this.f1587YoKzxo.mo1240Pq(this.f1581Vdz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1335VA()) {
            return this.f1587YoKzxo.mo1249diqgf(this.f1581Vdz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1322MiMN()) {
            return this.f1587YoKzxo.mo1344eyqo(this.f1581Vdz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1322MiMN()) {
            return this.f1587YoKzxo.mo1243Ucbh(this.f1581Vdz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null && abstractC0159qGY.mo1322MiMN()) {
            return this.f1587YoKzxo.mo1256huTpC(this.f1581Vdz);
        }
        return 0;
    }

    /* renamed from: diqgf */
    public void m1488diqgf() {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i = 0; i < iM1166Dt; i++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i));
            if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                abstractC0157mByQM1414dm.m1710wA();
            }
        }
        this.f1617wA.m1601ZfxDd();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m7964mjFkc(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m7952AZxh(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m7968wA(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m7956JHa(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* renamed from: dkKKW */
    public void m1489dkKKW() {
        AbstractC0157mByQ abstractC0157mByQ;
        int iM1184xJ = this.f1561JHa.m1184xJ();
        for (int i = 0; i < iM1184xJ; i++) {
            View viewM1169JHa = this.f1561JHa.m1169JHa(i);
            AbstractC0157mByQ abstractC0157mByQM1484alEkx = m1484alEkx(viewM1169JHa);
            if (abstractC0157mByQM1484alEkx != null && (abstractC0157mByQ = abstractC0157mByQM1484alEkx.f1702qdMbNW) != null) {
                View view = abstractC0157mByQ.f1700mjFkc;
                int left = viewM1169JHa.getLeft();
                int top = viewM1169JHa.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.f1607qGY.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((AbstractC0161rkYL) this.f1607qGY.get(i)).mo1828qdMbNW(canvas, this, this.f1581Vdz);
        }
        EdgeEffect edgeEffect = this.f1566KLMXS;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f1602lgHUyS ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f1566KLMXS;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f1624zvd;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f1602lgHUyS) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1624zvd;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f1592cMLeY;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1602lgHUyS ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f1592cMLeY;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f1609rWxwaT;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1602lgHUyS) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1609rWxwaT;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.f1582Vnb == null || this.f1607qGY.size() <= 0 || !this.f1582Vnb.mo1570qGY()) ? z : true) {
            AbstractC2876T9.m10283nxI(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: eQ */
    public void m1490eQ(boolean z) {
        this.f1573OjSQV = z | this.f1573OjSQV;
        this.f1603mByQ = true;
        m1476XFUzSY();
    }

    /* renamed from: eyqo */
    public void m1491eyqo(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1566KLMXS;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.f1566KLMXS.onRelease();
            zIsFinished = this.f1566KLMXS.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1592cMLeY;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f1592cMLeY.onRelease();
            zIsFinished |= this.f1592cMLeY.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1624zvd;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.f1624zvd.onRelease();
            zIsFinished |= this.f1624zvd.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1609rWxwaT;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f1609rWxwaT.onRelease();
            zIsFinished |= this.f1609rWxwaT.isFinished();
        }
        if (zIsFinished) {
            AbstractC2876T9.m10283nxI(this);
        }
    }

    /* renamed from: fFz */
    public void m1492fFz(int i) {
        if (this.f1587YoKzxo == null) {
            return;
        }
        setScrollState(2);
        this.f1587YoKzxo.mo1331Tw(i);
        awakenScrollBars();
    }

    /* renamed from: fLidf */
    public final void m1493fLidf(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1615vadzgd) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1615vadzgd = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f1567KRTLGT = x;
            this.f1590aqHPIZ = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f1555GMIER = y;
            this.f1585WrLQs = y;
        }
    }

    /* renamed from: fehf */
    public boolean m1494fehf(AbstractC0157mByQ abstractC0157mByQ) {
        AbstractC0144MiMN abstractC0144MiMN = this.f1582Vnb;
        return abstractC0144MiMN == null || abstractC0144MiMN.mo1573xJ(abstractC0157mByQ, abstractC0157mByQ.m1708rkYL());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewMo1255gtr;
        boolean z;
        View viewM1766XDdeP = this.f1587YoKzxo.m1766XDdeP(view, i);
        if (viewM1766XDdeP != null) {
            return viewM1766XDdeP;
        }
        boolean z2 = (this.f1568MiMN == null || this.f1587YoKzxo == null || m1495gYa() || this.f1557HGpJ) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.f1587YoKzxo.mo1322MiMN()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (f1547tISON) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f1587YoKzxo.mo1335VA()) {
                int i3 = (this.f1587YoKzxo.m1764WGXroI() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (f1547tISON) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                m1432HGpJ();
                if (m1528uHVRx(view) == null) {
                    return null;
                }
                m1433Htq();
                this.f1587YoKzxo.mo1255gtr(view, i, this.f1617wA, this.f1581Vdz);
                m1457QyqF(false);
            }
            viewMo1255gtr = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                m1432HGpJ();
                if (m1528uHVRx(view) == null) {
                    return null;
                }
                m1433Htq();
                viewMo1255gtr = this.f1587YoKzxo.mo1255gtr(view, i, this.f1617wA, this.f1581Vdz);
                m1457QyqF(false);
            } else {
                viewMo1255gtr = viewFindNextFocus;
            }
        }
        if (viewMo1255gtr == null || viewMo1255gtr.hasFocusable()) {
            return m1446LREOK(view, viewMo1255gtr, i) ? viewMo1255gtr : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        m1453NV(viewMo1255gtr, null);
        return view;
    }

    /* renamed from: gYa */
    public boolean m1495gYa() {
        return this.f1572Ne > 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            return abstractC0159qGY.mo1263mByQ();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m1444KRTLGT());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            return abstractC0159qGY.mo1239OjSQV(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m1444KRTLGT());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public AbstractC0156lgHUyS getAdapter() {
        return this.f1568MiMN;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        return abstractC0159qGY != null ? abstractC0159qGY.m1723CqaNbM() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1602lgHUyS;
    }

    public C0124ETF getCompatAccessibilityDelegate() {
        return this.f1616vjlshU;
    }

    public C0147VA getEdgeEffectFactory() {
        return this.f1621xrEuO;
    }

    public AbstractC0144MiMN getItemAnimator() {
        return this.f1582Vnb;
    }

    public int getItemDecorationCount() {
        return this.f1607qGY.size();
    }

    public AbstractC0159qGY getLayoutManager() {
        return this.f1587YoKzxo;
    }

    public int getMaxFlingVelocity() {
        return this.f1564JrJO;
    }

    public int getMinFlingVelocity() {
        return this.f1562JYgkl;
    }

    public long getNanoTime() {
        if (f1548uH) {
            return System.nanoTime();
        }
        return 0L;
    }

    public AbstractC0141IEE getOnFlingListener() {
        return this.f1563JYn;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1586XV;
    }

    public C0152eyqo getRecycledViewPool() {
        return this.f1617wA.m1614qdMbNW();
    }

    public int getScrollState() {
        return this.f1571NPj;
    }

    /* renamed from: giT */
    public void m1496giT(View view) {
    }

    /* renamed from: gtIJp */
    public final void m1497gtIJp() {
        this.f1561JHa = new C0122AZxh(new C0143KLFTb());
    }

    /* renamed from: gtr */
    public void m1498gtr() {
        m1425Dp(true);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m7953Dt();
    }

    /* renamed from: huTpC */
    public final int m1499huTpC(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && AbstractC2967UXIO.m10508AZxh(edgeEffect) != 0.0f) {
            int iRound = Math.round(((-i2) / 4.0f) * AbstractC2967UXIO.m10509ZfxDd(edgeEffect, ((-i) * 4.0f) / i2, 0.5f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || AbstractC2967UXIO.m10508AZxh(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int iRound2 = Math.round((f / 4.0f) * AbstractC2967UXIO.m10509ZfxDd(edgeEffect2, (i * 4.0f) / f, 0.5f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    /* renamed from: hvGY */
    public void m1500hvGY(int i) {
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f1574Pq;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f1557HGpJ;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m7959VA();
    }

    /* renamed from: jm */
    public long m1501jm(AbstractC0157mByQ abstractC0157mByQ) {
        return this.f1568MiMN.m1668lgHUyS() ? abstractC0157mByQ.m1681ETF() : abstractC0157mByQ.f1704wA;
    }

    /* renamed from: jtz */
    public void m1502jtz(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh) {
        abstractC0157mByQ.m1690OjSQV(0, 8192);
        if (this.f1581Vdz.f1662qdMbNW && abstractC0157mByQ.m1683HGpJ() && !abstractC0157mByQ.m1692Ucbh() && !abstractC0157mByQ.m1687KLMXS()) {
            this.f1619xJ.m2038wA(m1501jm(abstractC0157mByQ), abstractC0157mByQ);
        }
        this.f1619xJ.m2027KLFTb(abstractC0157mByQ, aZxh);
    }

    /* renamed from: jx */
    public void m1503jx(int i) {
        int iM1184xJ = this.f1561JHa.m1184xJ();
        for (int i2 = 0; i2 < iM1184xJ; i2++) {
            this.f1561JHa.m1169JHa(i2).offsetLeftAndRight(i);
        }
    }

    /* renamed from: kism */
    public void m1504kism(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new C0174ZfxDd(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(AbstractC4125m4.f14861mjFkc), resources.getDimensionPixelSize(AbstractC4125m4.f14862wA), resources.getDimensionPixelOffset(AbstractC4125m4.f14860AZxh));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + m1444KRTLGT());
        }
    }

    /* renamed from: knzZ */
    public void m1505knzZ() {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i = 0; i < iM1166Dt; i++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i));
            if (f1542gYa && abstractC0157mByQM1414dm.f1704wA == -1 && !abstractC0157mByQM1414dm.m1692Ucbh()) {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + m1444KRTLGT());
            }
            if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                abstractC0157mByQM1414dm.m1704mByQ();
            }
        }
    }

    /* renamed from: lB */
    public void m1506lB(View view) {
        int size;
        AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(view);
        m1496giT(view);
        AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1568MiMN;
        if (abstractC0156lgHUyS != null && abstractC0157mByQM1414dm != null) {
            abstractC0156lgHUyS.m1672rkYL(abstractC0157mByQM1414dm);
        }
        if (this.f1618wJVbdd == null || r2.size() - 1 < 0) {
            return;
        }
        AbstractC4793w7.m13819mjFkc(this.f1618wJVbdd.get(size));
        throw null;
    }

    /* renamed from: lgHUyS */
    public final void m1507lgHUyS(AbstractC0157mByQ abstractC0157mByQ) {
        View view = abstractC0157mByQ.f1700mjFkc;
        boolean z = view.getParent() == this;
        this.f1617wA.m1592NPj(m1484alEkx(view));
        if (abstractC0157mByQ.m1682Gd()) {
            this.f1561JHa.m1183wA(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f1561JHa.m1167ETF(view);
        } else {
            this.f1561JHa.m1165AZxh(view, true);
        }
    }

    /* renamed from: lti */
    public void m1508lti(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i4 = 0; i4 < iM1166Dt; i4++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i4));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1687KLMXS()) {
                int i5 = abstractC0157mByQM1414dm.f1704wA;
                if (i5 >= i3) {
                    if (f1536LREOK) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + abstractC0157mByQM1414dm + " now at position " + (abstractC0157mByQM1414dm.f1704wA - i2));
                    }
                    abstractC0157mByQM1414dm.m1694VocHEe(-i2, z);
                    this.f1581Vdz.f1665xJ = true;
                } else if (i5 >= i) {
                    if (f1536LREOK) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + abstractC0157mByQM1414dm + " now REMOVED");
                    }
                    abstractC0157mByQM1414dm.m1707qdMbNW(i - 1, -i2, z);
                    this.f1581Vdz.f1665xJ = true;
                }
            }
        }
        this.f1617wA.m1585Gd(i, i2, z);
        requestLayout();
    }

    /* renamed from: mByQ */
    public final void m1509mByQ() {
        int i = this.f1583VocHEe;
        this.f1583VocHEe = 0;
        if (i == 0 || !m1538yX()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC3253YoKzxo.m11134AZxh(accessibilityEventObtain, i);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    /* renamed from: mPWV */
    public void m1510mPWV(AbstractC0151diqgf abstractC0151diqgf) {
        List list = this.f1549ANMGZc;
        if (list != null) {
            list.remove(abstractC0151diqgf);
        }
    }

    /* renamed from: mjFkc */
    public void m1511mjFkc(int i, int i2) {
        if (i < 0) {
            m1514oCFDzJ();
            if (this.f1566KLMXS.isFinished()) {
                this.f1566KLMXS.onAbsorb(-i);
            }
        } else if (i > 0) {
            m1485aqHPIZ();
            if (this.f1592cMLeY.isFinished()) {
                this.f1592cMLeY.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            m1473WrLQs();
            if (this.f1624zvd.isFinished()) {
                this.f1624zvd.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            m1532vadzgd();
            if (this.f1609rWxwaT.isFinished()) {
                this.f1609rWxwaT.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        AbstractC2876T9.m10283nxI(this);
    }

    /* renamed from: mzUGzO */
    public void m1512mzUGzO(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1557HGpJ) {
            return;
        }
        if (!abstractC0159qGY.mo1335VA()) {
            i = 0;
        }
        if (!this.f1587YoKzxo.mo1322MiMN()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (i3 != Integer.MIN_VALUE && i3 <= 0) {
            scrollBy(i, i2);
            return;
        }
        if (z) {
            int i4 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i4 |= 2;
            }
            m1422BxruE(i4, 1);
        }
        this.f1591bbzow.m1854KLFTb(i, i2, i3, interpolator);
    }

    /* renamed from: nUaNy */
    public void m1513nUaNy() {
        setScrollState(0);
        m1529ub();
    }

    /* renamed from: oCFDzJ */
    public void m1514oCFDzJ() {
        if (this.f1566KLMXS != null) {
            return;
        }
        EdgeEffect edgeEffectMo1542mjFkc = this.f1621xrEuO.mo1542mjFkc(this, 0);
        this.f1566KLMXS = edgeEffectMo1542mjFkc;
        if (this.f1602lgHUyS) {
            edgeEffectMo1542mjFkc.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectMo1542mjFkc.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: oVXlhB */
    public boolean m1515oVXlhB(AccessibilityEvent accessibilityEvent) {
        if (!m1495gYa()) {
            return false;
        }
        int iM11135mjFkc = accessibilityEvent != null ? AbstractC3253YoKzxo.m11135mjFkc(accessibilityEvent) : 0;
        this.f1583VocHEe |= iM11135mjFkc != 0 ? iM11135mjFkc : 0;
        return true;
    }

    /* renamed from: oaI */
    public void m1516oaI(int i) {
        if (this.f1557HGpJ) {
            return;
        }
        m1513nUaNy();
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0159qGY.mo1331Tw(i);
            awakenScrollBars();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.f1572Ne = 0;
        this.f1574Pq = true;
        this.f1579Ucbh = this.f1579Ucbh && !isLayoutRequested();
        this.f1617wA.m1617vI();
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.m1762VocHEe(this);
        }
        this.f1623yfx = false;
        if (f1548uH) {
            ThreadLocal threadLocal = RunnableC0129KLFTb.f1479KLFTb;
            RunnableC0129KLFTb runnableC0129KLFTb = (RunnableC0129KLFTb) threadLocal.get();
            this.f1578SwgkN = runnableC0129KLFTb;
            if (runnableC0129KLFTb == null) {
                this.f1578SwgkN = new RunnableC0129KLFTb();
                Display displayM10273fehf = AbstractC2876T9.m10273fehf(this);
                if (isInEditMode() || displayM10273fehf == null) {
                    refreshRate = 60.0f;
                    RunnableC0129KLFTb runnableC0129KLFTb2 = this.f1578SwgkN;
                    runnableC0129KLFTb2.f1483wA = (long) (1.0E9f / refreshRate);
                    threadLocal.set(runnableC0129KLFTb2);
                } else {
                    refreshRate = displayM10273fehf.getRefreshRate();
                    if (refreshRate < 30.0f) {
                    }
                    RunnableC0129KLFTb runnableC0129KLFTb22 = this.f1578SwgkN;
                    runnableC0129KLFTb22.f1483wA = (long) (1.0E9f / refreshRate);
                    threadLocal.set(runnableC0129KLFTb22);
                }
            }
            this.f1578SwgkN.m1293mjFkc(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        RunnableC0129KLFTb runnableC0129KLFTb;
        super.onDetachedFromWindow();
        AbstractC0144MiMN abstractC0144MiMN = this.f1582Vnb;
        if (abstractC0144MiMN != null) {
            abstractC0144MiMN.mo1559ETF();
        }
        m1513nUaNy();
        this.f1574Pq = false;
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.m1721BAnRFn(this, this.f1617wA);
        }
        this.f1575Qr.clear();
        removeCallbacks(this.f1570NKyg);
        this.f1619xJ.m2024Dt();
        this.f1617wA.m1599VocHEe();
        AbstractC4924y3.m13989AZxh(this);
        if (!f1548uH || (runnableC0129KLFTb = this.f1578SwgkN) == null) {
            return;
        }
        runnableC0129KLFTb.m1289Dt(this);
        this.f1578SwgkN = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1607qGY.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC0161rkYL) this.f1607qGY.get(i)).mo1829xJ(canvas, this, this.f1581Vdz);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.f1587YoKzxo != null && !this.f1557HGpJ && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.f1587YoKzxo.mo1322MiMN() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f1587YoKzxo.mo1335VA() ? motionEvent.getAxisValue(10) : 0.0f;
                if (f != 0.0f || axisValue != 0.0f) {
                    m1480XtE((int) (axisValue * this.f1605nxI), (int) (f * this.f1584WGXroI), motionEvent, 1);
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f1587YoKzxo.mo1322MiMN()) {
                    f = -axisValue2;
                    if (f != 0.0f) {
                        m1480XtE((int) (axisValue * this.f1605nxI), (int) (f * this.f1584WGXroI), motionEvent, 1);
                    }
                } else {
                    if (this.f1587YoKzxo.mo1335VA()) {
                        axisValue = axisValue2;
                        f = 0.0f;
                    } else {
                        f = 0.0f;
                        axisValue = 0.0f;
                    }
                    if (f != 0.0f) {
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f1557HGpJ) {
            return false;
        }
        this.f1558IEE = null;
        if (m1438JYgkl(motionEvent)) {
            m1434IEE();
            return true;
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            return false;
        }
        boolean zMo1335VA = abstractC0159qGY.mo1335VA();
        boolean zMo1322MiMN = this.f1587YoKzxo.mo1322MiMN();
        if (this.f1606oCFDzJ == null) {
            this.f1606oCFDzJ = VelocityTracker.obtain();
        }
        this.f1606oCFDzJ.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f1614vI) {
                this.f1614vI = false;
            }
            this.f1615vadzgd = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f1567KRTLGT = x;
            this.f1590aqHPIZ = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f1555GMIER = y;
            this.f1585WrLQs = y;
            if (m1411Tw(motionEvent) || this.f1571NPj == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                m1448LsBneK(1);
            }
            int[] iArr = this.f1577SmIWf;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zMo1335VA;
            if (zMo1322MiMN) {
                i = (zMo1335VA ? 1 : 0) | 2;
            }
            m1422BxruE(i, 0);
        } else if (actionMasked == 1) {
            this.f1606oCFDzJ.clear();
            m1448LsBneK(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1615vadzgd);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1615vadzgd + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f1571NPj != 1) {
                int i2 = x2 - this.f1590aqHPIZ;
                int i3 = y2 - this.f1585WrLQs;
                if (zMo1335VA == 0 || Math.abs(i2) <= this.f1613uHVRx) {
                    z = false;
                } else {
                    this.f1567KRTLGT = x2;
                    z = true;
                }
                if (zMo1322MiMN && Math.abs(i3) > this.f1613uHVRx) {
                    this.f1555GMIER = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            m1434IEE();
        } else if (actionMasked == 5) {
            this.f1615vadzgd = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f1567KRTLGT = x3;
            this.f1590aqHPIZ = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f1555GMIER = y3;
            this.f1585WrLQs = y3;
        } else if (actionMasked == 6) {
            m1493fLidf(motionEvent);
        }
        return this.f1571NPj == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AbstractC2352L8.m9358mjFkc("RV OnLayout");
        m1455OjSQV();
        AbstractC2352L8.m9357AZxh();
        this.f1579Ucbh = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            m1470VocHEe(i, i2);
            return;
        }
        boolean z = false;
        if (abstractC0159qGY.mo1350kism()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f1587YoKzxo.m1771Zdbk(this.f1617wA, this.f1581Vdz, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f1597gtIJp = z;
            if (z || this.f1568MiMN == null) {
                return;
            }
            if (this.f1581Vdz.f1653KLFTb == 1) {
                m1454Ne();
            }
            this.f1587YoKzxo.m1789nUaNy(i, i2);
            this.f1581Vdz.f1650Dt = true;
            m1424CqaNbM();
            this.f1587YoKzxo.m1776bc(i, i2);
            if (this.f1587YoKzxo.mo1360ui()) {
                this.f1587YoKzxo.m1789nUaNy(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f1581Vdz.f1650Dt = true;
                m1424CqaNbM();
                this.f1587YoKzxo.m1776bc(i, i2);
            }
            this.f1600kism = getMeasuredWidth();
            this.f1612tjSezt = getMeasuredHeight();
            return;
        }
        if (this.f1593diqgf) {
            this.f1587YoKzxo.m1771Zdbk(this.f1617wA, this.f1581Vdz, i, i2);
            return;
        }
        if (this.f1551BAnRFn) {
            m1433Htq();
            m1474XD();
            m1475XDdeP();
            m1498gtr();
            C0148VocHEe c0148VocHEe = this.f1581Vdz;
            if (c0148VocHEe.f1655VA) {
                c0148VocHEe.f1659lgHUyS = true;
            } else {
                this.f1565KLFTb.m2001Dt();
                this.f1581Vdz.f1659lgHUyS = false;
            }
            this.f1551BAnRFn = false;
            m1457QyqF(false);
        } else if (this.f1581Vdz.f1655VA) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1568MiMN;
        if (abstractC0156lgHUyS != null) {
            this.f1581Vdz.f1652JHa = abstractC0156lgHUyS.mo1665ZfxDd();
        } else {
            this.f1581Vdz.f1652JHa = 0;
        }
        m1433Htq();
        this.f1587YoKzxo.m1771Zdbk(this.f1617wA, this.f1581Vdz, i, i2);
        m1457QyqF(false);
        this.f1581Vdz.f1659lgHUyS = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (m1495gYa()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0140HGpJ)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0140HGpJ c0140HGpJ = (C0140HGpJ) parcelable;
        this.f1588ZfxDd = c0140HGpJ;
        super.onRestoreInstanceState(c0140HGpJ.m13824mjFkc());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0140HGpJ c0140HGpJ = new C0140HGpJ(super.onSaveInstanceState());
        C0140HGpJ c0140HGpJ2 = this.f1588ZfxDd;
        if (c0140HGpJ2 != null) {
            c0140HGpJ.m1543AZxh(c0140HGpJ2);
        } else {
            AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
            if (abstractC0159qGY != null) {
                c0140HGpJ.f1628wA = abstractC0159qGY.mo1343dkKKW();
            } else {
                c0140HGpJ.f1628wA = null;
            }
        }
        return c0140HGpJ;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        m1526tjSezt();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v37 int) = (r0v26 int), (r0v41 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f1557HGpJ || this.f1614vI) {
            return false;
        }
        if (m1452NPj(motionEvent)) {
            m1434IEE();
            return true;
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            return false;
        }
        boolean zMo1335VA = abstractC0159qGY.mo1335VA();
        boolean zMo1322MiMN = this.f1587YoKzxo.mo1322MiMN();
        if (this.f1606oCFDzJ == null) {
            this.f1606oCFDzJ = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.f1577SmIWf;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.f1577SmIWf;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.f1615vadzgd = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f1567KRTLGT = x;
            this.f1590aqHPIZ = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f1555GMIER = y;
            this.f1585WrLQs = y;
            int i = zMo1335VA;
            if (zMo1322MiMN) {
                i = (zMo1335VA ? 1 : 0) | 2;
            }
            m1422BxruE(i, 0);
        } else {
            if (actionMasked == 1) {
                this.f1606oCFDzJ.addMovement(motionEventObtain);
                this.f1606oCFDzJ.computeCurrentVelocity(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, this.f1564JrJO);
                float f = zMo1335VA != 0 ? -this.f1606oCFDzJ.getXVelocity(this.f1615vadzgd) : 0.0f;
                float f2 = zMo1322MiMN ? -this.f1606oCFDzJ.getYVelocity(this.f1615vadzgd) : 0.0f;
                if ((f == 0.0f && f2 == 0.0f) || !m1437JBhc((int) f, (int) f2)) {
                    setScrollState(0);
                }
                m1435IvRQOa();
                motionEventObtain.recycle();
                return true;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1615vadzgd);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1615vadzgd + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.f1567KRTLGT - x2;
                int iMax2 = this.f1555GMIER - y2;
                if (this.f1571NPj != 1) {
                    if (zMo1335VA == 0) {
                        z = false;
                        if (zMo1322MiMN) {
                            iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.f1613uHVRx) : Math.min(0, iMax2 + this.f1613uHVRx);
                            if (iMax2 != 0) {
                                z = true;
                            }
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    } else {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.f1613uHVRx) : Math.min(0, iMax + this.f1613uHVRx);
                        if (iMax != 0) {
                            z = true;
                        }
                        if (zMo1322MiMN) {
                        }
                        if (z) {
                        }
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                if (this.f1571NPj == 1) {
                    int[] iArr3 = this.f1576SOS;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    int iM1524tAfC = iMax - m1524tAfC(iMax, motionEvent.getY());
                    int iM1413dGDT = iMax2 - m1413dGDT(iMax2, motionEvent.getX());
                    if (m1443KLMXS(zMo1335VA != 0 ? iM1524tAfC : 0, zMo1322MiMN ? iM1413dGDT : 0, this.f1576SOS, this.f1569Moer, 0)) {
                        int[] iArr4 = this.f1576SOS;
                        iM1524tAfC -= iArr4[0];
                        iM1413dGDT -= iArr4[1];
                        int[] iArr5 = this.f1577SmIWf;
                        int i2 = iArr5[0];
                        int[] iArr6 = this.f1569Moer;
                        iArr5[0] = i2 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i3 = iM1413dGDT;
                    int[] iArr7 = this.f1569Moer;
                    this.f1567KRTLGT = x2 - iArr7[0];
                    this.f1555GMIER = y2 - iArr7[1];
                    if (m1539ybBTr(zMo1335VA != 0 ? iM1524tAfC : 0, zMo1322MiMN ? i3 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    RunnableC0129KLFTb runnableC0129KLFTb = this.f1578SwgkN;
                    if (runnableC0129KLFTb != null && (iM1524tAfC != 0 || i3 != 0)) {
                        runnableC0129KLFTb.m1290JHa(this, iM1524tAfC, i3);
                    }
                }
            } else if (actionMasked == 3) {
                m1434IEE();
            } else if (actionMasked == 5) {
                this.f1615vadzgd = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f1567KRTLGT = x3;
                this.f1590aqHPIZ = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f1555GMIER = y3;
                this.f1585WrLQs = y3;
            } else if (actionMasked == 6) {
                m1493fLidf(motionEvent);
            }
        }
        this.f1606oCFDzJ.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    /* renamed from: qGY */
    public void m1517qGY(String str) {
        if (m1495gYa()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + m1444KRTLGT());
        }
        if (this.f1552CqaNbM > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.f24315FLAVOR + m1444KRTLGT()));
        }
    }

    /* renamed from: qdMbNW */
    public void m1518qdMbNW(AbstractC0161rkYL abstractC0161rkYL) {
        m1426Dt(abstractC0161rkYL, -1);
    }

    /* renamed from: rWxwaT */
    public void m1519rWxwaT(int i, int i2) {
        this.f1552CqaNbM++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        m1459Rc(i, i2);
        AbstractC0151diqgf abstractC0151diqgf = this.f1599jm;
        if (abstractC0151diqgf != null) {
            abstractC0151diqgf.mo1635AZxh(this, i, i2);
        }
        List list = this.f1549ANMGZc;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((AbstractC0151diqgf) this.f1549ANMGZc.get(size)).mo1635AZxh(this, i, i2);
            }
        }
        this.f1552CqaNbM--;
    }

    /* renamed from: rdJr */
    public final boolean m1520rdJr() {
        return this.f1582Vnb != null && this.f1587YoKzxo.mo1231ERt();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(view);
        if (abstractC0157mByQM1414dm != null) {
            if (abstractC0157mByQM1414dm.m1682Gd()) {
                abstractC0157mByQM1414dm.m1685JHa();
            } else if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + abstractC0157mByQM1414dm + m1444KRTLGT());
            }
        } else if (f1542gYa) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + m1444KRTLGT());
        }
        view.clearAnimation();
        m1534wJVbdd(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1587YoKzxo.m1745KRckQg(this, this.f1581Vdz, view, view2) && view2 != null) {
            m1453NV(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f1587YoKzxo.m1746LeWm(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f1596fehf.size();
        for (int i = 0; i < size; i++) {
            ((InterfaceC0145Pq) this.f1596fehf.get(i)).mo1579wA(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f1598huTpC != 0 || this.f1557HGpJ) {
            this.f1556Gd = true;
        } else {
            super.requestLayout();
        }
    }

    /* renamed from: rkYL */
    public void m1521rkYL(AbstractC0157mByQ abstractC0157mByQ, AbstractC0144MiMN.AZxh aZxh, AbstractC0144MiMN.AZxh aZxh2) {
        m1507lgHUyS(abstractC0157mByQ);
        abstractC0157mByQ.m1689Ne(false);
        if (this.f1582Vnb.mo1402wA(abstractC0157mByQ, aZxh, aZxh2)) {
            m1460SKTn();
        }
    }

    /* renamed from: sRqPfw */
    public void m1522sRqPfw(View view) {
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1557HGpJ) {
            return;
        }
        boolean zMo1335VA = abstractC0159qGY.mo1335VA();
        boolean zMo1322MiMN = this.f1587YoKzxo.mo1322MiMN();
        if (zMo1335VA || zMo1322MiMN) {
            if (!zMo1335VA) {
                i = 0;
            }
            if (!zMo1322MiMN) {
                i2 = 0;
            }
            m1539ybBTr(i, i2, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (m1515oVXlhB(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C0124ETF c0124etf) {
        this.f1616vjlshU = c0124etf;
        AbstractC2876T9.m10265alEkx(this, c0124etf);
    }

    public void setAdapter(AbstractC0156lgHUyS abstractC0156lgHUyS) {
        setLayoutFrozen(false);
        m1458RWyiuY(abstractC0156lgHUyS, false, true);
        m1490eQ(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0138ETF interfaceC0138ETF) {
        if (interfaceC0138ETF == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f1602lgHUyS) {
            m1526tjSezt();
        }
        this.f1602lgHUyS = z;
        super.setClipToPadding(z);
        if (this.f1579Ucbh) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0147VA c0147va) {
        AbstractC2280K3.m9126xJ(c0147va);
        this.f1621xrEuO = c0147va;
        m1526tjSezt();
    }

    public void setHasFixedSize(boolean z) {
        this.f1593diqgf = z;
    }

    public void setItemAnimator(AbstractC0144MiMN abstractC0144MiMN) {
        AbstractC0144MiMN abstractC0144MiMN2 = this.f1582Vnb;
        if (abstractC0144MiMN2 != null) {
            abstractC0144MiMN2.mo1559ETF();
            this.f1582Vnb.m1563Ucbh(null);
        }
        this.f1582Vnb = abstractC0144MiMN;
        if (abstractC0144MiMN != null) {
            abstractC0144MiMN.m1563Ucbh(this.f1611tQ);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f1617wA.m1603cMLeY(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(AbstractC0159qGY abstractC0159qGY) {
        if (abstractC0159qGY == this.f1587YoKzxo) {
            return;
        }
        m1513nUaNy();
        if (this.f1587YoKzxo != null) {
            AbstractC0144MiMN abstractC0144MiMN = this.f1582Vnb;
            if (abstractC0144MiMN != null) {
                abstractC0144MiMN.mo1559ETF();
            }
            this.f1587YoKzxo.m1797sqndV(this.f1617wA);
            this.f1587YoKzxo.m1793oaI(this.f1617wA);
            this.f1617wA.m1619wA();
            if (this.f1574Pq) {
                this.f1587YoKzxo.m1721BAnRFn(this, this.f1617wA);
            }
            this.f1587YoKzxo.m1811wLtdyQ(null);
            this.f1587YoKzxo = null;
        } else {
            this.f1617wA.m1619wA();
        }
        this.f1561JHa.m1182rkYL();
        this.f1587YoKzxo = abstractC0159qGY;
        if (abstractC0159qGY != null) {
            if (abstractC0159qGY.f1707AZxh != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0159qGY + " is already attached to a RecyclerView:" + abstractC0159qGY.f1707AZxh.m1444KRTLGT());
            }
            abstractC0159qGY.m1811wLtdyQ(this);
            if (this.f1574Pq) {
                this.f1587YoKzxo.m1762VocHEe(this);
            }
        }
        this.f1617wA.m1618vadzgd();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m7958MiMN(z);
    }

    public void setOnFlingListener(AbstractC0141IEE abstractC0141IEE) {
        this.f1563JYn = abstractC0141IEE;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0151diqgf abstractC0151diqgf) {
        this.f1599jm = abstractC0151diqgf;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f1586XV = z;
    }

    public void setRecycledViewPool(C0152eyqo c0152eyqo) {
        this.f1617wA.m1590KLMXS(c0152eyqo);
    }

    @Deprecated
    public void setRecyclerListener(InterfaceC0154huTpC interfaceC0154huTpC) {
    }

    public void setScrollState(int i) {
        if (i == this.f1571NPj) {
            return;
        }
        if (f1536LREOK) {
            Log.d("RecyclerView", "setting scroll state to " + i + " from " + this.f1571NPj, new Exception());
        }
        this.f1571NPj = i;
        if (i != 2) {
            m1529ub();
        }
        m1487cMLeY(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.f1613uHVRx = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.f1613uHVRx = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0155lB abstractC0155lB) {
        this.f1617wA.m1623zvd(abstractC0155lB);
    }

    /* renamed from: sqndV */
    public void m1523sqndV(int i, int i2, int[] iArr) {
        m1433Htq();
        m1474XD();
        AbstractC2352L8.m9358mjFkc("RV Scroll");
        m1430GMIER(this.f1581Vdz);
        int iMo1230BxruE = i != 0 ? this.f1587YoKzxo.mo1230BxruE(i, this.f1617wA, this.f1581Vdz) : 0;
        int iMo1241QyqF = i2 != 0 ? this.f1587YoKzxo.mo1241QyqF(i2, this.f1617wA, this.f1581Vdz) : 0;
        AbstractC2352L8.m9357AZxh();
        m1489dkKKW();
        m1498gtr();
        m1457QyqF(false);
        if (iArr != null) {
            iArr[0] = iMo1230BxruE;
            iArr[1] = iMo1241QyqF;
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m7967rkYL(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().m7962fehf();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.f1557HGpJ) {
            m1517qGY("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f1557HGpJ = true;
                this.f1614vI = true;
                m1513nUaNy();
                return;
            }
            this.f1557HGpJ = false;
            if (this.f1556Gd && this.f1587YoKzxo != null && this.f1568MiMN != null) {
                requestLayout();
            }
            this.f1556Gd = false;
        }
    }

    /* renamed from: tAfC */
    public final int m1524tAfC(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.f1566KLMXS;
        float f2 = 0.0f;
        if (edgeEffect == null || AbstractC2967UXIO.m10508AZxh(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1592cMLeY;
            if (edgeEffect2 != null && AbstractC2967UXIO.m10508AZxh(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.f1592cMLeY.onRelease();
                } else {
                    float fM10509ZfxDd = AbstractC2967UXIO.m10509ZfxDd(this.f1592cMLeY, width, height);
                    if (AbstractC2967UXIO.m10508AZxh(this.f1592cMLeY) == 0.0f) {
                        this.f1592cMLeY.onRelease();
                    }
                    f2 = fM10509ZfxDd;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f1566KLMXS.onRelease();
            } else {
                float f3 = -AbstractC2967UXIO.m10509ZfxDd(this.f1566KLMXS, -width, 1.0f - height);
                if (AbstractC2967UXIO.m10508AZxh(this.f1566KLMXS) == 0.0f) {
                    this.f1566KLMXS.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    /* renamed from: tISON */
    public void m1525tISON(int i, int i2) {
        int iM1166Dt = this.f1561JHa.m1166Dt();
        for (int i3 = 0; i3 < iM1166Dt; i3++) {
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1181qdMbNW(i3));
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1687KLMXS() && abstractC0157mByQM1414dm.f1704wA >= i) {
                if (f1536LREOK) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i3 + " holder " + abstractC0157mByQM1414dm + " now at position " + (abstractC0157mByQM1414dm.f1704wA + i2));
                }
                abstractC0157mByQM1414dm.m1694VocHEe(i2, false);
                this.f1581Vdz.f1665xJ = true;
            }
        }
        this.f1617wA.m1596Ucbh(i, i2);
        requestLayout();
    }

    /* renamed from: tjSezt */
    public void m1526tjSezt() {
        this.f1609rWxwaT = null;
        this.f1624zvd = null;
        this.f1592cMLeY = null;
        this.f1566KLMXS = null;
    }

    /* renamed from: uH */
    public void m1527uH(int i) {
        int iM1184xJ = this.f1561JHa.m1184xJ();
        for (int i2 = 0; i2 < iM1184xJ; i2++) {
            this.f1561JHa.m1169JHa(i2).offsetTopAndBottom(i);
        }
    }

    /* renamed from: uHVRx */
    public View m1528uHVRx(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* renamed from: ub */
    public final void m1529ub() {
        this.f1591bbzow.m1853JHa();
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            abstractC0159qGY.m1726FOJ();
        }
    }

    /* renamed from: uxlM */
    public final boolean m1530uxlM(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        return m1407IVlxe(-i) < AbstractC2967UXIO.m10508AZxh(edgeEffect) * ((float) i2);
    }

    /* renamed from: vI */
    public final void m1531vI(Context context, String str, AttributeSet attributeSet, int i, int i2) throws NoSuchMethodException, SecurityException {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strM1533vjlshU = m1533vjlshU(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strM1533vjlshU, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(AbstractC0159qGY.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f1545lti);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strM1533vjlshU, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0159qGY) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strM1533vjlshU, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strM1533vjlshU, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strM1533vjlshU, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strM1533vjlshU, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strM1533vjlshU, e7);
            }
        }
    }

    /* renamed from: vadzgd */
    public void m1532vadzgd() {
        if (this.f1609rWxwaT != null) {
            return;
        }
        EdgeEffect edgeEffectMo1542mjFkc = this.f1621xrEuO.mo1542mjFkc(this, 3);
        this.f1609rWxwaT = edgeEffectMo1542mjFkc;
        if (this.f1602lgHUyS) {
            edgeEffectMo1542mjFkc.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectMo1542mjFkc.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: vjlshU */
    public final String m1533vjlshU(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    /* renamed from: wJVbdd */
    public void m1534wJVbdd(View view) {
        int size;
        AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(view);
        m1522sRqPfw(view);
        AbstractC0156lgHUyS abstractC0156lgHUyS = this.f1568MiMN;
        if (abstractC0156lgHUyS != null && abstractC0157mByQM1414dm != null) {
            abstractC0156lgHUyS.m1670qGY(abstractC0157mByQM1414dm);
        }
        if (this.f1618wJVbdd == null || r2.size() - 1 < 0) {
            return;
        }
        AbstractC4793w7.m13819mjFkc(this.f1618wJVbdd.get(size));
        throw null;
    }

    /* renamed from: xCVa */
    public void m1535xCVa(int i, int i2, Object obj) {
        int i3;
        int iM1166Dt = this.f1561JHa.m1166Dt();
        int i4 = i + i2;
        for (int i5 = 0; i5 < iM1166Dt; i5++) {
            View viewM1181qdMbNW = this.f1561JHa.m1181qdMbNW(i5);
            AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(viewM1181qdMbNW);
            if (abstractC0157mByQM1414dm != null && !abstractC0157mByQM1414dm.m1687KLMXS() && (i3 = abstractC0157mByQM1414dm.f1704wA) >= i && i3 < i4) {
                abstractC0157mByQM1414dm.m1677AZxh(2);
                abstractC0157mByQM1414dm.m1705mjFkc(obj);
                ((C0153fehf) viewM1181qdMbNW.getLayoutParams()).f1678wA = true;
            }
        }
        this.f1617wA.m1602aqHPIZ(i, i2);
    }

    /* renamed from: xROA */
    public Rect m1536xROA(View view) {
        C0153fehf c0153fehf = (C0153fehf) view.getLayoutParams();
        if (!c0153fehf.f1678wA) {
            return c0153fehf.f1675AZxh;
        }
        if (this.f1581Vdz.m1626KLFTb() && (c0153fehf.m1651AZxh() || c0153fehf.m1652ZfxDd())) {
            return c0153fehf.f1675AZxh;
        }
        Rect rect = c0153fehf.f1675AZxh;
        rect.set(0, 0, 0, 0);
        int size = this.f1607qGY.size();
        for (int i = 0; i < size; i++) {
            this.f1553Dt.set(0, 0, 0, 0);
            ((AbstractC0161rkYL) this.f1607qGY.get(i)).m1825KLFTb(this.f1553Dt, view, this, this.f1581Vdz);
            int i2 = rect.left;
            Rect rect2 = this.f1553Dt;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        c0153fehf.f1678wA = false;
        return rect;
    }

    /* renamed from: xrEuO */
    public final void m1537xrEuO() {
        this.f1581Vdz.m1628mjFkc(4);
        m1433Htq();
        m1474XD();
        C0148VocHEe c0148VocHEe = this.f1581Vdz;
        c0148VocHEe.f1653KLFTb = 1;
        if (c0148VocHEe.f1651ETF) {
            for (int iM1184xJ = this.f1561JHa.m1184xJ() - 1; iM1184xJ >= 0; iM1184xJ--) {
                AbstractC0157mByQ abstractC0157mByQM1414dm = m1414dm(this.f1561JHa.m1169JHa(iM1184xJ));
                if (!abstractC0157mByQM1414dm.m1687KLMXS()) {
                    long jM1501jm = m1501jm(abstractC0157mByQM1414dm);
                    AbstractC0144MiMN.AZxh aZxhM1562Pq = this.f1582Vnb.m1562Pq(this.f1581Vdz, abstractC0157mByQM1414dm);
                    AbstractC0157mByQ abstractC0157mByQM2039xJ = this.f1619xJ.m2039xJ(jM1501jm);
                    if (abstractC0157mByQM2039xJ == null || abstractC0157mByQM2039xJ.m1687KLMXS()) {
                        this.f1619xJ.m2031ZfxDd(abstractC0157mByQM1414dm, aZxhM1562Pq);
                    } else {
                        boolean zM2033lgHUyS = this.f1619xJ.m2033lgHUyS(abstractC0157mByQM2039xJ);
                        boolean zM2033lgHUyS2 = this.f1619xJ.m2033lgHUyS(abstractC0157mByQM1414dm);
                        if (zM2033lgHUyS && abstractC0157mByQM2039xJ == abstractC0157mByQM1414dm) {
                            this.f1619xJ.m2031ZfxDd(abstractC0157mByQM1414dm, aZxhM1562Pq);
                        } else {
                            AbstractC0144MiMN.AZxh aZxhM2030YoKzxo = this.f1619xJ.m2030YoKzxo(abstractC0157mByQM2039xJ);
                            this.f1619xJ.m2031ZfxDd(abstractC0157mByQM1414dm, aZxhM1562Pq);
                            AbstractC0144MiMN.AZxh aZxhM2028MiMN = this.f1619xJ.m2028MiMN(abstractC0157mByQM1414dm);
                            if (aZxhM2030YoKzxo == null) {
                                m1450Moer(jM1501jm, abstractC0157mByQM1414dm, abstractC0157mByQM2039xJ);
                            } else {
                                m1482YoKzxo(abstractC0157mByQM2039xJ, abstractC0157mByQM1414dm, aZxhM2030YoKzxo, aZxhM2028MiMN, zM2033lgHUyS, zM2033lgHUyS2);
                            }
                        }
                    }
                }
            }
            this.f1619xJ.m2037rkYL(this.f1622yX);
        }
        this.f1587YoKzxo.m1793oaI(this.f1617wA);
        C0148VocHEe c0148VocHEe2 = this.f1581Vdz;
        c0148VocHEe2.f1664wA = c0148VocHEe2.f1652JHa;
        this.f1603mByQ = false;
        this.f1573OjSQV = false;
        c0148VocHEe2.f1651ETF = false;
        c0148VocHEe2.f1655VA = false;
        this.f1587YoKzxo.f1718lgHUyS = false;
        ArrayList arrayList = this.f1617wA.f1641AZxh;
        if (arrayList != null) {
            arrayList.clear();
        }
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY.f1715YoKzxo) {
            abstractC0159qGY.f1713MiMN = 0;
            abstractC0159qGY.f1715YoKzxo = false;
            this.f1617wA.m1618vadzgd();
        }
        this.f1587YoKzxo.mo1245Xxz(this.f1581Vdz);
        m1498gtr();
        m1457QyqF(false);
        this.f1619xJ.m2026JHa();
        int[] iArr = this.f1620xROA;
        if (m1421BAnRFn(iArr[0], iArr[1])) {
            m1519rWxwaT(0, 0);
        }
        m1479XgAT();
        m1440Jidt();
    }

    /* renamed from: yX */
    public boolean m1538yX() {
        AccessibilityManager accessibilityManager = this.f1601lB;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* renamed from: ybBTr */
    public boolean m1539ybBTr(int i, int i2, MotionEvent motionEvent, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        m1432HGpJ();
        if (this.f1568MiMN != null) {
            int[] iArr = this.f1576SOS;
            iArr[0] = 0;
            iArr[1] = 0;
            m1523sqndV(i, i2, iArr);
            int[] iArr2 = this.f1576SOS;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i - i8;
            i7 = i2 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.f1607qGY.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f1576SOS;
        iArr3[0] = 0;
        iArr3[1] = 0;
        m1541zvd(i5, i4, i6, i7, this.f1569Moer, i3, iArr3);
        int[] iArr4 = this.f1576SOS;
        int i10 = iArr4[0];
        int i11 = i6 - i10;
        int i12 = iArr4[1];
        int i13 = i7 - i12;
        boolean z = (i10 == 0 && i12 == 0) ? false : true;
        int i14 = this.f1567KRTLGT;
        int[] iArr5 = this.f1569Moer;
        int i15 = iArr5[0];
        this.f1567KRTLGT = i14 - i15;
        int i16 = this.f1555GMIER;
        int i17 = iArr5[1];
        this.f1555GMIER = i16 - i17;
        int[] iArr6 = this.f1577SmIWf;
        iArr6[0] = iArr6[0] + i15;
        iArr6[1] = iArr6[1] + i17;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !AbstractC4721v2.m13744mjFkc(motionEvent, 8194)) {
                m1428FbxKQm(motionEvent.getX(), i11, motionEvent.getY(), i13);
            }
            m1491eyqo(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            m1519rWxwaT(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i5 == 0 && i4 == 0) ? false : true;
    }

    /* renamed from: yfx */
    public final int m1540yfx(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* renamed from: zvd */
    public final void m1541zvd(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().m7957KLFTb(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i);
        this.f1550AZxh = new C0139Gd();
        this.f1617wA = new C0146Ucbh();
        this.f1619xJ = new C0177qGY();
        this.f1608qdMbNW = new RunnableC0158mjFkc();
        this.f1553Dt = new Rect();
        this.f1554ETF = new Rect();
        this.f1580VA = new RectF();
        this.f1610rkYL = new ArrayList();
        this.f1607qGY = new ArrayList();
        this.f1596fehf = new ArrayList();
        this.f1598huTpC = 0;
        this.f1603mByQ = false;
        this.f1573OjSQV = false;
        this.f1572Ne = 0;
        this.f1552CqaNbM = 0;
        this.f1621xrEuO = f1546sRqPfw;
        this.f1582Vnb = new C0180wA();
        this.f1571NPj = 0;
        this.f1615vadzgd = -1;
        this.f1605nxI = Float.MIN_VALUE;
        this.f1584WGXroI = Float.MIN_VALUE;
        this.f1586XV = true;
        this.f1591bbzow = new RunnableC0164wJVbdd();
        this.f1560JBhc = f1548uH ? new RunnableC0129KLFTb.AZxh() : null;
        this.f1581Vdz = new C0148VocHEe();
        this.f1589alEkx = false;
        this.f1594dm = false;
        this.f1611tQ = new C0149YoKzxo();
        this.f1623yfx = false;
        this.f1620xROA = new int[2];
        this.f1569Moer = new int[2];
        this.f1577SmIWf = new int[2];
        this.f1576SOS = new int[2];
        this.f1575Qr = new ArrayList();
        this.f1570NKyg = new RunnableC0135AZxh();
        this.f1600kism = 0;
        this.f1612tjSezt = 0;
        this.f1622yX = new C0150ZfxDd();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1613uHVRx = viewConfiguration.getScaledTouchSlop();
        this.f1605nxI = AbstractC3141X9.m10898KLFTb(viewConfiguration, context);
        this.f1584WGXroI = AbstractC3141X9.m10900lgHUyS(viewConfiguration, context);
        this.f1562JYgkl = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1564JrJO = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1604mjFkc = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f1582Vnb.m1563Ucbh(this.f1611tQ);
        m1456Qr();
        m1497gtIJp();
        m1451NKyg();
        if (AbstractC2876T9.m10271eyqo(this) == 0) {
            AbstractC2876T9.m10244NKyg(this, 1);
        }
        this.f1601lB = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C0124ETF(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3272Z4.f11966mjFkc, i, 0);
        AbstractC2876T9.m10277jm(this, context, AbstractC3272Z4.f11966mjFkc, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        String string = typedArrayObtainStyledAttributes.getString(AbstractC3272Z4.f11958Dt);
        if (typedArrayObtainStyledAttributes.getInt(AbstractC3272Z4.f11964ZfxDd, -1) == -1) {
            setDescendantFocusability(PKIFailureInfo.transactionIdInUse);
        }
        this.f1602lgHUyS = typedArrayObtainStyledAttributes.getBoolean(AbstractC3272Z4.f11968wA, true);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(AbstractC3272Z4.f11961KLFTb, false);
        this.f1595eyqo = z;
        if (z) {
            m1504kism((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(AbstractC3272Z4.f11965lgHUyS), typedArrayObtainStyledAttributes.getDrawable(AbstractC3272Z4.f11967qdMbNW), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(AbstractC3272Z4.f11960JHa), typedArrayObtainStyledAttributes.getDrawable(AbstractC3272Z4.f11969xJ));
        }
        typedArrayObtainStyledAttributes.recycle();
        m1531vI(context, string, attributeSet, i, 0);
        int[] iArr = f1541fFz;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        AbstractC2876T9.m10277jm(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i, 0);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        AbstractC4924y3.m13990ZfxDd(this, true);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$HGpJ */
    public static class C0140HGpJ extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0140HGpJ> f1627CREATOR = new mjFkc();

        /* renamed from: wA */
        public Parcelable f1628wA;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$HGpJ$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0140HGpJ createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0140HGpJ(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0140HGpJ createFromParcel(Parcel parcel) {
                return new C0140HGpJ(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0140HGpJ[] newArray(int i) {
                return new C0140HGpJ[i];
            }
        }

        public C0140HGpJ(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1628wA = parcel.readParcelable(classLoader == null ? AbstractC0159qGY.class.getClassLoader() : classLoader);
        }

        /* renamed from: AZxh */
        public void m1543AZxh(C0140HGpJ c0140HGpJ) {
            this.f1628wA = c0140HGpJ.f1628wA;
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1628wA, 0);
        }

        public C0140HGpJ(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$fehf */
    public static class C0153fehf extends ViewGroup.MarginLayoutParams {

        /* renamed from: AZxh */
        public final Rect f1675AZxh;

        /* renamed from: ZfxDd */
        public boolean f1676ZfxDd;

        /* renamed from: mjFkc */
        public AbstractC0157mByQ f1677mjFkc;

        /* renamed from: wA */
        public boolean f1678wA;

        public C0153fehf(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1675AZxh = new Rect();
            this.f1678wA = true;
            this.f1676ZfxDd = false;
        }

        /* renamed from: AZxh */
        public boolean m1651AZxh() {
            return this.f1677mjFkc.m1683HGpJ();
        }

        /* renamed from: ZfxDd */
        public boolean m1652ZfxDd() {
            return this.f1677mjFkc.m1698diqgf();
        }

        /* renamed from: mjFkc */
        public int m1653mjFkc() {
            return this.f1677mjFkc.m1688MiMN();
        }

        /* renamed from: wA */
        public boolean m1654wA() {
            return this.f1677mjFkc.m1692Ucbh();
        }

        public C0153fehf(int i, int i2) {
            super(i, i2);
            this.f1675AZxh = new Rect();
            this.f1678wA = true;
            this.f1676ZfxDd = false;
        }

        public C0153fehf(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1675AZxh = new Rect();
            this.f1678wA = true;
            this.f1676ZfxDd = false;
        }

        public C0153fehf(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1675AZxh = new Rect();
            this.f1678wA = true;
            this.f1676ZfxDd = false;
        }

        public C0153fehf(C0153fehf c0153fehf) {
            super((ViewGroup.LayoutParams) c0153fehf);
            this.f1675AZxh = new Rect();
            this.f1678wA = true;
            this.f1676ZfxDd = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0159qGY abstractC0159qGY = this.f1587YoKzxo;
        if (abstractC0159qGY != null) {
            return abstractC0159qGY.mo1238Ne(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m1444KRTLGT());
    }
}
