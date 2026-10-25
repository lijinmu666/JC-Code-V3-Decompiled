package org.bouncycastle.p191cms.p192bc;

import org.bouncycastle.operator.p305bc.BcAsymmetricKeyWrapper;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.KeyTransRecipientInfoGenerator;

/* loaded from: classes2.dex */
public abstract class BcKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public BcKeyTransRecipientInfoGenerator(X509CertificateHolder x509CertificateHolder, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(new IssuerAndSerialNumber(x509CertificateHolder.toASN1Structure()), bcAsymmetricKeyWrapper);
    }

    public BcKeyTransRecipientInfoGenerator(byte[] bArr, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(bArr, bcAsymmetricKeyWrapper);
    }
}
