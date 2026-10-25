package p094kotlin.p112ranges;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004R\u000f\u0010\u0007\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001a"}, m4988d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", BuildConfig.f24315FLAVOR, "start", "endInclusive", "<init>", "(FF)V", "_start", "_endInclusive", "getStart", "()Ljava/lang/Float;", "getEndInclusive", "lessThanOrEquals", BuildConfig.f24315FLAVOR, "a", "b", "contains", "value", "isEmpty", "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    private final float _endInclusive;
    private final float _start;

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.p112ranges.ClosedFloatingPointRange, p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    /* renamed from: equals */
    public boolean m6448equals(Object other) {
        if (other instanceof ClosedFloatRange) {
            if (!mo6445isEmpty() || !((ClosedFloatRange) other).mo6445isEmpty()) {
                ClosedFloatRange closedFloatRange = (ClosedFloatRange) other;
                if (this._start != closedFloatRange._start || this._endInclusive != closedFloatRange._endInclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo6445isEmpty()) {
            return -1;
        }
        return Float.hashCode(this._endInclusive) + (Float.hashCode(this._start) * 31);
    }

    @Override // p094kotlin.p112ranges.ClosedFloatingPointRange, p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    /* renamed from: isEmpty */
    public boolean mo6445isEmpty() {
        return this._start > this._endInclusive;
    }

    public boolean lessThanOrEquals(float a, float b) {
        return a <= b;
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }

    public boolean contains(float value) {
        return value >= this._start && value <= this._endInclusive;
    }

    @Override // p094kotlin.p112ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override // p094kotlin.p112ranges.ClosedRange, p094kotlin.p112ranges.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.p112ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }
}
