package p132okio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.JvmOverloads;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.internal.C5070Path;

@Metadata(m4987d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0002\b J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u00060"}, m4988d2 = {"Lokio/Path;", BuildConfig.f24315FLAVOR, "bytes", "Lokio/ByteString;", "<init>", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "root", "getRoot", "()Lokio/Path;", "segments", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "isAbsolute", BuildConfig.f24315FLAVOR, "()Z", "isRelative", "volumeLetter", BuildConfig.f24315FLAVOR, "()Ljava/lang/Character;", "nameBytes", "name", "()Ljava/lang/String;", "parent", "isRoot", "div", "child", "resolve", "normalize", "relativeTo", "other", "normalized", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "compareTo", BuildConfig.f24315FLAVOR, "equals", BuildConfig.f24315FLAVOR, "hashCode", "toString", "Companion", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/Path\n+ 2 Path.kt\nokio/internal/-Path\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n39#2,3:133\n47#2,28:136\n53#2,22:168\n106#2:190\n111#2:191\n116#2,6:192\n133#2,5:198\n143#2:203\n148#2,25:204\n188#2:229\n193#2,11:230\n198#2,6:241\n193#2,11:247\n198#2,6:258\n222#2,41:264\n267#2:305\n281#2:306\n286#2:307\n291#2:308\n296#2:309\n1563#3:164\n1634#3,3:165\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/Path\n*L\n44#1:133,3\n47#1:136,28\n50#1:168,22\n53#1:190\n56#1:191\n60#1:192,6\n64#1:198,5\n68#1:203\n72#1:204,25\n75#1:229\n78#1:230,11\n81#1:241,6\n87#1:247,11\n90#1:258,6\n95#1:264,41\n97#1:305\n104#1:306\n106#1:307\n108#1:308\n110#1:309\n47#1:164\n47#1:165,3\n*E\n"})
/* renamed from: okio.Path */
/* loaded from: classes.dex */
public final class C5055Path implements Comparable<C5055Path> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    @Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lokio/Path$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "DIRECTORY_SEPARATOR", BuildConfig.f24315FLAVOR, "toPath", "Lokio/Path;", "normalize", BuildConfig.f24315FLAVOR, "get", "toOkioPath", "Ljava/io/File;", "Ljava/nio/file/Path;", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    /* renamed from: okio.Path$Companion, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ C5055Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.m14367get(str, z);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14364get(File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ C5055Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.m14365get(file, z);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14366get(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ C5055Path get$default(Companion companion, Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.m14369get(path, z);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14368get(Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14367get(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return C5070Path.commonToPath(str, z);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14365get(File file, boolean z) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String string = file.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return m14367get(string, z);
        }

        @JvmStatic
        @JvmOverloads
        @InterfaceC1231JvmName(m6260name = "get")
        /* renamed from: get */
        public final C5055Path m14369get(Path path, boolean z) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return m14367get(path.toString(), z);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public C5055Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14346get(File file) {
        return INSTANCE.m14364get(file);
    }

    public static /* synthetic */ C5055Path resolve$default(C5055Path c5055Path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c5055Path.m14358resolve(str, z);
    }

    /* renamed from: equals */
    public boolean m14352equals(Object other) {
        return (other instanceof C5055Path) && Intrinsics.areEqual(((C5055Path) other).getBytes(), getBytes());
    }

    /* renamed from: getBytes$okio, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    /* renamed from: getRoot */
    public final C5055Path m14353getRoot() {
        int iRootLength = C5070Path.rootLength(this);
        if (iRootLength == -1) {
            return null;
        }
        return new C5055Path(getBytes().substring(0, iRootLength));
    }

    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int iRootLength = C5070Path.rootLength(this);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < getBytes().m14252size() && getBytes().m14242getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int iM14252size = getBytes().m14252size();
        int i = iRootLength;
        while (iRootLength < iM14252size) {
            if (getBytes().m14242getByte(iRootLength) == 47 || getBytes().m14242getByte(iRootLength) == 92) {
                arrayList.add(getBytes().substring(i, iRootLength));
                i = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i < getBytes().m14252size()) {
            arrayList.add(getBytes().substring(i, getBytes().m14252size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).m14254utf8());
        }
        return arrayList2;
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iRootLength = C5070Path.rootLength(this);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < getBytes().m14252size() && getBytes().m14242getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int iM14252size = getBytes().m14252size();
        int i = iRootLength;
        while (iRootLength < iM14252size) {
            if (getBytes().m14242getByte(iRootLength) == 47 || getBytes().m14242getByte(iRootLength) == 92) {
                arrayList.add(getBytes().substring(i, iRootLength));
                i = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i < getBytes().m14252size()) {
            arrayList.add(getBytes().substring(i, getBytes().m14252size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final boolean isAbsolute() {
        return C5070Path.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return C5070Path.rootLength(this) == -1;
    }

    /* renamed from: isRoot */
    public final boolean m14354isRoot() {
        return C5070Path.rootLength(this) == getBytes().m14252size();
    }

    @InterfaceC1231JvmName(m6260name = "name")
    /* renamed from: name */
    public final String m14355name() {
        return nameBytes().m14254utf8();
    }

    @InterfaceC1231JvmName(m6260name = "nameBytes")
    public final ByteString nameBytes() {
        int indexOfLastSlash = C5070Path.getIndexOfLastSlash(this);
        return indexOfLastSlash != -1 ? ByteString.substring$default(getBytes(), indexOfLastSlash + 1, 0, 2, null) : (volumeLetter() == null || getBytes().m14252size() != 2) ? getBytes() : ByteString.f17785EMPTY;
    }

    public final C5055Path normalized() {
        return INSTANCE.m14367get(toString(), true);
    }

    @InterfaceC1231JvmName(m6260name = "parent")
    /* renamed from: parent */
    public final C5055Path m14356parent() {
        C5055Path c5055Path;
        if (Intrinsics.areEqual(getBytes(), C5070Path.f17875DOT) || Intrinsics.areEqual(getBytes(), C5070Path.f17877SLASH) || Intrinsics.areEqual(getBytes(), C5070Path.BACKSLASH) || C5070Path.lastSegmentIsDotDot(this)) {
            return null;
        }
        int indexOfLastSlash = C5070Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != 2 || volumeLetter() == null) {
            if (indexOfLastSlash == 1 && getBytes().startsWith(C5070Path.BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash != -1 || volumeLetter() == null) {
                if (indexOfLastSlash == -1) {
                    return new C5055Path(C5070Path.f17875DOT);
                }
                if (indexOfLastSlash != 0) {
                    return new C5055Path(ByteString.substring$default(getBytes(), 0, indexOfLastSlash, 1, null));
                }
                c5055Path = new C5055Path(ByteString.substring$default(getBytes(), 0, 1, 1, null));
            } else {
                if (getBytes().m14252size() == 2) {
                    return null;
                }
                c5055Path = new C5055Path(ByteString.substring$default(getBytes(), 0, 2, 1, null));
            }
        } else {
            if (getBytes().m14252size() == 3) {
                return null;
            }
            c5055Path = new C5055Path(ByteString.substring$default(getBytes(), 0, 3, 1, null));
        }
        return c5055Path;
    }

    public final C5055Path relativeTo(C5055Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(m14353getRoot(), other.m14353getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i == iMin && getBytes().m14252size() == other.getBytes().m14252size()) {
            return Companion.get$default(INSTANCE, ".", false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(C5070Path.f17876DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (Intrinsics.areEqual(other.getBytes(), C5070Path.f17875DOT)) {
            return this;
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        ByteString slash = C5070Path.getSlash(other);
        if (slash == null && (slash = C5070Path.getSlash(this)) == null) {
            slash = C5070Path.m14403toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i2 = i; i2 < size; i2++) {
            c5052Buffer.mo14227write(C5070Path.f17876DOT_DOT);
            c5052Buffer.mo14227write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i < size2) {
            c5052Buffer.mo14227write(segmentsBytes.get(i));
            c5052Buffer.mo14227write(slash);
            i++;
        }
        return C5070Path.m14401toPath(c5052Buffer, false);
    }

    @InterfaceC1231JvmName(m6260name = "resolve")
    /* renamed from: resolve */
    public final C5055Path m14361resolve(C5055Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, child, false);
    }

    /* renamed from: toFile */
    public final File m14363toFile() {
        return new File(toString());
    }

    public final Path toNioPath() {
        Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    public String toString() {
        return getBytes().m14254utf8();
    }

    @InterfaceC1231JvmName(m6260name = "volumeLetter")
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes(), C5070Path.f17877SLASH, 0, 2, (Object) null) != -1 || getBytes().m14252size() < 2 || getBytes().m14242getByte(1) != 58) {
            return null;
        }
        char cM14242getByte = (char) getBytes().m14242getByte(0);
        if (('a' > cM14242getByte || cM14242getByte >= '{') && ('A' > cM14242getByte || cM14242getByte >= '[')) {
            return null;
        }
        return Character.valueOf(cM14242getByte);
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14347get(File file, boolean z) {
        return INSTANCE.m14365get(file, z);
    }

    public static /* synthetic */ C5055Path resolve$default(C5055Path c5055Path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c5055Path.m14360resolve(byteString, z);
    }

    @Override // java.lang.Comparable
    public int compareTo(C5055Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes().compareTo(other.getBytes());
    }

    /* renamed from: resolve */
    public final C5055Path m14362resolve(C5055Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, child, normalize);
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14348get(String str) {
        return INSTANCE.m14366get(str);
    }

    public static /* synthetic */ C5055Path resolve$default(C5055Path c5055Path, C5055Path c5055Path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c5055Path.m14362resolve(c5055Path2, z);
    }

    @InterfaceC1231JvmName(m6260name = "resolve")
    /* renamed from: resolve */
    public final C5055Path m14357resolve(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, C5070Path.m14401toPath(new C5052Buffer().writeUtf8(child), false), false);
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14349get(String str, boolean z) {
        return INSTANCE.m14367get(str, z);
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14350get(Path path) {
        return INSTANCE.m14368get(path);
    }

    @InterfaceC1231JvmName(m6260name = "resolve")
    /* renamed from: resolve */
    public final C5055Path m14359resolve(ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, C5070Path.m14401toPath(new C5052Buffer().mo14227write(child), false), false);
    }

    @JvmStatic
    @JvmOverloads
    @InterfaceC1231JvmName(m6260name = "get")
    /* renamed from: get */
    public static final C5055Path m14351get(Path path, boolean z) {
        return INSTANCE.m14369get(path, z);
    }

    /* renamed from: resolve */
    public final C5055Path m14358resolve(String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, C5070Path.m14401toPath(new C5052Buffer().writeUtf8(child), false), normalize);
    }

    /* renamed from: resolve */
    public final C5055Path m14360resolve(ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return C5070Path.commonResolve(this, C5070Path.m14401toPath(new C5052Buffer().mo14227write(child), false), normalize);
    }
}
