package com.flyfishxu.p028kadb.p029cert;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", BuildConfig.f24315FLAVOR, "privateKeyPem", BuildConfig.f24315FLAVOR, "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "snapshot", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "<init>", "([BLcom/flyfishxu/kadb/cert/AdbKeyPair;Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;)V", "getPrivateKeyPem", "()[B", "getKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getSnapshot", "()Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "component1", "component2", "component3", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ResolvedIdentity {
    private final AdbKeyPair keyPair;
    private final byte[] privateKeyPem;
    private final KadbIdentitySnapshot snapshot;

    public ResolvedIdentity(byte[] privateKeyPem, AdbKeyPair keyPair, KadbIdentitySnapshot snapshot) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.privateKeyPem = privateKeyPem;
        this.keyPair = keyPair;
        this.snapshot = snapshot;
    }

    public static /* synthetic */ ResolvedIdentity copy$default(ResolvedIdentity resolvedIdentity, byte[] bArr, AdbKeyPair adbKeyPair, KadbIdentitySnapshot kadbIdentitySnapshot, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = resolvedIdentity.privateKeyPem;
        }
        if ((i & 2) != 0) {
            adbKeyPair = resolvedIdentity.keyPair;
        }
        if ((i & 4) != 0) {
            kadbIdentitySnapshot = resolvedIdentity.snapshot;
        }
        return resolvedIdentity.m2200copy(bArr, adbKeyPair, kadbIdentitySnapshot);
    }

    /* renamed from: component1, reason: from getter */
    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    /* renamed from: component2, reason: from getter */
    public final AdbKeyPair getKeyPair() {
        return this.keyPair;
    }

    /* renamed from: component3, reason: from getter */
    public final KadbIdentitySnapshot getSnapshot() {
        return this.snapshot;
    }

    /* renamed from: copy */
    public final ResolvedIdentity m2200copy(byte[] privateKeyPem, AdbKeyPair keyPair, KadbIdentitySnapshot snapshot) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return new ResolvedIdentity(privateKeyPem, keyPair, snapshot);
    }

    /* renamed from: equals */
    public boolean m2201equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolvedIdentity)) {
            return false;
        }
        ResolvedIdentity resolvedIdentity = (ResolvedIdentity) other;
        return Intrinsics.areEqual(this.privateKeyPem, resolvedIdentity.privateKeyPem) && Intrinsics.areEqual(this.keyPair, resolvedIdentity.keyPair) && Intrinsics.areEqual(this.snapshot, resolvedIdentity.snapshot);
    }

    public final AdbKeyPair getKeyPair() {
        return this.keyPair;
    }

    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    public final KadbIdentitySnapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.privateKeyPem) * 31) + this.keyPair.hashCode()) * 31) + this.snapshot.hashCode();
    }

    public String toString() {
        return "ResolvedIdentity(privateKeyPem=" + Arrays.toString(this.privateKeyPem) + ", keyPair=" + this.keyPair + ", snapshot=" + this.snapshot + ")";
    }
}
