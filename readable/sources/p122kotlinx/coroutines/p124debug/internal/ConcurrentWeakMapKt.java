package p122kotlinx.coroutines.p124debug.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.internal.C1578Symbol;

@Metadata(m4987d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u000e\u0010\b\u001a\u00020\u0006*\u0004\u0018\u00010\tH\u0002\u001a\b\u0010\n\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m4988d2 = {"MAGIC", BuildConfig.f24315FLAVOR, "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "mark", BuildConfig.f24315FLAVOR, "noImpl", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ConcurrentWeakMapKt {

    /* renamed from: MAGIC */
    private static final int f6024MAGIC = -1640531527;
    private static final int MIN_CAPACITY = 16;

    /* renamed from: REHASH */
    private static final C1578Symbol f6025REHASH = new C1578Symbol("REHASH");
    private static final C1420Marked MARKED_NULL = new C1420Marked(null);
    private static final C1420Marked MARKED_TRUE = new C1420Marked(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mark */
    public static final C1420Marked m7172mark(Object obj) {
        return obj == null ? MARKED_NULL : Intrinsics.areEqual(obj, Boolean.TRUE) ? MARKED_TRUE : new C1420Marked(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: noImpl */
    public static final Void m7173noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}
