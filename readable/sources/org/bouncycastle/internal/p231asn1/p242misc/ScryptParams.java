package org.bouncycastle.internal.p231asn1.p242misc;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ScryptParams extends ASN1Object {
    private final BigInteger blockSize;
    private final BigInteger costParameter;
    private final BigInteger keyLength;
    private final BigInteger parallelizationParameter;

    /* renamed from: salt */
    private final byte[] f21271salt;

    private ScryptParams(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4 && aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("invalid sequence: size = " + aSN1Sequence.mo14450size());
        }
        this.f21271salt = C6238Arrays.m18231clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
        this.costParameter = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
        this.blockSize = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue();
        this.parallelizationParameter = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(3)).getValue();
        this.keyLength = aSN1Sequence.mo14450size() == 5 ? ASN1Integer.getInstance(aSN1Sequence.getObjectAt(4)).getValue() : null;
    }

    public static ScryptParams getInstance(Object obj) {
        if (obj instanceof ScryptParams) {
            return (ScryptParams) obj;
        }
        if (obj != null) {
            return new ScryptParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getBlockSize() {
        return this.blockSize;
    }

    public BigInteger getCostParameter() {
        return this.costParameter;
    }

    public BigInteger getKeyLength() {
        return this.keyLength;
    }

    public BigInteger getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    /* renamed from: getSalt */
    public byte[] m15989getSalt() {
        return C6238Arrays.m18231clone(this.f21271salt);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(new DEROctetString(this.f21271salt));
        aSN1EncodableVector.m14420add(new ASN1Integer(this.costParameter));
        aSN1EncodableVector.m14420add(new ASN1Integer(this.blockSize));
        aSN1EncodableVector.m14420add(new ASN1Integer(this.parallelizationParameter));
        if (this.keyLength != null) {
            aSN1EncodableVector.m14420add(new ASN1Integer(this.keyLength));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ScryptParams(byte[] bArr, int i, int i2, int i3) {
        this(bArr, BigInteger.valueOf(i), BigInteger.valueOf(i2), BigInteger.valueOf(i3), (BigInteger) null);
    }

    public ScryptParams(byte[] bArr, int i, int i2, int i3, int i4) {
        this(bArr, BigInteger.valueOf(i), BigInteger.valueOf(i2), BigInteger.valueOf(i3), BigInteger.valueOf(i4));
    }

    public ScryptParams(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f21271salt = C6238Arrays.m18231clone(bArr);
        this.costParameter = bigInteger;
        this.blockSize = bigInteger2;
        this.parallelizationParameter = bigInteger3;
        this.keyLength = bigInteger4;
    }
}
