package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class RC2CBCParameter extends ASN1Object {

    /* renamed from: iv */
    ASN1OctetString f18514iv;

    /* renamed from: version */
    ASN1Integer f18515version;

    public RC2CBCParameter(int i, byte[] bArr) {
        this.f18515version = ASN1Integer.m14429valueOf(i);
        this.f18514iv = new DEROctetString(bArr);
    }

    public static RC2CBCParameter getInstance(Object obj) {
        if (obj instanceof RC2CBCParameter) {
            return (RC2CBCParameter) obj;
        }
        if (obj != null) {
            return new RC2CBCParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getIV */
    public byte[] m14637getIV() {
        return this.f18514iv.getOctets();
    }

    public BigInteger getRC2ParameterVersion() {
        ASN1Integer aSN1Integer = this.f18515version;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public ASN1Integer getRC2ParameterVersionData() {
        return this.f18515version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1Integer aSN1Integer = this.f18515version;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        aSN1EncodableVector.m14420add(this.f18514iv);
        return new DERSequence(aSN1EncodableVector);
    }

    private RC2CBCParameter(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        if (aSN1Sequence.mo14450size() == 1) {
            this.f18515version = null;
            objectAt = aSN1Sequence.getObjectAt(0);
        } else {
            this.f18515version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
            objectAt = aSN1Sequence.getObjectAt(1);
        }
        this.f18514iv = (ASN1OctetString) objectAt;
    }

    public RC2CBCParameter(byte[] bArr) {
        this.f18515version = null;
        this.f18514iv = new DEROctetString(bArr);
    }
}
