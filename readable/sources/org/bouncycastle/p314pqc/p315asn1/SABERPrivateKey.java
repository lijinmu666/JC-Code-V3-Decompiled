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
public class SABERPrivateKey extends ASN1Object {
    private SABERPublicKey PublicKey;

    /* renamed from: hpk */
    private byte[] f23030hpk;

    /* renamed from: s */
    private byte[] f23031s;

    /* renamed from: version */
    private int f23032version;

    /* renamed from: z */
    private byte[] f23033z;

    public SABERPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f23032version = i;
        if (i != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23033z = bArr;
        this.f23031s = bArr2;
        this.f23030hpk = bArr3;
    }

    public static SABERPrivateKey getInstance(Object obj) {
        if (obj instanceof SABERPrivateKey) {
            return (SABERPrivateKey) obj;
        }
        if (obj != null) {
            return new SABERPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getHpk */
    public byte[] m17472getHpk() {
        return this.f23030hpk;
    }

    public SABERPublicKey getPublicKey() {
        return this.PublicKey;
    }

    /* renamed from: getS */
    public byte[] m17473getS() {
        return this.f23031s;
    }

    public int getVersion() {
        return this.f23032version;
    }

    /* renamed from: getZ */
    public byte[] m17474getZ() {
        return this.f23033z;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f23032version));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23033z));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23031s));
        aSN1EncodableVector.m14420add(new DEROctetString(this.f23030hpk));
        return new DERSequence(aSN1EncodableVector);
    }

    public SABERPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, SABERPublicKey sABERPublicKey) {
        this.f23032version = i;
        if (i != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23033z = bArr;
        this.f23031s = bArr2;
        this.f23030hpk = bArr3;
        this.PublicKey = sABERPublicKey;
    }

    private SABERPrivateKey(ASN1Sequence aSN1Sequence) {
        int iIntValueExact = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f23032version = iIntValueExact;
        if (iIntValueExact != 0) {
            throw new IllegalArgumentException("unrecognized version");
        }
        this.f23033z = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.f23031s = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
        this.PublicKey = SABERPublicKey.getInstance(aSN1Sequence.getObjectAt(3));
        this.f23030hpk = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(4)).getOctets());
    }
}
