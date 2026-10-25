package p094kotlin.p117text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u000e\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\"\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\rb\u0002\b\b\u001a\u0012\u0010\u000e\u001a\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000e\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u000f\u001a\u00020\t*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u000f\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0010\u001a\u00020\u0004*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0010\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0011\u001a\u00020\n*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a(\u0010\u0011\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0087\u0088\u0004b\u0002\b\b\u001a#\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0019\u001a \u0010\u001a\u001a\u00020\u001b*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\u001d\u001a\u0004\u0018\u00010\u001b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a \u0010\u001e\u001a\u00020\u001f*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a(\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001cb\u0002\b\b\u001a\u001e\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a&\u0010\"\u001a\u0004\u0018\u00010\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u001a5\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b(\u0010)\u001a5\u0010*\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H$0'H\u0082\u0088\u0004¢\u0006\u0004\b+\u0010)\u001a\u0017\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b.\u001a\u0017\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a%\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b4\u001a\u0017\u00105\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b7\u001a\u0017\u00108\u001a\u00020\f*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b9\u001a\u0017\u0010:\u001a\u00020\u0004*\u000206H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b;\u001a;\u0010<\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b>\u001a;\u0010?\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\b@\u001aC\u0010A\u001a\u00020\u0004*\u00020\u00012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\f2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\f0'H\u0083\u0088\u0004b\u0002\b\b¢\u0006\u0002\bC¨\u0006D"}, m4988d2 = {"toString", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "radix", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.1", "Lkotlin/internal/InlineOnly;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "toBoolean", BuildConfig.f24315FLAVOR, "1.4", "toByte", "toShort", "toInt", "toLong", "toFloat", BuildConfig.f24315FLAVOR, "toDouble", BuildConfig.f24315FLAVOR, "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "1.2", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenBigDecimalValue", "screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "isValidBigDecimal", "isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", BuildConfig.f24315FLAVOR, "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/text/StringsKt")
@SourceDebugExtension(m6344value = {"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,569:1\n267#1,7:570\n267#1,7:577\n278#1,8:584\n278#1,8:592\n1#2:600\n1665#3,3:601\n1665#3,3:604\n1665#3,3:607\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n166#1:570,7\n173#1:577,7\n253#1:584,8\n264#1:592,8\n430#1:601,3\n439#1:604,3\n452#1:607,3\n*E\n"})
/* loaded from: classes.dex */
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    @InlineOnly
    /* renamed from: advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt */
    private static final int m6729x47690acb(String str, int i, int i2, boolean z, Function1<? super Character, Boolean> function1) {
        boolean z2;
        int i3 = i;
        while (i3 <= i2 && function1.mo2237invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        boolean z3 = i != i3;
        if (i3 > i2) {
            if (z) {
                return -1;
            }
            return i3;
        }
        if (str.charAt(i3) == '.') {
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 <= i2 && function1.mo2237invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
                i5++;
            }
            z2 = i4 != i5;
            i3 = i5;
        } else {
            z2 = false;
        }
        if (z3 || z2) {
            return i3;
        }
        if (z) {
            return -1;
        }
        String str2 = i2 == i3 + 2 ? "NaN" : i2 == i3 + 7 ? "Infinity" : null;
        if (str2 != null && StringsKt__StringsKt.m6765indexOf((CharSequence) str, str2, i3, false) == i3) {
            return i2 + 1;
        }
        return -1;
    }

    @InlineOnly
    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i <= i2 && function1.mo2237invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    @InlineOnly
    /* renamed from: asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt */
    private static final int m6730xae944efa(char c) {
        return c | ' ';
    }

    @InlineOnly
    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 > i && function1.mo2237invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2--;
        }
        return i2;
    }

    @InlineOnly
    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int i, int i2) {
        if (i2 == i + 2) {
            return "NaN";
        }
        if (i2 == i + 7) {
            return "Infinity";
        }
        return null;
    }

    @InlineOnly
    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char c) {
        return ((c + 65488) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10;
    }

    @InlineOnly
    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char c) {
        return (((c | ' ') + (-97)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 6;
    }

    private static final boolean isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(String str) {
        int i;
        if (str.length() == 0) {
            return false;
        }
        int i2 = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;
        int i3 = i2;
        while (i3 < str.length() && Character.isDigit(str.charAt(i3))) {
            i3++;
        }
        if (i3 == str.length()) {
            return i3 - i2 > 0;
        }
        if (str.charAt(i3) == '.') {
            i3++;
            if (i3 == str.length()) {
                return i3 - i2 > 1;
            }
            while (i3 < str.length() && Character.isDigit(str.charAt(i3))) {
                i3++;
            }
        }
        if (i3 == str.length()) {
            return true;
        }
        if ((str.charAt(i3) != 'e' && str.charAt(i3) != 'E') || (i = i3 + 1) == str.length()) {
            return false;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i = i3 + 2;
        }
        if (i == str.length()) {
            return false;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }
        return i == str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String str) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int length = str.length() - 1;
        int i3 = 0;
        while (i3 <= length && str.charAt(i3) <= ' ') {
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        while (length > i3 && str.charAt(length) <= ' ') {
            length--;
        }
        if (str.charAt(i3) == '+' || str.charAt(i3) == '-') {
            i3++;
        }
        if (i3 > length) {
            return false;
        }
        if (str.charAt(i3) != '0') {
            z = false;
        } else {
            int i4 = i3 + 1;
            if (i4 > length) {
                return true;
            }
            if ((str.charAt(i4) | ' ') == 120) {
                int i5 = i3 + 2;
                int i6 = i5;
                while (i6 <= length) {
                    if (((str.charAt(i6) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >= 10 && (((r15 | ' ') - 97) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >= 6) {
                        break;
                    }
                    i6++;
                }
                boolean z4 = i5 != i6;
                if (i6 <= length) {
                    if (str.charAt(i6) == '.') {
                        int i7 = i6 + 1;
                        i2 = i7;
                        while (i2 <= length) {
                            if (((str.charAt(i2) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >= 10 && (((r15 | ' ') - 97) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >= 6) {
                                break;
                            }
                            i2++;
                        }
                        if (i7 != i2) {
                            z3 = true;
                        }
                        i3 = (!z4 || z3) ? i2 : -1;
                        if (i3 != -1 || i3 > length) {
                            return false;
                        }
                        z = true;
                    } else {
                        i2 = i6;
                    }
                    z3 = false;
                    if (z4) {
                    }
                    if (i3 != -1) {
                    }
                    return false;
                }
            }
        }
        if (!z) {
            int i8 = i3;
            while (i8 <= length && ((str.charAt(i8) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10) {
                i8++;
            }
            boolean z5 = i3 != i8;
            if (i8 > length) {
                i3 = i8;
            } else {
                if (str.charAt(i8) == '.') {
                    int i9 = i8 + 1;
                    i = i9;
                    while (i <= length && ((str.charAt(i) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10) {
                        i++;
                    }
                    if (i9 != i) {
                        z2 = true;
                    }
                    if (!z5 || z2) {
                        i3 = i;
                    } else {
                        String str2 = length == i + 2 ? "NaN" : length == i + 7 ? "Infinity" : null;
                        i3 = (str2 != null && StringsKt__StringsKt.m6765indexOf((CharSequence) str, str2, i, false) == i) ? length + 1 : -1;
                    }
                } else {
                    i = i8;
                }
                z2 = false;
                if (z5) {
                    i3 = i;
                }
            }
            if (i3 == -1) {
                return false;
            }
            if (i3 > length) {
                return true;
            }
        }
        int i10 = i3 + 1;
        int iCharAt = str.charAt(i3) | ' ';
        if (iCharAt != (z ? 112 : 101)) {
            return !z && (iCharAt == 102 || iCharAt == 100) && i10 > length;
        }
        if (i10 > length) {
            return false;
        }
        if ((str.charAt(i10) == '+' || str.charAt(i10) == '-') && (i10 = i3 + 2) > length) {
            return false;
        }
        while (i10 <= length && ((str.charAt(i10) - '0') & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) < 10) {
            i10++;
        }
        if (i10 > length) {
            return true;
        }
        if (i10 != length) {
            return false;
        }
        int iCharAt2 = str.charAt(i10) | ' ';
        return iCharAt2 == 102 || iCharAt2 == 100;
    }

    private static final <T> T screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.mo2237invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return function1.mo2237invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    @SinceKotlin(m5061version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    /* renamed from: toByte */
    private static final byte m6731toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    @InlineOnly
    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(m5061version = "1.1")
    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    /* renamed from: toFloat */
    private static final float m6733toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(m5061version = "1.1")
    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    /* renamed from: toInt */
    private static final int m6734toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    @InlineOnly
    /* renamed from: toLong */
    private static final long m6736toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    @InlineOnly
    /* renamed from: toShort */
    private static final short m6738toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final String toString(byte b, int i) {
        String string = Integer.toString(b, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        C1302CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (CharsKt__CharJVMKt.m6675digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        } else if (CharsKt__CharJVMKt.m6675digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: toByte */
    private static final byte m6732toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: toInt */
    private static final int m6735toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: toLong */
    private static final long m6737toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    /* renamed from: toShort */
    private static final short m6739toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str, C1302CharsKt.checkRadix(i));
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final String toString(short s, int i) {
        String string = Integer.toString(s, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final String toString(int i, int i2) {
        String string = Integer.toString(i, C1302CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @SinceKotlin(m5061version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(m5061version = "1.1")
    @InlineOnly
    private static final String toString(long j, int i) {
        String string = Long.toString(j, C1302CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
