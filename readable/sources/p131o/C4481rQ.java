package p131o;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.rQ */
/* loaded from: classes.dex */
public final class C4481rQ implements InterfaceC4085lQ {

    /* renamed from: mjFkc */
    public final List f16338mjFkc;

    public C4481rQ(Context context, AbstractC4348pQ abstractC4348pQ) {
        ArrayList arrayList = new ArrayList();
        this.f16338mjFkc = arrayList;
        if (abstractC4348pQ.mo12221wA()) {
            arrayList.add(new C2437MQ(context, abstractC4348pQ));
        }
    }

    @Override // p131o.InterfaceC4085lQ
    /* renamed from: mjFkc */
    public final void mo9507mjFkc(InterfaceC3949jQ interfaceC3949jQ) {
        Iterator it = this.f16338mjFkc.iterator();
        while (it.hasNext()) {
            ((InterfaceC4085lQ) it.next()).mo9507mjFkc(interfaceC3949jQ);
        }
    }
}
