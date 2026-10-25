package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class PBMParameter extends ASN1Object {
    private final ASN1Integer iterationCount;

    /* renamed from: mac */
    private final AlgorithmIdentifier f18127mac;

    /* renamed from: owf */
    private final AlgorithmIdentifier f18128owf;

    /* renamed from: salt */
    private final ASN1OctetString f18129salt;

    public PBMParameter(ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, ASN1Integer aSN1Integer, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18129salt = aSN1OctetString;
        this.f18128owf = algorithmIdentifier;
        this.iterationCount = aSN1Integer;
        this.f18127mac = algorithmIdentifier2;
    }

    public static PBMParameter getInstance(Object obj) {
        if (obj instanceof PBMParameter) {
            return (PBMParameter) obj;
        }
        if (obj != null) {
            return new PBMParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getIterationCount() {
        return this.iterationCount;
    }

    /* renamed from: getMac */
    public AlgorithmIdentifier m14514getMac() {
        return this.f18127mac;
    }

    /* renamed from: getOwf */
    public AlgorithmIdentifier m14515getOwf() {
        return this.f18128owf;
    }

    /* renamed from: getSalt */
    public ASN1OctetString m14516getSalt() {
        return this.f18129salt;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18129salt);
        aSN1EncodableVector.m14420add(this.f18128owf);
        aSN1EncodableVector.m14420add(this.iterationCount);
        aSN1EncodableVector.m14420add(this.f18127mac);
        return new DERSequence(aSN1EncodableVector);
    }

    private PBMParameter(ASN1Sequence aSN1Sequence) {
        this.f18129salt = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18128owf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.iterationCount = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2));
        this.f18127mac = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public PBMParameter(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2) {
        this(new DEROctetString(bArr), algorithmIdentifier, ASN1Integer.m14429valueOf(i), algorithmIdentifier2);
    }
}
