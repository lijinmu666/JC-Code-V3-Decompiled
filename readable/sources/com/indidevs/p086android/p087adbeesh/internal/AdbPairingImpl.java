package com.indidevs.p086android.p087adbeesh.internal;

import android.content.Context;
import android.util.Log;
import com.flyfishxu.p028kadb.C0187Kadb;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbAuthenticationException;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbNotPairedException;
import com.indidevs.p086android.p087adbeesh.exceptions.AdbTimeoutException;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbClient;
import com.indidevs.p086android.p087adbeesh.internal.connection.AdbSessionImpl;
import com.indidevs.p086android.p087adbeesh.internal.discovery.C0896Scanner;
import com.indidevs.p086android.p087adbeesh.internal.security.CertificateFactory;
import com.indidevs.p086android.p087adbeesh.internal.security.IdentityStore;
import com.indidevs.p086android.p087adbeesh.internal.security.KeyPair;
import com.indidevs.p086android.p087adbeesh.p088config.AdbSessionConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingStatus;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingWorkflow;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession;
import java.util.concurrent.CancellationException;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.NonCancellable;
import p122kotlinx.coroutines.SupervisorKt;
import p122kotlinx.coroutines.TimeoutKt;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.MutableStateFlow;
import p122kotlinx.coroutines.p125flow.StateFlow;
import p122kotlinx.coroutines.p125flow.StateFlowKt;
import p122kotlinx.coroutines.p129sync.C1593MutexKt;
import p122kotlinx.coroutines.p129sync.InterfaceC1592Mutex;

