package p132okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.internal.Intrinsics;

@Deprecated(m4972message = "changed in Okio 2.x")
@Metadata(m4987d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001aJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007¨\u0006\u001c"}, m4988d2 = {"Lokio/-DeprecatedOkio;", BuildConfig.f24315FLAVOR, "<init>", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "path", "Ljava/nio/file/Path;", "options", BuildConfig.f24315FLAVOR, "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "socket", "Ljava/net/Socket;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "blackhole", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", m5048imports = {"okio.appendingSink"}))
    public final InterfaceC5060Sink appendingSink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return C5053Okio.appendingSink(file);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", m5048imports = {"okio.blackholeSink"}))
    public final InterfaceC5060Sink blackhole() {
        return C5053Okio.blackhole();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", m5048imports = {"okio.buffer"}))
    /* renamed from: buffer */
    public final BufferedSink m14159buffer(InterfaceC5060Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return C5053Okio.m14315buffer(sink);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", m5048imports = {"okio.sink"}))
    /* renamed from: sink */
    public final InterfaceC5060Sink m14161sink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", m5048imports = {"okio.source"}))
    /* renamed from: source */
    public final InterfaceC5062Source m14165source(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return C5053Okio.m14324source(file);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", m5048imports = {"okio.buffer"}))
    /* renamed from: buffer */
    public final BufferedSource m14160buffer(InterfaceC5062Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return C5053Okio.m14316buffer(source);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", m5048imports = {"okio.sink"}))
    /* renamed from: sink */
    public final InterfaceC5060Sink m14162sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return C5053Okio.m14320sink(outputStream);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", m5048imports = {"okio.source"}))
    /* renamed from: source */
    public final InterfaceC5062Source m14166source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return C5053Okio.m14325source(inputStream);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", m5048imports = {"okio.sink"}))
    /* renamed from: sink */
    public final InterfaceC5060Sink m14164sink(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return C5053Okio.m14322sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", m5048imports = {"okio.source"}))
    /* renamed from: source */
    public final InterfaceC5062Source m14168source(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return C5053Okio.m14327source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", m5048imports = {"okio.sink"}))
    /* renamed from: sink */
    public final InterfaceC5060Sink m14163sink(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return C5053Okio.m14321sink(socket);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", m5048imports = {"okio.source"}))
    /* renamed from: source */
    public final InterfaceC5062Source m14167source(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return C5053Okio.m14326source(socket);
    }
}
