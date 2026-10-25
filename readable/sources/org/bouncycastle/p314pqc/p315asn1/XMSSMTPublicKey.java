package org.bouncycastle.p314pqc.p315asn1;

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
public class XMSSMTPublicKey extends ASN1Object {
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23050root;

    private XMSSMTPublicKey(ASN1Sequence aSN1Sequence) {
        if (!ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).hasValue(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.publicSeed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.f23050root = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static XMSSMTPublicKey getInstance(Object obj) {
        if (obj instanceof XMSSMTPublicKey) {
            return (XMSSMTPublicKey) obj;
        }
        if (obj != null) {
            return new XMSSMTPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17477getRoot() {
        return C6238Arrays.m18231clone(this.f23050root);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(ASN1Integer.f17922ZERO);
        aSN1EncodableVector.m14420add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23050root));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSMTPublicKey(byte[] bArr, byte[] bArr2) {
        this.publicSeed = C6238Arrays.m18231clone(bArr);
        this.f23050root = C6238Arrays.m18231clone(bArr2);
    }
}
