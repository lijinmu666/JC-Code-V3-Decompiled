package org.bouncycastle.p133asn1.cryptopro;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Gost2814789EncryptedKey extends ASN1Object {
    private final byte[] encryptedKey;

    /* renamed from: macKey */
    private final byte[] f18293macKey;

    /* renamed from: maskKey */
    private final byte[] f18294maskKey;

    private Gost2814789EncryptedKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 2) {
            this.encryptedKey = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
            this.f18293macKey = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            this.f18294maskKey = null;
        } else if (aSN1Sequence.mo14450size() == 3) {
            this.encryptedKey = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
            this.f18294maskKey = C6238Arrays.m18231clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)), false).getOctets());
            this.f18293macKey = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + aSN1Sequence.mo14450size());
        }
    }

    public static Gost2814789EncryptedKey getInstance(Object obj) {
        if (obj instanceof Gost2814789EncryptedKey) {
            return (Gost2814789EncryptedKey) obj;
        }
        if (obj != null) {
            return new Gost2814789EncryptedKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getEncryptedKey() {
        return C6238Arrays.m18231clone(this.encryptedKey);
    }

    public byte[] getMacKey() {
        return C6238Arrays.m18231clone(this.f18293macKey);
    }

    public byte[] getMaskKey() {
        return C6238Arrays.m18231clone(this.f18294maskKey);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(new DEROctetString(this.encryptedKey));
        if (this.f18294maskKey != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(this.encryptedKey)));
        }
        aSN1EncodableVector.m14420add(new DEROctetString(this.f18293macKey));
        return new DERSequence(aSN1EncodableVector);
    }

    public Gost2814789EncryptedKey(byte[] bArr, byte[] bArr2) {
        this(bArr, null, bArr2);
    }

    public Gost2814789EncryptedKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.encryptedKey = C6238Arrays.m18231clone(bArr);
        this.f18294maskKey = C6238Arrays.m18231clone(bArr2);
        this.f18293macKey = C6238Arrays.m18231clone(bArr3);
    }
}
