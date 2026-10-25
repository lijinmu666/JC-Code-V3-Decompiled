package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* renamed from: o.N8 */
/* loaded from: classes.dex */
public abstract class AbstractC2485N8 implements Cloneable {

    /* renamed from: diqgf */
    public ArrayList f9679diqgf;

    /* renamed from: eyqo */
    public ArrayList f9680eyqo;

    /* renamed from: mByQ */
    public C4633tjSezt f9685mByQ;

    /* renamed from: wJVbdd */
    public KLFTb f9692wJVbdd;

    /* renamed from: Ne */
    public static final int[] f9660Ne = {2, 1, 3, 4};

    /* renamed from: CqaNbM */
    public static final AbstractC4590t3 f9659CqaNbM = new mjFkc();

    /* renamed from: xrEuO */
    public static ThreadLocal f9661xrEuO = new ThreadLocal();

    /* renamed from: mjFkc */
    public String f9686mjFkc = getClass().getName();

    /* renamed from: AZxh */
    public long f9662AZxh = -1;

    /* renamed from: wA */
    public long f9691wA = -1;

    /* renamed from: ZfxDd */
    public TimeInterpolator f9678ZfxDd = null;

    /* renamed from: KLFTb */
    public ArrayList f9670KLFTb = new ArrayList();

    /* renamed from: JHa */
    public ArrayList f9669JHa = new ArrayList();

    /* renamed from: xJ */
    public ArrayList f9693xJ = null;

    /* renamed from: lgHUyS */
    public ArrayList f9684lgHUyS = null;

    /* renamed from: qdMbNW */
    public ArrayList f9688qdMbNW = null;

    /* renamed from: Dt */
    public ArrayList f9664Dt = null;

    /* renamed from: ETF */
    public ArrayList f9665ETF = null;

    /* renamed from: VA */
    public ArrayList f9675VA = null;

    /* renamed from: MiMN */
    public ArrayList f9671MiMN = null;

    /* renamed from: YoKzxo */
    public ArrayList f9677YoKzxo = null;

    /* renamed from: rkYL */
    public ArrayList f9689rkYL = null;

    /* renamed from: qGY */
    public C2937U8 f9687qGY = new C2937U8();

    /* renamed from: fehf */
    public C2937U8 f9681fehf = new C2937U8();

    /* renamed from: IEE */
    public C2741R8 f9668IEE = null;

    /* renamed from: Pq */
    public int[] f9673Pq = f9660Ne;

    /* renamed from: Ucbh */
    public ViewGroup f9674Ucbh = null;

    /* renamed from: huTpC */
    public boolean f9682huTpC = false;

    /* renamed from: Gd */
    public ArrayList f9666Gd = new ArrayList();

    /* renamed from: HGpJ */
    public int f9667HGpJ = 0;

    /* renamed from: vI */
    public boolean f9690vI = false;

    /* renamed from: VocHEe */
    public boolean f9676VocHEe = false;

    /* renamed from: BAnRFn */
    public ArrayList f9663BAnRFn = null;

    /* renamed from: lB */
    public ArrayList f9683lB = new ArrayList();

    /* renamed from: OjSQV */
    public AbstractC4590t3 f9672OjSQV = f9659CqaNbM;

    /* renamed from: o.N8$AZxh */
    public class AZxh extends AnimatorListenerAdapter {

        /* renamed from: mjFkc */
        public final /* synthetic */ C4633tjSezt f9695mjFkc;

        public AZxh(C4633tjSezt c4633tjSezt) {
            this.f9695mjFkc = c4633tjSezt;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9695mjFkc.m10823remove(animator);
            AbstractC2485N8.this.f9666Gd.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC2485N8.this.f9666Gd.add(animator);
        }
    }

    /* renamed from: o.N8$JHa */
    public interface JHa {
        /* renamed from: AZxh */
        void mo8141AZxh(AbstractC2485N8 abstractC2485N8);

        /* renamed from: KLFTb */
        void mo8143KLFTb(AbstractC2485N8 abstractC2485N8);

        /* renamed from: ZfxDd */
        void mo8144ZfxDd(AbstractC2485N8 abstractC2485N8);

        /* renamed from: mjFkc */
        void mo8145mjFkc(AbstractC2485N8 abstractC2485N8);

        /* renamed from: wA */
        void mo8146wA(AbstractC2485N8 abstractC2485N8);
    }

    /* renamed from: o.N8$KLFTb */
    public static abstract class KLFTb {
    }

    /* renamed from: o.N8$ZfxDd */
    public static class ZfxDd {

