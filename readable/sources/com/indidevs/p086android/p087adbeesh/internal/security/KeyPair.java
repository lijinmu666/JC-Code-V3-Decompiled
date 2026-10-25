package com.indidevs.p086android.p087adbeesh.internal.security;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", BuildConfig.f24315FLAVOR, "privateKey", "Ljava/security/PrivateKey;", "certificate", "Ljava/security/cert/X509Certificate;", "<init>", "(Ljava/security/PrivateKey;Ljava/security/cert/X509Certificate;)V", "getPrivateKey", "()Ljava/security/PrivateKey;", "getCertificate", "()Ljava/security/cert/X509Certificate;", "component1", "component2", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyPair {
    private final X509Certificate certificate;
    private final PrivateKey privateKey;

    public KeyPair(PrivateKey privateKey, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        this.privateKey = privateKey;
        this.certificate = certificate;
    }

    public static /* synthetic */ KeyPair copy$default(KeyPair keyPair, PrivateKey privateKey, X509Certificate x509Certificate, int i, Object obj) {
        if ((i & 1) != 0) {
            privateKey = keyPair.privateKey;
        }
        if ((i & 2) != 0) {
            x509Certificate = keyPair.certificate;
        }
        return keyPair.m4335copy(privateKey, x509Certificate);
    }

    /* renamed from: component1, reason: from getter */
    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    /* renamed from: component2, reason: from getter */
    public final X509Certificate getCertificate() {
        return this.certificate;
    }

    /* renamed from: copy */
    public final KeyPair m4335copy(PrivateKey privateKey, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return new KeyPair(privateKey, certificate);
    }

    /* renamed from: equals */
    public boolean m4336equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyPair)) {
            return false;
        }
        KeyPair keyPair = (KeyPair) other;
        return Intrinsics.areEqual(this.privateKey, keyPair.privateKey) && Intrinsics.areEqual(this.certificate, keyPair.certificate);
    }

    public final X509Certificate getCertificate() {
        return this.certificate;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public int hashCode() {
        return (this.privateKey.hashCode() * 31) + this.certificate.hashCode();
    }

    public String toString() {
        return "KeyPair(privateKey=" + this.privateKey + ", certificate=" + this.certificate + ')';
    }
}
