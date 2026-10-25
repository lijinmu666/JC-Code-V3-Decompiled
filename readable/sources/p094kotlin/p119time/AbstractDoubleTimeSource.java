package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.ComparableTimeMark;
import p094kotlin.p119time.TimeSource;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010Ê\u0001\u0002\b\u0011Ê\u0001\u0018\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\b\u0015\u0012\u0006\b\n0\u00168\u0017¨\u0006\r"}, m4988d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", BuildConfig.f24315FLAVOR, "markNow", "Lkotlin/time/ComparableTimeMark;", "DoubleTimeMark", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.", "level", "Lkotlin/DeprecationLevel;", "ERROR"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@ExperimentalTime
/* loaded from: classes.dex */
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\r\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001f"}, m4988d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", BuildConfig.f24315FLAVOR, "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeSource$annotations", "()V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        public /* synthetic */ DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, abstractDoubleTimeSource, j);
        }

        private static /* synthetic */ void getTimeSource$annotations() {
        }

        @Override // p094kotlin.p119time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
        public long mo19824elapsedNowUwyO8pc() {
            return Duration.m19864minusLRDsOJo(DurationKt.toDuration(this.timeSource.m6861read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark
        /* renamed from: equals */
        public boolean mo6862equals(Object other) {
            return (other instanceof DoubleTimeMark) && Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) other).timeSource) && Duration.m19841equalsimpl0(mo19826minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m19931getZEROUwyO8pc());
        }

        @Override // p094kotlin.p119time.TimeMark
        public /* bridge */ boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // p094kotlin.p119time.TimeMark
        public /* bridge */ boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark
        public int hashCode() {
            return Duration.m19857hashCodeimpl(Duration.m19865plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public /* bridge */ ComparableTimeMark mo19825minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m19829minusLRDsOJo(this, j);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc, reason: not valid java name */
        public long mo19826minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof DoubleTimeMark) {
                DoubleTimeMark doubleTimeMark = (DoubleTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, doubleTimeMark.timeSource)) {
                    if (Duration.m19841equalsimpl0(this.offset, doubleTimeMark.offset) && Duration.m19861isInfiniteimpl(this.offset)) {
                        return Duration.INSTANCE.m19931getZEROUwyO8pc();
                    }
                    long jM19864minusLRDsOJo = Duration.m19864minusLRDsOJo(this.offset, doubleTimeMark.offset);
                    long duration = DurationKt.toDuration(this.startedAt - doubleTimeMark.startedAt, this.timeSource.getUnit());
                    return Duration.m19841equalsimpl0(duration, Duration.m19880unaryMinusUwyO8pc(jM19864minusLRDsOJo)) ? Duration.INSTANCE.m19931getZEROUwyO8pc() : Duration.m19865plusLRDsOJo(duration, jM19864minusLRDsOJo);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m19876toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }

        private DoubleTimeMark(double d, AbstractDoubleTimeSource timeSource, long j) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = d;
            this.timeSource = timeSource;
            this.offset = j;
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, java.lang.Comparable
        public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public ComparableTimeMark mo19827plusLRDsOJo(long duration) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m19865plusLRDsOJo(this.offset, duration), null);
        }
    }

    public AbstractDoubleTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    /* renamed from: read */
    public abstract double m6861read();

    @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
    /* renamed from: markNow */
    public ComparableTimeMark mo6860markNow() {
        return new DoubleTimeMark(m6861read(), this, Duration.INSTANCE.m19931getZEROUwyO8pc(), null);
    }
}
