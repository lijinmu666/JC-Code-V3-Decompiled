package org.bouncycastle.p191cms;

import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public abstract class KEMKeyWrapper extends AsymmetricKeyWrapper {
    public KEMKeyWrapper(AlgorithmIdentifier algorithmIdentifier) {
        super(algorithmIdentifier);
    }

    public abstract byte[] getEncapsulation();

    public abstract AlgorithmIdentifier getKdfAlgorithmIdentifier();

    public abstract int getKekLength();

    public abstract AlgorithmIdentifier getWrapAlgorithmIdentifier();
}
