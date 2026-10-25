package p094kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000*\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0081\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005b\u0002\b\t¢\u0006\u0004\b\u0005\u0010\u0006\u001aU\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\fH\u0086\u0080\u0004\u001ah\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000e2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\r\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\fH\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f¢\u0006\u0002\b\u000f¨\u0006\u0010"}, m4988d2 = {"getOrImplicitDefault", "V", "K", BuildConfig.f24315FLAVOR, "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/PublishedApi;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", BuildConfig.f24315FLAVOR, "withDefaultMutable", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/MapsKt")
@SourceDebugExtension(m6344value = {"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
/* loaded from: classes.dex */
class MapsKt__MapWithDefaultKt {
    @PublishedApi
    @InterfaceC1231JvmName(m6260name = "getOrImplicitDefaultNullable")
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, Function1<? super K, ? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return map instanceof MapWithDefault ? withDefault(((MapWithDefault) map).mo5927getMap(), defaultValue) : new MapWithDefaultImpl(map, defaultValue);
    }

    @InterfaceC1231JvmName(m6260name = "withDefaultMutable")
    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, Function1<? super K, ? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return map instanceof MutableMapWithDefault ? withDefaultMutable(((MutableMapWithDefault) map).mo5927getMap(), defaultValue) : new MutableMapWithDefaultImpl(map, defaultValue);
    }
}
