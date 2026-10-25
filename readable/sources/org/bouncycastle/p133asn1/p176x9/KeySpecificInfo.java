package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class KeySpecificInfo extends ASN1Object {
    private final ASN1ObjectIdentifier algorithm;

    /* renamed from: counter */
    private final ASN1OctetString f18766counter;

    public KeySpecificInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1OctetString aSN1OctetString) {
        if (aSN1ObjectIdentifier == null) {
            throw new NullPointerException("'algorithm' cannot be null");
        }
        if (aSN1OctetString == null) {
            throw new NullPointerException("'counter' cannot be null");
        }
        this.algorithm = aSN1ObjectIdentifier;
        this.f18766counter = aSN1OctetString;
    }

    public static KeySpecificInfo getInstance(Object obj) {
        if (obj instanceof KeySpecificInfo) {
            return (KeySpecificInfo) obj;
        }
        if (obj != null) {
            return new KeySpecificInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static KeySpecificInfo getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new KeySpecificInfo(ASN1Sequence.getTagged(aSN1TaggedObject, z));
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1OctetString getCounter() {
        return this.f18766counter;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algorithm, this.f18766counter);
    }

    private KeySpecificInfo(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size == 2) {
            this.algorithm = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.f18766counter = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + iMo14450size);
        }
    }

    public static KeySpecificInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new KeySpecificInfo(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
