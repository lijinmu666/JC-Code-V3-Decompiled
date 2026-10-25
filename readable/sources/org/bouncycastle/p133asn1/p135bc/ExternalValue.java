package org.bouncycastle.p133asn1.p135bc;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class ExternalValue extends ASN1Object {

    /* renamed from: hashAlg */
    private final AlgorithmIdentifier f18042hashAlg;
    private final byte[] hashValue;
    private final GeneralNames location;

    private ExternalValue(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("unknown sequence");
        }
        this.location = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18042hashAlg = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        boolean z = aSN1Sequence.getObjectAt(2) instanceof ASN1BitString;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(2);
        if (z) {
            this.hashValue = ASN1BitString.getInstance(objectAt).getOctets();
        } else {
            this.hashValue = ASN1OctetString.getInstance(objectAt).getOctets();
        }
    }

    public static ExternalValue getInstance(Object obj) {
        if (obj instanceof ExternalValue) {
            return (ExternalValue) obj;
        }
        if (obj != null) {
            return new ExternalValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.f18042hashAlg;
    }

    public ASN1BitString getHashVal() {
        return new DERBitString(this.hashValue);
    }

    public byte[] getHashValue() {
        return C6238Arrays.m18231clone(this.hashValue);
    }

    public GeneralName getLocation() {
        return this.location.getNames()[0];
    }

    public GeneralName[] getLocations() {
        return this.location.getNames();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(this.location);
        aSN1EncodableVector.m14420add(this.f18042hashAlg);
        aSN1EncodableVector.m14420add(new DEROctetString(this.hashValue));
        return new DERSequence(aSN1EncodableVector);
    }

    public ExternalValue(GeneralName generalName, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.location = new GeneralNames(generalName);
        this.f18042hashAlg = algorithmIdentifier;
        this.hashValue = C6238Arrays.m18231clone(bArr);
    }
}
