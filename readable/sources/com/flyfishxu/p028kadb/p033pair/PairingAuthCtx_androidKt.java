package com.flyfishxu.p028kadb.p033pair;

import com.flyfishxu.p028kadb.p033pair.PairingAuthCtx;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C3409b7;
import p131o.EnumC3476c7;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, m4988d2 = {"CLIENT_NAME", BuildConfig.f24315FLAVOR, "getCLIENT_NAME", "()[B", "SERVER_NAME", "getSERVER_NAME", "INFO", "getINFO", "HKDF_KEY_LENGTH", BuildConfig.f24315FLAVOR, "getHKDF_KEY_LENGTH", "()I", "GCM_IV_LENGTH", "getGCM_IV_LENGTH", "createAlice", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx$Companion;", "password", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingAuthCtx_androidKt {
    public static final PairingAuthCtx createAlice(PairingAuthCtx.Companion companion, byte[] password) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            return new PairingAuthCtx(new C3409b7(EnumC3476c7.Alice, getCLIENT_NAME(), getSERVER_NAME()), password);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            return null;
        }
    }

    private static final byte[] getCLIENT_NAME() {
        return PairingAuthCtxKt.getBytes("adb pair client\u0000", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getGCM_IV_LENGTH() {
        return 12;
    }

    public static final int getHKDF_KEY_LENGTH() {
        return 16;
    }

    /* renamed from: getINFO */
    public static final byte[] m2266getINFO() {
        return PairingAuthCtxKt.getBytes("adb pairing_auth aes-128-gcm key", "UTF-8");
    }

    private static final byte[] getSERVER_NAME() {
        return PairingAuthCtxKt.getBytes("adb pair server\u0000", "UTF-8");
    }
}
