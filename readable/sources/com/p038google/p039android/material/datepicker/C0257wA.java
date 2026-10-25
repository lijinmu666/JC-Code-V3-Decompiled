package com.p038google.p039android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;
import p131o.AbstractC1870E9;
import p131o.AbstractC2007G4;
import p131o.AbstractC4567sjsh;
import p131o.AbstractC5019zZ;
import p131o.C4656u2;
import p131o.C4715uxlM;
import p131o.InterfaceC2981UlIi;

/* renamed from: com.google.android.material.datepicker.wA */
/* loaded from: classes.dex */
public class C0257wA extends BaseAdapter {

    /* renamed from: AZxh */
    public Collection f2665AZxh;

    /* renamed from: ZfxDd */
    public final C0256mjFkc f2666ZfxDd;

    /* renamed from: mjFkc */
    public final C4656u2 f2667mjFkc;

    /* renamed from: wA */
    public C4715uxlM f2668wA;

    /* renamed from: KLFTb */
    public static final int f2664KLFTb = AbstractC1870E9.m8116lgHUyS().getMaximum(4);

    /* renamed from: JHa */
    public static final int f2663JHa = (AbstractC1870E9.m8116lgHUyS().getMaximum(5) + AbstractC1870E9.m8116lgHUyS().getMaximum(7)) - 1;

    public C0257wA(C4656u2 c4656u2, InterfaceC2981UlIi interfaceC2981UlIi, C0256mjFkc c0256mjFkc, AbstractC4567sjsh abstractC4567sjsh) {
        this.f2667mjFkc = c4656u2;
        this.f2666ZfxDd = c0256mjFkc;
        this.f2665AZxh = interfaceC2981UlIi.m10641KLFTb();
    }

    /* renamed from: AZxh */
    public int m2927AZxh() {
        return this.f2667mjFkc.m13670VA(this.f2666ZfxDd.m2923wA());
    }

    /* renamed from: Dt */
    public int m2928Dt() {
        return (m2927AZxh() + this.f2667mjFkc.f16766KLFTb) - 1;
    }

    /* renamed from: ETF */
    public int m2929ETF(int i) {
        return (i - m2927AZxh()) + 1;
    }

    /* renamed from: JHa */
    public final void m2930JHa(Context context) {
        if (this.f2668wA == null) {
            this.f2668wA = new C4715uxlM(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* renamed from: KLFTb, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        m2930JHa(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC2007G4.f8316VA, viewGroup, false);
        }
        int iM2927AZxh = i - m2927AZxh();
        if (iM2927AZxh >= 0) {
            C4656u2 c4656u2 = this.f2667mjFkc;
            if (iM2927AZxh >= c4656u2.f16766KLFTb) {
                textView.setVisibility(8);
                textView.setEnabled(false);
                i2 = -1;
            } else {
                i2 = iM2927AZxh + 1;
                textView.setTag(c4656u2);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        m2933VA(textView, item.longValue(), i2);
        return textView;
    }

    /* renamed from: MiMN */
    public final void m2932MiMN(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (C4656u2.m13665Dt(j).m13672equals(this.f2667mjFkc)) {
            int iM13671YoKzxo = this.f2667mjFkc.m13671YoKzxo(j);
            m2933VA((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().m2937mjFkc(iM13671YoKzxo) - materialCalendarGridView.getFirstVisiblePosition()), j, iM13671YoKzxo);
        }
    }

    /* renamed from: VA */
    public final void m2933VA(TextView textView, long j, int i) {
        if (textView == null) {
            return;
        }
        textView.setContentDescription(m2940wA(textView.getContext(), j));
        this.f2666ZfxDd.m2922mjFkc();
        throw null;
    }

    /* renamed from: YoKzxo */
    public void m2934YoKzxo(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f2665AZxh.iterator();
        while (it.hasNext()) {
            m2932MiMN(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: ZfxDd, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < m2927AZxh() || i > m2928Dt()) {
            return null;
        }
        return Long.valueOf(this.f2667mjFkc.m13669MiMN(m2929ETF(i)));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f2663JHa;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f2667mjFkc.f16767ZfxDd;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* renamed from: lgHUyS */
    public boolean m2936lgHUyS(long j) {
        throw null;
    }

    /* renamed from: mjFkc */
    public int m2937mjFkc(int i) {
        return m2927AZxh() + (i - 1);
    }

    /* renamed from: qdMbNW */
    public final boolean m2938qdMbNW(long j) {
        return AbstractC1870E9.m8113JHa().getTimeInMillis() == j;
    }

    /* renamed from: rkYL */
    public boolean m2939rkYL(int i) {
        return i >= m2927AZxh() && i <= m2928Dt();
    }

    /* renamed from: wA */
    public final String m2940wA(Context context, long j) {
        return AbstractC5019zZ.m14117mjFkc(context, j, m2938qdMbNW(j), m2936lgHUyS(j), m2941xJ(j));
    }

    /* renamed from: xJ */
    public boolean m2941xJ(long j) {
        throw null;
    }
}
