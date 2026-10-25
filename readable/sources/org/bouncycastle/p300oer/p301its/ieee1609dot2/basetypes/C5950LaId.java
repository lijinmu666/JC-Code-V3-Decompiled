package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.LaId */
/* loaded from: classes2.dex */
public class C5950LaId extends ASN1Object {

    /* renamed from: laId */
    private final byte[] f22735laId;

    private C5950LaId(ASN1OctetString aSN1OctetString) {
        this(aSN1OctetString.getOctets());
    }

    private void assertLength() {
        if (this.f22735laId.length != 2) {
            throw new IllegalArgumentException("laId must be 2 octets");
        }
    }

    public static C5950LaId getInstance(Object obj) {
        if (obj instanceof C5950LaId) {
            return (C5950LaId) obj;
        }
        if (obj != null) {
            return new C5950LaId(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getLaId */
    public byte[] m17290getLaId() {
        return C6238Arrays.m18231clone(this.f22735laId);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.f22735laId);
    }

    public C5950LaId(byte[] bArr) {
        this.f22735laId = bArr;
        assertLength();
    }
}
