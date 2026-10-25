package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.p030core.AdbWriter;
import com.flyfishxu.p028kadb.p031debug.LoggingKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.Charsets;
import p132okio.BufferedSink;
import p132okio.C5053Okio;
import p132okio.InterfaceC5060Sink;

@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nJ \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nJ.\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nJ'\u0010 \u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\"J8\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nJ \u0010&\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m4988d2 = {"Lcom/flyfishxu/kadb/core/AdbWriter;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "sink", "Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "bufferedSink", "Lokio/BufferedSink;", "protocolVersion", BuildConfig.f24315FLAVOR, "updateProtocolVersion", BuildConfig.f24315FLAVOR, "peerVersion", "writeConnect", "payload", BuildConfig.f24315FLAVOR, "writeAuth", "authType", "authPayload", "writeStls", "version", "writeOpen", "localId", "destination", BuildConfig.f24315FLAVOR, "arg1", "writeWrite", "remoteId", "offset", "length", "writeClose", "writeOkay", "ackBytes", "(IILjava/lang/Integer;)V", "write", "command", "arg0", "payloadChecksum", "close", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbWriter implements AutoCloseable {
    private final BufferedSink bufferedSink;
    private volatile int protocolVersion;

    public AdbWriter(InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.bufferedSink = C5053Okio.m14315buffer(sink);
        this.protocolVersion = 16777216;
    }

    private final int payloadChecksum(byte[] payload, int offset, int length) {
        if (offset >= 0 && length >= 0 && offset + length <= payload.length) {
            int i = length + offset;
            int iM18564constructorimpl = 0;
            while (offset < i) {
                iM18564constructorimpl += C1126UByte.m18564constructorimpl(payload[offset]) & C1126UByte.MAX_VALUE;
                offset++;
            }
            return iM18564constructorimpl;
        }
        throw new IllegalArgumentException(("payloadChecksum out of bounds: offset=" + offset + " length=" + length + " size=" + payload.length).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String write$lambda$0(int i, int i2, int i3, int i4, byte[] bArr) {
        String name = Thread.currentThread().getName();
        if (bArr == null) {
            bArr = new byte[0];
        }
        return "(" + name + ") > " + new AdbMessage(i, i2, i3, i4, 0, 0, bArr);
    }

    public static /* synthetic */ void writeOkay$default(AdbWriter adbWriter, int i, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        adbWriter.writeOkay(i, i2, num);
    }

    public static /* synthetic */ void writeOpen$default(AdbWriter adbWriter, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        adbWriter.writeOpen(i, str, i2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.bufferedSink.close();
    }

    public final void updateProtocolVersion(int peerVersion) {
        this.protocolVersion = Math.min(peerVersion, 16777217);
    }

    /* renamed from: write */
    public final void m2213write(final int command, final int arg0, final int arg1, final byte[] payload, int offset, final int length) {
        LoggingKt.m2214log(new Function0() { // from class: o.xrEuO
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return AdbWriter.write$lambda$0(command, arg0, arg1, length, payload);
            }
        });
        synchronized (this.bufferedSink) {
            try {
                BufferedSink bufferedSink = this.bufferedSink;
                bufferedSink.writeIntLe(command);
                bufferedSink.writeIntLe(arg0);
                bufferedSink.writeIntLe(arg1);
                int iPayloadChecksum = 0;
                if (payload == null) {
                    bufferedSink.writeIntLe(0);
                    bufferedSink.writeIntLe(0);
                } else {
                    bufferedSink.writeIntLe(length);
                    if (this.protocolVersion < 16777217) {
                        iPayloadChecksum = payloadChecksum(payload, offset, length);
                    }
                    bufferedSink.writeIntLe(iPayloadChecksum);
                }
                bufferedSink.writeIntLe(~command);
                if (payload != null) {
                    bufferedSink.mo14231write(payload, offset, length);
                }
                bufferedSink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void writeAuth(int authType, byte[] authPayload) {
        Intrinsics.checkNotNullParameter(authPayload, "authPayload");
        m2213write(AdbProtocol.CMD_AUTH, authType, 0, authPayload, 0, authPayload.length);
    }

    public final void writeClose(int localId, int remoteId) {
        m2213write(AdbProtocol.CMD_CLSE, localId, remoteId, null, 0, 0);
    }

    public final void writeConnect(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        m2213write(AdbProtocol.CMD_CNXN, 16777217, 1048576, payload, 0, payload.length);
    }

    public final void writeOkay(int localId, int remoteId, Integer ackBytes) {
        byte[] bArrArray = ackBytes != null ? ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ackBytes.intValue()).array() : null;
        m2213write(AdbProtocol.CMD_OKAY, localId, remoteId, bArrArray, 0, bArrArray != null ? bArrArray.length : 0);
    }

    public final void writeOpen(int localId, String destination, int arg1) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        byte[] bytes = destination.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
        byteBufferAllocate.put(bytes);
        byteBufferAllocate.put((byte) 0);
        byte[] bArrArray = byteBufferAllocate.array();
        m2213write(AdbProtocol.CMD_OPEN, localId, arg1, bArrArray, 0, bArrArray.length);
    }

    public final void writeStls(int version) {
        m2213write(1397511251, version, 0, null, 0, 0);
    }

    public final void writeWrite(int localId, int remoteId, byte[] payload, int offset, int length) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        m2213write(AdbProtocol.CMD_WRTE, localId, remoteId, payload, offset, length);
    }
}
