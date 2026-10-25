package org.bouncycastle.p177cert;

import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public interface X509ContentVerifierProviderBuilder {
    /* renamed from: build */
    ContentVerifierProvider mo14750build(SubjectPublicKeyInfo subjectPublicKeyInfo);

    /* renamed from: build */
    ContentVerifierProvider mo14751build(X509CertificateHolder x509CertificateHolder);
}
