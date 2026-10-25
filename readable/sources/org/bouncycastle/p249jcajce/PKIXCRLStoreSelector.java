package org.bouncycastle.p249jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class PKIXCRLStoreSelector<T extends CRL> implements Selector<T> {
    private final CRLSelector baseSelector;
    private final boolean completeCRLEnabled;
    private final boolean deltaCRLIndicator;
    private final byte[] issuingDistributionPoint;
    private final boolean issuingDistributionPointEnabled;
    private final BigInteger maxBaseCRLNumber;

    /* renamed from: org.bouncycastle.jcajce.PKIXCRLStoreSelector$Builder */
    public static class C5477Builder {
        private final CRLSelector baseSelector;
        private boolean deltaCRLIndicator = false;
        private boolean completeCRLEnabled = false;
        private BigInteger maxBaseCRLNumber = null;
        private byte[] issuingDistributionPoint = null;
        private boolean issuingDistributionPointEnabled = false;

        public C5477Builder(CRLSelector cRLSelector) {
            this.baseSelector = (CRLSelector) cRLSelector.clone();
        }

        /* renamed from: build */
        public PKIXCRLStoreSelector<? extends CRL> m16074build() {
            return new PKIXCRLStoreSelector<>(this);
        }

        public C5477Builder setCompleteCRLEnabled(boolean z) {
            this.completeCRLEnabled = z;
            return this;
        }

        public C5477Builder setDeltaCRLIndicatorEnabled(boolean z) {
            this.deltaCRLIndicator = z;
            return this;
        }

        public void setIssuingDistributionPoint(byte[] bArr) {
            this.issuingDistributionPoint = C6238Arrays.m18231clone(bArr);
        }

        public void setIssuingDistributionPointEnabled(boolean z) {
            this.issuingDistributionPointEnabled = z;
        }

        public void setMaxBaseCRLNumber(BigInteger bigInteger) {
            this.maxBaseCRLNumber = bigInteger;
        }
    }

    public static class SelectorClone extends X509CRLSelector {
        private final PKIXCRLStoreSelector selector;

        public SelectorClone(PKIXCRLStoreSelector pKIXCRLStoreSelector) {
            this.selector = pKIXCRLStoreSelector;
            if (pKIXCRLStoreSelector.baseSelector instanceof X509CRLSelector) {
                X509CRLSelector x509CRLSelector = (X509CRLSelector) pKIXCRLStoreSelector.baseSelector;
                setCertificateChecking(x509CRLSelector.getCertificateChecking());
                setDateAndTime(x509CRLSelector.getDateAndTime());
                setIssuers(x509CRLSelector.getIssuers());
                setMinCRLNumber(x509CRLSelector.getMinCRL());
                setMaxCRLNumber(x509CRLSelector.getMaxCRL());
            }
        }

        @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
        public boolean match(CRL crl) {
            PKIXCRLStoreSelector pKIXCRLStoreSelector = this.selector;
            return pKIXCRLStoreSelector == null ? crl != null : pKIXCRLStoreSelector.mo14742match(crl);
        }
    }

    private PKIXCRLStoreSelector(C5477Builder c5477Builder) {
        this.baseSelector = c5477Builder.baseSelector;
        this.deltaCRLIndicator = c5477Builder.deltaCRLIndicator;
        this.completeCRLEnabled = c5477Builder.completeCRLEnabled;
        this.maxBaseCRLNumber = c5477Builder.maxBaseCRLNumber;
        this.issuingDistributionPoint = c5477Builder.issuingDistributionPoint;
        this.issuingDistributionPointEnabled = c5477Builder.issuingDistributionPointEnabled;
    }

    /* renamed from: getCRLs */
    public static Collection<? extends CRL> m16072getCRLs(PKIXCRLStoreSelector pKIXCRLStoreSelector, CertStore certStore) {
        return certStore.getCRLs(new SelectorClone(pKIXCRLStoreSelector));
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return this;
    }

    public X509Certificate getCertificateChecking() {
        CRLSelector cRLSelector = this.baseSelector;
        if (cRLSelector instanceof X509CRLSelector) {
            return ((X509CRLSelector) cRLSelector).getCertificateChecking();
        }
        return null;
    }

    public byte[] getIssuingDistributionPoint() {
        return C6238Arrays.m18231clone(this.issuingDistributionPoint);
    }

    public BigInteger getMaxBaseCRLNumber() {
        return this.maxBaseCRLNumber;
    }

    public boolean isCompleteCRLEnabled() {
        return this.completeCRLEnabled;
    }

    public boolean isDeltaCRLIndicatorEnabled() {
        return this.deltaCRLIndicator;
    }

    public boolean isIssuingDistributionPointEnabled() {
        return this.issuingDistributionPointEnabled;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        if (org.bouncycastle.p361util.C6238Arrays.areEqual(r0, r2) == false) goto L32;
     */
    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo14742match(CRL crl) {
        if (crl instanceof X509CRL) {
            X509CRL x509crl = (X509CRL) crl;
            try {
                byte[] extensionValue = x509crl.getExtensionValue(Extension.deltaCRLIndicator.m14433getId());
                ASN1Integer aSN1Integer = extensionValue != null ? ASN1Integer.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()) : null;
                if (aSN1Integer == null) {
                    if (isDeltaCRLIndicatorEnabled()) {
                        return false;
                    }
                } else {
                    if (isCompleteCRLEnabled()) {
                        return false;
                    }
                    if (this.maxBaseCRLNumber != null && aSN1Integer.getPositiveValue().compareTo(this.maxBaseCRLNumber) == 1) {
                        return false;
                    }
                }
                if (this.issuingDistributionPointEnabled) {
                    byte[] extensionValue2 = x509crl.getExtensionValue(Extension.issuingDistributionPoint.m14433getId());
                    byte[] bArr = this.issuingDistributionPoint;
                    if (bArr == null) {
                        if (extensionValue2 != null) {
                            return false;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return this.baseSelector.match(crl);
        return false;
    }
}
