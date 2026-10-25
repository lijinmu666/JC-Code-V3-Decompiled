package p094kotlin.p101io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0087\u0080\u0004b\u0016\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\b\t\u0012\u0004\b\b(\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u001aR\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0087\u0080\u0004b\u0016\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\b\t\u0012\u0004\b\b(\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u001a\u0016\u0010\u0017\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001d\u001a.\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0087\u0080\bb\u0002\b$\u001a@\u0010%\u001a\u00020!*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u001a\b\u0002\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'H\u0087\u0080\bb\u0002\b$\u001a\u0012\u0010*\u001a\u00020!*\u00020\u0001H\u0087\u0080\bb\u0002\b$\u001a\u0016\u0010+\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010+\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0016\u0010-\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010-\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u000e\u0010.\u001a\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u0013\u0010.\u001a\u00020/*\u00020/H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000101*\b\u0012\u0004\u0012\u00020\u000101H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a\u0016\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0003H\u0086\u0080\u0004\"\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0019\u0010\u0013\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"\u0019\u0010\u0015\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u00065"}, m4988d2 = {"createTempDir", "Ljava/io/File;", "prefix", BuildConfig.f24315FLAVOR, "suffix", "directory", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "2.3", "Lkotlin/Deprecated;", "message", "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.", "createTempFile", "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.", "extension", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "toRelativeString", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "copyTo", "target", "overwrite", BuildConfig.f24315FLAVOR, "bufferSize", BuildConfig.f24315FLAVOR, "Lkotlin/IgnorableReturnValue;", "copyRecursively", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "deleteRecursively", "startsWith", "other", "endsWith", "normalize", "Lkotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", BuildConfig.f24315FLAVOR, "resolve", "relative", "resolveSibling", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/io/FilesKt")
@SourceDebugExtension(m6344value = {"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,478:1\n1#2:479\n1476#3,3:480\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n352#1:480,3\n*E\n"})
/* loaded from: classes.dex */
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    @IgnorableReturnValue
    public static final boolean copyRecursively(File file, File target, boolean z, final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!file.exists()) {
            return onError.mo2167invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            Iterator<File> it = FilesKt__FileTreeWalkKt.walkTopDown(file).m6186onFail(new Function2() { // from class: kotlin.io.AZxh
                @Override // p094kotlin.p105jvm.functions.Function2
                /* renamed from: invoke */
                public final Object mo2167invoke(Object obj, Object obj2) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$1$FilesKt__UtilsKt(onError, (File) obj, (IOException) obj2);
                }
            }).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.exists()) {
                    File file2 = new File(target, toRelativeString(next, file));
                    if (file2.exists() && (!next.isDirectory() || !file2.isDirectory())) {
                        if (z) {
                            if (file2.isDirectory()) {
                                if (!deleteRecursively(file2)) {
                                }
                            } else if (!file2.delete()) {
                            }
                        }
                        if (onError.mo2167invoke(file2, new FileAlreadyExistsException(next, file2, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (next.isDirectory()) {
                        file2.mkdirs();
                    } else if (copyTo$default(next, file2, z, 0, 4, null).length() != next.length() && onError.mo2167invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else if (onError.mo2167invoke(next, new NoSuchFileException(next, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.wA
                @Override // p094kotlin.p105jvm.functions.Function2
                /* renamed from: invoke */
                public final Object mo2167invoke(Object obj2, Object obj3) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$0$FilesKt__UtilsKt((File) obj2, (IOException) obj3);
                }
            };
        }
        return copyRecursively(file, file2, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnErrorAction copyRecursively$lambda$0$FilesKt__UtilsKt(File file, IOException exception) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit copyRecursively$lambda$1$FilesKt__UtilsKt(Function2 function2, File f, IOException e) throws TerminateException {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(e, "e");
        if (function2.mo2167invoke(f, e) != OnErrorAction.TERMINATE) {
            return C1133Unit.INSTANCE;
        }
        throw new TerminateException(f);
    }

    @IgnorableReturnValue
    /* renamed from: copyTo */
    public static final File m6200copyTo(File file, File target, boolean z, int i) throws FileSystemException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    ByteStreamsKt.m6154copyTo(fileInputStream, fileOutputStream, i);
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new FileSystemException(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return m6200copyTo(file, file2, z, i);
    }

    @Deprecated(m4972message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @DeprecatedSinceKotlin(errorSince = "2.3", warningSince = "1.4")
    public static final File createTempDir(String prefix, String str, File file) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        fileCreateTempFile.delete();
        if (fileCreateTempFile.mkdir()) {
            Intrinsics.checkNotNull(fileCreateTempFile);
            return fileCreateTempFile;
        }
        throw new IOException("Unable to create temporary directory " + fileCreateTempFile + '.');
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    @Deprecated(m4972message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @DeprecatedSinceKotlin(errorSince = "2.3", warningSince = "1.4")
    public static final File createTempFile(String prefix, String str, File file) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    @IgnorableReturnValue
    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (!file2.delete() && file2.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }

    public static final boolean endsWith(File file, File other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, other);
        }
        int iM6182getSize = components.m6182getSize() - components2.m6182getSize();
        if (iM6182getSize < 0) {
            return false;
        }
        return components.getSegments().subList(iM6182getSize, components.m6182getSize()).equals(components2.getSegments());
    }

    public static final String getExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringAfterLast(name, '.', BuildConfig.f24315FLAVOR);
    }

    public static final String getInvariantSeparatorsPath(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        char c = File.separatorChar;
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return c != '/' ? StringsKt.replace$default(path, c, '/', false, 4, (Object) null) : path;
    }

    public static final String getNameWithoutExtension(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final File normalize(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        File fileM6181getRoot = components.m6181getRoot();
        List<File> listNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return m6202resolve(fileM6181getRoot, CollectionsKt.joinToString$default(listNormalize$FilesKt__UtilsKt, separator, null, null, 0, null, null, 62, null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.m6181getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    public static final File relativeTo(File file, File base) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        return new File(toRelativeString(file, base));
    }

    public static final File relativeToOrNull(File file, File base) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    public static final File relativeToOrSelf(File file, File base) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    /* renamed from: resolve */
    public static final File m6201resolve(File file, File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String string = file.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!StringsKt.endsWith$default((CharSequence) string, c, false, 2, (Object) null)) {
                return new File(string + c + relative);
            }
        }
        return new File(string + relative);
    }

    public static final File resolveSibling(File file, File relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        return m6201resolve(m6201resolve(components.m6181getRoot(), components.m6182getSize() == 0 ? new File("..") : components.m6183subPath(0, components.m6182getSize() - 1)), relative);
    }

    public static final boolean startsWith(File file, File other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (Intrinsics.areEqual(components.m6181getRoot(), components2.m6181getRoot()) && components.m6182getSize() >= components2.m6182getSize()) {
            return components.getSegments().subList(0, components2.m6182getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final String toRelativeString(File file, File base) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.m6181getRoot(), filePathComponentsNormalize$FilesKt__UtilsKt2.m6181getRoot())) {
            return null;
        }
        int iM6182getSize = filePathComponentsNormalize$FilesKt__UtilsKt2.m6182getSize();
        int iM6182getSize2 = filePathComponentsNormalize$FilesKt__UtilsKt.m6182getSize();
        int iMin = Math.min(iM6182getSize2, iM6182getSize);
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments().get(i), filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = iM6182getSize - 1;
        if (i <= i2) {
            while (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < iM6182getSize2) {
            if (i < iM6182getSize) {
                sb.append(File.separatorChar);
            }
            List listDrop = CollectionsKt.m5843drop(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments(), i);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            CollectionsKt.joinTo$default(listDrop, sb, separator, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (Intrinsics.areEqual(name, ".")) {
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } else if (!Intrinsics.areEqual(name, "..")) {
                arrayList.add(file);
            } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) CollectionsKt.m5859last((List) arrayList)).getName(), "..")) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    /* renamed from: resolve */
    public static final File m6202resolve(File file, String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return m6201resolve(file, new File(relative));
    }

    public static final File resolveSibling(File file, String relative) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolveSibling(file, new File(relative));
    }

    public static final boolean startsWith(File file, String other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return startsWith(file, new File(other));
    }

    public static final boolean endsWith(File file, String other) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return endsWith(file, new File(other));
    }
}
