package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.TimeMark;

@SinceKotlin(m5061version = "1.9")
@Metadata(m4987d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u0019\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0082\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0082\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0000H¦\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0082\u0004J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0011H¦\u0082\u0004J\n\u0010\u0012\u001a\u00020\u000eH¦\u0080\u0004Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016Ê\u0001\u0010\b\u0017\u0012\f\b\u0018\u0012\b\b\fJ\u0004\b\t0\u0019¨\u0006\u0013"}, m4988d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", BuildConfig.f24315FLAVOR, "plus", "duration", "Lkotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "compareTo", BuildConfig.f24315FLAVOR, "equals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "hashCode", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes.dex */
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        public static int compareTo(ComparableTimeMark comparableTimeMark, ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Duration.m19835compareToLRDsOJo(comparableTimeMark.mo19826minusUwyO8pc(other), Duration.INSTANCE.m19931getZEROUwyO8pc());
        }

        public static boolean hasNotPassedNow(ComparableTimeMark comparableTimeMark) {
            return TimeMark.DefaultImpls.hasNotPassedNow(comparableTimeMark);
        }

        public static boolean hasPassedNow(ComparableTimeMark comparableTimeMark) {
            return TimeMark.DefaultImpls.hasPassedNow(comparableTimeMark);
        }

        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static ComparableTimeMark m19829minusLRDsOJo(ComparableTimeMark comparableTimeMark, long j) {
            return comparableTimeMark.mo19827plusLRDsOJo(Duration.m19880unaryMinusUwyO8pc(j));
        }
    }

    @Override // java.lang.Comparable
    int compareTo(ComparableTimeMark other);

    /* renamed from: equals */
    boolean mo6862equals(Object other);

    int hashCode();

    @Override // p094kotlin.p119time.TimeMark
    /* renamed from: minus-LRDsOJo */
    ComparableTimeMark mo19825minusLRDsOJo(long duration);

    /* renamed from: minus-UwyO8pc */
    long mo19826minusUwyO8pc(ComparableTimeMark other);

    @Override // p094kotlin.p119time.TimeMark
    /* renamed from: plus-LRDsOJo */
    ComparableTimeMark mo19827plusLRDsOJo(long duration);
}
