package p132okio.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p132okio.TypedOptions;

@Metadata(m4987d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m4988d2 = {"commonSelect", "T", BuildConfig.f24315FLAVOR, "Lokio/BufferedSource;", "options", "Lokio/TypedOptions;", "(Lokio/BufferedSource;Lokio/TypedOptions;)Ljava/lang/Object;", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-BufferedSource")
/* renamed from: okio.internal.-BufferedSource, reason: invalid class name */
/* loaded from: classes.dex */
public final class BufferedSource {
    public static final <T> T commonSelect(p132okio.BufferedSource bufferedSource, TypedOptions<T> options) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int iMo14220select = bufferedSource.mo14220select(options.getOptions());
        if (iMo14220select == -1) {
            return null;
        }
        return options.get(iMo14220select);
    }
}
