package p132okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmOverloads;
import p094kotlin.p105jvm.internal.Intrinsics;
import p132okio.internal.DefaultSocket;
import p132okio.internal.PipeSocket;
import p132okio.internal.ResourceFileSystem;
import p132okio.internal.SocketAsyncTimeout;

@Metadata(m4987d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0006\u001a\u0011\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0002\b\t\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u000f\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000b\"\u00020\u0015¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0003\u001a\u00020\u0004*\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000b\"\u00020\u0015¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\"\u001a\u00020#*\u00020\u00042\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010$\u001a\u00020%\u001a\u0012\u0010\"\u001a\u00020#*\u00020\u00042\u0006\u0010$\u001a\u00020%\u001a\n\u0010&\u001a\u00020'*\u00020(¨\u0006)"}, m4988d2 = {"sink", "Lokio/Sink;", "Ljava/io/OutputStream;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "Ljava/net/Socket;", "asOkioSocket", "Lokio/Socket;", "socket", "inMemorySocketPair", BuildConfig.f24315FLAVOR, "maxBufferSize", BuildConfig.f24315FLAVOR, "(J)[Lokio/Socket;", "Ljava/io/File;", "append", BuildConfig.f24315FLAVOR, "appendingSink", "Ljava/nio/file/Path;", "options", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "hashingSink", "Lokio/HashingSink;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", CMSAttributeTableGenerator.f18937DIGEST, "Ljava/security/MessageDigest;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "okio"}, m4989k = 5, m4990mv = {2, 1, 0}, m4992xi = 48, m4993xs = "okio/Okio")
/* loaded from: classes.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    public static final InterfaceC5060Sink appendingSink(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return C5053Okio.m14320sink(new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true, null, 4, null);
    }

    public static final CipherSink cipherSink(InterfaceC5060Sink interfaceC5060Sink, Cipher cipher) {
        Intrinsics.checkNotNullParameter(interfaceC5060Sink, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSink(C5053Okio.m14315buffer(interfaceC5060Sink), cipher);
    }

    public static final CipherSource cipherSource(InterfaceC5062Source interfaceC5062Source, Cipher cipher) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSource(C5053Okio.m14316buffer(interfaceC5062Source), cipher);
    }

    public static final HashingSink hashingSink(InterfaceC5060Sink interfaceC5060Sink, Mac mac) {
        Intrinsics.checkNotNullParameter(interfaceC5060Sink, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSink(interfaceC5060Sink, mac);
    }

    public static final HashingSource hashingSource(InterfaceC5062Source interfaceC5062Source, Mac mac) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSource(interfaceC5062Source, mac);
    }

    public static final InterfaceC5061Socket[] inMemorySocketPair(long j) {
        C5056Pipe c5056Pipe = new C5056Pipe(j);
        C5056Pipe c5056Pipe2 = new C5056Pipe(j);
        return new InterfaceC5061Socket[]{new PipeSocket(c5056Pipe, c5056Pipe2), new PipeSocket(c5056Pipe2, c5056Pipe)};
    }

    @JvmOverloads
    /* renamed from: sink */
    public static final InterfaceC5060Sink m14329sink(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return sink$default(file, false, 1, null);
    }

    public static /* synthetic */ InterfaceC5060Sink sink$default(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return C5053Okio.m14319sink(file, z);
    }

    @InterfaceC1231JvmName(m6260name = "socket")
    /* renamed from: socket */
    public static final InterfaceC5061Socket m14334socket(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        return new DefaultSocket(socket);
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14336source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return new source(inputStream, new C5065Timeout());
    }

    public static final HashingSink hashingSink(InterfaceC5060Sink interfaceC5060Sink, MessageDigest digest) {
        Intrinsics.checkNotNullParameter(interfaceC5060Sink, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSink(interfaceC5060Sink, digest);
    }

    public static final HashingSource hashingSource(InterfaceC5062Source interfaceC5062Source, MessageDigest digest) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSource(interfaceC5062Source, digest);
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14331sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new sink(outputStream, new C5065Timeout());
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14337source(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        return socketAsyncTimeout.m14189source(new source(inputStream, socketAsyncTimeout));
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14332sink(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        return socketAsyncTimeout.m14188sink(new sink(outputStream, socketAsyncTimeout));
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14335source(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new source(new FileInputStream(file), C5065Timeout.f17852NONE);
    }

    @JvmOverloads
    /* renamed from: sink */
    public static final InterfaceC5060Sink m14330sink(File file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return C5053Okio.m14320sink(new FileOutputStream(file, z));
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14338source(Path path, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(inputStreamNewInputStream, "newInputStream(...)");
        return C5053Okio.m14325source(inputStreamNewInputStream);
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14333sink(Path path, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(...)");
        return C5053Okio.m14320sink(outputStreamNewOutputStream);
    }
}
