package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PsidSsp */
/* loaded from: classes2.dex */
public class C5955PsidSsp extends ASN1Object {

    /* renamed from: psid */
    private final C5954Psid f22749psid;

    /* renamed from: ssp */
    private final ServiceSpecificPermissions f22750ssp;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PsidSsp$Builder */
    public static class Builder {

        /* renamed from: psid */
        private C5954Psid f22751psid;

        /* renamed from: ssp */
        private ServiceSpecificPermissions f22752ssp;

        public C5955PsidSsp createPsidSsp() {
            return new C5955PsidSsp(this.f22751psid, this.f22752ssp);
        }

        /* renamed from: setPsid */
        public Builder m17313setPsid(C5954Psid c5954Psid) {
            this.f22751psid = c5954Psid;
            return this;
        }

        /* renamed from: setSsp */
        public Builder m17314setSsp(ServiceSpecificPermissions serviceSpecificPermissions) {
            this.f22752ssp = serviceSpecificPermissions;
            return this;
        }
    }

    private C5955PsidSsp(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22749psid = C5954Psid.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22750ssp = (ServiceSpecificPermissions) OEROptional.getValue(ServiceSpecificPermissions.class, aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static Builder m17310builder() {
        return new Builder();
    }

    public static C5955PsidSsp getInstance(Object obj) {
        if (obj instanceof C5955PsidSsp) {
            return (C5955PsidSsp) obj;
        }
        if (obj != null) {
            return new C5955PsidSsp(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getPsid */
    public C5954Psid m17311getPsid() {
        return this.f22749psid;
    }

    /* renamed from: getSsp */
    public ServiceSpecificPermissions m17312getSsp() {
        return this.f22750ssp;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22749psid, OEROptional.getInstance(this.f22750ssp));
    }

    public C5955PsidSsp(C5954Psid c5954Psid, ServiceSpecificPermissions serviceSpecificPermissions) {
        this.f22749psid = c5954Psid;
        this.f22750ssp = serviceSpecificPermissions;
    }
}
