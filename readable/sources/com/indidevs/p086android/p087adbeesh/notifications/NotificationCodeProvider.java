package com.indidevs.p086android.p087adbeesh.notifications;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.indidevs.p086android.p087adbeesh.internal.notifications.NotificationController;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCodeProvider;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingService;
import com.indidevs.p086android.p087adbeesh.p089pairing.PairingStage;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationCodeProvider;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCodeProvider;", "context", "Landroid/content/Context;", "config", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "<init>", "(Landroid/content/Context;Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;)V", "provideCode", BuildConfig.f24315FLAVOR, "sessionId", "port", BuildConfig.f24315FLAVOR, "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nNotificationCodeProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationCodeProvider.kt\ncom/indidevs/android/adbeesh/notifications/NotificationCodeProvider\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,60:1\n433#2,10:61\n*S KotlinDebug\n*F\n+ 1 NotificationCodeProvider.kt\ncom/indidevs/android/adbeesh/notifications/NotificationCodeProvider\n*L\n37#1:61,10\n*E\n"})
/* loaded from: classes.dex */
public final class NotificationCodeProvider implements AdbPairingCodeProvider {
    private final NotificationFlowConfig config;
    private final Context context;

    public NotificationCodeProvider(Context context, NotificationFlowConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCodeProvider
    public Object provideCode(final String str, int i, Continuation<? super String> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final Handler handler = new Handler(Looper.getMainLooper());
        NotificationController.INSTANCE.m4328update(this.context, str, this.config, PairingStage.AWAITING_CODE, (112 & 16) != 0 ? null : C1207Boxing.m6121boxInt(i), (112 & 32) != 0 ? null : new ResultReceiver(handler) { // from class: com.indidevs.android.adbeesh.notifications.NotificationCodeProvider$provideCode$2$receiver$1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int resultCode, Bundle resultData) {
                String string = resultData != null ? resultData.getString(AdbPairingService.DEFAULT_PAIRING_CODE_KEY) : null;
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(string));
                }
            }
        }, (112 & 64) != 0 ? null : AdbPairingService.DEFAULT_PAIRING_CODE_KEY, (112 & 128) != 0 ? null : null);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, C1133Unit>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationCodeProvider$provideCode$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(Throwable th) {
                invoke2(th);
                return C1133Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                NotificationController.terminate$default(NotificationController.INSTANCE, this.f4157this$0.context, str, this.f4157this$0.config, null, 8, null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public /* synthetic */ NotificationCodeProvider(Context context, NotificationFlowConfig notificationFlowConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Context context2;
        NotificationFlowConfig notificationFlowConfig2;
        if ((i & 2) != 0) {
            notificationFlowConfig2 = new NotificationFlowConfig(null, null, null, 0, 0, null, null, null, null, null, null, 2047, null);
            context2 = context;
        } else {
            context2 = context;
            notificationFlowConfig2 = notificationFlowConfig;
        }
        this(context2, notificationFlowConfig2);
    }
}
