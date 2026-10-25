package com.indidevs.p086android.p087adbeesh.notifications;

import android.R;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationConfig;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import com.indidevs.p086android.p087adbeesh.p089pairing.AdbPairingUpdate;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 %2\u00020\u0001:\u0002$%B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001e¨\u0006&"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", BuildConfig.f24315FLAVOR, "notificationChannelId", BuildConfig.f24315FLAVOR, "notificationChannelName", "notificationId", BuildConfig.f24315FLAVOR, "baseNotificationId", "baseRequestCode", "searching", "Lkotlin/Function1;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", "Lcom/indidevs/android/adbeesh/notifications/NotificationConfig;", "awaitingCode", "codeSubmitted", "pairing", "success", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getNotificationChannelId", "()Ljava/lang/String;", "getNotificationChannelName", "getNotificationId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseNotificationId", "()I", "getBaseRequestCode", "getSearching", "()Lkotlin/jvm/functions/Function1;", "getAwaitingCode", "getCodeSubmitted", "getPairing", "getSuccess", "getError", "Builder", "Companion", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class NotificationFlowConfig {
    public static final int DEFAULT_BASE_NOTIFICATION_ID = 10000;
    public static final int DEFAULT_BASE_REQUEST_CODE = 1000;
    public static final String DEFAULT_CHANNEL_ID = "adbeesh_pairing_channel_v0";
    public static final String DEFAULT_CHANNEL_NAME = "ADB Pairing Discovery";
    private static final Integer DEFAULT_NOTIFICATION_ID = null;
    public static final boolean DEFAULT_SHOW_SETTINGS = true;
    private final Function1<AdbPairingUpdate, NotificationConfig> awaitingCode;
    private final int baseNotificationId;
    private final int baseRequestCode;
    private final Function1<AdbPairingUpdate, NotificationConfig> codeSubmitted;
    private final Function1<AdbPairingUpdate, NotificationConfig> error;
    private final String notificationChannelId;
    private final String notificationChannelName;
    private final Integer notificationId;
    private final Function1<AdbPairingUpdate, NotificationConfig> pairing;
    private final Function1<AdbPairingUpdate, NotificationConfig> searching;
    private final Function1<AdbPairingUpdate, NotificationConfig> success;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_SMALL_ICON = R.drawable.ic_dialog_info;
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_SEARCHING = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_SEARCHING$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new NotificationConfig("Wireless Debugging Required", "Tap here and go to \"Wireless Debugging\"", "Go to \"Wireless Debugging\" in Developer Options.\nTap \"Pair device with pairing code\".", null, "OPEN SETTINGS", null, 0, false, 232, null);
        }
    };
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_AWAITING_CODE = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_AWAITING_CODE$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate update) {
            Intrinsics.checkNotNullParameter(update, "update");
            Integer numM4364getPort = update.m4364getPort();
            return new NotificationConfig("Enter Pairing Code", "Port " + (numM4364getPort != null ? numM4364getPort.intValue() : 0) + " found. Enter Wi-Fi pairing code:", null, "ENTER CODE", "OPEN SETTINGS", "Wi-Fi pairing code", 0, false, 196, null);
        }
    };
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_CODE_SUBMITTED = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_CODE_SUBMITTED$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new NotificationConfig("Code Submitted", "Handshaking with device...", null, null, null, null, 0, false, 124, null);
        }
    };
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_PAIRING = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_PAIRING$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new NotificationConfig("Connecting...", "Pairing ADB via Wireless Debugging.", null, null, null, null, 0, false, 124, null);
        }
    };
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_SUCCESS = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_SUCCESS$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new NotificationConfig("Connected!", "ADB pairing successful.", null, null, null, null, 0, false, 124, null);
        }
    };
    private static final Function1<AdbPairingUpdate, NotificationConfig> DEFAULT_ERROR = new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Companion$DEFAULT_ERROR$1
        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final NotificationConfig mo2237invoke(AdbPairingUpdate update) {
            Intrinsics.checkNotNullParameter(update, "update");
            String error = update.getError();
            if (error == null) {
                error = "Unknown error";
            }
            return new NotificationConfig("Pairing Failed", "Error: " + error, null, null, null, null, 0, false, 252, null);
        }
    };

    @Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u0016\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005J\u0015\u0010\r\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010)J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000eJ%\u0010+\u001a\u00020,*\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0002J\u000e\u00102\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u000e\u00106\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u000e\u00107\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001dJ\u0006\u00108\u001a\u000209R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig$Builder;", BuildConfig.f24315FLAVOR, "<init>", "()V", "channelId", BuildConfig.f24315FLAVOR, "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "channelName", "getChannelName", "setChannelName", "notificationId", BuildConfig.f24315FLAVOR, "getNotificationId", "()Ljava/lang/Integer;", "setNotificationId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "baseNotificationId", "getBaseNotificationId", "()I", "setBaseNotificationId", "(I)V", "baseRequestCode", "getBaseRequestCode", "setBaseRequestCode", "searchingModifier", "Lcom/indidevs/android/adbeesh/notifications/AdbeeshNotificationAction;", "awaitingCodeModifier", "codeSubmittedModifier", "pairingModifier", "successModifier", "errorModifier", "commonModifier", "common", "action", "channel", "id", "name", "(Ljava/lang/Integer;)Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig$Builder;", "code", "edit", "Lcom/indidevs/android/adbeesh/notifications/NotificationConfig;", "block", "Lkotlin/Function1;", "Lcom/indidevs/android/adbeesh/notifications/NotificationUiBuilder;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "searching", "awaitingCode", "codeSubmitted", "pairing", "success", "error", "build", "Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @AdbeeshNotificationDsl
    @SourceDebugExtension(m6344value = {"SMAP\nNotificationConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationConfig.kt\ncom/indidevs/android/adbeesh/notifications/NotificationFlowConfig$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,459:1\n1#2:460\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder */
    public static final class C0900Builder {
        private AdbeeshNotificationAction awaitingCodeModifier;
        private AdbeeshNotificationAction codeSubmittedModifier;
        private AdbeeshNotificationAction commonModifier;
        private AdbeeshNotificationAction errorModifier;
        private AdbeeshNotificationAction pairingModifier;
        private AdbeeshNotificationAction searchingModifier;
        private AdbeeshNotificationAction successModifier;
        private String channelId = NotificationFlowConfig.DEFAULT_CHANNEL_ID;
        private String channelName = NotificationFlowConfig.DEFAULT_CHANNEL_NAME;
        private Integer notificationId = NotificationFlowConfig.INSTANCE.getDEFAULT_NOTIFICATION_ID();
        private int baseNotificationId = 10000;
        private int baseRequestCode = NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE;

        private static final Function1<AdbPairingUpdate, NotificationConfig> build$wrap(final C0900Builder c0900Builder, final Function1<? super AdbPairingUpdate, NotificationConfig> function1, final AdbeeshNotificationAction adbeeshNotificationAction) {
            return new Function1<AdbPairingUpdate, NotificationConfig>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$build$wrap$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final NotificationConfig mo2237invoke(final AdbPairingUpdate update) {
                    Intrinsics.checkNotNullParameter(update, "update");
                    NotificationFlowConfig.C0900Builder c0900Builder2 = this.f4170this$0;
                    NotificationConfig notificationConfigMo2237invoke = function1.mo2237invoke(update);
                    final NotificationFlowConfig.C0900Builder c0900Builder3 = this.f4170this$0;
                    final AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    return c0900Builder2.m4346edit(notificationConfigMo2237invoke, new Function1<NotificationUiBuilder, C1133Unit>() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$build$wrap$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // p094kotlin.p105jvm.functions.Function1
                        /* renamed from: invoke */
                        public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(NotificationUiBuilder notificationUiBuilder) {
                            invoke2(notificationUiBuilder);
                            return C1133Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(NotificationUiBuilder edit) {
                            Intrinsics.checkNotNullParameter(edit, "$this$edit");
                            AdbeeshNotificationAction adbeeshNotificationAction3 = c0900Builder3.commonModifier;
                            if (adbeeshNotificationAction3 != null) {
                                adbeeshNotificationAction3.configure(edit, update);
                            }
                            AdbeeshNotificationAction adbeeshNotificationAction4 = adbeeshNotificationAction2;
                            if (adbeeshNotificationAction4 != null) {
                                adbeeshNotificationAction4.configure(edit, update);
                            }
                        }
                    });
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: edit */
        public final NotificationConfig m4346edit(NotificationConfig notificationConfig, Function1<? super NotificationUiBuilder, C1133Unit> function1) {
            NotificationConfig.C0899Builder c0899Builder = new NotificationConfig.C0899Builder(notificationConfig);
            function1.mo2237invoke(c0899Builder);
            return c0899Builder.m4341build();
        }

        public final C0900Builder awaitingCode(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.awaitingCodeModifier;
            this.awaitingCodeModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$awaitingCode$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        public final C0900Builder baseNotificationId(int id) {
            this.baseNotificationId = id;
            return this;
        }

        public final C0900Builder baseRequestCode(int code) {
            this.baseRequestCode = code;
            return this;
        }

        /* renamed from: build */
        public final NotificationFlowConfig m4347build() {
            return new NotificationFlowConfig(this.channelId, this.channelName, this.notificationId, this.baseNotificationId, this.baseRequestCode, build$wrap(this, NotificationFlowConfig.DEFAULT_SEARCHING, this.searchingModifier), build$wrap(this, NotificationFlowConfig.DEFAULT_AWAITING_CODE, this.awaitingCodeModifier), build$wrap(this, NotificationFlowConfig.DEFAULT_CODE_SUBMITTED, this.codeSubmittedModifier), build$wrap(this, NotificationFlowConfig.DEFAULT_PAIRING, this.pairingModifier), build$wrap(this, NotificationFlowConfig.DEFAULT_SUCCESS, this.successModifier), build$wrap(this, NotificationFlowConfig.DEFAULT_ERROR, this.errorModifier));
        }

        /* renamed from: channel */
        public final C0900Builder m4348channel(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.channelId = id;
            this.channelName = name;
            return this;
        }

        public final C0900Builder codeSubmitted(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.codeSubmittedModifier;
            this.codeSubmittedModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$codeSubmitted$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        /* renamed from: common */
        public final C0900Builder m4349common(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.commonModifier;
            this.commonModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$common$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        /* renamed from: error */
        public final C0900Builder m4350error(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.errorModifier;
            this.errorModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$error$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        public final int getBaseNotificationId() {
            return this.baseNotificationId;
        }

        public final int getBaseRequestCode() {
            return this.baseRequestCode;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final Integer getNotificationId() {
            return this.notificationId;
        }

        public final C0900Builder notificationId(Integer id) {
            this.notificationId = id;
            return this;
        }

        /* renamed from: pairing */
        public final C0900Builder m4351pairing(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.pairingModifier;
            this.pairingModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$pairing$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        public final C0900Builder searching(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.searchingModifier;
            this.searchingModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$searching$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }

        public final void setBaseNotificationId(int i) {
            this.baseNotificationId = i;
        }

        public final void setBaseRequestCode(int i) {
            this.baseRequestCode = i;
        }

        public final void setChannelId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelId = str;
        }

        public final void setChannelName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelName = str;
        }

        public final void setNotificationId(Integer num) {
            this.notificationId = num;
        }

        /* renamed from: success */
        public final C0900Builder m4352success(final AdbeeshNotificationAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final AdbeeshNotificationAction adbeeshNotificationAction = this.successModifier;
            this.successModifier = new AdbeeshNotificationAction() { // from class: com.indidevs.android.adbeesh.notifications.NotificationFlowConfig$Builder$success$1$1
                @Override // com.indidevs.p086android.p087adbeesh.notifications.AdbeeshNotificationAction
                public final void configure(NotificationUiBuilder AdbeeshNotificationAction, AdbPairingUpdate u) {
                    Intrinsics.checkNotNullParameter(AdbeeshNotificationAction, "$this$AdbeeshNotificationAction");
                    Intrinsics.checkNotNullParameter(u, "u");
                    AdbeeshNotificationAction adbeeshNotificationAction2 = adbeeshNotificationAction;
                    if (adbeeshNotificationAction2 != null) {
                        adbeeshNotificationAction2.configure(AdbeeshNotificationAction, u);
                    }
                    action.configure(AdbeeshNotificationAction, u);
                }
            };
            return this;
        }
    }

    @Metadata(m4987d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationFlowConfig$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "DEFAULT_CHANNEL_ID", BuildConfig.f24315FLAVOR, "DEFAULT_CHANNEL_NAME", "DEFAULT_BASE_NOTIFICATION_ID", BuildConfig.f24315FLAVOR, "DEFAULT_BASE_REQUEST_CODE", "DEFAULT_SHOW_SETTINGS", BuildConfig.f24315FLAVOR, "DEFAULT_SMALL_ICON", "getDEFAULT_SMALL_ICON", "()I", "DEFAULT_NOTIFICATION_ID", "getDEFAULT_NOTIFICATION_ID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "DEFAULT_SEARCHING", "Lkotlin/Function1;", "Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", "Lcom/indidevs/android/adbeesh/notifications/NotificationConfig;", "DEFAULT_AWAITING_CODE", "DEFAULT_CODE_SUBMITTED", "DEFAULT_PAIRING", "DEFAULT_SUCCESS", "DEFAULT_ERROR", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Integer getDEFAULT_NOTIFICATION_ID() {
            return NotificationFlowConfig.DEFAULT_NOTIFICATION_ID;
        }

        public final int getDEFAULT_SMALL_ICON() {
            return NotificationFlowConfig.DEFAULT_SMALL_ICON;
        }

        private Companion() {
        }
    }

    public NotificationFlowConfig() {
        this(null, null, null, 0, 0, null, null, null, null, null, null, 2047, null);
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getAwaitingCode() {
        return this.awaitingCode;
    }

    public final int getBaseNotificationId() {
        return this.baseNotificationId;
    }

    public final int getBaseRequestCode() {
        return this.baseRequestCode;
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getCodeSubmitted() {
        return this.codeSubmitted;
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getError() {
        return this.error;
    }

    public final String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public final String getNotificationChannelName() {
        return this.notificationChannelName;
    }

    public final Integer getNotificationId() {
        return this.notificationId;
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getPairing() {
        return this.pairing;
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getSearching() {
        return this.searching;
    }

    public final Function1<AdbPairingUpdate, NotificationConfig> getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationFlowConfig(String notificationChannelId, String notificationChannelName, Integer num, int i, int i2, Function1<? super AdbPairingUpdate, NotificationConfig> searching, Function1<? super AdbPairingUpdate, NotificationConfig> awaitingCode, Function1<? super AdbPairingUpdate, NotificationConfig> codeSubmitted, Function1<? super AdbPairingUpdate, NotificationConfig> pairing, Function1<? super AdbPairingUpdate, NotificationConfig> success, Function1<? super AdbPairingUpdate, NotificationConfig> error) {
        Intrinsics.checkNotNullParameter(notificationChannelId, "notificationChannelId");
        Intrinsics.checkNotNullParameter(notificationChannelName, "notificationChannelName");
        Intrinsics.checkNotNullParameter(searching, "searching");
        Intrinsics.checkNotNullParameter(awaitingCode, "awaitingCode");
        Intrinsics.checkNotNullParameter(codeSubmitted, "codeSubmitted");
        Intrinsics.checkNotNullParameter(pairing, "pairing");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
        this.notificationChannelId = notificationChannelId;
        this.notificationChannelName = notificationChannelName;
        this.notificationId = num;
        this.baseNotificationId = i;
        this.baseRequestCode = i2;
        this.searching = searching;
        this.awaitingCode = awaitingCode;
        this.codeSubmitted = codeSubmitted;
        this.pairing = pairing;
        this.success = success;
        this.error = error;
    }

    public /* synthetic */ NotificationFlowConfig(String str, String str2, Integer num, int i, int i2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? DEFAULT_CHANNEL_ID : str, (i3 & 2) != 0 ? DEFAULT_CHANNEL_NAME : str2, (i3 & 4) != 0 ? DEFAULT_NOTIFICATION_ID : num, (i3 & 8) != 0 ? 10000 : i, (i3 & 16) != 0 ? DEFAULT_BASE_REQUEST_CODE : i2, (i3 & 32) != 0 ? DEFAULT_SEARCHING : function1, (i3 & 64) != 0 ? DEFAULT_AWAITING_CODE : function12, (i3 & 128) != 0 ? DEFAULT_CODE_SUBMITTED : function13, (i3 & 256) != 0 ? DEFAULT_PAIRING : function14, (i3 & 512) != 0 ? DEFAULT_SUCCESS : function15, (i3 & 1024) != 0 ? DEFAULT_ERROR : function16);
    }
}
