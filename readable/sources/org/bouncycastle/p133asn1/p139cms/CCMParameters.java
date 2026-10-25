package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class CCMParameters extends ASN1Object {

    /* renamed from: icvLen */
    private int f18174icvLen;

    /* renamed from: nonce */
    private byte[] f18175nonce;

    private CCMParameters(ASN1Sequence aSN1Sequence) {
        this.f18175nonce = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets();
        this.f18174icvLen = aSN1Sequence.mo14450size() == 2 ? ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).intValueExact() : 12;
    }

    public static CCMParameters getInstance(Object obj) {
        if (obj instanceof CCMParameters) {
            return (CCMParameters) obj;
        }
        if (obj != null) {
            return new CCMParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getIcvLen() {
        return this.f18174icvLen;
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone(this.f18175nonce);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(new DEROctetString(this.f18175nonce));
        int i = this.f18174icvLen;
        if (i != 12) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CCMParameters(byte[] bArr, int i) {
        this.f18175nonce = C6238Arrays.m18231clone(bArr);
        this.f18174icvLen = i;
    }
}
