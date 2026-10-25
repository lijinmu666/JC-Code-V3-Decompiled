package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0081\u0080\u0004b\u0002\b\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u001a)\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\nH\u0081\u0080\u0004b\u0002\b\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u000b\u001a>\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aS\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\r*\u0002H\u00122\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\r0\u0013¢\u0006\u0002\b\u0014H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a1\u0010\u0016\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\nH\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0017\u001an\u0010\u0018\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0012*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0015\u001aC\u0010\u001c\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0012*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00120\n2\u0006\u0010\u001d\u001a\u0002H\rH\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u001e\u001a\u0097\u0001\u0010\u001f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\r0\u00132!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\"\u001ap\u0010#\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0015\u001ac\u0010%\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001at\u0010&\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0012*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0015\u001ag\u0010'\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u0012*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\r0\u0013H\u0087\u0088\u0004b\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001an\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00120\n\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\u0013H\u0087\u0088\bb\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b)ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0015\u001an\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00120\n\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\n2!\u0010(\u001a\u001d\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\t0\u0013H\u0087\u0088\bb\u0002\b\u0011b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b)ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, m4988d2 = {"createFailure", BuildConfig.f24315FLAVOR, "exception", BuildConfig.f24315FLAVOR, "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "throwOnFailure", BuildConfig.f24315FLAVOR, "Lkotlin/Result;", "(Ljava/lang/Object;)V", "runCatching", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "onFailure", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "fold", "onSuccess", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "map", "transform", "mapCatching", "recover", "recoverCatching", "action", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1#2:343\n*E\n"})
/* loaded from: classes.dex */
public final class ResultKt {
    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final Object createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new C1124Result.Failure(exception);
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: fold */
    private static final <R, T> R m5058fold(Object obj, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        return thM18549exceptionOrNullimpl == null ? onSuccess.mo2237invoke(obj) : onFailure.mo2237invoke(thM18549exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        return C1124Result.m18552isFailureimpl(obj) ? r : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        return thM18549exceptionOrNullimpl == null ? obj : onFailure.mo2237invoke(thM18549exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <T> T getOrThrow(Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: map */
    private static final <R, T> Object m5059map(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return C1124Result.m18553isSuccessimpl(obj) ? C1124Result.m18546constructorimpl(transform.mo2237invoke(obj)) : C1124Result.m18546constructorimpl(obj);
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (!C1124Result.m18553isSuccessimpl(obj)) {
            return C1124Result.m18546constructorimpl(obj);
        }
        try {
            return C1124Result.m18546constructorimpl(transform.mo2237invoke(obj));
        } catch (Throwable th) {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(m5061version = "1.3")
    @IgnorableReturnValue
    @InlineOnly
    private static final <T> Object onFailure(Object obj, Function1<? super Throwable, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        if (thM18549exceptionOrNullimpl != null) {
            action.mo2237invoke(thM18549exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(m5061version = "1.3")
    @IgnorableReturnValue
    @InlineOnly
    private static final <T> Object onSuccess(Object obj, Function1<? super T, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (C1124Result.m18553isSuccessimpl(obj)) {
            action.mo2237invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: recover */
    private static final <R, T extends R> Object m5060recover(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        return thM18549exceptionOrNullimpl == null ? obj : C1124Result.m18546constructorimpl(transform.mo2237invoke(thM18549exceptionOrNullimpl));
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        if (thM18549exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            return C1124Result.m18546constructorimpl(transform.mo2237invoke(thM18549exceptionOrNullimpl));
        } catch (Throwable th) {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <R> Object runCatching(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(block.mo4323invoke());
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(createFailure(th));
        }
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final void throwOnFailure(Object obj) {
        if (obj instanceof C1124Result.Failure) {
            throw ((C1124Result.Failure) obj).exception;
        }
    }

    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(block.mo2237invoke(t));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            return C1124Result.m18546constructorimpl(createFailure(th));
        }
    }
}
