package org.bouncycastle.p191cms;

import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyWrapper;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.KEKIdentifier;
import org.bouncycastle.p133asn1.p139cms.KEKRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;

/* loaded from: classes2.dex */
public abstract class KEKRecipientInfoGenerator implements RecipientInfoGenerator {
    private final KEKIdentifier kekIdentifier;

    /* renamed from: wrapper */
    protected final SymmetricKeyWrapper f19017wrapper;

    public KEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, SymmetricKeyWrapper symmetricKeyWrapper) {
        this.kekIdentifier = kEKIdentifier;
        this.f19017wrapper = symmetricKeyWrapper;
    }

    @Override // org.bouncycastle.p191cms.RecipientInfoGenerator
    public final RecipientInfo generate(GenericKey genericKey) throws CMSException {
        try {
            return new RecipientInfo(new KEKRecipientInfo(this.kekIdentifier, this.f19017wrapper.getAlgorithmIdentifier(), new DEROctetString(this.f19017wrapper.generateWrappedKey(genericKey))));
        } catch (OperatorException e) {
            throw new CMSException("exception wrapping content key: " + e.getMessage(), e);
        }
    }
}
