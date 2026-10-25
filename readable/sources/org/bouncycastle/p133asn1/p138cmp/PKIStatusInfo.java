package org.bouncycastle.p133asn1.p138cmp;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class PKIStatusInfo extends ASN1Object {
    ASN1BitString failInfo;

    /* renamed from: status */
    ASN1Integer f18151status;
    PKIFreeText statusString;

    private PKIStatusInfo(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        this.f18151status = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.statusString = null;
        this.failInfo = null;
        if (aSN1Sequence.mo14450size() > 2) {
            this.statusString = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(1));
            objectAt = aSN1Sequence.getObjectAt(2);
        } else {
            if (aSN1Sequence.mo14450size() <= 1) {
                return;
            }
            objectAt = aSN1Sequence.getObjectAt(1);
            if (!(objectAt instanceof ASN1BitString)) {
                this.statusString = PKIFreeText.getInstance(objectAt);
                return;
            }
        }
        this.failInfo = ASN1BitString.getInstance(objectAt);
    }

    public static PKIStatusInfo getInstance(Object obj) {
        if (obj instanceof PKIStatusInfo) {
            return (PKIStatusInfo) obj;
        }
        if (obj != null) {
            return new PKIStatusInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1BitString getFailInfo() {
        return this.failInfo;
    }

    public BigInteger getStatus() {
        return this.f18151status.getValue();
    }

    public ASN1Integer getStatusObject() {
        return this.f18151status;
    }

    public PKIFreeText getStatusString() {
        return this.statusString;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18151status);
        PKIFreeText pKIFreeText = this.statusString;
        if (pKIFreeText != null) {
            aSN1EncodableVector.m14420add(pKIFreeText);
        }
        ASN1BitString aSN1BitString = this.failInfo;
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(aSN1BitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PKIStatusInfo(PKIStatus pKIStatus) {
        this.f18151status = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
    }

    public static PKIStatusInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText) {
        this.f18151status = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
        this.statusString = pKIFreeText;
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText, PKIFailureInfo pKIFailureInfo) {
        this.f18151status = ASN1Integer.getInstance(pKIStatus.toASN1Primitive());
        this.statusString = pKIFreeText;
        this.failInfo = pKIFailureInfo;
    }
}
