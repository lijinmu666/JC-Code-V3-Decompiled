package org.bouncycastle.p133asn1.p147est;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.Attribute;

/* loaded from: classes2.dex */
public class AttrOrOID extends ASN1Object implements ASN1Choice {
    private final Attribute attribute;

    /* renamed from: oid */
    private final ASN1ObjectIdentifier f18379oid;

    public AttrOrOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f18379oid = aSN1ObjectIdentifier;
        this.attribute = null;
    }

    public static AttrOrOID getInstance(Object obj) {
        if (obj instanceof AttrOrOID) {
            return (AttrOrOID) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return new AttrOrOID(ASN1ObjectIdentifier.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new AttrOrOID(Attribute.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    /* renamed from: getOid */
    public ASN1ObjectIdentifier m14607getOid() {
        return this.f18379oid;
    }

    /* renamed from: isOid */
    public boolean m14608isOid() {
        return this.f18379oid != null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.f18379oid;
        return aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier : this.attribute.toASN1Primitive();
    }

    public AttrOrOID(Attribute attribute) {
        this.f18379oid = null;
        this.attribute = attribute;
    }
}
