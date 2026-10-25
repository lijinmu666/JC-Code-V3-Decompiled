package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DigestInfo extends ASN1Object {

    /* renamed from: algId */
    private AlgorithmIdentifier f18645algId;

    /* renamed from: digest */
    private byte[] f18646digest;

    public DigestInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18645algId = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.f18646digest = ASN1OctetString.getInstance(objects.nextElement()).getOctets();
    }

    public static DigestInfo getInstance(Object obj) {
        if (obj instanceof DigestInfo) {
            return (DigestInfo) obj;
        }
        if (obj != null) {
            return new DigestInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.f18645algId;
    }

    public byte[] getDigest() {
        return C6238Arrays.m18231clone(this.f18646digest);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18645algId, new DEROctetString(this.f18646digest));
    }

    public DigestInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f18646digest = C6238Arrays.m18231clone(bArr);
        this.f18645algId = algorithmIdentifier;
    }

    public static DigestInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
