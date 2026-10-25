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
public class PKCS12PBEParams extends ASN1Object {
    ASN1Integer iterations;

    /* renamed from: iv */
    ASN1OctetString f18489iv;

    private PKCS12PBEParams(ASN1Sequence aSN1Sequence) {
        this.f18489iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.iterations = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PKCS12PBEParams getInstance(Object obj) {
        if (obj instanceof PKCS12PBEParams) {
            return (PKCS12PBEParams) obj;
        }
        if (obj != null) {
            return new PKCS12PBEParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getIV */
    public byte[] m14636getIV() {
        return this.f18489iv.getOctets();
    }

    public BigInteger getIterations() {
        return this.iterations.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18489iv, this.iterations);
    }

    public PKCS12PBEParams(byte[] bArr, int i) {
        this.f18489iv = new DEROctetString(bArr);
        this.iterations = ASN1Integer.m14429valueOf(i);
    }
}
