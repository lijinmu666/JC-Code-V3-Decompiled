package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class EncryptionKey extends ASN1Object implements ASN1Choice {
    public static final int publicOption = 0;
    public static final int symmetric = 1;

    /* renamed from: choice */
    private final int f22724choice;
    private final ASN1Encodable encryptionKey;

    public EncryptionKey(int i, ASN1Encodable aSN1Encodable) {
        this.f22724choice = i;
        if (i == 0 || i == 1) {
            this.encryptionKey = aSN1Encodable;
            return;
        }
        throw new IllegalArgumentException("invalid choice value " + i);
    }

    public static EncryptionKey getInstance(Object obj) {
        if (obj instanceof EncryptionKey) {
            return (EncryptionKey) obj;
        }
        if (obj != null) {
            return new EncryptionKey(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static EncryptionKey publicOption(PublicEncryptionKey publicEncryptionKey) {
        return new EncryptionKey(0, publicEncryptionKey);
    }

    public static EncryptionKey symmetric(SymmetricEncryptionKey symmetricEncryptionKey) {
        return new EncryptionKey(1, symmetricEncryptionKey);
    }

    public int getChoice() {
        return this.f22724choice;
    }

    public ASN1Encodable getEncryptionKey() {
        return this.encryptionKey;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22724choice, this.encryptionKey);
    }

    private EncryptionKey(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getExplicitBaseObject());
    }
}
