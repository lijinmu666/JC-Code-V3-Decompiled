package androidx.activity;

import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import p131o.AbstractC3204Y2;
import p131o.InterfaceC3041VfB;
import p131o.InterfaceC3068W0;

/* loaded from: classes.dex */
class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements InterfaceC0104KLFTb, InterfaceC3041VfB {

    /* renamed from: AZxh */
    public final AbstractC3204Y2 f201AZxh;

    /* renamed from: mjFkc */
    public final AbstractC0112wA f202mjFkc;

    /* renamed from: wA */
    public InterfaceC3041VfB f203wA;

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
        if (mjfkc == AbstractC0112wA.mjFkc.ON_START) {
            throw null;
        }
        if (mjfkc != AbstractC0112wA.mjFkc.ON_STOP) {
            if (mjfkc == AbstractC0112wA.mjFkc.ON_DESTROY) {
                mo6cancel();
            }
        } else {
            InterfaceC3041VfB interfaceC3041VfB = this.f203wA;
            if (interfaceC3041VfB != null) {
                interfaceC3041VfB.mo6cancel();
            }
        }
    }

    @Override // p131o.InterfaceC3041VfB
    /* renamed from: cancel */
    public void mo6cancel() {
        this.f202mjFkc.mo1046wA(this);
        this.f201AZxh.m11044mjFkc(this);
        InterfaceC3041VfB interfaceC3041VfB = this.f203wA;
        if (interfaceC3041VfB != null) {
            interfaceC3041VfB.mo6cancel();
            this.f203wA = null;
        }
    }
}
