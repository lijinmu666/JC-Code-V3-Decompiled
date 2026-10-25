package org.bouncycastle.p177cert.p188path.validations;

import java.util.Collection;
import java.util.Iterator;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p188path.CertPathValidation;
import org.bouncycastle.p177cert.p188path.CertPathValidationContext;
import org.bouncycastle.p177cert.p188path.CertPathValidationException;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Memoable;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class CRLValidation implements CertPathValidation {

    /* renamed from: crls */
    private InterfaceC6249Store f18905crls;
    private X500Name workingIssuerName;

    public CRLValidation(X500Name x500Name, InterfaceC6249Store interfaceC6249Store) {
        this.workingIssuerName = x500Name;
        this.f18905crls = interfaceC6249Store;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new CRLValidation(this.workingIssuerName, this.f18905crls);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        CRLValidation cRLValidation = (CRLValidation) memoable;
        this.workingIssuerName = cRLValidation.workingIssuerName;
        this.f18905crls = cRLValidation.f18905crls;
    }

    @Override // org.bouncycastle.p177cert.p188path.CertPathValidation
    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        Collection matches = this.f18905crls.getMatches(new Selector() { // from class: org.bouncycastle.cert.path.validations.CRLValidation.1
            @Override // org.bouncycastle.p361util.Selector
            /* renamed from: clone */
            public Object mo14740clone() {
                return this;
            }

            @Override // org.bouncycastle.p361util.Selector
            /* renamed from: match */
            public boolean mo14742match(Object obj) {
                return ((X509CRLHolder) obj).getIssuer().mo14431equals(CRLValidation.this.workingIssuerName);
            }
        });
        if (matches.isEmpty()) {
            throw new CertPathValidationException("CRL for " + this.workingIssuerName + " not found");
        }
        Iterator it = matches.iterator();
        while (it.hasNext()) {
            if (((X509CRLHolder) it.next()).getRevokedCertificate(x509CertificateHolder.getSerialNumber()) != null) {
                throw new CertPathValidationException("Certificate revoked");
            }
        }
        this.workingIssuerName = x509CertificateHolder.getSubject();
    }
}
