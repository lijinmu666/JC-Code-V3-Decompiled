package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/NotCompleted;", "invoke", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "UserSupplied", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface CancelHandler extends NotCompleted {

    @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B,\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R+\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/CancelHandler$UserSupplied;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class UserSupplied implements CancelHandler {
        private final Function1<Throwable, C1133Unit> handler;

        /* JADX WARN: Multi-variable type inference failed */
        public UserSupplied(Function1<? super Throwable, C1133Unit> function1) {
            this.handler = function1;
        }

        @Override // p122kotlinx.coroutines.CancelHandler
        /* renamed from: invoke */
        public void mo6905invoke(Throwable cause) {
            this.handler.mo2237invoke(cause);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
        }
    }

    /* renamed from: invoke */
    void mo6905invoke(Throwable cause);
}
