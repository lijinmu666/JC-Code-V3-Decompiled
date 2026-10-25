package com.indidevs.p086android.p087adbeesh.p089pairing;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tJ\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J2\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J(\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u0017*\u00020!2\u0006\u0010\u001e\u001a\u00020\u0005H\u0082\b¢\u0006\u0002\u0010\"R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingService;", "Landroid/app/Service;", "<init>", "()V", "foregroundSessionId", BuildConfig.f24315FLAVOR, "isSessionForeground", BuildConfig.f24315FLAVOR, "sessionId", "isSessionForeground$adbeesh", "onStartCommand", BuildConfig.f24315FLAVOR, "intent", "Landroid/content/Intent;", "flags", "startId", "processAction", "dispatcher", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;", "action", "session", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "payload", "Landroid/os/Parcelable;", "onDestroy", BuildConfig.f24315FLAVOR, "onBind", "Landroid/os/IBinder;", "getParcelableExtraCompat", "T", "key", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableCompat", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "Companion", "PairingSession", "PairingDispatcher", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAdbPairingService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbPairingService.kt\ncom/indidevs/android/adbeesh/pairing/AdbPairingService\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,237:1\n220#1,7:241\n220#1,7:248\n229#1,7:256\n113#2,2:238\n1#3:240\n1#3:255\n*S KotlinDebug\n*F\n+ 1 AdbPairingService.kt\ncom/indidevs/android/adbeesh/pairing/AdbPairingService\n*L\n129#1:241,7\n136#1:248,7\n149#1:256,7\n123#1:238,2\n123#1:240\n*E\n"})
/* loaded from: classes.dex */
public final class AdbPairingService extends Service {
    private static final String ACTION_TERMINATE_SESSION;
    private static final String ACTION_UPDATE_SESSION;
    private static final String BASE_ACTION_NAME;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_PAIRING_CODE_KEY = "pairing_code";
    public static final String EXTRA_ERROR = "error_message";
    public static final String EXTRA_PAIRING_CODE_KEY = "extra_pairing_code_key";
    public static final String EXTRA_PORT = "adb_port";
    public static final String EXTRA_RESULT_RECEIVER = "extra_result_receiver";
    public static final String EXTRA_SESSION_DATA = "extra_session_data";
    public static final String EXTRA_SESSION_ID = "extra_session_id";
    public static final String EXTRA_STAGE = "session_stage";

    /* renamed from: TAG */
    private static final String f4185TAG = "ADBeesh:Service";
    private static PairingDispatcher dispatcher;
    private static final ConcurrentHashMap<String, PairingSession> sessions;
    private String foregroundSessionId;

    @Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!¨\u0006\""}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "TAG", BuildConfig.f24315FLAVOR, "dispatcher", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;", "getDispatcher$annotations", "getDispatcher", "()Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;", "setDispatcher", "(Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;)V", "BASE_ACTION_NAME", "kotlin.jvm.PlatformType", "ACTION_UPDATE_SESSION", "getACTION_UPDATE_SESSION", "()Ljava/lang/String;", "ACTION_TERMINATE_SESSION", "getACTION_TERMINATE_SESSION", "EXTRA_SESSION_DATA", "EXTRA_SESSION_ID", "EXTRA_RESULT_RECEIVER", "EXTRA_PAIRING_CODE_KEY", "EXTRA_STAGE", "EXTRA_PORT", "EXTRA_ERROR", "DEFAULT_PAIRING_CODE_KEY", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "getSessions$annotations", "getSessions", "()Ljava/util/concurrent/ConcurrentHashMap;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDispatcher$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getSessions$annotations() {
        }

        public final String getACTION_TERMINATE_SESSION() {
            return AdbPairingService.ACTION_TERMINATE_SESSION;
        }

        public final String getACTION_UPDATE_SESSION() {
            return AdbPairingService.ACTION_UPDATE_SESSION;
        }

        public final PairingDispatcher getDispatcher() {
            return AdbPairingService.dispatcher;
        }

        public final ConcurrentHashMap<String, PairingSession> getSessions() {
            return AdbPairingService.sessions;
        }

        public final void setDispatcher(PairingDispatcher pairingDispatcher) {
            AdbPairingService.dispatcher = pairingDispatcher;
        }

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\fH&J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0007H&¨\u0006\u0017"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingDispatcher;", BuildConfig.f24315FLAVOR, "onCreateSession", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", "sessionId", BuildConfig.f24315FLAVOR, "onUpdateSession", BuildConfig.f24315FLAVOR, "service", "Landroid/app/Service;", "session", "payload", "Landroid/os/Parcelable;", "isForeground", BuildConfig.f24315FLAVOR, "onPromoteToForeground", "onExitForeground", "onStopSession", "finalPayload", "onHandleInput", "intent", "Landroid/content/Intent;", "onServiceDestroyed", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public interface PairingDispatcher {
        PairingSession onCreateSession(String sessionId);

        void onExitForeground(Service service);

        void onHandleInput(Service service, Intent intent, PairingSession session);

        void onPromoteToForeground(Service service, PairingSession session);

        void onServiceDestroyed();

        void onStopSession(Service service, PairingSession session, Parcelable finalPayload);

        void onUpdateSession(Service service, PairingSession session, Parcelable payload, boolean isForeground);
    }

    static {
        String name = AdbPairingService.class.getName();
        BASE_ACTION_NAME = name;
        ACTION_UPDATE_SESSION = name + ".action.UPDATE_SESSION";
        ACTION_TERMINATE_SESSION = name + ".action.TERMINATE_SESSION";
        sessions = new ConcurrentHashMap<>();
    }

    public static final PairingDispatcher getDispatcher() {
        return INSTANCE.getDispatcher();
    }

    private final /* synthetic */ <T extends Parcelable> T getParcelableCompat(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) bundle.getParcelable(str, Parcelable.class);
        }
        T t = (T) bundle.getParcelable(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
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

    public static final ConcurrentHashMap<String, PairingSession> getSessions() {
        return INSTANCE.getSessions();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int processAction(PairingDispatcher dispatcher2, String action, PairingSession session, Parcelable payload, Intent intent) {
        C1133Unit c1133Unit;
        Log.d(f4185TAG, "processAction: action=" + action + " session=" + session.getSessionId() + " stage=" + session.getStage());
        if (Intrinsics.areEqual(action, ACTION_UPDATE_SESSION)) {
            if (this.foregroundSessionId == null) {
                this.foregroundSessionId = session.getSessionId();
            }
            if (payload != null) {
                dispatcher2.onUpdateSession(this, session, payload, Intrinsics.areEqual(this.foregroundSessionId, session.getSessionId()));
            }
        } else if (Intrinsics.areEqual(action, ACTION_TERMINATE_SESSION)) {
            boolean zAreEqual = Intrinsics.areEqual(this.foregroundSessionId, session.getSessionId());
            dispatcher2.onStopSession(this, session, payload);
            ConcurrentHashMap<String, PairingSession> concurrentHashMap = sessions;
            concurrentHashMap.remove(session.getSessionId());
            if (zAreEqual) {
                Enumeration<String> enumerationKeys = concurrentHashMap.keys();
                Intrinsics.checkNotNullExpressionValue(enumerationKeys, "keys(...)");
                String str = (String) SequencesKt.firstOrNull(SequencesKt.asSequence(CollectionsKt.iterator(enumerationKeys)));
                this.foregroundSessionId = str;
                if (str == null) {
                    dispatcher2.onExitForeground(this);
                } else {
                    PairingSession pairingSession = concurrentHashMap.get(str);
                    if (pairingSession != null) {
                        dispatcher2.onPromoteToForeground(this, pairingSession);
                        c1133Unit = C1133Unit.INSTANCE;
                    } else {
                        c1133Unit = null;
                    }
                    if (c1133Unit == null) {
                    }
                }
            }
        } else {
            dispatcher2.onHandleInput(this, intent, session);
        }
        if (!sessions.isEmpty()) {
            return 2;
        }
        stopSelf();
        return 2;
    }

    public static final void setDispatcher(PairingDispatcher pairingDispatcher) {
        INSTANCE.setDispatcher(pairingDispatcher);
    }

    public final boolean isSessionForeground$adbeesh(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return Intrinsics.areEqual(this.foregroundSessionId, sessionId);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        PairingDispatcher pairingDispatcher = dispatcher;
        if (pairingDispatcher != null) {
            pairingDispatcher.onServiceDestroyed();
        }
        sessions.clear();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action;
        PairingSession pairingSession;
        Parcelable parcelable;
        Parcelable parcelableExtra;
        Parcelable parcelable2;
        PairingSession pairingSessionPutIfAbsent;
        if (intent == null || (action = intent.getAction()) == null) {
            return 2;
        }
        String stringExtra = intent.getStringExtra(EXTRA_SESSION_ID);
        if (stringExtra == null) {
            stringExtra = BuildConfig.f24315FLAVOR;
        }
        PairingDispatcher pairingDispatcher = dispatcher;
        if (pairingDispatcher == null) {
            Log.e(f4185TAG, '[' + stringExtra + "] No dispatcher registered for " + action);
            return 2;
        }
        if (Intrinsics.areEqual(action, ACTION_UPDATE_SESSION)) {
            ConcurrentHashMap<String, PairingSession> concurrentHashMap = sessions;
            PairingSession pairingSessionOnCreateSession = concurrentHashMap.get(stringExtra);
            if (pairingSessionOnCreateSession == null && (pairingSessionPutIfAbsent = concurrentHashMap.putIfAbsent(stringExtra, (pairingSessionOnCreateSession = pairingDispatcher.onCreateSession(stringExtra)))) != null) {
                pairingSessionOnCreateSession = pairingSessionPutIfAbsent;
            }
            pairingSession = pairingSessionOnCreateSession;
        } else {
            PairingSession pairingSession2 = sessions.get(stringExtra);
            if (pairingSession2 == null) {
                return 2;
            }
            pairingSession = pairingSession2;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra(EXTRA_RESULT_RECEIVER, ResultReceiver.class);
        } else {
            Parcelable parcelableExtra2 = intent.getParcelableExtra(EXTRA_RESULT_RECEIVER);
            if (!(parcelableExtra2 instanceof ResultReceiver)) {
                parcelableExtra2 = null;
            }
            parcelable = (ResultReceiver) parcelableExtra2;
        }
        ResultReceiver resultReceiver = (ResultReceiver) parcelable;
        if (resultReceiver != null) {
            pairingSession.setResultReceiver(resultReceiver);
        }
        String stringExtra2 = intent.getStringExtra(EXTRA_PAIRING_CODE_KEY);
        if (stringExtra2 != null) {
            pairingSession.setPairingCodeKey(stringExtra2);
        }
        if (i >= 33) {
            parcelableExtra = (Parcelable) intent.getParcelableExtra(EXTRA_SESSION_DATA, Parcelable.class);
        } else {
            parcelableExtra = intent.getParcelableExtra(EXTRA_SESSION_DATA);
            if (parcelableExtra == null) {
                parcelableExtra = null;
            }
        }
        if (parcelableExtra instanceof Bundle) {
            Bundle bundle = (Bundle) parcelableExtra;
            String string = bundle.getString(EXTRA_STAGE);
            if (string != null) {
                try {
                    pairingSession.setStage(PairingStage.m4367valueOf(string));
                } catch (Exception unused) {
                }
            }
            if (bundle.containsKey(EXTRA_PORT)) {
                pairingSession.m4358setPort(Integer.valueOf(bundle.getInt(EXTRA_PORT)));
            }
            String string2 = bundle.getString(EXTRA_ERROR);
            if (string2 != null) {
                pairingSession.setError(string2);
            }
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable2 = (Parcelable) bundle.getParcelable(EXTRA_RESULT_RECEIVER, ResultReceiver.class);
            } else {
                Parcelable parcelable3 = bundle.getParcelable(EXTRA_RESULT_RECEIVER);
                parcelable2 = (ResultReceiver) (parcelable3 instanceof ResultReceiver ? parcelable3 : null);
            }
            ResultReceiver resultReceiver2 = (ResultReceiver) parcelable2;
            if (resultReceiver2 != null) {
                pairingSession.setResultReceiver(resultReceiver2);
            }
            String string3 = bundle.getString(EXTRA_PAIRING_CODE_KEY);
            if (string3 != null) {
                pairingSession.setPairingCodeKey(string3);
            }
        }
        Intrinsics.checkNotNull(pairingSession);
        return processAction(pairingDispatcher, action, pairingSession, parcelableExtra, intent);
    }

    @Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u001b¨\u0006\""}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingService$PairingSession;", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "stage", "Lcom/indidevs/android/adbeesh/pairing/PairingStage;", "port", BuildConfig.f24315FLAVOR, "error", "resultReceiver", "Landroid/os/ResultReceiver;", "pairingCodeKey", "<init>", "(Ljava/lang/String;Lcom/indidevs/android/adbeesh/pairing/PairingStage;Ljava/lang/Integer;Ljava/lang/String;Landroid/os/ResultReceiver;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getStage", "()Lcom/indidevs/android/adbeesh/pairing/PairingStage;", "setStage", "(Lcom/indidevs/android/adbeesh/pairing/PairingStage;)V", "getPort", "()Ljava/lang/Integer;", "setPort", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getError", "setError", "(Ljava/lang/String;)V", "getResultReceiver", "()Landroid/os/ResultReceiver;", "setResultReceiver", "(Landroid/os/ResultReceiver;)V", "getPairingCodeKey", "setPairingCodeKey", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static class PairingSession {
        private String error;
        private String pairingCodeKey;
        private Integer port;
        private ResultReceiver resultReceiver;
        private final String sessionId;
        private PairingStage stage;

        public PairingSession(String sessionId, PairingStage stage, Integer num, String str, ResultReceiver resultReceiver, String pairingCodeKey) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(stage, "stage");
            Intrinsics.checkNotNullParameter(pairingCodeKey, "pairingCodeKey");
            this.sessionId = sessionId;
            this.stage = stage;
            this.port = num;
            this.error = str;
            this.resultReceiver = resultReceiver;
            this.pairingCodeKey = pairingCodeKey;
        }

        public final String getError() {
            return this.error;
        }

        public final String getPairingCodeKey() {
            return this.pairingCodeKey;
        }

        public final Integer getPort() {
            return this.port;
        }

        public final ResultReceiver getResultReceiver() {
            return this.resultReceiver;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final PairingStage getStage() {
            return this.stage;
        }

        public final void setError(String str) {
            this.error = str;
        }

        public final void setPairingCodeKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pairingCodeKey = str;
        }

        /* renamed from: setPort */
        public final void m4358setPort(Integer num) {
            this.port = num;
        }

        public final void setResultReceiver(ResultReceiver resultReceiver) {
            this.resultReceiver = resultReceiver;
        }

        public final void setStage(PairingStage pairingStage) {
            Intrinsics.checkNotNullParameter(pairingStage, "<set-?>");
            this.stage = pairingStage;
        }

        public /* synthetic */ PairingSession(String str, PairingStage pairingStage, Integer num, String str2, ResultReceiver resultReceiver, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? PairingStage.SEARCHING : pairingStage, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : resultReceiver, (i & 32) != 0 ? AdbPairingService.DEFAULT_PAIRING_CODE_KEY : str3);
        }
    }
}
