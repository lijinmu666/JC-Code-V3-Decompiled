package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class EncryptedValue extends ASN1Object {
    private ASN1BitString encSymmKey;
    private ASN1BitString encValue;
    private AlgorithmIdentifier intendedAlg;

    /* renamed from: keyAlg */
    private AlgorithmIdentifier f18259keyAlg;

    /* renamed from: symmAlg */
    private AlgorithmIdentifier f18260symmAlg;
    private ASN1OctetString valueHint;

    private EncryptedValue(ASN1Sequence aSN1Sequence) {
        int i = 0;
        while (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.intendedAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.f18260symmAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 2) {
                this.encSymmKey = ASN1BitString.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 3) {
                this.f18259keyAlg = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else {
                if (tagNo != 4) {
                    throw new IllegalArgumentException("Unknown tag encountered: " + aSN1TaggedObject.getTagNo());
                }
                this.valueHint = ASN1OctetString.getInstance(aSN1TaggedObject, false);
            }
            i++;
        }
        this.encValue = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(i));
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, i, aSN1Encodable));
        }
    }

    public static EncryptedValue getInstance(Object obj) {
        if (obj instanceof EncryptedValue) {
            return (EncryptedValue) obj;
        }
        if (obj != null) {
            return new EncryptedValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1BitString getEncSymmKey() {
        return this.encSymmKey;
    }

    public ASN1BitString getEncValue() {
        return this.encValue;
    }

    public AlgorithmIdentifier getIntendedAlg() {
        return this.intendedAlg;
    }

    public AlgorithmIdentifier getKeyAlg() {
        return this.f18259keyAlg;
    }

    public AlgorithmIdentifier getSymmAlg() {
        return this.f18260symmAlg;
    }

    public ASN1OctetString getValueHint() {
        return this.valueHint;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        addOptional(aSN1EncodableVector, 0, this.intendedAlg);
        addOptional(aSN1EncodableVector, 1, this.f18260symmAlg);
        addOptional(aSN1EncodableVector, 2, this.encSymmKey);
        addOptional(aSN1EncodableVector, 3, this.f18259keyAlg);
        addOptional(aSN1EncodableVector, 4, this.valueHint);
        aSN1EncodableVector.m14420add(this.encValue);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedValue(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ASN1BitString aSN1BitString, AlgorithmIdentifier algorithmIdentifier3, ASN1OctetString aSN1OctetString, ASN1BitString aSN1BitString2) {
        if (aSN1BitString2 == null) {
            throw new IllegalArgumentException("'encValue' cannot be null");
        }
        this.intendedAlg = algorithmIdentifier;
        this.f18260symmAlg = algorithmIdentifier2;
        this.encSymmKey = aSN1BitString;
        this.f18259keyAlg = algorithmIdentifier3;
        this.valueHint = aSN1OctetString;
        this.encValue = aSN1BitString2;
    }
}
