package p094kotlin.p119time;

import java.io.IOException;
import org.conscrypt.BuildConfig;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Typography;
import p094kotlin.p119time.InstantKt;
import p094kotlin.p119time.InstantParseResult;

@Metadata(m4987d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082\u0080\u0004\u001a\u0012\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0082\u0080\u0004\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0082\u0088\u0004\u001a(\u0010$\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0082\u0088\u0004\u001a\u0012\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u001cH\u0080\u0080\u0004\u001a\u0016\u0010.\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010,\u001a\u00020\u0001H\u0082\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0019*\u00020\u00172\u0006\u00105\u001a\u00020\u001cH\u0082\u0080\u0004\"D\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\br\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000br\u0002\b\f¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"D\u0010\r\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\br\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\br\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000br\u0002\b\f¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\u0005\"\u000f\u0010\u000f\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0011\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0012\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0013\u001a\u00020\u0010X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u001b\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u001d\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010%\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010&\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010'\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010(\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010)\u001a\u00020\u001cX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010*\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010+\u001a\u00020\u001cX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010/\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00101\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00102\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000f\u00103\u001a\u000200X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u00066"}, m4988d2 = {"isDistantPast", BuildConfig.f24315FLAVOR, "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "Lkotlin/internal/InlineOnly;", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", BuildConfig.f24315FLAVOR, "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lkotlin/time/InstantParseResult;", "isoString", BuildConfig.f24315FLAVOR, "formatIso", BuildConfig.f24315FLAVOR, "instant", "DAYS_PER_CYCLE", BuildConfig.f24315FLAVOR, "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", BuildConfig.f24315FLAVOR, "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/UnboundLocalDateTime\n*L\n1#1,871:1\n1#2:872\n491#3,28:873\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/InstantKt\n*L\n700#1:873,28\n*E\n"})
/* loaded from: classes.dex */
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int[] POWERS_OF_TEN = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, NANOS_PER_SECOND};
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] colonsInIsoOffsetString = {3, 6};
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatIso(C1324Instant c1324Instant) throws IOException {
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime unboundLocalDateTimeFromInstant = UnboundLocalDateTime.INSTANCE.fromInstant(c1324Instant);
        int iM6890getYear = unboundLocalDateTimeFromInstant.getYear();
        int i = 0;
        if (Math.abs(iM6890getYear) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (iM6890getYear >= 0) {
                sb2.append(iM6890getYear + 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(iM6890getYear - 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (iM6890getYear >= 10000) {
                sb.append('+');
            }
            sb.append(iM6890getYear);
        }
        sb.append('-');
        formatIso$lambda$0$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getMonth());
        sb.append('-');
        formatIso$lambda$0$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getDay());
        sb.append('T');
        formatIso$lambda$0$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getHour());
        sb.append(':');
        formatIso$lambda$0$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getMinute());
        sb.append(':');
        formatIso$lambda$0$appendTwoDigits(sb, sb, unboundLocalDateTimeFromInstant.getSecond());
        if (unboundLocalDateTimeFromInstant.getNanosecond() != 0) {
            sb.append('.');
            while (true) {
                int nanosecond = unboundLocalDateTimeFromInstant.getNanosecond();
                iArr = POWERS_OF_TEN;
                int i2 = i + 1;
                if (nanosecond % iArr[i2] != 0) {
                    break;
                }
                i = i2;
            }
            int i3 = i - (i % 3);
            String strValueOf = String.valueOf((unboundLocalDateTimeFromInstant.getNanosecond() / iArr[i3]) + iArr[9 - i3]);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void formatIso$lambda$0$appendTwoDigits(Appendable appendable, StringBuilder sb, int i) throws IOException {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }

    private static final boolean isDistantFuture(C1324Instant c1324Instant) {
        Intrinsics.checkNotNullParameter(c1324Instant, "<this>");
        return c1324Instant.compareTo(C1324Instant.INSTANCE.getDISTANT_FUTURE()) >= 0;
    }

    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    public static /* synthetic */ void isDistantFuture$annotations(C1324Instant c1324Instant) {
    }

    private static final boolean isDistantPast(C1324Instant c1324Instant) {
        Intrinsics.checkNotNullParameter(c1324Instant, "<this>");
        return c1324Instant.compareTo(C1324Instant.INSTANCE.getDISTANT_PAST()) <= 0;
    }

    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    public static /* synthetic */ void isDistantPast$annotations(C1324Instant c1324Instant) {
    }

    public static final boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static final int monthLength(int i, boolean z) {
        return i != 2 ? (i == 4 || i == 6 || i == 9 || i == 11) ? 30 : 31 : z ? 29 : 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstantParseResult parseIso(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char cCharAt;
        char cCharAt2;
        if (charSequence.length() == 0) {
            return new InstantParseResult.C1325Failure("An empty string is not a valid Instant", charSequence);
        }
        char cCharAt3 = charSequence.charAt(0);
        if (cCharAt3 == '+' || cCharAt3 == '-') {
            i = 1;
        } else {
            i = 0;
            cCharAt3 = ' ';
        }
        int iCharAt = 0;
        int i6 = i;
        while (i6 < charSequence.length() && '0' <= (cCharAt2 = charSequence.charAt(i6)) && cCharAt2 < ':') {
            iCharAt = (iCharAt * 10) + (charSequence.charAt(i6) - '0');
            i6++;
        }
        int i7 = i6 - i;
        if (i7 > 10) {
            return parseIso$parseFailure(charSequence, "Expected at most 10 digits for the year number, got " + i7 + " digits");
        }
        if (i7 == 10 && charSequence.charAt(i) >= '2') {
            return parseIso$parseFailure(charSequence, "Expected at most 9 digits for the year number or year 1000000000, got " + i7 + " digits");
        }
        if (i7 < 4) {
            return parseIso$parseFailure(charSequence, "The year number must be padded to 4 digits, got " + i7 + " digits");
        }
        if (cCharAt3 == '+' && i7 == 4) {
            return parseIso$parseFailure(charSequence, "The '+' sign at the start is only valid for year numbers longer than 4 digits");
        }
        if (cCharAt3 == ' ' && i7 != 4) {
            return parseIso$parseFailure(charSequence, "A '+' or '-' sign is required for year numbers longer than 4 digits");
        }
        if (cCharAt3 == '-') {
            iCharAt = -iCharAt;
        }
        int i8 = i6 + 16;
        if (charSequence.length() < i8) {
            return parseIso$parseFailure(charSequence, "The input string is too short");
        }
        InstantParseResult.C1325Failure iso$expect = parseIso$expect(charSequence, "'-'", i6, new Function1() { // from class: o.X
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$0(((Character) obj).charValue()));
            }
        });
        if (iso$expect != null) {
            return iso$expect;
        }
        InstantParseResult.C1325Failure iso$expect2 = parseIso$expect(charSequence, "'-'", i6 + 3, new Function1() { // from class: o.Y
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$2(((Character) obj).charValue()));
            }
        });
        if (iso$expect2 != null) {
            return iso$expect2;
        }
        InstantParseResult.C1325Failure iso$expect3 = parseIso$expect(charSequence, "'T' or 't'", i6 + 6, new Function1() { // from class: o.Z
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$4(((Character) obj).charValue()));
            }
        });
        if (iso$expect3 != null) {
            return iso$expect3;
        }
        InstantParseResult.C1325Failure iso$expect4 = parseIso$expect(charSequence, "':'", i6 + 9, new Function1() { // from class: o.a0
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$6(((Character) obj).charValue()));
            }
        });
        if (iso$expect4 != null) {
            return iso$expect4;
        }
        InstantParseResult.C1325Failure iso$expect5 = parseIso$expect(charSequence, "':'", i6 + 12, new Function1() { // from class: o.b0
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(InstantKt.parseIso$lambda$8(((Character) obj).charValue()));
            }
        });
        if (iso$expect5 != null) {
            return iso$expect5;
        }
        for (int i9 : asciiDigitPositionsInIsoStringAfterYear) {
            InstantParseResult.C1325Failure iso$expect6 = parseIso$expect(charSequence, "an ASCII digit", i6 + i9, new Function1() { // from class: o.c0
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return Boolean.valueOf(InstantKt.parseIso$lambda$10(((Character) obj).charValue()));
                }
            });
            if (iso$expect6 != null) {
                return iso$expect6;
            }
        }
        int iso$twoDigitNumber = parseIso$twoDigitNumber(charSequence, i6 + 1);
        int iso$twoDigitNumber2 = parseIso$twoDigitNumber(charSequence, i6 + 4);
        int iso$twoDigitNumber3 = parseIso$twoDigitNumber(charSequence, i6 + 7);
        int iso$twoDigitNumber4 = parseIso$twoDigitNumber(charSequence, i6 + 10);
        int iso$twoDigitNumber5 = parseIso$twoDigitNumber(charSequence, i6 + 13);
        int i10 = i6 + 15;
        if (charSequence.charAt(i10) == '.') {
            i10 = i8;
            int iCharAt2 = 0;
            while (i10 < charSequence.length() && '0' <= (cCharAt = charSequence.charAt(i10)) && cCharAt < ':') {
                iCharAt2 = (iCharAt2 * 10) + (charSequence.charAt(i10) - '0');
                i10++;
            }
            int i11 = i10 - i8;
            if (1 > i11 || i11 >= 10) {
                return parseIso$parseFailure(charSequence, "1..9 digits are supported for the fraction of the second, got " + i11 + " digits");
            }
            i2 = iCharAt2 * POWERS_OF_TEN[9 - i11];
        } else {
            i2 = 0;
        }
        if (i10 >= charSequence.length()) {
            return parseIso$parseFailure(charSequence, "The UTC offset at the end of the string is missing");
        }
        char cCharAt4 = charSequence.charAt(i10);
        if (cCharAt4 == '+' || cCharAt4 == '-') {
            int length = charSequence.length() - i10;
            if (length > 9) {
                return parseIso$parseFailure(charSequence, "The UTC offset string \"" + truncateForErrorMessage(charSequence.subSequence(i10, charSequence.length()).toString(), 16) + "\" is too long");
            }
            if (length % 3 != 0) {
                return parseIso$parseFailure(charSequence, "Invalid UTC offset string \"" + charSequence.subSequence(i10, charSequence.length()).toString() + Typography.quote);
            }
            int[] iArr = colonsInIsoOffsetString;
            int length2 = iArr.length;
            int i12 = 0;
            while (i12 < length2) {
                int i13 = i10 + iArr[i12];
                if (i13 >= charSequence.length()) {
                    break;
                }
                int i14 = length2;
                if (charSequence.charAt(i13) != ':') {
                    return parseIso$parseFailure(charSequence, "Expected ':' at index " + i13 + ", got '" + charSequence.charAt(i13) + '\'');
                }
                i12++;
                length2 = i14;
            }
            int[] iArr2 = asciiDigitsInIsoOffsetString;
            int length3 = iArr2.length;
            int i15 = 0;
            while (i15 < length3) {
                int i16 = iArr2[i15] + i10;
                if (i16 >= charSequence.length()) {
                    break;
                }
                char cCharAt5 = charSequence.charAt(i16);
                int[] iArr3 = iArr2;
                if ('0' > cCharAt5 || cCharAt5 >= ':') {
                    return parseIso$parseFailure(charSequence, "Expected an ASCII digit at index " + i16 + ", got '" + charSequence.charAt(i16) + '\'');
                }
                i15++;
                iArr2 = iArr3;
            }
            int iso$twoDigitNumber6 = parseIso$twoDigitNumber(charSequence, i10 + 1);
            i3 = 3;
            int iso$twoDigitNumber7 = length > 3 ? parseIso$twoDigitNumber(charSequence, i10 + 4) : 0;
            int iso$twoDigitNumber8 = length > 6 ? parseIso$twoDigitNumber(charSequence, i10 + 7) : 0;
            if (iso$twoDigitNumber7 > 59) {
                return parseIso$parseFailure(charSequence, "Expected offset-minute-of-hour in 0..59, got " + iso$twoDigitNumber7);
            }
            if (iso$twoDigitNumber8 > 59) {
                return parseIso$parseFailure(charSequence, "Expected offset-second-of-minute in 0..59, got " + iso$twoDigitNumber8);
            }
            if (iso$twoDigitNumber6 > 17 && (iso$twoDigitNumber6 != 18 || iso$twoDigitNumber7 != 0 || iso$twoDigitNumber8 != 0)) {
                return parseIso$parseFailure(charSequence, "Expected an offset in -18:00..+18:00, got " + charSequence.subSequence(i10, charSequence.length()).toString());
            }
            i4 = (cCharAt4 == '-' ? -1 : 1) * ((iso$twoDigitNumber6 * SECONDS_PER_HOUR) + (iso$twoDigitNumber7 * 60) + iso$twoDigitNumber8);
            i5 = 1;
        } else {
            if (cCharAt4 != 'Z' && cCharAt4 != 'z') {
                return parseIso$parseFailure(charSequence, "Expected the UTC offset at position " + i10 + ", got '" + cCharAt4 + '\'');
            }
            int i17 = i10 + 1;
            if (charSequence.length() != i17) {
                return parseIso$parseFailure(charSequence, "Extra text after the instant at position " + i17);
            }
            i5 = 1;
            i4 = 0;
            i3 = 3;
        }
        if (i5 > iso$twoDigitNumber || iso$twoDigitNumber >= 13) {
            return parseIso$parseFailure(charSequence, "Expected a month number in 1..12, got " + iso$twoDigitNumber);
        }
        if (i5 > iso$twoDigitNumber2 || iso$twoDigitNumber2 > monthLength(iso$twoDigitNumber, isLeapYear(iCharAt))) {
            return parseIso$parseFailure(charSequence, "Expected a valid day-of-month for month " + iso$twoDigitNumber + " of year " + iCharAt + ", got " + iso$twoDigitNumber2);
        }
        if (iso$twoDigitNumber3 > 23) {
            return parseIso$parseFailure(charSequence, "Expected hour in 0..23, got " + iso$twoDigitNumber3);
        }
        if (iso$twoDigitNumber4 > 59) {
            return parseIso$parseFailure(charSequence, "Expected minute-of-hour in 0..59, got " + iso$twoDigitNumber4);
        }
        if (iso$twoDigitNumber5 > 59) {
            return parseIso$parseFailure(charSequence, "Expected second-of-minute in 0..59, got " + iso$twoDigitNumber5);
        }
        int i18 = i3;
        UnboundLocalDateTime unboundLocalDateTime = new UnboundLocalDateTime(iCharAt, iso$twoDigitNumber, iso$twoDigitNumber2, iso$twoDigitNumber3, iso$twoDigitNumber4, iso$twoDigitNumber5, i2);
        long jM6890getYear = unboundLocalDateTime.getYear();
        long j = 365 * jM6890getYear;
        long month = (jM6890getYear >= 0 ? j + (((i18 + jM6890getYear) / 4) - ((99 + jM6890getYear) / 100)) + ((jM6890getYear + 399) / 400) : j - (((jM6890getYear / (-4)) - (jM6890getYear / (-100))) + (jM6890getYear / (-400)))) + (((unboundLocalDateTime.getMonth() * 367) - 362) / 12) + (unboundLocalDateTime.getDay() - 1);
        if (unboundLocalDateTime.getMonth() > 2) {
            month = !isLeapYear(unboundLocalDateTime.getYear()) ? month - 2 : (-1) + month;
        }
        return new InstantParseResult.C1326Success((((month - DAYS_0000_TO_1970) * SECONDS_PER_DAY) + (((unboundLocalDateTime.getHour() * SECONDS_PER_HOUR) + (unboundLocalDateTime.getMinute() * 60)) + unboundLocalDateTime.getSecond())) - i4, unboundLocalDateTime.getNanosecond());
    }

    private static final InstantParseResult.C1325Failure parseIso$expect(CharSequence charSequence, String str, int i, Function1<? super Character, Boolean> function1) {
        char cCharAt = charSequence.charAt(i);
        if (function1.mo2237invoke(Character.valueOf(cCharAt)).booleanValue()) {
            return null;
        }
        return parseIso$parseFailure(charSequence, "Expected " + str + ", but got '" + cCharAt + "' at position " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$0(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$10(char c) {
        return '0' <= c && c < ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$2(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$4(char c) {
        return c == 'T' || c == 't';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$6(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseIso$lambda$8(char c) {
        return c == ':';
    }

    private static final InstantParseResult.C1325Failure parseIso$parseFailure(CharSequence charSequence, String str) {
        return new InstantParseResult.C1325Failure(str + " when parsing an Instant from \"" + truncateForErrorMessage(charSequence, 64) + Typography.quote, charSequence);
    }

    private static final int parseIso$twoDigitNumber(CharSequence charSequence, int i) {
        return ((charSequence.charAt(i) - '0') * 10) + (charSequence.charAt(i + 1) - '0');
    }

    private static final long safeAddOrElse(long j, long j2, Function0 function0) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        function0.mo4323invoke();
        throw new KotlinNothingValueException();
    }

    private static final long safeMultiplyOrElse(long j, long j2, Function0 function0) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        function0.mo4323invoke();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String truncateForErrorMessage(CharSequence charSequence, int i) {
        if (charSequence.length() <= i) {
            return charSequence.toString();
        }
        return charSequence.subSequence(0, i).toString() + "...";
    }
}
