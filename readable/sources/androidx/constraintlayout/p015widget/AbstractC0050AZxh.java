package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.p015widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import p131o.AbstractC3005V4;
import p131o.AbstractC4723v4;
import p131o.C3776gjvQ;
import p131o.InterfaceC4718v;

/* renamed from: androidx.constraintlayout.widget.AZxh */
/* loaded from: classes.dex */
public abstract class AbstractC0050AZxh extends View {

    /* renamed from: AZxh */
    public int f663AZxh;

    /* renamed from: JHa */
    public String f664JHa;

    /* renamed from: KLFTb */
    public boolean f665KLFTb;

    /* renamed from: ZfxDd */
    public InterfaceC4718v f666ZfxDd;

    /* renamed from: lgHUyS */
    public HashMap f667lgHUyS;

    /* renamed from: mjFkc */
    public int[] f668mjFkc;

    /* renamed from: wA */
    public Context f669wA;

    /* renamed from: xJ */
    public View[] f670xJ;

    public AbstractC0050AZxh(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f668mjFkc = new int[32];
        this.f665KLFTb = false;
        this.f670xJ = null;
        this.f667lgHUyS = new HashMap();
        this.f669wA = context;
        mo371xJ(null);
    }

    /* renamed from: AZxh */
    public final void m372AZxh(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f663AZxh + 1;
        int[] iArr = this.f668mjFkc;
        if (i2 > iArr.length) {
            this.f668mjFkc = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f668mjFkc;
        int i3 = this.f663AZxh;
        iArr2[i3] = i;
        this.f663AZxh = i3 + 1;
    }

    /* renamed from: Dt */
    public void m373Dt(ConstraintLayout constraintLayout) {
    }

    /* renamed from: ETF */
    public void m374ETF(ConstraintLayout constraintLayout) {
    }

    /* renamed from: JHa */
    public final int m375JHa(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iM376KLFTb = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objM392JHa = constraintLayout.m392JHa(0, str);
            if (objM392JHa instanceof Integer) {
                iM376KLFTb = ((Integer) objM392JHa).intValue();
            }
        }
        if (iM376KLFTb == 0 && constraintLayout != null) {
            iM376KLFTb = m376KLFTb(constraintLayout, str);
        }
        if (iM376KLFTb == 0) {
            try {
                iM376KLFTb = AbstractC4723v4.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iM376KLFTb == 0 ? this.f669wA.getResources().getIdentifier(str, "id", this.f669wA.getPackageName()) : iM376KLFTb;
    }

    /* renamed from: KLFTb */
    public final int m376KLFTb(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f669wA.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* renamed from: MiMN */
    public void m377MiMN() {
        if (this.f666ZfxDd == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.C0052AZxh) {
            ((ConstraintLayout.C0052AZxh) layoutParams).f760xROA = (C3776gjvQ) this.f666ZfxDd;
        }
    }

    /* renamed from: VA */
    public void m378VA(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String str;
        int iM376KLFTb;
        if (isInEditMode()) {
            m382setIds(this.f664JHa);
        }
        InterfaceC4718v interfaceC4718v = this.f666ZfxDd;
        if (interfaceC4718v == null) {
            return;
        }
        interfaceC4718v.mo13742wA();
        for (int i = 0; i < this.f663AZxh; i++) {
            int i2 = this.f668mjFkc[i];
            View viewM400lgHUyS = constraintLayout.m400lgHUyS(i2);
            if (viewM400lgHUyS == null && (iM376KLFTb = m376KLFTb(constraintLayout, (str = (String) this.f667lgHUyS.get(Integer.valueOf(i2))))) != 0) {
                this.f668mjFkc[i] = iM376KLFTb;
                this.f667lgHUyS.put(Integer.valueOf(iM376KLFTb), str);
                viewM400lgHUyS = constraintLayout.m400lgHUyS(iM376KLFTb);
            }
            if (viewM400lgHUyS != null) {
                this.f666ZfxDd.mo13741AZxh(constraintLayout.m402qdMbNW(viewM400lgHUyS));
            }
        }
        this.f666ZfxDd.mo8019mjFkc(constraintLayout.f695wA);
    }

    /* renamed from: ZfxDd */
    public void m379ZfxDd(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.f663AZxh; i++) {
            View viewM400lgHUyS = constraintLayout.m400lgHUyS(this.f668mjFkc[i]);
            if (viewM400lgHUyS != null) {
                viewM400lgHUyS.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewM400lgHUyS.setTranslationZ(viewM400lgHUyS.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f668mjFkc, this.f663AZxh);
    }

    /* renamed from: lgHUyS */
    public abstract void mo370lgHUyS(C3776gjvQ c3776gjvQ, boolean z);

    /* renamed from: mjFkc */
    public final void m380mjFkc(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f669wA == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iM375JHa = m375JHa(strTrim);
        if (iM375JHa != 0) {
            this.f667lgHUyS.put(Integer.valueOf(iM375JHa), strTrim);
            m372AZxh(iM375JHa);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f664JHa;
        if (str != null) {
            m382setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f665KLFTb) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: qdMbNW */
    public void m381qdMbNW(ConstraintLayout constraintLayout) {
    }

    /* renamed from: setIds */
    public void m382setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f664JHa = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f663AZxh = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                m380mjFkc(str.substring(i));
                return;
            } else {
                m380mjFkc(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f664JHa = null;
        this.f663AZxh = 0;
        for (int i : iArr) {
            m372AZxh(i);
        }
    }

    /* renamed from: wA */
    public void m383wA() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        m379ZfxDd((ConstraintLayout) parent);
    }

    /* renamed from: xJ */
    public void mo371xJ(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f10949CTcA) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f664JHa = string;
                    m382setIds(string);
                }
            }
        }
    }

    public AbstractC0050AZxh(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f668mjFkc = new int[32];
        this.f665KLFTb = false;
        this.f670xJ = null;
        this.f667lgHUyS = new HashMap();
        this.f669wA = context;
        mo371xJ(attributeSet);
    }
}
