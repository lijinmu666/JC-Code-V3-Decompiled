package org.bouncycastle.p300oer.p301its.etsi102941.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* renamed from: org.bouncycastle.oer.its.etsi102941.basetypes.Version */
/* loaded from: classes2.dex */
public class C5916Version extends ASN1Object {

    /* renamed from: version */
    private final BigInteger f22619version;

    public C5916Version(int i) {
        this(BigInteger.valueOf(i));
    }

    public static C5916Version getInstance(Object obj) {
        if (obj instanceof C5976UINT8) {
            return (C5916Version) obj;
        }
        if (obj != null) {
            return new C5916Version(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getVersion() {
        return this.f22619version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22619version);
    }

    public C5916Version(long j) {
        this(BigInteger.valueOf(j));
    }

    public C5916Version(BigInteger bigInteger) {
        this.f22619version = bigInteger;
    }

    public C5916Version(ASN1Integer aSN1Integer) {
        this.f22619version = aSN1Integer.getValue();
    }
}
