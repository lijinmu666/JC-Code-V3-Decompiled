package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p217signers.DSADigestSigner;
import org.bouncycastle.p194crypto.p217signers.ECDSASigner;

/* loaded from: classes2.dex */
public class BcECContentSignerBuilder extends BcContentSignerBuilder {
    public BcECContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        super(algorithmIdentifier, algorithmIdentifier2);
    }

    @Override // org.bouncycastle.operator.p305bc.BcContentSignerBuilder
    public InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        return new DSADigestSigner(new ECDSASigner(), this.digestProvider.mo14916get(algorithmIdentifier2));
    }
}
