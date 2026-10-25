package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class SignerId implements Selector {
    private X509CertificateHolderSelector baseSelector;

    public SignerId(X500Name x500Name, BigInteger bigInteger) {
        this(x500Name, bigInteger, null);
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new SignerId(this.baseSelector);
    }

    /* renamed from: equals */
    public boolean m14897equals(Object obj) {
        if (obj instanceof SignerId) {
            return this.baseSelector.m14841equals(((SignerId) obj).baseSelector);
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
        return obj instanceof SignerInformation ? ((SignerInformation) obj).m14901getSID().m14897equals(this) : this.baseSelector.mo14742match(obj);
    }

    public SignerId(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        this(new X509CertificateHolderSelector(x500Name, bigInteger, bArr));
    }

    private SignerId(X509CertificateHolderSelector x509CertificateHolderSelector) {
        this.baseSelector = x509CertificateHolderSelector;
    }

    public SignerId(byte[] bArr) {
        this(null, null, bArr);
    }
}
