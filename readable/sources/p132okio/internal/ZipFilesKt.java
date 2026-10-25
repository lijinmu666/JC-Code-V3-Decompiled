package p132okio.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.TuplesKt;
import p094kotlin.collections.C1155MapsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.comparisons.ComparisonsKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.C1302CharsKt;
import p094kotlin.p117text.StringsKt;
import p132okio.BufferedSource;
import p132okio.C5053Okio;
import p132okio.C5055Path;
import p132okio.FileHandle;
import p132okio.FileSystem;
import p132okio.ZipFileSystem;
import p132okio.internal.ZipEntry;
import p132okio.internal.ZipFilesKt;

@Metadata(m4987d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0000\u001a\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0002\u001a\f\u0010\u001d\u001a\u00020\u0017*\u00020\u001eH\u0000\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u001eH\u0002\u001a\u0014\u0010!\u001a\u00020 *\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0002\u001a.\u0010#\u001a\u00020$*\u00020\u001e2\u0006\u0010%\u001a\u00020\u00012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0'H\u0002\u001a\f\u0010(\u001a\u00020$*\u00020\u001eH\u0000\u001a\u0014\u0010)\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0000\u001a\u0018\u0010+\u001a\u0004\u0018\u00010\u0017*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002\u001a\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0000\u001a\u001f\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0000¢\u0006\u0002\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u00102\u001a\u000203*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, m4988d2 = {"LOCAL_FILE_HEADER_SIGNATURE", BuildConfig.f24315FLAVOR, "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", BuildConfig.f24315FLAVOR, "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_EXTENDED_TIMESTAMP", "openZip", "Lokio/ZipFileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", BuildConfig.f24315FLAVOR, "buildIndex", BuildConfig.f24315FLAVOR, "entries", BuildConfig.f24315FLAVOR, "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readZip64EocdRecord", "regularRecord", "readExtra", BuildConfig.f24315FLAVOR, "extraSize", "block", "Lkotlin/Function2;", "skipLocalHeader", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "filetimeToEpochMillis", "filetime", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "hex", BuildConfig.f24315FLAVOR, "getHex", "(I)Ljava/lang/String;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,503:1\n58#2,4:504\n58#2,4:508\n58#2,22:512\n66#2,10:534\n62#2,3:544\n77#2,3:547\n58#2,22:550\n66#2,10:572\n62#2,3:582\n77#2,3:585\n1056#3:588\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n66#1:504,4\n101#1:508,4\n109#1:512,22\n101#1:534,10\n101#1:544,3\n101#1:547,3\n125#1:550,22\n66#1:572,10\n66#1:582,3\n66#1:585,3\n155#1:588\n*E\n"})
/* loaded from: classes.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<C5055Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        C5055Path c5055Path = C5055Path.Companion.get$default(C5055Path.INSTANCE, "/", false, 1, (Object) null);
        Map<C5055Path, ZipEntry> mapMutableMapOf = C1155MapsKt.mutableMapOf(TuplesKt.m5076to(c5055Path, new ZipEntry(c5055Path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        Iterator it = CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        }).iterator();
        while (it.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it.next();
            if (mapMutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    C5055Path c5055PathM14356parent = zipEntry.getCanonicalPath().m14356parent();
                    if (c5055PathM14356parent != null) {
                        ZipEntry zipEntry2 = mapMutableMapOf.get(c5055PathM14356parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(c5055PathM14356parent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                        mapMutableMapOf.put(c5055PathM14356parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                        it = it;
                    }
                }
            }
        }
        return mapMutableMapOf;
    }

    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / 10000) - 11644473600000L;
    }

    /* renamed from: getHex */
    private static final String m14412getHex(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String string = Integer.toString(i, C1302CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00de A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #12 {all -> 0x00df, blocks: (B:13:0x0062, B:15:0x006b, B:18:0x007c, B:43:0x00de, B:46:0x00e2, B:47:0x00e9, B:48:0x00ea), top: B:136:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010b A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:3:0x0019, B:5:0x0027, B:6:0x0030, B:10:0x004e, B:12:0x005a, B:65:0x010b, B:59:0x00ff, B:66:0x010c, B:92:0x016d, B:96:0x017e, B:90:0x0168, B:99:0x0181, B:102:0x018d, B:103:0x0194, B:104:0x0195, B:105:0x0198, B:106:0x0199, B:107:0x01b3, B:67:0x011d, B:70:0x0125, B:72:0x0135, B:74:0x0141, B:77:0x0148, B:78:0x014c, B:79:0x0153, B:80:0x0154, B:87:0x0161, B:56:0x00f8, B:7:0x0038, B:9:0x0041), top: B:115:0x0019, inners: #1, #2, #11, #13 }] */
    /* renamed from: openZip */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ZipFileSystem m14414openZip(C5055Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> predicate) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        int intLe;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle fileHandleOpenReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            long jM14272size = fileHandleOpenReadOnly.m14272size() - 22;
            if (jM14272size < 0) {
                throw new IOException("not a zip: size=" + fileHandleOpenReadOnly.m14272size());
            }
            long jMax = Math.max(jM14272size - 65536, 0L);
            do {
                BufferedSource bufferedSourceM14316buffer = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(jM14272size));
                try {
                    if (bufferedSourceM14316buffer.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord eocdRecord = readEocdRecord(bufferedSourceM14316buffer);
                        String utf8 = bufferedSourceM14316buffer.readUtf8(eocdRecord.getCommentByteCount());
                        bufferedSourceM14316buffer.close();
                        long j = jM14272size - 20;
                        Throwable th4 = null;
                        if (j > 0) {
                            BufferedSource bufferedSourceM14316buffer2 = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(j));
                            try {
                                if (bufferedSourceM14316buffer2.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                    int intLe2 = bufferedSourceM14316buffer2.readIntLe();
                                    long longLe = bufferedSourceM14316buffer2.readLongLe();
                                    if (bufferedSourceM14316buffer2.readIntLe() != 1 || intLe2 != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    BufferedSource bufferedSourceM14316buffer3 = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(longLe));
                                    try {
                                        intLe = bufferedSourceM14316buffer3.readIntLe();
                                    } catch (Throwable th5) {
                                        if (bufferedSourceM14316buffer3 != null) {
                                            try {
                                                bufferedSourceM14316buffer3.close();
                                                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                                            } catch (Throwable th6) {
                                                try {
                                                    ExceptionsKt.addSuppressed(th5, th6);
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    eocdRecord = eocdRecord;
                                                    if (bufferedSourceM14316buffer2 != null) {
                                                        try {
                                                            bufferedSourceM14316buffer2.close();
                                                            C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                                                        } catch (Throwable th8) {
                                                            ExceptionsKt.addSuppressed(th, th8);
                                                        }
                                                    }
                                                    th2 = th;
                                                    if (th2 != null) {
                                                    }
                                                }
                                            }
                                        }
                                        th3 = th5;
                                        eocdRecord = eocdRecord;
                                    }
                                    if (intLe != ZIP64_EOCD_RECORD_SIGNATURE) {
                                        throw new IOException("bad zip: expected " + m14412getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + m14412getHex(intLe));
                                    }
                                    eocdRecord = readZip64EocdRecord(bufferedSourceM14316buffer3, eocdRecord);
                                    C1133Unit c1133Unit3 = C1133Unit.INSTANCE;
                                    if (bufferedSourceM14316buffer3 != null) {
                                        try {
                                            bufferedSourceM14316buffer3.close();
                                            th3 = null;
                                        } catch (Throwable th9) {
                                            th3 = th9;
                                        }
                                        if (th3 != null) {
                                            throw th3;
                                        }
                                    } else {
                                        th3 = null;
                                        if (th3 != null) {
                                        }
                                    }
                                }
                                C1133Unit c1133Unit4 = C1133Unit.INSTANCE;
                            } catch (Throwable th10) {
                                th = th10;
                            }
                            if (bufferedSourceM14316buffer2 != null) {
                                try {
                                    bufferedSourceM14316buffer2.close();
                                    th2 = null;
                                } catch (Throwable th11) {
                                    th2 = th11;
                                }
                                if (th2 != null) {
                                    throw th2;
                                }
                            } else {
                                th2 = null;
                                if (th2 != null) {
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        BufferedSource bufferedSourceM14316buffer4 = C5053Okio.m14316buffer(fileHandleOpenReadOnly.m14273source(eocdRecord.getCentralDirectoryOffset()));
                        try {
                            long entryCount = eocdRecord.getEntryCount();
                            for (long j2 = 0; j2 < entryCount; j2++) {
                                ZipEntry centralDirectoryZipEntry = readCentralDirectoryZipEntry(bufferedSourceM14316buffer4);
                                if (centralDirectoryZipEntry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (predicate.mo2237invoke(centralDirectoryZipEntry).booleanValue()) {
                                    arrayList.add(centralDirectoryZipEntry);
                                }
                            }
                            C1133Unit c1133Unit5 = C1133Unit.INSTANCE;
                            if (bufferedSourceM14316buffer4 != null) {
                                try {
                                    bufferedSourceM14316buffer4.close();
                                } catch (Throwable th12) {
                                    th4 = th12;
                                }
                            }
                        } catch (Throwable th13) {
                            th4 = th13;
                            if (bufferedSourceM14316buffer4 != null) {
                                try {
                                    bufferedSourceM14316buffer4.close();
                                    C1133Unit c1133Unit6 = C1133Unit.INSTANCE;
                                } catch (Throwable th14) {
                                    ExceptionsKt.addSuppressed(th4, th14);
                                }
                            }
                        }
                        if (th4 != null) {
                            throw th4;
                        }
                        ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), utf8);
                        if (fileHandleOpenReadOnly != null) {
                            try {
                                fileHandleOpenReadOnly.close();
                                C1133Unit c1133Unit7 = C1133Unit.INSTANCE;
                            } catch (Throwable unused) {
                            }
                        }
                        return zipFileSystem;
                    }
                    bufferedSourceM14316buffer.close();
                    jM14272size--;
                } finally {
                    bufferedSourceM14316buffer.close();
                }
            } while (jM14272size >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } finally {
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(C5055Path c5055Path, FileSystem fileSystem, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: o.Eb
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj2) {
                    return Boolean.valueOf(ZipFilesKt.openZip$lambda$0((ZipEntry) obj2));
                }
            };
        }
        return m14414openZip(c5055Path, fileSystem, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean openZip$lambda$0(ZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ZipEntry readCentralDirectoryZipEntry(final BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int intLe = bufferedSource.readIntLe();
        if (intLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + m14412getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + m14412getHex(intLe));
        }
        bufferedSource.mo14226skip(4L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + m14412getHex(i));
        }
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        int shortLe3 = bufferedSource.readShortLe() & 65535;
        int shortLe4 = bufferedSource.readShortLe() & 65535;
        long intLe2 = bufferedSource.readIntLe() & 4294967295L;
        final C1235Ref.LongRef longRef = new C1235Ref.LongRef();
        longRef.f5201element = bufferedSource.readIntLe() & 4294967295L;
        final C1235Ref.LongRef longRef2 = new C1235Ref.LongRef();
        longRef2.f5201element = bufferedSource.readIntLe() & 4294967295L;
        int shortLe5 = bufferedSource.readShortLe() & 65535;
        int shortLe6 = bufferedSource.readShortLe() & 65535;
        int shortLe7 = bufferedSource.readShortLe() & 65535;
        bufferedSource.mo14226skip(8L);
        final C1235Ref.LongRef longRef3 = new C1235Ref.LongRef();
        longRef3.f5201element = bufferedSource.readIntLe() & 4294967295L;
        String utf8 = bufferedSource.readUtf8(shortLe5);
        if (StringsKt.contains$default((CharSequence) utf8, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j = longRef2.f5201element == 4294967295L ? 8 : 0L;
        if (longRef.f5201element == 4294967295L) {
            j += 8;
        }
        if (longRef3.f5201element == 4294967295L) {
            j += 8;
        }
        final long j2 = j;
        final C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
        final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
        final C1235Ref.ObjectRef objectRef3 = new C1235Ref.ObjectRef();
        final C1235Ref.BooleanRef booleanRef = new C1235Ref.BooleanRef();
        readExtra(bufferedSource, shortLe6, new Function2() { // from class: o.Hb
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1(booleanRef, j2, longRef2, bufferedSource, longRef, longRef3, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        if (j2 <= 0 || booleanRef.f5195element) {
            return new ZipEntry(C5055Path.Companion.get$default(C5055Path.INSTANCE, "/", false, 1, (Object) null).m14357resolve(utf8), StringsKt.endsWith$default(utf8, "/", false, 2, (Object) null), bufferedSource.readUtf8(shortLe7), intLe2, longRef.f5201element, longRef2.f5201element, shortLe2, longRef3.f5201element, shortLe4, shortLe3, (Long) objectRef.f5202element, (Long) objectRef2.f5202element, (Long) objectRef3.f5202element, null, null, null, 57344, null);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit readCentralDirectoryZipEntry$lambda$1(C1235Ref.BooleanRef booleanRef, long j, C1235Ref.LongRef longRef, final BufferedSource bufferedSource, C1235Ref.LongRef longRef2, C1235Ref.LongRef longRef3, final C1235Ref.ObjectRef objectRef, final C1235Ref.ObjectRef objectRef2, final C1235Ref.ObjectRef objectRef3, int i, long j2) throws IOException {
        if (i != 1) {
            if (i == 10) {
                if (j2 < 4) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                bufferedSource.mo14226skip(4L);
                readExtra(bufferedSource, (int) (j2 - 4), new Function2() { // from class: o.Fb
                    @Override // p094kotlin.p105jvm.functions.Function2
                    /* renamed from: invoke */
                    public final Object mo2167invoke(Object obj, Object obj2) {
                        return ZipFilesKt.readCentralDirectoryZipEntry$lambda$1$0(objectRef, bufferedSource, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                    }
                });
            }
        } else {
            if (booleanRef.f5195element) {
                throw new IOException("bad zip: zip64 extra repeated");
            }
            booleanRef.f5195element = true;
            if (j2 < j) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            long longLe = longRef.f5201element;
            if (longLe == 4294967295L) {
                longLe = bufferedSource.readLongLe();
            }
            longRef.f5201element = longLe;
            longRef2.f5201element = longRef2.f5201element == 4294967295L ? bufferedSource.readLongLe() : 0L;
            longRef3.f5201element = longRef3.f5201element == 4294967295L ? bufferedSource.readLongLe() : 0L;
        }
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Long] */
    public static final C1133Unit readCentralDirectoryZipEntry$lambda$1$0(C1235Ref.ObjectRef objectRef, BufferedSource bufferedSource, C1235Ref.ObjectRef objectRef2, C1235Ref.ObjectRef objectRef3, int i, long j) throws IOException {
        if (i == 1) {
            if (objectRef.f5202element != 0) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if (j != 24) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            objectRef.f5202element = Long.valueOf(bufferedSource.readLongLe());
            objectRef2.f5202element = Long.valueOf(bufferedSource.readLongLe());
            objectRef3.f5202element = Long.valueOf(bufferedSource.readLongLe());
        }
        return C1133Unit.INSTANCE;
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int shortLe = bufferedSource.readShortLe() & 65535;
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        long shortLe3 = bufferedSource.readShortLe() & 65535;
        if (shortLe3 != (bufferedSource.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.mo14226skip(4L);
        return new EocdRecord(shortLe3, 4294967295L & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, C1133Unit> function2) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = bufferedSource.readShortLe() & 65535;
            long shortLe2 = bufferedSource.readShortLe() & 65535;
            long j2 = j - 4;
            if (j2 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.mo14219require(shortLe2);
            long jM14225size = bufferedSource.getBuffer().m14225size();
            function2.mo2167invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long jM14225size2 = (bufferedSource.getBuffer().m14225size() + shortLe2) - jM14225size;
            if (jM14225size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + shortLe);
            }
            if (jM14225size2 > 0) {
                bufferedSource.getBuffer().mo14226skip(jM14225size2);
            }
            j = j2 - shortLe2;
        }
    }

    public static final ZipEntry readLocalHeader(BufferedSource bufferedSource, ZipEntry centralDirectoryZipEntry) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        ZipEntry orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, centralDirectoryZipEntry);
        Intrinsics.checkNotNull(orSkipLocalHeader);
        return orSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource bufferedSource, ZipEntry zipEntry) throws IOException {
        int intLe = bufferedSource.readIntLe();
        if (intLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + m14412getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + m14412getHex(intLe));
        }
        bufferedSource.mo14226skip(2L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + m14412getHex(i));
        }
        bufferedSource.mo14226skip(18L);
        int shortLe2 = bufferedSource.readShortLe() & 65535;
        bufferedSource.mo14226skip(bufferedSource.readShortLe() & 65535);
        if (zipEntry == null) {
            bufferedSource.mo14226skip(shortLe2);
            return null;
        }
        final C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
        final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
        final C1235Ref.ObjectRef objectRef3 = new C1235Ref.ObjectRef();
        readExtra(bufferedSource, shortLe2, new Function2() { // from class: o.Gb
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return ZipFilesKt.readOrSkipLocalHeader$lambda$0(bufferedSource, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
            }
        });
        return zipEntry.copy$okio((Integer) objectRef.f5202element, (Integer) objectRef2.f5202element, (Integer) objectRef3.f5202element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v6, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Integer] */
    public static final C1133Unit readOrSkipLocalHeader$lambda$0(BufferedSource bufferedSource, C1235Ref.ObjectRef objectRef, C1235Ref.ObjectRef objectRef2, C1235Ref.ObjectRef objectRef3, int i, long j) throws IOException {
        if (i == HEADER_ID_EXTENDED_TIMESTAMP) {
            if (j < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            byte b = bufferedSource.readByte();
            boolean z = (b & 1) == 1;
            boolean z2 = (b & 2) == 2;
            boolean z3 = (b & 4) == 4;
            long j2 = z ? 5L : 1L;
            if (z2) {
                j2 += 4;
            }
            if (z3) {
                j2 += 4;
            }
            if (j < j2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z) {
                objectRef.f5202element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z2) {
                objectRef2.f5202element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z3) {
                objectRef3.f5202element = Integer.valueOf(bufferedSource.readIntLe());
            }
        }
        return C1133Unit.INSTANCE;
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.mo14226skip(12L);
        int intLe = bufferedSource.readIntLe();
        int intLe2 = bufferedSource.readIntLe();
        long longLe = bufferedSource.readLongLe();
        if (longLe != bufferedSource.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.mo14226skip(8L);
        return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
