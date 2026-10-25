package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.C1120LazyKt;
import p094kotlin.InterfaceC1119Lazy;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p109math.C1237MathKt;
import p094kotlin.p119time.ComparableTimeMark;
import p094kotlin.p119time.TimeSource;

@SinceKotlin(m5061version = "1.9")
@Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\u000f\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016Ê\u0001\u0010\b\u0017\u0012\f\b\u0018\u0012\b\b\fJ\u0004\b\t0\u0019¨\u0006\u0013"}, m4988d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", BuildConfig.f24315FLAVOR, "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    /* renamed from: zero$delegate, reason: from kotlin metadata */
    private final InterfaceC1119Lazy zero;

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, m4988d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", BuildConfig.f24315FLAVOR, "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,210:1\n80#2:211\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:211\n*E\n"})
    public static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        @Override // p094kotlin.p119time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo19824elapsedNowUwyO8pc() {
            return Duration.m19864minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark
        /* renamed from: equals */
        public boolean mo6862equals(Object other) {
            return (other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource) && Duration.m19841equalsimpl0(mo19826minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m19931getZEROUwyO8pc());
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
            return (Duration.m19857hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public /* bridge */ ComparableTimeMark mo19825minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m19829minusLRDsOJo(this, j);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo19826minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m19865plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m19864minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m19876toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, java.lang.Comparable
        public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo19827plusLRDsOJo(long duration) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m19861isInfiniteimpl(duration)) {
                return new LongTimeMark(LongSaturatedMathKt.m19943saturatingAddNuflL3o(this.startedAt, unit, duration), this.timeSource, Duration.INSTANCE.m19931getZEROUwyO8pc(), null);
            }
            long jM19879truncateToUwyO8pc$kotlin_stdlib = Duration.m19879truncateToUwyO8pc$kotlin_stdlib(duration, unit);
            long jM19865plusLRDsOJo = Duration.m19865plusLRDsOJo(Duration.m19864minusLRDsOJo(duration, jM19879truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long jM19943saturatingAddNuflL3o = LongSaturatedMathKt.m19943saturatingAddNuflL3o(this.startedAt, unit, jM19879truncateToUwyO8pc$kotlin_stdlib);
            long jM19879truncateToUwyO8pc$kotlin_stdlib2 = Duration.m19879truncateToUwyO8pc$kotlin_stdlib(jM19865plusLRDsOJo, unit);
            long jM19943saturatingAddNuflL3o2 = LongSaturatedMathKt.m19943saturatingAddNuflL3o(jM19943saturatingAddNuflL3o, unit, jM19879truncateToUwyO8pc$kotlin_stdlib2);
            long jM19864minusLRDsOJo = Duration.m19864minusLRDsOJo(jM19865plusLRDsOJo, jM19879truncateToUwyO8pc$kotlin_stdlib2);
            long jM19849getInWholeNanosecondsimpl = Duration.m19849getInWholeNanosecondsimpl(jM19864minusLRDsOJo);
            if (jM19943saturatingAddNuflL3o2 != 0 && jM19849getInWholeNanosecondsimpl != 0 && (jM19943saturatingAddNuflL3o2 ^ jM19849getInWholeNanosecondsimpl) < 0) {
                long duration2 = DurationKt.toDuration(C1237MathKt.m6390getSign(jM19849getInWholeNanosecondsimpl), unit);
                jM19943saturatingAddNuflL3o2 = LongSaturatedMathKt.m19943saturatingAddNuflL3o(jM19943saturatingAddNuflL3o2, unit, duration2);
                jM19864minusLRDsOJo = Duration.m19864minusLRDsOJo(jM19864minusLRDsOJo, duration2);
            }
            if ((1 | (jM19943saturatingAddNuflL3o2 - 1)) == LongCompanionObject.MAX_VALUE) {
                jM19864minusLRDsOJo = Duration.INSTANCE.m19931getZEROUwyO8pc();
            }
            return new LongTimeMark(jM19943saturatingAddNuflL3o2, this.timeSource, jM19864minusLRDsOJo, null);
        }
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero = C1120LazyKt.m4981lazy(new Function0() { // from class: o.xJ
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return Long.valueOf(this.f17370mjFkc.mo6866read());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return mo6866read() - m6863getZero();
    }

    /* renamed from: getZero */
    private final long m6863getZero() {
        return ((Number) this.zero.getValue()).longValue();
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    /* renamed from: read */
    public abstract long mo6866read();

    @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
    /* renamed from: markNow */
    public ComparableTimeMark mo6860markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.INSTANCE.m19931getZEROUwyO8pc(), null);
    }
}
