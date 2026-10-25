package p094kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.RestrictsSuspension;

@SinceKotlin(m5061version = "1.3")
@RestrictsSuspension
@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b@¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H¦À\u0004¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH¦À\u0004¢\u0006\u0002\u0010\fJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086À\u0004¢\u0006\u0002\u0010\u000fJ\u001d\u0010\t\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086À\u0004¢\u0006\u0002\u0010\u0012Ê\u0001\u0002\b\u0014Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¨\u0006\u0013"}, m4988d2 = {"Lkotlin/sequences/SequenceScope;", "T", BuildConfig.f24315FLAVOR, "<init>", "()V", "yield", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", BuildConfig.f24315FLAVOR, "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elements", BuildConfig.f24315FLAVOR, "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib", "Lkotlin/coroutines/RestrictsSuspension;", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class SequenceScope<T> {
    /* renamed from: yield */
    public abstract Object mo6559yield(T t, Continuation<? super C1133Unit> continuation);

    public final Object yieldAll(Iterable<? extends T> iterable, Continuation<? super C1133Unit> continuation) {
        return ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) ? C1133Unit.INSTANCE : yieldAll(iterable.iterator(), continuation);
    }

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super C1133Unit> continuation);

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super C1133Unit> continuation) {
        return yieldAll(sequence.iterator(), continuation);
    }
}
