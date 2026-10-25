package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERIA5String;

/* renamed from: org.bouncycastle.oer.its.etsi102941.Url */
/* loaded from: classes2.dex */
public class C5915Url extends ASN1Object {

    /* renamed from: url */
    private final String f22614url;

    public C5915Url(String str) {
        this.f22614url = str;
    }

    public static C5915Url getInstance(Object obj) {
        if (obj instanceof C5915Url) {
            return (C5915Url) obj;
        }
        if (obj != null) {
            return new C5915Url(ASN1IA5String.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getUrl */
    public String m17208getUrl() {
        return this.f22614url;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERIA5String(this.f22614url);
    }

    private C5915Url(ASN1IA5String aSN1IA5String) {
        this.f22614url = aSN1IA5String.getString();
    }
}
