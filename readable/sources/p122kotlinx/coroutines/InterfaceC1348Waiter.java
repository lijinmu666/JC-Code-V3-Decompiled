package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p122kotlinx.coroutines.internal.AbstractC1577Segment;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/Waiter;", BuildConfig.f24315FLAVOR, "invokeOnCancellation", BuildConfig.f24315FLAVOR, "segment", "Lkotlinx/coroutines/internal/Segment;", "index", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.Waiter */
/* loaded from: classes.dex */
public interface InterfaceC1348Waiter {
    void invokeOnCancellation(AbstractC1577Segment<?> segment, int index);
}
