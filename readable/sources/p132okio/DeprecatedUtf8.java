package p132okio;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.p105jvm.internal.Intrinsics;

@Deprecated(m4972message = "changed in Okio 2.x")
@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, m4988d2 = {"Lokio/-DeprecatedUtf8;", BuildConfig.f24315FLAVOR, "<init>", "()V", "size", BuildConfig.f24315FLAVOR, "string", BuildConfig.f24315FLAVOR, "beginIndex", BuildConfig.f24315FLAVOR, "endIndex", "okio"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: classes.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", m5048imports = {"okio.utf8Size"}))
    /* renamed from: size */
    public final long m14171size(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return C5066Utf8.size$default(string, 0, 0, 3, null);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", m5048imports = {"okio.utf8Size"}))
    /* renamed from: size */
    public final long m14172size(String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(string, "string");
        return C5066Utf8.m14396size(string, beginIndex, endIndex);
    }
}
