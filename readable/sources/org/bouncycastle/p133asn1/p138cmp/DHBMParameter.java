package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class DHBMParameter extends ASN1Object {

    /* renamed from: mac */
    private final AlgorithmIdentifier f18110mac;

    /* renamed from: owf */
    private final AlgorithmIdentifier f18111owf;

    private DHBMParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expecting sequence size of 2");
        }
        this.f18111owf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18110mac = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static DHBMParameter getInstance(Object obj) {
        if (obj instanceof DHBMParameter) {
            return (DHBMParameter) obj;
        }
        if (obj != null) {
            return new DHBMParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getMac */
    public AlgorithmIdentifier m14504getMac() {
        return this.f18110mac;
    }

    /* renamed from: getOwf */
    public AlgorithmIdentifier m14505getOwf() {
        return this.f18111owf;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f18111owf, this.f18110mac});
    }

    public DHBMParameter(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18111owf = algorithmIdentifier;
        this.f18110mac = algorithmIdentifier2;
    }
}
