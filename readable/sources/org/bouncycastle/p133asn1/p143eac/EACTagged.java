package org.bouncycastle.p133asn1.p143eac;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
class EACTagged {
    /* renamed from: create */
    public static ASN1TaggedObject m14594create(int i, ASN1Sequence aSN1Sequence) {
        return new DERTaggedObject(false, 64, i, (ASN1Encodable) aSN1Sequence);
    }

    /* renamed from: create */
    public static ASN1TaggedObject m14595create(int i, PublicKeyDataObject publicKeyDataObject) {
        return new DERTaggedObject(false, 64, i, (ASN1Encodable) publicKeyDataObject);
    }

    /* renamed from: create */
    public static ASN1TaggedObject m14596create(int i, byte[] bArr) {
        return new DERTaggedObject(false, 64, i, (ASN1Encodable) new DEROctetString(bArr));
    }
}
