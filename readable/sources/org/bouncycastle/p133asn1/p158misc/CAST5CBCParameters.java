package org.bouncycastle.p133asn1.p158misc;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CAST5CBCParameters extends ASN1Object {

    /* renamed from: iv */
    ASN1OctetString f18413iv;
    ASN1Integer keyLength;

    private CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.f18413iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.keyLength = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }

    public static CAST5CBCParameters getInstance(Object obj) {
        if (obj instanceof CAST5CBCParameters) {
            return (CAST5CBCParameters) obj;
        }
        if (obj != null) {
            return new CAST5CBCParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getIV */
    public byte[] m14617getIV() {
        return C6238Arrays.m18231clone(this.f18413iv.getOctets());
    }

    public int getKeyLength() {
        return this.keyLength.intValueExact();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18413iv, this.keyLength);
    }

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.f18413iv = new DEROctetString(C6238Arrays.m18231clone(bArr));
        this.keyLength = ASN1Integer.m14429valueOf(i);
    }
}
