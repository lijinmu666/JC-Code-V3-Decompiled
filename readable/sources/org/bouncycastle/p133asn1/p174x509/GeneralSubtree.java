package org.bouncycastle.p133asn1.p174x509;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class GeneralSubtree extends ASN1Object {

    /* renamed from: ZERO */
    private static final BigInteger f18658ZERO = BigInteger.valueOf(0);

    /* renamed from: base */
    private GeneralName f18659base;

    /* renamed from: maximum */
    private ASN1Integer f18660maximum;

    /* renamed from: minimum */
    private ASN1Integer f18661minimum;

    private GeneralSubtree(ASN1Sequence aSN1Sequence) {
        ASN1TaggedObject aSN1TaggedObject;
        this.f18659base = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size != 1) {
            if (iMo14450size == 2) {
                aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.f18661minimum = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    return;
                } else if (tagNo != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
                }
            } else {
                if (iMo14450size != 3) {
                    throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
                }
                ASN1TaggedObject aSN1TaggedObject2 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                if (aSN1TaggedObject2.getTagNo() != 0) {
                    throw new IllegalArgumentException("Bad tag number for 'minimum': " + aSN1TaggedObject2.getTagNo());
                }
                this.f18661minimum = ASN1Integer.getInstance(aSN1TaggedObject2, false);
                aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                if (aSN1TaggedObject.getTagNo() != 1) {
                    throw new IllegalArgumentException("Bad tag number for 'maximum': " + aSN1TaggedObject.getTagNo());
                }
            }
            this.f18660maximum = ASN1Integer.getInstance(aSN1TaggedObject, false);
        }
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof GeneralSubtree ? (GeneralSubtree) obj : new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    /* renamed from: getBase */
    public GeneralName m14694getBase() {
        return this.f18659base;
    }

    public BigInteger getMaximum() {
        ASN1Integer aSN1Integer = this.f18660maximum;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public BigInteger getMinimum() {
        ASN1Integer aSN1Integer = this.f18661minimum;
        return aSN1Integer == null ? f18658ZERO : aSN1Integer.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18659base);
        ASN1Integer aSN1Integer = this.f18661minimum;
        if (aSN1Integer != null && !aSN1Integer.hasValue(0)) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) this.f18661minimum));
        }
        ASN1Integer aSN1Integer2 = this.f18660maximum;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1Integer2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, null, null);
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f18659base = generalName;
        if (bigInteger2 != null) {
            this.f18660maximum = new ASN1Integer(bigInteger2);
        }
        this.f18661minimum = bigInteger == null ? null : new ASN1Integer(bigInteger);
    }
}
