package p094kotlin.p101io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;
import p094kotlin.sequences.Sequence;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\t"}, m4988d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", BuildConfig.f24315FLAVOR, "reader", "Ljava/io/BufferedReader;", "<init>", "(Ljava/io/BufferedReader;)V", "iterator", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class LinesSequence implements Sequence<String> {
    private final BufferedReader reader;

    @Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0006\u001a\u00020\u0005H\u0096\u0082\u0004J\n\u0010\u0007\u001a\u00020\u0002H\u0096\u0082\u0004R\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\b"}, m4988d2 = {"kotlin/io/LinesSequence$iterator$1", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "nextValue", "done", BuildConfig.f24315FLAVOR, "hasNext", "next", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.io.LinesSequence$iterator$1 */
    public static final class C12161 implements Iterator<String>, KMappedMarker {
        private boolean done;
        private String nextValue;

        public C12161() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.nextValue == null && !this.done) {
                String line = LinesSequence.this.reader.readLine();
                this.nextValue = line;
                if (line == null) {
                    this.done = true;
                }
            }
            return this.nextValue != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextValue;
            this.nextValue = null;
            Intrinsics.checkNotNull(str);
            return str;
        }
    }

    public LinesSequence(BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
    }

    @Override // p094kotlin.sequences.Sequence
    public Iterator<String> iterator() {
        return new C12161();
    }
}
