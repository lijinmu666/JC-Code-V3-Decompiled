package org.bouncycastle.p133asn1.p145esf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Attribute;
import org.bouncycastle.p133asn1.p174x509.AttributeCertificate;

/* loaded from: classes2.dex */
public class SignerAttribute extends ASN1Object {

    /* renamed from: values */
    private Object[] f18374values;

    private SignerAttribute(ASN1Sequence aSN1Sequence) {
        this.f18374values = new Object[aSN1Sequence.mo14450size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
            if (aSN1TaggedObject.getTagNo() == 0) {
                ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1TaggedObject, true);
                int iMo14450size = aSN1Sequence2.mo14450size();
                Attribute[] attributeArr = new Attribute[iMo14450size];
                for (int i2 = 0; i2 != iMo14450size; i2++) {
                    attributeArr[i2] = Attribute.getInstance(aSN1Sequence2.getObjectAt(i2));
                }
                this.f18374values[i] = attributeArr;
            } else {
                if (aSN1TaggedObject.getTagNo() != 1) {
                    throw new IllegalArgumentException("illegal tag: " + aSN1TaggedObject.getTagNo());
                }
                this.f18374values[i] = AttributeCertificate.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
            }
            i++;
        }
    }

    public static SignerAttribute getInstance(Object obj) {
        if (obj instanceof SignerAttribute) {
            return (SignerAttribute) obj;
        }
        if (obj != null) {
            return new SignerAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Object[] getValues() {
        Object[] objArr = this.f18374values;
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.f18374values.length);
        int i = 0;
        while (true) {
            Object[] objArr = this.f18374values;
            if (i == objArr.length) {
                return new DERSequence(aSN1EncodableVector);
            }
            Object obj = objArr[i];
            if (obj instanceof Attribute[]) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(0, new DERSequence((Attribute[]) this.f18374values[i])));
            } else {
                aSN1EncodableVector.m14420add(new DERTaggedObject(1, (AttributeCertificate) obj));
            }
            i++;
        }
    }

    public SignerAttribute(AttributeCertificate attributeCertificate) {
        this.f18374values = new Object[]{attributeCertificate};
    }

    public SignerAttribute(Attribute[] attributeArr) {
        this.f18374values = new Object[]{attributeArr};
    }
}
