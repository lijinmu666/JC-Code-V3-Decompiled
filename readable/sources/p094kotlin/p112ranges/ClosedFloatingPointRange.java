package p094kotlin.p112ranges;

import java.lang.Comparable;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0007J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\fÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¨\u0006\r"}, m4988d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", "T", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/ClosedRange;", "contains", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> closedFloatingPointRange, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), value) && closedFloatingPointRange.lessThanOrEquals(value, closedFloatingPointRange.getEndInclusive());
        }

        /* renamed from: isEmpty */
        public static <T extends Comparable<? super T>> boolean m6449isEmpty(ClosedFloatingPointRange<T> closedFloatingPointRange) {
            return !closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), closedFloatingPointRange.getEndInclusive());
        }
    }

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    boolean contains(T value);

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    /* renamed from: isEmpty */
    boolean mo6445isEmpty();

    boolean lessThanOrEquals(T a, T b);
}
