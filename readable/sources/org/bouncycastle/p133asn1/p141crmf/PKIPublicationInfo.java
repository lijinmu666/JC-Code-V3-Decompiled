package org.bouncycastle.p133asn1.p141crmf;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class PKIPublicationInfo extends ASN1Object {
    public static final ASN1Integer dontPublish = ASN1Integer.f17922ZERO;
    public static final ASN1Integer pleasePublish = ASN1Integer.f17918ONE;

    /* renamed from: action */
    private ASN1Integer f18262action;
    private ASN1Sequence pubInfos;

    public PKIPublicationInfo(BigInteger bigInteger) {
        this(new ASN1Integer(bigInteger));
    }

    public static PKIPublicationInfo getInstance(Object obj) {
        if (obj instanceof PKIPublicationInfo) {
            return (PKIPublicationInfo) obj;
        }
        if (obj != null) {
            return new PKIPublicationInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getAction() {
        return this.f18262action;
    }

    public SinglePubInfo[] getPubInfos() {
        ASN1Sequence aSN1Sequence = this.pubInfos;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        SinglePubInfo[] singlePubInfoArr = new SinglePubInfo[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            singlePubInfoArr[i] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(i));
        }
        return singlePubInfoArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18262action);
        ASN1Sequence aSN1Sequence = this.pubInfos;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PKIPublicationInfo(ASN1Integer aSN1Integer) {
        this.f18262action = aSN1Integer;
    }

    private PKIPublicationInfo(ASN1Sequence aSN1Sequence) {
        this.f18262action = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.pubInfos = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public PKIPublicationInfo(SinglePubInfo singlePubInfo) {
        this(singlePubInfo != null ? new SinglePubInfo[]{singlePubInfo} : null);
    }

    public PKIPublicationInfo(SinglePubInfo[] singlePubInfoArr) {
        this.f18262action = pleasePublish;
        if (singlePubInfoArr != null) {
            this.pubInfos = new DERSequence(singlePubInfoArr);
        } else {
            this.pubInfos = null;
        }
    }
}
