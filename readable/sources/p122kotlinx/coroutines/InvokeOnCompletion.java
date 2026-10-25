package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B0\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m4988d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCancelling", BuildConfig.f24315FLAVOR, "getOnCancelling", "()Z", "invoke", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class InvokeOnCompletion extends AbstractC1346JobNode {
    private final Function1<Throwable, C1133Unit> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCompletion(Function1<? super Throwable, C1133Unit> function1) {
        this.handler = function1;
    }

    @Override // p122kotlinx.coroutines.AbstractC1346JobNode
    public boolean getOnCancelling() {
        return false;
    }

    @Override // p122kotlinx.coroutines.AbstractC1346JobNode
    /* renamed from: invoke */
    public void mo6904invoke(Throwable cause) {
        this.handler.mo2237invoke(cause);
    }
}
