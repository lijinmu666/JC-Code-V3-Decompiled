package com.flyfishxu.p028kadb.transport;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import p132okio.C5052Buffer;
import p132okio.C5065Timeout;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m4988d2 = {"DEFAULT_CHUNK_SIZE", BuildConfig.f24315FLAVOR, "MAX_CHUNK_SIZE", "asOkioSource", "Lokio/Source;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "readTimeoutMs", BuildConfig.f24315FLAVOR, "asOkioSink", "Lokio/Sink;", "writeTimeoutMs", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class OkioAdaptersKt {
    private static final int DEFAULT_CHUNK_SIZE = 65536;
    private static final int MAX_CHUNK_SIZE = 262144;

    @Metadata(m4987d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m4988d2 = {"com/flyfishxu/kadb/transport/OkioAdaptersKt$asOkioSink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "scratch", "Ljava/nio/ByteBuffer;", "write", BuildConfig.f24315FLAVOR, "source", "Lokio/Buffer;", "byteCount", BuildConfig.f24315FLAVOR, "flush", "close", "ensureCapacity", "required", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nOkioAdapters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioAdapters.kt\ncom/flyfishxu/kadb/transport/OkioAdaptersKt$asOkioSink$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
    /* renamed from: com.flyfishxu.kadb.transport.OkioAdaptersKt$asOkioSink$1 */
    public static final class C02001 implements InterfaceC5060Sink {
        final /* synthetic */ TransportChannel $this_asOkioSink;
        final /* synthetic */ long $writeTimeoutMs;
        private ByteBuffer scratch;
        private final C5065Timeout timeout;

        public C02001(long j, TransportChannel transportChannel) {
            this.$writeTimeoutMs = j;
            this.$this_asOkioSink = transportChannel;
            C5065Timeout c5065Timeout = new C5065Timeout();
            if (j > 0) {
                c5065Timeout.mo14292timeout(j, TimeUnit.MILLISECONDS);
            }
            this.timeout = c5065Timeout;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65536);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            this.scratch = byteBufferAllocate;
        }

        private final void ensureCapacity(int required) {
            if (this.scratch.capacity() >= required) {
                return;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(required, 262144), this.scratch.capacity() * 2));
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            this.scratch = byteBufferAllocate;
        }

        @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
        public void flush() {
        }

        @Override // p132okio.InterfaceC5060Sink
        /* renamed from: timeout, reason: from getter */
        public C5065Timeout getTimeout() {
            return this.timeout;
        }

        @Override // p132okio.InterfaceC5060Sink
        /* renamed from: write */
        public void mo2303write(C5052Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            while (byteCount > 0) {
                int iCoerceAtMost = (int) RangesKt.coerceAtMost(byteCount, 262144L);
                ensureCapacity(iCoerceAtMost);
                byte[] bArrArray = this.scratch.array();
                int iArrayOffset = this.scratch.arrayOffset();
                Intrinsics.checkNotNull(bArrArray);
                int iMo14215read = source.mo14215read(bArrArray, iArrayOffset, iCoerceAtMost);
                if (iMo14215read <= 0) {
                    throw new IllegalArgumentException("Unexpected EOF while reading from buffer");
                }
                this.scratch.clear();
                this.scratch.put(bArrArray, iArrayOffset, iMo14215read);
                this.scratch.flip();
                BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new OkioAdaptersKt$asOkioSink$1$write$2(this.$this_asOkioSink, this, this.$writeTimeoutMs, null), 1, null);
                byteCount -= iMo14215read;
            }
        }
    }

    @Metadata(m4987d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m4988d2 = {"com/flyfishxu/kadb/transport/OkioAdaptersKt$asOkioSource$1", "Lokio/Source;", "timeout", "Lokio/Timeout;", "scratch", "Ljava/nio/ByteBuffer;", "read", BuildConfig.f24315FLAVOR, "sink", "Lokio/Buffer;", "byteCount", "close", BuildConfig.f24315FLAVOR, "ensureCapacity", "required", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: com.flyfishxu.kadb.transport.OkioAdaptersKt$asOkioSource$1 */
    public static final class C02011 implements InterfaceC5062Source {
        final /* synthetic */ long $readTimeoutMs;
        final /* synthetic */ TransportChannel $this_asOkioSource;
        private ByteBuffer scratch;
        private final C5065Timeout timeout;

        public C02011(long j, TransportChannel transportChannel) {
            this.$readTimeoutMs = j;
            this.$this_asOkioSource = transportChannel;
            C5065Timeout c5065Timeout = new C5065Timeout();
            if (j > 0) {
                c5065Timeout.mo14292timeout(j, TimeUnit.MILLISECONDS);
            }
            this.timeout = c5065Timeout;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65536);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            this.scratch = byteBufferAllocate;
        }

        private final void ensureCapacity(int required) {
            if (this.scratch.capacity() >= required) {
                return;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(required, 262144), this.scratch.capacity() * 2));
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            this.scratch = byteBufferAllocate;
        }

        @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // p132okio.InterfaceC5062Source
        /* renamed from: read */
        public long mo2305read(C5052Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount == 0) {
                return 0L;
            }
            int iCoerceAtMost = (int) RangesKt.coerceAtMost(byteCount, 262144L);
            ensureCapacity(iCoerceAtMost);
            this.scratch.clear();
            this.scratch.limit(iCoerceAtMost);
            int iIntValue = ((Number) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new OkioAdaptersKt$asOkioSource$1$read$read$1(this.$this_asOkioSource, this, this.$readTimeoutMs, null), 1, null)).intValue();
            if (iIntValue < 0) {
                return -1L;
            }
            this.scratch.flip();
            if (this.scratch.hasArray()) {
                byte[] bArrArray = this.scratch.array();
                int iArrayOffset = this.scratch.arrayOffset();
                Intrinsics.checkNotNull(bArrArray);
                sink.mo14231write(bArrArray, iArrayOffset, iIntValue);
            } else {
                byte[] bArr = new byte[iIntValue];
                this.scratch.get(bArr);
                sink.mo14230write(bArr);
            }
            return iIntValue;
        }

        @Override // p132okio.InterfaceC5062Source
        /* renamed from: timeout, reason: from getter */
        public C5065Timeout getTimeout() {
            return this.timeout;
        }
    }

    public static final InterfaceC5060Sink asOkioSink(TransportChannel transportChannel, long j) {
        Intrinsics.checkNotNullParameter(transportChannel, "<this>");
        return new C02001(j, transportChannel);
    }

    public static /* synthetic */ InterfaceC5060Sink asOkioSink$default(TransportChannel transportChannel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return asOkioSink(transportChannel, j);
    }

    public static final InterfaceC5062Source asOkioSource(TransportChannel transportChannel, long j) {
        Intrinsics.checkNotNullParameter(transportChannel, "<this>");
        return new C02011(j, transportChannel);
    }

    public static /* synthetic */ InterfaceC5062Source asOkioSource$default(TransportChannel transportChannel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return asOkioSource(transportChannel, j);
    }
}
