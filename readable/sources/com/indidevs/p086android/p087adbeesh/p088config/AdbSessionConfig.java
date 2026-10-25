package com.indidevs.p086android.p087adbeesh.p088config;

import android.content.Context;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, m4988d2 = {"Lcom/indidevs/android/adbeesh/config/AdbSessionConfig;", BuildConfig.f24315FLAVOR, "identityName", BuildConfig.f24315FLAVOR, "deviceName", "certificateSubject", "handshakeTimeoutMs", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getIdentityName", "()Ljava/lang/String;", "getDeviceName", "getCertificateSubject", "getHandshakeTimeoutMs", "()J", "resolve", "context", "Landroid/content/Context;", "resolve$adbeesh", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "Builder", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AdbSessionConfig {
    private final String certificateSubject;
    private final String deviceName;
    private final long handshakeTimeoutMs;
    private final String identityName;

    @Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/config/AdbSessionConfig$Builder;", BuildConfig.f24315FLAVOR, "<init>", "()V", "default", "Lcom/indidevs/android/adbeesh/config/AdbSessionConfig;", "identityName", BuildConfig.f24315FLAVOR, "getIdentityName", "()Ljava/lang/String;", "setIdentityName", "(Ljava/lang/String;)V", "value", "deviceName", "getDeviceName", "setDeviceName", "certificateSubject", "getCertificateSubject", "setCertificateSubject", "handshakeTimeoutMs", BuildConfig.f24315FLAVOR, "getHandshakeTimeoutMs", "()J", "setHandshakeTimeoutMs", "(J)V", "build", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nAdbSessionConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbSessionConfig.kt\ncom/indidevs/android/adbeesh/config/AdbSessionConfig$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    /* renamed from: com.indidevs.android.adbeesh.config.AdbSessionConfig$Builder */
    public static final class C0884Builder {
        private String certificateSubject;
        private final AdbSessionConfig default;
        private String deviceName;
        private long handshakeTimeoutMs;
        private String identityName;

        public C0884Builder() {
            AdbSessionConfig adbSessionConfig = new AdbSessionConfig(null, null, null, 0L, 15, null);
            this.default = adbSessionConfig;
            this.identityName = adbSessionConfig.getIdentityName();
            this.deviceName = adbSessionConfig.getDeviceName();
            this.certificateSubject = adbSessionConfig.getCertificateSubject();
            this.handshakeTimeoutMs = adbSessionConfig.getHandshakeTimeoutMs();
        }

        /* renamed from: build */
        public final AdbSessionConfig m4305build() {
            return new AdbSessionConfig(this.identityName, this.deviceName, this.certificateSubject, this.handshakeTimeoutMs);
        }

        public final C0884Builder certificateSubject(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.certificateSubject = value;
            return this;
        }

        public final C0884Builder deviceName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.deviceName = value;
            return this;
        }

        public final String getCertificateSubject() {
            return this.certificateSubject;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final long getHandshakeTimeoutMs() {
            return this.handshakeTimeoutMs;
        }

        public final String getIdentityName() {
            return this.identityName;
        }

        public final C0884Builder handshakeTimeoutMs(long value) {
            this.handshakeTimeoutMs = value;
            return this;
        }

        public final C0884Builder identityName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.identityName = value;
            return this;
        }

        public final void setCertificateSubject(String str) {
            this.certificateSubject = str;
        }

        public final void setDeviceName(String str) {
            this.deviceName = str;
        }

        public final void setHandshakeTimeoutMs(long j) {
            this.handshakeTimeoutMs = j;
        }

        public final void setIdentityName(String str) {
            this.identityName = str;
        }
    }

    public AdbSessionConfig() {
        this(null, null, null, 0L, 15, null);
    }

    public static /* synthetic */ AdbSessionConfig copy$default(AdbSessionConfig adbSessionConfig, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adbSessionConfig.identityName;
        }
        if ((i & 2) != 0) {
            str2 = adbSessionConfig.deviceName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = adbSessionConfig.certificateSubject;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = adbSessionConfig.handshakeTimeoutMs;
        }
        return adbSessionConfig.m4303copy(str, str4, str5, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIdentityName() {
        return this.identityName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCertificateSubject() {
        return this.certificateSubject;
    }

    /* renamed from: component4, reason: from getter */
    public final long getHandshakeTimeoutMs() {
        return this.handshakeTimeoutMs;
    }

    /* renamed from: copy */
    public final AdbSessionConfig m4303copy(String identityName, String deviceName, String certificateSubject, long handshakeTimeoutMs) {
        return new AdbSessionConfig(identityName, deviceName, certificateSubject, handshakeTimeoutMs);
    }

    /* renamed from: equals */
    public boolean m4304equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdbSessionConfig)) {
            return false;
        }
        AdbSessionConfig adbSessionConfig = (AdbSessionConfig) other;
        return Intrinsics.areEqual(this.identityName, adbSessionConfig.identityName) && Intrinsics.areEqual(this.deviceName, adbSessionConfig.deviceName) && Intrinsics.areEqual(this.certificateSubject, adbSessionConfig.certificateSubject) && this.handshakeTimeoutMs == adbSessionConfig.handshakeTimeoutMs;
    }

    public final String getCertificateSubject() {
        return this.certificateSubject;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final long getHandshakeTimeoutMs() {
        return this.handshakeTimeoutMs;
    }

    public final String getIdentityName() {
        return this.identityName;
    }

    public int hashCode() {
        String str = this.identityName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.certificateSubject;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.handshakeTimeoutMs);
    }

    public final AdbSessionConfig resolve$adbeesh(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        String packageName = context.getPackageName();
        String str = this.certificateSubject;
        if (str == null) {
            String str2 = this.identityName;
            if (str2 == null) {
                str2 = string;
            }
            str = "CN=" + str2 + ", O=ADBeesh, OU=" + packageName;
        }
        String str3 = str;
        String str4 = this.deviceName;
        return copy$default(this, null, (str4 == null && (str4 = this.identityName) == null) ? string : str4, str3, 0L, 9, null);
    }

    public String toString() {
        return "AdbSessionConfig(identityName=" + this.identityName + ", deviceName=" + this.deviceName + ", certificateSubject=" + this.certificateSubject + ", handshakeTimeoutMs=" + this.handshakeTimeoutMs + ')';
    }

    public AdbSessionConfig(String str, String str2, String str3, long j) {
        this.identityName = str;
        this.deviceName = str2;
        this.certificateSubject = str3;
        this.handshakeTimeoutMs = j;
    }

    public /* synthetic */ AdbSessionConfig(String str, String str2, String str3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "ADBeeshUser" : str, (i & 2) != 0 ? null : str2, (i & 4) == 0 ? str3 : null, (i & 8) != 0 ? 30000L : j);
    }
}
