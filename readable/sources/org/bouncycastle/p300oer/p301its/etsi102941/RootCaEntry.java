package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;

/* loaded from: classes2.dex */
public class RootCaEntry extends ASN1Object {
    private final EtsiTs103097Certificate selfsignedRootCa;
    private final EtsiTs103097Certificate successorTo;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.RootCaEntry$Builder */
    public static class C5908Builder {
        private EtsiTs103097Certificate selfsignedRootCa;
        private EtsiTs103097Certificate successorTo;

        public RootCaEntry createRootCaEntry() {
            return new RootCaEntry(this.selfsignedRootCa, this.successorTo);
        }

        public C5908Builder setSelfsignedRootCa(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.selfsignedRootCa = etsiTs103097Certificate;
            return this;
        }

        public C5908Builder setSuccessorTo(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.successorTo = etsiTs103097Certificate;
            return this;
        }
    }

    private RootCaEntry(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.selfsignedRootCa = EtsiTs103097Certificate.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.successorTo = (EtsiTs103097Certificate) OEROptional.getValue(EtsiTs103097Certificate.class, aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5908Builder m17197builder() {
        return new C5908Builder();
    }

    public static RootCaEntry getInstance(Object obj) {
        if (obj instanceof RootCaEntry) {
            return (RootCaEntry) obj;
        }
        if (obj != null) {
            return new RootCaEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Certificate getSelfsignedRootCa() {
        return this.selfsignedRootCa;
    }

    public EtsiTs103097Certificate getSuccessorTo() {
        return this.successorTo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.selfsignedRootCa, OEROptional.getInstance(this.successorTo)});
    }

    public RootCaEntry(EtsiTs103097Certificate etsiTs103097Certificate, EtsiTs103097Certificate etsiTs103097Certificate2) {
        this.selfsignedRootCa = etsiTs103097Certificate;
        this.successorTo = etsiTs103097Certificate2;
    }
}
