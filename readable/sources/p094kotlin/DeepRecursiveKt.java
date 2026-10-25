package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0082\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0011*r\b\u0002\u0010\t\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\r\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\u000e25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\r\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\u000e¨\u0006\u0012"}, m4988d2 = {"invoke", "R", "T", "Lkotlin/DeepRecursiveFunction;", "value", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "1.7", "DeepRecursiveFunctionBlock", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "UNDEFINED_RESULT", "Lkotlin/Result;", "Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    static {
        C1124Result.Companion companion = C1124Result.INSTANCE;
        UNDEFINED_RESULT = C1124Result.m18546constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(m5061version = "1.7")
    /* renamed from: invoke */
    public static final <T, R> R m4969invoke(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        return (R) new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), t).runCallLoop();
    }
}
