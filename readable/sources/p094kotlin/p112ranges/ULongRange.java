package p094kotlin.p112ranges;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.conscrypt.BuildConfig;
import p094kotlin.C1130ULong;
import p094kotlin.Deprecated;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;

@SinceKotlin(m5061version = "1.5")
@Metadata(m4987d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001&B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0082\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\n\u0010$\u001a\u00020%H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((¨\u0006'"}, m4988d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "Lkotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "contains", BuildConfig.f24315FLAVOR, "value", "contains-VKZWuLQ", "(J)Z", "isEmpty", "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "Companion", "kotlin-stdlib", "1.5"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<C1130ULong>, OpenEndRange<C1130ULong> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: EMPTY */
    private static final ULongRange f5265EMPTY = new ULongRange(-1, 0, null);

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lkotlin/ranges/ULongRange$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ULongRange getEMPTY() {
            return ULongRange.f5265EMPTY;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(m4972message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m19757getEndExclusivesVKNKU$annotations() {
    }

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return m19758containsVKZWuLQ(((C1130ULong) comparable).getData());
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m19758containsVKZWuLQ(long value) {
        return Long.compareUnsigned(getFirst(), value) <= 0 && Long.compareUnsigned(value, getLast()) <= 0;
    }

    @Override // p094kotlin.p112ranges.ULongProgression
    /* renamed from: equals */
    public boolean mo6518equals(Object other) {
        if (other instanceof ULongRange) {
            if (!mo6445isEmpty() || !((ULongRange) other).mo6445isEmpty()) {
                ULongRange uLongRange = (ULongRange) other;
                if (getFirst() != uLongRange.getFirst() || getLast() != uLongRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return C1130ULong.m18714boximpl(m19759getEndExclusivesVKNKU());
    }

    /* renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m19759getEndExclusivesVKNKU() {
        if (getLast() != -1) {
            return C1130ULong.m18720constructorimpl(getLast() + C1130ULong.m18720constructorimpl(1 & BodyPartID.bodyIdMax));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // p094kotlin.p112ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return C1130ULong.m18714boximpl(m19760getEndInclusivesVKNKU());
    }

    /* renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m19760getEndInclusivesVKNKU() {
        return getLast();
    }

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return C1130ULong.m18714boximpl(m19761getStartsVKNKU());
    }

    /* renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m19761getStartsVKNKU() {
        return getFirst();
    }

    @Override // p094kotlin.p112ranges.ULongProgression
    public int hashCode() {
        if (mo6445isEmpty()) {
            return -1;
        }
        return ((int) C1130ULong.m18720constructorimpl(getLast() ^ C1130ULong.m18720constructorimpl(getLast() >>> 32))) + (((int) C1130ULong.m18720constructorimpl(getFirst() ^ C1130ULong.m18720constructorimpl(getFirst() >>> 32))) * 31);
    }

    @Override // p094kotlin.p112ranges.ULongProgression, p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    /* renamed from: isEmpty */
    public boolean mo6445isEmpty() {
        return Long.compareUnsigned(getFirst(), getLast()) > 0;
    }

    @Override // p094kotlin.p112ranges.ULongProgression
    public String toString() {
        return ((Object) C1130ULong.m18766toStringimpl(getFirst())) + ".." + ((Object) C1130ULong.m18766toStringimpl(getLast()));
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }
}
