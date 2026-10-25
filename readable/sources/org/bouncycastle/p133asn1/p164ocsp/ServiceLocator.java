package org.bouncycastle.p133asn1.p164ocsp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AuthorityInformationAccess;

/* loaded from: classes2.dex */
public class ServiceLocator extends ASN1Object {

    /* renamed from: issuer */
    private final X500Name f18446issuer;

    /* renamed from: locator */
    private final AuthorityInformationAccess f18447locator;

    private ServiceLocator(ASN1Sequence aSN1Sequence) {
        this.f18446issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18447locator = aSN1Sequence.mo14450size() == 2 ? AuthorityInformationAccess.getInstance(aSN1Sequence.getObjectAt(1)) : null;
    }

    public static ServiceLocator getInstance(Object obj) {
        if (obj instanceof ServiceLocator) {
            return (ServiceLocator) obj;
        }
        if (obj != null) {
            return new ServiceLocator(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X500Name getIssuer() {
        return this.f18446issuer;
    }

    public AuthorityInformationAccess getLocator() {
        return this.f18447locator;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18446issuer);
        AuthorityInformationAccess authorityInformationAccess = this.f18447locator;
        if (authorityInformationAccess != null) {
            aSN1EncodableVector.m14420add(authorityInformationAccess);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
