package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\n2\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "F", BuildConfig.f24315FLAVOR, "<init>", "()V", "allocateLocked", BuildConfig.f24315FLAVOR, "flow", "(Ljava/lang/Object;)Z", "freeLocked", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;)[Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean allocateLocked(F flow);

    public abstract Continuation<C1133Unit>[] freeLocked(F flow);
}
