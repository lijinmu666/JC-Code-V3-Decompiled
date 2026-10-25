package p094kotlin.p112ranges;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0005\u001aQ\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e¢\u0006\u0002\u0010\b\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007*\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u001a<\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0087\u0082\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000e\u001aY\u0010\u0013\u001a\u00020\u0014\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019b\u0002\b\u001a¢\u0006\u0002\u0010\u0018\u001ao\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u001b\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b \u0012\b\b!\u0012\u0004\b\b(\u0019b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\"b\u0002\b\u001a¢\u0006\u0002\u0010\u001c\u001ak\u0010\u0013\u001a\u00020\u0014\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019b\u0010\b\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\t0\u000eb\u0002\b\u001a¢\u0006\u0002\u0010#\u001ao\u0010\u0013\u001a\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u001b\"\u0018\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u0016*\u0002H\u00152\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0002H\u0087\u008a\u0004b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fb\f\b \u0012\b\b!\u0012\u0004\b\b(\u0019b\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bb\u0002\b\u001a¢\u0006\u0002\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0080\u0080\u0004¨\u0006*"}, m4988d2 = {"rangeTo", "Lkotlin/ranges/ClosedRange;", "T", BuildConfig.f24315FLAVOR, "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "rangeUntil", "Lkotlin/ranges/OpenEndRange;", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/ranges/ClosedFloatingPointRange;", BuildConfig.f24315FLAVOR, "1.1", BuildConfig.f24315FLAVOR, "contains", BuildConfig.f24315FLAVOR, "R", BuildConfig.f24315FLAVOR, "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;)Z", "2.3", "Lkotlin/internal/InlineOnly;", BuildConfig.f24315FLAVOR, "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "Lkotlin/Deprecated;", "message", "The signature violates type safety guarantees", "Lkotlin/DeprecatedSinceKotlin;", "hiddenSince", "1.3", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Comparable;)Z", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "checkStepIsPositive", BuildConfig.f24315FLAVOR, "isPositive", "step", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<-TT;>;R::Lkotlin/ranges/ClosedRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(m5061version = "2.3")
    @InlineOnly
    private static final boolean contains(ClosedRange closedRange, Comparable comparable) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return comparable != null && closedRange.contains(comparable);
    }

    /* renamed from: rangeTo */
    public static final <T extends Comparable<? super T>> ClosedRange<T> m6466rangeTo(T t, T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new ComparableRange(t, that);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(T t, T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new ComparableOpenEndRange(t, that);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/ClosedRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    @Deprecated(m4972message = "The signature violates type safety guarantees")
    @DeprecatedSinceKotlin(hiddenSince = "2.3")
    private static final /* synthetic */ boolean contains(ClosedRange closedRange, Object obj) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return obj != null && closedRange.contains((Comparable) obj);
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: rangeTo */
    public static final ClosedFloatingPointRange<Double> m6464rangeTo(double d, double d2) {
        return new ClosedDoubleRange(d, d2);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Double> rangeUntil(double d, double d2) {
        return new OpenEndDoubleRange(d, d2);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<-TT;>;R::Lkotlin/ranges/OpenEndRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final boolean contains(OpenEndRange openEndRange, Comparable comparable) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return comparable != null && openEndRange.contains(comparable);
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: rangeTo */
    public static final ClosedFloatingPointRange<Float> m6465rangeTo(float f, float f2) {
        return new ClosedFloatRange(f, f2);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Float> rangeUntil(float f, float f2) {
        return new OpenEndFloatRange(f, f2);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/OpenEndRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @SinceKotlin(m5061version = "1.9")
    @InlineOnly
    @Deprecated(m4972message = "The signature violates type safety guarantees")
    @DeprecatedSinceKotlin(hiddenSince = "2.3")
    private static final /* synthetic */ boolean contains(OpenEndRange openEndRange, Object obj) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return obj != null && openEndRange.contains((Comparable) obj);
    }
}
