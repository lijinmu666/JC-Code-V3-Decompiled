package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class SymmetricEncryptionKey extends ASN1Object implements ASN1Choice {
    public static final int aes128ccm = 0;

    /* renamed from: choice */
    private final int f22774choice;
    private final ASN1Encodable symmetricEncryptionKey;

    public SymmetricEncryptionKey(int i, ASN1Encodable aSN1Encodable) {
        this.f22774choice = i;
        this.symmetricEncryptionKey = aSN1Encodable;
    }

    public static SymmetricEncryptionKey aes128ccm(ASN1OctetString aSN1OctetString) {
        return new SymmetricEncryptionKey(0, aSN1OctetString);
    }

    public static SymmetricEncryptionKey getInstance(Object obj) {
        if (obj instanceof SymmetricEncryptionKey) {
            return (SymmetricEncryptionKey) obj;
        }
        if (obj != null) {
            return new SymmetricEncryptionKey(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22774choice;
    }

    public ASN1Encodable getSymmetricEncryptionKey() {
        return this.symmetricEncryptionKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22774choice, this.symmetricEncryptionKey);
    }

    private SymmetricEncryptionKey(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22774choice = tagNo;
        if (tagNo != 0) {
            throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
        ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        if (aSN1OctetString.getOctets().length != 16) {
            throw new IllegalArgumentException("aes128ccm string not 16 bytes");
        }
        this.symmetricEncryptionKey = aSN1OctetString;
    }

    public static SymmetricEncryptionKey aes128ccm(byte[] bArr) {
        return new SymmetricEncryptionKey(0, new DEROctetString(bArr));
    }
}
