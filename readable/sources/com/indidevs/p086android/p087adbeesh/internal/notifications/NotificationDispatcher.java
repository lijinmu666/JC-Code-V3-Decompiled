package com.indidevs.p086android.p087adbeesh.internal.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationConfig;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingService;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingUpdate;
import com.indidevs.p086android.p087adbeesh.p089pairing.PairingStage;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p131o.AbstractC2346L2;
import p131o.C3925j5;

@Metadata(m4987d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0016\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010$\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u001f*\u00020!2\u0006\u0010#\u001a\u00020\"H\u0082\b¢\u0006\u0004\b$\u0010%J\u001f\u0010+\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\"2\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020,2\u0006\u0010&\u001a\u00020\"H\u0016¢\u0006\u0004\b-\u0010.J/\u00102\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020,2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001bH\u0016¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020,H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0004\b6\u00107J)\u00109\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b9\u0010:J'\u0010<\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00102\u0006\u0010;\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020,H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0015H\u0016¢\u0006\u0004\b>\u0010\u0003R\u0014\u0010?\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u0010@R\u0014\u0010D\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010G¨\u0006I"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/notifications/NotificationDispatcher;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/indidevs/android/adbeesh/internal/notifications/NotificationSession;", "session", "Lo/L2$ZfxDd;", "render", "(Landroid/content/Context;Lcom/indidevs/android/adbeesh/internal/notifications/NotificationSession;)Lo/L2$ZfxDd;", "Lcom/indidevs/android/adbeesh/internal/notifications/NotificationView;", "view", "Lo/L2$mjFkc;", "buildPairAction", "(Landroid/content/Context;Lcom/indidevs/android/adbeesh/internal/notifications/NotificationSession;Lcom/indidevs/android/adbeesh/internal/notifications/NotificationView;)Lo/L2$mjFkc;", "Landroid/app/Service;", BuildConfig.f24315FLAVOR, "id", "Landroid/app/Notification;", "ui", BuildConfig.f24315FLAVOR, "promoteToForeground", "(Landroid/app/Service;ILandroid/app/Notification;)V", "notifyNotification", "cancelNotification", "(Landroid/app/Service;I)V", BuildConfig.f24315FLAVOR, "keepNotification", "stopForegroundCompat", "(Landroid/app/Service;Z)V", "Landroid/os/Parcelable;", "T", "Landroid/content/Intent;", BuildConfig.f24315FLAVOR, "key", "getParcelableExtraCompat", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "sessionId", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "config", "prepare$adbeesh", "(Ljava/lang/String;Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;)V", "prepare", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "onCreateSession", "(Ljava/lang/String;)Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "service", "payload", "isForeground", "onUpdateSession", "(Landroid/app/Service;Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;Landroid/os/Parcelable;Z)V", "onPromoteToForeground", "(Landroid/app/Service;Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;)V", "onExitForeground", "(Landroid/app/Service;)V", "finalPayload", "onStopSession", "(Landroid/app/Service;Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;Landroid/os/Parcelable;)V", "intent", "onHandleInput", "(Landroid/app/Service;Landroid/content/Intent;Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;)V", "onServiceDestroyed", "TAG", "Ljava/lang/String;", "INPUT_KEY", "EXTRA_IMMEDIATE_UI_FEEDBACK", "ACTION_INPUT", "REQ_SUBMIT_CODE", "I", "lastKeptNotificationId", "Ljava/lang/Integer;", "activeForegroundId", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nNotificationDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationDispatcher.kt\ncom/indidevs/android/adbeesh/internal/notifications/NotificationDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,265:1\n258#1,6:267\n1#2:266\n*S KotlinDebug\n*F\n+ 1 NotificationDispatcher.kt\ncom/indidevs/android/adbeesh/internal/notifications/NotificationDispatcher\n*L\n152#1:267,6\n*E\n"})
/* loaded from: classes.dex */
public final class NotificationDispatcher implements AdbPairingService.PairingDispatcher {
    public static final String ACTION_INPUT = "com.indidevs.android.adbeesh.pairing.action.PROCESS_INPUT";
    public static final String EXTRA_IMMEDIATE_UI_FEEDBACK = "immediate_ui_feedback";
    public static final String INPUT_KEY = "input_pairing_code";
    public static final NotificationDispatcher INSTANCE = new NotificationDispatcher();
    private static final int REQ_SUBMIT_CODE = 100;
    private static final String TAG = "ADBeesh:NotificationDispatcher";
    private static Integer activeForegroundId;
    private static Integer lastKeptNotificationId;

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PairingStage.m4368values().length];
            try {
                iArr[PairingStage.SEARCHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PairingStage.AWAITING_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PairingStage.CODE_SUBMITTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PairingStage.f4198PAIRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PairingStage.f4199SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PairingStage.f4197ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private NotificationDispatcher() {
    }

    private final AbstractC2346L2.mjFkc buildPairAction(Context context, NotificationSession session, NotificationView view) {
        NotificationConfig notificationConfigMo2237invoke = session.getConfig().getAwaitingCode().mo2237invoke(new AdbPairingUpdate(session.getSessionId(), session.getPort(), null, 4, null));
        ResultReceiver resultReceiver = session.getResultReceiver();
        if (resultReceiver == null || notificationConfigMo2237invoke.getActionButtonText() == null) {
            return null;
        }
        C3925j5.ZfxDd zfxDd = new C3925j5.ZfxDd(INPUT_KEY);
        String inputLabel = notificationConfigMo2237invoke.getInputLabel();
        if (inputLabel == null) {
            inputLabel = "Code";
        }
        C3925j5 c3925j5M12358mjFkc = zfxDd.m12357AZxh(inputLabel).m12358mjFkc();
        Intrinsics.checkNotNullExpressionValue(c3925j5M12358mjFkc, "build(...)");
        Intent intent = new Intent(context, (Class<?>) AdbPairingService.class);
        intent.setAction(ACTION_INPUT);
        intent.putExtra(AdbPairingService.EXTRA_SESSION_ID, session.getSessionId());
        intent.putExtra(AdbPairingService.EXTRA_RESULT_RECEIVER, resultReceiver);
        intent.putExtra(EXTRA_IMMEDIATE_UI_FEEDBACK, view.createCodeSubmittedNotification().m9337wA());
        return new AbstractC2346L2.mjFkc.C6359mjFkc(0, notificationConfigMo2237invoke.getActionButtonText(), PendingIntent.getService(context, session.getRequestCodeBase() + REQ_SUBMIT_CODE, intent, (Build.VERSION.SDK_INT >= 31 ? AdbProtocol.INITIAL_DELAYED_ACK_BYTES : 0) | 134217728)).m9350mjFkc(c3925j5M12358mjFkc).m9349AZxh();
    }

    private final void cancelNotification(Service service, int i) {
        Object systemService = service.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i);
    }

    private final /* synthetic */ <T extends Parcelable> T getParcelableExtraCompat(Intent intent, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) intent.getParcelableExtra(str, Parcelable.class);
        }
        T t = (T) intent.getParcelableExtra(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    private final void notifyNotification(Service service, int i, Notification notification) {
        Object systemService = service.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(i, notification);
    }

    private final void promoteToForeground(Service service, int i, Notification notification) {
        try {
            service.startForeground(i, notification, 16);
        } catch (Exception e) {
            Log.e(TAG, "Failed to start foreground service", e);
        }
    }

    /* renamed from: render */
    private final AbstractC2346L2.ZfxDd m4329render(Context context, NotificationSession session) {
        NotificationView notificationView = new NotificationView(context, session.getConfig(), session.getSessionId(), session.getRequestCodeBase());
        switch (WhenMappings.$EnumSwitchMapping$0[session.getStage().ordinal()]) {
            case 1:
                return notificationView.createSearchingNotification();
            case 2:
                AbstractC2346L2.mjFkc mjfkcBuildPairAction = buildPairAction(context, session, notificationView);
                Integer numM4357getPort = session.getPort();
                return notificationView.createAwaitingCodeNotification(numM4357getPort != null ? numM4357getPort.intValue() : 0, mjfkcBuildPairAction);
            case 3:
                return notificationView.createCodeSubmittedNotification();
            case 4:
                return notificationView.createPairingNotification();
            case 5:
                return notificationView.createSuccessNotification();
            case 6:
                String error = session.getError();
                if (error == null) {
                    error = "Unknown error";
                }
                return notificationView.createErrorNotification(error);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void stopForegroundCompat(Service service, boolean z) {
        service.stopForeground(z ? 2 : 1);
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public AdbPairingService.PairingSession onCreateSession(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new NotificationSession(sessionId);
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onExitForeground(Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        stopForegroundCompat(service, lastKeptNotificationId != null);
        lastKeptNotificationId = null;
        activeForegroundId = null;
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onHandleInput(Service service, Intent intent, AdbPairingService.PairingSession session) {
        Parcelable parcelable;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(session, "session");
        NotificationSession notificationSession = (NotificationSession) session;
        Bundle bundleM12343Dt = C3925j5.m12343Dt(intent);
        String string = (bundleM12343Dt == null || (charSequence = bundleM12343Dt.getCharSequence(INPUT_KEY)) == null) ? null : charSequence.toString();
        if (string == null || StringsKt.m6766isBlank(string)) {
            return;
        }
        ResultReceiver resultReceiver = notificationSession.getResultReceiver();
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString(notificationSession.getPairingCodeKey(), string);
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra(EXTRA_IMMEDIATE_UI_FEEDBACK, Notification.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_IMMEDIATE_UI_FEEDBACK);
            if (!(parcelableExtra instanceof Notification)) {
                parcelableExtra = null;
            }
            parcelable = (Notification) parcelableExtra;
        }
        Parcelable bundle2 = (Notification) parcelable;
        notificationSession.setStage(PairingStage.CODE_SUBMITTED);
        AdbPairingService adbPairingService = service instanceof AdbPairingService ? (AdbPairingService) service : null;
        boolean zIsSessionForeground$adbeesh = adbPairingService != null ? adbPairingService.isSessionForeground$adbeesh(notificationSession.getSessionId()) : false;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        onUpdateSession(service, notificationSession, bundle2, zIsSessionForeground$adbeesh);
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onPromoteToForeground(Service service, AdbPairingService.PairingSession session) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(session, "session");
        NotificationSession notificationSession = (NotificationSession) session;
        Notification notificationM9337wA = m4329render(service, notificationSession).m9337wA();
        Intrinsics.checkNotNullExpressionValue(notificationM9337wA, "build(...)");
        promoteToForeground(service, notificationSession.getNotificationId(), notificationM9337wA);
        activeForegroundId = Integer.valueOf(notificationSession.getNotificationId());
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onServiceDestroyed() {
        activeForegroundId = null;
        lastKeptNotificationId = null;
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onStopSession(Service service, AdbPairingService.PairingSession session, Parcelable finalPayload) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(session, "session");
        NotificationSession notificationSession = (NotificationSession) session;
        PairingStage stage = notificationSession.getStage();
        PairingStage pairingStage = PairingStage.f4199SUCCESS;
        boolean z = stage == pairingStage;
        if (z && finalPayload == null) {
            notificationSession.setStage(pairingStage);
        }
        Notification notificationM9337wA = finalPayload instanceof Notification ? (Notification) finalPayload : ((finalPayload instanceof Bundle) || z) ? m4329render(service, notificationSession).m9337wA() : null;
        Integer num = activeForegroundId;
        int notificationId = notificationSession.getNotificationId();
        if (num != null && num.intValue() == notificationId) {
            stopForegroundCompat(service, notificationM9337wA != null);
            activeForegroundId = null;
        }
        if (notificationM9337wA != null) {
            notifyNotification(service, notificationSession.getNotificationId(), notificationM9337wA);
            lastKeptNotificationId = Integer.valueOf(notificationSession.getNotificationId());
        } else {
            cancelNotification(service, notificationSession.getNotificationId());
            lastKeptNotificationId = null;
        }
    }

    @Override // com.indidevs.android.adbeesh.pairing.AdbPairingService.PairingDispatcher
    public void onUpdateSession(Service service, AdbPairingService.PairingSession session, Parcelable payload, boolean isForeground) {
        Notification notificationM9337wA;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(payload, "payload");
        NotificationSession notificationSession = (NotificationSession) session;
        if (payload instanceof Notification) {
            notificationM9337wA = (Notification) payload;
        } else {
            notificationM9337wA = m4329render(service, notificationSession).m9337wA();
            Intrinsics.checkNotNullExpressionValue(notificationM9337wA, "build(...)");
        }
        if (!isForeground) {
            notifyNotification(service, notificationSession.getNotificationId(), notificationM9337wA);
            return;
        }
        Integer num = activeForegroundId;
        int notificationId = notificationSession.getNotificationId();
        if (num != null && num.intValue() == notificationId) {
            notifyNotification(service, notificationSession.getNotificationId(), notificationM9337wA);
        } else {
            promoteToForeground(service, notificationSession.getNotificationId(), notificationM9337wA);
            activeForegroundId = Integer.valueOf(notificationSession.getNotificationId());
        }
    }

    public final void prepare$adbeesh(String sessionId, NotificationFlowConfig config) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(config, "config");
        AdbPairingService.Companion companion = AdbPairingService.INSTANCE;
        AdbPairingService.PairingSession pairingSession = companion.getSessions().get(sessionId);
        NotificationSession notificationSession = pairingSession instanceof NotificationSession ? (NotificationSession) pairingSession : null;
        if (notificationSession == null) {
            notificationSession = new NotificationSession(sessionId);
            companion.getSessions().put(sessionId, notificationSession);
        }
        notificationSession.setConfig(config);
    }
}
