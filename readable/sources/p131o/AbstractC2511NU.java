package p131o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: o.NU */
/* loaded from: classes.dex */
public abstract class AbstractC2511NU extends ListView {

    /* renamed from: AZxh */
    public int f9742AZxh;

    /* renamed from: Dt */
    public boolean f9743Dt;

    /* renamed from: ETF */
    public C3403b1 f9744ETF;

    /* renamed from: JHa */
    public int f9745JHa;

    /* renamed from: KLFTb */
    public int f9746KLFTb;

    /* renamed from: VA */
    public JHa f9747VA;

    /* renamed from: ZfxDd */
    public int f9748ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f9749lgHUyS;

    /* renamed from: mjFkc */
    public final Rect f9750mjFkc;

    /* renamed from: qdMbNW */
    public boolean f9751qdMbNW;

    /* renamed from: wA */
    public int f9752wA;

    /* renamed from: xJ */
    public ZfxDd f9753xJ;

    /* renamed from: o.NU$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public static Method f9754AZxh;

        /* renamed from: ZfxDd */
        public static boolean f9755ZfxDd;

        /* renamed from: mjFkc */
        public static Method f9756mjFkc;

        /* renamed from: wA */
        public static Method f9757wA;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f9756mjFkc = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f9754AZxh = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f9757wA = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f9755ZfxDd = true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        /* renamed from: AZxh */
        public static void m9673AZxh(AbstractC2511NU abstractC2511NU, int i, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f9756mjFkc.invoke(abstractC2511NU, Integer.valueOf(i), view, Boolean.FALSE, -1, -1);
                f9754AZxh.invoke(abstractC2511NU, Integer.valueOf(i));
                f9757wA.invoke(abstractC2511NU, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }

        /* renamed from: mjFkc */
        public static boolean m9674mjFkc() {
            return f9755ZfxDd;
        }
    }

    /* renamed from: o.NU$JHa */
    public class JHa implements Runnable {
        public JHa() {
        }

        /* renamed from: AZxh */
        public void m9675AZxh() {
            AbstractC2511NU.this.post(this);
        }

        /* renamed from: mjFkc */
        public void m9676mjFkc() {
            AbstractC2511NU abstractC2511NU = AbstractC2511NU.this;
            abstractC2511NU.f9747VA = null;
            abstractC2511NU.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2511NU abstractC2511NU = AbstractC2511NU.this;
            abstractC2511NU.f9747VA = null;
            abstractC2511NU.drawableStateChanged();
        }
    }

    /* renamed from: o.NU$KLFTb */
    public static class KLFTb {

        /* renamed from: mjFkc */
        public static final Field f9759mjFkc;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            f9759mjFkc = declaredField;
        }

