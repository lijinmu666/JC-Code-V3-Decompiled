package com.indidevs.p086android.p087adbeesh.internal.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationConfig;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingUpdate;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC2346L2;

@Metadata(m4987d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0019¢\u0006\u0004\b$\u0010!J\r\u0010%\u001a\u00020\u0019¢\u0006\u0004\b%\u0010!J\r\u0010&\u001a\u00020\u0019¢\u0006\u0004\b&\u0010!J\u0015\u0010'\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,¨\u0006."}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/notifications/NotificationView;", BuildConfig.f24315FLAVOR, "Landroid/content/Context;", "context", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "config", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "requestCodeBase", "<init>", "(Landroid/content/Context;Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;Ljava/lang/String;I)V", BuildConfig.f24315FLAVOR, "createNotificationChannel", "()V", "port", "error", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", "update", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", "Lcom/indidevs/android/adbeesh/notifications/NotificationConfig;", "ui", "settingsReqCode", "Lo/L2$mjFkc;", "action", "Lo/L2$ZfxDd;", "render", "(Lcom/indidevs/android/adbeesh/notifications/NotificationConfig;ILo/L2$mjFkc;)Lo/L2$ZfxDd;", "requestId", "Landroid/app/PendingIntent;", "createSettingsPendingIntent", "(I)Landroid/app/PendingIntent;", "createSearchingNotification", "()Lo/L2$ZfxDd;", "createAwaitingCodeNotification", "(ILo/L2$mjFkc;)Lo/L2$ZfxDd;", "createCodeSubmittedNotification", "createPairingNotification", "createSuccessNotification", "createErrorNotification", "(Ljava/lang/String;)Lo/L2$ZfxDd;", "Landroid/content/Context;", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "Ljava/lang/String;", "I", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NotificationView {
    private static final int REQ_SETTINGS_AWAITING = 2;
    private static final int REQ_SETTINGS_INITIAL = 1;
    private final NotificationFlowConfig config;
    private final Context context;
    private final int requestCodeBase;
    private final String sessionId;

    public NotificationView(Context context, NotificationFlowConfig config, String sessionId, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.context = context;
        this.config = config;
        this.sessionId = sessionId;
        this.requestCodeBase = i;
        createNotificationChannel();
    }

    public static /* synthetic */ AbstractC2346L2.ZfxDd createAwaitingCodeNotification$default(NotificationView notificationView, int i, AbstractC2346L2.mjFkc mjfkc, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mjfkc = null;
        }
        return notificationView.createAwaitingCodeNotification(i, mjfkc);
    }

    private final void createNotificationChannel() {
        Object systemService = this.context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = new NotificationChannel(this.config.getNotificationChannelId(), this.config.getNotificationChannelName(), 4);
        notificationChannel.setShowBadge(true);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(false);
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    private final PendingIntent createSettingsPendingIntent(int requestId) {
        Intent intent = new Intent("android.settings.WIFI_ADB_SETTINGS");
        intent.addFlags(268435456);
        if (this.context.getPackageManager().resolveActivity(intent, 0) == null) {
            intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
            intent.addFlags(268435456);
        }
        PendingIntent activity = PendingIntent.getActivity(this.context, this.requestCodeBase + requestId, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    /* renamed from: render */
    private final AbstractC2346L2.ZfxDd m4330render(NotificationConfig ui, int settingsReqCode, AbstractC2346L2.mjFkc action) {
        AbstractC2346L2.ZfxDd zfxDdM9329diqgf = new AbstractC2346L2.ZfxDd(this.context, this.config.getNotificationChannelId()).m9331fehf(ui.getSmallIconRes()).m9321ETF(ui.getTitle()).m9320Dt(ui.m4339getText()).m9327YoKzxo(true).m9336rkYL(2).m9338xJ("service").m9329diqgf(1);
        Intrinsics.checkNotNullExpressionValue(zfxDdM9329diqgf, "setVisibility(...)");
        String bigText = ui.getBigText();
        if (bigText != null) {
            zfxDdM9329diqgf.m9322IEE(new AbstractC2346L2.AZxh().m9311lgHUyS(bigText));
        }
        if (action != null) {
            zfxDdM9329diqgf.m9319AZxh(action);
        }
        if (ui.getShowOpenSettingsButton() && ui.getSettingsButtonText() != null) {
            zfxDdM9329diqgf.m9333mjFkc(0, ui.getSettingsButtonText(), createSettingsPendingIntent(settingsReqCode));
            zfxDdM9329diqgf.m9335qdMbNW(createSettingsPendingIntent(settingsReqCode));
        }
        return zfxDdM9329diqgf;
    }

    public static /* synthetic */ AbstractC2346L2.ZfxDd render$default(NotificationView notificationView, NotificationConfig notificationConfig, int i, AbstractC2346L2.mjFkc mjfkc, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            mjfkc = null;
        }
        return notificationView.m4330render(notificationConfig, i, mjfkc);
    }

    /* renamed from: update */
    private final AdbPairingUpdate m4331update(Integer port, String error) {
        return new AdbPairingUpdate(this.sessionId, port, error);
    }

    public static /* synthetic */ AdbPairingUpdate update$default(NotificationView notificationView, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return notificationView.m4331update(num, str);
    }

    public final AbstractC2346L2.ZfxDd createAwaitingCodeNotification(int port, AbstractC2346L2.mjFkc action) {
        return m4330render(this.config.getAwaitingCode().mo2237invoke(update$default(this, Integer.valueOf(port), null, 2, null)), 2, action);
    }

    public final AbstractC2346L2.ZfxDd createCodeSubmittedNotification() {
        AbstractC2346L2.ZfxDd zfxDdRender$default = render$default(this, this.config.getCodeSubmitted().mo2237invoke(update$default(this, null, null, 3, null)), 0, null, 6, null);
        zfxDdRender$default.m9334qGY(0, 0, true);
        return zfxDdRender$default;
    }

    public final AbstractC2346L2.ZfxDd createErrorNotification(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        AbstractC2346L2.ZfxDd zfxDdRender$default = render$default(this, this.config.getError().mo2237invoke(update$default(this, null, error, 1, null)), 0, null, 6, null);
        zfxDdRender$default.m9327YoKzxo(false);
        return zfxDdRender$default;
    }

    public final AbstractC2346L2.ZfxDd createPairingNotification() {
        AbstractC2346L2.ZfxDd zfxDdRender$default = render$default(this, this.config.getPairing().mo2237invoke(update$default(this, null, null, 3, null)), 0, null, 6, null);
        zfxDdRender$default.m9334qGY(0, 0, true);
        return zfxDdRender$default;
    }

    public final AbstractC2346L2.ZfxDd createSearchingNotification() {
        return render$default(this, this.config.getSearching().mo2237invoke(update$default(this, null, null, 3, null)), 1, null, 4, null);
    }

    public final AbstractC2346L2.ZfxDd createSuccessNotification() {
        AbstractC2346L2.ZfxDd zfxDdRender$default = render$default(this, this.config.getSuccess().mo2237invoke(update$default(this, null, null, 3, null)), 0, null, 6, null);
        zfxDdRender$default.m9327YoKzxo(false);
        return zfxDdRender$default;
    }
}
