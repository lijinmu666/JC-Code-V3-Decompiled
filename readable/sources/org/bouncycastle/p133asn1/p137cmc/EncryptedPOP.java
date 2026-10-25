package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class EncryptedPOP extends ASN1Object {

    /* renamed from: cms */
    private final ContentInfo f18076cms;

    /* renamed from: request */
    private final TaggedRequest f18077request;
    private final AlgorithmIdentifier thePOPAlgID;

    /* renamed from: witness */
    private final byte[] f18078witness;
    private final AlgorithmIdentifier witnessAlgID;

    private EncryptedPOP(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f18077request = TaggedRequest.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18076cms = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        this.thePOPAlgID = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.witnessAlgID = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
        this.f18078witness = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4)).getOctets());
    }

    public static EncryptedPOP getInstance(Object obj) {
        if (obj instanceof EncryptedPOP) {
            return (EncryptedPOP) obj;
        }
        if (obj != null) {
            return new EncryptedPOP(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCms */
    public ContentInfo m14491getCms() {
        return this.f18076cms;
    }

    public TaggedRequest getRequest() {
        return this.f18077request;
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    public byte[] getWitness() {
        return C6238Arrays.m18231clone(this.f18078witness);
    }

    public AlgorithmIdentifier getWitnessAlgID() {
        return this.witnessAlgID;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18077request);
        aSN1EncodableVector.m14420add(this.f18076cms);
        aSN1EncodableVector.m14420add(this.thePOPAlgID);
        aSN1EncodableVector.m14420add(this.witnessAlgID);
        aSN1EncodableVector.m14420add(new DEROctetString(this.f18078witness));
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedPOP(TaggedRequest taggedRequest, ContentInfo contentInfo, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        this.f18077request = taggedRequest;
        this.f18076cms = contentInfo;
        this.thePOPAlgID = algorithmIdentifier;
        this.witnessAlgID = algorithmIdentifier2;
        this.f18078witness = C6238Arrays.m18231clone(bArr);
    }
}