        /* renamed from: AZxh */
        public static void m9677AZxh(AbsListView absListView, boolean z) throws IllegalAccessException, IllegalArgumentException {
            Field field = f9759mjFkc;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: mjFkc */
        public static boolean m9678mjFkc(AbsListView absListView) {
            Field field = f9759mjFkc;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: o.NU$ZfxDd */
    public static class ZfxDd extends AbstractC4844wsbqN {

        /* renamed from: AZxh */
        public boolean f9760AZxh;

        public ZfxDd(Drawable drawable) {
            super(drawable);
            this.f9760AZxh = true;
        }

        /* renamed from: AZxh */
        public void m9679AZxh(boolean z) {
            this.f9760AZxh = z;
        }

        @Override // p131o.AbstractC4844wsbqN, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f9760AZxh) {
                super.draw(canvas);
            }
        }

        @Override // p131o.AbstractC4844wsbqN, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f9760AZxh) {
                super.setHotspot(f, f2);
            }
        }

        @Override // p131o.AbstractC4844wsbqN, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f9760AZxh) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // p131o.AbstractC4844wsbqN, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f9760AZxh) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p131o.AbstractC4844wsbqN, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f9760AZxh) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: o.NU$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static void m9680mjFkc(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    /* renamed from: o.NU$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static void m9681AZxh(AbsListView absListView, boolean z) {
            absListView.setSelectedChildViewEnabled(z);
        }

        /* renamed from: mjFkc */
        public static boolean m9682mjFkc(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }
    }

    public AbstractC2511NU(Context context, boolean z) {
        super(context, null, AbstractC3862i4.f14111YoKzxo);
        this.f9750mjFkc = new Rect();
        this.f9742AZxh = 0;
        this.f9752wA = 0;
        this.f9748ZfxDd = 0;
        this.f9746KLFTb = 0;
        this.f9751qdMbNW = z;
        setCacheColorHint(0);
    }

    /* renamed from: AZxh */
    public final void m9659AZxh(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* renamed from: Dt */
    public final void m9660Dt(boolean z) {
        ZfxDd zfxDd = this.f9753xJ;
        if (zfxDd != null) {
            zfxDd.m9679AZxh(z);
        }
    }

    /* renamed from: ETF */
    public final boolean m9661ETF() {
        return C4576sqndV.m13526AZxh() ? wA.m9682mjFkc(this) : KLFTb.m9678mjFkc(this);
    }

    /* renamed from: JHa */
    public final void m9662JHa(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f9750mjFkc;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f9742AZxh;
        rect.top -= this.f9752wA;
        rect.right += this.f9748ZfxDd;
        rect.bottom += this.f9746KLFTb;
        boolean zM9661ETF = m9661ETF();
        if (view.isEnabled() != zM9661ETF) {
            m9665VA(!zM9661ETF);
            if (i != -1) {
                refreshDrawableState();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /* renamed from: KLFTb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo9663KLFTb(MotionEvent motionEvent, int i) throws IllegalAccessException, IllegalArgumentException {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = false;
                    z = false;
                }
                if (z || z2) {
                    m9669mjFkc();
                }
                if (z) {
                    C3403b1 c3403b1 = this.f9744ETF;
                    if (c3403b1 != null) {
                        c3403b1.m10964MiMN(false);
                    }
                } else {
                    if (this.f9744ETF == null) {
                        this.f9744ETF = new C3403b1(this);
                    }
                    this.f9744ETF.m10964MiMN(true);
                    this.f9744ETF.onTouch(this, motionEvent);
                }
                return z;
            }
            z = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        if (iFindPointerIndex >= 0) {
            int x = (int) motionEvent.getX(iFindPointerIndex);
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x, y);
            if (iPointToPosition == -1) {
                z2 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                m9670qdMbNW(childAt, iPointToPosition, x, y);
                if (actionMasked == 1) {
                    m9659AZxh(childAt, iPointToPosition);
                }
                z = true;
                z2 = false;
            }
        }
        if (z) {
            m9669mjFkc();
        }
        if (z) {
        }
        return z;
    }

    /* renamed from: MiMN */
    public final boolean m9664MiMN() {
        return this.f9743Dt;
    }

    /* renamed from: VA */
    public final void m9665VA(boolean z) throws IllegalAccessException, IllegalArgumentException {
        if (C4576sqndV.m13526AZxh()) {
            wA.m9681AZxh(this, z);
        } else {
            KLFTb.m9677AZxh(this, z);
        }
    }

    /* renamed from: YoKzxo */
    public final void m9666YoKzxo() {
        Drawable selector = getSelector();
        if (selector != null && m9664MiMN() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: ZfxDd */
    public int mo9667ZfxDd(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        View view = null;
        while (i6 < count) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i6 <= i5 || i8 <= 0 || measuredHeight == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i6 >= i5) {
                i8 = measuredHeight;
            }
            i6++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        m9671wA(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f9747VA != null) {
            return;
        }
        super.drawableStateChanged();
        m9660Dt(true);
        m9666YoKzxo();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f9751qdMbNW || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f9751qdMbNW || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f9751qdMbNW || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f9751qdMbNW && this.f9749lgHUyS) || super.isInTouchMode();
    }

    /* renamed from: lgHUyS */
    public final void m9668lgHUyS(int i, View view, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        m9672xJ(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        AbstractC4332pCk.m13076KLFTb(selector, f, f2);
    }

    /* renamed from: mjFkc */
    public final void m9669mjFkc() {
        this.f9743Dt = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f9745JHa - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f9747VA = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f9747VA == null) {
            JHa jHa = new JHa();
            this.f9747VA = jHa;
            jHa.m9675AZxh();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i < 30 || !AZxh.m9674mjFkc()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        AZxh.m9673AZxh(this, iPointToPosition, childAt);
                    }
                }
                m9666YoKzxo();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f9745JHa = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        JHa jHa = this.f9747VA;
        if (jHa != null) {
            jHa.m9676mjFkc();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: qdMbNW */
    public final void m9670qdMbNW(View view, int i, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f9743Dt = true;
        mjFkc.m9680mjFkc(this, f, f2);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f9745JHa;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f9745JHa = i;
        mjFkc.m9680mjFkc(view, f - view.getLeft(), f2 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m9668lgHUyS(i, view, f, f2);
        m9660Dt(false);
        refreshDrawableState();
    }

    public void setListSelectionHidden(boolean z) {
        this.f9749lgHUyS = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        ZfxDd zfxDd = drawable != null ? new ZfxDd(drawable) : null;
        this.f9753xJ = zfxDd;
        super.setSelector(zfxDd);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f9742AZxh = rect.left;
        this.f9752wA = rect.top;
        this.f9748ZfxDd = rect.right;
        this.f9746KLFTb = rect.bottom;
    }

    /* renamed from: wA */
    public final void m9671wA(Canvas canvas) {
        Drawable selector;
        if (this.f9750mjFkc.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f9750mjFkc);
        selector.draw(canvas);
    }

    /* renamed from: xJ */
    public final void m9672xJ(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m9662JHa(i, view);
        if (z) {
            Rect rect = this.f9750mjFkc;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            AbstractC4332pCk.m13076KLFTb(selector, fExactCenterX, fExactCenterY);
        }
    }
}
