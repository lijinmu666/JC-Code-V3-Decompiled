package p131o;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: o.P8 */
/* loaded from: classes.dex */
public abstract class AbstractC2614P8 {

    /* renamed from: mjFkc */
    public static AbstractC2485N8 f10037mjFkc = new C3986jx();

    /* renamed from: AZxh */
    public static ThreadLocal f10036AZxh = new ThreadLocal();

    /* renamed from: wA */
    public static ArrayList f10038wA = new ArrayList();

    /* renamed from: o.P8$mjFkc */
    public static class mjFkc implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: AZxh */
        public ViewGroup f10039AZxh;

        /* renamed from: mjFkc */
        public AbstractC2485N8 f10040mjFkc;

        /* renamed from: o.P8$mjFkc$mjFkc, reason: collision with other inner class name */
        public class C6362mjFkc extends AbstractC2549O8 {

            /* renamed from: mjFkc */
            public final /* synthetic */ C4633tjSezt f10042mjFkc;

            public C6362mjFkc(C4633tjSezt c4633tjSezt) {
                this.f10042mjFkc = c4633tjSezt;
            }

            @Override // p131o.AbstractC2485N8.JHa
            /* renamed from: wA */
            public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
                ((ArrayList) this.f10042mjFkc.m10817get(mjFkc.this.f10039AZxh)).remove(abstractC2485N8);
                abstractC2485N8.mo9616aqHPIZ(this);
            }
        }

        public mjFkc(AbstractC2485N8 abstractC2485N8, ViewGroup viewGroup) {
            this.f10040mjFkc = abstractC2485N8;
            this.f10039AZxh = viewGroup;
        }

        /* renamed from: mjFkc */
        public final void m9952mjFkc() {
            this.f10039AZxh.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f10039AZxh.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            m9952mjFkc();
            if (!AbstractC2614P8.f10038wA.remove(this.f10039AZxh)) {
                return true;
            }
            C4633tjSezt c4633tjSeztM9948AZxh = AbstractC2614P8.m9948AZxh();
            ArrayList arrayList = (ArrayList) c4633tjSeztM9948AZxh.m10817get(this.f10039AZxh);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c4633tjSeztM9948AZxh.m10821put(this.f10039AZxh, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f10040mjFkc);
            this.f10040mjFkc.mo9627mjFkc(new C6362mjFkc(c4633tjSeztM9948AZxh));
            this.f10040mjFkc.m9604MiMN(this.f10039AZxh, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC2485N8) it.next()).mo9603KRTLGT(this.f10039AZxh);
                }
            }
            this.f10040mjFkc.m9629oCFDzJ(this.f10039AZxh);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m9952mjFkc();
            AbstractC2614P8.f10038wA.remove(this.f10039AZxh);
            ArrayList arrayList = (ArrayList) AbstractC2614P8.m9948AZxh().m10817get(this.f10039AZxh);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC2485N8) it.next()).mo9603KRTLGT(this.f10039AZxh);
                }
            }
            this.f10040mjFkc.m9615YoKzxo(true);
        }
    }

    /* renamed from: AZxh */
    public static C4633tjSezt m9948AZxh() {
        C4633tjSezt c4633tjSezt;
        WeakReference weakReference = (WeakReference) f10036AZxh.get();
        if (weakReference != null && (c4633tjSezt = (C4633tjSezt) weakReference.get()) != null) {
            return c4633tjSezt;
        }
        C4633tjSezt c4633tjSezt2 = new C4633tjSezt();
        f10036AZxh.set(new WeakReference(c4633tjSezt2));
        return c4633tjSezt2;
    }

    /* renamed from: ZfxDd */
    public static void m9949ZfxDd(ViewGroup viewGroup, AbstractC2485N8 abstractC2485N8) {
        ArrayList arrayList = (ArrayList) m9948AZxh().m10817get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC2485N8) it.next()).mo9633vadzgd(viewGroup);
            }
        }
        if (abstractC2485N8 != null) {
            abstractC2485N8.m9604MiMN(viewGroup, true);
        }
        AbstractC4258o6.m12935mjFkc(viewGroup);
    }

    /* renamed from: mjFkc */
    public static void m9950mjFkc(ViewGroup viewGroup, AbstractC2485N8 abstractC2485N8) {
        if (f10038wA.contains(viewGroup) || !AbstractC2876T9.m10287rWxwaT(viewGroup)) {
            return;
        }
        f10038wA.add(viewGroup);
        if (abstractC2485N8 == null) {
            abstractC2485N8 = f10037mjFkc;
        }
        AbstractC2485N8 abstractC2485N8Mo9619clone = abstractC2485N8.mo9619clone();
        m9949ZfxDd(viewGroup, abstractC2485N8Mo9619clone);
        AbstractC4258o6.m12934AZxh(viewGroup, null);
        m9951wA(viewGroup, abstractC2485N8Mo9619clone);
    }

    /* renamed from: wA */
    public static void m9951wA(ViewGroup viewGroup, AbstractC2485N8 abstractC2485N8) {
        if (abstractC2485N8 == null || viewGroup == null) {
            return;
        }
        mjFkc mjfkc = new mjFkc(abstractC2485N8, viewGroup);
        viewGroup.addOnAttachStateChangeListener(mjfkc);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(mjfkc);
    }
}
