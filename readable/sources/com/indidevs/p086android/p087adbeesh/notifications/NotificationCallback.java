package com.indidevs.p086android.p087adbeesh.notifications;

import android.content.Context;
import com.indidevs.p086android.p087adbeesh.internal.notifications.NotificationController;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback;
import com.indidevs.p086android.p087adbeesh.p089pairing.PairingStage;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationCallback;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingCallback;", "context", "Landroid/content/Context;", "config", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "<init>", "(Landroid/content/Context;Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;)V", "onPairingStarted", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "onPortFound", "port", BuildConfig.f24315FLAVOR, "onPairingHandshakeStarted", "onPairingSuccess", "onPairingError", "error", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NotificationCallback implements AdbPairingCallback {
    private final NotificationFlowConfig config;
    private final Context context;

    public NotificationCallback(Context context, NotificationFlowConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
    public void onPairingError(String sessionId, String error) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(error, "error");
        NotificationController.INSTANCE.m4328update(this.context, sessionId, this.config, PairingStage.f4197ERROR, (112 & 16) != 0 ? null : null, (112 & 32) != 0 ? null : null, (112 & 64) != 0 ? null : null, (112 & 128) != 0 ? null : error);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
    public void onPairingHandshakeStarted(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        NotificationController.INSTANCE.m4328update(this.context, sessionId, this.config, PairingStage.f4198PAIRING, (112 & 16) != 0 ? null : null, (112 & 32) != 0 ? null : null, (112 & 64) != 0 ? null : null, (112 & 128) != 0 ? null : null);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
    public void onPairingStarted(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        NotificationController.INSTANCE.m4328update(this.context, sessionId, this.config, PairingStage.SEARCHING, (112 & 16) != 0 ? null : null, (112 & 32) != 0 ? null : null, (112 & 64) != 0 ? null : null, (112 & 128) != 0 ? null : null);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
    public void onPairingSuccess(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        NotificationController.INSTANCE.terminate(this.context, sessionId, this.config, PairingStage.f4199SUCCESS);
    }

    @Override // com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingCallback
    public void onPortFound(String sessionId, int port) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        NotificationController.INSTANCE.m4328update(this.context, sessionId, this.config, PairingStage.AWAITING_CODE, (112 & 16) != 0 ? null : Integer.valueOf(port), (112 & 32) != 0 ? null : null, (112 & 64) != 0 ? null : null, (112 & 128) != 0 ? null : null);
    }

    public /* synthetic */ NotificationCallback(Context context, NotificationFlowConfig notificationFlowConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
