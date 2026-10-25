package com.p038google.p039android.material.p058button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.p038google.p039android.material.p058button.MaterialButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import p131o.AbstractC1599A1;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4557sa;
import p131o.C2141I6;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;
import p131o.C3311ZfxDd;
import p131o.InterfaceC3498cQmsjG;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: ETF */
    public static final int f2450ETF = AbstractC2737R4.f10365ETF;

    /* renamed from: AZxh */
    public final C0240KLFTb f2451AZxh;

    /* renamed from: Dt */
    public Set f2452Dt;

    /* renamed from: JHa */
    public boolean f2453JHa;

    /* renamed from: KLFTb */
    public Integer[] f2454KLFTb;

    /* renamed from: ZfxDd */
    public final Comparator f2455ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f2456lgHUyS;

    /* renamed from: mjFkc */
    public final List f2457mjFkc;

    /* renamed from: qdMbNW */
    public final int f2458qdMbNW;

    /* renamed from: wA */
    public final LinkedHashSet f2459wA;

    /* renamed from: xJ */
    public boolean f2460xJ;

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$AZxh */
    public class C0239AZxh extends C2454MiMN {
        public C0239AZxh() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10561Vdz(C2971Ucbh.JHa.m10610mjFkc(0, 1, MaterialButtonToggleGroup.this.m2614qdMbNW(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$KLFTb */
    public class C0240KLFTb implements MaterialButton.InterfaceC0238mjFkc {
        public C0240KLFTb() {
        }

        @Override // com.p038google.p039android.material.p058button.MaterialButton.InterfaceC0238mjFkc
        /* renamed from: mjFkc */
        public void mo2597mjFkc(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ C0240KLFTb(MaterialButtonToggleGroup materialButtonToggleGroup, C0242mjFkc c0242mjFkc) {
            this();
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$ZfxDd */
    public interface InterfaceC0241ZfxDd {
        /* renamed from: mjFkc */
        void mo2618mjFkc(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$mjFkc */
    public class C0242mjFkc implements Comparator {
        public C0242mjFkc() {
        }

        @Override // java.util.Comparator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$wA */
    public static class C0243wA {

        /* renamed from: KLFTb */
        public static final InterfaceC3498cQmsjG f2464KLFTb = new C3311ZfxDd(0.0f);

        /* renamed from: AZxh */
        public InterfaceC3498cQmsjG f2465AZxh;

        /* renamed from: ZfxDd */
        public InterfaceC3498cQmsjG f2466ZfxDd;

        /* renamed from: mjFkc */
        public InterfaceC3498cQmsjG f2467mjFkc;

        /* renamed from: wA */
        public InterfaceC3498cQmsjG f2468wA;

        public C0243wA(InterfaceC3498cQmsjG interfaceC3498cQmsjG, InterfaceC3498cQmsjG interfaceC3498cQmsjG2, InterfaceC3498cQmsjG interfaceC3498cQmsjG3, InterfaceC3498cQmsjG interfaceC3498cQmsjG4) {
            this.f2467mjFkc = interfaceC3498cQmsjG;
            this.f2465AZxh = interfaceC3498cQmsjG3;
            this.f2468wA = interfaceC3498cQmsjG4;
            this.f2466ZfxDd = interfaceC3498cQmsjG2;
        }

        /* renamed from: AZxh */
        public static C0243wA m2620AZxh(C0243wA c0243wA, View view) {
            return AbstractC4557sa.m13503KLFTb(view) ? m2625wA(c0243wA) : m2623ZfxDd(c0243wA);
        }

        /* renamed from: JHa */
        public static C0243wA m2621JHa(C0243wA c0243wA) {
            InterfaceC3498cQmsjG interfaceC3498cQmsjG = c0243wA.f2467mjFkc;
            InterfaceC3498cQmsjG interfaceC3498cQmsjG2 = f2464KLFTb;
            return new C0243wA(interfaceC3498cQmsjG, interfaceC3498cQmsjG2, c0243wA.f2465AZxh, interfaceC3498cQmsjG2);
        }

        /* renamed from: KLFTb */
        public static C0243wA m2622KLFTb(C0243wA c0243wA, View view) {
            return AbstractC4557sa.m13503KLFTb(view) ? m2623ZfxDd(c0243wA) : m2625wA(c0243wA);
        }

        /* renamed from: ZfxDd */
        public static C0243wA m2623ZfxDd(C0243wA c0243wA) {
            InterfaceC3498cQmsjG interfaceC3498cQmsjG = f2464KLFTb;
            return new C0243wA(interfaceC3498cQmsjG, interfaceC3498cQmsjG, c0243wA.f2465AZxh, c0243wA.f2468wA);
        }

        /* renamed from: mjFkc */
        public static C0243wA m2624mjFkc(C0243wA c0243wA) {
            InterfaceC3498cQmsjG interfaceC3498cQmsjG = f2464KLFTb;
            return new C0243wA(interfaceC3498cQmsjG, c0243wA.f2466ZfxDd, interfaceC3498cQmsjG, c0243wA.f2468wA);
        }

        /* renamed from: wA */
        public static C0243wA m2625wA(C0243wA c0243wA) {
            InterfaceC3498cQmsjG interfaceC3498cQmsjG = c0243wA.f2467mjFkc;
            InterfaceC3498cQmsjG interfaceC3498cQmsjG2 = c0243wA.f2466ZfxDd;
            InterfaceC3498cQmsjG interfaceC3498cQmsjG3 = f2464KLFTb;
            return new C0243wA(interfaceC3498cQmsjG, interfaceC3498cQmsjG2, interfaceC3498cQmsjG3, interfaceC3498cQmsjG3);
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13950rkYL);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m2602ETF(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m2602ETF(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && m2602ETF(i2)) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: qGY */
    public static void m2599qGY(C2141I6.AZxh aZxh, C0243wA c0243wA) {
        if (c0243wA == null) {
            aZxh.m8710rkYL(0.0f);
        } else {
            aZxh.m8694BAnRFn(c0243wA.f2467mjFkc).m8703diqgf(c0243wA.f2466ZfxDd).m8699OjSQV(c0243wA.f2465AZxh).m8695Gd(c0243wA.f2468wA);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(AbstractC2876T9.m10280lgHUyS());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f2451AZxh);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    /* renamed from: AZxh */
    public void m2600AZxh(InterfaceC0241ZfxDd interfaceC0241ZfxDd) {
        this.f2459wA.add(interfaceC0241ZfxDd);
    }

    /* renamed from: Dt */
    public final C0243wA m2601Dt(int i, int i2, int i3) {
        C0243wA c0243wA = (C0243wA) this.f2457mjFkc.get(i);
        if (i2 == i3) {
            return c0243wA;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? C0243wA.m2622KLFTb(c0243wA, this) : C0243wA.m2621JHa(c0243wA);
        }
        if (i == i3) {
            return z ? C0243wA.m2620AZxh(c0243wA, this) : C0243wA.m2624mjFkc(c0243wA);
        }
        return null;
    }

    /* renamed from: ETF */
    public final boolean m2602ETF(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    /* renamed from: IEE */
    public final void m2603IEE() {
        TreeMap treeMap = new TreeMap(this.f2455ZfxDd);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(m2613lgHUyS(i), Integer.valueOf(i));
        }
        this.f2454KLFTb = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    /* renamed from: JHa */
    public void m2604JHa() {
        m2612fehf(new HashSet());
    }

    /* renamed from: KLFTb */
    public final void m2605KLFTb(int i, boolean z) {
        if (i == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.f2452Dt);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.f2460xJ && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.f2456lgHUyS || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        m2612fehf(hashSet);
    }

    /* renamed from: MiMN */
    public void m2606MiMN(MaterialButton materialButton, boolean z) {
        if (this.f2453JHa) {
            return;
        }
        m2605KLFTb(materialButton.getId(), z);
    }

    /* renamed from: Pq */
    public void m2607Pq() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButtonM2613lgHUyS = m2613lgHUyS(i);
            if (materialButtonM2613lgHUyS.getVisibility() != 8) {
                C2141I6.AZxh aZxhM8670Ucbh = materialButtonM2613lgHUyS.getShapeAppearanceModel().m8670Ucbh();
                m2599qGY(aZxhM8670Ucbh, m2601Dt(i, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonM2613lgHUyS.setShapeAppearanceModel(aZxhM8670Ucbh.m8698MiMN());
            }
        }
    }

    /* renamed from: VA */
    public boolean m2608VA() {
        return this.f2460xJ;
    }

    /* renamed from: YoKzxo */
    public final void m2609YoKzxo(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) m2613lgHUyS(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            AbstractC1599A1.m7549wA(layoutParams, 0);
            AbstractC1599A1.m7547ZfxDd(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    /* renamed from: ZfxDd */
    public final LinearLayout.LayoutParams m2610ZfxDd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        m2605KLFTb(materialButton.getId(), materialButton.isChecked());
        C2141I6 shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f2457mjFkc.add(new C0243wA(shapeAppearanceModel.m8668IEE(), shapeAppearanceModel.m8664Dt(), shapeAppearanceModel.m8673diqgf(), shapeAppearanceModel.m8671VA()));
        materialButton.setEnabled(isEnabled());
        AbstractC2876T9.m10265alEkx(materialButton, new C0239AZxh());
    }

    /* renamed from: diqgf */
    public final void m2611diqgf() {
        for (int i = 0; i < getChildCount(); i++) {
            m2613lgHUyS(i).setA11yClassName((this.f2460xJ ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        m2603IEE();
        super.dispatchDraw(canvas);
    }

    /* renamed from: fehf */
    public final void m2612fehf(Set set) {
        Set set2 = this.f2452Dt;
        this.f2452Dt = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = m2613lgHUyS(i).getId();
            m2615rkYL(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                m2617xJ(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    public int getCheckedButtonId() {
        if (!this.f2460xJ || this.f2452Dt.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f2452Dt.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = m2613lgHUyS(i).getId();
            if (this.f2452Dt.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.f2454KLFTb;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i2;
    }

    /* renamed from: lgHUyS */
    public final MaterialButton m2613lgHUyS(int i) {
        return (MaterialButton) getChildAt(i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f2458qdMbNW;
        if (i != -1) {
            m2612fehf(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C2971Ucbh.m10526XtE(accessibilityNodeInfo).m10540JBhc(C2971Ucbh.KLFTb.m10611mjFkc(1, getVisibleButtonCount(), false, m2608VA() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        m2607Pq();
        m2616wA();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f2457mjFkc.remove(iIndexOfChild);
        }
        m2607Pq();
        m2616wA();
    }

    /* renamed from: qdMbNW */
    public final int m2614qdMbNW(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof MaterialButton) && m2602ETF(i2)) {
                i++;
            }
        }
        return -1;
    }

    /* renamed from: rkYL */
    public final void m2615rkYL(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof MaterialButton) {
            this.f2453JHa = true;
            ((MaterialButton) viewFindViewById).setChecked(z);
            this.f2453JHa = false;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            m2613lgHUyS(i).setEnabled(z);
        }
    }

    public void setSelectionRequired(boolean z) {
        this.f2456lgHUyS = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f2460xJ != z) {
            this.f2460xJ = z;
            m2604JHa();
        }
        m2611diqgf();
    }

    /* renamed from: wA */
    public final void m2616wA() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButtonM2613lgHUyS = m2613lgHUyS(i);
            int iMin = Math.min(materialButtonM2613lgHUyS.getStrokeWidth(), m2613lgHUyS(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsM2610ZfxDd = m2610ZfxDd(materialButtonM2613lgHUyS);
            if (getOrientation() == 0) {
                AbstractC1599A1.m7549wA(layoutParamsM2610ZfxDd, 0);
                AbstractC1599A1.m7547ZfxDd(layoutParamsM2610ZfxDd, -iMin);
                layoutParamsM2610ZfxDd.topMargin = 0;
            } else {
                layoutParamsM2610ZfxDd.bottomMargin = 0;
                layoutParamsM2610ZfxDd.topMargin = -iMin;
                AbstractC1599A1.m7547ZfxDd(layoutParamsM2610ZfxDd, 0);
            }
            materialButtonM2613lgHUyS.setLayoutParams(layoutParamsM2610ZfxDd);
        }
        m2609YoKzxo(firstVisibleChildIndex);
    }

    /* renamed from: xJ */
    public final void m2617xJ(int i, boolean z) {
        Iterator it = this.f2459wA.iterator();
        while (it.hasNext()) {
            ((InterfaceC0241ZfxDd) it.next()).mo2618mjFkc(this, i, z);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i) {
        int i2 = f2450ETF;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        this.f2457mjFkc = new ArrayList();
        this.f2451AZxh = new C0240KLFTb(this, null);
        this.f2459wA = new LinkedHashSet();
        this.f2455ZfxDd = new C0242mjFkc();
        this.f2453JHa = false;
        this.f2452Dt = new HashSet();
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(getContext(), attributeSet, AbstractC3340a5.f12511XyP, i, i2, new int[0]);
        setSingleSelection(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12469Sx, false));
        this.f2458qdMbNW = typedArrayM12940lgHUyS.getResourceId(AbstractC3340a5.f12582jY, -1);
        this.f2456lgHUyS = typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12477UOnCkw, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12474UDcil, true));
        typedArrayM12940lgHUyS.recycle();
        AbstractC2876T9.m10244NKyg(this, 1);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
