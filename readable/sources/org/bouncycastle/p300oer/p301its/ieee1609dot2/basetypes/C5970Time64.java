package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p361util.BigIntegers;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.Time64 */
/* loaded from: classes2.dex */
public class C5970Time64 extends C5975UINT64 {
    public static long etsiEpochMicros = C5969Time32.etsiEpochMillis * 1000;

    public C5970Time64(long j) {
        this(BigInteger.valueOf(j));
    }

    public static C5970Time64 getInstance(Object obj) {
        if (obj instanceof C5975UINT64) {
            return new C5970Time64((C5975UINT64) obj);
        }
        if (obj != null) {
            return new C5970Time64(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    /* renamed from: now */
    public static C5970Time64 m17344now() {
        return new C5970Time64((System.currentTimeMillis() * 1000) - etsiEpochMicros);
    }

    public static C5970Time64 ofUnixMillis(long j) {
        return new C5970Time64((j * 1000) - etsiEpochMicros);
    }

    public long toUnixMillis() {
        return (BigIntegers.longValueExact(getValue()) + etsiEpochMicros) / 1000;
    }

    public C5970Time64(BigInteger bigInteger) {
        super(bigInteger);
    }

    public C5970Time64(C5975UINT64 c5975uint64) {
        this(c5975uint64.getValue());
    }
}
