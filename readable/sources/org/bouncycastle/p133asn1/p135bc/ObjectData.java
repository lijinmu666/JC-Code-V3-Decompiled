package org.bouncycastle.p133asn1.p135bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERGeneralizedTime;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class ObjectData extends ASN1Object {

    /* renamed from: comment */
    private final String f18045comment;
    private final ASN1GeneralizedTime creationDate;

    /* renamed from: data */
    private final ASN1OctetString f18046data;
    private final String identifier;
    private final ASN1GeneralizedTime lastModifiedDate;

    /* renamed from: type */
    private final BigInteger f18047type;

    public ObjectData(BigInteger bigInteger, String str, Date date, Date date2, byte[] bArr, String str2) {
        this.f18047type = bigInteger;
        this.identifier = str;
        this.creationDate = new DERGeneralizedTime(date);
        this.lastModifiedDate = new DERGeneralizedTime(date2);
        this.f18046data = new DEROctetString(C6238Arrays.m18231clone(bArr));
        this.f18045comment = str2;
    }

    public static ObjectData getInstance(Object obj) {
        if (obj instanceof ObjectData) {
            return (ObjectData) obj;
        }
        if (obj != null) {
            return new ObjectData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public String getComment() {
        return this.f18045comment;
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.creationDate;
    }

    /* renamed from: getData */
    public byte[] m14483getData() {
        return C6238Arrays.m18231clone(this.f18046data.getOctets());
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /* renamed from: getType */
    public BigInteger m14484getType() {
        return this.f18047type;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(new ASN1Integer(this.f18047type));
        aSN1EncodableVector.m14420add(new DERUTF8String(this.identifier));
        aSN1EncodableVector.m14420add(this.creationDate);
        aSN1EncodableVector.m14420add(this.lastModifiedDate);
        aSN1EncodableVector.m14420add(this.f18046data);
        if (this.f18045comment != null) {
            aSN1EncodableVector.m14420add(new DERUTF8String(this.f18045comment));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private ObjectData(ASN1Sequence aSN1Sequence) {
        this.f18047type = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue();
        this.identifier = ASN1UTF8String.getInstance(aSN1Sequence.getObjectAt(1)).getString();
        this.creationDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.lastModifiedDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        this.f18046data = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4));
        this.f18045comment = aSN1Sequence.mo14450size() == 6 ? ASN1UTF8String.getInstance(aSN1Sequence.getObjectAt(5)).getString() : null;
    }
}
