package com.p038google.p039android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.p015widget.ConstraintLayout;
import com.p038google.p039android.material.p058button.MaterialButtonToggleGroup;
import com.p038google.p039android.material.p059chip.C0251Chip;
import p131o.AbstractC1803D4;
import p131o.AbstractC2007G4;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: BAnRFn */
    public final MaterialButtonToggleGroup f2970BAnRFn;

    /* renamed from: Gd */
    public final C0251Chip f2971Gd;

    /* renamed from: HGpJ */
    public final C0251Chip f2972HGpJ;

    /* renamed from: VocHEe */
    public final ClockFaceView f2973VocHEe;

    /* renamed from: lB */
    public final View.OnClickListener f2974lB;

    /* renamed from: vI */
    public final ClockHandView f2975vI;

    /* renamed from: com.google.android.material.timepicker.TimePickerView$AZxh */
    public class C0299AZxh extends GestureDetector.SimpleOnGestureListener {
        public C0299AZxh() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.m3315Ucbh(TimePickerView.this);
            return false;
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$KLFTb */
    public interface InterfaceC0300KLFTb {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$ZfxDd */
    public interface InterfaceC0301ZfxDd {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$mjFkc */
    public class ViewOnClickListenerC0302mjFkc implements View.OnClickListener {
        public ViewOnClickListenerC0302mjFkc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.m3317eyqo(TimePickerView.this);
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$wA */
    public class ViewOnTouchListenerC0303wA implements View.OnTouchListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ GestureDetector f2979mjFkc;

        public ViewOnTouchListenerC0303wA(GestureDetector gestureDetector) {
            this.f2979mjFkc = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f2979mjFkc.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: Ucbh */
    public static /* synthetic */ InterfaceC0301ZfxDd m3315Ucbh(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* renamed from: eyqo */
    public static /* synthetic */ InterfaceC0300KLFTb m3317eyqo(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* renamed from: Gd */
    public final void m3318Gd() {
        this.f2971Gd.setTag(AbstractC1803D4.f7823wJVbdd, 12);
        this.f2972HGpJ.setTag(AbstractC1803D4.f7823wJVbdd, 10);
        this.f2971Gd.setOnClickListener(this.f2974lB);
        this.f2972HGpJ.setOnClickListener(this.f2974lB);
        this.f2971Gd.setAccessibilityClassName("android.view.View");
        this.f2972HGpJ.setAccessibilityClassName("android.view.View");
    }

    /* renamed from: HGpJ */
    public final void m3319HGpJ() {
        ViewOnTouchListenerC0303wA viewOnTouchListenerC0303wA = new ViewOnTouchListenerC0303wA(new GestureDetector(getContext(), new C0299AZxh()));
        this.f2971Gd.setOnTouchListener(viewOnTouchListenerC0303wA);
        this.f2972HGpJ.setOnTouchListener(viewOnTouchListenerC0303wA);
    }

    /* renamed from: huTpC */
    public final /* synthetic */ void m3320huTpC(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.f2972HGpJ.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2974lB = new ViewOnClickListenerC0302mjFkc();
        LayoutInflater.from(context).inflate(AbstractC2007G4.f8310ETF, this);
        this.f2973VocHEe = (ClockFaceView) findViewById(AbstractC1803D4.f7824xJ);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(AbstractC1803D4.f7790Dt);
        this.f2970BAnRFn = materialButtonToggleGroup;
        materialButtonToggleGroup.m2600AZxh(new MaterialButtonToggleGroup.InterfaceC0241ZfxDd() { // from class: com.google.android.material.timepicker.AZxh
            @Override // com.p038google.p039android.material.p058button.MaterialButtonToggleGroup.InterfaceC0241ZfxDd
            /* renamed from: mjFkc */
            public final void mo2618mjFkc(MaterialButtonToggleGroup materialButtonToggleGroup2, int i2, boolean z) {
                this.f2925mjFkc.m3320huTpC(materialButtonToggleGroup2, i2, z);
            }
        });
        this.f2971Gd = (C0251Chip) findViewById(AbstractC1803D4.f7798MiMN);
        this.f2972HGpJ = (C0251Chip) findViewById(AbstractC1803D4.f7791ETF);
        this.f2975vI = (ClockHandView) findViewById(AbstractC1803D4.f7814lgHUyS);
        m3319HGpJ();
        m3318Gd();
    }
}
