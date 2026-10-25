package com.indidevs.p086android.p087adbeesh.internal.discovery;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.flyfishxu.p028kadb.p032mdns.KadbMdnsAndroid;
import com.flyfishxu.p028kadb.p032mdns.MdnsConfig;
import com.flyfishxu.p028kadb.p032mdns.MdnsDiscoveryState;
import com.flyfishxu.p028kadb.p032mdns.MdnsEndpoint;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.ProduceKt;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;
import p122kotlinx.coroutines.p125flow.StateFlow;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\b*\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/discovery/Scanner;", BuildConfig.f24315FLAVOR, "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "discover", "Lkotlinx/coroutines/flow/Flow;", "Lcom/indidevs/android/adbeesh/internal/discovery/DiscoveredService;", "type", "Lcom/indidevs/android/adbeesh/internal/discovery/ServiceType;", "toDiscoveredService", "Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* renamed from: com.indidevs.android.adbeesh.internal.discovery.Scanner */
/* loaded from: classes.dex */
public final class C0896Scanner {

    /* renamed from: TAG */
    private static final String f4123TAG = "ADBeesh:Scanner";
    private final Context context;

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/indidevs/android/adbeesh/internal/discovery/DiscoveredService;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1", m6124f = "Scanner.kt", m6125i = {}, m6126l = {88}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scanner.kt\ncom/indidevs/android/adbeesh/internal/discovery/Scanner$discover$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,114:1\n49#2:115\n51#2:119\n45#3:116\n49#3:118\n105#4:117\n*S KotlinDebug\n*F\n+ 1 Scanner.kt\ncom/indidevs/android/adbeesh/internal/discovery/Scanner$discover$1\n*L\n67#1:115\n67#1:119\n67#1:116\n67#1:118\n67#1:117\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super DiscoveredService>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $type */
        final /* synthetic */ ServiceType f4134$type;

        /* renamed from: L$0 */
        private /* synthetic */ Object f4135L$0;

        /* renamed from: label */
        int f4136label;

