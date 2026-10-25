package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.RangesKt;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0007\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0081\u0080\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\"\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m4988d2 = {"convertDurationUnitToMilliseconds", BuildConfig.f24315FLAVOR, "value", "unit", "Lkotlin/time/DurationUnit;", "multiplyNonNegativeWithoutOverflow", "other", "multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt", "millisMultiplier", "getMillisMultiplier$DurationUnitKt__DurationUnitKt", "(Lkotlin/time/DurationUnit;)J", "shortName", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.3", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes.dex */
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.m6872values().length];
            try {
                iArr[DurationUnit.f5444DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.f5445HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.f5446MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.f5447SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long convertDurationUnitToMilliseconds(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return m6873x8de0e79a(j, getMillisMultiplier$DurationUnitKt__DurationUnitKt(unit));
    }

    private static final long getMillisMultiplier$DurationUnitKt__DurationUnitKt(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i == 1) {
            return DurationKt.MILLIS_IN_DAY;
        }
        if (i == 2) {
            return DurationKt.MILLIS_IN_HOUR;
        }
        if (i == 3) {
            return DurationKt.MILLIS_IN_MINUTE;
        }
        if (i == 4) {
            return 1000L;
        }
        if (i == 5) {
            return 1L;
        }
        throw new IllegalStateException(("Wrong unit for millisMultiplier: " + durationUnit).toString());
    }

    /* renamed from: multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt */
    private static final long m6873x8de0e79a(long j, long j2) {
        if (j == 0) {
            return 0L;
        }
        if (j == 1) {
            return RangesKt.coerceAtMost(j2, DurationKt.MAX_MILLIS);
        }
        if (j2 == 1) {
            return RangesKt.coerceAtMost(j, DurationKt.MAX_MILLIS);
        }
        int iNumberOfLeadingZeros = (128 - Long.numberOfLeadingZeros(j)) - Long.numberOfLeadingZeros(j2);
        return iNumberOfLeadingZeros < 63 ? j * j2 : iNumberOfLeadingZeros > 63 ? DurationKt.MAX_MILLIS : RangesKt.coerceAtMost(j * j2, DurationKt.MAX_MILLIS);
    }

    @SinceKotlin(m5061version = "1.3")
    public static final String shortName(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return "d";
            case 2:
                return "h";
            case 3:
                return "m";
            case 4:
                return "s";
            case 5:
                return "ms";
            case 6:
                return "ns";
            case 7:
                return "us";
            default:
                throw new IllegalStateException(("Unknown unit: " + durationUnit).toString());
        }
    }
}
