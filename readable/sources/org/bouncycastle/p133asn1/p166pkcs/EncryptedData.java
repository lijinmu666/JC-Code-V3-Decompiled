package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class EncryptedData extends ASN1Object {

    /* renamed from: data */
    ASN1Sequence f18473data;

    public EncryptedData(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(aSN1ObjectIdentifier);
        aSN1EncodableVector.m14420add(algorithmIdentifier.toASN1Primitive());
        aSN1EncodableVector.m14420add(new BERTaggedObject(false, 0, aSN1Encodable));
        this.f18473data = new BERSequence(aSN1EncodableVector);
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj != null) {
            return new EncryptedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getContent() {
        if (this.f18473data.mo14450size() == 3) {
            return ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(this.f18473data.getObjectAt(2)), false);
        }
        return null;
    }

    public ASN1ObjectIdentifier getContentType() {
        return ASN1ObjectIdentifier.getInstance(this.f18473data.getObjectAt(0));
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.f18473data.getObjectAt(1));
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new BERSequence(ASN1Integer.f17922ZERO, this.f18473data);
    }

    private EncryptedData(ASN1Sequence aSN1Sequence) {
        if (!((ASN1Integer) aSN1Sequence.getObjectAt(0)).hasValue(0)) {
            throw new IllegalArgumentException("sequence not version 0");
        }
        this.f18473data = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
