package org.bouncycastle.p314pqc.p315asn1;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMCEPublicKey extends ASN1Object {

    /* renamed from: T */
    private byte[] f23014T;

    @Deprecated
    public CMCEPublicKey(ASN1Sequence aSN1Sequence) {
        this.f23014T = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
    }

    public static CMCEPublicKey getInstance(Object obj) {
        if (obj instanceof CMCEPublicKey) {
            return (CMCEPublicKey) obj;
        }
        if (obj != null) {
            return new CMCEPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getT */
    public byte[] m17463getT() {
        return C6238Arrays.m18231clone(this.f23014T);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23014T));
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCEPublicKey(byte[] bArr) {
        this.f23014T = bArr;
    }
}
