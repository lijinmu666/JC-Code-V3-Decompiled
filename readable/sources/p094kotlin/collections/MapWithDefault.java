package p094kotlin.collections;

import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.p106markers.KMappedMarker;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0017\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\tR\u001f\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m4988d2 = {"Lkotlin/collections/MapWithDefault;", "K", "V", BuildConfig.f24315FLAVOR, "map", "getMap", "()Ljava/util/Map;", "getOrImplicitDefault", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    /* renamed from: getMap */
    Map<K, V> mo5927getMap();

    V getOrImplicitDefault(K key);
}
