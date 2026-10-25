package p132okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1120LazyKt;
import p094kotlin.C1122Pair;
import p094kotlin.InterfaceC1119Lazy;
import p094kotlin.Metadata;
import p094kotlin.TuplesKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.C5053Okio;
import p132okio.C5055Path;
import p132okio.FileHandle;
import p132okio.FileMetadata;
import p132okio.FileSystem;
import p132okio.InterfaceC5060Sink;
import p132okio.InterfaceC5062Source;
import p132okio.internal.ResourceFileSystem;
import p132okio.internal.ZipEntry;

@Metadata(m4987d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J \u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\u0018\u0010(\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\f\u0010*\u001a\u00020+*\u00020\fH\u0002J\u001e\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b0\n*\u00020\u0003H\u0002J\u001a\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020.H\u0002J\u001a\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00061"}, m4988d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", BuildConfig.f24315FLAVOR, "systemFileSystem", "<init>", "(Ljava/lang/ClassLoader;ZLokio/FileSystem;)V", "roots", BuildConfig.f24315FLAVOR, "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "canonicalize", "path", "canonicalizeInternal", "list", "dir", "listOrNull", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "metadataOrNull", "Lokio/FileMetadata;", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", BuildConfig.f24315FLAVOR, "atomicMove", "target", "delete", "createSymlink", "toRelativePath", BuildConfig.f24315FLAVOR, "toClasspathRoots", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nResourceFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,215:1\n774#2:216\n865#2,2:217\n1563#2:219\n1634#2,3:220\n774#2:223\n865#2,2:224\n1563#2:226\n1634#2,3:227\n1617#2,9:230\n1869#2:239\n1870#2:241\n1626#2:242\n1617#2,9:243\n1869#2:252\n1870#2:254\n1626#2:255\n1#3:240\n1#3:253\n*S KotlinDebug\n*F\n+ 1 ResourceFileSystem.kt\nokio/internal/ResourceFileSystem\n*L\n75#1:216\n75#1:217,2\n76#1:219\n76#1:220,3\n91#1:223\n91#1:224,2\n92#1:226\n92#1:227,3\n178#1:230,9\n178#1:239\n178#1:241\n178#1:242\n179#1:243,9\n179#1:252\n179#1:254\n179#1:255\n178#1:240\n179#1:253\n*E\n"})
/* loaded from: classes.dex */
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);

    /* renamed from: ROOT */
    private static final C5055Path f17886ROOT = C5055Path.Companion.get$default(C5055Path.INSTANCE, "/", false, 1, (Object) null);
    private final ClassLoader classLoader;

    /* renamed from: roots$delegate, reason: from kotlin metadata */
    private final InterfaceC1119Lazy roots;
    private final FileSystem systemFileSystem;

    @Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m4988d2 = {"Lokio/internal/ResourceFileSystem$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "removeBase", "base", "keepPath", BuildConfig.f24315FLAVOR, "path", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(C5055Path path) {
            return !StringsKt.endsWith(path.m14355name(), ".class", true);
        }

        /* renamed from: getROOT */
        public final C5055Path m14407getROOT() {
            return ResourceFileSystem.f17886ROOT;
        }

        public final C5055Path removeBase(C5055Path c5055Path, C5055Path base) {
            Intrinsics.checkNotNullParameter(c5055Path, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            return m14407getROOT().m14357resolve(StringsKt.replace$default(StringsKt.removePrefix(c5055Path.toString(), (CharSequence) base.toString()), '\\', '/', false, 4, (Object) null));
        }

        private Companion() {
        }
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem systemFileSystem) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots = C1120LazyKt.m4981lazy(new Function0() { // from class: o.r5
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return ResourceFileSystem.roots_delegate$lambda$0(this.f16287mjFkc);
            }
        });
        if (z) {
            getRoots().size();
        }
    }

    private final C5055Path canonicalizeInternal(C5055Path path) {
        return f17886ROOT.m14362resolve(path, true);
    }

    private final List<C1122Pair<FileSystem, C5055Path>> getRoots() {
        return (List) this.roots.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List roots_delegate$lambda$0(ResourceFileSystem resourceFileSystem) {
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }

    private final List<C1122Pair<FileSystem, C5055Path>> toClasspathRoots(ClassLoader classLoader) throws IOException {
        Enumeration<URL> resources = classLoader.getResources(BuildConfig.f24315FLAVOR);
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            Intrinsics.checkNotNull(url);
            C1122Pair<FileSystem, C5055Path> fileRoot = toFileRoot(url);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        Intrinsics.checkNotNullExpressionValue(list2, "list(...)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            Intrinsics.checkNotNull(url2);
            C1122Pair<FileSystem, C5055Path> jarRoot = toJarRoot(url2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return CollectionsKt.m5881plus((Collection) arrayList, (Iterable) arrayList2);
    }

    private final C1122Pair<FileSystem, C5055Path> toFileRoot(URL url) {
        if (Intrinsics.areEqual(url.getProtocol(), "file")) {
            return TuplesKt.m5076to(this.systemFileSystem, C5055Path.Companion.get$default(C5055Path.INSTANCE, new File(url.toURI()), false, 1, (Object) null));
        }
        return null;
    }

    private final C1122Pair<FileSystem, C5055Path> toJarRoot(URL url) {
        int iLastIndexOf$default;
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (!StringsKt.startsWith$default(string, "jar:file:", false, 2, (Object) null) || (iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) string, "!", 0, false, 6, (Object) null)) == -1) {
            return null;
        }
        C5055Path.Companion companion = C5055Path.INSTANCE;
        String strSubstring = string.substring(4, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return TuplesKt.m5076to(ZipFilesKt.m14414openZip(C5055Path.Companion.get$default(companion, new File(URI.create(strSubstring)), false, 1, (Object) null), this.systemFileSystem, new Function1() { // from class: o.q5
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(ResourceFileSystem.toJarRoot$lambda$0((ZipEntry) obj));
            }
        }), f17886ROOT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toJarRoot$lambda$0(ZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return Companion.keepPath(entry.getCanonicalPath());
    }

    private final String toRelativePath(C5055Path c5055Path) {
        return canonicalizeInternal(c5055Path).relativeTo(f17886ROOT).toString();
    }

    @Override // p132okio.FileSystem
    public InterfaceC5060Sink appendingSink(C5055Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    public void atomicMove(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    public C5055Path canonicalize(C5055Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // p132okio.FileSystem
    public void createDirectory(C5055Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    public void createSymlink(C5055Path source, C5055Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    /* renamed from: delete */
    public void mo14284delete(C5055Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    /* renamed from: list */
    public List<C5055Path> mo14286list(C5055Path dir) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (C1122Pair<FileSystem, C5055Path> c1122Pair : getRoots()) {
            FileSystem fileSystemComponent1 = c1122Pair.component1();
            C5055Path c5055PathComponent2 = c1122Pair.component2();
            try {
                List<C5055Path> listMo14286list = fileSystemComponent1.mo14286list(c5055PathComponent2.m14357resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listMo14286list) {
                    if (Companion.keepPath((C5055Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((C5055Path) it.next(), c5055PathComponent2));
                }
                CollectionsKt.m5818addAll(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.m5899toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // p132okio.FileSystem
    public List<C5055Path> listOrNull(C5055Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<C1122Pair<FileSystem, C5055Path>> it = getRoots().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            C1122Pair<FileSystem, C5055Path> next = it.next();
            FileSystem fileSystemComponent1 = next.component1();
            C5055Path c5055PathComponent2 = next.component2();
            List<C5055Path> listListOrNull = fileSystemComponent1.listOrNull(c5055PathComponent2.m14357resolve(relativePath));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (Companion.keepPath((C5055Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.removeBase((C5055Path) it2.next(), c5055PathComponent2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                CollectionsKt.m5818addAll(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return CollectionsKt.m5899toList(linkedHashSet);
        }
        return null;
    }

    @Override // p132okio.FileSystem
    public FileMetadata metadataOrNull(C5055Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (C1122Pair<FileSystem, C5055Path> c1122Pair : getRoots()) {
            FileMetadata fileMetadataMetadataOrNull = c1122Pair.component1().metadataOrNull(c1122Pair.component2().m14357resolve(relativePath));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadOnly(C5055Path file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String relativePath = toRelativePath(file);
        Iterator<C1122Pair<FileSystem, C5055Path>> it = getRoots().iterator();
        while (it.hasNext()) {
            C1122Pair<FileSystem, C5055Path> next = it.next();
            try {
                return next.component1().openReadOnly(next.component2().m14357resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // p132okio.FileSystem
    public FileHandle openReadWrite(C5055Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // p132okio.FileSystem
    /* renamed from: sink */
    public InterfaceC5060Sink mo14288sink(C5055Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // p132okio.FileSystem
    /* renamed from: source */
    public InterfaceC5062Source mo14289source(C5055Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        C5055Path c5055Path = f17886ROOT;
        URL resource = this.classLoader.getResource(C5055Path.resolve$default(c5055Path, file, false, 2, (Object) null).relativeTo(c5055Path).toString());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + file);
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        return C5053Okio.m14325source(inputStream);
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem fileSystem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classLoader, z, (i & 4) != 0 ? FileSystem.f17804SYSTEM : fileSystem);
    }
}
