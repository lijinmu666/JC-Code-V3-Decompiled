package com.indidevs.p086android.p087adbeesh.internal;

import android.util.Log;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbAuthenticationException;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbException;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbTimeoutException;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.discovery.DiscoveredService;
import com.indidevs.p086android.p087adbeesh.internal.discovery.ServiceType;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingStatus;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingWorkflow;
import java.net.InetAddress;
import java.util.concurrent.CancellationException;
import org.bouncycastle.p284math.AbstractC5816Primes;
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
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.TimeoutKt;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.SharedFlow;
import p122kotlinx.coroutines.p125flow.SharingStarted;
import p122kotlinx.coroutines.p129sync.InterfaceC1592Mutex;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1$1$1", m6124f = "AdbPairingImpl.kt", m6125i = {0, 0, 1, 1, 3}, m6126l = {104, 119, 129, AbstractC5816Primes.SMALL_FACTOR_LIMIT}, m6127m = "invokeSuspend", m6128n = {"$this$supervisorScope", "discoveryFlow", "latestService", "discoveryJob", "$this$withLock_u24default$iv"}, m6130s = {"L$0", "L$1", "L$0", "L$1", "L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$ensurePaired$task$1$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,206:1\n117#2,10:207\n*S KotlinDebug\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$ensurePaired$task$1$1$1\n*L\n134#1:207,10\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingImpl$ensurePaired$task$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $client */
    final /* synthetic */ AdbClient f4076$client;
    final /* synthetic */ AdbPairingWorkflow $workflow;

    /* renamed from: L$0 */
    private /* synthetic */ Object f4077L$0;

    /* renamed from: L$1 */
    Object f4078L$1;

    /* renamed from: L$2 */
    Object f4079L$2;

    /* renamed from: label */
    int f4080label;

    /* renamed from: this$0 */
    final /* synthetic */ AdbPairingImpl f4081this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$ensurePaired$task$1$1$1(AdbPairingImpl adbPairingImpl, AdbPairingWorkflow adbPairingWorkflow, AdbClient adbClient, Continuation<? super AdbPairingImpl$ensurePaired$task$1$1$1> continuation) {
        super(2, continuation);
        this.f4081this$0 = adbPairingImpl;
        this.$workflow = adbPairingWorkflow;
        this.f4076$client = adbClient;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        AdbPairingImpl$ensurePaired$task$1$1$1 adbPairingImpl$ensurePaired$task$1$1$1 = new AdbPairingImpl$ensurePaired$task$1$1$1(this.f4081this$0, this.$workflow, this.f4076$client, continuation);
        adbPairingImpl$ensurePaired$task$1$1$1.f4077L$0 = obj;
        return adbPairingImpl$ensurePaired$task$1$1$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d2  */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, com.indidevs.android.adbeesh.internal.discovery.DiscoveredService] */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws AdbException {
        CoroutineScope coroutineScope;
        SharedFlow sharedFlowM7245shareIn;
        Object objWithTimeoutOrNull;
        Object objProvideCode;
        C1235Ref.ObjectRef objectRef;
        InterfaceC1342Job interfaceC1342Job;
        String str;
        String hostAddress;
        Object objWithTimeoutOrNull2;
        Boolean bool;
        InterfaceC1592Mutex interfaceC1592Mutex;
        AdbPairingImpl adbPairingImpl;
        AdbPairingWorkflow adbPairingWorkflow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f4080label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.f4077L$0;
            sharedFlowM7245shareIn = C1427FlowKt.m7245shareIn(this.f4081this$0.scanner.discover(ServiceType.TLS_PAIRING), coroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), 1);
            long handshakeTimeoutMs = this.f4081this$0.config.getHandshakeTimeoutMs();
            AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1 adbPairingImpl$ensurePaired$task$1$1$1$firstService$1 = new AdbPairingImpl$ensurePaired$task$1$1$1$firstService$1(sharedFlowM7245shareIn, null);
            this.f4077L$0 = coroutineScope;
            this.f4078L$1 = sharedFlowM7245shareIn;
            this.f4080label = 1;
            objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(handshakeTimeoutMs, adbPairingImpl$ensurePaired$task$1$1$1$firstService$1, this);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            sharedFlowM7245shareIn = (SharedFlow) this.f4078L$1;
            coroutineScope = (CoroutineScope) this.f4077L$0;
            ResultKt.throwOnFailure(obj);
            objWithTimeoutOrNull = obj;
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    adbPairingWorkflow = (AdbPairingWorkflow) this.f4079L$2;
                    AdbPairingImpl adbPairingImpl2 = (AdbPairingImpl) this.f4078L$1;
                    InterfaceC1592Mutex interfaceC1592Mutex2 = (InterfaceC1592Mutex) this.f4077L$0;
                    ResultKt.throwOnFailure(obj);
                    adbPairingImpl = adbPairingImpl2;
                    interfaceC1592Mutex = interfaceC1592Mutex2;
                    try {
                        adbPairingImpl._status.setValue(AdbPairingStatus.f4192PAIRED);
                        adbPairingWorkflow.onPairingSuccess(adbPairingImpl.getId());
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        interfaceC1592Mutex.mo7494unlock(null);
                        return C1133Unit.INSTANCE;
                    } catch (Throwable th) {
                        interfaceC1592Mutex.mo7494unlock(null);
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(obj);
                objWithTimeoutOrNull2 = obj;
                bool = (Boolean) objWithTimeoutOrNull2;
                if (bool != null) {
                    throw new AdbTimeoutException("Pairing timed out during handshake");
                }
                if (!bool.booleanValue()) {
                    this.f4081this$0._status.setValue(AdbPairingStatus.f4190ERROR);
                    this.$workflow.onPairingError(this.f4081this$0.getId(), "Rejected by device");
                    throw new AdbAuthenticationException("Pairing failed", null, 2, null);
                }
                interfaceC1592Mutex = this.f4081this$0.pairingMutex;
                adbPairingImpl = this.f4081this$0;
                AdbPairingWorkflow adbPairingWorkflow2 = this.$workflow;
                this.f4077L$0 = interfaceC1592Mutex;
                this.f4078L$1 = adbPairingImpl;
                this.f4079L$2 = adbPairingWorkflow2;
                this.f4080label = 4;
                if (interfaceC1592Mutex.mo7492lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                adbPairingWorkflow = adbPairingWorkflow2;
                adbPairingImpl._status.setValue(AdbPairingStatus.f4192PAIRED);
                adbPairingWorkflow.onPairingSuccess(adbPairingImpl.getId());
                C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                interfaceC1592Mutex.mo7494unlock(null);
                return C1133Unit.INSTANCE;
            }
            interfaceC1342Job = (InterfaceC1342Job) this.f4078L$1;
            C1235Ref.ObjectRef objectRef2 = (C1235Ref.ObjectRef) this.f4077L$0;
            ResultKt.throwOnFailure(obj);
            objProvideCode = obj;
            objectRef = objectRef2;
            str = (String) objProvideCode;
            if (str != null) {
                throw new AdbException("Pairing cancelled by user", null, 2, null);
            }
            InterfaceC1342Job.cancel$default(interfaceC1342Job, (CancellationException) null, 1, (Object) null);
            Log.d("ADBeesh:Pairing", '[' + this.f4081this$0.getId() + "] Code received, handshaking...");
            this.f4081this$0._status.setValue(AdbPairingStatus.f4193PAIRING);
            this.$workflow.onPairingHandshakeStarted(this.f4081this$0.getId());
            InetAddress inetAddressM4319getHost = ((DiscoveredService) objectRef.f5202element).m4319getHost();
            if (inetAddressM4319getHost == null || (hostAddress = inetAddressM4319getHost.getHostAddress()) == null) {
                hostAddress = "127.0.0.1";
            }
            String str2 = hostAddress;
            long handshakeTimeoutMs2 = this.f4081this$0.config.getHandshakeTimeoutMs();
            AdbPairingImpl$ensurePaired$task$1$1$1$success$1 adbPairingImpl$ensurePaired$task$1$1$1$success$1 = new AdbPairingImpl$ensurePaired$task$1$1$1$success$1(this.f4076$client, str2, objectRef, str, null);
            this.f4077L$0 = null;
            this.f4078L$1 = null;
            this.f4080label = 3;
            objWithTimeoutOrNull2 = TimeoutKt.withTimeoutOrNull(handshakeTimeoutMs2, adbPairingImpl$ensurePaired$task$1$1$1$success$1, this);
            if (objWithTimeoutOrNull2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bool = (Boolean) objWithTimeoutOrNull2;
            if (bool != null) {
            }
        }
        SharedFlow sharedFlow = sharedFlowM7245shareIn;
        ?? r9 = (DiscoveredService) objWithTimeoutOrNull;
        if (r9 == 0) {
            throw new AdbTimeoutException("Pairing timed out: No device found");
        }
        C1235Ref.ObjectRef objectRef3 = new C1235Ref.ObjectRef();
        objectRef3.f5202element = r9;
        this.f4081this$0._status.setValue(AdbPairingStatus.AWAITING_CODE);
        this.$workflow.onPortFound(this.f4081this$0.getId(), r9.m4321getPort());
        InterfaceC1342Job interfaceC1342JobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AdbPairingImpl$ensurePaired$task$1$1$1$discoveryJob$1(sharedFlow, objectRef3, this.$workflow, this.f4081this$0, null), 3, null);
        AdbPairingWorkflow adbPairingWorkflow3 = this.$workflow;
        String id = this.f4081this$0.getId();
        int iM4321getPort = ((DiscoveredService) objectRef3.f5202element).m4321getPort();
        this.f4077L$0 = objectRef3;
        this.f4078L$1 = interfaceC1342JobLaunch$default;
        this.f4080label = 2;
        objProvideCode = adbPairingWorkflow3.provideCode(id, iM4321getPort, this);
        if (objProvideCode == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef = objectRef3;
        interfaceC1342Job = interfaceC1342JobLaunch$default;
        str = (String) objProvideCode;
        if (str != null) {
        }
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((AdbPairingImpl$ensurePaired$task$1$1$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
