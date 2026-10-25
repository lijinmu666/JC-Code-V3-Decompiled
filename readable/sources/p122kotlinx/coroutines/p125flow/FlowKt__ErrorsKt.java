package p122kotlinx.coroutines.p125flow;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.InterfaceC1342Job;

@Metadata(m4987d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000e\u001a`\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u001123\b\u0002\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013¢\u0006\u0002\u0010\u0015\u001az\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u0012\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0017¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0019\u001a.\u0010\u001a\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u00020\u0014*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\b \u001a\u001b\u0010!\u001a\u00020\u0014*\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b#¨\u0006$"}, m4988d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "retry", "retries", BuildConfig.f24315FLAVOR, "predicate", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,220:1\n105#2:221\n105#2:223\n1#3:222\n1307#4:224\n159#5:225\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n54#1:221\n128#1:223\n167#1:224\n217#1:225\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ErrorsKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", m6124f = "Errors.kt", m6125i = {0, 0, 0}, m6126l = {152}, m6127m = "catchImpl", m6128n = {"$this$catchImpl", "collector", "fromDownstream"}, m6130s = {"L$0", "L$1", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 */
    public static final class C14771<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6487L$0;

        /* renamed from: L$1 */
        Object f6488L$1;

        /* renamed from: L$2 */
        Object f6489L$2;

        /* renamed from: label */
        int f6490label;

        /* renamed from: result */
        /* synthetic */ Object f6491result;

        public C14771(Continuation<? super C14771> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6491result = obj;
            this.f6490label |= Integer.MIN_VALUE;
            return C1427FlowKt.catchImpl(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 */
    public static final class C14782<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $collector;
        final /* synthetic */ C1235Ref.ObjectRef<Throwable> $fromDownstream;

        /* JADX WARN: Multi-variable type inference failed */
        public C14782(FlowCollector<? super T> flowCollector, C1235Ref.ObjectRef<Throwable> objectRef) {
            this.$collector = flowCollector;
            this.$fromDownstream = objectRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__ErrorsKt$catchImpl$2$emit$1 flowKt__ErrorsKt$catchImpl$2$emit$1;
            if (continuation instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) {
                flowKt__ErrorsKt$catchImpl$2$emit$1 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) continuation;
                int i = flowKt__ErrorsKt$catchImpl$2$emit$1.f6493label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ErrorsKt$catchImpl$2$emit$1.f6493label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ErrorsKt$catchImpl$2$emit$1 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, continuation);
                }
            }
            Object obj = flowKt__ErrorsKt$catchImpl$2$emit$1.f6494result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ErrorsKt$catchImpl$2$emit$1.f6493label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<T> flowCollector = this.$collector;
                    flowKt__ErrorsKt$catchImpl$2$emit$1.f6492L$0 = SpillingKt.nullOutSpilledVariable(t);
                    flowKt__ErrorsKt$catchImpl$2$emit$1.f6493label = 1;
                    if (flowCollector.mo4309emit(t, flowKt__ErrorsKt$catchImpl$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this = (C14782<T>) C1133Unit.INSTANCE;
                return this;
            } catch (Throwable 
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:369)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:332)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                */
            /*
                this = this;
                boolean r0 = r6 instanceof p122kotlinx.coroutines.p125flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (p122kotlinx.coroutines.p125flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) r0
                int r1 = r0.f6493label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f6493label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f6494result
                java.lang.Object r1 = p094kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f6493label
                r3 = 1
                if (r2 == 0) goto L33
                if (r2 != r3) goto L2b
                p094kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L29
                goto L47
            L29:
                r5 = move-exception
                goto L4a
            L2b:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L33:
                p094kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.flow.FlowCollector<T> r6 = r4.$collector     // Catch: java.lang.Throwable -> L29
                java.lang.Object r2 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch: java.lang.Throwable -> L29
                r0.f6492L$0 = r2     // Catch: java.lang.Throwable -> L29
                r0.f6493label = r3     // Catch: java.lang.Throwable -> L29
                java.lang.Object r4 = r6.mo4309emit(r5, r0)     // Catch: java.lang.Throwable -> L29
                if (r4 != r1) goto L47
                return r1
            L47:
                kotlin.Unit r4 = p094kotlin.C1133Unit.INSTANCE
                return r4
            L4a:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r4 = r4.$fromDownstream
                r4.f5202element = r5
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: p122kotlinx.coroutines.p125flow.FlowKt__ErrorsKt.C14782.mo4309emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", m6124f = "Errors.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1 */
    public static final class C14791 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {

        /* renamed from: label */
        int f6496label;

        public C14791(Continuation<? super C14791> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C14791(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6496label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(true);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(Throwable th, Continuation<? super Boolean> continuation) {
            return ((C14791) mo2166create(th, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", BuildConfig.f24315FLAVOR, "attempt", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", m6124f = "Errors.kt", m6125i = {0, 0}, m6126l = {91}, m6127m = "invokeSuspend", m6128n = {"cause", "attempt"}, m6130s = {"L$0", "J$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3 */
    public static final class C14803<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ long $retries;

        /* renamed from: J$0 */
        /* synthetic */ long f6497J$0;

        /* renamed from: L$0 */
        /* synthetic */ Object f6498L$0;

        /* renamed from: label */
        int f6499label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14803(long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C14803> continuation) {
            super(4, continuation);
            this.$retries = j;
            this.$predicate = function2;
        }

        @Override // p094kotlin.p105jvm.functions.Function4
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo6276invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return m7293invoke((FlowCollector) obj, th, l.longValue(), continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.f6498L$0;
            long j = this.f6497J$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6499label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (j < this.$retries) {
                    Function2<Throwable, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                    this.f6498L$0 = SpillingKt.nullOutSpilledVariable(th);
                    this.f6497J$0 = j;
                    this.f6499label = 1;
                    obj = function2.mo2167invoke(th, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return C1207Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = ((Boolean) obj).booleanValue();
            return C1207Boxing.boxBoolean(z);
        }

        /* renamed from: invoke */
        public final Object m7293invoke(FlowCollector<? super T> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
            C14803 c14803 = new C14803(this.$retries, this.$predicate, continuation);
            c14803.f6498L$0 = th;
            c14803.f6497J$0 = j;
            return c14803.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* renamed from: catch */
    public static final <T> InterfaceC1426Flow<T> m7291catch(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(interfaceC1426Flow, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object catchImpl(InterfaceC1426Flow<? extends T> interfaceC1426Flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) throws Throwable {
        C14771 c14771;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C14771) {
            c14771 = (C14771) continuation;
            int i = c14771.f6490label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14771.f6490label = i - Integer.MIN_VALUE;
            } else {
                c14771 = new C14771(continuation);
            }
        }
        Object obj = c14771.f6491result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14771.f6490label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            try {
                FlowCollector<? super Object> c14782 = new C14782<>(flowCollector, objectRef2);
                c14771.f6487L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14771.f6488L$1 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14771.f6489L$2 = objectRef2;
                c14771.f6490label = 1;
                if (interfaceC1426Flow.mo4308collect(c14782, c14771) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                objectRef = objectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c14771.f6489L$2;
            try {
                ResultKt.throwOnFailure(obj);
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        Throwable th3 = (Throwable) objectRef.f5202element;
        if (isSameExceptionAs$FlowKt__ErrorsKt(th, th3) || isCancellationCause$FlowKt__ErrorsKt(th, c14771.getContext())) {
            throw th;
        }
        if (th3 == null) {
            return th;
        }
        if (th instanceof CancellationException) {
            ExceptionsKt.addSuppressed(th3, th);
            throw th3;
        }
        ExceptionsKt.addSuppressed(th, th3);
        throw th;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th, CoroutineContext coroutineContext) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job == null || !interfaceC1342Job.isCancelled()) {
            return false;
        }
        return isSameExceptionAs$FlowKt__ErrorsKt(th, interfaceC1342Job.getCancellationException());
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th, Throwable th2) {
        return th2 != null && Intrinsics.areEqual(th2, th);
    }

    /* renamed from: retry */
    public static final <T> InterfaceC1426Flow<T> m7292retry(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        if (j > 0) {
            return C1427FlowKt.retryWhen(interfaceC1426Flow, new C14803(j, function2, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
    }

    public static /* synthetic */ InterfaceC1426Flow retry$default(InterfaceC1426Flow interfaceC1426Flow, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            function2 = new C14791(null);
        }
        return C1427FlowKt.m7242retry(interfaceC1426Flow, j, function2);
    }

    public static final <T> InterfaceC1426Flow<T> retryWhen(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(interfaceC1426Flow, function4);
    }
}
