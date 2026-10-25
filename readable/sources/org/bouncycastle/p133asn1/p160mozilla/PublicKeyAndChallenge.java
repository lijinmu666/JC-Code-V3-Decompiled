package org.bouncycastle.p133asn1.p160mozilla;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class PublicKeyAndChallenge extends ASN1Object {
    private ASN1IA5String challenge;

    /* renamed from: pkacSeq */
    private ASN1Sequence f18424pkacSeq;

    /* renamed from: spki */
    private SubjectPublicKeyInfo f18425spki;

    private PublicKeyAndChallenge(ASN1Sequence aSN1Sequence) {
        this.f18424pkacSeq = aSN1Sequence;
        this.f18425spki = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.challenge = ASN1IA5String.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PublicKeyAndChallenge getInstance(Object obj) {
        if (obj instanceof PublicKeyAndChallenge) {
            return (PublicKeyAndChallenge) obj;
        }
        if (obj != null) {
            return new PublicKeyAndChallenge(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERIA5String getChallenge() {
        ASN1IA5String aSN1IA5String = this.challenge;
        return (aSN1IA5String == null || (aSN1IA5String instanceof DERIA5String)) ? (DERIA5String) aSN1IA5String : new DERIA5String(this.challenge.getString(), false);
    }

    public ASN1IA5String getChallengeIA5() {
        return this.challenge;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.f18425spki;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18424pkacSeq;
    }
}
