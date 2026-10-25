package org.bouncycastle.p314pqc.p315asn1;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class XMSSMTKeyParams extends ASN1Object {

    /* renamed from: height */
    private final int f23044height;

    /* renamed from: layers */
    private final int f23045layers;
    private final AlgorithmIdentifier treeDigest;

    /* renamed from: version */
    private final ASN1Integer f23046version;

    public XMSSMTKeyParams(int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.f23046version = ASN1Integer.f17922ZERO;
        this.f23044height = i;
        this.f23045layers = i2;
        this.treeDigest = algorithmIdentifier;
    }

    public static XMSSMTKeyParams getInstance(Object obj) {
        if (obj instanceof XMSSMTKeyParams) {
            return (XMSSMTKeyParams) obj;
        }
        if (obj != null) {
            return new XMSSMTKeyParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getHeight() {
        return this.f23044height;
    }

    public int getLayers() {
        return this.f23045layers;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f23046version);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23044height));
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23045layers));
        aSN1EncodableVector.m14420add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }

    private XMSSMTKeyParams(ASN1Sequence aSN1Sequence) {
        this.f23046version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.f23044height = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f23045layers = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).intValueExact();
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }
}
