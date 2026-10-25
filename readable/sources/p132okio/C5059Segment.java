package p132okio;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m4988d2 = {"Lokio/Segment;", BuildConfig.f24315FLAVOR, "<init>", "()V", "data", BuildConfig.f24315FLAVOR, "pos", BuildConfig.f24315FLAVOR, "limit", "shared", BuildConfig.f24315FLAVOR, "owner", "([BIIZZ)V", "next", "prev", "sharedCopy", "unsharedCopy", "pop", "push", "segment", "split", "byteCount", "compact", BuildConfig.f24315FLAVOR, "writeTo", "sink", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSegment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Segment.kt\nokio/Segment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* renamed from: okio.Segment */
/* loaded from: classes.dex */
public final class C5059Segment {
    public static final int SHARE_MINIMUM = 1024;

    /* renamed from: SIZE */
    public static final int f17840SIZE = 8192;

    @JvmField
    public final byte[] data;

    @JvmField
    public int limit;

    @JvmField
    public C5059Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @JvmField
    public C5059Segment prev;

    @JvmField
    public boolean shared;

    public C5059Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    /* renamed from: compact */
    public final void m14379compact() {
        int i;
        C5059Segment c5059Segment = this.prev;
        if (c5059Segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        Intrinsics.checkNotNull(c5059Segment);
        if (c5059Segment.owner) {
            int i2 = this.limit - this.pos;
            C5059Segment c5059Segment2 = this.prev;
            Intrinsics.checkNotNull(c5059Segment2);
            int i3 = 8192 - c5059Segment2.limit;
            C5059Segment c5059Segment3 = this.prev;
            Intrinsics.checkNotNull(c5059Segment3);
            if (c5059Segment3.shared) {
                i = 0;
            } else {
                C5059Segment c5059Segment4 = this.prev;
                Intrinsics.checkNotNull(c5059Segment4);
                i = c5059Segment4.pos;
            }
            if (i2 > i3 + i) {
                return;
            }
            C5059Segment c5059Segment5 = this.prev;
            Intrinsics.checkNotNull(c5059Segment5);
            m14383writeTo(c5059Segment5, i2);
            m14380pop();
            SegmentPool.m14384recycle(this);
        }
    }

    /* renamed from: pop */
    public final C5059Segment m14380pop() {
        C5059Segment c5059Segment = this.next;
        if (c5059Segment == this) {
            c5059Segment = null;
        }
        C5059Segment c5059Segment2 = this.prev;
        Intrinsics.checkNotNull(c5059Segment2);
        c5059Segment2.next = this.next;
        C5059Segment c5059Segment3 = this.next;
        Intrinsics.checkNotNull(c5059Segment3);
        c5059Segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return c5059Segment;
    }

    /* renamed from: push */
    public final C5059Segment m14381push(C5059Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        C5059Segment c5059Segment = this.next;
        Intrinsics.checkNotNull(c5059Segment);
        c5059Segment.prev = segment;
        this.next = segment;
        return segment;
    }

    public final C5059Segment sharedCopy() {
        this.shared = true;
        return new C5059Segment(this.data, this.pos, this.limit, true, false);
    }

    /* renamed from: split */
    public final C5059Segment m14382split(int byteCount) {
        C5059Segment c5059SegmentM14385take;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (byteCount >= 1024) {
            c5059SegmentM14385take = sharedCopy();
        } else {
            c5059SegmentM14385take = SegmentPool.m14385take();
            byte[] bArr = this.data;
            byte[] bArr2 = c5059SegmentM14385take.data;
            int i = this.pos;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i, i + byteCount, 2, (Object) null);
        }
        c5059SegmentM14385take.limit = c5059SegmentM14385take.pos + byteCount;
        this.pos += byteCount;
        C5059Segment c5059Segment = this.prev;
        Intrinsics.checkNotNull(c5059Segment);
        c5059Segment.m14381push(c5059SegmentM14385take);
        return c5059SegmentM14385take;
    }

    public final C5059Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return new C5059Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    /* renamed from: writeTo */
    public final void m14383writeTo(C5059Segment sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i = sink.limit;
        if (i + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i2 = sink.pos;
            if ((i + byteCount) - i2 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            ArraysKt.copyInto$default(bArr, bArr, 0, i2, i, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i3 = sink.limit;
        int i4 = this.pos;
        ArraysKt.copyInto(bArr2, bArr3, i3, i4, i4 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public C5059Segment(byte[] data, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
