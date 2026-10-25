package p094kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a \u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0012H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0013H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0014H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003\u001a(\u0010\u000e\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0003¨\u0006\u0015"}, m4988d2 = {"plus", "Ljava/math/BigDecimal;", "other", "Lkotlin/internal/InlineOnly;", "minus", "times", "div", "rem", "unaryMinus", "inc", "Lkotlin/SinceKotlin;", "version", "1.2", "dec", "toBigDecimal", BuildConfig.f24315FLAVOR, "mathContext", "Ljava/math/MathContext;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
class NumbersKt__BigDecimalsKt {
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: dec */
    private static final BigDecimal m4994dec(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    @InlineOnly
    /* renamed from: div */
    private static final BigDecimal m4995div(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalDivide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, "divide(...)");
        return bigDecimalDivide;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: inc */
    private static final BigDecimal m4996inc(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    @InlineOnly
    /* renamed from: minus */
    private static final BigDecimal m4997minus(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return bigDecimalSubtract;
    }

    @InlineOnly
    /* renamed from: plus */
    private static final BigDecimal m4998plus(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalAdd = bigDecimal.add(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return bigDecimalAdd;
    }

    @InlineOnly
    /* renamed from: rem */
    private static final BigDecimal m4999rem(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalRemainder, "remainder(...)");
        return bigDecimalRemainder;
    }

    @InlineOnly
    /* renamed from: times */
    private static final BigDecimal m5000times(BigDecimal bigDecimal, BigDecimal other) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(other);
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        return bigDecimalMultiply;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    @InlineOnly
    private static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(bigDecimalNegate, "negate(...)");
        return bigDecimalNegate;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(i, mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(j, mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(float f, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(double d, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
