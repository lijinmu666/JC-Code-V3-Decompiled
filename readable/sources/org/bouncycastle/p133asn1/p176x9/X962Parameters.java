package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;

/* loaded from: classes2.dex */
public class X962Parameters extends ASN1Object implements ASN1Choice {

    /* renamed from: params */
    private ASN1Primitive f18772params;

    public X962Parameters(ASN1Null aSN1Null) {
        this.f18772params = aSN1Null;
    }

    public static X962Parameters getInstance(Object obj) {
        if (obj == null || (obj instanceof X962Parameters)) {
            return (X962Parameters) obj;
        }
        if (obj instanceof ASN1Primitive) {
            return new X962Parameters((ASN1Primitive) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
        try {
            return new X962Parameters(ASN1Primitive.fromByteArray((byte[]) obj));
        } catch (Exception e) {
            throw new IllegalArgumentException("unable to parse encoded data: " + e.getMessage());
        }
    }

    public ASN1Primitive getParameters() {
        return this.f18772params;
    }

    public boolean isImplicitlyCA() {
        return this.f18772params instanceof ASN1Null;
    }

    public boolean isNamedCurve() {
        return this.f18772params instanceof ASN1ObjectIdentifier;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18772params;
    }

    public X962Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f18772params = aSN1ObjectIdentifier;
    }

    public static X962Parameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    private X962Parameters(ASN1Primitive aSN1Primitive) {
        this.f18772params = aSN1Primitive;
    }

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.f18772params = null;
        this.f18772params = x9ECParameters.toASN1Primitive();
    }
}
