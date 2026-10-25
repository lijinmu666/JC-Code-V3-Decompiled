package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p015widget.C0057wA;
import androidx.constraintlayout.p015widget.ConstraintLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: o.d5 */
/* loaded from: classes.dex */
public abstract class AbstractC3539d5 extends ConstraintLayout {

    /* renamed from: Gd */
    public final Runnable f13299Gd;

    /* renamed from: HGpJ */
    public int f13300HGpJ;

    /* renamed from: vI */
    public C2542O1 f13301vI;

    public AbstractC3539d5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(AbstractC2007G4.f8322lgHUyS, this);
        AbstractC2876T9.m10294vjlshU(this, m11652eyqo());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12703zZ, i, 0);
        this.f13300HGpJ = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12651sjsh, 0);
        this.f13299Gd = new Runnable() { // from class: o.c5
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                this.f13204mjFkc.mo3296vI();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: HGpJ */
    public static boolean m11648HGpJ(View view) {
        return "skip".equals(view.getTag());
    }

    /* renamed from: Gd */
    public void mo3291Gd(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f13300HGpJ = i;
        mo3296vI();
    }

    /* renamed from: Ucbh */
    public int m11649Ucbh(int i) {
        int i2 = this.f13300HGpJ;
        return i == 2 ? Math.round(i2 * 0.66f) : i2;
    }

    /* renamed from: VocHEe */
    public final void m11650VocHEe() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f13299Gd);
            handler.post(this.f13299Gd);
        }
    }

    @Override // androidx.constraintlayout.p015widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(AbstractC2876T9.m10280lgHUyS());
        }
        m11650VocHEe();
    }

    /* renamed from: diqgf */
    public final void m11651diqgf(List list, C0057wA c0057wA, int i) {
        Iterator it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            c0057wA.m429xJ(((View) it.next()).getId(), AbstractC1803D4.f7787AZxh, i, size);
            size += 360.0f / list.size();
        }
    }

    /* renamed from: eyqo */
    public final Drawable m11652eyqo() {
        C2542O1 c2542o1 = new C2542O1();
        this.f13301vI = c2542o1;
        c2542o1.m9810KRTLGT(new C3801h5(0.5f));
        this.f13301vI.m9841uHVRx(ColorStateList.valueOf(-1));
        return this.f13301vI;
    }

    /* renamed from: huTpC */
    public int m11653huTpC() {
        return this.f13300HGpJ;
    }

    @Override // android.view.View
    public void onFinishInflate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onFinishInflate();
        mo3296vI();
    }

    @Override // androidx.constraintlayout.p015widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        m11650VocHEe();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f13301vI.m9841uHVRx(ColorStateList.valueOf(i));
    }

    /* renamed from: vI */
    public void mo3296vI() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C0057wA c0057wA = new C0057wA();
        c0057wA.m421JHa(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != AbstractC1803D4.f7787AZxh && !m11648HGpJ(childAt)) {
                int i2 = (Integer) childAt.getTag(AbstractC1803D4.f7818qdMbNW);
                if (i2 == null) {
                    i2 = 1;
                }
                if (!map.containsKey(i2)) {
                    map.put(i2, new ArrayList());
                }
                ((List) map.get(i2)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            m11651diqgf((List) entry.getValue(), c0057wA, m11649Ucbh(((Integer) entry.getKey()).intValue()));
        }
        c0057wA.m428wA(this);
    }
}
