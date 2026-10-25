package androidx.fragment.p022app;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import p131o.InterfaceC3068W0;

/* loaded from: classes.dex */
class FragmentManager$6 implements InterfaceC0104KLFTb {

    /* renamed from: AZxh */
    public final /* synthetic */ AbstractC0112wA f1182AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ String f1183mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ AbstractC0093KLFTb f1184wA;

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
        if (mjfkc == AbstractC0112wA.mjFkc.ON_START && ((Bundle) this.f1184wA.f1220lgHUyS.get(this.f1183mjFkc)) != null) {
            throw null;
        }
        if (mjfkc == AbstractC0112wA.mjFkc.ON_DESTROY) {
            this.f1182AZxh.mo1046wA(this);
            this.f1184wA.f1224qdMbNW.remove(this.f1183mjFkc);
        }
    }
}
