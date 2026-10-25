package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.util.Arrays;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HashedId extends ASN1Object {

    /* renamed from: id */
    private final byte[] f22732id;

    public HashedId(byte[] bArr) {
        this.f22732id = C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    /* renamed from: equals */
    public boolean mo14431equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.mo14431equals(obj)) {
            return Arrays.equals(this.f22732id, ((HashedId) obj).f22732id);
        }
        return false;
    }

    public byte[] getHashBytes() {
        return C6238Arrays.m18231clone(this.f22732id);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.f22732id);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(this.f22732id);
    }
}
