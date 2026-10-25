package p094kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u000f\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\nH\u0082\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH¤\u0080\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001a\u00020\u000fH\u0084\u0080\u0004R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, m4988d2 = {"Lkotlin/collections/AbstractIterator;", "T", BuildConfig.f24315FLAVOR, "<init>", "()V", "state", BuildConfig.f24315FLAVOR, "nextValue", "Ljava/lang/Object;", "hasNext", BuildConfig.f24315FLAVOR, "next", "()Ljava/lang/Object;", "tryToComputeNext", "computeNext", BuildConfig.f24315FLAVOR, "setNext", "value", "(Ljava/lang/Object;)V", "done", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private T nextValue;
    private int state;

    private final boolean tryToComputeNext() {
        this.state = 3;
        computeNext();
        return this.state == 1;
    }

    public abstract void computeNext();

    /* renamed from: done */
    public final void m5112done() {
        this.state = 2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.state;
        if (i == 0) {
            return tryToComputeNext();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.state;
        if (i == 1) {
            this.state = 0;
            return this.nextValue;
        }
        if (i == 2 || !tryToComputeNext()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        return this.nextValue;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: setNext */
    public final void m5113setNext(T value) {
        this.nextValue = value;
        this.state = 1;
    }
}
