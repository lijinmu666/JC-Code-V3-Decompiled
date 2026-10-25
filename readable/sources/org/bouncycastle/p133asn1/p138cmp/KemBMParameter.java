package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class KemBMParameter extends ASN1Object {

    /* renamed from: kdf */
    private final AlgorithmIdentifier f18114kdf;

    /* renamed from: len */
    private final ASN1Integer f18115len;

    /* renamed from: mac */
    private final AlgorithmIdentifier f18116mac;

    private KemBMParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("sequence size should 3");
        }
        this.f18114kdf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18115len = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18116mac = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static KemBMParameter getInstance(Object obj) {
        if (obj instanceof KemBMParameter) {
            return (KemBMParameter) obj;
        }
        if (obj != null) {
            return new KemBMParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getKdf */
    public AlgorithmIdentifier m14506getKdf() {
        return this.f18114kdf;
    }

    /* renamed from: getLen */
    public ASN1Integer m14507getLen() {
        return this.f18115len;
    }

    /* renamed from: getMac */
    public AlgorithmIdentifier m14508getMac() {
        return this.f18116mac;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18114kdf);
        aSN1EncodableVector.m14420add(this.f18115len);
        aSN1EncodableVector.m14420add(this.f18116mac);
        return new DERSequence(aSN1EncodableVector);
    }

    public KemBMParameter(AlgorithmIdentifier algorithmIdentifier, long j, AlgorithmIdentifier algorithmIdentifier2) {
        this(algorithmIdentifier, ASN1Integer.m14430valueOf(j), algorithmIdentifier2);
    }

    public KemBMParameter(AlgorithmIdentifier algorithmIdentifier, ASN1Integer aSN1Integer, AlgorithmIdentifier algorithmIdentifier2) {
        this.f18114kdf = algorithmIdentifier;
        this.f18115len = aSN1Integer;
        this.f18116mac = algorithmIdentifier2;
    }
}
