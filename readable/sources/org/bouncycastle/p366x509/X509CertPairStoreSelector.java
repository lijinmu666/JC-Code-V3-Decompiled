package org.bouncycastle.p366x509;

import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class X509CertPairStoreSelector implements Selector {
    private X509CertificatePair certPair;
    private X509CertStoreSelector forwardSelector;
    private X509CertStoreSelector reverseSelector;

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.certPair = this.certPair;
        X509CertStoreSelector x509CertStoreSelector = this.forwardSelector;
        if (x509CertStoreSelector != null) {
            x509CertPairStoreSelector.setForwardSelector((X509CertStoreSelector) x509CertStoreSelector.mo14740clone());
        }
        X509CertStoreSelector x509CertStoreSelector2 = this.reverseSelector;
        if (x509CertStoreSelector2 != null) {
            x509CertPairStoreSelector.setReverseSelector((X509CertStoreSelector) x509CertStoreSelector2.mo14740clone());
        }
        return x509CertPairStoreSelector;
    }

    public X509CertificatePair getCertPair() {
        return this.certPair;
    }

    public X509CertStoreSelector getForwardSelector() {
        return this.forwardSelector;
    }

    public X509CertStoreSelector getReverseSelector() {
        return this.reverseSelector;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        try {
            if (!(obj instanceof X509CertificatePair)) {
                return false;
            }
            X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
            X509CertStoreSelector x509CertStoreSelector = this.forwardSelector;
            if (x509CertStoreSelector != null && !x509CertStoreSelector.mo14742match((Object) x509CertificatePair.getForward())) {
                return false;
            }
            X509CertStoreSelector x509CertStoreSelector2 = this.reverseSelector;
            if (x509CertStoreSelector2 != null && !x509CertStoreSelector2.mo14742match((Object) x509CertificatePair.getReverse())) {
                return false;
            }
            X509CertificatePair x509CertificatePair2 = this.certPair;
            if (x509CertificatePair2 != null) {
                return x509CertificatePair2.m18394equals(obj);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setCertPair(X509CertificatePair x509CertificatePair) {
        this.certPair = x509CertificatePair;
    }

    public void setForwardSelector(X509CertStoreSelector x509CertStoreSelector) {
        this.forwardSelector = x509CertStoreSelector;
    }

    public void setReverseSelector(X509CertStoreSelector x509CertStoreSelector) {
        this.reverseSelector = x509CertStoreSelector;
    }
}
