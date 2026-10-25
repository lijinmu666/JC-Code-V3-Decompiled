package org.bouncycastle.p133asn1.cryptopro;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GostR3410TransportParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final SubjectPublicKeyInfo ephemeralPublicKey;

    /* renamed from: ukm */
    private final byte[] f18296ukm;

    public GostR3410TransportParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SubjectPublicKeyInfo subjectPublicKeyInfo, byte[] bArr) {
        this.encryptionParamSet = aSN1ObjectIdentifier;
        this.ephemeralPublicKey = subjectPublicKeyInfo;
        this.f18296ukm = C6238Arrays.m18231clone(bArr);
    }

    public static GostR3410TransportParameters getInstance(Object obj) {
        if (obj instanceof GostR3410TransportParameters) {
            return (GostR3410TransportParameters) obj;
        }
        if (obj != null) {
            return new GostR3410TransportParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public SubjectPublicKeyInfo getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    /* renamed from: getUkm */
    public byte[] m14581getUkm() {
        return C6238Arrays.m18231clone(this.f18296ukm);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.encryptionParamSet);
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.ephemeralPublicKey;
        if (subjectPublicKeyInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) subjectPublicKeyInfo));
        }
        aSN1EncodableVector.m14420add(new DEROctetString(this.f18296ukm));
        return new DERSequence(aSN1EncodableVector);
    }

    private GostR3410TransportParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 2) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.f18296ukm = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            this.ephemeralPublicKey = null;
        } else if (aSN1Sequence.mo14450size() == 3) {
            this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.ephemeralPublicKey = SubjectPublicKeyInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)), false);
            this.f18296ukm = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets();
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + aSN1Sequence.mo14450size());
        }
    }

    public static GostR3410TransportParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
