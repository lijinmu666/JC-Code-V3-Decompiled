package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.JvmInline;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.ComparableTimeMark;

@SinceKotlin(m5061version = "1.9")
@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nÊ\u0001\u0010\b\u000b\u0012\f\b\f\u0012\b\b\fJ\u0004\b\t0\r¨\u0006\u0007"}, m4988d2 = {"Lkotlin/time/TimeSource;", BuildConfig.f24315FLAVOR, "markNow", "Lkotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"Lkotlin/time/TimeSource$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004¨\u0006\u000b"}, m4988d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", BuildConfig.f24315FLAVOR, "ValueTimeMark", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        @SinceKotlin(m5061version = "1.9")
        @Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b@\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u000eJ\u0011\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u000eJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\b('Ê\u0001\u0010\b(\u0012\f\b)\u0012\b\b\fJ\u0004\b\t0*Ê\u0001\u0002\b+¨\u0006$"}, m4988d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", BuildConfig.f24315FLAVOR, "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", BuildConfig.f24315FLAVOR, "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", BuildConfig.f24315FLAVOR, "compareTo-6eNON_k", "(JJ)I", "equals", BuildConfig.f24315FLAVOR, "hashCode", "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "Lkotlin/jvm/JvmInline;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
        @JvmInline
        @WasExperimental(markerClass = {ExperimentalTime.class})
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            private /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m19954boximpl(long j) {
                return new ValueTimeMark(j);
            }

            /* renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m19955compareTo6eNON_k(long j, long j2) {
                return Duration.m19835compareToLRDsOJo(m19964minus6eNON_k(j, j2), Duration.INSTANCE.m19931getZEROUwyO8pc());
            }

            /* renamed from: compareTo-impl, reason: not valid java name */
            public static int m19956compareToimpl(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m19954boximpl(j).compareTo(other);
            }

            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m19957constructorimpl(long j) {
                return j;
            }

            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m19959equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).getReading();
            }

            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m19960equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m19961hasNotPassedNowimpl(long j) {
                return Duration.m19862isNegativeimpl(m19958elapsedNowUwyO8pc(j));
            }

            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m19962hasPassedNowimpl(long j) {
                return !Duration.m19862isNegativeimpl(m19958elapsedNowUwyO8pc(j));
            }

            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m19963hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            /* renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m19964minus6eNON_k(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m19946differenceBetweenfRLX17w(j, j2);
            }

            /* renamed from: toString-impl, reason: not valid java name */
            public static String m19968toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override // p094kotlin.p119time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo19824elapsedNowUwyO8pc() {
                return m19958elapsedNowUwyO8pc(this.reading);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark
            /* renamed from: equals */
            public boolean mo6862equals(Object other) {
                return m19959equalsimpl(this.reading, other);
            }

            @Override // p094kotlin.p119time.TimeMark
            public boolean hasNotPassedNow() {
                return m19961hasNotPassedNowimpl(this.reading);
            }

            @Override // p094kotlin.p119time.TimeMark
            public boolean hasPassedNow() {
                return m19962hasPassedNowimpl(this.reading);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark
            public int hashCode() {
                return m19963hashCodeimpl(this.reading);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo19825minusLRDsOJo(long j) {
                return m19954boximpl(m19969minusLRDsOJo(j));
            }

            @Override // p094kotlin.p119time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo19826minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m19966minusUwyO8pc(this.reading, other);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo19827plusLRDsOJo(long j) {
                return m19954boximpl(m19970plusLRDsOJo(j));
            }

            public String toString() {
                return m19968toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getReading() {
                return this.reading;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m19958elapsedNowUwyO8pc(long j) {
                return MonotonicTimeSource.INSTANCE.m19947elapsedFrom6eNON_k(j);
            }

            /* renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m19966minusUwyO8pc(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (other instanceof ValueTimeMark) {
                    return m19964minus6eNON_k(j, ((ValueTimeMark) other).getReading());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m19968toStringimpl(j)) + " and " + other);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark, java.lang.Comparable
            public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo19825minusLRDsOJo(long j) {
                return m19954boximpl(m19969minusLRDsOJo(j));
            }

            @Override // p094kotlin.p119time.ComparableTimeMark, p094kotlin.p119time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo19827plusLRDsOJo(long j) {
                return m19954boximpl(m19970plusLRDsOJo(j));
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m19969minusLRDsOJo(long j) {
                return m19965minusLRDsOJo(this.reading, j);
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m19970plusLRDsOJo(long j) {
                return m19967plusLRDsOJo(this.reading, j);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m19965minusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m19945adjustReading6QKq23U(j, Duration.m19880unaryMinusUwyO8pc(j2));
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m19967plusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m19945adjustReading6QKq23U(j, j2);
            }
        }

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
        /* renamed from: markNow */
        public /* bridge */ /* synthetic */ ComparableTimeMark mo6860markNow() {
            return ValueTimeMark.m19954boximpl(m19953markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m19953markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m19948markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
        /* renamed from: markNow */
        public /* bridge */ /* synthetic */ TimeMark mo6860markNow() {
            return ValueTimeMark.m19954boximpl(m19953markNowz9LOYto());
        }
    }

    @SinceKotlin(m5061version = "1.9")
    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007Ê\u0001\u0010\b\b\u0012\f\b\t\u0012\b\b\fJ\u0004\b\t0\n¨\u0006\u0004"}, m4988d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public interface WithComparableMarks extends TimeSource {
        @Override // p094kotlin.p119time.TimeSource
        /* renamed from: markNow */
        ComparableTimeMark mo6860markNow();
    }

    /* renamed from: markNow */
    TimeMark mo6860markNow();
}