        /* renamed from: this$0 */
        final /* synthetic */ C0896Scanner f4137this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServiceType serviceType, C0896Scanner c0896Scanner, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f4134$type = serviceType;
            this.f4137this$0 = c0896Scanner;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4134$type, this.f4137this$0, continuation);
            anonymousClass1.f4135L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference failed for: r3v11, types: [T, java.util.Set] */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f4136label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.f4135L$0;
                Log.i(C0896Scanner.f4123TAG, "Initiating discovery for protocol: " + this.f4134$type.getProtocol());
                Object systemService = this.f4137this$0.context.getApplicationContext().getSystemService("wifi");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                final WifiManager.MulticastLock multicastLockCreateMulticastLock = ((WifiManager) systemService).createMulticastLock("adbeesh_discovery_lock");
                multicastLockCreateMulticastLock.setReferenceCounted(false);
                multicastLockCreateMulticastLock.acquire();
                MdnsConfig mdnsConfig = new MdnsConfig(C1159SetsKt.m5992setOf(this.f4134$type.toMdnsServiceType()), false, 2, null);
                Context applicationContext = this.f4137this$0.context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                final KadbMdnsAndroid kadbMdnsAndroid = new KadbMdnsAndroid(applicationContext, mdnsConfig);
                C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
                objectRef.f5202element = C1159SetsKt.emptySet();
                final StateFlow<MdnsDiscoveryState> state = kadbMdnsAndroid.getState();
                final ServiceType serviceType = this.f4134$type;
                final InterfaceC1342Job interfaceC1342JobLaunchIn = C1427FlowKt.launchIn(C1427FlowKt.m7234onEach(C1427FlowKt.distinctUntilChanged(new InterfaceC1426Flow<Set<? extends MdnsEndpoint>>() { // from class: com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1$invokeSuspend$$inlined$map$1

                    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
                    @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Scanner.kt\ncom/indidevs/android/adbeesh/internal/discovery/Scanner$discover$1\n*L\n1#1,216:1\n50#2:217\n69#3,6:218\n*E\n"})
                    /* renamed from: com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1$invokeSuspend$$inlined$map$1$2 */
                    public static final class C08972<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ ServiceType $type$inlined;

                        @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
                        @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1$invokeSuspend$$inlined$map$1$2", m6124f = "Scanner.kt", m6125i = {}, m6126l = {217}, m6127m = "emit", m6128n = {}, m6130s = {}, m6131v = 1)
                        /* renamed from: com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {

                            /* renamed from: I$0 */
                            int f4125I$0;

                            /* renamed from: L$0 */
                            Object f4126L$0;

                            /* renamed from: L$1 */
                            Object f4127L$1;

                            /* renamed from: L$2 */
                            Object f4128L$2;

                            /* renamed from: L$3 */
                            Object f4129L$3;

                            /* renamed from: L$4 */
                            Object f4130L$4;

                            /* renamed from: label */
                            int f4131label;

                            /* renamed from: result */
                            /* synthetic */ Object f4132result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.f4132result = obj;
                                this.f4131label |= Integer.MIN_VALUE;
                                return C08972.this.mo4309emit(null, this);
                            }
                        }

                        public C08972(FlowCollector flowCollector, ServiceType serviceType) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$type$inlined = serviceType;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                        /* renamed from: emit */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object mo4309emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.f4131label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.f4131label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            }
                            Object obj2 = anonymousClass1.f4132result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.f4131label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                MdnsDiscoveryState mdnsDiscoveryState = (MdnsDiscoveryState) obj;
                                Set set = CollectionsKt.m5900toSet(this.$type$inlined == ServiceType.TLS_PAIRING ? mdnsDiscoveryState.getPairDevices() : mdnsDiscoveryState.getConnectDevices());
                                anonymousClass1.f4131label = 1;
                                if (flowCollector.mo4309emit(set, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return C1133Unit.INSTANCE;
                        }
                    }

                    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
                    /* renamed from: collect */
                    public Object mo4308collect(FlowCollector<? super Set<? extends MdnsEndpoint>> flowCollector, Continuation continuation) {
                        Object objMo4308collect = state.mo4308collect(new C08972(flowCollector, serviceType), continuation);
                        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
                    }
                }), new Scanner$discover$1$job$2(objectRef, producerScope, this.f4137this$0, this.f4134$type, null)), producerScope);
                kadbMdnsAndroid.mo2228start();
                final ServiceType serviceType2 = this.f4134$type;
                Function0<C1133Unit> function0 = new Function0<C1133Unit>() { // from class: com.indidevs.android.adbeesh.internal.discovery.Scanner.discover.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ C1133Unit mo4323invoke() {
                        invoke2();
                        return C1133Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Log.i(C0896Scanner.f4123TAG, "Stopping discovery for protocol: " + serviceType2.getProtocol());
                        InterfaceC1342Job.cancel$default(interfaceC1342JobLaunchIn, (CancellationException) null, 1, (Object) null);
                        kadbMdnsAndroid.mo2229stop();
                        kadbMdnsAndroid.close();
                        multicastLockCreateMulticastLock.release();
                    }
                };
                this.f4136label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super DiscoveredService> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((AnonymousClass1) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public C0896Scanner(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscoveredService toDiscoveredService(MdnsEndpoint mdnsEndpoint, ServiceType serviceType) throws UnknownHostException {
        InetAddress byName;
        String strM2245getName = mdnsEndpoint.m2245getName();
        try {
            byName = InetAddress.getByName(mdnsEndpoint.m2244getHost());
        } catch (Exception unused) {
            byName = null;
        }
        return new DiscoveredService(strM2245getName, byName, mdnsEndpoint.m2246getPort(), serviceType);
    }

    public final InterfaceC1426Flow<DiscoveredService> discover(ServiceType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return C1427FlowKt.m7222flowOn(C1427FlowKt.callbackFlow(new AnonymousClass1(type, this, null)), Dispatchers.m6975getIO());
    }
}
