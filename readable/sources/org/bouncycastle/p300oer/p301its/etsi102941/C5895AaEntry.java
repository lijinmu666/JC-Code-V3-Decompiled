package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;

/* renamed from: org.bouncycastle.oer.its.etsi102941.AaEntry */
/* loaded from: classes2.dex */
public class C5895AaEntry extends ASN1Object {
    private final EtsiTs103097Certificate aaCertificate;
    private final C5915Url accessPoint;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.AaEntry$Builder */
    public static class Builder {
        private EtsiTs103097Certificate aaCertificate;
        private C5915Url accessPoint;

        public C5895AaEntry createAaEntry() {
            return new C5895AaEntry(this.aaCertificate, this.accessPoint);
        }

        public Builder setAaCertificate(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.aaCertificate = etsiTs103097Certificate;
            return this;
        }

        public Builder setAccessPoint(C5915Url c5915Url) {
            this.accessPoint = c5915Url;
            return this;
        }
    }

    private C5895AaEntry(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.aaCertificate = EtsiTs103097Certificate.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.accessPoint = C5915Url.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static Builder m17172builder() {
        return new Builder();
    }

    public static C5895AaEntry getInstance(Object obj) {
        if (obj instanceof C5895AaEntry) {
            return (C5895AaEntry) obj;
        }
        if (obj != null) {
            return new C5895AaEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Certificate getAaCertificate() {
        return this.aaCertificate;
    }

    public C5915Url getAccessPoint() {
        return this.accessPoint;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.aaCertificate, this.accessPoint});
    }

    public C5895AaEntry(EtsiTs103097Certificate etsiTs103097Certificate, C5915Url c5915Url) {
        this.aaCertificate = etsiTs103097Certificate;
        this.accessPoint = c5915Url;
    }
}
