package org.bouncycastle.p366x509;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AttCertIssuer;
import org.bouncycastle.p133asn1.p174x509.C5195V2Form;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class AttributeCertificateIssuer implements CertSelector, Selector {

    /* renamed from: form */
    final ASN1Encodable f24278form;

    public AttributeCertificateIssuer(X500Principal x500Principal) {
        this(new X509Principal(x500Principal.getEncoded()));
    }

    private Object[] getNames() {
        ASN1Encodable aSN1Encodable = this.f24278form;
        GeneralName[] names = (aSN1Encodable instanceof C5195V2Form ? ((C5195V2Form) aSN1Encodable).getIssuerName() : (GeneralNames) aSN1Encodable).getNames();
        ArrayList arrayList = new ArrayList(names.length);
        for (int i = 0; i != names.length; i++) {
            if (names[i].getTagNo() == 4) {
                try {
                    arrayList.add(new X500Principal(names[i].m14690getName().toASN1Primitive().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    private boolean matchesDN(X500Principal x500Principal, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4) {
                try {
                    if (new X500Principal(generalName.m14690getName().toASN1Primitive().getEncoded()).equals(x500Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // java.security.cert.CertSelector, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.f24278form));
    }

    /* renamed from: equals */
    public boolean m18387equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeCertificateIssuer) {
            return this.f24278form.equals(((AttributeCertificateIssuer) obj).f24278form);
        }
        return false;
    }

    public Principal[] getPrincipals() {
        Object[] names = getNames();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            Object obj = names[i];
            if (obj instanceof Principal) {
                arrayList.add(obj);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    public int hashCode() {
        return this.f24278form.hashCode();
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return false;
    }

    public AttributeCertificateIssuer(AttCertIssuer attCertIssuer) {
        this.f24278form = attCertIssuer.getIssuer();
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        ASN1Encodable aSN1Encodable = this.f24278form;
        if (aSN1Encodable instanceof C5195V2Form) {
            C5195V2Form c5195V2Form = (C5195V2Form) aSN1Encodable;
            if (c5195V2Form.getBaseCertificateID() != null) {
                return c5195V2Form.getBaseCertificateID().getSerial().hasValue(x509Certificate.getSerialNumber()) && matchesDN(x509Certificate.getIssuerX500Principal(), c5195V2Form.getBaseCertificateID().getIssuer());
            }
            if (matchesDN(x509Certificate.getSubjectX500Principal(), c5195V2Form.getIssuerName())) {
                return true;
            }
        } else {
            if (matchesDN(x509Certificate.getSubjectX500Principal(), (GeneralNames) aSN1Encodable)) {
                return true;
            }
        }
        return false;
    }

    public AttributeCertificateIssuer(X509Principal x509Principal) {
        this.f24278form = new C5195V2Form(GeneralNames.getInstance(new DERSequence(new GeneralName(x509Principal))));
    }
}
