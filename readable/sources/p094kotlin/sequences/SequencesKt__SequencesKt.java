package p094kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.SinceKotlin;
import p094kotlin.TuplesKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p110random.AbstractC1241Random;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0088\u0004b\u0002\b\u0006ø\u0001\u0000\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\f\u001a\u0002H\u0002H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\r\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010b\u0002\b\u0006\u001a\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001a4\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013b\u0002\b\u0006\u001aB\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u001a&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001H\u0086\u0080\u0004\u001a9\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0018¢\u0006\u0002\b\u0018\u001aE\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00050\u001cH\u0082\u0080\u0004¢\u0006\u0002\b\u001d\u001aD\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0 0\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001b0\u001f0\u0001H\u0086\u0080\u0004\u001a.\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u001ad\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H&0)2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00050\u001cH\u0080\u0080\u0004\u001a \u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001a*\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\u0086\u0080\u0004\u001aC\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\b\u0010/\u001a\u0004\u0018\u0001H\u00022\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u001cH\u0087\u0080\u0004b\u0002\b1¢\u0006\u0002\u00100\u001a@\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u001cH\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, m4988d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "asSequence", "sequenceOf", "elements", BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "element", "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "Lkotlin/SinceKotlin;", "version", "2.2", "emptySequence", "orEmpty", "1.3", "ifEmpty", "defaultValue", "flatten", BuildConfig.f24315FLAVOR, "flattenSequenceOfIterable", "Lkotlin/jvm/JvmName;", "name", "R", "Lkotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lkotlin/Pair;", BuildConfig.f24315FLAVOR, "shuffled", "1.4", "random", "Lkotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "constrainOnce", "generateSequence", BuildConfig.f24315FLAVOR, "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "Lkotlin/internal/LowPriorityInOverloadResolution;", "seedFunction", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlin/sequences/SequenceScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", m6124f = "Sequences.kt", m6125i = {0, 0, 0, 0}, m6126l = {383}, m6127m = "invokeSuspend", m6128n = {"$this$sequence", "element", "result", "index"}, m6129nl = {385}, m6130s = {"L$0", "L$2", "L$3", "I$0"}, m6131v = 2)
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1 */
    public static final class C12681<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function1<C, Iterator<R>> $iterator;

        /* renamed from: $source */
        final /* synthetic */ Sequence<T> f5295$source;
        final /* synthetic */ Function2<Integer, T, C> $transform;

        /* renamed from: I$0 */
        int f5296I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5297L$0;

        /* renamed from: L$1 */
        Object f5298L$1;

        /* renamed from: L$2 */
        Object f5299L$2;

        /* renamed from: L$3 */
        Object f5300L$3;

        /* renamed from: label */
        int f5301label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12681(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super C12681> continuation) {
            super(2, continuation);
            this.f5295$source = sequence;
            this.$transform = function2;
            this.$iterator = function1;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C12681 c12681 = new C12681(this.f5295$source, this.$transform, this.$iterator, continuation);
            c12681.f5297L$0 = obj;
            return c12681;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            Iterator it;
            SequenceScope sequenceScope = (SequenceScope) this.f5297L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f5301label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                it = this.f5295$source.iterator();
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f5296I$0;
                it = (Iterator) this.f5298L$1;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                Function2<Integer, T, C> function2 = this.$transform;
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object objMo2167invoke = function2.mo2167invoke(C1207Boxing.m6121boxInt(i), next);
                Iterator<R> itMo2237invoke = this.$iterator.mo2237invoke(objMo2167invoke);
                this.f5297L$0 = sequenceScope;
                this.f5298L$1 = it;
                this.f5299L$2 = SpillingKt.nullOutSpilledVariable(next);
                this.f5300L$3 = SpillingKt.nullOutSpilledVariable(objMo2167invoke);
                this.f5296I$0 = i3;
                this.f5301label = 1;
                if (sequenceScope.yieldAll(itMo2237invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super R> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C12681) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlin/sequences/SequenceScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", m6124f = "Sequences.kt", m6125i = {0, 0, 1, 1}, m6126l = {102, 104}, m6127m = "invokeSuspend", m6128n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, m6129nl = {104, 106}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 2)
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1 */
    public static final class C12691<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function0<Sequence<T>> $defaultValue;
        final /* synthetic */ Sequence<T> $this_ifEmpty;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5302L$0;

        /* renamed from: L$1 */
        Object f5303L$1;

        /* renamed from: label */
        int f5304label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12691(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0, Continuation<? super C12691> continuation) {
            super(2, continuation);
            this.$this_ifEmpty = sequence;
            this.$defaultValue = function0;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C12691 c12691 = new C12691(this.$this_ifEmpty, this.$defaultValue, continuation);
            c12691.f5302L$0 = obj;
            return c12691;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope = (SequenceScope) this.f5302L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5304label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                if (it.hasNext()) {
                    this.f5302L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.f5303L$1 = SpillingKt.nullOutSpilledVariable(it);
                    this.f5304label = 1;
                    if (sequenceScope.yieldAll(it, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Sequence<T> sequenceMo4323invoke = this.$defaultValue.mo4323invoke();
                    this.f5302L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.f5303L$1 = SpillingKt.nullOutSpilledVariable(it);
                    this.f5304label = 2;
                    if (sequenceScope.yieldAll(sequenceMo4323invoke, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super T> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C12691) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlin/sequences/SequenceScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", m6124f = "Sequences.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {178}, m6127m = "invokeSuspend", m6128n = {"$this$sequence", "buffer", "last", "value", "j"}, m6129nl = {180}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 2)
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$shuffled$1 */
    public static final class C12701<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $random */
        final /* synthetic */ AbstractC1241Random f5305$random;
        final /* synthetic */ Sequence<T> $this_shuffled;

        /* renamed from: I$0 */
        int f5306I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5307L$0;

        /* renamed from: L$1 */
        Object f5308L$1;

        /* renamed from: L$2 */
        Object f5309L$2;

        /* renamed from: L$3 */
        Object f5310L$3;

        /* renamed from: label */
        int f5311label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12701(Sequence<? extends T> sequence, AbstractC1241Random abstractC1241Random, Continuation<? super C12701> continuation) {
            super(2, continuation);
            this.$this_shuffled = sequence;
            this.f5305$random = abstractC1241Random;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C12701 c12701 = new C12701(this.$this_shuffled, this.f5305$random, continuation);
            c12701.f5307L$0 = obj;
            return c12701;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List mutableList;
            SequenceScope sequenceScope = (SequenceScope) this.f5307L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5311label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableList = SequencesKt___SequencesKt.toMutableList(this.$this_shuffled);
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableList = (List) this.f5308L$1;
                ResultKt.throwOnFailure(obj);
            }
            while (!mutableList.isEmpty()) {
                int iMo6436nextInt = this.f5305$random.mo6436nextInt(mutableList.size());
                Object objRemoveLast = CollectionsKt.removeLast(mutableList);
                Object obj2 = iMo6436nextInt < mutableList.size() ? mutableList.set(iMo6436nextInt, objRemoveLast) : objRemoveLast;
                this.f5307L$0 = sequenceScope;
                this.f5308L$1 = mutableList;
                this.f5309L$2 = SpillingKt.nullOutSpilledVariable(objRemoveLast);
                this.f5310L$3 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f5306I$0 = iMo6436nextInt;
                this.f5311label = 1;
                if (sequenceScope.mo6559yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super T> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C12701) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt.Sequence.1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterator.mo4323invoke();
            }
        };
    }

    public static <T> Sequence<T> asSequence(final Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return it;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> source, Function2<? super Integer, ? super T, ? extends C> transform, Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return SequencesKt.sequence(new C12681(source, transform, iterator, null));
    }

    /* renamed from: flatten */
    public static final <T> Sequence<T> m6563flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() { // from class: kotlin.sequences.wA
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$0$SequencesKt__SequencesKt((Sequence) obj);
            }
        });
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return sequence instanceof TransformingSequence ? ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1) : new FlatteningSequence(sequence, new Function1() { // from class: kotlin.sequences.KLFTb
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt(obj);
            }
        }, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator flatten$lambda$0$SequencesKt__SequencesKt(Sequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Iterable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object flatten$lambda$2$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    @InterfaceC1231JvmName(m6260name = "flattenSequenceOfIterable")
    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() { // from class: kotlin.sequences.ZfxDd
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Iterable) obj);
            }
        });
    }

    public static final <T> Sequence<T> generateSequence(final Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return SequencesKt.constrainOnce(new GeneratorSequence(nextFunction, new Function1() { // from class: kotlin.sequences.AZxh
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return SequencesKt__SequencesKt.generateSequence$lambda$0$SequencesKt__SequencesKt(nextFunction, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$0$SequencesKt__SequencesKt(Function0 function0, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return function0.mo4323invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object generateSequence$lambda$1$SequencesKt__SequencesKt(Object obj) {
        return obj;
    }

    @SinceKotlin(m5061version = "1.3")
    /* renamed from: ifEmpty */
    public static final <T> Sequence<T> m6564ifEmpty(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt.sequence(new C12691(sequence, defaultValue, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    /* renamed from: orEmpty */
    private static final <T> Sequence<T> m6566orEmpty(Sequence<? extends T> sequence) {
        return sequence == 0 ? SequencesKt.emptySequence() : sequence;
    }

    public static final <T> Sequence<T> sequenceOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.asSequence(elements);
    }

    @SinceKotlin(m5061version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return shuffled(sequence, AbstractC1241Random.INSTANCE);
    }

    /* renamed from: unzip */
    public static final <T, R> C1122Pair<List<T>, List<R>> m6567unzip(Sequence<? extends C1122Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C1122Pair<? extends T, ? extends R> c1122Pair : sequence) {
            arrayList.add(c1122Pair.getFirst());
            arrayList2.add(c1122Pair.getSecond());
        }
        return TuplesKt.m5076to(arrayList, arrayList2);
    }

    @LowPriorityInOverloadResolution
    public static <T> Sequence<T> generateSequence(final T t, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return t == null ? EmptySequence.INSTANCE : new GeneratorSequence(new Function0() { // from class: kotlin.sequences.mjFkc
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return SequencesKt__SequencesKt.generateSequence$lambda$1$SequencesKt__SequencesKt(t);
            }
        }, nextFunction);
    }

    @SinceKotlin(m5061version = "2.2")
    public static <T> Sequence<T> sequenceOf(final T t) {
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$sequenceOf$$inlined$Sequence$1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return new SequencesKt__SequencesKt$sequenceOf$1$1(t);
            }
        };
    }

    @SinceKotlin(m5061version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence, AbstractC1241Random random) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt.sequence(new C12701(sequence, random, null));
    }

    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> Sequence<T> sequenceOf() {
        return SequencesKt.emptySequence();
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> seedFunction, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new GeneratorSequence(seedFunction, nextFunction);
    }
}
