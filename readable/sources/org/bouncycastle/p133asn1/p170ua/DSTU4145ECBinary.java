package org.bouncycastle.p133asn1.p170ua;

import java.math.BigInteger;
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
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p294field.PolynomialExtensionField;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSTU4145ECBinary extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f18563a;

    /* renamed from: b */
    ASN1OctetString f18564b;

    /* renamed from: bp */
    ASN1OctetString f18565bp;

    /* renamed from: f */
    DSTU4145BinaryField f18566f;

    /* renamed from: n */
    ASN1Integer f18567n;

    /* renamed from: version */
    BigInteger f18568version;

    private DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        this.f18568version = BigInteger.valueOf(0L);
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            if (!aSN1TaggedObject.isExplicit() || aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.f18568version = ASN1Integer.getInstance(aSN1TaggedObject.getLoadedObject()).getValue();
            i = 1;
        }
        this.f18566f = DSTU4145BinaryField.getInstance(aSN1Sequence.getObjectAt(i));
        this.f18563a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.f18564b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i + 2));
        this.f18567n = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 3));
        this.f18565bp = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i + 4));
    }

    public static DSTU4145ECBinary getInstance(Object obj) {
        if (obj instanceof DSTU4145ECBinary) {
            return (DSTU4145ECBinary) obj;
        }
        if (obj != null) {
            return new DSTU4145ECBinary(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getA */
    public BigInteger m14656getA() {
        return this.f18563a.getValue();
    }

    /* renamed from: getB */
    public byte[] m14657getB() {
        return C6238Arrays.m18231clone(this.f18564b.getOctets());
    }

    public DSTU4145BinaryField getField() {
        return this.f18566f;
    }

    /* renamed from: getG */
    public byte[] m14658getG() {
        return C6238Arrays.m18231clone(this.f18565bp.getOctets());
    }

    /* renamed from: getN */
    public BigInteger m14659getN() {
        return this.f18567n.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        if (this.f18568version.compareTo(BigInteger.valueOf(0L)) != 0) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new ASN1Integer(this.f18568version)));
        }
        aSN1EncodableVector.m14420add(this.f18566f);
        aSN1EncodableVector.m14420add(this.f18563a);
        aSN1EncodableVector.m14420add(this.f18564b);
        aSN1EncodableVector.m14420add(this.f18567n);
        aSN1EncodableVector.m14420add(this.f18565bp);
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145ECBinary(ECDomainParameters eCDomainParameters) {
        DSTU4145BinaryField dSTU4145BinaryField;
        this.f18568version = BigInteger.valueOf(0L);
        AbstractC5817ECCurve curve = eCDomainParameters.getCurve();
        if (!ECAlgorithms.isF2mCurve(curve)) {
            throw new IllegalArgumentException("only binary domain is possible");
        }
        int[] exponentsPresent = ((PolynomialExtensionField) curve.getField()).getMinimalPolynomial().getExponentsPresent();
        if (exponentsPresent.length == 3) {
            dSTU4145BinaryField = new DSTU4145BinaryField(exponentsPresent[2], exponentsPresent[1]);
        } else {
            if (exponentsPresent.length != 5) {
                throw new IllegalArgumentException("curve must have a trinomial or pentanomial basis");
            }
            dSTU4145BinaryField = new DSTU4145BinaryField(exponentsPresent[4], exponentsPresent[1], exponentsPresent[2], exponentsPresent[3]);
        }
        this.f18566f = dSTU4145BinaryField;
        this.f18563a = new ASN1Integer(curve.m16298getA().toBigInteger());
        this.f18564b = new DEROctetString(curve.m16299getB().getEncoded());
        this.f18567n = new ASN1Integer(eCDomainParameters.m15723getN());
        this.f18565bp = new DEROctetString(DSTU4145PointEncoder.encodePoint(eCDomainParameters.m15720getG()));
    }
}
