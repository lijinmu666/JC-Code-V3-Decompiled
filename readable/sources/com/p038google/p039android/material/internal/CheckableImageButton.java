package com.p038google.p039android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import p131o.AbstractC2876T9;
import p131o.AbstractC3862i4;
import p131o.AbstractC4796wA;
import p131o.C1622ANMGZc;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
public class CheckableImageButton extends C1622ANMGZc implements Checkable {

    /* renamed from: xJ */
    public static final int[] f2673xJ = {R.attr.state_checked};

    /* renamed from: JHa */
    public boolean f2674JHa;

    /* renamed from: KLFTb */
    public boolean f2675KLFTb;

    /* renamed from: ZfxDd */
    public boolean f2676ZfxDd;

    /* renamed from: com.google.android.material.internal.CheckableImageButton$AZxh */
    public static class C0258AZxh extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0258AZxh> f2677CREATOR = new mjFkc();

        /* renamed from: wA */
        public boolean f2678wA;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$AZxh$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0258AZxh createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0258AZxh(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0258AZxh createFromParcel(Parcel parcel) {
                return new C0258AZxh(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0258AZxh[] newArray(int i) {
                return new C0258AZxh[i];
            }
        }

        public C0258AZxh(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: AZxh */
        private void m2956AZxh(Parcel parcel) {
            this.f2678wA = parcel.readInt() == 1;
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2678wA ? 1 : 0);
        }

        public C0258AZxh(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m2956AZxh(parcel);
        }
    }

    /* renamed from: com.google.android.material.internal.CheckableImageButton$mjFkc */
    public class C0259mjFkc extends C2454MiMN {
        public C0259mjFkc() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: JHa */
        public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
            super.mo619JHa(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10564WGXroI(CheckableImageButton.this.m2955mjFkc());
            c2971Ucbh.m10566XV(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3862i4.f14119rkYL);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2676ZfxDd;
    }

    /* renamed from: mjFkc */
    public boolean m2955mjFkc() {
        return this.f2675KLFTb;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (!this.f2676ZfxDd) {
            return super.onCreateDrawableState(i);
        }
        int[] iArr = f2673xJ;
        return View.mergeDrawableStates(super.onCreateDrawableState(i + iArr.length), iArr);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0258AZxh)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0258AZxh c0258AZxh = (C0258AZxh) parcelable;
        super.onRestoreInstanceState(c0258AZxh.m13824mjFkc());
        setChecked(c0258AZxh.f2678wA);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0258AZxh c0258AZxh = new C0258AZxh(super.onSaveInstanceState());
        c0258AZxh.f2678wA = this.f2676ZfxDd;
        return c0258AZxh;
    }

    public void setCheckable(boolean z) {
        if (this.f2675KLFTb != z) {
            this.f2675KLFTb = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f2675KLFTb || this.f2676ZfxDd == z) {
            return;
        }
        this.f2676ZfxDd = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.f2674JHa = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f2674JHa) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2676ZfxDd);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2675KLFTb = true;
        this.f2674JHa = true;
        AbstractC2876T9.m10265alEkx(this, new C0259mjFkc());
    }
}
