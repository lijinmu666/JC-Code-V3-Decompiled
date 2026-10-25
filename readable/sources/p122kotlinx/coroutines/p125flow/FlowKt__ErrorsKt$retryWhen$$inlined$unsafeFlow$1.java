package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,111:1\n129#2,15:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_retryWhen$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", m6124f = "Errors.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {116, 118}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$retryWhen_u24lambda_u240", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1", "attempt", "shallRetry", "collector", "$completion", "$this$retryWhen_u24lambda_u240", "cause", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$retryWhen$1", "attempt", "shallRetry"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "J$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "J$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 */
    public static final class C14761 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6477I$0;

        /* renamed from: I$1 */
        int f6478I$1;

        /* renamed from: J$0 */
        long f6479J$0;

        /* renamed from: L$0 */
        Object f6480L$0;

        /* renamed from: L$1 */
        Object f6481L$1;

        /* renamed from: L$2 */
        Object f6482L$2;

        /* renamed from: L$3 */
        Object f6483L$3;

        /* renamed from: label */
        int f6484label;

        /* renamed from: result */
        /* synthetic */ Object f6485result;

        public C14761(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6485result = obj;
            this.f6484label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, Function4 function4) {
        this.$this_retryWhen$inlined = interfaceC1426Flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d0 -> B:27:0x00d3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e6 -> B:30:0x00e2). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) throws Throwable {
        C14761 c14761;
        FlowCollector<? super T> flowCollector2;
        C14761 c147612;
        int i;
        long j;
        Object obj;
        FlowCollector<? super T> flowCollector3;
        FlowCollector<? super T> flowCollector4;
        Object obj2;
        FlowCollector<? super T> flowCollector5;
        int i2;
        int i3;
        Throwable th;
        Object objCatchImpl;
        if (continuation instanceof C14761) {
            c14761 = (C14761) continuation;
            int i4 = c14761.f6484label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14761.f6484label = i4 - Integer.MIN_VALUE;
            } else {
                c14761 = new C14761(continuation);
            }
        }
        Object obj3 = c14761.f6485result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14761.f6484label;
        int i6 = 0;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj3);
            flowCollector2 = flowCollector;
            c147612 = c14761;
            i = 0;
            j = 0;
            obj = c147612;
            flowCollector3 = flowCollector2;
            InterfaceC1426Flow interfaceC1426Flow = this.$this_retryWhen$inlined;
            c147612.f6480L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            c147612.f6481L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c147612.f6482L$2 = flowCollector2;
            c147612.f6483L$3 = null;
            c147612.f6477I$0 = i;
            c147612.f6479J$0 = j;
            c147612.f6478I$1 = i6;
            c147612.f6484label = 1;
            objCatchImpl = C1427FlowKt.catchImpl(interfaceC1426Flow, flowCollector2, c147612);
            if (objCatchImpl != coroutine_suspended) {
            }
        } else if (i5 == 1) {
            int i7 = c14761.f6478I$1;
            long j2 = c14761.f6479J$0;
            int i8 = c14761.f6477I$0;
            flowCollector5 = (FlowCollector) c14761.f6482L$2;
            obj2 = (Continuation) c14761.f6481L$1;
            flowCollector4 = (FlowCollector) c14761.f6480L$0;
            ResultKt.throwOnFailure(obj3);
            i2 = i7;
            i3 = i8;
            j = j2;
            th = (Throwable) obj3;
            if (th == null) {
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c14761.f6479J$0;
            i3 = c14761.f6477I$0;
            Throwable th2 = (Throwable) c14761.f6483L$3;
            flowCollector5 = (FlowCollector) c14761.f6482L$2;
            obj2 = (Continuation) c14761.f6481L$1;
            flowCollector4 = (FlowCollector) c14761.f6480L$0;
            ResultKt.throwOnFailure(obj3);
            if (!((Boolean) obj3).booleanValue()) {
                j = j3 + 1;
                flowCollector2 = flowCollector5;
                i = i3;
                i2 = 1;
                c147612 = c14761;
                flowCollector3 = flowCollector4;
                if (i2 != 0) {
                    return C1133Unit.INSTANCE;
                }
                obj = obj2;
                i6 = 0;
                InterfaceC1426Flow interfaceC1426Flow2 = this.$this_retryWhen$inlined;
                c147612.f6480L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                c147612.f6481L$1 = SpillingKt.nullOutSpilledVariable(obj);
                c147612.f6482L$2 = flowCollector2;
                c147612.f6483L$3 = null;
                c147612.f6477I$0 = i;
                c147612.f6479J$0 = j;
                c147612.f6478I$1 = i6;
                c147612.f6484label = 1;
                objCatchImpl = C1427FlowKt.catchImpl(interfaceC1426Flow2, flowCollector2, c147612);
                if (objCatchImpl != coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector4 = flowCollector3;
                c14761 = c147612;
                i3 = i;
                flowCollector5 = flowCollector2;
                obj3 = objCatchImpl;
                obj2 = obj;
                i2 = i6;
                th = (Throwable) obj3;
                if (th == null) {
                    Function4 function4 = this.$predicate$inlined;
                    Long lM6122boxLong = C1207Boxing.m6122boxLong(j);
                    c14761.f6480L$0 = SpillingKt.nullOutSpilledVariable(flowCollector4);
                    c14761.f6481L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                    c14761.f6482L$2 = flowCollector5;
                    c14761.f6483L$3 = th;
                    c14761.f6477I$0 = i3;
                    c14761.f6479J$0 = j;
                    c14761.f6478I$1 = i2;
                    c14761.f6484label = 2;
                    InlineMarker.m6315mark(6);
                    Object objMo6276invoke = function4.mo6276invoke(flowCollector5, th, lM6122boxLong, c14761);
                    InlineMarker.m6315mark(7);
                    if (objMo6276invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = j;
                    th2 = th;
                    obj3 = objMo6276invoke;
                    if (!((Boolean) obj3).booleanValue()) {
                        throw th2;
                    }
                } else {
                    flowCollector2 = flowCollector5;
                    i = i3;
                    c147612 = c14761;
                    flowCollector3 = flowCollector4;
                    if (i2 != 0) {
                    }
                }
            }
        }
    }
}
