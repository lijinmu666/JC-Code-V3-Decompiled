package com.indidevs.p086android.p087adbeesh.internal;

import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.discovery.DiscoveredService;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p122kotlinx.coroutines.CoroutineScope;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1$1$1$success$1", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {130}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
/* loaded from: classes.dex */
public final class AdbPairingImpl$ensurePaired$task$1$1$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: $client */
    final /* synthetic */ AdbClient f4086$client;

    /* renamed from: $code */
    final /* synthetic */ String f4087$code;

    /* renamed from: $host */
    final /* synthetic */ String f4088$host;
    final /* synthetic */ C1235Ref.ObjectRef<DiscoveredService> $latestService;

    /* renamed from: label */
    int f4089label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$ensurePaired$task$1$1$1$success$1(AdbClient adbClient, String str, C1235Ref.ObjectRef<DiscoveredService> objectRef, String str2, Continuation<? super AdbPairingImpl$ensurePaired$task$1$1$1$success$1> continuation) {
        super(2, continuation);
        this.f4086$client = adbClient;
        this.f4088$host = str;
        this.$latestService = objectRef;
        this.f4087$code = str2;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new AdbPairingImpl$ensurePaired$task$1$1$1$success$1(this.f4086$client, this.f4088$host, this.$latestService, this.f4087$code, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f4089label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AdbClient adbClient = this.f4086$client;
            String str = this.f4088$host;
            int iM4321getPort = this.$latestService.f5202element.m4321getPort();
            String str2 = this.f4087$code;
            this.f4089label = 1;
            obj = adbClient.m4313pair(str, iM4321getPort, str2, this);
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
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AdbPairingImpl$ensurePaired$task$1$1$1$success$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
