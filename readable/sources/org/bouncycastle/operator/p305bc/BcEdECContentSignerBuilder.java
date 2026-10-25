package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p217signers.Ed25519Signer;

/* loaded from: classes2.dex */
public class BcEdECContentSignerBuilder extends BcContentSignerBuilder {
    public BcEdECContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier) {
        super(algorithmIdentifier, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512));
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentSignerBuilder
    public InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
            return new Ed25519Signer();
        }
        throw new IllegalStateException("unknown signature type");
    }
}
