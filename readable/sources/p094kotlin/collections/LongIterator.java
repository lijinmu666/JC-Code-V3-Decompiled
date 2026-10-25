package p094kotlin.collections;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u00020\u0002H¦\u0080\u0004¨\u0006\b"}, m4988d2 = {"Lkotlin/collections/LongIterator;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "<init>", "()V", "next", "()Ljava/lang/Long;", "nextLong", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class LongIterator implements Iterator<Long>, KMappedMarker {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
