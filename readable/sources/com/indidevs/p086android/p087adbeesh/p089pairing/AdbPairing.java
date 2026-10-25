package com.indidevs.p086android.p087adbeesh.p089pairing;

import android.content.Context;
import com.indidevs.p086android.p087adbeesh.internal.AdbPairingImpl;
import com.indidevs.p086android.p087adbeesh.p088config.AdbSessionConfig;
import com.indidevs.p086android.p087adbeesh.p090runtime.AdbSession;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.StateFlow;

@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u00172\u00060\u0001j\u0002`\u0002:\u0001\u0017J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\rH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairing;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "id", BuildConfig.f24315FLAVOR, "getId", "()Ljava/lang/String;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingStatus;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "ensurePaired", BuildConfig.f24315FLAVOR, "workflow", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;", "(Lcom/indidevs/android/adbeesh/pairing/AdbPairingWorkflow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSession", "Lcom/indidevs/android/adbeesh/runtime/AdbSession;", "timeoutMs", BuildConfig.f24315FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unpair", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface AdbPairing extends AutoCloseable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairing$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "get", "Lcom/indidevs/android/adbeesh/pairing/AdbPairing;", "context", "Landroid/content/Context;", "id", BuildConfig.f24315FLAVOR, "config", "Lcom/indidevs/android/adbeesh/config/AdbSessionConfig;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ AdbPairing get$default(Companion companion, Context context, String str, AdbSessionConfig adbSessionConfig, CoroutineScope coroutineScope, int i, Object obj) {
            if ((i & 2) != 0) {
                str = BuildConfig.f24315FLAVOR;
            }
            if ((i & 4) != 0) {
                adbSessionConfig = new AdbSessionConfig(null, null, null, 0L, 15, null);
            }
            if ((i & 8) != 0) {
                coroutineScope = null;
            }
            return companion.m4356get(context, str, adbSessionConfig, coroutineScope);
        }

        /* renamed from: get */
        public final AdbPairing m4356get(Context context, String id, AdbSessionConfig config, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(config, "config");
            return new AdbPairingImpl(context, id, config, scope);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object openSession$default(AdbPairing adbPairing, long j, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSession");
            }
            if ((i & 1) != 0) {
                j = 10000;
            }
            return adbPairing.openSession(j, continuation);
        }
    }

    Object ensurePaired(AdbPairingWorkflow adbPairingWorkflow, Continuation<? super C1133Unit> continuation);

    String getId();

    StateFlow<AdbPairingStatus> getStatus();

    Object openSession(long j, Continuation<? super AdbSession> continuation);

    /* renamed from: unpair */
    void mo4307unpair();
}
