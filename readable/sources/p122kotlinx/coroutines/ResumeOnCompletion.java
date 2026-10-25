package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/coroutines/Continuation;)V", "onCancelling", BuildConfig.f24315FLAVOR, "getOnCancelling", "()Z", "invoke", "cause", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class ResumeOnCompletion extends AbstractC1346JobNode {
    private final Continuation<C1133Unit> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Continuation<? super C1133Unit> continuation) {
        this.continuation = continuation;
    }

    @Override // p122kotlinx.coroutines.AbstractC1346JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override // p122kotlinx.coroutines.AbstractC1346JobNode
    /* renamed from: invoke */
    public void mo6904invoke(Throwable cause) {
        Continuation<C1133Unit> continuation = this.continuation;
        C1124Result.Companion companion = C1124Result.INSTANCE;
        continuation.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
    }
}
