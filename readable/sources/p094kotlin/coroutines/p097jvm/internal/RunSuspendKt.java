package p094kotlin.coroutines.p097jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0081\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\u0010\u0006¨\u0006\n"}, m4988d2 = {"runSuspend", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/SinceKotlin;", "version", "1.3", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class RunSuspendKt {
    @SinceKotlin(m5061version = "1.3")
    public static final void runSuspend(Function1<? super Continuation<? super C1133Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        RunSuspend runSuspend = new RunSuspend();
        ContinuationKt.startCoroutine(block, runSuspend);
        runSuspend.m6132await();
    }
}
