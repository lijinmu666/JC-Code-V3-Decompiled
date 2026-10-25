package org.bouncycastle.internal.p231asn1.p233cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GCMParameters extends ASN1Object {

    /* renamed from: icvLen */
    private int f21241icvLen;

    /* renamed from: nonce */
    private byte[] f21242nonce;

    private GCMParameters(ASN1Sequence aSN1Sequence) {
        this.f21242nonce = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets();
        this.f21241icvLen = aSN1Sequence.mo14450size() == 2 ? ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).intValueExact() : 12;
    }

    public static GCMParameters getInstance(Object obj) {
        if (obj instanceof GCMParameters) {
            return (GCMParameters) obj;
        }
        if (obj != null) {
            return new GCMParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getIcvLen() {
        return this.f21241icvLen;
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone(this.f21242nonce);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(new DEROctetString(this.f21242nonce));
        int i = this.f21241icvLen;
        if (i != 12) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public GCMParameters(byte[] bArr, int i) {
        this.f21242nonce = C6238Arrays.m18231clone(bArr);
        this.f21241icvLen = i;
    }
}
