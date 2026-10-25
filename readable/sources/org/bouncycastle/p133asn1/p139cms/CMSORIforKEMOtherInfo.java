package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class CMSORIforKEMOtherInfo extends ASN1Object {
    private final int kekLength;

    /* renamed from: ukm */
    private final byte[] f18177ukm;

    /* renamed from: wrap */
    private final AlgorithmIdentifier f18178wrap;

    public CMSORIforKEMOtherInfo(AlgorithmIdentifier algorithmIdentifier, int i) {
        this(algorithmIdentifier, i, null);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18178wrap);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.kekLength));
        if (this.f18177ukm != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new DEROctetString(this.f18177ukm)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CMSORIforKEMOtherInfo(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
        if (i > 65535) {
            throw new IllegalArgumentException("kekLength must be <= 65535");
        }
        this.f18178wrap = algorithmIdentifier;
        this.kekLength = i;
        this.f18177ukm = bArr;
    }
}
