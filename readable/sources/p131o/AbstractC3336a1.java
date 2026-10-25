package p131o;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

/* renamed from: o.a1 */
/* loaded from: classes.dex */
public abstract class AbstractC3336a1 implements InterfaceC2674Q6 {

    /* renamed from: AZxh */
    public ListAdapter f12273AZxh;

    /* renamed from: BAnRFn */
    public final Handler f12274BAnRFn;

    /* renamed from: Dt */
    public boolean f12275Dt;

    /* renamed from: ETF */
    public boolean f12276ETF;

    /* renamed from: IEE */
    public DataSetObserver f12279IEE;

    /* renamed from: JHa */
    public int f12280JHa;

    /* renamed from: OjSQV */
    public PopupWindow f12283OjSQV;

    /* renamed from: Pq */
    public View f12284Pq;

    /* renamed from: Ucbh */
    public AdapterView.OnItemSelectedListener f12285Ucbh;

    /* renamed from: VocHEe */
    public Runnable f12287VocHEe;

    /* renamed from: diqgf */
    public Drawable f12290diqgf;

    /* renamed from: eyqo */
    public AdapterView.OnItemClickListener f12291eyqo;

    /* renamed from: mByQ */
    public boolean f12296mByQ;

    /* renamed from: mjFkc */
    public Context f12297mjFkc;

    /* renamed from: qGY */
    public View f12298qGY;

    /* renamed from: qdMbNW */
    public boolean f12299qdMbNW;

    /* renamed from: wA */
    public AbstractC2511NU f12302wA;

    /* renamed from: wJVbdd */
    public Rect f12303wJVbdd;

    /* renamed from: xJ */
    public int f12304xJ;

    /* renamed from: ZfxDd */
    public int f12289ZfxDd = -2;

    /* renamed from: KLFTb */
    public int f12281KLFTb = -2;

    /* renamed from: lgHUyS */
    public int f12295lgHUyS = 1002;

    /* renamed from: VA */
    public int f12286VA = 0;

    /* renamed from: MiMN */
    public boolean f12282MiMN = false;

    /* renamed from: YoKzxo */
    public boolean f12288YoKzxo = false;

    /* renamed from: rkYL */
    public int f12300rkYL = Integer.MAX_VALUE;

    /* renamed from: fehf */
    public int f12292fehf = 0;

    /* renamed from: huTpC */
    public final qdMbNW f12293huTpC = new qdMbNW();

    /* renamed from: Gd */
    public final lgHUyS f12277Gd = new lgHUyS();

    /* renamed from: HGpJ */
    public final xJ f12278HGpJ = new xJ();

    /* renamed from: vI */
    public final KLFTb f12301vI = new KLFTb();

    /* renamed from: lB */
    public final Rect f12294lB = new Rect();

    /* renamed from: o.a1$AZxh */
    public class AZxh implements AdapterView.OnItemSelectedListener {
        public AZxh() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            AbstractC2511NU abstractC2511NU;
            if (i == -1 || (abstractC2511NU = AbstractC3336a1.this.f12302wA) == null) {
                return;
            }
            abstractC2511NU.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* renamed from: o.a1$JHa */
    public class JHa extends DataSetObserver {
        public JHa() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (AbstractC3336a1.this.mo9Dt()) {
                AbstractC3336a1.this.mo29mjFkc();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC3336a1.this.mo21ZfxDd();
        }
    }

    /* renamed from: o.a1$KLFTb */
    public class KLFTb implements Runnable {
        public KLFTb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3336a1.this.m11266xJ();
        }
    }

    /* renamed from: o.a1$ZfxDd */
    public static class ZfxDd {
        /* renamed from: AZxh */
        public static void m11267AZxh(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }

        /* renamed from: mjFkc */
        public static void m11268mjFkc(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }
    }

