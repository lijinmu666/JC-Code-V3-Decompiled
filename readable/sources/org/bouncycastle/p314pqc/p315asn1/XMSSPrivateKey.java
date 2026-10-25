package org.bouncycastle.p314pqc.p315asn1;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
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
public class XMSSPrivateKey extends ASN1Object {
    private final byte[] bdsState;

    /* renamed from: index */
    private final int f23051index;
    private final int maxIndex;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23052root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* renamed from: version */
    private final int f23053version;

    public XMSSPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f23053version = 0;
        this.f23051index = i;
        this.secretKeySeed = C6238Arrays.m18231clone(bArr);
        this.secretKeyPRF = C6238Arrays.m18231clone(bArr2);
        this.publicSeed = C6238Arrays.m18231clone(bArr3);
        this.f23052root = C6238Arrays.m18231clone(bArr4);
        this.bdsState = C6238Arrays.m18231clone(bArr5);
        this.maxIndex = -1;
    }

    public static XMSSPrivateKey getInstance(Object obj) {
        if (obj instanceof XMSSPrivateKey) {
            return (XMSSPrivateKey) obj;
        }
        if (obj != null) {
            return new XMSSPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getBdsState() {
        return C6238Arrays.m18231clone(this.bdsState);
    }

    public int getIndex() {
        return this.f23051index;
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17478getRoot() {
        return C6238Arrays.m18231clone(this.f23052root);
    }

    public byte[] getSecretKeyPRF() {
        return C6238Arrays.m18231clone(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return C6238Arrays.m18231clone(this.secretKeySeed);
    }

    public int getVersion() {
        return this.f23053version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.maxIndex >= 0 ? ASN1Integer.f17918ONE : ASN1Integer.f17922ZERO);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m14420add(ASN1Integer.m14429valueOf(this.f23051index));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.secretKeySeed));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.secretKeyPRF));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.f23052root));
        int i = this.maxIndex;
        if (i >= 0) {
            aSN1EncodableVector2.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) ASN1Integer.m14429valueOf(i)));
        }
        aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new DEROctetString(this.bdsState)));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSPrivateKey(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i2) {
        this.f23053version = 1;
        this.f23051index = i;
        this.secretKeySeed = C6238Arrays.m18231clone(bArr);
        this.secretKeyPRF = C6238Arrays.m18231clone(bArr2);
        this.publicSeed = C6238Arrays.m18231clone(bArr3);
        this.f23052root = C6238Arrays.m18231clone(bArr4);
        this.bdsState = C6238Arrays.m18231clone(bArr5);
        this.maxIndex = i2;
    }

    private XMSSPrivateKey(ASN1Sequence aSN1Sequence) {
        int iIntValueExact;
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (!aSN1Integer.hasValue(0) && !aSN1Integer.hasValue(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f23053version = aSN1Integer.intValueExact();
        if (aSN1Sequence.mo14450size() != 2 && aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        this.f23051index = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).intValueExact();
        this.secretKeySeed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets());
        this.secretKeyPRF = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(2)).getOctets());
        this.publicSeed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(3)).getOctets());
        this.f23052root = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(4)).getOctets());
        if (aSN1Sequence2.mo14450size() == 6) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence2.getObjectAt(5));
            if (aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            iIntValueExact = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact();
        } else {
            if (aSN1Sequence2.mo14450size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            iIntValueExact = -1;
        }
        this.maxIndex = iIntValueExact;
        if (aSN1Sequence.mo14450size() == 3) {
            this.bdsState = C6238Arrays.m18231clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)), true).getOctets());
        } else {
            this.bdsState = null;
        }
    }
}
