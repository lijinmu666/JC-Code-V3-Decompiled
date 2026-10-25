package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERIA5String;

/* loaded from: classes2.dex */
public class DcDelete extends ASN1Object {

    /* renamed from: url */
    private final String f22591url;

    public DcDelete(String str) {
        this.f22591url = str;
    }

    public static DcDelete getInstance(Object obj) {
        if (obj instanceof DcDelete) {
            return (DcDelete) obj;
        }
        if (obj != null) {
            return new DcDelete(ASN1IA5String.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getUrl */
    public String m17186getUrl() {
        return this.f22591url;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERIA5String(this.f22591url);
    }

    private DcDelete(ASN1IA5String aSN1IA5String) {
        this.f22591url = aSN1IA5String.getString();
    }
}
