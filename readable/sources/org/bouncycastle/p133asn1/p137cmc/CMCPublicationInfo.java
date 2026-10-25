package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p141crmf.PKIPublicationInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class CMCPublicationInfo extends ASN1Object {
    private final ASN1Sequence certHashes;

    /* renamed from: hashAlg */
    private final AlgorithmIdentifier f18064hashAlg;

    /* renamed from: pubInfo */
    private final PKIPublicationInfo f18065pubInfo;

    private CMCPublicationInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f18064hashAlg = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.certHashes = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18065pubInfo = PKIPublicationInfo.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CMCPublicationInfo getInstance(Object obj) {
        if (obj instanceof CMCPublicationInfo) {
            return (CMCPublicationInfo) obj;
        }
        if (obj != null) {
            return new CMCPublicationInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[][] getCertHashes() {
        int iMo14450size = this.certHashes.mo14450size();
        byte[][] bArr = new byte[iMo14450size][];
        for (int i = 0; i != iMo14450size; i++) {
            bArr[i] = C6238Arrays.m18231clone(ASN1OctetString.getInstance(this.certHashes.getObjectAt(i)).getOctets());
        }
        return bArr;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.f18064hashAlg;
    }

    public PKIPublicationInfo getPubInfo() {
        return this.f18065pubInfo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18064hashAlg);
        aSN1EncodableVector.m14420add(this.certHashes);
        aSN1EncodableVector.m14420add(this.f18065pubInfo);
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCPublicationInfo(AlgorithmIdentifier algorithmIdentifier, byte[][] bArr, PKIPublicationInfo pKIPublicationInfo) {
        this.f18064hashAlg = algorithmIdentifier;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(bArr.length);
        for (int i = 0; i != bArr.length; i++) {
            aSN1EncodableVector.m14420add(new DEROctetString(C6238Arrays.m18231clone(bArr[i])));
        }
        this.certHashes = new DERSequence(aSN1EncodableVector);
        this.f18065pubInfo = pKIPublicationInfo;
    }
}
