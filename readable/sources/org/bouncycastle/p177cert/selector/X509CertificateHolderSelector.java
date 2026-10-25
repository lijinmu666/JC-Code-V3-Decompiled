package org.bouncycastle.p177cert.selector;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class X509CertificateHolderSelector implements Selector {

    /* renamed from: issuer */
    private X500Name f18924issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public X509CertificateHolderSelector(X500Name x500Name, BigInteger bigInteger) {
        this(x500Name, bigInteger, null);
    }

    private boolean equalsObj(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new X509CertificateHolderSelector(this.f18924issuer, this.serialNumber, this.subjectKeyId);
    }

    /* renamed from: equals */
    public boolean m14841equals(Object obj) {
        if (!(obj instanceof X509CertificateHolderSelector)) {
            return false;
        }
        X509CertificateHolderSelector x509CertificateHolderSelector = (X509CertificateHolderSelector) obj;
        return C6238Arrays.areEqual(this.subjectKeyId, x509CertificateHolderSelector.subjectKeyId) && equalsObj(this.serialNumber, x509CertificateHolderSelector.serialNumber) && equalsObj(this.f18924issuer, x509CertificateHolderSelector.f18924issuer);
    }

    public X500Name getIssuer() {
        return this.f18924issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public byte[] getSubjectKeyIdentifier() {
        return C6238Arrays.m18231clone(this.subjectKeyId);
    }

    public int hashCode() {
        int iHashCode = C6238Arrays.hashCode(this.subjectKeyId);
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null) {
            iHashCode ^= bigInteger.hashCode();
        }
        X500Name x500Name = this.f18924issuer;
        return x500Name != null ? iHashCode ^ x500Name.hashCode() : iHashCode;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        if (obj instanceof X509CertificateHolder) {
            X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
            if (getSerialNumber() != null) {
                IssuerAndSerialNumber issuerAndSerialNumber = new IssuerAndSerialNumber(x509CertificateHolder.toASN1Structure());
                return issuerAndSerialNumber.m14540getName().mo14431equals(this.f18924issuer) && issuerAndSerialNumber.getSerialNumber().hasValue(this.serialNumber);
            }
            if (this.subjectKeyId != null) {
                Extension extension = x509CertificateHolder.getExtension(Extension.subjectKeyIdentifier);
                if (extension == null) {
                    return C6238Arrays.areEqual(this.subjectKeyId, MSOutlookKeyIdCalculator.calculateKeyId(x509CertificateHolder.getSubjectPublicKeyInfo()));
                }
                return C6238Arrays.areEqual(this.subjectKeyId, ASN1OctetString.getInstance(extension.getParsedValue()).getOctets());
            }
        } else if (obj instanceof byte[]) {
            return C6238Arrays.areEqual(this.subjectKeyId, (byte[]) obj);
        }
        return false;
    }

    public X509CertificateHolderSelector(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        this.f18924issuer = x500Name;
        this.serialNumber = bigInteger;
        this.subjectKeyId = C6238Arrays.m18231clone(bArr);
    }

    public X509CertificateHolderSelector(byte[] bArr) {
        this(null, null, bArr);
    }
}
