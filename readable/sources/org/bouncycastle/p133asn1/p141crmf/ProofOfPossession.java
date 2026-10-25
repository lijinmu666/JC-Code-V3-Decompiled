package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;

    /* renamed from: obj */
    private ASN1Encodable f18269obj;

    /* renamed from: tagNo */
    private int f18270tagNo;

    public ProofOfPossession() {
        this.f18270tagNo = 0;
        this.f18269obj = C5103DERNull.INSTANCE;
    }

    public static ProofOfPossession getInstance(Object obj) {
        if (obj == null || (obj instanceof ProofOfPossession)) {
            return (ProofOfPossession) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new ProofOfPossession((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public ASN1Encodable getObject() {
        return this.f18269obj;
    }

    /* renamed from: getType */
    public int m14567getType() {
        return this.f18270tagNo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.f18270tagNo, this.f18269obj);
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.f18270tagNo = i;
        this.f18269obj = pOPOPrivKey;
    }

    private ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable pOPOSigningKey;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f18270tagNo = tagNo;
        if (tagNo == 0) {
            pOPOSigningKey = C5103DERNull.INSTANCE;
        } else if (tagNo == 1) {
            pOPOSigningKey = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else {
            if (tagNo != 2 && tagNo != 3) {
                throw new IllegalArgumentException("unknown tag: " + this.f18270tagNo);
            }
            pOPOSigningKey = POPOPrivKey.getInstance(aSN1TaggedObject, true);
        }
        this.f18269obj = pOPOSigningKey;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.f18270tagNo = 1;
        this.f18269obj = pOPOSigningKey;
    }
}
