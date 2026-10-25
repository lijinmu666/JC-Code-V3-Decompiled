package org.bouncycastle.p133asn1.p167sec;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1BitString;
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
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECPrivateKey extends ASN1Object {

    /* renamed from: seq */
    private final ASN1Sequence f18530seq;

    public ECPrivateKey(int i, BigInteger bigInteger) {
        this.f18530seq = new DERSequence(ASN1Integer.f17918ONE, new DEROctetString(BigIntegers.asUnsignedByteArray((i + 7) / 8, bigInteger)));
    }

    public static ECPrivateKey getInstance(Object obj) {
        if (obj instanceof ECPrivateKey) {
            return (ECPrivateKey) obj;
        }
        if (obj != null) {
            return new ECPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private ASN1Object getObjectInTag(int i, int i2) {
        int iMo14450size = this.f18530seq.mo14450size();
        for (int i3 = 0; i3 < iMo14450size; i3++) {
            ASN1TaggedObject contextOptional = ASN1TaggedObject.getContextOptional(this.f18530seq.getObjectAt(i3), i);
            if (contextOptional != null) {
                return i2 < 0 ? contextOptional.getExplicitBaseObject().toASN1Primitive() : contextOptional.getBaseUniversal(true, i2);
            }
        }
        return null;
    }

    public static ECPrivateKey getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new ECPrivateKey(ASN1Sequence.getTagged(aSN1TaggedObject, z));
    }

    /* renamed from: getKey */
    public BigInteger m14639getKey() {
        return new BigInteger(1, getPrivateKey().getOctets());
    }

    public ASN1Object getParametersObject() {
        return getObjectInTag(0, -1);
    }

    public ASN1OctetString getPrivateKey() {
        return (ASN1OctetString) this.f18530seq.getObjectAt(1);
    }

    public ASN1BitString getPublicKey() {
        return (ASN1BitString) getObjectInTag(1, 3);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18530seq;
    }

    public ECPrivateKey(int i, BigInteger bigInteger, ASN1BitString aSN1BitString, ASN1Encodable aSN1Encodable) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray((i + 7) / 8, bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(ASN1Integer.f17918ONE);
        aSN1EncodableVector.m14420add(new DEROctetString(bArrAsUnsignedByteArray));
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, aSN1Encodable));
        }
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1BitString));
        }
        this.f18530seq = new DERSequence(aSN1EncodableVector);
    }

    public static ECPrivateKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new ECPrivateKey(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ECPrivateKey(int i, BigInteger bigInteger, ASN1Encodable aSN1Encodable) {
        this(i, bigInteger, null, aSN1Encodable);
    }

    public ECPrivateKey(ASN1OctetString aSN1OctetString, ASN1Encodable aSN1Encodable, ASN1BitString aSN1BitString) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(ASN1Integer.f17918ONE);
        aSN1EncodableVector.m14420add(aSN1OctetString);
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, aSN1Encodable));
        }
        if (aSN1BitString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1BitString));
        }
        this.f18530seq = new DERSequence(aSN1EncodableVector);
    }

    private ECPrivateKey(ASN1Sequence aSN1Sequence) {
        this.f18530seq = aSN1Sequence;
    }
}
