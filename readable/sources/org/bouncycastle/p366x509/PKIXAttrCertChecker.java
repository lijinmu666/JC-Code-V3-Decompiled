package org.bouncycastle.p366x509;

import java.security.cert.CertPath;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class PKIXAttrCertChecker implements Cloneable {
    /* renamed from: check */
    public abstract void m18388check(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, Collection collection);

    /* renamed from: clone */
    public abstract Object m18389clone();

    public abstract Set getSupportedExtensions();
}
