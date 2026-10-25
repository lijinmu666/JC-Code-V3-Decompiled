package org.bouncycastle.p133asn1.p137cmc;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.CRLReason;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class RevokeRequest extends ASN1Object {

    /* renamed from: comment */
    private ASN1UTF8String f18086comment;
    private ASN1GeneralizedTime invalidityDate;

    /* renamed from: name */
    private final X500Name f18087name;
    private ASN1OctetString passphrase;

    /* renamed from: reason */
    private final CRLReason f18088reason;
    private final ASN1Integer serialNumber;

    private RevokeRequest(ASN1Sequence aSN1Sequence) {
        int i = 3;
        if (aSN1Sequence.mo14450size() < 3 || aSN1Sequence.mo14450size() > 6) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f18087name = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18088reason = CRLReason.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.mo14450size() > 3 && (aSN1Sequence.getObjectAt(3).toASN1Primitive() instanceof ASN1GeneralizedTime)) {
            this.invalidityDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
            i = 4;
        }
        if (aSN1Sequence.mo14450size() > i && (aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1OctetString)) {
            this.passphrase = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (aSN1Sequence.mo14450size() <= i || !(aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1UTF8String)) {
            return;
        }
        this.f18086comment = ASN1UTF8String.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public static RevokeRequest getInstance(Object obj) {
        if (obj instanceof RevokeRequest) {
            return (RevokeRequest) obj;
        }
        if (obj != null) {
            return new RevokeRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getComment() {
        ASN1UTF8String aSN1UTF8String = this.f18086comment;
        return (aSN1UTF8String == null || (aSN1UTF8String instanceof DERUTF8String)) ? (DERUTF8String) aSN1UTF8String : new DERUTF8String(this.f18086comment.getString());
    }

    public ASN1UTF8String getCommentUTF8() {
        return this.f18086comment;
    }

    public ASN1GeneralizedTime getInvalidityDate() {
        return this.invalidityDate;
    }

    /* renamed from: getName */
    public X500Name m14497getName() {
        return this.f18087name;
    }

    public byte[] getPassPhrase() {
        ASN1OctetString aSN1OctetString = this.passphrase;
        if (aSN1OctetString != null) {
            return C6238Arrays.m18231clone(aSN1OctetString.getOctets());
        }
        return null;
    }

    public ASN1OctetString getPassphrase() {
        return this.passphrase;
    }

    public CRLReason getReason() {
        return this.f18088reason;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber.getValue();
    }

    public void setComment(ASN1UTF8String aSN1UTF8String) {
        this.f18086comment = aSN1UTF8String;
    }

    public void setInvalidityDate(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.invalidityDate = aSN1GeneralizedTime;
    }

    public void setPassphrase(ASN1OctetString aSN1OctetString) {
        this.passphrase = aSN1OctetString;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(this.f18087name);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(this.f18088reason);
        ASN1GeneralizedTime aSN1GeneralizedTime = this.invalidityDate;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.m14420add(aSN1GeneralizedTime);
        }
        ASN1OctetString aSN1OctetString = this.passphrase;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.m14420add(aSN1OctetString);
        }
        ASN1UTF8String aSN1UTF8String = this.f18086comment;
        if (aSN1UTF8String != null) {
            aSN1EncodableVector.m14420add(aSN1UTF8String);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevokeRequest(X500Name x500Name, ASN1Integer aSN1Integer, CRLReason cRLReason, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1OctetString aSN1OctetString, ASN1UTF8String aSN1UTF8String) {
        this.f18087name = x500Name;
        this.serialNumber = aSN1Integer;
        this.f18088reason = cRLReason;
        this.invalidityDate = aSN1GeneralizedTime;
        this.passphrase = aSN1OctetString;
        this.f18086comment = aSN1UTF8String;
    }
}
