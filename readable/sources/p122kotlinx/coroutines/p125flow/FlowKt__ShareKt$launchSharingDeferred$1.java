package p122kotlinx.coroutines.p125flow;

import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.CompletableDeferred;
import p122kotlinx.coroutines.CoroutineScope;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", m6124f = "Share.kt", m6125i = {0, 0}, m6126l = {337}, m6127m = "invokeSuspend", m6128n = {"$this$launch", "state"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $result */
    final /* synthetic */ CompletableDeferred<C1124Result<StateFlow<T>>> f6746$result;
    final /* synthetic */ InterfaceC1426Flow<T> $upstream;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6747L$0;

    /* renamed from: L$1 */
    Object f6748L$1;

    /* renamed from: label */
    int f6749label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharingDeferred$1(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CompletableDeferred<C1124Result<StateFlow<T>>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = interfaceC1426Flow;
        this.f6746$result = completableDeferred;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.f6746$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.f6747L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        C1235Ref.ObjectRef objectRef;
        final CoroutineScope coroutineScope = (CoroutineScope) this.f6747L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6749label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
                InterfaceC1426Flow<T> interfaceC1426Flow = this.$upstream;
                final CompletableDeferred<C1124Result<StateFlow<T>>> completableDeferred = this.f6746$result;
                FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1.1
                    /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
                    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                    /* renamed from: emit */
                    public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
                        C1235Ref.ObjectRef<MutableStateFlow<T>> objectRef3 = objectRef2;
                        MutableStateFlow<T> mutableStateFlow = objectRef3.f5202element;
                        if (mutableStateFlow != null) {
                            mutableStateFlow.setValue(t);
                        } else {
                            CoroutineScope coroutineScope2 = coroutineScope;
                            CompletableDeferred<C1124Result<StateFlow<T>>> completableDeferred2 = completableDeferred;
                            ?? r3 = (T) StateFlowKt.MutableStateFlow(t);
                            C1124Result.Companion companion = C1124Result.INSTANCE;
                            completableDeferred2.complete(C1124Result.m18545boximpl(C1124Result.m18546constructorimpl(new ReadonlyStateFlow(r3, C1344JobKt.m7015getJob(coroutineScope2.getCoroutineContext())))));
                            objectRef3.f5202element = r3;
                        }
                        return C1133Unit.INSTANCE;
                    }
                };
                this.f6747L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f6748L$1 = objectRef2;
                this.f6749label = 1;
                if (interfaceC1426Flow.mo4308collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (C1235Ref.ObjectRef) this.f6748L$1;
                ResultKt.throwOnFailure(obj);
            }
            if (objectRef.f5202element == 0) {
                CompletableDeferred<C1124Result<StateFlow<T>>> completableDeferred2 = this.f6746$result;
                C1124Result.Companion companion = C1124Result.INSTANCE;
                completableDeferred2.complete(C1124Result.m18545boximpl(C1124Result.m18546constructorimpl(ResultKt.createFailure(new NoSuchElementException("Flow is empty")))));
            }
            return C1133Unit.INSTANCE;
        } catch (Throwable th) {
            this.f6746$result.completeExceptionally(th);
            throw th;
        }
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
