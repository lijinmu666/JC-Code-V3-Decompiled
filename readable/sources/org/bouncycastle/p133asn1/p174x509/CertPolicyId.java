package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class CertPolicyId extends ASN1Object {

    /* renamed from: id */
    private ASN1ObjectIdentifier f18633id;

    private CertPolicyId(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f18633id = aSN1ObjectIdentifier;
    }

    public static CertPolicyId getInstance(Object obj) {
        if (obj instanceof CertPolicyId) {
            return (CertPolicyId) obj;
        }
        if (obj != null) {
            return new CertPolicyId(ASN1ObjectIdentifier.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getId */
    public String m14677getId() {
        return this.f18633id.m14433getId();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18633id;
    }
}
