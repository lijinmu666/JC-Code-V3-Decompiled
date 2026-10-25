package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;

/* loaded from: classes2.dex */
public class PKIXRecipientId extends RecipientId {
    protected final X509CertificateHolderSelector baseSelector;

    public PKIXRecipientId(int i, X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        this(i, new X509CertificateHolderSelector(x500Name, bigInteger, bArr));
    }

    @Override // org.bouncycastle.p191cms.RecipientId, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new PKIXRecipientId(m14891getType(), this.baseSelector);
    }

    /* renamed from: equals */
    public boolean mo14885equals(Object obj) {
        if (obj instanceof PKIXRecipientId) {
            return this.baseSelector.m14841equals(((PKIXRecipientId) obj).baseSelector);
        }
        return false;
    }

    public X500Name getIssuer() {
        return this.baseSelector.getIssuer();
    }

    public BigInteger getSerialNumber() {
        return this.baseSelector.getSerialNumber();
    }

    public byte[] getSubjectKeyIdentifier() {
        return this.baseSelector.getSubjectKeyIdentifier();
    }

    public int hashCode() {
        return this.baseSelector.hashCode();
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return this.baseSelector.mo14742match(obj);
    }

    public PKIXRecipientId(int i, X509CertificateHolderSelector x509CertificateHolderSelector) {
        super(i);
        this.baseSelector = x509CertificateHolderSelector;
    }
}
