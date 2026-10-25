package com.flyfishxu.p028kadb.p035shell;

import com.flyfishxu.p028kadb.p035shell.AdbShellPacket;
import com.flyfishxu.p028kadb.p036stream.AdbStream;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.Charsets;
import p094kotlin.p117text.StringsKt;
import p132okio.BufferedSink;
import p132okio.BufferedSource;

@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ*\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m4988d2 = {"Lcom/flyfishxu/kadb/shell/AdbShellStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "stream", "Lcom/flyfishxu/kadb/stream/AdbStream;", "<init>", "(Lcom/flyfishxu/kadb/stream/AdbStream;)V", "readAll", "Lcom/flyfishxu/kadb/shell/AdbShellResponse;", "read", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "write", BuildConfig.f24315FLAVOR, "string", BuildConfig.f24315FLAVOR, "input", BuildConfig.f24315FLAVOR, "closeStdin", "resize", "rows", BuildConfig.f24315FLAVOR, "cols", "xPixels", "yPixels", "id", "payload", "close", "checkId", "checkLength", "length", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbShellStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbShellStream.kt\ncom/flyfishxu/kadb/shell/AdbShellStream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
/* loaded from: classes.dex */
public final class AdbShellStream implements AutoCloseable {
    private final AdbStream stream;

    public AdbShellStream(AdbStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
    }

    /* renamed from: checkId */
    private final int m2293checkId(int id) {
        if (id == 1 || id == 2 || id == 3) {
            return id;
        }
        throw new IllegalStateException(("Invalid shell packet id: " + id).toString());
    }

    private final int checkLength(int id, int length) {
        if (length < 0) {
            throw new IllegalStateException(("Shell packet length must be >= 0: " + length).toString());
        }
        if (id != 3 || length == 1) {
            return length;
        }
        throw new IllegalStateException(("Shell exit packet does not have payload length == 1: " + length).toString());
    }

    public static /* synthetic */ void resize$default(AdbShellStream adbShellStream, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        adbShellStream.m2296resize(i, i2, i3, i4);
    }

    public static /* synthetic */ void write$default(AdbShellStream adbShellStream, int i, byte[] bArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bArr = null;
        }
        adbShellStream.m2297write(i, bArr);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    public final void closeStdin() {
        write$default(this, 4, null, 2, null);
    }

    /* renamed from: read */
    public final AdbShellPacket m2294read() {
        BufferedSource source = this.stream.getSource();
        int iM2293checkId = m2293checkId(source.readByte());
        byte[] byteArray = source.readByteArray(checkLength(iM2293checkId, source.readIntLe()));
        if (iM2293checkId == 1) {
            return new AdbShellPacket.C0198StdOut(byteArray);
        }
        if (iM2293checkId == 2) {
            return new AdbShellPacket.StdError(byteArray);
        }
        if (iM2293checkId == 3) {
            return new AdbShellPacket.C0197Exit(byteArray);
        }
        throw new IllegalArgumentException("Invalid shell packet id: " + iM2293checkId);
    }

    /* renamed from: readAll */
    public final AdbShellResponse m2295readAll() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            AdbShellPacket adbShellPacketM2294read = m2294read();
            if (adbShellPacketM2294read instanceof AdbShellPacket.C0197Exit) {
                int iM18564constructorimpl = C1126UByte.m18564constructorimpl(((AdbShellPacket.C0197Exit) adbShellPacketM2294read).getPayload()[0]) & C1126UByte.MAX_VALUE;
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String string2 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                return new AdbShellResponse(string, string2, iM18564constructorimpl);
            }
            if (adbShellPacketM2294read instanceof AdbShellPacket.C0198StdOut) {
                sb.append(new String(((AdbShellPacket.C0198StdOut) adbShellPacketM2294read).getPayload(), Charsets.UTF_8));
            } else {
                if (!(adbShellPacketM2294read instanceof AdbShellPacket.StdError)) {
                    throw new NoWhenBranchMatchedException();
                }
                sb2.append(new String(((AdbShellPacket.StdError) adbShellPacketM2294read).getPayload(), Charsets.UTF_8));
            }
        }
    }

    /* renamed from: resize */
    public final void m2296resize(int rows, int cols, int xPixels, int yPixels) {
        m2297write(5, StringsKt.encodeToByteArray(rows + "x" + cols + "," + xPixels + "x" + yPixels));
    }

    /* renamed from: write */
    public final void m2298write(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        m2299write(bytes);
    }

    /* renamed from: write */
    public final void m2299write(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        m2297write(0, input);
    }

    /* renamed from: write */
    public final void m2297write(int id, byte[] payload) {
        BufferedSink sink = this.stream.getSink();
        sink.writeByte(id);
        sink.writeIntLe(payload != null ? payload.length : 0);
        if (payload != null) {
            sink.mo14230write(payload);
        }
        sink.flush();
    }
}
