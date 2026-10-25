package com.indidevs.p086android.p087adbeesh.internal;

import android.content.Context;
import android.util.Log;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.security.KeyPair;
import com.indidevs.p086android.p087adbeesh.p088config.AdbSessionConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingStatus;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingWorkflow;
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
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.SupervisorKt;
import p122kotlinx.coroutines.p129sync.InterfaceC1592Mutex;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$ensurePaired$task$1", m6124f = "AdbPairingImpl.kt", m6125i = {0, 0, 1, 1, 2}, m6126l = {AbstractC5816Primes.SMALL_FACTOR_LIMIT, 85, 100}, m6127m = "invokeSuspend", m6128n = {"$this$async", "$this$withLock_u24default$iv", "$this$async", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m6130s = {"L$0", "L$1", "L$0", "L$1", "L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$ensurePaired$task$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,206:1\n117#2,10:207\n*S KotlinDebug\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$ensurePaired$task$1\n*L\n84#1:207,10\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingImpl$ensurePaired$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ AdbPairingWorkflow $workflow;

    /* renamed from: L$0 */
    private /* synthetic */ Object f4070L$0;

    /* renamed from: L$1 */
    Object f4071L$1;

    /* renamed from: L$2 */
    Object f4072L$2;

    /* renamed from: L$3 */
    Object f4073L$3;

    /* renamed from: label */
    int f4074label;

    /* renamed from: this$0 */
    final /* synthetic */ AdbPairingImpl f4075this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbPairingImpl$ensurePaired$task$1(AdbPairingImpl adbPairingImpl, AdbPairingWorkflow adbPairingWorkflow, Continuation<? super AdbPairingImpl$ensurePaired$task$1> continuation) {
        super(2, continuation);
        this.f4075this$0 = adbPairingImpl;
        this.$workflow = adbPairingWorkflow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        AdbPairingImpl$ensurePaired$task$1 adbPairingImpl$ensurePaired$task$1 = new AdbPairingImpl$ensurePaired$task$1(this.f4075this$0, this.$workflow, continuation);
        adbPairingImpl$ensurePaired$task$1.f4070L$0 = obj;
        return adbPairingImpl$ensurePaired$task$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[Catch: all -> 0x0048, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0048, blocks: (B:19:0x0044, B:34:0x00a1, B:37:0x00c2), top: B:69:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2 A[Catch: all -> 0x0048, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0048, blocks: (B:19:0x0044, B:34:0x00a1, B:37:0x00c2), top: B:69:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0164  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC1592Mutex interfaceC1592Mutex;
        Throwable th;
        CoroutineScope coroutineScope;
        AdbPairingImpl adbPairingImpl;
        InterfaceC1592Mutex interfaceC1592Mutex2;
        AdbPairingWorkflow adbPairingWorkflow;
        CoroutineScope coroutineScope2;
        AdbPairingImpl adbPairingImpl2;
        InterfaceC1592Mutex interfaceC1592Mutex3;
        AdbPairingWorkflow adbPairingWorkflow2;
        AdbPairingImpl adbPairingImpl3;
        InterfaceC1592Mutex interfaceC1592Mutex4;
        String message;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        AdbPairingImpl adbPairingImpl4 = this.f4074label;
        try {
            try {
            } catch (Throwable th2) {
                interfaceC1592Mutex = this;
                th = th2;
            }
            try {
                if (adbPairingImpl4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.f4070L$0;
                    InterfaceC1592Mutex interfaceC1592Mutex5 = this.f4075this$0.workflowMutex;
                    AdbPairingImpl adbPairingImpl5 = this.f4075this$0;
                    AdbPairingWorkflow adbPairingWorkflow3 = this.$workflow;
                    this.f4070L$0 = coroutineScope;
                    this.f4071L$1 = interfaceC1592Mutex5;
                    this.f4072L$2 = adbPairingImpl5;
                    this.f4073L$3 = adbPairingWorkflow3;
                    this.f4074label = 1;
                    if (interfaceC1592Mutex5.mo7492lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    adbPairingImpl = adbPairingImpl5;
                    interfaceC1592Mutex2 = interfaceC1592Mutex5;
                    adbPairingWorkflow = adbPairingWorkflow3;
                } else {
                    if (adbPairingImpl4 != 1) {
                        if (adbPairingImpl4 != 2) {
                            if (adbPairingImpl4 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            adbPairingWorkflow2 = (AdbPairingWorkflow) this.f4072L$2;
                            adbPairingImpl3 = (AdbPairingImpl) this.f4071L$1;
                            interfaceC1592Mutex4 = (InterfaceC1592Mutex) this.f4070L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                adbPairingImpl3.pairingJob = null;
                                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                                interfaceC1592Mutex4.mo7494unlock(null);
                                return C1133Unit.INSTANCE;
                            } catch (CancellationException e) {
                                e = e;
                                adbPairingImpl3._status.setValue(AdbPairingStatus.f4191IDLE);
                                throw e;
                            } catch (Exception e2) {
                                e = e2;
                                adbPairingImpl3._status.setValue(AdbPairingStatus.f4190ERROR);
                                String id = adbPairingImpl3.getId();
                                message = e.getMessage();
                                if (message == null) {
                                }
                                adbPairingWorkflow2.onPairingError(id, message);
                                throw e;
                            }
                        }
                        adbPairingWorkflow = (AdbPairingWorkflow) this.f4073L$3;
                        adbPairingImpl2 = (AdbPairingImpl) this.f4072L$2;
                        interfaceC1592Mutex = (InterfaceC1592Mutex) this.f4071L$1;
                        coroutineScope2 = (CoroutineScope) this.f4070L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            interfaceC1592Mutex3 = interfaceC1592Mutex;
                            if (obj == null) {
                                Log.d("ADBeesh:Pairing", '[' + adbPairingImpl2.getId() + "] Identity already exists, skipping workflow");
                                C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                                interfaceC1592Mutex3.mo7494unlock(null);
                                return c1133Unit2;
                            }
                            adbPairingImpl2.pairingJob = (InterfaceC1342Job) coroutineScope2.getCoroutineContext().mo6098get(InterfaceC1342Job.INSTANCE);
                            try {
                                KeyPair orCreateKeyPair = adbPairingImpl2.getOrCreateKeyPair();
                                AdbSessionConfig adbSessionConfig = adbPairingImpl2.config;
                                Context context = adbPairingImpl2.appContext;
                                Intrinsics.checkNotNullExpressionValue(context, "access$getAppContext$p(...)");
                                String deviceName = adbSessionConfig.resolve$adbeesh(context).getDeviceName();
                                Intrinsics.checkNotNull(deviceName);
                                AdbClient adbClient = new AdbClient(orCreateKeyPair, deviceName);
                                adbPairingImpl2._status.setValue(AdbPairingStatus.DISCOVERING);
                                adbPairingWorkflow.onPairingStarted(adbPairingImpl2.getId());
                                Log.d("ADBeesh:Pairing", '[' + adbPairingImpl2.getId() + "] Starting discovery");
                                AdbPairingImpl$ensurePaired$task$1$1$1 adbPairingImpl$ensurePaired$task$1$1$1 = new AdbPairingImpl$ensurePaired$task$1$1$1(adbPairingImpl2, adbPairingWorkflow, adbClient, null);
                                this.f4070L$0 = interfaceC1592Mutex3;
                                this.f4071L$1 = adbPairingImpl2;
                                this.f4072L$2 = adbPairingWorkflow;
                                this.f4073L$3 = null;
                                this.f4074label = 3;
                                if (SupervisorKt.supervisorScope(adbPairingImpl$ensurePaired$task$1$1$1, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                adbPairingImpl3 = adbPairingImpl2;
                                interfaceC1592Mutex4 = interfaceC1592Mutex3;
                                adbPairingImpl3.pairingJob = null;
                                C1133Unit c1133Unit3 = C1133Unit.INSTANCE;
                                interfaceC1592Mutex4.mo7494unlock(null);
                                return C1133Unit.INSTANCE;
                            } catch (CancellationException e3) {
                                e = e3;
                                adbPairingImpl3 = adbPairingImpl2;
                                adbPairingImpl3._status.setValue(AdbPairingStatus.f4191IDLE);
                                throw e;
                            } catch (Exception e4) {
                                e = e4;
                                adbPairingWorkflow2 = adbPairingWorkflow;
                                adbPairingImpl3 = adbPairingImpl2;
                                adbPairingImpl3._status.setValue(AdbPairingStatus.f4190ERROR);
                                String id2 = adbPairingImpl3.getId();
                                message = e.getMessage();
                                if (message == null) {
                                    message = "Unknown error";
                                }
                                adbPairingWorkflow2.onPairingError(id2, message);
                                throw e;
                            } catch (Throwable th3) {
                                th = th3;
                                adbPairingImpl4 = adbPairingImpl2;
                                adbPairingImpl4.pairingJob = null;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            interfaceC1592Mutex.mo7494unlock(null);
                            throw th;
                        }
                    }
                    adbPairingWorkflow = (AdbPairingWorkflow) this.f4073L$3;
                    adbPairingImpl = (AdbPairingImpl) this.f4072L$2;
                    interfaceC1592Mutex2 = (InterfaceC1592Mutex) this.f4071L$1;
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.f4070L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope3;
                }
                this.f4070L$0 = coroutineScope;
                this.f4071L$1 = interfaceC1592Mutex2;
                this.f4072L$2 = adbPairingImpl;
                this.f4073L$3 = adbPairingWorkflow;
                this.f4074label = 2;
                Object objSyncIdentity = adbPairingImpl.syncIdentity(this);
                if (objSyncIdentity == coroutine_suspended) {
                    return coroutine_suspended;
                }
                InterfaceC1592Mutex interfaceC1592Mutex6 = interfaceC1592Mutex2;
                coroutineScope2 = coroutineScope;
                obj = objSyncIdentity;
                adbPairingImpl2 = adbPairingImpl;
                interfaceC1592Mutex3 = interfaceC1592Mutex6;
                if (obj == null) {
                }
            } catch (Throwable th5) {
                th = th5;
                interfaceC1592Mutex = interfaceC1592Mutex2;
                interfaceC1592Mutex.mo7494unlock(null);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((AdbPairingImpl$ensurePaired$task$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
