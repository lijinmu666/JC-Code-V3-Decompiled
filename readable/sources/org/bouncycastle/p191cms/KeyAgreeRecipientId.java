package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;

/* loaded from: classes2.dex */
public class KeyAgreeRecipientId extends PKIXRecipientId {
    public KeyAgreeRecipientId(X500Name x500Name, BigInteger bigInteger) {
        super(2, x500Name, bigInteger, null);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new KeyAgreeRecipientId(this.baseSelector);
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    /* renamed from: equals */
    public boolean mo14885equals(Object obj) {
        if (obj instanceof KeyAgreeRecipientId) {
            return this.baseSelector.m14841equals(((KeyAgreeRecipientId) obj).baseSelector);
        }
        return false;
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    public X500Name getIssuer() {
        return this.baseSelector.getIssuer();
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    public BigInteger getSerialNumber() {
        return this.baseSelector.getSerialNumber();
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    public byte[] getSubjectKeyIdentifier() {
        return this.baseSelector.getSubjectKeyIdentifier();
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId
    public int hashCode() {
        return this.baseSelector.hashCode();
    }

    @Override // org.bouncycastle.p191cms.PKIXRecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return obj instanceof KeyAgreeRecipientInformation ? ((KeyAgreeRecipientInformation) obj).m14893getRID().equals(this) : this.baseSelector.mo14742match(obj);
    }

    public KeyAgreeRecipientId(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        super(2, x500Name, bigInteger, bArr);
    }

    private KeyAgreeRecipientId(X509CertificateHolderSelector x509CertificateHolderSelector) {
        super(2, x509CertificateHolderSelector);
    }

    public KeyAgreeRecipientId(byte[] bArr) {
        super(2, null, null, bArr);
    }
}
