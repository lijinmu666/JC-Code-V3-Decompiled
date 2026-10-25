package com.flyfishxu.p028kadb.p029cert;

import java.io.Serializable;
import java.util.List;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m4988d2 = {"KEY_BEGIN", BuildConfig.f24315FLAVOR, "KEY_END", "CERT_BEGIN", "CERT_END", "providers", BuildConfig.f24315FLAVOR, "Ljava/io/Serializable;", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CertUtilsKt {
    private static final String CERT_BEGIN = "-----BEGIN CERTIFICATE-----";
    private static final String CERT_END = "-----END CERTIFICATE-----";
    private static final String KEY_BEGIN = "-----BEGIN PRIVATE KEY-----";

    /* renamed from: KEY_END */
    private static final String f2015KEY_END = "-----END PRIVATE KEY-----";
    private static final List<Serializable> providers = CollectionsKt.m5806listOf((Object[]) new Serializable[]{null, new BouncyCastleProvider(), "AndroidOpenSSL"});
}
