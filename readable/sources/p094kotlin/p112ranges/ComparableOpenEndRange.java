package p094kotlin.p112ranges;

import java.lang.Comparable;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.OpenEndRange;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\bF\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004R\u0017\u0010\u0004\u001a\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, m4988d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "T", BuildConfig.f24315FLAVOR, "Lkotlin/ranges/OpenEndRange;", "start", "endExclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getStart", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getEndExclusive", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    private final T endExclusive;
    private final T start;

    public ComparableOpenEndRange(T start, T endExclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endExclusive, "endExclusive");
        this.start = start;
        this.endExclusive = endExclusive;
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    public /* bridge */ boolean contains(T t) {
        return OpenEndRange.DefaultImpls.contains(this, t);
    }

    /* renamed from: equals */
    public boolean m6451equals(Object other) {
        if (other instanceof ComparableOpenEndRange) {
            if (!mo6445isEmpty() || !((ComparableOpenEndRange) other).mo6445isEmpty()) {
                ComparableOpenEndRange comparableOpenEndRange = (ComparableOpenEndRange) other;
                if (!Intrinsics.areEqual(getStart(), comparableOpenEndRange.getStart()) || !Intrinsics.areEqual(getEndExclusive(), comparableOpenEndRange.getEndExclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    public T getEndExclusive() {
        return this.endExclusive;
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (mo6445isEmpty()) {
            return -1;
        }
        return getEndExclusive().hashCode() + (getStart().hashCode() * 31);
    }

    @Override // p094kotlin.p112ranges.OpenEndRange
    /* renamed from: isEmpty */
    public /* bridge */ boolean mo6445isEmpty() {
        return OpenEndRange.DefaultImpls.m6463isEmpty(this);
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
