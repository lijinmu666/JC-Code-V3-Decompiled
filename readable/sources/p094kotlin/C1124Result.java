package p094kotlin;

import java.io.Serializable;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u0000  *\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002 !B\u0017\bA\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0087\u0088\u0004b\u0002\b\u0013¢\u0006\u0004\b\u0012\u0010\u0007J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0086\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0084\br\u0002\b\b¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00020\f8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\b(%Ê\u0001\u0002\b&¨\u0006\""}, m4988d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", BuildConfig.f24315FLAVOR, "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/PublishedApi;", "getValue$annotations", "()V", "isSuccess", BuildConfig.f24315FLAVOR, "isSuccess-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "getOrNull", "getOrNull-impl", "Lkotlin/internal/InlineOnly;", "exceptionOrNull", BuildConfig.f24315FLAVOR, "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "toString", BuildConfig.f24315FLAVOR, "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "Companion", "Failure", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@JvmInline
/* renamed from: kotlin.Result */
/* loaded from: classes.dex */
public final class C1124Result<T> implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Object value;

    @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006H\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\u0002\u0010\bJ5\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m4988d2 = {"Lkotlin/Result$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "success", "Lkotlin/Result;", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "Lkotlin/jvm/JvmName;", "name", "failure", "exception", BuildConfig.f24315FLAVOR, "(Ljava/lang/Throwable;)Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.Result$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @InlineOnly
        @InterfaceC1231JvmName(m6260name = "failure")
        /* renamed from: failure */
        private final <T> Object m5055failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return C1124Result.m18546constructorimpl(ResultKt.createFailure(exception));
        }

        @InlineOnly
        @InterfaceC1231JvmName(m6260name = "success")
        /* renamed from: success */
        private final <T> Object m5056success(T value) {
            return C1124Result.m18546constructorimpl(value);
        }

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0082\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\u0007¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m4988d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/JvmField;", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.Result$Failure, reason: from toString */
    public static final class Failure implements Serializable {

        @JvmField
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        /* renamed from: equals */
        public boolean m5057equals(Object other) {
            return (other instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) other).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @PublishedApi
    private /* synthetic */ C1124Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C1124Result m18545boximpl(Object obj) {
        return new C1124Result(obj);
    }

    @PublishedApi
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m18546constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m18547equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof C1124Result) && Intrinsics.areEqual(obj, ((C1124Result) obj2).getValue());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18548equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m18549exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m18550getOrNullimpl(Object obj) {
        if (m18552isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m18551hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m18552isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m18553isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m18554toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    /* renamed from: equals */
    public boolean m5054equals(Object other) {
        return m18547equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m18551hashCodeimpl(this.value);
    }

    public String toString() {
        return m18554toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Object getValue() {
        return this.value;
    }
}
