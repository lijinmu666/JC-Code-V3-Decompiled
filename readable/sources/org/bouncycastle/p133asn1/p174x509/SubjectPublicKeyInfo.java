package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class SubjectPublicKeyInfo extends ASN1Object {

    /* renamed from: algId */
    private AlgorithmIdentifier f18681algId;

    /* renamed from: keyData */
    private ASN1BitString f18682keyData;

    @Deprecated
    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f18681algId = AlgorithmIdentifier.getInstance(objects.nextElement());
            this.f18682keyData = ASN1BitString.getInstance(objects.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
    }

    public static SubjectPublicKeyInfo getInstance(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.f18681algId;
    }

    @Deprecated
    public AlgorithmIdentifier getAlgorithmId() {
        return this.f18681algId;
    }

    @Deprecated
    public ASN1Primitive getPublicKey() {
        return ASN1Primitive.fromByteArray(this.f18682keyData.getOctets());
    }

    public ASN1BitString getPublicKeyData() {
        return this.f18682keyData;
    }

    public ASN1Primitive parsePublicKey() {
        return ASN1Primitive.fromByteArray(this.f18682keyData.getOctets());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18681algId, this.f18682keyData);
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        this.f18682keyData = aSN1BitString;
        this.f18681algId = algorithmIdentifier;
    }

    public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18682keyData = new DERBitString(aSN1Encodable);
        this.f18681algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f18682keyData = new DERBitString(bArr);
        this.f18681algId = algorithmIdentifier;
    }
}
