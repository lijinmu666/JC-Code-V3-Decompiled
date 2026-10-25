package org.bouncycastle.p177cert.p183dane;

import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class DANEEntryFactory {
    private final DANEEntrySelectorFactory selectorFactory;

    public DANEEntryFactory(DigestCalculator digestCalculator) {
        this.selectorFactory = new DANEEntrySelectorFactory(digestCalculator);
    }

    public DANEEntry createEntry(String str, int i, X509CertificateHolder x509CertificateHolder) throws DANEException {
        if (i >= 0 && i <= 3) {
            return new DANEEntry(this.selectorFactory.createSelector(str).getDomainName(), new byte[]{(byte) i, 0, 0}, x509CertificateHolder);
        }
        throw new DANEException("unknown certificate usage: " + i);
    }

    public DANEEntry createEntry(String str, X509CertificateHolder x509CertificateHolder) {
        return createEntry(str, 3, x509CertificateHolder);
    }
}
