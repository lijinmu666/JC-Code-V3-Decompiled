package p132okio;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmOverloads;
import p094kotlin.p105jvm.functions.Function1;

@Metadata(m4987d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt", "okio/Okio__ZlibOkioKt"}, m4989k = 4, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: okio.Okio */
/* loaded from: classes.dex */
public final class C5053Okio {
    public static final InterfaceC5060Sink appendingSink(File file) {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        return Okio__JvmOkioKt.asResourceFileSystem(classLoader);
    }

    @InterfaceC1231JvmName(m6260name = "blackhole")
    public static final InterfaceC5060Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    /* renamed from: buffer */
    public static final BufferedSink m14315buffer(InterfaceC5060Sink interfaceC5060Sink) {
        return Okio__OkioKt.m14339buffer(interfaceC5060Sink);
    }

    public static final CipherSink cipherSink(InterfaceC5060Sink interfaceC5060Sink, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink(interfaceC5060Sink, cipher);
    }

    public static final CipherSource cipherSource(InterfaceC5062Source interfaceC5062Source, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource(interfaceC5062Source, cipher);
    }

    public static final HashingSink hashingSink(InterfaceC5060Sink interfaceC5060Sink, MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSink(interfaceC5060Sink, messageDigest);
    }

    public static final HashingSource hashingSource(InterfaceC5062Source interfaceC5062Source, MessageDigest messageDigest) {
        return Okio__JvmOkioKt.hashingSource(interfaceC5062Source, messageDigest);
    }

    public static final InterfaceC5061Socket[] inMemorySocketPair(long j) {
        return Okio__JvmOkioKt.inMemorySocketPair(j);
    }

    /* renamed from: openZip */
    public static final FileSystem m14317openZip(FileSystem fileSystem, C5055Path c5055Path) {
        return Okio__ZlibOkioKt.m14342openZip(fileSystem, c5055Path);
    }

    @JvmOverloads
    /* renamed from: sink */
    public static final InterfaceC5060Sink m14318sink(File file) {
        return Okio__JvmOkioKt.m14329sink(file);
    }

    @InterfaceC1231JvmName(m6260name = "socket")
    /* renamed from: socket */
    public static final InterfaceC5061Socket m14323socket(Socket socket) {
        return Okio__JvmOkioKt.m14334socket(socket);
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14324source(File file) {
        return Okio__JvmOkioKt.m14335source(file);
    }

    /* renamed from: use */
    public static final <T extends Closeable, R> R m14328use(T t, Function1<? super T, ? extends R> function1) {
        return (R) Okio__OkioKt.m14341use(t, function1);
    }

    /* renamed from: buffer */
    public static final BufferedSource m14316buffer(InterfaceC5062Source interfaceC5062Source) {
        return Okio__OkioKt.m14340buffer(interfaceC5062Source);
    }

    public static final HashingSink hashingSink(InterfaceC5060Sink interfaceC5060Sink, Mac mac) {
        return Okio__JvmOkioKt.hashingSink(interfaceC5060Sink, mac);
    }

    public static final HashingSource hashingSource(InterfaceC5062Source interfaceC5062Source, Mac mac) {
        return Okio__JvmOkioKt.hashingSource(interfaceC5062Source, mac);
    }

    @JvmOverloads
    /* renamed from: sink */
    public static final InterfaceC5060Sink m14319sink(File file, boolean z) {
        return Okio__JvmOkioKt.m14330sink(file, z);
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14325source(InputStream inputStream) {
        return Okio__JvmOkioKt.m14336source(inputStream);
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14320sink(OutputStream outputStream) {
        return Okio__JvmOkioKt.m14331sink(outputStream);
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14326source(Socket socket) {
        return Okio__JvmOkioKt.m14337source(socket);
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14321sink(Socket socket) {
        return Okio__JvmOkioKt.m14332sink(socket);
    }

    /* renamed from: source */
    public static final InterfaceC5062Source m14327source(Path path, OpenOption... openOptionArr) {
        return Okio__JvmOkioKt.m14338source(path, openOptionArr);
    }

    /* renamed from: sink */
    public static final InterfaceC5060Sink m14322sink(Path path, OpenOption... openOptionArr) {
        return Okio__JvmOkioKt.m14333sink(path, openOptionArr);
    }
}
