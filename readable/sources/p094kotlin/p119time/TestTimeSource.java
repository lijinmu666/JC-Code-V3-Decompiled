package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@SinceKotlin(m5061version = "1.9")
@Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0094\u0080\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012Ê\u0001\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\t0\u0015¨\u0006\u000f"}, m4988d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", BuildConfig.f24315FLAVOR, "read", "plusAssign", BuildConfig.f24315FLAVOR, "duration", "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension(m6344value = {"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,210:1\n80#2:211\n80#2:212\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n184#1:211\n191#1:212\n*E\n"})
/* loaded from: classes.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        mo6860markNow();
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m19949overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt__DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m19876toStringimpl(duration)) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m19950plusAssignLRDsOJo(long duration) {
        long jM19875toLongimpl = Duration.m19875toLongimpl(duration, getUnit());
        if (((jM19875toLongimpl - 1) | 1) != LongCompanionObject.MAX_VALUE) {
            long j = this.reading;
            long j2 = j + jM19875toLongimpl;
            if ((jM19875toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m19949overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM19839divUwyO8pc = Duration.m19839divUwyO8pc(duration, 2);
        if ((1 | (Duration.m19875toLongimpl(jM19839divUwyO8pc, getUnit()) - 1)) == LongCompanionObject.MAX_VALUE) {
            m19949overflowLRDsOJo(duration);
            return;
        }
        long j3 = this.reading;
        try {
            m19950plusAssignLRDsOJo(jM19839divUwyO8pc);
            m19950plusAssignLRDsOJo(Duration.m19864minusLRDsOJo(duration, jM19839divUwyO8pc));
        } catch (IllegalStateException e) {
            this.reading = j3;
            throw e;
        }
    }

    @Override // p094kotlin.p119time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }
}
