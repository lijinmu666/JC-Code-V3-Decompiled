package org.bouncycastle.p177cert.p185jcajce;

import java.security.Provider;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class JcaCertStoreBuilder {
    private Object provider;

    /* renamed from: certs */
    private List f18872certs = new ArrayList();

    /* renamed from: crls */
    private List f18873crls = new ArrayList();
    private JcaX509CertificateConverter certificateConverter = new JcaX509CertificateConverter();
    private JcaX509CRLConverter crlConverter = new JcaX509CRLConverter();

    /* renamed from: type */
    private String f18874type = "Collection";

    private CollectionCertStoreParameters convertHolders(JcaX509CertificateConverter jcaX509CertificateConverter, JcaX509CRLConverter jcaX509CRLConverter) {
        ArrayList arrayList = new ArrayList(this.f18872certs.size() + this.f18873crls.size());
        Iterator it = this.f18872certs.iterator();
        while (it.hasNext()) {
            arrayList.add(jcaX509CertificateConverter.getCertificate((X509CertificateHolder) it.next()));
        }
        Iterator it2 = this.f18873crls.iterator();
        while (it2.hasNext()) {
            arrayList.add(jcaX509CRLConverter.m14813getCRL((X509CRLHolder) it2.next()));
        }
        return new CollectionCertStoreParameters(arrayList);
    }

    /* renamed from: addCRL */
    public JcaCertStoreBuilder m14807addCRL(X509CRLHolder x509CRLHolder) {
        this.f18873crls.add(x509CRLHolder);
        return this;
    }

    /* renamed from: addCRLs */
    public JcaCertStoreBuilder m14808addCRLs(InterfaceC6249Store interfaceC6249Store) {
        this.f18873crls.addAll(interfaceC6249Store.getMatches(null));
        return this;
    }

    public JcaCertStoreBuilder addCertificate(X509CertificateHolder x509CertificateHolder) {
        this.f18872certs.add(x509CertificateHolder);
        return this;
    }

    public JcaCertStoreBuilder addCertificates(InterfaceC6249Store interfaceC6249Store) {
        this.f18872certs.addAll(interfaceC6249Store.getMatches(null));
        return this;
    }

    /* renamed from: build */
    public CertStore m14809build() {
        CollectionCertStoreParameters collectionCertStoreParametersConvertHolders = convertHolders(this.certificateConverter, this.crlConverter);
        Object obj = this.provider;
        if (obj instanceof String) {
            return CertStore.getInstance(this.f18874type, collectionCertStoreParametersConvertHolders, (String) obj);
        }
        boolean z = obj instanceof Provider;
        String str = this.f18874type;
        return z ? CertStore.getInstance(str, collectionCertStoreParametersConvertHolders, (Provider) obj) : CertStore.getInstance(str, collectionCertStoreParametersConvertHolders);
    }

    public JcaCertStoreBuilder setProvider(String str) {
        this.certificateConverter.setProvider(str);
        this.crlConverter.setProvider(str);
        this.provider = str;
        return this;
    }

    /* renamed from: setType */
    public JcaCertStoreBuilder m14810setType(String str) {
        this.f18874type = str;
        return this;
    }

    public JcaCertStoreBuilder setProvider(Provider provider) {
        this.certificateConverter.setProvider(provider);
        this.crlConverter.setProvider(provider);
        this.provider = provider;
        return this;
    }
}
