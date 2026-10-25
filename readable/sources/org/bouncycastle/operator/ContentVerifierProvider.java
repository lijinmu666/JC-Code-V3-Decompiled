package org.bouncycastle.operator;

import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public interface ContentVerifierProvider {
    /* renamed from: get */
    ContentVerifier mo17379get(AlgorithmIdentifier algorithmIdentifier);

    X509CertificateHolder getAssociatedCertificate();

    boolean hasAssociatedCertificate();
}
