package androidx.viewpager2.p025adapter;

import android.os.Handler;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import p131o.InterfaceC3068W0;

/* loaded from: classes.dex */
class FragmentStateAdapter$4 implements InterfaceC0104KLFTb {

    /* renamed from: AZxh */
    public final /* synthetic */ Runnable f1953AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ Handler f1954mjFkc;

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
        if (mjfkc == AbstractC0112wA.mjFkc.ON_DESTROY) {
            this.f1954mjFkc.removeCallbacks(this.f1953AZxh);
            interfaceC3068W0.mo770JHa().mo1046wA(this);
        }
    }
}
