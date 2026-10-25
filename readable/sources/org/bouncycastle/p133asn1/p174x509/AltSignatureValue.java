package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERBitString;

/* loaded from: classes2.dex */
public class AltSignatureValue extends ASN1Object {
    private final ASN1BitString signature;

    private AltSignatureValue(ASN1BitString aSN1BitString) {
        this.signature = aSN1BitString;
    }

    public static AltSignatureValue fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.altSignatureValue));
    }

    public static AltSignatureValue getInstance(Object obj) {
        if (obj instanceof AltSignatureValue) {
            return (AltSignatureValue) obj;
        }
        if (obj != null) {
            return new AltSignatureValue(ASN1BitString.getInstance(obj));
        }
        return null;
    }

    public ASN1BitString getSignature() {
        return this.signature;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.signature;
    }

    public AltSignatureValue(byte[] bArr) {
        this.signature = new DERBitString(bArr);
    }

    public static AltSignatureValue getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1BitString.getInstance(aSN1TaggedObject, z));
    }
}
