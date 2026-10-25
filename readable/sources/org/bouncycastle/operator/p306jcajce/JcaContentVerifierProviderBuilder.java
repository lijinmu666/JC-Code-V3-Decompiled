package org.bouncycastle.operator.p306jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.List;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RawContentVerifier;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p249jcajce.p250io.OutputStreamFactory;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class JcaContentVerifierProviderBuilder {

    /* renamed from: helper */
    private OperatorHelper f22895helper = new OperatorHelper(new DefaultJcaJceHelper());

    public static class CompositeVerifier implements ContentVerifier {

        /* renamed from: sigs */
        private Signature[] f22898sigs;

        /* renamed from: stream */
        private OutputStream f22899stream;

        public CompositeVerifier(Signature[] signatureArr) throws OperatorCreationException {
            this.f22898sigs = signatureArr;
            int i = 0;
            while (i < signatureArr.length && signatureArr[i] == null) {
                i++;
            }
            if (i == signatureArr.length) {
                throw new OperatorCreationException("no matching signature found in composite");
            }
            OutputStream outputStreamCreateStream = OutputStreamFactory.createStream(signatureArr[i]);
            while (true) {
                this.f22899stream = outputStreamCreateStream;
                do {
                    i++;
                    if (i == signatureArr.length) {
                        return;
                    }
                } while (signatureArr[i] == null);
                outputStreamCreateStream = new TeeOutputStream(this.f22899stream, OutputStreamFactory.createStream(signatureArr[i]));
            }
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite);
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public OutputStream getOutputStream() {
            return this.f22899stream;
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        /* renamed from: verify */
        public boolean mo16015verify(byte[] bArr) {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
                    Signature signature = this.f22898sigs[i];
                    if (signature != null) {
                        if (signature.verify(ASN1BitString.getInstance(aSN1Sequence.getObjectAt(i)).getOctets())) {
                            z2 = true;
                        } else {
                            z = true;
                            z2 = true;
                        }
                    }
                }
                return (!z) & z2;
            } catch (SignatureException e) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
            }
        }
    }

    public static class RawSigVerifier extends SigVerifier implements RawContentVerifier {
        private Signature rawSignature;

        public RawSigVerifier(AlgorithmIdentifier algorithmIdentifier, Signature signature, Signature signature2) {
            super(algorithmIdentifier, signature);
            this.rawSignature = signature2;
        }

        @Override // org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder.SigVerifier, org.bouncycastle.operator.ContentVerifier
        /* renamed from: verify */
        public boolean mo16015verify(byte[] bArr) throws SignatureException {
            try {
                return super.mo16015verify(bArr);
            } finally {
                try {
                    this.rawSignature.verify(bArr);
                } catch (Exception unused) {
                }
            }
        }

        @Override // org.bouncycastle.operator.RawContentVerifier
        /* renamed from: verify */
        public boolean mo17387verify(byte[] bArr, byte[] bArr2) throws SignatureException {
            try {
                try {
                    this.rawSignature.update(bArr);
                    return this.rawSignature.verify(bArr2);
                } finally {
                    try {
                        this.rawSignature.verify(bArr2);
                    } catch (Exception unused) {
                    }
                }
            } catch (SignatureException e) {
                throw new RuntimeOperatorException("exception obtaining raw signature: " + e.getMessage(), e);
            }
        }
    }

    public static class SigVerifier implements ContentVerifier {
        private final AlgorithmIdentifier algorithm;
        private final Signature signature;

        /* renamed from: stream */
        protected final OutputStream f22900stream;

        public SigVerifier(AlgorithmIdentifier algorithmIdentifier, Signature signature) {
            this.algorithm = algorithmIdentifier;
            this.signature = signature;
            this.f22900stream = OutputStreamFactory.createStream(signature);
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithm;
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        public OutputStream getOutputStream() {
            OutputStream outputStream = this.f22900stream;
            if (outputStream != null) {
                return outputStream;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        @Override // org.bouncycastle.operator.ContentVerifier
        /* renamed from: verify */
        public boolean mo16015verify(byte[] bArr) {
            try {
                return this.signature.verify(bArr);
            } catch (SignatureException e) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentVerifier createCompositeVerifier(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) {
        int i = 0;
        if (!(publicKey instanceof CompositePublicKey)) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(algorithmIdentifier.getParameters());
            Signature[] signatureArr = new Signature[aSN1Sequence.mo14450size()];
            while (i != aSN1Sequence.mo14450size()) {
                try {
                    signatureArr[i] = createSignature(AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i)), publicKey);
                } catch (Exception unused) {
                    signatureArr[i] = null;
                }
                i++;
            }
            return new CompositeVerifier(signatureArr);
        }
        List<PublicKey> publicKeys = ((CompositePublicKey) publicKey).getPublicKeys();
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(algorithmIdentifier.getParameters());
        Signature[] signatureArr2 = new Signature[aSN1Sequence2.mo14450size()];
        while (i != aSN1Sequence2.mo14450size()) {
            AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(aSN1Sequence2.getObjectAt(i));
            if (publicKeys.get(i) != null) {
                signatureArr2[i] = createSignature(algorithmIdentifier2, publicKeys.get(i));
            } else {
                signatureArr2[i] = null;
            }
            i++;
        }
        return new CompositeVerifier(signatureArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Signature createRawSig(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) throws InvalidKeyException {
        try {
            Signature signatureCreateRawSignature = this.f22895helper.createRawSignature(algorithmIdentifier);
            if (signatureCreateRawSignature == null) {
                return signatureCreateRawSignature;
            }
            signatureCreateRawSignature.initVerify(publicKey);
            return signatureCreateRawSignature;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Signature createSignature(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) throws OperatorCreationException, IOException, InvalidKeyException {
        try {
            Signature signatureCreateSignature = this.f22895helper.createSignature(algorithmIdentifier);
            signatureCreateSignature.initVerify(publicKey);
            return signatureCreateSignature;
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("exception on setup: " + e, e);
        }
    }

    /* renamed from: build */
    public ContentVerifierProvider m17393build(final PublicKey publicKey) {
        return new ContentVerifierProvider(this) { // from class: org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder.2

            /* renamed from: this$0 */
            final /* synthetic */ JcaContentVerifierProviderBuilder f22897this$0;

            {
                this.f22897this$0 = this;
            }

            @Override // org.bouncycastle.operator.ContentVerifierProvider
            /* renamed from: get */
            public ContentVerifier mo17379get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException, IOException, InvalidKeyException {
                if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) MiscObjectIdentifiers.id_alg_composite)) {
                    return this.f22897this$0.createCompositeVerifier(algorithmIdentifier, publicKey);
                }
                PublicKey publicKey2 = publicKey;
                if (!(publicKey2 instanceof CompositePublicKey) || !((CompositePublicKey) publicKey2).getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) MiscObjectIdentifiers.id_composite_key)) {
                    Signature signatureCreateSignature = this.f22897this$0.createSignature(algorithmIdentifier, publicKey);
                    Signature signatureCreateRawSig = this.f22897this$0.createRawSig(algorithmIdentifier, publicKey);
                    return signatureCreateRawSig != null ? new RawSigVerifier(algorithmIdentifier, signatureCreateSignature, signatureCreateRawSig) : new SigVerifier(algorithmIdentifier, signatureCreateSignature);
                }
                List<PublicKey> publicKeys = ((CompositePublicKey) publicKey).getPublicKeys();
                for (int i = 0; i != publicKeys.size(); i++) {
                    try {
                        Signature signatureCreateSignature2 = this.f22897this$0.createSignature(algorithmIdentifier, publicKeys.get(i));
                        Signature signatureCreateRawSig2 = this.f22897this$0.createRawSig(algorithmIdentifier, publicKeys.get(i));
                        return signatureCreateRawSig2 != null ? new RawSigVerifier(algorithmIdentifier, signatureCreateSignature2, signatureCreateRawSig2) : new SigVerifier(algorithmIdentifier, signatureCreateSignature2);
                    } catch (OperatorCreationException unused) {
                    }
                }
                throw new OperatorCreationException("no matching algorithm found for key");
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

    public JcaContentVerifierProviderBuilder setProvider(String str) {
        this.f22895helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    /* renamed from: build */
    public ContentVerifierProvider m17394build(final X509Certificate x509Certificate) throws OperatorCreationException {
        try {
            final JcaX509CertificateHolder jcaX509CertificateHolder = new JcaX509CertificateHolder(x509Certificate);
            return new ContentVerifierProvider(this) { // from class: org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcaContentVerifierProviderBuilder f22896this$0;

                {
                    this.f22896this$0 = this;
                }

                @Override // org.bouncycastle.operator.ContentVerifierProvider
                /* renamed from: get */
                public ContentVerifier mo17379get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException, IOException, InvalidKeyException {
                    if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) MiscObjectIdentifiers.id_alg_composite)) {
                        return this.f22896this$0.createCompositeVerifier(algorithmIdentifier, x509Certificate.getPublicKey());
                    }
                    try {
                        Signature signatureCreateSignature = this.f22896this$0.f22895helper.createSignature(algorithmIdentifier);
                        signatureCreateSignature.initVerify(x509Certificate.getPublicKey());
                        Signature signatureCreateRawSig = this.f22896this$0.createRawSig(algorithmIdentifier, x509Certificate.getPublicKey());
                        return signatureCreateRawSig != null ? new RawSigVerifier(algorithmIdentifier, signatureCreateSignature, signatureCreateRawSig) : new SigVerifier(algorithmIdentifier, signatureCreateSignature);
                    } catch (GeneralSecurityException e) {
                        throw new OperatorCreationException("exception on setup: " + e, e);
                    }
                }

                @Override // org.bouncycastle.operator.ContentVerifierProvider
                public X509CertificateHolder getAssociatedCertificate() {
                    return jcaX509CertificateHolder;
                }

                @Override // org.bouncycastle.operator.ContentVerifierProvider
                public boolean hasAssociatedCertificate() {
                    return true;
                }
            };
        } catch (CertificateEncodingException e) {
            throw new OperatorCreationException("cannot process certificate: " + e.getMessage(), e);
        }
    }

    public JcaContentVerifierProviderBuilder setProvider(Provider provider) {
        this.f22895helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    /* renamed from: build */
    public ContentVerifierProvider m17395build(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return m17393build(this.f22895helper.convertPublicKey(subjectPublicKeyInfo));
    }

    /* renamed from: build */
    public ContentVerifierProvider m17396build(X509CertificateHolder x509CertificateHolder) {
        return m17394build(this.f22895helper.convertCertificate(x509CertificateHolder));
    }
}
