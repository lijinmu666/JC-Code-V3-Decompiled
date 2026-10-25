package org.bouncycastle.p133asn1.p167sec;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECPrivateKeyStructure extends ASN1Object {

    /* renamed from: seq */
    private ASN1Sequence f18531seq;

    public ECPrivateKeyStructure(BigInteger bigInteger) {
        this.f18531seq = new DERSequence(ASN1Integer.f17918ONE, new DEROctetString(BigIntegers.asUnsignedByteArray(bigInteger)));
    }

    private ASN1Primitive getObjectInTag(int i) {
        Enumeration objects = this.f18531seq.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject.getTagNo() == i) {
                    return aSN1TaggedObject.getExplicitBaseObject().toASN1Primitive();
                }
            }
        }
        return null;
    }

    /* renamed from: getKey */
    public BigInteger m14640getKey() {
        return new BigInteger(1, ((ASN1OctetString) this.f18531seq.getObjectAt(1)).getOctets());
    }

    public ASN1Primitive getParameters() {
        return getObjectInTag(0);
    }

    public ASN1BitString getPublicKey() {
        return (ASN1BitString) getObjectInTag(1);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18531seq;
    }

    public ECPrivateKeyStructure(BigInteger bigInteger, ASN1BitString aSN1BitString, ASN1Encodable aSN1Encodable) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(ASN1Integer.f17918ONE);
        aSN1EncodableVector.m14420add(new DEROctetString(bArrAsUnsignedByteArray));
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, aSN1Encodable));
        }
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1BitString));
        }
        this.f18531seq = new DERSequence(aSN1EncodableVector);
    }

    public ECPrivateKeyStructure(BigInteger bigInteger, ASN1Encodable aSN1Encodable) {
        this(bigInteger, null, aSN1Encodable);
    }

    public ECPrivateKeyStructure(ASN1Sequence aSN1Sequence) {
        this.f18531seq = aSN1Sequence;
    }
}
