package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class GenericHybridParameters extends ASN1Object {

    /* renamed from: dem */
    private final AlgorithmIdentifier f18193dem;

    /* renamed from: kem */
    private final AlgorithmIdentifier f18194kem;

    private GenericHybridParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
        }
        this.f18194kem = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18193dem = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static GenericHybridParameters getInstance(Object obj) {
        if (obj instanceof GenericHybridParameters) {
            return (GenericHybridParameters) obj;
        }
        if (obj != null) {
            return new GenericHybridParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getDem */
    public AlgorithmIdentifier m14538getDem() {
        return this.f18193dem;
    }

    /* renamed from: getKem */
    public AlgorithmIdentifier m14539getKem() {
        return this.f18194kem;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18194kem, this.f18193dem);
    }

    public GenericHybridParameters(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18194kem = algorithmIdentifier;
        this.f18193dem = algorithmIdentifier2;
    }
}
