package p094kotlin;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u0086\u0084\u0004¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0086\u0080\u0004\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\tH\u0086\u0080\u0004¨\u0006\n"}, m4988d2 = {"to", "Lkotlin/Pair;", "A", "B", "that", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "toList", BuildConfig.f24315FLAVOR, "T", "Lkotlin/Triple;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "TuplesKt")
/* loaded from: classes.dex */
public final class TuplesKt {
    /* renamed from: to */
    public static final <A, B> C1122Pair<A, B> m5076to(A a, B b) {
        return new C1122Pair<>(a, b);
    }

    /* renamed from: toList */
    public static final <T> List<T> m5077toList(C1122Pair<? extends T, ? extends T> c1122Pair) {
        Intrinsics.checkNotNullParameter(c1122Pair, "<this>");
        return CollectionsKt.m5806listOf(c1122Pair.getFirst(), c1122Pair.getSecond());
    }

    /* renamed from: toList */
    public static final <T> List<T> m5078toList(C1125Triple<? extends T, ? extends T, ? extends T> c1125Triple) {
        Intrinsics.checkNotNullParameter(c1125Triple, "<this>");
        return CollectionsKt.m5806listOf(c1125Triple.getFirst(), c1125Triple.getSecond(), c1125Triple.getThird());
    }
}
