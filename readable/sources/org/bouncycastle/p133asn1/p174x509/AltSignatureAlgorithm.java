package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;

/* loaded from: classes2.dex */
public class AltSignatureAlgorithm extends ASN1Object {
    private final AlgorithmIdentifier algorithm;

    public AltSignatureAlgorithm(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, null);
    }

    public static AltSignatureAlgorithm fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.altSignatureAlgorithm));
    }

    public static AltSignatureAlgorithm getInstance(Object obj) {
        if (obj instanceof AltSignatureAlgorithm) {
            return (AltSignatureAlgorithm) obj;
        }
        if (obj != null) {
            return new AltSignatureAlgorithm(AlgorithmIdentifier.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algorithm;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.algorithm.toASN1Primitive();
    }

    public AltSignatureAlgorithm(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.algorithm = new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public static AltSignatureAlgorithm getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(AlgorithmIdentifier.getInstance(aSN1TaggedObject, z));
    }

    public AltSignatureAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.algorithm = algorithmIdentifier;
    }
}