@Metadata(m4987d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010!\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020%H\u0016J\b\u0010/\u001a\u00020%H\u0016J\b\u00100\u001a\u00020\"H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/AdbPairingImpl;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairing;", "context", "Landroid/content/Context;", "id", BuildConfig.f24315FLAVOR, "config", "Lcom/indidevs/android/adbeesh/config/AdbSessionConfig;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/indidevs/android/adbeesh/config/AdbSessionConfig;Lkotlinx/coroutines/CoroutineScope;)V", "getId", "()Ljava/lang/String;", "scope", "appContext", "kotlin.jvm.PlatformType", "identityStore", "Lcom/indidevs/android/adbeesh/internal/security/IdentityStore;", "_status", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingStatus;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "scanner", "Lcom/indidevs/android/adbeesh/internal/discovery/Scanner;", "pairingMutex", "Lkotlinx/coroutines/sync/Mutex;", "workflowMutex", "pairingJob", "Lkotlinx/coroutines/Job;", "syncIdentity", "Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensurePaired", BuildConfig.f24315FLAVOR, "workflow", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;", "(Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSession", "Lcom/indidevs/android/adbeesh/runtime/AdbSession;", "timeoutMs", BuildConfig.f24315FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unpair", "close", "getOrCreateKeyPair", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,206:1\n117#2,10:207\n*S KotlinDebug\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl\n*L\n75#1:207,10\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingImpl implements AdbPairing {

    /* renamed from: TAG */
    private static final String f4052TAG = "ADBeesh:Pairing";
    private final MutableStateFlow<AdbPairingStatus> _status;
    private final Context appContext;
    private final AdbSessionConfig config;
    private final CoroutineScope externalScope;
    private final String id;
    private final IdentityStore identityStore;
    private volatile InterfaceC1342Job pairingJob;
    private final InterfaceC1592Mutex pairingMutex;
    private final C0896Scanner scanner;
    private final CoroutineScope scope;
    private final StateFlow<AdbPairingStatus> status;
    private final InterfaceC1592Mutex workflowMutex;

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$1", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {72}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$1 */
    public static final class C08861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

        /* renamed from: label */
        int f4068label;

        public C08861(Continuation<? super C08861> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbPairingImpl.this.new C08861(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f4068label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AdbPairingImpl adbPairingImpl = AdbPairingImpl.this;
                this.f4068label = 1;
                if (adbPairingImpl.syncIdentity(this) == coroutine_suspended) {
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
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C08861) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "Lcom/indidevs/android/adbeesh/internal/connection/AdbSessionImpl;", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2", m6124f = "AdbPairingImpl.kt", m6125i = {}, m6126l = {160, 166}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$openSession$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n1#2:207\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$openSession$2 */
    public static final class C08882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdbSessionImpl>, Object> {
        final /* synthetic */ long $timeoutMs;

        /* renamed from: label */
        int f4090label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C08882(long j, Continuation<? super C08882> continuation) {
            super(2, continuation);
            this.$timeoutMs = j;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbPairingImpl.this.new C08882(this.$timeoutMs, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x006a A[Catch: AdbAuthenticationException -> 0x0012, TryCatch #0 {AdbAuthenticationException -> 0x0012, blocks: (B:6:0x000e, B:22:0x0066, B:24:0x006a, B:26:0x0070, B:27:0x0077, B:19:0x0053), top: B:32:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[Catch: AdbAuthenticationException -> 0x0012, TryCatch #0 {AdbAuthenticationException -> 0x0012, blocks: (B:6:0x000e, B:22:0x0066, B:24:0x006a, B:26:0x0070, B:27:0x0077, B:19:0x0053), top: B:32:0x0008 }] */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws AdbNotPairedException, AdbAuthenticationException, AdbTimeoutException {
            C0187Kadb c0187Kadb;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f4090label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AdbPairingImpl adbPairingImpl = AdbPairingImpl.this;
                    this.f4090label = 1;
                    obj = adbPairingImpl.syncIdentity(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        c0187Kadb = (C0187Kadb) obj;
                        if (c0187Kadb == null) {
                            return new AdbSessionImpl(c0187Kadb);
                        }
                        throw new AdbTimeoutException("Could not connect");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                KeyPair keyPair = (KeyPair) obj;
                if (keyPair == null) {
                    throw new AdbNotPairedException("Device not paired for ID: " + AdbPairingImpl.this.getId());
                }
                AdbSessionConfig adbSessionConfig = AdbPairingImpl.this.config;
                Context context = AdbPairingImpl.this.appContext;
                Intrinsics.checkNotNullExpressionValue(context, "access$getAppContext$p(...)");
                String deviceName = adbSessionConfig.resolve$adbeesh(context).getDeviceName();
                Intrinsics.checkNotNull(deviceName);
                AdbClient adbClient = new AdbClient(keyPair, deviceName);
                long j = this.$timeoutMs;
                AdbPairingImpl$openSession$2$result$1 adbPairingImpl$openSession$2$result$1 = new AdbPairingImpl$openSession$2$result$1(AdbPairingImpl.this, adbClient, null);
                this.f4090label = 2;
                obj = TimeoutKt.withTimeoutOrNull(j, adbPairingImpl$openSession$2$result$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c0187Kadb = (C0187Kadb) obj;
                if (c0187Kadb == null) {
                }
            } catch (AdbAuthenticationException e) {
                Log.w(AdbPairingImpl.f4052TAG, '[' + AdbPairingImpl.this.getId() + "] Authentication failure (pairing might be revoked), wiping identity");
                AdbPairingImpl.this.mo4307unpair();
                throw e;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super AdbSessionImpl> continuation) {
            return ((C08882) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl", m6124f = "AdbPairingImpl.kt", m6125i = {0}, m6126l = {AbstractC5816Primes.SMALL_FACTOR_LIMIT}, m6127m = "syncIdentity", m6128n = {"$this$withLock_u24default$iv"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$syncIdentity$1 */
    public static final class C08891 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f4095L$0;

        /* renamed from: label */
        int f4096label;

        /* renamed from: result */
        /* synthetic */ Object f4097result;

        public C08891(Continuation<? super C08891> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f4097result = obj;
            this.f4096label |= Integer.MIN_VALUE;
            return AdbPairingImpl.this.syncIdentity(this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.AdbPairingImpl$unpair$1", m6124f = "AdbPairingImpl.kt", m6125i = {0}, m6126l = {AbstractC5816Primes.SMALL_FACTOR_LIMIT}, m6127m = "invokeSuspend", m6128n = {"$this$withLock_u24default$iv"}, m6130s = {"L$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nAdbPairingImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$unpair$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,206:1\n117#2,10:207\n*S KotlinDebug\n*F\n+ 1 AdbPairingImpl.kt\ncom/indidevs/android/adbeesh/internal/AdbPairingImpl$unpair$1\n*L\n184#1:207,10\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.internal.AdbPairingImpl$unpair$1 */
    public static final class C08901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

        /* renamed from: L$0 */
        Object f4099L$0;

        /* renamed from: L$1 */
        Object f4100L$1;

        /* renamed from: label */
        int f4101label;

        public C08901(Continuation<? super C08901> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return AdbPairingImpl.this.new C08901(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC1592Mutex interfaceC1592Mutex;
            AdbPairingImpl adbPairingImpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f4101label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1592Mutex interfaceC1592Mutex2 = AdbPairingImpl.this.pairingMutex;
                AdbPairingImpl adbPairingImpl2 = AdbPairingImpl.this;
                this.f4099L$0 = interfaceC1592Mutex2;
                this.f4100L$1 = adbPairingImpl2;
                this.f4101label = 1;
                if (interfaceC1592Mutex2.mo7492lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                interfaceC1592Mutex = interfaceC1592Mutex2;
                adbPairingImpl = adbPairingImpl2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                adbPairingImpl = (AdbPairingImpl) this.f4100L$1;
                interfaceC1592Mutex = (InterfaceC1592Mutex) this.f4099L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                adbPairingImpl._status.setValue(AdbPairingStatus.f4191IDLE);
                adbPairingImpl.identityStore.m4332delete();
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                interfaceC1592Mutex.mo7494unlock(null);
                return C1133Unit.INSTANCE;
            } catch (Throwable th) {
                interfaceC1592Mutex.mo7494unlock(null);
                throw th;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C08901) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public AdbPairingImpl(Context context, String id, AdbSessionConfig config, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(config, "config");
        this.id = id;
        this.config = config;
        this.externalScope = coroutineScope;
        CoroutineScope CoroutineScope = coroutineScope == null ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((InterfaceC1342Job) null, 1, (Object) null).mo6100plus(Dispatchers.m6975getIO())) : coroutineScope;
        this.scope = CoroutineScope;
        Context appContext = context.getApplicationContext();
        this.appContext = appContext;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        this.identityStore = new IdentityStore(appContext, getId());
        MutableStateFlow<AdbPairingStatus> MutableStateFlow = StateFlowKt.MutableStateFlow(AdbPairingStatus.f4191IDLE);
        this._status = MutableStateFlow;
        this.status = C1427FlowKt.asStateFlow(MutableStateFlow);
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        this.scanner = new C0896Scanner(appContext);
        this.pairingMutex = C1593MutexKt.Mutex$default(false, 1, null);
        this.workflowMutex = C1593MutexKt.Mutex$default(false, 1, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, Dispatchers.m6975getIO(), null, new C08861(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KeyPair getOrCreateKeyPair() {
        KeyPair keyPairM4333load = this.identityStore.m4333load();
        if (keyPairM4333load != null) {
            return keyPairM4333load;
        }
        CertificateFactory certificateFactory = CertificateFactory.INSTANCE;
        AdbSessionConfig adbSessionConfig = this.config;
        Context appContext = this.appContext;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        String certificateSubject = adbSessionConfig.resolve$adbeesh(appContext).getCertificateSubject();
        Intrinsics.checkNotNull(certificateSubject);
        KeyPair keyPairGenerateKeyPair$default = CertificateFactory.generateKeyPair$default(certificateFactory, certificateSubject, 0, 0L, 6, null);
        this.identityStore.m4334save(keyPairGenerateKeyPair$default);
        return keyPairGenerateKeyPair$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncIdentity(Continuation<? super KeyPair> continuation) {
        C08891 c08891;
        InterfaceC1592Mutex interfaceC1592Mutex;
        if (continuation instanceof C08891) {
            c08891 = (C08891) continuation;
            int i = c08891.f4096label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c08891.f4096label = i - Integer.MIN_VALUE;
            } else {
                c08891 = new C08891(continuation);
            }
        }
        Object obj = c08891.f4097result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c08891.f4096label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1592Mutex interfaceC1592Mutex2 = this.pairingMutex;
            c08891.f4095L$0 = interfaceC1592Mutex2;
            c08891.f4096label = 1;
            if (interfaceC1592Mutex2.mo7492lock(null, c08891) == coroutine_suspended) {
                return coroutine_suspended;
            }
            interfaceC1592Mutex = interfaceC1592Mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC1592Mutex = (InterfaceC1592Mutex) c08891.f4095L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            KeyPair keyPairM4333load = this.identityStore.m4333load();
            if (keyPairM4333load != null) {
                this._status.setValue(AdbPairingStatus.f4192PAIRED);
            } else {
                keyPairM4333load = null;
            }
            return keyPairM4333load;
        } finally {
            interfaceC1592Mutex.mo7494unlock(null);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        InterfaceC1342Job interfaceC1342Job = this.pairingJob;
        if (interfaceC1342Job != null) {
            InterfaceC1342Job.cancel$default(interfaceC1342Job, (CancellationException) null, 1, (Object) null);
        }
        this._status.setValue(AdbPairingStatus.f4191IDLE);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing
    public Object ensurePaired(AdbPairingWorkflow adbPairingWorkflow, Continuation<? super C1133Unit> continuation) {
        CoroutineScopeKt.ensureActive(this.scope);
        Object objMo6928await = BuildersKt__Builders_commonKt.async$default(this.scope, Dispatchers.m6975getIO(), null, new AdbPairingImpl$ensurePaired$task$1(this, adbPairingWorkflow, null), 2, null).mo6928await(continuation);
        return objMo6928await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo6928await : C1133Unit.INSTANCE;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing
    public String getId() {
        return this.id;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing
    public StateFlow<AdbPairingStatus> getStatus() {
        return this.status;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing
    public Object openSession(long j, Continuation<? super AdbSession> continuation) {
        return BuildersKt.withContext(Dispatchers.m6975getIO(), new C08882(j, null), continuation);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairing
    /* renamed from: unpair */
    public void mo4307unpair() {
        InterfaceC1342Job interfaceC1342Job = this.pairingJob;
        if (interfaceC1342Job != null) {
            InterfaceC1342Job.cancel$default(interfaceC1342Job, (CancellationException) null, 1, (Object) null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.m6975getIO().mo6100plus(NonCancellable.INSTANCE), null, new C08901(null), 2, null);
    }

    public /* synthetic */ AdbPairingImpl(Context context, String str, AdbSessionConfig adbSessionConfig, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, adbSessionConfig, (i & 8) != 0 ? null : coroutineScope);
    }
}
