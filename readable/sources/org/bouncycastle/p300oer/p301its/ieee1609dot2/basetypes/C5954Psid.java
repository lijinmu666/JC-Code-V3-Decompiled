package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.Psid */
/* loaded from: classes2.dex */
public class C5954Psid extends ASN1Object {

    /* renamed from: psid */
    private final BigInteger f22748psid;

    public C5954Psid(long j) {
        this(BigInteger.valueOf(j));
    }

    public static C5954Psid getInstance(Object obj) {
        if (obj instanceof C5954Psid) {
            return (C5954Psid) obj;
        }
        if (obj != null) {
            return new C5954Psid(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    /* renamed from: getPsid */
    public BigInteger m17309getPsid() {
        return this.f22748psid;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22748psid);
    }

    public C5954Psid(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalStateException("psid must be greater than zero");
        }
        this.f22748psid = bigInteger;
    }
}
