package org.bouncycastle.p133asn1.p176x9;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;

/* loaded from: classes2.dex */
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {

    /* renamed from: ONE */
    private static final BigInteger f18775ONE = BigInteger.valueOf(1);

    /* renamed from: curve */
    private C5219X9Curve f18776curve;

    /* renamed from: fieldID */
    private X9FieldID f18777fieldID;

    /* renamed from: g */
    private X9ECPoint f18778g;

    /* renamed from: h */
    private BigInteger f18779h;

    /* renamed from: n */
    private BigInteger f18780n;

    private X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) || !((ASN1Integer) aSN1Sequence.getObjectAt(0)).hasValue(1)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        this.f18780n = ((ASN1Integer) aSN1Sequence.getObjectAt(4)).getValue();
        if (aSN1Sequence.mo14450size() == 6) {
            this.f18779h = ((ASN1Integer) aSN1Sequence.getObjectAt(5)).getValue();
        }
        X9FieldID x9FieldID = X9FieldID.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18777fieldID = x9FieldID;
        this.f18776curve = new C5219X9Curve(x9FieldID, this.f18780n, this.f18779h, ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2)));
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(3);
        if (objectAt instanceof X9ECPoint) {
            this.f18778g = (X9ECPoint) objectAt;
        } else {
            this.f18778g = new X9ECPoint(this.f18776curve.getCurve(), (ASN1OctetString) objectAt);
        }
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X9ECPoint getBaseEntry() {
        return this.f18778g;
    }

    public AbstractC5817ECCurve getCurve() {
        return this.f18776curve.getCurve();
    }

    public C5219X9Curve getCurveEntry() {
        return this.f18776curve;
    }

    public X9FieldID getFieldIDEntry() {
        return this.f18777fieldID;
    }

    /* renamed from: getG */
    public AbstractC5820ECPoint m14735getG() {
        return this.f18778g.getPoint();
    }

    /* renamed from: getH */
    public BigInteger m14736getH() {
        return this.f18779h;
    }

    /* renamed from: getN */
    public BigInteger m14737getN() {
        return this.f18780n;
    }

    /* renamed from: getSeed */
    public byte[] m14738getSeed() {
        return this.f18776curve.m14733getSeed();
    }

    /* renamed from: hasSeed */
    public boolean m14739hasSeed() {
        return this.f18776curve.m14734hasSeed();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(new ASN1Integer(f18775ONE));
        aSN1EncodableVector.m14420add(this.f18777fieldID);
        aSN1EncodableVector.m14420add(this.f18776curve);
        aSN1EncodableVector.m14420add(this.f18778g);
        aSN1EncodableVector.m14420add(new ASN1Integer(this.f18780n));
        if (this.f18779h != null) {
            aSN1EncodableVector.m14420add(new ASN1Integer(this.f18779h));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9ECParameters(AbstractC5817ECCurve abstractC5817ECCurve, X9ECPoint x9ECPoint, BigInteger bigInteger) {
        this(abstractC5817ECCurve, x9ECPoint, bigInteger, null, null);
    }

    public X9ECParameters(AbstractC5817ECCurve abstractC5817ECCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(abstractC5817ECCurve, x9ECPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(AbstractC5817ECCurve abstractC5817ECCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        X9FieldID x9FieldID;
        this.f18776curve = new C5219X9Curve(abstractC5817ECCurve, bArr);
        this.f18778g = x9ECPoint;
        this.f18780n = bigInteger;
        this.f18779h = bigInteger2;
        FiniteField field = abstractC5817ECCurve.getField();
        if (ECAlgorithms.isFpField(field)) {
            x9FieldID = new X9FieldID(field.getCharacteristic());
        } else {
            if (!ECAlgorithms.isF2mField(field)) {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
            int[] exponentsPresent = ((PolynomialExtensionField) field).getMinimalPolynomial().getExponentsPresent();
            if (exponentsPresent.length == 3) {
                x9FieldID = new X9FieldID(exponentsPresent[2], exponentsPresent[1]);
            } else {
                if (exponentsPresent.length != 5) {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
                x9FieldID = new X9FieldID(exponentsPresent[4], exponentsPresent[1], exponentsPresent[2], exponentsPresent[3]);
            }
        }
        this.f18777fieldID = x9FieldID;
    }
}