    /* renamed from: o.a1$lgHUyS */
    public class lgHUyS implements View.OnTouchListener {
        public lgHUyS() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = AbstractC3336a1.this.f12283OjSQV) != null && popupWindow.isShowing() && x >= 0 && x < AbstractC3336a1.this.f12283OjSQV.getWidth() && y >= 0 && y < AbstractC3336a1.this.f12283OjSQV.getHeight()) {
                AbstractC3336a1 abstractC3336a1 = AbstractC3336a1.this;
                abstractC3336a1.f12274BAnRFn.postDelayed(abstractC3336a1.f12293huTpC, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            AbstractC3336a1 abstractC3336a12 = AbstractC3336a1.this;
            abstractC3336a12.f12274BAnRFn.removeCallbacks(abstractC3336a12.f12293huTpC);
            return false;
        }
    }

    /* renamed from: o.a1$mjFkc */
    public class mjFkc implements Runnable {
        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewM11262qdMbNW = AbstractC3336a1.this.m11262qdMbNW();
            if (viewM11262qdMbNW == null || viewM11262qdMbNW.getWindowToken() == null) {
                return;
            }
            AbstractC3336a1.this.mo29mjFkc();
        }
    }

    /* renamed from: o.a1$qdMbNW */
    public class qdMbNW implements Runnable {
        public qdMbNW() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2511NU abstractC2511NU = AbstractC3336a1.this.f12302wA;
            if (abstractC2511NU == null || !AbstractC2876T9.m10268cMLeY(abstractC2511NU) || AbstractC3336a1.this.f12302wA.getCount() <= AbstractC3336a1.this.f12302wA.getChildCount()) {
                return;
            }
            int childCount = AbstractC3336a1.this.f12302wA.getChildCount();
            AbstractC3336a1 abstractC3336a1 = AbstractC3336a1.this;
            if (childCount <= abstractC3336a1.f12300rkYL) {
                abstractC3336a1.f12283OjSQV.setInputMethodMode(2);
                AbstractC3336a1.this.mo29mjFkc();
            }
        }
    }

    /* renamed from: o.a1$wA */
    public static class wA {
        /* renamed from: mjFkc */
        public static int m11269mjFkc(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    /* renamed from: o.a1$xJ */
    public class xJ implements AbsListView.OnScrollListener {
        public xJ() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || AbstractC3336a1.this.m11254YoKzxo() || AbstractC3336a1.this.f12283OjSQV.getContentView() == null) {
                return;
            }
            AbstractC3336a1 abstractC3336a1 = AbstractC3336a1.this;
            abstractC3336a1.f12274BAnRFn.removeCallbacks(abstractC3336a1.f12293huTpC);
            AbstractC3336a1.this.f12293huTpC.run();
        }
    }

    public AbstractC3336a1(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f12297mjFkc = context;
        this.f12274BAnRFn = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3407b5.f13013tISON, i, i2);
        this.f12280JHa = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3407b5.f12932Vgyli, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3407b5.f12988lti, 0);
        this.f12304xJ = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f12299qdMbNW = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C4616tQ c4616tQ = new C4616tQ(context, attributeSet, i, i2);
        this.f12283OjSQV = c4616tQ;
        c4616tQ.setInputMethodMode(1);
    }

    /* renamed from: BAnRFn */
    public void m11243BAnRFn(boolean z) {
        this.f12276ETF = true;
        this.f12275Dt = z;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: Dt */
    public boolean mo9Dt() {
        return this.f12283OjSQV.isShowing();
    }

    /* renamed from: ETF */
    public int m11244ETF() {
        return this.f12280JHa;
    }

    /* renamed from: Gd */
    public void m11245Gd(int i) {
        this.f12283OjSQV.setInputMethodMode(i);
    }

    /* renamed from: HGpJ */
    public void m11246HGpJ(boolean z) {
        this.f12296mByQ = z;
        this.f12283OjSQV.setFocusable(z);
    }

    /* renamed from: IEE */
    public void m11247IEE(View view) {
        this.f12284Pq = view;
    }

    /* renamed from: JHa */
    public final int m11248JHa() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        int i2;
        if (this.f12302wA == null) {
            Context context = this.f12297mjFkc;
            this.f12287VocHEe = new mjFkc();
            AbstractC2511NU abstractC2511NUMo11167lgHUyS = mo11167lgHUyS(context, !this.f12296mByQ);
            this.f12302wA = abstractC2511NUMo11167lgHUyS;
            Drawable drawable = this.f12290diqgf;
            if (drawable != null) {
                abstractC2511NUMo11167lgHUyS.setSelector(drawable);
            }
            this.f12302wA.setAdapter(this.f12273AZxh);
            this.f12302wA.setOnItemClickListener(this.f12291eyqo);
            this.f12302wA.setFocusable(true);
            this.f12302wA.setFocusableInTouchMode(true);
            this.f12302wA.setOnItemSelectedListener(new AZxh());
            this.f12302wA.setOnScrollListener(this.f12278HGpJ);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f12285Ucbh;
            if (onItemSelectedListener != null) {
                this.f12302wA.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f12302wA;
            View view2 = this.f12298qGY;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.f12292fehf;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i3 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f12292fehf);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i4 = this.f12281KLFTb;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f12283OjSQV.setContentView(view);
        } else {
            View view3 = this.f12298qGY;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f12283OjSQV.getBackground();
        if (background != null) {
            background.getPadding(this.f12294lB);
            Rect rect = this.f12294lB;
            int i5 = rect.top;
            i = rect.bottom + i5;
            if (!this.f12299qdMbNW) {
                this.f12304xJ = -i5;
            }
        } else {
            this.f12294lB.setEmpty();
            i = 0;
        }
        int iM11252VA = m11252VA(m11262qdMbNW(), this.f12304xJ, this.f12283OjSQV.getInputMethodMode() == 2);
        if (this.f12282MiMN || this.f12289ZfxDd == -1) {
            return iM11252VA + i;
        }
        int i6 = this.f12281KLFTb;
        if (i6 == -2) {
            int i7 = this.f12297mjFkc.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f12294lB;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i6 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        } else {
            int i8 = this.f12297mjFkc.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f12294lB;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect3.left + rect3.right), 1073741824);
        }
        int iMo9667ZfxDd = this.f12302wA.mo9667ZfxDd(iMakeMeasureSpec, 0, -1, iM11252VA - measuredHeight, -1);
        if (iMo9667ZfxDd > 0) {
            measuredHeight += i + this.f12302wA.getPaddingTop() + this.f12302wA.getPaddingBottom();
        }
        return iMo9667ZfxDd + measuredHeight;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: KLFTb */
    public ListView mo12KLFTb() {
        return this.f12302wA;
    }

    /* renamed from: MiMN */
    public int m11249MiMN() {
        if (this.f12299qdMbNW) {
            return this.f12304xJ;
        }
        return 0;
    }

    /* renamed from: Pq */
    public void m11250Pq(int i) {
        this.f12283OjSQV.setAnimationStyle(i);
    }

    /* renamed from: Ucbh */
    public void m11251Ucbh(Rect rect) {
        this.f12303wJVbdd = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: VA */
    public final int m11252VA(View view, int i, boolean z) {
        return wA.m11269mjFkc(this.f12283OjSQV, view, i, z);
    }

    /* renamed from: VocHEe */
    public void m11253VocHEe(AdapterView.OnItemClickListener onItemClickListener) {
        this.f12291eyqo = onItemClickListener;
    }

    /* renamed from: YoKzxo */
    public boolean m11254YoKzxo() {
        return this.f12283OjSQV.getInputMethodMode() == 2;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: ZfxDd */
    public void mo21ZfxDd() {
        this.f12283OjSQV.dismiss();
        m11261qGY();
        this.f12283OjSQV.setContentView(null);
        this.f12302wA = null;
        this.f12274BAnRFn.removeCallbacks(this.f12293huTpC);
    }

    /* renamed from: diqgf */
    public void m11255diqgf(int i) {
        Drawable background = this.f12283OjSQV.getBackground();
        if (background == null) {
            m11260mByQ(i);
            return;
        }
        background.getPadding(this.f12294lB);
        Rect rect = this.f12294lB;
        this.f12281KLFTb = rect.left + rect.right + i;
    }

    /* renamed from: eyqo */
    public void m11256eyqo(int i) {
        this.f12286VA = i;
    }

    /* renamed from: fehf */
    public void m11257fehf(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f12279IEE;
        if (dataSetObserver == null) {
            this.f12279IEE = new JHa();
        } else {
            ListAdapter listAdapter2 = this.f12273AZxh;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f12273AZxh = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f12279IEE);
        }
        AbstractC2511NU abstractC2511NU = this.f12302wA;
        if (abstractC2511NU != null) {
            abstractC2511NU.setAdapter(this.f12273AZxh);
        }
    }

    /* renamed from: huTpC */
    public void m11258huTpC(int i) {
        this.f12280JHa = i;
    }

    /* renamed from: lB */
    public final void m11259lB(boolean z) {
        ZfxDd.m11267AZxh(this.f12283OjSQV, z);
    }

    /* renamed from: lgHUyS */
    public abstract AbstractC2511NU mo11167lgHUyS(Context context, boolean z);

    /* renamed from: mByQ */
    public void m11260mByQ(int i) {
        this.f12281KLFTb = i;
    }

    @Override // p131o.InterfaceC2674Q6
    /* renamed from: mjFkc */
    public void mo29mjFkc() {
        int iM11248JHa = m11248JHa();
        boolean zM11254YoKzxo = m11254YoKzxo();
        AbstractC1933F3.m8251AZxh(this.f12283OjSQV, this.f12295lgHUyS);
        if (this.f12283OjSQV.isShowing()) {
            if (AbstractC2876T9.m10268cMLeY(m11262qdMbNW())) {
                int width = this.f12281KLFTb;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = m11262qdMbNW().getWidth();
                }
                int i = this.f12289ZfxDd;
                if (i == -1) {
                    if (!zM11254YoKzxo) {
                        iM11248JHa = -1;
                    }
                    if (zM11254YoKzxo) {
                        this.f12283OjSQV.setWidth(this.f12281KLFTb == -1 ? -1 : 0);
                        this.f12283OjSQV.setHeight(0);
                    } else {
                        this.f12283OjSQV.setWidth(this.f12281KLFTb == -1 ? -1 : 0);
                        this.f12283OjSQV.setHeight(-1);
                    }
                } else if (i != -2) {
                    iM11248JHa = i;
                }
                this.f12283OjSQV.setOutsideTouchable((this.f12288YoKzxo || this.f12282MiMN) ? false : true);
                this.f12283OjSQV.update(m11262qdMbNW(), this.f12280JHa, this.f12304xJ, width < 0 ? -1 : width, iM11248JHa < 0 ? -1 : iM11248JHa);
                return;
            }
            return;
        }
        int width2 = this.f12281KLFTb;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = m11262qdMbNW().getWidth();
        }
        int i2 = this.f12289ZfxDd;
        if (i2 == -1) {
            iM11248JHa = -1;
        } else if (i2 != -2) {
            iM11248JHa = i2;
        }
        this.f12283OjSQV.setWidth(width2);
        this.f12283OjSQV.setHeight(iM11248JHa);
        m11259lB(true);
        this.f12283OjSQV.setOutsideTouchable((this.f12288YoKzxo || this.f12282MiMN) ? false : true);
        this.f12283OjSQV.setTouchInterceptor(this.f12277Gd);
        if (this.f12276ETF) {
            AbstractC1933F3.m8252mjFkc(this.f12283OjSQV, this.f12275Dt);
        }
        ZfxDd.m11268mjFkc(this.f12283OjSQV, this.f12303wJVbdd);
        AbstractC1933F3.m8253wA(this.f12283OjSQV, m11262qdMbNW(), this.f12280JHa, this.f12304xJ, this.f12286VA);
        this.f12302wA.setSelection(-1);
        if (!this.f12296mByQ || this.f12302wA.isInTouchMode()) {
            m11266xJ();
        }
        if (this.f12296mByQ) {
            return;
        }
        this.f12274BAnRFn.post(this.f12301vI);
    }

    /* renamed from: qGY */
    public final void m11261qGY() {
        View view = this.f12298qGY;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f12298qGY);
            }
        }
    }

    /* renamed from: qdMbNW */
    public View m11262qdMbNW() {
        return this.f12284Pq;
    }

    /* renamed from: rkYL */
    public boolean m11263rkYL() {
        return this.f12296mByQ;
    }

    /* renamed from: vI */
    public void m11264vI(PopupWindow.OnDismissListener onDismissListener) {
        this.f12283OjSQV.setOnDismissListener(onDismissListener);
    }

    /* renamed from: wJVbdd */
    public void m11265wJVbdd(int i) {
        this.f12304xJ = i;
        this.f12299qdMbNW = true;
    }

    /* renamed from: xJ */
    public void m11266xJ() {
        AbstractC2511NU abstractC2511NU = this.f12302wA;
        if (abstractC2511NU != null) {
            abstractC2511NU.setListSelectionHidden(true);
            abstractC2511NU.requestLayout();
        }
    }
}
