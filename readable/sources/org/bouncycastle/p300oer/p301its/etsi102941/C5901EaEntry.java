package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;

/* renamed from: org.bouncycastle.oer.its.etsi102941.EaEntry */
/* loaded from: classes2.dex */
public class C5901EaEntry extends ASN1Object {
    private final C5915Url aaAccessPoint;
    private final EtsiTs103097Certificate eaCertificate;
    private final C5915Url itsAccessPoint;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.EaEntry$Builder */
    public static class Builder {
        private C5915Url aaAccessPoint;
        private EtsiTs103097Certificate eaCertificate;
        private C5915Url itsAccessPoint;

        public C5901EaEntry createEaEntry() {
            return new C5901EaEntry(this.eaCertificate, this.aaAccessPoint, this.itsAccessPoint);
        }

        public Builder setAaAccessPoint(C5915Url c5915Url) {
            this.aaAccessPoint = c5915Url;
            return this;
        }

        public Builder setEaCertificate(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.eaCertificate = etsiTs103097Certificate;
            return this;
        }

        public Builder setItsAccessPoint(C5915Url c5915Url) {
            this.itsAccessPoint = c5915Url;
            return this;
        }
    }

    private C5901EaEntry(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.eaCertificate = EtsiTs103097Certificate.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.aaAccessPoint = C5915Url.getInstance(aSN1Sequence.getObjectAt(1));
        this.itsAccessPoint = (C5915Url) OEROptional.getValue(C5915Url.class, aSN1Sequence.getObjectAt(2));
    }

    /* renamed from: builder */
    public static Builder m17192builder() {
        return new Builder();
    }

    public static C5901EaEntry getInstance(Object obj) {
        if (obj instanceof C5901EaEntry) {
            return (C5901EaEntry) obj;
        }
        if (obj != null) {
            return new C5901EaEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5915Url getAaAccessPoint() {
        return this.aaAccessPoint;
    }

    public EtsiTs103097Certificate getEaCertificate() {
        return this.eaCertificate;
    }

    public C5915Url getItsAccessPoint() {
        return this.itsAccessPoint;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.eaCertificate, this.aaAccessPoint, OEROptional.getInstance(this.itsAccessPoint)});
    }

    public C5901EaEntry(EtsiTs103097Certificate etsiTs103097Certificate, C5915Url c5915Url, C5915Url c5915Url2) {
        this.eaCertificate = etsiTs103097Certificate;
        this.aaAccessPoint = c5915Url;
        this.itsAccessPoint = c5915Url2;
    }
}
