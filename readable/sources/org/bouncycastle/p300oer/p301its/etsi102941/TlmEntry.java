package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;

/* loaded from: classes2.dex */
public class TlmEntry extends ASN1Object {
    private final C5915Url accessPoint;
    private final EtsiTs103097Certificate selfSignedTLMCertificate;
    private final EtsiTs103097Certificate successorTo;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.TlmEntry$Builder */
    public static class C5912Builder {
        private C5915Url accessPoint;
        private EtsiTs103097Certificate selfSignedTLMCertificate;
        private EtsiTs103097Certificate successorTo;

        public TlmEntry createTlmEntry() {
            return new TlmEntry(this.selfSignedTLMCertificate, this.successorTo, this.accessPoint);
        }

        public C5912Builder setAccessPoint(C5915Url c5915Url) {
            this.accessPoint = c5915Url;
            return this;
        }

        public C5912Builder setSelfSignedTLMCertificate(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.selfSignedTLMCertificate = etsiTs103097Certificate;
            return this;
        }

        public C5912Builder setSuccessorTo(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.successorTo = etsiTs103097Certificate;
            return this;
        }
    }

    private TlmEntry(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.selfSignedTLMCertificate = EtsiTs103097Certificate.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.successorTo = (EtsiTs103097Certificate) OEROptional.getValue(EtsiTs103097Certificate.class, aSN1Sequence.getObjectAt(1));
        this.accessPoint = C5915Url.getInstance(aSN1Sequence.getObjectAt(2));
    }

    /* renamed from: builder */
    public static C5912Builder m17205builder() {
        return new C5912Builder();
    }

    public static TlmEntry getInstance(Object obj) {
        if (obj instanceof TlmEntry) {
            return (TlmEntry) obj;
        }
        if (obj != null) {
            return new TlmEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5915Url getAccessPoint() {
        return this.accessPoint;
    }

    public EtsiTs103097Certificate getSelfSignedTLMCertificate() {
        return this.selfSignedTLMCertificate;
    }

    public EtsiTs103097Certificate getSuccessorTo() {
        return this.successorTo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.selfSignedTLMCertificate, OEROptional.getInstance(this.successorTo), this.accessPoint});
    }

    public TlmEntry(EtsiTs103097Certificate etsiTs103097Certificate, EtsiTs103097Certificate etsiTs103097Certificate2, C5915Url c5915Url) {
        this.selfSignedTLMCertificate = etsiTs103097Certificate;
        this.successorTo = etsiTs103097Certificate2;
        this.accessPoint = c5915Url;
    }
}
