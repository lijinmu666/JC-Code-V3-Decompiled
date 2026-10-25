package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class CompressedData extends ASN1Object {
    private AlgorithmIdentifier compressionAlgorithm;
    private ContentInfo encapContentInfo;

    /* renamed from: version */
    private ASN1Integer f18183version;

    private CompressedData(ASN1Sequence aSN1Sequence) {
        this.f18183version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.compressionAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CompressedData getInstance(Object obj) {
        if (obj instanceof CompressedData) {
            return (CompressedData) obj;
        }
        if (obj != null) {
            return new CompressedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this.compressionAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this.f18183version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18183version);
        aSN1EncodableVector.m14420add(this.compressionAlgorithm);
        aSN1EncodableVector.m14420add(this.encapContentInfo);
        return new BERSequence(aSN1EncodableVector);
    }

    public CompressedData(AlgorithmIdentifier algorithmIdentifier, ContentInfo contentInfo) {
        this.f18183version = ASN1Integer.f17922ZERO;
        this.compressionAlgorithm = algorithmIdentifier;
        this.encapContentInfo = contentInfo;
    }

    public static CompressedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
