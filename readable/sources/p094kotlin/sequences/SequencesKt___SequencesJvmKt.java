package p094kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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

@Metadata(m4987d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001aI\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\bb\u0002\b\n¢\u0006\u0002\u0010\t\u001a*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0086\u0080\u0004\u001a<\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0086\u0080\u0004\u001aw\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u0010\u0012\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u0010*\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(.\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(/\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u00100\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(2\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aw\u00104\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010\u0014\u001aw\u00104\u001a\u0004\u0018\u00010'*\b\u0012\u0004\u0012\u00020'0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#b\f\b$\u0012\b\b%\u0012\u0004\b\b(&¢\u0006\u0002\u0010(\u001ay\u00104\u001a\u0004\u0018\u0001H\r\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e*\b\u0012\u0004\u0012\u0002H\r0\u0001H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(5\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(6\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010)\u001a\u0096\u0001\u00107\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020,H\u0087\u0088\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(8\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(9\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u008b\u0001\u0010:\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u001a\u0010\u000f\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0011H\u0087\u0080\u0004b*\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(;\u0012\u001c\b\u0018\u0012\u0018\b\u000bB\u0014\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(<\u0012\u0006\b\u001c\u0012\u0002\b\fb \b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u00101\u001aZ\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020>0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(?b\u0002\bCø\u0001\u0000¢\u0006\u0002\b?\u001aZ\u0010=\u001a\u00020D\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020D0,H\u0087\u0088\u0004b\f\b$\u0012\b\b%\u0012\u0004\b\b(\u001fb\u0002\b@b\f\bA\u0012\b\bB\u0012\u0004\b\b(Eb\u0002\bCø\u0001\u0000¢\u0006\u0002\bE\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006F"}, m4988d2 = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", BuildConfig.f24315FLAVOR, "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "Lkotlin/IgnorableReturnValue;", "toSortedSet", "Ljava/util/SortedSet;", "T", BuildConfig.f24315FLAVOR, "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", BuildConfig.f24315FLAVOR, "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "Lkotlin/Deprecated;", "message", "Use maxOrNull instead.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "this.maxOrNull()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "1.5", "hiddenSince", "1.6", "Lkotlin/SinceKotlin;", "version", "1.1", BuildConfig.f24315FLAVOR, "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Use maxByOrNull instead.", "this.maxByOrNull(selector)", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "Use maxWithOrNull instead.", "this.maxWithOrNull(comparator)", "min", "Use minOrNull instead.", "this.minOrNull()", "minBy", "Use minByOrNull instead.", "this.minByOrNull(selector)", "minWith", "Use minWithOrNull instead.", "this.minWithOrNull(comparator)", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Lkotlin/OverloadResolutionByLambdaReturnType;", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/internal/InlineOnly;", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/sequences/SequencesKt")
@SourceDebugExtension(m6344value = {"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,173:1\n1647#2,14:174\n2107#2,14:188\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n90#1:174,14\n127#1:188,14\n*E\n"})
/* loaded from: classes.dex */
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static final <R> Sequence<R> filterIsInstance(Sequence<?> sequence, final Class<R> klass) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Sequence<R> sequenceFilter = SequencesKt.m6596filter(sequence, new Function1() { // from class: kotlin.sequences.JHa
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(klass.isInstance(obj));
            }
        });
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return sequenceFilter;
    }

    @IgnorableReturnValue
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Sequence<?> sequence, C destination, Class<R> klass) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (Object obj : sequence) {
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
    public static final /* synthetic */ Double m6574max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.m19794maxOrNull((Sequence<Double>) sequence);
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
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m6576maxBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final /* synthetic */ Object m6577maxWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt___SequencesKt.maxWithOrNull(sequence, comparator);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Double m6579min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.m19800minOrNull((Sequence<Double>) sequence);
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
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m6581minBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator<? extends T> it = sequence.iterator();
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
    public static final /* synthetic */ Object m6582minWith(Sequence sequence, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt___SequencesKt.minWithOrNull(sequence, comparator);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    @InterfaceC1231JvmName(m6260name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal sumOfBigDecimal(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
        Iterator<? extends T> it = sequence.iterator();
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
    private static final <T> BigInteger sumOfBigInteger(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.mo2237invoke(it.next()));
            Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "add(...)");
        }
        return bigIntegerValueOf;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet());
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Float m6575max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.m19795maxOrNull((Sequence<Float>) sequence);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @SinceKotlin(m5061version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Float m6580min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.m19801minOrNull((Sequence<Float>) sequence);
    }

    public static final <T> SortedSet<T> toSortedSet(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }

    @Deprecated(m4972message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max */
    public static final /* synthetic */ Comparable m6573max(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.maxOrNull(sequence);
    }

    @Deprecated(m4972message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", m5048imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min */
    public static final /* synthetic */ Comparable m6578min(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt___SequencesKt.minOrNull(sequence);
    }
}
