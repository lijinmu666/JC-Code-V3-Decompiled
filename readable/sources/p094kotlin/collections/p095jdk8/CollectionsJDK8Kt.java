package p094kotlin.collections.p095jdk8;

import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.TypeIntrinsics;

@Metadata(m4987d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aT\u0010\u0000\u001a\u0002H\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000b¢\u0006\u0002\u0010\u0007\u001a_\u0010\f\u001a\u00020\r\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000e2\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u000f\u001a\u0002H\u0001H\u0087\u0088\bb\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000bb\u0002\b\u0011¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, m4988d2 = {"getOrDefault", "V", "K", "Lkotlin/internal/OnlyInputTypes;", BuildConfig.f24315FLAVOR, "key", "defaultValue", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/SinceKotlin;", "version", "1.2", "Lkotlin/internal/InlineOnly;", "remove", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlin/IgnorableReturnValue;", "kotlin-stdlib-jdk8"}, m4989k = 2, m4990mv = {2, 4, 0}, m4991pn = "kotlin.collections", m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "CollectionsJDK8Kt")
/* loaded from: classes.dex */
public final class CollectionsJDK8Kt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    private static final <K, V> V getOrDefault(Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.getOrDefault(k, v);
    }

    @SinceKotlin(m5061version = "1.2")
    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: remove */
    private static final <K, V> boolean m6019remove(Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return TypeIntrinsics.asMutableMap(map).remove(k, v);
    }
}
