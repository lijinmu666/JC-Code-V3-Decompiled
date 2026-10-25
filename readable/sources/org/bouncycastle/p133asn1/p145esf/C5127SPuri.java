package org.bouncycastle.p133asn1.p145esf;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* renamed from: org.bouncycastle.asn1.esf.SPuri */
/* loaded from: classes2.dex */
public class C5127SPuri {

    /* renamed from: uri */
    private ASN1IA5String f18373uri;

    public C5127SPuri(ASN1IA5String aSN1IA5String) {
        this.f18373uri = aSN1IA5String;
    }

    public static C5127SPuri getInstance(Object obj) {
        if (obj instanceof C5127SPuri) {
            return (C5127SPuri) obj;
        }
        if (obj instanceof ASN1IA5String) {
            return new C5127SPuri(ASN1IA5String.getInstance(obj));
        }
        return null;
    }

    public ASN1IA5String getUriIA5() {
        return this.f18373uri;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.f18373uri.toASN1Primitive();
    }
}
