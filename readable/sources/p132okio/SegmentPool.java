package p132okio;

import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\tH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\rH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, m4988d2 = {"Lokio/SegmentPool;", BuildConfig.f24315FLAVOR, "<init>", "()V", "MAX_SIZE", BuildConfig.f24315FLAVOR, "getMAX_SIZE", "()I", "LOCK", "Lokio/Segment;", "HASH_BUCKET_COUNT", "hashBuckets", BuildConfig.f24315FLAVOR, "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "byteCount", "getByteCount", "take", "recycle", BuildConfig.f24315FLAVOR, "segment", "firstRef", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    private static final AtomicReference<C5059Segment>[] hashBuckets;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = PKIFailureInfo.notAuthorized;
    private static final C5059Segment LOCK = new C5059Segment(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference<C5059Segment>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<C5059Segment> firstRef() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
    }

    @JvmStatic
    /* renamed from: recycle */
    public static final void m14384recycle(C5059Segment segment) {
        AtomicReference<C5059Segment> atomicReferenceFirstRef;
        C5059Segment c5059Segment;
        C5059Segment andSet;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared || (andSet = (atomicReferenceFirstRef = INSTANCE.firstRef()).getAndSet((c5059Segment = LOCK))) == c5059Segment) {
            return;
        }
        int i = andSet != null ? andSet.limit : 0;
        if (i >= MAX_SIZE) {
            atomicReferenceFirstRef.set(andSet);
            return;
        }
        segment.next = andSet;
        segment.pos = 0;
        segment.limit = i + 8192;
        atomicReferenceFirstRef.set(segment);
    }

    @JvmStatic
    /* renamed from: take */
    public static final C5059Segment m14385take() {
        AtomicReference<C5059Segment> atomicReferenceFirstRef = INSTANCE.firstRef();
        C5059Segment c5059Segment = LOCK;
        C5059Segment andSet = atomicReferenceFirstRef.getAndSet(c5059Segment);
        if (andSet == c5059Segment) {
            return new C5059Segment();
        }
        if (andSet == null) {
            atomicReferenceFirstRef.set(null);
            return new C5059Segment();
        }
        atomicReferenceFirstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getByteCount() {
        C5059Segment c5059Segment = firstRef().get();
        if (c5059Segment == null) {
            return 0;
        }
        return c5059Segment.limit;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
