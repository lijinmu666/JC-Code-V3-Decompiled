package p094kotlin.comparisons;

import java.util.Comparator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a]\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\t\u001aI\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022 \u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000b\u0010\t\u001aF\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\r\u001ab\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0014\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0015\u001a]\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0017\u001aH\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ad\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aH\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ad\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\\\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001ax\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\\\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001ax\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001az\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u001228\b\u0004\u0010\u001f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00010 H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010#\u001aU\u0010$\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0084\u0004¢\u0006\u0002\u0010%\u001aU\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0084\u0004¢\u0006\u0002\u0010%\u001aI\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\b\b\u0000\u0010\u0002*\u00020(2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001a7\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004b\u0002\b\u000e¢\u0006\u0002\u0010*\u001aI\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\b\b\u0000\u0010\u0002*\u00020(2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001a7\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004b\u0002\b\u000e¢\u0006\u0002\u0010*\u001a/\u0010,\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010*\u001a/\u0010-\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010*\u001a9\u0010.\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, m4988d2 = {"compareValuesBy", BuildConfig.f24315FLAVOR, "T", "a", "b", "selectors", BuildConfig.f24315FLAVOR, "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "selector", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "Lkotlin/internal/InlineOnly;", "K", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareBy", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "compareByDescending", "thenBy", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "then", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "thenDescending", "nullsFirst", BuildConfig.f24315FLAVOR, "(Ljava/util/Comparator;)Ljava/util/Comparator;", "()Ljava/util/Comparator;", "nullsLast", "naturalOrder", "reverseOrder", "reversed", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes.dex */
public class ComparisonsKt__ComparisonsKt {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,325:1\n*E\n"})
    /* renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2 */
    public static final class C11772<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public C11772(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.mo2237invoke(t), function1.mo2237invoke(t2));
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,325:1\n*E\n"})
    /* renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1 */
    public static final class C11791<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        /* JADX WARN: Multi-variable type inference failed */
        public C11791(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.mo2237invoke(t2), function1.mo2237invoke(t));
        }
    }

    public static <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            return new Comparator() { // from class: kotlin.comparisons.ZfxDd
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(selectors, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] function1Arr, Object obj, Object obj2) {
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(obj, obj2, function1Arr);
    }

    @InlineOnly
    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new C11791(selector);
    }

    public static <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == null) {
            return t2 == null ? 0 : -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int iCompareValues = ComparisonsKt.compareValues(function1.mo2237invoke(t), function1.mo2237invoke(t2));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return naturalOrderComparator;
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.KLFTb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? 0 : -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.mjFkc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(Comparator comparator, Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? 0 : 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return reverseOrderComparator;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        if (comparator instanceof ReversedComparator) {
            return ((ReversedComparator) comparator).getComparator();
        }
        Comparator<T> reversedComparator = NaturalOrderComparator.INSTANCE;
        if (Intrinsics.areEqual(comparator, reversedComparator)) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
            Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
            return reverseOrderComparator;
        }
        if (Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE)) {
            Intrinsics.checkNotNull(reversedComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
        } else {
            reversedComparator = new ReversedComparator<>(comparator);
        }
        return reversedComparator;
    }

    /* renamed from: then */
    public static final <T> Comparator<T> m6028then(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.wA
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.then$lambda$0$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int then$lambda$0$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj, obj2);
    }

    @InlineOnly
    /* renamed from: thenBy */
    private static final <T> Comparator<T> m6030thenBy(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenBy.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Function1<T, Comparable<?>> function1 = selector;
                return ComparisonsKt.compareValues(function1.mo2237invoke(t), function1.mo2237invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenByDescending(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenByDescending.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Function1<T, Comparable<?>> function1 = selector;
                return ComparisonsKt.compareValues(function1.mo2237invoke(t2), function1.mo2237invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> thenComparator(final Comparator<T> comparator, final Function2<? super T, ? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenComparator.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : comparison.mo2167invoke(t, t2).intValue();
            }
        };
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() { // from class: kotlin.comparisons.AZxh
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        int iCompare = comparator.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator2.compare(obj2, obj);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareByDescending.2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function1 = selector;
                return comparator2.compare(function1.mo2237invoke(t2), function1.mo2237invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return nullsFirst(ComparisonsKt.naturalOrder());
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return nullsLast(ComparisonsKt.naturalOrder());
    }

    @InlineOnly
    /* renamed from: thenBy */
    private static final <T, K> Comparator<T> m6029thenBy(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenBy.2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function1 = selector;
                return comparator3.compare(function1.mo2237invoke(t), function1.mo2237invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.thenByDescending.2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function1 = selector;
                return comparator3.compare(function1.mo2237invoke(t2), function1.mo2237invoke(t));
            }
        };
    }

    @InlineOnly
    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new C11772(selector);
    }

    @InlineOnly
    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return ComparisonsKt.compareValues(selector.mo2237invoke(t), selector.mo2237invoke(t2));
    }

    @InlineOnly
    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareBy.3
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function1 = selector;
                return comparator2.compare(function1.mo2237invoke(t), function1.mo2237invoke(t2));
            }
        };
    }

    @InlineOnly
    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return comparator.compare(selector.mo2237invoke(t), selector.mo2237invoke(t2));
    }
}
