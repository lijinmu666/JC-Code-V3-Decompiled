package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"emptyArray", BuildConfig.f24315FLAVOR, "T", "()[Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ArrayIntrinsicsKt {
    public static final /* synthetic */ <T> T[] emptyArray() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }
}
