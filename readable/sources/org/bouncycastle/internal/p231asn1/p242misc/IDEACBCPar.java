package org.bouncycastle.internal.p231asn1.p242misc;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class IDEACBCPar extends ASN1Object {

    /* renamed from: iv */
    ASN1OctetString f21263iv;

    private IDEACBCPar(ASN1Sequence aSN1Sequence) {
        this.f21263iv = aSN1Sequence.mo14450size() == 1 ? (ASN1OctetString) aSN1Sequence.getObjectAt(0) : null;
    }

    public static IDEACBCPar getInstance(Object obj) {
        if (obj instanceof IDEACBCPar) {
            return (IDEACBCPar) obj;
        }
        if (obj != null) {
            return new IDEACBCPar(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getIV */
    public byte[] m15988getIV() {
        ASN1OctetString aSN1OctetString = this.f21263iv;
        if (aSN1OctetString != null) {
            return C6238Arrays.m18231clone(aSN1OctetString.getOctets());
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(1);
        ASN1OctetString aSN1OctetString = this.f21263iv;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.m14420add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public IDEACBCPar(byte[] bArr) {
        this.f21263iv = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }
}
