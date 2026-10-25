package org.bouncycastle.p133asn1.p164ocsp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* renamed from: org.bouncycastle.asn1.ocsp.Request */
/* loaded from: classes2.dex */
public class C5133Request extends ASN1Object {

    /* renamed from: reqCert */
    C5131CertID f18442reqCert;
    Extensions singleRequestExtensions;

    private C5133Request(ASN1Sequence aSN1Sequence) {
        this.f18442reqCert = C5131CertID.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() == 2) {
            this.singleRequestExtensions = Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }

    public static C5133Request getInstance(Object obj) {
        if (obj instanceof C5133Request) {
            return (C5133Request) obj;
        }
        if (obj != null) {
            return new C5133Request(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5131CertID getReqCert() {
        return this.f18442reqCert;
    }

    public Extensions getSingleRequestExtensions() {
        return this.singleRequestExtensions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18442reqCert);
        Extensions extensions = this.singleRequestExtensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public C5133Request(C5131CertID c5131CertID, Extensions extensions) {
        this.f18442reqCert = c5131CertID;
        this.singleRequestExtensions = extensions;
    }

    public static C5133Request getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
