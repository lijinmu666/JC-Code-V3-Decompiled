package p122kotlinx.coroutines.p125flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.IndexedValue;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.C1350YieldKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.channels.ChannelKt;
import p122kotlinx.coroutines.channels.ChannelResult;
import p122kotlinx.coroutines.channels.InterfaceC1361Channel;
import p122kotlinx.coroutines.channels.SendChannel;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u008d\u0001\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0014\u0010\b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00060\n0\t2\u0016\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0018\u00010\t0\f29\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e¢\u0006\u0002\b\u0010H\u0081@¢\u0006\u0002\u0010\u0011\u001ak\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00050\n\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\n2(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0017*\u001c\b\u0002\u0010\u0000\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0018"}, m4988d2 = {"Update", "Lkotlin/collections/IndexedValue;", BuildConfig.f24315FLAVOR, "combineInternal", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "flows", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/Flow;", "arrayFactory", "Lkotlin/Function0;", "transform", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zipImpl", "T1", "T2", "flow", "flow2", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,140:1\n105#2:141\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n83#1:141\n*E\n"})
/* loaded from: classes.dex */
public final class CombineKt {

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", m6124f = "Combine.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m6126l = {C5125EACTags.TRANSACTION_DATE, 73, 76}, m6127m = "invokeSuspend", m6128n = {"$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "size", "remainingAbsentValues", "currentEpoch", "$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "element", "results", "size", "remainingAbsentValues", "currentEpoch", "$this$flowScope", "latestValues", "resultChannel", "nonClosed", "lastReceivedEpoch", "element", "results", "size", "remainingAbsentValues", "currentEpoch"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 */
    public static final class C15672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function0<T[]> $arrayFactory;

        /* renamed from: $flows */
        final /* synthetic */ InterfaceC1426Flow<T>[] f7117$flows;
        final /* synthetic */ FlowCollector<R> $this_combineInternal;
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

        /* renamed from: I$0 */
        int f7118I$0;

        /* renamed from: I$1 */
        int f7119I$1;

        /* renamed from: I$2 */
        int f7120I$2;

        /* renamed from: L$0 */
        private /* synthetic */ Object f7121L$0;

        /* renamed from: L$1 */
        Object f7122L$1;

        /* renamed from: L$2 */
        Object f7123L$2;

        /* renamed from: L$3 */
        Object f7124L$3;

        /* renamed from: L$4 */
        Object f7125L$4;

        /* renamed from: L$5 */
        Object f7126L$5;

        /* renamed from: L$6 */
        Object f7127L$6;

        /* renamed from: label */
        int f7128label;

        @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", m6124f = "Combine.kt", m6125i = {}, m6126l = {28}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

            /* renamed from: $flows */
            final /* synthetic */ InterfaceC1426Flow<T>[] f7129$flows;

            /* renamed from: $i */
            final /* synthetic */ int f7130$i;
            final /* synthetic */ AtomicInteger $nonClosed;
            final /* synthetic */ InterfaceC1361Channel<IndexedValue<Object>> $resultChannel;

            /* renamed from: label */
            int f7131label;

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C63541<T> implements FlowCollector {

                /* renamed from: $i */
                final /* synthetic */ int f7132$i;
                final /* synthetic */ InterfaceC1361Channel<IndexedValue<Object>> $resultChannel;

                public C63541(InterfaceC1361Channel<IndexedValue<Object>> interfaceC1361Channel, int i) {
                    this.$resultChannel = interfaceC1361Channel;
                    this.f7132$i = i;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
                    CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                    if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                        combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                        int i = combineKt$combineInternal$2$1$1$emit$1.f7134label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            combineKt$combineInternal$2$1$1$emit$1.f7134label = i - Integer.MIN_VALUE;
                        } else {
                            combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                        }
                    }
                    Object obj = combineKt$combineInternal$2$1$1$emit$1.f7135result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = combineKt$combineInternal$2$1$1$emit$1.f7134label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        InterfaceC1361Channel<IndexedValue<Object>> interfaceC1361Channel = this.$resultChannel;
                        IndexedValue<Object> indexedValue = new IndexedValue<>(this.f7132$i, t);
                        combineKt$combineInternal$2$1$1$emit$1.f7133L$0 = SpillingKt.nullOutSpilledVariable(t);
                        combineKt$combineInternal$2$1$1$emit$1.f7134label = 1;
                        if (interfaceC1361Channel.mo7052send(indexedValue, combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return C1133Unit.INSTANCE;
                        }
                        t = (T) combineKt$combineInternal$2$1$1$emit$1.f7133L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    combineKt$combineInternal$2$1$1$emit$1.f7133L$0 = SpillingKt.nullOutSpilledVariable(t);
                    combineKt$combineInternal$2$1$1$emit$1.f7134label = 2;
                    if (C1350YieldKt.m7037yield(combineKt$combineInternal$2$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, int i, AtomicInteger atomicInteger, InterfaceC1361Channel<IndexedValue<Object>> interfaceC1361Channel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.f7129$flows = interfaceC1426FlowArr;
                this.f7130$i = i;
                this.$nonClosed = atomicInteger;
                this.$resultChannel = interfaceC1361Channel;
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            /* renamed from: create */
            public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.f7129$flows, this.f7130$i, this.$nonClosed, this.$resultChannel, continuation);
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AtomicInteger atomicInteger;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f7131label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        InterfaceC1426Flow[] interfaceC1426FlowArr = this.f7129$flows;
                        int i2 = this.f7130$i;
                        InterfaceC1426Flow interfaceC1426Flow = interfaceC1426FlowArr[i2];
                        C63541 c63541 = new C63541(this.$resultChannel, i2);
                        this.f7131label = 1;
                        if (interfaceC1426Flow.mo4308collect(c63541, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        SendChannel.close$default(this.$resultChannel, null, 1, null);
                    }
                    return C1133Unit.INSTANCE;
                } finally {
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        SendChannel.close$default(this.$resultChannel, null, 1, null);
                    }
                }
            }

            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
                return ((AnonymousClass1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15672(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super C15672> continuation) {
            super(2, continuation);
            this.f7117$flows = interfaceC1426FlowArr;
            this.$arrayFactory = function0;
            this.$transform = function3;
            this.$this_combineInternal = flowCollector;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15672 c15672 = new C15672(this.f7117$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
            c15672.f7121L$0 = obj;
            return c15672;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0119 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x012b A[LOOP:0: B:28:0x012b->B:36:0x0151, LOOP_START, PHI: r3 r14
          0x012b: PHI (r3v5 int) = (r3v4 int), (r3v6 int) binds: [B:25:0x0126, B:36:0x0151] A[DONT_GENERATE, DONT_INLINE]
          0x012b: PHI (r14v5 kotlin.collections.IndexedValue) = (r14v4 kotlin.collections.IndexedValue), (r14v11 kotlin.collections.IndexedValue) binds: [B:25:0x0126, B:36:0x0151] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.Flow<T>[]] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.flow.Flow<T>[], kotlinx.coroutines.flow.Flow[]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01d9 -> B:49:0x01dc). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int length;
            Object[] objArr;
            AtomicInteger atomicInteger;
            byte b;
            byte[] bArr;
            int i;
            InterfaceC1361Channel interfaceC1361Channel;
            byte b2;
            Object holder;
            Object[] objArr2;
            IndexedValue indexedValue;
            Object objMo19995receiveCatchingJP2dKIU;
            CoroutineScope coroutineScope = (CoroutineScope) this.f7121L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f7128label;
            int i3 = 1;
            Object obj2 = null;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                length = this.f7117$flows.length;
                if (length == 0) {
                    return C1133Unit.INSTANCE;
                }
                objArr = new Object[length];
                ArraysKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
                InterfaceC1361Channel interfaceC1361ChannelChannel$default = ChannelKt.Channel$default(length, null, null, 6, null);
                atomicInteger = new AtomicInteger(length);
                b = 0;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.f7117$flows, i5, atomicInteger, interfaceC1361ChannelChannel$default, null), 3, null);
                    i4 = i5 + 1;
                    atomicInteger = atomicInteger;
                }
                bArr = new byte[length];
                i = length;
                interfaceC1361Channel = interfaceC1361ChannelChannel$default;
                byte b3 = (byte) (b + 1);
                this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f7122L$1 = objArr;
                this.f7123L$2 = interfaceC1361Channel;
                this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                this.f7125L$4 = bArr;
                this.f7126L$5 = obj2;
                this.f7127L$6 = obj2;
                this.f7118I$0 = length;
                this.f7119I$1 = i;
                this.f7120I$2 = b3;
                this.f7128label = i3;
                objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                }
            } else if (i2 == 1) {
                ?? r2 = this.f7120I$2;
                i = this.f7119I$1;
                int i6 = this.f7118I$0;
                byte[] bArr2 = (byte[]) this.f7125L$4;
                AtomicInteger atomicInteger2 = (AtomicInteger) this.f7124L$3;
                InterfaceC1361Channel interfaceC1361Channel2 = (InterfaceC1361Channel) this.f7123L$2;
                Object[] objArr3 = (Object[]) this.f7122L$1;
                ResultKt.throwOnFailure(obj);
                holder = ((ChannelResult) obj).getHolder();
                b2 = r2;
                bArr = bArr2;
                objArr2 = objArr3;
                length = i6;
                interfaceC1361Channel = interfaceC1361Channel2;
                atomicInteger = atomicInteger2;
                indexedValue = (IndexedValue) ChannelResult.m20007getOrNullimpl(holder);
                if (indexedValue != null) {
                }
            } else if (i2 == 2) {
                ?? r22 = this.f7120I$2;
                i = this.f7119I$1;
                int i7 = this.f7118I$0;
                byte[] bArr3 = (byte[]) this.f7125L$4;
                AtomicInteger atomicInteger3 = (AtomicInteger) this.f7124L$3;
                InterfaceC1361Channel interfaceC1361Channel3 = (InterfaceC1361Channel) this.f7123L$2;
                Object[] objArr4 = (Object[]) this.f7122L$1;
                ResultKt.throwOnFailure(obj);
                objArr = objArr4;
                length = i7;
                interfaceC1361Channel = interfaceC1361Channel3;
                atomicInteger = atomicInteger3;
                b2 = r22;
                bArr = bArr3;
                b = b2;
                i3 = 1;
                obj2 = null;
                byte b32 = (byte) (b + 1);
                this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f7122L$1 = objArr;
                this.f7123L$2 = interfaceC1361Channel;
                this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                this.f7125L$4 = bArr;
                this.f7126L$5 = obj2;
                this.f7127L$6 = obj2;
                this.f7118I$0 = length;
                this.f7119I$1 = i;
                this.f7120I$2 = b32;
                this.f7128label = i3;
                objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ?? r23 = this.f7120I$2;
                i = this.f7119I$1;
                int i8 = this.f7118I$0;
                byte[] bArr4 = (byte[]) this.f7125L$4;
                AtomicInteger atomicInteger4 = (AtomicInteger) this.f7124L$3;
                InterfaceC1361Channel interfaceC1361Channel4 = (InterfaceC1361Channel) this.f7123L$2;
                Object[] objArr5 = (Object[]) this.f7122L$1;
                ResultKt.throwOnFailure(obj);
                char c = 3;
                b2 = r23;
                bArr = bArr4;
                objArr2 = objArr5;
                length = i8;
                interfaceC1361Channel = interfaceC1361Channel4;
                atomicInteger = atomicInteger4;
                b = b2;
                i3 = 1;
                obj2 = null;
                objArr = objArr2;
                byte b322 = (byte) (b + 1);
                this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f7122L$1 = objArr;
                this.f7123L$2 = interfaceC1361Channel;
                this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                this.f7125L$4 = bArr;
                this.f7126L$5 = obj2;
                this.f7127L$6 = obj2;
                this.f7118I$0 = length;
                this.f7119I$1 = i;
                this.f7120I$2 = b322;
                this.f7128label = i3;
                objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                    return coroutine_suspended;
                }
                b2 = b322;
                objArr2 = objArr;
                holder = objMo19995receiveCatchingJP2dKIU;
                indexedValue = (IndexedValue) ChannelResult.m20007getOrNullimpl(holder);
                if (indexedValue != null) {
                    return C1133Unit.INSTANCE;
                }
                while (true) {
                    int index = indexedValue.getIndex();
                    Object obj3 = objArr2[index];
                    objArr2[index] = indexedValue.getValue();
                    if (obj3 == NullSurrogateKt.UNINITIALIZED) {
                        i--;
                    }
                    if (bArr[index] == b2) {
                        break;
                    }
                    bArr[index] = b2;
                    IndexedValue indexedValue2 = (IndexedValue) ChannelResult.m20007getOrNullimpl(interfaceC1361Channel.mo19996tryReceivePtdJZtk());
                    if (indexedValue2 == null) {
                        break;
                    }
                    indexedValue = indexedValue2;
                }
                if (i != 0) {
                    objArr = objArr2;
                    b = b2;
                    i3 = 1;
                    obj2 = null;
                    byte b3222 = (byte) (b + 1);
                    this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.f7122L$1 = objArr;
                    this.f7123L$2 = interfaceC1361Channel;
                    this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                    this.f7125L$4 = bArr;
                    this.f7126L$5 = obj2;
                    this.f7127L$6 = obj2;
                    this.f7118I$0 = length;
                    this.f7119I$1 = i;
                    this.f7120I$2 = b3222;
                    this.f7128label = i3;
                    objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                    if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                    }
                } else {
                    Object[] objArr6 = (Object[]) this.$arrayFactory.mo4323invoke();
                    if (objArr6 == null) {
                        Function3 function3 = this.$transform;
                        Object obj4 = this.$this_combineInternal;
                        this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.f7122L$1 = objArr2;
                        this.f7123L$2 = interfaceC1361Channel;
                        this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.f7125L$4 = bArr;
                        this.f7126L$5 = SpillingKt.nullOutSpilledVariable(indexedValue);
                        this.f7127L$6 = SpillingKt.nullOutSpilledVariable(objArr6);
                        this.f7118I$0 = length;
                        this.f7119I$1 = i;
                        this.f7120I$2 = b2;
                        this.f7128label = 2;
                        if (function3.mo6219invoke(obj4, objArr2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objArr = objArr2;
                        b = b2;
                        i3 = 1;
                        obj2 = null;
                        byte b32222 = (byte) (b + 1);
                        this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.f7122L$1 = objArr;
                        this.f7123L$2 = interfaceC1361Channel;
                        this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.f7125L$4 = bArr;
                        this.f7126L$5 = obj2;
                        this.f7127L$6 = obj2;
                        this.f7118I$0 = length;
                        this.f7119I$1 = i;
                        this.f7120I$2 = b32222;
                        this.f7128label = i3;
                        objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                        if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                        }
                    } else {
                        ArraysKt.copyInto$default(objArr2, objArr6, 0, 0, 0, 14, (Object) null);
                        Function3 function32 = this.$transform;
                        Object obj5 = this.$this_combineInternal;
                        this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.f7122L$1 = objArr2;
                        this.f7123L$2 = interfaceC1361Channel;
                        this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.f7125L$4 = bArr;
                        this.f7126L$5 = SpillingKt.nullOutSpilledVariable(indexedValue);
                        this.f7127L$6 = SpillingKt.nullOutSpilledVariable(objArr6);
                        this.f7118I$0 = length;
                        this.f7119I$1 = i;
                        this.f7120I$2 = b2;
                        c = 3;
                        this.f7128label = 3;
                        if (function32.mo6219invoke(obj5, objArr6, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        b = b2;
                        i3 = 1;
                        obj2 = null;
                        objArr = objArr2;
                        byte b322222 = (byte) (b + 1);
                        this.f7121L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.f7122L$1 = objArr;
                        this.f7123L$2 = interfaceC1361Channel;
                        this.f7124L$3 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.f7125L$4 = bArr;
                        this.f7126L$5 = obj2;
                        this.f7127L$6 = obj2;
                        this.f7118I$0 = length;
                        this.f7119I$1 = i;
                        this.f7120I$2 = b322222;
                        this.f7128label = i3;
                        objMo19995receiveCatchingJP2dKIU = interfaceC1361Channel.mo19995receiveCatchingJP2dKIU(this);
                        if (objMo19995receiveCatchingJP2dKIU != coroutine_suspended) {
                        }
                    }
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C15672) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @PublishedApi
    public static final <R, T> Object combineInternal(FlowCollector<? super R> flowCollector, InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C1133Unit> continuation) {
        Object objFlowScope = FlowCoroutineKt.flowScope(new C15672(interfaceC1426FlowArr, function0, function3, flowCollector, null), continuation);
        return objFlowScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlowScope : C1133Unit.INSTANCE;
    }

    /* renamed from: zipImpl */
    public static final <T1, T2, R> InterfaceC1426Flow<R> m7392zipImpl(final InterfaceC1426Flow<? extends T1> interfaceC1426Flow, final InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new InterfaceC1426Flow<R>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$zipImpl$1$1(interfaceC1426Flow2, interfaceC1426Flow, flowCollector, function3, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : C1133Unit.INSTANCE;
            }
        };
    }
}
