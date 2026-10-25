package com.p038google.p039android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
import p131o.AbstractC1803D4;
import p131o.AbstractC1870E9;
import p131o.AbstractC2876T9;
import p131o.C2409M1;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: AZxh */
    public final boolean f2646AZxh;

    /* renamed from: mjFkc */
    public final Calendar f2647mjFkc;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendarGridView$mjFkc */
    public class C0254mjFkc extends C2454MiMN {
        public C0254mjFkc() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10540JBhc(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C0257wA getAdapter() {
        return (C0257wA) super.getAdapter();
    }

    /* renamed from: mjFkc */
    public final void m2910mjFkc(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().m2928Dt());
        } else if (i == 130) {
            setSelection(getAdapter().m2927AZxh());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C0257wA adapter = getAdapter();
        adapter.getClass();
        int iMax = Math.max(adapter.m2927AZxh(), getFirstVisiblePosition());
        int iMin = Math.min(adapter.m2928Dt(), getLastVisiblePosition());
        adapter.getItem(iMax);
        adapter.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            m2910mjFkc(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().m2927AZxh()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().m2927AZxh());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.f2646AZxh) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().m2927AZxh()) {
            super.setSelection(getAdapter().m2927AZxh());
        } else {
            super.setSelection(i);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2647mjFkc = AbstractC1870E9.m8116lgHUyS();
        if (C2409M1.m9416ybBTr(getContext())) {
            setNextFocusLeftId(AbstractC1803D4.f7816mjFkc);
            setNextFocusRightId(AbstractC1803D4.f7822wA);
        }
        this.f2646AZxh = C2409M1.m9415oaI(getContext());
        AbstractC2876T9.m10265alEkx(this, new C0254mjFkc());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof C0257wA)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), C0257wA.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
