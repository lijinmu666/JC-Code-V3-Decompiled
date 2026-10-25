package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.C5116CertId;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes.dex */
public class OOBCertHash extends ASN1Object {

    /* renamed from: certId */
    private final C5116CertId f18124certId;

    /* renamed from: hashAlg */
    private final AlgorithmIdentifier f18125hashAlg;

    /* renamed from: hashVal */
    private final ASN1BitString f18126hashVal;

    private OOBCertHash(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        int i = iMo14450size - 1;
        this.f18126hashVal = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(i));
        AlgorithmIdentifier algorithmIdentifier = null;
        C5116CertId c5116CertId = null;
        for (int i2 = iMo14450size - 2; i2 >= 0; i2--) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i2);
            if (aSN1TaggedObject.hasContextTag(0)) {
                algorithmIdentifier = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else {
                if (!aSN1TaggedObject.hasContextTag(1)) {
                    throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(aSN1TaggedObject));
                }
                c5116CertId = C5116CertId.getInstance(aSN1TaggedObject, true);
            }
        }
        this.f18125hashAlg = algorithmIdentifier;
        this.f18124certId = c5116CertId;
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static OOBCertHash getInstance(Object obj) {
        if (obj instanceof OOBCertHash) {
            return (OOBCertHash) obj;
        }
        if (obj != null) {
            return new OOBCertHash(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5116CertId getCertId() {
        return this.f18124certId;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.f18125hashAlg;
    }

    public ASN1BitString getHashVal() {
        return this.f18126hashVal;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        addOptional(aSN1EncodableVector, 0, this.f18125hashAlg);
        addOptional(aSN1EncodableVector, 1, this.f18124certId);
        aSN1EncodableVector.m14420add(this.f18126hashVal);
        return new DERSequence(aSN1EncodableVector);
    }

    public OOBCertHash(AlgorithmIdentifier algorithmIdentifier, C5116CertId c5116CertId, DERBitString dERBitString) {
        this.f18125hashAlg = algorithmIdentifier;
        this.f18124certId = c5116CertId;
        this.f18126hashVal = dERBitString;
    }

    public OOBCertHash(AlgorithmIdentifier algorithmIdentifier, C5116CertId c5116CertId, byte[] bArr) {
        this(algorithmIdentifier, c5116CertId, new DERBitString(bArr));
    }
}
