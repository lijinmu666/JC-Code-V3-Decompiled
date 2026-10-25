package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\u0004b\u0002\b\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a8\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\tH\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001aI\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\f\u001a!\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a2\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\u0004b\u0002\b\u0004ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a8\u0010\u000e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\tH\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000b\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001aI\u0010\u000e\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u0001H\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\u0088\bb\u0002\b\u0004b\u0002\b\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\f\u001a\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m4988d2 = {"require", BuildConfig.f24315FLAVOR, "value", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "lazyMessage", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "requireNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/IgnorableReturnValue;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "check", "checkNotNull", "error", BuildConfig.f24315FLAVOR, "message", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/PreconditionsKt")
@SourceDebugExtension(m6344value = {"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1#2:151\n*E\n"})
/* loaded from: classes.dex */
class PreconditionsKt__PreconditionsKt extends PreconditionsKt__AssertionsJVMKt {
    @InlineOnly
    /* renamed from: check */
    private static final void m5043check(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.");
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @InlineOnly
    /* renamed from: error */
    private static final Void m5045error(Object message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @InlineOnly
    /* renamed from: require */
    private static final void m5046require(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @InlineOnly
    /* renamed from: check */
    private static final void m5044check(boolean z, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!z) {
            throw new IllegalStateException(lazyMessage.mo4323invoke().toString());
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> T checkNotNull(T t, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(lazyMessage.mo4323invoke().toString());
    }

    @InlineOnly
    /* renamed from: require */
    private static final void m5047require(boolean z, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!z) {
            throw new IllegalArgumentException(lazyMessage.mo4323invoke().toString());
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    private static final <T> T requireNotNull(T t, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(lazyMessage.mo4323invoke().toString());
    }
}
