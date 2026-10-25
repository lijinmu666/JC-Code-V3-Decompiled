package org.bouncycastle.p133asn1.p170ua;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j */
    private int f18559j;

    /* renamed from: k */
    private int f18560k;

    /* renamed from: l */
    private int f18561l;

    /* renamed from: m */
    private int f18562m;

    public DSTU4145BinaryField(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getK1 */
    public int m14652getK1() {
        return this.f18560k;
    }

    /* renamed from: getK2 */
    public int m14653getK2() {
        return this.f18559j;
    }

    /* renamed from: getK3 */
    public int m14654getK3() {
        return this.f18561l;
    }

    /* renamed from: getM */
    public int m14655getM() {
        return this.f18562m;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable dERSequence;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f18562m));
        if (this.f18559j == 0) {
            dERSequence = ASN1Integer.m14429valueOf(this.f18560k);
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.f18560k));
            aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.f18559j));
            aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.f18561l));
            dERSequence = new DERSequence(aSN1EncodableVector2);
        }
        aSN1EncodableVector.m14420add(dERSequence);
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145BinaryField(int i, int i2, int i3, int i4) {
        this.f18562m = i;
        this.f18560k = i2;
        this.f18559j = i3;
        this.f18561l = i4;
    }

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f18562m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intPositiveValueExact();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f18560k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intPositiveValueExact();
        } else {
            if (!(aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("object parse error");
            }
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f18560k = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).intPositiveValueExact();
            this.f18559j = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(1)).intPositiveValueExact();
            this.f18561l = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).intPositiveValueExact();
        }
    }
}
