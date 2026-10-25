package org.bouncycastle.p281jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.p281jce.X509LDAPCertStoreParameters;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p366x509.X509CertPairStoreSelector;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.bouncycastle.p366x509.X509StoreSpi;
import org.bouncycastle.p366x509.p367util.LDAPStoreHelper;

/* loaded from: classes2.dex */
public class X509StoreLDAPCertPairs extends X509StoreSpi {

    /* renamed from: helper */
    private LDAPStoreHelper f22052helper;

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) {
        if (!(selector instanceof X509CertPairStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f22052helper.getCrossCertificatePairs((X509CertPairStoreSelector) selector));
        return hashSet;
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.f22052helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
