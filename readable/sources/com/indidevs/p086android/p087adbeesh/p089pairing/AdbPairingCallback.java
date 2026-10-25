package com.indidevs.p086android.p087adbeesh.p089pairing;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingCallback;", BuildConfig.f24315FLAVOR, "onPairingStarted", BuildConfig.f24315FLAVOR, "sessionId", BuildConfig.f24315FLAVOR, "onPortFound", "port", BuildConfig.f24315FLAVOR, "onPairingHandshakeStarted", "onPairingSuccess", "onPairingError", "error", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface AdbPairingCallback {

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        public static void onPairingError(AdbPairingCallback adbPairingCallback, String sessionId, String error) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onPairingHandshakeStarted(AdbPairingCallback adbPairingCallback, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        }

        public static void onPairingStarted(AdbPairingCallback adbPairingCallback, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        }

        public static void onPairingSuccess(AdbPairingCallback adbPairingCallback, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        }

        public static void onPortFound(AdbPairingCallback adbPairingCallback, String sessionId, int i) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        }
    }

    void onPairingError(String sessionId, String error);

    void onPairingHandshakeStarted(String sessionId);

    void onPairingStarted(String sessionId);

    void onPairingSuccess(String sessionId);

    void onPortFound(String sessionId, int port);
}
