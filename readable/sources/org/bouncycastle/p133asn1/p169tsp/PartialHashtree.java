package org.bouncycastle.p133asn1.p169tsp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PartialHashtree extends ASN1Object {

    /* renamed from: values */
    private final ASN1Sequence f18551values;

    private PartialHashtree(ASN1Sequence aSN1Sequence) {
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            if (!(aSN1Sequence.getObjectAt(i) instanceof ASN1OctetString)) {
                throw new IllegalArgumentException("unknown object in constructor: " + aSN1Sequence.getObjectAt(i).getClass().getName());
            }
        }
        this.f18551values = aSN1Sequence;
    }

    public static PartialHashtree getInstance(Object obj) {
        if (obj instanceof PartialHashtree) {
            return (PartialHashtree) obj;
        }
        if (obj != null) {
            return new PartialHashtree(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public boolean containsHash(byte[] bArr) {
        Enumeration objects = this.f18551values.getObjects();
        while (objects.hasMoreElements()) {
            if (C6238Arrays.constantTimeAreEqual(bArr, ASN1OctetString.getInstance(objects.nextElement()).getOctets())) {
                return true;
            }
        }
        return false;
    }

    public int getValueCount() {
        return this.f18551values.mo14450size();
    }

    public byte[][] getValues() {
        int iMo14450size = this.f18551values.mo14450size();
        byte[][] bArr = new byte[iMo14450size][];
        for (int i = 0; i != iMo14450size; i++) {
            bArr[i] = C6238Arrays.m18231clone(ASN1OctetString.getInstance(this.f18551values.getObjectAt(i)).getOctets());
        }
        return bArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18551values;
    }

    public PartialHashtree(byte[] bArr) {
        this(new byte[][]{bArr});
    }

    public PartialHashtree(byte[][] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(bArr.length);
        for (int i = 0; i != bArr.length; i++) {
            aSN1EncodableVector.m14420add(new DEROctetString(C6238Arrays.m18231clone(bArr[i])));
        }
        this.f18551values = new DERSequence(aSN1EncodableVector);
    }
}
