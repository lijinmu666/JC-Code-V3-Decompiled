package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.DEROctetString;

/* loaded from: classes2.dex */
public class SubjectAssurance extends DEROctetString {
    private SubjectAssurance(ASN1OctetString aSN1OctetString) {
        this(aSN1OctetString.getOctets());
    }

    public static SubjectAssurance getInstance(Object obj) {
        if (obj instanceof SubjectAssurance) {
            return (SubjectAssurance) obj;
        }
        if (obj != null) {
            return new SubjectAssurance(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public SubjectAssurance(byte[] bArr) {
        super(bArr);
        if (bArr.length != 1) {
            throw new IllegalArgumentException("length is not 1");
        }
    }
}
