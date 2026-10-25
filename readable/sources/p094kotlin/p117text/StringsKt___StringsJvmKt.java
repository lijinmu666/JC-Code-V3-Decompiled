package p094kotlin.p117text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000n\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u0002H\u0086\u0080\u0004\u001ac\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(&\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b('\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001ac\u0010(\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b()\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(*\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\t\u001a\u008a\u0001\u0010+\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001a0\u001b*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0087\u0088\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(,\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(-\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\"\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010#j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`$H\u0087\u0080\u0004b*\b\n\u0012\b\b\u000b\u0012\u0004\b\b(/\u0012\u001c\b\r\u0012\u0018\b\u000bB\u0014\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(0\u0012\u0006\b\u0011\u0012\u0002\b\fb \b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010%\u001aN\u00101\u001a\u000202*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002020\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(3b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b3\u001aN\u00101\u001a\u000209*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090\u001dH\u0087\u0088\u0004b\f\b4\u0012\b\b5\u0012\u0004\b\b(\u0014b\u0002\b6b\f\b7\u0012\b\b8\u0012\u0004\b\b(:b\u0002\b\u0005ø\u0001\u0000¢\u0006\u0002\b:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, m4988d2 = {"elementAt", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "index", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "toSortedSet", "Ljava/util/SortedSet;", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "maxBy", "R", BuildConfig.f24315FLAVOR, "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lkotlin/SinceKotlin;", "version", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1279#2,14:109\n1603#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
/* loaded from: classes.dex */
class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    @InlineOnly
    private static final char elementAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.charAt(i);
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Character m6791max(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt___StringsKt.maxOrNull(charSequence);
    }

    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy */
    public static final /* synthetic */ <R extends Comparable<? super R>> Character m6792maxBy(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rMo2237invoke = selector.mo2237invoke(Character.valueOf(cCharAt));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i);
                R rMo2237invoke2 = selector.mo2237invoke(Character.valueOf(cCharAt2));
                if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                    cCharAt = cCharAt2;
                    rMo2237invoke = rMo2237invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith */
    public static final /* synthetic */ Character m6793maxWith(CharSequence charSequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt___StringsKt.maxWithOrNull(charSequence, comparator);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Character m6794min(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt___StringsKt.minOrNull(charSequence);
    }

    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy */
    public static final /* synthetic */ <R extends Comparable<? super R>> Character m6795minBy(CharSequence charSequence, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(cCharAt);
        }
        R rMo2237invoke = selector.mo2237invoke(Character.valueOf(cCharAt));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i);
                R rMo2237invoke2 = selector.mo2237invoke(Character.valueOf(cCharAt2));
                if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                    cCharAt = cCharAt2;
                    rMo2237invoke = rMo2237invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith */
    public static final /* synthetic */ Character m6796minWith(CharSequence charSequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt___StringsKt.minWithOrNull(charSequence, comparator);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        for (int i = 0; i < charSequence.length(); i++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (SortedSet) StringsKt___StringsKt.toCollection(charSequence, new TreeSet());
    }
}
