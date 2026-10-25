package p131o;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.p022app.Fragment;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.HF */
/* loaded from: classes.dex */
public final class C2084HF extends Fragment implements InterfaceC2929U0 {

    /* renamed from: XV */
    public static final WeakHashMap f8561XV = new WeakHashMap();

    /* renamed from: WGXroI */
    public Bundle f8563WGXroI;

    /* renamed from: JrJO */
    public final Map f8562JrJO = Collections.synchronizedMap(new C4633tjSezt());

    /* renamed from: nxI */
    public int f8564nxI = 0;

    /* renamed from: SKTn */
    public static C2084HF m8529SKTn(AbstractActivityC2784RnaHj abstractActivityC2784RnaHj) {
        C2084HF c2084hf;
        WeakReference weakReference = (WeakReference) f8561XV.get(abstractActivityC2784RnaHj);
        if (weakReference == null || (c2084hf = (C2084HF) weakReference.get()) == null) {
            throw null;
        }
        return c2084hf;
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: ANMGZc */
    public final void mo758ANMGZc() {
        super.mo758ANMGZc();
        this.f8564nxI = 3;
        Iterator it = this.f8562JrJO.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2388lgHUyS();
        }
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: AZxh */
    public final void mo8531AZxh(String str, LifecycleCallback lifecycleCallback) {
        if (this.f8562JrJO.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f8562JrJO.put(str, lifecycleCallback);
        if (this.f8564nxI > 0) {
            new HandlerC4274oL(Looper.getMainLooper()).post(new RunnableC4334pE(this, lifecycleCallback, str));
        }
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: JYn */
    public final void mo772JYn(Bundle bundle) {
        super.mo772JYn(bundle);
        this.f8564nxI = 1;
        this.f8563WGXroI = bundle;
        for (Map.Entry entry : this.f8562JrJO.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo2386JHa(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: KLFTb */
    public final /* synthetic */ Activity mo8532KLFTb() {
        m829qdMbNW();
        return null;
    }

    @Override // p131o.InterfaceC2929U0
    /* renamed from: ZfxDd */
    public final LifecycleCallback mo8533ZfxDd(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f8562JrJO.get(str));
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: alEkx */
    public final void mo802alEkx() {
        super.mo802alEkx();
        this.f8564nxI = 2;
        Iterator it = this.f8562JrJO.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2384Dt();
        }
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: dm */
    public final void mo807dm() {
        super.mo807dm();
        this.f8564nxI = 4;
        Iterator it = this.f8562JrJO.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).mo2385ETF();
        }
    }
}
