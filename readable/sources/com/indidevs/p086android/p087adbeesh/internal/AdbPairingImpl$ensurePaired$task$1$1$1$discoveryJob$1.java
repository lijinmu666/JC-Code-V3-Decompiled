package com.indidevs.p086android.p087adbeesh.internal;

import com.indidevs.p086android.p087adbeesh.internal.discovery.DiscoveredService;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingWorkflow;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.SharedFlow;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {113}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
/* loaded from: classes.dex */
public final class AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ SharedFlow<DiscoveredService> $discoveryFlow;
    final /* synthetic */ C1235Ref.ObjectRef<DiscoveredService> $latestService;
    final /* synthetic */ AdbPairingWorkflow $workflow;

    /* renamed from: label */
    int f4082label;

    /* renamed from: this$0 */
    final /* synthetic */ AdbPairingImpl f4083this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1(SharedFlow<DiscoveredService> sharedFlow, C1235Ref.ObjectRef<DiscoveredService> objectRef, AdbPairingWorkflow adbPairingWorkflow, AdbPairingImpl adbPairingImpl, Continuation<? super AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1> continuation) {
        super(2, continuation);
        this.$discoveryFlow = sharedFlow;
        this.$latestService = objectRef;
        this.$workflow = adbPairingWorkflow;
        this.f4083this$0 = adbPairingImpl;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1(this.$discoveryFlow, this.$latestService, this.$workflow, this.f4083this$0, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f4082label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<DiscoveredService> sharedFlow = this.$discoveryFlow;
            final C1235Ref.ObjectRef<DiscoveredService> objectRef = this.$latestService;
            final AdbPairingWorkflow adbPairingWorkflow = this.$workflow;
            final AdbPairingImpl adbPairingImpl = this.f4083this$0;
            FlowCollector<? super DiscoveredService> flowCollector = new FlowCollector() { // from class: com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1.1
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public /* bridge */ /* synthetic */ Object mo4309emit(Object obj2, Continuation continuation) {
                    return m4310emit((DiscoveredService) obj2, (Continuation<? super C1133Unit>) continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: emit */
                public final Object m4310emit(DiscoveredService discoveredService, Continuation<? super C1133Unit> continuation) {
                    objectRef.f5202element = discoveredService;
                    adbPairingWorkflow.onPortFound(adbPairingImpl.getId(), discoveredService.m4321getPort());
                    return C1133Unit.INSTANCE;
                }
            };
            this.f4082label = 1;
            if (sharedFlow.mo4308collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
