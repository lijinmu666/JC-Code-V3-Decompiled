package p094kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B@\bF\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0010H\u0096\u0080\u0004J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010 J\u0017\u0010,\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010 R!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0017\u001a\u00020\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b'\u0010(R'\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0\"8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010$¨\u0006-"}, m4988d2 = {"Lkotlin/collections/MapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MapWithDefault;", "map", BuildConfig.f24315FLAVOR, "default", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getMap", "()Ljava/util/Map;", "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "size", "getSize", "()I", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "keys", BuildConfig.f24315FLAVOR, "getKeys", "()Ljava/util/Set;", "values", BuildConfig.f24315FLAVOR, "getValues", "()Ljava/util/Collection;", "entries", BuildConfig.f24315FLAVOR, "getEntries", "getOrImplicitDefault", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapWithDefaultImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
/* loaded from: classes.dex */
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {
    private final Function1<K, V> default;
    private final Map<K, V> map;

    /* JADX WARN: Multi-variable type inference failed */
    public MapWithDefaultImpl(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.map = map;
        this.default = function1;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return mo5927getMap().containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return mo5927getMap().containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return mo5927getMap().equals(other);
    }

    @Override // java.util.Map
    public V get(Object key) {
        return mo5927getMap().get(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return mo5927getMap().entrySet();
    }

    /* renamed from: getKeys */
    public Set<K> m5928getKeys() {
        return mo5927getMap().keySet();
    }

    @Override // p094kotlin.collections.MapWithDefault
    /* renamed from: getMap */
    public Map<K, V> mo5927getMap() {
        return this.map;
    }

    @Override // p094kotlin.collections.MapWithDefault
    public V getOrImplicitDefault(K key) {
        Map<K, V> mapMo5927getMap = mo5927getMap();
        V v = mapMo5927getMap.get(key);
        return (v != null || mapMo5927getMap.containsKey(key)) ? v : this.default.mo2237invoke(key);
    }

    /* renamed from: getSize */
    public int m5929getSize() {
        return mo5927getMap().size();
    }

    public Collection<V> getValues() {
        return mo5927getMap().values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return mo5927getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return mo5927getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m5928getKeys();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m5929getSize();
    }

    public String toString() {
        return mo5927getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
