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
public class FalconPrivateKey extends ASN1Object {

    /* renamed from: F */
    private byte[] f23015F;

    /* renamed from: f */
    private byte[] f23016f;

    /* renamed from: g */
    private byte[] f23017g;
    private FalconPublicKey publicKey;

    /* renamed from: version */
    private int f23018version;

    public FalconPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this(i, bArr, bArr2, bArr3, null);
    }

    public static FalconPrivateKey getInstance(Object obj) {
        if (obj instanceof FalconPrivateKey) {
            return (FalconPrivateKey) obj;
        }
        if (obj != null) {
            return new FalconPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getF */
    public byte[] m17464getF() {
        return C6238Arrays.m18231clone(this.f23015F);
    }

    /* renamed from: getG */
    public byte[] m17465getG() {
        return C6238Arrays.m18231clone(this.f23017g);
    }

    public FalconPublicKey getPublicKey() {
        return this.publicKey;
    }

    public int getVersion() {
        return this.f23018version;
    }

    /* renamed from: getf */
    public byte[] m17466getf() {
        return C6238Arrays.m18231clone(this.f23016f);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23018version));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23016f));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23017g));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23015F));
        FalconPublicKey falconPublicKey = this.publicKey;
        if (falconPublicKey != null) {
            aSN1EncodableVector.m14420add(new FalconPublicKey(falconPublicKey.m17467getH()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public FalconPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, FalconPublicKey falconPublicKey) {
        this.f23018version = i;
        this.f23016f = bArr;
        this.f23017g = bArr2;
        this.f23015F = bArr3;
        this.publicKey = falconPublicKey;
    }

    private FalconPrivateKey(ASN1Sequence aSN1Sequence) {
        int iIntValueExact = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23018version = iIntValueExact;
        if (iIntValueExact != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23016f = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.f23017g = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
        this.f23015F = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3)).getOctets());
        if (aSN1Sequence.mo14450size() == 5) {
            this.publicKey = FalconPublicKey.getInstance(aSN1Sequence.getObjectAt(4));
        }
    }
}
