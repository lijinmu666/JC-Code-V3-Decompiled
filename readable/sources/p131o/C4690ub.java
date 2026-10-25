package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: o.ub */
/* loaded from: classes.dex */
public class C4690ub implements InterfaceC3443bc {
    @Override // p131o.InterfaceC3443bc
    /* renamed from: AZxh */
    public float mo11552AZxh(InterfaceC4867xCVa interfaceC4867xCVa) {
        return m13719qGY(interfaceC4867xCVa).m8265wA();
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: Dt */
    public void mo11553Dt(InterfaceC4867xCVa interfaceC4867xCVa) {
        mo11565wA(interfaceC4867xCVa, mo11552AZxh(interfaceC4867xCVa));
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: ETF */
    public float mo11554ETF(InterfaceC4867xCVa interfaceC4867xCVa) {
        return m13719qGY(interfaceC4867xCVa).m8261ZfxDd();
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: JHa */
    public float mo11555JHa(InterfaceC4867xCVa interfaceC4867xCVa) {
        return mo11554ETF(interfaceC4867xCVa) * 2.0f;
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: KLFTb */
    public void mo11556KLFTb(InterfaceC4867xCVa interfaceC4867xCVa) {
        mo11565wA(interfaceC4867xCVa, mo11552AZxh(interfaceC4867xCVa));
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: MiMN */
    public float mo11557MiMN(InterfaceC4867xCVa interfaceC4867xCVa) {
        return interfaceC4867xCVa.mo12890mjFkc().getElevation();
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: VA */
    public void mo11558VA(InterfaceC4867xCVa interfaceC4867xCVa) {
        if (!interfaceC4867xCVa.mo12888KLFTb()) {
            interfaceC4867xCVa.mo12886AZxh(0, 0, 0, 0);
            return;
        }
        float fMo11552AZxh = mo11552AZxh(interfaceC4867xCVa);
        float fMo11554ETF = mo11554ETF(interfaceC4867xCVa);
        int iCeil = (int) Math.ceil(AbstractC2008G5.m8404mjFkc(fMo11552AZxh, fMo11554ETF, interfaceC4867xCVa.mo12889ZfxDd()));
        int iCeil2 = (int) Math.ceil(AbstractC2008G5.m8403AZxh(fMo11552AZxh, fMo11554ETF, interfaceC4867xCVa.mo12889ZfxDd()));
        interfaceC4867xCVa.mo12886AZxh(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: YoKzxo */
    public void mo11559YoKzxo(InterfaceC4867xCVa interfaceC4867xCVa, float f) {
        m13719qGY(interfaceC4867xCVa).m8262lgHUyS(f);
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: ZfxDd */
    public float mo11560ZfxDd(InterfaceC4867xCVa interfaceC4867xCVa) {
        return mo11554ETF(interfaceC4867xCVa) * 2.0f;
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: lgHUyS */
    public void mo11561lgHUyS() {
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: mjFkc */
    public ColorStateList mo11562mjFkc(InterfaceC4867xCVa interfaceC4867xCVa) {
        return m13719qGY(interfaceC4867xCVa).m8258AZxh();
    }

    /* renamed from: qGY */
    public final C1935F5 m13719qGY(InterfaceC4867xCVa interfaceC4867xCVa) {
        return (C1935F5) interfaceC4867xCVa.mo12887JHa();
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: qdMbNW */
    public void mo11563qdMbNW(InterfaceC4867xCVa interfaceC4867xCVa, ColorStateList colorStateList) {
        m13719qGY(interfaceC4867xCVa).m8259JHa(colorStateList);
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: rkYL */
    public void mo11564rkYL(InterfaceC4867xCVa interfaceC4867xCVa, float f) {
        interfaceC4867xCVa.mo12890mjFkc().setElevation(f);
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: wA */
    public void mo11565wA(InterfaceC4867xCVa interfaceC4867xCVa, float f) {
        m13719qGY(interfaceC4867xCVa).m8266xJ(f, interfaceC4867xCVa.mo12888KLFTb(), interfaceC4867xCVa.mo12889ZfxDd());
        mo11558VA(interfaceC4867xCVa);
    }

    @Override // p131o.InterfaceC3443bc
    /* renamed from: xJ */
    public void mo11566xJ(InterfaceC4867xCVa interfaceC4867xCVa, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        interfaceC4867xCVa.mo12891wA(new C1935F5(colorStateList, f));
        View viewMo12890mjFkc = interfaceC4867xCVa.mo12890mjFkc();
        viewMo12890mjFkc.setClipToOutline(true);
        viewMo12890mjFkc.setElevation(f2);
        mo11565wA(interfaceC4867xCVa, f3);
    }
}
