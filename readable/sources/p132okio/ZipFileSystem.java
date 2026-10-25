package p132okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import org.conscrypt.BuildConfig;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.C5055Path;
import p132okio.internal.FixedLengthSource;
import p132okio.internal.ZipEntry;
import p132okio.internal.ZipFilesKt;

@Metadata(m4987d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J \u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m4988d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", BuildConfig.f24315FLAVOR, "Lokio/internal/ZipEntry;", "comment", BuildConfig.f24315FLAVOR, "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "canonicalize", "path", "canonicalizeInternal", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", BuildConfig.f24315FLAVOR, "mustExist", "list", BuildConfig.f24315FLAVOR, "dir", "listOrNull", "throwOnFailure", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", BuildConfig.f24315FLAVOR, "atomicMove", "target", "delete", "createSymlink", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nZipFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,142:1\n58#2,4:143\n58#2,22:147\n66#2,10:169\n62#2,3:179\n77#2,3:182\n58#2,22:185\n*S KotlinDebug\n*F\n+ 1 ZipFileSystem.kt\nokio/ZipFileSystem\n*L\n55#1:143,4\n56#1:147,22\n55#1:169,10\n55#1:179,3\n55#1:182,3\n99#1:185,22\n*E\n"})
/* loaded from: classes.dex */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);

    /* renamed from: ROOT */
    private static final C5055Path f17855ROOT = C5055Path.Companion.get$default(C5055Path.INSTANCE, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<C5055Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final C5055Path zipPath;

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m4988d2 = {"Lokio/ZipFileSystem$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getROOT */
        public final C5055Path m14398getROOT() {
            return ZipFileSystem.f17855ROOT;
        }

        private Companion() {
        }
    }

    public ZipFileSystem(C5055Path zipPath, FileSystem fileSystem, Map<C5055Path, ZipEntry> entries, String str) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final C5055Path canonicalizeInternal(C5055Path path) {
        return f17855ROOT.m14362resolve(path, true);
    }

    @Override // p132okio.FileSystem
    public InterfaceC5060Sink appendingSink(C5055Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // p132okio.FileSystem
    public void atomicMove(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // p132okio.FileSystem
    public C5055Path canonicalize(C5055Path path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(path, "path");
        C5055Path c5055PathCanonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(c5055PathCanonicalizeInternal)) {
            return c5055PathCanonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // p132okio.FileSystem
    public void createDirectory(C5055Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // p132okio.FileSystem
    public void createSymlink(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // p132okio.FileSystem
    /* renamed from: delete */
    public void mo14284delete(C5055Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // p132okio.FileSystem
    /* renamed from: list */
    public List<C5055Path> mo14286list(C5055Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<C5055Path> listM14397list = m14397list(dir, true);
        Intrinsics.checkNotNull(listM14397list);
        return listM14397list;
    }

    @Override // p132okio.FileSystem
    public List<C5055Path> listOrNull(C5055Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return m14397list(dir, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d A[Catch: all -> 0x004d, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x004d, blocks: (B:8:0x0027, B:33:0x005d, B:21:0x0049, B:9:0x0033, B:18:0x0044), top: B:59:0x0027, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006d  */
    @Override // p132okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileMetadata metadataOrNull(C5055Path path) throws Throwable {
        Throwable th;
        BufferedSource bufferedSourceM14316buffer;
        Throwable th2;
        Intrinsics.checkNotNullParameter(path, "path");
        ZipEntry localHeader = this.entries.get(canonicalizeInternal(path));
        if (localHeader == null) {
            return null;
        }
        if (localHeader.getOffset() != -1) {
            FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            try {
                bufferedSourceM14316buffer = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(localHeader.getOffset()));
                try {
                    localHeader = ZipFilesKt.readLocalHeader(bufferedSourceM14316buffer, localHeader);
                } catch (Throwable th3) {
                    if (bufferedSourceM14316buffer != null) {
                        try {
                            bufferedSourceM14316buffer.close();
                        } catch (Throwable th4) {
                            ExceptionsKt.addSuppressed(th3, th4);
                        }
                    }
                    th2 = th3;
                    localHeader = null;
                }
            } catch (Throwable th5) {
                if (fileHandleOpenReadOnly != null) {
                    try {
                        fileHandleOpenReadOnly.close();
                    } catch (Throwable th6) {
                        ExceptionsKt.addSuppressed(th5, th6);
                    }
                }
                th = th5;
                localHeader = null;
            }
            if (bufferedSourceM14316buffer != null) {
                try {
                    bufferedSourceM14316buffer.close();
                    th2 = null;
                } catch (Throwable th7) {
                    th2 = th7;
                }
                if (th2 == null) {
                    throw th2;
                }
                if (fileHandleOpenReadOnly != null) {
                    try {
                        fileHandleOpenReadOnly.close();
                        th = null;
                    } catch (Throwable th8) {
                        th = th8;
                    }
                    if (th != null) {
                        throw th;
                    }
                } else {
                    th = null;
                    if (th != null) {
                    }
                }
            } else {
                th2 = null;
                if (th2 == null) {
                }
            }
        }
        return new FileMetadata(!localHeader.getIsDirectory(), localHeader.getIsDirectory(), null, localHeader.getIsDirectory() ? null : Long.valueOf(localHeader.getSize()), localHeader.getCreatedAtMillis$okio(), localHeader.getLastModifiedAtMillis$okio(), localHeader.getLastAccessedAtMillis$okio(), null, 128, null);
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadOnly(C5055Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadWrite(C5055Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // p132okio.FileSystem
    /* renamed from: sink */
    public InterfaceC5060Sink mo14288sink(C5055Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // p132okio.FileSystem
    /* renamed from: source */
    public InterfaceC5062Source mo14289source(C5055Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(file));
        if (zipEntry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        BufferedSource th = null;
        try {
            BufferedSource bufferedSourceM14316buffer = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(zipEntry.getOffset()));
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            th = th;
            th = bufferedSourceM14316buffer;
        } catch (Throwable th3) {
            th = th3;
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
        ZipFilesKt.skipLocalHeader(th);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(th, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(th, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }

    /* renamed from: list */
    private final List<C5055Path> m14397list(C5055Path dir, boolean throwOnFailure) throws IOException {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(dir));
        if (zipEntry != null) {
            return CollectionsKt.m5899toList(zipEntry.getChildren());
        }
        if (!throwOnFailure) {
            return null;
        }
        throw new IOException("not a directory: " + dir);
    }
}
