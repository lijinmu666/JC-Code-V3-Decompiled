package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;

/* loaded from: classes2.dex */
public class KEMRecipientId extends PKIXRecipientId {
    public KEMRecipientId(X500Name x500Name, BigInteger bigInteger) {
        super(4, x500Name, bigInteger, null);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new KEMRecipientId(this.baseSelector);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return obj instanceof KEMRecipientInformation ? ((KEMRecipientInformation) obj).m14893getRID().equals(this) : super.mo14742match(obj);
    }

    public KEMRecipientId(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        super(4, x500Name, bigInteger, bArr);
    }

    private KEMRecipientId(X509CertificateHolderSelector x509CertificateHolderSelector) {
        super(4, x509CertificateHolderSelector);
    }

    public KEMRecipientId(byte[] bArr) {
        super(4, null, null, bArr);
    }
}
