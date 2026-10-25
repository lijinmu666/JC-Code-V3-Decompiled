package org.conscrypt;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public interface ConscryptHostnameVerifier {
    /* renamed from: verify */
    boolean mo18423verify(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession);
}
