package org.bouncycastle.p133asn1.p137cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes.dex */
public class CMCFailInfo extends ASN1Object {
    public static final CMCFailInfo authDataFail;

    /* renamed from: badAlg */
    public static final CMCFailInfo f18056badAlg;
    public static final CMCFailInfo badCertId;
    public static final CMCFailInfo badIdentity;
    public static final CMCFailInfo badMessageCheck;
    public static final CMCFailInfo badRequest;

    /* renamed from: badTime */
    public static final CMCFailInfo f18057badTime;
    public static final CMCFailInfo internalCAError;
    public static final CMCFailInfo mustArchiveKeys;
    public static final CMCFailInfo noKeyReuse;
    public static final CMCFailInfo popFailed;
    public static final CMCFailInfo popRequired;

    /* renamed from: range */
    private static Map f18058range;
    public static final CMCFailInfo tryLater;
    public static final CMCFailInfo unsupportedExt;

    /* renamed from: value */
    private final ASN1Integer f18059value;

    static {
        CMCFailInfo cMCFailInfo = new CMCFailInfo(ASN1Integer.m14429valueOf(0));
        f18056badAlg = cMCFailInfo;
        CMCFailInfo cMCFailInfo2 = new CMCFailInfo(ASN1Integer.m14429valueOf(1));
        badMessageCheck = cMCFailInfo2;
        CMCFailInfo cMCFailInfo3 = new CMCFailInfo(ASN1Integer.m14429valueOf(2));
        badRequest = cMCFailInfo3;
        CMCFailInfo cMCFailInfo4 = new CMCFailInfo(ASN1Integer.m14429valueOf(3));
        f18057badTime = cMCFailInfo4;
        CMCFailInfo cMCFailInfo5 = new CMCFailInfo(ASN1Integer.m14429valueOf(4));
        badCertId = cMCFailInfo5;
        CMCFailInfo cMCFailInfo6 = new CMCFailInfo(ASN1Integer.m14429valueOf(5));
        unsupportedExt = cMCFailInfo6;
        CMCFailInfo cMCFailInfo7 = new CMCFailInfo(ASN1Integer.m14429valueOf(6));
        mustArchiveKeys = cMCFailInfo7;
        CMCFailInfo cMCFailInfo8 = new CMCFailInfo(ASN1Integer.m14429valueOf(7));
        badIdentity = cMCFailInfo8;
        CMCFailInfo cMCFailInfo9 = new CMCFailInfo(ASN1Integer.m14429valueOf(8));
        popRequired = cMCFailInfo9;
        CMCFailInfo cMCFailInfo10 = new CMCFailInfo(ASN1Integer.m14429valueOf(9));
        popFailed = cMCFailInfo10;
        CMCFailInfo cMCFailInfo11 = new CMCFailInfo(ASN1Integer.m14429valueOf(10));
        noKeyReuse = cMCFailInfo11;
        CMCFailInfo cMCFailInfo12 = new CMCFailInfo(ASN1Integer.m14429valueOf(11));
        internalCAError = cMCFailInfo12;
        CMCFailInfo cMCFailInfo13 = new CMCFailInfo(ASN1Integer.m14429valueOf(12));
        tryLater = cMCFailInfo13;
        CMCFailInfo cMCFailInfo14 = new CMCFailInfo(ASN1Integer.m14429valueOf(13));
        authDataFail = cMCFailInfo14;
        HashMap map = new HashMap();
        f18058range = map;
        map.put(cMCFailInfo.f18059value, cMCFailInfo);
        f18058range.put(cMCFailInfo2.f18059value, cMCFailInfo2);
        f18058range.put(cMCFailInfo3.f18059value, cMCFailInfo3);
        f18058range.put(cMCFailInfo4.f18059value, cMCFailInfo4);
        f18058range.put(cMCFailInfo5.f18059value, cMCFailInfo5);
        f18058range.put(cMCFailInfo9.f18059value, cMCFailInfo9);
        f18058range.put(cMCFailInfo6.f18059value, cMCFailInfo6);
        f18058range.put(cMCFailInfo7.f18059value, cMCFailInfo7);
        f18058range.put(cMCFailInfo8.f18059value, cMCFailInfo8);
        f18058range.put(cMCFailInfo9.f18059value, cMCFailInfo9);
        f18058range.put(cMCFailInfo10.f18059value, cMCFailInfo10);
        f18058range.put(cMCFailInfo5.f18059value, cMCFailInfo5);
        f18058range.put(cMCFailInfo9.f18059value, cMCFailInfo9);
        f18058range.put(cMCFailInfo11.f18059value, cMCFailInfo11);
        f18058range.put(cMCFailInfo12.f18059value, cMCFailInfo12);
        f18058range.put(cMCFailInfo13.f18059value, cMCFailInfo13);
        f18058range.put(cMCFailInfo14.f18059value, cMCFailInfo14);
    }

    private CMCFailInfo(ASN1Integer aSN1Integer) {
        this.f18059value = aSN1Integer;
    }

    public static CMCFailInfo getInstance(Object obj) {
        if (obj instanceof CMCFailInfo) {
            return (CMCFailInfo) obj;
        }
        if (obj == null) {
            return null;
        }
        CMCFailInfo cMCFailInfo = (CMCFailInfo) f18058range.get(ASN1Integer.getInstance(obj));
        if (cMCFailInfo != null) {
            return cMCFailInfo;
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18059value;
    }
}
