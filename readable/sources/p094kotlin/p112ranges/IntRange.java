package p094kotlin.p112ranges;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;

@Metadata(m4987d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001#B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004J\n\u0010\u001c\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0082\u0004J\n\u0010 \u001a\u00020\u0003H\u0096\u0080\u0004J\n\u0010!\u001a\u00020\"H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006$"}, m4988d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(II)V", "getStart", "()Ljava/lang/Integer;", "getEndInclusive", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "Lkotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "contains", BuildConfig.f24315FLAVOR, "value", "isEmpty", "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", "toString", BuildConfig.f24315FLAVOR, "Companion", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class IntRange extends IntProgression implements ClosedRange<Integer>, OpenEndRange<Integer> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: EMPTY */
    private static final IntRange f5242EMPTY = new IntRange(1, 0);

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lkotlin/ranges/IntRange$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange getEMPTY() {
            return IntRange.f5242EMPTY;
        }

        private Companion() {
        }
    }

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    @Deprecated(m4972message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // p094kotlin.p112ranges.IntProgression
    /* renamed from: equals */
    public boolean mo6453equals(Object other) {
        if (other instanceof IntRange) {
            if (!mo6445isEmpty() || !((IntRange) other).mo6445isEmpty()) {
                IntRange intRange = (IntRange) other;
                if (getFirst() != intRange.getFirst() || getLast() != intRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p094kotlin.p112ranges.IntProgression
    public int hashCode() {
        if (mo6445isEmpty()) {
            return -1;
        }
        return getLast() + (getFirst() * 31);
    }

    @Override // p094kotlin.p112ranges.IntProgression, p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    /* renamed from: isEmpty */
    public boolean mo6445isEmpty() {
        return getFirst() > getLast();
    }

    @Override // p094kotlin.p112ranges.IntProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    public Integer getEndExclusive() {
        if (getLast() != Integer.MAX_VALUE) {
            return Integer.valueOf(getLast() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // p094kotlin.p112ranges.ClosedRange
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
