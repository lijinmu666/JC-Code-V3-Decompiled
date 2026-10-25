package com.p038google.p039android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.p023widget.RecyclerView;
import com.p038google.p039android.material.datepicker.C0253AZxh;
import p131o.AbstractC1803D4;
import p131o.AbstractC2007G4;
import p131o.AbstractC2876T9;
import p131o.AbstractC4567sjsh;
import p131o.C2409M1;
import p131o.C4656u2;
import p131o.InterfaceC2981UlIi;

/* renamed from: com.google.android.material.datepicker.ZfxDd */
/* loaded from: classes.dex */
public class C0255ZfxDd extends RecyclerView.AbstractC0156lgHUyS {

    /* renamed from: JHa */
    public final int f2649JHa;

    /* renamed from: KLFTb */
    public final C0253AZxh.MiMN f2650KLFTb;

    /* renamed from: ZfxDd */
    public final C0256mjFkc f2651ZfxDd;

    /* renamed from: com.google.android.material.datepicker.ZfxDd$AZxh */
    public static class AZxh extends RecyclerView.AbstractC0157mByQ {

        /* renamed from: Ucbh */
        public final MaterialCalendarGridView f2652Ucbh;

        /* renamed from: eyqo */
        public final TextView f2653eyqo;

        public AZxh(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(AbstractC1803D4.f7801Pq);
            this.f2653eyqo = textView;
            AbstractC2876T9.m10270dm(textView, true);
            this.f2652Ucbh = (MaterialCalendarGridView) linearLayout.findViewById(AbstractC1803D4.f7820rkYL);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* renamed from: com.google.android.material.datepicker.ZfxDd$mjFkc */
    public class mjFkc implements AdapterView.OnItemClickListener {

        /* renamed from: mjFkc */
        public final /* synthetic */ MaterialCalendarGridView f2655mjFkc;

        public mjFkc(MaterialCalendarGridView materialCalendarGridView) {
            this.f2655mjFkc = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.f2655mjFkc.getAdapter().m2939rkYL(i)) {
                C0255ZfxDd.this.f2650KLFTb.mo2906mjFkc(this.f2655mjFkc.getAdapter().getItem(i).longValue());
            }
        }
    }

    public C0255ZfxDd(Context context, InterfaceC2981UlIi interfaceC2981UlIi, C0256mjFkc c0256mjFkc, AbstractC4567sjsh abstractC4567sjsh, C0253AZxh.MiMN miMN) {
        C4656u2 c4656u2M2924xJ = c0256mjFkc.m2924xJ();
        C4656u2 c4656u2M2917AZxh = c0256mjFkc.m2917AZxh();
        C4656u2 c4656u2M2918JHa = c0256mjFkc.m2918JHa();
        if (c4656u2M2924xJ.compareTo(c4656u2M2918JHa) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (c4656u2M2918JHa.compareTo(c4656u2M2917AZxh) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f2649JHa = (C0257wA.f2664KLFTb * C0253AZxh.m2890Xxz(context)) + (C2409M1.m9416ybBTr(context) ? C0253AZxh.m2890Xxz(context) : 0);
        this.f2651ZfxDd = c0256mjFkc;
        this.f2650KLFTb = miMN;
        m1662Pq(true);
    }

    /* renamed from: Gd */
    public int m2912Gd(C4656u2 c4656u2) {
        return this.f2651ZfxDd.m2924xJ().m13668IEE(c4656u2);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: HGpJ, reason: merged with bridge method [inline-methods] */
    public void mo1656Dt(AZxh aZxh, int i) {
        C4656u2 c4656u2M13673fehf = this.f2651ZfxDd.m2924xJ().m13673fehf(i);
        aZxh.f2653eyqo.setText(c4656u2M13673fehf.m13676rkYL());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aZxh.f2652Ucbh.findViewById(AbstractC1803D4.f7820rkYL);
        if (materialCalendarGridView.getAdapter() == null || !c4656u2M13673fehf.m13672equals(materialCalendarGridView.getAdapter().f2667mjFkc)) {
            C0257wA c0257wA = new C0257wA(c4656u2M13673fehf, null, this.f2651ZfxDd, null);
            materialCalendarGridView.setNumColumns(c4656u2M13673fehf.f16767ZfxDd);
            materialCalendarGridView.setAdapter((ListAdapter) c0257wA);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m2934YoKzxo(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new mjFkc(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: KLFTb */
    public long mo1660KLFTb(int i) {
        return this.f2651ZfxDd.m2924xJ().m13673fehf(i).m13675qGY();
    }

    /* renamed from: Ucbh */
    public C4656u2 m2914Ucbh(int i) {
        return this.f2651ZfxDd.m2924xJ().m13673fehf(i);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: ZfxDd */
    public int mo1665ZfxDd() {
        return this.f2651ZfxDd.m2919ZfxDd();
    }

    /* renamed from: huTpC */
    public CharSequence m2915huTpC(int i) {
        return m2914Ucbh(i).m13676rkYL();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: vI, reason: merged with bridge method [inline-methods] */
    public AZxh mo1663VA(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC2007G4.f8326rkYL, viewGroup, false);
        if (!C2409M1.m9416ybBTr(viewGroup.getContext())) {
            return new AZxh(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.C0153fehf(-1, this.f2649JHa));
        return new AZxh(linearLayout, true);
    }
}
