package p132okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.C5055Path;

@Metadata(m4987d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020!H\u0016J\f\u0010\"\u001a\u00020\u001b*\u00020\u0005H\u0002J\f\u0010#\u001a\u00020\u001b*\u00020\u0005H\u0002¨\u0006$"}, m4988d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "<init>", "()V", "canonicalize", "Lokio/Path;", "path", "metadataOrNull", "Lokio/FileMetadata;", "list", BuildConfig.f24315FLAVOR, "dir", "listOrNull", "throwOnFailure", BuildConfig.f24315FLAVOR, "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", BuildConfig.f24315FLAVOR, "atomicMove", "target", "delete", "createSymlink", "toString", BuildConfig.f24315FLAVOR, "requireExist", "requireCreate", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nJvmSystemFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,158:1\n11563#2,3:159\n*S KotlinDebug\n*F\n+ 1 JvmSystemFileSystem.kt\nokio/JvmSystemFileSystem\n*L\n77#1:159,3\n*E\n"})
/* loaded from: classes.dex */
public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(C5055Path c5055Path) throws IOException {
        if (m14285exists(c5055Path)) {
            throw new IOException(c5055Path + " already exists.");
        }
    }

    private final void requireExist(C5055Path c5055Path) throws IOException {
        if (m14285exists(c5055Path)) {
            return;
        }
        throw new IOException(c5055Path + " doesn't exist.");
    }

    @Override // p132okio.FileSystem
    public InterfaceC5060Sink appendingSink(C5055Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (mustExist) {
            requireExist(file);
        }
        return C5053Okio.m14319sink(file.m14363toFile(), true);
    }

    @Override // p132okio.FileSystem
    public void atomicMove(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        if (source.m14363toFile().renameTo(target.m14363toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // p132okio.FileSystem
    public C5055Path canonicalize(C5055Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        File canonicalFile = path.m14363toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        C5055Path.Companion companion = C5055Path.INSTANCE;
        Intrinsics.checkNotNull(canonicalFile);
        return C5055Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
    }

    @Override // p132okio.FileSystem
    public void createDirectory(C5055Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.m14363toFile().mkdir()) {
            return;
        }
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(dir);
        if (fileMetadataMetadataOrNull == null || !fileMetadataMetadataOrNull.getIsDirectory()) {
            throw new IOException("failed to create directory: " + dir);
        }
        if (mustCreate) {
            throw new IOException(dir + " already exists.");
        }
    }

    @Override // p132okio.FileSystem
    public void createSymlink(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("unsupported");
    }

    @Override // p132okio.FileSystem
    /* renamed from: delete */
    public void mo14284delete(C5055Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileM14363toFile = path.m14363toFile();
        if (fileM14363toFile.delete()) {
            return;
        }
        if (fileM14363toFile.exists()) {
            throw new IOException("failed to delete " + path);
        }
        if (mustExist) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    @Override // p132okio.FileSystem
    /* renamed from: list */
    public List<C5055Path> mo14286list(C5055Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<C5055Path> listM14312list = m14312list(dir, true);
        Intrinsics.checkNotNull(listM14312list);
        return listM14312list;
    }

    @Override // p132okio.FileSystem
    public List<C5055Path> listOrNull(C5055Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return m14312list(dir, false);
    }

    @Override // p132okio.FileSystem
    public FileMetadata metadataOrNull(C5055Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File fileM14363toFile = path.m14363toFile();
        boolean zIsFile = fileM14363toFile.isFile();
        boolean zIsDirectory = fileM14363toFile.isDirectory();
        long jLastModified = fileM14363toFile.lastModified();
        long length = fileM14363toFile.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !fileM14363toFile.exists()) {
            return null;
        }
        return new FileMetadata(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadOnly(C5055Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.m14363toFile(), "r"));
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadWrite(C5055Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (mustCreate && mustExist) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (mustCreate) {
            requireCreate(file);
        }
        if (mustExist) {
            requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.m14363toFile(), "rw"));
    }

    @Override // p132okio.FileSystem
    /* renamed from: sink */
    public InterfaceC5060Sink mo14288sink(C5055Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (mustCreate) {
            requireCreate(file);
        }
        return Okio__JvmOkioKt.sink$default(file.m14363toFile(), false, 1, null);
    }

    @Override // p132okio.FileSystem
    /* renamed from: source */
    public InterfaceC5062Source mo14289source(C5055Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return C5053Okio.m14324source(file.m14363toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    /* renamed from: list */
    private final List<C5055Path> m14312list(C5055Path dir, boolean throwOnFailure) throws IOException {
        File fileM14363toFile = dir.m14363toFile();
        String[] list = fileM14363toFile.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNull(str);
                arrayList.add(dir.m14357resolve(str));
            }
            CollectionsKt.m5815sort(arrayList);
            return arrayList;
        }
        if (!throwOnFailure) {
            return null;
        }
        if (fileM14363toFile.exists()) {
            throw new IOException("failed to list " + dir);
        }
        throw new FileNotFoundException("no such file: " + dir);
    }
}
