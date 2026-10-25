package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class KeyDerivationFunc extends ASN1Object {

    /* renamed from: algId */
    private AlgorithmIdentifier f18478algId;

    public KeyDerivationFunc(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18478algId = new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public static KeyDerivationFunc getInstance(Object obj) {
        if (obj instanceof KeyDerivationFunc) {
            return (KeyDerivationFunc) obj;
        }
        if (obj != null) {
            return new KeyDerivationFunc(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.f18478algId.getAlgorithm();
    }

    public ASN1Encodable getParameters() {
        return this.f18478algId.getParameters();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18478algId.toASN1Primitive();
    }

    private KeyDerivationFunc(ASN1Sequence aSN1Sequence) {
        this.f18478algId = AlgorithmIdentifier.getInstance(aSN1Sequence);
    }
}
