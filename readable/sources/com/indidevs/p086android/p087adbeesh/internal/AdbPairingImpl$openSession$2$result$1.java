package com.indidevs.p086android.p087adbeesh.internal;

import com.flyfishxu.p028kadb.C0187Kadb;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.discovery.DiscoveredService;
import com.indidevs.p086android.p087adbeesh.internal.discovery.ServiceType;
import java.net.InetAddress;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "Lcom/flyfishxu/kadb/Kadb;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2$result$1", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {170}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$openSession$2$result$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,206:1\n56#2:207\n59#2:211\n45#3:208\n49#3:210\n105#4:209\n*S KotlinDebug\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$openSession$2$result$1\n*L\n167#1:207\n167#1:211\n167#1:208\n167#1:210\n167#1:209\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingImpl$openSession$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C0187Kadb>, Object> {

    /* renamed from: $client */
    final /* synthetic */ AdbClient f4092$client;

    /* renamed from: label */
    int f4093label;

    /* renamed from: this$0 */
    final /* synthetic */ AdbPairingImpl f4094this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$openSession$2$result$1(AdbPairingImpl adbPairingImpl, AdbClient adbClient, Continuation<? super AdbPairingImpl$openSession$2$result$1> continuation) {
        super(2, continuation);
        this.f4094this$0 = adbPairingImpl;
        this.f4092$client = adbClient;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new AdbPairingImpl$openSession$2$result$1(this.f4094this$0, this.f4092$client, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f4093label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final InterfaceC1426Flow<DiscoveredService> interfaceC1426FlowDiscover = this.f4094this$0.scanner.discover(ServiceType.TLS_CONNECT);
            final AdbClient adbClient = this.f4092$client;
            InterfaceC1426Flow<C0187Kadb> interfaceC1426Flow = new InterfaceC1426Flow<C0187Kadb>() { // from class: com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2$result$1$invokeSuspend$$inlined$mapNotNull$1

                @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
                @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$openSession$2$result$1\n*L\n1#1,216:1\n57#2:217\n58#2:220\n168#3,2:218\n*E\n"})
                /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2$result$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ AdbClient $client$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
                    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2$result$1$invokeSuspend$$inlined$mapNotNull$1$2", m6124f = "AdbPairingImpl.kt", m6125i = {0}, m6126l = {219, 220}, m6127m = "emit", m6128n = {"$this$mapNotNull_u24lambda_u240"}, m6130s = {"L$0"}, m6131v = 1)
                    /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2$result$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: I$0 */
                        int f4059I$0;

                        /* renamed from: L$0 */
                        Object f4060L$0;

                        /* renamed from: L$1 */
                        Object f4061L$1;

                        /* renamed from: L$2 */
                        Object f4062L$2;

                        /* renamed from: L$3 */
                        Object f4063L$3;

                        /* renamed from: L$4 */
                        Object f4064L$4;

                        /* renamed from: label */
                        int f4065label;

                        /* renamed from: result */
                        /* synthetic */ Object f4066result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f4066result = obj;
                            this.f4065label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.mo4309emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, AdbClient adbClient) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$client$inlined = adbClient;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                    /* renamed from: emit */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object mo4309emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        FlowCollector flowCollector;
                        String hostAddress;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i = anonymousClass1.f4065label;
                            if ((i & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.f4065label = i - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        }
                        Object obj2 = anonymousClass1.f4066result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i2 = anonymousClass1.f4065label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.$this_unsafeFlow;
                            DiscoveredService discoveredService = (DiscoveredService) obj;
                            InetAddress inetAddressM4319getHost = discoveredService.m4319getHost();
                            if (inetAddressM4319getHost == null || (hostAddress = inetAddressM4319getHost.getHostAddress()) == null) {
                                flowCollector = flowCollector2;
                                obj2 = null;
                            } else {
                                AdbClient adbClient = this.$client$inlined;
                                int iM4321getPort = discoveredService.m4321getPort();
                                anonymousClass1.f4060L$0 = flowCollector2;
                                anonymousClass1.f4065label = 1;
                                Object objM4312connect = adbClient.m4312connect(hostAddress, iM4321getPort, anonymousClass1);
                                if (objM4312connect == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj2 = objM4312connect;
                                flowCollector = flowCollector2;
                            }
                        } else {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                                return C1133Unit.INSTANCE;
                            }
                            FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.f4060L$0;
                            ResultKt.throwOnFailure(obj2);
                            flowCollector = flowCollector3;
                        }
                        if (obj2 != null) {
                            anonymousClass1.f4060L$0 = null;
                            anonymousClass1.f4065label = 2;
                            if (flowCollector.mo4309emit(obj2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return C1133Unit.INSTANCE;
                    }
                }

                @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
                /* renamed from: collect */
                public Object mo4308collect(FlowCollector<? super C0187Kadb> flowCollector, Continuation continuation) {
                    Object objMo4308collect = interfaceC1426FlowDiscover.mo4308collect(new AnonymousClass2(flowCollector, adbClient), continuation);
                    return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
                }
            };
            this.f4093label = 1;
            obj = C1427FlowKt.m7215first(interfaceC1426Flow, this);
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
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C0187Kadb> continuation) {
        return ((AdbPairingImpl$openSession$2$result$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
