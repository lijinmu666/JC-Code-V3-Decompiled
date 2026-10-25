package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class OriginatorPublicKey extends ASN1Object {
    private AlgorithmIdentifier algorithm;
    private ASN1BitString publicKey;

    private OriginatorPublicKey(ASN1Sequence aSN1Sequence) {
        this.algorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.publicKey = (DERBitString) aSN1Sequence.getObjectAt(1);
    }

    public static OriginatorPublicKey getInstance(Object obj) {
        if (obj instanceof OriginatorPublicKey) {
            return (OriginatorPublicKey) obj;
        }
        if (obj != null) {
            return new OriginatorPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public DERBitString getPublicKey() {
        return DERBitString.m14469convert(this.publicKey);
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algorithm, this.publicKey);
    }

    public OriginatorPublicKey(AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        this.algorithm = algorithmIdentifier;
        this.publicKey = aSN1BitString;
    }

    public static OriginatorPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new OriginatorPublicKey(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public OriginatorPublicKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.algorithm = algorithmIdentifier;
        this.publicKey = new DERBitString(bArr);
    }
}
