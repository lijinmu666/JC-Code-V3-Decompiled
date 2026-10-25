package androidx.activity.p008result;

import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import p131o.InterfaceC3068W0;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements InterfaceC0104KLFTb {
    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
        if (AbstractC0112wA.mjFkc.ON_START.equals(mjfkc) || AbstractC0112wA.mjFkc.ON_STOP.equals(mjfkc) || AbstractC0112wA.mjFkc.ON_DESTROY.equals(mjfkc)) {
            throw null;
        }
    }
}
