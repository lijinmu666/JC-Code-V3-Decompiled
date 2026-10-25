package p131o;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.SV */
/* loaded from: classes.dex */
public final class C2832SV implements InterfaceC2574OV {

    /* renamed from: mjFkc */
    public final List f10562mjFkc;

    public C2832SV(Context context, AbstractC2700QV abstractC2700QV) {
        ArrayList arrayList = new ArrayList();
        this.f10562mjFkc = arrayList;
        if (abstractC2700QV.mo9369wA()) {
            arrayList.add(new C4222nW(context, abstractC2700QV));
        }
    }

    @Override // p131o.InterfaceC2574OV
    /* renamed from: mjFkc */
    public final void mo9900mjFkc(InterfaceC2443MV interfaceC2443MV) {
        Iterator it = this.f10562mjFkc.iterator();
        while (it.hasNext()) {
            ((InterfaceC2574OV) it.next()).mo9900mjFkc(interfaceC2443MV);
        }
    }
}
