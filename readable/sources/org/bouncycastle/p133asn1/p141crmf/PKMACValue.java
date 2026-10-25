package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.CMPObjectIdentifiers;
import org.bouncycastle.p133asn1.p138cmp.PBMParameter;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class PKMACValue extends ASN1Object {

    /* renamed from: algId */
    private AlgorithmIdentifier f18263algId;

    /* renamed from: value */
    private ASN1BitString f18264value;

    private PKMACValue(ASN1Sequence aSN1Sequence) {
        this.f18263algId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18264value = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PKMACValue getInstance(Object obj) {
        if (obj instanceof PKMACValue) {
            return (PKMACValue) obj;
        }
        if (obj != null) {
            return new PKMACValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgId() {
        return this.f18263algId;
    }

    public ASN1BitString getValue() {
        return this.f18264value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18263algId, this.f18264value);
    }

    public PKMACValue(PBMParameter pBMParameter, DERBitString dERBitString) {
        this(new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, pBMParameter), dERBitString);
    }

    public static PKMACValue getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public PKMACValue(AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString) {
        this.f18263algId = algorithmIdentifier;
        this.f18264value = dERBitString;
    }
}
