package p094kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u0003\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a \u0010\f\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u000f\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\u0001*\u00020\u0015H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a'\u0010\u0017\u001a\u00020\u0001*\u00020\u0019H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001cb\u0002\b\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0017\u001a\u00020\u0001*\u00020\u001dH\u0087\u0080\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0010 \u001a\u00020!*\u00020\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a4\u0010 \u001a\u00020!*\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003¨\u0006%"}, m4988d2 = {"plus", "Ljava/math/BigInteger;", "other", "Lkotlin/internal/InlineOnly;", "minus", "times", "div", "rem", "Lkotlin/SinceKotlin;", "version", "1.1", "unaryMinus", "inc", "1.2", "dec", "inv", "and", "or", "xor", "shl", "n", BuildConfig.f24315FLAVOR, "shr", "toBigInteger", BuildConfig.f24315FLAVOR, "Lkotlin/UInt;", "toBigInteger-WZ4Q5Ns", "(I)Ljava/math/BigInteger;", "2.4", "Lkotlin/ULong;", "toBigInteger-VKZWuLQ", "(J)Ljava/math/BigInteger;", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: and */
    private static final BigInteger m5001and(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerAnd = bigInteger.and(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAnd, "and(...)");
        return bigIntegerAnd;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: dec */
    private static final BigInteger m5002dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    @InlineOnly
    /* renamed from: div */
    private static final BigInteger m5003div(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerDivide = bigInteger.divide(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerDivide, "divide(...)");
        return bigIntegerDivide;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: inc */
    private static final BigInteger m5004inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: inv */
    private static final BigInteger m5005inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerNot = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNot, "not(...)");
        return bigIntegerNot;
    }

    @InlineOnly
    /* renamed from: minus */
    private static final BigInteger m5006minus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerSubtract = bigInteger.subtract(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        return bigIntegerSubtract;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: or */
    private static final BigInteger m5007or(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerOr = bigInteger.or(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerOr, "or(...)");
        return bigIntegerOr;
    }

    @InlineOnly
    /* renamed from: plus */
    private static final BigInteger m5008plus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerAdd = bigInteger.add(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: rem */
    private static final BigInteger m5009rem(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerRemainder = bigInteger.remainder(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerRemainder, "remainder(...)");
        return bigIntegerRemainder;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: shl */
    private static final BigInteger m5010shl(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftLeft, "shiftLeft(...)");
        return bigIntegerShiftLeft;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: shr */
    private static final BigInteger m5011shr(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerShiftRight, "shiftRight(...)");
        return bigIntegerShiftRight;
    }

    @InlineOnly
    /* renamed from: times */
    private static final BigInteger m5012times(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerMultiply = bigInteger.multiply(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMultiply, "multiply(...)");
        return bigIntegerMultiply;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    public static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "UNLIMITED");
        }
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(int i) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    @SinceKotlin(m5061version = "2.4")
    /* renamed from: toBigInteger-VKZWuLQ, reason: not valid java name */
    public static final BigInteger m18543toBigIntegerVKZWuLQ(long j) {
        if (j >= 0) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
            return bigIntegerValueOf;
        }
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(Long.divideUnsigned(j, 2L));
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf2, "valueOf(...)");
        BigInteger bigIntegerShiftLeft = bigIntegerValueOf2.shiftLeft(1);
        long jRemainderUnsigned = Long.remainderUnsigned(j, 2L);
        Intrinsics.checkNotNull(bigIntegerShiftLeft);
        if (jRemainderUnsigned != 1) {
            return bigIntegerShiftLeft;
        }
        BigInteger ONE = BigInteger.ONE;
        Intrinsics.checkNotNullExpressionValue(ONE, "ONE");
        BigInteger bigIntegerAdd = bigIntegerShiftLeft.add(ONE);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return bigIntegerAdd;
    }

    @SinceKotlin(m5061version = "2.4")
    @InlineOnly
    /* renamed from: toBigInteger-WZ4Q5Ns, reason: not valid java name */
    private static final BigInteger m18544toBigIntegerWZ4Q5Ns(int i) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i & BodyPartID.bodyIdMax);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }

    @InlineOnly
    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger bigIntegerNegate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(bigIntegerNegate, "negate(...)");
        return bigIntegerNegate;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: xor */
    private static final BigInteger m5013xor(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger bigIntegerXor = bigInteger.xor(other);
        Intrinsics.checkNotNullExpressionValue(bigIntegerXor, "xor(...)");
        return bigIntegerXor;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(long j) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        return bigIntegerValueOf;
    }
}
