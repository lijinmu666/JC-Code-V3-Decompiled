package p094kotlin.p112ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1130ULong;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000b\u001a\u00020\fH\u0096\u0082\u0004J\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\r\u001a\u00020\u0002X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\nÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¨\u0006\u0010"}, m4988d2 = {"Lkotlin/ranges/ULongProgressionIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/ULong;", "first", "last", "step", BuildConfig.f24315FLAVOR, "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", BuildConfig.f24315FLAVOR, "next", "next-s-VKNKU", "()J", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class ULongProgressionIterator implements Iterator<C1130ULong>, KMappedMarker {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public /* synthetic */ ULongProgressionIterator(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ C1130ULong next() {
        return C1130ULong.m18714boximpl(m19756nextsVKNKU());
    }

    /* renamed from: next-s-VKNKU, reason: not valid java name */
    public long m19756nextsVKNKU() {
        long j = this.next;
        if (j != this.finalElement) {
            this.next = C1130ULong.m18720constructorimpl(this.step + j);
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return j;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private ULongProgressionIterator(long j, long j2, long j3) {
        this.finalElement = j2;
        boolean z = false;
        if (j3 <= 0 ? Long.compareUnsigned(j, j2) >= 0 : Long.compareUnsigned(j, j2) <= 0) {
            z = true;
        }
        this.hasNext = z;
        this.step = C1130ULong.m18720constructorimpl(j3);
        this.next = this.hasNext ? j : j2;
    }
}
