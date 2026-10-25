package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p217signers.Ed25519Signer;
import org.bouncycastle.p194crypto.p217signers.Ed448Signer;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;

/* loaded from: classes2.dex */
public class BcEdDSAContentVerifierProviderBuilder extends BcContentVerifierProviderBuilder {
    public static final byte[] DEFAULT_CONTEXT = new byte[0];

    @Override // org.bouncycastle.operator.p305bc.BcContentVerifierProviderBuilder
    public InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier) {
        return algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed448) ? new Ed448Signer(DEFAULT_CONTEXT) : new Ed25519Signer();
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentVerifierProviderBuilder
    public AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }
}
