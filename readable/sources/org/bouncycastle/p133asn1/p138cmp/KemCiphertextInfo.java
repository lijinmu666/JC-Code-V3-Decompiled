package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class KemCiphertextInfo extends ASN1Object {

    /* renamed from: ct */
    private final ASN1OctetString f18117ct;

    /* renamed from: kem */
    private final AlgorithmIdentifier f18118kem;

    private KemCiphertextInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("sequence size should 2");
        }
        this.f18118kem = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18117ct = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static KemCiphertextInfo getInstance(Object obj) {
        if (obj instanceof KemCiphertextInfo) {
            return (KemCiphertextInfo) obj;
        }
        if (obj != null) {
            return new KemCiphertextInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCt */
    public ASN1OctetString m14509getCt() {
        return this.f18117ct;
    }

    /* renamed from: getKem */
    public AlgorithmIdentifier m14510getKem() {
        return this.f18118kem;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18118kem, this.f18117ct);
    }

    public KemCiphertextInfo(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.f18118kem = algorithmIdentifier;
        this.f18117ct = aSN1OctetString;
    }
}
