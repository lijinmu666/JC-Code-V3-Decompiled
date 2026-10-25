package org.bouncycastle.p281jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.p281jce.X509LDAPCertStoreParameters;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p366x509.X509CRLStoreSelector;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.bouncycastle.p366x509.X509StoreSpi;
import org.bouncycastle.p366x509.p367util.LDAPStoreHelper;

/* loaded from: classes2.dex */
public class X509StoreLDAPCRLs extends X509StoreSpi {

    /* renamed from: helper */
    private LDAPStoreHelper f22051helper;

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) {
        Collection certificateRevocationLists;
        if (!(selector instanceof X509CRLStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CRLStoreSelector x509CRLStoreSelector = (X509CRLStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CRLStoreSelector.isDeltaCRLIndicatorEnabled()) {
            certificateRevocationLists = this.f22051helper.getDeltaCertificateRevocationLists(x509CRLStoreSelector);
        } else {
            hashSet.addAll(this.f22051helper.getDeltaCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.f22051helper.getAttributeAuthorityRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.f22051helper.getAttributeCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.f22051helper.getAuthorityRevocationLists(x509CRLStoreSelector));
            certificateRevocationLists = this.f22051helper.getCertificateRevocationLists(x509CRLStoreSelector);
        }
        hashSet.addAll(certificateRevocationLists);
        return hashSet;
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.f22051helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
