package p131o;

import android.view.View;

/* renamed from: o.la */
/* loaded from: classes.dex */
public class C4092la {

    /* renamed from: AZxh */
    public int f14765AZxh;

    /* renamed from: KLFTb */
    public int f14767KLFTb;

    /* renamed from: ZfxDd */
    public int f14768ZfxDd;

    /* renamed from: mjFkc */
    public final View f14769mjFkc;

    /* renamed from: wA */
    public int f14770wA;

    /* renamed from: JHa */
    public boolean f14766JHa = true;

    /* renamed from: xJ */
    public boolean f14771xJ = true;

    public C4092la(View view) {
        this.f14769mjFkc = view;
    }

    /* renamed from: AZxh */
    public int m12695AZxh() {
        return this.f14768ZfxDd;
    }

    /* renamed from: KLFTb */
    public boolean m12696KLFTb(int i) {
        if (!this.f14766JHa || this.f14768ZfxDd == i) {
            return false;
        }
        this.f14768ZfxDd = i;
        m12698mjFkc();
        return true;
    }

    /* renamed from: ZfxDd */
    public boolean m12697ZfxDd(int i) {
        if (!this.f14771xJ || this.f14767KLFTb == i) {
            return false;
        }
        this.f14767KLFTb = i;
        m12698mjFkc();
        return true;
    }

    /* renamed from: mjFkc */
    public void m12698mjFkc() {
        View view = this.f14769mjFkc;
        AbstractC2876T9.m10240KRTLGT(view, this.f14768ZfxDd - (view.getTop() - this.f14765AZxh));
        View view2 = this.f14769mjFkc;
        AbstractC2876T9.m10259WrLQs(view2, this.f14767KLFTb - (view2.getLeft() - this.f14770wA));
    }

    /* renamed from: wA */
    public void m12699wA() {
        this.f14765AZxh = this.f14769mjFkc.getTop();
        this.f14770wA = this.f14769mjFkc.getLeft();
    }
}
