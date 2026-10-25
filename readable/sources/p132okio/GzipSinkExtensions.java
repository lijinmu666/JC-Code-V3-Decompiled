package p132okio;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m4988d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: classes.dex */
public final class GzipSinkExtensions {
    /* renamed from: gzip */
    public static final GzipSink m14173gzip(InterfaceC5060Sink interfaceC5060Sink) {
        Intrinsics.checkNotNullParameter(interfaceC5060Sink, "<this>");
        return new GzipSink(interfaceC5060Sink);
    }
}
