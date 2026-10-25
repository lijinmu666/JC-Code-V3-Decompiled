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
public class CMCEPrivateKey extends ASN1Object {

    /* renamed from: C */
    private byte[] f23008C;
    private CMCEPublicKey PublicKey;

    /* renamed from: alpha */
    private byte[] f23009alpha;

    /* renamed from: delta */
    private byte[] f23010delta;

    /* renamed from: g */
    private byte[] f23011g;

    /* renamed from: s */
    private byte[] f23012s;

    /* renamed from: version */
    private int f23013version;

    public CMCEPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this(i, bArr, bArr2, bArr3, bArr4, bArr5, null);
    }

    public static CMCEPrivateKey getInstance(Object obj) {
        if (obj instanceof CMCEPrivateKey) {
            return (CMCEPrivateKey) obj;
        }
        if (obj != null) {
            return new CMCEPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getAlpha() {
        return C6238Arrays.m18231clone(this.f23009alpha);
    }

    /* renamed from: getC */
    public byte[] m17460getC() {
        return C6238Arrays.m18231clone(this.f23008C);
    }

    public byte[] getDelta() {
        return C6238Arrays.m18231clone(this.f23010delta);
    }

    /* renamed from: getG */
    public byte[] m17461getG() {
        return C6238Arrays.m18231clone(this.f23011g);
    }

    public CMCEPublicKey getPublicKey() {
        return this.PublicKey;
    }

    /* renamed from: getS */
    public byte[] m17462getS() {
        return C6238Arrays.m18231clone(this.f23012s);
    }

    public int getVersion() {
        return this.f23013version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23013version));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23010delta));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23008C));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23011g));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23009alpha));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23012s));
        CMCEPublicKey cMCEPublicKey = this.PublicKey;
        if (cMCEPublicKey != null) {
            aSN1EncodableVector.m14420add(new CMCEPublicKey(cMCEPublicKey.m17463getT()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCEPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, CMCEPublicKey cMCEPublicKey) {
        this.f23013version = i;
        if (i != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23010delta = C6238Arrays.m18231clone(bArr);
        this.f23008C = C6238Arrays.m18231clone(bArr2);
        this.f23011g = C6238Arrays.m18231clone(bArr3);
        this.f23009alpha = C6238Arrays.m18231clone(bArr4);
        this.f23012s = C6238Arrays.m18231clone(bArr5);
        this.PublicKey = cMCEPublicKey;
    }

    private CMCEPrivateKey(ASN1Sequence aSN1Sequence) {
        int iIntValueExact = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23013version = iIntValueExact;
        if (iIntValueExact != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23010delta = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.f23008C = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
        this.f23011g = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3)).getOctets());
        this.f23009alpha = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4)).getOctets());
        this.f23012s = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(5)).getOctets());
        if (aSN1Sequence.mo14450size() == 7) {
            this.PublicKey = CMCEPublicKey.getInstance(aSN1Sequence.getObjectAt(6));
        }
    }
}
