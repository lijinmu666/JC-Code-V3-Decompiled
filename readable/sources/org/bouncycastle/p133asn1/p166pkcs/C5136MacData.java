package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.asn1.pkcs.MacData */
/* loaded from: classes2.dex */
public class C5136MacData extends ASN1Object {

    /* renamed from: ONE */
    private static final BigInteger f18479ONE = BigInteger.valueOf(1);

    /* renamed from: digInfo */
    DigestInfo f18480digInfo;
    BigInteger iterationCount;

    /* renamed from: salt */
    byte[] f18481salt;

    private C5136MacData(ASN1Sequence aSN1Sequence) {
        this.f18480digInfo = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18481salt = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        this.iterationCount = aSN1Sequence.mo14450size() == 3 ? ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue() : f18479ONE;
    }

    public static C5136MacData getInstance(Object obj) {
        if (obj instanceof C5136MacData) {
            return (C5136MacData) obj;
        }
        if (obj != null) {
            return new C5136MacData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount;
    }

    /* renamed from: getMac */
    public DigestInfo m14631getMac() {
        return this.f18480digInfo;
    }

    /* renamed from: getSalt */
    public byte[] m14632getSalt() {
        return C6238Arrays.m18231clone(this.f18481salt);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18480digInfo);
        aSN1EncodableVector.m14420add(new DEROctetString(this.f18481salt));
        if (!this.iterationCount.equals(f18479ONE)) {
            aSN1EncodableVector.m14420add(new ASN1Integer(this.iterationCount));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public C5136MacData(DigestInfo digestInfo, byte[] bArr, int i) {
        this.f18480digInfo = digestInfo;
        this.f18481salt = C6238Arrays.m18231clone(bArr);
        this.iterationCount = BigInteger.valueOf(i);
    }
}
