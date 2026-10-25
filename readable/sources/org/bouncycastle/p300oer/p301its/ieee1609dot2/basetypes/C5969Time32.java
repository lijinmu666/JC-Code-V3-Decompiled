package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.p133asn1.ASN1Integer;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.Time32 */
/* loaded from: classes2.dex */
public class C5969Time32 extends C5974UINT32 {
    public static long etsiEpochMillis = 1072915200000L;

    public C5969Time32(long j) {
        super(j);
    }

    public static C5969Time32 getInstance(Object obj) {
        if (obj instanceof C5974UINT32) {
            return new C5969Time32((C5974UINT32) obj);
        }
        if (obj != null) {
            return new C5969Time32(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    /* renamed from: now */
    public static C5969Time32 m17343now() {
        return ofUnixMillis(System.currentTimeMillis());
    }

    public static C5969Time32 ofUnixMillis(long j) {
        return new C5969Time32((j - etsiEpochMillis) / 1000);
    }

    public String toString() {
        return new Date(toUnixMillis()).toString();
    }

    public long toUnixMillis() {
        return (getValue().longValue() * 1000) + etsiEpochMillis;
    }

    public C5969Time32(BigInteger bigInteger) {
        super(bigInteger);
    }

    public C5969Time32(C5974UINT32 c5974uint32) {
        this(c5974uint32.getValue());
    }
}
