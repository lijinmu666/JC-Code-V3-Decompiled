package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERUTF8String;

/* loaded from: classes2.dex */
public class Hostname extends ASN1Object {
    private final String hostName;

    public Hostname(String str) {
        this.hostName = str;
    }

    public static Hostname getInstance(Object obj) {
        if (obj instanceof Hostname) {
            return (Hostname) obj;
        }
        if (obj != null) {
            return new Hostname(ASN1UTF8String.getInstance(obj));
        }
        return null;
    }

    public String getHostName() {
        return this.hostName;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERUTF8String(this.hostName);
    }

    private Hostname(ASN1String aSN1String) {
        this.hostName = aSN1String.getString();
    }
}
