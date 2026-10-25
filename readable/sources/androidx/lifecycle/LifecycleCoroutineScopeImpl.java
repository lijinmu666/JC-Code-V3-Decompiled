package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.JobKt__JobKt;
import p131o.AbstractC2867T0;
import p131o.InterfaceC3068W0;

@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\n8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m4988d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Lo/T0;", "Landroidx/lifecycle/KLFTb;", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", BuildConfig.f24315FLAVOR, "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", "Landroidx/lifecycle/wA;", "mjFkc", "Landroidx/lifecycle/wA;", "()Landroidx/lifecycle/wA;", "lifecycle", "Lkotlin/coroutines/CoroutineContext;", "AZxh", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "lifecycle-common"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends AbstractC2867T0 implements InterfaceC0104KLFTb {

    /* renamed from: AZxh, reason: from kotlin metadata */
    public final CoroutineContext coroutineContext;

    /* renamed from: mjFkc, reason: from kotlin metadata */
    public final AbstractC0112wA lifecycle;

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (getLifecycle().mo1035AZxh().compareTo(AbstractC0112wA.AZxh.DESTROYED) <= 0) {
            getLifecycle().mo1046wA(this);
            JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // p122kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* renamed from: mjFkc, reason: from getter */
    public AbstractC0112wA getLifecycle() {
        return this.lifecycle;
    }
}
