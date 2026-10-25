package org.bouncycastle.p133asn1.p176x9;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.asn1.x9.X9Curve */
/* loaded from: classes2.dex */
public class C5219X9Curve extends ASN1Object implements X9ObjectIdentifiers {

    /* renamed from: curve */
    private AbstractC5817ECCurve f18773curve;
    private ASN1ObjectIdentifier fieldIdentifier;

    /* renamed from: seed */
    private byte[] f18774seed;

    public C5219X9Curve(X9FieldID x9FieldID, BigInteger bigInteger, BigInteger bigInteger2, ASN1Sequence aSN1Sequence) {
        int iIntValueExact;
        int iIntValueExact2;
        int i;
        AbstractC5817ECCurve f2m;
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.prime_field)) {
            f2m = new AbstractC5817ECCurve.Fp(((ASN1Integer) x9FieldID.getParameters()).getValue(), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        } else {
            if (!this.fieldIdentifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int iIntValueExact3 = ((ASN1Integer) aSN1Sequence2.getObjectAt(0)).intValueExact();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(1);
            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.f18793tpBasis)) {
                iIntValueExact2 = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).intValueExact();
                i = 0;
                iIntValueExact = 0;
            } else {
                if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.f18792ppBasis)) {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(aSN1Sequence2.getObjectAt(2));
                int iIntValueExact4 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(0)).intValueExact();
                int iIntValueExact5 = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(1)).intValueExact();
                iIntValueExact = ASN1Integer.getInstance(aSN1Sequence3.getObjectAt(2)).intValueExact();
                iIntValueExact2 = iIntValueExact4;
                i = iIntValueExact5;
            }
            f2m = new AbstractC5817ECCurve.F2m(iIntValueExact3, iIntValueExact2, i, iIntValueExact, new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        }
        this.f18773curve = f2m;
        if (aSN1Sequence.mo14450size() == 3) {
            this.f18774seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }

    private void setFieldIdentifier() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (ECAlgorithms.isFpCurve(this.f18773curve)) {
            aSN1ObjectIdentifier = X9ObjectIdentifiers.prime_field;
        } else {
            if (!ECAlgorithms.isF2mCurve(this.f18773curve)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            aSN1ObjectIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        }
        this.fieldIdentifier = aSN1ObjectIdentifier;
    }

    public AbstractC5817ECCurve getCurve() {
        return this.f18773curve;
    }

    /* renamed from: getSeed */
    public byte[] m14733getSeed() {
        return C6238Arrays.m18231clone(this.f18774seed);
    }

    /* renamed from: hasSeed */
    public boolean m14734hasSeed() {
        return this.f18774seed != null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        if (this.fieldIdentifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.prime_field) || this.fieldIdentifier.m14446equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.m14420add(new X9FieldElement(this.f18773curve.m16298getA()).toASN1Primitive());
            X9FieldElement x9FieldElement = new X9FieldElement(this.f18773curve.m16299getB());
            aSN1EncodableVector.m14420add(x9FieldElement.toASN1Primitive());
        }
        if (this.f18774seed != null) {
            aSN1EncodableVector.m14420add(new DERBitString(this.f18774seed));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public C5219X9Curve(AbstractC5817ECCurve abstractC5817ECCurve) {
        this(abstractC5817ECCurve, null);
    }

    public C5219X9Curve(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        this.fieldIdentifier = null;
        this.f18773curve = abstractC5817ECCurve;
        this.f18774seed = C6238Arrays.m18231clone(bArr);
        setFieldIdentifier();
    }
}
