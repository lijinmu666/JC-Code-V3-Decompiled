package org.bouncycastle.p314pqc.p315asn1;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.asn1.ParSet */
/* loaded from: classes2.dex */
public class C6048ParSet extends ASN1Object {

    /* renamed from: h */
    private int[] f23026h;

    /* renamed from: k */
    private int[] f23027k;

    /* renamed from: t */
    private int f23028t;

    /* renamed from: w */
    private int[] f23029w;

    public C6048ParSet(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f23028t = i;
        this.f23026h = iArr;
        this.f23029w = iArr2;
        this.f23027k = iArr3;
    }

    private static int checkBigIntegerInIntRangeAndPositive(ASN1Encodable aSN1Encodable) {
        int iIntValueExact = ((ASN1Integer) aSN1Encodable).intValueExact();
        if (iIntValueExact > 0) {
            return iIntValueExact;
        }
        throw new IllegalArgumentException("BigInteger not in Range: " + iIntValueExact);
    }

    public static C6048ParSet getInstance(Object obj) {
        if (obj instanceof C6048ParSet) {
            return (C6048ParSet) obj;
        }
        if (obj != null) {
            return new C6048ParSet(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getH */
    public int[] m17468getH() {
        return C6238Arrays.m18234clone(this.f23026h);
    }

    /* renamed from: getK */
    public int[] m17469getK() {
        return C6238Arrays.m18234clone(this.f23027k);
    }

    /* renamed from: getT */
    public int m17470getT() {
        return this.f23028t;
    }

    /* renamed from: getW */
    public int[] m17471getW() {
        return C6238Arrays.m18234clone(this.f23029w);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            int[] iArr = this.f23026h;
            if (i >= iArr.length) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.m14420add(ASN1Integer.m14429valueOf(this.f23028t));
                aSN1EncodableVector4.m14420add(new DERSequence(aSN1EncodableVector));
                aSN1EncodableVector4.m14420add(new DERSequence(aSN1EncodableVector2));
                aSN1EncodableVector4.m14420add(new DERSequence(aSN1EncodableVector3));
                return new DERSequence(aSN1EncodableVector4);
            }
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(iArr[i]));
            aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.f23029w[i]));
            aSN1EncodableVector3.m14420add(ASN1Integer.m14429valueOf(this.f23027k[i]));
            i++;
        }
    }

    private C6048ParSet(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("sie of seqOfParams = " + aSN1Sequence.mo14450size());
        }
        this.f23028t = checkBigIntegerInIntRangeAndPositive(aSN1Sequence.getObjectAt(0));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
        if (aSN1Sequence2.mo14450size() != this.f23028t || aSN1Sequence3.mo14450size() != this.f23028t || aSN1Sequence4.mo14450size() != this.f23028t) {
            throw new IllegalArgumentException("invalid size of sequences");
        }
        this.f23026h = new int[aSN1Sequence2.mo14450size()];
        this.f23029w = new int[aSN1Sequence3.mo14450size()];
        this.f23027k = new int[aSN1Sequence4.mo14450size()];
        for (int i = 0; i < this.f23028t; i++) {
            this.f23026h[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence2.getObjectAt(i));
            this.f23029w[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence3.getObjectAt(i));
            this.f23027k[i] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence4.getObjectAt(i));
        }
    }
}
