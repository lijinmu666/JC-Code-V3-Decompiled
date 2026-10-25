package org.bouncycastle.p191cms.p192bc;

import org.bouncycastle.operator.p305bc.BcSymmetricKeyWrapper;
import org.bouncycastle.p133asn1.p139cms.KEKIdentifier;
import org.bouncycastle.p191cms.KEKRecipientInfoGenerator;

/* loaded from: classes2.dex */
public class BcKEKRecipientInfoGenerator extends KEKRecipientInfoGenerator {
    public BcKEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, BcSymmetricKeyWrapper bcSymmetricKeyWrapper) {
        super(kEKIdentifier, bcSymmetricKeyWrapper);
    }

    public BcKEKRecipientInfoGenerator(byte[] bArr, BcSymmetricKeyWrapper bcSymmetricKeyWrapper) {
        this(new KEKIdentifier(bArr, null, null), bcSymmetricKeyWrapper);
    }
}
