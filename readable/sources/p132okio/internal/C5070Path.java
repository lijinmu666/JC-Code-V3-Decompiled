package p132okio.internal;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.ByteString;
import p132okio.C5052Buffer;
import p132okio.C5055Path;

@Metadata(m4987d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\u001a\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001a\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0080\b\u001a\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u0007H\u0080\b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0007H\u0002\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\n*\u00020\u0007H\u0080\b\u001a\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001a\f\u0010\u001a\u001a\u00020\u000f*\u00020\u0007H\u0002\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001c\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\u0015\u0010 \u001a\u00020\u0007*\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0007*\u00020\u0007H\u0080\b\u001a\u0015\u0010&\u001a\u00020\r*\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010'\u001a\u00020\u000f*\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010(H\u0080\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0007H\u0080\b\u001a\r\u0010*\u001a\u00020\n*\u00020\u0007H\u0080\b\u001a\u0014\u0010+\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\u0014\u0010,\u001a\u00020\u0007*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\f\u0010-\u001a\u00020\u0001*\u00020\nH\u0002\u001a\f\u0010-\u001a\u00020\u0001*\u00020.H\u0002\u001a\u0014\u0010/\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010#\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\r*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001a\u0010#\u001a\u0004\u0018\u00010\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00060"}, m4988d2 = {"SLASH", "Lokio/ByteString;", "BACKSLASH", "ANY_SLASH", "DOT", "DOT_DOT", "commonRoot", "Lokio/Path;", "commonSegments", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "commonSegmentsBytes", "rootLength", BuildConfig.f24315FLAVOR, "commonIsAbsolute", BuildConfig.f24315FLAVOR, "commonIsRelative", "commonVolumeLetter", BuildConfig.f24315FLAVOR, "(Lokio/Path;)Ljava/lang/Character;", "indexOfLastSlash", "getIndexOfLastSlash", "(Lokio/Path;)I", "commonNameBytes", "commonName", "commonParent", "lastSegmentIsDotDot", "commonIsRoot", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRelativeTo", "other", "commonNormalized", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "commonEquals", BuildConfig.f24315FLAVOR, "commonHashCode", "commonToString", "commonToPath", "toPath", "toSlash", BuildConfig.f24315FLAVOR, "startsWithVolumeLetterAndColon", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-Path")
@SourceDebugExtension(m6344value = {"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nokio/internal/-Path\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,405:1\n53#1,22:406\n203#1:432\n203#1:433\n1563#2:428\n1634#2,3:429\n*S KotlinDebug\n*F\n+ 1 Path.kt\nokio/internal/-Path\n*L\n47#1:406,22\n193#1:432\n198#1:433\n47#1:428\n47#1:429,3\n*E\n"})
/* renamed from: okio.internal.-Path */
/* loaded from: classes.dex */
public final class C5070Path {
    private static final ByteString ANY_SLASH;
    private static final ByteString BACKSLASH;

    /* renamed from: DOT */
    private static final ByteString f17875DOT;

    /* renamed from: DOT_DOT */
    private static final ByteString f17876DOT_DOT;

    /* renamed from: SLASH */
    private static final ByteString f17877SLASH;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f17877SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        f17875DOT = companion.encodeUtf8(".");
        f17876DOT_DOT = companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(C5055Path c5055Path, C5055Path other) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return c5055Path.getBytes().compareTo(other.getBytes());
    }

    public static final boolean commonEquals(C5055Path c5055Path, Object obj) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return (obj instanceof C5055Path) && Intrinsics.areEqual(((C5055Path) obj).getBytes(), c5055Path.getBytes());
    }

    public static final int commonHashCode(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return c5055Path.getBytes().hashCode();
    }

    public static final boolean commonIsAbsolute(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return rootLength(c5055Path) != -1;
    }

    public static final boolean commonIsRelative(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return rootLength(c5055Path) == -1;
    }

    public static final boolean commonIsRoot(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return rootLength(c5055Path) == c5055Path.getBytes().m14252size();
    }

    public static final String commonName(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return c5055Path.nameBytes().m14254utf8();
    }

    public static final ByteString commonNameBytes(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(c5055Path);
        return indexOfLastSlash != -1 ? ByteString.substring$default(c5055Path.getBytes(), indexOfLastSlash + 1, 0, 2, null) : (c5055Path.volumeLetter() == null || c5055Path.getBytes().m14252size() != 2) ? c5055Path.getBytes() : ByteString.f17785EMPTY;
    }

    public static final C5055Path commonNormalized(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return C5055Path.INSTANCE.m14367get(c5055Path.toString(), true);
    }

    public static final C5055Path commonParent(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        if (Intrinsics.areEqual(c5055Path.getBytes(), f17875DOT) || Intrinsics.areEqual(c5055Path.getBytes(), f17877SLASH) || Intrinsics.areEqual(c5055Path.getBytes(), BACKSLASH) || lastSegmentIsDotDot(c5055Path)) {
            return null;
        }
        int indexOfLastSlash = getIndexOfLastSlash(c5055Path);
        if (indexOfLastSlash == 2 && c5055Path.volumeLetter() != null) {
            if (c5055Path.getBytes().m14252size() == 3) {
                return null;
            }
            return new C5055Path(ByteString.substring$default(c5055Path.getBytes(), 0, 3, 1, null));
        }
        if (indexOfLastSlash == 1 && c5055Path.getBytes().startsWith(BACKSLASH)) {
            return null;
        }
        if (indexOfLastSlash != -1 || c5055Path.volumeLetter() == null) {
            return indexOfLastSlash == -1 ? new C5055Path(f17875DOT) : indexOfLastSlash == 0 ? new C5055Path(ByteString.substring$default(c5055Path.getBytes(), 0, 1, 1, null)) : new C5055Path(ByteString.substring$default(c5055Path.getBytes(), 0, indexOfLastSlash, 1, null));
        }
        if (c5055Path.getBytes().m14252size() == 2) {
            return null;
        }
        return new C5055Path(ByteString.substring$default(c5055Path.getBytes(), 0, 2, 1, null));
    }

    public static final C5055Path commonRelativeTo(C5055Path c5055Path, C5055Path other) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(c5055Path.m14353getRoot(), other.m14353getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + c5055Path + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = c5055Path.getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i == iMin && c5055Path.getBytes().m14252size() == other.getBytes().m14252size()) {
            return C5055Path.Companion.get$default(C5055Path.INSTANCE, ".", false, 1, (Object) null);
        }
        if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(f17876DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + c5055Path + " and " + other).toString());
        }
        if (Intrinsics.areEqual(other.getBytes(), f17875DOT)) {
            return c5055Path;
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        ByteString slash = getSlash(other);
        if (slash == null && (slash = getSlash(c5055Path)) == null) {
            slash = m14403toSlash(C5055Path.DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i2 = i; i2 < size; i2++) {
            c5052Buffer.mo14227write(f17876DOT_DOT);
            c5052Buffer.mo14227write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i < size2) {
            c5052Buffer.mo14227write(segmentsBytes.get(i));
            c5052Buffer.mo14227write(slash);
            i++;
        }
        return m14401toPath(c5052Buffer, false);
    }

    public static final C5055Path commonResolve(C5055Path c5055Path, String child, boolean z) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(c5055Path, m14401toPath(new C5052Buffer().writeUtf8(child), false), z);
    }

    public static final C5055Path commonRoot(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        int iRootLength = rootLength(c5055Path);
        if (iRootLength == -1) {
            return null;
        }
        return new C5055Path(c5055Path.getBytes().substring(0, iRootLength));
    }

    public static final List<String> commonSegments(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        ArrayList arrayList = new ArrayList();
        int iRootLength = rootLength(c5055Path);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < c5055Path.getBytes().m14252size() && c5055Path.getBytes().m14242getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int iM14252size = c5055Path.getBytes().m14252size();
        int i = iRootLength;
        while (iRootLength < iM14252size) {
            if (c5055Path.getBytes().m14242getByte(iRootLength) == 47 || c5055Path.getBytes().m14242getByte(iRootLength) == 92) {
                arrayList.add(c5055Path.getBytes().substring(i, iRootLength));
                i = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i < c5055Path.getBytes().m14252size()) {
            arrayList.add(c5055Path.getBytes().substring(i, c5055Path.getBytes().m14252size()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).m14254utf8());
        }
        return arrayList2;
    }

    public static final List<ByteString> commonSegmentsBytes(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        ArrayList arrayList = new ArrayList();
        int iRootLength = rootLength(c5055Path);
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < c5055Path.getBytes().m14252size() && c5055Path.getBytes().m14242getByte(iRootLength) == 92) {
            iRootLength++;
        }
        int iM14252size = c5055Path.getBytes().m14252size();
        int i = iRootLength;
        while (iRootLength < iM14252size) {
            if (c5055Path.getBytes().m14242getByte(iRootLength) == 47 || c5055Path.getBytes().m14242getByte(iRootLength) == 92) {
                arrayList.add(c5055Path.getBytes().substring(i, iRootLength));
                i = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i < c5055Path.getBytes().m14252size()) {
            arrayList.add(c5055Path.getBytes().substring(i, c5055Path.getBytes().m14252size()));
        }
        return arrayList;
    }

    public static final C5055Path commonToPath(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return m14401toPath(new C5052Buffer().writeUtf8(str), z);
    }

    public static final String commonToString(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        return c5055Path.getBytes().m14254utf8();
    }

    public static final Character commonVolumeLetter(C5055Path c5055Path) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        if (ByteString.indexOf$default(c5055Path.getBytes(), f17877SLASH, 0, 2, (Object) null) != -1 || c5055Path.getBytes().m14252size() < 2 || c5055Path.getBytes().m14242getByte(1) != 58) {
            return null;
        }
        char cM14242getByte = (char) c5055Path.getBytes().m14242getByte(0);
        if (('a' > cM14242getByte || cM14242getByte >= '{') && ('A' > cM14242getByte || cM14242getByte >= '[')) {
            return null;
        }
        return Character.valueOf(cM14242getByte);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getIndexOfLastSlash(C5055Path c5055Path) {
        int iLastIndexOf$default = ByteString.lastIndexOf$default(c5055Path.getBytes(), f17877SLASH, 0, 2, (Object) null);
        return iLastIndexOf$default != -1 ? iLastIndexOf$default : ByteString.lastIndexOf$default(c5055Path.getBytes(), BACKSLASH, 0, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString getSlash(C5055Path c5055Path) {
        ByteString bytes = c5055Path.getBytes();
        ByteString byteString = f17877SLASH;
        if (ByteString.indexOf$default(bytes, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes2 = c5055Path.getBytes();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(C5055Path c5055Path) {
        return c5055Path.getBytes().endsWith(f17876DOT_DOT) && (c5055Path.getBytes().m14252size() == 2 || c5055Path.getBytes().rangeEquals(c5055Path.getBytes().m14252size() + (-3), f17877SLASH, 0, 1) || c5055Path.getBytes().rangeEquals(c5055Path.getBytes().m14252size() + (-3), BACKSLASH, 0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rootLength(C5055Path c5055Path) {
        if (c5055Path.getBytes().m14252size() == 0) {
            return -1;
        }
        if (c5055Path.getBytes().m14242getByte(0) == 47) {
            return 1;
        }
        if (c5055Path.getBytes().m14242getByte(0) == 92) {
            if (c5055Path.getBytes().m14252size() <= 2 || c5055Path.getBytes().m14242getByte(1) != 92) {
                return 1;
            }
            int iM14245indexOf = c5055Path.getBytes().m14245indexOf(BACKSLASH, 2);
            return iM14245indexOf == -1 ? c5055Path.getBytes().m14252size() : iM14245indexOf;
        }
        if (c5055Path.getBytes().m14252size() > 2 && c5055Path.getBytes().m14242getByte(1) == 58 && c5055Path.getBytes().m14242getByte(2) == 92) {
            char cM14242getByte = (char) c5055Path.getBytes().m14242getByte(0);
            if ('a' <= cM14242getByte && cM14242getByte < '{') {
                return 3;
            }
            if ('A' <= cM14242getByte && cM14242getByte < '[') {
                return 3;
            }
        }
        return -1;
    }

    private static final boolean startsWithVolumeLetterAndColon(C5052Buffer c5052Buffer, ByteString byteString) {
        if (!Intrinsics.areEqual(byteString, BACKSLASH) || c5052Buffer.m14225size() < 2 || c5052Buffer.m14205getByte(1L) != 58) {
            return false;
        }
        char cM14205getByte = (char) c5052Buffer.m14205getByte(0L);
        return ('a' <= cM14205getByte && cM14205getByte < '{') || ('A' <= cM14205getByte && cM14205getByte < '[');
    }

    /* renamed from: toPath */
    public static final C5055Path m14401toPath(C5052Buffer c5052Buffer, boolean z) throws EOFException {
        ByteString byteString;
        ByteString byteString2;
        Intrinsics.checkNotNullParameter(c5052Buffer, "<this>");
        C5052Buffer c5052Buffer2 = new C5052Buffer();
        ByteString byteStringM14402toSlash = null;
        int i = 0;
        while (true) {
            if (!c5052Buffer.rangeEquals(0L, f17877SLASH)) {
                byteString = BACKSLASH;
                if (!c5052Buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte b = c5052Buffer.readByte();
            if (byteStringM14402toSlash == null) {
                byteStringM14402toSlash = m14402toSlash(b);
            }
            i++;
        }
        boolean z2 = i >= 2 && Intrinsics.areEqual(byteStringM14402toSlash, byteString);
        if (z2) {
            Intrinsics.checkNotNull(byteStringM14402toSlash);
            c5052Buffer2.mo14227write(byteStringM14402toSlash);
            c5052Buffer2.mo14227write(byteStringM14402toSlash);
        } else if (i > 0) {
            Intrinsics.checkNotNull(byteStringM14402toSlash);
            c5052Buffer2.mo14227write(byteStringM14402toSlash);
        } else {
            long jIndexOfElement = c5052Buffer.indexOfElement(ANY_SLASH);
            if (byteStringM14402toSlash == null) {
                byteStringM14402toSlash = jIndexOfElement == -1 ? m14403toSlash(C5055Path.DIRECTORY_SEPARATOR) : m14402toSlash(c5052Buffer.m14205getByte(jIndexOfElement));
            }
            if (startsWithVolumeLetterAndColon(c5052Buffer, byteStringM14402toSlash)) {
                if (jIndexOfElement == 2) {
                    c5052Buffer2.mo2303write(c5052Buffer, 3L);
                } else {
                    c5052Buffer2.mo2303write(c5052Buffer, 2L);
                }
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
        boolean z3 = c5052Buffer2.m14225size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!c5052Buffer.exhausted()) {
            long jIndexOfElement2 = c5052Buffer.indexOfElement(ANY_SLASH);
            if (jIndexOfElement2 == -1) {
                byteString2 = c5052Buffer.readByteString();
            } else {
                byteString2 = c5052Buffer.readByteString(jIndexOfElement2);
                c5052Buffer.readByte();
            }
            ByteString byteString3 = f17876DOT_DOT;
            if (Intrinsics.areEqual(byteString2, byteString3)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.m5859last((List) arrayList), byteString3)))) {
                        arrayList.add(byteString2);
                    } else if (!z2 || arrayList.size() != 1) {
                        CollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual(byteString2, f17875DOT) && !Intrinsics.areEqual(byteString2, ByteString.f17785EMPTY)) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                c5052Buffer2.mo14227write(byteStringM14402toSlash);
            }
            c5052Buffer2.mo14227write((ByteString) arrayList.get(i2));
        }
        if (c5052Buffer2.m14225size() == 0) {
            c5052Buffer2.mo14227write(f17875DOT);
        }
        return new C5055Path(c5052Buffer2.readByteString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toSlash */
    public static final ByteString m14403toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return f17877SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    public static final C5055Path commonResolve(C5055Path c5055Path, ByteString child, boolean z) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(c5055Path, m14401toPath(new C5052Buffer().mo14227write(child), false), z);
    }

    /* renamed from: toSlash */
    private static final ByteString m14402toSlash(byte b) {
        if (b == 47) {
            return f17877SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b));
    }

    public static final C5055Path commonResolve(C5055Path c5055Path, C5052Buffer child, boolean z) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(c5055Path, m14401toPath(child, false), z);
    }

    public static final C5055Path commonResolve(C5055Path c5055Path, C5055Path child, boolean z) {
        Intrinsics.checkNotNullParameter(c5055Path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(c5055Path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = m14403toSlash(C5055Path.DIRECTORY_SEPARATOR);
        }
        C5052Buffer c5052Buffer = new C5052Buffer();
        c5052Buffer.mo14227write(c5055Path.getBytes());
        if (c5052Buffer.m14225size() > 0) {
            c5052Buffer.mo14227write(slash);
        }
        c5052Buffer.mo14227write(child.getBytes());
        return m14401toPath(c5052Buffer, z);
    }
}
