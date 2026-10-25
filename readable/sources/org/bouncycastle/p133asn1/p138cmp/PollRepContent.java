package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class PollRepContent extends ASN1Object {
    private final ASN1Integer[] certReqId;
    private final ASN1Integer[] checkAfter;

    /* renamed from: reason */
    private final PKIFreeText[] f18154reason;

    public PollRepContent(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2) {
        this(aSN1Integer, aSN1Integer2, null);
    }

    public static PollRepContent getInstance(Object obj) {
        if (obj instanceof PollRepContent) {
            return (PollRepContent) obj;
        }
        if (obj != null) {
            return new PollRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId(int i) {
        return this.certReqId[i];
    }

    public ASN1Integer getCheckAfter(int i) {
        return this.checkAfter[i];
    }

    public PKIFreeText getReason(int i) {
        return this.f18154reason[i];
    }

    /* renamed from: size */
    public int m14522size() {
        return this.certReqId.length;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.certReqId.length);
        for (int i = 0; i != this.certReqId.length; i++) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.m14420add(this.certReqId[i]);
            aSN1EncodableVector2.m14420add(this.checkAfter[i]);
            PKIFreeText pKIFreeText = this.f18154reason[i];
            if (pKIFreeText != null) {
                aSN1EncodableVector2.m14420add(pKIFreeText);
            }
            aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PollRepContent(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, PKIFreeText pKIFreeText) {
        this.certReqId = new ASN1Integer[]{aSN1Integer};
        this.checkAfter = new ASN1Integer[]{aSN1Integer2};
        this.f18154reason = new PKIFreeText[]{pKIFreeText};
    }

    private PollRepContent(ASN1Sequence aSN1Sequence) {
        this.certReqId = new ASN1Integer[aSN1Sequence.mo14450size()];
        this.checkAfter = new ASN1Integer[aSN1Sequence.mo14450size()];
        this.f18154reason = new PKIFreeText[aSN1Sequence.mo14450size()];
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i));
            this.certReqId[i] = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0));
            this.checkAfter[i] = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(1));
            if (aSN1Sequence2.mo14450size() > 2) {
                this.f18154reason[i] = PKIFreeText.getInstance(aSN1Sequence2.getObjectAt(2));
            }
        }
    }
}
