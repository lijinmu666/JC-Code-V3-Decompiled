package p132okio;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p132okio.FileSystem;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m4988d2 = {"SYSTEM", "Lokio/FileSystem;", "Lokio/FileSystem$Companion;", "getSYSTEM$annotations", "(Lokio/FileSystem$Companion;)V", "getSYSTEM", "(Lokio/FileSystem$Companion;)Lokio/FileSystem;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "SystemFileSystem")
/* loaded from: classes.dex */
public final class SystemFileSystem {
    public static final /* synthetic */ FileSystem getSYSTEM(FileSystem.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return FileSystem.f17804SYSTEM;
    }

    public static /* synthetic */ void getSYSTEM$annotations(FileSystem.Companion companion) {
    }
}
