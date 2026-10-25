package com.flyfishxu.p028kadb.p029cert;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/InMemoryPrivateKeyStore;", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "<init>", "()V", "lock", BuildConfig.f24315FLAVOR, "privateKeyPem", BuildConfig.f24315FLAVOR, "readPrivateKeyPem", "writePrivateKeyPemAtomic", BuildConfig.f24315FLAVOR, "clear", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class InMemoryPrivateKeyStore implements KadbPrivateKeyStore {
    private final Object lock = new Object();
    private byte[] privateKeyPem;

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    /* renamed from: clear */
    public void mo2180clear() {
        synchronized (this.lock) {
            this.privateKeyPem = null;
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
    }

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    public byte[] readPrivateKeyPem() {
        byte[] bArrCopyOf;
        synchronized (this.lock) {
            byte[] bArr = this.privateKeyPem;
            if (bArr != null) {
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            } else {
                bArrCopyOf = null;
            }
        }
        return bArrCopyOf;
    }

    @Override // com.flyfishxu.p028kadb.p029cert.KadbPrivateKeyStore
    public void writePrivateKeyPemAtomic(byte[] privateKeyPem) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        synchronized (this.lock) {
            byte[] bArrCopyOf = Arrays.copyOf(privateKeyPem, privateKeyPem.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            this.privateKeyPem = bArrCopyOf;
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
    }
}
