package p094kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.NotImplementedError;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001ar\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0087\u0088\u0004b6\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\b\u000e\u0012\u0002\b\f\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011b\u0002\b\u0012\u001as\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0014H\u0087\u0088\u0004b6\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0006\b\u000e\u0012\u0002\b\f\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011b\u0002\b\u0012ø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0080\u0004\u001a6\u0010\u0019\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0086\u0080\u0004\u001a9\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001b\u001a\u0002H\u0002H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\u0002\u0010\u001c\u001a,\u0010 \u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001a4\u0010 \u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m4988d2 = {"sort", BuildConfig.f24315FLAVOR, "T", BuildConfig.f24315FLAVOR, "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Lkotlin/Deprecated;", "message", "Use sortWith(comparator) instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.sortWith(comparator)", "imports", "level", "Lkotlin/DeprecationLevel;", "ERROR", "Lkotlin/internal/InlineOnly;", "comparison", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "Use sortWith(Comparator(comparison)) instead.", "this.sortWith(Comparator(comparison))", BuildConfig.f24315FLAVOR, "sortWith", "fill", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "Lkotlin/SinceKotlin;", "version", "1.2", "shuffle", "random", "Ljava/util/Random;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: fill */
    private static final <T> void m5812fill(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.fill(list, t);
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: shuffle */
    private static final <T> void m5813shuffle(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.shuffle(list);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", m5048imports = {}))
    @InlineOnly
    /* renamed from: sort */
    private static final <T> void m5816sort(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    public static <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: shuffle */
    private static final <T> void m5814shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        Collections.shuffle(list, random);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", m5048imports = {}))
    @InlineOnly
    /* renamed from: sort */
    private static final <T> void m5817sort(List<T> list, Function2<? super T, ? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    /* renamed from: sort */
    public static <T extends Comparable<? super T>> void m5815sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
