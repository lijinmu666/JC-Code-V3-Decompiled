package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;

/* loaded from: classes2.dex */
public class KeyTransRecipientId extends PKIXRecipientId {
    public KeyTransRecipientId(X500Name x500Name, BigInteger bigInteger) {
        super(0, x500Name, bigInteger, null);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new KeyTransRecipientId(this.baseSelector);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    /* renamed from: equals */
    public boolean mo14885equals(Object obj) {
        if (obj instanceof KeyTransRecipientId) {
            return this.baseSelector.m14841equals(((KeyTransRecipientId) obj).baseSelector);
        }
        return false;
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return obj instanceof KeyTransRecipientInformation ? ((KeyTransRecipientInformation) obj).m14893getRID().equals(this) : super.mo14742match(obj);
    }

    public KeyTransRecipientId(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        super(0, x500Name, bigInteger, bArr);
    }

    private KeyTransRecipientId(X509CertificateHolderSelector x509CertificateHolderSelector) {
        super(0, x509CertificateHolderSelector);
    }

    public KeyTransRecipientId(byte[] bArr) {
        super(0, null, null, bArr);
    }
}
