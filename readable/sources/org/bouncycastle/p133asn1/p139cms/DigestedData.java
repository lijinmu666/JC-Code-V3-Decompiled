package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class DigestedData extends ASN1Object {

    /* renamed from: digest */
    private ASN1OctetString f18186digest;
    private AlgorithmIdentifier digestAlgorithm;
    private ContentInfo encapContentInfo;

    /* renamed from: version */
    private ASN1Integer f18187version;

    private DigestedData(ASN1Sequence aSN1Sequence) {
        this.f18187version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(2));
        this.f18186digest = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static DigestedData getInstance(Object obj) {
        if (obj instanceof DigestedData) {
            return (DigestedData) obj;
        }
        if (obj != null) {
            return new DigestedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getDigest() {
        return C6238Arrays.m18231clone(this.f18186digest.getOctets());
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this.f18187version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18187version);
        aSN1EncodableVector.m14420add(this.digestAlgorithm);
        aSN1EncodableVector.m14420add(this.encapContentInfo);
        aSN1EncodableVector.m14420add(this.f18186digest);
        return new BERSequence(aSN1EncodableVector);
    }

    public DigestedData(AlgorithmIdentifier algorithmIdentifier, ContentInfo contentInfo, byte[] bArr) {
        this.f18187version = ASN1Integer.f17922ZERO;
        this.digestAlgorithm = algorithmIdentifier;
        this.encapContentInfo = contentInfo;
        this.f18186digest = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public static DigestedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
