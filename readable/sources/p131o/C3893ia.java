package p131o;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p094kotlin.p105jvm.internal.Intrinsics;

/* renamed from: o.ia */
/* loaded from: classes.dex */
public class C3893ia {

    /* renamed from: mjFkc */
    public final Map f14157mjFkc = new LinkedHashMap();

    /* renamed from: AZxh */
    public final Set m12300AZxh() {
        return new HashSet(this.f14157mjFkc.keySet());
    }

    /* renamed from: mjFkc */
    public final AbstractC3764ga m12301mjFkc(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (AbstractC3764ga) this.f14157mjFkc.get(key);
    }

    /* renamed from: wA */
    public final void m12302wA(String key, AbstractC3764ga viewModel) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        AbstractC3764ga abstractC3764ga = (AbstractC3764ga) this.f14157mjFkc.put(key, viewModel);
        if (abstractC3764ga != null) {
            abstractC3764ga.mo11578AZxh();
        }
    }
}
