package org.bouncycastle.operator.p305bc;

import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p217signers.RSADigestSigner;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;

/* loaded from: classes2.dex */
public class BcRSAContentVerifierProviderBuilder extends BcContentVerifierProviderBuilder {
    private DigestAlgorithmIdentifierFinder digestAlgorithmFinder;

    public BcRSAContentVerifierProviderBuilder(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.digestAlgorithmFinder = digestAlgorithmIdentifierFinder;
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentVerifierProviderBuilder
    public InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier) {
        return new RSADigestSigner(this.digestProvider.mo14916get(this.digestAlgorithmFinder.mo17382find(algorithmIdentifier)));
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentVerifierProviderBuilder
    public AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }
}
