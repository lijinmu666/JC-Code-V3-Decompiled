package org.bouncycastle.p133asn1.p153isismtt.p155x509;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p172x500.DirectoryString;

/* loaded from: classes2.dex */
public class Restriction extends ASN1Object {
    private DirectoryString restriction;

    public Restriction(String str) {
        this.restriction = new DirectoryString(str);
    }

    public static Restriction getInstance(Object obj) {
        if (obj instanceof Restriction) {
            return (Restriction) obj;
        }
        if (obj != null) {
            return new Restriction(DirectoryString.getInstance(obj));
        }
        return null;
    }

    public DirectoryString getRestriction() {
        return this.restriction;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.restriction.toASN1Primitive();
    }

    private Restriction(DirectoryString directoryString) {
        this.restriction = directoryString;
    }
}
