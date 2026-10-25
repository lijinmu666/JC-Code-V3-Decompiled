package org.bouncycastle.p281jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.p281jce.X509LDAPCertStoreParameters;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p366x509.X509AttributeCertStoreSelector;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.bouncycastle.p366x509.X509StoreSpi;
import org.bouncycastle.p366x509.p367util.LDAPStoreHelper;

/* loaded from: classes2.dex */
public class X509StoreLDAPAttrCerts extends X509StoreSpi {

    /* renamed from: helper */
    private LDAPStoreHelper f22050helper;

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) {
        if (!(selector instanceof X509AttributeCertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = (X509AttributeCertStoreSelector) selector;
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f22050helper.getAACertificates(x509AttributeCertStoreSelector));
        hashSet.addAll(this.f22050helper.getAttributeCertificateAttributes(x509AttributeCertStoreSelector));
        hashSet.addAll(this.f22050helper.getAttributeDescriptorCertificates(x509AttributeCertStoreSelector));
        return hashSet;
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.f22050helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
