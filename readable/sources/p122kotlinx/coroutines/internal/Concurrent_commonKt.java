package p122kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001af\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032<\u0010\f\u001a8\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\"D\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u00032\u0006\u0010\u0000\u001a\u00028\u00008@@@X\u0080\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, m4988d2 = {"value", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "getValue$annotations", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "getValue", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "setValue", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V", "loop", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class Concurrent_commonKt {
    public static final <T> T getValue(AtomicReference<T> atomicReference) {
        return atomicReference.get();
    }

    public static /* synthetic */ void getValue$annotations(AtomicReference atomicReference) {
    }

    /* renamed from: loop */
    public static final <T> void m7411loop(AtomicReference<T> atomicReference, Function2<? super AtomicReference<T>, ? super T, C1133Unit> function2) {
        while (true) {
            function2.mo2167invoke(atomicReference, (Object) getValue(atomicReference));
        }
    }

    public static final <T> void setValue(AtomicReference<T> atomicReference, T t) {
        atomicReference.set(t);
    }
}
