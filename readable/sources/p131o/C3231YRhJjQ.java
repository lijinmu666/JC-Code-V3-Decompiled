package p131o;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p131o.AbstractC2485N8;

/* renamed from: o.YRhJjQ */
/* loaded from: classes.dex */
public class C3231YRhJjQ extends AbstractC2318KbpP {

    /* renamed from: o.YRhJjQ$AZxh */
    public class AZxh implements AbstractC2485N8.JHa {

        /* renamed from: AZxh */
        public final /* synthetic */ ArrayList f11868AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ View f11869mjFkc;

        public AZxh(View view, ArrayList arrayList) {
            this.f11869mjFkc = view;
            this.f11868AZxh = arrayList;
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: AZxh */
        public void mo8141AZxh(AbstractC2485N8 abstractC2485N8) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: KLFTb */
        public void mo8143KLFTb(AbstractC2485N8 abstractC2485N8) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: ZfxDd */
        public void mo8144ZfxDd(AbstractC2485N8 abstractC2485N8) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: mjFkc */
        public void mo8145mjFkc(AbstractC2485N8 abstractC2485N8) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            abstractC2485N8.mo9616aqHPIZ(this);
            this.f11869mjFkc.setVisibility(8);
            int size = this.f11868AZxh.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f11868AZxh.get(i)).setVisibility(0);
            }
        }
    }

    /* renamed from: o.YRhJjQ$ZfxDd */
    public class ZfxDd extends AbstractC2485N8.KLFTb {

        /* renamed from: mjFkc */
        public final /* synthetic */ Rect f11872mjFkc;

        public ZfxDd(Rect rect) {
            this.f11872mjFkc = rect;
        }
    }

    /* renamed from: o.YRhJjQ$mjFkc */
    public class mjFkc extends AbstractC2485N8.KLFTb {

        /* renamed from: mjFkc */
        public final /* synthetic */ Rect f11874mjFkc;

        public mjFkc(Rect rect) {
            this.f11874mjFkc = rect;
        }
    }

    /* renamed from: o.YRhJjQ$wA */
    public class wA extends AbstractC2549O8 {

        /* renamed from: AZxh */
        public final /* synthetic */ ArrayList f11875AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ ArrayList f11876JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ Object f11877KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ArrayList f11878ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ Object f11879mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Object f11880wA;

        public wA(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f11879mjFkc = obj;
            this.f11875AZxh = arrayList;
            this.f11880wA = obj2;
            this.f11878ZfxDd = arrayList2;
            this.f11877KLFTb = obj3;
            this.f11876JHa = arrayList3;
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: ZfxDd */
        public void mo8144ZfxDd(AbstractC2485N8 abstractC2485N8) {
            Object obj = this.f11879mjFkc;
            if (obj != null) {
                C3231YRhJjQ.this.m11121huTpC(obj, this.f11875AZxh, null);
            }
            Object obj2 = this.f11880wA;
            if (obj2 != null) {
                C3231YRhJjQ.this.m11121huTpC(obj2, this.f11878ZfxDd, null);
            }
            Object obj3 = this.f11877KLFTb;
            if (obj3 != null) {
                C3231YRhJjQ.this.m11121huTpC(obj3, this.f11876JHa, null);
            }
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    /* renamed from: Ucbh */
    public static boolean m11120Ucbh(AbstractC2485N8 abstractC2485N8) {
        return (AbstractC2318KbpP.m9248qdMbNW(abstractC2485N8.m9592BAnRFn()) && AbstractC2318KbpP.m9248qdMbNW(abstractC2485N8.m9624lB()) && AbstractC2318KbpP.m9248qdMbNW(abstractC2485N8.m9635wJVbdd())) ? false : true;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: AZxh */
    public void mo9250AZxh(Object obj, ArrayList arrayList) {
        AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) obj;
        if (abstractC2485N8 == null) {
            return;
        }
        int i = 0;
        if (abstractC2485N8 instanceof C2741R8) {
            C2741R8 c2741r8 = (C2741R8) abstractC2485N8;
            int iM10050dm = c2741r8.m10050dm();
            while (i < iM10050dm) {
                mo9250AZxh(c2741r8.m10049alEkx(i), arrayList);
                i++;
            }
            return;
        }
        if (m11120Ucbh(abstractC2485N8) || !AbstractC2318KbpP.m9248qdMbNW(abstractC2485N8.m9626mByQ())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            abstractC2485N8.mo9591AZxh((View) arrayList.get(i));
            i++;
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: Dt */
    public Object mo9251Dt(Object obj, Object obj2, Object obj3) {
        AbstractC2485N8 abstractC2485N8M10044IVlxe = (AbstractC2485N8) obj;
        AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) obj2;
        AbstractC2485N8 abstractC2485N82 = (AbstractC2485N8) obj3;
        if (abstractC2485N8M10044IVlxe != null && abstractC2485N8 != null) {
            abstractC2485N8M10044IVlxe = new C2741R8().m10051jm(abstractC2485N8M10044IVlxe).m10051jm(abstractC2485N8).m10044IVlxe(1);
        } else if (abstractC2485N8M10044IVlxe == null) {
            abstractC2485N8M10044IVlxe = abstractC2485N8 != null ? abstractC2485N8 : null;
        }
        if (abstractC2485N82 == null) {
            return abstractC2485N8M10044IVlxe;
        }
        C2741R8 c2741r8 = new C2741R8();
        if (abstractC2485N8M10044IVlxe != null) {
            c2741r8.m10051jm(abstractC2485N8M10044IVlxe);
        }
        c2741r8.m10051jm(abstractC2485N82);
        return c2741r8;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: ETF */
    public Object mo9252ETF(Object obj, Object obj2, Object obj3) {
        C2741R8 c2741r8 = new C2741R8();
        if (obj != null) {
            c2741r8.m10051jm((AbstractC2485N8) obj);
        }
        if (obj2 != null) {
            c2741r8.m10051jm((AbstractC2485N8) obj2);
        }
        if (obj3 != null) {
            c2741r8.m10051jm((AbstractC2485N8) obj3);
        }
        return c2741r8;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: JHa */
    public Object mo9254JHa(Object obj) {
        if (obj != null) {
            return ((AbstractC2485N8) obj).mo9619clone();
        }
        return null;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: KLFTb */
    public boolean mo9255KLFTb(Object obj) {
        return obj instanceof AbstractC2485N8;
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: MiMN */
    public void mo9256MiMN(Object obj, View view, ArrayList arrayList) {
        ((AbstractC2485N8) obj).mo9627mjFkc(new AZxh(view, arrayList));
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: Pq */
    public void mo9257Pq(Object obj, View view, ArrayList arrayList) {
        C2741R8 c2741r8 = (C2741R8) obj;
        List listM9626mByQ = c2741r8.m9626mByQ();
        listM9626mByQ.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC2318KbpP.m9247ZfxDd(listM9626mByQ, (View) arrayList.get(i));
        }
        listM9626mByQ.add(view);
        arrayList.add(view);
        mo9250AZxh(c2741r8, arrayList);
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: YoKzxo */
    public void mo9259YoKzxo(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((AbstractC2485N8) obj).mo9627mjFkc(new wA(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: diqgf */
    public void mo9260diqgf(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        C2741R8 c2741r8 = (C2741R8) obj;
        if (c2741r8 != null) {
            c2741r8.m9626mByQ().clear();
            c2741r8.m9626mByQ().addAll(arrayList2);
            m11121huTpC(c2741r8, arrayList, arrayList2);
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: eyqo */
    public Object mo9261eyqo(Object obj) {
        if (obj == null) {
            return null;
        }
        C2741R8 c2741r8 = new C2741R8();
        c2741r8.m10051jm((AbstractC2485N8) obj);
        return c2741r8;
    }

    /* renamed from: huTpC */
    public void m11121huTpC(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC2485N8 abstractC2485N8 = (AbstractC2485N8) obj;
        int i = 0;
        if (abstractC2485N8 instanceof C2741R8) {
            C2741R8 c2741r8 = (C2741R8) abstractC2485N8;
            int iM10050dm = c2741r8.m10050dm();
            while (i < iM10050dm) {
                m11121huTpC(c2741r8.m10049alEkx(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m11120Ucbh(abstractC2485N8)) {
            return;
        }
        List listM9626mByQ = abstractC2485N8.m9626mByQ();
        if (listM9626mByQ.size() == arrayList.size() && listM9626mByQ.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                abstractC2485N8.mo9591AZxh((View) arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                abstractC2485N8.mo9613WrLQs((View) arrayList.get(size2));
            }
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: mjFkc */
    public void mo9264mjFkc(Object obj, View view) {
        if (obj != null) {
            ((AbstractC2485N8) obj).mo9591AZxh(view);
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: qGY */
    public void mo9265qGY(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m9263lgHUyS(view, rect);
            ((AbstractC2485N8) obj).mo9600JYgkl(new mjFkc(rect));
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: rkYL */
    public void mo9266rkYL(Object obj, Rect rect) {
        if (obj != null) {
            ((AbstractC2485N8) obj).mo9600JYgkl(new ZfxDd(rect));
        }
    }

    @Override // p131o.AbstractC2318KbpP
    /* renamed from: wA */
    public void mo9267wA(ViewGroup viewGroup, Object obj) {
        AbstractC2614P8.m9950mjFkc(viewGroup, (AbstractC2485N8) obj);
    }
}
