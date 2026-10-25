package p094kotlin.p119time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.NotImplementedError;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.Duration;

@SinceKotlin(m5061version = "2.3")
@Metadata(m4987d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001'B\u0019\b@\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u000e\u001a\u00020\u0005H\u0086\u0080\u0004J\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0082\u0004J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0096\u0082\u0004J\n\u0010\u001d\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u0096\u0080\u0004J\n\u0010 \u001a\u00020\u001cH\u0082\u0080\u0004J\u001b\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060$j\u0002`%H\u0082\u0080\u0004¢\u0006\u0002\u0010&R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rÊ\u0001\f\b)\u0012\b\b*\u0012\u0004\b\b(+Ê\u0001\u0010\b,\u0012\f\b-\u0012\b\b\fJ\u0004\b\t0.¨\u0006("}, m4988d2 = {"Lkotlin/time/Instant;", BuildConfig.f24315FLAVOR, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "epochSeconds", BuildConfig.f24315FLAVOR, "nanosecondsOfSecond", BuildConfig.f24315FLAVOR, "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/Instant;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/Instant;)J", "compareTo", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "toString", BuildConfig.f24315FLAVOR, "writeReplace", "readObject", BuildConfig.f24315FLAVOR, "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension(m6344value = {"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Instant.kt\nkotlin/time/InstantKt\n+ 4 Duration.kt\nkotlin/time/Duration\n*L\n1#1,871:1\n1#2:872\n810#3,14:873\n793#3,6:887\n810#3,14:893\n793#3,6:907\n793#3,6:914\n620#4:913\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant\n*L\n150#1:873,14\n153#1:887,6\n161#1:893,14\n164#1:907,6\n188#1:914,6\n184#1:913\n*E\n"})
/* renamed from: kotlin.time.Instant */
/* loaded from: classes.dex */
public final class C1324Instant implements Comparable<C1324Instant>, Serializable {
    private final long epochSeconds;
    private final int nanosecondsOfSecond;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MIN */
    private static final C1324Instant f5449MIN = new C1324Instant(-31557014167219200L, 0);

    /* renamed from: MAX */
    private static final C1324Instant f5448MAX = new C1324Instant(31556889864403199L, 999999999);

    @Metadata(m4987d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u0005H\u0087\u0080\u0004b<\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\"\b\t\u0012\u001e\b\u000bB\u001a\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\b(\u000e\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011J\u0012\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0080\u0004J\u001c\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0086\u0080\u0004J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0080\u0004J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0080\u0004R\u0015\u0010\u001d\u001a\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0015\u0010\"\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0015\u0010$\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001f¨\u0006&"}, m4988d2 = {"Lkotlin/time/Instant$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "now", "Lkotlin/time/Instant;", "Lkotlin/Deprecated;", "message", "Use Clock.System.now() instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "Clock.System.now()", "imports", "kotlin.time.Clock", "level", "Lkotlin/DeprecationLevel;", "ERROR", "fromEpochMilliseconds", "epochMilliseconds", BuildConfig.f24315FLAVOR, "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", BuildConfig.f24315FLAVOR, "parse", "input", BuildConfig.f24315FLAVOR, "parseOrNull", "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlin/time/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlin_stdlib", "MAX", "getMAX$kotlin_stdlib", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n+ 2 Instant.kt\nkotlin/time/InstantKt\n*L\n1#1,871:1\n793#2,6:872\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlin/time/Instant$Companion\n*L\n320#1:872,6\n*E\n"})
    /* renamed from: kotlin.time.Instant$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ C1324Instant fromEpochSeconds$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return companion.fromEpochSeconds(j, j2);
        }

        public final C1324Instant fromEpochMilliseconds(long epochMilliseconds) {
            long j = epochMilliseconds / 1000;
            if ((epochMilliseconds ^ 1000) < 0 && j * 1000 != epochMilliseconds) {
                j--;
            }
            long j2 = epochMilliseconds % 1000;
            return j < -31557014167219200L ? getMIN$kotlin_stdlib() : j > 31556889864403199L ? getMAX$kotlin_stdlib() : fromEpochSeconds(j, (int) ((j2 + (1000 & (((j2 ^ 1000) & ((-j2) | j2)) >> 63))) * DurationKt.NANOS_IN_MILLIS));
        }

        public final C1324Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            long j = nanosecondAdjustment / 1000000000;
            if ((nanosecondAdjustment ^ 1000000000) < 0 && j * 1000000000 != nanosecondAdjustment) {
                j--;
            }
            long j2 = epochSeconds + j;
            if ((epochSeconds ^ j2) < 0 && (j ^ epochSeconds) >= 0) {
                return epochSeconds > 0 ? C1324Instant.INSTANCE.getMAX$kotlin_stdlib() : C1324Instant.INSTANCE.getMIN$kotlin_stdlib();
            }
            if (j2 < -31557014167219200L) {
                return getMIN$kotlin_stdlib();
            }
            if (j2 > 31556889864403199L) {
                return getMAX$kotlin_stdlib();
            }
            long j3 = nanosecondAdjustment % 1000000000;
            return new C1324Instant(j2, (int) (j3 + ((((j3 ^ 1000000000) & ((-j3) | j3)) >> 63) & 1000000000)));
        }

        public final C1324Instant getDISTANT_FUTURE() {
            return fromEpochSeconds(3093527980800L, 0);
        }

        public final C1324Instant getDISTANT_PAST() {
            return fromEpochSeconds(-3217862419201L, 999999999);
        }

        public final C1324Instant getMAX$kotlin_stdlib() {
            return C1324Instant.f5448MAX;
        }

        public final C1324Instant getMIN$kotlin_stdlib() {
            return C1324Instant.f5449MIN;
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", m5048imports = {"kotlin.time.Clock"}))
        /* renamed from: now */
        public final C1324Instant m6876now() {
            throw new NotImplementedError(null, 1, null);
        }

        /* renamed from: parse */
        public final C1324Instant m6877parse(CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.parseIso(input).toInstant();
        }

        public final C1324Instant parseOrNull(CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.parseIso(input).toInstantOrNull();
        }

        private Companion() {
        }

        public final C1324Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return fromEpochSeconds(epochSeconds, nanosecondAdjustment);
        }
    }

    public C1324Instant(long j, int i) {
        this.epochSeconds = j;
        this.nanosecondsOfSecond = i;
        if (-31557014167219200L > j || j >= 31556889864403200L) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return InstantJvmKt.serializedInstant(this);
    }

    /* renamed from: equals */
    public boolean m6875equals(Object other) {
        if (this != other) {
            if (other instanceof C1324Instant) {
                C1324Instant c1324Instant = (C1324Instant) other;
                if (this.epochSeconds != c1324Instant.epochSeconds || this.nanosecondsOfSecond != c1324Instant.nanosecondsOfSecond) {
                }
            }
            return false;
        }
        return true;
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final C1324Instant m19939minusLRDsOJo(long duration) {
        return m19941plusLRDsOJo(Duration.m19880unaryMinusUwyO8pc(duration));
    }

    /* renamed from: minus-UwyO8pc, reason: not valid java name */
    public final long m19940minusUwyO8pc(C1324Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m19865plusLRDsOJo(DurationKt.toDuration(this.epochSeconds - other.epochSeconds, DurationUnit.f5447SECONDS), DurationKt.toDuration(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final C1324Instant m19941plusLRDsOJo(long duration) {
        long jM19850getInWholeSecondsimpl = Duration.m19850getInWholeSecondsimpl(duration);
        int iM19852getNanosecondsComponentimpl = Duration.m19852getNanosecondsComponentimpl(duration);
        if (jM19850getInWholeSecondsimpl == 0 && iM19852getNanosecondsComponentimpl == 0) {
            return this;
        }
        long j = this.epochSeconds;
        long j2 = j + jM19850getInWholeSecondsimpl;
        if ((j ^ j2) >= 0 || (jM19850getInWholeSecondsimpl ^ j) < 0) {
            return INSTANCE.fromEpochSeconds(j2, this.nanosecondsOfSecond + iM19852getNanosecondsComponentimpl);
        }
        return Duration.m19863isPositiveimpl(duration) ? f5448MAX : f5449MIN;
    }

    public final long toEpochMilliseconds() {
        long j = this.epochSeconds;
        long j2 = 1000;
        if (j >= 0) {
            if (j != 1) {
                if (j != 0) {
                    long j3 = j * 1000;
                    if (j3 / 1000 != j) {
                        return LongCompanionObject.MAX_VALUE;
                    }
                    j2 = j3;
                } else {
                    j2 = 0;
                }
            }
            long j4 = this.nanosecondsOfSecond / DurationKt.NANOS_IN_MILLIS;
            long j5 = j2 + j4;
            return ((j2 ^ j5) >= 0 || (j4 ^ j2) < 0) ? j5 : LongCompanionObject.MAX_VALUE;
        }
        long j6 = j + 1;
        if (j6 != 1) {
            if (j6 != 0) {
                long j7 = j6 * 1000;
                if (j7 / 1000 != j6) {
                    return Long.MIN_VALUE;
                }
                j2 = j7;
            } else {
                j2 = 0;
            }
        }
        long j8 = (this.nanosecondsOfSecond / DurationKt.NANOS_IN_MILLIS) - 1000;
        long j9 = j2 + j8;
        if ((j2 ^ j9) >= 0 || (j8 ^ j2) < 0) {
            return j9;
        }
        return Long.MIN_VALUE;
    }

    public String toString() {
        return InstantKt.formatIso(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(C1324Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM6320compare = Intrinsics.m6320compare(this.epochSeconds, other.epochSeconds);
        return iM6320compare != 0 ? iM6320compare : Intrinsics.m6319compare(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }
}
