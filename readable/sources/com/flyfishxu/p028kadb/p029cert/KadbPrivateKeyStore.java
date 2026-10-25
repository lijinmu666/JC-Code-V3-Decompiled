package com.flyfishxu.p028kadb.p029cert;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", BuildConfig.f24315FLAVOR, "readPrivateKeyPem", BuildConfig.f24315FLAVOR, "writePrivateKeyPemAtomic", BuildConfig.f24315FLAVOR, "privateKeyPem", "clear", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KadbPrivateKeyStore {
    /* renamed from: clear */
    void mo2180clear();

    byte[] readPrivateKeyPem();

    void writePrivateKeyPemAtomic(byte[] privateKeyPem);
}
