package com.indidevs.p086android.p087adbeesh.notifications;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@AdbeeshNotificationDsl
@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0019\u0010\u0018\u001a\u00020\u00002\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010%R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198'@'X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u0004\u0018\u00010 X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/notifications/NotificationUiBuilder;", BuildConfig.f24315FLAVOR, "title", BuildConfig.f24315FLAVOR, "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "value", "text", "getText", "setText", "bigText", "getBigText", "setBigText", "actionButtonText", "getActionButtonText", "setActionButtonText", "settingsButtonText", "getSettingsButtonText", "setSettingsButtonText", "inputLabel", "getInputLabel", "setInputLabel", "smallIconRes", BuildConfig.f24315FLAVOR, "getSmallIconRes", "()Ljava/lang/Integer;", "setSmallIconRes", "(Ljava/lang/Integer;)V", "(Ljava/lang/Integer;)Lcom/indidevs/android/adbeesh/notifications/NotificationUiBuilder;", "showOpenSettingsButton", BuildConfig.f24315FLAVOR, "getShowOpenSettingsButton", "()Ljava/lang/Boolean;", "setShowOpenSettingsButton", "(Ljava/lang/Boolean;)V", "(Ljava/lang/Boolean;)Lcom/indidevs/android/adbeesh/notifications/NotificationUiBuilder;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface NotificationUiBuilder {

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nNotificationConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationConfig.kt\ncom/indidevs/android/adbeesh/notifications/NotificationUiBuilder$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,459:1\n1#2:460\n*E\n"})
    public static final class DefaultImpls {
        public static NotificationUiBuilder actionButtonText(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.setActionButtonText(str);
            return notificationUiBuilder;
        }

        /* renamed from: bigText */
        public static NotificationUiBuilder m4353bigText(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.setBigText(str);
            return notificationUiBuilder;
        }

        public static NotificationUiBuilder inputLabel(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.setInputLabel(str);
            return notificationUiBuilder;
        }

        public static NotificationUiBuilder settingsButtonText(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.setSettingsButtonText(str);
            return notificationUiBuilder;
        }

        public static NotificationUiBuilder showOpenSettingsButton(NotificationUiBuilder notificationUiBuilder, Boolean bool) {
            notificationUiBuilder.setShowOpenSettingsButton(bool);
            return notificationUiBuilder;
        }

        public static NotificationUiBuilder smallIconRes(NotificationUiBuilder notificationUiBuilder, Integer num) {
            notificationUiBuilder.setSmallIconRes(num);
            return notificationUiBuilder;
        }

        /* renamed from: text */
        public static NotificationUiBuilder m4354text(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.mo4343setText(str);
            return notificationUiBuilder;
        }

        /* renamed from: title */
        public static NotificationUiBuilder m4355title(NotificationUiBuilder notificationUiBuilder, String str) {
            notificationUiBuilder.setTitle(str);
            return notificationUiBuilder;
        }
    }

    NotificationUiBuilder actionButtonText(String value);

    /* renamed from: bigText */
    NotificationUiBuilder mo4340bigText(String value);

    String getActionButtonText();

    String getBigText();

    String getInputLabel();

    String getSettingsButtonText();

    Boolean getShowOpenSettingsButton();

    Integer getSmallIconRes();

    /* renamed from: getText */
    String mo4342getText();

    String getTitle();

    NotificationUiBuilder inputLabel(String value);

    void setActionButtonText(String str);

    void setBigText(String str);

    void setInputLabel(String str);

    void setSettingsButtonText(String str);

    void setShowOpenSettingsButton(Boolean bool);

    void setSmallIconRes(Integer num);

    /* renamed from: setText */
    void mo4343setText(String str);

    void setTitle(String str);

    NotificationUiBuilder settingsButtonText(String value);

    NotificationUiBuilder showOpenSettingsButton(Boolean value);

    NotificationUiBuilder smallIconRes(Integer value);

    /* renamed from: text */
    NotificationUiBuilder mo4344text(String value);

    /* renamed from: title */
    NotificationUiBuilder mo4345title(String value);
}
