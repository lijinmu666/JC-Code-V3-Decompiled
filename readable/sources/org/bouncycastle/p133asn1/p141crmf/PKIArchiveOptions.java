package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;

    /* renamed from: value */
    private ASN1Encodable f18261value;

    public PKIArchiveOptions(ASN1OctetString aSN1OctetString) {
        this.f18261value = aSN1OctetString;
    }

    public static PKIArchiveOptions getInstance(Object obj) {
        if (obj == null || (obj instanceof PKIArchiveOptions)) {
            return (PKIArchiveOptions) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new PKIArchiveOptions(ASN1TaggedObject.getContextInstance(obj));
        }
        throw new IllegalArgumentException("unknown object: " + obj);
    }

    /* renamed from: getType */
    public int m14565getType() {
        ASN1Encodable aSN1Encodable = this.f18261value;
        if (aSN1Encodable instanceof EncryptedKey) {
            return 0;
        }
        return aSN1Encodable instanceof ASN1OctetString ? 1 : 2;
    }

    public ASN1Encodable getValue() {
        return this.f18261value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Encodable aSN1Encodable = this.f18261value;
        return aSN1Encodable instanceof EncryptedKey ? new DERTaggedObject(true, 0, aSN1Encodable) : aSN1Encodable instanceof ASN1OctetString ? new DERTaggedObject(false, 1, aSN1Encodable) : new DERTaggedObject(false, 2, aSN1Encodable);
    }

    private PKIArchiveOptions(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable encryptedKey;
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            encryptedKey = EncryptedKey.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            encryptedKey = ASN1OctetString.getInstance(aSN1TaggedObject, false);
        } else {
            if (tagNo != 2) {
                throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
            }
            encryptedKey = ASN1Boolean.getInstance(aSN1TaggedObject, false);
        }
        this.f18261value = encryptedKey;
    }

    public PKIArchiveOptions(EncryptedKey encryptedKey) {
        this.f18261value = encryptedKey;
    }

    public PKIArchiveOptions(boolean z) {
        this.f18261value = ASN1Boolean.getInstance(z);
    }
}
