package com.indidevs.p086android.p087adbeesh.internal.notifications;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingService;
import com.indidevs.p086android.p087adbeesh.p089pairing.PairingStage;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ2\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¨\u0006\u0019"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/notifications/NotificationController;", BuildConfig.f24315FLAVOR, "<init>", "()V", "update", BuildConfig.f24315FLAVOR, "context", "Landroid/content/Context;", "sessionId", BuildConfig.f24315FLAVOR, "config", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "stage", "Lcom/indidevs/android/adbeesh/pairing/PairingStage;", "port", BuildConfig.f24315FLAVOR, "receiver", "Landroid/os/Parcelable;", "pairingCodeKey", "error", "(Landroid/content/Context;Ljava/lang/String;Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;Lcom/indidevs/android/adbeesh/pairing/PairingStage;Ljava/lang/Integer;Landroid/os/Parcelable;Ljava/lang/String;Ljava/lang/String;)V", "terminate", "send", "action", "payload", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nNotificationController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationController.kt\ncom/indidevs/android/adbeesh/internal/notifications/NotificationController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n1#2:83\n*E\n"})
/* loaded from: classes.dex */
public final class NotificationController {
    public static final NotificationController INSTANCE = new NotificationController();

    private NotificationController() {
    }

    /* renamed from: send */
    private final void m4327send(Context context, String sessionId, NotificationFlowConfig config, String action, Parcelable payload) {
        AdbPairingService.Companion companion = AdbPairingService.INSTANCE;
        NotificationDispatcher notificationDispatcher = NotificationDispatcher.INSTANCE;
        companion.setDispatcher(notificationDispatcher);
        notificationDispatcher.prepare$adbeesh(sessionId, config);
        Intent intent = new Intent(context, (Class<?>) AdbPairingService.class);
        intent.setAction(action);
        intent.putExtra(AdbPairingService.EXTRA_SESSION_ID, sessionId);
        intent.putExtra(AdbPairingService.EXTRA_SESSION_DATA, payload);
        if (Intrinsics.areEqual(action, companion.getACTION_UPDATE_SESSION())) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static /* synthetic */ void terminate$default(NotificationController notificationController, Context context, String str, NotificationFlowConfig notificationFlowConfig, PairingStage pairingStage, int i, Object obj) {
        if ((i & 8) != 0) {
            pairingStage = null;
        }
        notificationController.terminate(context, str, notificationFlowConfig, pairingStage);
    }

    public final void terminate(Context context, String sessionId, NotificationFlowConfig config, PairingStage stage) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(config, "config");
        if (stage != null) {
            bundle = new Bundle();
            bundle.putString(AdbPairingService.EXTRA_STAGE, stage.name());
        } else {
            bundle = null;
        }
        m4327send(context, sessionId, config, AdbPairingService.INSTANCE.getACTION_TERMINATE_SESSION(), bundle);
    }

    /* renamed from: update */
    public final void m4328update(Context context, String sessionId, NotificationFlowConfig config, PairingStage stage, Integer port, Parcelable receiver, String pairingCodeKey, String error) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Bundle bundle = new Bundle();
        bundle.putString(AdbPairingService.EXTRA_STAGE, stage.name());
        if (port != null) {
            bundle.putInt(AdbPairingService.EXTRA_PORT, port.intValue());
        }
        if (receiver != null) {
            bundle.putParcelable(AdbPairingService.EXTRA_RESULT_RECEIVER, receiver);
        }
        if (pairingCodeKey != null) {
            bundle.putString(AdbPairingService.EXTRA_PAIRING_CODE_KEY, pairingCodeKey);
        }
        if (error != null) {
            bundle.putString(AdbPairingService.EXTRA_ERROR, error);
        }
        m4327send(context, sessionId, config, AdbPairingService.INSTANCE.getACTION_UPDATE_SESSION(), bundle);
    }
}