        /* renamed from: AZxh */
        public String f9696AZxh;

        /* renamed from: KLFTb */
        public AbstractC2485N8 f9697KLFTb;

        /* renamed from: ZfxDd */
        public InterfaceC2445Ma f9698ZfxDd;

        /* renamed from: mjFkc */
        public View f9699mjFkc;

        /* renamed from: wA */
        public C2875T8 f9700wA;

        public ZfxDd(View view, String str, AbstractC2485N8 abstractC2485N8, InterfaceC2445Ma interfaceC2445Ma, C2875T8 c2875t8) {
            this.f9699mjFkc = view;
            this.f9696AZxh = str;
            this.f9700wA = c2875t8;
            this.f9698ZfxDd = interfaceC2445Ma;
            this.f9697KLFTb = abstractC2485N8;
        }
    }

    /* renamed from: o.N8$mjFkc */
    public static class mjFkc extends AbstractC4590t3 {
        @Override // p131o.AbstractC4590t3
        /* renamed from: mjFkc */
        public Path mo9638mjFkc(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* renamed from: o.N8$wA */
    public class wA extends AnimatorListenerAdapter {
        public wA() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC2485N8.this.m9598IEE();
            animator.removeListener(this);
        }
    }

    /* renamed from: KLFTb */
    public static void m9588KLFTb(C2937U8 c2937u8, View view, C2875T8 c2875t8) {
        c2937u8.f10806mjFkc.m10821put(view, c2875t8);
        int id = view.getId();
        if (id >= 0) {
            if (c2937u8.f10804AZxh.indexOfKey(id) >= 0) {
                c2937u8.f10804AZxh.put(id, null);
            } else {
                c2937u8.f10804AZxh.put(id, view);
            }
        }
        String strM10281mByQ = AbstractC2876T9.m10281mByQ(view);
        if (strM10281mByQ != null) {
            if (c2937u8.f10805ZfxDd.containsKey(strM10281mByQ)) {
                c2937u8.f10805ZfxDd.m10821put(strM10281mByQ, null);
            } else {
                c2937u8.f10805ZfxDd.m10821put(strM10281mByQ, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c2937u8.f10807wA.m12923lgHUyS(itemIdAtPosition) < 0) {
                    AbstractC2876T9.m10249Qr(view, true);
                    c2937u8.f10807wA.m12915Dt(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) c2937u8.f10807wA.m12918KLFTb(itemIdAtPosition);
                if (view2 != null) {
                    AbstractC2876T9.m10249Qr(view2, false);
                    c2937u8.f10807wA.m12915Dt(itemIdAtPosition, null);
                }
            }
        }
    }

    /* renamed from: KLMXS */
    public static boolean m9589KLMXS(C2875T8 c2875t8, C2875T8 c2875t82, String str) {
        Object obj = c2875t8.f10646mjFkc.get(str);
        Object obj2 = c2875t82.f10646mjFkc.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    /* renamed from: vI */
    public static C4633tjSezt m9590vI() {
        C4633tjSezt c4633tjSezt = (C4633tjSezt) f9661xrEuO.get();
        if (c4633tjSezt != null) {
            return c4633tjSezt;
        }
        C4633tjSezt c4633tjSezt2 = new C4633tjSezt();
        f9661xrEuO.set(c4633tjSezt2);
        return c4633tjSezt2;
    }

    /* renamed from: AZxh */
    public AbstractC2485N8 mo9591AZxh(View view) {
        this.f9669JHa.add(view);
        return this;
    }

    /* renamed from: BAnRFn */
    public List m9592BAnRFn() {
        return this.f9670KLFTb;
    }

    /* renamed from: CqaNbM */
    public boolean mo8131CqaNbM(C2875T8 c2875t8, C2875T8 c2875t82) {
        if (c2875t8 == null || c2875t82 == null) {
            return false;
        }
        String[] strArrMo8132OjSQV = mo8132OjSQV();
        if (strArrMo8132OjSQV == null) {
            Iterator it = c2875t8.f10646mjFkc.keySet().iterator();
            while (it.hasNext()) {
                if (m9589KLMXS(c2875t8, c2875t82, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrMo8132OjSQV) {
            if (!m9589KLMXS(c2875t8, c2875t82, str)) {
            }
        }
        return false;
        return true;
    }

    /* renamed from: Dt */
    public final void m9593Dt(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f9688qdMbNW;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f9664Dt;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f9665ETF;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (((Class) this.f9665ETF.get(i)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C2875T8 c2875t8 = new C2875T8(view);
                    if (z) {
                        mo8133VA(c2875t8);
                    } else {
                        mo8139qdMbNW(c2875t8);
                    }
                    c2875t8.f10647wA.add(this);
                    mo9594ETF(c2875t8);
                    if (z) {
                        m9588KLFTb(this.f9687qGY, view, c2875t8);
                    } else {
                        m9588KLFTb(this.f9681fehf, view, c2875t8);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f9671MiMN;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f9677YoKzxo;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.f9689rkYL;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (((Class) this.f9689rkYL.get(i2)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                m9593Dt(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ETF */
    public void mo9594ETF(C2875T8 c2875t8) {
    }

    /* renamed from: GMIER */
    public final void m9595GMIER(Animator animator, C4633tjSezt c4633tjSezt) {
        if (animator != null) {
            animator.addListener(new AZxh(c4633tjSezt));
            m9599JHa(animator);
        }
    }

    /* renamed from: Gd */
    public AbstractC4590t3 m9596Gd() {
        return this.f9672OjSQV;
    }

    /* renamed from: HGpJ */
    public AbstractC2676Q8 m9597HGpJ() {
        return null;
    }

    /* renamed from: IEE */
    public void m9598IEE() {
        int i = this.f9667HGpJ - 1;
        this.f9667HGpJ = i;
        if (i == 0) {
            ArrayList arrayList = this.f9663BAnRFn;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f9663BAnRFn.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((JHa) arrayList2.get(i2)).mo8146wA(this);
                }
            }
            for (int i3 = 0; i3 < this.f9687qGY.f10807wA.m12919MiMN(); i3++) {
                View view = (View) this.f9687qGY.f10807wA.m12921YoKzxo(i3);
                if (view != null) {
                    AbstractC2876T9.m10249Qr(view, false);
                }
            }
            for (int i4 = 0; i4 < this.f9681fehf.f10807wA.m12919MiMN(); i4++) {
                View view2 = (View) this.f9681fehf.f10807wA.m12921YoKzxo(i4);
                if (view2 != null) {
                    AbstractC2876T9.m10249Qr(view2, false);
                }
            }
            this.f9676VocHEe = true;
        }
    }

    /* renamed from: JHa */
    public void m9599JHa(Animator animator) {
        if (animator == null) {
            m9598IEE();
            return;
        }
        if (m9607Pq() >= 0) {
            animator.setDuration(m9607Pq());
        }
        if (m9611VocHEe() >= 0) {
            animator.setStartDelay(m9611VocHEe() + animator.getStartDelay());
        }
        if (m9621eyqo() != null) {
            animator.setInterpolator(m9621eyqo());
        }
        animator.addListener(new wA());
        animator.start();
    }

    /* renamed from: JYgkl */
    public void mo9600JYgkl(KLFTb kLFTb) {
        this.f9692wJVbdd = kLFTb;
    }

    /* renamed from: JYn */
    public AbstractC2485N8 mo9601JYn(long j) {
        this.f9691wA = j;
        return this;
    }

    /* renamed from: JrJO */
    public AbstractC2485N8 mo9602JrJO(TimeInterpolator timeInterpolator) {
        this.f9678ZfxDd = timeInterpolator;
        return this;
    }

    /* renamed from: KRTLGT */
    public void mo9603KRTLGT(View view) {
        if (this.f9690vI) {
            if (!this.f9676VocHEe) {
                C4633tjSezt c4633tjSeztM9590vI = m9590vI();
                int iM10827size = c4633tjSeztM9590vI.m10827size();
                InterfaceC2445Ma interfaceC2445MaM13633ZfxDd = AbstractC4623ta.m13633ZfxDd(view);
                for (int i = iM10827size - 1; i >= 0; i--) {
                    ZfxDd zfxDd = (ZfxDd) c4633tjSeztM9590vI.m10813MiMN(i);
                    if (zfxDd.f9699mjFkc != null && interfaceC2445MaM13633ZfxDd.equals(zfxDd.f9698ZfxDd)) {
                        AbstractC4265oCFDzJ.m12949wA((Animator) c4633tjSeztM9590vI.m10822qdMbNW(i));
                    }
                }
                ArrayList arrayList = this.f9663BAnRFn;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f9663BAnRFn.clone();
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((JHa) arrayList2.get(i2)).mo8143KLFTb(this);
                    }
                }
            }
            this.f9690vI = false;
        }
    }

    /* renamed from: MiMN */
    public void m9604MiMN(ViewGroup viewGroup, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C4633tjSezt c4633tjSezt;
        m9615YoKzxo(z);
        if ((this.f9670KLFTb.size() > 0 || this.f9669JHa.size() > 0) && (((arrayList = this.f9693xJ) == null || arrayList.isEmpty()) && ((arrayList2 = this.f9684lgHUyS) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.f9670KLFTb.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.f9670KLFTb.get(i)).intValue());
                if (viewFindViewById != null) {
                    C2875T8 c2875t8 = new C2875T8(viewFindViewById);
                    if (z) {
                        mo8133VA(c2875t8);
                    } else {
                        mo8139qdMbNW(c2875t8);
                    }
                    c2875t8.f10647wA.add(this);
                    mo9594ETF(c2875t8);
                    if (z) {
                        m9588KLFTb(this.f9687qGY, viewFindViewById, c2875t8);
                    } else {
                        m9588KLFTb(this.f9681fehf, viewFindViewById, c2875t8);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f9669JHa.size(); i2++) {
                View view = (View) this.f9669JHa.get(i2);
                C2875T8 c2875t82 = new C2875T8(view);
                if (z) {
                    mo8133VA(c2875t82);
                } else {
                    mo8139qdMbNW(c2875t82);
                }
                c2875t82.f10647wA.add(this);
                mo9594ETF(c2875t82);
                if (z) {
                    m9588KLFTb(this.f9687qGY, view, c2875t82);
                } else {
                    m9588KLFTb(this.f9681fehf, view, c2875t82);
                }
            }
        } else {
            m9593Dt(viewGroup, z);
        }
        if (z || (c4633tjSezt = this.f9685mByQ) == null) {
            return;
        }
        int iM10827size = c4633tjSezt.m10827size();
        ArrayList arrayList3 = new ArrayList(iM10827size);
        for (int i3 = 0; i3 < iM10827size; i3++) {
            arrayList3.add(this.f9687qGY.f10805ZfxDd.m10823remove((String) this.f9685mByQ.m10822qdMbNW(i3)));
        }
        for (int i4 = 0; i4 < iM10827size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.f9687qGY.f10805ZfxDd.m10821put((String) this.f9685mByQ.m10813MiMN(i4), view2);
            }
        }
    }

    /* renamed from: NPj */
    public final void m9605NPj(C2937U8 c2937u8, C2937U8 c2937u82) {
        C4633tjSezt c4633tjSezt = new C4633tjSezt(c2937u8.f10806mjFkc);
        C4633tjSezt c4633tjSezt2 = new C4633tjSezt(c2937u82.f10806mjFkc);
        int i = 0;
        while (true) {
            int[] iArr = this.f9673Pq;
            if (i >= iArr.length) {
                m9634wA(c4633tjSezt, c4633tjSezt2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                m9618cMLeY(c4633tjSezt, c4633tjSezt2);
            } else if (i2 == 2) {
                m9610Vnb(c4633tjSezt, c4633tjSezt2, c2937u8.f10805ZfxDd, c2937u82.f10805ZfxDd);
            } else if (i2 == 3) {
                m9637zvd(c4633tjSezt, c4633tjSezt2, c2937u8.f10804AZxh, c2937u82.f10804AZxh);
            } else if (i2 == 4) {
                m9630rWxwaT(c4633tjSezt, c4633tjSezt2, c2937u8.f10807wA, c2937u82.f10807wA);
            }
            i++;
        }
    }

    /* renamed from: Ne */
    public C2875T8 m9606Ne(View view, boolean z) {
        C2741R8 c2741r8 = this.f9668IEE;
        if (c2741r8 != null) {
            return c2741r8.m9606Ne(view, z);
        }
        return (C2875T8) (z ? this.f9687qGY : this.f9681fehf).f10806mjFkc.m10817get(view);
    }

    /* renamed from: OjSQV */
    public String[] mo8132OjSQV() {
        return null;
    }

    /* renamed from: Pq */
    public long m9607Pq() {
        return this.f9691wA;
    }

    /* renamed from: SwgkN */
    public String mo9608SwgkN(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f9691wA != -1) {
            str2 = str2 + "dur(" + this.f9691wA + ") ";
        }
        if (this.f9662AZxh != -1) {
            str2 = str2 + "dly(" + this.f9662AZxh + ") ";
        }
        if (this.f9678ZfxDd != null) {
            str2 = str2 + "interp(" + this.f9678ZfxDd + ") ";
        }
        if (this.f9670KLFTb.size() <= 0 && this.f9669JHa.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f9670KLFTb.size() > 0) {
            for (int i = 0; i < this.f9670KLFTb.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f9670KLFTb.get(i);
            }
        }
        if (this.f9669JHa.size() > 0) {
            for (int i2 = 0; i2 < this.f9669JHa.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f9669JHa.get(i2);
            }
        }
        return str3 + ")";
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.f9680eyqo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.f9679diqgf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (p131o.C2875T8) r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /* renamed from: Ucbh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2875T8 m9609Ucbh(View view, boolean z) {
        C2741R8 c2741r8 = this.f9668IEE;
        if (c2741r8 != null) {
            return c2741r8.m9609Ucbh(view, z);
        }
        ArrayList arrayList = z ? this.f9679diqgf : this.f9680eyqo;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            C2875T8 c2875t8 = (C2875T8) arrayList.get(i);
            if (c2875t8 == null) {
                return null;
            }
            if (c2875t8.f10645AZxh == view) {
                break;
            }
            i++;
        }
    }

    /* renamed from: VA */
    public abstract void mo8133VA(C2875T8 c2875t8);

    /* renamed from: Vnb */
    public final void m9610Vnb(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2, C4633tjSezt c4633tjSezt3, C4633tjSezt c4633tjSezt4) {
        View view;
        int iM10827size = c4633tjSezt3.m10827size();
        for (int i = 0; i < iM10827size; i++) {
            View view2 = (View) c4633tjSezt3.m10813MiMN(i);
            if (view2 != null && m9636xrEuO(view2) && (view = (View) c4633tjSezt4.m10817get(c4633tjSezt3.m10822qdMbNW(i))) != null && m9636xrEuO(view)) {
                C2875T8 c2875t8 = (C2875T8) c4633tjSezt.m10817get(view2);
                C2875T8 c2875t82 = (C2875T8) c4633tjSezt2.m10817get(view);
                if (c2875t8 != null && c2875t82 != null) {
                    this.f9679diqgf.add(c2875t8);
                    this.f9680eyqo.add(c2875t82);
                    c4633tjSezt.m10823remove(view2);
                    c4633tjSezt2.m10823remove(view);
                }
            }
        }
    }

    /* renamed from: VocHEe */
    public long m9611VocHEe() {
        return this.f9662AZxh;
    }

    /* renamed from: WGXroI */
    public void mo9612WGXroI(AbstractC2676Q8 abstractC2676Q8) {
    }

    /* renamed from: WrLQs */
    public AbstractC2485N8 mo9613WrLQs(View view) {
        this.f9669JHa.remove(view);
        return this;
    }

    /* renamed from: XV */
    public AbstractC2485N8 mo9614XV(long j) {
        this.f9662AZxh = j;
        return this;
    }

    /* renamed from: YoKzxo */
    public void m9615YoKzxo(boolean z) {
        if (z) {
            this.f9687qGY.f10806mjFkc.m10815clear();
            this.f9687qGY.f10804AZxh.clear();
            this.f9687qGY.f10807wA.m12924mjFkc();
        } else {
            this.f9681fehf.f10806mjFkc.m10815clear();
            this.f9681fehf.f10804AZxh.clear();
            this.f9681fehf.f10807wA.m12924mjFkc();
        }
    }

    /* renamed from: aqHPIZ */
    public AbstractC2485N8 mo9616aqHPIZ(JHa jHa) {
        ArrayList arrayList = this.f9663BAnRFn;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(jHa);
        if (this.f9663BAnRFn.size() == 0) {
            this.f9663BAnRFn = null;
        }
        return this;
    }

    /* renamed from: bbzow */
    public void m9617bbzow() {
        if (this.f9667HGpJ == 0) {
            ArrayList arrayList = this.f9663BAnRFn;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f9663BAnRFn.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((JHa) arrayList2.get(i)).mo8144ZfxDd(this);
                }
            }
            this.f9676VocHEe = false;
        }
        this.f9667HGpJ++;
    }

    /* renamed from: cMLeY */
    public final void m9618cMLeY(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2) {
        C2875T8 c2875t8;
        for (int iM10827size = c4633tjSezt.m10827size() - 1; iM10827size >= 0; iM10827size--) {
            View view = (View) c4633tjSezt.m10822qdMbNW(iM10827size);
            if (view != null && m9636xrEuO(view) && (c2875t8 = (C2875T8) c4633tjSezt2.m10823remove(view)) != null && m9636xrEuO(c2875t8.f10645AZxh)) {
                this.f9679diqgf.add((C2875T8) c4633tjSezt.m10810ETF(iM10827size));
                this.f9680eyqo.add(c2875t8);
            }
        }
    }

    /* renamed from: diqgf */
    public KLFTb m9620diqgf() {
        return this.f9692wJVbdd;
    }

    /* renamed from: eyqo */
    public TimeInterpolator m9621eyqo() {
        return this.f9678ZfxDd;
    }

    /* renamed from: fehf */
    public void mo9622fehf(ViewGroup viewGroup, C2937U8 c2937u8, C2937U8 c2937u82, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        C2875T8 c2875t8;
        int i;
        Animator animator2;
        C2875T8 c2875t82;
        C4633tjSezt c4633tjSeztM9590vI = m9590vI();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C2875T8 c2875t83 = (C2875T8) arrayList.get(i2);
            C2875T8 c2875t84 = (C2875T8) arrayList2.get(i2);
            if (c2875t83 != null && !c2875t83.f10647wA.contains(this)) {
                c2875t83 = null;
            }
            if (c2875t84 != null && !c2875t84.f10647wA.contains(this)) {
                c2875t84 = null;
            }
            if ((c2875t83 != null || c2875t84 != null) && (c2875t83 == null || c2875t84 == null || mo8131CqaNbM(c2875t83, c2875t84))) {
                Animator animatorMo8138qGY = mo8138qGY(viewGroup, c2875t83, c2875t84);
                if (animatorMo8138qGY != null) {
                    if (c2875t84 != null) {
                        View view2 = c2875t84.f10645AZxh;
                        String[] strArrMo8132OjSQV = mo8132OjSQV();
                        if (strArrMo8132OjSQV != null && strArrMo8132OjSQV.length > 0) {
                            c2875t82 = new C2875T8(view2);
                            C2875T8 c2875t85 = (C2875T8) c2937u82.f10806mjFkc.m10817get(view2);
                            if (c2875t85 != null) {
                                int i3 = 0;
                                while (i3 < strArrMo8132OjSQV.length) {
                                    Map map = c2875t82.f10646mjFkc;
                                    Animator animator3 = animatorMo8138qGY;
                                    String str = strArrMo8132OjSQV[i3];
                                    map.put(str, c2875t85.f10646mjFkc.get(str));
                                    i3++;
                                    animatorMo8138qGY = animator3;
                                    strArrMo8132OjSQV = strArrMo8132OjSQV;
                                }
                            }
                            Animator animator4 = animatorMo8138qGY;
                            int iM10827size = c4633tjSeztM9590vI.m10827size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= iM10827size) {
                                    animator2 = animator4;
                                    break;
                                }
                                ZfxDd zfxDd = (ZfxDd) c4633tjSeztM9590vI.m10817get((Animator) c4633tjSeztM9590vI.m10822qdMbNW(i4));
                                if (zfxDd.f9700wA != null && zfxDd.f9699mjFkc == view2 && zfxDd.f9696AZxh.equals(m9623huTpC()) && zfxDd.f9700wA.m10221equals(c2875t82)) {
                                    animator2 = null;
                                    break;
                                }
                                i4++;
                            }
                        } else {
                            animator2 = animatorMo8138qGY;
                            c2875t82 = null;
                        }
                        view = view2;
                        animator = animator2;
                        c2875t8 = c2875t82;
                    } else {
                        view = c2875t83.f10645AZxh;
                        animator = animatorMo8138qGY;
                        c2875t8 = null;
                    }
                    if (animator != null) {
                        i = size;
                        c4633tjSeztM9590vI.m10821put(animator, new ZfxDd(view, m9623huTpC(), this, AbstractC4623ta.m13633ZfxDd(viewGroup), c2875t8));
                        this.f9683lB.add(animator);
                    }
                    i2++;
                    size = i;
                }
                i = size;
                i2++;
                size = i;
            }
            i = size;
            i2++;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator5 = (Animator) this.f9683lB.get(sparseIntArray.keyAt(i5));
                animator5.setStartDelay((sparseIntArray.valueAt(i5) - LongCompanionObject.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    /* renamed from: huTpC */
    public String m9623huTpC() {
        return this.f9686mjFkc;
    }

    /* renamed from: lB */
    public List m9624lB() {
        return this.f9693xJ;
    }

    /* renamed from: lgHUyS */
    public void m9625lgHUyS() {
        for (int size = this.f9666Gd.size() - 1; size >= 0; size--) {
            ((Animator) this.f9666Gd.get(size)).cancel();
        }
        ArrayList arrayList = this.f9663BAnRFn;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f9663BAnRFn.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((JHa) arrayList2.get(i)).mo8141AZxh(this);
        }
    }

    /* renamed from: mByQ */
    public List m9626mByQ() {
        return this.f9669JHa;
    }

    /* renamed from: mjFkc */
    public AbstractC2485N8 mo9627mjFkc(JHa jHa) {
        if (this.f9663BAnRFn == null) {
            this.f9663BAnRFn = new ArrayList();
        }
        this.f9663BAnRFn.add(jHa);
        return this;
    }

    /* renamed from: nxI */
    public void mo9628nxI(AbstractC4590t3 abstractC4590t3) {
        if (abstractC4590t3 == null) {
            this.f9672OjSQV = f9659CqaNbM;
        } else {
            this.f9672OjSQV = abstractC4590t3;
        }
    }

    /* renamed from: oCFDzJ */
    public void m9629oCFDzJ(ViewGroup viewGroup) {
        ZfxDd zfxDd;
        this.f9679diqgf = new ArrayList();
        this.f9680eyqo = new ArrayList();
        m9605NPj(this.f9687qGY, this.f9681fehf);
        C4633tjSezt c4633tjSeztM9590vI = m9590vI();
        int iM10827size = c4633tjSeztM9590vI.m10827size();
        InterfaceC2445Ma interfaceC2445MaM13633ZfxDd = AbstractC4623ta.m13633ZfxDd(viewGroup);
        for (int i = iM10827size - 1; i >= 0; i--) {
            Animator animator = (Animator) c4633tjSeztM9590vI.m10822qdMbNW(i);
            if (animator != null && (zfxDd = (ZfxDd) c4633tjSeztM9590vI.m10817get(animator)) != null && zfxDd.f9699mjFkc != null && interfaceC2445MaM13633ZfxDd.equals(zfxDd.f9698ZfxDd)) {
                C2875T8 c2875t8 = zfxDd.f9700wA;
                View view = zfxDd.f9699mjFkc;
                C2875T8 c2875t8M9606Ne = m9606Ne(view, true);
                C2875T8 c2875t8M9609Ucbh = m9609Ucbh(view, true);
                if (c2875t8M9606Ne == null && c2875t8M9609Ucbh == null) {
                    c2875t8M9609Ucbh = (C2875T8) this.f9681fehf.f10806mjFkc.m10817get(view);
                }
                if ((c2875t8M9606Ne != null || c2875t8M9609Ucbh != null) && zfxDd.f9697KLFTb.mo8131CqaNbM(c2875t8, c2875t8M9609Ucbh)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        c4633tjSeztM9590vI.m10823remove(animator);
                    }
                }
            }
        }
        mo9622fehf(viewGroup, this.f9687qGY, this.f9681fehf, this.f9679diqgf, this.f9680eyqo);
        mo9632uHVRx();
    }

    /* renamed from: qGY */
    public Animator mo8138qGY(ViewGroup viewGroup, C2875T8 c2875t8, C2875T8 c2875t82) {
        return null;
    }

    /* renamed from: qdMbNW */
    public abstract void mo8139qdMbNW(C2875T8 c2875t8);

    /* renamed from: rWxwaT */
    public final void m9630rWxwaT(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2, C4253o1 c4253o1, C4253o1 c4253o12) {
        View view;
        int iM12919MiMN = c4253o1.m12919MiMN();
        for (int i = 0; i < iM12919MiMN; i++) {
            View view2 = (View) c4253o1.m12921YoKzxo(i);
            if (view2 != null && m9636xrEuO(view2) && (view = (View) c4253o12.m12918KLFTb(c4253o1.m12925qdMbNW(i))) != null && m9636xrEuO(view)) {
                C2875T8 c2875t8 = (C2875T8) c4633tjSezt.m10817get(view2);
                C2875T8 c2875t82 = (C2875T8) c4633tjSezt2.m10817get(view);
                if (c2875t8 != null && c2875t82 != null) {
                    this.f9679diqgf.add(c2875t8);
                    this.f9680eyqo.add(c2875t82);
                    c4633tjSezt.m10823remove(view2);
                    c4633tjSezt2.m10823remove(view);
                }
            }
        }
    }

    @Override // 
    /* renamed from: rkYL */
    public AbstractC2485N8 mo9619clone() {
        try {
            AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) super.clone();
            abstractC2485N8.f9683lB = new ArrayList();
            abstractC2485N8.f9687qGY = new C2937U8();
            abstractC2485N8.f9681fehf = new C2937U8();
            abstractC2485N8.f9679diqgf = null;
            abstractC2485N8.f9680eyqo = null;
            return abstractC2485N8;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String toString() {
        return mo9608SwgkN(BuildConfig.f24315FLAVOR);
    }

    /* renamed from: uHVRx */
    public void mo9632uHVRx() {
        m9617bbzow();
        C4633tjSezt c4633tjSeztM9590vI = m9590vI();
        Iterator it = this.f9683lB.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (c4633tjSeztM9590vI.containsKey(animator)) {
                m9617bbzow();
                m9595GMIER(animator, c4633tjSeztM9590vI);
            }
        }
        this.f9683lB.clear();
        m9598IEE();
    }

    /* renamed from: vadzgd */
    public void mo9633vadzgd(View view) {
        if (this.f9676VocHEe) {
            return;
        }
        C4633tjSezt c4633tjSeztM9590vI = m9590vI();
        int iM10827size = c4633tjSeztM9590vI.m10827size();
        InterfaceC2445Ma interfaceC2445MaM13633ZfxDd = AbstractC4623ta.m13633ZfxDd(view);
        for (int i = iM10827size - 1; i >= 0; i--) {
            ZfxDd zfxDd = (ZfxDd) c4633tjSeztM9590vI.m10813MiMN(i);
            if (zfxDd.f9699mjFkc != null && interfaceC2445MaM13633ZfxDd.equals(zfxDd.f9698ZfxDd)) {
                AbstractC4265oCFDzJ.m12947AZxh((Animator) c4633tjSeztM9590vI.m10822qdMbNW(i));
            }
        }
        ArrayList arrayList = this.f9663BAnRFn;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f9663BAnRFn.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((JHa) arrayList2.get(i2)).mo8145mjFkc(this);
            }
        }
        this.f9690vI = true;
    }

    /* renamed from: wA */
    public final void m9634wA(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2) {
        for (int i = 0; i < c4633tjSezt.m10827size(); i++) {
            C2875T8 c2875t8 = (C2875T8) c4633tjSezt.m10813MiMN(i);
            if (m9636xrEuO(c2875t8.f10645AZxh)) {
                this.f9679diqgf.add(c2875t8);
                this.f9680eyqo.add(null);
            }
        }
        for (int i2 = 0; i2 < c4633tjSezt2.m10827size(); i2++) {
            C2875T8 c2875t82 = (C2875T8) c4633tjSezt2.m10813MiMN(i2);
            if (m9636xrEuO(c2875t82.f10645AZxh)) {
                this.f9680eyqo.add(c2875t82);
                this.f9679diqgf.add(null);
            }
        }
    }

    /* renamed from: wJVbdd */
    public List m9635wJVbdd() {
        return this.f9684lgHUyS;
    }

    /* renamed from: xrEuO */
    public boolean m9636xrEuO(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f9688qdMbNW;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f9664Dt;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f9665ETF;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.f9665ETF.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f9675VA != null && AbstractC2876T9.m10281mByQ(view) != null && this.f9675VA.contains(AbstractC2876T9.m10281mByQ(view))) {
            return false;
        }
        if ((this.f9670KLFTb.size() == 0 && this.f9669JHa.size() == 0 && (((arrayList = this.f9684lgHUyS) == null || arrayList.isEmpty()) && ((arrayList2 = this.f9693xJ) == null || arrayList2.isEmpty()))) || this.f9670KLFTb.contains(Integer.valueOf(id)) || this.f9669JHa.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f9693xJ;
        if (arrayList6 != null && arrayList6.contains(AbstractC2876T9.m10281mByQ(view))) {
            return true;
        }
        if (this.f9684lgHUyS != null) {
            for (int i2 = 0; i2 < this.f9684lgHUyS.size(); i2++) {
                if (((Class) this.f9684lgHUyS.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: zvd */
    public final void m9637zvd(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) sparseArray.valueAt(i);
            if (view2 != null && m9636xrEuO(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i))) != null && m9636xrEuO(view)) {
                C2875T8 c2875t8 = (C2875T8) c4633tjSezt.m10817get(view2);
                C2875T8 c2875t82 = (C2875T8) c4633tjSezt2.m10817get(view);
                if (c2875t8 != null && c2875t82 != null) {
                    this.f9679diqgf.add(c2875t8);
                    this.f9680eyqo.add(c2875t82);
                    c4633tjSezt.m10823remove(view2);
                    c4633tjSezt2.m10823remove(view);
                }
            }
        }
    }
}
