package p094kotlin.collections;

import java.util.Iterator;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\n\u0010\u0002\u001a\u00020\u0003H\u0096\u0082\u0004J\u000f\u0010\u0004\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"kotlin/collections/AbstractMap$values$1$iterator$1", BuildConfig.f24315FLAVOR, "hasNext", BuildConfig.f24315FLAVOR, "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AbstractMap$values$1$iterator$1<V> implements Iterator<V>, KMappedMarker {
    final /* synthetic */ Iterator<Map.Entry<K, V>> $entryIterator;

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMap$values$1$iterator$1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.$entryIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.$entryIterator.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.$entryIterator.next()).getValue();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
