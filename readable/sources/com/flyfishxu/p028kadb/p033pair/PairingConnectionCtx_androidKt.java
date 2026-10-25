package com.flyfishxu.p028kadb.p033pair;

import android.annotation.SuppressLint;
import org.conscrypt.Conscrypt;
import org.p370lsposed.hiddenapibypass.HiddenApiBypass;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\u0001b\u0010\b\u0003\u0012\f\b\u0004\u0012\b\b\fJ\u0004\b\b(\u0005¨\u0006\u0006"}, m4988d2 = {"getConscryptClass", "Ljava/lang/Class;", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx;", "Landroid/annotation/SuppressLint;", "value", "PrivateApi", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingConnectionCtx_androidKt {
    @SuppressLint({"PrivateApi"})
    public static final Class<?> getConscryptClass(PairingConnectionCtx pairingConnectionCtx) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(pairingConnectionCtx, "<this>");
        if (SslUtils.INSTANCE.getCustomConscrypt()) {
            int i = Conscrypt.f24320mjFkc;
            Intrinsics.checkNotNull(Conscrypt.class);
            return Conscrypt.class;
        }
        try {
            HiddenApiBypass.addHiddenApiExemptions("Lcom/android/org/conscrypt/Conscrypt;");
            Class<?> cls = Class.forName("com.android.org.conscrypt.Conscrypt");
            Intrinsics.checkNotNull(cls);
            return cls;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException("Cannot load Conscrypt class via HiddenApiBypass.", e);
        }
    }
}
