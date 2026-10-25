package com.indidevs.p086android.p087adbeesh.internal.notifications;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingService;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/notifications/NotificationSession;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "sessionId", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;)V", "config", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "getConfig", "()Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "setConfig", "(Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;)V", "notificationId", BuildConfig.f24315FLAVOR, "getNotificationId", "()I", "requestCodeBase", "getRequestCodeBase", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NotificationSession extends AdbPairingService.PairingSession {
    private NotificationFlowConfig config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationSession(String sessionId) {
        super(sessionId, null, null, null, null, null, 62, null);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.config = new NotificationFlowConfig(null, null, null, 0, 0, null, null, null, null, null, null, 2047, null);
    }

    public final NotificationFlowConfig getConfig() {
        return this.config;
    }

    public final int getNotificationId() {
        Integer notificationId = this.config.getNotificationId();
        if (notificationId != null) {
            return notificationId.intValue();
        }
        return (getSessionId().hashCode() & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + this.config.getBaseNotificationId();
    }

    public final int getRequestCodeBase() {
        return this.config.getBaseRequestCode() + (getSessionId().hashCode() & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
    }

    public final void setConfig(NotificationFlowConfig notificationFlowConfig) {
        Intrinsics.checkNotNullParameter(notificationFlowConfig, "<set-?>");
        this.config = notificationFlowConfig;
    }
}
