package org.bouncycastle.p177cert;

import java.util.ArrayList;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AttCertIssuer;
import org.bouncycastle.p133asn1.p174x509.C5195V2Form;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class AttributeCertificateIssuer implements Selector {

    /* renamed from: form */
    final ASN1Encodable f18796form;

    public AttributeCertificateIssuer(X500Name x500Name) {
        this.f18796form = new C5195V2Form(new GeneralNames(new GeneralName(x500Name)));
    }

    private boolean matchesDN(X500Name x500Name, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4 && X500Name.getInstance(generalName.m14690getName()).mo14431equals(x500Name)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.f18796form));
    }

    /* renamed from: equals */
    public boolean m14743equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeCertificateIssuer) {
            return this.f18796form.equals(((AttributeCertificateIssuer) obj).f18796form);
        }
        return false;
    }

    public X500Name[] getNames() {
        ASN1Encodable aSN1Encodable = this.f18796form;
        GeneralName[] names = (aSN1Encodable instanceof C5195V2Form ? ((C5195V2Form) aSN1Encodable).getIssuerName() : (GeneralNames) aSN1Encodable).getNames();
        ArrayList arrayList = new ArrayList(names.length);
        for (int i = 0; i != names.length; i++) {
            if (names[i].getTagNo() == 4) {
                arrayList.add(X500Name.getInstance(names[i].m14690getName()));
            }
        }
        return (X500Name[]) arrayList.toArray(new X500Name[arrayList.size()]);
    }

    public int hashCode() {
        return this.f18796form.hashCode();
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
        ASN1Encodable aSN1Encodable = this.f18796form;
        if (aSN1Encodable instanceof C5195V2Form) {
            C5195V2Form c5195V2Form = (C5195V2Form) aSN1Encodable;
            if (c5195V2Form.getBaseCertificateID() != null) {
                return c5195V2Form.getBaseCertificateID().getSerial().hasValue(x509CertificateHolder.getSerialNumber()) && matchesDN(x509CertificateHolder.getIssuer(), c5195V2Form.getBaseCertificateID().getIssuer());
            }
            if (matchesDN(x509CertificateHolder.getSubject(), c5195V2Form.getIssuerName())) {
                return true;
            }
        } else {
            if (matchesDN(x509CertificateHolder.getSubject(), (GeneralNames) aSN1Encodable)) {
                return true;
            }
        }
        return false;
    }

    public AttributeCertificateIssuer(AttCertIssuer attCertIssuer) {
        this.f18796form = attCertIssuer.getIssuer();
    }
}
