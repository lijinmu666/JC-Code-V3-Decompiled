package com.indidevs.p086android.p087adbeesh.internal;

import com.indidevs.p086android.p087adbeesh.internal.discovery.DiscoveredService;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.SharedFlow;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "Lcom/indidevs/android/adbeesh/internal/discovery/DiscoveredService;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {105}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
/* loaded from: classes.dex */
public final class AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DiscoveredService>, Object> {
    final /* synthetic */ SharedFlow<DiscoveredService> $discoveryFlow;

    /* renamed from: label */
    int f4085label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1(SharedFlow<DiscoveredService> sharedFlow, Continuation<? super AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1> continuation) {
        super(2, continuation);
        this.$discoveryFlow = sharedFlow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1(this.$discoveryFlow, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f4085label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<DiscoveredService> sharedFlow = this.$discoveryFlow;
            this.f4085label = 1;
            obj = C1427FlowKt.m7215first(sharedFlow, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super DiscoveredService> continuation) {
        return ((AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
