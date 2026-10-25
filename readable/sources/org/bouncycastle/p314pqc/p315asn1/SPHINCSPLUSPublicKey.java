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
public class SPHINCSPLUSPublicKey extends ASN1Object {

    /* renamed from: pkroot */
    private byte[] f23040pkroot;

    /* renamed from: pkseed */
    private byte[] f23041pkseed;

    @Deprecated
    public SPHINCSPLUSPublicKey(ASN1Sequence aSN1Sequence) {
        this.f23041pkseed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
        this.f23040pkroot = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
    }

    public static SPHINCSPLUSPublicKey getInstance(Object obj) {
        if (obj instanceof SPHINCSPLUSPublicKey) {
            return (SPHINCSPLUSPublicKey) obj;
        }
        if (obj != null) {
            return new SPHINCSPLUSPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getPkroot() {
        return C6238Arrays.m18231clone(this.f23040pkroot);
    }

    public byte[] getPkseed() {
        return C6238Arrays.m18231clone(this.f23041pkseed);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23041pkseed));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23040pkroot));
        return new DERSequence(aSN1EncodableVector);
    }

    public SPHINCSPLUSPublicKey(byte[] bArr, byte[] bArr2) {
        this.f23041pkseed = bArr;
        this.f23040pkroot = bArr2;
    }
}
