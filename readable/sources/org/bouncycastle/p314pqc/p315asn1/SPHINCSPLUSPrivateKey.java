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
public class SPHINCSPLUSPrivateKey extends ASN1Object {
    private SPHINCSPLUSPublicKey PublicKey;

    /* renamed from: skprf */
    private byte[] f23037skprf;

    /* renamed from: skseed */
    private byte[] f23038skseed;

    /* renamed from: version */
    private int f23039version;

    public SPHINCSPLUSPrivateKey(int i, byte[] bArr, byte[] bArr2) {
        this(i, bArr, bArr2, null);
    }

    public static SPHINCSPLUSPrivateKey getInstance(Object obj) {
        if (obj instanceof SPHINCSPLUSPrivateKey) {
            return (SPHINCSPLUSPrivateKey) obj;
        }
        if (obj != null) {
            return new SPHINCSPLUSPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SPHINCSPLUSPublicKey getPublicKey() {
        return this.PublicKey;
    }

    public byte[] getSkprf() {
        return C6238Arrays.m18231clone(this.f23037skprf);
    }

    public byte[] getSkseed() {
        return C6238Arrays.m18231clone(this.f23038skseed);
    }

    public int getVersion() {
        return this.f23039version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23039version));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23038skseed));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23037skprf));
        SPHINCSPLUSPublicKey sPHINCSPLUSPublicKey = this.PublicKey;
        if (sPHINCSPLUSPublicKey != null) {
            aSN1EncodableVector.m14420add(new SPHINCSPLUSPublicKey(sPHINCSPLUSPublicKey.getPkseed(), this.PublicKey.getPkroot()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SPHINCSPLUSPrivateKey(int i, byte[] bArr, byte[] bArr2, SPHINCSPLUSPublicKey sPHINCSPLUSPublicKey) {
        this.f23039version = i;
        this.f23038skseed = bArr;
        this.f23037skprf = bArr2;
        this.PublicKey = sPHINCSPLUSPublicKey;
    }

    @Deprecated
    public SPHINCSPLUSPrivateKey(ASN1Sequence aSN1Sequence) {
        int iIntValueExact = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23039version = iIntValueExact;
        if (iIntValueExact != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23038skseed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.f23037skprf = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
        if (aSN1Sequence.mo14450size() == 4) {
            this.PublicKey = SPHINCSPLUSPublicKey.getInstance(aSN1Sequence.getObjectAt(3));
        }
    }
}
