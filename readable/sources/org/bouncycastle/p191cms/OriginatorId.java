package org.bouncycastle.p191cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
class OriginatorId implements Selector {

    /* renamed from: issuer */
    private X500Name f19024issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public OriginatorId(X500Name x500Name, BigInteger bigInteger) {
        setIssuerAndSerial(x500Name, bigInteger);
    }

    private boolean equalsObj(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    private void setIssuerAndSerial(X500Name x500Name, BigInteger bigInteger) {
        this.f19024issuer = x500Name;
        this.serialNumber = bigInteger;
    }

    private void setSubjectKeyID(byte[] bArr) {
        this.subjectKeyId = bArr;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new OriginatorId(this.f19024issuer, this.serialNumber, this.subjectKeyId);
    }

    /* renamed from: equals */
    public boolean m14886equals(Object obj) {
        if (!(obj instanceof OriginatorId)) {
            return false;
        }
        OriginatorId originatorId = (OriginatorId) obj;
        return C6238Arrays.areEqual(this.subjectKeyId, originatorId.subjectKeyId) && equalsObj(this.serialNumber, originatorId.serialNumber) && equalsObj(this.f19024issuer, originatorId.f19024issuer);
    }

    public X500Name getIssuer() {
        return this.f19024issuer;
    }

    public int hashCode() {
        int iHashCode = C6238Arrays.hashCode(this.subjectKeyId);
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null) {
            iHashCode ^= bigInteger.hashCode();
        }
        X500Name x500Name = this.f19024issuer;
        return x500Name != null ? iHashCode ^ x500Name.hashCode() : iHashCode;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        return false;
    }

    public OriginatorId(X500Name x500Name, BigInteger bigInteger, byte[] bArr) {
        setIssuerAndSerial(x500Name, bigInteger);
        setSubjectKeyID(bArr);
    }

    public OriginatorId(byte[] bArr) {
        setSubjectKeyID(bArr);
    }
}
