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
public class XMSSMTPrivateKey extends ASN1Object {
    private final byte[] bdsState;

    /* renamed from: index */
    private final long f23047index;
    private final long maxIndex;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23048root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* renamed from: version */
    private final int f23049version;

    public XMSSMTPrivateKey(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f23049version = 0;
        this.f23047index = j;
        this.secretKeySeed = C6238Arrays.m18231clone(bArr);
        this.secretKeyPRF = C6238Arrays.m18231clone(bArr2);
        this.publicSeed = C6238Arrays.m18231clone(bArr3);
        this.f23048root = C6238Arrays.m18231clone(bArr4);
        this.bdsState = C6238Arrays.m18231clone(bArr5);
        this.maxIndex = -1L;
    }

    public static XMSSMTPrivateKey getInstance(Object obj) {
        if (obj instanceof XMSSMTPrivateKey) {
            return (XMSSMTPrivateKey) obj;
        }
        if (obj != null) {
            return new XMSSMTPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getBdsState() {
        return C6238Arrays.m18231clone(this.bdsState);
    }

    public long getIndex() {
        return this.f23047index;
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17476getRoot() {
        return C6238Arrays.m18231clone(this.f23048root);
    }

    public byte[] getSecretKeyPRF() {
        return C6238Arrays.m18231clone(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return C6238Arrays.m18231clone(this.secretKeySeed);
    }

    public int getVersion() {
        return this.f23049version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(this.maxIndex >= 0 ? ASN1Integer.f17918ONE : ASN1Integer.f17922ZERO);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m14420add(ASN1Integer.m14430valueOf(this.f23047index));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.secretKeySeed));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.secretKeyPRF));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector2.m14420add(new DEROctetString(this.f23048root));
        long j = this.maxIndex;
        if (j >= 0) {
            aSN1EncodableVector2.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) ASN1Integer.m14430valueOf(j)));
        }
        aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new DEROctetString(this.bdsState)));
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSMTPrivateKey(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j2) {
        this.f23049version = 1;
        this.f23047index = j;
        this.secretKeySeed = C6238Arrays.m18231clone(bArr);
        this.secretKeyPRF = C6238Arrays.m18231clone(bArr2);
        this.publicSeed = C6238Arrays.m18231clone(bArr3);
        this.f23048root = C6238Arrays.m18231clone(bArr4);
        this.bdsState = C6238Arrays.m18231clone(bArr5);
        this.maxIndex = j2;
    }

    private XMSSMTPrivateKey(ASN1Sequence aSN1Sequence) {
        long jLongValueExact;
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (!aSN1Integer.hasValue(0) && !aSN1Integer.hasValue(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f23049version = aSN1Integer.intValueExact();
        if (aSN1Sequence.mo14450size() != 2 && aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        this.f23047index = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).longValueExact();
        this.secretKeySeed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets());
        this.secretKeyPRF = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(2)).getOctets());
        this.publicSeed = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(3)).getOctets());
        this.f23048root = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(4)).getOctets());
        if (aSN1Sequence2.mo14450size() == 6) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence2.getObjectAt(5));
            if (aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            jLongValueExact = ASN1Integer.getInstance(aSN1TaggedObject, false).longValueExact();
        } else {
            if (aSN1Sequence2.mo14450size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            jLongValueExact = -1;
        }
        this.maxIndex = jLongValueExact;
        if (aSN1Sequence.mo14450size() == 3) {
            this.bdsState = C6238Arrays.m18231clone(ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)), true).getOctets());
        } else {
            this.bdsState = null;
        }
    }
}
