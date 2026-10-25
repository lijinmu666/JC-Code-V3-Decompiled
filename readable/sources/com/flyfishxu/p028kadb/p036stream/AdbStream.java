package com.flyfishxu.p028kadb.p036stream;

import com.flyfishxu.p028kadb.p030core.AdbMessage;
import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import com.flyfishxu.p028kadb.p030core.AdbWriter;
import com.flyfishxu.p028kadb.p034queue.AdbMessageQueue;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p117text.C1302CharsKt;
import p132okio.BufferedSink;
import p132okio.BufferedSource;
import p132okio.C5052Buffer;
import p132okio.C5053Okio;
import p132okio.C5065Timeout;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;

@Metadata(m4987d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002BE\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, m4988d2 = {"Lcom/flyfishxu/kadb/stream/AdbStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "messageQueue", "Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "adbWriter", "Lcom/flyfishxu/kadb/core/AdbWriter;", "outboundMaxPayloadSize", BuildConfig.f24315FLAVOR, "localId", "remoteId", "delayedAckEnabled", BuildConfig.f24315FLAVOR, "initialAvailableSendBytes", BuildConfig.f24315FLAVOR, "<init>", "(Lcom/flyfishxu/kadb/queue/AdbMessageQueue;Lcom/flyfishxu/kadb/core/AdbWriter;IIIZJ)V", "isClosed", "source", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "getSink", "()Lokio/BufferedSink;", "awaitAckBytes", "decodeOkayAckBytes", "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "nextMessage", "command", "close", BuildConfig.f24315FLAVOR, "sendClose", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbStream.kt\ncom/flyfishxu/kadb/stream/AdbStream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n1#2:185\n*E\n"})
/* loaded from: classes.dex */
public final class AdbStream implements AutoCloseable {
    private final AdbWriter adbWriter;
    private final boolean delayedAckEnabled;
    private final long initialAvailableSendBytes;
    private boolean isClosed;
    private final int localId;
    private final AdbMessageQueue messageQueue;
    private final int outboundMaxPayloadSize;
    private final int remoteId;
    private final BufferedSink sink;
    private final BufferedSource source;

