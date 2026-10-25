package p094kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecatedSinceKotlin;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001aI\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0080\bb\u0002\b\u000b¢\u0006\u0002\u0010\n\u001a\u001a\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000fH\u0086\u0080\u0004\u001a*\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0086\u0080\u0004\u001a<\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0086\u0080\u0004\u001aw\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010\u0018\u001aw\u0010\u0016\u001a\u0004\u0018\u00010+*\b\u0012\u0004\u0012\u00020+0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010,\u001ay\u0010\u0016\u001a\u0004\u0018\u0001H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u0010-\u001a\u0096\u0001\u0010.\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000200H\u0087\u0088\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(2\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(3\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u008b\u0001\u00104\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(7\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u00105\u001aw\u00108\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020\u00170\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010\u0018\u001aw\u00108\u001a\u0004\u0018\u00010+*\b\u0012\u0004\u0012\u00020+0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('b\f\b(\u0012\b\b)\u0012\u0004\b\b(*¢\u0006\u0002\u0010,\u001ay\u00108\u001a\u0004\u0018\u0001H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u0003H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(:\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u0010-\u001a\u0096\u0001\u0010;\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000200H\u0087\u0088\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(<\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(=\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u008b\u0001\u0010>\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0014j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u0015H\u0087\u0080\u0004b*\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(?\u0012\u001c\b\u001c\u0012\u0018\b\u000bB\u0014\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(@\u0012\u0006\b \u0012\u0002\b\fb \b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\b\b$\u0012\u0004\b\b(%\u0012\b\b&\u0012\u0004\b\b('¢\u0006\u0002\u00105\u001aZ\u0010A\u001a\u00020B\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020B00H\u0087\u0088\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(#b\u0002\bDb\f\bE\u0012\b\bF\u0012\u0004\b\b(Cb\u0002\bGø\u0001\u0000¢\u0006\u0002\bC\u001aZ\u0010A\u001a\u00020H\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020H00H\u0087\u0088\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(#b\u0002\bDb\f\bE\u0012\b\bF\u0012\u0004\b\b(Ib\u0002\bGø\u0001\u0000¢\u0006\u0002\bI\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006J"}, m4988d2 = {"filterIsInstance", BuildConfig.f24315FLAVOR, "R", BuildConfig.f24315FLAVOR, "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", BuildConfig.f24315FLAVOR, "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "Lkotlin/IgnorableReturnValue;", "reverse", BuildConfig.f24315FLAVOR, "T", BuildConfig.f24315FLAVOR, "toSortedSet", "Ljava/util/SortedSet;", BuildConfig.f24315FLAVOR, "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", BuildConfig.f24315FLAVOR, "(Ljava/lang/Iterable;)Ljava/lang/Double;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lkotlin/SinceKotlin;", "version", "1.1", BuildConfig.f24315FLAVOR, "(Ljava/lang/Iterable;)Ljava/lang/Float;", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/internal/InlineOnly;", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension(m6344value = {"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n2198#2,14:170\n2622#2,14:184\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n90#1:170,14\n127#1:184,14\n*E\n"})
/* loaded from: classes.dex */
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <R> List<R> filterIsInstance(Iterable<?> iterable, Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), klass);
    }

    @IgnorableReturnValue
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> iterable, C destination, Class<R> klass) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Double m5824max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m18939maxOrNull((Iterable<Double>) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Deprecated(m4972message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy */
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m5826maxBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rMo2237invoke = selector.mo2237invoke(next);
            do {
                T next2 = it.next();
                R rMo2237invoke2 = selector.mo2237invoke(next2);
                next = next;
                if (rMo2237invoke.compareTo(rMo2237invoke2) < 0) {
                    rMo2237invoke = rMo2237invoke2;
                    next = next2;
                }
            } while (it.hasNext());
        }
        return next;
    }

    @Deprecated(m4972message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith */
    public static final /* synthetic */ Object m5827maxWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.maxWithOrNull(iterable, comparator);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Double m5829min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m18945minOrNull((Iterable<Double>) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Deprecated(m4972message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy */
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m5831minBy(Iterable<? extends T> iterable, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rMo2237invoke = selector.mo2237invoke(next);
            do {
                T next2 = it.next();
                R rMo2237invoke2 = selector.mo2237invoke(next2);
                next = next;
                if (rMo2237invoke.compareTo(rMo2237invoke2) > 0) {
                    rMo2237invoke = rMo2237invoke2;
                    next = next2;
                }
            } while (it.hasNext());
        }
        return next;
    }

    @Deprecated(m4972message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith */
    public static final /* synthetic */ Object m5832minWith(Iterable iterable, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt___CollectionsKt.minWithOrNull(iterable, comparator);
    }

    /* renamed from: reverse */
    public static <T> void m5833reverse(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.mo2237invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "add(...)");
        }
        return bigDecimalValueOf;
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet());
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Float m5825max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m18940maxOrNull((Iterable<Float>) iterable);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Float m5830min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.m18946minOrNull((Iterable<Float>) iterable);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Comparable m5823max(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt___CollectionsKt.maxOrNull(iterable);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Comparable m5828min(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return CollectionsKt.minOrNull(iterable);
    }
}
