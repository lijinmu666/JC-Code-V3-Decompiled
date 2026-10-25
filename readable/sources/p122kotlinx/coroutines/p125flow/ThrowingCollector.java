package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.JvmField;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m4988d2 = {"Lkotlinx/coroutines/flow/ThrowingCollector;", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.f24315FLAVOR, "e", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ThrowingCollector implements FlowCollector<Object> {

    @JvmField
    public final Throwable e;

    public ThrowingCollector(Throwable th) {
        this.e = th;
    }

    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public Object mo4309emit(Object obj, Continuation<? super C1133Unit> continuation) throws Throwable {
        throw this.e;
    }
}
