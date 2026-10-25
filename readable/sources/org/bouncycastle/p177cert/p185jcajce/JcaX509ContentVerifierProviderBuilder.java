package org.bouncycastle.p177cert.p185jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.p306jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.X509ContentVerifierProviderBuilder;

/* loaded from: classes2.dex */
public class JcaX509ContentVerifierProviderBuilder implements X509ContentVerifierProviderBuilder {

    /* renamed from: builder */
    private JcaContentVerifierProviderBuilder f18880builder = new JcaContentVerifierProviderBuilder();

    @Override // org.bouncycastle.p177cert.X509ContentVerifierProviderBuilder
    /* renamed from: build */
    public ContentVerifierProvider mo14750build(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return this.f18880builder.m17395build(subjectPublicKeyInfo);
    }

    public JcaX509ContentVerifierProviderBuilder setProvider(String str) {
        this.f18880builder.setProvider(str);
        return this;
    }

    @Override // org.bouncycastle.p177cert.X509ContentVerifierProviderBuilder
    /* renamed from: build */
    public ContentVerifierProvider mo14751build(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        try {
            return this.f18880builder.m17396build(x509CertificateHolder);
        } catch (CertificateException e) {
            throw new OperatorCreationException("Unable to process certificate: " + e.getMessage(), e);
        }
    }

    public JcaX509ContentVerifierProviderBuilder setProvider(Provider provider) {
        this.f18880builder.setProvider(provider);
        return this;
    }
}
