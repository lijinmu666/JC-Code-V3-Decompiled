package org.bouncycastle.p133asn1.p137cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes.dex */
public class CMCStatus extends ASN1Object {
    public static final CMCStatus confirmRequired;

    /* renamed from: failed */
    public static final CMCStatus f18066failed;
    public static final CMCStatus noSupport;

    /* renamed from: partial */
    public static final CMCStatus f18067partial;

    /* renamed from: pending */
    public static final CMCStatus f18068pending;
    public static final CMCStatus popRequired;

    /* renamed from: range */
    private static Map f18069range;

    /* renamed from: success */
    public static final CMCStatus f18070success;

    /* renamed from: value */
    private final ASN1Integer f18071value;

    static {
        CMCStatus cMCStatus = new CMCStatus(ASN1Integer.m14429valueOf(0));
        f18070success = cMCStatus;
        CMCStatus cMCStatus2 = new CMCStatus(ASN1Integer.m14429valueOf(2));
        f18066failed = cMCStatus2;
        CMCStatus cMCStatus3 = new CMCStatus(ASN1Integer.m14429valueOf(3));
        f18068pending = cMCStatus3;
        CMCStatus cMCStatus4 = new CMCStatus(ASN1Integer.m14429valueOf(4));
        noSupport = cMCStatus4;
        CMCStatus cMCStatus5 = new CMCStatus(ASN1Integer.m14429valueOf(5));
        confirmRequired = cMCStatus5;
        CMCStatus cMCStatus6 = new CMCStatus(ASN1Integer.m14429valueOf(6));
        popRequired = cMCStatus6;
        CMCStatus cMCStatus7 = new CMCStatus(ASN1Integer.m14429valueOf(7));
        f18067partial = cMCStatus7;
        HashMap map = new HashMap();
        f18069range = map;
        map.put(cMCStatus.f18071value, cMCStatus);
        f18069range.put(cMCStatus2.f18071value, cMCStatus2);
        f18069range.put(cMCStatus3.f18071value, cMCStatus3);
        f18069range.put(cMCStatus4.f18071value, cMCStatus4);
        f18069range.put(cMCStatus5.f18071value, cMCStatus5);
        f18069range.put(cMCStatus6.f18071value, cMCStatus6);
        f18069range.put(cMCStatus7.f18071value, cMCStatus7);
    }

    private CMCStatus(ASN1Integer aSN1Integer) {
        this.f18071value = aSN1Integer;
    }

    public static CMCStatus getInstance(Object obj) {
        if (obj instanceof CMCStatus) {
            return (CMCStatus) obj;
        }
        if (obj == null) {
            return null;
        }
        CMCStatus cMCStatus = (CMCStatus) f18069range.get(ASN1Integer.getInstance(obj));
        if (cMCStatus != null) {
            return cMCStatus;
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18071value;
    }
}
