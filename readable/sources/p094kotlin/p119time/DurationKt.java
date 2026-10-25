package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p109math.C1237MathKt;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u000f\u0010\u0010\u001a/\u0010\r\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001d\u001a/\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082\u0080\u0004¢\u0006\u0002\u0010 \u001a\u0016\u0010!\u001a\u00020\t*\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010$\u001a\u00020\u0018*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u001e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a&\u0010(\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a\u0016\u0010*\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004\u001a%\u0010+\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u0016H\u0083\u0088\u0004b\u0002\b\u0011¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\u0082\u0088\u0004¢\u0006\u0004\b1\u00102\u001a\u0018\u00103\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0018\u00105\u001a\u0004\u0018\u00010\u0004*\u00020\u00162\u0006\u00104\u001a\u00020\u0002H\u0082\u0080\u0004\u001a\u0012\u0010A\u001a\u00020\t*\u00020\tH\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010A\u001a\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004b\u0002\b\u0011\u001a\u0012\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0017\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u001f\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010Z\u001a\u0017\u0010[\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\u001a\u0017\u0010\\\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\tH\u0082\u0080\u0004¢\u0006\u0002\u0010T\"\u001f\u00106\u001a\u00020\u000b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0019\u0010;\u001a\u00020\t*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=\"\u0019\u0010>\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b?\u0010@\"\u000f\u0010B\u001a\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010C\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010D\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010E\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010F\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010G\u001a\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010H\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010I\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010J\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010K\u001a\u00020\tX\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010L\u001a\u00020\u0016X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010M\u001a\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006]"}, m4988d2 = {"toDuration", "Lkotlin/time/Duration;", BuildConfig.f24315FLAVOR, "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "Lkotlin/SinceKotlin;", "version", "1.6", BuildConfig.f24315FLAVOR, "(JLkotlin/time/DurationUnit;)J", BuildConfig.f24315FLAVOR, "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "Lkotlin/internal/InlineOnly;", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", BuildConfig.f24315FLAVOR, "strictIso", BuildConfig.f24315FLAVOR, "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", "other", "isInfiniteMillis", "isFiniteMillis", "sameSign", "a", "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lkotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", "start", "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Duration.kt\nkotlin/time/LongParser\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 5 Duration.kt\nkotlin/time/FractionalParser\n*L\n1#1,1629:1\n1#2:1630\n1300#3,12:1631\n1312#3,15:1646\n1300#3,12:1690\n1312#3,15:1705\n1665#4,3:1643\n1665#4,3:1684\n1665#4,3:1687\n1665#4,3:1702\n1665#4,3:1743\n1358#5,23:1661\n1358#5,23:1720\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1116#1:1631,12\n1116#1:1646,15\n1195#1:1690,12\n1195#1:1705,15\n1116#1:1643,3\n1125#1:1684,3\n1190#1:1687,3\n1195#1:1702,3\n1207#1:1743,3\n1125#1:1661,23\n1207#1:1720,23\n*E\n"})
/* loaded from: classes.dex */
public final class DurationKt {
    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.m6872values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.f5447SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.f5446MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.f5445HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.f5444DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long addMillisWithoutOverflow(long j, long j2) {
        return (j == MAX_MILLIS || j == -4611686018427387903L) ? ((-4611686018427387903L >= j2 || j2 >= MAX_MILLIS) && (j2 ^ j) < 0) ? Duration.INVALID_RAW_VALUE : j : (j2 == MAX_MILLIS || j2 == -4611686018427387903L) ? j2 : RangesKt.coerceIn(j + j2, -4611686018427387903L, MAX_MILLIS);
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        char cCharAt2 = i < StringsKt.getLastIndex(str) ? str.charAt(i + 1) : (char) 0;
        if (cCharAt == 'd') {
            return DurationUnit.f5444DAYS;
        }
        if (cCharAt == 'h') {
            return DurationUnit.f5445HOURS;
        }
        if (cCharAt == 's') {
            return DurationUnit.f5447SECONDS;
        }
        if (cCharAt == 'u') {
            if (cCharAt2 == 's') {
                return DurationUnit.MICROSECONDS;
            }
            return null;
        }
        if (cCharAt == 'm') {
            return cCharAt2 == 's' ? DurationUnit.MILLISECONDS : DurationUnit.f5446MINUTES;
        }
        if (cCharAt == 'n' && cCharAt2 == 's') {
            return DurationUnit.NANOSECONDS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j, int i) {
        return Duration.INSTANCE.m19927fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j) {
        return Duration.INSTANCE.m19927fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, MAX_MILLIS)) : durationOfNanos(millisToNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j) {
        return Duration.INSTANCE.m19927fromRawValueUwyO8pc$kotlin_stdlib(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j) {
        return (-4611686018426999999L > j || j >= 4611686018427000000L) ? durationOfMillis(nanosToMillis(j)) : durationOfNanos(j);
    }

    private static final long fractionDigitsToNanos(long j, DurationUnit durationUnit) {
        return C1237MathKt.roundToLong(j * getFractionMultiplier(durationUnit));
    }

    private static final long getFallbackFractionMultiplier(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i == 5) {
            return 60000000000L;
        }
        if (i == 6) {
            return 3600000000000L;
        }
        if (i == 7) {
            return 86400000000000L;
        }
        throw new IllegalStateException(("Invalid unit: " + durationUnit + " for fallback fraction multiplier").toString());
    }

    private static final double getFractionMultiplier(DurationUnit durationUnit) {
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case 7:
                return 0.0864d;
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }

    private static /* synthetic */ void getFractionMultiplier$annotations(DurationUnit durationUnit) {
    }

    private static final int getShortNameLength(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? 2 : 1;
    }

    @InlineOnly
    private static final long handleError(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
    }

    public static /* synthetic */ long handleError$default(boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = BuildConfig.f24315FLAVOR;
        }
        if (z) {
            throw new IllegalArgumentException(str);
        }
        return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
    }

    @InlineOnly
    private static final boolean isFiniteMillis(long j) {
        return -4611686018427387903L < j && j < MAX_MILLIS;
    }

    @InlineOnly
    private static final boolean isInfiniteMillis(long j) {
        return j == MAX_MILLIS || j == -4611686018427387903L;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'D') {
            return DurationUnit.f5444DAYS;
        }
        if (cCharAt == 'H') {
            return DurationUnit.f5445HOURS;
        }
        if (cCharAt == 'M') {
            return DurationUnit.f5446MINUTES;
        }
        if (cCharAt != 'S') {
            return null;
        }
        return DurationUnit.f5447SECONDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j) {
        return j * NANOS_IN_MILLIS;
    }

    @InlineOnly
    private static final int multiplyBy10(int i) {
        return (i << 3) + (i << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j) {
        return j / NANOS_IN_MILLIS;
    }

    /* renamed from: onInvalid-ge6A_vg, reason: not valid java name */
    private static final Duration m19936onInvalidge6A_vg(long j, Function0<Duration> function0) {
        return Duration.m19841equalsimpl0(j, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib()) ? function0.mo4323invoke() : Duration.m19834boximpl(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x019d, code lost:
    
        if (r2 >= r26.length()) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x019f, code lost:
    
        r8 = r26.charAt(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a5, code lost:
    
        if ('0' > r8) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a9, code lost:
    
        if (r8 >= ':') goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ab, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b0, code lost:
    
        r18 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b3, code lost:
    
        r18 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b5, code lost:
    
        if (r2 == r3) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01b7, code lost:
    
        if (r2 != r15) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ba, code lost:
    
        r6 = (r15 * p094kotlin.p119time.InstantKt.NANOS_PER_SECOND) + r6;
        r8 = r2;
        r2 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01c8, code lost:
    
        if (r29 != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d0, code lost:
    
        return p094kotlin.p119time.Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d6, code lost:
    
        throw new java.lang.IllegalArgumentException(org.conscrypt.BuildConfig.f24315FLAVOR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d7, code lost:
    
        r18 = '0';
        r2 = -1;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e0, code lost:
    
        r3 = defaultDurationUnitByShortNameOrNull(r26, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e4, code lost:
    
        if (r3 != null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01e6, code lost:
    
        r0 = "Unknown duration unit short name: " + r26.charAt(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01fb, code lost:
    
        if (r29 != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0203, code lost:
    
        return p094kotlin.p119time.Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0209, code lost:
    
        throw new java.lang.IllegalArgumentException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x020a, code lost:
    
        if (r10 == null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0210, code lost:
    
        if (r10.compareTo(r3) > 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0212, code lost:
    
        if (r29 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x021a, code lost:
    
        return p094kotlin.p119time.Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0222, code lost:
    
        throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0223, code lost:
    
        r9 = kotlin.time.DurationKt.WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x022c, code lost:
    
        if (r9 == 1) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x022f, code lost:
    
        if (r9 == 2) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0231, code lost:
    
        r11 = addMillisWithoutOverflow(r11, p094kotlin.p119time.DurationUnitKt__DurationUnitKt.convertDurationUnitToMilliseconds(r4, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x023b, code lost:
    
        r9 = p094kotlin.p119time.DurationKt.NANOS_IN_MILLIS;
        r11 = r11 + (r4 / r9);
        r13 = r13 + (r4 % r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0246, code lost:
    
        r11 = r11 + (r4 / 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0253, code lost:
    
        if (r11 > p094kotlin.p119time.DurationKt.MAX_NANOS_IN_MILLIS) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0255, code lost:
    
        r13 = (r4 % 1000) * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0258, code lost:
    
        r4 = getShortNameLength(r3) + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x025d, code lost:
    
        if (r16 == false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x025f, code lost:
    
        if (r4 >= r15) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0261, code lost:
    
        if (r29 != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0269, code lost:
    
        return p094kotlin.p119time.Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0271, code lost:
    
        throw new java.lang.IllegalArgumentException("Fractional component must be last");
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0278, code lost:
    
        if (r3.compareTo(p094kotlin.p119time.DurationUnit.f5446MINUTES) < 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x027e, code lost:
    
        if ((r4 - r2) <= 15) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0280, code lost:
    
        r5 = parseFractionFallback(r26, r2, r4 - getShortNameLength(r3), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x028b, code lost:
    
        r5 = fractionDigitsToNanos(r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x028f, code lost:
    
        r13 = r13 + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0290, code lost:
    
        r5 = r15;
        r10 = r3;
        r6 = r4;
        r2 = r18;
        r7 = r19;
        r4 = 1;
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x029c, code lost:
    
        if (r29 != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02a4, code lost:
    
        return p094kotlin.p119time.Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02aa, code lost:
    
        throw new java.lang.IllegalArgumentException(org.conscrypt.BuildConfig.f24315FLAVOR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f2, code lost:
    
        if (r8 == r6) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f5, code lost:
    
        if (r8 == r15) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
    
        if (r26.charAt(r8) != '.') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ff, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0102, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0104, code lost:
    
        if (r16 == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0106, code lost:
    
        r3 = r8 + 1;
        r2 = p094kotlin.p119time.FractionalParser.INSTANCE;
        r2 = java.lang.Math.min(r8 + 7, r26.length());
        r6 = r3;
        r21 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0118, code lost:
    
        if (r6 >= r2) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x011a, code lost:
    
        r9 = r26.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
    
        if ('0' > r9) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0124, code lost:
    
        if (r9 >= ':') goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0126, code lost:
    
        r21 = ((r21 << 3) + (r21 << 1)) + (r9 - '0');
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0136, code lost:
    
        r15 = r21;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013d, code lost:
    
        if (r9 >= (6 - (r6 - r3))) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013f, code lost:
    
        r15 = (r15 << 3) + (r15 << 1);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014c, code lost:
    
        r2 = java.lang.Math.min(r6 + 9, r26.length());
        r9 = r6;
        r21 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x015b, code lost:
    
        if (r9 >= r2) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
    
        r23 = r2;
        r2 = r26.charAt(r9);
        r24 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0167, code lost:
    
        if ('0' > r2) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x016b, code lost:
    
        if (r2 >= ':') goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x016d, code lost:
    
        r21 = ((r21 << 3) + (r21 << 1)) + (r2 - '0');
        r9 = r9 + 1;
        r2 = r23;
        r8 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0180, code lost:
    
        r24 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0182, code lost:
    
        r2 = 9 - (r9 - r6);
        r6 = r21;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0189, code lost:
    
        if (r8 >= r2) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018b, code lost:
    
        r6 = (r6 << 3) + (r6 << 1);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0196, code lost:
    
        r2 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseDefaultStringFormat(String str, int i, boolean z, boolean z2) {
        boolean z3;
        int i2;
        boolean z4;
        String str2;
        char cCharAt;
        char cCharAt2;
        char c = '0';
        int i3 = 1;
        int length = str.length();
        boolean z5 = !z;
        if (z && str.charAt(i) == '(' && str.charAt(length - 1) == ')') {
            i2 = i + 1;
            length--;
            if (i2 == length) {
                if (z2) {
                    throw new IllegalArgumentException("No components");
                }
                return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
            }
            z3 = true;
        } else {
            z3 = z5;
            i2 = i;
        }
        DurationUnit durationUnit = null;
        boolean z6 = true;
        long jAddMillisWithoutOverflow = 0;
        long j = 0;
        loop0: while (i2 < length) {
            if (!z6 && z3) {
                while (i2 < str.length() && str.charAt(i2) == ' ') {
                    i2 += i3;
                }
            }
            LongParser longParser = LongParser.INSTANCE.getDefault();
            int i4 = (longParser.allowSign && ((cCharAt2 = str.charAt(i2)) == '+' || cCharAt2 == '-')) ? i2 + 1 : i2;
            while (i4 < str.length() && str.charAt(i4) == c) {
                i4 += i3;
            }
            int i5 = length;
            long j2 = 0;
            while (true) {
                if (i4 >= str.length()) {
                    z4 = z3;
                    break;
                }
                char cCharAt3 = str.charAt(i4);
                z4 = z3;
                if ('0' <= cCharAt3 && cCharAt3 < ':') {
                    int i6 = cCharAt3 - '0';
                    if (j2 > longParser.overflowThreshold) {
                        str2 = BuildConfig.f24315FLAVOR;
                        break loop0;
                    }
                    if (j2 == longParser.overflowThreshold) {
                        str2 = BuildConfig.f24315FLAVOR;
                        if (i6 > longParser.lastDigitMax) {
                            break loop0;
                        }
                    }
                    j2 = (j2 << 3) + (j2 << 1) + i6;
                    i4++;
                    z3 = z4;
                } else {
                    break;
                }
            }
            while (i4 < str.length() && '0' <= (cCharAt = str.charAt(i4)) && cCharAt < ':') {
                i4++;
            }
            if (z2) {
                throw new IllegalArgumentException(str2);
            }
            return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
        }
        return Duration.m19865plusLRDsOJo(toDuration(jAddMillisWithoutOverflow, DurationUnit.MILLISECONDS), toDuration(j, DurationUnit.NANOSECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseDuration(String str, boolean z, boolean z2) {
        int i;
        int i2;
        long jM19928getINFINITEUwyO8pc;
        if (str.length() == 0) {
            if (z2) {
                throw new IllegalArgumentException("The string is empty");
            }
            return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '+') {
            i2 = cCharAt != '-' ? 0 : 1;
            i = i2;
        } else {
            i = 0;
            i2 = 1;
        }
        boolean z3 = i2 > 0;
        if (str.length() <= i2) {
            if (z2) {
                throw new IllegalArgumentException("No components");
            }
            return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
        }
        if (str.charAt(i2) == 'P') {
            jM19928getINFINITEUwyO8pc = parseIsoStringFormat(str, i2 + 1, z2);
        } else {
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException(BuildConfig.f24315FLAVOR);
                }
                return Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib();
            }
            jM19928getINFINITEUwyO8pc = StringsKt.regionMatches(str, i2, INFINITY_STRING, 0, Math.max(str.length() - i2, 8), true) ? Duration.INSTANCE.m19928getINFINITEUwyO8pc() : parseDefaultStringFormat(str, i2, z3, z2);
        }
        return (i == 0 || Duration.m19841equalsimpl0(jM19928getINFINITEUwyO8pc, Duration.INSTANCE.m19929getINVALIDUwyO8pc$kotlin_stdlib())) ? jM19928getINFINITEUwyO8pc : Duration.m19880unaryMinusUwyO8pc(jM19928getINFINITEUwyO8pc);
    }

    public static /* synthetic */ long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    private static final long parseFractionFallback(String str, int i, int i2, DurationUnit durationUnit) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return C1237MathKt.roundToLong(Double.parseDouble(strSubstring) * getFallbackFractionMultiplier(durationUnit));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:40:0x008b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseIsoStringFormat(java.lang.String r25, int r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p094kotlin.p119time.DurationKt.parseIsoStringFormat(java.lang.String, int, boolean):long");
    }

    @InlineOnly
    private static final boolean sameSign(long j, long j2) {
        return (j ^ j2) >= 0;
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m19937timeskIfJnKk(double d, long j) {
        return Duration.m19866timesUwyO8pc(j, d);
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m19938timesmvk6XK0(int i, long j) {
        return Duration.m19867timesUwyO8pc(j, i);
    }

    @SinceKotlin(m5061version = "1.6")
    public static final long toDuration(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(DurationUnit.f5447SECONDS) <= 0 ? durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i, unit, DurationUnit.NANOSECONDS)) : toDuration(i, unit);
    }

    @InlineOnly
    private static final long multiplyBy10(long j) {
        return (j << 3) + (j << 1);
    }

    @SinceKotlin(m5061version = "1.6")
    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long jConvertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if ((-jConvertDurationUnitOverflow) <= j && j <= jConvertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j, unit, durationUnit));
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (unit.compareTo(durationUnit2) >= 0) {
            return durationOfMillis(C1237MathKt.m6390getSign(j) * DurationUnitKt__DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(j, -9223372036854775807L)), unit));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j, unit, durationUnit2), -4611686018427387903L, MAX_MILLIS));
    }

    @SinceKotlin(m5061version = "1.6")
    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double dConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(dConvertDurationUnit)) {
            long jRoundToLong = C1237MathKt.roundToLong(dConvertDurationUnit);
            if (-4611686018426999999L <= jRoundToLong && jRoundToLong < 4611686018427000000L) {
                return durationOfNanos(jRoundToLong);
            }
            return durationOfMillisNormalized(C1237MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
