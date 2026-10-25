package p094kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.AbstractMutableSet;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\t\bF¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0082\u0004¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H¦\u0080\u0004¨\u0006\r"}, m4988d2 = {"Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", BuildConfig.f24315FLAVOR, "K", "V", "Lkotlin/collections/AbstractMutableSet;", "<init>", "()V", "contains", BuildConfig.f24315FLAVOR, "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((AbstractMapBuilderEntrySet<E, K, V>) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> element);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return mo6005remove((Map.Entry<?, ?>) obj);
        }
        return false;
    }

    public final boolean contains(E element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return containsEntry(element);
    }

    /* renamed from: remove */
    public /* bridge */ boolean mo6005remove(Map.Entry<?, ?> entry) {
        return super.remove((Object) entry);
    }
}
