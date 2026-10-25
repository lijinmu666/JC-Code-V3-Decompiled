package p094kotlin.p101io.p102path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.C1159SetsKt;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0080\u0004¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0080\u0004R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007R\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"Lkotlin/io/path/LinkFollowing;", BuildConfig.f24315FLAVOR, "<init>", "()V", "nofollowLinkOption", BuildConfig.f24315FLAVOR, "Ljava/nio/file/LinkOption;", "[Ljava/nio/file/LinkOption;", "followLinkOption", "nofollowVisitOption", BuildConfig.f24315FLAVOR, "Ljava/nio/file/FileVisitOption;", "followVisitOption", "toLinkOptions", "followLinks", BuildConfig.f24315FLAVOR, "(Z)[Ljava/nio/file/LinkOption;", "toVisitOptions", "kotlin-stdlib-jdk7"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class LinkFollowing {
    public static final LinkFollowing INSTANCE = new LinkFollowing();
    private static final LinkOption[] nofollowLinkOption = {LinkOption.NOFOLLOW_LINKS};
    private static final LinkOption[] followLinkOption = new LinkOption[0];
    private static final Set<FileVisitOption> nofollowVisitOption = C1159SetsKt.emptySet();
    private static final Set<FileVisitOption> followVisitOption = C1159SetsKt.m5992setOf(FileVisitOption.FOLLOW_LINKS);

    private LinkFollowing() {
    }

    public final LinkOption[] toLinkOptions(boolean followLinks) {
        return followLinks ? followLinkOption : nofollowLinkOption;
    }

    public final Set<FileVisitOption> toVisitOptions(boolean followLinks) {
        return followLinks ? followVisitOption : nofollowVisitOption;
    }
}
