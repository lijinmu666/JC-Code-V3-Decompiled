package p132okio;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0082\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0086\b\"\u000e\u0010\u0004\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m4988d2 = {"getBit", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "bit", "FHCRC", "FEXTRA", "FNAME", "FCOMMENT", "SECTION_HEADER", BuildConfig.f24315FLAVOR, "SECTION_BODY", "SECTION_TRAILER", "SECTION_DONE", "gzip", "Lokio/GzipSource;", "Lokio/Source;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* loaded from: classes.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;

    /* renamed from: FEXTRA */
    private static final int f17764FEXTRA = 2;

    /* renamed from: FHCRC */
    private static final int f17765FHCRC = 1;

    /* renamed from: FNAME */
    private static final int f17766FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    /* renamed from: getBit */
    private static final boolean m14174getBit(int i, int i2) {
        return ((i >> i2) & 1) == 1;
    }

    /* renamed from: gzip */
    public static final GzipSource m14175gzip(InterfaceC5062Source interfaceC5062Source) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        return new GzipSource(interfaceC5062Source);
    }
}
