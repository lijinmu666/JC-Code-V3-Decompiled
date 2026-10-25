package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class PBEParameter extends ASN1Object {
    ASN1Integer iterations;

    /* renamed from: salt */
    ASN1OctetString f18482salt;

    private PBEParameter(ASN1Sequence aSN1Sequence) {
        this.f18482salt = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.iterations = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }

    public static PBEParameter getInstance(Object obj) {
        if (obj instanceof PBEParameter) {
            return (PBEParameter) obj;
        }
        if (obj != null) {
            return new PBEParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.iterations.getValue();
    }

    /* renamed from: getSalt */
    public byte[] m14633getSalt() {
        return this.f18482salt.getOctets();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18482salt, this.iterations);
    }

    public PBEParameter(byte[] bArr, int i) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException("salt length must be 8");
        }
        this.f18482salt = new DEROctetString(bArr);
        this.iterations = ASN1Integer.m14429valueOf(i);
    }
}
