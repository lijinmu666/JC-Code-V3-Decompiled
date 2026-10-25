package com.indidevs.p086android.p087adbeesh.p089pairing;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "port", BuildConfig.f24315FLAVOR, "error", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getPort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getError", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/indidevs/android/adbeesh/pairing/AdbPairingUpdate;", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", "toString", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AdbPairingUpdate {
    private final String error;
    private final Integer port;
    private final String sessionId;

    public AdbPairingUpdate(String sessionId, Integer num, String str) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.port = num;
        this.error = str;
    }

    public static /* synthetic */ AdbPairingUpdate copy$default(AdbPairingUpdate adbPairingUpdate, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adbPairingUpdate.sessionId;
        }
        if ((i & 2) != 0) {
            num = adbPairingUpdate.port;
        }
        if ((i & 4) != 0) {
            str2 = adbPairingUpdate.error;
        }
        return adbPairingUpdate.m4362copy(str, num, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getPort() {
        return this.port;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: copy */
    public final AdbPairingUpdate m4362copy(String sessionId, Integer port, String error) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new AdbPairingUpdate(sessionId, port, error);
    }

    /* renamed from: equals */
    public boolean m4363equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdbPairingUpdate)) {
            return false;
        }
        AdbPairingUpdate adbPairingUpdate = (AdbPairingUpdate) other;
        return Intrinsics.areEqual(this.sessionId, adbPairingUpdate.sessionId) && Intrinsics.areEqual(this.port, adbPairingUpdate.port) && Intrinsics.areEqual(this.error, adbPairingUpdate.error);
    }

    public final String getError() {
        return this.error;
    }

    /* renamed from: getPort */
    public final Integer m4364getPort() {
        return this.port;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iHashCode = this.sessionId.hashCode() * 31;
        Integer num = this.port;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.error;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AdbPairingUpdate(sessionId=" + this.sessionId + ", port=" + this.port + ", error=" + this.error + ')';
    }

    public /* synthetic */ AdbPairingUpdate(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
    }
}
