package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.Zy */
/* loaded from: classes.dex */
public final class C3332Zy extends AbstractC3794gz {
    public C3332Zy() {
        super(null);
    }

    @Override // p131o.AbstractC3794gz
    /* renamed from: mjFkc */
    public final void mo11236mjFkc() {
        if (!m12122Dt()) {
            for (int i = 0; i < m12129wA(); i++) {
                ((InterfaceC2601Ox) ((C3400az) m12130xJ(i)).m11437KLFTb()).mo9920ZfxDd();
            }
            Iterator it = m12127ZfxDd().iterator();
            while (it.hasNext()) {
                ((InterfaceC2601Ox) ((Map.Entry) it.next()).getKey()).mo9920ZfxDd();
            }
        }
        super.mo11236mjFkc();
    }
}
