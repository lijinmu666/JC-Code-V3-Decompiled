package org.bouncycastle.p133asn1.p143eac;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class UnsignedInteger extends ASN1Object {

    /* renamed from: tagNo */
    private int f18365tagNo;

    /* renamed from: value */
    private BigInteger f18366value;

    public UnsignedInteger(int i, BigInteger bigInteger) {
        this.f18365tagNo = i;
        this.f18366value = bigInteger;
    }

    private byte[] convertValue() {
        byte[] byteArray = this.f18366value.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static UnsignedInteger getInstance(Object obj) {
        if (obj instanceof UnsignedInteger) {
            return (UnsignedInteger) obj;
        }
        if (obj != null) {
            return new UnsignedInteger(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getTagNo() {
        return this.f18365tagNo;
    }

    public BigInteger getValue() {
        return this.f18366value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18365tagNo, (ASN1Encodable) new DEROctetString(convertValue()));
    }

    private UnsignedInteger(ASN1TaggedObject aSN1TaggedObject) {
        this.f18365tagNo = aSN1TaggedObject.getTagNo();
        this.f18366value = new BigInteger(1, ASN1OctetString.getInstance(aSN1TaggedObject, false).getOctets());
    }
}
