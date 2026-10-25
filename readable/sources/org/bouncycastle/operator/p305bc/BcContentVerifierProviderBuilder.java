package org.bouncycastle.operator.p305bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public abstract class BcContentVerifierProviderBuilder {
    protected BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;

    public static class SigVerifier implements ContentVerifier {
        private AlgorithmIdentifier algorithm;

        /* renamed from: stream */
        private BcSignerOutputStream f22873stream;

        public SigVerifier(AlgorithmIdentifier algorithmIdentifier, BcSignerOutputStream bcSignerOutputStream) {
            this.algorithm = algorithmIdentifier;
            this.f22873stream = bcSignerOutputStream;
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithm;
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public OutputStream getOutputStream() {
            BcSignerOutputStream bcSignerOutputStream = this.f22873stream;
            if (bcSignerOutputStream != null) {
                return bcSignerOutputStream;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        /* renamed from: verify */
        public boolean mo16015verify(byte[] bArr) {
            return this.f22873stream.m17391verify(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BcSignerOutputStream createSignatureStream(AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) {
        InterfaceC5282Signer interfaceC5282SignerCreateSigner = createSigner(algorithmIdentifier);
        interfaceC5282SignerCreateSigner.mo14987init(false, asymmetricKeyParameter);
        return new BcSignerOutputStream(interfaceC5282SignerCreateSigner);
    }

    /* renamed from: build */
    public ContentVerifierProvider m17389build(final X509CertificateHolder x509CertificateHolder) {
        return new ContentVerifierProvider(this) { // from class: org.bouncycastle.operator.bc.BcContentVerifierProviderBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ BcContentVerifierProviderBuilder f22871this$0;

            {
                this.f22871this$0 = this;
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            /* renamed from: get */
            public ContentVerifier mo17379get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                try {
                    return new SigVerifier(algorithmIdentifier, this.f22871this$0.createSignatureStream(algorithmIdentifier, this.f22871this$0.extractKeyParameters(x509CertificateHolder.getSubjectPublicKeyInfo())));
                } catch (IOException e) {
                    throw new OperatorCreationException("exception on setup: " + e, e);
                }
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            public X509CertificateHolder getAssociatedCertificate() {
                return x509CertificateHolder;
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            public boolean hasAssociatedCertificate() {
                return true;
            }
        };
    }

    public abstract InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier);

    public abstract AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo);

    /* renamed from: build */
    public ContentVerifierProvider m17390build(final AsymmetricKeyParameter asymmetricKeyParameter) {
        return new ContentVerifierProvider(this) { // from class: org.bouncycastle.operator.bc.BcContentVerifierProviderBuilder.2

            /* renamed from: this$0 */
            final /* synthetic */ BcContentVerifierProviderBuilder f22872this$0;

            {
                this.f22872this$0 = this;
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            /* renamed from: get */
            public ContentVerifier mo17379get(AlgorithmIdentifier algorithmIdentifier) {
                return new SigVerifier(algorithmIdentifier, this.f22872this$0.createSignatureStream(algorithmIdentifier, asymmetricKeyParameter));
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            public X509CertificateHolder getAssociatedCertificate() {
                return null;
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            public boolean hasAssociatedCertificate() {
                return false;
            }
        };
    }
}