    public AdbStream(AdbMessageQueue messageQueue, AdbWriter adbWriter, int i, int i2, int i3, boolean z, long j) {
        Intrinsics.checkNotNullParameter(messageQueue, "messageQueue");
        Intrinsics.checkNotNullParameter(adbWriter, "adbWriter");
        this.messageQueue = messageQueue;
        this.adbWriter = adbWriter;
        this.outboundMaxPayloadSize = i;
        this.localId = i2;
        this.remoteId = i3;
        this.delayedAckEnabled = z;
        this.initialAvailableSendBytes = j;
        this.source = C5053Okio.m14316buffer(new InterfaceC5062Source() { // from class: com.flyfishxu.kadb.stream.AdbStream$source$1
            private int bytesRead;
            private AdbMessage message;

            /* renamed from: message */
            private final AdbMessage m2304message() {
                AdbMessage adbMessage = this.message;
                if (adbMessage != null) {
                    return adbMessage;
                }
                AdbMessage adbMessageNextMessage = this.f2127this$0.nextMessage(AdbProtocol.CMD_WRTE);
                this.message = adbMessageNextMessage;
                this.bytesRead = 0;
                return adbMessageNextMessage;
            }

            @Override // p132okio.InterfaceC5062Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // p132okio.InterfaceC5062Source
            /* renamed from: read */
            public long mo2305read(C5052Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AdbMessage adbMessageM2304message = m2304message();
                if (adbMessageM2304message == null) {
                    return -1L;
                }
                int iCoerceAtMost = RangesKt.coerceAtMost((int) RangesKt.coerceAtMost(byteCount, 2147483647L), adbMessageM2304message.getPayloadLength() - this.bytesRead);
                sink.mo14231write(adbMessageM2304message.getPayload(), this.bytesRead, iCoerceAtMost);
                this.bytesRead += iCoerceAtMost;
                if (this.f2127this$0.delayedAckEnabled && iCoerceAtMost > 0) {
                    this.f2127this$0.adbWriter.writeOkay(this.f2127this$0.localId, this.f2127this$0.remoteId, Integer.valueOf(iCoerceAtMost));
                }
                if (this.bytesRead > adbMessageM2304message.getPayloadLength()) {
                    throw new IllegalStateException("Check failed.");
                }
                if (this.bytesRead == adbMessageM2304message.getPayloadLength()) {
                    this.message = null;
                    if (!this.f2127this$0.delayedAckEnabled) {
                        AdbWriter.writeOkay$default(this.f2127this$0.adbWriter, this.f2127this$0.localId, this.f2127this$0.remoteId, null, 4, null);
                    }
                }
                return iCoerceAtMost;
            }

            @Override // p132okio.InterfaceC5062Source
            /* renamed from: timeout */
            public C5065Timeout getTimeout() {
                return C5065Timeout.f17852NONE;
            }
        });
        this.sink = C5053Okio.m14315buffer(new InterfaceC5060Sink() { // from class: com.flyfishxu.kadb.stream.AdbStream$sink$1
            private long availableSendBytes;
            private final ByteBuffer buffer;

            {
                this.buffer = ByteBuffer.allocate(this.f2125this$0.outboundMaxPayloadSize);
                this.availableSendBytes = this.f2125this$0.initialAvailableSendBytes;
            }

            private final int writeToBuffer(BufferedSource source, long byteCount) throws IOException {
                int iMin = Integer.min(this.buffer.remaining(), (int) RangesKt.coerceAtMost(byteCount, 2147483647L));
                byte[] bArrArray = this.buffer.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
                int iMo14215read = source.mo14215read(bArrArray, this.buffer.position(), iMin);
                if (iMo14215read < 0) {
                    throw new EOFException("EOF while writing ADB stream");
                }
                ByteBuffer byteBuffer = this.buffer;
                byteBuffer.position(byteBuffer.position() + iMo14215read);
                if (this.buffer.remaining() == 0) {
                    flush();
                }
                return iMo14215read;
            }

            @Override // p132okio.InterfaceC5060Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // p132okio.InterfaceC5060Sink, java.io.Flushable
            public void flush() throws IOException {
                int iPosition = this.buffer.position();
                if (iPosition == 0) {
                    return;
                }
                if (this.f2125this$0.delayedAckEnabled) {
                    while (true) {
                        long j2 = this.availableSendBytes;
                        if (j2 > 0) {
                            break;
                        } else {
                            this.availableSendBytes = j2 + this.f2125this$0.awaitAckBytes();
                        }
                    }
                }
                AdbWriter adbWriter2 = this.f2125this$0.adbWriter;
                int i4 = this.f2125this$0.localId;
                int i5 = this.f2125this$0.remoteId;
                byte[] bArrArray = this.buffer.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
                adbWriter2.writeWrite(i4, i5, bArrArray, 0, iPosition);
                if (this.f2125this$0.delayedAckEnabled) {
                    this.availableSendBytes -= iPosition;
                }
                this.buffer.clear();
                if (this.f2125this$0.delayedAckEnabled || this.f2125this$0.nextMessage(AdbProtocol.CMD_OKAY) != null) {
                    return;
                }
                String string = Integer.toString(this.f2125this$0.localId, C1302CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new IOException("ADB stream closed before OKAY for localId: " + string);
            }

            @Override // p132okio.InterfaceC5060Sink
            /* renamed from: timeout */
            public C5065Timeout getTimeout() {
                return C5065Timeout.f17852NONE;
            }

            @Override // p132okio.InterfaceC5060Sink
            /* renamed from: write */
            public void mo2303write(C5052Buffer source, long byteCount) {
                Intrinsics.checkNotNullParameter(source, "source");
                while (byteCount > 0) {
                    byteCount -= writeToBuffer(source, byteCount);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int awaitAckBytes() throws IOException {
        AdbMessage adbMessageNextMessage = nextMessage(AdbProtocol.CMD_OKAY);
        if (adbMessageNextMessage != null) {
            return decodeOkayAckBytes(adbMessageNextMessage);
        }
        String string = Integer.toString(this.localId, C1302CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        throw new IOException("ADB stream closed before delayed ACK for localId: " + string);
    }

    private final int decodeOkayAckBytes(AdbMessage message) throws IOException {
        if (message.getCommand() != 1497451343) {
            throw new IllegalArgumentException(("Expected OKAY message, got " + message.getCommand()).toString());
        }
        int payloadLength = message.getPayloadLength();
        if (payloadLength == 0) {
            if (!this.delayedAckEnabled) {
                return 0;
            }
            String string = Integer.toString(this.localId, C1302CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            throw new IOException("Delayed ACK stream missing OKAY payload for localId: " + string);
        }
        if (payloadLength != 4) {
            throw new IOException("Invalid OKAY payload size: " + message.getPayloadLength());
        }
        if (this.delayedAckEnabled) {
            return new C5052Buffer().mo14230write(message.getPayload()).readIntLe();
        }
        throw new IOException("Unexpected OKAY payload for non-delayed-ack stream: " + message.getPayloadLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdbMessage nextMessage(int command) {
        try {
            return this.messageQueue.m2284take(this.localId, command);
        } catch (IOException unused) {
            m2300close(false);
            return null;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        m2300close(true);
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    /* renamed from: close */
    private final void m2300close(boolean sendClose) {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        if (sendClose) {
            try {
                this.adbWriter.writeClose(this.localId, this.remoteId);
            } finally {
                this.messageQueue.stopListening(this.localId);
            }
        }
    }

    public /* synthetic */ AdbStream(AdbMessageQueue adbMessageQueue, AdbWriter adbWriter, int i, int i2, int i3, boolean z, long j, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(adbMessageQueue, adbWriter, i, i2, i3, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? 0L : j);
    }
}
