package org.bouncycastle.p191cms.p193jcajce;

import java.security.cert.X509CertSelector;
import org.bouncycastle.p191cms.KeyTransRecipientId;
import org.bouncycastle.p191cms.SignerId;

/* loaded from: classes2.dex */
public class JcaX509CertSelectorConverter extends org.bouncycastle.p177cert.selector.p189jcajce.JcaX509CertSelectorConverter {
    public X509CertSelector getCertSelector(KeyTransRecipientId keyTransRecipientId) {
        return doConversion(keyTransRecipientId.getIssuer(), keyTransRecipientId.getSerialNumber(), keyTransRecipientId.getSubjectKeyIdentifier());
    }

    public X509CertSelector getCertSelector(SignerId signerId) {
        return doConversion(signerId.getIssuer(), signerId.getSerialNumber(), signerId.getSubjectKeyIdentifier());
    }
}
