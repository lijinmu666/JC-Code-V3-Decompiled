package org.bouncycastle.p226est.p227jcajce;

import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public interface JsseHostnameAuthorizer {
    boolean verified(String str, SSLSession sSLSession);
}
