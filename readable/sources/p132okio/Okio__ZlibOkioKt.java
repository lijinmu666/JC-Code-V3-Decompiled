package p132okio;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p132okio.internal.ZipFilesKt;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m4988d2 = {"openZip", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "okio"}, m4989k = 5, m4990mv = {2, 1, 0}, m4992xi = 48, m4993xs = "okio/Okio")
/* loaded from: classes.dex */
final /* synthetic */ class Okio__ZlibOkioKt {
    /* renamed from: openZip */
    public static final FileSystem m14342openZip(FileSystem fileSystem, C5055Path zipPath) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return ZipFilesKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }
}
