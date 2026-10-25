package org.bouncycastle.p300oer.p301its.etsi103097.extension;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* renamed from: org.bouncycastle.oer.its.etsi103097.extension.ExtId */
/* loaded from: classes2.dex */
public class C5920ExtId extends ASN1Object {

    /* renamed from: MAX */
    private static final BigInteger f22621MAX = BigInteger.valueOf(255);

    /* renamed from: extId */
    private final BigInteger f22622extId;

    public C5920ExtId(long j) {
        this(BigInteger.valueOf(j));
    }

    public static C5920ExtId getInstance(Object obj) {
        if (obj instanceof C5920ExtId) {
            return (C5920ExtId) obj;
        }
        if (obj != null) {
            return new C5920ExtId(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getExtId() {
        return this.f22622extId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22622extId);
    }

    public C5920ExtId(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.compareTo(f22621MAX) <= 0) {
            this.f22622extId = bigInteger;
            return;
        }
        throw new IllegalArgumentException("value " + bigInteger + " outside of range 0...255");
    }

    private C5920ExtId(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }

    public C5920ExtId(byte[] bArr) {
        this(new BigInteger(bArr));
    }
}
