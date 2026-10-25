package p094kotlin.p112ranges;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1130ULong;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.UProgressionUtilKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB!\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0086\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004R\u0017\u0010\t\u001a\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bÊ\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¨\u0006\u001c"}, m4988d2 = {"Lkotlin/ranges/ULongProgression;", BuildConfig.f24315FLAVOR, "Lkotlin/ULong;", "start", "endInclusive", "step", BuildConfig.f24315FLAVOR, "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "iterator", BuildConfig.f24315FLAVOR, "isEmpty", BuildConfig.f24315FLAVOR, "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.5"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public class ULongProgression implements Iterable<C1130ULong>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long first;
    private final long last;
    private final long step;

    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m4988d2 = {"Lkotlin/ranges/ULongProgression$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", BuildConfig.f24315FLAVOR, "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m19755fromClosedRange7ftBX0g(long rangeStart, long rangeEnd, long step) {
            return new ULongProgression(rangeStart, rangeEnd, step, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    /* renamed from: equals */
    public boolean mo6518equals(Object other) {
        if (other instanceof ULongProgression) {
            if (!mo6445isEmpty() || !((ULongProgression) other).mo6445isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) other;
                if (this.first != uLongProgression.first || this.last != uLongProgression.last || this.step != uLongProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-s-VKNKU, reason: not valid java name and from getter */
    public final long getFirst() {
        return this.first;
    }

    /* renamed from: getLast-s-VKNKU, reason: not valid java name and from getter */
    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (mo6445isEmpty()) {
            return -1;
        }
        long j = this.first;
        int iM18720constructorimpl = ((int) C1130ULong.m18720constructorimpl(j ^ C1130ULong.m18720constructorimpl(j >>> 32))) * 31;
        long j2 = this.last;
        int iM18720constructorimpl2 = (iM18720constructorimpl + ((int) C1130ULong.m18720constructorimpl(j2 ^ C1130ULong.m18720constructorimpl(j2 >>> 32)))) * 31;
        long j3 = this.step;
        return ((int) ((j3 >>> 32) ^ j3)) + iM18720constructorimpl2;
    }

    /* renamed from: isEmpty */
    public boolean mo6445isEmpty() {
        long j = this.step;
        int iCompareUnsigned = Long.compareUnsigned(this.first, this.last);
        if (j > 0) {
            if (iCompareUnsigned <= 0) {
                return false;
            }
        } else if (iCompareUnsigned >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<C1130ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append((Object) C1130ULong.m18766toStringimpl(this.first));
            sb.append("..");
            sb.append((Object) C1130ULong.m18766toStringimpl(this.last));
            sb.append(" step ");
            j = this.step;
        } else {
            sb = new StringBuilder();
            sb.append((Object) C1130ULong.m18766toStringimpl(this.first));
            sb.append(" downTo ");
            sb.append((Object) C1130ULong.m18766toStringimpl(this.last));
            sb.append(" step ");
            j = -this.step;
        }
        sb.append(j);
        return sb.toString();
    }

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = j;
        this.last = UProgressionUtilKt.m19729getProgressionLastElement7ftBX0g(j, j2, j3);
        this.step = j3;
    }
}
