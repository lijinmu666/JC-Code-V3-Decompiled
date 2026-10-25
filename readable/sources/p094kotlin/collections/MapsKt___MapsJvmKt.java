package p094kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000D\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a»\u0001\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\u0088\u0004b*\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001c\b\f\u0012\u0018\b\u000bB\u0014\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0006\b\u0010\u0012\u0002\b\fb \b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017b\u0002\b\u0018ø\u0001\u0000\u001a¼\u0001\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\u001a\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u001bj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\u001cH\u0087\u0088\u0004b*\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001d\u0012\u001c\b\f\u0012\u0018\b\u000bB\u0014\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001e\u0012\u0006\b\u0010\u0012\u0002\b\fb \b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017b\u0002\b\u0018\u001a·\u0001\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\u0088\u0004b*\b\t\u0012\b\b\n\u0012\u0004\b\b( \u0012\u001c\b\f\u0012\u0018\b\u000bB\u0014\b\r\u0012\b\b\u000e\u0012\u0004\b\b(!\u0012\u0006\b\u0010\u0012\u0002\b\fb \b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017ø\u0001\u0000\u001a¸\u0001\u0010\"\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\u001a\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u001bj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\u001cH\u0087\u0080\u0004b*\b\t\u0012\b\b\n\u0012\u0004\b\b(#\u0012\u001c\b\f\u0012\u0018\b\u000bB\u0014\b\r\u0012\b\b\u000e\u0012\u0004\b\b($\u0012\u0006\b\u0010\u0012\u0002\b\fb \b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m4988d2 = {"maxBy", BuildConfig.f24315FLAVOR, "K", "V", "R", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "selector", "Lkotlin/Function1;", "Lkotlin/Deprecated;", "message", "Use maxByOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxByOrNull(selector)", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lkotlin/internal/InlineOnly;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/MapsKt")
/* loaded from: classes.dex */
class MapsKt___MapsJvmKt extends MapsKt__MapsKt {
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @InlineOnly
    /* renamed from: maxBy */
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m5963maxBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rMo2237invoke = selector.mo2237invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rMo2237invoke2 = selector.mo2237invoke(entry3);
                    if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                        entry2 = entry3;
                        rMo2237invoke = rMo2237invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @InlineOnly
    /* renamed from: maxWith */
    private static final /* synthetic */ <K, V> Map.Entry<K, V> m5964maxWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy */
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> m5965minBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rMo2237invoke = selector.mo2237invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rMo2237invoke2 = selector.mo2237invoke(entry3);
                    if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                        entry2 = entry3;
                        rMo2237invoke = rMo2237invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith */
    public static final /* synthetic */ Map.Entry m5966minWith(Map map, Comparator comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.minWithOrNull(map.entrySet(), comparator);
    }
}
