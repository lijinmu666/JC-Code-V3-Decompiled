package org.bouncycastle.p133asn1.p137cmc;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes.dex */
public class BodyPartID extends ASN1Object {
    public static final long bodyIdMax = 4294967295L;

    /* renamed from: id */
    private final long f18055id;

    public BodyPartID(long j) {
        if (j < 0 || j > bodyIdMax) {
            throw new IllegalArgumentException("id out of range");
        }
        this.f18055id = j;
    }

    /* renamed from: convert */
    private static long m14487convert(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 32) {
            return bigInteger.longValue();
        }
        throw new IllegalArgumentException("id out of range");
    }

    public static BodyPartID getInstance(Object obj) {
        if (obj instanceof BodyPartID) {
            return (BodyPartID) obj;
        }
        if (obj != null) {
            return new BodyPartID(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getID */
    public long m14488getID() {
        return this.f18055id;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ASN1Integer.m14430valueOf(this.f18055id);
    }

    private BodyPartID(ASN1Integer aSN1Integer) {
        this(m14487convert(aSN1Integer.getValue()));
    }
}
