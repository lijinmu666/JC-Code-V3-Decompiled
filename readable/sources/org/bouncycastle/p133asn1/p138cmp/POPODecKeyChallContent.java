package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class POPODecKeyChallContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18152content;

    private POPODecKeyChallContent(ASN1Sequence aSN1Sequence) {
        this.f18152content = aSN1Sequence;
    }

    public static POPODecKeyChallContent getInstance(Object obj) {
        if (obj instanceof POPODecKeyChallContent) {
            return (POPODecKeyChallContent) obj;
        }
        if (obj != null) {
            return new POPODecKeyChallContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18152content;
    }

    public Challenge[] toChallengeArray() {
        int iMo14450size = this.f18152content.mo14450size();
        Challenge[] challengeArr = new Challenge[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            challengeArr[i] = Challenge.getInstance(this.f18152content.getObjectAt(i));
        }
        return challengeArr;
    }

    public POPODecKeyChallContent(Challenge... challengeArr) {
        this.f18152content = new DERSequence(challengeArr);
    }
}
