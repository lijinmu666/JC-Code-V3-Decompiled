package org.bouncycastle.p281jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.p281jce.X509LDAPCertStoreParameters;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p366x509.X509CertPairStoreSelector;
import org.bouncycastle.p366x509.X509CertStoreSelector;
import org.bouncycastle.p366x509.X509CertificatePair;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.bouncycastle.p366x509.X509StoreSpi;
import org.bouncycastle.p366x509.p367util.LDAPStoreHelper;

/* loaded from: classes2.dex */
public class X509StoreLDAPCerts extends X509StoreSpi {

    /* renamed from: helper */
    private LDAPStoreHelper f22053helper;

    private Collection getCertificatesFromCrossCertificatePairs(X509CertStoreSelector x509CertStoreSelector) {
        HashSet hashSet = new HashSet();
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.setForwardSelector(x509CertStoreSelector);
        x509CertPairStoreSelector.setReverseSelector(new X509CertStoreSelector());
        HashSet<X509CertificatePair> hashSet2 = new HashSet(this.f22053helper.getCrossCertificatePairs(x509CertPairStoreSelector));
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (X509CertificatePair x509CertificatePair : hashSet2) {
            if (x509CertificatePair.getForward() != null) {
                hashSet3.add(x509CertificatePair.getForward());
            }
            if (x509CertificatePair.getReverse() != null) {
                hashSet4.add(x509CertificatePair.getReverse());
            }
        }
        hashSet.addAll(hashSet3);
        hashSet.addAll(hashSet4);
        return hashSet;
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) {
        Collection userCertificates;
        if (!(selector instanceof X509CertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CertStoreSelector x509CertStoreSelector = (X509CertStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CertStoreSelector.getBasicConstraints() > 0) {
            hashSet.addAll(this.f22053helper.getCACertificates(x509CertStoreSelector));
            userCertificates = getCertificatesFromCrossCertificatePairs(x509CertStoreSelector);
        } else if (x509CertStoreSelector.getBasicConstraints() == -2) {
            userCertificates = this.f22053helper.getUserCertificates(x509CertStoreSelector);
        } else {
            hashSet.addAll(this.f22053helper.getUserCertificates(x509CertStoreSelector));
            hashSet.addAll(this.f22053helper.getCACertificates(x509CertStoreSelector));
            userCertificates = getCertificatesFromCrossCertificatePairs(x509CertStoreSelector);
        }
        hashSet.addAll(userCertificates);
        return hashSet;
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.f22053helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
