package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0002\u001a;\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001aP\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aT\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0010\u001a\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001aJ\u0010\u0011\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aS\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00120\fH\u0087\u0088\bb\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u0017\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\fH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u0018\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u001a0\fH\u0087\u0088\u0004b\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u001b\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u001a0\fH\u0087\u0088\u0004b\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001a8\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00120\fH\u0087\u0088\u0004b\u0002\b\u0002ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m4988d2 = {"TODO", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "reason", BuildConfig.f24315FLAVOR, "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/IgnorableReturnValue;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "with", "receiver", "apply", BuildConfig.f24315FLAVOR, "also", "Lkotlin/SinceKotlin;", "version", "1.1", "let", "takeIf", "predicate", BuildConfig.f24315FLAVOR, "takeUnless", "repeat", "times", BuildConfig.f24315FLAVOR, "action", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/StandardKt")
/* loaded from: classes.dex */
class StandardKt__StandardKt {
    @InlineOnly
    /* renamed from: TODO */
    private static final Void m5062TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    @SinceKotlin(m5061version = "1.1")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: also */
    private static final <T> T m5064also(T t, Function1<? super T, C1133Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.mo2237invoke(t);
        return t;
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: apply */
    private static final <T> T m5065apply(T t, Function1<? super T, C1133Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.mo2237invoke(t);
        return t;
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: let */
    private static final <T, R> R m5066let(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.mo2237invoke(t);
    }

    @InlineOnly
    /* renamed from: repeat */
    private static final void m5067repeat(int i, Function1<? super Integer, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i2 = 0; i2 < i; i2++) {
            action.mo2237invoke(Integer.valueOf(i2));
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: run */
    private static final <R> R m5069run(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.mo4323invoke();
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: takeIf */
    private static final <T> T m5070takeIf(T t, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (predicate.mo2237invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final <T> T takeUnless(T t, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (predicate.mo2237invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: with */
    private static final <T, R> R m5071with(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.mo2237invoke(t);
    }

    @InlineOnly
    /* renamed from: TODO */
    private static final Void m5063TODO(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        throw new NotImplementedError("An operation is not implemented: " + reason);
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: run */
    private static final <T, R> R m5068run(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.mo2237invoke(t);
    }
}
