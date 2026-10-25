package p132okio;

import java.util.zip.Inflater;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m4988d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-InflaterSourceExtensions")
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes.dex */
public final class InflaterSourceExtensions {
    /* renamed from: inflate */
    public static final InflaterSource m14176inflate(InterfaceC5062Source interfaceC5062Source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource(interfaceC5062Source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(InterfaceC5062Source interfaceC5062Source, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter(interfaceC5062Source, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource(interfaceC5062Source, inflater);
    }
}
