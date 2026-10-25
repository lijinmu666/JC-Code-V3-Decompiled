package com.flyfishxu.p028kadb.p029cert;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", BuildConfig.f24315FLAVOR, "privateKeyPem", BuildConfig.f24315FLAVOR, "certificatePem", "fingerprintSha256", BuildConfig.f24315FLAVOR, "notAfterEpochMillis", BuildConfig.f24315FLAVOR, "<init>", "([B[BLjava/lang/String;J)V", "getPrivateKeyPem", "()[B", "getCertificatePem", "getFingerprintSha256", "()Ljava/lang/String;", "getNotAfterEpochMillis", "()J", "deepCopy", "deepCopy$com_github_IndiTheo_kadb", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KadbIdentitySnapshot {
    private final byte[] certificatePem;
    private final String fingerprintSha256;
    private final long notAfterEpochMillis;
    private final byte[] privateKeyPem;

    public KadbIdentitySnapshot(byte[] privateKeyPem, byte[] certificatePem, String fingerprintSha256, long j) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(certificatePem, "certificatePem");
        Intrinsics.checkNotNullParameter(fingerprintSha256, "fingerprintSha256");
        this.privateKeyPem = privateKeyPem;
        this.certificatePem = certificatePem;
        this.fingerprintSha256 = fingerprintSha256;
        this.notAfterEpochMillis = j;
    }

    public static /* synthetic */ KadbIdentitySnapshot copy$default(KadbIdentitySnapshot kadbIdentitySnapshot, byte[] bArr, byte[] bArr2, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = kadbIdentitySnapshot.privateKeyPem;
        }
        if ((i & 2) != 0) {
            bArr2 = kadbIdentitySnapshot.certificatePem;
        }
        byte[] bArr3 = bArr2;
        if ((i & 4) != 0) {
            str = kadbIdentitySnapshot.fingerprintSha256;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            j = kadbIdentitySnapshot.notAfterEpochMillis;
        }
        return kadbIdentitySnapshot.m2198copy(bArr, bArr3, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getCertificatePem() {
        return this.certificatePem;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFingerprintSha256() {
        return this.fingerprintSha256;
    }

    /* renamed from: component4, reason: from getter */
    public final long getNotAfterEpochMillis() {
        return this.notAfterEpochMillis;
    }

    /* renamed from: copy */
    public final KadbIdentitySnapshot m2198copy(byte[] privateKeyPem, byte[] certificatePem, String fingerprintSha256, long notAfterEpochMillis) {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(certificatePem, "certificatePem");
        Intrinsics.checkNotNullParameter(fingerprintSha256, "fingerprintSha256");
        return new KadbIdentitySnapshot(privateKeyPem, certificatePem, fingerprintSha256, notAfterEpochMillis);
    }

    public final KadbIdentitySnapshot deepCopy$com_github_IndiTheo_kadb() {
        byte[] bArr = this.privateKeyPem;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        byte[] bArr2 = this.certificatePem;
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
        return copy$default(this, bArrCopyOf, bArrCopyOf2, null, 0L, 12, null);
    }

    /* renamed from: equals */
    public boolean m2199equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KadbIdentitySnapshot)) {
            return false;
        }
        KadbIdentitySnapshot kadbIdentitySnapshot = (KadbIdentitySnapshot) other;
        return Intrinsics.areEqual(this.privateKeyPem, kadbIdentitySnapshot.privateKeyPem) && Intrinsics.areEqual(this.certificatePem, kadbIdentitySnapshot.certificatePem) && Intrinsics.areEqual(this.fingerprintSha256, kadbIdentitySnapshot.fingerprintSha256) && this.notAfterEpochMillis == kadbIdentitySnapshot.notAfterEpochMillis;
    }

    public final byte[] getCertificatePem() {
        return this.certificatePem;
    }

    public final String getFingerprintSha256() {
        return this.fingerprintSha256;
    }

    public final long getNotAfterEpochMillis() {
        return this.notAfterEpochMillis;
    }

    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.privateKeyPem) * 31) + Arrays.hashCode(this.certificatePem)) * 31) + this.fingerprintSha256.hashCode()) * 31) + Long.hashCode(this.notAfterEpochMillis);
    }

    public String toString() {
        return "KadbIdentitySnapshot(privateKeyPem=" + Arrays.toString(this.privateKeyPem) + ", certificatePem=" + Arrays.toString(this.certificatePem) + ", fingerprintSha256=" + this.fingerprintSha256 + ", notAfterEpochMillis=" + this.notAfterEpochMillis + ")";
    }
}
