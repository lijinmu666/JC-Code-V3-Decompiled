package com.flyfishxu.p028kadb.p030core;

import com.flyfishxu.p028kadb.p029cert.AdbKeyPair;
import com.flyfishxu.p028kadb.p029cert.AndroidPubkey;
import com.flyfishxu.p028kadb.p029cert.platform.DefaultDeviceName_androidKt;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, m4988d2 = {"adbPublicKey", BuildConfig.f24315FLAVOR, "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbConnectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] adbPublicKey(AdbKeyPair adbKeyPair) {
        PublicKey publicKey = adbKeyPair.getPublicKey();
        Intrinsics.checkNotNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
        return AndroidPubkey.encodeWithName((RSAPublicKey) publicKey, DefaultDeviceName_androidKt.defaultDeviceName$default(null, 1, null));
    }
}
