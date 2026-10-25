package p131o;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.p022app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: o.KbpP */
/* loaded from: classes.dex */
public abstract class AbstractC2318KbpP {

    /* renamed from: o.KbpP$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ ArrayList f9198AZxh;

        /* renamed from: KLFTb */
        public final /* synthetic */ ArrayList f9200KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ ArrayList f9201ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ int f9202mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ ArrayList f9203wA;

        public mjFkc(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f9202mjFkc = i;
            this.f9198AZxh = arrayList;
            this.f9203wA = arrayList2;
            this.f9201ZfxDd = arrayList3;
            this.f9200KLFTb = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f9202mjFkc; i++) {
                AbstractC2876T9.m10241LREOK((View) this.f9198AZxh.get(i), (String) this.f9203wA.get(i));
                AbstractC2876T9.m10241LREOK((View) this.f9201ZfxDd.get(i), (String) this.f9200KLFTb.get(i));
            }
        }
    }

    /* renamed from: ZfxDd */
    public static void m9247ZfxDd(List list, View view) {
        int size = list.size();
        if (m9249xJ(list, view, size)) {
            return;
        }
        if (AbstractC2876T9.m10281mByQ(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            View view2 = (View) list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m9249xJ(list, childAt, size) && AbstractC2876T9.m10281mByQ(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* renamed from: qdMbNW */
    public static boolean m9248qdMbNW(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: xJ */
    public static boolean m9249xJ(List list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: AZxh */
    public abstract void mo9250AZxh(Object obj, ArrayList arrayList);

    /* renamed from: Dt */
    public abstract Object mo9251Dt(Object obj, Object obj2, Object obj3);

    /* renamed from: ETF */
    public abstract Object mo9252ETF(Object obj, Object obj2, Object obj3);

    /* renamed from: IEE */
    public void m9253IEE(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String strM10281mByQ = AbstractC2876T9.m10281mByQ(view2);
            arrayList4.add(strM10281mByQ);
            if (strM10281mByQ != null) {
                AbstractC2876T9.m10241LREOK(view2, null);
                String str = (String) map.get(strM10281mByQ);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        AbstractC2876T9.m10241LREOK((View) arrayList2.get(i2), strM10281mByQ);
                        break;
                    }
                    i2++;
                }
            }
        }
        ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(view, new mjFkc(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    /* renamed from: JHa */
    public abstract Object mo9254JHa(Object obj);

    /* renamed from: KLFTb */
    public abstract boolean mo9255KLFTb(Object obj);

    /* renamed from: MiMN */
    public abstract void mo9256MiMN(Object obj, View view, ArrayList arrayList);

    /* renamed from: Pq */
    public abstract void mo9257Pq(Object obj, View view, ArrayList arrayList);

    /* renamed from: VA */
    public ArrayList m9258VA(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(AbstractC2876T9.m10281mByQ(view));
            AbstractC2876T9.m10241LREOK(view, null);
        }
        return arrayList2;
    }

    /* renamed from: YoKzxo */
    public abstract void mo9259YoKzxo(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    /* renamed from: diqgf */
    public abstract void mo9260diqgf(Object obj, ArrayList arrayList, ArrayList arrayList2);

    /* renamed from: eyqo */
    public abstract Object mo9261eyqo(Object obj);

    /* renamed from: fehf */
    public void mo9262fehf(Fragment fragment, Object obj, C1726BxruE c1726BxruE, Runnable runnable) {
        runnable.run();
    }

    /* renamed from: lgHUyS */
    public void m9263lgHUyS(View view, Rect rect) {
        if (AbstractC2876T9.m10268cMLeY(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* renamed from: mjFkc */
    public abstract void mo9264mjFkc(Object obj, View view);

    /* renamed from: qGY */
    public abstract void mo9265qGY(Object obj, View view);

    /* renamed from: rkYL */
    public abstract void mo9266rkYL(Object obj, Rect rect);

    /* renamed from: wA */
    public abstract void mo9267wA(ViewGroup viewGroup, Object obj);
}
