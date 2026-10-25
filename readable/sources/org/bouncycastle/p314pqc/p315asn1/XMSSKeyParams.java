package org.bouncycastle.p314pqc.p315asn1;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class XMSSKeyParams extends ASN1Object {

    /* renamed from: height */
    private final int f23042height;
    private final AlgorithmIdentifier treeDigest;

    /* renamed from: version */
    private final ASN1Integer f23043version;

    public XMSSKeyParams(int i, AlgorithmIdentifier algorithmIdentifier) {
        this.f23043version = ASN1Integer.f17922ZERO;
        this.f23042height = i;
        this.treeDigest = algorithmIdentifier;
    }

    public static XMSSKeyParams getInstance(Object obj) {
        if (obj instanceof XMSSKeyParams) {
            return (XMSSKeyParams) obj;
        }
        if (obj != null) {
            return new XMSSKeyParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getHeight() {
        return this.f23042height;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(this.f23043version);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23042height));
        aSN1EncodableVector.m14420add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }

    private XMSSKeyParams(ASN1Sequence aSN1Sequence) {
        this.f23043version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.f23042height = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
    }
}
