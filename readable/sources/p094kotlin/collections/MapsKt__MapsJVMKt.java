package p094kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.builders.MapBuilder;
import p094kotlin.internal.ConstantsKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.PlatformImplementationsKt;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000x\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001a`\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032#\u0010\u0007\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001ah\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0007\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001a4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a<\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001aH\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\tH\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001ag\u0010\u0016\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\u0002\b\u001cb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001aD\u0010\u001e\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001ai\u0010\u001f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u000e\b\u0004\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\u0002\b\u001cb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001ai\u0010 \u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u000e\b\u0004\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010b\u0002\b\u001cø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001aS\u0010!\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0018\u001a\u0002H\u00022\u0006\u0010\"\u001a\u0002H\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u001c¢\u0006\u0002\u0010#\u001aQ\u0010$\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u0006\u0010%\u001a\u0002H\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u001c¢\u0006\u0002\u0010&\u001a>\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020)\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0080\u0004\u001aD\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020+H\u0086\u0080\u0004\u001a]\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020)\"\u0004\b\u0001\u0010\u00032*\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050.\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004¢\u0006\u0002\u0010/\u001aq\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020+2*\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050.\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0080\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(1¢\u0006\u0002\u00100\u001a\u001e\u00102\u001a\u000203*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040\u0001H\u0087\u0088\u0004b\u0002\b\u0010\u001a6\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\u0088\u0004b\u0002\b\u0010\u001a4\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\u0080\u0004\u001a\u0016\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\f\"\u000f\u00109\u001a\u00020\u0012X\u0082Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, m4988d2 = {"mapOf", BuildConfig.f24315FLAVOR, "K", "V", "pair", "Lkotlin/Pair;", "buildMapInternal", "builderAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/InlineOnly;", "capacity", BuildConfig.f24315FLAVOR, "createMapBuilder", "build", "builder", "getOrElseIfMissing", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/ExperimentalStdlibApi;", "2.4", "getOrPut", "getOrPutIfNull", "getOrPutIfMissing", "getOrDefaultImpl", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrPutIfNullImpl", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toSortedMap", "Ljava/util/SortedMap;", BuildConfig.f24315FLAVOR, "comparator", "Ljava/util/Comparator;", "sortedMapOf", "pairs", BuildConfig.f24315FLAVOR, "([Lkotlin/Pair;)Ljava/util/SortedMap;", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "1.4", "toProperties", "Ljava/util/Properties;", BuildConfig.f24315FLAVOR, "toSingletonMapOrSelf", "toSingletonMap", "mapCapacity", "expectedSize", "INT_MAX_POWER_OF_TWO", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/MapsKt")
@SourceDebugExtension(m6344value = {"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,309:1\n1#2:310\n*E\n"})
/* loaded from: classes.dex */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    private static final int INT_MAX_POWER_OF_TWO = 1073741824;

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    /* renamed from: build */
    public static <K, V> Map<K, V> m5930build(Map<K, V> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((MapBuilder) builder).m6012build();
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(Function1<? super Map<K, V>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapCreateMapBuilder = createMapBuilder();
        builderAction.mo2237invoke(mapCreateMapBuilder);
        return C1155MapsKt.m5930build(mapCreateMapBuilder);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    @SinceKotlin(m5061version = "2.4")
    @PublishedApi
    @ExperimentalStdlibApi
    public static final <K, V> V getOrDefaultImpl(Map<K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (V) PlatformImplementationsKt.IMPLEMENTATIONS.getOrDefault(map, k, v);
    }

    @SinceKotlin(m5061version = "2.4")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <K, V> V getOrElseIfMissing(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj = ConstantsKt.MISSING_VALUE;
        V v = (V) getOrDefaultImpl(concurrentMap, k, obj);
        return v != obj ? v : defaultValue.mo4323invoke();
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V vMo4323invoke = defaultValue.mo4323invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k, vMo4323invoke);
        return vPutIfAbsent == null ? vMo4323invoke : vPutIfAbsent;
    }

    @SinceKotlin(m5061version = "2.4")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <K, V> V getOrPutIfMissing(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> defaultValue) {
        Object obj;
        V v;
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object obj2 = ConstantsKt.MISSING_VALUE;
        V v2 = (V) getOrDefaultImpl(concurrentMap, k, obj2);
        if (v2 != obj2) {
            return v2;
        }
        V vMo4323invoke = defaultValue.mo4323invoke();
        do {
            V vPutIfAbsent = concurrentMap.putIfAbsent(k, vMo4323invoke);
            if (vPutIfAbsent != null) {
                return vPutIfAbsent;
            }
            obj = ConstantsKt.MISSING_VALUE;
            v = (V) getOrDefaultImpl(concurrentMap, k, obj);
        } while (v == obj);
        return v;
    }

    @SinceKotlin(m5061version = "2.4")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <K, V> V getOrPutIfNull(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = concurrentMap.get(k);
        return v == null ? (V) getOrPutIfNullImpl(concurrentMap, k, defaultValue.mo4323invoke()) : v;
    }

    @SinceKotlin(m5061version = "2.4")
    @PublishedApi
    @ExperimentalStdlibApi
    public static final <K, V> V getOrPutIfNullImpl(ConcurrentMap<K, V> concurrentMap, K k, V v) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        return v != null ? (V) PlatformImplementationsKt.IMPLEMENTATIONS.computeIfAbsent(concurrentMap, k, v) : concurrentMap.putIfAbsent(k, v);
    }

    @PublishedApi
    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: mapOf */
    public static final <K, V> Map<K, V> m5931mapOf(C1122Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(C1122Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        MapsKt__MapsKt.m5951putAll(treeMap, pairs);
        return treeMap;
    }

    @InlineOnly
    private static final Properties toProperties(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return toSingletonMap(map);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new TreeMap(map);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(int i, Function1<? super Map<K, V>, C1133Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapCreateMapBuilder = C1155MapsKt.createMapBuilder(i);
        builderAction.mo2237invoke(mapCreateMapBuilder);
        return C1155MapsKt.m5930build(mapCreateMapBuilder);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    public static <K, V> Map<K, V> createMapBuilder(int i) {
        return new MapBuilder(i);
    }

    @SinceKotlin(m5061version = "1.4")
    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, C1122Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        MapsKt__MapsKt.m5951putAll(treeMap, pairs);
        return treeMap;
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
